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
public interface STPointMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPointMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpointmeasurea96atype");

    public static final class Factory {
        private Factory() {
        }

        public static STPointMeasure newInstance() {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().newInstance(STPointMeasure.type, null);
        }

        public static STPointMeasure newInstance(XmlOptions xmlOptions) {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().newInstance(STPointMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPointMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure newValue(Object obj) {
            return (STPointMeasure) STPointMeasure.type.newValue(obj);
        }

        public static STPointMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(File file) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(file, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(file, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(Reader reader) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(reader, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(reader, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(String str) throws XmlException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(str, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(str, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(URL url) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(url, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(url, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPointMeasure.type, xmlOptions);
        }

        public static STPointMeasure parse(Node node) throws XmlException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(node, STPointMeasure.type, (XmlOptions) null);
        }

        public static STPointMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPointMeasure) XmlBeans.getContextTypeLoader().parse(node, STPointMeasure.type, xmlOptions);
        }
    }
}
