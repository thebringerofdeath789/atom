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
public interface CTRPrDefault extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRPrDefault.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctrprdefault5ebbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRPrDefault newInstance() {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().newInstance(CTRPrDefault.type, null);
        }

        public static CTRPrDefault newInstance(XmlOptions xmlOptions) {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().newInstance(CTRPrDefault.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRPrDefault.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(File file) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(file, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(file, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(inputStream, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(inputStream, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(Reader reader) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(reader, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(reader, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(String str) throws XmlException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(str, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(str, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(URL url) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(url, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(url, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(Node node) throws XmlException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(node, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRPrDefault) XmlBeans.getContextTypeLoader().parse(node, CTRPrDefault.type, xmlOptions);
        }
    }

    CTRPr addNewRPr();

    CTRPr getRPr();

    boolean isSetRPr();

    void setRPr(CTRPr cTRPr);

    void unsetRPr();
}
