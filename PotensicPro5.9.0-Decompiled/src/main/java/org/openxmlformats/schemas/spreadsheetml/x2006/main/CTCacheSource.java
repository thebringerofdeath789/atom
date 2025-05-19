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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCacheSource extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCacheSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcachesource00dctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCacheSource newInstance() {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().newInstance(CTCacheSource.type, null);
        }

        public static CTCacheSource newInstance(XmlOptions xmlOptions) {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().newInstance(CTCacheSource.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCacheSource.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(File file) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(file, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(file, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(Reader reader) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(reader, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(reader, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(String str) throws XmlException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(str, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(str, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(URL url) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(url, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(url, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCacheSource.type, xmlOptions);
        }

        public static CTCacheSource parse(Node node) throws XmlException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(node, CTCacheSource.type, (XmlOptions) null);
        }

        public static CTCacheSource parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheSource) XmlBeans.getContextTypeLoader().parse(node, CTCacheSource.type, xmlOptions);
        }
    }

    CTConsolidation addNewConsolidation();

    CTExtensionList addNewExtLst();

    CTWorksheetSource addNewWorksheetSource();

    long getConnectionId();

    CTConsolidation getConsolidation();

    CTExtensionList getExtLst();

    STSourceType.Enum getType();

    CTWorksheetSource getWorksheetSource();

    boolean isSetConnectionId();

    boolean isSetConsolidation();

    boolean isSetExtLst();

    boolean isSetWorksheetSource();

    void setConnectionId(long j);

    void setConsolidation(CTConsolidation cTConsolidation);

    void setExtLst(CTExtensionList cTExtensionList);

    void setType(STSourceType.Enum r1);

    void setWorksheetSource(CTWorksheetSource cTWorksheetSource);

    void unsetConnectionId();

    void unsetConsolidation();

    void unsetExtLst();

    void unsetWorksheetSource();

    XmlUnsignedInt xgetConnectionId();

    STSourceType xgetType();

    void xsetConnectionId(XmlUnsignedInt xmlUnsignedInt);

    void xsetType(STSourceType sTSourceType);
}
