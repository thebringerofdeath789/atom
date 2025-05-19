package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* loaded from: classes2.dex */
public interface STOrientation extends XmlString {
    public static final int INT_MAX_MIN = 1;
    public static final int INT_MIN_MAX = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STOrientation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("storientationc326type");
    public static final Enum MAX_MIN = Enum.forString("maxMin");
    public static final Enum MIN_MAX = Enum.forString("minMax");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAX_MIN = 1;
        static final int INT_MIN_MAX = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("maxMin", 1), new Enum("minMax", 2)});

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

        public static STOrientation newInstance() {
            return (STOrientation) XmlBeans.getContextTypeLoader().newInstance(STOrientation.type, null);
        }

        public static STOrientation newInstance(XmlOptions xmlOptions) {
            return (STOrientation) XmlBeans.getContextTypeLoader().newInstance(STOrientation.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STOrientation.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STOrientation.type, xmlOptions);
        }

        public static STOrientation newValue(Object obj) {
            return (STOrientation) STOrientation.type.newValue(obj);
        }

        public static STOrientation parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(File file) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(file, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(file, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(InputStream inputStream) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(inputStream, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(inputStream, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(Reader reader) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(reader, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(reader, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(String str) throws XmlException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(str, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(str, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(URL url) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(url, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(url, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(Node node) throws XmlException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(node, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STOrientation) XmlBeans.getContextTypeLoader().parse(node, STOrientation.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
