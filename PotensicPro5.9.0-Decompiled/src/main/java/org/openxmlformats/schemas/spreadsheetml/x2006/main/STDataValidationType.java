package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STDataValidationType extends XmlString {
    public static final int INT_CUSTOM = 8;
    public static final int INT_DATE = 5;
    public static final int INT_DECIMAL = 3;
    public static final int INT_LIST = 4;
    public static final int INT_NONE = 1;
    public static final int INT_TEXT_LENGTH = 7;
    public static final int INT_TIME = 6;
    public static final int INT_WHOLE = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STDataValidationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stdatavalidationtypeabf6type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum WHOLE = Enum.forString("whole");
    public static final Enum DECIMAL = Enum.forString(XmlErrorCodes.DECIMAL);
    public static final Enum LIST = Enum.forString(XmlErrorCodes.LIST);
    public static final Enum DATE = Enum.forString("date");
    public static final Enum TIME = Enum.forString(RtspHeaders.Values.TIME);
    public static final Enum TEXT_LENGTH = Enum.forString("textLength");
    public static final Enum CUSTOM = Enum.forString(SchedulerSupport.CUSTOM);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 8;
        static final int INT_DATE = 5;
        static final int INT_DECIMAL = 3;
        static final int INT_LIST = 4;
        static final int INT_NONE = 1;
        static final int INT_TEXT_LENGTH = 7;
        static final int INT_TIME = 6;
        static final int INT_WHOLE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("whole", 2), new Enum(XmlErrorCodes.DECIMAL, 3), new Enum(XmlErrorCodes.LIST, 4), new Enum("date", 5), new Enum(RtspHeaders.Values.TIME, 6), new Enum("textLength", 7), new Enum(SchedulerSupport.CUSTOM, 8)});

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

        public static STDataValidationType newInstance() {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().newInstance(STDataValidationType.type, null);
        }

        public static STDataValidationType newInstance(XmlOptions xmlOptions) {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().newInstance(STDataValidationType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDataValidationType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType newValue(Object obj) {
            return (STDataValidationType) STDataValidationType.type.newValue(obj);
        }

        public static STDataValidationType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(File file) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(file, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(file, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(InputStream inputStream) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(inputStream, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(inputStream, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(Reader reader) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(reader, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(reader, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(String str) throws XmlException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(str, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(str, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(URL url) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(url, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(url, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(Node node) throws XmlException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(node, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STDataValidationType) XmlBeans.getContextTypeLoader().parse(node, STDataValidationType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
