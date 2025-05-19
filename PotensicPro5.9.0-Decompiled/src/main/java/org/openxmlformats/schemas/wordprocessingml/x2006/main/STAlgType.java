package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STAlgType extends XmlString {
    public static final int INT_TYPE_ANY = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAlgType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stalgtype156ctype");
    public static final Enum TYPE_ANY = Enum.forString("typeAny");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_TYPE_ANY = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("typeAny", 1)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    public static final class Factory {
        private Factory() {
        }

        public static STAlgType newInstance() {
            return (STAlgType) XmlBeans.getContextTypeLoader().newInstance(STAlgType.type, null);
        }

        public static STAlgType newInstance(XmlOptions xmlOptions) {
            return (STAlgType) XmlBeans.getContextTypeLoader().newInstance(STAlgType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAlgType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAlgType.type, xmlOptions);
        }

        public static STAlgType newValue(Object obj) {
            return (STAlgType) STAlgType.type.newValue(obj);
        }

        public static STAlgType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(File file) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(file, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(file, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(InputStream inputStream) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(inputStream, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(inputStream, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(Reader reader) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(reader, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(reader, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(String str) throws XmlException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(str, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(str, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(URL url) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(url, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(url, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(Node node) throws XmlException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(node, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAlgType) XmlBeans.getContextTypeLoader().parse(node, STAlgType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
