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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface PresentationDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(PresentationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("presentation02f7doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PresentationDocument newInstance() {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().newInstance(PresentationDocument.type, null);
        }

        public static PresentationDocument newInstance(XmlOptions xmlOptions) {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().newInstance(PresentationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PresentationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(File file) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(file, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(file, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(Reader reader) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(reader, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(reader, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(String str) throws XmlException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(str, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(str, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(URL url) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(url, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(url, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(Node node) throws XmlException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(node, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PresentationDocument) XmlBeans.getContextTypeLoader().parse(node, PresentationDocument.type, xmlOptions);
        }
    }

    CTPresentation addNewPresentation();

    CTPresentation getPresentation();

    void setPresentation(CTPresentation cTPresentation);
}
