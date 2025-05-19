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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STCoordinate32 extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCoordinate32.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcoordinate322cc2type");

    public static final class Factory {
        private Factory() {
        }

        public static STCoordinate32 newInstance() {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().newInstance(STCoordinate32.type, null);
        }

        public static STCoordinate32 newInstance(XmlOptions xmlOptions) {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().newInstance(STCoordinate32.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCoordinate32.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 newValue(Object obj) {
            return (STCoordinate32) STCoordinate32.type.newValue(obj);
        }

        public static STCoordinate32 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(File file) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(file, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(file, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(InputStream inputStream) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(inputStream, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(inputStream, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(Reader reader) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(reader, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(reader, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(String str) throws XmlException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(str, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(str, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(URL url) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(url, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(url, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(Node node) throws XmlException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(node, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCoordinate32) XmlBeans.getContextTypeLoader().parse(node, STCoordinate32.type, xmlOptions);
        }
    }
}
