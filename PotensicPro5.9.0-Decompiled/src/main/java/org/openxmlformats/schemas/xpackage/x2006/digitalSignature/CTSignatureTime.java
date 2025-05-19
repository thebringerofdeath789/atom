package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSignatureTime extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSignatureTime.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctsignaturetime461dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSignatureTime newInstance() {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().newInstance(CTSignatureTime.type, null);
        }

        public static CTSignatureTime newInstance(XmlOptions xmlOptions) {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().newInstance(CTSignatureTime.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSignatureTime.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(File file) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(file, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(file, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(inputStream, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(inputStream, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(Reader reader) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(reader, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(reader, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(String str) throws XmlException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(str, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(str, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(URL url) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(url, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(url, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSignatureTime.type, xmlOptions);
        }

        public static CTSignatureTime parse(Node node) throws XmlException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(node, CTSignatureTime.type, (XmlOptions) null);
        }

        public static CTSignatureTime parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSignatureTime) XmlBeans.getContextTypeLoader().parse(node, CTSignatureTime.type, xmlOptions);
        }
    }

    String getFormat();

    String getValue();

    void setFormat(String str);

    void setValue(String str);

    STFormat xgetFormat();

    STValue xgetValue();

    void xsetFormat(STFormat sTFormat);

    void xsetValue(STValue sTValue);
}
