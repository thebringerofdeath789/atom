package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import com.mapbox.mapboxsdk.style.layers.Property;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.ss.util.CellUtil;
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
public interface STSheetState extends XmlString {
    public static final int INT_HIDDEN = 2;
    public static final int INT_VERY_HIDDEN = 3;
    public static final int INT_VISIBLE = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSheetState.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stsheetstate158btype");
    public static final Enum VISIBLE = Enum.forString(Property.VISIBLE);
    public static final Enum HIDDEN = Enum.forString(CellUtil.HIDDEN);
    public static final Enum VERY_HIDDEN = Enum.forString("veryHidden");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HIDDEN = 2;
        static final int INT_VERY_HIDDEN = 3;
        static final int INT_VISIBLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(Property.VISIBLE, 1), new Enum(CellUtil.HIDDEN, 2), new Enum("veryHidden", 3)});

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

        public static STSheetState newInstance() {
            return (STSheetState) XmlBeans.getContextTypeLoader().newInstance(STSheetState.type, null);
        }

        public static STSheetState newInstance(XmlOptions xmlOptions) {
            return (STSheetState) XmlBeans.getContextTypeLoader().newInstance(STSheetState.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSheetState.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSheetState.type, xmlOptions);
        }

        public static STSheetState newValue(Object obj) {
            return (STSheetState) STSheetState.type.newValue(obj);
        }

        public static STSheetState parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(File file) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(file, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(file, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(InputStream inputStream) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(inputStream, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(inputStream, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(Reader reader) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(reader, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(reader, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(String str) throws XmlException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(str, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(str, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(URL url) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(url, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(url, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(Node node) throws XmlException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(node, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSheetState) XmlBeans.getContextTypeLoader().parse(node, STSheetState.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
