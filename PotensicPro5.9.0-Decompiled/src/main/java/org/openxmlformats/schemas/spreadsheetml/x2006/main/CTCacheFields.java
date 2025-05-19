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
public interface CTCacheFields extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCacheFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcachefieldsf5fatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCacheFields newInstance() {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().newInstance(CTCacheFields.type, null);
        }

        public static CTCacheFields newInstance(XmlOptions xmlOptions) {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().newInstance(CTCacheFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCacheFields.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(File file) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(file, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(file, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(Reader reader) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(reader, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(reader, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(String str) throws XmlException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(str, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(str, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(URL url) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(url, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(url, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(Node node) throws XmlException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(node, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheFields) XmlBeans.getContextTypeLoader().parse(node, CTCacheFields.type, xmlOptions);
        }
    }

    CTCacheField addNewCacheField();

    CTCacheField getCacheFieldArray(int i);

    CTCacheField[] getCacheFieldArray();

    List<CTCacheField> getCacheFieldList();

    long getCount();

    CTCacheField insertNewCacheField(int i);

    boolean isSetCount();

    void removeCacheField(int i);

    void setCacheFieldArray(int i, CTCacheField cTCacheField);

    void setCacheFieldArray(CTCacheField[] cTCacheFieldArr);

    void setCount(long j);

    int sizeOfCacheFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
