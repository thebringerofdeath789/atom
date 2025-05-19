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
public interface STTextIndentLevelType extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextIndentLevelType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextindentleveltypeaf86type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextIndentLevelType newInstance() {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().newInstance(STTextIndentLevelType.type, null);
        }

        public static STTextIndentLevelType newInstance(XmlOptions xmlOptions) {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().newInstance(STTextIndentLevelType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextIndentLevelType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType newValue(Object obj) {
            return (STTextIndentLevelType) STTextIndentLevelType.type.newValue(obj);
        }

        public static STTextIndentLevelType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(File file) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(file, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(file, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(Reader reader) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(reader, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(reader, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(String str) throws XmlException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(str, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(str, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(URL url) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(url, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(url, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(Node node) throws XmlException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(node, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextIndentLevelType) XmlBeans.getContextTypeLoader().parse(node, STTextIndentLevelType.type, xmlOptions);
        }
    }
}
