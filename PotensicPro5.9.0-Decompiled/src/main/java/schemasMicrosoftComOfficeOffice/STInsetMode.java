package schemasMicrosoftComOfficeOffice;

import aavax.xml.stream.XMLStreamReader;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
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
public interface STInsetMode extends XmlString {
    public static final int INT_AUTO = 1;
    public static final int INT_CUSTOM = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STInsetMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stinsetmode3b89type");
    public static final Enum AUTO = Enum.forString("auto");
    public static final Enum CUSTOM = Enum.forString(SchedulerSupport.CUSTOM);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        static final int INT_CUSTOM = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1), new Enum(SchedulerSupport.CUSTOM, 2)});

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

        public static STInsetMode newInstance() {
            return (STInsetMode) XmlBeans.getContextTypeLoader().newInstance(STInsetMode.type, null);
        }

        public static STInsetMode newInstance(XmlOptions xmlOptions) {
            return (STInsetMode) XmlBeans.getContextTypeLoader().newInstance(STInsetMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STInsetMode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode newValue(Object obj) {
            return (STInsetMode) STInsetMode.type.newValue(obj);
        }

        public static STInsetMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(File file) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(file, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(file, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(InputStream inputStream) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(inputStream, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(inputStream, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(Reader reader) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(reader, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(reader, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(String str) throws XmlException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(str, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(str, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(URL url) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(url, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(url, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(Node node) throws XmlException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(node, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STInsetMode) XmlBeans.getContextTypeLoader().parse(node, STInsetMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
