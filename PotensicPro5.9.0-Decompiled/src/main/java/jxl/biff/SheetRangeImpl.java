package jxl.biff;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public class SheetRangeImpl implements Range {
    private int column1;
    private int column2;
    private int row1;
    private int row2;
    private Sheet sheet;

    @Override // jxl.Range
    public int getFirstSheetIndex() {
        return -1;
    }

    @Override // jxl.Range
    public int getLastSheetIndex() {
        return -1;
    }

    public SheetRangeImpl(Sheet sheet, int i, int i2, int i3, int i4) {
        this.sheet = sheet;
        this.row1 = i2;
        this.row2 = i4;
        this.column1 = i;
        this.column2 = i3;
    }

    public SheetRangeImpl(SheetRangeImpl sheetRangeImpl, Sheet sheet) {
        this.sheet = sheet;
        this.row1 = sheetRangeImpl.row1;
        this.row2 = sheetRangeImpl.row2;
        this.column1 = sheetRangeImpl.column1;
        this.column2 = sheetRangeImpl.column2;
    }

    @Override // jxl.Range
    public Cell getTopLeft() {
        return this.sheet.getCell(this.column1, this.row1);
    }

    @Override // jxl.Range
    public Cell getBottomRight() {
        return this.sheet.getCell(this.column2, this.row2);
    }

    public boolean intersects(SheetRangeImpl sheetRangeImpl) {
        if (sheetRangeImpl == this) {
            return true;
        }
        return this.row2 >= sheetRangeImpl.row1 && this.row1 <= sheetRangeImpl.row2 && this.column2 >= sheetRangeImpl.column1 && this.column1 <= sheetRangeImpl.column2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        CellReferenceHelper.getCellReference(this.column1, this.row1, stringBuffer);
        stringBuffer.append(NameUtil.HYPHEN);
        CellReferenceHelper.getCellReference(this.column2, this.row2, stringBuffer);
        return stringBuffer.toString();
    }

    public void insertRow(int i) {
        int i2 = this.row2;
        if (i > i2) {
            return;
        }
        int i3 = this.row1;
        if (i <= i3) {
            this.row1 = i3 + 1;
        }
        if (i <= i2) {
            this.row2 = i2 + 1;
        }
    }

    public void insertColumn(int i) {
        int i2 = this.column2;
        if (i > i2) {
            return;
        }
        int i3 = this.column1;
        if (i <= i3) {
            this.column1 = i3 + 1;
        }
        if (i <= i2) {
            this.column2 = i2 + 1;
        }
    }

    public void removeRow(int i) {
        int i2 = this.row2;
        if (i > i2) {
            return;
        }
        int i3 = this.row1;
        if (i < i3) {
            this.row1 = i3 - 1;
        }
        if (i < i2) {
            this.row2 = i2 - 1;
        }
    }

    public void removeColumn(int i) {
        int i2 = this.column2;
        if (i > i2) {
            return;
        }
        int i3 = this.column1;
        if (i < i3) {
            this.column1 = i3 - 1;
        }
        if (i < i2) {
            this.column2 = i2 - 1;
        }
    }

    public int hashCode() {
        return (((this.row1 ^ 65535) ^ this.row2) ^ this.column1) ^ this.column2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SheetRangeImpl)) {
            return false;
        }
        SheetRangeImpl sheetRangeImpl = (SheetRangeImpl) obj;
        return this.column1 == sheetRangeImpl.column1 && this.column2 == sheetRangeImpl.column2 && this.row1 == sheetRangeImpl.row1 && this.row2 == sheetRangeImpl.row2;
    }
}
