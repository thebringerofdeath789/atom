package org.apache.xmlbeans.impl.common;

import aavax.xml.namespace.QName;
import com.mapbox.api.directions.v5.models.StepManeuver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes5.dex */
public class NameUtil {
    public static final char AYAH = 1757;
    public static final char COLON = ':';
    private static final boolean DEBUG = false;
    private static final int DIGIT = 2;
    public static final char DOT = 183;
    public static final char ELHIZB = 1758;
    public static final char HYPHEN = '-';
    private static final String JAVA_NS_PREFIX = "java:";
    private static final String LANG_PREFIX = "java.";
    private static final int LOWER = 5;
    private static final int MARK = 3;
    private static final int NOCASE = 6;
    public static final char PERIOD = '.';
    private static final int PUNCT = 1;
    private static final int START = 0;
    public static final char TELEIA = 903;
    private static final int UPPER = 4;
    public static final char USCORE = '_';
    private static final Set javaWords = new HashSet(Arrays.asList("assert", "abstract", XmlErrorCodes.BOOLEAN, "break", "byte", "case", "catch", "char", JamXmlElements.CLASS, StringLookupFactory.KEY_CONST, StepManeuver.CONTINUE, "default", "do", XmlErrorCodes.DOUBLE, "else", "enum", "extends", "false", "final", "finally", XmlErrorCodes.FLOAT, "for", "goto", "if", "implements", "import", "instanceof", XmlErrorCodes.INT, JamXmlElements.INTERFACE, XmlErrorCodes.LONG, "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "threadsafe", "throw", "throws", "transient", BooleanUtils.TRUE, "try", "void", "volatile", "while"));
    private static final Set extraWords = new HashSet(Arrays.asList(Complex.DEFAULT_SUFFIX, "target", "org", "com"));
    private static final Set javaNames = new HashSet(Arrays.asList("CharSequence", "Cloneable", "Comparable", "Runnable", "Boolean", "Byte", "Character", "Class", "ClassLoader", "Compiler", "Double", "Float", "InheritableThreadLocal", "Integer", "Long", "Math", "Number", "Object", "Package", "Process", "Runtime", "RuntimePermission", "SecurityManager", "Short", "StackTraceElement", "StrictMath", "String", "StringBuffer", "System", "Thread", "ThreadGroup", "ThreadLocal", "Throwable", "Void", "ArithmeticException", "ArrayIndexOutOfBoundsException", "ArrayStoreException", "ClassCastException", "ClassNotFoundException", "CloneNotSupportedException", "Exception", "IllegalAccessException", "IllegalArgumentException", "IllegalMonitorStateException", "IllegalStateException", "IllegalThreadStateException", "IndexOutOfBoundsException", "InstantiationException", "InterruptedException", "NegativeArraySizeException", "NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException", "RuntimeException", "SecurityException", "StringIndexOutOfBoundsException", "UnsupportedOperationException", "AbstractMethodError", "AssertionError", "ClassCircularityError", "ClassFormatError", "Error", "ExceptionInInitializerError", "IllegalAccessError", "IncompatibleClassChangeError", "InstantiationError", "InternalError", "LinkageError", "NoClassDefFoundError", "NoSuchFieldError", "NoSuchMethodError", "OutOfMemoryError", "StackOverflowError", "ThreadDeath", "UnknownError", "UnsatisfiedLinkError", "UnsupportedClassVersionError", "VerifyError", "VirtualMachineError", "BigInteger", "BigDecimal", "Enum", "Date", "GDate", "GDuration", XmlErrorCodes.QNAME, "List", "XmlObject", "XmlCursor", "XmlBeans", "SchemaType"));

    private static boolean isLetter(int i) {
        return i == 4 || i == 5 || i == 6;
    }

    public static boolean isPunctuation(char c, boolean z) {
        return c == '-' || c == '.' || c == ':' || c == 183 || (c == '_' && !z) || c == 903 || c == 1757 || c == 1758;
    }

    private static boolean isUriAlphaChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isUriSchemeChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '.' || c == '+');
    }

