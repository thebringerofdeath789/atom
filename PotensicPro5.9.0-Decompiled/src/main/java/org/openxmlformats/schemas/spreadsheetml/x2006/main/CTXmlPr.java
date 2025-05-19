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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTXmlPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTXmlPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctxmlpr2c58type");

    public static final class Factory {
        private Factory() {
        }

        public static CTXmlPr newInstance() {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().newInstance(CTXmlPr.type, null);
        }

        public static CTXmlPr newInstance(XmlOptions xmlOptions) {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().newInstance(CTXmlPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXmlPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(File file) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(file, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(file, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(Reader reader) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(reader, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(reader, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(String str) throws XmlException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(str, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(str, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(URL url) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(url, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(url, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(Node node) throws XmlException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(node, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlPr) XmlBeans.getContextTypeLoader().parse(node, CTXmlPr.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    long getMapId();

    STXmlDataType.Enum getXmlDataType();

    String getXpath();

    boolean isSetExtLst();

    void setExtLst(CTExtensionList cTExtensionList);

    void setMapId(long j);

    void setXmlDataType(STXmlDataType.Enum r1);

    void setXpath(String str);

    void unsetExtLst();

    XmlUnsignedInt xgetMapId();

    STXmlDataType xgetXmlDataType();

    STXstring xgetXpath();

    void xsetMapId(XmlUnsignedInt xmlUnsignedInt);

    void xsetXmlDataType(STXmlDataType sTXmlDataType);

    void xsetXpath(STXstring sTXstring);
}
