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
public interface STConditionalFormattingOperator extends XmlString {
    public static final int INT_BEGINS_WITH = 11;
    public static final int INT_BETWEEN = 7;
    public static final int INT_CONTAINS_TEXT = 9;
    public static final int INT_ENDS_WITH = 12;
    public static final int INT_EQUAL = 3;
    public static final int INT_GREATER_THAN = 6;
    public static final int INT_GREATER_THAN_OR_EQUAL = 5;
    public static final int INT_LESS_THAN = 1;
    public static final int INT_LESS_THAN_OR_EQUAL = 2;
    public static final int INT_NOT_BETWEEN = 8;
    public static final int INT_NOT_CONTAINS = 10;
    public static final int INT_NOT_EQUAL = 4;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STConditionalFormattingOperator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stconditionalformattingoperatora99etype");
    public static final Enum LESS_THAN = Enum.forString("lessThan");
    public static final Enum LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
    public static final Enum EQUAL = Enum.forString("equal");
    public static final Enum NOT_EQUAL = Enum.forString("notEqual");
    public static final Enum GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");
    public static final Enum GREATER_THAN = Enum.forString("greaterThan");
    public static final Enum BETWEEN = Enum.forString("between");
    public static final Enum NOT_BETWEEN = Enum.forString("notBetween");
    public static final Enum CONTAINS_TEXT = Enum.forString("containsText");
    public static final Enum NOT_CONTAINS = Enum.forString("notContains");
    public static final Enum BEGINS_WITH = Enum.forString("beginsWith");
    public static final Enum ENDS_WITH = Enum.forString("endsWith");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BEGINS_WITH = 11;
        static final int INT_BETWEEN = 7;
        static final int INT_CONTAINS_TEXT = 9;
        static final int INT_ENDS_WITH = 12;
        static final int INT_EQUAL = 3;
        static final int INT_GREATER_THAN = 6;
        static final int INT_GREATER_THAN_OR_EQUAL = 5;
        static final int INT_LESS_THAN = 1;
        static final int INT_LESS_THAN_OR_EQUAL = 2;
        static final int INT_NOT_BETWEEN = 8;
        static final int INT_NOT_CONTAINS = 10;
        static final int INT_NOT_EQUAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("lessThan", 1), new Enum("lessThanOrEqual", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("greaterThanOrEqual", 5), new Enum("greaterThan", 6), new Enum("between", 7), new Enum("notBetween", 8), new Enum("containsText", 9), new Enum("notContains", 10), new Enum("beginsWith", 11), new Enum("endsWith", 12)});

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

        public static STConditionalFormattingOperator newInstance() {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().newInstance(STConditionalFormattingOperator.type, null);
        }

        public static STConditionalFormattingOperator newInstance(XmlOptions xmlOptions) {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().newInstance(STConditionalFormattingOperator.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STConditionalFormattingOperator.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator newValue(Object obj) {
            return (STConditionalFormattingOperator) STConditionalFormattingOperator.type.newValue(obj);
        }

        public static STConditionalFormattingOperator parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(File file) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(file, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(file, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(InputStream inputStream) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(inputStream, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(inputStream, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(Reader reader) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(reader, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(reader, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(String str) throws XmlException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(str, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(str, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(URL url) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(url, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(url, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STConditionalFormattingOperator.type, xmlOptions);
        }

        public static STConditionalFormattingOperator parse(Node node) throws XmlException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(node, STConditionalFormattingOperator.type, (XmlOptions) null);
        }

        public static STConditionalFormattingOperator parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STConditionalFormattingOperator) XmlBeans.getContextTypeLoader().parse(node, STConditionalFormattingOperator.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
