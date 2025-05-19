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
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STHexColorRGB extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHexColorRGB.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sthexcolorrgbd59dtype");

    public static final class Factory {
        private Factory() {
        }

        public static STHexColorRGB newInstance() {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().newInstance(STHexColorRGB.type, null);
        }

        public static STHexColorRGB newInstance(XmlOptions xmlOptions) {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().newInstance(STHexColorRGB.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexColorRGB.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB newValue(Object obj) {
            return (STHexColorRGB) STHexColorRGB.type.newValue(obj);
        }

        public static STHexColorRGB parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(File file) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(file, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(file, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(InputStream inputStream) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(inputStream, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(inputStream, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(Reader reader) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(reader, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(reader, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(String str) throws XmlException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(str, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(str, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(URL url) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(url, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(url, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(Node node) throws XmlException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(node, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHexColorRGB) XmlBeans.getContextTypeLoader().parse(node, STHexColorRGB.type, xmlOptions);
        }
    }
}
