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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTRel extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctrel4519type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRel newInstance() {
            return (CTRel) XmlBeans.getContextTypeLoader().newInstance(CTRel.type, null);
        }

        public static CTRel newInstance(XmlOptions xmlOptions) {
            return (CTRel) XmlBeans.getContextTypeLoader().newInstance(CTRel.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRel.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRel.type, xmlOptions);
        }

        public static CTRel parse(File file) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(file, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(file, CTRel.type, xmlOptions);
        }

        public static CTRel parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(inputStream, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(inputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(Reader reader) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(reader, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(reader, CTRel.type, xmlOptions);
        }

        public static CTRel parse(String str) throws XmlException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(str, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(str, CTRel.type, xmlOptions);
        }

        public static CTRel parse(URL url) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(url, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(url, CTRel.type, xmlOptions);
        }

        public static CTRel parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(Node node) throws XmlException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(node, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRel) XmlBeans.getContextTypeLoader().parse(node, CTRel.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
