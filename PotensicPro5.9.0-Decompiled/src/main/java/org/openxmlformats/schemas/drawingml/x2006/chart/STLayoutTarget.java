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
public interface STLayoutTarget extends XmlString {
    public static final int INT_INNER = 1;
    public static final int INT_OUTER = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLayoutTarget.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlayouttarget19f1type");
    public static final Enum INNER = Enum.forString("inner");
    public static final Enum OUTER = Enum.forString("outer");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_INNER = 1;
        static final int INT_OUTER = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("inner", 1), new Enum("outer", 2)});

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

        public static STLayoutTarget newInstance() {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().newInstance(STLayoutTarget.type, null);
        }

        public static STLayoutTarget newInstance(XmlOptions xmlOptions) {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().newInstance(STLayoutTarget.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLayoutTarget.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget newValue(Object obj) {
            return (STLayoutTarget) STLayoutTarget.type.newValue(obj);
        }

        public static STLayoutTarget parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(File file) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(file, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(file, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(InputStream inputStream) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(inputStream, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(inputStream, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(Reader reader) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(reader, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(reader, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(String str) throws XmlException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(str, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(str, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(URL url) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(url, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(url, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLayoutTarget.type, xmlOptions);
        }

        public static STLayoutTarget parse(Node node) throws XmlException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(node, STLayoutTarget.type, (XmlOptions) null);
        }

        public static STLayoutTarget parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLayoutTarget) XmlBeans.getContextTypeLoader().parse(node, STLayoutTarget.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
