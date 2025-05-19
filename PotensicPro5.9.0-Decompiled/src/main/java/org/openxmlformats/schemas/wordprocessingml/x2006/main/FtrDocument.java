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
public interface FtrDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(FtrDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ftre182doctype");

    public static final class Factory {
        private Factory() {
        }

        public static FtrDocument newInstance() {
            return (FtrDocument) XmlBeans.getContextTypeLoader().newInstance(FtrDocument.type, null);
        }

        public static FtrDocument newInstance(XmlOptions xmlOptions) {
            return (FtrDocument) XmlBeans.getContextTypeLoader().newInstance(FtrDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FtrDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(File file) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(file, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(file, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(Reader reader) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(reader, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(reader, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(String str) throws XmlException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(str, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(str, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(URL url) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(url, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(url, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(Node node) throws XmlException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(node, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FtrDocument) XmlBeans.getContextTypeLoader().parse(node, FtrDocument.type, xmlOptions);
        }
    }

    CTHdrFtr addNewFtr();

    CTHdrFtr getFtr();

    void setFtr(CTHdrFtr cTHdrFtr);
}
