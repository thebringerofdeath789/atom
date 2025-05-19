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
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTTickMark extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTickMark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttickmarke7f2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTickMark newInstance() {
            return (CTTickMark) XmlBeans.getContextTypeLoader().newInstance(CTTickMark.type, null);
        }

        public static CTTickMark newInstance(XmlOptions xmlOptions) {
            return (CTTickMark) XmlBeans.getContextTypeLoader().newInstance(CTTickMark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTickMark.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(File file) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(file, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(file, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(inputStream, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(inputStream, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(Reader reader) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(reader, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(reader, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(String str) throws XmlException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(str, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(str, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(URL url) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(url, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(url, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTickMark.type, xmlOptions);
        }

        public static CTTickMark parse(Node node) throws XmlException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(node, CTTickMark.type, (XmlOptions) null);
        }

        public static CTTickMark parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTickMark) XmlBeans.getContextTypeLoader().parse(node, CTTickMark.type, xmlOptions);
        }
    }

    STTickMark.Enum getVal();

    boolean isSetVal();

    void setVal(STTickMark.Enum r1);

    void unsetVal();

    STTickMark xgetVal();

    void xsetVal(STTickMark sTTickMark);
}
