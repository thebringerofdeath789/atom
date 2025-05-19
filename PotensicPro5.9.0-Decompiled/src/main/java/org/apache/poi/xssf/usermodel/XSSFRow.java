package org.apache.poi.xssf.usermodel;

import java.util.Iterator;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

/* loaded from: classes5.dex */
public class XSSFRow implements Row, Comparable<XSSFRow> {
    private final TreeMap<Integer, XSSFCell> _cells = new TreeMap<>();
    private final CTRow _row;
    private final XSSFSheet _sheet;

    protected XSSFRow(CTRow cTRow, XSSFSheet xSSFSheet) {
        this._row = cTRow;
        this._sheet = xSSFSheet;
        for (CTCell cTCell : cTRow.getCArray()) {
            XSSFCell xSSFCell = new XSSFCell(this, cTCell);
            this._cells.put(Integer.valueOf(xSSFCell.getColumnIndex()), xSSFCell);
            xSSFSheet.onReadCell(xSSFCell);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return this._cells.values().iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Cell> iterator() {
        return cellIterator();
    }

    @Override // java.lang.Comparable
    public int compareTo(XSSFRow xSSFRow) {
        int rowNum = getRowNum();
        if (xSSFRow.getSheet() != getSheet()) {
            throw new IllegalArgumentException("The compared rows must belong to the same XSSFSheet");
        }
        int rowNum2 = xSSFRow.getRowNum();
        if (rowNum < rowNum2) {
            return -1;
        }
        return rowNum == rowNum2 ? 0 : 1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i) {
        return createCell(i, 3);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i, int i2) {
        CTCell addNewC;
        XSSFCell xSSFCell = this._cells.get(Integer.valueOf(i));
        if (xSSFCell != null) {
            addNewC = xSSFCell.getCTCell();
            addNewC.set(CTCell.Factory.newInstance());
        } else {
            addNewC = this._row.addNewC();
        }
        XSSFCell xSSFCell2 = new XSSFCell(this, addNewC);
        xSSFCell2.setCellNum(i);
        if (i2 != 3) {
            xSSFCell2.setCellType(i2);
        }
        this._cells.put(Integer.valueOf(i), xSSFCell2);
        return xSSFCell2;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int i) {
        return getCell(i, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int i, Row.MissingCellPolicy missingCellPolicy) {
        if (i < 0) {
            throw new IllegalArgumentException("Cell index must be >= 0");
        }
        XSSFCell xSSFCell = this._cells.get(Integer.valueOf(i));
        if (missingCellPolicy == RETURN_NULL_AND_BLANK) {
            return xSSFCell;
        }
        if (missingCellPolicy == RETURN_BLANK_AS_NULL) {
            if (xSSFCell != null && xSSFCell.getCellType() == 3) {
                return null;
            }
            return xSSFCell;
        }
        if (missingCellPolicy == CREATE_NULL_AS_BLANK) {
            return xSSFCell == null ? createCell((int) ((short) i), 3) : xSSFCell;
        }
        throw new IllegalArgumentException("Illegal policy " + missingCellPolicy + " (" + missingCellPolicy.id + ")");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        return (short) (this._cells.size() == 0 ? -1 : this._cells.firstKey().intValue());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        return (short) (this._cells.size() == 0 ? -1 : this._cells.lastKey().intValue() + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        return (short) (getHeightInPoints() * 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        if (this._row.isSetHt()) {
            return (float) this._row.getHt();
        }
        return this._sheet.getDefaultRowHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s) {
        if (s == -1) {
            if (this._row.isSetHt()) {
                this._row.unsetHt();
            }
            if (this._row.isSetCustomHeight()) {
                this._row.unsetCustomHeight();
                return;
            }
            return;
        }
        this._row.setHt(s / 20.0d);
        this._row.setCustomHeight(true);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f) {
        setHeight((short) (f != -1.0f ? 20.0f * f : -1.0f));
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return (int) (this._row.getR() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (i < 0 || i > lastRowIndex) {
            throw new IllegalArgumentException("Invalid row number (" + i + ") outside allowable range (0.." + lastRowIndex + ")");
        }
        this._row.setR(i + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this._row.getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z) {
        this._row.setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this._row.isSetS();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCellStyle getRowStyle() {
        if (!isFormatted()) {
            return null;
        }
        StylesTable stylesSource = getSheet().getWorkbook().getStylesSource();
        if (stylesSource.getNumCellStyles() > 0) {
            return stylesSource.getStyleAt((int) this._row.getS());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            if (this._row.isSetS()) {
                this._row.unsetS();
                this._row.unsetCustomFormat();
                return;
            }
            return;
        }
        XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
        xSSFCellStyle.verifyBelongsToStylesSource(getSheet().getWorkbook().getStylesSource());
        this._row.setS(r0.putStyle(xSSFCellStyle));
        this._row.setCustomFormat(true);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        if (cell.getRow() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this row");
        }
        XSSFCell xSSFCell = (XSSFCell) cell;
        if (xSSFCell.isPartOfArrayFormulaGroup()) {
            xSSFCell.notifyArrayFormulaChanging();
        }
        if (cell.getCellType() == 2) {
            this._sheet.getWorkbook().onDeleteFormula(xSSFCell);
        }
        this._cells.remove(Integer.valueOf(cell.getColumnIndex()));
    }

    @Internal
    public CTRow getCTRow() {
        return this._row;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDocumentWrite() {
        /*
            r7 = this;
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow r0 = r7._row
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell[] r0 = r0.getCArray()
            int r1 = r0.length
            java.util.TreeMap<java.lang.Integer, org.apache.poi.xssf.usermodel.XSSFCell> r2 = r7._cells
            int r2 = r2.size()
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L13
        L11:
            r0 = r4
            goto L49
        L13:
            java.util.TreeMap<java.lang.Integer, org.apache.poi.xssf.usermodel.XSSFCell> r1 = r7._cells
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
            r2 = r4
        L1e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L48
            java.lang.Object r5 = r1.next()
            org.apache.poi.xssf.usermodel.XSSFCell r5 = (org.apache.poi.xssf.usermodel.XSSFCell) r5
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell r5 = r5.getCTCell()
            int r6 = r2 + 1
            r2 = r0[r2]
            java.lang.String r5 = r5.getR()
            java.lang.String r2 = r2.getR()
            if (r5 != 0) goto L3f
            if (r2 != 0) goto L11
            goto L46
        L3f:
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L46
            goto L11
        L46:
            r2 = r6
            goto L1e
        L48:
            r0 = r3
        L49:
            if (r0 != 0) goto L81
            java.util.TreeMap<java.lang.Integer, org.apache.poi.xssf.usermodel.XSSFCell> r0 = r7._cells
            int r0 = r0.size()
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell[] r0 = new org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell[r0]
            java.util.TreeMap<java.lang.Integer, org.apache.poi.xssf.usermodel.XSSFCell> r1 = r7._cells
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L5d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L7c
            java.lang.Object r2 = r1.next()
            org.apache.poi.xssf.usermodel.XSSFCell r2 = (org.apache.poi.xssf.usermodel.XSSFCell) r2
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell r5 = r2.getCTCell()
            org.apache.xmlbeans.XmlObject r5 = r5.copy()
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell r5 = (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell) r5
            r0[r4] = r5
            r5 = r0[r4]
            r2.setCTCell(r5)
            int r4 = r4 + r3
            goto L5d
        L7c:
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow r1 = r7._row
            r1.setCArray(r0)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xssf.usermodel.XSSFRow.onDocumentWrite():void");
    }

    public String toString() {
        return this._row.toString();
    }

    protected void shift(int i) {
        int rowNum = getRowNum() + i;
        CalculationChain calculationChain = this._sheet.getWorkbook().getCalculationChain();
        int sheetId = (int) this._sheet.sheet.getSheetId();
        String str = "Row[rownum=" + getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.";
        Iterator<Cell> it = iterator();
        while (it.hasNext()) {
            XSSFCell xSSFCell = (XSSFCell) it.next();
            if (xSSFCell.isPartOfArrayFormulaGroup()) {
                xSSFCell.notifyArrayFormulaChanging(str);
            }
            if (calculationChain != null) {
                calculationChain.removeItem(sheetId, xSSFCell.getReference());
            }
            xSSFCell.getCTCell().setR(new CellReference(rowNum, xSSFCell.getColumnIndex()).formatAsString());
        }
        setRowNum(rowNum);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this._row.getOutlineLevel();
    }
}
