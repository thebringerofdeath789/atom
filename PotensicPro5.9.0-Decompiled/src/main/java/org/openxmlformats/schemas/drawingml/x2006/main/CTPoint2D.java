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
public interface CTPoint2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPoint2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpoint2d8193type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPoint2D newInstance() {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().newInstance(CTPoint2D.type, null);
        }

        public static CTPoint2D newInstance(XmlOptions xmlOptions) {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().newInstance(CTPoint2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPoint2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(File file) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(file, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(file, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(Reader reader) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(reader, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(reader, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(String str) throws XmlException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(str, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(str, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(URL url) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(url, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(url, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(Node node) throws XmlException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(node, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPoint2D) XmlBeans.getContextTypeLoader().parse(node, CTPoint2D.type, xmlOptions);
        }
    }

    long getX();

    long getY();

    void setX(long j);

    void setY(long j);

    STCoordinate xgetX();

    STCoordinate xgetY();

    void xsetX(STCoordinate sTCoordinate);

    void xsetY(STCoordinate sTCoordinate);
}
