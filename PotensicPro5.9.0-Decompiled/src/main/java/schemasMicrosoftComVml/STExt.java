package schemasMicrosoftComVml;

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
public interface STExt extends XmlString {
    public static final int INT_BACKWARD_COMPATIBLE = 3;
    public static final int INT_EDIT = 2;
    public static final int INT_VIEW = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STExt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stext2fe5type");
    public static final Enum VIEW = Enum.forString("view");
    public static final Enum EDIT = Enum.forString("edit");
    public static final Enum BACKWARD_COMPATIBLE = Enum.forString("backwardCompatible");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BACKWARD_COMPATIBLE = 3;
        static final int INT_EDIT = 2;
        static final int INT_VIEW = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("view", 1), new Enum("edit", 2), new Enum("backwardCompatible", 3)});

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

        public static STExt newInstance() {
            return (STExt) XmlBeans.getContextTypeLoader().newInstance(STExt.type, null);
        }

        public static STExt newInstance(XmlOptions xmlOptions) {
            return (STExt) XmlBeans.getContextTypeLoader().newInstance(STExt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STExt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STExt.type, xmlOptions);
        }

        public static STExt newValue(Object obj) {
            return (STExt) STExt.type.newValue(obj);
        }

        public static STExt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STExt.type, xmlOptions);
        }

        public static STExt parse(File file) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(file, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(file, STExt.type, xmlOptions);
        }

        public static STExt parse(InputStream inputStream) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(inputStream, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(inputStream, STExt.type, xmlOptions);
        }

        public static STExt parse(Reader reader) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(reader, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(reader, STExt.type, xmlOptions);
        }

        public static STExt parse(String str) throws XmlException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(str, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(str, STExt.type, xmlOptions);
        }

        public static STExt parse(URL url) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(url, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(url, STExt.type, xmlOptions);
        }

        public static STExt parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STExt.type, xmlOptions);
        }

        public static STExt parse(Node node) throws XmlException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(node, STExt.type, (XmlOptions) null);
        }

        public static STExt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STExt) XmlBeans.getContextTypeLoader().parse(node, STExt.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
