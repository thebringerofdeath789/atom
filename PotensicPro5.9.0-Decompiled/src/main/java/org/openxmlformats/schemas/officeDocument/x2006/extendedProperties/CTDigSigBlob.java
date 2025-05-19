package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTDigSigBlob extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDigSigBlob.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdigsigblob73c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDigSigBlob newInstance() {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().newInstance(CTDigSigBlob.type, null);
        }

        public static CTDigSigBlob newInstance(XmlOptions xmlOptions) {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().newInstance(CTDigSigBlob.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDigSigBlob.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(File file) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(file, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(file, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(inputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(inputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(Reader reader) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(reader, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(reader, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(String str) throws XmlException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(str, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(str, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(URL url) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(url, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(url, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(Node node) throws XmlException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(node, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDigSigBlob) XmlBeans.getContextTypeLoader().parse(node, CTDigSigBlob.type, xmlOptions);
        }
    }

    byte[] getBlob();

    void setBlob(byte[] bArr);

    XmlBase64Binary xgetBlob();

    void xsetBlob(XmlBase64Binary xmlBase64Binary);
}
