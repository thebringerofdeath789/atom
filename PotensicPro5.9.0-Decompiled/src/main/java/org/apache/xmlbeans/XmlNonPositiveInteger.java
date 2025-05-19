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
public interface XmlNonPositiveInteger extends XmlInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_nonPositiveInteger");

    public static final class Factory {
        public static XmlNonPositiveInteger newInstance() {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonPositiveInteger.type, null);
        }

        public static XmlNonPositiveInteger newInstance(XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger newValue(Object obj) {
            return (XmlNonPositiveInteger) XmlNonPositiveInteger.type.newValue(obj);
        }

        public static XmlNonPositiveInteger parse(String str) throws XmlException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(File file) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(URL url) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(Reader reader) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(Node node) throws XmlException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonPositiveInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonPositiveInteger.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
