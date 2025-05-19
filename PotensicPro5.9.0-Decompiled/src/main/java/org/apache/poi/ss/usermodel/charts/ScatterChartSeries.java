package org.apache.poi.ss.usermodel.charts;

/* loaded from: classes5.dex */
public interface ScatterChartSeries extends ChartSeries {
    ChartDataSource<?> getXValues();

    ChartDataSource<? extends Number> getYValues();
}
