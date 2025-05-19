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
public interface STPenAlignment extends XmlToken {
    public static final int INT_CTR = 1;
    public static final int INT_IN = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPenAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpenalignmentd775type");
    public static final Enum CTR = Enum.forString("ctr");
    public static final Enum IN = Enum.forString("in");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CTR = 1;
        static final int INT_IN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("ctr", 1), new Enum("in", 2)});

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

        public static STPenAlignment newInstance() {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().newInstance(STPenAlignment.type, null);
        }

        public static STPenAlignment newInstance(XmlOptions xmlOptions) {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().newInstance(STPenAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPenAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment newValue(Object obj) {
            return (STPenAlignment) STPenAlignment.type.newValue(obj);
        }

        public static STPenAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(File file) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(file, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(file, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(inputStream, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(Reader reader) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(reader, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(reader, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(String str) throws XmlException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(str, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(str, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(URL url) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(url, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(url, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(Node node) throws XmlException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(node, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPenAlignment) XmlBeans.getContextTypeLoader().parse(node, STPenAlignment.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
