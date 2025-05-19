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
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STCoordinate extends XmlLong {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcoordinatefae3type");

    public static final class Factory {
        private Factory() {
        }

        public static STCoordinate newInstance() {
            return (STCoordinate) XmlBeans.getContextTypeLoader().newInstance(STCoordinate.type, null);
        }

        public static STCoordinate newInstance(XmlOptions xmlOptions) {
            return (STCoordinate) XmlBeans.getContextTypeLoader().newInstance(STCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate newValue(Object obj) {
            return (STCoordinate) STCoordinate.type.newValue(obj);
        }

        public static STCoordinate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(File file) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(file, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(file, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(InputStream inputStream) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(Reader reader) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(String str) throws XmlException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(str, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(str, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(URL url) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(url, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(url, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(Node node) throws XmlException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(node, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCoordinate) XmlBeans.getContextTypeLoader().parse(node, STCoordinate.type, xmlOptions);
        }
    }
}
