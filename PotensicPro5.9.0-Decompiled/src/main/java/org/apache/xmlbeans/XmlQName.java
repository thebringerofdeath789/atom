package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
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
public interface XmlQName extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_QName");

    QName getQNameValue();

    QName qNameValue();

    void set(QName qName);

    void setQNameValue(QName qName);

    public static final class Factory {
        public static XmlQName newInstance() {
            return (XmlQName) XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, null);
        }

        public static XmlQName newInstance(XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, xmlOptions);
        }

        public static XmlQName newValue(Object obj) {
            return (XmlQName) XmlQName.type.newValue(obj);
        }

        public static XmlQName parse(String str) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(str, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(str, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(File file) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(file, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(file, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(URL url) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(url, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(url, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(Reader reader) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(reader, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(reader, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(Node node) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(node, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(node, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlQName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlQName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlQName.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
