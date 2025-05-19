package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTGraphicalObjectFrameNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrameNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgraphicalobjectframenonvisual833ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrameNonVisual newInstance() {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectFrameNonVisual.type, null);
        }

        public static CTGraphicalObjectFrameNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(String str) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Node node) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
