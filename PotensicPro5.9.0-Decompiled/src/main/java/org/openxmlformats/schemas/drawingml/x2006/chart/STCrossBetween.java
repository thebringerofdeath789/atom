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
public interface STCrossBetween extends XmlString {
    public static final int INT_BETWEEN = 1;
    public static final int INT_MID_CAT = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCrossBetween.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcrossbetweenf504type");
    public static final Enum BETWEEN = Enum.forString("between");
    public static final Enum MID_CAT = Enum.forString("midCat");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BETWEEN = 1;
        static final int INT_MID_CAT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("between", 1), new Enum("midCat", 2)});

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

        public static STCrossBetween newInstance() {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().newInstance(STCrossBetween.type, null);
        }

        public static STCrossBetween newInstance(XmlOptions xmlOptions) {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().newInstance(STCrossBetween.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCrossBetween.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween newValue(Object obj) {
            return (STCrossBetween) STCrossBetween.type.newValue(obj);
        }

        public static STCrossBetween parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(File file) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(file, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(file, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(InputStream inputStream) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(inputStream, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(inputStream, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(Reader reader) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(reader, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(reader, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(String str) throws XmlException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(str, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(str, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(URL url) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(url, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(url, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(Node node) throws XmlException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(node, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCrossBetween) XmlBeans.getContextTypeLoader().parse(node, STCrossBetween.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
