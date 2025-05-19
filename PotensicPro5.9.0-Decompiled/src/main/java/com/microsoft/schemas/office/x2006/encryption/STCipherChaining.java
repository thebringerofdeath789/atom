package com.microsoft.schemas.office.x2006.encryption;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes3.dex */
public interface STCipherChaining extends XmlToken {
    public static final int INT_CHAINING_MODE_CBC = 1;
    public static final int INT_CHAINING_MODE_CFB = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCipherChaining.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("stcipherchaining1e98type");
    public static final Enum CHAINING_MODE_CBC = Enum.forString("ChainingModeCBC");
    public static final Enum CHAINING_MODE_CFB = Enum.forString("ChainingModeCFB");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CHAINING_MODE_CBC = 1;
        static final int INT_CHAINING_MODE_CFB = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("ChainingModeCBC", 1), new Enum("ChainingModeCFB", 2)});

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

        public static STCipherChaining newInstance() {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().newInstance(STCipherChaining.type, null);
        }

        public static STCipherChaining newInstance(XmlOptions xmlOptions) {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().newInstance(STCipherChaining.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCipherChaining.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining newValue(Object obj) {
            return (STCipherChaining) STCipherChaining.type.newValue(obj);
        }

        public static STCipherChaining parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(File file) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(file, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(file, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(InputStream inputStream) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(inputStream, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(inputStream, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(Reader reader) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(reader, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(reader, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(String str) throws XmlException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(str, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(str, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(URL url) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(url, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(url, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCipherChaining.type, xmlOptions);
        }

        public static STCipherChaining parse(Node node) throws XmlException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(node, STCipherChaining.type, (XmlOptions) null);
        }

        public static STCipherChaining parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCipherChaining) XmlBeans.getContextTypeLoader().parse(node, STCipherChaining.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
