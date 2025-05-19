package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTSlideIdList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslideidlist70a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideIdList newInstance() {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().newInstance(CTSlideIdList.type, null);
        }

        public static CTSlideIdList newInstance(XmlOptions xmlOptions) {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().newInstance(CTSlideIdList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideIdList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(File file) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(file, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(file, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(Reader reader) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(reader, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(reader, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(String str) throws XmlException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(str, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(str, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(URL url) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(url, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(url, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(Node node) throws XmlException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(node, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdList) XmlBeans.getContextTypeLoader().parse(node, CTSlideIdList.type, xmlOptions);
        }
    }

    CTSlideIdListEntry addNewSldId();

    CTSlideIdListEntry getSldIdArray(int i);

    CTSlideIdListEntry[] getSldIdArray();

    List<CTSlideIdListEntry> getSldIdList();

    CTSlideIdListEntry insertNewSldId(int i);

    void removeSldId(int i);

    void setSldIdArray(int i, CTSlideIdListEntry cTSlideIdListEntry);

    void setSldIdArray(CTSlideIdListEntry[] cTSlideIdListEntryArr);

    int sizeOfSldIdArray();
}
