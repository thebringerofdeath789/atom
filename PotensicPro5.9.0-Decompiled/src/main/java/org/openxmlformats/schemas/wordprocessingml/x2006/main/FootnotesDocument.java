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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface FootnotesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(FootnotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("footnotes8773doctype");

    public static final class Factory {
        private Factory() {
        }

        public static FootnotesDocument newInstance() {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().newInstance(FootnotesDocument.type, null);
        }

        public static FootnotesDocument newInstance(XmlOptions xmlOptions) {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().newInstance(FootnotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FootnotesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(File file) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(file, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(file, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(Reader reader) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(reader, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(reader, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(String str) throws XmlException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(str, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(str, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(URL url) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(url, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(url, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(Node node) throws XmlException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(node, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FootnotesDocument) XmlBeans.getContextTypeLoader().parse(node, FootnotesDocument.type, xmlOptions);
        }
    }

    CTFootnotes addNewFootnotes();

    CTFootnotes getFootnotes();

    void setFootnotes(CTFootnotes cTFootnotes);
}
