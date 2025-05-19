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
public interface STAlgClass extends XmlString {
    public static final int INT_HASH = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAlgClass.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stalgclass061ctype");
    public static final Enum HASH = Enum.forString("hash");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HASH = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("hash", 1)});

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

        public static STAlgClass newInstance() {
            return (STAlgClass) XmlBeans.getContextTypeLoader().newInstance(STAlgClass.type, null);
        }

        public static STAlgClass newInstance(XmlOptions xmlOptions) {
            return (STAlgClass) XmlBeans.getContextTypeLoader().newInstance(STAlgClass.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAlgClass.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass newValue(Object obj) {
            return (STAlgClass) STAlgClass.type.newValue(obj);
        }

        public static STAlgClass parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(File file) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(file, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(file, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(InputStream inputStream) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(inputStream, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(inputStream, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(Reader reader) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(reader, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(reader, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(String str) throws XmlException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(str, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(str, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(URL url) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(url, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(url, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(Node node) throws XmlException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(node, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAlgClass) XmlBeans.getContextTypeLoader().parse(node, STAlgClass.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
