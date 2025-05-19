package schemasMicrosoftComVml;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STColorType extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STColorType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcolortype99c1type");

    public static final class Factory {
        private Factory() {
        }

        public static STColorType newInstance() {
            return (STColorType) XmlBeans.getContextTypeLoader().newInstance(STColorType.type, null);
        }

        public static STColorType newInstance(XmlOptions xmlOptions) {
            return (STColorType) XmlBeans.getContextTypeLoader().newInstance(STColorType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STColorType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STColorType.type, xmlOptions);
        }

        public static STColorType newValue(Object obj) {
            return (STColorType) STColorType.type.newValue(obj);
        }

        public static STColorType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STColorType.type, xmlOptions);
        }

        public static STColorType parse(File file) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(file, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(file, STColorType.type, xmlOptions);
        }

        public static STColorType parse(InputStream inputStream) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(inputStream, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(inputStream, STColorType.type, xmlOptions);
        }

        public static STColorType parse(Reader reader) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(reader, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(reader, STColorType.type, xmlOptions);
        }

        public static STColorType parse(String str) throws XmlException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(str, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(str, STColorType.type, xmlOptions);
        }

        public static STColorType parse(URL url) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(url, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(url, STColorType.type, xmlOptions);
        }

        public static STColorType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STColorType.type, xmlOptions);
        }

        public static STColorType parse(Node node) throws XmlException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(node, STColorType.type, (XmlOptions) null);
        }

        public static STColorType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STColorType) XmlBeans.getContextTypeLoader().parse(node, STColorType.type, xmlOptions);
        }
    }
}
