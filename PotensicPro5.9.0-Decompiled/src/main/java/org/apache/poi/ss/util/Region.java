package org.apache.poi.ss.util;

/* loaded from: classes5.dex */
public class Region implements Comparable<Region> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private short _colFrom;
    private short _colTo;
    private int _rowFrom;
    private int _rowTo;

    public int hashCode() {
        return 42;
    }

    public Region() {
    }

    public Region(int i, short s, int i2, short s2) {
        this._rowFrom = i;
        this._rowTo = i2;
        this._colFrom = s;
        this._colTo = s2;
    }

    public Region(String str) {
        CellReference cellReference = new CellReference(str.substring(0, str.indexOf(":")));
        CellReference cellReference2 = new CellReference(str.substring(str.indexOf(":") + 1));
        this._rowFrom = cellReference.getRow();
        this._colFrom = cellReference.getCol();
        this._rowTo = cellReference2.getRow();
        this._colTo = cellReference2.getCol();
    }

    public short getColumnFrom() {
        return this._colFrom;
    }

    public int getRowFrom() {
        return this._rowFrom;
    }

    public short getColumnTo() {
        return this._colTo;
    }

    public int getRowTo() {
        return this._rowTo;
    }

    public void setColumnFrom(short s) {
        this._colFrom = s;
    }

    public void setRowFrom(int i) {
        this._rowFrom = i;
    }

    public void setColumnTo(short s) {
        this._colTo = s;
    }

    public void setRowTo(int i) {
        this._rowTo = i;
    }

    public boolean contains(int i, short s) {
        return this._rowFrom <= i && this._rowTo >= i && this._colFrom <= s && this._colTo >= s;
    }

    public boolean equals(Region region) {
        return compareTo(region) == 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(Region region) {
        if (getRowFrom() == region.getRowFrom() && getColumnFrom() == region.getColumnFrom() && getRowTo() == region.getRowTo() && getColumnTo() == region.getColumnTo()) {
            return 0;
        }
        return (getRowFrom() < region.getRowFrom() || getColumnFrom() < region.getColumnFrom() || getRowTo() < region.getRowTo() || getColumnTo() < region.getColumnTo()) ? 1 : -1;
    }

    public int getArea() {
        return ((this._rowTo - this._rowFrom) + 1) * ((this._colTo - this._colFrom) + 1);
    }

    public static Region[] convertCellRangesToRegions(CellRangeAddress[] cellRangeAddressArr) {
        int length = cellRangeAddressArr.length;
        if (length < 1) {
            return new Region[0];
        }
        Region[] regionArr = new Region[length];
        for (int i = 0; i != length; i++) {
            regionArr[i] = convertToRegion(cellRangeAddressArr[i]);
        }
        return regionArr;
    }

    private static Region convertToRegion(CellRangeAddress cellRangeAddress) {
        return new Region(cellRangeAddress.getFirstRow(), (short) cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastRow(), (short) cellRangeAddress.getLastColumn());
    }

    public static CellRangeAddress[] convertRegionsToCellRanges(Region[] regionArr) {
        int length = regionArr.length;
        if (length < 1) {
            return new CellRangeAddress[0];
        }
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[length];
        for (int i = 0; i != length; i++) {
            cellRangeAddressArr[i] = convertToCellRangeAddress(regionArr[i]);
        }
        return cellRangeAddressArr;
    }

    public static CellRangeAddress convertToCellRangeAddress(Region region) {
        return new CellRangeAddress(region.getRowFrom(), region.getRowTo(), region.getColumnFrom(), region.getColumnTo());
    }

    public String getRegionRef() {
        return new CellReference(this._rowFrom, this._colFrom).formatAsString() + ":" + new CellReference(this._rowTo, this._colTo).formatAsString();
    }
}
