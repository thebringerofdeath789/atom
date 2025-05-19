package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CmLstDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CmLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cmlst3880doctype");

    public static final class Factory {
        private Factory() {
        }

        public static CmLstDocument newInstance() {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().newInstance(CmLstDocument.type, null);
        }

        public static CmLstDocument newInstance(XmlOptions xmlOptions) {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().newInstance(CmLstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CmLstDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(File file) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(file, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(file, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(inputStream, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(inputStream, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(Reader reader) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(reader, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(reader, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(String str) throws XmlException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(str, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(str, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(URL url) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(url, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(url, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(Node node) throws XmlException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(node, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CmLstDocument) XmlBeans.getContextTypeLoader().parse(node, CmLstDocument.type, xmlOptions);
        }
    }

    CTCommentList addNewCmLst();

    CTCommentList getCmLst();

    void setCmLst(CTCommentList cTCommentList);
}
