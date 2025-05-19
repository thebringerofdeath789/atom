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
public interface CTProofErr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTProofErr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctprooferr1e07type");

    public static final class Factory {
        private Factory() {
        }

        public static CTProofErr newInstance() {
            return (CTProofErr) XmlBeans.getContextTypeLoader().newInstance(CTProofErr.type, null);
        }

        public static CTProofErr newInstance(XmlOptions xmlOptions) {
            return (CTProofErr) XmlBeans.getContextTypeLoader().newInstance(CTProofErr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTProofErr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(File file) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(file, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(file, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(inputStream, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(inputStream, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(Reader reader) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(reader, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(reader, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(String str) throws XmlException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(str, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(str, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(URL url) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(url, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(url, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(Node node) throws XmlException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(node, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTProofErr) XmlBeans.getContextTypeLoader().parse(node, CTProofErr.type, xmlOptions);
        }
    }

    STProofErr$Enum getType();

    void setType(STProofErr$Enum sTProofErr$Enum);

    STProofErr xgetType();

    void xsetType(STProofErr sTProofErr);
}
