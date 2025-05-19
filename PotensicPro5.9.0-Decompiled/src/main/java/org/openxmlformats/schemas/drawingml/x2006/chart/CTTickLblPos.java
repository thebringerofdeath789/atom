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
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTTickLblPos extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTickLblPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctticklblposff61type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTickLblPos newInstance() {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().newInstance(CTTickLblPos.type, null);
        }

        public static CTTickLblPos newInstance(XmlOptions xmlOptions) {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().newInstance(CTTickLblPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTickLblPos.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(File file) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(file, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(file, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(inputStream, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(inputStream, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(Reader reader) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(reader, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(reader, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(String str) throws XmlException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(str, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(str, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(URL url) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(url, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(url, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(Node node) throws XmlException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(node, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTickLblPos) XmlBeans.getContextTypeLoader().parse(node, CTTickLblPos.type, xmlOptions);
        }
    }

    STTickLblPos.Enum getVal();

    boolean isSetVal();

    void setVal(STTickLblPos.Enum r1);

    void unsetVal();

    STTickLblPos xgetVal();

    void xsetVal(STTickLblPos sTTickLblPos);
}
