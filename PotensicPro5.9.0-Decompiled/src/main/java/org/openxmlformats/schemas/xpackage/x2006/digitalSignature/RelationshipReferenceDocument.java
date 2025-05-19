package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
public interface RelationshipReferenceDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(RelationshipReferenceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("relationshipreference8903doctype");

    public static final class Factory {
        private Factory() {
        }

        public static RelationshipReferenceDocument newInstance() {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().newInstance(RelationshipReferenceDocument.type, null);
        }

        public static RelationshipReferenceDocument newInstance(XmlOptions xmlOptions) {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().newInstance(RelationshipReferenceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RelationshipReferenceDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(File file) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(file, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(file, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(Reader reader) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(reader, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(reader, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(String str) throws XmlException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(str, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(str, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(URL url) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(url, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(url, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(Node node) throws XmlException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(node, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipReferenceDocument) XmlBeans.getContextTypeLoader().parse(node, RelationshipReferenceDocument.type, xmlOptions);
        }
    }

    CTRelationshipReference addNewRelationshipReference();

    CTRelationshipReference getRelationshipReference();

    void setRelationshipReference(CTRelationshipReference cTRelationshipReference);
}
