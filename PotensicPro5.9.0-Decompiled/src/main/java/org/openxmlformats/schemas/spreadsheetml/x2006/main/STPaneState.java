package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface STPaneState extends XmlString {
    public static final int INT_FROZEN = 2;
    public static final int INT_FROZEN_SPLIT = 3;
    public static final int INT_SPLIT = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPaneState.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpanestateae58type");
    public static final Enum SPLIT = Enum.forString("split");
    public static final Enum FROZEN = Enum.forString("frozen");
    public static final Enum FROZEN_SPLIT = Enum.forString("frozenSplit");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FROZEN = 2;
        static final int INT_FROZEN_SPLIT = 3;
        static final int INT_SPLIT = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("split", 1), new Enum("frozen", 2), new Enum("frozenSplit", 3)});

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

        public static STPaneState newInstance() {
            return (STPaneState) XmlBeans.getContextTypeLoader().newInstance(STPaneState.type, null);
        }

        public static STPaneState newInstance(XmlOptions xmlOptions) {
            return (STPaneState) XmlBeans.getContextTypeLoader().newInstance(STPaneState.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPaneState.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPaneState.type, xmlOptions);
        }

        public static STPaneState newValue(Object obj) {
            return (STPaneState) STPaneState.type.newValue(obj);
        }

        public static STPaneState parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(File file) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(file, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(file, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(InputStream inputStream) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(inputStream, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(inputStream, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(Reader reader) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(reader, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(reader, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(String str) throws XmlException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(str, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(str, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(URL url) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(url, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(url, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPaneState.type, xmlOptions);
        }

        public static STPaneState parse(Node node) throws XmlException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(node, STPaneState.type, (XmlOptions) null);
        }

        public static STPaneState parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPaneState) XmlBeans.getContextTypeLoader().parse(node, STPaneState.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
