package schemasMicrosoftComOfficeOffice;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;
import schemasMicrosoftComVml.STExt;

/* loaded from: classes6.dex */
public interface CTIdMap extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTIdMap.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctidmap63fatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTIdMap newInstance() {
            return (CTIdMap) XmlBeans.getContextTypeLoader().newInstance(CTIdMap.type, null);
        }

        public static CTIdMap newInstance(XmlOptions xmlOptions) {
            return (CTIdMap) XmlBeans.getContextTypeLoader().newInstance(CTIdMap.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTIdMap.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(File file) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(file, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(file, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(inputStream, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(inputStream, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(Reader reader) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(reader, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(reader, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(String str) throws XmlException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(str, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(str, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(URL url) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(url, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(url, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTIdMap.type, xmlOptions);
        }

        public static CTIdMap parse(Node node) throws XmlException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(node, CTIdMap.type, (XmlOptions) null);
        }

        public static CTIdMap parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIdMap) XmlBeans.getContextTypeLoader().parse(node, CTIdMap.type, xmlOptions);
        }
    }

    String getData();

    STExt.Enum getExt();

    boolean isSetData();

    boolean isSetExt();

    void setData(String str);

    void setExt(STExt.Enum r1);

    void unsetData();

    void unsetExt();

    XmlString xgetData();

    STExt xgetExt();

    void xsetData(XmlString xmlString);

    void xsetExt(STExt sTExt);
}
