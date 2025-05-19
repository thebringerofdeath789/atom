package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface STPageOrder extends XmlString {
    public static final int INT_DOWN_THEN_OVER = 1;
    public static final int INT_OVER_THEN_DOWN = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPageOrder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpageorderd2cetype");
    public static final Enum DOWN_THEN_OVER = Enum.forString("downThenOver");
    public static final Enum OVER_THEN_DOWN = Enum.forString("overThenDown");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DOWN_THEN_OVER = 1;
        static final int INT_OVER_THEN_DOWN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("downThenOver", 1), new Enum("overThenDown", 2)});

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

        public static STPageOrder newInstance() {
            return (STPageOrder) XmlBeans.getContextTypeLoader().newInstance(STPageOrder.type, null);
        }

        public static STPageOrder newInstance(XmlOptions xmlOptions) {
            return (STPageOrder) XmlBeans.getContextTypeLoader().newInstance(STPageOrder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPageOrder.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder newValue(Object obj) {
            return (STPageOrder) STPageOrder.type.newValue(obj);
        }

        public static STPageOrder parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(File file) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(file, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(file, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(InputStream inputStream) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(inputStream, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(inputStream, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(Reader reader) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(reader, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(reader, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(String str) throws XmlException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(str, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(str, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(URL url) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(url, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(url, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(Node node) throws XmlException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(node, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPageOrder) XmlBeans.getContextTypeLoader().parse(node, STPageOrder.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
