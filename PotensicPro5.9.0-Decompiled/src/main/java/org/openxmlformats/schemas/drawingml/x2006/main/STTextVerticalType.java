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
public interface STTextVerticalType extends XmlToken {
    public static final int INT_EA_VERT = 5;
    public static final int INT_HORZ = 1;
    public static final int INT_MONGOLIAN_VERT = 6;
    public static final int INT_VERT = 2;
    public static final int INT_VERT_270 = 3;
    public static final int INT_WORD_ART_VERT = 4;
    public static final int INT_WORD_ART_VERT_RTL = 7;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextVerticalType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextverticaltyped988type");
    public static final Enum HORZ = Enum.forString("horz");
    public static final Enum VERT = Enum.forString("vert");
    public static final Enum VERT_270 = Enum.forString("vert270");
    public static final Enum WORD_ART_VERT = Enum.forString("wordArtVert");
    public static final Enum EA_VERT = Enum.forString("eaVert");
    public static final Enum MONGOLIAN_VERT = Enum.forString("mongolianVert");
    public static final Enum WORD_ART_VERT_RTL = Enum.forString("wordArtVertRtl");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EA_VERT = 5;
        static final int INT_HORZ = 1;
        static final int INT_MONGOLIAN_VERT = 6;
        static final int INT_VERT = 2;
        static final int INT_VERT_270 = 3;
        static final int INT_WORD_ART_VERT = 4;
        static final int INT_WORD_ART_VERT_RTL = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("horz", 1), new Enum("vert", 2), new Enum("vert270", 3), new Enum("wordArtVert", 4), new Enum("eaVert", 5), new Enum("mongolianVert", 6), new Enum("wordArtVertRtl", 7)});

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

        public static STTextVerticalType newInstance() {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().newInstance(STTextVerticalType.type, null);
        }

        public static STTextVerticalType newInstance(XmlOptions xmlOptions) {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().newInstance(STTextVerticalType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextVerticalType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType newValue(Object obj) {
            return (STTextVerticalType) STTextVerticalType.type.newValue(obj);
        }

        public static STTextVerticalType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(File file) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(file, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(file, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(Reader reader) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(reader, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(reader, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(String str) throws XmlException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(str, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(str, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(URL url) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(url, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(url, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextVerticalType.type, xmlOptions);
        }

        public static STTextVerticalType parse(Node node) throws XmlException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(node, STTextVerticalType.type, (XmlOptions) null);
        }

        public static STTextVerticalType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextVerticalType) XmlBeans.getContextTypeLoader().parse(node, STTextVerticalType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
