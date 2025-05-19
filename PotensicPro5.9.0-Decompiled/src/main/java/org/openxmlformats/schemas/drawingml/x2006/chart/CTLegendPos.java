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
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTLegendPos extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLegendPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlegendpos053ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLegendPos newInstance() {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().newInstance(CTLegendPos.type, null);
        }

        public static CTLegendPos newInstance(XmlOptions xmlOptions) {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().newInstance(CTLegendPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLegendPos.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(File file) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(file, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(file, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(inputStream, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(inputStream, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(Reader reader) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(reader, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(reader, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(String str) throws XmlException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(str, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(str, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(URL url) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(url, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(url, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(Node node) throws XmlException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(node, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLegendPos) XmlBeans.getContextTypeLoader().parse(node, CTLegendPos.type, xmlOptions);
        }
    }

    STLegendPos.Enum getVal();

    boolean isSetVal();

    void setVal(STLegendPos.Enum r1);

    void unsetVal();

    STLegendPos xgetVal();

    void xsetVal(STLegendPos sTLegendPos);
}
