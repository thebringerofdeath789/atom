package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import com.mapbox.api.directions.v5.models.Incident;
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
public interface STFontCollectionIndex extends XmlToken {
    public static final int INT_MAJOR = 1;
    public static final int INT_MINOR = 2;
    public static final int INT_NONE = 3;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFontCollectionIndex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stfontcollectionindex6766type");
    public static final Enum MAJOR = Enum.forString(Incident.IMPACT_MAJOR);
    public static final Enum MINOR = Enum.forString(Incident.IMPACT_MINOR);
    public static final Enum NONE = Enum.forString("none");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAJOR = 1;
        static final int INT_MINOR = 2;
        static final int INT_NONE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(Incident.IMPACT_MAJOR, 1), new Enum(Incident.IMPACT_MINOR, 2), new Enum("none", 3)});

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

        public static STFontCollectionIndex newInstance() {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().newInstance(STFontCollectionIndex.type, null);
        }

        public static STFontCollectionIndex newInstance(XmlOptions xmlOptions) {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().newInstance(STFontCollectionIndex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFontCollectionIndex.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex newValue(Object obj) {
            return (STFontCollectionIndex) STFontCollectionIndex.type.newValue(obj);
        }

        public static STFontCollectionIndex parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(File file) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(file, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(file, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(InputStream inputStream) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(inputStream, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(inputStream, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(Reader reader) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(reader, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(reader, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(String str) throws XmlException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(str, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(str, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(URL url) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(url, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(url, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(Node node) throws XmlException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(node, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFontCollectionIndex) XmlBeans.getContextTypeLoader().parse(node, STFontCollectionIndex.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
