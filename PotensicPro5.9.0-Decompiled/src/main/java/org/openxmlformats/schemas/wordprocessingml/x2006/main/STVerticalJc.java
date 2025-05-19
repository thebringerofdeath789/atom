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
public interface STVerticalJc extends XmlString {
    public static final int INT_BOTH = 3;
    public static final int INT_BOTTOM = 4;
    public static final int INT_CENTER = 2;
    public static final int INT_TOP = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STVerticalJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stverticaljc3629type");
    public static final Enum TOP = Enum.forString("top");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum BOTH = Enum.forString(Property.ICON_TEXT_FIT_BOTH);
    public static final Enum BOTTOM = Enum.forString("bottom");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTH = 3;
        static final int INT_BOTTOM = 4;
        static final int INT_CENTER = 2;
        static final int INT_TOP = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("top", 1), new Enum("center", 2), new Enum(Property.ICON_TEXT_FIT_BOTH, 3), new Enum("bottom", 4)});

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

        public static STVerticalJc newInstance() {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().newInstance(STVerticalJc.type, null);
        }

        public static STVerticalJc newInstance(XmlOptions xmlOptions) {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().newInstance(STVerticalJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STVerticalJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc newValue(Object obj) {
            return (STVerticalJc) STVerticalJc.type.newValue(obj);
        }

        public static STVerticalJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(File file) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(file, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(file, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(InputStream inputStream) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(inputStream, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(inputStream, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(Reader reader) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(reader, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(reader, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(String str) throws XmlException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(str, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(str, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(URL url) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(url, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(url, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STVerticalJc.type, xmlOptions);
        }

        public static STVerticalJc parse(Node node) throws XmlException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(node, STVerticalJc.type, (XmlOptions) null);
        }

        public static STVerticalJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STVerticalJc) XmlBeans.getContextTypeLoader().parse(node, STVerticalJc.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
