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
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTLogBase extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLogBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlogbase9191type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLogBase newInstance() {
            return (CTLogBase) XmlBeans.getContextTypeLoader().newInstance(CTLogBase.type, null);
        }

        public static CTLogBase newInstance(XmlOptions xmlOptions) {
            return (CTLogBase) XmlBeans.getContextTypeLoader().newInstance(CTLogBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLogBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(File file) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(file, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(file, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(Reader reader) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(reader, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(reader, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(String str) throws XmlException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(str, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(str, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(URL url) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(url, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(url, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLogBase.type, xmlOptions);
        }

        public static CTLogBase parse(Node node) throws XmlException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(node, CTLogBase.type, (XmlOptions) null);
        }

        public static CTLogBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLogBase) XmlBeans.getContextTypeLoader().parse(node, CTLogBase.type, xmlOptions);
        }
    }

    double getVal();

    void setVal(double d);

    STLogBase xgetVal();

    void xsetVal(STLogBase sTLogBase);
}
