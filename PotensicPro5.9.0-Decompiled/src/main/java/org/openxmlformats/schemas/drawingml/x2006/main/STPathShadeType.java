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
public interface STPathShadeType extends XmlToken {
    public static final int INT_CIRCLE = 2;
    public static final int INT_RECT = 3;
    public static final int INT_SHAPE = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPathShadeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpathshadetype93c3type");
    public static final Enum SHAPE = Enum.forString("shape");
    public static final Enum CIRCLE = Enum.forString(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    public static final Enum RECT = Enum.forString("rect");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CIRCLE = 2;
        static final int INT_RECT = 3;
        static final int INT_SHAPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("shape", 1), new Enum(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, 2), new Enum("rect", 3)});

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

        public static STPathShadeType newInstance() {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().newInstance(STPathShadeType.type, null);
        }

        public static STPathShadeType newInstance(XmlOptions xmlOptions) {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().newInstance(STPathShadeType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPathShadeType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType newValue(Object obj) {
            return (STPathShadeType) STPathShadeType.type.newValue(obj);
        }

        public static STPathShadeType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(File file) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(file, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(file, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(InputStream inputStream) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(inputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(inputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(Reader reader) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(reader, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(reader, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(String str) throws XmlException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(str, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(str, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(URL url) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(url, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(url, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(Node node) throws XmlException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(node, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPathShadeType) XmlBeans.getContextTypeLoader().parse(node, STPathShadeType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
