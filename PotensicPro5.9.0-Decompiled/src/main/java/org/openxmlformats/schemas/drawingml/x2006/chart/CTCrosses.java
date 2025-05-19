package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrosses;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTCrosses extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCrosses.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcrossesbcb8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCrosses newInstance() {
            return (CTCrosses) XmlBeans.getContextTypeLoader().newInstance(CTCrosses.type, null);
        }

        public static CTCrosses newInstance(XmlOptions xmlOptions) {
            return (CTCrosses) XmlBeans.getContextTypeLoader().newInstance(CTCrosses.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCrosses.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(File file) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(file, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(file, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(inputStream, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(inputStream, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(Reader reader) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(reader, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(reader, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(String str) throws XmlException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(str, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(str, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(URL url) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(url, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(url, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCrosses.type, xmlOptions);
        }

        public static CTCrosses parse(Node node) throws XmlException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(node, CTCrosses.type, (XmlOptions) null);
        }

        public static CTCrosses parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCrosses) XmlBeans.getContextTypeLoader().parse(node, CTCrosses.type, xmlOptions);
        }
    }

    STCrosses.Enum getVal();

    void setVal(STCrosses.Enum r1);

    STCrosses xgetVal();

    void xsetVal(STCrosses sTCrosses);
}
