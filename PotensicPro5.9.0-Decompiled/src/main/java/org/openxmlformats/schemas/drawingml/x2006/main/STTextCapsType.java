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
public interface STTextCapsType extends XmlToken {
    public static final int INT_ALL = 3;
    public static final int INT_NONE = 1;
    public static final int INT_SMALL = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextCapsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextcapstyped233type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum SMALL = Enum.forString("small");
    public static final Enum ALL = Enum.forString(TtmlNode.COMBINE_ALL);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL = 3;
        static final int INT_NONE = 1;
        static final int INT_SMALL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("small", 2), new Enum(TtmlNode.COMBINE_ALL, 3)});

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

        public static STTextCapsType newInstance() {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().newInstance(STTextCapsType.type, null);
        }

        public static STTextCapsType newInstance(XmlOptions xmlOptions) {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().newInstance(STTextCapsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextCapsType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType newValue(Object obj) {
            return (STTextCapsType) STTextCapsType.type.newValue(obj);
        }

        public static STTextCapsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(File file) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(file, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(file, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(Reader reader) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(reader, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(reader, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(String str) throws XmlException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(str, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(str, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(URL url) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(url, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(url, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(Node node) throws XmlException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(node, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextCapsType) XmlBeans.getContextTypeLoader().parse(node, STTextCapsType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
