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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTableColumn extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableColumn.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablecolumn08a3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableColumn newInstance() {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().newInstance(CTTableColumn.type, null);
        }

        public static CTTableColumn newInstance(XmlOptions xmlOptions) {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().newInstance(CTTableColumn.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableColumn.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(File file) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(file, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(file, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(Reader reader) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(reader, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(reader, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(String str) throws XmlException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(str, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(str, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(URL url) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(url, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(url, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(Node node) throws XmlException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(node, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumn) XmlBeans.getContextTypeLoader().parse(node, CTTableColumn.type, xmlOptions);
        }
    }

    CTTableFormula addNewCalculatedColumnFormula();

    CTExtensionList addNewExtLst();

    CTTableFormula addNewTotalsRowFormula();

    CTXmlColumnPr addNewXmlColumnPr();

    CTTableFormula getCalculatedColumnFormula();

    String getDataCellStyle();

    long getDataDxfId();

    CTExtensionList getExtLst();

    String getHeaderRowCellStyle();

    long getHeaderRowDxfId();

    long getId();

    String getName();

    long getQueryTableFieldId();

    String getTotalsRowCellStyle();

    long getTotalsRowDxfId();

    CTTableFormula getTotalsRowFormula();

    STTotalsRowFunction$Enum getTotalsRowFunction();

    String getTotalsRowLabel();

    String getUniqueName();

    CTXmlColumnPr getXmlColumnPr();

    boolean isSetCalculatedColumnFormula();

    boolean isSetDataCellStyle();

    boolean isSetDataDxfId();

    boolean isSetExtLst();

    boolean isSetHeaderRowCellStyle();

    boolean isSetHeaderRowDxfId();

    boolean isSetQueryTableFieldId();

    boolean isSetTotalsRowCellStyle();

    boolean isSetTotalsRowDxfId();

    boolean isSetTotalsRowFormula();

    boolean isSetTotalsRowFunction();

    boolean isSetTotalsRowLabel();

    boolean isSetUniqueName();

    boolean isSetXmlColumnPr();

    void setCalculatedColumnFormula(CTTableFormula cTTableFormula);

    void setDataCellStyle(String str);

    void setDataDxfId(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHeaderRowCellStyle(String str);

    void setHeaderRowDxfId(long j);

    void setId(long j);

    void setName(String str);

    void setQueryTableFieldId(long j);

    void setTotalsRowCellStyle(String str);

    void setTotalsRowDxfId(long j);

    void setTotalsRowFormula(CTTableFormula cTTableFormula);

    void setTotalsRowFunction(STTotalsRowFunction$Enum sTTotalsRowFunction$Enum);

    void setTotalsRowLabel(String str);

    void setUniqueName(String str);

    void setXmlColumnPr(CTXmlColumnPr cTXmlColumnPr);

    void unsetCalculatedColumnFormula();

    void unsetDataCellStyle();

    void unsetDataDxfId();

    void unsetExtLst();

    void unsetHeaderRowCellStyle();

    void unsetHeaderRowDxfId();

    void unsetQueryTableFieldId();

    void unsetTotalsRowCellStyle();

    void unsetTotalsRowDxfId();

    void unsetTotalsRowFormula();

    void unsetTotalsRowFunction();

    void unsetTotalsRowLabel();

    void unsetUniqueName();

    void unsetXmlColumnPr();

    STXstring xgetDataCellStyle();

    STDxfId xgetDataDxfId();

    STXstring xgetHeaderRowCellStyle();

    STDxfId xgetHeaderRowDxfId();

    XmlUnsignedInt xgetId();

    STXstring xgetName();

    XmlUnsignedInt xgetQueryTableFieldId();

    STXstring xgetTotalsRowCellStyle();

    STDxfId xgetTotalsRowDxfId();

    STTotalsRowFunction xgetTotalsRowFunction();

    STXstring xgetTotalsRowLabel();

    STXstring xgetUniqueName();

    void xsetDataCellStyle(STXstring sTXstring);

    void xsetDataDxfId(STDxfId sTDxfId);

    void xsetHeaderRowCellStyle(STXstring sTXstring);

    void xsetHeaderRowDxfId(STDxfId sTDxfId);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);

    void xsetQueryTableFieldId(XmlUnsignedInt xmlUnsignedInt);

    void xsetTotalsRowCellStyle(STXstring sTXstring);

    void xsetTotalsRowDxfId(STDxfId sTDxfId);

    void xsetTotalsRowFunction(STTotalsRowFunction sTTotalsRowFunction);

    void xsetTotalsRowLabel(STXstring sTXstring);

    void xsetUniqueName(STXstring sTXstring);
}
