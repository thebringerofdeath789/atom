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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPictureBase extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPictureBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpicturebase5f83type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureBase newInstance() {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().newInstance(CTPictureBase.type, null);
        }

        public static CTPictureBase newInstance(XmlOptions xmlOptions) {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().newInstance(CTPictureBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPictureBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(File file) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(file, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(file, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(Reader reader) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(reader, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(reader, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(String str) throws XmlException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(str, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(str, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(URL url) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(url, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(url, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(Node node) throws XmlException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(node, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureBase) XmlBeans.getContextTypeLoader().parse(node, CTPictureBase.type, xmlOptions);
        }
    }
}
