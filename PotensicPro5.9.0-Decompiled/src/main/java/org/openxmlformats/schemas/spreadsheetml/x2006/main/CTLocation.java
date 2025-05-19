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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTLocation extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLocation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlocationc23etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLocation newInstance() {
            return (CTLocation) XmlBeans.getContextTypeLoader().newInstance(CTLocation.type, null);
        }

        public static CTLocation newInstance(XmlOptions xmlOptions) {
            return (CTLocation) XmlBeans.getContextTypeLoader().newInstance(CTLocation.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLocation.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(File file) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(file, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(file, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(inputStream, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(inputStream, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(Reader reader) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(reader, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(reader, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(String str) throws XmlException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(str, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(str, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(URL url) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(url, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(url, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLocation.type, xmlOptions);
        }

        public static CTLocation parse(Node node) throws XmlException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(node, CTLocation.type, (XmlOptions) null);
        }

        public static CTLocation parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLocation) XmlBeans.getContextTypeLoader().parse(node, CTLocation.type, xmlOptions);
        }
    }

    long getColPageCount();

    long getFirstDataCol();

    long getFirstDataRow();

    long getFirstHeaderRow();

    String getRef();

    long getRowPageCount();

    boolean isSetColPageCount();

    boolean isSetRowPageCount();

    void setColPageCount(long j);

    void setFirstDataCol(long j);

    void setFirstDataRow(long j);

    void setFirstHeaderRow(long j);

    void setRef(String str);

    void setRowPageCount(long j);

    void unsetColPageCount();

    void unsetRowPageCount();

    XmlUnsignedInt xgetColPageCount();

    XmlUnsignedInt xgetFirstDataCol();

    XmlUnsignedInt xgetFirstDataRow();

    XmlUnsignedInt xgetFirstHeaderRow();

    STRef xgetRef();

    XmlUnsignedInt xgetRowPageCount();

    void xsetColPageCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetFirstDataCol(XmlUnsignedInt xmlUnsignedInt);

    void xsetFirstDataRow(XmlUnsignedInt xmlUnsignedInt);

    void xsetFirstHeaderRow(XmlUnsignedInt xmlUnsignedInt);

    void xsetRef(STRef sTRef);

    void xsetRowPageCount(XmlUnsignedInt xmlUnsignedInt);
}
