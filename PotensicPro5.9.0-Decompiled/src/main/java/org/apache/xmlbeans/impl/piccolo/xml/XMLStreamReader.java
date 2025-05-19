package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.CharEncoding;
import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;

/* loaded from: classes5.dex */
public final class XMLStreamReader extends XMLInputReader {
    private static final int BYTE_BUFFER_SIZE = 8192;
    private static final int MAX_XML_DECL_CHARS = 100;
    private static HashMap charsetTable;
    private XMLStreamDecoder activeStreamDecoder;
    private byte[] bbuf;
    private int bbufEnd;
    private int bbufPos;
    private char[] cbuf;
    private int cbufEnd;
    private int cbufPos;
    private int[] decodeResult;
    private XMLDecoder decoder;
    private String encoding;
    private boolean eofReached;
    private FastStreamDecoder fastStreamDecoder;
    private InputStream in;
    private JavaStreamDecoder javaStreamDecoder;
    private int maxBytesPerChar;
    private int minBytesPerChar;
    private boolean rewindDeclaration;
    private boolean useDeclaredEncoding;

    private interface XMLStreamDecoder {
        int read() throws IOException;

        int read(char[] cArr, int i, int i2) throws IOException;

        boolean ready() throws IOException;

        void reset() throws IOException;

        long skip(long j) throws IOException;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return false;
    }

    static /* synthetic */ int access$108(XMLStreamReader xMLStreamReader) {
        int i = xMLStreamReader.cbufPos;
        xMLStreamReader.cbufPos = i + 1;
        return i;
    }

    static /* synthetic */ int access$112(XMLStreamReader xMLStreamReader, int i) {
        int i2 = xMLStreamReader.cbufPos + i;
        xMLStreamReader.cbufPos = i2;
        return i2;
    }

    static /* synthetic */ int access$114(XMLStreamReader xMLStreamReader, long j) {
        int i = (int) (xMLStreamReader.cbufPos + j);
        xMLStreamReader.cbufPos = i;
        return i;
    }

    static /* synthetic */ int access$412(XMLStreamReader xMLStreamReader, int i) {
        int i2 = xMLStreamReader.bbufPos + i;
        xMLStreamReader.bbufPos = i2;
        return i2;
    }

    public XMLStreamReader() {
        this.decodeResult = new int[2];
        this.cbuf = new char[100];
        this.bbuf = new byte[8192];
        this.fastStreamDecoder = new FastStreamDecoder();
        this.javaStreamDecoder = null;
    }

