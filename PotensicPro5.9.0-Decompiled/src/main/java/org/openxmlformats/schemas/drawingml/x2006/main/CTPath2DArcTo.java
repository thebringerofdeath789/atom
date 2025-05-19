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
public interface CTPath2DArcTo extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPath2DArcTo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpath2darctodaa7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DArcTo newInstance() {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().newInstance(CTPath2DArcTo.type, null);
        }

        public static CTPath2DArcTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().newInstance(CTPath2DArcTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DArcTo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(File file) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(file, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(file, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(reader, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(String str) throws XmlException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(str, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(str, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(URL url) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(url, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(url, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath2DArcTo.type, xmlOptions);
        }

        public static CTPath2DArcTo parse(Node node) throws XmlException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(node, CTPath2DArcTo.type, (XmlOptions) null);
        }

        public static CTPath2DArcTo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DArcTo) XmlBeans.getContextTypeLoader().parse(node, CTPath2DArcTo.type, xmlOptions);
        }
    }

    Object getHR();

    Object getStAng();

    Object getSwAng();

    Object getWR();

    void setHR(Object obj);

    void setStAng(Object obj);

    void setSwAng(Object obj);

    void setWR(Object obj);

    STAdjCoordinate xgetHR();

    STAdjAngle xgetStAng();

    STAdjAngle xgetSwAng();

    STAdjCoordinate xgetWR();

    void xsetHR(STAdjCoordinate sTAdjCoordinate);

    void xsetStAng(STAdjAngle sTAdjAngle);

    void xsetSwAng(STAdjAngle sTAdjAngle);

    void xsetWR(STAdjCoordinate sTAdjCoordinate);
}
