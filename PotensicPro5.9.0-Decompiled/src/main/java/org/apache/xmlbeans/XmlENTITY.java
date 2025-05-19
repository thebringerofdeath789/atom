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
public interface XmlENTITY extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITY");

    public static final class Factory {
        public static XmlENTITY newInstance() {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().newInstance(XmlENTITY.type, null);
        }

        public static XmlENTITY newInstance(XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().newInstance(XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY newValue(Object obj) {
            return (XmlENTITY) XmlENTITY.type.newValue(obj);
        }

        public static XmlENTITY parse(String str) throws XmlException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(str, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(str, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(File file) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(file, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(file, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(URL url) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(url, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(url, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(Reader reader) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(Node node) throws XmlException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(node, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(node, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITY.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITY.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITY.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
