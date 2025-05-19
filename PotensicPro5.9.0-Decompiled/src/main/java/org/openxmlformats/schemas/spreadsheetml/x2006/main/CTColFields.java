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
public interface CTColFields extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTColFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcolfields9ab8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColFields newInstance() {
            return (CTColFields) XmlBeans.getContextTypeLoader().newInstance(CTColFields.type, null);
        }

        public static CTColFields newInstance(XmlOptions xmlOptions) {
            return (CTColFields) XmlBeans.getContextTypeLoader().newInstance(CTColFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColFields.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(File file) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(file, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(file, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(inputStream, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(Reader reader) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(reader, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(reader, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(String str) throws XmlException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(str, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(str, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(URL url) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(url, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(url, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColFields.type, xmlOptions);
        }

        public static CTColFields parse(Node node) throws XmlException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(node, CTColFields.type, (XmlOptions) null);
        }

        public static CTColFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColFields) XmlBeans.getContextTypeLoader().parse(node, CTColFields.type, xmlOptions);
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
