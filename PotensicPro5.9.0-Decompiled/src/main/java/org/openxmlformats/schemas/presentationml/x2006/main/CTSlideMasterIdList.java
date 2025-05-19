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
public interface CTSlideMasterIdList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideMasterIdList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslidemasteridlist0b63type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMasterIdList newInstance() {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().newInstance(CTSlideMasterIdList.type, null);
        }

        public static CTSlideMasterIdList newInstance(XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().newInstance(CTSlideMasterIdList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(File file) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(file, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(file, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(Reader reader) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(String str) throws XmlException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(str, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(str, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(URL url) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(url, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(url, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(Node node) throws XmlException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(node, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterIdList) XmlBeans.getContextTypeLoader().parse(node, CTSlideMasterIdList.type, xmlOptions);
        }
    }

    CTSlideMasterIdListEntry addNewSldMasterId();

    CTSlideMasterIdListEntry getSldMasterIdArray(int i);

    CTSlideMasterIdListEntry[] getSldMasterIdArray();

    List<CTSlideMasterIdListEntry> getSldMasterIdList();

    CTSlideMasterIdListEntry insertNewSldMasterId(int i);

    void removeSldMasterId(int i);

    void setSldMasterIdArray(int i, CTSlideMasterIdListEntry cTSlideMasterIdListEntry);

    void setSldMasterIdArray(CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr);

    int sizeOfSldMasterIdArray();
}
