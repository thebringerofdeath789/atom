package org.apache.poi.ss.usermodel.charts;

/* loaded from: classes5.dex */
public interface LineChartSeries extends ChartSeries {
    ChartDataSource<?> getCategoryAxisData();

    ChartDataSource<? extends Number> getValues();
}
