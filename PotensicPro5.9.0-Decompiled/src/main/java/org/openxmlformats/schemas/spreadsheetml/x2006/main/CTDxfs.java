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
public interface CTDxfs extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDxfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdxfsb26atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDxfs newInstance() {
            return (CTDxfs) XmlBeans.getContextTypeLoader().newInstance(CTDxfs.type, null);
        }

        public static CTDxfs newInstance(XmlOptions xmlOptions) {
            return (CTDxfs) XmlBeans.getContextTypeLoader().newInstance(CTDxfs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDxfs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(File file) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(file, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(file, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(inputStream, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(inputStream, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(Reader reader) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(reader, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(reader, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(String str) throws XmlException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(str, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(str, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(URL url) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(url, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(url, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(Node node) throws XmlException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(node, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDxfs) XmlBeans.getContextTypeLoader().parse(node, CTDxfs.type, xmlOptions);
        }
    }

    CTDxf addNewDxf();

    long getCount();

    CTDxf getDxfArray(int i);

    CTDxf[] getDxfArray();

    List<CTDxf> getDxfList();

    CTDxf insertNewDxf(int i);

    boolean isSetCount();

    void removeDxf(int i);

    void setCount(long j);

    void setDxfArray(int i, CTDxf cTDxf);

    void setDxfArray(CTDxf[] cTDxfArr);

    int sizeOfDxfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
