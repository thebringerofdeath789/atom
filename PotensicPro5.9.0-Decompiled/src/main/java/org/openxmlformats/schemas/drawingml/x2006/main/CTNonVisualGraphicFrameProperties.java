package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTNonVisualGraphicFrameProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNonVisualGraphicFrameProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnonvisualgraphicframeproperties43b6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualGraphicFrameProperties newInstance() {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualGraphicFrameProperties.type, null);
        }

        public static CTNonVisualGraphicFrameProperties newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualGraphicFrameProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(File file) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(String str) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(URL url) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(Node node) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGraphicalObjectFrameLocking addNewGraphicFrameLocks();

    CTOfficeArtExtensionList getExtLst();

    CTGraphicalObjectFrameLocking getGraphicFrameLocks();

    boolean isSetExtLst();

    boolean isSetGraphicFrameLocks();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGraphicFrameLocks(CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking);

    void unsetExtLst();

    void unsetGraphicFrameLocks();
}
