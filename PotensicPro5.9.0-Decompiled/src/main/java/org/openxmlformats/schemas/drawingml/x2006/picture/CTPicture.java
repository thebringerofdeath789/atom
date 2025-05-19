package org.openxmlformats.schemas.drawingml.x2006.picture;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTPicture extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPicture.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpicture1d48type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPicture newInstance() {
            return (CTPicture) XmlBeans.getContextTypeLoader().newInstance(CTPicture.type, null);
        }

        public static CTPicture newInstance(XmlOptions xmlOptions) {
            return (CTPicture) XmlBeans.getContextTypeLoader().newInstance(CTPicture.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPicture.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(File file) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(file, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(file, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(inputStream, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(inputStream, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(Reader reader) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(reader, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(reader, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(String str) throws XmlException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(str, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(str, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(URL url) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(url, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(url, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(Node node) throws XmlException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(node, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPicture) XmlBeans.getContextTypeLoader().parse(node, CTPicture.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTPictureNonVisual addNewNvPicPr();

    CTShapeProperties addNewSpPr();

    CTBlipFillProperties getBlipFill();

    CTPictureNonVisual getNvPicPr();

    CTShapeProperties getSpPr();

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setNvPicPr(CTPictureNonVisual cTPictureNonVisual);

    void setSpPr(CTShapeProperties cTShapeProperties);
}
