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
public interface STTextAlignment extends XmlString {
    public static final int INT_AUTO = 5;
    public static final int INT_BASELINE = 3;
    public static final int INT_BOTTOM = 4;
    public static final int INT_CENTER = 2;
    public static final int INT_TOP = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextalignment316ctype");
    public static final Enum TOP = Enum.forString("top");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum BASELINE = Enum.forString("baseline");
    public static final Enum BOTTOM = Enum.forString("bottom");
    public static final Enum AUTO = Enum.forString("auto");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 5;
        static final int INT_BASELINE = 3;
        static final int INT_BOTTOM = 4;
        static final int INT_CENTER = 2;
        static final int INT_TOP = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("top", 1), new Enum("center", 2), new Enum("baseline", 3), new Enum("bottom", 4), new Enum("auto", 5)});

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

        public static STTextAlignment newInstance() {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().newInstance(STTextAlignment.type, null);
        }

        public static STTextAlignment newInstance(XmlOptions xmlOptions) {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().newInstance(STTextAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment newValue(Object obj) {
            return (STTextAlignment) STTextAlignment.type.newValue(obj);
        }

        public static STTextAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(File file) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(file, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(file, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(Reader reader) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(reader, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(reader, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(String str) throws XmlException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(str, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(str, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(URL url) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(url, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(url, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextAlignment.type, xmlOptions);
        }

        public static STTextAlignment parse(Node node) throws XmlException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(node, STTextAlignment.type, (XmlOptions) null);
        }

        public static STTextAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextAlignment) XmlBeans.getContextTypeLoader().parse(node, STTextAlignment.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
