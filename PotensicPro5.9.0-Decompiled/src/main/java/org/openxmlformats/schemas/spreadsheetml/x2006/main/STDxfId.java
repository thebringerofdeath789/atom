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
public interface STDxfId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STDxfId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stdxfid9fdctype");

    public static final class Factory {
        private Factory() {
        }

        public static STDxfId newInstance() {
            return (STDxfId) XmlBeans.getContextTypeLoader().newInstance(STDxfId.type, null);
        }

        public static STDxfId newInstance(XmlOptions xmlOptions) {
            return (STDxfId) XmlBeans.getContextTypeLoader().newInstance(STDxfId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDxfId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDxfId.type, xmlOptions);
        }

        public static STDxfId newValue(Object obj) {
            return (STDxfId) STDxfId.type.newValue(obj);
        }

        public static STDxfId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(File file) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(file, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(file, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(InputStream inputStream) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(inputStream, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(inputStream, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(Reader reader) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(reader, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(reader, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(String str) throws XmlException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(str, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(str, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(URL url) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(url, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(url, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDxfId.type, xmlOptions);
        }

        public static STDxfId parse(Node node) throws XmlException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(node, STDxfId.type, (XmlOptions) null);
        }

        public static STDxfId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STDxfId) XmlBeans.getContextTypeLoader().parse(node, STDxfId.type, xmlOptions);
        }
    }
}
