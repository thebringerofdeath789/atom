package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STWrapDistance extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STWrapDistance.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stwrapdistanceea50type");

    public static final class Factory {
        private Factory() {
        }

        public static STWrapDistance newInstance() {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().newInstance(STWrapDistance.type, null);
        }

        public static STWrapDistance newInstance(XmlOptions xmlOptions) {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().newInstance(STWrapDistance.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STWrapDistance.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance newValue(Object obj) {
            return (STWrapDistance) STWrapDistance.type.newValue(obj);
        }

        public static STWrapDistance parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(File file) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(file, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(file, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(InputStream inputStream) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(inputStream, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(inputStream, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(Reader reader) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(reader, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(reader, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(String str) throws XmlException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(str, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(str, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(URL url) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(url, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(url, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(Node node) throws XmlException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(node, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STWrapDistance) XmlBeans.getContextTypeLoader().parse(node, STWrapDistance.type, xmlOptions);
        }
    }
}
