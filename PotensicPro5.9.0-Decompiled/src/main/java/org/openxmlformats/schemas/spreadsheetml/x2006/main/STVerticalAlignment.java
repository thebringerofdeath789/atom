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
public interface STVerticalAlignment extends XmlString {
    public static final int INT_BOTTOM = 3;
    public static final int INT_CENTER = 2;
    public static final int INT_DISTRIBUTED = 5;
    public static final int INT_JUSTIFY = 4;
    public static final int INT_TOP = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STVerticalAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stverticalalignmentd35ctype");
    public static final Enum TOP = Enum.forString("top");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum BOTTOM = Enum.forString("bottom");
    public static final Enum JUSTIFY = Enum.forString("justify");
    public static final Enum DISTRIBUTED = Enum.forString("distributed");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM = 3;
        static final int INT_CENTER = 2;
        static final int INT_DISTRIBUTED = 5;
        static final int INT_JUSTIFY = 4;
        static final int INT_TOP = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("top", 1), new Enum("center", 2), new Enum("bottom", 3), new Enum("justify", 4), new Enum("distributed", 5)});

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

        public static STVerticalAlignment newInstance() {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().newInstance(STVerticalAlignment.type, null);
        }

        public static STVerticalAlignment newInstance(XmlOptions xmlOptions) {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().newInstance(STVerticalAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STVerticalAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment newValue(Object obj) {
            return (STVerticalAlignment) STVerticalAlignment.type.newValue(obj);
        }

        public static STVerticalAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(File file) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(file, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(file, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(Reader reader) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(reader, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(reader, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(String str) throws XmlException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(str, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(str, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(URL url) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(url, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(url, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(Node node) throws XmlException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(node, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STVerticalAlignment) XmlBeans.getContextTypeLoader().parse(node, STVerticalAlignment.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
