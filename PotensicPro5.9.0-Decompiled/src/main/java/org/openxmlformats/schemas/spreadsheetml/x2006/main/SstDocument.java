package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface SstDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(SstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sstf81fdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SstDocument newInstance() {
            return (SstDocument) XmlBeans.getContextTypeLoader().newInstance(SstDocument.type, null);
        }

        public static SstDocument newInstance(XmlOptions xmlOptions) {
            return (SstDocument) XmlBeans.getContextTypeLoader().newInstance(SstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SstDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(File file) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(file, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(file, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(Reader reader) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(reader, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(reader, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(String str) throws XmlException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(str, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(str, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(URL url) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(url, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(url, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(Node node) throws XmlException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(node, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SstDocument) XmlBeans.getContextTypeLoader().parse(node, SstDocument.type, xmlOptions);
        }
    }

    CTSst addNewSst();

    CTSst getSst();

    void setSst(CTSst cTSst);
}
