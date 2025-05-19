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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCommentAuthor extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCommentAuthor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcommentauthora405type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCommentAuthor newInstance() {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().newInstance(CTCommentAuthor.type, null);
        }

        public static CTCommentAuthor newInstance(XmlOptions xmlOptions) {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().newInstance(CTCommentAuthor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCommentAuthor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(File file) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(file, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(file, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(inputStream, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(inputStream, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(Reader reader) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(reader, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(reader, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(String str) throws XmlException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(str, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(str, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(URL url) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(url, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(url, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCommentAuthor.type, xmlOptions);
        }

        public static CTCommentAuthor parse(Node node) throws XmlException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(node, CTCommentAuthor.type, (XmlOptions) null);
        }

        public static CTCommentAuthor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentAuthor) XmlBeans.getContextTypeLoader().parse(node, CTCommentAuthor.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    long getClrIdx();

    CTExtensionList getExtLst();

    long getId();

    String getInitials();

    long getLastIdx();

    String getName();

    boolean isSetExtLst();

    void setClrIdx(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setInitials(String str);

    void setLastIdx(long j);

    void setName(String str);

    void unsetExtLst();

    XmlUnsignedInt xgetClrIdx();

    XmlUnsignedInt xgetId();

    STName xgetInitials();

    XmlUnsignedInt xgetLastIdx();

    STName xgetName();

    void xsetClrIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetInitials(STName sTName);

    void xsetLastIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STName sTName);
}
