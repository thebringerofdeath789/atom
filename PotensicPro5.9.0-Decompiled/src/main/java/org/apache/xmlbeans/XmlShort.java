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
public interface XmlShort extends XmlInt {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_short");

    short getShortValue();

    void set(short s);

    void setShortValue(short s);

    short shortValue();

    public static final class Factory {
        public static XmlShort newInstance() {
            return (XmlShort) XmlBeans.getContextTypeLoader().newInstance(XmlShort.type, null);
        }

        public static XmlShort newInstance(XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().newInstance(XmlShort.type, xmlOptions);
        }

        public static XmlShort newValue(Object obj) {
            return (XmlShort) XmlShort.type.newValue(obj);
        }

        public static XmlShort parse(String str) throws XmlException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(str, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(str, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(File file) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(file, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(file, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(URL url) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(url, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(url, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(Reader reader) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(reader, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(reader, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(Node node) throws XmlException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(node, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(node, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlShort.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlShort.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlShort.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
