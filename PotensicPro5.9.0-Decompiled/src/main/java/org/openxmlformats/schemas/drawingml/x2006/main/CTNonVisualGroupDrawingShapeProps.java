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
public interface CTNonVisualGroupDrawingShapeProps extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNonVisualGroupDrawingShapeProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnonvisualgroupdrawingshapeprops610ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualGroupDrawingShapeProps newInstance() {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualGroupDrawingShapeProps.type, null);
        }

        public static CTNonVisualGroupDrawingShapeProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().newInstance(CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(File file) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(file, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(reader, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(String str) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(str, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(URL url) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(url, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Node node) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) XmlBeans.getContextTypeLoader().parse(node, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGroupLocking addNewGrpSpLocks();

    CTOfficeArtExtensionList getExtLst();

    CTGroupLocking getGrpSpLocks();

    boolean isSetExtLst();

    boolean isSetGrpSpLocks();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGrpSpLocks(CTGroupLocking cTGroupLocking);

    void unsetExtLst();

    void unsetGrpSpLocks();
}
