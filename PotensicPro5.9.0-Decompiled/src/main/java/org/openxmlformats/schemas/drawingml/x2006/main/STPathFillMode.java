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
public interface STPathFillMode extends XmlToken {
    public static final int INT_DARKEN = 5;
    public static final int INT_DARKEN_LESS = 6;
    public static final int INT_LIGHTEN = 3;
    public static final int INT_LIGHTEN_LESS = 4;
    public static final int INT_NONE = 1;
    public static final int INT_NORM = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPathFillMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpathfillmode3cf6type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum NORM = Enum.forString("norm");
    public static final Enum LIGHTEN = Enum.forString("lighten");
    public static final Enum LIGHTEN_LESS = Enum.forString("lightenLess");
    public static final Enum DARKEN = Enum.forString("darken");
    public static final Enum DARKEN_LESS = Enum.forString("darkenLess");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DARKEN = 5;
        static final int INT_DARKEN_LESS = 6;
        static final int INT_LIGHTEN = 3;
        static final int INT_LIGHTEN_LESS = 4;
        static final int INT_NONE = 1;
        static final int INT_NORM = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("norm", 2), new Enum("lighten", 3), new Enum("lightenLess", 4), new Enum("darken", 5), new Enum("darkenLess", 6)});

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

        public static STPathFillMode newInstance() {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().newInstance(STPathFillMode.type, null);
        }

        public static STPathFillMode newInstance(XmlOptions xmlOptions) {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().newInstance(STPathFillMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPathFillMode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode newValue(Object obj) {
            return (STPathFillMode) STPathFillMode.type.newValue(obj);
        }

        public static STPathFillMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(File file) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(file, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(file, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(InputStream inputStream) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(inputStream, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(inputStream, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(Reader reader) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(reader, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(reader, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(String str) throws XmlException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(str, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(str, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(URL url) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(url, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(url, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPathFillMode.type, xmlOptions);
        }

        public static STPathFillMode parse(Node node) throws XmlException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(node, STPathFillMode.type, (XmlOptions) null);
        }

        public static STPathFillMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPathFillMode) XmlBeans.getContextTypeLoader().parse(node, STPathFillMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
