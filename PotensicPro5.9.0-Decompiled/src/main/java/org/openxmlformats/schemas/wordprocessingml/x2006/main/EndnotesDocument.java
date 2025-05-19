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
public interface EndnotesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(EndnotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("endnotes960edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static EndnotesDocument newInstance() {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().newInstance(EndnotesDocument.type, null);
        }

        public static EndnotesDocument newInstance(XmlOptions xmlOptions) {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().newInstance(EndnotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EndnotesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(File file) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(file, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(file, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(Reader reader) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(reader, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(reader, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(String str) throws XmlException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(str, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(str, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(URL url) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(url, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(url, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(Node node) throws XmlException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(node, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EndnotesDocument) XmlBeans.getContextTypeLoader().parse(node, EndnotesDocument.type, xmlOptions);
        }
    }

    CTEndnotes addNewEndnotes();

    CTEndnotes getEndnotes();

    void setEndnotes(CTEndnotes cTEndnotes);
}
