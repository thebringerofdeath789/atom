package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
public interface STTextFontAlignType extends XmlToken {
    public static final int INT_AUTO = 1;
    public static final int INT_B = 5;
    public static final int INT_BASE = 4;
    public static final int INT_CTR = 3;
    public static final int INT_T = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextFontAlignType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextfontaligntypecb44type");
    public static final Enum AUTO = Enum.forString("auto");
    public static final Enum T = Enum.forString("t");
    public static final Enum CTR = Enum.forString("ctr");
    public static final Enum BASE = Enum.forString(TtmlNode.RUBY_BASE);
    public static final Enum B = Enum.forString("b");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        static final int INT_B = 5;
        static final int INT_BASE = 4;
        static final int INT_CTR = 3;
        static final int INT_T = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1), new Enum("t", 2), new Enum("ctr", 3), new Enum(TtmlNode.RUBY_BASE, 4), new Enum("b", 5)});

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

        public static STTextFontAlignType newInstance() {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().newInstance(STTextFontAlignType.type, null);
        }

        public static STTextFontAlignType newInstance(XmlOptions xmlOptions) {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().newInstance(STTextFontAlignType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextFontAlignType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType newValue(Object obj) {
            return (STTextFontAlignType) STTextFontAlignType.type.newValue(obj);
        }

        public static STTextFontAlignType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(File file) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(file, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(file, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(Reader reader) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(reader, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(reader, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(String str) throws XmlException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(str, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(str, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(URL url) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(url, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(url, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(Node node) throws XmlException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(node, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontAlignType) XmlBeans.getContextTypeLoader().parse(node, STTextFontAlignType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
