package org.openxmlformats.schemas.presentationml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCommentList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCommentList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcommentlistf692type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCommentList newInstance() {
            return (CTCommentList) XmlBeans.getContextTypeLoader().newInstance(CTCommentList.type, null);
        }

        public static CTCommentList newInstance(XmlOptions xmlOptions) {
            return (CTCommentList) XmlBeans.getContextTypeLoader().newInstance(CTCommentList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCommentList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(File file) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(file, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(file, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(inputStream, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(inputStream, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(Reader reader) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(reader, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(reader, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(String str) throws XmlException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(str, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(str, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(URL url) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(url, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(url, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(Node node) throws XmlException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(node, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentList) XmlBeans.getContextTypeLoader().parse(node, CTCommentList.type, xmlOptions);
        }
    }

    CTComment addNewCm();

    CTComment getCmArray(int i);

    CTComment[] getCmArray();

    List<CTComment> getCmList();

    CTComment insertNewCm(int i);

    void removeCm(int i);

    void setCmArray(int i, CTComment cTComment);

    void setCmArray(CTComment[] cTCommentArr);

    int sizeOfCmArray();
}
