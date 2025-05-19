package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface TopLevelSimpleType extends SimpleType {
    public static final SchemaType type;

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void xsetName(XmlNCName xmlNCName);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType;

        static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError().initCause(e);
            }
        }
    }

    static {
        Class cls;
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$TopLevelSimpleType;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelsimpletypec958type");
    }

    public static final class Factory {
        public static TopLevelSimpleType newInstance() {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().newInstance(TopLevelSimpleType.type, null);
        }

        public static TopLevelSimpleType newInstance(XmlOptions xmlOptions) {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().newInstance(TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(String str) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(str, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(str, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(File file) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(file, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(file, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(URL url) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(url, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(url, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(Reader reader) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(reader, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(reader, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(Node node) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(node, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(node, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelSimpleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelSimpleType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelSimpleType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
