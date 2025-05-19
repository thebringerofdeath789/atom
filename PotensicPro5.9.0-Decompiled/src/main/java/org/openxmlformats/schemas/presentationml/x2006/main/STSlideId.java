package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STSlideId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSlideId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stslideida0b3type");

    public static final class Factory {
        private Factory() {
        }

        public static STSlideId newInstance() {
            return (STSlideId) XmlBeans.getContextTypeLoader().newInstance(STSlideId.type, null);
        }

        public static STSlideId newInstance(XmlOptions xmlOptions) {
            return (STSlideId) XmlBeans.getContextTypeLoader().newInstance(STSlideId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSlideId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSlideId.type, xmlOptions);
        }

        public static STSlideId newValue(Object obj) {
            return (STSlideId) STSlideId.type.newValue(obj);
        }

        public static STSlideId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(File file) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(file, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(file, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(InputStream inputStream) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(inputStream, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(inputStream, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(Reader reader) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(reader, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(reader, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(String str) throws XmlException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(str, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(str, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(URL url) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(url, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(url, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(Node node) throws XmlException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(node, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSlideId) XmlBeans.getContextTypeLoader().parse(node, STSlideId.type, xmlOptions);
        }
    }
}
