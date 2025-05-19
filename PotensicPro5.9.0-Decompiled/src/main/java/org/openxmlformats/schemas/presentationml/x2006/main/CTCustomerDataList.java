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
public interface CTCustomerDataList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCustomerDataList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcustomerdatalist8b7ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCustomerDataList newInstance() {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().newInstance(CTCustomerDataList.type, null);
        }

        public static CTCustomerDataList newInstance(XmlOptions xmlOptions) {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().newInstance(CTCustomerDataList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCustomerDataList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(File file) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(file, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(file, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(inputStream, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(inputStream, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(Reader reader) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(reader, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(reader, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(String str) throws XmlException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(str, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(str, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(URL url) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(url, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(url, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCustomerDataList.type, xmlOptions);
        }

        public static CTCustomerDataList parse(Node node) throws XmlException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(node, CTCustomerDataList.type, (XmlOptions) null);
        }

        public static CTCustomerDataList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomerDataList) XmlBeans.getContextTypeLoader().parse(node, CTCustomerDataList.type, xmlOptions);
        }
    }

    CTCustomerData addNewCustData();

    CTTagsData addNewTags();

    CTCustomerData getCustDataArray(int i);

    CTCustomerData[] getCustDataArray();

    List<CTCustomerData> getCustDataList();

    CTTagsData getTags();

    CTCustomerData insertNewCustData(int i);

    boolean isSetTags();

    void removeCustData(int i);

    void setCustDataArray(int i, CTCustomerData cTCustomerData);

    void setCustDataArray(CTCustomerData[] cTCustomerDataArr);

    void setTags(CTTagsData cTTagsData);

    int sizeOfCustDataArray();

    void unsetTags();
}
