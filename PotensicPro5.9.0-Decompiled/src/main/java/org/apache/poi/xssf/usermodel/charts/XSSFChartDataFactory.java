package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.ChartDataFactory;

/* loaded from: classes5.dex */
public class XSSFChartDataFactory implements ChartDataFactory {
    private static XSSFChartDataFactory instance;

    private XSSFChartDataFactory() {
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartDataFactory
    public XSSFScatterChartData createScatterChartData() {
        return new XSSFScatterChartData();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartDataFactory
    public XSSFLineChartData createLineChartData() {
        return new XSSFLineChartData();
    }

    public static XSSFChartDataFactory getInstance() {
        if (instance == null) {
            instance = new XSSFChartDataFactory();
        }
        return instance;
    }
}
