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
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTAxPos extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTAxPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctaxposff69type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAxPos newInstance() {
            return (CTAxPos) XmlBeans.getContextTypeLoader().newInstance(CTAxPos.type, null);
        }

        public static CTAxPos newInstance(XmlOptions xmlOptions) {
            return (CTAxPos) XmlBeans.getContextTypeLoader().newInstance(CTAxPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAxPos.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(File file) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(file, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(file, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(inputStream, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(inputStream, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(Reader reader) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(reader, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(reader, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(String str) throws XmlException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(str, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(str, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(URL url) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(url, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(url, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(Node node) throws XmlException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(node, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAxPos) XmlBeans.getContextTypeLoader().parse(node, CTAxPos.type, xmlOptions);
        }
    }

    STAxPos.Enum getVal();

    void setVal(STAxPos.Enum r1);

    STAxPos xgetVal();

    void xsetVal(STAxPos sTAxPos);
}
