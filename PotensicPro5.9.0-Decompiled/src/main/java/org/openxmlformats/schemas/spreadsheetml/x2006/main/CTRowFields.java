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
public interface CTRowFields extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRowFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctrowfields0312type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRowFields newInstance() {
            return (CTRowFields) XmlBeans.getContextTypeLoader().newInstance(CTRowFields.type, null);
        }

        public static CTRowFields newInstance(XmlOptions xmlOptions) {
            return (CTRowFields) XmlBeans.getContextTypeLoader().newInstance(CTRowFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRowFields.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(File file) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(file, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(file, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(Reader reader) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(reader, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(reader, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(String str) throws XmlException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(str, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(str, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(URL url) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(url, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(url, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(Node node) throws XmlException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(node, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRowFields) XmlBeans.getContextTypeLoader().parse(node, CTRowFields.type, xmlOptions);
        }
    }

    CTField addNewField();

    long getCount();

    CTField getFieldArray(int i);

    CTField[] getFieldArray();

    List<CTField> getFieldList();

    CTField insertNewField(int i);

    boolean isSetCount();

    void removeField(int i);

    void setCount(long j);

    void setFieldArray(int i, CTField cTField);

    void setFieldArray(CTField[] cTFieldArr);

    int sizeOfFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
