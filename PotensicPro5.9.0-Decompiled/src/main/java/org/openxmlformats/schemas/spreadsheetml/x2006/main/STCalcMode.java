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
public interface STCalcMode extends XmlString {
    public static final int INT_AUTO = 2;
    public static final int INT_AUTO_NO_TABLE = 3;
    public static final int INT_MANUAL = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCalcMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcalcmode5e71type");
    public static final Enum MANUAL = Enum.forString("manual");
    public static final Enum AUTO = Enum.forString("auto");
    public static final Enum AUTO_NO_TABLE = Enum.forString("autoNoTable");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 2;
        static final int INT_AUTO_NO_TABLE = 3;
        static final int INT_MANUAL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("manual", 1), new Enum("auto", 2), new Enum("autoNoTable", 3)});

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

        public static STCalcMode newInstance() {
            return (STCalcMode) XmlBeans.getContextTypeLoader().newInstance(STCalcMode.type, null);
        }

        public static STCalcMode newInstance(XmlOptions xmlOptions) {
            return (STCalcMode) XmlBeans.getContextTypeLoader().newInstance(STCalcMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCalcMode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode newValue(Object obj) {
            return (STCalcMode) STCalcMode.type.newValue(obj);
        }

        public static STCalcMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(File file) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(file, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(file, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(InputStream inputStream) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(inputStream, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(inputStream, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(Reader reader) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(reader, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(reader, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(String str) throws XmlException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(str, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(str, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(URL url) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(url, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(url, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(Node node) throws XmlException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(node, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCalcMode) XmlBeans.getContextTypeLoader().parse(node, STCalcMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
