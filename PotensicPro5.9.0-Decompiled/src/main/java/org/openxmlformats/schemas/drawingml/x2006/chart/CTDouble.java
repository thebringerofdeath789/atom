package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTDouble extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDouble.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdoublec10btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDouble newInstance() {
            return (CTDouble) XmlBeans.getContextTypeLoader().newInstance(CTDouble.type, null);
        }

        public static CTDouble newInstance(XmlOptions xmlOptions) {
            return (CTDouble) XmlBeans.getContextTypeLoader().newInstance(CTDouble.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDouble.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(File file) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(file, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(file, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(inputStream, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(inputStream, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(Reader reader) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(reader, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(reader, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(String str) throws XmlException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(str, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(str, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(URL url) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(url, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(url, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDouble.type, xmlOptions);
        }

        public static CTDouble parse(Node node) throws XmlException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(node, CTDouble.type, (XmlOptions) null);
        }

        public static CTDouble parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDouble) XmlBeans.getContextTypeLoader().parse(node, CTDouble.type, xmlOptions);
        }
    }

    double getVal();

    void setVal(double d);

    XmlDouble xgetVal();

    void xsetVal(XmlDouble xmlDouble);
}
