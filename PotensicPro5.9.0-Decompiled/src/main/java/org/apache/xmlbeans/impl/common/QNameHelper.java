package org.apache.xmlbeans.impl.common;

import aavax.xml.namespace.QName;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.soap.SOAPConstants;
import org.apache.xmlbeans.xml.stream.XMLName;

/* loaded from: classes5.dex */
public class QNameHelper {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int MAX_NAME_LENGTH = 64;
    public static final String URI_SHA1_PREFIX = "URI_SHA_1_";
    private static final Map WELL_KNOWN_PREFIXES;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$QNameHelper;
    private static final char[] hexdigits;

    private static boolean isSafe(int i) {
        if (i >= 97 && i <= 122) {
            return true;
        }
        if (i < 65 || i > 90) {
            return i >= 48 && i <= 57;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static {
        if (class$org$apache$xmlbeans$impl$common$QNameHelper == null) {
            class$org$apache$xmlbeans$impl$common$QNameHelper = class$("org.apache.xmlbeans.impl.common.QNameHelper");
        }
        $assertionsDisabled = true;
        WELL_KNOWN_PREFIXES = buildWKP();
        hexdigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static XMLName getXMLName(QName qName) {
        if (qName == null) {
            return null;
        }
        return XMLNameHelper.forLNS(qName.getLocalPart(), qName.getNamespaceURI());
    }

    public static QName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new QName(str2, str);
    }

    public static QName forLN(String str) {
        return new QName("", str);
    }

    public static QName forPretty(String str, int i) {
        int indexOf = str.indexOf(64, i);
        if (indexOf < 0) {
            return new QName("", str.substring(i));
        }
        return new QName(str.substring(indexOf + 1), str.substring(i, indexOf));
    }

    public static String pretty(QName qName) {
        if (qName == null) {
            return "null";
        }
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        return new StringBuffer().append(qName.getLocalPart()).append("@").append(qName.getNamespaceURI()).toString();
    }

    public static String hexsafe(String str) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (isSafe(charAt)) {
                stringBuffer.append(charAt);
            } else {
                try {
                    byte[] bytes = str.substring(i, i + 1).getBytes("UTF-8");
                    for (int i2 = 0; i2 < bytes.length; i2++) {
                        stringBuffer.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        stringBuffer.append(cArr[(bytes[i2] >> 4) & 15]);
                        stringBuffer.append(cArr[bytes[i2] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    stringBuffer.append("_BAD_UTF8_CHAR");
                }
            }
        }
        if (stringBuffer.length() <= 64) {
            return stringBuffer.toString();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                bArr = new byte[0];
            }
            byte[] digest = messageDigest.digest(bArr);
            if (!$assertionsDisabled && digest.length != 20) {
                throw new AssertionError();
            }
            StringBuffer stringBuffer2 = new StringBuffer(URI_SHA1_PREFIX);
            for (int i3 = 0; i3 < digest.length; i3++) {
                char[] cArr2 = hexdigits;
                stringBuffer2.append(cArr2[(digest[i3] >> 4) & 15]);
                stringBuffer2.append(cArr2[digest[i3] & 15]);
            }
            return stringBuffer2.toString();
        } catch (NoSuchAlgorithmException unused3) {
            throw new IllegalStateException("Using in a JDK without an SHA implementation");
        }
    }

    public static String hexsafedir(QName qName) {
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return new StringBuffer().append("_nons/").append(hexsafe(qName.getLocalPart())).toString();
        }
        return new StringBuffer().append(hexsafe(qName.getNamespaceURI())).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(hexsafe(qName.getLocalPart())).toString();
    }

    private static Map buildWKP() {
        HashMap hashMap = new HashMap();
        hashMap.put("http://www.w3.org/XML/1998/namespace", "xml");
        hashMap.put("http://www.w3.org/2001/XMLSchema", "xs");
        hashMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        hashMap.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
        hashMap.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
        hashMap.put(SOAPConstants.URI_NS_SOAP_ENVELOPE, "soapenv");
        return Collections.unmodifiableMap(hashMap);
    }

    public static String readable(SchemaType schemaType) {
        return readable(schemaType, WELL_KNOWN_PREFIXES);
    }

    public static String readable(SchemaType schemaType, Map map) {
        if (schemaType.getName() != null) {
            return readable(schemaType.getName(), map);
        }
        if (schemaType.isAttributeType()) {
            return new StringBuffer().append("attribute type ").append(readable(schemaType.getAttributeTypeAttributeName(), map)).toString();
        }
        if (schemaType.isDocumentType()) {
            return new StringBuffer().append("document type ").append(readable(schemaType.getDocumentElementName(), map)).toString();
        }
        if (schemaType.isNoType() || schemaType.getOuterType() == null) {
            return "invalid type";
        }
        SchemaType outerType = schemaType.getOuterType();
        SchemaField containerField = schemaType.getContainerField();
        if (outerType.isAttributeType()) {
            return new StringBuffer().append("type of attribute ").append(readable(containerField.getName(), map)).toString();
        }
        if (outerType.isDocumentType()) {
            return new StringBuffer().append("type of element ").append(readable(containerField.getName(), map)).toString();
        }
        if (containerField != null) {
            if (containerField.isAttribute()) {
                return new StringBuffer().append("type of ").append(containerField.getName().getLocalPart()).append(" attribute in ").append(readable(outerType, map)).toString();
            }
            return new StringBuffer().append("type of ").append(containerField.getName().getLocalPart()).append(" element in ").append(readable(outerType, map)).toString();
        }
        if (outerType.getBaseType() == schemaType) {
            return new StringBuffer().append("base type of ").append(readable(outerType, map)).toString();
        }
        if (outerType.getSimpleVariety() == 3) {
            return new StringBuffer().append("item type of ").append(readable(outerType, map)).toString();
        }
        if (outerType.getSimpleVariety() == 2) {
            return new StringBuffer().append("member type ").append(schemaType.getAnonymousUnionMemberOrdinal()).append(" of ").append(readable(outerType, map)).toString();
        }
        return new StringBuffer().append("inner type in ").append(readable(outerType, map)).toString();
    }

    public static String readable(QName qName) {
        return readable(qName, WELL_KNOWN_PREFIXES);
    }

    public static String readable(QName qName, Map map) {
        if (qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        String str = (String) map.get(qName.getNamespaceURI());
        if (str != null) {
            return new StringBuffer().append(str).append(":").append(qName.getLocalPart()).toString();
        }
        return new StringBuffer().append(qName.getLocalPart()).append(" in namespace ").append(qName.getNamespaceURI()).toString();
    }

    public static String suggestPrefix(String str) {
        String str2 = (String) WELL_KNOWN_PREFIXES.get(str);
        if (str2 != null) {
            return str2;
        }
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0 && lastIndexOf == str.length() - 1) {
            lastIndexOf = str.lastIndexOf(47, lastIndexOf - 1);
            length = lastIndexOf;
        }
        int i = lastIndexOf + 1;
        if (str.startsWith("www.", i)) {
            i += 4;
        }
        while (i < length && !XMLChar.isNCNameStart(str.charAt(i))) {
            i++;
        }
        for (int i2 = i + 1; i2 < length; i2++) {
            if (!XMLChar.isNCName(str.charAt(i2)) || !Character.isLetterOrDigit(str.charAt(i2))) {
                length = i2;
                break;
            }
        }
        int i3 = i + 3;
        if (str.length() >= i3 && startsWithXml(str, i)) {
            return str.length() >= i + 4 ? new StringBuffer().append("x").append(Character.toLowerCase(str.charAt(i3))).toString() : "ns";
        }
        if (length - i > 4) {
            length = (!isVowel(str.charAt(i + 2)) || isVowel(str.charAt(i3))) ? i3 : i + 4;
        }
        return length - i == 0 ? "ns" : str.substring(i, length).toLowerCase();
    }

    private static boolean startsWithXml(String str, int i) {
        if (str.length() < i + 3) {
            return false;
        }
        if (str.charAt(i) != 'X' && str.charAt(i) != 'x') {
            return false;
        }
        int i2 = i + 1;
        if (str.charAt(i2) != 'M' && str.charAt(i2) != 'm') {
            return false;
        }
        int i3 = i + 2;
        return str.charAt(i3) == 'L' || str.charAt(i3) == 'l';
    }

    public static String namespace(SchemaType schemaType) {
        while (schemaType != null) {
            if (schemaType.getName() != null) {
                return schemaType.getName().getNamespaceURI();
            }
            if (schemaType.getContainerField() != null && schemaType.getContainerField().getName().getNamespaceURI().length() > 0) {
                return schemaType.getContainerField().getName().getNamespaceURI();
            }
            schemaType = schemaType.getOuterType();
        }
        return "";
    }

    public static String getLocalPart(String str) {
        int indexOf = str.indexOf(58);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    public static String getPrefixPart(String str) {
        int indexOf = str.indexOf(58);
        return indexOf >= 0 ? str.substring(0, indexOf) : "";
    }
}
