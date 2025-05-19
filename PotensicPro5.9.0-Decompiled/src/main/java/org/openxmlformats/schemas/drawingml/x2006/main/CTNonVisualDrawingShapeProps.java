package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTNonVisualDrawingShapeProps extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNonVisualDrawingShapeProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnonvisualdrawingshapepropsf17btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualDrawingShapeProps newInstance() {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualDrawingShapeProps.type, null);
        }

        public static CTNonVisualDrawingShapeProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingShapeProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(File file) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(String str) throws XmlException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(URL url) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(Node node) throws XmlException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTShapeLocking addNewSpLocks();

    CTOfficeArtExtensionList getExtLst();

    CTShapeLocking getSpLocks();

    boolean getTxBox();

    boolean isSetExtLst();

    boolean isSetSpLocks();

    boolean isSetTxBox();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setSpLocks(CTShapeLocking cTShapeLocking);

    void setTxBox(boolean z);

    void unsetExtLst();

    void unsetSpLocks();

    void unsetTxBox();

    XmlBoolean xgetTxBox();

    void xsetTxBox(XmlBoolean xmlBoolean);
}
