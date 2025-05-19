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
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STSignedHpsMeasure extends XmlInteger {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSignedHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stsignedhpsmeasure8e89type");

    public static final class Factory {
        private Factory() {
        }

        public static STSignedHpsMeasure newInstance() {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(STSignedHpsMeasure.type, null);
        }

        public static STSignedHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().newInstance(STSignedHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSignedHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure newValue(Object obj) {
            return (STSignedHpsMeasure) STSignedHpsMeasure.type.newValue(obj);
        }

        public static STSignedHpsMeasure parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(File file) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(file, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(InputStream inputStream) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(inputStream, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(Reader reader) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(reader, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(String str) throws XmlException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(str, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(URL url) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(url, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSignedHpsMeasure.type, xmlOptions);
        }

        public static STSignedHpsMeasure parse(Node node) throws XmlException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, STSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static STSignedHpsMeasure parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSignedHpsMeasure) XmlBeans.getContextTypeLoader().parse(node, STSignedHpsMeasure.type, xmlOptions);
        }
    }
}
