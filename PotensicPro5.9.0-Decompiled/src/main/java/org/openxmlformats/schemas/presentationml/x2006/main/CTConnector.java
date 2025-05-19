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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTConnector extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTConnector.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctconnector3522type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnector newInstance() {
            return (CTConnector) XmlBeans.getContextTypeLoader().newInstance(CTConnector.type, null);
        }

        public static CTConnector newInstance(XmlOptions xmlOptions) {
            return (CTConnector) XmlBeans.getContextTypeLoader().newInstance(CTConnector.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConnector.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(File file) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(file, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(file, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(InputStream inputStream) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(inputStream, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(inputStream, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(Reader reader) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(reader, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(reader, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(String str) throws XmlException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(str, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(str, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(URL url) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(url, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(url, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(Node node) throws XmlException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(node, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTConnector) XmlBeans.getContextTypeLoader().parse(node, CTConnector.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTConnectorNonVisual addNewNvCxnSpPr();

    CTShapeProperties addNewSpPr();

    CTShapeStyle addNewStyle();

    CTExtensionListModify getExtLst();

    CTConnectorNonVisual getNvCxnSpPr();

    CTShapeProperties getSpPr();

    CTShapeStyle getStyle();

    boolean isSetExtLst();

    boolean isSetStyle();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setNvCxnSpPr(CTConnectorNonVisual cTConnectorNonVisual);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStyle(CTShapeStyle cTShapeStyle);

    void unsetExtLst();

    void unsetStyle();
}
