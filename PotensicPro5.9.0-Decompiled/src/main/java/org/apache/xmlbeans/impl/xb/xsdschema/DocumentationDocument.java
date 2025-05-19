package org.apache.xmlbeans.impl.xb.xsdschema;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface DocumentationDocument extends XmlObject {
    public static final SchemaType type;

    Documentation addNewDocumentation();

    Documentation getDocumentation();

    void setDocumentation(Documentation documentation);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("documentation6cdbdoctype");
    }

    public interface Documentation extends XmlObject {
        public static final SchemaType type;

        String getLang();

        String getSource();

        boolean isSetLang();

        boolean isSetSource();

        void setLang(String str);

        void setSource(String str);

        void unsetLang();

        void unsetSource();

        XmlLanguage xgetLang();

        XmlAnyURI xgetSource();

        void xsetLang(XmlLanguage xmlLanguage);

        void xsetSource(XmlAnyURI xmlAnyURI);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument$Documentation");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("documentationa475elemtype");
        }

        public static final class Factory {
            public static Documentation newInstance() {
                return (Documentation) XmlBeans.getContextTypeLoader().newInstance(Documentation.type, null);
            }

            public static Documentation newInstance(XmlOptions xmlOptions) {
                return (Documentation) XmlBeans.getContextTypeLoader().newInstance(Documentation.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static DocumentationDocument newInstance() {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, null);
        }

        public static DocumentationDocument newInstance(XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(String str) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(str, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(str, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(File file) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(file, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(file, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(URL url) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(url, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(url, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(Reader reader) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(reader, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(reader, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(Node node) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(node, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(node, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DocumentationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DocumentationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DocumentationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
