package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STLineCap extends XmlToken {
    public static final int INT_FLAT = 3;
    public static final int INT_RND = 1;
    public static final int INT_SQ = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLineCap.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlinecapcddftype");
    public static final Enum RND = Enum.forString("rnd");
    public static final Enum SQ = Enum.forString("sq");
    public static final Enum FLAT = Enum.forString("flat");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FLAT = 3;
        static final int INT_RND = 1;
        static final int INT_SQ = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("rnd", 1), new Enum("sq", 2), new Enum("flat", 3)});

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

        public static STLineCap newInstance() {
            return (STLineCap) XmlBeans.getContextTypeLoader().newInstance(STLineCap.type, null);
        }

        public static STLineCap newInstance(XmlOptions xmlOptions) {
            return (STLineCap) XmlBeans.getContextTypeLoader().newInstance(STLineCap.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineCap.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineCap.type, xmlOptions);
        }

        public static STLineCap newValue(Object obj) {
            return (STLineCap) STLineCap.type.newValue(obj);
        }

        public static STLineCap parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(File file) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(file, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(file, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(InputStream inputStream) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(inputStream, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(inputStream, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(Reader reader) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(reader, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(reader, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(String str) throws XmlException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(str, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(str, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(URL url) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(url, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(url, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(Node node) throws XmlException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(node, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLineCap) XmlBeans.getContextTypeLoader().parse(node, STLineCap.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
