package org.openxmlformats.schemas.officeDocument.x2006.relationships;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface STRelationshipId extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STRelationshipId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("strelationshipid1e94type");

    public static final class Factory {
        private Factory() {
        }

        public static STRelationshipId newInstance() {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().newInstance(STRelationshipId.type, null);
        }

        public static STRelationshipId newInstance(XmlOptions xmlOptions) {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().newInstance(STRelationshipId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STRelationshipId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId newValue(Object obj) {
            return (STRelationshipId) STRelationshipId.type.newValue(obj);
        }

        public static STRelationshipId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(File file) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(file, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(file, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(InputStream inputStream) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(inputStream, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(inputStream, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(Reader reader) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(reader, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(reader, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(String str) throws XmlException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(str, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(str, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(URL url) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(url, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(url, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(Node node) throws XmlException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(node, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STRelationshipId) XmlBeans.getContextTypeLoader().parse(node, STRelationshipId.type, xmlOptions);
        }
    }
}
