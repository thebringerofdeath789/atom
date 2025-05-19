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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTGroupShapeNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGroupShapeNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgroupshapenonvisual5a55type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShapeNonVisual newInstance() {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTGroupShapeNonVisual.type, null);
        }

        public static CTGroupShapeNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().newInstance(CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupShapeNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(File file) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(file, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(reader, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(String str) throws XmlException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(str, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(URL url) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(url, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(Node node) throws XmlException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeNonVisual) XmlBeans.getContextTypeLoader().parse(node, CTGroupShapeNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
