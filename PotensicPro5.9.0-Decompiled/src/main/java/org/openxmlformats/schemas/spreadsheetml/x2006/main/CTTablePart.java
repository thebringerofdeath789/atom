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
public interface CTTablePart extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTablePart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablepart1140type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTablePart newInstance() {
            return (CTTablePart) XmlBeans.getContextTypeLoader().newInstance(CTTablePart.type, null);
        }

        public static CTTablePart newInstance(XmlOptions xmlOptions) {
            return (CTTablePart) XmlBeans.getContextTypeLoader().newInstance(CTTablePart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTablePart.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(File file) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(file, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(file, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(inputStream, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(inputStream, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(Reader reader) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(reader, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(reader, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(String str) throws XmlException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(str, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(str, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(URL url) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(url, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(url, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTablePart.type, xmlOptions);
        }

        public static CTTablePart parse(Node node) throws XmlException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(node, CTTablePart.type, (XmlOptions) null);
        }

        public static CTTablePart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTablePart) XmlBeans.getContextTypeLoader().parse(node, CTTablePart.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
