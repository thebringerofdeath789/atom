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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTStylesheet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStylesheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstylesheet4257type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStylesheet newInstance() {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().newInstance(CTStylesheet.type, null);
        }

        public static CTStylesheet newInstance(XmlOptions xmlOptions) {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().newInstance(CTStylesheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStylesheet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(File file) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(file, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(file, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(Reader reader) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(reader, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(reader, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(String str) throws XmlException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(str, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(str, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(URL url) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(url, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(url, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(Node node) throws XmlException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(node, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStylesheet) XmlBeans.getContextTypeLoader().parse(node, CTStylesheet.type, xmlOptions);
        }
    }

    CTBorders addNewBorders();

    CTCellStyleXfs addNewCellStyleXfs();

    CTCellStyles addNewCellStyles();

    CTCellXfs addNewCellXfs();

    CTColors addNewColors();

    CTDxfs addNewDxfs();

    CTExtensionList addNewExtLst();

    CTFills addNewFills();

    CTFonts addNewFonts();

    CTNumFmts addNewNumFmts();

    CTTableStyles addNewTableStyles();

    CTBorders getBorders();

    CTCellStyleXfs getCellStyleXfs();

    CTCellStyles getCellStyles();

    CTCellXfs getCellXfs();

    CTColors getColors();

    CTDxfs getDxfs();

    CTExtensionList getExtLst();

    CTFills getFills();

    CTFonts getFonts();

    CTNumFmts getNumFmts();

    CTTableStyles getTableStyles();

    boolean isSetBorders();

    boolean isSetCellStyleXfs();

    boolean isSetCellStyles();

    boolean isSetCellXfs();

    boolean isSetColors();

    boolean isSetDxfs();

    boolean isSetExtLst();

    boolean isSetFills();

    boolean isSetFonts();

    boolean isSetNumFmts();

    boolean isSetTableStyles();

    void setBorders(CTBorders cTBorders);

    void setCellStyleXfs(CTCellStyleXfs cTCellStyleXfs);

    void setCellStyles(CTCellStyles cTCellStyles);

    void setCellXfs(CTCellXfs cTCellXfs);

    void setColors(CTColors cTColors);

    void setDxfs(CTDxfs cTDxfs);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFills(CTFills cTFills);

    void setFonts(CTFonts cTFonts);

    void setNumFmts(CTNumFmts cTNumFmts);

    void setTableStyles(CTTableStyles cTTableStyles);

    void unsetBorders();

    void unsetCellStyleXfs();

    void unsetCellStyles();

    void unsetCellXfs();

    void unsetColors();

    void unsetDxfs();

    void unsetExtLst();

    void unsetFills();

    void unsetFonts();

    void unsetNumFmts();

    void unsetTableStyles();
}
