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
public interface STTheme extends XmlString {
    public static final int INT_MAJOR_ASCII = 3;
    public static final int INT_MAJOR_BIDI = 2;
    public static final int INT_MAJOR_EAST_ASIA = 1;
    public static final int INT_MAJOR_H_ANSI = 4;
    public static final int INT_MINOR_ASCII = 7;
    public static final int INT_MINOR_BIDI = 6;
    public static final int INT_MINOR_EAST_ASIA = 5;
    public static final int INT_MINOR_H_ANSI = 8;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttheme58b9type");
    public static final Enum MAJOR_EAST_ASIA = Enum.forString("majorEastAsia");
    public static final Enum MAJOR_BIDI = Enum.forString("majorBidi");
    public static final Enum MAJOR_ASCII = Enum.forString("majorAscii");
    public static final Enum MAJOR_H_ANSI = Enum.forString("majorHAnsi");
    public static final Enum MINOR_EAST_ASIA = Enum.forString("minorEastAsia");
    public static final Enum MINOR_BIDI = Enum.forString("minorBidi");
    public static final Enum MINOR_ASCII = Enum.forString("minorAscii");
    public static final Enum MINOR_H_ANSI = Enum.forString("minorHAnsi");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAJOR_ASCII = 3;
        static final int INT_MAJOR_BIDI = 2;
        static final int INT_MAJOR_EAST_ASIA = 1;
        static final int INT_MAJOR_H_ANSI = 4;
        static final int INT_MINOR_ASCII = 7;
        static final int INT_MINOR_BIDI = 6;
        static final int INT_MINOR_EAST_ASIA = 5;
        static final int INT_MINOR_H_ANSI = 8;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("majorEastAsia", 1), new Enum("majorBidi", 2), new Enum("majorAscii", 3), new Enum("majorHAnsi", 4), new Enum("minorEastAsia", 5), new Enum("minorBidi", 6), new Enum("minorAscii", 7), new Enum("minorHAnsi", 8)});

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

        public static STTheme newInstance() {
            return (STTheme) XmlBeans.getContextTypeLoader().newInstance(STTheme.type, null);
        }

        public static STTheme newInstance(XmlOptions xmlOptions) {
            return (STTheme) XmlBeans.getContextTypeLoader().newInstance(STTheme.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTheme.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTheme.type, xmlOptions);
        }

        public static STTheme newValue(Object obj) {
            return (STTheme) STTheme.type.newValue(obj);
        }

        public static STTheme parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTheme.type, xmlOptions);
        }

        public static STTheme parse(File file) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(file, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(file, STTheme.type, xmlOptions);
        }

        public static STTheme parse(InputStream inputStream) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(inputStream, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(inputStream, STTheme.type, xmlOptions);
        }

        public static STTheme parse(Reader reader) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(reader, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(reader, STTheme.type, xmlOptions);
        }

        public static STTheme parse(String str) throws XmlException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(str, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(str, STTheme.type, xmlOptions);
        }

        public static STTheme parse(URL url) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(url, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(url, STTheme.type, xmlOptions);
        }

        public static STTheme parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTheme.type, xmlOptions);
        }

        public static STTheme parse(Node node) throws XmlException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(node, STTheme.type, (XmlOptions) null);
        }

        public static STTheme parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTheme) XmlBeans.getContextTypeLoader().parse(node, STTheme.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
