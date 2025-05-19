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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTMapInfo extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMapInfo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmapinfo1a09type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMapInfo newInstance() {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().newInstance(CTMapInfo.type, null);
        }

        public static CTMapInfo newInstance(XmlOptions xmlOptions) {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().newInstance(CTMapInfo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMapInfo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(File file) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(file, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(file, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(inputStream, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(inputStream, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(Reader reader) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(reader, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(reader, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(String str) throws XmlException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(str, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(str, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(URL url) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(url, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(url, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMapInfo.type, xmlOptions);
        }

        public static CTMapInfo parse(Node node) throws XmlException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(node, CTMapInfo.type, (XmlOptions) null);
        }

        public static CTMapInfo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMapInfo) XmlBeans.getContextTypeLoader().parse(node, CTMapInfo.type, xmlOptions);
        }
    }

    CTMap addNewMap();

    CTSchema addNewSchema();

    CTMap getMapArray(int i);

    CTMap[] getMapArray();

    List<CTMap> getMapList();

    CTSchema getSchemaArray(int i);

    CTSchema[] getSchemaArray();

    List<CTSchema> getSchemaList();

    String getSelectionNamespaces();

    CTMap insertNewMap(int i);

    CTSchema insertNewSchema(int i);

    void removeMap(int i);

    void removeSchema(int i);

    void setMapArray(int i, CTMap cTMap);

    void setMapArray(CTMap[] cTMapArr);

    void setSchemaArray(int i, CTSchema cTSchema);

    void setSchemaArray(CTSchema[] cTSchemaArr);

    void setSelectionNamespaces(String str);

    int sizeOfMapArray();

    int sizeOfSchemaArray();

    XmlString xgetSelectionNamespaces();

    void xsetSelectionNamespaces(XmlString xmlString);
}
