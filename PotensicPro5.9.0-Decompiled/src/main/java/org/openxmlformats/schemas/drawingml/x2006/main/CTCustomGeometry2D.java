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
public interface CTCustomGeometry2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCustomGeometry2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcustomgeometry2dca70type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCustomGeometry2D newInstance() {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().newInstance(CTCustomGeometry2D.type, null);
        }

        public static CTCustomGeometry2D newInstance(XmlOptions xmlOptions) {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().newInstance(CTCustomGeometry2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCustomGeometry2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(File file) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(file, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(file, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(Reader reader) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(reader, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(reader, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(String str) throws XmlException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(str, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(str, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(URL url) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(url, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(url, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCustomGeometry2D.type, xmlOptions);
        }

        public static CTCustomGeometry2D parse(Node node) throws XmlException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(node, CTCustomGeometry2D.type, (XmlOptions) null);
        }

        public static CTCustomGeometry2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCustomGeometry2D) XmlBeans.getContextTypeLoader().parse(node, CTCustomGeometry2D.type, xmlOptions);
        }
    }

    CTAdjustHandleList addNewAhLst();

    CTGeomGuideList addNewAvLst();

    CTConnectionSiteList addNewCxnLst();

    CTGeomGuideList addNewGdLst();

    CTPath2DList addNewPathLst();

    CTGeomRect addNewRect();

    CTAdjustHandleList getAhLst();

    CTGeomGuideList getAvLst();

    CTConnectionSiteList getCxnLst();

    CTGeomGuideList getGdLst();

    CTPath2DList getPathLst();

    CTGeomRect getRect();

    boolean isSetAhLst();

    boolean isSetAvLst();

    boolean isSetCxnLst();

    boolean isSetGdLst();

    boolean isSetRect();

    void setAhLst(CTAdjustHandleList cTAdjustHandleList);

    void setAvLst(CTGeomGuideList cTGeomGuideList);

    void setCxnLst(CTConnectionSiteList cTConnectionSiteList);

    void setGdLst(CTGeomGuideList cTGeomGuideList);

    void setPathLst(CTPath2DList cTPath2DList);

    void setRect(CTGeomRect cTGeomRect);

    void unsetAhLst();

    void unsetAvLst();

    void unsetCxnLst();

    void unsetGdLst();

    void unsetRect();
}
