package org.apache.poi.xssf.streaming;

import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* loaded from: classes5.dex */
public class SXSSFSheet implements Sheet, Cloneable {
    XSSFSheet _sh;
    SXSSFWorkbook _workbook;
    SheetDataWriter _writer;
    TreeMap<Integer, SXSSFRow> _rows = new TreeMap<>();
    int _randomAccessWindowSize = 100;
    int outlineLevelRow = 0;

    public SXSSFSheet(SXSSFWorkbook sXSSFWorkbook, XSSFSheet xSSFSheet) throws IOException {
        this._workbook = sXSSFWorkbook;
        this._sh = xSSFSheet;
        this._writer = sXSSFWorkbook.createSheetDataWriter();
        setRandomAccessWindowSize(this._workbook.getRandomAccessWindowSize());
    }

    SheetDataWriter getSheetDataWriter() {
        return this._writer;
    }

    public InputStream getWorksheetXMLInputStream() throws IOException {
        flushRows(0);
        this._writer.close();
        return this._writer.getWorksheetXMLInputStream();
    }

    @Override // java.lang.Iterable
    public Iterator<Row> iterator() {
        return rowIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Row createRow(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (i < 0 || i > lastRowIndex) {
            throw new IllegalArgumentException("Invalid row number (" + i + ") outside allowable range (0.." + lastRowIndex + ")");
        }
        if (i <= this._writer.getLastFlushedRow()) {
            throw new IllegalArgumentException("Attempting to write a row[" + i + "] in the range [0," + this._writer.getLastFlushedRow() + "] that is already written to disk.");
        }
        if (this._sh.getPhysicalNumberOfRows() > 0 && i <= this._sh.getLastRowNum()) {
            throw new IllegalArgumentException("Attempting to write a row[" + i + "] in the range [0," + this._sh.getLastRowNum() + "] that is already written to disk.");
        }
        Row row = i > 0 ? getRow(i - 1) : null;
        int lastCellNum = row != null ? row.getLastCellNum() : 0;
        if (lastCellNum <= 0 && this._writer.getNumberOfFlushedRows() > 0) {
            lastCellNum = this._writer.getNumberOfCellsOfLastFlushedRow();
        }
        if (lastCellNum <= 0) {
            lastCellNum = 10;
        }
        SXSSFRow sXSSFRow = new SXSSFRow(this, lastCellNum);
        this._rows.put(new Integer(i), sXSSFRow);
        if (this._randomAccessWindowSize >= 0) {
            int size = this._rows.size();
            int i2 = this._randomAccessWindowSize;
            if (size > i2) {
                try {
                    flushRows(i2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sXSSFRow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRow(Row row) {
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        Iterator<Map.Entry<Integer, SXSSFRow>> it = this._rows.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == row) {
                it.remove();
                return;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Row getRow(int i) {
        return this._rows.get(new Integer(i));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size() + this._writer.getNumberOfFlushedRows();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getFirstRowNum() {
        if (this._writer.getNumberOfFlushedRows() > 0) {
            return this._writer.getLowestIndexOfFlushedRows();
        }
        if (this._rows.size() == 0) {
            return 0;
        }
        return this._rows.firstKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getLastRowNum() {
        if (this._rows.size() == 0) {
            return 0;
        }
        return this._rows.lastKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnHidden(int i, boolean z) {
        this._sh.setColumnHidden(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnHidden(int i) {
        return this._sh.isColumnHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnWidth(int i, int i2) {
        this._sh.setColumnWidth(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnWidth(int i) {
        return this._sh.getColumnWidth(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i) {
        return this._sh.getColumnWidthInPixels(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i) {
        this._sh.setDefaultColumnWidth(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        return this._sh.getDefaultColumnWidth();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return this._sh.getDefaultRowHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        return this._sh.getDefaultRowHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeight(short s) {
        this._sh.setDefaultRowHeight(s);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f) {
        this._sh.setDefaultRowHeightInPoints(f);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellStyle getColumnStyle(int i) {
        return this._sh.getColumnStyle(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegion(CellRangeAddress cellRangeAddress) {
        return this._sh.addMergedRegion(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z) {
        this._sh.setVerticallyCenter(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z) {
        this._sh.setHorizontallyCenter(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        return this._sh.getHorizontallyCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        return this._sh.getVerticallyCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegion(int i) {
        this._sh.removeMergedRegion(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        return this._sh.getNumMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i) {
        return this._sh.getMergedRegion(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setAutobreaks(boolean z) {
        this._sh.setAutobreaks(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGuts(boolean z) {
        this._sh.setDisplayGuts(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayZeros(boolean z) {
        this._sh.setDisplayZeros(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        return this._sh.isDisplayZeros();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRightToLeft(boolean z) {
        this._sh.setRightToLeft(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRightToLeft() {
        return this._sh.isRightToLeft();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setFitToPage(boolean z) {
        this._sh.setFitToPage(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z) {
        this._sh.setRowSumsBelow(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsRight(boolean z) {
        this._sh.setRowSumsRight(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getAutobreaks() {
        return this._sh.getAutobreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        return this._sh.getDisplayGuts();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getFitToPage() {
        return this._sh.getFitToPage();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        return this._sh.getRowSumsBelow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        return this._sh.getRowSumsRight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        return this._sh.isPrintGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintGridlines(boolean z) {
        this._sh.setPrintGridlines(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PrintSetup getPrintSetup() {
        return this._sh.getPrintSetup();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Header getHeader() {
        return this._sh.getHeader();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Footer getFooter() {
        return this._sh.getFooter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setSelected(boolean z) {
        this._sh.setSelected(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public double getMargin(short s) {
        return this._sh.getMargin(s);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setMargin(short s, double d) {
        this._sh.setMargin(s, d);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getProtect() {
        return this._sh.getProtect();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void protectSheet(String str) {
        this._sh.protectSheet(str);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return this._sh.getScenarioProtect();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setZoom(int i, int i2) {
        this._sh.setZoom(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getTopRow() {
        return this._sh.getTopRow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getLeftCol() {
        return this._sh.getLeftCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(int i, int i2) {
        this._sh.showInPane(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(short s, short s2) {
        this._sh.showInPane(s, s2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z) {
        this._sh.setForceFormulaRecalculation(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        return this._sh.getForceFormulaRecalculation();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i, int i2, int i3) {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i, int i2, int i3, boolean z, boolean z2) {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i, int i2, int i3, int i4) {
        this._sh.createFreezePane(i, i2, i3, i4);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i, int i2) {
        this._sh.createFreezePane(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createSplitPane(int i, int i2, int i3, int i4, int i5) {
        this._sh.createSplitPane(i, i2, i3, i4, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        return this._sh.getPaneInformation();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z) {
        this._sh.setDisplayGridlines(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        return this._sh.isDisplayGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z) {
        this._sh.setDisplayFormulas(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        return this._sh.isDisplayFormulas();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z) {
        this._sh.setDisplayRowColHeadings(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        return this._sh.isDisplayRowColHeadings();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowBreak(int i) {
        this._sh.setRowBreak(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRowBroken(int i) {
        return this._sh.isRowBroken(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRowBreak(int i) {
        this._sh.removeRowBreak(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getRowBreaks() {
        return this._sh.getRowBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this._sh.getColumnBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnBreak(int i) {
        this._sh.setColumnBreak(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnBroken(int i) {
        return this._sh.isColumnBroken(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeColumnBreak(int i) {
        this._sh.removeColumnBreak(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i, boolean z) {
        this._sh.setColumnGroupCollapsed(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupColumn(int i, int i2) {
        this._sh.groupColumn(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupColumn(int i, int i2) {
        this._sh.ungroupColumn(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupRow(int i, int i2) {
        for (SXSSFRow sXSSFRow : this._rows.subMap(Integer.valueOf(i), Integer.valueOf(i2 + 1)).values()) {
            int outlineLevel = sXSSFRow.getOutlineLevel() + 1;
            sXSSFRow.setOutlineLevel(outlineLevel);
            if (outlineLevel > this.outlineLevelRow) {
                this.outlineLevelRow = outlineLevel;
            }
        }
        setWorksheetOutlineLevelRow();
    }

    public void setRowOutlineLevel(int i, int i2) {
        this._rows.get(new Integer(i)).setOutlineLevel(i2);
        if (i2 <= 0 || i2 <= this.outlineLevelRow) {
            return;
        }
        this.outlineLevelRow = i2;
        setWorksheetOutlineLevelRow();
    }

    private void setWorksheetOutlineLevelRow() {
        CTWorksheet cTWorksheet = this._sh.getCTWorksheet();
        CTSheetFormatPr sheetFormatPr = cTWorksheet.isSetSheetFormatPr() ? cTWorksheet.getSheetFormatPr() : cTWorksheet.addNewSheetFormatPr();
        int i = this.outlineLevelRow;
        if (i > 0) {
            sheetFormatPr.setOutlineLevelRow((short) i);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupRow(int i, int i2) {
        this._sh.ungroupRow(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i, boolean z) {
        if (z) {
            collapseRow(i);
            return;
        }
        throw new RuntimeException("Not Implemented");
    }

    private void collapseRow(int i) {
        SXSSFRow sXSSFRow = (SXSSFRow) getRow(i);
        if (sXSSFRow == null) {
            throw new IllegalArgumentException("Invalid row number(" + i + "). Row does not exist.");
        }
        int writeHidden = writeHidden(sXSSFRow, findStartOfRowOutlineGroup(i), true);
        SXSSFRow sXSSFRow2 = (SXSSFRow) getRow(writeHidden);
        if (sXSSFRow2 != null) {
            sXSSFRow2.setCollapsed(true);
        } else {
            ((SXSSFRow) createRow(writeHidden)).setCollapsed(true);
        }
    }

    private int findStartOfRowOutlineGroup(int i) {
        int outlineLevel = ((SXSSFRow) getRow(i)).getOutlineLevel();
        if (outlineLevel == 0) {
            throw new IllegalArgumentException("Outline level is zero for the row (" + i + ").");
        }
        while (getRow(i) != null && ((SXSSFRow) getRow(i)).getOutlineLevel() >= outlineLevel) {
            i--;
        }
        return i + 1;
    }

    private int writeHidden(SXSSFRow sXSSFRow, int i, boolean z) {
        int outlineLevel = sXSSFRow.getOutlineLevel();
        SXSSFRow sXSSFRow2 = (SXSSFRow) getRow(i);
        while (sXSSFRow2 != null && sXSSFRow2.getOutlineLevel() >= outlineLevel) {
            sXSSFRow2.setHidden(Boolean.valueOf(z));
            i++;
            sXSSFRow2 = (SXSSFRow) getRow(i);
        }
        return i;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i, CellStyle cellStyle) {
        this._sh.setDefaultColumnStyle(i, cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i) {
        autoSizeColumn(i, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i, boolean z) {
        double columnWidth = SheetUtil.getColumnWidth(this, i, z);
        if (columnWidth != -1.0d) {
            double d = columnWidth * 256.0d;
            double d2 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            if (d > d2) {
                d = d2;
            }
            setColumnWidth(i, (int) d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Comment getCellComment(int i, int i2) {
        return this._sh.getCellComment(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Drawing createDrawingPatriarch() {
        return this._sh.createDrawingPatriarch();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Workbook getWorkbook() {
        return this._workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        return this._sh.getSheetName();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isSelected() {
        return this._sh.isSelected();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<? extends Cell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        return this._sh.setArrayFormula(str, cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<? extends Cell> removeArrayFormula(Cell cell) {
        return this._sh.removeArrayFormula(cell);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return this._sh.getDataValidationHelper();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<XSSFDataValidation> getDataValidations() {
        return this._sh.getDataValidations();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void addValidationData(DataValidation dataValidation) {
        this._sh.addValidationData(dataValidation);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public AutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        return this._sh.setAutoFilter(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SheetConditionalFormatting getSheetConditionalFormatting() {
        return this._sh.getSheetConditionalFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingRows() {
        return this._sh.getRepeatingRows();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingColumns() {
        return this._sh.getRepeatingColumns();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingRows(CellRangeAddress cellRangeAddress) {
        this._sh.setRepeatingRows(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingColumns(CellRangeAddress cellRangeAddress) {
        this._sh.setRepeatingColumns(cellRangeAddress);
    }

    public void setRandomAccessWindowSize(int i) {
        if (i == 0 || i < -1) {
            throw new IllegalArgumentException("RandomAccessWindowSize must be either -1 or a positive integer");
        }
        this._randomAccessWindowSize = i;
    }

    public void flushRows(int i) throws IOException {
        while (this._rows.size() > i) {
            flushOneRow();
        }
    }

    public void flushRows() throws IOException {
        flushRows(0);
    }

    private void flushOneRow() throws IOException {
        Integer firstKey = this._rows.firstKey();
        if (firstKey != null) {
            this._writer.writeRow(firstKey.intValue(), this._rows.get(firstKey));
            this._rows.remove(firstKey);
        }
    }

    public void changeRowNum(SXSSFRow sXSSFRow, int i) {
        removeRow(sXSSFRow);
        this._rows.put(new Integer(i), sXSSFRow);
    }

    public int getRowNum(SXSSFRow sXSSFRow) {
        for (Map.Entry<Integer, SXSSFRow> entry : this._rows.entrySet()) {
            if (entry.getValue() == sXSSFRow) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    boolean dispose() {
        return this._writer.dispose();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i) {
        return this._sh.getColumnOutlineLevel(i);
    }
}
