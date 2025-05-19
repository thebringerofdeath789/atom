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
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STBrType extends XmlString {
    public static final int INT_COLUMN = 2;
    public static final int INT_PAGE = 1;
    public static final int INT_TEXT_WRAPPING = 3;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STBrType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stbrtypeb52etype");
    public static final Enum PAGE = Enum.forString("page");
    public static final Enum COLUMN = Enum.forString(JamXmlElements.COLUMN);
    public static final Enum TEXT_WRAPPING = Enum.forString("textWrapping");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_COLUMN = 2;
        static final int INT_PAGE = 1;
        static final int INT_TEXT_WRAPPING = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("page", 1), new Enum(JamXmlElements.COLUMN, 2), new Enum("textWrapping", 3)});

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

        public static STBrType newInstance() {
            return (STBrType) XmlBeans.getContextTypeLoader().newInstance(STBrType.type, null);
        }

        public static STBrType newInstance(XmlOptions xmlOptions) {
            return (STBrType) XmlBeans.getContextTypeLoader().newInstance(STBrType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STBrType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STBrType.type, xmlOptions);
        }

        public static STBrType newValue(Object obj) {
            return (STBrType) STBrType.type.newValue(obj);
        }

        public static STBrType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STBrType.type, xmlOptions);
        }

        public static STBrType parse(File file) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(file, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(file, STBrType.type, xmlOptions);
        }

        public static STBrType parse(InputStream inputStream) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(inputStream, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(inputStream, STBrType.type, xmlOptions);
        }

        public static STBrType parse(Reader reader) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(reader, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(reader, STBrType.type, xmlOptions);
        }

        public static STBrType parse(String str) throws XmlException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(str, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(str, STBrType.type, xmlOptions);
        }

        public static STBrType parse(URL url) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(url, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(url, STBrType.type, xmlOptions);
        }

        public static STBrType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STBrType.type, xmlOptions);
        }

        public static STBrType parse(Node node) throws XmlException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(node, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STBrType) XmlBeans.getContextTypeLoader().parse(node, STBrType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
