package org.apache.xmlbeans.impl.xb.xsdownload;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface DownloadedSchemaEntry extends XmlObject {
    public static final SchemaType type;

    XmlAnyURI addNewSchemaLocation();

    void addSchemaLocation(String str);

    String getFilename();

    String getNamespace();

    String getSchemaLocationArray(int i);

    String[] getSchemaLocationArray();

    String getSha1();

    XmlAnyURI insertNewSchemaLocation(int i);

    void insertSchemaLocation(int i, String str);

    boolean isSetNamespace();

    void removeSchemaLocation(int i);

    void setFilename(String str);

    void setNamespace(String str);

    void setSchemaLocationArray(int i, String str);

    void setSchemaLocationArray(String[] strArr);

    void setSha1(String str);

    int sizeOfSchemaLocationArray();

    void unsetNamespace();

    XmlToken xgetFilename();

    XmlAnyURI xgetNamespace();

    XmlAnyURI xgetSchemaLocationArray(int i);

    XmlAnyURI[] xgetSchemaLocationArray();

    XmlToken xgetSha1();

    void xsetFilename(XmlToken xmlToken);

    void xsetNamespace(XmlAnyURI xmlAnyURI);

    void xsetSchemaLocationArray(int i, XmlAnyURI xmlAnyURI);

    void xsetSchemaLocationArray(XmlAnyURI[] xmlAnyURIArr);

    void xsetSha1(XmlToken xmlToken);

    /* renamed from: org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry;

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
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$xsdownload$DownloadedSchemaEntry;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemaentry1c75type");
    }

    public static final class Factory {
        public static DownloadedSchemaEntry newInstance() {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemaEntry.type, null);
        }

        public static DownloadedSchemaEntry newInstance(XmlOptions xmlOptions) {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(String str) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(File file) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(URL url) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(InputStream inputStream) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(Reader reader) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(Node node) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemaEntry.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemaEntry.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
