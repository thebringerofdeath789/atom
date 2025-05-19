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
public interface CalcChainDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CalcChainDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("calcchainfc37doctype");

    public static final class Factory {
        private Factory() {
        }

        public static CalcChainDocument newInstance() {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().newInstance(CalcChainDocument.type, null);
        }

        public static CalcChainDocument newInstance(XmlOptions xmlOptions) {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().newInstance(CalcChainDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CalcChainDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(File file) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(file, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(file, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(inputStream, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(inputStream, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(Reader reader) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(reader, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(reader, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(String str) throws XmlException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(str, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(str, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(URL url) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(url, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(url, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CalcChainDocument.type, xmlOptions);
        }

        public static CalcChainDocument parse(Node node) throws XmlException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(node, CalcChainDocument.type, (XmlOptions) null);
        }

        public static CalcChainDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CalcChainDocument) XmlBeans.getContextTypeLoader().parse(node, CalcChainDocument.type, xmlOptions);
        }
    }

    CTCalcChain addNewCalcChain();

    CTCalcChain getCalcChain();

    void setCalcChain(CTCalcChain cTCalcChain);
}
