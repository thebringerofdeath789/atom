package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTTable extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTable.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttable5f3ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTable newInstance() {
            return (CTTable) XmlBeans.getContextTypeLoader().newInstance(CTTable.type, null);
        }

        public static CTTable newInstance(XmlOptions xmlOptions) {
            return (CTTable) XmlBeans.getContextTypeLoader().newInstance(CTTable.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTable.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTable.type, xmlOptions);
        }

        public static CTTable parse(File file) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(file, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(file, CTTable.type, xmlOptions);
        }

        public static CTTable parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(inputStream, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(inputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(Reader reader) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(reader, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(reader, CTTable.type, xmlOptions);
        }

        public static CTTable parse(String str) throws XmlException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(str, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(str, CTTable.type, xmlOptions);
        }

        public static CTTable parse(URL url) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(url, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(url, CTTable.type, xmlOptions);
        }

        public static CTTable parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(Node node) throws XmlException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(node, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTable) XmlBeans.getContextTypeLoader().parse(node, CTTable.type, xmlOptions);
        }
    }

    CTTableGrid addNewTblGrid();

    CTTableProperties addNewTblPr();

    CTTableRow addNewTr();

    CTTableGrid getTblGrid();

    CTTableProperties getTblPr();

    CTTableRow getTrArray(int i);

    CTTableRow[] getTrArray();

    List<CTTableRow> getTrList();

    CTTableRow insertNewTr(int i);

    boolean isSetTblPr();

    void removeTr(int i);

    void setTblGrid(CTTableGrid cTTableGrid);

    void setTblPr(CTTableProperties cTTableProperties);

    void setTrArray(int i, CTTableRow cTTableRow);

    void setTrArray(CTTableRow[] cTTableRowArr);

    int sizeOfTrArray();

    void unsetTblPr();
}
