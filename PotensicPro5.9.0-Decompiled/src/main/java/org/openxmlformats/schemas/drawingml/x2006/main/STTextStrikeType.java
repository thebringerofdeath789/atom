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
public interface STTextStrikeType extends XmlToken {
    public static final int INT_DBL_STRIKE = 3;
    public static final int INT_NO_STRIKE = 1;
    public static final int INT_SNG_STRIKE = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextStrikeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextstriketype4744type");
    public static final Enum NO_STRIKE = Enum.forString("noStrike");
    public static final Enum SNG_STRIKE = Enum.forString("sngStrike");
    public static final Enum DBL_STRIKE = Enum.forString("dblStrike");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DBL_STRIKE = 3;
        static final int INT_NO_STRIKE = 1;
        static final int INT_SNG_STRIKE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("noStrike", 1), new Enum("sngStrike", 2), new Enum("dblStrike", 3)});

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

        public static STTextStrikeType newInstance() {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().newInstance(STTextStrikeType.type, null);
        }

        public static STTextStrikeType newInstance(XmlOptions xmlOptions) {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().newInstance(STTextStrikeType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextStrikeType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType newValue(Object obj) {
            return (STTextStrikeType) STTextStrikeType.type.newValue(obj);
        }

        public static STTextStrikeType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(File file) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(file, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(file, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(inputStream, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(Reader reader) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(reader, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(reader, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(String str) throws XmlException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(str, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(str, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(URL url) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(url, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(url, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextStrikeType.type, xmlOptions);
        }

        public static STTextStrikeType parse(Node node) throws XmlException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(node, STTextStrikeType.type, (XmlOptions) null);
        }

        public static STTextStrikeType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextStrikeType) XmlBeans.getContextTypeLoader().parse(node, STTextStrikeType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
