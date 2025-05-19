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
public interface CmAuthorLstDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CmAuthorLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cmauthorlst86abdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static CmAuthorLstDocument newInstance() {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().newInstance(CmAuthorLstDocument.type, null);
        }

        public static CmAuthorLstDocument newInstance(XmlOptions xmlOptions) {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().newInstance(CmAuthorLstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CmAuthorLstDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(File file) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(file, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(file, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(inputStream, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(inputStream, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(Reader reader) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(reader, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(reader, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(String str) throws XmlException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(str, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(str, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(URL url) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(url, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(url, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(Node node) throws XmlException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(node, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CmAuthorLstDocument) XmlBeans.getContextTypeLoader().parse(node, CmAuthorLstDocument.type, xmlOptions);
        }
    }

    CTCommentAuthorList addNewCmAuthorLst();

    CTCommentAuthorList getCmAuthorLst();

    void setCmAuthorLst(CTCommentAuthorList cTCommentAuthorList);
}
