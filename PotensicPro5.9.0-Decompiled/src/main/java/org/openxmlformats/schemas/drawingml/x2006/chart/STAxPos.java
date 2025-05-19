package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface STAxPos extends XmlString {
    public static final int INT_B = 1;
    public static final int INT_L = 2;
    public static final int INT_R = 3;
    public static final int INT_T = 4;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAxPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("staxpos4379type");
    public static final Enum B = Enum.forString("b");
    public static final Enum L = Enum.forString("l");
    public static final Enum R = Enum.forString(InternalZipConstants.READ_MODE);
    public static final Enum T = Enum.forString("t");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 1;
        static final int INT_L = 2;
        static final int INT_R = 3;
        static final int INT_T = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("b", 1), new Enum("l", 2), new Enum(InternalZipConstants.READ_MODE, 3), new Enum("t", 4)});

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

        public static STAxPos newInstance() {
            return (STAxPos) XmlBeans.getContextTypeLoader().newInstance(STAxPos.type, null);
        }

        public static STAxPos newInstance(XmlOptions xmlOptions) {
            return (STAxPos) XmlBeans.getContextTypeLoader().newInstance(STAxPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAxPos.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAxPos.type, xmlOptions);
        }

        public static STAxPos newValue(Object obj) {
            return (STAxPos) STAxPos.type.newValue(obj);
        }

        public static STAxPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(File file) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(file, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(file, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(InputStream inputStream) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(inputStream, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(inputStream, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(Reader reader) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(reader, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(reader, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(String str) throws XmlException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(str, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(str, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(URL url) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(url, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(url, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAxPos.type, xmlOptions);
        }

        public static STAxPos parse(Node node) throws XmlException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(node, STAxPos.type, (XmlOptions) null);
        }

        public static STAxPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAxPos) XmlBeans.getContextTypeLoader().parse(node, STAxPos.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
