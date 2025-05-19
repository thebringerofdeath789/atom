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
public interface CTLegacyDrawing extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLegacyDrawing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlegacydrawing49f4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLegacyDrawing newInstance() {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().newInstance(CTLegacyDrawing.type, null);
        }

        public static CTLegacyDrawing newInstance(XmlOptions xmlOptions) {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().newInstance(CTLegacyDrawing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLegacyDrawing.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(File file) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(file, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(file, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(inputStream, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(inputStream, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(Reader reader) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(reader, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(reader, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(String str) throws XmlException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(str, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(str, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(URL url) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(url, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(url, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLegacyDrawing.type, xmlOptions);
        }

        public static CTLegacyDrawing parse(Node node) throws XmlException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(node, CTLegacyDrawing.type, (XmlOptions) null);
        }

        public static CTLegacyDrawing parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLegacyDrawing) XmlBeans.getContextTypeLoader().parse(node, CTLegacyDrawing.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
