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
public interface CTGeomRect extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGeomRect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgeomrect53dbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomRect newInstance() {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().newInstance(CTGeomRect.type, null);
        }

        public static CTGeomRect newInstance(XmlOptions xmlOptions) {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().newInstance(CTGeomRect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGeomRect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(File file) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(file, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(file, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(inputStream, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(inputStream, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(Reader reader) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(reader, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(reader, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(String str) throws XmlException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(str, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(str, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(URL url) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(url, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(url, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(Node node) throws XmlException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(node, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomRect) XmlBeans.getContextTypeLoader().parse(node, CTGeomRect.type, xmlOptions);
        }
    }

    Object getB();

    Object getL();

    Object getR();

    Object getT();

    void setB(Object obj);

    void setL(Object obj);

    void setR(Object obj);

    void setT(Object obj);

    STAdjCoordinate xgetB();

    STAdjCoordinate xgetL();

    STAdjCoordinate xgetR();

    STAdjCoordinate xgetT();

    void xsetB(STAdjCoordinate sTAdjCoordinate);

    void xsetL(STAdjCoordinate sTAdjCoordinate);

    void xsetR(STAdjCoordinate sTAdjCoordinate);

    void xsetT(STAdjCoordinate sTAdjCoordinate);
}
