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
public interface STPercentage extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpercentage0a85type");

    public static final class Factory {
        private Factory() {
        }

        public static STPercentage newInstance() {
            return (STPercentage) XmlBeans.getContextTypeLoader().newInstance(STPercentage.type, null);
        }

        public static STPercentage newInstance(XmlOptions xmlOptions) {
            return (STPercentage) XmlBeans.getContextTypeLoader().newInstance(STPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage newValue(Object obj) {
            return (STPercentage) STPercentage.type.newValue(obj);
        }

        public static STPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(File file) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(file, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(file, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(Reader reader) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(reader, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(reader, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(String str) throws XmlException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(str, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(str, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(URL url) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(url, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(url, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(Node node) throws XmlException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(node, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPercentage) XmlBeans.getContextTypeLoader().parse(node, STPercentage.type, xmlOptions);
        }
    }
}
