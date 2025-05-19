package org.apache.xmlbeans.impl.xb.xsdownload;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface DownloadedSchemasDocument extends XmlObject {
    public static final SchemaType type;

    DownloadedSchemas addNewDownloadedSchemas();

    DownloadedSchemas getDownloadedSchemas();

    void setDownloadedSchemas(DownloadedSchemas downloadedSchemas);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemas2dd7doctype");
    }

    public interface DownloadedSchemas extends XmlObject {
        public static final SchemaType type;

        DownloadedSchemaEntry addNewEntry();

        String getDefaultDirectory();

        DownloadedSchemaEntry getEntryArray(int i);

        DownloadedSchemaEntry[] getEntryArray();

        DownloadedSchemaEntry insertNewEntry(int i);

        boolean isSetDefaultDirectory();

        void removeEntry(int i);

        void setDefaultDirectory(String str);

        void setEntryArray(int i, DownloadedSchemaEntry downloadedSchemaEntry);

        void setEntryArray(DownloadedSchemaEntry[] downloadedSchemaEntryArr);

        int sizeOfEntryArray();

        void unsetDefaultDirectory();

        XmlToken xgetDefaultDirectory();

        void xsetDefaultDirectory(XmlToken xmlToken);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument$DownloadedSchemas");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemasDocument$DownloadedSchemas;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemasb3efelemtype");
        }

        public static final class Factory {
            public static DownloadedSchemas newInstance() {
                return (DownloadedSchemas) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemas.type, null);
            }

            public static DownloadedSchemas newInstance(XmlOptions xmlOptions) {
                return (DownloadedSchemas) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemas.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static DownloadedSchemasDocument newInstance() {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.type, null);
        }

        public static DownloadedSchemasDocument newInstance(XmlOptions xmlOptions) {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(String str) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(File file) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(URL url) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(Reader reader) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(Node node) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemasDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemasDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
