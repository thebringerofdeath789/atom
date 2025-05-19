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
public interface CTComments extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTComments.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcommentse3bdtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTComments newInstance() {
            return (CTComments) XmlBeans.getContextTypeLoader().newInstance(CTComments.type, null);
        }

        public static CTComments newInstance(XmlOptions xmlOptions) {
            return (CTComments) XmlBeans.getContextTypeLoader().newInstance(CTComments.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTComments.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTComments.type, xmlOptions);
        }

        public static CTComments parse(File file) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(file, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(file, CTComments.type, xmlOptions);
        }

        public static CTComments parse(InputStream inputStream) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(inputStream, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(inputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(Reader reader) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(reader, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(reader, CTComments.type, xmlOptions);
        }

        public static CTComments parse(String str) throws XmlException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(str, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(str, CTComments.type, xmlOptions);
        }

        public static CTComments parse(URL url) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(url, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(url, CTComments.type, xmlOptions);
        }

        public static CTComments parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(Node node) throws XmlException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(node, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTComments) XmlBeans.getContextTypeLoader().parse(node, CTComments.type, xmlOptions);
        }
    }

    CTAuthors addNewAuthors();

    CTCommentList addNewCommentList();

    CTExtensionList addNewExtLst();

    CTAuthors getAuthors();

    CTCommentList getCommentList();

    CTExtensionList getExtLst();

    boolean isSetExtLst();

    void setAuthors(CTAuthors cTAuthors);

    void setCommentList(CTCommentList cTCommentList);

    void setExtLst(CTExtensionList cTExtensionList);

    void unsetExtLst();
}
