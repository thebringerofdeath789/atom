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
public interface SldLayoutDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SldLayoutDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sldlayout638edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldLayoutDocument newInstance() {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().newInstance(SldLayoutDocument.type, null);
        }

        public static SldLayoutDocument newInstance(XmlOptions xmlOptions) {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().newInstance(SldLayoutDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SldLayoutDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(File file) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(file, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(file, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(Reader reader) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(reader, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(reader, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(String str) throws XmlException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(str, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(str, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(URL url) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(url, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(url, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(Node node) throws XmlException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(node, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SldLayoutDocument) XmlBeans.getContextTypeLoader().parse(node, SldLayoutDocument.type, xmlOptions);
        }
    }

    CTSlideLayout addNewSldLayout();

    CTSlideLayout getSldLayout();

    void setSldLayout(CTSlideLayout cTSlideLayout);
}
