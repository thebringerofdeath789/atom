package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisOrientation;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.AxisTickMark;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

/* loaded from: classes5.dex */
public class XSSFCategoryAxis extends XSSFChartAxis {
    private CTCatAx ctCatAx;

    public XSSFCategoryAxis(XSSFChart xSSFChart, long j, AxisPosition axisPosition) {
        super(xSSFChart);
        createAxis(j, axisPosition);
    }

    public XSSFCategoryAxis(XSSFChart xSSFChart, CTCatAx cTCatAx) {
        super(xSSFChart);
        this.ctCatAx = cTCatAx;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public long getId() {
        return this.ctCatAx.getAxId().getVal();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTAxPos getCTAxPos() {
        return this.ctCatAx.getAxPos();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTNumFmt getCTNumFmt() {
        if (this.ctCatAx.isSetNumFmt()) {
            return this.ctCatAx.getNumFmt();
        }
        return this.ctCatAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTScaling getCTScaling() {
        return this.ctCatAx.getScaling();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTCrosses getCTCrosses() {
        return this.ctCatAx.getCrosses();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTBoolean getDelete() {
        return this.ctCatAx.getDelete();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTTickMark getMajorCTTickMark() {
        return this.ctCatAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xssf.usermodel.charts.XSSFChartAxis
    protected CTTickMark getMinorCTTickMark() {
        return this.ctCatAx.getMinorTickMark();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void crossAxis(ChartAxis chartAxis) {
        this.ctCatAx.getCrossAx().setVal(chartAxis.getId());
    }

    private void createAxis(long j, AxisPosition axisPosition) {
        CTCatAx addNewCatAx = this.chart.getCTChart().getPlotArea().addNewCatAx();
        this.ctCatAx = addNewCatAx;
        addNewCatAx.addNewAxId().setVal(j);
        this.ctCatAx.addNewAxPos();
        this.ctCatAx.addNewScaling();
        this.ctCatAx.addNewCrosses();
        this.ctCatAx.addNewCrossAx();
        this.ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        this.ctCatAx.addNewDelete();
        this.ctCatAx.addNewMajorTickMark();
        this.ctCatAx.addNewMinorTickMark();
        setPosition(axisPosition);
        setOrientation(AxisOrientation.MIN_MAX);
        setCrosses(AxisCrosses.AUTO_ZERO);
        setVisible(true);
        setMajorTickMark(AxisTickMark.CROSS);
        setMinorTickMark(AxisTickMark.NONE);
    }
}
