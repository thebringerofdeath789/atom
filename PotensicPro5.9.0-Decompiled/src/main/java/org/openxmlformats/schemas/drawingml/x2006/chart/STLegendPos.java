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
public interface STLegendPos extends XmlString {
    public static final int INT_B = 1;
    public static final int INT_L = 3;
    public static final int INT_R = 4;
    public static final int INT_T = 5;
    public static final int INT_TR = 2;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STLegendPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stlegendposc14ftype");
    public static final Enum B = Enum.forString("b");
    public static final Enum TR = Enum.forString("tr");
    public static final Enum L = Enum.forString("l");
    public static final Enum R = Enum.forString(InternalZipConstants.READ_MODE);
    public static final Enum T = Enum.forString("t");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 1;
        static final int INT_L = 3;
        static final int INT_R = 4;
        static final int INT_T = 5;
        static final int INT_TR = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("b", 1), new Enum("tr", 2), new Enum("l", 3), new Enum(InternalZipConstants.READ_MODE, 4), new Enum("t", 5)});

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

        public static STLegendPos newInstance() {
            return (STLegendPos) XmlBeans.getContextTypeLoader().newInstance(STLegendPos.type, null);
        }

        public static STLegendPos newInstance(XmlOptions xmlOptions) {
            return (STLegendPos) XmlBeans.getContextTypeLoader().newInstance(STLegendPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLegendPos.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos newValue(Object obj) {
            return (STLegendPos) STLegendPos.type.newValue(obj);
        }

        public static STLegendPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(File file) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(file, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(file, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(InputStream inputStream) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(inputStream, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(inputStream, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(Reader reader) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(reader, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(reader, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(String str) throws XmlException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(str, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(str, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(URL url) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(url, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(url, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STLegendPos.type, xmlOptions);
        }

        public static STLegendPos parse(Node node) throws XmlException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(node, STLegendPos.type, (XmlOptions) null);
        }

        public static STLegendPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STLegendPos) XmlBeans.getContextTypeLoader().parse(node, STLegendPos.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
