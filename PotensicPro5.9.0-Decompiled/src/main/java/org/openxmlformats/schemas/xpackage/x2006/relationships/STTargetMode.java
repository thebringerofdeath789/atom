package org.openxmlformats.schemas.xpackage.x2006.relationships;

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

/* loaded from: classes6.dex */
public interface STTargetMode extends XmlString {
    public static final int INT_EXTERNAL = 1;
    public static final int INT_INTERNAL = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTargetMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("sttargetmode0e8ctype");
    public static final Enum EXTERNAL = Enum.forString("External");
    public static final Enum INTERNAL = Enum.forString("Internal");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EXTERNAL = 1;
        static final int INT_INTERNAL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("External", 1), new Enum("Internal", 2)});

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

        public static STTargetMode newInstance() {
            return (STTargetMode) XmlBeans.getContextTypeLoader().newInstance(STTargetMode.type, null);
        }

        public static STTargetMode newInstance(XmlOptions xmlOptions) {
            return (STTargetMode) XmlBeans.getContextTypeLoader().newInstance(STTargetMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTargetMode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode newValue(Object obj) {
            return (STTargetMode) STTargetMode.type.newValue(obj);
        }

        public static STTargetMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(File file) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(file, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(file, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(InputStream inputStream) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(inputStream, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(inputStream, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(Reader reader) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(reader, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(reader, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(String str) throws XmlException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(str, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(str, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(URL url) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(url, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(url, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTargetMode.type, xmlOptions);
        }

        public static STTargetMode parse(Node node) throws XmlException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(node, STTargetMode.type, (XmlOptions) null);
        }

        public static STTargetMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTargetMode) XmlBeans.getContextTypeLoader().parse(node, STTargetMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
