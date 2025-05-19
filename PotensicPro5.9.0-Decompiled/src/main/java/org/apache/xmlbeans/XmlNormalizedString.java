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
public interface XmlNormalizedString extends XmlString {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_normalizedString");

    public static final class Factory {
        public static XmlNormalizedString newInstance() {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().newInstance(XmlNormalizedString.type, null);
        }

        public static XmlNormalizedString newInstance(XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().newInstance(XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString newValue(Object obj) {
            return (XmlNormalizedString) XmlNormalizedString.type.newValue(obj);
        }

        public static XmlNormalizedString parse(String str) throws XmlException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(str, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(str, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(File file) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(file, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(file, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(URL url) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(url, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(url, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(Reader reader) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(reader, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(reader, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(Node node) throws XmlException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(node, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(node, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNormalizedString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNormalizedString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNormalizedString.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
