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
public interface CTNumFmts extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNumFmts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnumfmtsb58btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumFmts newInstance() {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().newInstance(CTNumFmts.type, null);
        }

        public static CTNumFmts newInstance(XmlOptions xmlOptions) {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().newInstance(CTNumFmts.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumFmts.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(File file) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(file, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(file, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(Reader reader) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(reader, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(reader, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(String str) throws XmlException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(str, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(str, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(URL url) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(url, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(url, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumFmts.type, xmlOptions);
        }

        public static CTNumFmts parse(Node node) throws XmlException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(node, CTNumFmts.type, (XmlOptions) null);
        }

        public static CTNumFmts parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmts) XmlBeans.getContextTypeLoader().parse(node, CTNumFmts.type, xmlOptions);
        }
    }

    CTNumFmt addNewNumFmt();

    long getCount();

    CTNumFmt getNumFmtArray(int i);

    CTNumFmt[] getNumFmtArray();

    List<CTNumFmt> getNumFmtList();

    CTNumFmt insertNewNumFmt(int i);

    boolean isSetCount();

    void removeNumFmt(int i);

    void setCount(long j);

    void setNumFmtArray(int i, CTNumFmt cTNumFmt);

    void setNumFmtArray(CTNumFmt[] cTNumFmtArr);

    int sizeOfNumFmtArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
