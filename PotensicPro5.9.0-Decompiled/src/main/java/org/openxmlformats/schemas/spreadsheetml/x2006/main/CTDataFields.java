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
public interface CTDataFields extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDataFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdatafields52cctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataFields newInstance() {
            return (CTDataFields) XmlBeans.getContextTypeLoader().newInstance(CTDataFields.type, null);
        }

        public static CTDataFields newInstance(XmlOptions xmlOptions) {
            return (CTDataFields) XmlBeans.getContextTypeLoader().newInstance(CTDataFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataFields.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(File file) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(file, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(file, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(Reader reader) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(reader, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(reader, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(String str) throws XmlException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(str, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(str, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(URL url) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(url, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(url, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(Node node) throws XmlException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(node, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataFields) XmlBeans.getContextTypeLoader().parse(node, CTDataFields.type, xmlOptions);
        }
    }

    CTDataField addNewDataField();

    long getCount();

    CTDataField getDataFieldArray(int i);

    CTDataField[] getDataFieldArray();

    List<CTDataField> getDataFieldList();

    CTDataField insertNewDataField(int i);

    boolean isSetCount();

    void removeDataField(int i);

    void setCount(long j);

    void setDataFieldArray(int i, CTDataField cTDataField);

    void setDataFieldArray(CTDataField[] cTDataFieldArr);

    int sizeOfDataFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
