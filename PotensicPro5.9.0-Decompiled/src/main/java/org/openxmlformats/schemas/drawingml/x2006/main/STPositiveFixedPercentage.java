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
public interface STPositiveFixedPercentage extends STPercentage {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPositiveFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpositivefixedpercentagee756type");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveFixedPercentage newInstance() {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().newInstance(STPositiveFixedPercentage.type, null);
        }

        public static STPositiveFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().newInstance(STPositiveFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage newValue(Object obj) {
            return (STPositiveFixedPercentage) STPositiveFixedPercentage.type.newValue(obj);
        }

        public static STPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(File file) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(file, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(file, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(Reader reader) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(reader, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(reader, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(String str) throws XmlException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(str, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(str, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(URL url) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(url, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(url, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(Node node) throws XmlException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(node, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(node, STPositiveFixedPercentage.type, xmlOptions);
        }
    }
}
