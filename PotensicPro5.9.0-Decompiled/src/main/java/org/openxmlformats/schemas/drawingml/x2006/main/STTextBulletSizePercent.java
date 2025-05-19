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
public interface STTextBulletSizePercent extends STPercentage {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextBulletSizePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextbulletsizepercentb516type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextBulletSizePercent newInstance() {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().newInstance(STTextBulletSizePercent.type, null);
        }

        public static STTextBulletSizePercent newInstance(XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().newInstance(STTextBulletSizePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextBulletSizePercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent newValue(Object obj) {
            return (STTextBulletSizePercent) STTextBulletSizePercent.type.newValue(obj);
        }

        public static STTextBulletSizePercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(File file) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(file, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(file, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(Reader reader) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(reader, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(reader, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(String str) throws XmlException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(str, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(str, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(URL url) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(url, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(url, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(Node node) throws XmlException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(node, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextBulletSizePercent) XmlBeans.getContextTypeLoader().parse(node, STTextBulletSizePercent.type, xmlOptions);
        }
    }
}
