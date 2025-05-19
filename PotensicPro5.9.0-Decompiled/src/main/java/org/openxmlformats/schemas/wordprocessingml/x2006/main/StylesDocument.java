package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* loaded from: classes6.dex */
public interface StylesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(StylesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("styles2732doctype");

    public static final class Factory {
        private Factory() {
        }

        public static StylesDocument newInstance() {
            return (StylesDocument) XmlBeans.getContextTypeLoader().newInstance(StylesDocument.type, null);
        }

        public static StylesDocument newInstance(XmlOptions xmlOptions) {
            return (StylesDocument) XmlBeans.getContextTypeLoader().newInstance(StylesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, StylesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(File file) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(file, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(file, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(Reader reader) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(reader, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(reader, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(String str) throws XmlException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(str, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(str, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(URL url) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(url, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(url, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, StylesDocument.type, xmlOptions);
        }

        public static StylesDocument parse(Node node) throws XmlException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(node, StylesDocument.type, (XmlOptions) null);
        }

        public static StylesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (StylesDocument) XmlBeans.getContextTypeLoader().parse(node, StylesDocument.type, xmlOptions);
        }
    }

    CTStyles addNewStyles();

    CTStyles getStyles();

    void setStyles(CTStyles cTStyles);
}
