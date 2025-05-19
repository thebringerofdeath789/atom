package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface STFillId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFillId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stfillida097type");

    public static final class Factory {
        private Factory() {
        }

        public static STFillId newInstance() {
            return (STFillId) XmlBeans.getContextTypeLoader().newInstance(STFillId.type, null);
        }

        public static STFillId newInstance(XmlOptions xmlOptions) {
            return (STFillId) XmlBeans.getContextTypeLoader().newInstance(STFillId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFillId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFillId.type, xmlOptions);
        }

        public static STFillId newValue(Object obj) {
            return (STFillId) STFillId.type.newValue(obj);
        }

        public static STFillId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFillId.type, xmlOptions);
        }

        public static STFillId parse(File file) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(file, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(file, STFillId.type, xmlOptions);
        }

        public static STFillId parse(InputStream inputStream) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(inputStream, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(inputStream, STFillId.type, xmlOptions);
        }

        public static STFillId parse(Reader reader) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(reader, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(reader, STFillId.type, xmlOptions);
        }

        public static STFillId parse(String str) throws XmlException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(str, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(str, STFillId.type, xmlOptions);
        }

        public static STFillId parse(URL url) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(url, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(url, STFillId.type, xmlOptions);
        }

        public static STFillId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFillId.type, xmlOptions);
        }

        public static STFillId parse(Node node) throws XmlException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(node, STFillId.type, (XmlOptions) null);
        }

        public static STFillId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFillId) XmlBeans.getContextTypeLoader().parse(node, STFillId.type, xmlOptions);
        }
    }
}
