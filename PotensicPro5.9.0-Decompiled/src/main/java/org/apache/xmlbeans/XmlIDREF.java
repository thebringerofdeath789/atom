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
public interface XmlIDREF extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_IDREF");

    public static final class Factory {
        public static XmlIDREF newInstance() {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().newInstance(XmlIDREF.type, null);
        }

        public static XmlIDREF newInstance(XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().newInstance(XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF newValue(Object obj) {
            return (XmlIDREF) XmlIDREF.type.newValue(obj);
        }

        public static XmlIDREF parse(String str) throws XmlException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(str, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(str, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(File file) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(file, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(file, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(URL url) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(url, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(url, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(Reader reader) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(Node node) throws XmlException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(node, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(node, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREF.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREF.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREF.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
