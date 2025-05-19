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
public interface CTSdtDocPart extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSdtDocPart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsdtdocpartcea0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtDocPart newInstance() {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().newInstance(CTSdtDocPart.type, null);
        }

        public static CTSdtDocPart newInstance(XmlOptions xmlOptions) {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().newInstance(CTSdtDocPart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtDocPart.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(File file) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(file, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(file, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(inputStream, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(Reader reader) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(reader, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(reader, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(String str) throws XmlException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(str, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(str, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(URL url) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(url, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(url, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSdtDocPart.type, xmlOptions);
        }

        public static CTSdtDocPart parse(Node node) throws XmlException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(node, CTSdtDocPart.type, (XmlOptions) null);
        }

        public static CTSdtDocPart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtDocPart) XmlBeans.getContextTypeLoader().parse(node, CTSdtDocPart.type, xmlOptions);
        }
    }

    CTString addNewDocPartCategory();

    CTString addNewDocPartGallery();

    CTOnOff addNewDocPartUnique();

    CTString getDocPartCategory();

    CTString getDocPartGallery();

    CTOnOff getDocPartUnique();

    boolean isSetDocPartCategory();

    boolean isSetDocPartGallery();

    boolean isSetDocPartUnique();

    void setDocPartCategory(CTString cTString);

    void setDocPartGallery(CTString cTString);

    void setDocPartUnique(CTOnOff cTOnOff);

    void unsetDocPartCategory();

    void unsetDocPartGallery();

    void unsetDocPartUnique();
}
