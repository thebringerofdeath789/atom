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
public interface ComplexTypeDocument extends XmlObject {
    public static final SchemaType type;

    TopLevelComplexType addNewComplexType();

    TopLevelComplexType getComplexType();

    void setComplexType(TopLevelComplexType topLevelComplexType);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexTypeDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complextype83cbdoctype");
    }

    public static final class Factory {
        public static ComplexTypeDocument newInstance() {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().newInstance(ComplexTypeDocument.type, null);
        }

        public static ComplexTypeDocument newInstance(XmlOptions xmlOptions) {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().newInstance(ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(String str) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(str, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(str, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(File file) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(file, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(file, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(URL url) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(url, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(url, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(Reader reader) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(reader, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(reader, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(Node node) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(node, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(node, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexTypeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexTypeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexTypeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
