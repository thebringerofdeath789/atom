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
public interface STConnectType extends XmlString {
    public static final int INT_CUSTOM = 4;
    public static final int INT_NONE = 1;
    public static final int INT_RECT = 2;
    public static final int INT_SEGMENTS = 3;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STConnectType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stconnecttype97adtype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum RECT = Enum.forString("rect");
    public static final Enum SEGMENTS = Enum.forString("segments");
    public static final Enum CUSTOM = Enum.forString(SchedulerSupport.CUSTOM);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 4;
        static final int INT_NONE = 1;
        static final int INT_RECT = 2;
        static final int INT_SEGMENTS = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("rect", 2), new Enum("segments", 3), new Enum(SchedulerSupport.CUSTOM, 4)});

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

        public static STConnectType newInstance() {
            return (STConnectType) XmlBeans.getContextTypeLoader().newInstance(STConnectType.type, null);
        }

        public static STConnectType newInstance(XmlOptions xmlOptions) {
            return (STConnectType) XmlBeans.getContextTypeLoader().newInstance(STConnectType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STConnectType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STConnectType.type, xmlOptions);
        }

        public static STConnectType newValue(Object obj) {
            return (STConnectType) STConnectType.type.newValue(obj);
        }

        public static STConnectType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(File file) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(file, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(file, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(InputStream inputStream) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(inputStream, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(inputStream, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(Reader reader) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(reader, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(reader, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(String str) throws XmlException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(str, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(str, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(URL url) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(url, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(url, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(Node node) throws XmlException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(node, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STConnectType) XmlBeans.getContextTypeLoader().parse(node, STConnectType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
