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
public interface CTSingleXmlCells extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSingleXmlCells.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsinglexmlcells5a6btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSingleXmlCells newInstance() {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().newInstance(CTSingleXmlCells.type, null);
        }

        public static CTSingleXmlCells newInstance(XmlOptions xmlOptions) {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().newInstance(CTSingleXmlCells.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCells.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(File file) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(file, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(file, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(inputStream, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(inputStream, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(Reader reader) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(reader, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(reader, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(String str) throws XmlException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(str, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(str, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(URL url) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(url, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(url, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(Node node) throws XmlException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(node, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCells) XmlBeans.getContextTypeLoader().parse(node, CTSingleXmlCells.type, xmlOptions);
        }
    }

    CTSingleXmlCell addNewSingleXmlCell();

    CTSingleXmlCell getSingleXmlCellArray(int i);

    CTSingleXmlCell[] getSingleXmlCellArray();

    List<CTSingleXmlCell> getSingleXmlCellList();

    CTSingleXmlCell insertNewSingleXmlCell(int i);

    void removeSingleXmlCell(int i);

    void setSingleXmlCellArray(int i, CTSingleXmlCell cTSingleXmlCell);

    void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr);

    int sizeOfSingleXmlCellArray();
}
