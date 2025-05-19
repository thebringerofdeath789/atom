package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STLineWidth extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLineWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlinewidth8313type");

    public static final class Factory {
        private Factory() {
        }

        public static STLineWidth newInstance() {
            return (STLineWidth) XmlBeans.getContextTypeLoader().newInstance(STLineWidth.type, null);
        }

        public static STLineWidth newInstance(XmlOptions xmlOptions) {
            return (STLineWidth) XmlBeans.getContextTypeLoader().newInstance(STLineWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineWidth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth newValue(Object obj) {
            return (STLineWidth) STLineWidth.type.newValue(obj);
        }

        public static STLineWidth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(File file) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(file, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(file, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(InputStream inputStream) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(inputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(inputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(Reader reader) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(reader, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(reader, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(String str) throws XmlException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(str, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(str, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(URL url) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(url, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(url, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(Node node) throws XmlException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(node, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLineWidth) XmlBeans.getContextTypeLoader().parse(node, STLineWidth.type, xmlOptions);
        }
    }
}
