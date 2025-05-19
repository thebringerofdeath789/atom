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
public interface CTExternalLink extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalLink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternallink966etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalLink newInstance() {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().newInstance(CTExternalLink.type, null);
        }

        public static CTExternalLink newInstance(XmlOptions xmlOptions) {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().newInstance(CTExternalLink.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalLink.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(File file) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(file, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(file, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(Reader reader) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(reader, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(reader, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(String str) throws XmlException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(str, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(str, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(URL url) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(url, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(url, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalLink.type, xmlOptions);
        }

        public static CTExternalLink parse(Node node) throws XmlException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(node, CTExternalLink.type, (XmlOptions) null);
        }

        public static CTExternalLink parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalLink) XmlBeans.getContextTypeLoader().parse(node, CTExternalLink.type, xmlOptions);
        }
    }

    CTDdeLink addNewDdeLink();

    CTExtensionList addNewExtLst();

    CTExternalBook addNewExternalBook();

    CTOleLink addNewOleLink();

    CTDdeLink getDdeLink();

    CTExtensionList getExtLst();

    CTExternalBook getExternalBook();

    CTOleLink getOleLink();

    boolean isSetDdeLink();

    boolean isSetExtLst();

    boolean isSetExternalBook();

    boolean isSetOleLink();

    void setDdeLink(CTDdeLink cTDdeLink);

    void setExtLst(CTExtensionList cTExtensionList);

    void setExternalBook(CTExternalBook cTExternalBook);

    void setOleLink(CTOleLink cTOleLink);

    void unsetDdeLink();

    void unsetExtLst();

    void unsetExternalBook();

    void unsetOleLink();
}
