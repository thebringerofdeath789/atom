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
public interface XmlID extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ID");

    public static final class Factory {
        public static XmlID newInstance() {
            return (XmlID) XmlBeans.getContextTypeLoader().newInstance(XmlID.type, null);
        }

        public static XmlID newInstance(XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().newInstance(XmlID.type, xmlOptions);
        }

        public static XmlID newValue(Object obj) {
            return (XmlID) XmlID.type.newValue(obj);
        }

        public static XmlID parse(String str) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(str, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(str, XmlID.type, xmlOptions);
        }

        public static XmlID parse(File file) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(file, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(file, XmlID.type, xmlOptions);
        }

        public static XmlID parse(URL url) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(url, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(url, XmlID.type, xmlOptions);
        }

        public static XmlID parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(inputStream, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(inputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(Reader reader) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(reader, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(reader, XmlID.type, xmlOptions);
        }

        public static XmlID parse(Node node) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(node, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(node, XmlID.type, xmlOptions);
        }

        public static XmlID parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlID.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
