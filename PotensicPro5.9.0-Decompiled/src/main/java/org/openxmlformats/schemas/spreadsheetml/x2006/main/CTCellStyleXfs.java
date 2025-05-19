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
public interface CTCellStyleXfs extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCellStyleXfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcellstylexfsa81ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellStyleXfs newInstance() {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().newInstance(CTCellStyleXfs.type, null);
        }

        public static CTCellStyleXfs newInstance(XmlOptions xmlOptions) {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().newInstance(CTCellStyleXfs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCellStyleXfs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(File file) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(file, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(file, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(inputStream, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(inputStream, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(Reader reader) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(reader, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(reader, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(String str) throws XmlException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(str, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(str, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(URL url) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(url, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(url, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCellStyleXfs.type, xmlOptions);
        }

        public static CTCellStyleXfs parse(Node node) throws XmlException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(node, CTCellStyleXfs.type, (XmlOptions) null);
        }

        public static CTCellStyleXfs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCellStyleXfs) XmlBeans.getContextTypeLoader().parse(node, CTCellStyleXfs.type, xmlOptions);
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
