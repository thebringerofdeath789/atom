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
public interface STPositiveCoordinate32 extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPositiveCoordinate32.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpositivecoordinate321b9btype");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveCoordinate32 newInstance() {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().newInstance(STPositiveCoordinate32.type, null);
        }

        public static STPositiveCoordinate32 newInstance(XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().newInstance(STPositiveCoordinate32.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate32.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 newValue(Object obj) {
            return (STPositiveCoordinate32) STPositiveCoordinate32.type.newValue(obj);
        }

        public static STPositiveCoordinate32 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(File file) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(file, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(file, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(InputStream inputStream) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(Reader reader) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(reader, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(reader, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(String str) throws XmlException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(str, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(str, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(URL url) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(url, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(url, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(Node node) throws XmlException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(node, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveCoordinate32) XmlBeans.getContextTypeLoader().parse(node, STPositiveCoordinate32.type, xmlOptions);
        }
    }
}
