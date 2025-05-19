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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSchema extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSchema.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctschema0e6atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSchema newInstance() {
            return (CTSchema) XmlBeans.getContextTypeLoader().newInstance(CTSchema.type, null);
        }

        public static CTSchema newInstance(XmlOptions xmlOptions) {
            return (CTSchema) XmlBeans.getContextTypeLoader().newInstance(CTSchema.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSchema.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(File file) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(file, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(file, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(inputStream, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(inputStream, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(Reader reader) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(reader, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(reader, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(String str) throws XmlException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(str, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(str, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(URL url) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(url, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(url, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(Node node) throws XmlException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(node, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSchema) XmlBeans.getContextTypeLoader().parse(node, CTSchema.type, xmlOptions);
        }
    }

    String getID();

    String getNamespace();

    String getSchemaRef();

    boolean isSetNamespace();

    boolean isSetSchemaRef();

    void setID(String str);

    void setNamespace(String str);

    void setSchemaRef(String str);

    void unsetNamespace();

    void unsetSchemaRef();

    XmlString xgetID();

    XmlString xgetNamespace();

    XmlString xgetSchemaRef();

    void xsetID(XmlString xmlString);

    void xsetNamespace(XmlString xmlString);

    void xsetSchemaRef(XmlString xmlString);
}
