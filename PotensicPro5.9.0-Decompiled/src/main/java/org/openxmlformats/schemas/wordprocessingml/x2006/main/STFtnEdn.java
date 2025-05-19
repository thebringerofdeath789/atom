package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface STFtnEdn extends XmlString {
    public static final int INT_CONTINUATION_NOTICE = 4;
    public static final int INT_CONTINUATION_SEPARATOR = 3;
    public static final int INT_NORMAL = 1;
    public static final int INT_SEPARATOR = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFtnEdn.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stftnednd4c9type");
    public static final Enum NORMAL = Enum.forString("normal");
    public static final Enum SEPARATOR = Enum.forString("separator");
    public static final Enum CONTINUATION_SEPARATOR = Enum.forString("continuationSeparator");
    public static final Enum CONTINUATION_NOTICE = Enum.forString("continuationNotice");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUATION_NOTICE = 4;
        static final int INT_CONTINUATION_SEPARATOR = 3;
        static final int INT_NORMAL = 1;
        static final int INT_SEPARATOR = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("normal", 1), new Enum("separator", 2), new Enum("continuationSeparator", 3), new Enum("continuationNotice", 4)});

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

        public static STFtnEdn newInstance() {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().newInstance(STFtnEdn.type, null);
        }

        public static STFtnEdn newInstance(XmlOptions xmlOptions) {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().newInstance(STFtnEdn.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFtnEdn.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn newValue(Object obj) {
            return (STFtnEdn) STFtnEdn.type.newValue(obj);
        }

        public static STFtnEdn parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(File file) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(file, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(file, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(InputStream inputStream) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(inputStream, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(inputStream, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(Reader reader) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(reader, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(reader, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(String str) throws XmlException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(str, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(str, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(URL url) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(url, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(url, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(Node node) throws XmlException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(node, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFtnEdn) XmlBeans.getContextTypeLoader().parse(node, STFtnEdn.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
