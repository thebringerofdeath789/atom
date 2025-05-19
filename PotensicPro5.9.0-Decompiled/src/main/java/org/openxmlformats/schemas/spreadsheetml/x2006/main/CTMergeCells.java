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
public interface CTMergeCells extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMergeCells.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmergecells1242type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMergeCells newInstance() {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().newInstance(CTMergeCells.type, null);
        }

        public static CTMergeCells newInstance(XmlOptions xmlOptions) {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().newInstance(CTMergeCells.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMergeCells.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(File file) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(file, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(file, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(inputStream, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(inputStream, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(Reader reader) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(reader, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(reader, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(String str) throws XmlException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(str, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(str, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(URL url) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(url, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(url, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMergeCells.type, xmlOptions);
        }

        public static CTMergeCells parse(Node node) throws XmlException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(node, CTMergeCells.type, (XmlOptions) null);
        }

        public static CTMergeCells parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMergeCells) XmlBeans.getContextTypeLoader().parse(node, CTMergeCells.type, xmlOptions);
        }
    }

    CTMergeCell addNewMergeCell();

    long getCount();

    CTMergeCell getMergeCellArray(int i);

    CTMergeCell[] getMergeCellArray();

    List<CTMergeCell> getMergeCellList();

    CTMergeCell insertNewMergeCell(int i);

    boolean isSetCount();

    void removeMergeCell(int i);

    void setCount(long j);

    void setMergeCellArray(int i, CTMergeCell cTMergeCell);

    void setMergeCellArray(CTMergeCell[] cTMergeCellArr);

    int sizeOfMergeCellArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
