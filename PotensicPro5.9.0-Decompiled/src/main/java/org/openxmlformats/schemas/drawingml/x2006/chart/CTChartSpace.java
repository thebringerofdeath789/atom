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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTChartSpace extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTChartSpace.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctchartspacef9b4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTChartSpace newInstance() {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().newInstance(CTChartSpace.type, null);
        }

        public static CTChartSpace newInstance(XmlOptions xmlOptions) {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().newInstance(CTChartSpace.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTChartSpace.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(File file) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(file, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(file, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(InputStream inputStream) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(inputStream, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(inputStream, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(Reader reader) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(reader, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(reader, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(String str) throws XmlException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(str, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(str, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(URL url) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(url, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(url, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTChartSpace.type, xmlOptions);
        }

        public static CTChartSpace parse(Node node) throws XmlException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(node, CTChartSpace.type, (XmlOptions) null);
        }

        public static CTChartSpace parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTChartSpace) XmlBeans.getContextTypeLoader().parse(node, CTChartSpace.type, xmlOptions);
        }
    }

    CTChart addNewChart();

    CTColorMapping addNewClrMapOvr();

    CTBoolean addNewDate1904();

    CTExtensionList addNewExtLst();

    CTExternalData addNewExternalData();

    CTTextLanguageID addNewLang();

    CTPivotSource addNewPivotSource();

    CTPrintSettings addNewPrintSettings();

    CTProtection addNewProtection();

    CTBoolean addNewRoundedCorners();

    CTShapeProperties addNewSpPr();

    CTStyle addNewStyle();

    CTTextBody addNewTxPr();

    CTRelId addNewUserShapes();

    CTChart getChart();

    CTColorMapping getClrMapOvr();

    CTBoolean getDate1904();

    CTExtensionList getExtLst();

    CTExternalData getExternalData();

    CTTextLanguageID getLang();

    CTPivotSource getPivotSource();

    CTPrintSettings getPrintSettings();

    CTProtection getProtection();

    CTBoolean getRoundedCorners();

    CTShapeProperties getSpPr();

    CTStyle getStyle();

    CTTextBody getTxPr();

    CTRelId getUserShapes();

    boolean isSetClrMapOvr();

    boolean isSetDate1904();

    boolean isSetExtLst();

    boolean isSetExternalData();

    boolean isSetLang();

    boolean isSetPivotSource();

    boolean isSetPrintSettings();

    boolean isSetProtection();

    boolean isSetRoundedCorners();

    boolean isSetSpPr();

    boolean isSetStyle();

    boolean isSetTxPr();

    boolean isSetUserShapes();

    void setChart(CTChart cTChart);

    void setClrMapOvr(CTColorMapping cTColorMapping);

    void setDate1904(CTBoolean cTBoolean);

    void setExtLst(CTExtensionList cTExtensionList);

    void setExternalData(CTExternalData cTExternalData);

    void setLang(CTTextLanguageID cTTextLanguageID);

    void setPivotSource(CTPivotSource cTPivotSource);

    void setPrintSettings(CTPrintSettings cTPrintSettings);

    void setProtection(CTProtection cTProtection);

    void setRoundedCorners(CTBoolean cTBoolean);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStyle(CTStyle cTStyle);

    void setTxPr(CTTextBody cTTextBody);

    void setUserShapes(CTRelId cTRelId);

    void unsetClrMapOvr();

    void unsetDate1904();

    void unsetExtLst();

    void unsetExternalData();

    void unsetLang();

    void unsetPivotSource();

    void unsetPrintSettings();

    void unsetProtection();

    void unsetRoundedCorners();

    void unsetSpPr();

    void unsetStyle();

    void unsetTxPr();

    void unsetUserShapes();
}
