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
public interface STPresetLineDashVal extends XmlToken {
    public static final int INT_DASH = 3;
    public static final int INT_DASH_DOT = 5;
    public static final int INT_DOT = 2;
    public static final int INT_LG_DASH = 4;
    public static final int INT_LG_DASH_DOT = 6;
    public static final int INT_LG_DASH_DOT_DOT = 7;
    public static final int INT_SOLID = 1;
    public static final int INT_SYS_DASH = 8;
    public static final int INT_SYS_DASH_DOT = 10;
    public static final int INT_SYS_DASH_DOT_DOT = 11;
    public static final int INT_SYS_DOT = 9;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPresetLineDashVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpresetlinedashval159dtype");
    public static final Enum SOLID = Enum.forString("solid");
    public static final Enum DOT = Enum.forString(TtmlNode.TEXT_EMPHASIS_MARK_DOT);
    public static final Enum DASH = Enum.forString("dash");
    public static final Enum LG_DASH = Enum.forString("lgDash");
    public static final Enum DASH_DOT = Enum.forString("dashDot");
    public static final Enum LG_DASH_DOT = Enum.forString("lgDashDot");
    public static final Enum LG_DASH_DOT_DOT = Enum.forString("lgDashDotDot");
    public static final Enum SYS_DASH = Enum.forString("sysDash");
    public static final Enum SYS_DOT = Enum.forString("sysDot");
    public static final Enum SYS_DASH_DOT = Enum.forString("sysDashDot");
    public static final Enum SYS_DASH_DOT_DOT = Enum.forString("sysDashDotDot");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASH = 3;
        static final int INT_DASH_DOT = 5;
        static final int INT_DOT = 2;
        static final int INT_LG_DASH = 4;
        static final int INT_LG_DASH_DOT = 6;
        static final int INT_LG_DASH_DOT_DOT = 7;
        static final int INT_SOLID = 1;
        static final int INT_SYS_DASH = 8;
        static final int INT_SYS_DASH_DOT = 10;
        static final int INT_SYS_DASH_DOT_DOT = 11;
        static final int INT_SYS_DOT = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("solid", 1), new Enum(TtmlNode.TEXT_EMPHASIS_MARK_DOT, 2), new Enum("dash", 3), new Enum("lgDash", 4), new Enum("dashDot", 5), new Enum("lgDashDot", 6), new Enum("lgDashDotDot", 7), new Enum("sysDash", 8), new Enum("sysDot", 9), new Enum("sysDashDot", 10), new Enum("sysDashDotDot", 11)});

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

        public static STPresetLineDashVal newInstance() {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().newInstance(STPresetLineDashVal.type, null);
        }

        public static STPresetLineDashVal newInstance(XmlOptions xmlOptions) {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().newInstance(STPresetLineDashVal.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPresetLineDashVal.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal newValue(Object obj) {
            return (STPresetLineDashVal) STPresetLineDashVal.type.newValue(obj);
        }

        public static STPresetLineDashVal parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(File file) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(file, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(file, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(InputStream inputStream) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(inputStream, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(inputStream, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(Reader reader) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(reader, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(reader, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(String str) throws XmlException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(str, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(str, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(URL url) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(url, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(url, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPresetLineDashVal.type, xmlOptions);
        }

        public static STPresetLineDashVal parse(Node node) throws XmlException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(node, STPresetLineDashVal.type, (XmlOptions) null);
        }

        public static STPresetLineDashVal parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPresetLineDashVal) XmlBeans.getContextTypeLoader().parse(node, STPresetLineDashVal.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
