package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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

/* loaded from: classes2.dex */
public interface PropertiesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(PropertiesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("propertiesee84doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PropertiesDocument newInstance() {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().newInstance(PropertiesDocument.type, null);
        }

        public static PropertiesDocument newInstance(XmlOptions xmlOptions) {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().newInstance(PropertiesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PropertiesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(File file) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(file, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(file, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(Reader reader) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(reader, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(reader, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(String str) throws XmlException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(str, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(str, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(URL url) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(url, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(url, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(Node node) throws XmlException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(node, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PropertiesDocument) XmlBeans.getContextTypeLoader().parse(node, PropertiesDocument.type, xmlOptions);
        }
    }

    CTProperties addNewProperties();

    CTProperties getProperties();

    void setProperties(CTProperties cTProperties);
}
