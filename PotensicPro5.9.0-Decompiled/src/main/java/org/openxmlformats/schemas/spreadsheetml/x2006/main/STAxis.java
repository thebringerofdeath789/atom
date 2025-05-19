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
public interface STAxis extends XmlString {
    public static final int INT_AXIS_COL = 2;
    public static final int INT_AXIS_PAGE = 3;
    public static final int INT_AXIS_ROW = 1;
    public static final int INT_AXIS_VALUES = 4;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAxis.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("staxis45batype");
    public static final Enum AXIS_ROW = Enum.forString("axisRow");
    public static final Enum AXIS_COL = Enum.forString("axisCol");
    public static final Enum AXIS_PAGE = Enum.forString("axisPage");
    public static final Enum AXIS_VALUES = Enum.forString("axisValues");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AXIS_COL = 2;
        static final int INT_AXIS_PAGE = 3;
        static final int INT_AXIS_ROW = 1;
        static final int INT_AXIS_VALUES = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("axisRow", 1), new Enum("axisCol", 2), new Enum("axisPage", 3), new Enum("axisValues", 4)});

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

        public static STAxis newInstance() {
            return (STAxis) XmlBeans.getContextTypeLoader().newInstance(STAxis.type, null);
        }

        public static STAxis newInstance(XmlOptions xmlOptions) {
            return (STAxis) XmlBeans.getContextTypeLoader().newInstance(STAxis.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAxis.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAxis.type, xmlOptions);
        }

        public static STAxis newValue(Object obj) {
            return (STAxis) STAxis.type.newValue(obj);
        }

        public static STAxis parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAxis.type, xmlOptions);
        }

        public static STAxis parse(File file) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(file, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(file, STAxis.type, xmlOptions);
        }

        public static STAxis parse(InputStream inputStream) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(inputStream, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(inputStream, STAxis.type, xmlOptions);
        }

        public static STAxis parse(Reader reader) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(reader, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(reader, STAxis.type, xmlOptions);
        }

        public static STAxis parse(String str) throws XmlException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(str, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(str, STAxis.type, xmlOptions);
        }

        public static STAxis parse(URL url) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(url, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(url, STAxis.type, xmlOptions);
        }

        public static STAxis parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAxis.type, xmlOptions);
        }

        public static STAxis parse(Node node) throws XmlException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(node, STAxis.type, (XmlOptions) null);
        }

        public static STAxis parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAxis) XmlBeans.getContextTypeLoader().parse(node, STAxis.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
