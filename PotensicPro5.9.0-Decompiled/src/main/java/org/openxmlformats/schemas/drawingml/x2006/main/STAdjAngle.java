package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STAdjAngle extends XmlAnySimpleType {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAdjAngle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stadjanglef017type");

    public static final class Factory {
        private Factory() {
        }

        public static STAdjAngle newInstance() {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().newInstance(STAdjAngle.type, null);
        }

        public static STAdjAngle newInstance(XmlOptions xmlOptions) {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().newInstance(STAdjAngle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAdjAngle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle newValue(Object obj) {
            return (STAdjAngle) STAdjAngle.type.newValue(obj);
        }

        public static STAdjAngle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(File file) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(file, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(file, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(InputStream inputStream) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(inputStream, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(inputStream, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(Reader reader) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(reader, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(reader, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(String str) throws XmlException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(str, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(str, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(URL url) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(url, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(url, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAdjAngle.type, xmlOptions);
        }

        public static STAdjAngle parse(Node node) throws XmlException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(node, STAdjAngle.type, (XmlOptions) null);
        }

        public static STAdjAngle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAdjAngle) XmlBeans.getContextTypeLoader().parse(node, STAdjAngle.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