    public XMLStreamReader(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, null, z);
    }

    public XMLStreamReader(InputStream inputStream, String str, boolean z) throws IOException {
        this.decodeResult = new int[2];
        this.cbuf = new char[100];
        this.bbuf = new byte[8192];
        this.fastStreamDecoder = new FastStreamDecoder();
        this.javaStreamDecoder = null;
        reset(inputStream, str, z);
    }

    public void reset(InputStream inputStream, String str, boolean z) throws IOException {
        super.resetInput();
        this.in = inputStream;
        this.eofReached = false;
        this.rewindDeclaration = z;
        this.useDeclaredEncoding = false;
        this.bbufEnd = 0;
        this.bbufPos = 0;
        this.cbufEnd = 0;
        this.cbufPos = 0;
        this.activeStreamDecoder = this.fastStreamDecoder;
        fillByteBuffer(true);
        if (str != null) {
            String javaCharset = getJavaCharset(str);
            this.encoding = javaCharset;
            if (javaCharset.equals("Unicode")) {
                String guessEncoding = guessEncoding();
                this.encoding = guessEncoding;
                if (guessEncoding == null || !guessEncoding.equals("UnicodeLittle")) {
                    this.encoding = "UnicodeBig";
                }
            }
        } else {
            String guessEncoding2 = guessEncoding();
            this.encoding = guessEncoding2;
            if (guessEncoding2 == null) {
                this.useDeclaredEncoding = true;
                this.encoding = "UTF-8";
            }
        }
        setEncoding(this.encoding);
        processXMLDecl();
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eofReached = true;
        this.cbufEnd = 0;
        this.cbufPos = 0;
        this.bbufEnd = 0;
        this.bbufPos = 0;
        InputStream inputStream = this.in;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        super.resetInput();
        this.in.reset();
        this.cbufEnd = 0;
        this.cbufPos = 0;
        this.bbufEnd = 0;
        this.bbufPos = 0;
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        throw new UnsupportedOperationException("mark() not supported");
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return this.activeStreamDecoder.read();
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        return this.activeStreamDecoder.read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.activeStreamDecoder.ready();
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        return this.activeStreamDecoder.skip(j);
    }

    private void setEncoding(String str) throws IOException {
        try {
            this.encoding = str;
            XMLDecoder createDecoder = XMLDecoderFactory.createDecoder(str);
            this.decoder = createDecoder;
            this.minBytesPerChar = createDecoder.minBytesPerChar();
            this.maxBytesPerChar = this.decoder.maxBytesPerChar();
        } catch (UnsupportedEncodingException unused) {
            if (this.javaStreamDecoder == null) {
                this.javaStreamDecoder = new JavaStreamDecoder();
            }
            this.activeStreamDecoder = this.javaStreamDecoder;
        }
        this.activeStreamDecoder.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fillByteBuffer(boolean z) throws IOException {
        int i = this.bbufEnd;
        int i2 = this.bbufPos;
        int i3 = i - i2;
        int i4 = 0;
        if (i3 > 0) {
            byte[] bArr = this.bbuf;
            System.arraycopy(bArr, i2, bArr, 0, i3);
        }
        this.bbufPos = 0;
        this.bbufEnd = i3;
        while (true) {
            int i5 = this.bbufEnd;
            if (i5 >= 8192 || i4 >= 160) {
                break;
            }
            int read = this.in.read(this.bbuf, i5, 8192 - i5);
            if (read != -1) {
                this.bbufEnd += read;
            }
            i4 += read;
            if (read == -1) {
                this.eofReached = true;
                break;
            }
            if (!z) {
                break;
            }
        }
        return i4;
    }

    static {
        HashMap hashMap = new HashMap(31);
        charsetTable = hashMap;
        hashMap.put("EBCDIC-CP-US", "Cp037");
        charsetTable.put("EBCDIC-CP-CA", "Cp037");
        charsetTable.put("EBCDIC-CP-NL", "Cp037");
        charsetTable.put("EBCDIC-CP-WT", "Cp037");
        charsetTable.put("EBCDIC-CP-DK", "Cp277");
        charsetTable.put("EBCDIC-CP-NO", "Cp277");
        charsetTable.put("EBCDIC-CP-FI", "Cp278");
        charsetTable.put("EBCDIC-CP-SE", "Cp278");
        charsetTable.put("EBCDIC-CP-IT", "Cp280");
        charsetTable.put("EBCDIC-CP-ES", "Cp284");
        charsetTable.put("EBCDIC-CP-GB", "Cp285");
        charsetTable.put("EBCDIC-CP-FR", "Cp297");
        charsetTable.put("EBCDIC-CP-AR1", "Cp420");
        charsetTable.put("EBCDIC-CP-GR", "Cp423");
        charsetTable.put("EBCDIC-CP-HE", "Cp424");
        charsetTable.put("EBCDIC-CP-BE", "Cp500");
        charsetTable.put("EBCDIC-CP-CH", "Cp500");
        charsetTable.put("EBCDIC-CP-ROECE", "Cp870");
        charsetTable.put("EBCDIC-CP-YU", "Cp870");
        charsetTable.put("EBCDIC-CP-IS", "Cp871");
        charsetTable.put("EBCDIC-CP-TR", "Cp905");
        charsetTable.put("EBCDIC-CP-AR2", "Cp918");
        charsetTable.put("UTF-16", "Unicode");
        charsetTable.put("ISO-10646-UCS-2", "Unicode");
        charsetTable.put("ANSI_X3.4-1986", "ASCII");
        charsetTable.put("ASCII", "ASCII");
        charsetTable.put("CP367", "ASCII");
        charsetTable.put("CSASCII", "ASCII");
        charsetTable.put("IBM-367", "ASCII");
        charsetTable.put("IBM367", "ASCII");
        charsetTable.put("ISO-IR-6", "ASCII");
        charsetTable.put("ISO646-US", "ASCII");
        charsetTable.put("ISO_646.IRV:1991", "ASCII");
        charsetTable.put("US", "ASCII");
        charsetTable.put("US-ASCII", "ASCII");
        charsetTable.put("BIG5", "BIG5");
        charsetTable.put("CSBIG5", "BIG5");
        charsetTable.put("CP037", "CP037");
        charsetTable.put("CSIBM037", "CP037");
        charsetTable.put("IBM-37", "CP037");
        charsetTable.put("IBM037", "CP037");
        charsetTable.put("CP1026", "CP1026");
        charsetTable.put("CSIBM1026", "CP1026");
        charsetTable.put("IBM-1026", "CP1026");
        charsetTable.put("IBM1026", "CP1026");
        charsetTable.put("CP1047", "CP1047");
        charsetTable.put("IBM-1047", "CP1047");
        charsetTable.put("IBM1047", "CP1047");
        charsetTable.put("CCSID01140", "CP1140");
        charsetTable.put("CP01140", "CP1140");
        charsetTable.put("IBM-1140", "CP1140");
        charsetTable.put("IBM01140", "CP1140");
        charsetTable.put("CCSID01141", "CP1141");
        charsetTable.put("CP01141", "CP1141");
        charsetTable.put("IBM-1141", "CP1141");
        charsetTable.put("IBM01141", "CP1141");
        charsetTable.put("CCSID01142", "CP1142");
        charsetTable.put("CP01142", "CP1142");
        charsetTable.put("IBM-1142", "CP1142");
        charsetTable.put("IBM01142", "CP1142");
        charsetTable.put("CCSID01143", "CP1143");
        charsetTable.put("CP01143", "CP1143");
        charsetTable.put("IBM-1143", "CP1143");
        charsetTable.put("IBM01143", "CP1143");
        charsetTable.put("CCSID01144", "CP1144");
        charsetTable.put("CP01144", "CP1144");
        charsetTable.put("IBM-1144", "CP1144");
        charsetTable.put("IBM01144", "CP1144");
        charsetTable.put("CCSID01145", "CP1145");
        charsetTable.put("CP01145", "CP1145");
        charsetTable.put("IBM-1145", "CP1145");
        charsetTable.put("IBM01145", "CP1145");
        charsetTable.put("CCSID01146", "CP1146");
        charsetTable.put("CP01146", "CP1146");
        charsetTable.put("IBM-1146", "CP1146");
        charsetTable.put("IBM01146", "CP1146");
        charsetTable.put("CCSID01147", "CP1147");
        charsetTable.put("CP01147", "CP1147");
        charsetTable.put("IBM-1147", "CP1147");
        charsetTable.put("IBM01147", "CP1147");
        charsetTable.put("CCSID01148", "CP1148");
        charsetTable.put("CP01148", "CP1148");
        charsetTable.put("IBM-1148", "CP1148");
        charsetTable.put("IBM01148", "CP1148");
        charsetTable.put("CCSID01149", "CP1149");
        charsetTable.put("CP01149", "CP1149");
        charsetTable.put("IBM-1149", "CP1149");
        charsetTable.put("IBM01149", "CP1149");
        charsetTable.put("WINDOWS-1250", "CP1250");
        charsetTable.put("WINDOWS-1251", "CP1251");
        charsetTable.put("WINDOWS-1252", "CP1252");
        charsetTable.put("WINDOWS-1253", "CP1253");
        charsetTable.put("WINDOWS-1254", "CP1254");
        charsetTable.put("WINDOWS-1255", "CP1255");
        charsetTable.put("WINDOWS-1256", "CP1256");
        charsetTable.put("WINDOWS-1257", "CP1257");
        charsetTable.put("WINDOWS-1258", "CP1258");
        charsetTable.put("CP273", "CP273");
        charsetTable.put("CSIBM273", "CP273");
        charsetTable.put("IBM-273", "CP273");
        charsetTable.put("IBM273", "CP273");
        charsetTable.put("CP277", "CP277");
        charsetTable.put("CSIBM277", "CP277");
        charsetTable.put("IBM-277", "CP277");
        charsetTable.put("IBM277", "CP277");
        charsetTable.put("CP278", "CP278");
        charsetTable.put("CSIBM278", "CP278");
        charsetTable.put("IBM-278", "CP278");
        charsetTable.put("IBM278", "CP278");
        charsetTable.put("CP280", "CP280");
        charsetTable.put("CSIBM280", "CP280");
        charsetTable.put("IBM-280", "CP280");
        charsetTable.put("IBM280", "CP280");
        charsetTable.put("CP284", "CP284");
        charsetTable.put("CSIBM284", "CP284");
        charsetTable.put("IBM-284", "CP284");
        charsetTable.put("IBM284", "CP284");
        charsetTable.put("CP285", "CP285");
        charsetTable.put("CSIBM285", "CP285");
        charsetTable.put("IBM-285", "CP285");
        charsetTable.put("IBM285", "CP285");
        charsetTable.put("CP290", "CP290");
        charsetTable.put("CSIBM290", "CP290");
        charsetTable.put("EBCDIC-JP-KANA", "CP290");
        charsetTable.put("IBM-290", "CP290");
        charsetTable.put("IBM290", "CP290");
        charsetTable.put("CP297", "CP297");
        charsetTable.put("CSIBM297", "CP297");
        charsetTable.put("IBM-297", "CP297");
        charsetTable.put("IBM297", "CP297");
        charsetTable.put("CP420", "CP420");
        charsetTable.put("CSIBM420", "CP420");
        charsetTable.put("IBM-420", "CP420");
        charsetTable.put("IBM420", "CP420");
        charsetTable.put("CP424", "CP424");
        charsetTable.put("CSIBM424", "CP424");
        charsetTable.put("IBM-424", "CP424");
        charsetTable.put("IBM424", "CP424");
        charsetTable.put("437", "CP437");
        charsetTable.put("CP437", "CP437");
        charsetTable.put("CSPC8CODEPAGE437", "CP437");
        charsetTable.put("IBM-437", "CP437");
        charsetTable.put("IBM437", "CP437");
        charsetTable.put("CP500", "CP500");
        charsetTable.put("CSIBM500", "CP500");
        charsetTable.put("IBM-500", "CP500");
        charsetTable.put("IBM500", "CP500");
        charsetTable.put("CP775", "CP775");
        charsetTable.put("CSPC775BALTIC", "CP775");
        charsetTable.put("IBM-775", "CP775");
        charsetTable.put("IBM775", "CP775");
        charsetTable.put("850", "CP850");
        charsetTable.put("CP850", "CP850");
        charsetTable.put("CSPC850MULTILINGUAL", "CP850");
        charsetTable.put("IBM-850", "CP850");
        charsetTable.put("IBM850", "CP850");
        charsetTable.put("852", "CP852");
        charsetTable.put("CP852", "CP852");
        charsetTable.put("CSPCP852", "CP852");
        charsetTable.put("IBM-852", "CP852");
        charsetTable.put("IBM852", "CP852");
        charsetTable.put("855", "CP855");
        charsetTable.put("CP855", "CP855");
        charsetTable.put("CSIBM855", "CP855");
        charsetTable.put("IBM-855", "CP855");
        charsetTable.put("IBM855", "CP855");
        charsetTable.put("857", "CP857");
        charsetTable.put("CP857", "CP857");
        charsetTable.put("CSIBM857", "CP857");
        charsetTable.put("IBM-857", "CP857");
        charsetTable.put("IBM857", "CP857");
        charsetTable.put("CCSID00858", "CP858");
        charsetTable.put("CP00858", "CP858");
        charsetTable.put("IBM-858", "CP858");
        charsetTable.put("IBM00858", "CP858");
        charsetTable.put("860", "CP860");
        charsetTable.put("CP860", "CP860");
        charsetTable.put("CSIBM860", "CP860");
        charsetTable.put("IBM-860", "CP860");
        charsetTable.put("IBM860", "CP860");
        charsetTable.put("861", "CP861");
        charsetTable.put("CP-IS", "CP861");
        charsetTable.put("CP861", "CP861");
        charsetTable.put("CSIBM861", "CP861");
        charsetTable.put("IBM-861", "CP861");
        charsetTable.put("IBM861", "CP861");
        charsetTable.put("862", "CP862");
        charsetTable.put("CP862", "CP862");
        charsetTable.put("CSPC862LATINHEBREW", "CP862");
        charsetTable.put("IBM-862", "CP862");
        charsetTable.put("IBM862", "CP862");
        charsetTable.put("863", "CP863");
        charsetTable.put("CP863", "CP863");
        charsetTable.put("CSIBM863", "CP863");
        charsetTable.put("IBM-863", "CP863");
        charsetTable.put("IBM863", "CP863");
        charsetTable.put("CP864", "CP864");
        charsetTable.put("CSIBM864", "CP864");
        charsetTable.put("IBM-864", "CP864");
        charsetTable.put("IBM864", "CP864");
        charsetTable.put("865", "CP865");
        charsetTable.put("CP865", "CP865");
        charsetTable.put("CSIBM865", "CP865");
        charsetTable.put("IBM-865", "CP865");
        charsetTable.put("IBM865", "CP865");
        charsetTable.put("866", "CP866");
        charsetTable.put("CP866", "CP866");
        charsetTable.put("CSIBM866", "CP866");
        charsetTable.put("IBM-866", "CP866");
        charsetTable.put("IBM866", "CP866");
        charsetTable.put("CP-AR", "CP868");
        charsetTable.put("CP868", "CP868");
        charsetTable.put("CSIBM868", "CP868");
        charsetTable.put("IBM-868", "CP868");
        charsetTable.put("IBM868", "CP868");
        charsetTable.put("CP-GR", "CP869");
        charsetTable.put("CP869", "CP869");
        charsetTable.put("CSIBM869", "CP869");
        charsetTable.put("IBM-869", "CP869");
        charsetTable.put("IBM869", "CP869");
        charsetTable.put("CP870", "CP870");
        charsetTable.put("CSIBM870", "CP870");
        charsetTable.put("IBM-870", "CP870");
        charsetTable.put("IBM870", "CP870");
        charsetTable.put("CP871", "CP871");
        charsetTable.put("CSIBM871", "CP871");
        charsetTable.put("IBM-871", "CP871");
        charsetTable.put("IBM871", "CP871");
        charsetTable.put("CP918", "CP918");
        charsetTable.put("CSIBM918", "CP918");
        charsetTable.put("IBM-918", "CP918");
        charsetTable.put("IBM918", "CP918");
        charsetTable.put("CCSID00924", "CP924");
        charsetTable.put("CP00924", "CP924");
        charsetTable.put("EBCDIC-LATIN9--EURO", "CP924");
        charsetTable.put("IBM-924", "CP924");
        charsetTable.put("IBM00924", "CP924");
        charsetTable.put("CSEUCPKDFMTJAPANESE", "EUCJIS");
        charsetTable.put("EUC-JP", "EUCJIS");
        charsetTable.put("EXTENDED_UNIX_CODE_PACKED_FORMAT_FOR_JAPANESE", "EUCJIS");
        charsetTable.put("GB18030", "GB18030");
        charsetTable.put("CSGB2312", "GB2312");
        charsetTable.put("GB2312", "GB2312");
        charsetTable.put("ISO-2022-CN", "ISO2022CN");
        charsetTable.put("CSISO2022KR", "ISO2022KR");
        charsetTable.put("ISO-2022-KR", "ISO2022KR");
        charsetTable.put("CP819", "ISO8859_1");
        charsetTable.put("CSISOLATIN1", "ISO8859_1");
        charsetTable.put("IBM-819", "ISO8859_1");
        charsetTable.put("IBM819", "ISO8859_1");
        charsetTable.put("ISO-8859-1", "ISO8859_1");
        charsetTable.put("ISO-IR-100", "ISO8859_1");
        charsetTable.put("ISO_8859-1", "ISO8859_1");
        charsetTable.put("L1", "ISO8859_1");
        charsetTable.put("LATIN1", "ISO8859_1");
        charsetTable.put("CSISOLATIN2", "ISO8859_2");
        charsetTable.put("ISO-8859-2", "ISO8859_2");
        charsetTable.put("ISO-IR-101", "ISO8859_2");
        charsetTable.put("ISO_8859-2", "ISO8859_2");
        charsetTable.put("L2", "ISO8859_2");
        charsetTable.put("LATIN2", "ISO8859_2");
        charsetTable.put("CSISOLATIN3", "ISO8859_3");
        charsetTable.put("ISO-8859-3", "ISO8859_3");
        charsetTable.put("ISO-IR-109", "ISO8859_3");
        charsetTable.put("ISO_8859-3", "ISO8859_3");
        charsetTable.put("L3", "ISO8859_3");
        charsetTable.put("LATIN3", "ISO8859_3");
        charsetTable.put("CSISOLATIN4", "ISO8859_4");
        charsetTable.put("ISO-8859-4", "ISO8859_4");
        charsetTable.put("ISO-IR-110", "ISO8859_4");
        charsetTable.put("ISO_8859-4", "ISO8859_4");
        charsetTable.put("L4", "ISO8859_4");
        charsetTable.put("LATIN4", "ISO8859_4");
        charsetTable.put("CSISOLATINCYRILLIC", "ISO8859_5");
        charsetTable.put("CYRILLIC", "ISO8859_5");
        charsetTable.put("ISO-8859-5", "ISO8859_5");
        charsetTable.put("ISO-IR-144", "ISO8859_5");
        charsetTable.put("ISO_8859-5", "ISO8859_5");
        charsetTable.put("ARABIC", "ISO8859_6");
        charsetTable.put("ASMO-708", "ISO8859_6");
        charsetTable.put("CSISOLATINARABIC", "ISO8859_6");
        charsetTable.put("ECMA-114", "ISO8859_6");
        charsetTable.put("ISO-8859-6", "ISO8859_6");
        charsetTable.put("ISO-IR-127", "ISO8859_6");
        charsetTable.put("ISO_8859-6", "ISO8859_6");
        charsetTable.put("CSISOLATINGREEK", "ISO8859_7");
        charsetTable.put("ECMA-118", "ISO8859_7");
        charsetTable.put("ELOT_928", "ISO8859_7");
        charsetTable.put("GREEK", "ISO8859_7");
        charsetTable.put("GREEK8", "ISO8859_7");
        charsetTable.put("ISO-8859-7", "ISO8859_7");
        charsetTable.put("ISO-IR-126", "ISO8859_7");
        charsetTable.put("ISO_8859-7", "ISO8859_7");
        charsetTable.put("CSISOLATINHEBREW", "ISO8859_8");
        charsetTable.put("HEBREW", "ISO8859_8");
        charsetTable.put("ISO-8859-8", "ISO8859_8");
        charsetTable.put("ISO-8859-8-I", "ISO8859_8");
        charsetTable.put("ISO-IR-138", "ISO8859_8");
        charsetTable.put("ISO_8859-8", "ISO8859_8");
        charsetTable.put("CSISOLATIN5", "ISO8859_9");
        charsetTable.put("ISO-8859-9", "ISO8859_9");
        charsetTable.put("ISO-IR-148", "ISO8859_9");
        charsetTable.put("ISO_8859-9", "ISO8859_9");
        charsetTable.put("L5", "ISO8859_9");
        charsetTable.put("LATIN5", "ISO8859_9");
        charsetTable.put("CSISO2022JP", "JIS");
        charsetTable.put("ISO-2022-JP", "JIS");
        charsetTable.put("CSISO13JISC6220JP", "JIS0201");
        charsetTable.put("X0201", "JIS0201");
        charsetTable.put("CSISO87JISX0208", "JIS0208");
        charsetTable.put("ISO-IR-87", "JIS0208");
        charsetTable.put("X0208", "JIS0208");
        charsetTable.put("X0208DBIJIS_X0208-1983", "JIS0208");
        charsetTable.put("CSISO159JISX02121990", "JIS0212");
        charsetTable.put("ISO-IR-159", "JIS0212");
        charsetTable.put("X0212", "JIS0212");
        charsetTable.put("CSKOI8R", "KOI8_R");
        charsetTable.put("KOI8-R", "KOI8_R");
        charsetTable.put("EUC-KR", "KSC5601");
        charsetTable.put("CSWINDOWS31J", "MS932");
        charsetTable.put("WINDOWS-31J", "MS932");
        charsetTable.put("CSSHIFTJIS", "SJIS");
        charsetTable.put("MS_KANJI", "SJIS");
        charsetTable.put("SHIFT_JIS", "SJIS");
        charsetTable.put("TIS-620", "TIS620");
        charsetTable.put(CharEncoding.UTF_16BE, "UNICODEBIG");
        charsetTable.put("UTF-16LE", "UNICODELITTLE");
        charsetTable.put("UTF-8", InternalZipConstants.CHARSET_UTF8);
    }

    private String getJavaCharset(String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) charsetTable.get(str.toUpperCase());
        return str2 != null ? str2 : str;
    }

    private String guessEncoding() {
        if (this.bbufEnd < 4) {
            return null;
        }
        byte[] bArr = this.bbuf;
        byte b = bArr[0];
        if (b == -17) {
            if (bArr[1] != -69 || bArr[2] != -65) {
                return null;
            }
            this.bbufPos = 3;
            return "UTF-8";
        }
        if (b == 60) {
            byte b2 = bArr[1];
            if (b2 != 0) {
                if (b2 != 63 || bArr[2] != 120 || bArr[3] != 109) {
                    return null;
                }
                this.useDeclaredEncoding = true;
                return "UTF-8";
            }
            if (bArr[2] == 63 && bArr[3] == 0) {
                return "UnicodeLittleUnmarked";
            }
            if (bArr[2] == 0 && bArr[3] == 0) {
                return "UCS-4";
            }
            return null;
        }
        if (b == 76) {
            if (bArr[1] != 111 || bArr[2] != -89 || bArr[3] != -108) {
                return null;
            }
            this.useDeclaredEncoding = true;
            return "Cp037";
        }
        if (b == -2) {
            if (bArr[1] != -1) {
                return null;
            }
            if (bArr[2] == 0 && bArr[3] == 0) {
                this.bbufPos = 4;
                return "UCS-4";
            }
            this.bbufPos = 2;
            return "UnicodeBig";
        }
        if (b == -1) {
            if (bArr[1] != -2) {
                return null;
            }
            if (bArr[2] == 0 && bArr[3] == 0) {
                this.bbufPos = 4;
                return "UCS-4";
            }
            this.bbufPos = 2;
            return "UnicodeLittle";
        }
        if (b == 0) {
            byte b3 = bArr[1];
            if (b3 != 0) {
                if (b3 != 60) {
                    return null;
                }
                if (bArr[2] == 0 && bArr[3] == 63) {
                    return "UnicodeBigUnmarked";
                }
                if (bArr[2] == 0 && bArr[3] == 0) {
                    return "UCS-4";
                }
                return null;
            }
            if (bArr[2] == -2 && bArr[3] == -1) {
                this.bbufPos = 4;
                return "UCS-4";
            }
            if (bArr[2] == -1 && bArr[3] == -2) {
                this.bbufPos = 4;
                return "UCS-4";
            }
            if ((bArr[2] == 60 && bArr[3] == 0) || (bArr[2] == 0 && bArr[3] == 60)) {
                return "UCS-4";
            }
            return null;
        }
        this.useDeclaredEncoding = true;
        return null;
    }

    private void processXMLDecl() throws IOException {
        int i = this.bbufPos;
        XMLDecoder xMLDecoder = this.decoder;
        byte[] bArr = this.bbuf;
        int i2 = this.bbufEnd - i;
        char[] cArr = this.cbuf;
        xMLDecoder.decodeXMLDecl(bArr, i, i2, cArr, this.cbufPos, cArr.length, this.decodeResult);
        int i3 = this.bbufPos;
        int[] iArr = this.decodeResult;
        this.bbufPos = i3 + iArr[0];
        int i4 = iArr[1];
        this.cbufEnd = i4;
        int parseXMLDeclaration = parseXMLDeclaration(this.cbuf, 0, i4);
        if (parseXMLDeclaration > 0) {
            String javaCharset = getJavaCharset(getXMLDeclaredEncoding());
            if (!this.rewindDeclaration) {
                this.cbufPos += parseXMLDeclaration;
            }
            if (!this.useDeclaredEncoding || javaCharset == null || javaCharset.equalsIgnoreCase(this.encoding)) {
                return;
            }
            this.cbufEnd = 0;
            this.cbufPos = 0;
            this.decoder.reset();
            if (this.rewindDeclaration) {
                this.bbufPos = i;
            } else {
                this.bbufPos = parseXMLDeclaration * this.minBytesPerChar;
            }
            setEncoding(javaCharset);
        }
    }

    private class FastStreamDecoder implements XMLStreamDecoder {
        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public void reset() {
        }

        public FastStreamDecoder() {
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public int read() throws IOException {
            if (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0) {
                return XMLStreamReader.this.cbuf[XMLStreamReader.access$108(XMLStreamReader.this)];
            }
            XMLStreamReader xMLStreamReader = XMLStreamReader.this;
            xMLStreamReader.cbufPos = xMLStreamReader.cbufEnd = 0;
            XMLStreamReader xMLStreamReader2 = XMLStreamReader.this;
            xMLStreamReader2.cbufEnd = read(xMLStreamReader2.cbuf, XMLStreamReader.this.cbufPos, 100);
            if (XMLStreamReader.this.cbufEnd > 0) {
                return XMLStreamReader.this.cbuf[XMLStreamReader.access$108(XMLStreamReader.this)];
            }
            return -1;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i3;
            int min;
            if (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos <= 0 || (min = Math.min(XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos, i2 + 0)) <= 0) {
                i3 = 0;
            } else {
                System.arraycopy(XMLStreamReader.this.cbuf, XMLStreamReader.this.cbufPos, cArr, i, min);
                i3 = min + 0;
                XMLStreamReader.access$112(XMLStreamReader.this, min);
            }
            if (i3 < i2) {
                if (XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos < XMLStreamReader.this.maxBytesPerChar) {
                    XMLStreamReader.this.fillByteBuffer(false);
                    if (XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos < XMLStreamReader.this.minBytesPerChar) {
                        if (i3 <= 0) {
                            return -1;
                        }
                        return i3;
                    }
                }
                XMLStreamReader.this.decoder.decode(XMLStreamReader.this.bbuf, XMLStreamReader.this.bbufPos, XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos, cArr, i + i3, i2 - i3, XMLStreamReader.this.decodeResult);
                XMLStreamReader xMLStreamReader = XMLStreamReader.this;
                XMLStreamReader.access$412(xMLStreamReader, xMLStreamReader.decodeResult[0]);
                i3 += XMLStreamReader.this.decodeResult[1];
            }
            if (i3 == 0 && XMLStreamReader.this.eofReached) {
                return -1;
            }
            return i3;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public boolean ready() throws IOException {
            return XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0 || XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos > XMLStreamReader.this.maxBytesPerChar || XMLStreamReader.this.in.available() > 0;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public long skip(long j) throws IOException {
            long j2;
            if (XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos > 0) {
                j2 = Math.min(XMLStreamReader.this.cbufEnd - XMLStreamReader.this.cbufPos, j);
                XMLStreamReader.access$114(XMLStreamReader.this, j2);
            } else {
                j2 = 0;
            }
            while (true) {
                if (j2 >= j) {
                    break;
                }
                XMLStreamReader.this.cbufPos = 0;
                XMLStreamReader xMLStreamReader = XMLStreamReader.this;
                xMLStreamReader.cbufEnd = read(xMLStreamReader.cbuf, 0, 100);
                if (XMLStreamReader.this.cbufEnd <= 0) {
                    XMLStreamReader.this.cbufEnd = 0;
                    break;
                }
                XMLStreamReader.this.cbufPos = (int) Math.min(r2.cbufEnd, j - j2);
                j2 += XMLStreamReader.this.cbufPos;
            }
            return j2;
        }
    }

    private class JavaStreamDecoder implements XMLStreamDecoder {
        char[] oneCharBuffer = new char[1];
        private Reader reader;
        boolean sawCR;

        public JavaStreamDecoder() throws IOException {
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public void reset() throws IOException {
            this.sawCR = false;
            if (XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos > 0) {
                PushbackInputStream pushbackInputStream = new PushbackInputStream(XMLStreamReader.this.in, XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos);
                pushbackInputStream.unread(XMLStreamReader.this.bbuf, XMLStreamReader.this.bbufPos, XMLStreamReader.this.bbufEnd - XMLStreamReader.this.bbufPos);
                this.reader = new InputStreamReader(pushbackInputStream, XMLStreamReader.this.encoding);
                return;
            }
            this.reader = new InputStreamReader(XMLStreamReader.this.in, XMLStreamReader.this.encoding);
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public int read() throws IOException {
            int read;
            do {
                read = read(this.oneCharBuffer, 0, 1);
                if (read > 0) {
                    return this.oneCharBuffer[0];
                }
            } while (read >= 0);
            return read;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i3;
            int read = this.reader.read(cArr, i, i2);
            if (read < 0) {
                return read;
            }
            int i4 = i;
            for (int i5 = 0; i5 < read; i5++) {
                int i6 = i5 + i;
                char c = cArr[i6];
                if (c < ' ') {
                    if (c == '\t') {
                        i3 = i4 + 1;
                        cArr[i4] = '\t';
                    } else if (c != '\n') {
                        if (c == '\r') {
                            this.sawCR = true;
                            i3 = i4 + 1;
                            cArr[i4] = '\n';
                        } else {
                            System.out.println(new StringBuffer().append("Char: ").append(c).append(" [").append((int) c).append("]").toString());
                            throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(c)).toString());
                        }
                    } else if (this.sawCR) {
                        this.sawCR = false;
                    } else {
                        i3 = i4 + 1;
                        cArr[i4] = '\n';
                    }
                    i4 = i3;
                } else if (c <= 55295 || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535))) {
                    this.sawCR = false;
                    if (i6 != i4) {
                        cArr[i4] = c;
                    }
                    i4++;
                } else {
                    throw new IllegalCharException(new StringBuffer().append("Illegal XML Character: 0x").append(Integer.toHexString(c)).toString());
                }
            }
            return i4 - i;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public boolean ready() throws IOException {
            return this.reader.ready();
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLStreamReader.XMLStreamDecoder
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                XMLStreamReader xMLStreamReader = XMLStreamReader.this;
                xMLStreamReader.cbufEnd = read(xMLStreamReader.cbuf, 0, (int) Math.min(j, 100L));
                if (XMLStreamReader.this.cbufEnd <= 0) {
                    break;
                }
                j2 += XMLStreamReader.this.cbufEnd;
            }
            return j2;
        }
    }
}
