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
public interface CTNoFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNoFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnofillpropertiesbf92type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNoFillProperties newInstance() {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().newInstance(CTNoFillProperties.type, null);
        }

        public static CTNoFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().newInstance(CTNoFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNoFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(File file) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(file, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(file, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(reader, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(reader, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(String str) throws XmlException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(str, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(str, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(URL url) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(url, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(url, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(Node node) throws XmlException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(node, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNoFillProperties) XmlBeans.getContextTypeLoader().parse(node, CTNoFillProperties.type, xmlOptions);
        }
    }
}
