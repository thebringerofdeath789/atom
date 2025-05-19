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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTagsData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTagsData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttagsdatac662type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTagsData newInstance() {
            return (CTTagsData) XmlBeans.getContextTypeLoader().newInstance(CTTagsData.type, null);
        }

        public static CTTagsData newInstance(XmlOptions xmlOptions) {
            return (CTTagsData) XmlBeans.getContextTypeLoader().newInstance(CTTagsData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTagsData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(File file) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(file, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(file, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(inputStream, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(inputStream, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(Reader reader) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(reader, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(reader, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(String str) throws XmlException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(str, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(str, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(URL url) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(url, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(url, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTagsData.type, xmlOptions);
        }

        public static CTTagsData parse(Node node) throws XmlException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(node, CTTagsData.type, (XmlOptions) null);
        }

        public static CTTagsData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTagsData) XmlBeans.getContextTypeLoader().parse(node, CTTagsData.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
