package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTOnOff extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTOnOff.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctonoff04c2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOnOff newInstance() {
            return (CTOnOff) XmlBeans.getContextTypeLoader().newInstance(CTOnOff.type, null);
        }

        public static CTOnOff newInstance(XmlOptions xmlOptions) {
            return (CTOnOff) XmlBeans.getContextTypeLoader().newInstance(CTOnOff.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOnOff.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(File file) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(file, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(file, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(inputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(inputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(Reader reader) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(reader, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(reader, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(String str) throws XmlException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(str, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(str, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(URL url) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(url, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(url, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(Node node) throws XmlException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(node, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOnOff) XmlBeans.getContextTypeLoader().parse(node, CTOnOff.type, xmlOptions);
        }
    }

    STOnOff.Enum getVal();

    boolean isSetVal();

    void setVal(STOnOff.Enum r1);

    void unsetVal();

    STOnOff xgetVal();

    void xsetVal(STOnOff sTOnOff);
}
