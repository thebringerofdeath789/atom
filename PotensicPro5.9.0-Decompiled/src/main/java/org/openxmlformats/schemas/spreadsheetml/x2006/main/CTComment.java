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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTComment extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTComment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcomment7bfetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTComment newInstance() {
            return (CTComment) XmlBeans.getContextTypeLoader().newInstance(CTComment.type, null);
        }

        public static CTComment newInstance(XmlOptions xmlOptions) {
            return (CTComment) XmlBeans.getContextTypeLoader().newInstance(CTComment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTComment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTComment.type, xmlOptions);
        }

        public static CTComment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTComment.type, xmlOptions);
        }

        public static CTComment parse(File file) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(file, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(file, CTComment.type, xmlOptions);
        }

        public static CTComment parse(InputStream inputStream) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(inputStream, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(inputStream, CTComment.type, xmlOptions);
        }

        public static CTComment parse(Reader reader) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(reader, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(reader, CTComment.type, xmlOptions);
        }

        public static CTComment parse(String str) throws XmlException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(str, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(str, CTComment.type, xmlOptions);
        }

        public static CTComment parse(URL url) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(url, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(url, CTComment.type, xmlOptions);
        }

        public static CTComment parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTComment.type, xmlOptions);
        }

        public static CTComment parse(Node node) throws XmlException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(node, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTComment) XmlBeans.getContextTypeLoader().parse(node, CTComment.type, xmlOptions);
        }
    }

    CTRst addNewText();

    long getAuthorId();

    String getGuid();

    String getRef();

    CTRst getText();

    boolean isSetGuid();

    void setAuthorId(long j);

    void setGuid(String str);

    void setRef(String str);

    void setText(CTRst cTRst);

    void unsetGuid();

    XmlUnsignedInt xgetAuthorId();

    STGuid xgetGuid();

    STRef xgetRef();

    void xsetAuthorId(XmlUnsignedInt xmlUnsignedInt);

    void xsetGuid(STGuid sTGuid);

    void xsetRef(STRef sTRef);
}
