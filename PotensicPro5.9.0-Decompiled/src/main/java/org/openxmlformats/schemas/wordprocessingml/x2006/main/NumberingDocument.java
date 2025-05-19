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
public interface NumberingDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(NumberingDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("numbering1c4ddoctype");

    public static final class Factory {
        private Factory() {
        }

        public static NumberingDocument newInstance() {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().newInstance(NumberingDocument.type, null);
        }

        public static NumberingDocument newInstance(XmlOptions xmlOptions) {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().newInstance(NumberingDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NumberingDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(File file) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(file, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(file, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(Reader reader) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(reader, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(reader, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(String str) throws XmlException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(str, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(str, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(URL url) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(url, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(url, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(Node node) throws XmlException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(node, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NumberingDocument) XmlBeans.getContextTypeLoader().parse(node, NumberingDocument.type, xmlOptions);
        }
    }

    CTNumbering addNewNumbering();

    CTNumbering getNumbering();

    void setNumbering(CTNumbering cTNumbering);
}
