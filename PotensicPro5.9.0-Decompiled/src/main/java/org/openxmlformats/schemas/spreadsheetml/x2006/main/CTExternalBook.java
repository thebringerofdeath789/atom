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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTExternalBook extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalBook.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternalbookc89dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalBook newInstance() {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().newInstance(CTExternalBook.type, null);
        }

        public static CTExternalBook newInstance(XmlOptions xmlOptions) {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().newInstance(CTExternalBook.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalBook.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(File file) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(file, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(file, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(Reader reader) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(reader, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(reader, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(String str) throws XmlException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(str, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(str, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(URL url) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(url, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(url, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalBook.type, xmlOptions);
        }

        public static CTExternalBook parse(Node node) throws XmlException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(node, CTExternalBook.type, (XmlOptions) null);
        }

        public static CTExternalBook parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalBook) XmlBeans.getContextTypeLoader().parse(node, CTExternalBook.type, xmlOptions);
        }
    }

    CTExternalDefinedNames addNewDefinedNames();

    CTExternalSheetDataSet addNewSheetDataSet();

    CTExternalSheetNames addNewSheetNames();

    CTExternalDefinedNames getDefinedNames();

    String getId();

    CTExternalSheetDataSet getSheetDataSet();

    CTExternalSheetNames getSheetNames();

    boolean isSetDefinedNames();

    boolean isSetSheetDataSet();

    boolean isSetSheetNames();

    void setDefinedNames(CTExternalDefinedNames cTExternalDefinedNames);

    void setId(String str);

    void setSheetDataSet(CTExternalSheetDataSet cTExternalSheetDataSet);

    void setSheetNames(CTExternalSheetNames cTExternalSheetNames);

    void unsetDefinedNames();

    void unsetSheetDataSet();

    void unsetSheetNames();

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
