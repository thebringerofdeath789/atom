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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface ExternalLinkDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(ExternalLinkDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("externallinkb4c2doctype");

    public static final class Factory {
        private Factory() {
        }

        public static ExternalLinkDocument newInstance() {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().newInstance(ExternalLinkDocument.type, null);
        }

        public static ExternalLinkDocument newInstance(XmlOptions xmlOptions) {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().newInstance(ExternalLinkDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ExternalLinkDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(File file) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(file, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(file, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(Reader reader) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(reader, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(reader, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(String str) throws XmlException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(str, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(str, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(URL url) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(url, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(url, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ExternalLinkDocument.type, xmlOptions);
        }

        public static ExternalLinkDocument parse(Node node) throws XmlException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(node, ExternalLinkDocument.type, (XmlOptions) null);
        }

        public static ExternalLinkDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ExternalLinkDocument) XmlBeans.getContextTypeLoader().parse(node, ExternalLinkDocument.type, xmlOptions);
        }
    }

    CTExternalLink addNewExternalLink();

    CTExternalLink getExternalLink();

    void setExternalLink(CTExternalLink cTExternalLink);
}
