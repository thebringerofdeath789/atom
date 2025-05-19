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
public interface STDataValidationOperator extends XmlString {
    public static final int INT_BETWEEN = 1;
    public static final int INT_EQUAL = 3;
    public static final int INT_GREATER_THAN = 7;
    public static final int INT_GREATER_THAN_OR_EQUAL = 8;
    public static final int INT_LESS_THAN = 5;
    public static final int INT_LESS_THAN_OR_EQUAL = 6;
    public static final int INT_NOT_BETWEEN = 2;
    public static final int INT_NOT_EQUAL = 4;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STDataValidationOperator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stdatavalidationoperatore0e0type");
    public static final Enum BETWEEN = Enum.forString("between");
    public static final Enum NOT_BETWEEN = Enum.forString("notBetween");
    public static final Enum EQUAL = Enum.forString("equal");
    public static final Enum NOT_EQUAL = Enum.forString("notEqual");
    public static final Enum LESS_THAN = Enum.forString("lessThan");
    public static final Enum LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
    public static final Enum GREATER_THAN = Enum.forString("greaterThan");
    public static final Enum GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BETWEEN = 1;
        static final int INT_EQUAL = 3;
        static final int INT_GREATER_THAN = 7;
        static final int INT_GREATER_THAN_OR_EQUAL = 8;
        static final int INT_LESS_THAN = 5;
        static final int INT_LESS_THAN_OR_EQUAL = 6;
        static final int INT_NOT_BETWEEN = 2;
        static final int INT_NOT_EQUAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("between", 1), new Enum("notBetween", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("lessThan", 5), new Enum("lessThanOrEqual", 6), new Enum("greaterThan", 7), new Enum("greaterThanOrEqual", 8)});

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

        public static STDataValidationOperator newInstance() {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().newInstance(STDataValidationOperator.type, null);
        }

        public static STDataValidationOperator newInstance(XmlOptions xmlOptions) {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().newInstance(STDataValidationOperator.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDataValidationOperator.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator newValue(Object obj) {
            return (STDataValidationOperator) STDataValidationOperator.type.newValue(obj);
        }

        public static STDataValidationOperator parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(File file) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(file, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(file, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(InputStream inputStream) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(inputStream, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(inputStream, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(Reader reader) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(reader, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(reader, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(String str) throws XmlException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(str, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(str, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(URL url) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(url, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(url, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(Node node) throws XmlException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(node, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STDataValidationOperator) XmlBeans.getContextTypeLoader().parse(node, STDataValidationOperator.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
