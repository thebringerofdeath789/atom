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
public interface CTCellXfs extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCellXfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcellxfs1322type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellXfs newInstance() {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().newInstance(CTCellXfs.type, null);
        }

        public static CTCellXfs newInstance(XmlOptions xmlOptions) {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().newInstance(CTCellXfs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCellXfs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(File file) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(file, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(file, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(inputStream, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(inputStream, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(Reader reader) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(reader, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(reader, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(String str) throws XmlException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(str, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(str, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(URL url) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(url, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(url, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(Node node) throws XmlException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(node, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCellXfs) XmlBeans.getContextTypeLoader().parse(node, CTCellXfs.type, xmlOptions);
        }
    }

    CTXf addNewXf();

    long getCount();

    CTXf getXfArray(int i);

    CTXf[] getXfArray();

    List<CTXf> getXfList();

    CTXf insertNewXf(int i);

    boolean isSetCount();

    void removeXf(int i);

    void setCount(long j);

    void setXfArray(int i, CTXf cTXf);

    void setXfArray(CTXf[] cTXfArr);

    int sizeOfXfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
