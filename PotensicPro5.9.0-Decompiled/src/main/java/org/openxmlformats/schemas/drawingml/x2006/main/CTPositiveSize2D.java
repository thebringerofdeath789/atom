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
public interface CTPositiveSize2D extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPositiveSize2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpositivesize2d0147type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositiveSize2D newInstance() {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().newInstance(CTPositiveSize2D.type, null);
        }

        public static CTPositiveSize2D newInstance(XmlOptions xmlOptions) {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().newInstance(CTPositiveSize2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPositiveSize2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(File file) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(file, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(file, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(inputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(Reader reader) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(reader, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(reader, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(String str) throws XmlException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(str, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(str, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(URL url) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(url, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(url, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(Node node) throws XmlException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(node, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveSize2D) XmlBeans.getContextTypeLoader().parse(node, CTPositiveSize2D.type, xmlOptions);
        }
    }

    long getCx();

    long getCy();

    void setCx(long j);

    void setCy(long j);

    STPositiveCoordinate xgetCx();

    STPositiveCoordinate xgetCy();

    void xsetCx(STPositiveCoordinate sTPositiveCoordinate);

    void xsetCy(STPositiveCoordinate sTPositiveCoordinate);
}
