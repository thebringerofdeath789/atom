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
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTPresetGeometry2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPresetGeometry2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpresetgeometry2db1detype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPresetGeometry2D newInstance() {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().newInstance(CTPresetGeometry2D.type, null);
        }

        public static CTPresetGeometry2D newInstance(XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().newInstance(CTPresetGeometry2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPresetGeometry2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(File file) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(file, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(file, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(Reader reader) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(reader, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(reader, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(String str) throws XmlException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(str, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(str, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(URL url) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(url, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(url, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(Node node) throws XmlException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(node, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPresetGeometry2D) XmlBeans.getContextTypeLoader().parse(node, CTPresetGeometry2D.type, xmlOptions);
        }
    }

    CTGeomGuideList addNewAvLst();

    CTGeomGuideList getAvLst();

    STShapeType.Enum getPrst();

    boolean isSetAvLst();

    void setAvLst(CTGeomGuideList cTGeomGuideList);

    void setPrst(STShapeType.Enum r1);

    void unsetAvLst();

    STShapeType xgetPrst();

    void xsetPrst(STShapeType sTShapeType);
}
