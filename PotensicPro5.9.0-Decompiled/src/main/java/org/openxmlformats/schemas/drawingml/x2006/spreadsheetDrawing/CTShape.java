package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTShape extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTShape.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctshapee40btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShape newInstance() {
            return (CTShape) XmlBeans.getContextTypeLoader().newInstance(CTShape.type, null);
        }

        public static CTShape newInstance(XmlOptions xmlOptions) {
            return (CTShape) XmlBeans.getContextTypeLoader().newInstance(CTShape.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShape.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShape.type, xmlOptions);
        }

        public static CTShape parse(File file) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(file, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(file, CTShape.type, xmlOptions);
        }

        public static CTShape parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(inputStream, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(inputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(Reader reader) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(reader, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(reader, CTShape.type, xmlOptions);
        }

        public static CTShape parse(String str) throws XmlException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(str, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(str, CTShape.type, xmlOptions);
        }

        public static CTShape parse(URL url) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(url, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(url, CTShape.type, xmlOptions);
        }

        public static CTShape parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(Node node) throws XmlException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(node, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShape) XmlBeans.getContextTypeLoader().parse(node, CTShape.type, xmlOptions);
        }
    }

    CTShapeNonVisual addNewNvSpPr();

    CTShapeProperties addNewSpPr();

    CTShapeStyle addNewStyle();

    CTTextBody addNewTxBody();

    boolean getFLocksText();

    boolean getFPublished();

    String getMacro();

    CTShapeNonVisual getNvSpPr();

    CTShapeProperties getSpPr();

    CTShapeStyle getStyle();

    String getTextlink();

    CTTextBody getTxBody();

    boolean isSetFLocksText();

    boolean isSetFPublished();

    boolean isSetMacro();

    boolean isSetStyle();

    boolean isSetTextlink();

    boolean isSetTxBody();

    void setFLocksText(boolean z);

    void setFPublished(boolean z);

    void setMacro(String str);

    void setNvSpPr(CTShapeNonVisual cTShapeNonVisual);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStyle(CTShapeStyle cTShapeStyle);

    void setTextlink(String str);

    void setTxBody(CTTextBody cTTextBody);

    void unsetFLocksText();

    void unsetFPublished();

    void unsetMacro();

    void unsetStyle();

    void unsetTextlink();

    void unsetTxBody();

    XmlBoolean xgetFLocksText();

    XmlBoolean xgetFPublished();

    XmlString xgetMacro();

    XmlString xgetTextlink();

    void xsetFLocksText(XmlBoolean xmlBoolean);

    void xsetFPublished(XmlBoolean xmlBoolean);

    void xsetMacro(XmlString xmlString);

    void xsetTextlink(XmlString xmlString);
}
