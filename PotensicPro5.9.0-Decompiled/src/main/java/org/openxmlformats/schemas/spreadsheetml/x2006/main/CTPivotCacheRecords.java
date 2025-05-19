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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPivotCacheRecords extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPivotCacheRecords.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpivotcacherecords5be1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotCacheRecords newInstance() {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().newInstance(CTPivotCacheRecords.type, null);
        }

        public static CTPivotCacheRecords newInstance(XmlOptions xmlOptions) {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().newInstance(CTPivotCacheRecords.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCacheRecords.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(File file) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(file, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(file, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(inputStream, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(Reader reader) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(reader, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(String str) throws XmlException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(str, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(str, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(URL url) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(url, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(url, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(Node node) throws XmlException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(node, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheRecords) XmlBeans.getContextTypeLoader().parse(node, CTPivotCacheRecords.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTRecord addNewR();

    long getCount();

    CTExtensionList getExtLst();

    CTRecord getRArray(int i);

    CTRecord[] getRArray();

    List<CTRecord> getRList();

    CTRecord insertNewR(int i);

    boolean isSetCount();

    boolean isSetExtLst();

    void removeR(int i);

    void setCount(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setRArray(int i, CTRecord cTRecord);

    void setRArray(CTRecord[] cTRecordArr);

    int sizeOfRArray();

    void unsetCount();

    void unsetExtLst();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
