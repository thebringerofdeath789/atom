package schemasMicrosoftComVml;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.commons.lang3.BooleanUtils;
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
public interface STTrueFalse extends XmlString {
    public static final int INT_F = 2;
    public static final int INT_FALSE = 4;
    public static final int INT_T = 1;
    public static final int INT_TRUE = 3;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTrueFalse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttruefalse4ab9type");
    public static final Enum T = Enum.forString("t");
    public static final Enum F = Enum.forString("f");
    public static final Enum TRUE = Enum.forString(BooleanUtils.TRUE);
    public static final Enum FALSE = Enum.forString("false");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_F = 2;
        static final int INT_FALSE = 4;
        static final int INT_T = 1;
        static final int INT_TRUE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("t", 1), new Enum("f", 2), new Enum(BooleanUtils.TRUE, 3), new Enum("false", 4)});

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

        public static STTrueFalse newInstance() {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().newInstance(STTrueFalse.type, null);
        }

        public static STTrueFalse newInstance(XmlOptions xmlOptions) {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().newInstance(STTrueFalse.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTrueFalse.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse newValue(Object obj) {
            return (STTrueFalse) STTrueFalse.type.newValue(obj);
        }

        public static STTrueFalse parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(File file) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(file, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(file, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(InputStream inputStream) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(inputStream, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(inputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(Reader reader) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(reader, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(reader, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(String str) throws XmlException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(str, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(str, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(URL url) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(url, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(url, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(Node node) throws XmlException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(node, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTrueFalse) XmlBeans.getContextTypeLoader().parse(node, STTrueFalse.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
