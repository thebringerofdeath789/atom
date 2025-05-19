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
public interface STTextHorzOverflowType extends XmlToken {
    public static final int INT_CLIP = 2;
    public static final int INT_OVERFLOW = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextHorzOverflowType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttexthorzoverflowtype6003type");
    public static final Enum OVERFLOW = Enum.forString("overflow");
    public static final Enum CLIP = Enum.forString("clip");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CLIP = 2;
        static final int INT_OVERFLOW = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("overflow", 1), new Enum("clip", 2)});

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

        public static STTextHorzOverflowType newInstance() {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().newInstance(STTextHorzOverflowType.type, null);
        }

        public static STTextHorzOverflowType newInstance(XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().newInstance(STTextHorzOverflowType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextHorzOverflowType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType newValue(Object obj) {
            return (STTextHorzOverflowType) STTextHorzOverflowType.type.newValue(obj);
        }

        public static STTextHorzOverflowType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(File file) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(file, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(file, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(Reader reader) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(reader, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(reader, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(String str) throws XmlException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(str, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(str, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(URL url) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(url, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(url, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(Node node) throws XmlException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(node, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextHorzOverflowType) XmlBeans.getContextTypeLoader().parse(node, STTextHorzOverflowType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
