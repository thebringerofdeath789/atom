package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
public interface STEditAs extends XmlToken {
    public static final int INT_ABSOLUTE = 3;
    public static final int INT_ONE_CELL = 2;
    public static final int INT_TWO_CELL = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STEditAs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("steditasad40type");
    public static final Enum TWO_CELL = Enum.forString("twoCell");
    public static final Enum ONE_CELL = Enum.forString("oneCell");
    public static final Enum ABSOLUTE = Enum.forString("absolute");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ABSOLUTE = 3;
        static final int INT_ONE_CELL = 2;
        static final int INT_TWO_CELL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("twoCell", 1), new Enum("oneCell", 2), new Enum("absolute", 3)});

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

        public static STEditAs newInstance() {
            return (STEditAs) XmlBeans.getContextTypeLoader().newInstance(STEditAs.type, null);
        }

        public static STEditAs newInstance(XmlOptions xmlOptions) {
            return (STEditAs) XmlBeans.getContextTypeLoader().newInstance(STEditAs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STEditAs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STEditAs.type, xmlOptions);
        }

        public static STEditAs newValue(Object obj) {
            return (STEditAs) STEditAs.type.newValue(obj);
        }

        public static STEditAs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(File file) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(file, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(file, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(InputStream inputStream) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(inputStream, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(inputStream, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(Reader reader) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(reader, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(reader, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(String str) throws XmlException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(str, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(str, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(URL url) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(url, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(url, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(Node node) throws XmlException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(node, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STEditAs) XmlBeans.getContextTypeLoader().parse(node, STEditAs.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
