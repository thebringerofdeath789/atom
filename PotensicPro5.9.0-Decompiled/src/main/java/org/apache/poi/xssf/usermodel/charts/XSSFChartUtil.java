package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;

/* loaded from: classes5.dex */
class XSSFChartUtil {
    private XSSFChartUtil() {
    }

    public static void buildAxDataSource(CTAxDataSource cTAxDataSource, ChartDataSource<?> chartDataSource) {
        if (chartDataSource.isNumeric()) {
            if (chartDataSource.isReference()) {
                buildNumRef(cTAxDataSource.addNewNumRef(), chartDataSource);
                return;
            } else {
                buildNumLit(cTAxDataSource.addNewNumLit(), chartDataSource);
                return;
            }
        }
        if (chartDataSource.isReference()) {
            buildStrRef(cTAxDataSource.addNewStrRef(), chartDataSource);
        } else {
            buildStrLit(cTAxDataSource.addNewStrLit(), chartDataSource);
        }
    }

    public static void buildNumDataSource(CTNumDataSource cTNumDataSource, ChartDataSource<? extends Number> chartDataSource) {
        if (chartDataSource.isReference()) {
            buildNumRef(cTNumDataSource.addNewNumRef(), chartDataSource);
        } else {
            buildNumLit(cTNumDataSource.addNewNumLit(), chartDataSource);
        }
    }

    private static void buildNumRef(CTNumRef cTNumRef, ChartDataSource<?> chartDataSource) {
        cTNumRef.setF(chartDataSource.getFormulaString());
        fillNumCache(cTNumRef.addNewNumCache(), chartDataSource);
    }

    private static void buildNumLit(CTNumData cTNumData, ChartDataSource<?> chartDataSource) {
        fillNumCache(cTNumData, chartDataSource);
    }

    private static void buildStrRef(CTStrRef cTStrRef, ChartDataSource<?> chartDataSource) {
        cTStrRef.setF(chartDataSource.getFormulaString());
        fillStringCache(cTStrRef.addNewStrCache(), chartDataSource);
    }

    private static void buildStrLit(CTStrData cTStrData, ChartDataSource<?> chartDataSource) {
        fillStringCache(cTStrData, chartDataSource);
    }

    private static void fillStringCache(CTStrData cTStrData, ChartDataSource<?> chartDataSource) {
        int pointCount = chartDataSource.getPointCount();
        cTStrData.addNewPtCount().setVal(pointCount);
        for (int i = 0; i < pointCount; i++) {
            Object pointAt = chartDataSource.getPointAt(i);
            if (pointAt != null) {
                CTStrVal addNewPt = cTStrData.addNewPt();
                addNewPt.setIdx(i);
                addNewPt.setV(pointAt.toString());
            }
        }
    }

    private static void fillNumCache(CTNumData cTNumData, ChartDataSource<?> chartDataSource) {
        int pointCount = chartDataSource.getPointCount();
        cTNumData.addNewPtCount().setVal(pointCount);
        for (int i = 0; i < pointCount; i++) {
            Number number = (Number) chartDataSource.getPointAt(i);
            if (number != null) {
                CTNumVal addNewPt = cTNumData.addNewPt();
                addNewPt.setIdx(i);
                addNewPt.setV(number.toString());
            }
        }
    }
}
