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
public interface CTEmptyElement extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTEmptyElement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctemptyelement05catype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEmptyElement newInstance() {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().newInstance(CTEmptyElement.type, null);
        }

        public static CTEmptyElement newInstance(XmlOptions xmlOptions) {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().newInstance(CTEmptyElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEmptyElement.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(File file) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(file, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(file, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(inputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(inputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(Reader reader) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(reader, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(reader, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(String str) throws XmlException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(str, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(str, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(URL url) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(url, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(url, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(Node node) throws XmlException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(node, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEmptyElement) XmlBeans.getContextTypeLoader().parse(node, CTEmptyElement.type, xmlOptions);
        }
    }
}
