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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STTextBulletStartAtNum extends XmlInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextBulletStartAtNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextbulletstartatnum562btype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextBulletStartAtNum newInstance() {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().newInstance(STTextBulletStartAtNum.type, null);
        }

        public static STTextBulletStartAtNum newInstance(XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().newInstance(STTextBulletStartAtNum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextBulletStartAtNum.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum newValue(Object obj) {
            return (STTextBulletStartAtNum) STTextBulletStartAtNum.type.newValue(obj);
        }

        public static STTextBulletStartAtNum parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(File file) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(file, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(file, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(inputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(inputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(Reader reader) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(reader, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(reader, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(String str) throws XmlException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(str, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(str, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(URL url) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(url, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(url, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(Node node) throws XmlException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(node, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextBulletStartAtNum) XmlBeans.getContextTypeLoader().parse(node, STTextBulletStartAtNum.type, xmlOptions);
        }
    }
}
