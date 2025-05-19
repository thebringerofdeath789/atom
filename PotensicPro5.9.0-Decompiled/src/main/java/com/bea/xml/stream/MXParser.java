package com.bea.xml.stream;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.EntityDeclaration;
import aavax.xml.stream.events.NotationDeclaration;
import com.bea.xml.stream.events.DTDEvent;
import com.bea.xml.stream.reader.XmlReader;
import com.bea.xml.stream.util.ElementTypeNames;
import com.bea.xml.stream.util.EmptyIterator;
import com.wutka.dtd.DTD;
import com.wutka.dtd.DTDAttlist;
import com.wutka.dtd.DTDAttribute;
import com.wutka.dtd.DTDEntity;
import com.wutka.dtd.DTDNotation;
import com.wutka.dtd.DTDParser;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import kotlin.text.Typography;
import okio.Utf8;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class MXParser implements XMLStreamReader, Location {
    protected static final char CHAR_UTF8_BOM = 65279;
    private static final int DOCDECL = 32768;
    protected static final char[] ENCODING;
    static final String EOF_MSG = "Unexpected end of stream";
    protected static final String FEATURE_NAMES_INTERNED = "http://xmlpull.org/v1/doc/features.html#names-interned";
    public static final String FEATURE_PROCESS_DOCDECL = "http://xmlpull.org/v1/doc/features.html#process-docdecl";
    public static final String FEATURE_PROCESS_NAMESPACES = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    public static final String FEATURE_STAX_ENTITIES = "aavax.xml.stream.entities";
    public static final String FEATURE_STAX_NOTATIONS = "aavax.xml.stream.notations";
    protected static final String FEATURE_XML_ROUNDTRIP = "http://xmlpull.org/v1/doc/features.html#xml-roundtrip";
    protected static final int LOOKUP_MAX = 1024;
    protected static final char LOOKUP_MAX_CHAR = 1024;
    protected static final int MAX_UNICODE_CHAR = 1114111;
    protected static final char[] NO;
    private static final char[] NO_CHARS;
    private static final int[] NO_INTS;
    private static final String[] NO_STRINGS;
    protected static final int READ_CHUNK_SIZE = 8192;
    protected static final char[] STANDALONE;
    private static final int TEXT = 16384;
    private static final boolean TRACE_SIZING = false;
    protected static final char[] VERSION;
    protected static final char[] YES;
    static /* synthetic */ Class class$com$wutka$dtd$DTDAttlist;
    static /* synthetic */ Class class$com$wutka$dtd$DTDEntity;
    static /* synthetic */ Class class$com$wutka$dtd$DTDNotation;
    protected boolean allStringsInterned;
    protected int attributeCount;
    protected String[] attributeName;
    protected int[] attributeNameHash;
    protected String[] attributePrefix;
    protected String[] attributeUri;
    protected String[] attributeValue;
    protected char[] buf;
    protected int bufAbsoluteStart;
    protected int bufEnd;
    protected int bufLoadFactor;
    protected int bufSoftLimit;
    protected int bufStart;
    protected String charEncodingScheme;
    protected char[] charRefOneCharBuf;
    protected char[] charRefTwoCharBuf;
    protected int columnNumber;
    private ConfigurationContextBase configurationContext;
    protected HashMap defaultAttributes;
    protected int depth;
    protected String[] elName;
    protected int[] elNamespaceCount;
    protected String[] elPrefix;
    protected char[][] elRawName;
    protected int[] elRawNameEnd;
    protected String[] elUri;
    protected boolean emptyElementTag;
    protected int entityEnd;
    protected String[] entityName;
    protected char[][] entityNameBuf;
    protected int[] entityNameHash;
    protected String entityRefName;
    protected String[] entityReplacement;
    protected char[][] entityReplacementBuf;
    protected char[] entityValue;
    protected int eventType;
    protected String inputEncoding;
    protected int lineNumber;
    protected int localNamespaceEnd;
    protected String[] localNamespacePrefix;
    protected int[] localNamespacePrefixHash;
    protected String[] localNamespaceUri;
    protected DTD mDtdIntSubset;
    protected int namespaceEnd;
    protected String[] namespacePrefix;
    protected int[] namespacePrefixHash;
    protected String[] namespaceUri;
    protected boolean pastEndTag;
    protected char[] pc;
    protected int pcEnd;
    protected int pcStart;
    protected String piData;
    protected String piTarget;
    protected int pos;
    protected int posEnd;
    protected int posStart;
    protected boolean reachedEnd;
    protected Reader reader;
    protected boolean seenAmpersand;
    protected boolean seenDocdecl;
    protected boolean seenEndTag;
    protected boolean seenMarkup;
    protected boolean seenRoot;
    protected boolean seenStartTag;
    protected String text;
    protected boolean tokenize;
    protected boolean usePC;
    public static final String[] TYPES = {"[UNKNOWN]", "START_ELEMENT", "END_ELEMENT", "PROCESSING_INSTRUCTION", "CHARACTERS", "COMMENT", "SPACE", "START_DOCUMENT", "END_DOCUMENT", "ENTITY_REFERENCE", "ATTRIBUTE", "DTD", "CDATA", "NAMESPACE", "NOTATION_DECLARATION", "ENTITY_DECLARATION"};
    public static final String NO_NAMESPACE = null;
    protected static boolean[] lookupNameStartChar = new boolean[1024];
    protected static boolean[] lookupNameChar = new boolean[1024];
    private boolean reportCdataEvent = false;
    protected boolean processNamespaces = true;
    protected boolean roundtripSupported = true;
    protected String xmlVersion = null;
    protected boolean standalone = false;
    protected boolean standaloneSet = false;

    private static final String checkNull(String str) {
        return str != null ? str : "";
    }

    private static boolean isElementEvent(int i) {
        return i == 1 || i == 2;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public void close() throws XMLStreamException {
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public Location getLocation() {
        return this;
    }

    public String getLocationURI() {
        return null;
    }

    @Override // aavax.xml.stream.Location
    public String getPublicId() {
        return null;
    }

    @Override // aavax.xml.stream.Location
    public String getSystemId() {
        return null;
    }

    protected boolean isS(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t';
    }

    protected void resetStringCache() {
    }

    static {
        setNameStart(NameUtil.COLON);
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            setNameStart(c);
        }
        setNameStart(NameUtil.USCORE);
        for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
            setNameStart(c2);
        }
        for (char c3 = 192; c3 <= 767; c3 = (char) (c3 + 1)) {
            setNameStart(c3);
        }
        for (char c4 = 880; c4 <= 893; c4 = (char) (c4 + 1)) {
            setNameStart(c4);
        }
        for (char c5 = 895; c5 < 1024; c5 = (char) (c5 + 1)) {
            setNameStart(c5);
        }
        setName(NameUtil.HYPHEN);
        setName('.');
        for (char c6 = '0'; c6 <= '9'; c6 = (char) (c6 + 1)) {
            setName(c6);
        }
        setName((char) 183);
        for (char c7 = 768; c7 <= 879; c7 = (char) (c7 + 1)) {
            setName(c7);
        }
        NO_STRINGS = new String[0];
        NO_INTS = new int[0];
        NO_CHARS = new char[0];
        VERSION = new char[]{'v', 'e', 'r', 's', 'i', 'o', 'n'};
        ENCODING = new char[]{'e', 'n', 'c', 'o', 'd', 'i', 'n', 'g'};
        STANDALONE = new char[]{'s', 't', 'a', 'n', 'd', 'a', 'l', 'o', 'n', 'e'};
        YES = new char[]{'y', 'e', 's'};
        NO = new char[]{'n', 'o'};
    }

    protected String newString(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    protected String newStringIntern(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2).intern();
    }

    protected void ensureElementsCapacity() {
        String[] strArr = this.elName;
        int length = strArr != null ? strArr.length : 0;
        int i = this.depth;
        if (i + 1 >= length) {
            int i2 = (i >= 7 ? i * 2 : 8) + 2;
            boolean z = length > 0;
            String[] strArr2 = new String[i2];
            if (z) {
                System.arraycopy(strArr, 0, strArr2, 0, length);
            }
            this.elName = strArr2;
            String[] strArr3 = new String[i2];
            if (z) {
                System.arraycopy(this.elPrefix, 0, strArr3, 0, length);
            }
            this.elPrefix = strArr3;
            String[] strArr4 = new String[i2];
            if (z) {
                System.arraycopy(this.elUri, 0, strArr4, 0, length);
            }
            this.elUri = strArr4;
            int[] iArr = new int[i2];
            if (z) {
                System.arraycopy(this.elNamespaceCount, 0, iArr, 0, length);
            } else {
                iArr[0] = 0;
            }
            this.elNamespaceCount = iArr;
            int[] iArr2 = new int[i2];
            if (z) {
                System.arraycopy(this.elRawNameEnd, 0, iArr2, 0, length);
            }
            this.elRawNameEnd = iArr2;
            char[][] cArr = new char[i2][];
            if (z) {
                System.arraycopy(this.elRawName, 0, cArr, 0, length);
            }
            this.elRawName = cArr;
        }
    }

    private static final void setName(char c) {
        lookupNameChar[c] = true;
    }

    private static final void setNameStart(char c) {
        lookupNameStartChar[c] = true;
        setName(c);
    }

    protected boolean isNameStartChar(char c) {
        return (c < 1024 && lookupNameStartChar[c]) || (c >= 1024 && c <= 8231) || ((c >= 8234 && c <= 8591) || (c >= 10240 && c <= 65519));
    }

    protected boolean isNameChar(char c) {
        return (c < 1024 && lookupNameChar[c]) || (c >= 1024 && c <= 8231) || ((c >= 8234 && c <= 8591) || (c >= 10240 && c <= 65519));
    }

    protected void checkCharValidity(int i, boolean z) throws XMLStreamException {
        if (i < 32) {
            if (!isS((char) i)) {
                throw new XMLStreamException(new StringBuffer().append("Illegal white space character (code 0x").append(Integer.toHexString(i)).append(")").toString());
            }
        } else if (i >= 55296) {
            if (i <= 57343) {
                if (!z) {
                    throw new XMLStreamException(new StringBuffer().append("Illegal character (code 0x").append(Integer.toHexString(i)).append("): surrogate characters are not valid XML characters").toString(), getLocation());
                }
            } else if (i > 1114111) {
                throw new XMLStreamException(new StringBuffer().append("Illegal character (code 0x").append(Integer.toHexString(i)).append("), past max. Unicode character 0x").append(Integer.toHexString(1114111)).toString(), getLocation());
            }
        }
    }

    protected void ensureAttributesCapacity(int i) {
        String[] strArr = this.attributeName;
        int length = strArr != null ? strArr.length : 0;
        if (i >= length) {
            int i2 = i > 7 ? i * 2 : 8;
            boolean z = length > 0;
            String[] strArr2 = new String[i2];
            if (z) {
                System.arraycopy(strArr, 0, strArr2, 0, length);
            }
            this.attributeName = strArr2;
            String[] strArr3 = new String[i2];
            if (z) {
                System.arraycopy(this.attributePrefix, 0, strArr3, 0, length);
            }
            this.attributePrefix = strArr3;
            String[] strArr4 = new String[i2];
            if (z) {
                System.arraycopy(this.attributeUri, 0, strArr4, 0, length);
            }
            this.attributeUri = strArr4;
            String[] strArr5 = new String[i2];
            if (z) {
                System.arraycopy(this.attributeValue, 0, strArr5, 0, length);
            }
            this.attributeValue = strArr5;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            if (z) {
                System.arraycopy(this.attributeNameHash, 0, iArr, 0, length);
            }
            this.attributeNameHash = iArr;
        }
    }

    protected void ensureNamespacesCapacity(int i) {
        String[] strArr = this.namespacePrefix;
        if (i >= (strArr != null ? strArr.length : 0)) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr2 = new String[i2];
            String[] strArr3 = new String[i2];
            if (strArr != null) {
                System.arraycopy(strArr, 0, strArr2, 0, this.namespaceEnd);
                System.arraycopy(this.namespaceUri, 0, strArr3, 0, this.namespaceEnd);
            }
            this.namespacePrefix = strArr2;
            this.namespaceUri = strArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.namespacePrefixHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.namespaceEnd);
            }
            this.namespacePrefixHash = iArr;
        }
    }

    protected void ensureLocalNamespacesCapacity(int i) {
        String[] strArr = this.localNamespacePrefix;
        if (i >= (strArr != null ? strArr.length : 0)) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr2 = new String[i2];
            String[] strArr3 = new String[i2];
            if (strArr != null) {
                System.arraycopy(strArr, 0, strArr2, 0, this.localNamespaceEnd);
                System.arraycopy(this.localNamespaceUri, 0, strArr3, 0, this.localNamespaceEnd);
            }
            this.localNamespacePrefix = strArr2;
            this.localNamespaceUri = strArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.localNamespacePrefixHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.localNamespaceEnd);
            }
            this.localNamespacePrefixHash = iArr;
        }
    }

    public int getLocalNamespaceCount() {
        return this.namespaceEnd - this.elNamespaceCount[this.depth - 1];
    }

    private String getLocalNamespaceURI(int i) {
        return this.namespaceUri[i];
    }

    private String getLocalNamespacePrefix(int i) {
        return this.namespacePrefix[i];
    }

    protected static final int fastHash(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = (cArr[i] << 7) + cArr[(i + i2) - 1];
        if (i2 > 16) {
            i3 = (i3 << 7) + cArr[(i2 / 4) + i];
        }
        return i2 > 8 ? (i3 << 7) + cArr[i + (i2 / 2)] : i3;
    }

    protected void ensureEntityCapacity() {
        char[][] cArr = this.entityReplacementBuf;
        int length = cArr != null ? cArr.length : 0;
        int i = this.entityEnd;
        if (i >= length) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr = new String[i2];
            char[][] cArr2 = new char[i2][];
            String[] strArr2 = new String[i2];
            char[][] cArr3 = new char[i2][];
            String[] strArr3 = this.entityName;
            if (strArr3 != null) {
                System.arraycopy(strArr3, 0, strArr, 0, i);
                System.arraycopy(this.entityNameBuf, 0, cArr2, 0, this.entityEnd);
                System.arraycopy(this.entityReplacement, 0, strArr2, 0, this.entityEnd);
                System.arraycopy(this.entityReplacementBuf, 0, cArr3, 0, this.entityEnd);
            }
            this.entityName = strArr;
            this.entityNameBuf = cArr2;
            this.entityReplacement = strArr2;
            this.entityReplacementBuf = cArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.entityNameHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.entityEnd);
            }
            this.entityNameHash = iArr;
        }
    }

    private void reset() {
        this.lineNumber = 1;
        this.columnNumber = 0;
        this.seenRoot = false;
        this.reachedEnd = false;
        this.eventType = 7;
        this.emptyElementTag = false;
        this.depth = 0;
        this.attributeCount = 0;
        this.namespaceEnd = 0;
        this.localNamespaceEnd = 0;
        this.entityEnd = 0;
        this.reader = null;
        this.inputEncoding = null;
        this.bufAbsoluteStart = 0;
        this.bufStart = 0;
        this.bufEnd = 0;
        this.posEnd = 0;
        this.posStart = 0;
        this.pos = 0;
        this.pcStart = 0;
        this.pcEnd = 0;
        this.usePC = false;
        this.seenStartTag = false;
        this.seenEndTag = false;
        this.pastEndTag = false;
        this.seenAmpersand = false;
        this.seenMarkup = false;
        this.seenDocdecl = false;
        resetStringCache();
    }

    public MXParser() {
        String[] strArr = NO_STRINGS;
        this.namespacePrefix = strArr;
        this.namespaceUri = strArr;
        this.bufLoadFactor = 95;
        char[] cArr = new char[Runtime.getRuntime().freeMemory() > 1000000 ? 8192 : 256];
        this.buf = cArr;
        this.bufSoftLimit = (this.bufLoadFactor * cArr.length) / 100;
        this.pc = new char[Runtime.getRuntime().freeMemory() <= 1000000 ? 64 : 8192];
        this.entityValue = null;
        this.charRefOneCharBuf = new char[1];
        this.charRefTwoCharBuf = null;
    }

    public void setFeature(String str, boolean z) throws XMLStreamException {
        if (str == null) {
            throw new IllegalArgumentException("feature name should not be nulll");
        }
        if (FEATURE_PROCESS_NAMESPACES.equals(str)) {
            if (this.eventType != 7) {
                throw new XMLStreamException("namespace processing feature can only be changed before parsing", getLocation());
            }
            this.processNamespaces = z;
        } else if (FEATURE_NAMES_INTERNED.equals(str)) {
            if (z) {
                throw new XMLStreamException("interning names in this implementation is not supported");
            }
        } else if (FEATURE_PROCESS_DOCDECL.equals(str)) {
            if (z) {
                throw new XMLStreamException("processing DOCDECL is not supported");
            }
        } else {
            if (!FEATURE_XML_ROUNDTRIP.equals(str)) {
                throw new XMLStreamException(new StringBuffer().append("unknown feature ").append(str).toString());
            }
            if (!z) {
                throw new XMLStreamException("roundtrip feature can not be switched off");
            }
        }
    }

    public boolean getFeature(String str) {
        if (str == null) {
            throw new IllegalArgumentException("feature name should not be null");
        }
        if (FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNamespaces;
        }
        return (FEATURE_NAMES_INTERNED.equals(str) || FEATURE_PROCESS_DOCDECL.equals(str) || !FEATURE_XML_ROUNDTRIP.equals(str)) ? false : true;
    }

    public void setProperty(String str, Object obj) throws XMLStreamException {
        throw new XMLStreamException(new StringBuffer().append("unsupported property: '").append(str).append("'").toString());
    }

    public boolean checkForXMLDecl() throws XMLStreamException {
        try {
            BufferedReader bufferedReader = new BufferedReader(this.reader, 7);
            this.reader = bufferedReader;
            bufferedReader.mark(7);
            int read = bufferedReader.read();
            if (read == 65279) {
                bufferedReader.mark(7);
                read = bufferedReader.read();
            }
            if (read == 60 && bufferedReader.read() == 63 && bufferedReader.read() == 120 && bufferedReader.read() == 109 && bufferedReader.read() == 108) {
                bufferedReader.reset();
                return true;
            }
            bufferedReader.reset();
            return false;
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    public void setInput(Reader reader) throws XMLStreamException {
        reset();
        this.reader = reader;
        if (checkForXMLDecl()) {
            next();
        }
    }

    public void setInput(InputStream inputStream) throws XMLStreamException {
        try {
            Reader createReader = XmlReader.createReader(inputStream);
            String encoding = createReader instanceof XmlReader.BaseReader ? ((XmlReader.BaseReader) createReader).getEncoding() : null;
            setInput(createReader);
            if (encoding != null) {
                this.inputEncoding = encoding;
            }
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    public void setInput(InputStream inputStream, String str) throws XMLStreamException {
        if (inputStream == null) {
            throw new IllegalArgumentException("input stream can not be null");
        }
        try {
            setInput(str != null ? XmlReader.createReader(inputStream, str) : XmlReader.createReader(inputStream));
            if (str != null) {
                this.inputEncoding = str;
            }
        } catch (IOException e) {
            throw new XMLStreamException(new StringBuffer().append("could not create reader ").append(str == null ? new StringBuffer().append("(for encoding '").append(str).append("')").toString() : "").append(": ").append(e).toString(), getLocation(), e);
        }
    }

    public String getInputEncoding() {
        return this.inputEncoding;
    }

    public void defineEntityReplacementText(String str, String str2) throws XMLStreamException {
        ensureEntityCapacity();
        char[] charArray = str.toCharArray();
        this.entityName[this.entityEnd] = newString(charArray, 0, str.length());
        char[][] cArr = this.entityNameBuf;
        int i = this.entityEnd;
        cArr[i] = charArray;
        this.entityReplacement[i] = str2;
        char[] charArray2 = str2 == null ? NO_CHARS : str2.toCharArray();
        char[][] cArr2 = this.entityReplacementBuf;
        int i2 = this.entityEnd;
        cArr2[i2] = charArray2;
        if (!this.allStringsInterned) {
            int[] iArr = this.entityNameHash;
            char[][] cArr3 = this.entityNameBuf;
            iArr[i2] = fastHash(cArr3[i2], 0, cArr3[i2].length);
        }
        this.entityEnd++;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getNamespaceCount() {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        return getNamespaceCount(this.depth);
    }

    public int getNamespaceCount(int i) {
        if (!this.processNamespaces || i == 0) {
            return 0;
        }
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("namespace count may be 0..").append(this.depth).append(" not ").append(i).toString());
        }
        int[] iArr = this.elNamespaceCount;
        return iArr[i] - iArr[i - 1];
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespacePrefix(int i) {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        int i2 = this.depth;
        int namespaceCount = getNamespaceCount(i2);
        int i3 = this.elNamespaceCount[i2 - 1] + i;
        if (i < namespaceCount) {
            return this.namespacePrefix[i3];
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("position ").append(i).append(" exceeded number of available namespaces ").append(namespaceCount).toString());
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespaceURI(int i) {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        int i2 = this.depth;
        int namespaceCount = getNamespaceCount(i2);
        int i3 = this.elNamespaceCount[i2 - 1] + i;
        if (i < namespaceCount) {
            return this.namespaceUri[i3];
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("position ").append(i).append(" exceedded number of available namespaces ").append(namespaceCount).toString());
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespaceURI(String str) {
        if (!isElementEvent(this.eventType)) {
            throwIllegalState(new int[]{1, 2});
        }
        if (str != null && str.length() > 0) {
            for (int i = this.namespaceEnd - 1; i >= 0; i--) {
                if (str.equals(this.namespacePrefix[i])) {
                    return this.namespaceUri[i];
                }
            }
            if ("xml".equals(str)) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            if ("xmlns".equals(str)) {
                return "http://www.w3.org/2000/xmlns/";
            }
            return null;
        }
        for (int i2 = this.namespaceEnd - 1; i2 >= 0; i2--) {
            if (this.namespacePrefix[i2] == null) {
                return this.namespaceUri[i2];
            }
        }
        return null;
    }

    public int getDepth() {
        return this.depth;
    }

    private static int findFragment(int i, char[] cArr, int i2, int i3) {
        if (i2 < i) {
            return i > i3 ? i3 : i;
        }
        if (i3 - i2 > 65) {
            i2 = i3 - 10;
        }
        int i4 = i2 + 1;
        while (true) {
            i4--;
            if (i4 <= i || i3 - i4 > 65 || (cArr[i4] == '<' && i2 - i4 > 10)) {
                break;
            }
        }
        return i4;
    }

    public String getPositionDescription() {
        int i = this.posStart;
        int i2 = this.pos;
        if (i <= i2) {
            int findFragment = findFragment(0, this.buf, i, i2);
            r3 = findFragment < this.pos ? new String(this.buf, findFragment, this.pos - findFragment) : null;
            if (this.bufAbsoluteStart > 0 || findFragment > 0) {
                r3 = new StringBuffer().append("...").append(r3).toString();
            }
        }
        return new StringBuffer().append(StringUtils.SPACE).append(r3 != null ? new StringBuffer().append(" seen ").append(printable(r3)).append("...").toString() : "").append(" @").append(getLineNumber()).append(":").append(getColumnNumber()).toString();
    }

    @Override // aavax.xml.stream.Location
    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // aavax.xml.stream.Location
    public int getColumnNumber() {
        return this.columnNumber;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isWhiteSpace() {
        int i = this.eventType;
        if (i != 4 && i != 12) {
            return i == 6;
        }
        if (this.usePC) {
            for (int i2 = this.pcStart; i2 < this.pcEnd; i2++) {
                if (!isS(this.pc[i2])) {
                    return false;
                }
            }
            return true;
        }
        for (int i3 = this.posStart; i3 < this.posEnd; i3++) {
            if (!isS(this.buf[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getNamespaceURI() {
        int i = this.eventType;
        return (i == 1 || i == 2) ? this.processNamespaces ? this.elUri[this.depth] : NO_NAMESPACE : throwIllegalState(new int[]{1, 2});
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getLocalName() {
        int i = this.eventType;
        if (i == 1) {
            return this.elName[this.depth];
        }
        if (i == 2) {
            return this.elName[this.depth];
        }
        if (i != 9) {
            return throwIllegalState(new int[]{1, 2, 9});
        }
        if (this.entityRefName == null) {
            char[] cArr = this.buf;
            int i2 = this.posStart;
            this.entityRefName = newString(cArr, i2, this.posEnd - i2);
        }
        return this.entityRefName;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getPrefix() {
        int i = this.eventType;
        return (i == 1 || i == 2) ? this.elPrefix[this.depth] : throwIllegalState(new int[]{1, 2});
    }

    public boolean isEmptyElementTag() throws XMLStreamException {
        if (this.eventType != 1) {
            throw new XMLStreamException("parser must be on XMLStreamConstants.START_ELEMENT to check for empty element", getLocation());
        }
        return this.emptyElementTag;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getAttributeCount() {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        return this.attributeCount;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeNamespace(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (!this.processNamespaces) {
            return NO_NAMESPACE;
        }
        if (i < 0 || i >= this.attributeCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("attribute position must be 0..").append(this.attributeCount - 1).append(" and not ").append(i).toString());
        }
        return this.attributeUri[i];
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeLocalName(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("attribute position must be 0..").append(this.attributeCount - 1).append(" and not ").append(i).toString());
        }
        return this.attributeName[i];
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributePrefix(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (!this.processNamespaces) {
            return null;
        }
        if (i < 0 || i >= this.attributeCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("attribute position must be 0..").append(this.attributeCount - 1).append(" and not ").append(i).toString());
        }
        return this.attributePrefix[i];
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeType(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("attribute position must be 0..").append(this.attributeCount - 1).append(" and not ").append(i).toString());
        }
        return "CDATA";
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isAttributeSpecified(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("attribute position must be 0..").append(this.attributeCount - 1).append(" and not ").append(i).toString());
        }
        return true;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeValue(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (i < 0 || i >= this.attributeCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("attribute position must be 0..").append(this.attributeCount - 1).append(" and not ").append(i).toString());
        }
        return this.attributeValue[i];
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getAttributeValue(String str, String str2) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("attribute name can not be null");
        }
        int i = 0;
        if (str != null) {
            while (i < this.attributeCount) {
                if (str2.equals(this.attributeName[i]) && str.equals(this.attributeUri[i])) {
                    return this.attributeValue[i];
                }
                i++;
            }
            return null;
        }
        while (i < this.attributeCount) {
            if (str2.equals(this.attributeName[i])) {
                return this.attributeValue[i];
            }
            i++;
        }
        return null;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getEventType() {
        return this.eventType;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public void require(int i, String str, String str2) throws XMLStreamException {
        int eventType = getEventType();
        boolean z = i == eventType;
        if (z && str2 != null) {
            if (eventType == 1 || eventType == 2 || eventType == 9) {
                z = str2.equals(getLocalName());
            } else {
                throw new XMLStreamException(new StringBuffer().append("Using non-null local name argument for require(); ").append(ElementTypeNames.getEventTypeString(eventType)).append(" event does not have local name").toString(), getLocation());
            }
        }
        if (z && str != null && (eventType == 1 || eventType == 1)) {
            String namespaceURI = getNamespaceURI();
            if (str.length() == 0) {
                z = namespaceURI == null;
            } else {
                z = str.equals(namespaceURI);
            }
        }
        if (z) {
            return;
        }
        String str3 = "";
        StringBuffer append = new StringBuffer().append("expected event ").append(ElementTypeNames.getEventTypeString(i)).append(str2 != null ? new StringBuffer().append(" with name '").append(str2).append("'").toString() : "").append((str == null || str2 == null) ? "" : " and").append(str != null ? new StringBuffer().append(" with namespace '").append(str).append("'").toString() : "").append(" but got").append(i != getEventType() ? new StringBuffer().append(StringUtils.SPACE).append(ElementTypeNames.getEventTypeString(getEventType())).toString() : "").append((str2 == null || getLocalName() == null || str2.equals(getName())) ? "" : new StringBuffer().append(" name '").append(getLocalName()).append("'").toString()).append((str == null || str2 == null || getLocalName() == null || str2.equals(getName()) || getNamespaceURI() == null || str.equals(getNamespaceURI())) ? "" : " and");
        if (str != null && getNamespaceURI() != null && !str.equals(getNamespaceURI())) {
            str3 = new StringBuffer().append(" namespace '").append(getNamespaceURI()).append("'").toString();
        }
        throw new XMLStreamException(append.append(str3).append(" (position:").append(getPositionDescription()).append(")").toString(), getLocation());
    }

    public String nextText() throws XMLStreamException {
        if (getEventType() != 1) {
            throw new XMLStreamException("parser must be on START_ELEMENT to read next text", getLocation());
        }
        int next = next();
        if (next != 4) {
            if (next == 2) {
                return "";
            }
            throw new XMLStreamException("parser must be on START_ELEMENT or TEXT to read text", getLocation());
        }
        String text = getText();
        if (next() == 2) {
            return text;
        }
        throw new XMLStreamException(new StringBuffer().append("TEXT must be immediately followed by END_ELEMENT and not ").append(ElementTypeNames.getEventTypeString(getEventType())).toString(), getLocation());
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int nextTag() throws XMLStreamException {
        next();
        while (true) {
            int i = this.eventType;
            if (i == 6 || i == 5 || i == 3 || ((i == 4 && isWhiteSpace()) || (this.eventType == 12 && isWhiteSpace()))) {
                next();
            }
        }
        int i2 = this.eventType;
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        throw new XMLStreamException(new StringBuffer().append("expected XMLStreamConstants.START_ELEMENT or XMLStreamConstants.END_ELEMENT not ").append(ElementTypeNames.getEventTypeString(getEventType())).toString(), getLocation());
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getElementText() throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        if (getEventType() != 1) {
            throw new XMLStreamException("Precondition for readText is getEventType() == START_ELEMENT");
        }
        while (next() != 8) {
            if (isStartElement()) {
                throw new XMLStreamException("Unexpected Element start");
            }
            if (isCharacters() || getEventType() == 9) {
                stringBuffer.append(getText());
            }
            if (isEndElement()) {
                return stringBuffer.toString();
            }
        }
        throw new XMLStreamException("Unexpected end of Document");
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        this.tokenize = true;
        this.pcStart = 0;
        this.pcEnd = 0;
        this.usePC = false;
        return nextImpl();
    }

    public int nextToken() throws XMLStreamException {
        this.tokenize = true;
        return nextImpl();
    }

    public int nextElement() throws XMLStreamException {
        return nextTag();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean hasNext() throws XMLStreamException {
        return this.eventType != 8;
    }

    public void skip() throws XMLStreamException {
        nextToken();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isStartElement() {
        return this.eventType == 1;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isEndElement() {
        return this.eventType == 2;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isCharacters() {
        return this.eventType == 4;
    }

    public boolean isEOF() {
        return this.eventType == 8;
    }

    public boolean moveToStartElement() throws XMLStreamException {
        if (isStartElement()) {
            return true;
        }
        while (hasNext()) {
            if (isStartElement()) {
                return true;
            }
            next();
        }
        return false;
    }

    public boolean moveToStartElement(String str) throws XMLStreamException {
        if (str == null) {
            return false;
        }
        while (moveToStartElement()) {
            if (str.equals(getLocalName())) {
                return true;
            }
            if (!hasNext()) {
                return false;
            }
            next();
        }
        return false;
    }

    public boolean moveToStartElement(String str, String str2) throws XMLStreamException {
        if (str != null && str2 != null) {
            while (moveToStartElement(str)) {
                if (str2.equals(getNamespaceURI())) {
                    return true;
                }
                if (!hasNext()) {
                    return false;
                }
                next();
            }
        }
        return false;
    }

    public boolean moveToEndElement() throws XMLStreamException {
        if (isEndElement()) {
            return true;
        }
        while (hasNext()) {
            if (isEndElement()) {
                return true;
            }
            next();
        }
        return false;
    }

    public boolean moveToEndElement(String str) throws XMLStreamException {
        if (str == null) {
            return false;
        }
        while (moveToEndElement()) {
            if (str.equals(getLocalName())) {
                return true;
            }
            if (!hasNext()) {
                return false;
            }
            next();
        }
        return false;
    }

    public boolean moveToEndElement(String str, String str2) throws XMLStreamException {
        if (str != null && str2 != null) {
            while (moveToEndElement(str)) {
                if (str2.equals(getNamespaceURI())) {
                    return true;
                }
                if (!hasNext()) {
                    return false;
                }
                next();
            }
        }
        return false;
    }

    public boolean hasAttributes() {
        return getAttributeCount() > 0;
    }

    public boolean hasNamespaces() {
        return getNamespaceCount() > 0;
    }

    public Iterator getAttributes() {
        if (!hasAttributes()) {
            return EmptyIterator.emptyIterator;
        }
        int attributeCount = getAttributeCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < attributeCount; i++) {
            arrayList.add(new AttributeBase(getAttributePrefix(i), getAttributeNamespace(i), getAttributeLocalName(i), getAttributeValue(i), getAttributeType(i)));
        }
        return arrayList.iterator();
    }

    public Iterator internalGetNamespaces(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = this.elNamespaceCount[i - 1];
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 + i3;
            String localNamespacePrefix = getLocalNamespacePrefix(i5);
            if (localNamespacePrefix == null) {
                arrayList.add(new NamespaceBase(getLocalNamespaceURI(i5)));
            } else {
                arrayList.add(new NamespaceBase(localNamespacePrefix, getLocalNamespaceURI(i5)));
            }
        }
        return arrayList.iterator();
    }

    public Iterator getNamespaces() {
        if (!hasNamespaces()) {
            return EmptyIterator.emptyIterator;
        }
        return internalGetNamespaces(this.depth, getLocalNamespaceCount());
    }

    public Iterator getOutOfScopeNamespaces() {
        int[] iArr = this.elNamespaceCount;
        int i = this.depth;
        return internalGetNamespaces(i, iArr[i] - iArr[i - 1]);
    }

    public XMLStreamReader subReader() throws XMLStreamException {
        return new SubReader(this);
    }

    public void recycle() throws XMLStreamException {
        reset();
    }

    public Reader getTextStream() {
        throw new UnsupportedOperationException();
    }

    private final void checkTextEvent() {
        if (!hasText()) {
            throw new IllegalStateException(new StringBuffer().append("Current state (").append(eventTypeDesc(this.eventType)).append(") does not have textual content").toString());
        }
    }

    private final void checkTextEventXxx() {
        int i = this.eventType;
        if (i != 4 && i != 12 && i != 5 && i != 6) {
            throw new IllegalStateException(new StringBuffer().append("getTextXxx methods cannot be called for ").append(eventTypeDesc(this.eventType)).toString());
        }
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getText() {
        checkTextEvent();
        if (this.eventType == 9) {
            if (this.text == null && this.entityValue != null) {
                this.text = new String(this.entityValue);
            }
            return this.text;
        }
        if (this.usePC) {
            char[] cArr = this.pc;
            int i = this.pcStart;
            this.text = new String(cArr, i, this.pcEnd - i);
        } else {
            char[] cArr2 = this.buf;
            int i2 = this.posStart;
            this.text = new String(cArr2, i2, this.posEnd - i2);
        }
        return this.text;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
        checkTextEventXxx();
        int textLength = getTextLength();
        if (i < 0 || i > textLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = textLength - i;
        if (i4 < i3) {
            i3 = i4;
        }
        if (i3 > 0) {
            System.arraycopy(getTextCharacters(), getTextStart() + i, cArr, i2, i3);
        }
        return i3;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public char[] getTextCharacters() {
        checkTextEventXxx();
        if (this.eventType == 4) {
            if (this.usePC) {
                return this.pc;
            }
            return this.buf;
        }
        return this.buf;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getTextStart() {
        checkTextEventXxx();
        if (this.usePC) {
            return this.pcStart;
        }
        return this.posStart;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public int getTextLength() {
        int i;
        int i2;
        checkTextEventXxx();
        if (this.usePC) {
            i = this.pcEnd;
            i2 = this.pcStart;
        } else {
            i = this.posEnd;
            i2 = this.posStart;
        }
        return i - i2;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean hasText() {
        int i = this.eventType;
        return i == 4 || i == 11 || i == 12 || i == 5 || i == 6 || i == 9;
    }

    public String getValue() {
        return getText();
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getEncoding() {
        return getInputEncoding();
    }

    @Override // aavax.xml.stream.Location
    public int getCharacterOffset() {
        return this.posEnd;
    }

    private static String eventTypeDesc(int i) {
        if (i >= 0) {
            String[] strArr = TYPES;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return "[UNKNOWN]";
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public QName getAttributeName(int i) {
        if (this.eventType != 1) {
            throwIllegalState(1);
        }
        return new QName(checkNull(getAttributeNamespace(i)), getAttributeLocalName(i), checkNull(getAttributePrefix(i)));
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public QName getName() {
        if (!isElementEvent(this.eventType)) {
            throw new IllegalStateException("Current state not START_ELEMENT or END_ELEMENT");
        }
        return new QName(checkNull(getNamespaceURI()), getLocalName(), checkNull(getPrefix()));
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean hasName() {
        return isElementEvent(this.eventType);
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getVersion() {
        return this.xmlVersion;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean isStandalone() {
        return this.standalone;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public boolean standaloneSet() {
        return this.standaloneSet;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getCharacterEncodingScheme() {
        return this.charEncodingScheme;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x013b, code lost:
    
        if (r5 != false) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int nextImpl() throws aavax.xml.stream.XMLStreamException {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.MXParser.nextImpl():int");
    }

    protected int parseProlog() throws XMLStreamException {
        char more;
        try {
            if (this.seenMarkup) {
                more = this.buf[this.pos - 1];
            } else {
                more = more();
            }
            if (this.eventType == 7) {
                if (more == 65534) {
                    throw new XMLStreamException("first character in input was UNICODE noncharacter (0xFFFE)- input requires int swapping", getLocation());
                }
                if (more == 65279) {
                    more = more();
                }
            }
            boolean z = false;
            this.seenMarkup = false;
            this.posStart = this.pos - 1;
            while (true) {
                if (more == '<') {
                    if (z && this.tokenize) {
                        this.posEnd = this.pos - 1;
                        this.seenMarkup = true;
                        this.eventType = 6;
                        return 6;
                    }
                    char more2 = more();
                    if (more2 == '?') {
                        boolean parsePI = parsePI();
                        if (this.tokenize) {
                            if (parsePI) {
                                this.eventType = 7;
                                return 7;
                            }
                            this.eventType = 3;
                            return 3;
                        }
                    } else {
                        if (more2 != '!') {
                            if (more2 == '/') {
                                throw new XMLStreamException(new StringBuffer().append("expected start tag name and not ").append(printable(more2)).toString(), getLocation());
                            }
                            if (isNameStartChar(more2)) {
                                this.seenRoot = true;
                                return parseStartTag();
                            }
                            throw new XMLStreamException(new StringBuffer().append("expected start tag name and not ").append(printable(more2)).toString(), getLocation());
                        }
                        char more3 = more();
                        if (more3 == 'D') {
                            if (this.seenDocdecl) {
                                throw new XMLStreamException("only one docdecl allowed in XML document", getLocation());
                            }
                            this.seenDocdecl = true;
                            parseDocdecl();
                            if (this.tokenize) {
                                this.eventType = 11;
                                return 11;
                            }
                        } else if (more3 == '-') {
                            parseComment();
                            if (this.tokenize) {
                                this.eventType = 5;
                                return 5;
                            }
                        } else {
                            throw new XMLStreamException(new StringBuffer().append("unexpected markup <!").append(printable(more3)).toString(), getLocation());
                        }
                    }
                } else {
                    if (!isS(more)) {
                        throw new XMLStreamException(new StringBuffer().append("only whitespace content allowed before start tag and not ").append(printable(more)).toString(), getLocation());
                    }
                    z = true;
                }
                more = more();
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected int parseEpilog() throws XMLStreamException {
        char more;
        if (this.eventType == 8) {
            throw new XMLStreamException("already reached end document", getLocation());
        }
        if (this.reachedEnd) {
            this.eventType = 8;
            return 8;
        }
        boolean z = false;
        try {
            if (this.seenMarkup) {
                more = this.buf[this.pos - 1];
            } else {
                more = more();
            }
            this.seenMarkup = false;
            this.posStart = this.pos - 1;
            while (true) {
                if (more == '<') {
                    if (z && this.tokenize) {
                        this.posEnd = this.pos - 1;
                        this.seenMarkup = true;
                        this.eventType = 6;
                        return 6;
                    }
                    char more2 = more();
                    if (more2 == '?') {
                        parsePI();
                        if (this.tokenize) {
                            this.eventType = 3;
                            return 3;
                        }
                    } else {
                        if (more2 != '!') {
                            if (more2 == '/') {
                                throw new XMLStreamException(new StringBuffer().append("end tag not allowed in epilog but got ").append(printable(more2)).toString(), getLocation());
                            }
                            if (isNameStartChar(more2)) {
                                throw new XMLStreamException(new StringBuffer().append("start tag not allowed in epilog but got ").append(printable(more2)).toString(), getLocation());
                            }
                            throw new XMLStreamException(new StringBuffer().append("in epilog expected ignorable content and not ").append(printable(more2)).toString(), getLocation());
                        }
                        char more3 = more();
                        if (more3 == 'D') {
                            parseDocdecl();
                            if (this.tokenize) {
                                this.eventType = 11;
                                return 11;
                            }
                        } else if (more3 == '-') {
                            parseComment();
                            if (this.tokenize) {
                                this.eventType = 5;
                                return 5;
                            }
                        } else {
                            throw new XMLStreamException(new StringBuffer().append("unexpected markup <!").append(printable(more3)).toString(), getLocation());
                        }
                    }
                } else {
                    if (!isS(more)) {
                        throw new XMLStreamException(new StringBuffer().append("in epilog non whitespace content is not allowed but got ").append(printable(more)).toString(), getLocation());
                    }
                    z = true;
                }
                more = more();
            }
        } catch (EOFException unused) {
            this.reachedEnd = true;
            if (this.tokenize && 0 != 0) {
                this.posEnd = this.pos;
                this.eventType = 6;
                return 6;
            }
            this.eventType = 8;
            return 8;
        }
    }

    public int parseEndTag() throws XMLStreamException {
        char more;
        this.eventType = 2;
        try {
            char more2 = more();
            if (!isNameStartChar(more2)) {
                throw new XMLStreamException(new StringBuffer().append("expected name start and not ").append(printable(more2)).toString(), getLocation());
            }
            int i = this.pos;
            this.posStart = i - 3;
            int i2 = (i - 1) + this.bufAbsoluteStart;
            do {
                more = more();
            } while (isNameChar(more));
            int i3 = this.pos - 1;
            int i4 = i2 - this.bufAbsoluteStart;
            int i5 = i3 - i4;
            char[][] cArr = this.elRawName;
            int i6 = this.depth;
            char[] cArr2 = cArr[i6];
            if (this.elRawNameEnd[i6] != i5) {
                throw new XMLStreamException(new StringBuffer().append("end tag name '").append(new String(this.buf, i4, i5)).append("' must match start tag name '").append(new String(cArr2, 0, this.elRawNameEnd[this.depth])).append("'").toString(), getLocation());
            }
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i4 + 1;
                if (this.buf[i4] != cArr2[i7]) {
                    throw new XMLStreamException(new StringBuffer().append("end tag name '").append(new String(this.buf, (i8 - i7) - 1, i5)).append("' must be the same as start tag '").append(new String(cArr2, 0, i5)).append("'").toString(), getLocation());
                }
                i7++;
                i4 = i8;
            }
            while (isS(more)) {
                more = more();
            }
            if (more != '>') {
                throw new XMLStreamException(new StringBuffer().append("expected > to finsh end tag not ").append(printable(more)).toString(), getLocation());
            }
            this.posEnd = this.pos;
            this.pastEndTag = true;
            return 2;
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0193 A[Catch: EOFException -> 0x0308, TryCatch #0 {EOFException -> 0x0308, blocks: (B:3:0x0003, B:5:0x0023, B:8:0x0028, B:9:0x0034, B:12:0x0037, B:29:0x0041, B:31:0x0054, B:33:0x005f, B:36:0x0075, B:38:0x00bc, B:40:0x00c2, B:65:0x00dd, B:68:0x00e7, B:71:0x00ef, B:72:0x00f2, B:73:0x010e, B:74:0x010f, B:75:0x0116, B:77:0x011a, B:79:0x0120, B:81:0x0126, B:83:0x014e, B:85:0x012b, B:86:0x0147, B:87:0x0148, B:91:0x0152, B:95:0x0159, B:97:0x0161, B:99:0x0165, B:102:0x0189, B:104:0x0193, B:105:0x01ac, B:107:0x01b6, B:108:0x01cf, B:109:0x01f1, B:110:0x0171, B:112:0x0175, B:114:0x017d, B:118:0x01f2, B:123:0x01f6, B:125:0x025a, B:128:0x026c, B:129:0x0285, B:132:0x01fb, B:136:0x0202, B:138:0x0206, B:141:0x022b, B:142:0x0253, B:143:0x0212, B:145:0x0216, B:147:0x021e, B:151:0x0254, B:156:0x0257, B:63:0x00d5, B:158:0x0289, B:159:0x02a9, B:48:0x02aa, B:56:0x02b5, B:57:0x02c0, B:54:0x02c1, B:60:0x02ca, B:61:0x02eb, B:162:0x009d, B:163:0x00af, B:164:0x0059, B:16:0x02ee, B:20:0x02f4, B:24:0x02fc, B:25:0x0307), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b6 A[Catch: EOFException -> 0x0308, TryCatch #0 {EOFException -> 0x0308, blocks: (B:3:0x0003, B:5:0x0023, B:8:0x0028, B:9:0x0034, B:12:0x0037, B:29:0x0041, B:31:0x0054, B:33:0x005f, B:36:0x0075, B:38:0x00bc, B:40:0x00c2, B:65:0x00dd, B:68:0x00e7, B:71:0x00ef, B:72:0x00f2, B:73:0x010e, B:74:0x010f, B:75:0x0116, B:77:0x011a, B:79:0x0120, B:81:0x0126, B:83:0x014e, B:85:0x012b, B:86:0x0147, B:87:0x0148, B:91:0x0152, B:95:0x0159, B:97:0x0161, B:99:0x0165, B:102:0x0189, B:104:0x0193, B:105:0x01ac, B:107:0x01b6, B:108:0x01cf, B:109:0x01f1, B:110:0x0171, B:112:0x0175, B:114:0x017d, B:118:0x01f2, B:123:0x01f6, B:125:0x025a, B:128:0x026c, B:129:0x0285, B:132:0x01fb, B:136:0x0202, B:138:0x0206, B:141:0x022b, B:142:0x0253, B:143:0x0212, B:145:0x0216, B:147:0x021e, B:151:0x0254, B:156:0x0257, B:63:0x00d5, B:158:0x0289, B:159:0x02a9, B:48:0x02aa, B:56:0x02b5, B:57:0x02c0, B:54:0x02c1, B:60:0x02ca, B:61:0x02eb, B:162:0x009d, B:163:0x00af, B:164:0x0059, B:16:0x02ee, B:20:0x02f4, B:24:0x02fc, B:25:0x0307), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int parseStartTag() throws aavax.xml.stream.XMLStreamException {
        /*
            Method dump skipped, instructions count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.MXParser.parseStartTag():int");
    }

    protected void addDefaultAttributes(String str) throws XMLStreamException {
        boolean z;
        HashMap hashMap = this.defaultAttributes;
        if (hashMap == null) {
            return;
        }
        DTDAttlist dTDAttlist = (DTDAttlist) hashMap.get(str);
        if (str == null || dTDAttlist == null) {
            return;
        }
        for (DTDAttribute dTDAttribute : dTDAttlist.getAttribute()) {
            if (dTDAttribute.getDefaultValue() != null) {
                int i = this.attributeCount;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        z = false;
                        break;
                    } else {
                        if (this.attributeName[i2].equals(dTDAttribute.getName())) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z) {
                    int i3 = this.attributeCount + 1;
                    this.attributeCount = i3;
                    ensureAttributesCapacity(i3);
                    String[] strArr = this.attributePrefix;
                    int i4 = this.attributeCount;
                    strArr[i4 - 1] = null;
                    this.attributeUri[i4 - 1] = NO_NAMESPACE;
                    this.attributeName[i4 - 1] = dTDAttribute.getName();
                    this.attributeValue[this.attributeCount - 1] = dTDAttribute.getDefaultValue();
                }
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameCodeVar(RegisterArg.java:193)
        	at jadx.core.dex.visitors.PrepareForCodeGen.modifyArith(PrepareForCodeGen.java:244)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:90)
        */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        if (r7 != 'm') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 != (-1)) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
    
        r11 = r16.bufAbsoluteStart + (r16.pos - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
    
        throw new aavax.xml.stream.XMLStreamException("only one colon is allowed in attribute name when namespaces are enabled", getLocation());
     */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0263 A[Catch: EOFException -> 0x0409, TryCatch #0 {EOFException -> 0x0409, blocks: (B:3:0x0004, B:5:0x0018, B:8:0x001d, B:9:0x0029, B:11:0x002a, B:16:0x0036, B:17:0x003d, B:19:0x0045, B:24:0x004e, B:46:0x0073, B:47:0x007e, B:50:0x0083, B:54:0x008a, B:55:0x0095, B:52:0x0096, B:59:0x009b, B:65:0x00ac, B:69:0x0152, B:71:0x0158, B:75:0x0161, B:76:0x0165, B:78:0x016b, B:85:0x0179, B:86:0x0199, B:87:0x019a, B:88:0x01a5, B:155:0x01ad, B:158:0x01b3, B:160:0x01b7, B:161:0x01cf, B:164:0x01dd, B:169:0x01f8, B:171:0x01fe, B:173:0x0204, B:176:0x020b, B:177:0x0217, B:178:0x0218, B:180:0x0222, B:181:0x0253, B:183:0x0263, B:188:0x0273, B:190:0x0279, B:196:0x02a1, B:197:0x02c3, B:198:0x028c, B:200:0x0284, B:204:0x0269, B:208:0x02c4, B:209:0x0302, B:212:0x022c, B:213:0x0237, B:214:0x0238, B:216:0x0244, B:217:0x0246, B:219:0x024a, B:220:0x01e4, B:221:0x01ec, B:222:0x01ed, B:224:0x02ca, B:225:0x02d2, B:226:0x01c4, B:227:0x02d3, B:229:0x02d7, B:230:0x02fd, B:231:0x02eb, B:95:0x0313, B:97:0x031c, B:101:0x0325, B:102:0x0329, B:104:0x032f, B:123:0x033d, B:125:0x0341, B:126:0x034e, B:127:0x0374, B:107:0x0376, B:109:0x0379, B:111:0x0380, B:113:0x0383, B:133:0x039f, B:135:0x03a3, B:137:0x03aa, B:138:0x03ad, B:139:0x03b8, B:141:0x03bc, B:143:0x03c5, B:144:0x03c9, B:145:0x03cf, B:147:0x03d6, B:150:0x03dd, B:152:0x03f1, B:153:0x03fc, B:232:0x03fd, B:233:0x0408, B:234:0x00c8, B:235:0x00d4, B:238:0x00da, B:239:0x011f, B:241:0x0123, B:242:0x0105, B:243:0x012e, B:245:0x0147), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected char parseAttribute() throws aavax.xml.stream.XMLStreamException {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.MXParser.parseAttribute():char");
    }

    protected char[] parseEntityRef(boolean z) throws XMLStreamException {
        int i;
        int i2;
        try {
            this.entityRefName = null;
            this.posStart = this.pos;
            if (more() == '#') {
                char more = more();
                if (more == 'x') {
                    i = 0;
                    do {
                        char more2 = more();
                        if (more2 == ';') {
                            break;
                        }
                        int i3 = i << 4;
                        if (more2 >= '0' && more2 <= '9') {
                            i2 = more2 - 48;
                        } else if (more2 >= 'a' && more2 <= 'f') {
                            i2 = more2 - 87;
                        } else {
                            if (more2 < 'A' || more2 > 'F') {
                                throw new XMLStreamException(new StringBuffer().append("character reference (with hex value) may not contain ").append(printable(more2)).toString(), getLocation());
                            }
                            i2 = more2 - 55;
                        }
                        i = i3 + i2;
                    } while (i <= 1114111);
                } else {
                    int i4 = 0;
                    while (more >= '0' && more <= '9') {
                        i4 = (i4 * 10) + (more - '0');
                        more = more();
                        if (i4 > 1114111) {
                            break;
                        }
                    }
                    if (more != ';') {
                        throw new XMLStreamException(new StringBuffer().append("character reference (with decimal value) may not contain ").append(printable(more)).toString(), getLocation());
                    }
                    i = i4;
                }
                this.posEnd = this.pos - 1;
                checkCharValidity(i, false);
                if (i > 65535) {
                    if (this.charRefTwoCharBuf == null) {
                        this.charRefTwoCharBuf = new char[2];
                    }
                    int i5 = i - 65536;
                    char[] cArr = this.charRefTwoCharBuf;
                    cArr[0] = (char) ((i5 >> 10) + 55296);
                    cArr[1] = (char) ((i5 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                    this.entityValue = cArr;
                    return cArr;
                }
                char[] cArr2 = this.charRefOneCharBuf;
                cArr2[0] = (char) i;
                this.entityValue = cArr2;
                return cArr2;
            }
            while (more() != ';') {
            }
            int i6 = this.pos - 1;
            this.posEnd = i6;
            int i7 = this.posStart;
            int i8 = i6 - i7;
            if (i8 == 2) {
                char[] cArr3 = this.buf;
                if (cArr3[i7] == 'l' && cArr3[i7 + 1] == 't') {
                    if (!z) {
                        this.text = "<";
                    }
                    char[] cArr4 = this.charRefOneCharBuf;
                    cArr4[0] = Typography.less;
                    this.entityValue = cArr4;
                    return cArr4;
                }
                if (cArr3[i7] == 'g' && cArr3[i7 + 1] == 't') {
                    if (!z) {
                        this.text = ">";
                    }
                    char[] cArr5 = this.charRefOneCharBuf;
                    cArr5[0] = Typography.greater;
                    this.entityValue = cArr5;
                    return cArr5;
                }
            } else if (i8 == 3) {
                char[] cArr6 = this.buf;
                if (cArr6[i7] == 'a' && cArr6[i7 + 1] == 'm' && cArr6[i7 + 2] == 'p') {
                    if (!z) {
                        this.text = "&";
                    }
                    char[] cArr7 = this.charRefOneCharBuf;
                    cArr7[0] = Typography.amp;
                    this.entityValue = cArr7;
                    return cArr7;
                }
            } else if (i8 == 4) {
                char[] cArr8 = this.buf;
                if (cArr8[i7] == 'a' && cArr8[i7 + 1] == 'p' && cArr8[i7 + 2] == 'o' && cArr8[i7 + 3] == 's') {
                    if (!z) {
                        this.text = "'";
                    }
                    char[] cArr9 = this.charRefOneCharBuf;
                    cArr9[0] = '\'';
                    this.entityValue = cArr9;
                    return cArr9;
                }
                if (cArr8[i7] == 'q' && cArr8[i7 + 1] == 'u' && cArr8[i7 + 2] == 'o' && cArr8[i7 + 3] == 't') {
                    if (!z) {
                        this.text = "\"";
                    }
                    char[] cArr10 = this.charRefOneCharBuf;
                    cArr10[0] = '\"';
                    this.entityValue = cArr10;
                    return cArr10;
                }
            }
            char[] lookupEntityReplacement = lookupEntityReplacement(i8);
            this.entityValue = lookupEntityReplacement;
            return lookupEntityReplacement;
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected char[] lookupEntityReplacement(int i) throws XMLStreamException {
        if (!this.allStringsInterned) {
            char[] cArr = this.buf;
            int i2 = this.posStart;
            int fastHash = fastHash(cArr, i2, this.posEnd - i2);
            for (int i3 = this.entityEnd - 1; i3 >= 0; i3--) {
                if (fastHash == this.entityNameHash[i3]) {
                    char[][] cArr2 = this.entityNameBuf;
                    if (i == cArr2[i3].length) {
                        char[] cArr3 = cArr2[i3];
                        for (int i4 = 0; i4 < i; i4++) {
                            if (this.buf[this.posStart + i4] != cArr3[i4]) {
                                break;
                            }
                        }
                        if (this.tokenize) {
                            this.text = this.entityReplacement[i3];
                        }
                        this.entityRefName = this.entityName[i3];
                        return this.entityReplacementBuf[i3];
                    }
                    continue;
                }
            }
            return null;
        }
        char[] cArr4 = this.buf;
        int i5 = this.posStart;
        this.entityRefName = newString(cArr4, i5, this.posEnd - i5);
        for (int i6 = this.entityEnd - 1; i6 >= 0; i6--) {
            if (this.entityRefName == this.entityName[i6]) {
                if (this.tokenize) {
                    this.text = this.entityReplacement[i6];
                }
                return this.entityReplacementBuf[i6];
            }
        }
        return null;
    }

    protected void parseComment() throws XMLStreamException {
        try {
            if (more() != '-') {
                throw new XMLStreamException("expected <!-- for COMMENT start", getLocation());
            }
            this.posStart = this.pos;
            int i = this.lineNumber;
            int i2 = this.columnNumber;
            int i3 = -1;
            boolean z = false;
            int i4 = -2;
            int i5 = -2;
            while (true) {
                try {
                    char more = more();
                    i3++;
                    if (more == '-') {
                        if (i4 >= i3) {
                            break;
                        } else {
                            i4 = i3 + 1;
                        }
                    } else if (more == '\r') {
                        this.columnNumber = 1;
                        i5 = i3 + 1;
                        if (z) {
                            more = '\n';
                        } else {
                            this.buf[this.pos - 1] = '\n';
                        }
                    } else if (more == '\n' && i5 == i3) {
                        if (!z) {
                            this.posEnd = this.pos - 1;
                            z = true;
                        }
                    }
                    if (z) {
                        char[] cArr = this.buf;
                        int i6 = this.posEnd;
                        cArr[i6] = more;
                        this.posEnd = i6 + 1;
                    }
                } catch (EOFException e) {
                    throw new XMLStreamException(new StringBuffer().append("COMMENT started on line ").append(i).append(" and column ").append(i2).append(" was not closed").toString(), getLocation(), e);
                }
            }
            char more2 = more();
            if (more2 != '>') {
                throw new XMLStreamException(new StringBuffer().append("in COMMENT after two dashes (--) next character must be '>' not ").append(printable(more2)).toString(), getLocation());
            }
            if (z) {
                this.posEnd--;
            } else {
                this.posEnd = this.pos - 3;
            }
        } catch (EOFException e2) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e2);
        }
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getPITarget() {
        if (this.eventType != 3) {
            throwIllegalState(3);
        }
        return this.piTarget;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public String getPIData() {
        if (this.eventType != 3) {
            throwIllegalState(3);
        }
        return this.piData;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public NamespaceContext getNamespaceContext() {
        return new ReadOnlyNamespaceContextBase(this.namespacePrefix, this.namespaceUri, this.namespaceEnd);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        r6 = true;
        r5 = (r13.pos - r13.posStart) - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r5 == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r13.piTarget = new java.lang.String(r13.buf, r13.posStart, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r3 == '?') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        r3 = skipS(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r5 = r13.piTarget.equalsIgnoreCase("xml");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (r5 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if ((r13.posStart + r13.bufAbsoluteStart) > 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if ("xml".equals(r13.piTarget) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        r13.posStart = r13.pos - 1;
        parseXmlDecl(r3);
        r13.posEnd = r13.pos - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
    
        r3 = r13.buf;
        r4 = r13.posStart;
        r13.piData = new java.lang.String(r3, r4, r13.posEnd - r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b1, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        throw new aavax.xml.stream.XMLStreamException("XMLDecl must have xml name in lowercase", getLocation());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        throw new aavax.xml.stream.XMLStreamException("processing instruction can not have PITarget with reserved name 'xml'", getLocation());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        r13.posStart = r13.pos - 1;
        r0 = -1;
        r8 = false;
        r9 = -2;
        r10 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
    
        if (r3 != '?') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
    
        r9 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d3, code lost:
    
        if (r8 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
    
        r11 = r13.buf;
        r12 = r13.posEnd;
        r11[r12] = r3;
        r13.posEnd = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
    
        r3 = more();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (r3 != '>') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        if (r0 != r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0095, code lost:
    
        if (r8 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0097, code lost:
    
        r13.posEnd--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
    
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009d, code lost:
    
        r13.posEnd = r13.pos - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b4, code lost:
    
        if (r3 != '\r') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b6, code lost:
    
        r13.columnNumber = 1;
        r10 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:
    
        if (r8 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bc, code lost:
    
        r13.buf[r13.pos - 1] = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c4, code lost:
    
        r3 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
    
        if (r3 != '\n') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c8, code lost:
    
        if (r10 != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
    
        if (r8 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cc, code lost:
    
        r13.posEnd = r13.pos - 1;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ef, code lost:
    
        throw new aavax.xml.stream.XMLStreamException("processing instruction must have PITarget name", getLocation());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean parsePI() throws aavax.xml.stream.XMLStreamException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.MXParser.parsePI():boolean");
    }

    protected char requireInput(char c, char[] cArr) throws XMLStreamException {
        for (int i = 0; i < cArr.length; i++) {
            if (c != cArr[i]) {
                throw new XMLStreamException(new StringBuffer().append("expected ").append(printable(cArr[i])).append(" in ").append(new String(cArr)).append(" and not ").append(printable(c)).toString(), getLocation());
            }
            try {
                c = more();
            } catch (EOFException e) {
                throw new XMLStreamException(EOF_MSG, getLocation(), e);
            }
        }
        return c;
    }

    protected char requireNextS() throws XMLStreamException {
        try {
            char more = more();
            if (!isS(more)) {
                throw new XMLStreamException(new StringBuffer().append("white space is required and not ").append(printable(more)).toString(), getLocation());
            }
            return skipS(more);
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected char skipS(char c) throws XMLStreamException {
        while (isS(c)) {
            try {
                c = more();
            } catch (EOFException e) {
                throw new XMLStreamException(EOF_MSG, getLocation(), e);
            }
        }
        return c;
    }

    protected void parseXmlDecl(char c) throws XMLStreamException {
        try {
            char skipS = skipS(requireInput(skipS(c), VERSION));
            if (skipS != '=') {
                throw new XMLStreamException(new StringBuffer().append("expected equals sign (=) after version and not ").append(printable(skipS)).toString(), getLocation());
            }
            char skipS2 = skipS(more());
            if (skipS2 != '\'' && skipS2 != '\"') {
                throw new XMLStreamException(new StringBuffer().append("expected apostrophe (') or quotation mark (\") after version and not ").append(printable(skipS2)).toString(), getLocation());
            }
            int i = this.pos;
            char more = more();
            while (more != skipS2) {
                if ((more < 'a' || more > 'z') && ((more < 'A' || more > 'Z') && ((more < '0' || more > '9') && more != '_' && more != '.' && more != ':' && more != '-'))) {
                    throw new XMLStreamException(new StringBuffer().append("<?xml version value expected to be in ([a-zA-Z0-9_.:] | '-') not ").append(printable(more)).toString(), getLocation());
                }
                more = more();
            }
            parseXmlDeclWithVersion(i, this.pos - 1);
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected void parseXmlDeclWithVersion(int i, int i2) throws XMLStreamException {
        char requireInput;
        int i3 = i2 - i;
        if (i3 == 3) {
            try {
                char[] cArr = this.buf;
                if (cArr[i] == '1' && cArr[i + 1] == '.' && cArr[i + 2] == '0') {
                    this.xmlVersion = new String(this.buf, i, i3);
                    char skipS = skipS(more());
                    if (skipS != '?') {
                        skipS = skipS(skipS);
                        char[] cArr2 = ENCODING;
                        if (skipS == cArr2[0]) {
                            char skipS2 = skipS(requireInput(skipS, cArr2));
                            if (skipS2 != '=') {
                                throw new XMLStreamException(new StringBuffer().append("expected equals sign (=) after encoding and not ").append(printable(skipS2)).toString(), getLocation());
                            }
                            char skipS3 = skipS(more());
                            if (skipS3 != '\'' && skipS3 != '\"') {
                                throw new XMLStreamException(new StringBuffer().append("expected apostrophe (') or quotation mark (\") after encoding and not ").append(printable(skipS3)).toString(), getLocation());
                            }
                            int i4 = this.pos;
                            char more = more();
                            char c = 'a';
                            if ((more < 'a' || more > 'z') && (more < 'A' || more > 'Z')) {
                                throw new XMLStreamException(new StringBuffer().append("<?xml encoding name expected to start with [A-Za-z] not ").append(printable(more)).toString(), getLocation());
                            }
                            char more2 = more();
                            while (more2 != skipS3) {
                                if ((more2 < c || more2 > 'z') && ((more2 < 'A' || more2 > 'Z') && ((more2 < '0' || more2 > '9') && more2 != '.' && more2 != '_' && more2 != '-'))) {
                                    throw new XMLStreamException(new StringBuffer().append("<?xml encoding value expected to be in ([A-Za-z0-9._] | '-') not ").append(printable(more2)).toString(), getLocation());
                                }
                                more2 = more();
                                c = 'a';
                            }
                            this.charEncodingScheme = newString(this.buf, i4, (this.pos - 1) - i4);
                            skipS = skipS(more());
                        }
                        if (skipS != '?') {
                            char skipS4 = skipS(requireInput(skipS(skipS), STANDALONE));
                            if (skipS4 != '=') {
                                throw new XMLStreamException(new StringBuffer().append("expected equals sign (=) after standalone and not ").append(printable(skipS4)).toString(), getLocation());
                            }
                            char skipS5 = skipS(more());
                            if (skipS5 != '\'' && skipS5 != '\"') {
                                throw new XMLStreamException(new StringBuffer().append("expected apostrophe (') or quotation mark (\") after encoding and not ").append(printable(skipS5)).toString(), getLocation());
                            }
                            char more3 = more();
                            if (more3 == 'y') {
                                requireInput = requireInput(more3, YES);
                                this.standalone = true;
                            } else if (more3 == 'n') {
                                requireInput = requireInput(more3, NO);
                                this.standalone = false;
                            } else {
                                throw new XMLStreamException(new StringBuffer().append("expected 'yes' or 'no' after standalone and not ").append(printable(more3)).toString(), getLocation());
                            }
                            this.standaloneSet = true;
                            if (requireInput != skipS5) {
                                throw new XMLStreamException(new StringBuffer().append("expected ").append(skipS5).append(" after standalone value not ").append(printable(requireInput)).toString(), getLocation());
                            }
                            skipS = more();
                        }
                    }
                    char skipS6 = skipS(skipS);
                    if (skipS6 != '?') {
                        throw new XMLStreamException(new StringBuffer().append("expected ?> as last part of <?xml not ").append(printable(skipS6)).toString(), getLocation());
                    }
                    char more4 = more();
                    if (more4 != '>') {
                        throw new XMLStreamException(new StringBuffer().append("expected ?> as last part of <?xml not ").append(printable(more4)).toString(), getLocation());
                    }
                    return;
                }
            } catch (EOFException e) {
                throw new XMLStreamException(EOF_MSG, getLocation(), e);
            }
        }
        throw new XMLStreamException(new StringBuffer().append("only 1.0 is supported as <?xml version not '").append(printable(new String(this.buf, i, i2))).append("'").toString(), getLocation());
    }

    protected void parseDocdecl() throws XMLStreamException {
        char more;
        this.posStart = this.pos - 3;
        try {
            if (more() != 'O' || more() != 'C' || more() != 'T' || more() != 'Y' || more() != 'P' || more() != 'E') {
                throw new XMLStreamException("expected <!DOCTYPE", getLocation());
            }
            char requireNextS = requireNextS();
            if (!isNameStartChar(requireNextS)) {
                throwNotNameStart(requireNextS);
            }
            do {
                more = more();
            } while (isNameChar(more));
            char skipS = skipS(more);
            if (skipS == 'S' || skipS == 'P') {
                if (skipS == 'S') {
                    if (more() != 'Y' || more() != 'S' || more() != 'T' || more() != 'E' || more() != 'M') {
                        throw new XMLStreamException("expected keyword SYSTEM", getLocation());
                    }
                } else {
                    if (more() != 'U' || more() != 'B' || more() != 'L' || more() != 'I' || more() != 'C') {
                        throw new XMLStreamException("expected keyword PUBLIC", getLocation());
                    }
                    char requireNextS2 = requireNextS();
                    if (requireNextS2 != '\"' && requireNextS2 != '\'') {
                        throw new XMLStreamException(new StringBuffer().append("Public identifier has to be enclosed in quotes, not ").append(printable(skipS)).toString(), getLocation());
                    }
                    do {
                        skipS = more();
                    } while (skipS != requireNextS2);
                }
                char requireNextS3 = requireNextS();
                if (requireNextS3 != '\"' && requireNextS3 != '\'') {
                    throw new XMLStreamException(new StringBuffer().append("System identifier has to be enclosed in quotes, not ").append(printable(skipS)).toString(), getLocation());
                }
                while (more() != requireNextS3) {
                }
                skipS = skipS(more());
            }
            if (skipS == '[') {
                this.posStart = this.pos;
                int i = 1;
                while (true) {
                    char more2 = more();
                    if (more2 == '\"' || more2 == '\'') {
                        while (more() != more2) {
                        }
                    } else if (more2 != '>') {
                        if (more2 == '[') {
                            i++;
                        } else if (more2 == ']') {
                            i--;
                        }
                    } else if (i <= 0) {
                        this.posEnd = this.pos - 2;
                        processDTD();
                        return;
                    }
                }
            } else {
                int i2 = this.pos;
                this.posEnd = i2;
                this.posStart = i2;
                char skipS2 = skipS(skipS);
                if (skipS2 != '>') {
                    throw new XMLStreamException(new StringBuffer().append("Expected closing '>' after internal DTD subset, not '").append(printable(skipS2)).append("'").toString(), getLocation());
                }
            }
        } catch (EOFException e) {
            throw new XMLStreamException(EOF_MSG, getLocation(), e);
        }
    }

    protected void processDTD() throws XMLStreamException {
        try {
            char[] cArr = this.buf;
            int i = this.posStart;
            DTD parse = new DTDParser(new StringReader(new String(cArr, i, this.posEnd - i))).parse();
            this.mDtdIntSubset = parse;
            Class cls = class$com$wutka$dtd$DTDEntity;
            if (cls == null) {
                cls = class$("com.wutka.dtd.DTDEntity");
                class$com$wutka$dtd$DTDEntity = cls;
            }
            Enumeration elements = parse.getItemsByType(cls).elements();
            while (elements.hasMoreElements()) {
                DTDEntity dTDEntity = (DTDEntity) elements.nextElement();
                if (!dTDEntity.isParsed()) {
                    defineEntityReplacementText(dTDEntity.getName(), dTDEntity.getValue());
                }
            }
            DTD dtd = this.mDtdIntSubset;
            Class cls2 = class$com$wutka$dtd$DTDAttlist;
            if (cls2 == null) {
                cls2 = class$("com.wutka.dtd.DTDAttlist");
                class$com$wutka$dtd$DTDAttlist = cls2;
            }
            Enumeration elements2 = dtd.getItemsByType(cls2).elements();
            while (elements2.hasMoreElements()) {
                DTDAttlist dTDAttlist = (DTDAttlist) elements2.nextElement();
                for (DTDAttribute dTDAttribute : dTDAttlist.getAttribute()) {
                    if (dTDAttribute.getDefaultValue() != null) {
                        if (this.defaultAttributes == null) {
                            this.defaultAttributes = new HashMap();
                        }
                        this.defaultAttributes.put(dTDAttlist.getName(), dTDAttlist);
                    }
                }
            }
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected void parseCDATA() throws XMLStreamException {
        try {
            if (more() != 'C' || more() != 'D' || more() != 'A' || more() != 'T' || more() != 'A' || more() != '[') {
                throw new XMLStreamException("expected <[CDATA[ for CDATA start", getLocation());
            }
            this.posStart = this.pos;
            int i = this.lineNumber;
            int i2 = this.columnNumber;
            int i3 = -2;
            int i4 = -1;
            int i5 = 0;
            boolean z = false;
            while (true) {
                i4++;
                try {
                    char more = more();
                    if (more == ']') {
                        i5++;
                    } else {
                        if (more == '>') {
                            if (i5 >= 2) {
                                break;
                            }
                        } else if (more == '\r') {
                            this.columnNumber = 1;
                            i3 = i4 + 1;
                            if (z) {
                                i5 = 0;
                                more = '\n';
                            } else {
                                this.buf[this.pos - 1] = '\n';
                                i5 = 0;
                            }
                        } else if (more == '\n' && i3 == i4) {
                            this.posEnd = this.pos - 1;
                            i5 = 0;
                            z = true;
                        }
                        i5 = 0;
                    }
                    if (z) {
                        char[] cArr = this.buf;
                        int i6 = this.posEnd;
                        cArr[i6] = more;
                        this.posEnd = i6 + 1;
                    }
                } catch (EOFException e) {
                    throw new XMLStreamException(new StringBuffer().append("CDATA section on line ").append(i).append(" and column ").append(i2).append(" was not closed").toString(), getLocation(), e);
                }
            }
            if (z) {
                this.posEnd -= 2;
            } else {
                this.posEnd = this.pos - 3;
            }
        } catch (EOFException e2) {
            throw new XMLStreamException("Unexpected EOF in directive", getLocation(), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void fillBuf() throws aavax.xml.stream.XMLStreamException, java.io.EOFException {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.MXParser.fillBuf():void");
    }

    protected char more() throws XMLStreamException, EOFException {
        if (this.pos >= this.bufEnd) {
            fillBuf();
        }
        char[] cArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        char c = cArr[i];
        if (c == '\n') {
            this.lineNumber++;
            this.columnNumber = 1;
        } else {
            this.columnNumber++;
        }
        return c;
    }

    protected String printable(char c) {
        if (c == '\n') {
            return "\\n";
        }
        if (c == '\r') {
            return "\\r";
        }
        if (c == '\t') {
            return "\\t";
        }
        if (c == '\'') {
            return "\\'";
        }
        if (c > 127 || c < ' ') {
            return new StringBuffer().append("\\u").append(Integer.toHexString(c)).toString();
        }
        return new StringBuffer().append("").append(c).toString();
    }

    protected String printable(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(printable(str.charAt(i)));
        }
        return stringBuffer.toString();
    }

    protected void ensurePC(int i) {
        char[] cArr = new char[i > 8192 ? i * 2 : 16384];
        System.arraycopy(this.pc, 0, cArr, 0, this.pcEnd);
        this.pc = cArr;
    }

    protected void joinPC() {
        int i = this.posEnd - this.posStart;
        int i2 = this.pcEnd + i + 1;
        if (i2 >= this.pc.length) {
            ensurePC(i2);
        }
        System.arraycopy(this.buf, this.posStart, this.pc, this.pcEnd, i);
        this.pcEnd += i;
        this.usePC = true;
    }

    public void setConfigurationContext(ConfigurationContextBase configurationContextBase) {
        this.configurationContext = configurationContextBase;
        Boolean.TRUE.equals(configurationContextBase.getProperty(XMLInputFactory.IS_COALESCING));
        this.reportCdataEvent = Boolean.TRUE.equals(configurationContextBase.getProperty("http://java.sun.com/xml/stream/properties/report-cdata-event"));
    }

    public ConfigurationContextBase getConfigurationContext() {
        return this.configurationContext;
    }

    @Override // aavax.xml.stream.XMLStreamReader
    public Object getProperty(String str) {
        ArrayList arrayList = null;
        if (str.equals("aavax.xml.stream.entities")) {
            DTD dtd = this.mDtdIntSubset;
            if (dtd != null) {
                Class cls = class$com$wutka$dtd$DTDEntity;
                if (cls == null) {
                    cls = class$("com.wutka.dtd.DTDEntity");
                    class$com$wutka$dtd$DTDEntity = cls;
                }
                Vector itemsByType = dtd.getItemsByType(cls);
                Enumeration elements = itemsByType.elements();
                arrayList = new ArrayList(itemsByType.size());
                while (elements.hasMoreElements()) {
                    EntityDeclaration createEntityDeclaration = DTDEvent.createEntityDeclaration((DTDEntity) elements.nextElement());
                    if (createEntityDeclaration != null) {
                        arrayList.add(createEntityDeclaration);
                    }
                }
            }
            return arrayList;
        }
        if (str.equals("aavax.xml.stream.notations")) {
            DTD dtd2 = this.mDtdIntSubset;
            if (dtd2 != null) {
                Class cls2 = class$com$wutka$dtd$DTDNotation;
                if (cls2 == null) {
                    cls2 = class$("com.wutka.dtd.DTDNotation");
                    class$com$wutka$dtd$DTDNotation = cls2;
                }
                Vector itemsByType2 = dtd2.getItemsByType(cls2);
                Enumeration elements2 = itemsByType2.elements();
                arrayList = new ArrayList(itemsByType2.size());
                while (elements2.hasMoreElements()) {
                    NotationDeclaration createNotationDeclaration = DTDEvent.createNotationDeclaration((DTDNotation) elements2.nextElement());
                    if (createNotationDeclaration != null) {
                        arrayList.add(createNotationDeclaration);
                    }
                }
            }
            return arrayList;
        }
        return this.configurationContext.getProperty(str);
    }

    private String throwIllegalState(int i) throws IllegalStateException {
        throw new IllegalStateException(new StringBuffer().append("Current state (").append(eventTypeDesc(this.eventType)).append(") not ").append(eventTypeDesc(i)).toString());
    }

    private String throwIllegalState(int[] iArr) throws IllegalStateException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(eventTypeDesc(iArr[0]));
        int length = iArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(", ");
            stringBuffer.append(eventTypeDesc(iArr[i]));
        }
        stringBuffer.append(" or ");
        stringBuffer.append(eventTypeDesc(iArr[length]));
        throw new IllegalStateException(new StringBuffer().append("Current state (").append(eventTypeDesc(this.eventType)).append(") not ").append(stringBuffer.toString()).toString());
    }

    private void throwNotNameStart(char c) throws XMLStreamException {
        throw new XMLStreamException(new StringBuffer().append("expected name start character and not ").append(printable(c)).toString(), getLocation());
    }
}
