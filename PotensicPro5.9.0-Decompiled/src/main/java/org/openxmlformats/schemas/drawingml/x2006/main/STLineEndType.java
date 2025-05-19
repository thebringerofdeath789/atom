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
public interface STLineEndType extends XmlToken {
    public static final int INT_ARROW = 6;
    public static final int INT_DIAMOND = 4;
    public static final int INT_NONE = 1;
    public static final int INT_OVAL = 5;
    public static final int INT_STEALTH = 3;
    public static final int INT_TRIANGLE = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLineEndType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlineendtype8902type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum TRIANGLE = Enum.forString("triangle");
    public static final Enum STEALTH = Enum.forString("stealth");
    public static final Enum DIAMOND = Enum.forString("diamond");
    public static final Enum OVAL = Enum.forString("oval");
    public static final Enum ARROW = Enum.forString("arrow");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ARROW = 6;
        static final int INT_DIAMOND = 4;
        static final int INT_NONE = 1;
        static final int INT_OVAL = 5;
        static final int INT_STEALTH = 3;
        static final int INT_TRIANGLE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("triangle", 2), new Enum("stealth", 3), new Enum("diamond", 4), new Enum("oval", 5), new Enum("arrow", 6)});

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

        public static STLineEndType newInstance() {
            return (STLineEndType) XmlBeans.getContextTypeLoader().newInstance(STLineEndType.type, null);
        }

        public static STLineEndType newInstance(XmlOptions xmlOptions) {
            return (STLineEndType) XmlBeans.getContextTypeLoader().newInstance(STLineEndType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineEndType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType newValue(Object obj) {
            return (STLineEndType) STLineEndType.type.newValue(obj);
        }

        public static STLineEndType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(File file) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(file, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(file, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(InputStream inputStream) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(inputStream, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(inputStream, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(Reader reader) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(reader, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(reader, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(String str) throws XmlException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(str, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(str, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(URL url) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(url, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(url, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineEndType.type, xmlOptions);
        }

        public static STLineEndType parse(Node node) throws XmlException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(node, STLineEndType.type, (XmlOptions) null);
        }

        public static STLineEndType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLineEndType) XmlBeans.getContextTypeLoader().parse(node, STLineEndType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
