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
public interface STLineEndLength extends XmlToken {
    public static final int INT_LG = 3;
    public static final int INT_MED = 2;
    public static final int INT_SM = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLineEndLength.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlineendlength3f2etype");
    public static final Enum SM = Enum.forString("sm");
    public static final Enum MED = Enum.forString("med");
    public static final Enum LG = Enum.forString("lg");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_LG = 3;
        static final int INT_MED = 2;
        static final int INT_SM = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("sm", 1), new Enum("med", 2), new Enum("lg", 3)});

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

        public static STLineEndLength newInstance() {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().newInstance(STLineEndLength.type, null);
        }

        public static STLineEndLength newInstance(XmlOptions xmlOptions) {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().newInstance(STLineEndLength.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineEndLength.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength newValue(Object obj) {
            return (STLineEndLength) STLineEndLength.type.newValue(obj);
        }

        public static STLineEndLength parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(File file) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(file, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(file, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(InputStream inputStream) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(inputStream, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(inputStream, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(Reader reader) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(reader, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(reader, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(String str) throws XmlException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(str, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(str, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(URL url) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(url, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(url, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(Node node) throws XmlException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(node, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLineEndLength) XmlBeans.getContextTypeLoader().parse(node, STLineEndLength.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
