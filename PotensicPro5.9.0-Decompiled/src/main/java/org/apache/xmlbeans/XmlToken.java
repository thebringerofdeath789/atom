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
public interface XmlToken extends XmlNormalizedString {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_token");

    public static final class Factory {
        public static XmlToken newInstance() {
            return (XmlToken) XmlBeans.getContextTypeLoader().newInstance(XmlToken.type, null);
        }

        public static XmlToken newInstance(XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().newInstance(XmlToken.type, xmlOptions);
        }

        public static XmlToken newValue(Object obj) {
            return (XmlToken) XmlToken.type.newValue(obj);
        }

        public static XmlToken parse(String str) throws XmlException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(str, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(str, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(File file) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(file, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(file, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(URL url) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(url, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(url, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(inputStream, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(inputStream, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(Reader reader) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(reader, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(reader, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(Node node) throws XmlException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(node, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(node, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlToken.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlToken.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlToken.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
