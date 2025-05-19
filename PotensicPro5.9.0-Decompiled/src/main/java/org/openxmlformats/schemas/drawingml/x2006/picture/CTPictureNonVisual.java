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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTPictureNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPictureNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpicturenonvisual05adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureNonVisual newInstance() {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTPictureNonVisual.type, null);
        }

        public static CTPictureNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTPictureNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPictureNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(File file) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(String str) throws XmlException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(URL url) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(Node node) throws XmlException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTPictureNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualPictureProperties addNewCNvPicPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualPictureProperties getCNvPicPr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvPicPr(CTNonVisualPictureProperties cTNonVisualPictureProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
