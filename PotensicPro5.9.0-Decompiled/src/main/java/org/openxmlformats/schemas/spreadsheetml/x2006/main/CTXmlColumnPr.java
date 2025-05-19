package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTXmlColumnPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTXmlColumnPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctxmlcolumnprc14etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTXmlColumnPr newInstance() {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().newInstance(CTXmlColumnPr.type, null);
        }

        public static CTXmlColumnPr newInstance(XmlOptions xmlOptions) {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().newInstance(CTXmlColumnPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXmlColumnPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(File file) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(file, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(file, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(Reader reader) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(reader, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(reader, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(String str) throws XmlException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(str, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(str, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(URL url) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(url, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(url, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXmlColumnPr.type, xmlOptions);
        }

        public static CTXmlColumnPr parse(Node node) throws XmlException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(node, CTXmlColumnPr.type, (XmlOptions) null);
        }

        public static CTXmlColumnPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlColumnPr) XmlBeans.getContextTypeLoader().parse(node, CTXmlColumnPr.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    boolean getDenormalized();

    CTExtensionList getExtLst();

    long getMapId();

    STXmlDataType.Enum getXmlDataType();

    String getXpath();

    boolean isSetDenormalized();

    boolean isSetExtLst();

    void setDenormalized(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setMapId(long j);

    void setXmlDataType(STXmlDataType.Enum r1);

    void setXpath(String str);

    void unsetDenormalized();

    void unsetExtLst();

    XmlBoolean xgetDenormalized();

    XmlUnsignedInt xgetMapId();

    STXmlDataType xgetXmlDataType();

    STXstring xgetXpath();

    void xsetDenormalized(XmlBoolean xmlBoolean);

    void xsetMapId(XmlUnsignedInt xmlUnsignedInt);

    void xsetXmlDataType(STXmlDataType sTXmlDataType);

    void xsetXpath(STXstring sTXstring);
}
