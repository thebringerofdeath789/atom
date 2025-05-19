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
public interface STFixedPercentage extends STPercentage {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stfixedpercentagef0cftype");

    public static final class Factory {
        private Factory() {
        }

        public static STFixedPercentage newInstance() {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().newInstance(STFixedPercentage.type, null);
        }

        public static STFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().newInstance(STFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage newValue(Object obj) {
            return (STFixedPercentage) STFixedPercentage.type.newValue(obj);
        }

        public static STFixedPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(File file) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(file, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(file, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(Reader reader) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(reader, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(reader, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(String str) throws XmlException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(str, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(str, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(URL url) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(url, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(url, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(Node node) throws XmlException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(node, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFixedPercentage) XmlBeans.getContextTypeLoader().parse(node, STFixedPercentage.type, xmlOptions);
        }
    }
}
