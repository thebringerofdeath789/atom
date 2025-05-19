package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTExternalReferences extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalReferences.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternalreferencesd77ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalReferences newInstance() {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().newInstance(CTExternalReferences.type, null);
        }

        public static CTExternalReferences newInstance(XmlOptions xmlOptions) {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().newInstance(CTExternalReferences.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalReferences.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(File file) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(file, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(file, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(Reader reader) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(reader, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(reader, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(String str) throws XmlException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(str, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(str, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(URL url) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(url, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(url, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalReferences.type, xmlOptions);
        }

        public static CTExternalReferences parse(Node node) throws XmlException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(node, CTExternalReferences.type, (XmlOptions) null);
        }

        public static CTExternalReferences parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalReferences) XmlBeans.getContextTypeLoader().parse(node, CTExternalReferences.type, xmlOptions);
        }
    }

    CTExternalReference addNewExternalReference();

    CTExternalReference getExternalReferenceArray(int i);

    CTExternalReference[] getExternalReferenceArray();

    List<CTExternalReference> getExternalReferenceList();

    CTExternalReference insertNewExternalReference(int i);

    void removeExternalReference(int i);

    void setExternalReferenceArray(int i, CTExternalReference cTExternalReference);

    void setExternalReferenceArray(CTExternalReference[] cTExternalReferenceArr);

    int sizeOfExternalReferenceArray();
}
