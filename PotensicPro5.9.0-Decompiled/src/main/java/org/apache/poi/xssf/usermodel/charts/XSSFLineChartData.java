package org.apache.poi.xssf.usermodel.charts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.LineChartSeries;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;

/* loaded from: classes5.dex */
public class XSSFLineChartData implements LineChartData {
    private List<Series> series = new ArrayList();

    static class Series extends AbstractXSSFChartSeries implements LineChartSeries {
        private ChartDataSource<?> categories;
        private int id;
        private int order;
        private ChartDataSource<? extends Number> values;

        protected Series(int i, int i2, ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2) {
            this.id = i;
            this.order = i2;
            this.categories = chartDataSource;
            this.values = chartDataSource2;
        }

        @Override // org.apache.poi.ss.usermodel.charts.LineChartSeries
        public ChartDataSource<?> getCategoryAxisData() {
            return this.categories;
        }

        @Override // org.apache.poi.ss.usermodel.charts.LineChartSeries
        public ChartDataSource<? extends Number> getValues() {
            return this.values;
        }

        protected void addToChart(CTLineChart cTLineChart) {
            CTLineSer addNewSer = cTLineChart.addNewSer();
            addNewSer.addNewIdx().setVal(this.id);
            addNewSer.addNewOrder().setVal(this.order);
            addNewSer.addNewMarker().addNewSymbol().setVal(STMarkerStyle.NONE);
            XSSFChartUtil.buildAxDataSource(addNewSer.addNewCat(), this.categories);
            XSSFChartUtil.buildNumDataSource(addNewSer.addNewVal(), this.values);
            if (isTitleSet()) {
                addNewSer.setTx(getCTSerTx());
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.LineChartData
    public LineChartSeries addSeries(ChartDataSource<?> chartDataSource, ChartDataSource<? extends Number> chartDataSource2) {
        if (!chartDataSource2.isNumeric()) {
            throw new IllegalArgumentException("Value data source must be numeric.");
        }
        int size = this.series.size();
        Series series = new Series(size, size, chartDataSource, chartDataSource2);
        this.series.add(series);
        return series;
    }

    @Override // org.apache.poi.ss.usermodel.charts.LineChartData
    public List<? extends LineChartSeries> getSeries() {
        return this.series;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartData
    public void fillChart(Chart chart, ChartAxis... chartAxisArr) {
        if (!(chart instanceof XSSFChart)) {
            throw new IllegalArgumentException("Chart must be instance of XSSFChart");
        }
        CTLineChart addNewLineChart = ((XSSFChart) chart).getCTChart().getPlotArea().addNewLineChart();
        addNewLineChart.addNewVaryColors().setVal(false);
        Iterator<Series> it = this.series.iterator();
        while (it.hasNext()) {
            it.next().addToChart(addNewLineChart);
        }
        for (ChartAxis chartAxis : chartAxisArr) {
            addNewLineChart.addNewAxId().setVal(chartAxis.getId());
        }
    }
}
