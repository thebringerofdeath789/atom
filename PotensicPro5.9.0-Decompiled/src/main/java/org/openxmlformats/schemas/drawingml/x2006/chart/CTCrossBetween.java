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
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTCrossBetween extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCrossBetween.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcrossbetweeneb14type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCrossBetween newInstance() {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().newInstance(CTCrossBetween.type, null);
        }

        public static CTCrossBetween newInstance(XmlOptions xmlOptions) {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().newInstance(CTCrossBetween.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCrossBetween.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(File file) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(file, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(file, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(inputStream, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(inputStream, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(Reader reader) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(reader, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(reader, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(String str) throws XmlException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(str, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(str, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(URL url) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(url, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(url, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(Node node) throws XmlException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(node, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCrossBetween) XmlBeans.getContextTypeLoader().parse(node, CTCrossBetween.type, xmlOptions);
        }
    }

    STCrossBetween.Enum getVal();

    void setVal(STCrossBetween.Enum r1);

    STCrossBetween xgetVal();

    void xsetVal(STCrossBetween sTCrossBetween);
}
