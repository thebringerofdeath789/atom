package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STHexColor extends XmlAnySimpleType {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHexColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sthexcolor55d0type");

    public static final class Factory {
        private Factory() {
        }

        public static STHexColor newInstance() {
            return (STHexColor) XmlBeans.getContextTypeLoader().newInstance(STHexColor.type, null);
        }

        public static STHexColor newInstance(XmlOptions xmlOptions) {
            return (STHexColor) XmlBeans.getContextTypeLoader().newInstance(STHexColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexColor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexColor.type, xmlOptions);
        }

        public static STHexColor newValue(Object obj) {
            return (STHexColor) STHexColor.type.newValue(obj);
        }

        public static STHexColor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(File file) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(file, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(file, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(InputStream inputStream) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(inputStream, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(inputStream, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(Reader reader) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(reader, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(reader, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(String str) throws XmlException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(str, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(str, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(URL url) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(url, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(url, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(Node node) throws XmlException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(node, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHexColor) XmlBeans.getContextTypeLoader().parse(node, STHexColor.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
