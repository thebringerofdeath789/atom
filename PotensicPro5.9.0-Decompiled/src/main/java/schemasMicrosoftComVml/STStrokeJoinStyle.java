package schemasMicrosoftComVml;

import aavax.xml.stream.XMLStreamReader;
import com.mapbox.mapboxsdk.style.layers.Property;
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
public interface STStrokeJoinStyle extends XmlString {
    public static final int INT_BEVEL = 2;
    public static final int INT_MITER = 3;
    public static final int INT_ROUND = 1;
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STStrokeJoinStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ststrokejoinstyle3c13type");
    public static final Enum ROUND = Enum.forString("round");
    public static final Enum BEVEL = Enum.forString(Property.LINE_JOIN_BEVEL);
    public static final Enum MITER = Enum.forString(Property.LINE_JOIN_MITER);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BEVEL = 2;
        static final int INT_MITER = 3;
        static final int INT_ROUND = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("round", 1), new Enum(Property.LINE_JOIN_BEVEL, 2), new Enum(Property.LINE_JOIN_MITER, 3)});

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

        public static STStrokeJoinStyle newInstance() {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().newInstance(STStrokeJoinStyle.type, null);
        }

        public static STStrokeJoinStyle newInstance(XmlOptions xmlOptions) {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().newInstance(STStrokeJoinStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STStrokeJoinStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle newValue(Object obj) {
            return (STStrokeJoinStyle) STStrokeJoinStyle.type.newValue(obj);
        }

        public static STStrokeJoinStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(File file) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(file, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(file, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(inputStream, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(inputStream, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(Reader reader) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(reader, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(reader, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(String str) throws XmlException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(str, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(str, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(URL url) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(url, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(url, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(Node node) throws XmlException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(node, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STStrokeJoinStyle) XmlBeans.getContextTypeLoader().parse(node, STStrokeJoinStyle.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
