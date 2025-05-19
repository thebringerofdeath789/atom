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
public interface CTTableParts extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableParts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablepartsf6bbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableParts newInstance() {
            return (CTTableParts) XmlBeans.getContextTypeLoader().newInstance(CTTableParts.type, null);
        }

        public static CTTableParts newInstance(XmlOptions xmlOptions) {
            return (CTTableParts) XmlBeans.getContextTypeLoader().newInstance(CTTableParts.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableParts.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(File file) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(file, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(file, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(Reader reader) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(reader, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(reader, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(String str) throws XmlException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(str, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(str, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(URL url) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(url, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(url, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableParts.type, xmlOptions);
        }

        public static CTTableParts parse(Node node) throws XmlException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(node, CTTableParts.type, (XmlOptions) null);
        }

        public static CTTableParts parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableParts) XmlBeans.getContextTypeLoader().parse(node, CTTableParts.type, xmlOptions);
        }
    }

    CTTablePart addNewTablePart();

    long getCount();

    CTTablePart getTablePartArray(int i);

    CTTablePart[] getTablePartArray();

    List<CTTablePart> getTablePartList();

    CTTablePart insertNewTablePart(int i);

    boolean isSetCount();

    void removeTablePart(int i);

    void setCount(long j);

    void setTablePartArray(int i, CTTablePart cTTablePart);

    void setTablePartArray(CTTablePart[] cTTablePartArr);

    int sizeOfTablePartArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
