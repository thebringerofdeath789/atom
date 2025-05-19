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
public interface STPositiveFixedAngle extends STAngle {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPositiveFixedAngle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpositivefixedangle2503type");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveFixedAngle newInstance() {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().newInstance(STPositiveFixedAngle.type, null);
        }

        public static STPositiveFixedAngle newInstance(XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().newInstance(STPositiveFixedAngle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveFixedAngle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle newValue(Object obj) {
            return (STPositiveFixedAngle) STPositiveFixedAngle.type.newValue(obj);
        }

        public static STPositiveFixedAngle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(File file) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(file, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(file, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(InputStream inputStream) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(Reader reader) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(reader, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(reader, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(String str) throws XmlException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(str, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(str, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(URL url) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(url, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(url, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(Node node) throws XmlException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(node, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveFixedAngle) XmlBeans.getContextTypeLoader().parse(node, STPositiveFixedAngle.type, xmlOptions);
        }
    }
}
