package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPivotCaches extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPivotCaches.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpivotcaches4f32type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotCaches newInstance() {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().newInstance(CTPivotCaches.type, null);
        }

        public static CTPivotCaches newInstance(XmlOptions xmlOptions) {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().newInstance(CTPivotCaches.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCaches.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(File file) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(file, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(file, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(Reader reader) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(String str) throws XmlException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(str, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(str, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(URL url) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(url, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(url, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(Node node) throws XmlException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(node, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCaches) XmlBeans.getContextTypeLoader().parse(node, CTPivotCaches.type, xmlOptions);
        }
    }

    CTPivotCache addNewPivotCache();

    CTPivotCache getPivotCacheArray(int i);

    CTPivotCache[] getPivotCacheArray();

    List<CTPivotCache> getPivotCacheList();

    CTPivotCache insertNewPivotCache(int i);

    void removePivotCache(int i);

    void setPivotCacheArray(int i, CTPivotCache cTPivotCache);

    void setPivotCacheArray(CTPivotCache[] cTPivotCacheArr);

    int sizeOfPivotCacheArray();
}
