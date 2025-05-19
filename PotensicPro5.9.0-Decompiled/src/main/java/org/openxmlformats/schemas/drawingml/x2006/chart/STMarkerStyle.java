package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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

/* loaded from: classes2.dex */
public interface STMarkerStyle extends XmlString {
    public static final int INT_CIRCLE = 1;
    public static final int INT_DASH = 2;
    public static final int INT_DIAMOND = 3;
    public static final int INT_DOT = 4;
    public static final int INT_NONE = 5;
    public static final int INT_PICTURE = 6;
    public static final int INT_PLUS = 7;
    public static final int INT_SQUARE = 8;
    public static final int INT_STAR = 9;
    public static final int INT_TRIANGLE = 10;
    public static final int INT_X = 11;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STMarkerStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stmarkerstyle177ftype");
    public static final Enum CIRCLE = Enum.forString(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    public static final Enum DASH = Enum.forString("dash");
    public static final Enum DIAMOND = Enum.forString("diamond");
    public static final Enum DOT = Enum.forString(TtmlNode.TEXT_EMPHASIS_MARK_DOT);
    public static final Enum NONE = Enum.forString("none");
    public static final Enum PICTURE = Enum.forString("picture");
    public static final Enum PLUS = Enum.forString("plus");
    public static final Enum SQUARE = Enum.forString(Property.LINE_CAP_SQUARE);
    public static final Enum STAR = Enum.forString("star");
    public static final Enum TRIANGLE = Enum.forString("triangle");
    public static final Enum X = Enum.forString("x");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CIRCLE = 1;
        static final int INT_DASH = 2;
        static final int INT_DIAMOND = 3;
        static final int INT_DOT = 4;
        static final int INT_NONE = 5;
        static final int INT_PICTURE = 6;
        static final int INT_PLUS = 7;
        static final int INT_SQUARE = 8;
        static final int INT_STAR = 9;
        static final int INT_TRIANGLE = 10;
        static final int INT_X = 11;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, 1), new Enum("dash", 2), new Enum("diamond", 3), new Enum(TtmlNode.TEXT_EMPHASIS_MARK_DOT, 4), new Enum("none", 5), new Enum("picture", 6), new Enum("plus", 7), new Enum(Property.LINE_CAP_SQUARE, 8), new Enum("star", 9), new Enum("triangle", 10), new Enum("x", 11)});

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

        public static STMarkerStyle newInstance() {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().newInstance(STMarkerStyle.type, null);
        }

        public static STMarkerStyle newInstance(XmlOptions xmlOptions) {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().newInstance(STMarkerStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STMarkerStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle newValue(Object obj) {
            return (STMarkerStyle) STMarkerStyle.type.newValue(obj);
        }

        public static STMarkerStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(File file) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(file, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(file, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(inputStream, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(inputStream, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(Reader reader) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(reader, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(reader, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(String str) throws XmlException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(str, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(str, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(URL url) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(url, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(url, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STMarkerStyle.type, xmlOptions);
        }

        public static STMarkerStyle parse(Node node) throws XmlException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(node, STMarkerStyle.type, (XmlOptions) null);
        }

        public static STMarkerStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STMarkerStyle) XmlBeans.getContextTypeLoader().parse(node, STMarkerStyle.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
