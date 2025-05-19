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
public interface STDataConsolidateFunction extends XmlString {
    public static final int INT_AVERAGE = 1;
    public static final int INT_COUNT = 2;
    public static final int INT_COUNT_NUMS = 3;
    public static final int INT_MAX = 4;
    public static final int INT_MIN = 5;
    public static final int INT_PRODUCT = 6;
    public static final int INT_STD_DEV = 7;
    public static final int INT_STD_DEVP = 8;
    public static final int INT_SUM = 9;
    public static final int INT_VAR = 10;
    public static final int INT_VARP = 11;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STDataConsolidateFunction.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stdataconsolidatefunction1206type");
    public static final Enum AVERAGE = Enum.forString("average");
    public static final Enum COUNT = Enum.forString("count");
    public static final Enum COUNT_NUMS = Enum.forString("countNums");
    public static final Enum MAX = Enum.forString("max");
    public static final Enum MIN = Enum.forString("min");
    public static final Enum PRODUCT = Enum.forString("product");
    public static final Enum STD_DEV = Enum.forString("stdDev");
    public static final Enum STD_DEVP = Enum.forString("stdDevp");
    public static final Enum SUM = Enum.forString("sum");
    public static final Enum VAR = Enum.forString("var");
    public static final Enum VARP = Enum.forString("varp");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AVERAGE = 1;
        static final int INT_COUNT = 2;
        static final int INT_COUNT_NUMS = 3;
        static final int INT_MAX = 4;
        static final int INT_MIN = 5;
        static final int INT_PRODUCT = 6;
        static final int INT_STD_DEV = 7;
        static final int INT_STD_DEVP = 8;
        static final int INT_SUM = 9;
        static final int INT_VAR = 10;
        static final int INT_VARP = 11;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("average", 1), new Enum("count", 2), new Enum("countNums", 3), new Enum("max", 4), new Enum("min", 5), new Enum("product", 6), new Enum("stdDev", 7), new Enum("stdDevp", 8), new Enum("sum", 9), new Enum("var", 10), new Enum("varp", 11)});

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

        public static STDataConsolidateFunction newInstance() {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().newInstance(STDataConsolidateFunction.type, null);
        }

        public static STDataConsolidateFunction newInstance(XmlOptions xmlOptions) {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().newInstance(STDataConsolidateFunction.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDataConsolidateFunction.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction newValue(Object obj) {
            return (STDataConsolidateFunction) STDataConsolidateFunction.type.newValue(obj);
        }

        public static STDataConsolidateFunction parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(File file) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(file, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(file, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(InputStream inputStream) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(inputStream, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(inputStream, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(Reader reader) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(reader, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(reader, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(String str) throws XmlException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(str, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(str, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(URL url) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(url, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(url, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDataConsolidateFunction.type, xmlOptions);
        }

        public static STDataConsolidateFunction parse(Node node) throws XmlException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(node, STDataConsolidateFunction.type, (XmlOptions) null);
        }

        public static STDataConsolidateFunction parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STDataConsolidateFunction) XmlBeans.getContextTypeLoader().parse(node, STDataConsolidateFunction.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
