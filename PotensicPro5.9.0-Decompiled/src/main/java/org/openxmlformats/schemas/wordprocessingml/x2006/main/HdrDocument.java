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
public interface HdrDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(HdrDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("hdra530doctype");

    public static final class Factory {
        private Factory() {
        }

        public static HdrDocument newInstance() {
            return (HdrDocument) XmlBeans.getContextTypeLoader().newInstance(HdrDocument.type, null);
        }

        public static HdrDocument newInstance(XmlOptions xmlOptions) {
            return (HdrDocument) XmlBeans.getContextTypeLoader().newInstance(HdrDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, HdrDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(File file) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(file, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(file, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(inputStream, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(inputStream, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(Reader reader) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(reader, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(reader, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(String str) throws XmlException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(str, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(str, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(URL url) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(url, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(url, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, HdrDocument.type, xmlOptions);
        }

        public static HdrDocument parse(Node node) throws XmlException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(node, HdrDocument.type, (XmlOptions) null);
        }

        public static HdrDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (HdrDocument) XmlBeans.getContextTypeLoader().parse(node, HdrDocument.type, xmlOptions);
        }
    }

    CTHdrFtr addNewHdr();

    CTHdrFtr getHdr();

    void setHdr(CTHdrFtr cTHdrFtr);
}
