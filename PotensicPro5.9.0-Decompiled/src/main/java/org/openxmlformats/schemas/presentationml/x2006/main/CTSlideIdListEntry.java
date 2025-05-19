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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSlideIdListEntry extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslideidlistentry427dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideIdListEntry newInstance() {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().newInstance(CTSlideIdListEntry.type, null);
        }

        public static CTSlideIdListEntry newInstance(XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().newInstance(CTSlideIdListEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideIdListEntry.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(File file) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(file, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(file, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(Reader reader) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(reader, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(reader, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(String str) throws XmlException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(str, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(str, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(URL url) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(url, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(url, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(Node node) throws XmlException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(node, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideIdListEntry) XmlBeans.getContextTypeLoader().parse(node, CTSlideIdListEntry.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    long getId();

    String getId2();

    boolean isSetExtLst();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setId2(String str);

    void unsetExtLst();

    STSlideId xgetId();

    STRelationshipId xgetId2();

    void xsetId(STSlideId sTSlideId);

    void xsetId2(STRelationshipId sTRelationshipId);
}
