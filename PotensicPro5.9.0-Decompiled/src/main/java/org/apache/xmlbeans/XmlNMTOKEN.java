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
public interface XmlNMTOKEN extends XmlToken {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NMTOKEN");

    public static final class Factory {
        public static XmlNMTOKEN newInstance() {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKEN.type, null);
        }

        public static XmlNMTOKEN newInstance(XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN newValue(Object obj) {
            return (XmlNMTOKEN) XmlNMTOKEN.type.newValue(obj);
        }

        public static XmlNMTOKEN parse(String str) throws XmlException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(File file) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(URL url) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(Reader reader) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(Node node) throws XmlException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKEN.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKEN.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKEN.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
