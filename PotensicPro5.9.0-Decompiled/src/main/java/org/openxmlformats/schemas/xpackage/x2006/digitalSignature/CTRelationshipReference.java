package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTRelationshipReference extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRelationshipReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctrelationshipreferencee68ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelationshipReference newInstance() {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().newInstance(CTRelationshipReference.type, null);
        }

        public static CTRelationshipReference newInstance(XmlOptions xmlOptions) {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().newInstance(CTRelationshipReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelationshipReference.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(File file) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(file, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(file, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(Reader reader) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(reader, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(reader, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(String str) throws XmlException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(str, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(str, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(URL url) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(url, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(url, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(Node node) throws XmlException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(node, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationshipReference) XmlBeans.getContextTypeLoader().parse(node, CTRelationshipReference.type, xmlOptions);
        }
    }

    String getSourceId();

    void setSourceId(String str);

    XmlString xgetSourceId();

    void xsetSourceId(XmlString xmlString);
}
