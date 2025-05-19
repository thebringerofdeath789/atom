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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTExternalReference extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternalreference945ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalReference newInstance() {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().newInstance(CTExternalReference.type, null);
        }

        public static CTExternalReference newInstance(XmlOptions xmlOptions) {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().newInstance(CTExternalReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalReference.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(File file) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(file, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(file, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(Reader reader) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(reader, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(reader, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(String str) throws XmlException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(str, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(str, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(URL url) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(url, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(url, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalReference.type, xmlOptions);
        }

        public static CTExternalReference parse(Node node) throws XmlException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(node, CTExternalReference.type, (XmlOptions) null);
        }

        public static CTExternalReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReference) XmlBeans.getContextTypeLoader().parse(node, CTExternalReference.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
