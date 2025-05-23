package org.apache.xmlbeans.impl.common;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: classes5.dex */
public class EncodingMap {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final HashMap _iana_to_java;
    private static final HashMap _java_to_iana;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$EncodingMap;

    static {
        if (class$org$apache$xmlbeans$impl$common$EncodingMap == null) {
            class$org$apache$xmlbeans$impl$common$EncodingMap = class$("org.apache.xmlbeans.impl.common.EncodingMap");
        }
        $assertionsDisabled = true;
        _iana_to_java = new HashMap();
        _java_to_iana = new HashMap();
        addMapping("ASCII", "ANSI_X3.4-1986", false);
        addMapping("ASCII", "ASCII", true);
        addMapping("ASCII", "CP367", false);
        addMapping("ASCII", "CSASCII", false);
        addMapping("ASCII", "IBM-367", false);
        addMapping("ASCII", "IBM367", false);
        addMapping("ASCII", "ISO-IR-6", false);
        addMapping("ASCII", "ISO646-US", false);
        addMapping("ASCII", "ISO_646.IRV:1991", false);
        addMapping("ASCII", "US", false);
        addMapping("ASCII", "US-ASCII", false);
        addMapping("BIG5", "BIG5", true);
        addMapping("BIG5", "CSBIG5", false);
        addMapping("CP037", "CP037", false);
        addMapping("CP037", "CSIBM037", false);
        addMapping("CP037", "EBCDIC-CP-CA", false);
        addMapping("CP037", "EBCDIC-CP-NL", false);
        addMapping("CP037", "EBCDIC-CP-US", true);
        addMapping("CP037", "EBCDIC-CP-WT", false);
        addMapping("CP037", "IBM-37", false);
        addMapping("CP037", "IBM037", false);
        addMapping("CP1026", "CP1026", false);
        addMapping("CP1026", "CSIBM1026", false);
        addMapping("CP1026", "IBM-1026", false);
        addMapping("CP1026", "IBM1026", true);
        addMapping("CP1047", "CP1047", false);
        addMapping("CP1047", "IBM-1047", false);
        addMapping("CP1047", "IBM1047", true);
        addMapping("CP1140", "CCSID01140", false);
        addMapping("CP1140", "CP01140", false);
        addMapping("CP1140", "IBM-1140", false);
        addMapping("CP1140", "IBM01140", true);
        addMapping("CP1141", "CCSID01141", false);
        addMapping("CP1141", "CP01141", false);
        addMapping("CP1141", "IBM-1141", false);
        addMapping("CP1141", "IBM01141", true);
        addMapping("CP1142", "CCSID01142", false);
        addMapping("CP1142", "CP01142", false);
        addMapping("CP1142", "IBM-1142", false);
        addMapping("CP1142", "IBM01142", true);
        addMapping("CP1143", "CCSID01143", false);
        addMapping("CP1143", "CP01143", false);
        addMapping("CP1143", "IBM-1143", false);
        addMapping("CP1143", "IBM01143", true);
        addMapping("CP1144", "CCSID01144", false);
        addMapping("CP1144", "CP01144", false);
        addMapping("CP1144", "IBM-1144", false);
        addMapping("CP1144", "IBM01144", true);
        addMapping("CP1145", "CCSID01145", false);
        addMapping("CP1145", "CP01145", false);
        addMapping("CP1145", "IBM-1145", false);
        addMapping("CP1145", "IBM01145", true);
        addMapping("CP1146", "CCSID01146", false);
        addMapping("CP1146", "CP01146", false);
        addMapping("CP1146", "IBM-1146", false);
        addMapping("CP1146", "IBM01146", true);
        addMapping("CP1147", "CCSID01147", false);
        addMapping("CP1147", "CP01147", false);
        addMapping("CP1147", "IBM-1147", false);
        addMapping("CP1147", "IBM01147", true);
        addMapping("CP1148", "CCSID01148", false);
        addMapping("CP1148", "CP01148", false);
        addMapping("CP1148", "IBM-1148", false);
        addMapping("CP1148", "IBM01148", true);
        addMapping("CP1149", "CCSID01149", false);
        addMapping("CP1149", "CP01149", false);
        addMapping("CP1149", "IBM-1149", false);
        addMapping("CP1149", "IBM01149", true);
        addMapping("CP1250", "WINDOWS-1250", true);
        addMapping("CP1251", "WINDOWS-1251", true);
        addMapping("CP1252", "WINDOWS-1252", true);
        addMapping("CP1253", "WINDOWS-1253", true);
        addMapping("CP1254", "WINDOWS-1254", true);
        addMapping("CP1255", "WINDOWS-1255", true);
        addMapping("CP1256", "WINDOWS-1256", true);
        addMapping("CP1257", "WINDOWS-1257", true);
        addMapping("CP1258", "WINDOWS-1258", true);
        addMapping("CP273", "CP273", false);
        addMapping("CP273", "CSIBM273", false);
        addMapping("CP273", "IBM-273", false);
        addMapping("CP273", "IBM273", true);
        addMapping("CP277", "CP277", false);
        addMapping("CP277", "CSIBM277", false);
        addMapping("CP277", "EBCDIC-CP-DK", true);
        addMapping("CP277", "EBCDIC-CP-NO", false);
        addMapping("CP277", "IBM-277", false);
        addMapping("CP277", "IBM277", false);
        addMapping("CP278", "CP278", false);
        addMapping("CP278", "CSIBM278", false);
        addMapping("CP278", "EBCDIC-CP-FI", true);
        addMapping("CP278", "EBCDIC-CP-SE", false);
        addMapping("CP278", "IBM-278", false);
        addMapping("CP278", "IBM278", false);
        addMapping("CP280", "CP280", false);
        addMapping("CP280", "CSIBM280", false);
        addMapping("CP280", "EBCDIC-CP-IT", true);
        addMapping("CP280", "IBM-280", false);
        addMapping("CP280", "IBM280", false);
        addMapping("CP284", "CP284", false);
        addMapping("CP284", "CSIBM284", false);
        addMapping("CP284", "EBCDIC-CP-ES", true);
        addMapping("CP284", "IBM-284", false);
        addMapping("CP284", "IBM284", false);
        addMapping("CP285", "CP285", false);
        addMapping("CP285", "CSIBM285", false);
        addMapping("CP285", "EBCDIC-CP-GB", true);
        addMapping("CP285", "IBM-285", false);
        addMapping("CP285", "IBM285", false);
        addMapping("CP290", "CP290", false);
        addMapping("CP290", "CSIBM290", false);
        addMapping("CP290", "EBCDIC-JP-KANA", true);
        addMapping("CP290", "IBM-290", false);
        addMapping("CP290", "IBM290", false);
        addMapping("CP297", "CP297", false);
        addMapping("CP297", "CSIBM297", false);
        addMapping("CP297", "EBCDIC-CP-FR", true);
        addMapping("CP297", "IBM-297", false);
        addMapping("CP297", "IBM297", false);
        addMapping("CP420", "CP420", false);
        addMapping("CP420", "CSIBM420", false);
        addMapping("CP420", "EBCDIC-CP-AR1", true);
        addMapping("CP420", "IBM-420", false);
        addMapping("CP420", "IBM420", false);
        addMapping("CP424", "CP424", false);
        addMapping("CP424", "CSIBM424", false);
        addMapping("CP424", "EBCDIC-CP-HE", true);
        addMapping("CP424", "IBM-424", false);
        addMapping("CP424", "IBM424", false);
        addMapping("CP437", "437", false);
        addMapping("CP437", "CP437", false);
        addMapping("CP437", "CSPC8CODEPAGE437", false);
        addMapping("CP437", "IBM-437", false);
        addMapping("CP437", "IBM437", true);
        addMapping("CP500", "CP500", false);
        addMapping("CP500", "CSIBM500", false);
        addMapping("CP500", "EBCDIC-CP-BE", false);
        addMapping("CP500", "EBCDIC-CP-CH", true);
        addMapping("CP500", "IBM-500", false);
        addMapping("CP500", "IBM500", false);
        addMapping("CP775", "CP775", false);
        addMapping("CP775", "CSPC775BALTIC", false);
        addMapping("CP775", "IBM-775", false);
        addMapping("CP775", "IBM775", true);
        addMapping("CP850", "850", false);
        addMapping("CP850", "CP850", false);
        addMapping("CP850", "CSPC850MULTILINGUAL", false);
        addMapping("CP850", "IBM-850", false);
        addMapping("CP850", "IBM850", true);
        addMapping("CP852", "852", false);
        addMapping("CP852", "CP852", false);
        addMapping("CP852", "CSPCP852", false);
        addMapping("CP852", "IBM-852", false);
        addMapping("CP852", "IBM852", true);
        addMapping("CP855", "855", false);
        addMapping("CP855", "CP855", false);
        addMapping("CP855", "CSIBM855", false);
        addMapping("CP855", "IBM-855", false);
        addMapping("CP855", "IBM855", true);
        addMapping("CP857", "857", false);
        addMapping("CP857", "CP857", false);
        addMapping("CP857", "CSIBM857", false);
        addMapping("CP857", "IBM-857", false);
        addMapping("CP857", "IBM857", true);
        addMapping("CP858", "CCSID00858", false);
        addMapping("CP858", "CP00858", false);
        addMapping("CP858", "IBM-858", false);
        addMapping("CP858", "IBM00858", true);
        addMapping("CP860", "860", false);
        addMapping("CP860", "CP860", false);
        addMapping("CP860", "CSIBM860", false);
        addMapping("CP860", "IBM-860", false);
        addMapping("CP860", "IBM860", true);
        addMapping("CP861", "861", false);
        addMapping("CP861", "CP-IS", false);
        addMapping("CP861", "CP861", false);
        addMapping("CP861", "CSIBM861", false);
        addMapping("CP861", "IBM-861", false);
        addMapping("CP861", "IBM861", true);
        addMapping("CP862", "862", false);
        addMapping("CP862", "CP862", false);
        addMapping("CP862", "CSPC862LATINHEBREW", false);
        addMapping("CP862", "IBM-862", false);
        addMapping("CP862", "IBM862", true);
        addMapping("CP863", "863", false);
        addMapping("CP863", "CP863", false);
        addMapping("CP863", "CSIBM863", false);
        addMapping("CP863", "IBM-863", false);
        addMapping("CP863", "IBM863", true);
        addMapping("CP864", "CP864", false);
        addMapping("CP864", "CSIBM864", false);
        addMapping("CP864", "IBM-864", false);
        addMapping("CP864", "IBM864", true);
        addMapping("CP865", "865", false);
        addMapping("CP865", "CP865", false);
        addMapping("CP865", "CSIBM865", false);
        addMapping("CP865", "IBM-865", false);
        addMapping("CP865", "IBM865", true);
        addMapping("CP866", "866", false);
        addMapping("CP866", "CP866", false);
        addMapping("CP866", "CSIBM866", false);
        addMapping("CP866", "IBM-866", false);
        addMapping("CP866", "IBM866", true);
        addMapping("CP868", "CP-AR", false);
        addMapping("CP868", "CP868", false);
        addMapping("CP868", "CSIBM868", false);
        addMapping("CP868", "IBM-868", false);
        addMapping("CP868", "IBM868", true);
        addMapping("CP869", "CP-GR", false);
        addMapping("CP869", "CP869", false);
        addMapping("CP869", "CSIBM869", false);
        addMapping("CP869", "IBM-869", false);
        addMapping("CP869", "IBM869", true);
        addMapping("CP870", "CP870", false);
        addMapping("CP870", "CSIBM870", false);
        addMapping("CP870", "EBCDIC-CP-ROECE", true);
        addMapping("CP870", "EBCDIC-CP-YU", false);
        addMapping("CP870", "IBM-870", false);
        addMapping("CP870", "IBM870", false);
        addMapping("CP871", "CP871", false);
        addMapping("CP871", "CSIBM871", false);
        addMapping("CP871", "EBCDIC-CP-IS", true);
        addMapping("CP871", "IBM-871", false);
        addMapping("CP871", "IBM871", false);
        addMapping("CP918", "CP918", false);
        addMapping("CP918", "CSIBM918", false);
        addMapping("CP918", "EBCDIC-CP-AR2", true);
        addMapping("CP918", "IBM-918", false);
        addMapping("CP918", "IBM918", false);
        addMapping("CP924", "CCSID00924", false);
        addMapping("CP924", "CP00924", false);
        addMapping("CP924", "EBCDIC-LATIN9--EURO", false);
        addMapping("CP924", "IBM-924", false);
        addMapping("CP924", "IBM00924", true);
        addMapping("CP936", "GBK", true);
        addMapping("CP936", "CP936", false);
        addMapping("CP936", "MS936", false);
        addMapping("CP936", "WINDOWS-936", false);
        addMapping("EUCJIS", "CSEUCPKDFMTJAPANESE", false);
        addMapping("EUCJIS", "EUC-JP", true);
        addMapping("EUCJIS", "EXTENDED_UNIX_CODE_PACKED_FORMAT_FOR_JAPANESE", false);
        addMapping("GB18030", "GB18030", true);
        addMapping("GB2312", "CSGB2312", false);
        addMapping("GB2312", "GB2312", true);
        addMapping("ISO2022CN", "ISO-2022-CN", true);
        addMapping("ISO2022KR", "CSISO2022KR", false);
        addMapping("ISO2022KR", "ISO-2022-KR", true);
        addMapping("ISO8859_1", "CP819", false);
        addMapping("ISO8859_1", "CSISOLATIN1", false);
        addMapping("ISO8859_1", "IBM-819", false);
        addMapping("ISO8859_1", "IBM819", false);
        addMapping("ISO8859_1", "ISO-8859-1", true);
        addMapping("ISO8859_1", "ISO-IR-100", false);
        addMapping("ISO8859_1", "ISO_8859-1", false);
        addMapping("ISO8859_1", "L1", false);
        addMapping("ISO8859_1", "LATIN1", false);
        addMapping("ISO8859_2", "CSISOLATIN2", false);
        addMapping("ISO8859_2", "ISO-8859-2", true);
        addMapping("ISO8859_2", "ISO-IR-101", false);
        addMapping("ISO8859_2", "ISO_8859-2", false);
        addMapping("ISO8859_2", "L2", false);
        addMapping("ISO8859_2", "LATIN2", false);
        addMapping("ISO8859_3", "CSISOLATIN3", false);
        addMapping("ISO8859_3", "ISO-8859-3", true);
        addMapping("ISO8859_3", "ISO-IR-109", false);
        addMapping("ISO8859_3", "ISO_8859-3", false);
        addMapping("ISO8859_3", "L3", false);
        addMapping("ISO8859_3", "LATIN3", false);
        addMapping("ISO8859_4", "CSISOLATIN4", false);
        addMapping("ISO8859_4", "ISO-8859-4", true);
        addMapping("ISO8859_4", "ISO-IR-110", false);
        addMapping("ISO8859_4", "ISO_8859-4", false);
        addMapping("ISO8859_4", "L4", false);
        addMapping("ISO8859_4", "LATIN4", false);
        addMapping("ISO8859_5", "CSISOLATINCYRILLIC", false);
        addMapping("ISO8859_5", "CYRILLIC", false);
        addMapping("ISO8859_5", "ISO-8859-5", true);
        addMapping("ISO8859_5", "ISO-IR-144", false);
        addMapping("ISO8859_5", "ISO_8859-5", false);
        addMapping("ISO8859_6", "ARABIC", false);
        addMapping("ISO8859_6", "ASMO-708", false);
        addMapping("ISO8859_6", "CSISOLATINARABIC", false);
        addMapping("ISO8859_6", "ECMA-114", false);
        addMapping("ISO8859_6", "ISO-8859-6", true);
        addMapping("ISO8859_6", "ISO-IR-127", false);
        addMapping("ISO8859_6", "ISO_8859-6", false);
        addMapping("ISO8859_7", "CSISOLATINGREEK", false);
        addMapping("ISO8859_7", "ECMA-118", false);
        addMapping("ISO8859_7", "ELOT_928", false);
        addMapping("ISO8859_7", "GREEK", false);
        addMapping("ISO8859_7", "GREEK8", false);
        addMapping("ISO8859_7", "ISO-8859-7", true);
        addMapping("ISO8859_7", "ISO-IR-126", false);
        addMapping("ISO8859_7", "ISO_8859-7", false);
        addMapping("ISO8859_8", "CSISOLATINHEBREW", false);
        addMapping("ISO8859_8", "HEBREW", false);
        addMapping("ISO8859_8", "ISO-8859-8", true);
        addMapping("ISO8859_8", "ISO-8859-8-I", false);
        addMapping("ISO8859_8", "ISO-IR-138", false);
        addMapping("ISO8859_8", "ISO_8859-8", false);
        addMapping("ISO8859_9", "CSISOLATIN5", false);
        addMapping("ISO8859_9", "ISO-8859-9", true);
        addMapping("ISO8859_9", "ISO-IR-148", false);
        addMapping("ISO8859_9", "ISO_8859-9", false);
        addMapping("ISO8859_9", "L5", false);
        addMapping("ISO8859_9", "LATIN5", false);
        addMapping("JIS", "CSISO2022JP", false);
        addMapping("JIS", "ISO-2022-JP", true);
        addMapping("JIS0201", "CSISO13JISC6220JP", false);
        addMapping("JIS0201", "X0201", true);
        addMapping("JIS0208", "CSISO87JISX0208", false);
        addMapping("JIS0208", "ISO-IR-87", false);
        addMapping("JIS0208", "X0208", true);
        addMapping("JIS0208", "X0208DBIJIS_X0208-1983", false);
        addMapping("JIS0212", "CSISO159JISX02121990", false);
        addMapping("JIS0212", "ISO-IR-159", true);
        addMapping("JIS0212", "X0212", false);
        addMapping("KOI8_R", "CSKOI8R", false);
        addMapping("KOI8_R", "KOI8-R", true);
        addMapping("KSC5601", "EUC-KR", true);
        addMapping("MS932", "CSWINDOWS31J", false);
        addMapping("MS932", "WINDOWS-31J", true);
        addMapping("SJIS", "CSSHIFTJIS", false);
        addMapping("SJIS", "MS_KANJI", false);
        addMapping("SJIS", "SHIFT_JIS", true);
        addMapping("TIS620", "TIS-620", true);
        addMapping("UNICODE", "UTF-16", true);
        addMapping(CharEncoding.UTF_16BE, CharEncoding.UTF_16BE, true);
        addMapping(CharEncoding.UTF_16BE, "UTF_16BE", false);
        addMapping("ISO-10646-UCS-2", "ISO-10646-UCS-2", true);
        addMapping("UTF-16LE", "UTF-16LE", true);
        addMapping("UTF-16LE", "UTF_16LE", false);
        addMapping(InternalZipConstants.CHARSET_UTF8, "UTF-8", true);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static String getJava2IANAMapping(String str) {
        String str2 = (String) _java_to_iana.get(str.toUpperCase());
        if (str2 != null) {
            return str2;
        }
        if (Charset.isSupported(str)) {
            try {
                return Charset.forName(str).name();
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static String getIANA2JavaMapping(String str) {
        String str2 = (String) _iana_to_java.get(str.toUpperCase());
        if (str2 != null) {
            return str2;
        }
        if (Charset.isSupported(str)) {
            return str;
        }
        return null;
    }

    private EncodingMap() {
    }

    private static final void addMapping(String str, String str2, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && _iana_to_java.containsKey(str2)) {
            throw new AssertionError();
        }
        if (!z2 && !str.toUpperCase().equals(str)) {
            throw new AssertionError();
        }
        if (!z2 && !str2.toUpperCase().equals(str2)) {
            throw new AssertionError();
        }
        _iana_to_java.put(str2, str);
        if (z) {
            if (!z2 && _java_to_iana.containsKey(str)) {
                throw new AssertionError();
            }
            _java_to_iana.put(str, str2);
        }
    }

    private static final boolean completeMappings() {
        HashMap hashMap = new HashMap();
        Iterator it = _iana_to_java.keySet().iterator();
        while (it.hasNext()) {
            hashMap.put(_iana_to_java.get(it.next()), null);
        }
        for (Object obj : hashMap.keySet()) {
            if (!$assertionsDisabled && !_java_to_iana.containsKey(obj)) {
                throw new AssertionError(obj);
            }
        }
        return true;
    }
}
