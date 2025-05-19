package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface STLineSpacingRule extends XmlString {
    public static final int INT_AT_LEAST = 3;
    public static final int INT_AUTO = 1;
    public static final int INT_EXACT = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLineSpacingRule.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlinespacingrule6237type");
    public static final Enum AUTO = Enum.forString("auto");
    public static final Enum EXACT = Enum.forString("exact");
    public static final Enum AT_LEAST = Enum.forString("atLeast");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AT_LEAST = 3;
        static final int INT_AUTO = 1;
        static final int INT_EXACT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1), new Enum("exact", 2), new Enum("atLeast", 3)});

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

        public static STLineSpacingRule newInstance() {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().newInstance(STLineSpacingRule.type, null);
        }

        public static STLineSpacingRule newInstance(XmlOptions xmlOptions) {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().newInstance(STLineSpacingRule.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineSpacingRule.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule newValue(Object obj) {
            return (STLineSpacingRule) STLineSpacingRule.type.newValue(obj);
        }

        public static STLineSpacingRule parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(File file) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(file, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(file, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(InputStream inputStream) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(inputStream, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(inputStream, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(Reader reader) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(reader, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(reader, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(String str) throws XmlException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(str, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(str, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(URL url) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(url, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(url, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(Node node) throws XmlException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(node, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLineSpacingRule) XmlBeans.getContextTypeLoader().parse(node, STLineSpacingRule.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
