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
public interface CTAdjPoint2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTAdjPoint2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctadjpoint2d1656type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAdjPoint2D newInstance() {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().newInstance(CTAdjPoint2D.type, null);
        }

        public static CTAdjPoint2D newInstance(XmlOptions xmlOptions) {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().newInstance(CTAdjPoint2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAdjPoint2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(File file) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(file, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(file, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(Reader reader) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(reader, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(reader, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(String str) throws XmlException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(str, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(str, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(URL url) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(url, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(url, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(Node node) throws XmlException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(node, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjPoint2D) XmlBeans.getContextTypeLoader().parse(node, CTAdjPoint2D.type, xmlOptions);
        }
    }

    Object getX();

    Object getY();

    void setX(Object obj);

    void setY(Object obj);

    STAdjCoordinate xgetX();

    STAdjCoordinate xgetY();

    void xsetX(STAdjCoordinate sTAdjCoordinate);

    void xsetY(STAdjCoordinate sTAdjCoordinate);
}
