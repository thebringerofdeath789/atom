package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.opencsv.ICSVParser;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public final class SchemaTypeCodePrinter implements SchemaCodePrinter {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int ADD_NEW_VALUE = 3;
    static final int INDENT_INCREMENT = 4;
    public static final String INDEX_CLASSNAME = "TypeSystemHolder";
    static final String LINE_SEPARATOR;
    static final String MAX_SPACES = "                                        ";
    private static final int NOTHING = 1;
    private static final int THROW_EXCEPTION = 4;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeCodePrinter;
    int _indent = 0;
    boolean _useJava15;
    Writer _writer;

    static boolean isJavaPrimitive(int i) {
        return i >= 1 && i <= 7;
    }

    static String shortIndexClassForSystem(SchemaTypeSystem schemaTypeSystem) {
        return INDEX_CLASSNAME;
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem) throws IOException {
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeCodePrinter == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeCodePrinter = class$("org.apache.xmlbeans.impl.schema.SchemaTypeCodePrinter");
        }
        $assertionsDisabled = true;
        LINE_SEPARATOR = SystemProperties.getProperty("line.separator") == null ? "\n" : SystemProperties.getProperty("line.separator");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void printTypeImpl(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        getPrinter(xmlOptions).printTypeImpl(writer, schemaType);
    }

    public static void printType(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        getPrinter(xmlOptions).printType(writer, schemaType);
    }

    public static void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem, XmlOptions xmlOptions) throws IOException {
        getPrinter(xmlOptions).printLoader(writer, schemaTypeSystem);
    }

    private static SchemaCodePrinter getPrinter(XmlOptions xmlOptions) {
        Object safeGet = XmlOptions.safeGet(xmlOptions, XmlOptions.SCHEMA_CODE_PRINTER);
        if (safeGet == null || !(safeGet instanceof SchemaCodePrinter)) {
            safeGet = new SchemaTypeCodePrinter(xmlOptions);
        }
        return (SchemaCodePrinter) safeGet;
    }

    public SchemaTypeCodePrinter(XmlOptions xmlOptions) {
        String str = (xmlOptions == null || !XmlOptions.hasOption(xmlOptions, XmlOptions.GENERATE_JAVA_VERSION)) ? null : (String) xmlOptions.get(XmlOptions.GENERATE_JAVA_VERSION);
        this._useJava15 = XmlOptions.GENERATE_JAVA_15.equals(str == null ? XmlOptions.GENERATE_JAVA_14 : str);
    }

    void indent() {
        this._indent += 4;
    }

    void outdent() {
        this._indent -= 4;
    }

    String encodeString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append('\"');
            } else if (charAt == '\\') {
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
            } else if (charAt == '\r') {
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append('r');
            } else if (charAt == '\n') {
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append('n');
            } else if (charAt == '\t') {
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append('t');
            } else {
                stringBuffer.append(charAt);
            }
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    void emit(String str) throws IOException {
        int i = this._indent;
        if (i > 20) {
            i = (i / 2) + 10;
        }
        if (i > 40) {
            i = 40;
        }
        this._writer.write(MAX_SPACES.substring(0, i));
        try {
            this._writer.write(str);
        } catch (CharacterCodingException unused) {
            this._writer.write(makeSafe(str));
        }
        this._writer.write(LINE_SEPARATOR);
    }

    private static String makeSafe(String str) {
        Charset forName = Charset.forName(System.getProperty("file.encoding"));
        if (forName == null) {
            throw new IllegalStateException("Default character set is null!");
        }
        CharsetEncoder newEncoder = forName.newEncoder();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length() && newEncoder.canEncode(str.charAt(i))) {
            i++;
        }
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (newEncoder.canEncode(charAt)) {
                stringBuffer.append(charAt);
            } else {
                String hexString = Integer.toHexString(charAt);
                int length = hexString.length();
                if (length == 1) {
                    stringBuffer.append("\\u000").append(hexString);
                } else if (length == 2) {
                    stringBuffer.append("\\u00").append(hexString);
                } else if (length == 3) {
                    stringBuffer.append("\\u0").append(hexString);
                } else if (length == 4) {
                    stringBuffer.append("\\u").append(hexString);
                } else {
                    throw new IllegalStateException();
                }
            }
            i++;
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printType(Writer writer, SchemaType schemaType) throws IOException {
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, true);
        emit("");
        printInnerType(schemaType, schemaType.getTypeSystem());
        this._writer.flush();
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printTypeImpl(Writer writer, SchemaType schemaType) throws IOException {
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, false);
        printInnerTypeImpl(schemaType, schemaType.getTypeSystem(), false);
    }

    String findJavaType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType.getFullJavaName();
    }

    static String prettyQName(QName qName) {
        String localPart = qName.getLocalPart();
        return qName.getNamespaceURI() != null ? new StringBuffer().append(localPart).append("(@").append(qName.getNamespaceURI()).append(")").toString() : localPart;
    }

    void printInnerTypeJavaDoc(SchemaType schemaType) throws IOException {
        QName name = schemaType.getName();
        if (name == null) {
            if (schemaType.isDocumentType()) {
                name = schemaType.getDocumentElementName();
            } else if (schemaType.isAttributeType()) {
                name = schemaType.getAttributeTypeAttributeName();
            } else if (schemaType.getContainerField() != null) {
                name = schemaType.getContainerField().getName();
            }
        }
        emit("/**");
        if (schemaType.isDocumentType()) {
            emit(new StringBuffer().append(" * A document containing one ").append(prettyQName(name)).append(" element.").toString());
        } else if (schemaType.isAttributeType()) {
            emit(new StringBuffer().append(" * A document containing one ").append(prettyQName(name)).append(" attribute.").toString());
        } else if (name != null) {
            emit(new StringBuffer().append(" * An XML ").append(prettyQName(name)).append(".").toString());
        } else {
            emit(" * An anonymous inner XML type.");
        }
        emit(" *");
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            emit(" * This is a complex type.");
        } else if (simpleVariety == 1) {
            emit(new StringBuffer().append(" * This is an atomic type that is a restriction of ").append(getFullJavaName(schemaType)).append(".").toString());
        } else if (simpleVariety == 2) {
            emit(" * This is a union type. Instances are of one of the following types:");
            for (SchemaType schemaType2 : schemaType.getUnionConstituentTypes()) {
                emit(new StringBuffer().append(" *     ").append(schemaType2.getFullJavaName()).toString());
            }
        } else if (simpleVariety == 3) {
            emit(new StringBuffer().append(" * This is a list type whose items are ").append(schemaType.getListItemType().getFullJavaName()).append(".").toString());
        }
        emit(" */");
    }

    private String getFullJavaName(SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
        String fullJavaName = schemaTypeImpl.getFullJavaName();
        while (schemaTypeImpl.isRedefinition()) {
            fullJavaName = schemaTypeImpl.getFullJavaName();
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        }
        return fullJavaName;
    }

    private String getUserTypeStaticHandlerMethod(boolean z, SchemaTypeImpl schemaTypeImpl) {
        String stringBuffer;
        String localPart = schemaTypeImpl.getName().getLocalPart();
        if (localPart.length() < 2) {
            stringBuffer = localPart.toUpperCase();
        } else {
            stringBuffer = new StringBuffer().append(localPart.substring(0, 1).toUpperCase()).append(localPart.substring(1)).toString();
        }
        if (z) {
            return new StringBuffer().append(schemaTypeImpl.getUserTypeHandlerName()).append(".encode").append(stringBuffer).toString();
        }
        return new StringBuffer().append(schemaTypeImpl.getUserTypeHandlerName()).append(".decode").append(stringBuffer).toString();
    }

    public static String indexClassForSystem(SchemaTypeSystem schemaTypeSystem) {
        return new StringBuffer().append(schemaTypeSystem.getName()).append(".").append(INDEX_CLASSNAME).toString();
    }

    void printStaticTypeDeclaration(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        String shortJavaName = schemaType.getShortJavaName();
        emit("public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)");
        indent();
        emit(new StringBuffer().append("org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(").append(shortJavaName).append(".class.getClassLoader(), \"").append(schemaTypeSystem.getName()).append("\")").append(".resolveHandle(\"").append(((SchemaTypeSystemImpl) schemaTypeSystem).handleForType(schemaType)).append("\");").toString());
        outdent();
    }

    void printInnerType(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        emit("");
        printInnerTypeJavaDoc(schemaType);
        startInterface(schemaType);
        printStaticTypeDeclaration(schemaType, schemaTypeSystem);
        if (schemaType.isSimpleType()) {
            if (schemaType.hasStringEnumValues()) {
                printStringEnumeration(schemaType);
            }
        } else {
            if (schemaType.getContentType() == 2 && schemaType.hasStringEnumValues()) {
                printStringEnumeration(schemaType);
            }
            for (SchemaProperty schemaProperty : getDerivedProperties(schemaType)) {
                printPropertyGetters(schemaProperty.getName(), schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), xmlTypeForProperty(schemaProperty), schemaProperty.hasNillable() != 0, schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton());
                if (!schemaProperty.isReadOnly()) {
                    printPropertySetters(schemaProperty.getName(), schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), xmlTypeForProperty(schemaProperty), schemaProperty.hasNillable() != 0, schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton());
                }
            }
        }
        printNestedInnerTypes(schemaType, schemaTypeSystem);
        printFactory(schemaType);
        endBlock();
    }

    void printFactory(SchemaType schemaType) throws IOException {
        boolean z = !schemaType.isAnonymousType() || schemaType.isDocumentType() || schemaType.isAttributeType();
        String replace = schemaType.getFullJavaName().replace('$', '.');
        emit("");
        emit("/**");
        emit(" * A factory class with static methods for creating instances");
        emit(" * of this type.");
        emit(" */");
        emit("");
        emit("public static final class Factory");
        emit("{");
        indent();
        if (schemaType.isSimpleType()) {
            emit(new StringBuffer().append("public static ").append(replace).append(" newValue(java.lang.Object obj) {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") type.newValue( obj ); }").toString());
            emit("");
        }
        if (schemaType.isAbstract()) {
            emit("/** @deprecated No need to be able to create instances of abstract types */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
        }
        emit(new StringBuffer().append("public static ").append(replace).append(" newInstance() {").toString());
        emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }").toString());
        emit("");
        if (schemaType.isAbstract()) {
            emit("/** @deprecated No need to be able to create instances of abstract types */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
        }
        emit(new StringBuffer().append("public static ").append(replace).append(" newInstance(org.apache.xmlbeans.XmlOptions options) {").toString());
        emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }").toString());
        emit("");
        if (z) {
            emit("/** @param xmlAsString the string value to parse */");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }").toString());
            emit("");
            emit("/** @param file the file from which to load an xml document */");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(aavax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(aavax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }").toString());
            emit("");
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }").toString());
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }").toString());
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit(new StringBuffer().append("public static ").append(replace).append(" parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {").toString());
            emit(new StringBuffer().append("  return (").append(replace).append(") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }").toString());
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
            emit("  return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }");
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
            emit("  return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }");
            emit("");
        }
        emit("private Factory() { } // No instance of this class allowed");
        outdent();
        emit(StringSubstitutor.DEFAULT_VAR_END);
    }

    void printNestedInnerTypes(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
            for (int i = 0; i < anonymousTypes.length; i++) {
                if (anonymousTypes[i].isSkippedAnonymousType()) {
                    printNestedInnerTypes(anonymousTypes[i], schemaTypeSystem);
                } else {
                    printInnerType(anonymousTypes[i], schemaTypeSystem);
                }
            }
            if (!z) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }

    void printTopComment(SchemaType schemaType) throws IOException {
        emit("/*");
        if (schemaType.getName() != null) {
            emit(new StringBuffer().append(" * XML Type:  ").append(schemaType.getName().getLocalPart()).toString());
            emit(new StringBuffer().append(" * Namespace: ").append(schemaType.getName().getNamespaceURI()).toString());
        } else {
            QName qName = null;
            if (schemaType.isDocumentType()) {
                qName = schemaType.getDocumentElementName();
                emit(" * An XML document type.");
            } else if (schemaType.isAttributeType()) {
                qName = schemaType.getAttributeTypeAttributeName();
                emit(" * An XML attribute type.");
            } else if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && qName == null) {
                throw new AssertionError();
            }
            emit(new StringBuffer().append(" * Localname: ").append(qName.getLocalPart()).toString());
            emit(new StringBuffer().append(" * Namespace: ").append(qName.getNamespaceURI()).toString());
        }
        emit(new StringBuffer().append(" * Java type: ").append(schemaType.getFullJavaName()).toString());
        emit(" *");
        emit(" * Automatically generated - do not modify.");
        emit(" */");
    }

    void printPackage(SchemaType schemaType, boolean z) throws IOException {
        String fullJavaImplName;
        if (z) {
            fullJavaImplName = schemaType.getFullJavaName();
        } else {
            fullJavaImplName = schemaType.getFullJavaImplName();
        }
        int lastIndexOf = fullJavaImplName.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return;
        }
        emit(new StringBuffer().append("package ").append(fullJavaImplName.substring(0, lastIndexOf)).append(";").toString());
    }

    void startInterface(SchemaType schemaType) throws IOException {
        String shortJavaName = schemaType.getShortJavaName();
        emit(new StringBuffer().append("public interface ").append(shortJavaName).append(" extends ").append(findJavaType(schemaType.getBaseType())).append(getExtensionInterfaces(schemaType)).toString());
        emit("{");
        indent();
        emitSpecializedAccessors(schemaType);
    }

    private static String getExtensionInterfaces(SchemaType schemaType) {
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        InterfaceExtension[] interfaceExtensions = impl.getInterfaceExtensions();
        if (interfaceExtensions != null) {
            for (InterfaceExtension interfaceExtension : interfaceExtensions) {
                stringBuffer.append(new StringBuffer().append(", ").append(interfaceExtension.getInterface()).toString());
            }
        }
        return stringBuffer.toString();
    }

    private static SchemaTypeImpl getImpl(SchemaType schemaType) {
        if (schemaType instanceof SchemaTypeImpl) {
            return (SchemaTypeImpl) schemaType;
        }
        return null;
    }

    private void emitSpecializedAccessors(SchemaType schemaType) throws IOException {
        int decimalSize;
        if (schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == 11 && ((decimalSize = schemaType.getDecimalSize()) != schemaType.getBaseType().getDecimalSize() || schemaType.getBaseType().getFullJavaName() == null)) {
            if (decimalSize == 1000000) {
                emit("java.math.BigInteger getBigIntegerValue();");
                emit("void setBigIntegerValue(java.math.BigInteger bi);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("java.math.BigInteger bigIntegerValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(java.math.BigInteger bi);");
            } else if (decimalSize == 64) {
                emit("long getLongValue();");
                emit("void setLongValue(long l);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("long longValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(long l);");
            } else if (decimalSize == 32) {
                emit("int getIntValue();");
                emit("void setIntValue(int i);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("int intValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(int i);");
            } else if (decimalSize == 16) {
                emit("short getShortValue();");
                emit("void setShortValue(short s);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("short shortValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(short s);");
            } else if (decimalSize == 8) {
                emit("byte getByteValue();");
                emit("void setByteValue(byte b);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("byte byteValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(byte b);");
            }
        }
        if (schemaType.getSimpleVariety() == 2) {
            emit("java.lang.Object getObjectValue();");
            emit("void setObjectValue(java.lang.Object val);");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("java.lang.Object objectValue();");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("void objectSet(java.lang.Object val);");
            emit("org.apache.xmlbeans.SchemaType instanceType();");
            SchemaType unionCommonBaseType = schemaType.getUnionCommonBaseType();
            if (unionCommonBaseType != null) {
                unionCommonBaseType.getSimpleVariety();
            }
            emitSpecializedAccessors(unionCommonBaseType);
        }
        if (schemaType.getSimpleVariety() == 3) {
            emit("java.util.List getListValue();");
            emit("java.util.List xgetListValue();");
            emit("void setListValue(java.util.List list);");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("java.util.List listValue();");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("java.util.List xlistValue();");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("void set(java.util.List list);");
        }
    }

    void startBlock() throws IOException {
        emit("{");
        indent();
    }

    void endBlock() throws IOException {
        outdent();
        emit(StringSubstitutor.DEFAULT_VAR_END);
    }

    void printJavaDoc(String str) throws IOException {
        emit("");
        emit("/**");
        emit(new StringBuffer().append(" * ").append(str).toString());
        emit(" */");
    }

    void printShortJavaDoc(String str) throws IOException {
        emit(new StringBuffer().append("/** ").append(str).append(" */").toString());
    }

    public static String javaStringEscape(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n' || charAt == '\r' || charAt == '\"' || charAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 == '\n') {
                        stringBuffer.append("\\n");
                    } else if (charAt2 == '\r') {
                        stringBuffer.append("\\r");
                    } else if (charAt2 == '\"') {
                        stringBuffer.append("\\\"");
                    } else if (charAt2 != '\\') {
                        stringBuffer.append(charAt2);
                    } else {
                        stringBuffer.append("\\\\");
                    }
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    void printStringEnumeration(SchemaType schemaType) throws IOException {
        String fullJavaName = schemaType.getBaseEnumType().getFullJavaName();
        boolean hasBase = hasBase(schemaType);
        if (!hasBase) {
            emit("");
            emit("org.apache.xmlbeans.StringEnumAbstractBase enumValue();");
            emit("void set(org.apache.xmlbeans.StringEnumAbstractBase e);");
        }
        emit("");
        SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < stringEnumEntries.length; i++) {
            String string = stringEnumEntries[i].getString();
            if (hashSet.contains(string)) {
                hashSet2.add(string);
            } else {
                hashSet.add(string);
                String enumName = stringEnumEntries[i].getEnumName();
                if (hasBase) {
                    emit(new StringBuffer().append("static final ").append(fullJavaName).append(".Enum ").append(enumName).append(" = ").append(fullJavaName).append(".").append(enumName).append(";").toString());
                } else {
                    emit(new StringBuffer().append("static final Enum ").append(enumName).append(" = Enum.forString(\"").append(javaStringEscape(string)).append("\");").toString());
                }
            }
        }
        emit("");
        for (int i2 = 0; i2 < stringEnumEntries.length; i2++) {
            if (!hashSet2.contains(stringEnumEntries[i2].getString())) {
                String stringBuffer = new StringBuffer().append("INT_").append(stringEnumEntries[i2].getEnumName()).toString();
                if (hasBase) {
                    emit(new StringBuffer().append("static final int ").append(stringBuffer).append(" = ").append(fullJavaName).append(".").append(stringBuffer).append(";").toString());
                } else {
                    emit(new StringBuffer().append("static final int ").append(stringBuffer).append(" = Enum.").append(stringBuffer).append(";").toString());
                }
            }
        }
        if (hasBase) {
            return;
        }
        emit("");
        emit("/**");
        emit(new StringBuffer().append(" * Enumeration value class for ").append(fullJavaName).append(".").toString());
        emit(" * These enum values can be used as follows:");
        emit(" * <pre>");
        emit(" * enum.toString(); // returns the string value of the enum");
        emit(" * enum.intValue(); // returns an int value, useful for switches");
        if (stringEnumEntries.length > 0) {
            emit(new StringBuffer().append(" * // e.g., case Enum.INT_").append(stringEnumEntries[0].getEnumName()).toString());
        }
        emit(" * Enum.forString(s); // returns the enum value for a string");
        emit(" * Enum.forInt(i); // returns the enum value for an int");
        emit(" * </pre>");
        emit(" * Enumeration objects are immutable singleton objects that");
        emit(" * can be compared using == object equality. They have no");
        emit(" * public constructor. See the constants defined within this");
        emit(" * class for all the valid values.");
        emit(" */");
        emit("static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase");
        emit("{");
        indent();
        emit("/**");
        emit(" * Returns the enum value for a string, or null if none.");
        emit(" */");
        emit("public static Enum forString(java.lang.String s)");
        emit("    { return (Enum)table.forString(s); }");
        emit("/**");
        emit(" * Returns the enum value corresponding to an int, or null if none.");
        emit(" */");
        emit("public static Enum forInt(int i)");
        emit("    { return (Enum)table.forInt(i); }");
        emit("");
        emit("private Enum(java.lang.String s, int i)");
        emit("    { super(s, i); }");
        emit("");
        for (int i3 = 0; i3 < stringEnumEntries.length; i3++) {
            emit(new StringBuffer().append("static final int ").append(new StringBuffer().append("INT_").append(stringEnumEntries[i3].getEnumName()).toString()).append(" = ").append(stringEnumEntries[i3].getIntValue()).append(";").toString());
        }
        emit("");
        emit("public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =");
        emit("    new org.apache.xmlbeans.StringEnumAbstractBase.Table");
        emit("(");
        indent();
        emit("new Enum[]");
        emit("{");
        indent();
        for (int i4 = 0; i4 < stringEnumEntries.length; i4++) {
            emit(new StringBuffer().append("new Enum(\"").append(javaStringEscape(stringEnumEntries[i4].getString())).append("\", ").append(new StringBuffer().append("INT_").append(stringEnumEntries[i4].getEnumName()).toString()).append("),").toString());
        }
        outdent();
        emit(StringSubstitutor.DEFAULT_VAR_END);
        outdent();
        emit(");");
        emit("private static final long serialVersionUID = 1L;");
        emit("private java.lang.Object readResolve() { return forInt(intValue()); } ");
        outdent();
        emit(StringSubstitutor.DEFAULT_VAR_END);
    }

    private boolean hasBase(SchemaType schemaType) {
        SchemaType baseEnumType = schemaType.getBaseEnumType();
        if (baseEnumType.isAnonymousType() && baseEnumType.isSkippedAnonymousType()) {
            if (schemaType.getContentBasedOnType() != null) {
                if (schemaType.getContentBasedOnType().getBaseType() != baseEnumType) {
                    return true;
                }
            } else if (schemaType.getBaseType() != baseEnumType) {
                return true;
            }
        } else if (baseEnumType != schemaType) {
            return true;
        }
        return false;
    }

    String xmlTypeForProperty(SchemaProperty schemaProperty) {
        return findJavaType(schemaProperty.javaBasedOnType()).replace('$', '.');
    }

    static boolean xmlTypeForPropertyIsUnion(SchemaProperty schemaProperty) {
        SchemaType javaBasedOnType = schemaProperty.javaBasedOnType();
        return javaBasedOnType.isSimpleType() && javaBasedOnType.getSimpleVariety() == 2;
    }

    static String javaWrappedType(int i) {
        switch (i) {
            case 1:
                return "java.lang.Boolean";
            case 2:
                return "java.lang.Float";
            case 3:
                return "java.lang.Double";
            case 4:
                return "java.lang.Byte";
            case 5:
                return "java.lang.Short";
            case 6:
                return "java.lang.Integer";
            case 7:
                return "java.lang.Long";
            default:
                if ($assertionsDisabled) {
                    throw new IllegalStateException();
                }
                throw new AssertionError();
        }
    }

    String javaTypeForProperty(SchemaProperty schemaProperty) {
        if (schemaProperty.getJavaTypeCode() == 0) {
            return findJavaType(schemaProperty.javaBasedOnType()).replace('$', '.');
        }
        if (schemaProperty.getJavaTypeCode() == 20) {
            return ((SchemaTypeImpl) schemaProperty.getType()).getUserTypeName();
        }
        switch (schemaProperty.getJavaTypeCode()) {
            case 1:
                return XmlErrorCodes.BOOLEAN;
            case 2:
                return XmlErrorCodes.FLOAT;
            case 3:
                return XmlErrorCodes.DOUBLE;
            case 4:
                return "byte";
            case 5:
                return "short";
            case 6:
                return XmlErrorCodes.INT;
            case 7:
                return XmlErrorCodes.LONG;
            case 8:
                return "java.math.BigDecimal";
            case 9:
                return "java.math.BigInteger";
            case 10:
                return "java.lang.String";
            case 11:
                return "byte[]";
            case 12:
                return "org.apache.xmlbeans.GDate";
            case 13:
                return "org.apache.xmlbeans.GDuration";
            case 14:
                return "java.util.Date";
            case 15:
                return "javax.xml.namespace.QName";
            case 16:
                return "java.util.List";
            case 17:
                return "java.util.Calendar";
            case 18:
                SchemaType javaBasedOnType = schemaProperty.javaBasedOnType();
                if (javaBasedOnType.getSimpleVariety() == 2) {
                    javaBasedOnType = javaBasedOnType.getUnionCommonBaseType();
                }
                if (!$assertionsDisabled && javaBasedOnType.getBaseEnumType() == null) {
                    throw new AssertionError();
                }
                if (hasBase(javaBasedOnType)) {
                    return new StringBuffer().append(findJavaType(javaBasedOnType.getBaseEnumType()).replace('$', '.')).append(".Enum").toString();
                }
                return new StringBuffer().append(findJavaType(javaBasedOnType).replace('$', '.')).append(".Enum").toString();
            case 19:
                return "java.lang.Object";
            default:
                if ($assertionsDisabled) {
                    throw new IllegalStateException();
                }
                throw new AssertionError();
        }
    }

    void printPropertyGetters(QName qName, boolean z, String str, int i, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5) throws IOException {
        String str4;
        String str5;
        String str6;
        String stringBuffer = new StringBuffer().append("\"").append(qName.getLocalPart()).append("\"").append(z ? " attribute" : " element").toString();
        boolean z6 = i == 0;
        if (z5) {
            printJavaDoc(new StringBuffer().append(z4 ? "Gets first " : "Gets the ").append(stringBuffer).toString());
            emit(new StringBuffer().append(str2).append(" get").append(str).append("();").toString());
            if (!z6) {
                printJavaDoc(new StringBuffer().append(z4 ? "Gets (as xml) first " : "Gets (as xml) the ").append(stringBuffer).toString());
                emit(new StringBuffer().append(str3).append(" xget").append(str).append("();").toString());
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append(z4 ? "Tests for nil first " : "Tests for nil ").append(stringBuffer).toString());
                emit(new StringBuffer().append("boolean isNil").append(str).append("();").toString());
            }
        }
        if (z3) {
            printJavaDoc(new StringBuffer().append(z4 ? "True if has at least one " : "True if has ").append(stringBuffer).toString());
            emit(new StringBuffer().append("boolean isSet").append(str).append("();").toString());
        }
        if (z4) {
            String stringBuffer2 = new StringBuffer().append(str).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).toString();
            if (this._useJava15) {
                String javaWrappedType = isJavaPrimitive(i) ? javaWrappedType(i) : str2;
                str4 = "boolean isNil";
                printJavaDoc(new StringBuffer().append("Gets a List of ").append(stringBuffer).append("s").toString());
                emit(new StringBuffer().append("java.util.List<").append(javaWrappedType).append("> get").append(str).append("List();").toString());
            } else {
                str4 = "boolean isNil";
            }
            if (this._useJava15) {
                emit("");
                emit("/**");
                str5 = "";
                emit(new StringBuffer().append(" * Gets array of all ").append(stringBuffer).append("s").toString());
                emit(" * @deprecated");
                emit(" */");
                emit("@Deprecated");
            } else {
                str5 = "";
                printJavaDoc(new StringBuffer().append("Gets array of all ").append(stringBuffer).append("s").toString());
            }
            emit(new StringBuffer().append(str2).append("[] get").append(stringBuffer2).append("();").toString());
            printJavaDoc(new StringBuffer().append("Gets ith ").append(stringBuffer).toString());
            emit(new StringBuffer().append(str2).append(" get").append(stringBuffer2).append("(int i);").toString());
            if (!z6) {
                if (this._useJava15) {
                    printJavaDoc(new StringBuffer().append("Gets (as xml) a List of ").append(stringBuffer).append("s").toString());
                    str6 = str5;
                    emit(new StringBuffer().append("java.util.List<").append(str3).append("> xget").append(str).append("List();").toString());
                } else {
                    str6 = str5;
                }
                if (this._useJava15) {
                    emit(str6);
                    emit("/**");
                    emit(new StringBuffer().append(" * Gets (as xml) array of all ").append(stringBuffer).append("s").toString());
                    emit(" * @deprecated");
                    emit(" */");
                    emit("@Deprecated");
                } else {
                    printJavaDoc(new StringBuffer().append("Gets (as xml) array of all ").append(stringBuffer).append("s").toString());
                }
                emit(new StringBuffer().append(str3).append("[] xget").append(stringBuffer2).append("();").toString());
                printJavaDoc(new StringBuffer().append("Gets (as xml) ith ").append(stringBuffer).toString());
                emit(new StringBuffer().append(str3).append(" xget").append(stringBuffer2).append("(int i);").toString());
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append("Tests for nil ith ").append(stringBuffer).toString());
                emit(new StringBuffer().append(str4).append(stringBuffer2).append("(int i);").toString());
            }
            printJavaDoc(new StringBuffer().append("Returns number of ").append(stringBuffer).toString());
            emit(new StringBuffer().append("int sizeOf").append(stringBuffer2).append("();").toString());
        }
    }

    void printPropertySetters(QName qName, boolean z, String str, int i, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5) throws IOException {
        String str4;
        String str5;
        String str6;
        String nonJavaKeyword = NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(str));
        if (nonJavaKeyword.equals(Complex.DEFAULT_SUFFIX)) {
            nonJavaKeyword = "iValue";
        }
        boolean z6 = i == 0;
        String stringBuffer = new StringBuffer().append("\"").append(qName.getLocalPart()).append("\"").append(z ? " attribute" : " element").toString();
        if (z5) {
            printJavaDoc(new StringBuffer().append(z4 ? "Sets first " : "Sets the ").append(stringBuffer).toString());
            emit(new StringBuffer().append("void set").append(str).append("(").append(str2).append(StringUtils.SPACE).append(nonJavaKeyword).append(");").toString());
            if (!z6) {
                printJavaDoc(new StringBuffer().append(z4 ? "Sets (as xml) first " : "Sets (as xml) the ").append(stringBuffer).toString());
                emit(new StringBuffer().append("void xset").append(str).append("(").append(str3).append(StringUtils.SPACE).append(nonJavaKeyword).append(");").toString());
            }
            if (z6 && !z4) {
                printJavaDoc(new StringBuffer().append("Appends and returns a new empty ").append(stringBuffer).toString());
                emit(new StringBuffer().append(str3).append(" addNew").append(str).append("();").toString());
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append(z4 ? "Nils the first " : "Nils the ").append(stringBuffer).toString());
                str4 = "void setNil";
                emit(new StringBuffer().append(str4).append(str).append("();").toString());
            } else {
                str4 = "void setNil";
            }
        } else {
            str4 = "void setNil";
        }
        if (z3) {
            str5 = " addNew";
            printJavaDoc(new StringBuffer().append(z4 ? "Removes first " : "Unsets the ").append(stringBuffer).toString());
            emit(new StringBuffer().append("void unset").append(str).append("();").toString());
        } else {
            str5 = " addNew";
        }
        if (z4) {
            String stringBuffer2 = new StringBuffer().append(str).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).toString();
            printJavaDoc(new StringBuffer().append("Sets array of all ").append(stringBuffer).toString());
            emit(new StringBuffer().append("void set").append(stringBuffer2).append("(").append(str2).append("[] ").append(nonJavaKeyword).append("Array);").toString());
            String str7 = str4;
            printJavaDoc(new StringBuffer().append("Sets ith ").append(stringBuffer).toString());
            emit(new StringBuffer().append("void set").append(stringBuffer2).append("(int i, ").append(str2).append(StringUtils.SPACE).append(nonJavaKeyword).append(");").toString());
            if (!z6) {
                printJavaDoc(new StringBuffer().append("Sets (as xml) array of all ").append(stringBuffer).toString());
                emit(new StringBuffer().append("void xset").append(stringBuffer2).append("(").append(str3).append("[] ").append(nonJavaKeyword).append("Array);").toString());
                printJavaDoc(new StringBuffer().append("Sets (as xml) ith ").append(stringBuffer).toString());
                emit(new StringBuffer().append("void xset").append(stringBuffer2).append("(int i, ").append(str3).append(StringUtils.SPACE).append(nonJavaKeyword).append(");").toString());
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append("Nils the ith ").append(stringBuffer).toString());
                emit(new StringBuffer().append(str7).append(stringBuffer2).append("(int i);").toString());
            }
            if (z6) {
                str6 = str;
            } else {
                printJavaDoc(new StringBuffer().append("Inserts the value as the ith ").append(stringBuffer).toString());
                str6 = str;
                emit(new StringBuffer().append("void insert").append(str6).append("(int i, ").append(str2).append(StringUtils.SPACE).append(nonJavaKeyword).append(");").toString());
                printJavaDoc(new StringBuffer().append("Appends the value as the last ").append(stringBuffer).toString());
                emit(new StringBuffer().append("void add").append(str6).append("(").append(str2).append(StringUtils.SPACE).append(nonJavaKeyword).append(");").toString());
            }
            printJavaDoc(new StringBuffer().append("Inserts and returns a new empty value (as xml) as the ith ").append(stringBuffer).toString());
            emit(new StringBuffer().append(str3).append(" insertNew").append(str6).append("(int i);").toString());
            printJavaDoc(new StringBuffer().append("Appends and returns a new empty value (as xml) as the last ").append(stringBuffer).toString());
            emit(new StringBuffer().append(str3).append(str5).append(str6).append("();").toString());
            printJavaDoc(new StringBuffer().append("Removes the ith ").append(stringBuffer).toString());
            emit(new StringBuffer().append("void remove").append(str6).append("(int i);").toString());
        }
    }

    String getAtomicRestrictionType(SchemaType schemaType) {
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return "org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl";
            case 3:
                return "org.apache.xmlbeans.impl.values.JavaBooleanHolderEx";
            case 4:
                return "org.apache.xmlbeans.impl.values.JavaBase64HolderEx";
            case 5:
                return "org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx";
            case 6:
                return "org.apache.xmlbeans.impl.values.JavaUriHolderEx";
            case 7:
                return "org.apache.xmlbeans.impl.values.JavaQNameHolderEx";
            case 8:
                return "org.apache.xmlbeans.impl.values.JavaNotationHolderEx";
            case 9:
                return "org.apache.xmlbeans.impl.values.JavaFloatHolderEx";
            case 10:
                return "org.apache.xmlbeans.impl.values.JavaDoubleHolderEx";
            case 11:
                int decimalSize = schemaType.getDecimalSize();
                if (decimalSize == 8 || decimalSize == 16 || decimalSize == 32) {
                    return "org.apache.xmlbeans.impl.values.JavaIntHolderEx";
                }
                if (decimalSize == 64) {
                    return "org.apache.xmlbeans.impl.values.JavaLongHolderEx";
                }
                switch (decimalSize) {
                    case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                        return "org.apache.xmlbeans.impl.values.JavaIntegerHolderEx";
                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                        return "org.apache.xmlbeans.impl.values.JavaDecimalHolderEx";
                    default:
                        if ($assertionsDisabled) {
                            return "org.apache.xmlbeans.impl.values.JavaDecimalHolderEx";
                        }
                        throw new AssertionError();
                }
            case 12:
                return schemaType.hasStringEnumValues() ? "org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx" : "org.apache.xmlbeans.impl.values.JavaStringHolderEx";
            case 13:
                return "org.apache.xmlbeans.impl.values.JavaGDurationHolderEx";
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return "org.apache.xmlbeans.impl.values.JavaGDateHolderEx";
            default:
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError("unrecognized primitive type");
        }
    }

    static SchemaType findBaseType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    String getBaseClass(SchemaType schemaType) {
        SchemaType findBaseType = findBaseType(schemaType.getBaseType());
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            return !XmlObject.type.equals(findBaseType) ? findBaseType.getFullJavaImplName() : "org.apache.xmlbeans.impl.values.XmlComplexContentImpl";
        }
        if (simpleVariety == 1) {
            if ($assertionsDisabled || !schemaType.isBuiltinType()) {
                return getAtomicRestrictionType(schemaType);
            }
            throw new AssertionError();
        }
        if (simpleVariety == 2) {
            return "org.apache.xmlbeans.impl.values.XmlUnionImpl";
        }
        if (simpleVariety == 3) {
            return "org.apache.xmlbeans.impl.values.XmlListImpl";
        }
        throw new IllegalStateException();
    }

    void printConstructor(SchemaType schemaType, String str) throws IOException {
        emit("");
        emit(new StringBuffer().append("public ").append(str).append("(org.apache.xmlbeans.SchemaType sType)").toString());
        startBlock();
        emit(new StringBuffer().append("super(sType").append(schemaType.getSimpleVariety() == 0 ? "" : new StringBuffer().append(", ").append(!schemaType.isSimpleType()).toString()).append(");").toString());
        endBlock();
        if (schemaType.getSimpleVariety() != 0) {
            emit("");
            emit(new StringBuffer().append("protected ").append(str).append("(org.apache.xmlbeans.SchemaType sType, boolean b)").toString());
            startBlock();
            emit("super(sType, b);");
            endBlock();
        }
    }

    void startClass(SchemaType schemaType, boolean z) throws IOException {
        String shortJavaImplName = schemaType.getShortJavaImplName();
        String baseClass = getBaseClass(schemaType);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(schemaType.getFullJavaName().replace('$', '.'));
        if (schemaType.getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : schemaType.getUnionMemberTypes()) {
                stringBuffer.append(new StringBuffer().append(", ").append(schemaType2.getFullJavaName().replace('$', '.')).toString());
            }
        }
        emit(new StringBuffer().append("public ").append(z ? "static " : "").append("class ").append(shortJavaImplName).append(" extends ").append(baseClass).append(" implements ").append(stringBuffer.toString()).toString());
        startBlock();
        emit("private static final long serialVersionUID = 1L;");
    }

    void makeAttributeDefaultValue(String str, SchemaProperty schemaProperty, String str2) throws IOException {
        if (str == null) {
            str = schemaProperty.javaBasedOnType().getFullJavaName().replace('$', '.');
        }
        emit(new StringBuffer().append("target = (").append(str).append(")get_default_attribute_value(").append(str2).append(");").toString());
    }

    void makeMissingValue(int i) throws IOException {
        switch (i) {
            case 1:
                emit("return false;");
                break;
            case 2:
                emit("return 0.0f;");
                break;
            case 3:
                emit("return 0.0;");
                break;
            case 4:
            case 5:
            case 6:
                emit("return 0;");
                break;
            case 7:
                emit("return 0L;");
                break;
            default:
                emit("return null;");
                break;
        }
    }

    void printJGetArrayValue(int i, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i) {
            case 0:
                emit(new StringBuffer().append(str).append("[] result = new ").append(str).append("[targetList.size()];").toString());
                emit("targetList.toArray(result);");
                break;
            case 1:
                emit("boolean[] result = new boolean[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBooleanValue();");
                break;
            case 2:
                emit("float[] result = new float[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getFloatValue();");
                break;
            case 3:
                emit("double[] result = new double[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getDoubleValue();");
                break;
            case 4:
                emit("byte[] result = new byte[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getByteValue();");
                break;
            case 5:
                emit("short[] result = new short[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getShortValue();");
                break;
            case 6:
                emit("int[] result = new int[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getIntValue();");
                break;
            case 7:
                emit("long[] result = new long[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getLongValue();");
                break;
            case 8:
                emit("java.math.BigDecimal[] result = new java.math.BigDecimal[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBigDecimalValue();");
                break;
            case 9:
                emit("java.math.BigInteger[] result = new java.math.BigInteger[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBigIntegerValue();");
                break;
            case 10:
                emit("java.lang.String[] result = new java.lang.String[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();");
                break;
            case 11:
                emit("byte[][] result = new byte[targetList.size()][];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getByteArrayValue();");
                break;
            case 12:
                emit("org.apache.xmlbeans.GDate[] result = new org.apache.xmlbeans.GDate[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getGDateValue();");
                break;
            case 13:
                emit("org.apache.xmlbeans.GDuration[] result = new org.apache.xmlbeans.GDuration[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getGDurationValue();");
                break;
            case 14:
                emit("java.util.Date[] result = new java.util.Date[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getDateValue();");
                break;
            case 15:
                emit("javax.xml.namespace.QName[] result = new javax.xml.namespace.QName[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getQNameValue();");
                break;
            case 16:
                emit("java.util.List[] result = new java.util.List[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getListValue();");
                break;
            case 17:
                emit("java.util.Calendar[] result = new java.util.Calendar[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getCalendarValue();");
                break;
            case 18:
                emit(new StringBuffer().append(str).append("[] result = new ").append(str).append("[targetList.size()];").toString());
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit(new StringBuffer().append("    result[i] = (").append(str).append(")((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();").toString());
                break;
            case 19:
                emit("java.lang.Object[] result = new java.lang.Object[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getObjectValue();");
                break;
            case 20:
                emit(new StringBuffer().append(schemaTypeImpl.getUserTypeName()).append("[] result = new ").append(schemaTypeImpl.getUserTypeName()).append("[targetList.size()];").toString());
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit(new StringBuffer().append("    result[i] = ").append(getUserTypeStaticHandlerMethod(false, schemaTypeImpl)).append("((org.apache.xmlbeans.SimpleValue)targetList.get(i));").toString());
                break;
            default:
                throw new IllegalStateException();
        }
        emit("return result;");
    }

    void printJGetValue(int i, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i) {
            case 0:
                emit("return target;");
                return;
            case 1:
                emit("return target.getBooleanValue();");
                return;
            case 2:
                emit("return target.getFloatValue();");
                return;
            case 3:
                emit("return target.getDoubleValue();");
                return;
            case 4:
                emit("return target.getByteValue();");
                return;
            case 5:
                emit("return target.getShortValue();");
                return;
            case 6:
                emit("return target.getIntValue();");
                return;
            case 7:
                emit("return target.getLongValue();");
                return;
            case 8:
                emit("return target.getBigDecimalValue();");
                return;
            case 9:
                emit("return target.getBigIntegerValue();");
                return;
            case 10:
                emit("return target.getStringValue();");
                return;
            case 11:
                emit("return target.getByteArrayValue();");
                return;
            case 12:
                emit("return target.getGDateValue();");
                return;
            case 13:
                emit("return target.getGDurationValue();");
                return;
            case 14:
                emit("return target.getDateValue();");
                return;
            case 15:
                emit("return target.getQNameValue();");
                return;
            case 16:
                emit("return target.getListValue();");
                return;
            case 17:
                emit("return target.getCalendarValue();");
                return;
            case 18:
                emit(new StringBuffer().append("return (").append(str).append(")target.getEnumValue();").toString());
                return;
            case 19:
                emit("return target.getObjectValue();");
                return;
            case 20:
                emit(new StringBuffer().append("return ").append(getUserTypeStaticHandlerMethod(false, schemaTypeImpl)).append("(target);").toString());
                return;
            default:
                throw new IllegalStateException();
        }
    }

    void printJSetValue(int i, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i) {
            case 0:
                emit(new StringBuffer().append("target.set(").append(str).append(");").toString());
                return;
            case 1:
                emit(new StringBuffer().append("target.setBooleanValue(").append(str).append(");").toString());
                return;
            case 2:
                emit(new StringBuffer().append("target.setFloatValue(").append(str).append(");").toString());
                return;
            case 3:
                emit(new StringBuffer().append("target.setDoubleValue(").append(str).append(");").toString());
                return;
            case 4:
                emit(new StringBuffer().append("target.setByteValue(").append(str).append(");").toString());
                return;
            case 5:
                emit(new StringBuffer().append("target.setShortValue(").append(str).append(");").toString());
                return;
            case 6:
                emit(new StringBuffer().append("target.setIntValue(").append(str).append(");").toString());
                return;
            case 7:
                emit(new StringBuffer().append("target.setLongValue(").append(str).append(");").toString());
                return;
            case 8:
                emit(new StringBuffer().append("target.setBigDecimalValue(").append(str).append(");").toString());
                return;
            case 9:
                emit(new StringBuffer().append("target.setBigIntegerValue(").append(str).append(");").toString());
                return;
            case 10:
                emit(new StringBuffer().append("target.setStringValue(").append(str).append(");").toString());
                return;
            case 11:
                emit(new StringBuffer().append("target.setByteArrayValue(").append(str).append(");").toString());
                return;
            case 12:
                emit(new StringBuffer().append("target.setGDateValue(").append(str).append(");").toString());
                return;
            case 13:
                emit(new StringBuffer().append("target.setGDurationValue(").append(str).append(");").toString());
                return;
            case 14:
                emit(new StringBuffer().append("target.setDateValue(").append(str).append(");").toString());
                return;
            case 15:
                emit(new StringBuffer().append("target.setQNameValue(").append(str).append(");").toString());
                return;
            case 16:
                emit(new StringBuffer().append("target.setListValue(").append(str).append(");").toString());
                return;
            case 17:
                emit(new StringBuffer().append("target.setCalendarValue(").append(str).append(");").toString());
                return;
            case 18:
                emit(new StringBuffer().append("target.setEnumValue(").append(str).append(");").toString());
                return;
            case 19:
                emit(new StringBuffer().append("target.setObjectValue(").append(str).append(");").toString());
                return;
            case 20:
                emit(new StringBuffer().append(getUserTypeStaticHandlerMethod(true, schemaTypeImpl)).append("(").append(str).append(", target);").toString());
                return;
            default:
                throw new IllegalStateException();
        }
    }

    String getIdentifier(Map map, QName qName) {
        return ((String[]) map.get(qName))[0];
    }

    String getSetIdentifier(Map map, QName qName) {
        String[] strArr = (String[]) map.get(qName);
        return strArr[1] == null ? strArr[0] : strArr[1];
    }

    Map printStaticFields(SchemaProperty[] schemaPropertyArr) throws IOException {
        HashMap hashMap = new HashMap();
        emit("");
        for (int i = 0; i < schemaPropertyArr.length; i++) {
            String[] strArr = new String[2];
            SchemaProperty schemaProperty = schemaPropertyArr[i];
            QName name = schemaProperty.getName();
            hashMap.put(name, strArr);
            String javaPropertyName = schemaProperty.getJavaPropertyName();
            int i2 = i * 2;
            strArr[0] = new StringBuffer().append(javaPropertyName).append("$").append(i2).toString().toUpperCase();
            String stringBuffer = new StringBuffer().append("\"").append(name.getNamespaceURI()).append("\"").toString();
            emit(new StringBuffer().append("private static final javax.xml.namespace.QName ").append(strArr[0]).append(" = ").toString());
            indent();
            emit(new StringBuffer().append("new javax.xml.namespace.QName(").append(stringBuffer).append(", \"").append(name.getLocalPart()).append("\");").toString());
            outdent();
            if (schemaPropertyArr[i].acceptedNames() != null) {
                QName[] acceptedNames = schemaPropertyArr[i].acceptedNames();
                if (acceptedNames.length > 1) {
                    strArr[1] = new StringBuffer().append(javaPropertyName).append("$").append(i2 + 1).toString().toUpperCase();
                    emit(new StringBuffer().append("private static final org.apache.xmlbeans.QNameSet ").append(strArr[1]).append(" = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { ").toString());
                    indent();
                    for (int i3 = 0; i3 < acceptedNames.length; i3++) {
                        emit(new StringBuffer().append("new javax.xml.namespace.QName(\"").append(acceptedNames[i3].getNamespaceURI()).append("\", \"").append(acceptedNames[i3].getLocalPart()).append("\"),").toString());
                    }
                    outdent();
                    emit("});");
                }
            }
        }
        emit("");
        return hashMap;
    }

    void emitImplementationPreamble() throws IOException {
        emit("synchronized (monitor())");
        emit("{");
        indent();
        emit("check_orphaned();");
    }

    void emitImplementationPostamble() throws IOException {
        outdent();
        emit(StringSubstitutor.DEFAULT_VAR_END);
    }

    void emitDeclareTarget(boolean z, String str) throws IOException {
        if (z) {
            emit(new StringBuffer().append(str).append(" target = null;").toString());
        }
    }

    void emitAddTarget(String str, boolean z, boolean z2, String str2) throws IOException {
        if (z) {
            emit(new StringBuffer().append("target = (").append(str2).append(")get_store().add_attribute_user(").append(str).append(");").toString());
        } else {
            emit(new StringBuffer().append("target = (").append(str2).append(")get_store().add_element_user(").append(str).append(");").toString());
        }
    }

    void emitPre(SchemaType schemaType, int i, String str, boolean z) throws IOException {
        emitPre(schemaType, i, str, z, "-1");
    }

    void emitPre(SchemaType schemaType, int i, String str, boolean z, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null || !prePostExtension.hasPreCall()) {
            return;
        }
        emit(new StringBuffer().append("if ( ").append(prePostExtension.getStaticHandler()).append(".preSet(").append(prePostOpString(i)).append(", this, ").append(str).append(", ").append(z).append(", ").append(str2).append("))").toString());
        startBlock();
    }

    void emitPost(SchemaType schemaType, int i, String str, boolean z) throws IOException {
        emitPost(schemaType, i, str, z, "-1");
    }

    void emitPost(SchemaType schemaType, int i, String str, boolean z, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null) {
            return;
        }
        if (prePostExtension.hasPreCall()) {
            endBlock();
        }
        if (prePostExtension.hasPostCall()) {
            emit(new StringBuffer().append(prePostExtension.getStaticHandler()).append(".postSet(").append(prePostOpString(i)).append(", this, ").append(str).append(", ").append(z).append(", ").append(str2).append(");").toString());
        }
    }

    String prePostOpString(int i) {
        if (i == 1) {
            return "org.apache.xmlbeans.PrePostExtension.OPERATION_SET";
        }
        if (i == 2) {
            return "org.apache.xmlbeans.PrePostExtension.OPERATION_INSERT";
        }
        if (i == 3) {
            return "org.apache.xmlbeans.PrePostExtension.OPERATION_REMOVE";
        }
        if ($assertionsDisabled) {
            return "org.apache.xmlbeans.PrePostExtension.OPERATION_SET";
        }
        throw new AssertionError();
    }

    void emitGetTarget(String str, String str2, boolean z, String str3, int i, String str4) throws IOException {
        boolean z2 = $assertionsDisabled;
        if (!z2 && (str == null || str2 == null)) {
            throw new AssertionError();
        }
        emit(new StringBuffer().append(str4).append(" target = null;").toString());
        if (z) {
            emit(new StringBuffer().append("target = (").append(str4).append(")get_store().find_attribute_user(").append(str2).append(");").toString());
        } else {
            emit(new StringBuffer().append("target = (").append(str4).append(")get_store().find_element_user(").append(str).append(", ").append(str3).append(");").toString());
        }
        if (i == 1) {
            return;
        }
        emit("if (target == null)");
        startBlock();
        if (i != 1) {
            if (i == 3) {
                emitAddTarget(str2, z, false, str4);
            } else if (i == 4) {
                emit("throw new IndexOutOfBoundsException();");
            } else if (!z2) {
                throw new AssertionError(new StringBuffer().append("Bad behaviour type: ").append(i).toString());
            }
        }
        endBlock();
    }

    void printListGetter15Impl(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2) throws IOException {
        String stringBuffer = new StringBuffer().append(str3).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).toString();
        String stringBuffer2 = new StringBuffer().append(str3).append("List").toString();
        String stringBuffer3 = new StringBuffer().append(str).append(".this.").toString();
        String stringBuffer4 = new StringBuffer().append(z2 ? "x" : "").append("get").toString();
        String stringBuffer5 = new StringBuffer().append(z2 ? "x" : "").append(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX).toString();
        printJavaDoc(new StringBuffer().append("Gets ").append(z2 ? "(as xml) " : "").append("a List of ").append(str2).append("s").toString());
        emit(new StringBuffer().append("public java.util.List<").append(str4).append("> ").append(stringBuffer4).append(stringBuffer2).append("()").toString());
        startBlock();
        emit(new StringBuffer().append("final class ").append(stringBuffer2).append(" extends java.util.AbstractList<").append(str4).append(">").toString());
        startBlock();
        if (this._useJava15) {
            emit("@Override");
        }
        emit(new StringBuffer().append("public ").append(str4).append(" get(int i)").toString());
        emit(new StringBuffer().append("    { return ").append(stringBuffer3).append(stringBuffer4).append(stringBuffer).append("(i); }").toString());
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit(new StringBuffer().append("public ").append(str4).append(" set(int i, ").append(str4).append(" o)").toString());
        startBlock();
        emit(new StringBuffer().append(str4).append(" old = ").append(stringBuffer3).append(stringBuffer4).append(stringBuffer).append("(i);").toString());
        emit(new StringBuffer().append(stringBuffer3).append(stringBuffer5).append(stringBuffer).append("(i, o);").toString());
        emit("return old;");
        endBlock();
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit(new StringBuffer().append("public void add(int i, ").append(str4).append(" o)").toString());
        if (z || z2) {
            emit(new StringBuffer().append("    { ").append(stringBuffer3).append("insertNew").append(str3).append("(i).set(o); }").toString());
        } else {
            emit(new StringBuffer().append("    { ").append(stringBuffer3).append("insert").append(str3).append("(i, o); }").toString());
        }
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit(new StringBuffer().append("public ").append(str4).append(" remove(int i)").toString());
        startBlock();
        emit(new StringBuffer().append(str4).append(" old = ").append(stringBuffer3).append(stringBuffer4).append(stringBuffer).append("(i);").toString());
        emit(new StringBuffer().append(stringBuffer3).append("remove").append(str3).append("(i);").toString());
        emit("return old;");
        endBlock();
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit("public int size()");
        emit(new StringBuffer().append("    { return ").append(stringBuffer3).append("sizeOf").append(stringBuffer).append("(); }").toString());
        emit("");
        endBlock();
        emit("");
        emitImplementationPreamble();
        emit(new StringBuffer().append("return new ").append(stringBuffer2).append("();").toString());
        emitImplementationPostamble();
        endBlock();
    }

    void printGetterImpls(String str, SchemaProperty schemaProperty, QName qName, boolean z, String str2, int i, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str5, String str6) throws IOException {
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String stringBuffer = new StringBuffer().append("\"").append(qName.getLocalPart()).append("\"").append(z ? " attribute" : " element").toString();
        boolean z7 = i == 0;
        String str27 = (z6 || !z7) ? "org.apache.xmlbeans.SimpleValue" : str4;
        if (z5) {
            printJavaDoc(new StringBuffer().append(z4 ? "Gets first " : "Gets the ").append(stringBuffer).toString());
            emit(new StringBuffer().append("public ").append(str3).append(" get").append(str2).append("()").toString());
            startBlock();
            emitImplementationPreamble();
            str9 = " get";
            String str28 = str27;
            emitGetTarget(str6, str5, z, SessionDescription.SUPPORTED_SDP_VERSION, 1, str27);
            if (z && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                emit("if (target == null)");
                startBlock();
                str25 = str28;
                makeAttributeDefaultValue(str25, schemaProperty, str5);
                endBlock();
            } else {
                str25 = str28;
            }
            emit("if (target == null)");
            startBlock();
            makeMissingValue(i);
            endBlock();
            printJGetValue(i, str3, (SchemaTypeImpl) schemaProperty.getType());
            emitImplementationPostamble();
            endBlock();
            if (z7) {
                str10 = " xget";
                str26 = "()";
                str8 = "public ";
                str11 = str25;
            } else {
                printJavaDoc(new StringBuffer().append(z4 ? "Gets (as xml) first " : "Gets (as xml) the ").append(stringBuffer).toString());
                emit(new StringBuffer().append("public ").append(str4).append(" xget").append(str2).append("()").toString());
                startBlock();
                emitImplementationPreamble();
                str26 = "()";
                str8 = "public ";
                str11 = str25;
                str10 = " xget";
                emitGetTarget(str6, str5, z, SessionDescription.SUPPORTED_SDP_VERSION, 1, str4);
                if (z && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                    emit("if (target == null)");
                    startBlock();
                    makeAttributeDefaultValue(str4, schemaProperty, str5);
                    endBlock();
                }
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append(z4 ? "Tests for nil first " : "Tests for nil ").append(stringBuffer).toString());
                str7 = str26;
                emit(new StringBuffer().append("public boolean isNil").append(str2).append(str7).toString());
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str6, str5, z, SessionDescription.SUPPORTED_SDP_VERSION, 1, str4);
                emit("if (target == null) return false;");
                emit("return target.isNil();");
                emitImplementationPostamble();
                endBlock();
            } else {
                str7 = str26;
            }
        } else {
            str7 = "()";
            str8 = "public ";
            str9 = " get";
            str10 = " xget";
            str11 = str27;
        }
        if (z3) {
            printJavaDoc(new StringBuffer().append(z4 ? "True if has at least one " : "True if has ").append(stringBuffer).toString());
            emit(new StringBuffer().append("public boolean isSet").append(str2).append(str7).toString());
            startBlock();
            emitImplementationPreamble();
            if (z) {
                emit(new StringBuffer().append("return get_store().find_attribute_user(").append(str5).append(") != null;").toString());
                str12 = str10;
            } else {
                str12 = str10;
                emit(new StringBuffer().append("return get_store().count_elements(").append(str6).append(") != 0;").toString());
            }
            emitImplementationPostamble();
            endBlock();
        } else {
            str12 = str10;
        }
        if (z4) {
            String stringBuffer2 = new StringBuffer().append(str2).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).toString();
            if (this._useJava15) {
                str13 = stringBuffer2;
                str14 = str12;
                str15 = "return get_store().count_elements(";
                str16 = stringBuffer;
                printListGetter15Impl(str, stringBuffer, str2, isJavaPrimitive(i) ? javaWrappedType(i) : str3, str4, z7, false);
            } else {
                str13 = stringBuffer2;
                str14 = str12;
                str15 = "return get_store().count_elements(";
                str16 = stringBuffer;
            }
            if (this._useJava15) {
                emit("");
                emit("/**");
                emit(new StringBuffer().append(" * Gets array of all ").append(str16).append("s").toString());
                emit(" * @deprecated");
                emit(" */");
                emit("@Deprecated");
                str17 = "";
            } else {
                str17 = "";
                printJavaDoc(new StringBuffer().append("Gets array of all ").append(str16).append("s").toString());
            }
            String str29 = str8;
            String str30 = str13;
            emit(new StringBuffer().append(str29).append(str3).append("[] get").append(str30).append(str7).toString());
            startBlock();
            emitImplementationPreamble();
            String str31 = str15;
            if (this._useJava15) {
                emit(new StringBuffer().append("java.util.List<").append(str4).append("> targetList = new java.util.ArrayList<").append(str4).append(">();").toString());
            } else {
                emit("java.util.List targetList = new java.util.ArrayList();");
            }
            emit(new StringBuffer().append("get_store().find_all_element_users(").append(str6).append(", targetList);").toString());
            printJGetArrayValue(i, str3, (SchemaTypeImpl) schemaProperty.getType());
            emitImplementationPostamble();
            endBlock();
            printJavaDoc(new StringBuffer().append("Gets ith ").append(str16).toString());
            emit(new StringBuffer().append(str29).append(str3).append(str9).append(str30).append("(int i)").toString());
            startBlock();
            emitImplementationPreamble();
            String str32 = str17;
            emitGetTarget(str6, str5, z, Complex.DEFAULT_SUFFIX, 4, str11);
            printJGetValue(i, str3, (SchemaTypeImpl) schemaProperty.getType());
            emitImplementationPostamble();
            endBlock();
            if (z7) {
                str18 = str6;
                str19 = str30;
                str20 = "(int i)";
            } else {
                if (this._useJava15) {
                    str21 = ">();";
                    str22 = ", targetList);";
                    str23 = "java.util.List targetList = new java.util.ArrayList();";
                    str24 = "@Deprecated";
                    printListGetter15Impl(str, str16, str2, str4, str4, z7, true);
                } else {
                    str21 = ">();";
                    str22 = ", targetList);";
                    str23 = "java.util.List targetList = new java.util.ArrayList();";
                    str24 = "@Deprecated";
                }
                if (this._useJava15) {
                    emit(str32);
                    emit("/**");
                    emit(new StringBuffer().append(" * Gets array of all ").append(str16).append("s").toString());
                    emit(" * @deprecated");
                    emit(" */");
                    emit(str24);
                } else {
                    printJavaDoc(new StringBuffer().append("Gets (as xml) array of all ").append(str16).append("s").toString());
                }
                str19 = str30;
                emit(new StringBuffer().append(str29).append(str4).append("[] xget").append(str19).append(str7).toString());
                startBlock();
                emitImplementationPreamble();
                if (this._useJava15) {
                    emit(new StringBuffer().append("java.util.List<").append(str4).append("> targetList = new java.util.ArrayList<").append(str4).append(str21).toString());
                } else {
                    emit(str23);
                }
                str18 = str6;
                emit(new StringBuffer().append("get_store().find_all_element_users(").append(str18).append(str22).toString());
                emit(new StringBuffer().append(str4).append("[] result = new ").append(str4).append("[targetList.size()];").toString());
                emit("targetList.toArray(result);");
                emit("return result;");
                emitImplementationPostamble();
                endBlock();
                printJavaDoc(new StringBuffer().append("Gets (as xml) ith ").append(str16).toString());
                str20 = "(int i)";
                emit(new StringBuffer().append(str29).append(str4).append(str14).append(str19).append(str20).toString());
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str6, str5, z, Complex.DEFAULT_SUFFIX, 4, str4);
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append("Tests for nil ith ").append(str16).toString());
                emit(new StringBuffer().append("public boolean isNil").append(str19).append(str20).toString());
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str6, str5, z, Complex.DEFAULT_SUFFIX, 4, str4);
                emit("return target.isNil();");
                emitImplementationPostamble();
                endBlock();
            }
            printJavaDoc(new StringBuffer().append("Returns number of ").append(str16).toString());
            emit(new StringBuffer().append("public int sizeOf").append(str19).append(str7).toString());
            startBlock();
            emitImplementationPreamble();
            emit(new StringBuffer().append(str31).append(str18).append(");").toString());
            emitImplementationPostamble();
            endBlock();
        }
    }

    void printSetterImpls(QName qName, SchemaProperty schemaProperty, boolean z, String str, int i, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str4, String str5, SchemaType schemaType) throws IOException {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z7;
        String str15;
        String str16;
        String str17;
        String str18;
        SchemaType schemaType2;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        boolean z8;
        SchemaType schemaType3;
        String str40;
        String str41;
        String str42;
        String str43;
        int i2;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        SchemaType schemaType4;
        String str54;
        String str55;
        String str56;
        String nonExtraKeyword = NameUtil.nonExtraKeyword(NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(str)));
        boolean z9 = i == 0;
        boolean z10 = i == 19;
        boolean z11 = str4 != str5;
        String str57 = (z6 || !z9) ? "org.apache.xmlbeans.SimpleValue" : str3;
        String stringBuffer = new StringBuffer().append("\"").append(qName.getLocalPart()).append("\"").append(z ? " attribute" : " element").toString();
        if (z5) {
            printJavaDoc(new StringBuffer().append(z4 ? "Sets first " : "Sets the ").append(stringBuffer).toString());
            emit(new StringBuffer().append("public void set").append(str).append("(").append(str2).append(StringUtils.SPACE).append(nonExtraKeyword).append(")").toString());
            startBlock();
            if (z9 && !z11) {
                str49 = "()";
                str48 = "public void xset";
                str47 = "public ";
                str8 = "public void set";
                str9 = str57;
                str50 = ")";
                str16 = stringBuffer;
                emitPre(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                emit(new StringBuffer().append("generatedSetterHelperImpl(").append(nonExtraKeyword).append(", ").append(str5).append(", 0, ").append("org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);").toString());
                emitPost(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                str11 = ", ";
                str17 = nonExtraKeyword;
            } else {
                str47 = "public ";
                str48 = "public void xset";
                str8 = "public void set";
                str9 = str57;
                str49 = "()";
                str50 = ")";
                str16 = stringBuffer;
                emitImplementationPreamble();
                emitPre(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                str11 = ", ";
                str17 = nonExtraKeyword;
                emitGetTarget(str5, str4, z, SessionDescription.SUPPORTED_SDP_VERSION, 3, str9);
                printJSetValue(i, str17, (SchemaTypeImpl) schemaProperty.getType());
                emitPost(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                emitImplementationPostamble();
            }
            endBlock();
            if (z9) {
                str7 = str48;
                str14 = ");";
                str10 = str50;
                str51 = StringUtils.SPACE;
                str52 = str3;
            } else {
                printJavaDoc(new StringBuffer().append(z4 ? "Sets (as xml) first " : "Sets (as xml) the ").append(str16).toString());
                String str58 = str50;
                emit(new StringBuffer().append(str48).append(str).append("(").append(str3).append(StringUtils.SPACE).append(str17).append(str58).toString());
                startBlock();
                emitImplementationPreamble();
                str10 = str58;
                str7 = str48;
                str14 = ");";
                emitPre(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                str51 = StringUtils.SPACE;
                str52 = str3;
                emitGetTarget(str5, str4, z, SessionDescription.SUPPORTED_SDP_VERSION, 3, str3);
                emit(new StringBuffer().append("target.set(").append(str17).append(str14).toString());
                emitPost(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                emitImplementationPostamble();
                endBlock();
            }
            if (!z9 || z4) {
                str53 = str4;
                schemaType4 = schemaType;
                str13 = "(";
                str54 = str51;
                str55 = str49;
                str56 = str47;
                z7 = z;
            } else {
                printJavaDoc(new StringBuffer().append("Appends and returns a new empty ").append(str16).toString());
                str56 = str47;
                str55 = str49;
                emit(new StringBuffer().append(str56).append(str52).append(" addNew").append(str).append(str55).toString());
                startBlock();
                emitImplementationPreamble();
                emitDeclareTarget(true, str52);
                str53 = str4;
                schemaType4 = schemaType;
                str13 = "(";
                str54 = str51;
                z7 = z;
                emitPre(schemaType4, 2, str53, z7);
                emitAddTarget(str53, z7, true, str52);
                emitPost(schemaType4, 2, str53, z7);
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append(z4 ? "Nils the first " : "Nils the ").append(str16).toString());
                emit(new StringBuffer().append("public void setNil").append(str).append(str55).toString());
                startBlock();
                emitImplementationPreamble();
                str12 = str54;
                str15 = str55;
                emitPre(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                str6 = str56;
                emitGetTarget(str5, str4, z, SessionDescription.SUPPORTED_SDP_VERSION, 3, str3);
                emit("target.setNil();");
                emitPost(schemaType, 1, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
                emitImplementationPostamble();
                endBlock();
            } else {
                str12 = str54;
                str15 = str55;
                str6 = str56;
            }
        } else {
            str6 = "public ";
            str7 = "public void xset";
            str8 = "public void set";
            str9 = str57;
            str10 = ")";
            str11 = ", ";
            str12 = StringUtils.SPACE;
            str13 = "(";
            str14 = ");";
            z7 = z;
            str15 = "()";
            str16 = stringBuffer;
            str17 = nonExtraKeyword;
        }
        if (z3) {
            printJavaDoc(new StringBuffer().append(z4 ? "Removes first " : "Unsets the ").append(str16).toString());
            emit(new StringBuffer().append("public void unset").append(str).append(str15).toString());
            startBlock();
            emitImplementationPreamble();
            emitPre(schemaType, 3, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
            if (z7) {
                str18 = str4;
                emit(new StringBuffer().append("get_store().remove_attribute(").append(str18).append(str14).toString());
            } else {
                str18 = str4;
                emit(new StringBuffer().append("get_store().remove_element(").append(str5).append(", 0);").toString());
            }
            emitPost(schemaType, 3, str4, z, z4 ? SessionDescription.SUPPORTED_SDP_VERSION : "-1");
            emitImplementationPostamble();
            endBlock();
        } else {
            str18 = str4;
        }
        if (z4) {
            String stringBuffer2 = new StringBuffer().append(str).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).toString();
            String str59 = "arraySetterHelper(";
            if (z9) {
                str19 = str15;
                printJavaDoc(new StringBuffer().append("Sets array of all ").append(str16).append("  WARNING: This method is not atomicaly synchronized.").toString());
                str22 = str8;
                str21 = str7;
                emit(new StringBuffer().append(str22).append(stringBuffer2).append(str13).append(str2).append("[] ").append(str17).append("Array)").toString());
                startBlock();
                emit("check_orphaned();");
                schemaType2 = schemaType;
                emitPre(schemaType2, 1, str18, z7);
                if (!z10) {
                    str23 = "Array)";
                    str20 = str11;
                    if (!z11) {
                        emit(new StringBuffer().append("arraySetterHelper(").append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str14).toString());
                    } else {
                        emit(new StringBuffer().append("arraySetterHelper(").append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str20).append(str5).append(str14).toString());
                    }
                } else if (z11) {
                    str23 = "Array)";
                    str20 = str11;
                    emit(new StringBuffer().append("unionArraySetterHelper(").append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str20).append(str5).append(str14).toString());
                } else {
                    str20 = str11;
                    emit(new StringBuffer().append("unionArraySetterHelper(").append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str14).toString());
                    str23 = "Array)";
                }
                emitPost(schemaType2, 1, str18, z7);
                endBlock();
            } else {
                schemaType2 = schemaType;
                str19 = str15;
                str20 = str11;
                str21 = str7;
                str22 = str8;
                printJavaDoc(new StringBuffer().append("Sets array of all ").append(str16).toString());
                emit(new StringBuffer().append(str22).append(stringBuffer2).append(str13).append(str2).append("[] ").append(str17).append("Array)").toString());
                startBlock();
                emitImplementationPreamble();
                emitPre(schemaType2, 1, str18, z7);
                if (z10) {
                    if (!z11) {
                        emit(new StringBuffer().append("unionArraySetterHelper(").append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str14).toString());
                    } else {
                        emit(new StringBuffer().append("unionArraySetterHelper(").append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str20).append(str5).append(str14).toString());
                    }
                    str59 = "arraySetterHelper(";
                    str23 = "Array)";
                } else if (schemaProperty.getJavaTypeCode() == 20) {
                    if (!z11) {
                        emit(new StringBuffer().append("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(").append(str17).append("Array.length").append(str20).append(str18).append(str14).toString());
                        emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
                        str23 = "Array)";
                        emit(new StringBuffer().append("    ").append(getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl) schemaProperty.getType())).append(str13).append(str17).append("Array[i], dests[i]);").toString());
                        emit(StringSubstitutor.DEFAULT_VAR_END);
                    } else {
                        str23 = "Array)";
                        emit(new StringBuffer().append("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(").append(str17).append("Array.length").append(str20).append(str18).append(str20).append(str5).append(str14).toString());
                        emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
                        emit(new StringBuffer().append("    ").append(getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl) schemaProperty.getType())).append(str13).append(str17).append("Array[i], dests[i]);").toString());
                        emit(StringSubstitutor.DEFAULT_VAR_END);
                    }
                    str59 = "arraySetterHelper(";
                } else {
                    str23 = "Array)";
                    if (!z11) {
                        str59 = "arraySetterHelper(";
                        emit(new StringBuffer().append(str59).append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str14).toString());
                    } else {
                        str59 = "arraySetterHelper(";
                        emit(new StringBuffer().append(str59).append(str17).append(SoapEncSchemaTypeSystem.SOAP_ARRAY).append(str20).append(str18).append(str20).append(str5).append(str14).toString());
                    }
                }
                emitPost(schemaType2, 1, str18, z7);
                emitImplementationPostamble();
                endBlock();
            }
            printJavaDoc(new StringBuffer().append("Sets ith ").append(str16).toString());
            String str60 = str59;
            String str61 = str12;
            StringBuffer append = new StringBuffer().append(str22).append(stringBuffer2).append("(int i, ").append(str2).append(str61).append(str17);
            String str62 = str10;
            emit(append.append(str62).toString());
            startBlock();
            if (z9 && !z11) {
                String str63 = str13;
                str30 = str20;
                str25 = str62;
                str28 = "(int i, ";
                str29 = str60;
                str24 = str23;
                str26 = stringBuffer2;
                str27 = str14;
                str31 = SoapEncSchemaTypeSystem.SOAP_ARRAY;
                emitPre(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                emit(new StringBuffer().append("generatedSetterHelperImpl(").append(str17).append(str30).append(str5).append(", i, ").append("org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);").toString());
                emitPost(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                str32 = str18;
                str33 = str63;
            } else {
                str24 = str23;
                str25 = str62;
                str26 = stringBuffer2;
                String str64 = str13;
                str27 = str14;
                str28 = "(int i, ";
                str29 = str60;
                str30 = str20;
                str31 = SoapEncSchemaTypeSystem.SOAP_ARRAY;
                emitImplementationPreamble();
                emitPre(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                str32 = str18;
                emitGetTarget(str5, str4, z, Complex.DEFAULT_SUFFIX, 4, str9);
                printJSetValue(i, str17, (SchemaTypeImpl) schemaProperty.getType());
                str33 = str64;
                emitPost(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                emitImplementationPostamble();
            }
            endBlock();
            if (z9) {
                str34 = str28;
                str35 = str30;
                str36 = str61;
                str37 = str25;
                str38 = str26;
                str39 = str33;
            } else {
                printJavaDoc(new StringBuffer().append("Sets (as xml) array of all ").append(str16).toString());
                String str65 = str21;
                String str66 = str26;
                emit(new StringBuffer().append(str65).append(str66).append(str33).append(str3).append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI).append(str17).append(str24).toString());
                startBlock();
                emitImplementationPreamble();
                emitPre(schemaType2, 1, str32, z7);
                StringBuffer append2 = new StringBuffer().append(str29).append(str17).append(str31).append(str30).append(str32);
                String str67 = str27;
                emit(append2.append(str67).toString());
                emitPost(schemaType2, 1, str32, z7);
                emitImplementationPostamble();
                endBlock();
                printJavaDoc(new StringBuffer().append("Sets (as xml) ith ").append(str16).toString());
                str34 = str28;
                StringBuffer append3 = new StringBuffer().append(str65).append(str66).append(str34).append(str3).append(str61).append(str17);
                String str68 = str25;
                emit(append3.append(str68).toString());
                startBlock();
                emitImplementationPreamble();
                str37 = str68;
                str36 = str61;
                str38 = str66;
                emitPre(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                str35 = str30;
                str39 = str33;
                emitGetTarget(str5, str4, z, Complex.DEFAULT_SUFFIX, 4, str3);
                emit(new StringBuffer().append("target.set(").append(str17).append(str67).toString());
                emitPost(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                emitImplementationPostamble();
                endBlock();
            }
            if (z2) {
                printJavaDoc(new StringBuffer().append("Nils the ith ").append(str16).toString());
                emit(new StringBuffer().append("public void setNil").append(str38).append("(int i)").toString());
                startBlock();
                emitImplementationPreamble();
                emitPre(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                emitGetTarget(str5, str4, z, Complex.DEFAULT_SUFFIX, 4, str3);
                emit("target.setNil();");
                emitPost(schemaType, 1, str4, z, Complex.DEFAULT_SUFFIX);
                emitImplementationPostamble();
                endBlock();
            }
            if (z9) {
                z8 = z;
                schemaType3 = schemaType;
                str40 = ")get_store().insert_element_user(";
                str41 = "(int i)";
                str42 = ", i);";
                str43 = str35;
                i2 = 2;
                str44 = str;
            } else {
                printJavaDoc(new StringBuffer().append("Inserts the value as the ith ").append(str16).toString());
                StringBuffer append4 = new StringBuffer().append("public void insert").append(str).append(str34).append(str2);
                String str69 = str36;
                emit(append4.append(str69).append(str17).append(str37).toString());
                startBlock();
                emitImplementationPreamble();
                str41 = "(int i)";
                str44 = str;
                emitPre(schemaType, 2, str4, z, Complex.DEFAULT_SUFFIX);
                String str70 = str9;
                emit(new StringBuffer().append(str70).append(" target = ").toString());
                indent();
                if (!z11) {
                    emit(new StringBuffer().append(str39).append(str70).append(")get_store().insert_element_user(").append(str32).append(", i);").toString());
                    str46 = str35;
                } else {
                    str46 = str35;
                    emit(new StringBuffer().append(str39).append(str70).append(")get_store().insert_element_user(").append(str5).append(str46).append(str32).append(", i);").toString());
                }
                outdent();
                printJSetValue(i, str17, (SchemaTypeImpl) schemaProperty.getType());
                str42 = ", i);";
                str43 = str46;
                str40 = ")get_store().insert_element_user(";
                emitPost(schemaType, 2, str4, z, Complex.DEFAULT_SUFFIX);
                emitImplementationPostamble();
                endBlock();
                printJavaDoc(new StringBuffer().append("Appends the value as the last ").append(str16).toString());
                emit(new StringBuffer().append("public void add").append(str44).append(str39).append(str2).append(str69).append(str17).append(str37).toString());
                startBlock();
                emitImplementationPreamble();
                emitDeclareTarget(true, str70);
                z8 = z;
                schemaType3 = schemaType;
                i2 = 2;
                emitPre(schemaType3, 2, str32, z8);
                emitAddTarget(str32, z8, true, str70);
                printJSetValue(i, str17, (SchemaTypeImpl) schemaProperty.getType());
                emitPost(schemaType3, 2, str32, z8);
                emitImplementationPostamble();
                endBlock();
            }
            printJavaDoc(new StringBuffer().append("Inserts and returns a new empty value (as xml) as the ith ").append(str16).toString());
            String str71 = str6;
            String str72 = str41;
            emit(new StringBuffer().append(str71).append(str3).append(" insertNew").append(str44).append(str72).toString());
            startBlock();
            emitImplementationPreamble();
            emitDeclareTarget(true, str3);
            emitPre(schemaType, 2, str4, z, Complex.DEFAULT_SUFFIX);
            if (z11) {
                str45 = str42;
                emit(new StringBuffer().append("target = (").append(str3).append(str40).append(str5).append(str43).append(str32).append(str45).toString());
            } else {
                str45 = str42;
                emit(new StringBuffer().append("target = (").append(str3).append(str40).append(str32).append(str45).toString());
            }
            emitPost(schemaType, 2, str4, z, Complex.DEFAULT_SUFFIX);
            emit("return target;");
            emitImplementationPostamble();
            endBlock();
            printJavaDoc(new StringBuffer().append("Appends and returns a new empty value (as xml) as the last ").append(str16).toString());
            emit(new StringBuffer().append(str71).append(str3).append(" addNew").append(str44).append(str19).toString());
            startBlock();
            emitImplementationPreamble();
            emitDeclareTarget(true, str3);
            emitPre(schemaType3, i2, str32, z8);
            emitAddTarget(str32, z8, true, str3);
            emitPost(schemaType3, i2, str32, z8);
            emit("return target;");
            emitImplementationPostamble();
            endBlock();
            printJavaDoc(new StringBuffer().append("Removes the ith ").append(str16).toString());
            emit(new StringBuffer().append("public void remove").append(str44).append(str72).toString());
            startBlock();
            emitImplementationPreamble();
            emitPre(schemaType, 3, str4, z, Complex.DEFAULT_SUFFIX);
            emit(new StringBuffer().append("get_store().remove_element(").append(str5).append(str45).toString());
            emitPost(schemaType, 3, str4, z, Complex.DEFAULT_SUFFIX);
            emitImplementationPostamble();
            endBlock();
        }
    }

    static void getTypeName(Class cls, StringBuffer stringBuffer) {
        int i = 0;
        while (cls.isArray()) {
            cls = cls.getComponentType();
            i++;
        }
        stringBuffer.append(cls.getName());
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
    }

    void printInnerTypeImpl(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem, boolean z) throws IOException {
        SchemaProperty[] derivedProperties;
        Map map;
        SchemaTypeCodePrinter schemaTypeCodePrinter = this;
        String shortJavaImplName = schemaType.getShortJavaImplName();
        printInnerTypeJavaDoc(schemaType);
        schemaTypeCodePrinter.startClass(schemaType, z);
        schemaTypeCodePrinter.printConstructor(schemaType, shortJavaImplName);
        printExtensionImplMethods(schemaType);
        if (!schemaType.isSimpleType()) {
            if (schemaType.getContentType() == 2) {
                ArrayList arrayList = null;
                for (SchemaType baseType = schemaType.getBaseType(); !baseType.isSimpleType() && !baseType.isBuiltinType(); baseType = baseType.getBaseType()) {
                    SchemaProperty[] derivedProperties2 = baseType.getDerivedProperties();
                    for (int i = 0; i < derivedProperties2.length; i++) {
                        if (!derivedProperties2[i].isAttribute() || schemaType.getAttributeProperty(derivedProperties2[i].getName()) == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(derivedProperties2[i]);
                        }
                    }
                }
                derivedProperties = schemaType.getProperties();
                if (arrayList != null) {
                    for (SchemaProperty schemaProperty : derivedProperties) {
                        arrayList.add(schemaProperty);
                    }
                    derivedProperties = (SchemaProperty[]) arrayList.toArray(new SchemaProperty[arrayList.size()]);
                }
            } else {
                derivedProperties = getDerivedProperties(schemaType);
            }
            SchemaProperty[] schemaPropertyArr = derivedProperties;
            Map printStaticFields = schemaTypeCodePrinter.printStaticFields(schemaPropertyArr);
            int i2 = 0;
            while (i2 < schemaPropertyArr.length) {
                SchemaProperty schemaProperty2 = schemaPropertyArr[i2];
                QName name = schemaProperty2.getName();
                String xmlTypeForProperty = schemaTypeCodePrinter.xmlTypeForProperty(schemaProperty2);
                int i3 = i2;
                Map map2 = printStaticFields;
                SchemaProperty[] schemaPropertyArr2 = schemaPropertyArr;
                String str = shortJavaImplName;
                printGetterImpls(shortJavaImplName, schemaProperty2, name, schemaProperty2.isAttribute(), schemaProperty2.getJavaPropertyName(), schemaProperty2.getJavaTypeCode(), schemaTypeCodePrinter.javaTypeForProperty(schemaProperty2), xmlTypeForProperty, schemaProperty2.hasNillable() != 0, schemaProperty2.extendsJavaOption(), schemaProperty2.extendsJavaArray(), schemaProperty2.extendsJavaSingleton(), xmlTypeForPropertyIsUnion(schemaProperty2), schemaTypeCodePrinter.getIdentifier(printStaticFields, name), schemaTypeCodePrinter.getSetIdentifier(printStaticFields, name));
                if (schemaProperty2.isReadOnly()) {
                    map = map2;
                } else {
                    map = map2;
                    printSetterImpls(name, schemaProperty2, schemaProperty2.isAttribute(), schemaProperty2.getJavaPropertyName(), schemaProperty2.getJavaTypeCode(), javaTypeForProperty(schemaProperty2), xmlTypeForProperty, schemaProperty2.hasNillable() != 0, schemaProperty2.extendsJavaOption(), schemaProperty2.extendsJavaArray(), schemaProperty2.extendsJavaSingleton(), xmlTypeForPropertyIsUnion(schemaProperty2), getIdentifier(map2, name), getSetIdentifier(map2, name), schemaType);
                }
                i2 = i3 + 1;
                schemaTypeCodePrinter = this;
                printStaticFields = map;
                schemaPropertyArr = schemaPropertyArr2;
                shortJavaImplName = str;
            }
        }
        printNestedTypeImpls(schemaType, schemaTypeSystem);
        endBlock();
    }

    private SchemaProperty[] getDerivedProperties(SchemaType schemaType) {
        QName name = schemaType.getName();
        if (name != null && name.equals(schemaType.getBaseType().getName())) {
            SchemaProperty[] derivedProperties = schemaType.getDerivedProperties();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i = 0; i < derivedProperties.length; i++) {
                linkedHashMap.put(derivedProperties[i].getName(), derivedProperties[i]);
            }
            for (SchemaType baseType = schemaType.getBaseType(); baseType != null && name.equals(baseType.getName()); baseType = baseType.getBaseType()) {
                SchemaProperty[] derivedProperties2 = baseType.getDerivedProperties();
                for (int i2 = 0; i2 < derivedProperties2.length; i2++) {
                    if (!linkedHashMap.containsKey(derivedProperties2[i2].getName())) {
                        linkedHashMap.put(derivedProperties2[i2].getName(), derivedProperties2[i2]);
                    }
                }
            }
            return (SchemaProperty[]) linkedHashMap.values().toArray(new SchemaProperty[0]);
        }
        return schemaType.getDerivedProperties();
    }

    private void printExtensionImplMethods(SchemaType schemaType) throws IOException {
        InterfaceExtension[] interfaceExtensions;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (interfaceExtensions = impl.getInterfaceExtensions()) == null) {
            return;
        }
        for (int i = 0; i < interfaceExtensions.length; i++) {
            InterfaceExtension.MethodSignature[] methods = interfaceExtensions[i].getMethods();
            if (methods != null) {
                for (int i2 = 0; i2 < methods.length; i2++) {
                    printJavaDoc(new StringBuffer().append("Implementation method for interface ").append(interfaceExtensions[i].getStaticHandler()).toString());
                    printInterfaceMethodDecl(methods[i2]);
                    startBlock();
                    printInterfaceMethodImpl(interfaceExtensions[i].getStaticHandler(), methods[i2]);
                    endBlock();
                }
            }
        }
    }

    void printInterfaceMethodDecl(InterfaceExtension.MethodSignature methodSignature) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("public ").append(methodSignature.getReturnType());
        stringBuffer.append(StringUtils.SPACE).append(methodSignature.getName()).append("(");
        String[] parameterTypes = methodSignature.getParameterTypes();
        int i = 0;
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(parameterTypes[i2]).append(" p").append(i2);
        }
        stringBuffer.append(")");
        String[] exceptionTypes = methodSignature.getExceptionTypes();
        while (i < exceptionTypes.length) {
            stringBuffer.append(new StringBuffer().append(i == 0 ? " throws " : ", ").append(exceptionTypes[i]).toString());
            i++;
        }
        emit(stringBuffer.toString());
    }

    void printInterfaceMethodImpl(String str, InterfaceExtension.MethodSignature methodSignature) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(60);
        if (!methodSignature.getReturnType().equals("void")) {
            stringBuffer.append("return ");
        }
        stringBuffer.append(str).append(".").append(methodSignature.getName()).append("(this");
        String[] parameterTypes = methodSignature.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            stringBuffer.append(new StringBuffer().append(", p").append(i).toString());
        }
        stringBuffer.append(");");
        emit(stringBuffer.toString());
    }

    void printNestedTypeImpls(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
            for (int i = 0; i < anonymousTypes.length; i++) {
                if (anonymousTypes[i].isSkippedAnonymousType()) {
                    printNestedTypeImpls(anonymousTypes[i], schemaTypeSystem);
                } else {
                    printInnerTypeImpl(anonymousTypes[i], schemaTypeSystem, true);
                }
            }
            if (!z) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }
}
