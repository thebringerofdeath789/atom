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
public interface SldDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SldDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sld1b98doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldDocument newInstance() {
            return (SldDocument) XmlBeans.getContextTypeLoader().newInstance(SldDocument.type, null);
        }

        public static SldDocument newInstance(XmlOptions xmlOptions) {
            return (SldDocument) XmlBeans.getContextTypeLoader().newInstance(SldDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SldDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(File file) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(file, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(file, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(Reader reader) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(reader, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(reader, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(String str) throws XmlException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(str, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(str, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(URL url) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(url, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(url, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(Node node) throws XmlException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(node, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SldDocument) XmlBeans.getContextTypeLoader().parse(node, SldDocument.type, xmlOptions);
        }
    }

    CTSlide addNewSld();

    CTSlide getSld();

    void setSld(CTSlide cTSlide);
}
