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
public interface STLayoutMode extends XmlString {
    public static final int INT_EDGE = 1;
    public static final int INT_FACTOR = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLayoutMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlayoutmode19dftype");
    public static final Enum EDGE = Enum.forString("edge");
    public static final Enum FACTOR = Enum.forString("factor");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EDGE = 1;
        static final int INT_FACTOR = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("edge", 1), new Enum("factor", 2)});

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

        public static STLayoutMode newInstance() {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().newInstance(STLayoutMode.type, null);
        }

        public static STLayoutMode newInstance(XmlOptions xmlOptions) {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().newInstance(STLayoutMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLayoutMode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode newValue(Object obj) {
            return (STLayoutMode) STLayoutMode.type.newValue(obj);
        }

        public static STLayoutMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(File file) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(file, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(file, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(InputStream inputStream) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(inputStream, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(inputStream, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(Reader reader) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(reader, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(reader, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(String str) throws XmlException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(str, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(str, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(URL url) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(url, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(url, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(Node node) throws XmlException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(node, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLayoutMode) XmlBeans.getContextTypeLoader().parse(node, STLayoutMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
