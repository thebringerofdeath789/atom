package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPivotCache extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPivotCache.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpivotcache4de9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotCache newInstance() {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().newInstance(CTPivotCache.type, null);
        }

        public static CTPivotCache newInstance(XmlOptions xmlOptions) {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().newInstance(CTPivotCache.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCache.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(File file) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(file, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(file, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(Reader reader) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(String str) throws XmlException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(str, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(str, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(URL url) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(url, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(url, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCache.type, xmlOptions);
        }

        public static CTPivotCache parse(Node node) throws XmlException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(node, CTPivotCache.type, (XmlOptions) null);
        }

        public static CTPivotCache parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCache) XmlBeans.getContextTypeLoader().parse(node, CTPivotCache.type, xmlOptions);
        }
    }

    long getCacheId();

    String getId();

    void setCacheId(long j);

    void setId(String str);

    XmlUnsignedInt xgetCacheId();

    STRelationshipId xgetId();

    void xsetCacheId(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(STRelationshipId sTRelationshipId);
}
