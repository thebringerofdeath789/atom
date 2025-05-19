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
public interface STSourceType extends XmlString {
    public static final int INT_CONSOLIDATION = 3;
    public static final int INT_EXTERNAL = 2;
    public static final int INT_SCENARIO = 4;
    public static final int INT_WORKSHEET = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSourceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stsourcetype074etype");
    public static final Enum WORKSHEET = Enum.forString("worksheet");
    public static final Enum EXTERNAL = Enum.forString("external");
    public static final Enum CONSOLIDATION = Enum.forString("consolidation");
    public static final Enum SCENARIO = Enum.forString("scenario");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONSOLIDATION = 3;
        static final int INT_EXTERNAL = 2;
        static final int INT_SCENARIO = 4;
        static final int INT_WORKSHEET = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("worksheet", 1), new Enum("external", 2), new Enum("consolidation", 3), new Enum("scenario", 4)});

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

        public static STSourceType newInstance() {
            return (STSourceType) XmlBeans.getContextTypeLoader().newInstance(STSourceType.type, null);
        }

        public static STSourceType newInstance(XmlOptions xmlOptions) {
            return (STSourceType) XmlBeans.getContextTypeLoader().newInstance(STSourceType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSourceType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSourceType.type, xmlOptions);
        }

        public static STSourceType newValue(Object obj) {
            return (STSourceType) STSourceType.type.newValue(obj);
        }

        public static STSourceType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(File file) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(file, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(file, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(InputStream inputStream) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(inputStream, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(inputStream, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(Reader reader) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(reader, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(reader, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(String str) throws XmlException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(str, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(str, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(URL url) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(url, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(url, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSourceType.type, xmlOptions);
        }

        public static STSourceType parse(Node node) throws XmlException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(node, STSourceType.type, (XmlOptions) null);
        }

        public static STSourceType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSourceType) XmlBeans.getContextTypeLoader().parse(node, STSourceType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
