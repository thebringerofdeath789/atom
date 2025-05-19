package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartAxisFactory;
import org.apache.poi.ss.usermodel.charts.ChartData;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.charts.XSSFCategoryAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartDataFactory;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.apache.poi.xssf.usermodel.charts.XSSFManualLayout;
import org.apache.poi.xssf.usermodel.charts.XSSFValueAxis;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public final class XSSFChart extends POIXMLDocumentPart implements Chart, ChartAxisFactory {
    List<XSSFChartAxis> axis;
    private CTChart chart;
    private CTChartSpace chartSpace;
    private XSSFGraphicFrame frame;

    @Override // org.apache.poi.ss.usermodel.Chart
    public XSSFChart getChartAxisFactory() {
        return this;
    }

    protected XSSFChart() {
        this.axis = new ArrayList();
        createChart();
    }

    protected XSSFChart(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        this.axis = new ArrayList();
        CTChartSpace chartSpace = ChartSpaceDocument.Factory.parse(packagePart.getInputStream()).getChartSpace();
        this.chartSpace = chartSpace;
        this.chart = chartSpace.getChart();
    }

    private void createChart() {
        CTChartSpace newInstance = CTChartSpace.Factory.newInstance();
        this.chartSpace = newInstance;
        CTChart addNewChart = newInstance.addNewChart();
        this.chart = addNewChart;
        addNewChart.addNewPlotArea().addNewLayout();
        this.chart.addNewPlotVisOnly().setVal(true);
        CTPrintSettings addNewPrintSettings = this.chartSpace.addNewPrintSettings();
        addNewPrintSettings.addNewHeaderFooter();
        CTPageMargins addNewPageMargins = addNewPrintSettings.addNewPageMargins();
        addNewPageMargins.setB(0.75d);
        addNewPageMargins.setL(0.7d);
        addNewPageMargins.setR(0.7d);
        addNewPageMargins.setT(0.75d);
        addNewPageMargins.setHeader(0.3d);
        addNewPageMargins.setFooter(0.3d);
        addNewPrintSettings.addNewPageSetup();
    }

    @Internal
    public CTChartSpace getCTChartSpace() {
        return this.chartSpace;
    }

    @Internal
    public CTChart getCTChart() {
        return this.chart;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        HashMap hashMap = new HashMap();
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/chart", "c");
        hashMap.put(STRelationshipId.type.getName().getNamespaceURI(), InternalZipConstants.READ_MODE);
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.chartSpace.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public XSSFGraphicFrame getGraphicFrame() {
        return this.frame;
    }

    protected void setGraphicFrame(XSSFGraphicFrame xSSFGraphicFrame) {
        this.frame = xSSFGraphicFrame;
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public XSSFChartDataFactory getChartDataFactory() {
        return XSSFChartDataFactory.getInstance();
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public void plot(ChartData chartData, ChartAxis... chartAxisArr) {
        chartData.fillChart(this, chartAxisArr);
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxisFactory
    public XSSFValueAxis createValueAxis(AxisPosition axisPosition) {
        XSSFValueAxis xSSFValueAxis = new XSSFValueAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            XSSFChartAxis xSSFChartAxis = this.axis.get(0);
            xSSFChartAxis.crossAxis(xSSFValueAxis);
            xSSFValueAxis.crossAxis(xSSFChartAxis);
        }
        this.axis.add(xSSFValueAxis);
        return xSSFValueAxis;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxisFactory
    public XSSFCategoryAxis createCategoryAxis(AxisPosition axisPosition) {
        XSSFCategoryAxis xSSFCategoryAxis = new XSSFCategoryAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            XSSFChartAxis xSSFChartAxis = this.axis.get(0);
            xSSFChartAxis.crossAxis(xSSFCategoryAxis);
            xSSFCategoryAxis.crossAxis(xSSFChartAxis);
        }
        this.axis.add(xSSFCategoryAxis);
        return xSSFCategoryAxis;
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public List<? extends XSSFChartAxis> getAxis() {
        if (this.axis.isEmpty() && hasAxis()) {
            parseAxis();
        }
        return this.axis;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ManuallyPositionable
    public XSSFManualLayout getManualLayout() {
        return new XSSFManualLayout(this);
    }

    public boolean isPlotOnlyVisibleCells() {
        return this.chart.getPlotVisOnly().getVal();
    }

    public void setPlotOnlyVisibleCells(boolean z) {
        this.chart.getPlotVisOnly().setVal(z);
    }

    public XSSFRichTextString getTitle() {
        if (!this.chart.isSetTitle()) {
            return null;
        }
        CTTitle title = this.chart.getTitle();
        StringBuffer stringBuffer = new StringBuffer();
        for (XmlObject xmlObject : title.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t")) {
            NodeList childNodes = xmlObject.getDomNode().getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i) instanceof Text) {
                    stringBuffer.append(childNodes.item(i).getNodeValue());
                }
            }
        }
        return new XSSFRichTextString(stringBuffer.toString());
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public XSSFChartLegend getOrCreateLegend() {
        return new XSSFChartLegend(this);
    }

    @Override // org.apache.poi.ss.usermodel.Chart
    public void deleteLegend() {
        if (this.chart.isSetLegend()) {
            this.chart.unsetLegend();
        }
    }

    private boolean hasAxis() {
        CTPlotArea plotArea = this.chart.getPlotArea();
        return ((plotArea.sizeOfValAxArray() + plotArea.sizeOfCatAxArray()) + plotArea.sizeOfDateAxArray()) + plotArea.sizeOfSerAxArray() > 0;
    }

    private void parseAxis() {
        parseCategoryAxis();
        parseValueAxis();
    }

    private void parseCategoryAxis() {
        for (CTCatAx cTCatAx : this.chart.getPlotArea().getCatAxArray()) {
            this.axis.add(new XSSFCategoryAxis(this, cTCatAx));
        }
    }

    private void parseValueAxis() {
        for (CTValAx cTValAx : this.chart.getPlotArea().getValAxArray()) {
            this.axis.add(new XSSFValueAxis(this, cTValAx));
        }
    }
}
