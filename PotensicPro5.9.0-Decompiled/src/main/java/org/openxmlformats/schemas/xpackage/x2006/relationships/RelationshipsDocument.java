package org.openxmlformats.schemas.xpackage.x2006.relationships;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface RelationshipsDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(RelationshipsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("relationships93b3doctype");

    public static final class Factory {
        private Factory() {
        }

        public static RelationshipsDocument newInstance() {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().newInstance(RelationshipsDocument.type, null);
        }

        public static RelationshipsDocument newInstance(XmlOptions xmlOptions) {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().newInstance(RelationshipsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RelationshipsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(File file) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(file, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(file, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(Reader reader) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(reader, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(reader, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(String str) throws XmlException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(str, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(str, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(URL url) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(url, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(url, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RelationshipsDocument.type, xmlOptions);
        }

        public static RelationshipsDocument parse(Node node) throws XmlException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(node, RelationshipsDocument.type, (XmlOptions) null);
        }

        public static RelationshipsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipsDocument) XmlBeans.getContextTypeLoader().parse(node, RelationshipsDocument.type, xmlOptions);
        }
    }

    CTRelationships addNewRelationships();

    CTRelationships getRelationships();

    void setRelationships(CTRelationships cTRelationships);
}
