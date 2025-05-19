package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface STHexColorAuto extends XmlString {
    public static final int INT_AUTO = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHexColorAuto.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sthexcolorauto3ce1type");
    public static final Enum AUTO = Enum.forString("auto");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1)});

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

        public static STHexColorAuto newInstance() {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().newInstance(STHexColorAuto.type, null);
        }

        public static STHexColorAuto newInstance(XmlOptions xmlOptions) {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().newInstance(STHexColorAuto.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexColorAuto.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto newValue(Object obj) {
            return (STHexColorAuto) STHexColorAuto.type.newValue(obj);
        }

        public static STHexColorAuto parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(File file) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(file, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(file, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(InputStream inputStream) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(inputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(inputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(Reader reader) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(reader, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(reader, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(String str) throws XmlException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(str, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(str, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(URL url) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(url, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(url, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(Node node) throws XmlException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(node, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHexColorAuto) XmlBeans.getContextTypeLoader().parse(node, STHexColorAuto.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
