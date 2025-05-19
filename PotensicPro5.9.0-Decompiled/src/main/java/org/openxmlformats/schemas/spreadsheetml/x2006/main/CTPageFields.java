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
public interface CTPageFields extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagefields1db1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageFields newInstance() {
            return (CTPageFields) XmlBeans.getContextTypeLoader().newInstance(CTPageFields.type, null);
        }

        public static CTPageFields newInstance(XmlOptions xmlOptions) {
            return (CTPageFields) XmlBeans.getContextTypeLoader().newInstance(CTPageFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageFields.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(File file) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(file, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(file, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(Reader reader) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(reader, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(reader, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(String str) throws XmlException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(str, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(str, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(URL url) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(url, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(url, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(Node node) throws XmlException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(node, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageFields) XmlBeans.getContextTypeLoader().parse(node, CTPageFields.type, xmlOptions);
        }
    }

    CTPageField addNewPageField();

    long getCount();

    CTPageField getPageFieldArray(int i);

    CTPageField[] getPageFieldArray();

    List<CTPageField> getPageFieldList();

    CTPageField insertNewPageField(int i);

    boolean isSetCount();

    void removePageField(int i);

    void setCount(long j);

    void setPageFieldArray(int i, CTPageField cTPageField);

    void setPageFieldArray(CTPageField[] cTPageFieldArr);

    int sizeOfPageFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
