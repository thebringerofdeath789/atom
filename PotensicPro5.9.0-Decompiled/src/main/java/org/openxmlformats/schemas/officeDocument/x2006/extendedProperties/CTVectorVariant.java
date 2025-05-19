package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTVectorVariant extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTVectorVariant.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctvectorvariant9d75type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVectorVariant newInstance() {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().newInstance(CTVectorVariant.type, null);
        }

        public static CTVectorVariant newInstance(XmlOptions xmlOptions) {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().newInstance(CTVectorVariant.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVectorVariant.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(File file) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(file, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(file, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(inputStream, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(inputStream, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(Reader reader) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(reader, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(reader, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(String str) throws XmlException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(str, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(str, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(URL url) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(url, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(url, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(Node node) throws XmlException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(node, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorVariant) XmlBeans.getContextTypeLoader().parse(node, CTVectorVariant.type, xmlOptions);
        }
    }

    CTVector addNewVector();

    CTVector getVector();

    void setVector(CTVector cTVector);
}
