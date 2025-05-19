package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import com.mapbox.mapboxsdk.style.layers.Property;
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
public interface STJc extends XmlString {
    public static final int INT_BOTH = 4;
    public static final int INT_CENTER = 2;
    public static final int INT_DISTRIBUTE = 6;
    public static final int INT_HIGH_KASHIDA = 8;
    public static final int INT_LEFT = 1;
    public static final int INT_LOW_KASHIDA = 9;
    public static final int INT_MEDIUM_KASHIDA = 5;
    public static final int INT_NUM_TAB = 7;
    public static final int INT_RIGHT = 3;
    public static final int INT_THAI_DISTRIBUTE = 10;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stjc977ftype");
    public static final Enum LEFT = Enum.forString("left");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum RIGHT = Enum.forString("right");
    public static final Enum BOTH = Enum.forString(Property.ICON_TEXT_FIT_BOTH);
    public static final Enum MEDIUM_KASHIDA = Enum.forString("mediumKashida");
    public static final Enum DISTRIBUTE = Enum.forString("distribute");
    public static final Enum NUM_TAB = Enum.forString("numTab");
    public static final Enum HIGH_KASHIDA = Enum.forString("highKashida");
    public static final Enum LOW_KASHIDA = Enum.forString("lowKashida");
    public static final Enum THAI_DISTRIBUTE = Enum.forString("thaiDistribute");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTH = 4;
        static final int INT_CENTER = 2;
        static final int INT_DISTRIBUTE = 6;
        static final int INT_HIGH_KASHIDA = 8;
        static final int INT_LEFT = 1;
        static final int INT_LOW_KASHIDA = 9;
        static final int INT_MEDIUM_KASHIDA = 5;
        static final int INT_NUM_TAB = 7;
        static final int INT_RIGHT = 3;
        static final int INT_THAI_DISTRIBUTE = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("left", 1), new Enum("center", 2), new Enum("right", 3), new Enum(Property.ICON_TEXT_FIT_BOTH, 4), new Enum("mediumKashida", 5), new Enum("distribute", 6), new Enum("numTab", 7), new Enum("highKashida", 8), new Enum("lowKashida", 9), new Enum("thaiDistribute", 10)});

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

        public static STJc newInstance() {
            return (STJc) XmlBeans.getContextTypeLoader().newInstance(STJc.type, null);
        }

        public static STJc newInstance(XmlOptions xmlOptions) {
            return (STJc) XmlBeans.getContextTypeLoader().newInstance(STJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STJc.type, xmlOptions);
        }

        public static STJc newValue(Object obj) {
            return (STJc) STJc.type.newValue(obj);
        }

        public static STJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STJc.type, xmlOptions);
        }

        public static STJc parse(File file) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(file, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(file, STJc.type, xmlOptions);
        }

        public static STJc parse(InputStream inputStream) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(inputStream, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(inputStream, STJc.type, xmlOptions);
        }

        public static STJc parse(Reader reader) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(reader, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(reader, STJc.type, xmlOptions);
        }

        public static STJc parse(String str) throws XmlException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(str, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(str, STJc.type, xmlOptions);
        }

        public static STJc parse(URL url) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(url, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(url, STJc.type, xmlOptions);
        }

        public static STJc parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STJc.type, xmlOptions);
        }

        public static STJc parse(Node node) throws XmlException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(node, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STJc) XmlBeans.getContextTypeLoader().parse(node, STJc.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
