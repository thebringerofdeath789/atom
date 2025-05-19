package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STFontScheme extends XmlString {
    public static final int INT_MAJOR = 2;
    public static final int INT_MINOR = 3;
    public static final int INT_NONE = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STFontScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stfontschemef36dtype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum MAJOR = Enum.forString(Incident.IMPACT_MAJOR);
    public static final Enum MINOR = Enum.forString(Incident.IMPACT_MINOR);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAJOR = 2;
        static final int INT_MINOR = 3;
        static final int INT_NONE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum(Incident.IMPACT_MAJOR, 2), new Enum(Incident.IMPACT_MINOR, 3)});

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

        public static STFontScheme newInstance() {
            return (STFontScheme) XmlBeans.getContextTypeLoader().newInstance(STFontScheme.type, null);
        }

        public static STFontScheme newInstance(XmlOptions xmlOptions) {
            return (STFontScheme) XmlBeans.getContextTypeLoader().newInstance(STFontScheme.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFontScheme.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme newValue(Object obj) {
            return (STFontScheme) STFontScheme.type.newValue(obj);
        }

        public static STFontScheme parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(File file) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(file, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(file, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(InputStream inputStream) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(inputStream, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(inputStream, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(Reader reader) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(reader, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(reader, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(String str) throws XmlException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(str, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(str, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(URL url) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(url, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(url, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(Node node) throws XmlException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(node, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STFontScheme) XmlBeans.getContextTypeLoader().parse(node, STFontScheme.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
