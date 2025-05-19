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
public interface ElementDocument extends XmlObject {
    public static final SchemaType type;

    TopLevelElement addNewElement();

    TopLevelElement getElement();

    void setElement(TopLevelElement topLevelElement);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$ElementDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("element7f99doctype");
    }

    public static final class Factory {
        public static ElementDocument newInstance() {
            return (ElementDocument) XmlBeans.getContextTypeLoader().newInstance(ElementDocument.type, null);
        }

        public static ElementDocument newInstance(XmlOptions xmlOptions) {
            return (ElementDocument) XmlBeans.getContextTypeLoader().newInstance(ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(String str) throws XmlException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(str, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(str, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(File file) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(file, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(file, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(URL url) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(url, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(url, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(Reader reader) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(reader, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(reader, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(Node node) throws XmlException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(node, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(node, ElementDocument.type, xmlOptions);
        }

        public static ElementDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ElementDocument.type, (XmlOptions) null);
        }

        public static ElementDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ElementDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ElementDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ElementDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ElementDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
