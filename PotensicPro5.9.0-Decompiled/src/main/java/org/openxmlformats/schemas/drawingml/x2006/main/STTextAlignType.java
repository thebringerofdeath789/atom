package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import net.lingala.zip4j.util.InternalZipConstants;
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
public interface STTextAlignType extends XmlToken {
    public static final int INT_CTR = 2;
    public static final int INT_DIST = 6;
    public static final int INT_JUST = 4;
    public static final int INT_JUST_LOW = 5;
    public static final int INT_L = 1;
    public static final int INT_R = 3;
    public static final int INT_THAI_DIST = 7;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextAlignType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextaligntypebc93type");
    public static final Enum L = Enum.forString("l");
    public static final Enum CTR = Enum.forString("ctr");
    public static final Enum R = Enum.forString(InternalZipConstants.READ_MODE);
    public static final Enum JUST = Enum.forString("just");
    public static final Enum JUST_LOW = Enum.forString("justLow");
    public static final Enum DIST = Enum.forString("dist");
    public static final Enum THAI_DIST = Enum.forString("thaiDist");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CTR = 2;
        static final int INT_DIST = 6;
        static final int INT_JUST = 4;
        static final int INT_JUST_LOW = 5;
        static final int INT_L = 1;
        static final int INT_R = 3;
        static final int INT_THAI_DIST = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("l", 1), new Enum("ctr", 2), new Enum(InternalZipConstants.READ_MODE, 3), new Enum("just", 4), new Enum("justLow", 5), new Enum("dist", 6), new Enum("thaiDist", 7)});

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

        public static STTextAlignType newInstance() {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().newInstance(STTextAlignType.type, null);
        }

        public static STTextAlignType newInstance(XmlOptions xmlOptions) {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().newInstance(STTextAlignType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextAlignType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType newValue(Object obj) {
            return (STTextAlignType) STTextAlignType.type.newValue(obj);
        }

        public static STTextAlignType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(File file) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(file, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(file, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(Reader reader) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(reader, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(reader, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(String str) throws XmlException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(str, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(str, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(URL url) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(url, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(url, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(Node node) throws XmlException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(node, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextAlignType) XmlBeans.getContextTypeLoader().parse(node, STTextAlignType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
