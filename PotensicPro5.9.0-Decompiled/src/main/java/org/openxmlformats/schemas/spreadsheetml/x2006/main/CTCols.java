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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCols extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCols.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcols627ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCols newInstance() {
            return (CTCols) XmlBeans.getContextTypeLoader().newInstance(CTCols.type, null);
        }

        public static CTCols newInstance(XmlOptions xmlOptions) {
            return (CTCols) XmlBeans.getContextTypeLoader().newInstance(CTCols.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCols.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCols.type, xmlOptions);
        }

        public static CTCols parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCols.type, xmlOptions);
        }

        public static CTCols parse(File file) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(file, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(file, CTCols.type, xmlOptions);
        }

        public static CTCols parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(inputStream, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(inputStream, CTCols.type, xmlOptions);
        }

        public static CTCols parse(Reader reader) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(reader, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(reader, CTCols.type, xmlOptions);
        }

        public static CTCols parse(String str) throws XmlException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(str, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(str, CTCols.type, xmlOptions);
        }

        public static CTCols parse(URL url) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(url, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(url, CTCols.type, xmlOptions);
        }

        public static CTCols parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCols.type, xmlOptions);
        }

        public static CTCols parse(Node node) throws XmlException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(node, CTCols.type, (XmlOptions) null);
        }

        public static CTCols parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCols) XmlBeans.getContextTypeLoader().parse(node, CTCols.type, xmlOptions);
        }
    }

    CTCol addNewCol();

    CTCol getColArray(int i);

    CTCol[] getColArray();

    List<CTCol> getColList();

    CTCol insertNewCol(int i);

    void removeCol(int i);

    void setColArray(int i, CTCol cTCol);

    void setColArray(CTCol[] cTColArr);

    int sizeOfColArray();
}
