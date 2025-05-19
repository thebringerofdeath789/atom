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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTCfRule extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTCfRule.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcfrule3548type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCfRule newInstance() {
            return (CTCfRule) XmlBeans.getContextTypeLoader().newInstance(CTCfRule.type, null);
        }

        public static CTCfRule newInstance(XmlOptions xmlOptions) {
            return (CTCfRule) XmlBeans.getContextTypeLoader().newInstance(CTCfRule.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCfRule.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(File file) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(file, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(file, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(inputStream, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(inputStream, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(Reader reader) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(reader, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(reader, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(String str) throws XmlException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(str, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(str, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(URL url) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(url, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(url, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(Node node) throws XmlException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(node, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCfRule) XmlBeans.getContextTypeLoader().parse(node, CTCfRule.type, xmlOptions);
        }
    }

    void addFormula(String str);

    CTColorScale addNewColorScale();

    CTDataBar addNewDataBar();

    CTExtensionList addNewExtLst();

    STFormula addNewFormula();

    CTIconSet addNewIconSet();

    boolean getAboveAverage();

    boolean getBottom();

    CTColorScale getColorScale();

    CTDataBar getDataBar();

    long getDxfId();

    boolean getEqualAverage();

    CTExtensionList getExtLst();

    String getFormulaArray(int i);

    String[] getFormulaArray();

    List<String> getFormulaList();

    CTIconSet getIconSet();

    STConditionalFormattingOperator.Enum getOperator();

    boolean getPercent();

    int getPriority();

    long getRank();

    int getStdDev();

    boolean getStopIfTrue();

    String getText();

    STTimePeriod$Enum getTimePeriod();

    STCfType.Enum getType();

    void insertFormula(int i, String str);

    STFormula insertNewFormula(int i);

    boolean isSetAboveAverage();

    boolean isSetBottom();

    boolean isSetColorScale();

    boolean isSetDataBar();

    boolean isSetDxfId();

    boolean isSetEqualAverage();

    boolean isSetExtLst();

    boolean isSetIconSet();

    boolean isSetOperator();

    boolean isSetPercent();

    boolean isSetRank();

    boolean isSetStdDev();

    boolean isSetStopIfTrue();

    boolean isSetText();

    boolean isSetTimePeriod();

    boolean isSetType();

    void removeFormula(int i);

    void setAboveAverage(boolean z);

    void setBottom(boolean z);

    void setColorScale(CTColorScale cTColorScale);

    void setDataBar(CTDataBar cTDataBar);

    void setDxfId(long j);

    void setEqualAverage(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFormulaArray(int i, String str);

    void setFormulaArray(String[] strArr);

    void setIconSet(CTIconSet cTIconSet);

    void setOperator(STConditionalFormattingOperator.Enum r1);

    void setPercent(boolean z);

    void setPriority(int i);

    void setRank(long j);

    void setStdDev(int i);

    void setStopIfTrue(boolean z);

    void setText(String str);

    void setTimePeriod(STTimePeriod$Enum sTTimePeriod$Enum);

    void setType(STCfType.Enum r1);

    int sizeOfFormulaArray();

    void unsetAboveAverage();

    void unsetBottom();

    void unsetColorScale();

    void unsetDataBar();

    void unsetDxfId();

    void unsetEqualAverage();

    void unsetExtLst();

    void unsetIconSet();

    void unsetOperator();

    void unsetPercent();

    void unsetRank();

    void unsetStdDev();

    void unsetStopIfTrue();

    void unsetText();

    void unsetTimePeriod();

    void unsetType();

    XmlBoolean xgetAboveAverage();

    XmlBoolean xgetBottom();

    STDxfId xgetDxfId();

    XmlBoolean xgetEqualAverage();

    STFormula xgetFormulaArray(int i);

    STFormula[] xgetFormulaArray();

    List<STFormula> xgetFormulaList();

    STConditionalFormattingOperator xgetOperator();

    XmlBoolean xgetPercent();

    XmlInt xgetPriority();

    XmlUnsignedInt xgetRank();

    XmlInt xgetStdDev();

    XmlBoolean xgetStopIfTrue();

    XmlString xgetText();

    STTimePeriod xgetTimePeriod();

    STCfType xgetType();

    void xsetAboveAverage(XmlBoolean xmlBoolean);

    void xsetBottom(XmlBoolean xmlBoolean);

    void xsetDxfId(STDxfId sTDxfId);

    void xsetEqualAverage(XmlBoolean xmlBoolean);

    void xsetFormulaArray(int i, STFormula sTFormula);

    void xsetFormulaArray(STFormula[] sTFormulaArr);

    void xsetOperator(STConditionalFormattingOperator sTConditionalFormattingOperator);

    void xsetPercent(XmlBoolean xmlBoolean);

    void xsetPriority(XmlInt xmlInt);

    void xsetRank(XmlUnsignedInt xmlUnsignedInt);

    void xsetStdDev(XmlInt xmlInt);

    void xsetStopIfTrue(XmlBoolean xmlBoolean);

    void xsetText(XmlString xmlString);

    void xsetTimePeriod(STTimePeriod sTTimePeriod);

    void xsetType(STCfType sTCfType);
}
