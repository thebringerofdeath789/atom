package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* loaded from: classes2.dex */
public interface STTickMark extends XmlString {
    public static final int INT_CROSS = 1;
    public static final int INT_IN = 2;
    public static final int INT_NONE = 3;
    public static final int INT_OUT = 4;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTickMark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttickmark69e2type");
    public static final Enum CROSS = Enum.forString("cross");
    public static final Enum IN = Enum.forString("in");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum OUT = Enum.forString("out");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CROSS = 1;
        static final int INT_IN = 2;
        static final int INT_NONE = 3;
        static final int INT_OUT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("cross", 1), new Enum("in", 2), new Enum("none", 3), new Enum("out", 4)});

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

        public static STTickMark newInstance() {
            return (STTickMark) XmlBeans.getContextTypeLoader().newInstance(STTickMark.type, null);
        }

        public static STTickMark newInstance(XmlOptions xmlOptions) {
            return (STTickMark) XmlBeans.getContextTypeLoader().newInstance(STTickMark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTickMark.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTickMark.type, xmlOptions);
        }

        public static STTickMark newValue(Object obj) {
            return (STTickMark) STTickMark.type.newValue(obj);
        }

        public static STTickMark parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(File file) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(file, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(file, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(InputStream inputStream) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(inputStream, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(inputStream, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(Reader reader) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(reader, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(reader, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(String str) throws XmlException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(str, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(str, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(URL url) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(url, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(url, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(Node node) throws XmlException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(node, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTickMark) XmlBeans.getContextTypeLoader().parse(node, STTickMark.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
