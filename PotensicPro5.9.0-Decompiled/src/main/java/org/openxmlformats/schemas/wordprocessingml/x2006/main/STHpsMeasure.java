package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* loaded from: classes6.dex */
public interface STHpsMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sthpsmeasurec985type");

    public static final class Factory {
        private Factory() {
        }

        public static STHpsMeasure newInstance() {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(STHpsMeasure.type, null);
        }

        public static STHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(STHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure newValue(Object obj) {
            return (STHpsMeasure) STHpsMeasure.type.newValue(obj);
        }

        public static STHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(File file) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(String str) throws XmlException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(URL url) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(Node node) throws XmlException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, STHpsMeasure.type, xmlOptions);
        }
    }
}
