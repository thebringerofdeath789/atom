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
public interface STTwipsMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTwipsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttwipsmeasure1e23type");

    public static final class Factory {
        private Factory() {
        }

        public static STTwipsMeasure newInstance() {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().newInstance(STTwipsMeasure.type, null);
        }

        public static STTwipsMeasure newInstance(XmlOptions xmlOptions) {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().newInstance(STTwipsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTwipsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure newValue(Object obj) {
            return (STTwipsMeasure) STTwipsMeasure.type.newValue(obj);
        }

        public static STTwipsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(File file) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(file, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(file, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(Reader reader) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(reader, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(reader, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(String str) throws XmlException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(str, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(str, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(URL url) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(url, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(url, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(Node node) throws XmlException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(node, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTwipsMeasure) XmlBeans.getContextTypeLoader().parse(node, STTwipsMeasure.type, xmlOptions);
        }
    }
}
