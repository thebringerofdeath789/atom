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
public interface CTDocumentBase extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDocumentBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdocumentbasedf5ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocumentBase newInstance() {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().newInstance(CTDocumentBase.type, null);
        }

        public static CTDocumentBase newInstance(XmlOptions xmlOptions) {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().newInstance(CTDocumentBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocumentBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(File file) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(file, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(file, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(Reader reader) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(reader, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(reader, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(String str) throws XmlException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(str, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(str, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(URL url) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(url, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(url, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(Node node) throws XmlException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(node, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDocumentBase) XmlBeans.getContextTypeLoader().parse(node, CTDocumentBase.type, xmlOptions);
        }
    }

    CTBackground addNewBackground();

    CTBackground getBackground();

    boolean isSetBackground();

    void setBackground(CTBackground cTBackground);

    void unsetBackground();
}
