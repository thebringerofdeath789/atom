package schemasMicrosoftComOfficeExcel;

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
public interface STTrueFalseBlank extends XmlString {
    public static final int INT_F = 4;
    public static final int INT_FALSE = 3;
    public static final int INT_T = 2;
    public static final int INT_TRUE = 1;
    public static final int INT_X = 5;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTrueFalseBlank.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttruefalseblanka061type");
    public static final Enum TRUE = Enum.forString("True");
    public static final Enum T = Enum.forString("t");
    public static final Enum FALSE = Enum.forString("False");
    public static final Enum F = Enum.forString("f");
    public static final Enum X = Enum.forString("");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_F = 4;
        static final int INT_FALSE = 3;
        static final int INT_T = 2;
        static final int INT_TRUE = 1;
        static final int INT_X = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("True", 1), new Enum("t", 2), new Enum("False", 3), new Enum("f", 4), new Enum("", 5)});

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

        public static STTrueFalseBlank newInstance() {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().newInstance(STTrueFalseBlank.type, null);
        }

        public static STTrueFalseBlank newInstance(XmlOptions xmlOptions) {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().newInstance(STTrueFalseBlank.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTrueFalseBlank.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank newValue(Object obj) {
            return (STTrueFalseBlank) STTrueFalseBlank.type.newValue(obj);
        }

        public static STTrueFalseBlank parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(File file) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(file, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(file, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(InputStream inputStream) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(inputStream, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(inputStream, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(Reader reader) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(reader, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(reader, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(String str) throws XmlException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(str, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(str, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(URL url) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(url, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(url, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTrueFalseBlank.type, xmlOptions);
        }

        public static STTrueFalseBlank parse(Node node) throws XmlException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(node, STTrueFalseBlank.type, (XmlOptions) null);
        }

        public static STTrueFalseBlank parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalseBlank) XmlBeans.getContextTypeLoader().parse(node, STTrueFalseBlank.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
