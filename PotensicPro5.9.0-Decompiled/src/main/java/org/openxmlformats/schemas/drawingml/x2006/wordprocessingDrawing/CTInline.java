package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTInline extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTInline.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctinline5726type");

    public static final class Factory {
        private Factory() {
        }

        public static CTInline newInstance() {
            return (CTInline) XmlBeans.getContextTypeLoader().newInstance(CTInline.type, null);
        }

        public static CTInline newInstance(XmlOptions xmlOptions) {
            return (CTInline) XmlBeans.getContextTypeLoader().newInstance(CTInline.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTInline.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTInline.type, xmlOptions);
        }

        public static CTInline parse(File file) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(file, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(file, CTInline.type, xmlOptions);
        }

        public static CTInline parse(InputStream inputStream) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(inputStream, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(inputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(Reader reader) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(reader, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(reader, CTInline.type, xmlOptions);
        }

        public static CTInline parse(String str) throws XmlException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(str, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(str, CTInline.type, xmlOptions);
        }

        public static CTInline parse(URL url) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(url, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(url, CTInline.type, xmlOptions);
        }

        public static CTInline parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(Node node) throws XmlException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(node, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTInline) XmlBeans.getContextTypeLoader().parse(node, CTInline.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewDocPr();

    CTEffectExtent addNewEffectExtent();

    CTPositiveSize2D addNewExtent();

    CTGraphicalObject addNewGraphic();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    long getDistB();

    long getDistL();

    long getDistR();

    long getDistT();

    CTNonVisualDrawingProps getDocPr();

    CTEffectExtent getEffectExtent();

    CTPositiveSize2D getExtent();

    CTGraphicalObject getGraphic();

    boolean isSetCNvGraphicFramePr();

    boolean isSetDistB();

    boolean isSetDistL();

    boolean isSetDistR();

    boolean isSetDistT();

    boolean isSetEffectExtent();

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setDistB(long j);

    void setDistL(long j);

    void setDistR(long j);

    void setDistT(long j);

    void setDocPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setEffectExtent(CTEffectExtent cTEffectExtent);

    void setExtent(CTPositiveSize2D cTPositiveSize2D);

    void setGraphic(CTGraphicalObject cTGraphicalObject);

    void unsetCNvGraphicFramePr();

    void unsetDistB();

    void unsetDistL();

    void unsetDistR();

    void unsetDistT();

    void unsetEffectExtent();

    STWrapDistance xgetDistB();

    STWrapDistance xgetDistL();

    STWrapDistance xgetDistR();

    STWrapDistance xgetDistT();

    void xsetDistB(STWrapDistance sTWrapDistance);

    void xsetDistL(STWrapDistance sTWrapDistance);

    void xsetDistR(STWrapDistance sTWrapDistance);

    void xsetDistT(STWrapDistance sTWrapDistance);
}
