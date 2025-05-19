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
public interface STPane extends XmlString {
    public static final int INT_BOTTOM_LEFT = 3;
    public static final int INT_BOTTOM_RIGHT = 1;
    public static final int INT_TOP_LEFT = 4;
    public static final int INT_TOP_RIGHT = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPane.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpane2ac1type");
    public static final Enum BOTTOM_RIGHT = Enum.forString("bottomRight");
    public static final Enum TOP_RIGHT = Enum.forString("topRight");
    public static final Enum BOTTOM_LEFT = Enum.forString("bottomLeft");
    public static final Enum TOP_LEFT = Enum.forString("topLeft");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM_LEFT = 3;
        static final int INT_BOTTOM_RIGHT = 1;
        static final int INT_TOP_LEFT = 4;
        static final int INT_TOP_RIGHT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bottomRight", 1), new Enum("topRight", 2), new Enum("bottomLeft", 3), new Enum("topLeft", 4)});

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

        public static STPane newInstance() {
            return (STPane) XmlBeans.getContextTypeLoader().newInstance(STPane.type, null);
        }

        public static STPane newInstance(XmlOptions xmlOptions) {
            return (STPane) XmlBeans.getContextTypeLoader().newInstance(STPane.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPane.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPane.type, xmlOptions);
        }

        public static STPane newValue(Object obj) {
            return (STPane) STPane.type.newValue(obj);
        }

        public static STPane parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPane.type, xmlOptions);
        }

        public static STPane parse(File file) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(file, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(file, STPane.type, xmlOptions);
        }

        public static STPane parse(InputStream inputStream) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(inputStream, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(inputStream, STPane.type, xmlOptions);
        }

        public static STPane parse(Reader reader) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(reader, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(reader, STPane.type, xmlOptions);
        }

        public static STPane parse(String str) throws XmlException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(str, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(str, STPane.type, xmlOptions);
        }

        public static STPane parse(URL url) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(url, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(url, STPane.type, xmlOptions);
        }

        public static STPane parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPane.type, xmlOptions);
        }

        public static STPane parse(Node node) throws XmlException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(node, STPane.type, (XmlOptions) null);
        }

        public static STPane parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPane) XmlBeans.getContextTypeLoader().parse(node, STPane.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
