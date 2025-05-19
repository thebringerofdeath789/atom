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
public interface CTTableColumns extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableColumns.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablecolumnsebb8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableColumns newInstance() {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().newInstance(CTTableColumns.type, null);
        }

        public static CTTableColumns newInstance(XmlOptions xmlOptions) {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().newInstance(CTTableColumns.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableColumns.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(File file) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(file, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(file, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(Reader reader) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(reader, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(reader, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(String str) throws XmlException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(str, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(str, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(URL url) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(url, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(url, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(Node node) throws XmlException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(node, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumns) XmlBeans.getContextTypeLoader().parse(node, CTTableColumns.type, xmlOptions);
        }
    }

    CTTableColumn addNewTableColumn();

    long getCount();

    CTTableColumn getTableColumnArray(int i);

    CTTableColumn[] getTableColumnArray();

    List<CTTableColumn> getTableColumnList();

    CTTableColumn insertNewTableColumn(int i);

    boolean isSetCount();

    void removeTableColumn(int i);

    void setCount(long j);

    void setTableColumnArray(int i, CTTableColumn cTTableColumn);

    void setTableColumnArray(CTTableColumn[] cTTableColumnArr);

    int sizeOfTableColumnArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