    public static boolean isValidJavaIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        int length = str.length();
        if (length == 0 || javaWords.contains(str) || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < length; i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String getClassNameFromQName(QName qName) {
        return getClassNameFromQName(qName, false);
    }

    public static String getClassNameFromQName(QName qName, boolean z) {
        String upperCamelCase = upperCamelCase(qName.getLocalPart(), z);
        String packageFromNamespace = getPackageFromNamespace(qName.getNamespaceURI(), z);
        return packageFromNamespace != null ? new StringBuffer().append(packageFromNamespace).append(".").append(upperCamelCase).toString() : upperCamelCase;
    }

    public static String getNamespaceFromPackage(Class cls) {
        for (Class cls2 = cls; cls2.isArray(); cls2 = cls2.getComponentType()) {
        }
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return new StringBuffer().append(JAVA_NS_PREFIX).append(lastIndexOf < 0 ? "" : name.substring(0, lastIndexOf)).toString();
    }

    private static int findSchemeColon(String str) {
        int length = str.length();
        if (length == 0 || !isUriAlphaChar(str.charAt(0))) {
            return -1;
        }
        int i = 1;
        while (i < length && isUriSchemeChar(str.charAt(i))) {
            i++;
        }
        if (i == length || str.charAt(i) != ':') {
            return -1;
        }
        while (i < length && str.charAt(i) == ':') {
            i++;
        }
        return i - 1;
    }

    private static String jls77String(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isJavaIdentifierPart(stringBuffer.charAt(i)) || '$' == stringBuffer.charAt(i)) {
                stringBuffer.setCharAt(i, USCORE);
            }
        }
        if (stringBuffer.length() == 0 || !Character.isJavaIdentifierStart(stringBuffer.charAt(0))) {
            stringBuffer.insert(0, USCORE);
        }
        if (isJavaReservedWord(str)) {
            stringBuffer.append(USCORE);
        }
        return stringBuffer.toString();
    }

    private static List splitDNS(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        for (int lastIndexOf = str.lastIndexOf(46); lastIndexOf != -1; lastIndexOf--) {
            if (str.charAt(lastIndexOf) == '.') {
                arrayList.add(jls77String(str.substring(lastIndexOf + 1, length)));
                length = lastIndexOf;
            }
        }
        arrayList.add(jls77String(str.substring(0, length)));
        if (arrayList.size() >= 3 && ((String) arrayList.get(arrayList.size() - 1)).toLowerCase().equals("www")) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    private static String processFilename(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0) {
            return str;
        }
        int i = lastIndexOf + 1;
        return (i + 2 == str.length() || i + 3 == str.length() || str.substring(i).toLowerCase() == "html") ? str.substring(0, lastIndexOf) : str;
    }

    public static String getPackageFromNamespace(String str) {
        return getPackageFromNamespace(str, false);
    }

    public static String getPackageFromNamespace(String str, boolean z) {
        List list;
        if (str == null || str.length() == 0) {
            return "noNamespace";
        }
        int length = str.length();
        int findSchemeColon = findSchemeColon(str);
        if (findSchemeColon == length - 1) {
            list = new ArrayList();
            list.add(str.substring(0, findSchemeColon));
        } else if (findSchemeColon >= 0 && str.substring(0, findSchemeColon).equals(StringLookupFactory.KEY_JAVA)) {
            list = Arrays.asList(str.substring(findSchemeColon + 1).split("\\."));
        } else {
            ArrayList arrayList = new ArrayList();
            int i = findSchemeColon + 1;
            loop1: while (i < length) {
                while (str.charAt(i) == '/') {
                    i++;
                    if (i >= length) {
                        break loop1;
                    }
                }
                int i2 = i;
                while (str.charAt(i2) != '/' && (i2 = i2 + 1) < length) {
                }
                arrayList.add(str.substring(i, i2));
                i = i2;
            }
            if (arrayList.size() > 1) {
                arrayList.set(arrayList.size() - 1, processFilename((String) arrayList.get(arrayList.size() - 1)));
            }
            if (arrayList.size() > 0) {
                List splitDNS = splitDNS((String) arrayList.get(0));
                arrayList.remove(0);
                arrayList.addAll(0, splitDNS);
            }
            list = arrayList;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String nonJavaKeyword = nonJavaKeyword(lowerCamelCase((String) it.next(), z, true));
            if (nonJavaKeyword.length() > 0) {
                stringBuffer.append(nonJavaKeyword);
                stringBuffer.append('.');
            }
        }
        if (stringBuffer.length() == 0) {
            return "noNamespace";
        }
        if (z) {
            return stringBuffer.substring(0, stringBuffer.length() - 1).toLowerCase();
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    public static void main(String[] strArr) {
        for (String str : strArr) {
            System.out.println(upperCaseUnderbar(str));
        }
    }

    public static String upperCaseUnderbar(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        List splitWords = splitWords(str, false);
        int size = splitWords.size() - 1;
        if (size >= 0 && !Character.isJavaIdentifierStart(((String) splitWords.get(0)).charAt(0))) {
            stringBuffer.append("X_");
        }
        for (int i = 0; i < size; i++) {
            stringBuffer.append((String) splitWords.get(i));
            stringBuffer.append(USCORE);
        }
        if (size >= 0) {
            stringBuffer.append((String) splitWords.get(size));
        }
        int length = stringBuffer.length();
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.setCharAt(i2, Character.toUpperCase(stringBuffer.charAt(i2)));
        }
        return stringBuffer.toString();
    }

    public static String upperCamelCase(String str) {
        return upperCamelCase(str, false);
    }

    public static String upperCamelCase(String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        List splitWords = splitWords(str, z);
        if (splitWords.size() > 0) {
            if (!Character.isJavaIdentifierStart(((String) splitWords.get(0)).charAt(0))) {
                stringBuffer.append("X");
            }
            Iterator it = splitWords.iterator();
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
            }
        }
        return stringBuffer.toString();
    }

    public static String lowerCamelCase(String str) {
        return lowerCamelCase(str, false, true);
    }

    public static String lowerCamelCase(String str, boolean z, boolean z2) {
        StringBuffer stringBuffer = new StringBuffer();
        List splitWords = splitWords(str, z);
        if (splitWords.size() > 0) {
            String lowerCase = ((String) splitWords.get(0)).toLowerCase();
            if (!Character.isJavaIdentifierStart(lowerCase.charAt(0)) && z2) {
                stringBuffer.append("x");
            }
            stringBuffer.append(lowerCase);
            Iterator it = splitWords.iterator();
            it.next();
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
            }
        }
        return stringBuffer.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        if (str.length() == 0 || Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.setCharAt(0, Character.toUpperCase(stringBuffer.charAt(0)));
        return stringBuffer.toString();
    }

    private static void addCapped(List list, String str) {
        if (str.length() > 0) {
            list.add(upperCaseFirstLetter(str));
        }
    }

    public static List splitWords(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int charClass = getCharClass(str.charAt(i), z);
            if (i3 != 1 && charClass == 1) {
                addCapped(arrayList, str.substring(i2, i));
                do {
                    int charClass2 = getCharClass(str.charAt(i), z);
                    if (charClass2 == 1) {
                        i++;
                    } else {
                        i3 = charClass2;
                        i2 = i;
                    }
                } while (i < length);
                return arrayList;
            }
            if ((i3 == 2) != (charClass == 2) || ((i3 == 5 && charClass != 5) || isLetter(i3) != isLetter(charClass))) {
                addCapped(arrayList, str.substring(i2, i));
                i2 = i;
            } else if (i3 == 4 && charClass == 5 && i > i2 + 1) {
                int i4 = i - 1;
                addCapped(arrayList, str.substring(i2, i4));
                i2 = i4;
            }
            i3 = charClass;
            i++;
        }
        addCapped(arrayList, str.substring(i2));
        return arrayList;
    }

    public static int getCharClass(char c, boolean z) {
        if (isPunctuation(c, z)) {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        if (Character.isUpperCase(c)) {
            return 4;
        }
        if (Character.isLowerCase(c)) {
            return 5;
        }
        if (Character.isLetter(c)) {
            return 6;
        }
        return Character.isJavaIdentifierPart(c) ? 3 : 1;
    }

    public static String nonJavaKeyword(String str) {
        return isJavaReservedWord(str) ? new StringBuffer().append('x').append(str).toString() : str;
    }

    public static String nonExtraKeyword(String str) {
        return isExtraReservedWord(str, true) ? new StringBuffer().append(str).append("Value").toString() : str;
    }

    public static String nonJavaCommonClassName(String str) {
        return isJavaCommonClassName(str) ? new StringBuffer().append("X").append(str).toString() : str;
    }

    private static boolean isJavaReservedWord(String str) {
        return isJavaReservedWord(str, true);
    }

    private static boolean isJavaReservedWord(String str, boolean z) {
        if (z) {
            str = str.toLowerCase();
        }
        return javaWords.contains(str);
    }

    private static boolean isExtraReservedWord(String str, boolean z) {
        if (z) {
            str = str.toLowerCase();
        }
        return extraWords.contains(str);
    }

    public static boolean isJavaCommonClassName(String str) {
        return javaNames.contains(str);
    }
}
