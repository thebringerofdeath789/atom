package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCommonSlideData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCommonSlideData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcommonslidedata8c7ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCommonSlideData newInstance() {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().newInstance(CTCommonSlideData.type, null);
        }

        public static CTCommonSlideData newInstance(XmlOptions xmlOptions) {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().newInstance(CTCommonSlideData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCommonSlideData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(File file) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(file, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(file, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(inputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(inputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(Reader reader) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(reader, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(reader, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(String str) throws XmlException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(str, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(str, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(URL url) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(url, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(url, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(Node node) throws XmlException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(node, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCommonSlideData) XmlBeans.getContextTypeLoader().parse(node, CTCommonSlideData.type, xmlOptions);
        }
    }

    CTBackground addNewBg();

    CTControlList addNewControls();

    CTCustomerDataList addNewCustDataLst();

    CTExtensionList addNewExtLst();

    CTGroupShape addNewSpTree();

    CTBackground getBg();

    CTControlList getControls();

    CTCustomerDataList getCustDataLst();

    CTExtensionList getExtLst();

    String getName();

    CTGroupShape getSpTree();

    boolean isSetBg();

    boolean isSetControls();

    boolean isSetCustDataLst();

    boolean isSetExtLst();

    boolean isSetName();

    void setBg(CTBackground cTBackground);

    void setControls(CTControlList cTControlList);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setName(String str);

    void setSpTree(CTGroupShape cTGroupShape);

    void unsetBg();

    void unsetControls();

    void unsetCustDataLst();

    void unsetExtLst();

    void unsetName();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
