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
public interface CTSlideMasterIdListEntry extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideMasterIdListEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslidemasteridlistentryae7ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMasterIdListEntry newInstance() {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().newInstance(CTSlideMasterIdListEntry.type, null);
        }

        public static CTSlideMasterIdListEntry newInstance(XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().newInstance(CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdListEntry.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(File file) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(file, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(file, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(Reader reader) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(String str) throws XmlException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(str, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(str, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(URL url) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(url, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(url, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(Node node) throws XmlException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(node, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterIdListEntry) XmlBeans.getContextTypeLoader().parse(node, CTSlideMasterIdListEntry.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    long getId();

    String getId2();

    boolean isSetExtLst();

    boolean isSetId();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setId2(String str);

    void unsetExtLst();

    void unsetId();

    STSlideMasterId xgetId();

    STRelationshipId xgetId2();

    void xsetId(STSlideMasterId sTSlideMasterId);

    void xsetId2(STRelationshipId sTRelationshipId);
}
