package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STSqref extends XmlAnySimpleType {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSqref.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stsqrefb044type");

    public static final class Factory {
        private Factory() {
        }

        public static STSqref newInstance() {
            return (STSqref) XmlBeans.getContextTypeLoader().newInstance(STSqref.type, null);
        }

        public static STSqref newInstance(XmlOptions xmlOptions) {
            return (STSqref) XmlBeans.getContextTypeLoader().newInstance(STSqref.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSqref.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSqref.type, xmlOptions);
        }

        public static STSqref newValue(Object obj) {
            return (STSqref) STSqref.type.newValue(obj);
        }

        public static STSqref parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSqref.type, xmlOptions);
        }

        public static STSqref parse(File file) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(file, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(file, STSqref.type, xmlOptions);
        }

        public static STSqref parse(InputStream inputStream) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(inputStream, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(inputStream, STSqref.type, xmlOptions);
        }

        public static STSqref parse(Reader reader) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(reader, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(reader, STSqref.type, xmlOptions);
        }

        public static STSqref parse(String str) throws XmlException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(str, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(str, STSqref.type, xmlOptions);
        }

        public static STSqref parse(URL url) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(url, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(url, STSqref.type, xmlOptions);
        }

        public static STSqref parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSqref.type, xmlOptions);
        }

        public static STSqref parse(Node node) throws XmlException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(node, STSqref.type, (XmlOptions) null);
        }

        public static STSqref parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSqref) XmlBeans.getContextTypeLoader().parse(node, STSqref.type, xmlOptions);
        }
    }

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();
}
