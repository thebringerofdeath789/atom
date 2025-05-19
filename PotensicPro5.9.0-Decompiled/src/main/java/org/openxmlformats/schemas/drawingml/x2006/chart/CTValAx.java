package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTValAx extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTValAx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctvalaxd06etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTValAx newInstance() {
            return (CTValAx) XmlBeans.getContextTypeLoader().newInstance(CTValAx.type, null);
        }

        public static CTValAx newInstance(XmlOptions xmlOptions) {
            return (CTValAx) XmlBeans.getContextTypeLoader().newInstance(CTValAx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTValAx.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(File file) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(file, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(file, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(inputStream, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(inputStream, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(Reader reader) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(reader, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(reader, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(String str) throws XmlException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(str, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(str, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(URL url) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(url, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(url, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTValAx.type, xmlOptions);
        }

        public static CTValAx parse(Node node) throws XmlException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(node, CTValAx.type, (XmlOptions) null);
        }

        public static CTValAx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTValAx) XmlBeans.getContextTypeLoader().parse(node, CTValAx.type, xmlOptions);
        }
    }

    CTUnsignedInt addNewAxId();

    CTAxPos addNewAxPos();

    CTUnsignedInt addNewCrossAx();

    CTCrossBetween addNewCrossBetween();

    CTCrosses addNewCrosses();

    CTDouble addNewCrossesAt();

    CTBoolean addNewDelete();

    CTDispUnits addNewDispUnits();

    CTExtensionList addNewExtLst();

    CTChartLines addNewMajorGridlines();

    CTTickMark addNewMajorTickMark();

    CTAxisUnit addNewMajorUnit();

    CTChartLines addNewMinorGridlines();

    CTTickMark addNewMinorTickMark();

    CTAxisUnit addNewMinorUnit();

    CTNumFmt addNewNumFmt();

    CTScaling addNewScaling();

    CTShapeProperties addNewSpPr();

    CTTickLblPos addNewTickLblPos();

    CTTitle addNewTitle();

    CTTextBody addNewTxPr();

    CTUnsignedInt getAxId();

    CTAxPos getAxPos();

    CTUnsignedInt getCrossAx();

    CTCrossBetween getCrossBetween();

    CTCrosses getCrosses();

    CTDouble getCrossesAt();

    CTBoolean getDelete();

    CTDispUnits getDispUnits();

    CTExtensionList getExtLst();

    CTChartLines getMajorGridlines();

    CTTickMark getMajorTickMark();

    CTAxisUnit getMajorUnit();

    CTChartLines getMinorGridlines();

    CTTickMark getMinorTickMark();

    CTAxisUnit getMinorUnit();

    CTNumFmt getNumFmt();

    CTScaling getScaling();

    CTShapeProperties getSpPr();

    CTTickLblPos getTickLblPos();

    CTTitle getTitle();

    CTTextBody getTxPr();

    boolean isSetCrossBetween();

    boolean isSetCrosses();

    boolean isSetCrossesAt();

    boolean isSetDelete();

    boolean isSetDispUnits();

    boolean isSetExtLst();

    boolean isSetMajorGridlines();

    boolean isSetMajorTickMark();

    boolean isSetMajorUnit();

    boolean isSetMinorGridlines();

    boolean isSetMinorTickMark();

    boolean isSetMinorUnit();

    boolean isSetNumFmt();

    boolean isSetSpPr();

    boolean isSetTickLblPos();

    boolean isSetTitle();

    boolean isSetTxPr();

    void setAxId(CTUnsignedInt cTUnsignedInt);

    void setAxPos(CTAxPos cTAxPos);

    void setCrossAx(CTUnsignedInt cTUnsignedInt);

    void setCrossBetween(CTCrossBetween cTCrossBetween);

    void setCrosses(CTCrosses cTCrosses);

    void setCrossesAt(CTDouble cTDouble);

    void setDelete(CTBoolean cTBoolean);

    void setDispUnits(CTDispUnits cTDispUnits);

    void setExtLst(CTExtensionList cTExtensionList);

    void setMajorGridlines(CTChartLines cTChartLines);

    void setMajorTickMark(CTTickMark cTTickMark);

    void setMajorUnit(CTAxisUnit cTAxisUnit);

    void setMinorGridlines(CTChartLines cTChartLines);

    void setMinorTickMark(CTTickMark cTTickMark);

    void setMinorUnit(CTAxisUnit cTAxisUnit);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setScaling(CTScaling cTScaling);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTickLblPos(CTTickLblPos cTTickLblPos);

    void setTitle(CTTitle cTTitle);

    void setTxPr(CTTextBody cTTextBody);

    void unsetCrossBetween();

    void unsetCrosses();

    void unsetCrossesAt();

    void unsetDelete();

    void unsetDispUnits();

    void unsetExtLst();

    void unsetMajorGridlines();

    void unsetMajorTickMark();

    void unsetMajorUnit();

    void unsetMinorGridlines();

    void unsetMinorTickMark();

    void unsetMinorUnit();

    void unsetNumFmt();

    void unsetSpPr();

    void unsetTickLblPos();

    void unsetTitle();

    void unsetTxPr();
}
