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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STHexBinary3 extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHexBinary3.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sthexbinary314e2type");

    public static final class Factory {
        private Factory() {
        }

        public static STHexBinary3 newInstance() {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().newInstance(STHexBinary3.type, null);
        }

        public static STHexBinary3 newInstance(XmlOptions xmlOptions) {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().newInstance(STHexBinary3.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexBinary3.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 newValue(Object obj) {
            return (STHexBinary3) STHexBinary3.type.newValue(obj);
        }

        public static STHexBinary3 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(File file) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(file, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(file, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(InputStream inputStream) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(inputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(inputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(Reader reader) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(reader, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(reader, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(String str) throws XmlException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(str, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(str, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(URL url) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(url, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(url, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(Node node) throws XmlException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(node, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHexBinary3) XmlBeans.getContextTypeLoader().parse(node, STHexBinary3.type, xmlOptions);
        }
    }
}
