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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface SimpleTypeDocument extends XmlObject {
    public static final SchemaType type;

    TopLevelSimpleType addNewSimpleType();

    TopLevelSimpleType getSimpleType();

    void setSimpleType(TopLevelSimpleType topLevelSimpleType);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$SimpleTypeDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpletypedef7doctype");
    }

    public static final class Factory {
        public static SimpleTypeDocument newInstance() {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().newInstance(SimpleTypeDocument.type, null);
        }

        public static SimpleTypeDocument newInstance(XmlOptions xmlOptions) {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().newInstance(SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(String str) throws XmlException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(str, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(str, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(File file) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(file, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(file, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(URL url) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(url, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(url, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(Reader reader) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(reader, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(reader, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(Node node) throws XmlException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(node, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(node, SimpleTypeDocument.type, xmlOptions);
        }

        public static SimpleTypeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleTypeDocument.type, (XmlOptions) null);
        }

        public static SimpleTypeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SimpleTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleTypeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleTypeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleTypeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
