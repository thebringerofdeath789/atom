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
public interface STTblWidth extends XmlString {
    public static final int INT_AUTO = 4;
    public static final int INT_DXA = 3;
    public static final int INT_NIL = 1;
    public static final int INT_PCT = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTblWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttblwidth3a30type");
    public static final Enum NIL = Enum.forString("nil");
    public static final Enum PCT = Enum.forString("pct");
    public static final Enum DXA = Enum.forString("dxa");
    public static final Enum AUTO = Enum.forString("auto");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 4;
        static final int INT_DXA = 3;
        static final int INT_NIL = 1;
        static final int INT_PCT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("nil", 1), new Enum("pct", 2), new Enum("dxa", 3), new Enum("auto", 4)});

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

        public static STTblWidth newInstance() {
            return (STTblWidth) XmlBeans.getContextTypeLoader().newInstance(STTblWidth.type, null);
        }

        public static STTblWidth newInstance(XmlOptions xmlOptions) {
            return (STTblWidth) XmlBeans.getContextTypeLoader().newInstance(STTblWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTblWidth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth newValue(Object obj) {
            return (STTblWidth) STTblWidth.type.newValue(obj);
        }

        public static STTblWidth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(File file) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(file, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(file, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(InputStream inputStream) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(inputStream, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(inputStream, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(Reader reader) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(reader, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(reader, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(String str) throws XmlException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(str, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(str, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(URL url) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(url, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(url, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTblWidth.type, xmlOptions);
        }

        public static STTblWidth parse(Node node) throws XmlException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(node, STTblWidth.type, (XmlOptions) null);
        }

        public static STTblWidth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTblWidth) XmlBeans.getContextTypeLoader().parse(node, STTblWidth.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
