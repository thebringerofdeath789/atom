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
public interface XmlPositiveInteger extends XmlNonNegativeInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_positiveInteger");

    public static final class Factory {
        public static XmlPositiveInteger newInstance() {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlPositiveInteger.type, null);
        }

        public static XmlPositiveInteger newInstance(XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger newValue(Object obj) {
            return (XmlPositiveInteger) XmlPositiveInteger.type.newValue(obj);
        }

        public static XmlPositiveInteger parse(String str) throws XmlException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(File file) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(URL url) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(Reader reader) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(Node node) throws XmlException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlPositiveInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlPositiveInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlPositiveInteger.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
