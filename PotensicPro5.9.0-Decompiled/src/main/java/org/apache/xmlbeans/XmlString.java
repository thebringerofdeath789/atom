package org.apache.xmlbeans;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface XmlString extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_string");

    public static final class Factory {
        public static XmlString newInstance() {
            return (XmlString) XmlBeans.getContextTypeLoader().newInstance(XmlString.type, null);
        }

        public static XmlString newInstance(XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().newInstance(XmlString.type, xmlOptions);
        }

        public static XmlString newValue(Object obj) {
            return (XmlString) XmlString.type.newValue(obj);
        }

        public static XmlString parse(String str) throws XmlException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(str, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(str, XmlString.type, xmlOptions);
        }

        public static XmlString parse(File file) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(file, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(file, XmlString.type, xmlOptions);
        }

        public static XmlString parse(URL url) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(url, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(url, XmlString.type, xmlOptions);
        }

        public static XmlString parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlString.type, xmlOptions);
        }

        public static XmlString parse(Reader reader) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(reader, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(reader, XmlString.type, xmlOptions);
        }

        public static XmlString parse(Node node) throws XmlException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(node, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(node, XmlString.type, xmlOptions);
        }

        public static XmlString parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlString.type, xmlOptions);
        }

        public static XmlString parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlString.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
