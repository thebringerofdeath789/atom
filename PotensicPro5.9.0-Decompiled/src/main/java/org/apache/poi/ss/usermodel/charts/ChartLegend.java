package org.apache.poi.ss.usermodel.charts;

/* loaded from: classes5.dex */
public interface ChartLegend extends ManuallyPositionable {
    LegendPosition getPosition();

    boolean isOverlay();

    void setOverlay(boolean z);

    void setPosition(LegendPosition legendPosition);
}
