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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTDocument1 extends CTDocumentBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDocument1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdocument64adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocument1 newInstance() {
            return (CTDocument1) XmlBeans.getContextTypeLoader().newInstance(CTDocument1.type, null);
        }

        public static CTDocument1 newInstance(XmlOptions xmlOptions) {
            return (CTDocument1) XmlBeans.getContextTypeLoader().newInstance(CTDocument1.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocument1.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(File file) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(file, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(file, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(Reader reader) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(reader, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(reader, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(String str) throws XmlException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(str, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(str, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(URL url) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(url, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(url, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(Node node) throws XmlException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(node, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDocument1) XmlBeans.getContextTypeLoader().parse(node, CTDocument1.type, xmlOptions);
        }
    }

    CTBody addNewBody();

    CTBody getBody();

    boolean isSetBody();

    void setBody(CTBody cTBody);

    void unsetBody();
}
