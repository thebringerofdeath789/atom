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
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTMarkerStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMarkerStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmarkerstyle1f6ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarkerStyle newInstance() {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().newInstance(CTMarkerStyle.type, null);
        }

        public static CTMarkerStyle newInstance(XmlOptions xmlOptions) {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().newInstance(CTMarkerStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarkerStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(File file) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(file, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(file, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(inputStream, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(Reader reader) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(reader, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(reader, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(String str) throws XmlException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(str, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(str, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(URL url) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(url, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(url, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(Node node) throws XmlException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(node, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkerStyle) XmlBeans.getContextTypeLoader().parse(node, CTMarkerStyle.type, xmlOptions);
        }
    }

    STMarkerStyle.Enum getVal();

    void setVal(STMarkerStyle.Enum r1);

    STMarkerStyle xgetVal();

    void xsetVal(STMarkerStyle sTMarkerStyle);
}
