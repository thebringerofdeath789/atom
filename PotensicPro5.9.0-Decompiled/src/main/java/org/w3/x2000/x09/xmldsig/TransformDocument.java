package org.w3.x2000.x09.xmldsig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface TransformDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(TransformDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("transforme335doctype");

    public static final class Factory {
        private Factory() {
        }

        public static TransformDocument newInstance() {
            return (TransformDocument) XmlBeans.getContextTypeLoader().newInstance(TransformDocument.type, null);
        }

        public static TransformDocument newInstance(XmlOptions xmlOptions) {
            return (TransformDocument) XmlBeans.getContextTypeLoader().newInstance(TransformDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TransformDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(File file) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(file, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(file, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(Reader reader) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(reader, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(reader, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(String str) throws XmlException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(str, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(str, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(URL url) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(url, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(url, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(Node node) throws XmlException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(node, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TransformDocument) XmlBeans.getContextTypeLoader().parse(node, TransformDocument.type, xmlOptions);
        }
    }

    TransformType addNewTransform();

    TransformType getTransform();

    void setTransform(TransformType transformType);
}
