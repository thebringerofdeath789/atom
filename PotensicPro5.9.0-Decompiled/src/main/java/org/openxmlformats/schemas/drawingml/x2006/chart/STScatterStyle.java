package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* loaded from: classes2.dex */
public interface STScatterStyle extends XmlString {
    public static final int INT_LINE = 2;
    public static final int INT_LINE_MARKER = 3;
    public static final int INT_MARKER = 4;
    public static final int INT_NONE = 1;
    public static final int INT_SMOOTH = 5;
    public static final int INT_SMOOTH_MARKER = 6;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STScatterStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stscatterstyle9eb9type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum LINE = Enum.forString("line");
    public static final Enum LINE_MARKER = Enum.forString("lineMarker");
    public static final Enum MARKER = Enum.forString("marker");
    public static final Enum SMOOTH = Enum.forString("smooth");
    public static final Enum SMOOTH_MARKER = Enum.forString("smoothMarker");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_LINE = 2;
        static final int INT_LINE_MARKER = 3;
        static final int INT_MARKER = 4;
        static final int INT_NONE = 1;
        static final int INT_SMOOTH = 5;
        static final int INT_SMOOTH_MARKER = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("line", 2), new Enum("lineMarker", 3), new Enum("marker", 4), new Enum("smooth", 5), new Enum("smoothMarker", 6)});

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

        public static STScatterStyle newInstance() {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().newInstance(STScatterStyle.type, null);
        }

        public static STScatterStyle newInstance(XmlOptions xmlOptions) {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().newInstance(STScatterStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STScatterStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle newValue(Object obj) {
            return (STScatterStyle) STScatterStyle.type.newValue(obj);
        }

        public static STScatterStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(File file) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(file, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(file, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(inputStream, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(inputStream, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(Reader reader) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(reader, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(reader, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(String str) throws XmlException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(str, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(str, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(URL url) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(url, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(url, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STScatterStyle.type, xmlOptions);
        }

        public static STScatterStyle parse(Node node) throws XmlException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(node, STScatterStyle.type, (XmlOptions) null);
        }

        public static STScatterStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STScatterStyle) XmlBeans.getContextTypeLoader().parse(node, STScatterStyle.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
