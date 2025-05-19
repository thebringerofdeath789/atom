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
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STTabJc extends XmlString {
    public static final int INT_BAR = 6;
    public static final int INT_CENTER = 3;
    public static final int INT_CLEAR = 1;
    public static final int INT_DECIMAL = 5;
    public static final int INT_LEFT = 2;
    public static final int INT_NUM = 7;
    public static final int INT_RIGHT = 4;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTabJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttabjc10f4type");
    public static final Enum CLEAR = Enum.forString("clear");
    public static final Enum LEFT = Enum.forString("left");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum RIGHT = Enum.forString("right");
    public static final Enum DECIMAL = Enum.forString(XmlErrorCodes.DECIMAL);
    public static final Enum BAR = Enum.forString("bar");
    public static final Enum NUM = Enum.forString("num");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BAR = 6;
        static final int INT_CENTER = 3;
        static final int INT_CLEAR = 1;
        static final int INT_DECIMAL = 5;
        static final int INT_LEFT = 2;
        static final int INT_NUM = 7;
        static final int INT_RIGHT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clear", 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum(XmlErrorCodes.DECIMAL, 5), new Enum("bar", 6), new Enum("num", 7)});

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

        public static STTabJc newInstance() {
            return (STTabJc) XmlBeans.getContextTypeLoader().newInstance(STTabJc.type, null);
        }

        public static STTabJc newInstance(XmlOptions xmlOptions) {
            return (STTabJc) XmlBeans.getContextTypeLoader().newInstance(STTabJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTabJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTabJc.type, xmlOptions);
        }

        public static STTabJc newValue(Object obj) {
            return (STTabJc) STTabJc.type.newValue(obj);
        }

        public static STTabJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(File file) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(file, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(file, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(InputStream inputStream) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(inputStream, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(inputStream, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(Reader reader) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(reader, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(reader, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(String str) throws XmlException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(str, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(str, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(URL url) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(url, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(url, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(Node node) throws XmlException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(node, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTabJc) XmlBeans.getContextTypeLoader().parse(node, STTabJc.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
