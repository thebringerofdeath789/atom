package org.apache.poi.xssf.streaming;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/* loaded from: classes5.dex */
public class SXSSFRow implements Row {
    SXSSFCell[] _cells;
    Boolean _collapsed;
    Boolean _hidden;
    SXSSFSheet _sheet;
    int _maxColumn = -1;
    short _style = -1;
    short _height = -1;
    boolean _zHeight = false;
    int _outlineLevel = 0;

    public SXSSFRow(SXSSFSheet sXSSFSheet, int i) {
        this._sheet = sXSSFSheet;
        this._cells = new SXSSFCell[i];
    }

    public Iterator<Cell> allCellsIterator() {
        return new CellIterator();
    }

    public boolean hasCustomHeight() {
        return this._height != -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this._outlineLevel;
    }

    void setOutlineLevel(int i) {
        this._outlineLevel = i;
    }

    public Boolean getHidden() {
        return this._hidden;
    }

    public void setHidden(Boolean bool) {
        this._hidden = bool;
    }

    public Boolean getCollapsed() {
        return this._collapsed;
    }

    public void setCollapsed(Boolean bool) {
        this._collapsed = bool;
    }

    @Override // java.lang.Iterable
    public Iterator<Cell> iterator() {
        return new FilledCellIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Cell createCell(int i) {
        return createCell(i, 3);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Cell createCell(int i, int i2) {
        checkBounds(i);
        SXSSFCell[] sXSSFCellArr = this._cells;
        if (i >= sXSSFCellArr.length) {
            SXSSFCell[] sXSSFCellArr2 = new SXSSFCell[Math.max(i + 1, sXSSFCellArr.length * 2)];
            SXSSFCell[] sXSSFCellArr3 = this._cells;
            System.arraycopy(sXSSFCellArr3, 0, sXSSFCellArr2, 0, sXSSFCellArr3.length);
            this._cells = sXSSFCellArr2;
        }
        this._cells[i] = new SXSSFCell(this, i2);
        if (i > this._maxColumn) {
            this._maxColumn = i;
        }
        return this._cells[i];
    }

    private static void checkBounds(int i) {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastColumnIndex = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        if (i < 0 || i > lastColumnIndex) {
            throw new IllegalArgumentException("Invalid column index (" + i + ").  Allowable column range for " + spreadsheetVersion.name() + " is (0.." + lastColumnIndex + ") or ('A'..'" + spreadsheetVersion.getLastColumnName() + "')");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        int cellIndex = getCellIndex(cell);
        if (cellIndex < 0) {
            return;
        }
        this._cells[cellIndex] = null;
        while (true) {
            int i = this._maxColumn;
            if (i < 0 || this._cells[i] != null) {
                return;
            } else {
                this._maxColumn = i - 1;
            }
        }
    }

    int getCellIndex(Cell cell) {
        for (int i = 0; i <= this._maxColumn; i++) {
            if (this._cells[i] == cell) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i) {
        this._sheet.changeRowNum(this, i);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this._sheet.getRowNum(this);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Cell getCell(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Cell index must be >= 0");
        }
        SXSSFCell sXSSFCell = i > this._maxColumn ? null : this._cells[i];
        Row.MissingCellPolicy missingCellPolicy = this._sheet.getWorkbook().getMissingCellPolicy();
        if (missingCellPolicy == RETURN_NULL_AND_BLANK) {
            return sXSSFCell;
        }
        if (missingCellPolicy == RETURN_BLANK_AS_NULL) {
            if (sXSSFCell != null && sXSSFCell.getCellType() == 3) {
                return null;
            }
            return sXSSFCell;
        }
        if (missingCellPolicy == CREATE_NULL_AS_BLANK) {
            return sXSSFCell == null ? createCell((short) i, 3) : sXSSFCell;
        }
        throw new IllegalArgumentException("Illegal policy " + missingCellPolicy + " (" + missingCellPolicy.id + ")");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Cell getCell(int i, Row.MissingCellPolicy missingCellPolicy) {
        Cell cell = getCell(i);
        if (missingCellPolicy == RETURN_NULL_AND_BLANK) {
            return cell;
        }
        if (missingCellPolicy == RETURN_BLANK_AS_NULL) {
            if (cell != null && cell.getCellType() == 3) {
                return null;
            }
            return cell;
        }
        if (missingCellPolicy == CREATE_NULL_AS_BLANK) {
            return cell == null ? createCell(i, 3) : cell;
        }
        throw new IllegalArgumentException("Illegal policy " + missingCellPolicy + " (" + missingCellPolicy.id + ")");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        for (int i = 0; i <= this._maxColumn; i++) {
            if (this._cells[i] != null) {
                return (short) i;
            }
        }
        return (short) -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        int i = this._maxColumn;
        if (i == -1) {
            return (short) -1;
        }
        return (short) (i + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        int i = 0;
        for (int i2 = 0; i2 <= this._maxColumn; i2++) {
            if (this._cells[i2] != null) {
                i++;
            }
        }
        return i;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s) {
        this._height = s;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z) {
        this._zHeight = z;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this._zHeight;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f) {
        if (f == -1.0f) {
            this._height = (short) -1;
        } else {
            this._height = (short) (f * 20.0f);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        return (short) (this._height == -1 ? getSheet().getDefaultRowHeightInPoints() * 20.0f : r0);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        short s = this._height;
        return (float) (s == -1 ? getSheet().getDefaultRowHeightInPoints() : s / 20.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this._style > -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public CellStyle getRowStyle() {
        if (isFormatted()) {
            return getSheet().getWorkbook().getCellStyleAt(this._style);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            this._style = (short) -1;
        } else {
            this._style = cellStyle.getIndex();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return iterator();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Sheet getSheet() {
        return this._sheet;
    }

    public class FilledCellIterator implements Iterator<Cell> {
        int pos;

        FilledCellIterator() {
            this.pos = 0;
            for (int i = 0; i <= SXSSFRow.this._maxColumn; i++) {
                if (SXSSFRow.this._cells[i] != null) {
                    this.pos = i;
                    return;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos <= SXSSFRow.this._maxColumn;
        }

        void advanceToNext() {
            this.pos++;
            while (this.pos <= SXSSFRow.this._maxColumn) {
                SXSSFCell[] sXSSFCellArr = SXSSFRow.this._cells;
                int i = this.pos;
                if (sXSSFCellArr[i] != null) {
                    return;
                } else {
                    this.pos = i + 1;
                }
            }
        }

        @Override // java.util.Iterator
        public Cell next() throws NoSuchElementException {
            if (hasNext()) {
                SXSSFCell sXSSFCell = SXSSFRow.this._cells[this.pos];
                advanceToNext();
                return sXSSFCell;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class CellIterator implements Iterator<Cell> {
        int pos = 0;

        public CellIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos <= SXSSFRow.this._maxColumn;
        }

        @Override // java.util.Iterator
        public Cell next() throws NoSuchElementException {
            if (hasNext()) {
                SXSSFCell[] sXSSFCellArr = SXSSFRow.this._cells;
                int i = this.pos;
                this.pos = i + 1;
                return sXSSFCellArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
