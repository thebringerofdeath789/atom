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
public interface STSlideMasterId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSlideMasterId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stslidemasteridfe71type");

    public static final class Factory {
        private Factory() {
        }

        public static STSlideMasterId newInstance() {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().newInstance(STSlideMasterId.type, null);
        }

        public static STSlideMasterId newInstance(XmlOptions xmlOptions) {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().newInstance(STSlideMasterId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSlideMasterId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId newValue(Object obj) {
            return (STSlideMasterId) STSlideMasterId.type.newValue(obj);
        }

        public static STSlideMasterId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(File file) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(file, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(file, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(InputStream inputStream) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(inputStream, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(inputStream, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(Reader reader) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(reader, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(reader, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(String str) throws XmlException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(str, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(str, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(URL url) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(url, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(url, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(Node node) throws XmlException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(node, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSlideMasterId) XmlBeans.getContextTypeLoader().parse(node, STSlideMasterId.type, xmlOptions);
        }
    }
}
