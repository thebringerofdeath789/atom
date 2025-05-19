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
public interface CTNotesMasterIdListEntry extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNotesMasterIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnotesmasteridlistentry278ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNotesMasterIdListEntry newInstance() {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().newInstance(CTNotesMasterIdListEntry.type, null);
        }

        public static CTNotesMasterIdListEntry newInstance(XmlOptions xmlOptions) {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().newInstance(CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNotesMasterIdListEntry.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(File file) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(file, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(file, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(inputStream, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(inputStream, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(Reader reader) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(reader, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(reader, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(String str) throws XmlException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(str, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(str, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(URL url) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(url, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(url, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNotesMasterIdListEntry.type, xmlOptions);
        }

        public static CTNotesMasterIdListEntry parse(Node node) throws XmlException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(node, CTNotesMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTNotesMasterIdListEntry parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(node, CTNotesMasterIdListEntry.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    String getId();

    boolean isSetExtLst();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(String str);

    void unsetExtLst();

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
