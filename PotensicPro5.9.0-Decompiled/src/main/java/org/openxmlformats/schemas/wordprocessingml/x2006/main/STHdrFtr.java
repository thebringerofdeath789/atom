package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import com.mapbox.api.directions.v5.DirectionsCriteria;
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
public interface STHdrFtr extends XmlString {
    public static final int INT_DEFAULT = 2;
    public static final int INT_EVEN = 1;
    public static final int INT_FIRST = 3;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STHdrFtr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sthdrftr30catype");
    public static final Enum EVEN = Enum.forString("even");
    public static final Enum DEFAULT = Enum.forString("default");
    public static final Enum FIRST = Enum.forString(DirectionsCriteria.SOURCE_FIRST);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DEFAULT = 2;
        static final int INT_EVEN = 1;
        static final int INT_FIRST = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("even", 1), new Enum("default", 2), new Enum(DirectionsCriteria.SOURCE_FIRST, 3)});

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

        public static STHdrFtr newInstance() {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().newInstance(STHdrFtr.type, null);
        }

        public static STHdrFtr newInstance(XmlOptions xmlOptions) {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().newInstance(STHdrFtr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHdrFtr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr newValue(Object obj) {
            return (STHdrFtr) STHdrFtr.type.newValue(obj);
        }

        public static STHdrFtr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(File file) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(file, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(file, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(InputStream inputStream) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(inputStream, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(inputStream, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(Reader reader) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(reader, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(reader, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(String str) throws XmlException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(str, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(str, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(URL url) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(url, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(url, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STHdrFtr.type, xmlOptions);
        }

        public static STHdrFtr parse(Node node) throws XmlException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(node, STHdrFtr.type, (XmlOptions) null);
        }

        public static STHdrFtr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STHdrFtr) XmlBeans.getContextTypeLoader().parse(node, STHdrFtr.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
