package org.apache.poi.hssf.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.RegionUtil;

/* loaded from: classes5.dex */
public final class HSSFRegionUtil {
    private HSSFRegionUtil() {
    }

    private static org.apache.poi.ss.util.CellRangeAddress toCRA(org.apache.poi.ss.util.Region region) {
        return org.apache.poi.ss.util.Region.convertToCellRangeAddress(region);
    }

    public static void setBorderLeft(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setBorderLeft(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderLeft(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderLeft(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setLeftBorderColor(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setLeftBorderColor(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setLeftBorderColor(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setLeftBorderColor(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderRight(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setBorderRight(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderRight(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderRight(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setRightBorderColor(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setRightBorderColor(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setRightBorderColor(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setRightBorderColor(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderBottom(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setBorderBottom(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderBottom(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderBottom(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setBottomBorderColor(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setBottomBorderColor(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setBottomBorderColor(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBottomBorderColor(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderTop(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setBorderTop(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setBorderTop(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderTop(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }

    public static void setTopBorderColor(short s, Region region, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        setTopBorderColor(s, toCRA(region), hSSFSheet, hSSFWorkbook);
    }

    public static void setTopBorderColor(int i, org.apache.poi.ss.util.CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setTopBorderColor(i, cellRangeAddress, hSSFSheet, hSSFWorkbook);
    }
}
