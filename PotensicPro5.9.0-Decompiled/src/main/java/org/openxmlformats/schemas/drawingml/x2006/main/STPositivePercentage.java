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
public interface STPositivePercentage extends STPercentage {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPositivePercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpositivepercentagedb9etype");

    public static final class Factory {
        private Factory() {
        }

        public static STPositivePercentage newInstance() {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().newInstance(STPositivePercentage.type, null);
        }

        public static STPositivePercentage newInstance(XmlOptions xmlOptions) {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().newInstance(STPositivePercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositivePercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage newValue(Object obj) {
            return (STPositivePercentage) STPositivePercentage.type.newValue(obj);
        }

        public static STPositivePercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(File file) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(file, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(file, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(Reader reader) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(reader, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(reader, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(String str) throws XmlException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(str, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(str, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(URL url) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(url, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(url, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(Node node) throws XmlException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(node, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPositivePercentage) XmlBeans.getContextTypeLoader().parse(node, STPositivePercentage.type, xmlOptions);
        }
    }
}
