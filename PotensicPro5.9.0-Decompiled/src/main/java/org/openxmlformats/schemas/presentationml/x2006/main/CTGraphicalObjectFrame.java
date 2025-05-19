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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTGraphicalObjectFrame extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrame.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgraphicalobjectframebfeatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrame newInstance() {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectFrame.type, null);
        }

        public static CTGraphicalObjectFrame newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrame.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(String str) throws XmlException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(Node node) throws XmlException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrame) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectFrame.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTGraphicalObject addNewGraphic();

    CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr();

    CTTransform2D addNewXfrm();

    CTExtensionListModify getExtLst();

    CTGraphicalObject getGraphic();

    CTGraphicalObjectFrameNonVisual getNvGraphicFramePr();

    CTTransform2D getXfrm();

    boolean isSetExtLst();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setGraphic(CTGraphicalObject cTGraphicalObject);

    void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual);

    void setXfrm(CTTransform2D cTTransform2D);

    void unsetExtLst();
}
