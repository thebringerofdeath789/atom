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
public interface STEighthPointMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STEighthPointMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("steighthpointmeasure3371type");

    public static final class Factory {
        private Factory() {
        }

        public static STEighthPointMeasure newInstance() {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().newInstance(STEighthPointMeasure.type, null);
        }

        public static STEighthPointMeasure newInstance(XmlOptions xmlOptions) {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().newInstance(STEighthPointMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STEighthPointMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure newValue(Object obj) {
            return (STEighthPointMeasure) STEighthPointMeasure.type.newValue(obj);
        }

        public static STEighthPointMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(File file) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(file, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(file, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(Reader reader) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(reader, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(reader, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(String str) throws XmlException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(str, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(str, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(URL url) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(url, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(url, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STEighthPointMeasure.type, xmlOptions);
        }

        public static STEighthPointMeasure parse(Node node) throws XmlException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(node, STEighthPointMeasure.type, (XmlOptions) null);
        }

        public static STEighthPointMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STEighthPointMeasure) XmlBeans.getContextTypeLoader().parse(node, STEighthPointMeasure.type, xmlOptions);
        }
    }
}
