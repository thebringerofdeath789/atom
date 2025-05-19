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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTShapeNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTShapeNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctshapenonvisualb619type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeNonVisual newInstance() {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTShapeNonVisual.type, null);
        }

        public static CTShapeNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTShapeNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShapeNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(File file) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(String str) throws XmlException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(URL url) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(Node node) throws XmlException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTShapeNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualDrawingShapeProps addNewCNvSpPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualDrawingProps getCNvPr();

    CTNonVisualDrawingShapeProps getCNvSpPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setCNvSpPr(CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
