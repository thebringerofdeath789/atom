package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTableCell extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablecell3ac1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableCell newInstance() {
            return (CTTableCell) XmlBeans.getContextTypeLoader().newInstance(CTTableCell.type, null);
        }

        public static CTTableCell newInstance(XmlOptions xmlOptions) {
            return (CTTableCell) XmlBeans.getContextTypeLoader().newInstance(CTTableCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableCell.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(File file) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(file, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(file, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(Reader reader) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(reader, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(reader, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(String str) throws XmlException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(str, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(str, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(URL url) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(url, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(url, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableCell.type, xmlOptions);
        }

        public static CTTableCell parse(Node node) throws XmlException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(node, CTTableCell.type, (XmlOptions) null);
        }

        public static CTTableCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCell) XmlBeans.getContextTypeLoader().parse(node, CTTableCell.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTTableCellProperties addNewTcPr();

    CTTextBody addNewTxBody();

    CTOfficeArtExtensionList getExtLst();

    int getGridSpan();

    boolean getHMerge();

    int getRowSpan();

    CTTableCellProperties getTcPr();

    CTTextBody getTxBody();

    boolean getVMerge();

    boolean isSetExtLst();

    boolean isSetGridSpan();

    boolean isSetHMerge();

    boolean isSetRowSpan();

    boolean isSetTcPr();

    boolean isSetTxBody();

    boolean isSetVMerge();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGridSpan(int i);

    void setHMerge(boolean z);

    void setRowSpan(int i);

    void setTcPr(CTTableCellProperties cTTableCellProperties);

    void setTxBody(CTTextBody cTTextBody);

    void setVMerge(boolean z);

    void unsetExtLst();

    void unsetGridSpan();

    void unsetHMerge();

    void unsetRowSpan();

    void unsetTcPr();

    void unsetTxBody();

    void unsetVMerge();

    XmlInt xgetGridSpan();

    XmlBoolean xgetHMerge();

    XmlInt xgetRowSpan();

    XmlBoolean xgetVMerge();

    void xsetGridSpan(XmlInt xmlInt);

    void xsetHMerge(XmlBoolean xmlBoolean);

    void xsetRowSpan(XmlInt xmlInt);

    void xsetVMerge(XmlBoolean xmlBoolean);
}
