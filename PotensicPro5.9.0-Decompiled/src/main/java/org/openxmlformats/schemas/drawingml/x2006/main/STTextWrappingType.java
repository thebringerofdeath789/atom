package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STTextWrappingType extends XmlToken {
    public static final int INT_NONE = 1;
    public static final int INT_SQUARE = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextWrappingType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextwrappingtype4b4etype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum SQUARE = Enum.forString(Property.LINE_CAP_SQUARE);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_NONE = 1;
        static final int INT_SQUARE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum(Property.LINE_CAP_SQUARE, 2)});

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

        public static STTextWrappingType newInstance() {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().newInstance(STTextWrappingType.type, null);
        }

        public static STTextWrappingType newInstance(XmlOptions xmlOptions) {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().newInstance(STTextWrappingType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextWrappingType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType newValue(Object obj) {
            return (STTextWrappingType) STTextWrappingType.type.newValue(obj);
        }

        public static STTextWrappingType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(File file) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(file, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(file, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(Reader reader) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(reader, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(reader, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(String str) throws XmlException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(str, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(str, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(URL url) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(url, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(url, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(Node node) throws XmlException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(node, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextWrappingType) XmlBeans.getContextTypeLoader().parse(node, STTextWrappingType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
