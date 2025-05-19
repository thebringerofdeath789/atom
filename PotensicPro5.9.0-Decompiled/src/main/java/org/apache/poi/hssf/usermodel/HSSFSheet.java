package org.apache.poi.hssf.usermodel;

import androidx.core.view.MotionEventCompat;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.model.DrawingManager2;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.AutoFilterInfoRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.DVRecord;
import org.apache.poi.hssf.record.DrawingRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SCLRecord;
import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.Region;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Configurator;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class HSSFSheet implements Sheet {
    private static final int DEBUG = 1;
    private static final float PX_DEFAULT = 32.0f;
    private static final float PX_MODIFIED = 36.56f;
    protected final InternalWorkbook _book;
    private int _firstrow;
    private int _lastrow;
    private HSSFPatriarch _patriarch;
    private final TreeMap<Integer, HSSFRow> _rows;
    private final InternalSheet _sheet;
    protected final HSSFWorkbook _workbook;
    private static final POILogger log = POILogFactory.getLogger((Class<?>) HSSFSheet.class);
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFSheet.RowInitialCapacity", 20);

    protected HSSFSheet(HSSFWorkbook hSSFWorkbook) {
        this._sheet = InternalSheet.createSheet();
        this._rows = new TreeMap<>();
        this._workbook = hSSFWorkbook;
        this._book = hSSFWorkbook.getWorkbook();
    }

    protected HSSFSheet(HSSFWorkbook hSSFWorkbook, InternalSheet internalSheet) {
        this._sheet = internalSheet;
        this._rows = new TreeMap<>();
        this._workbook = hSSFWorkbook;
        this._book = hSSFWorkbook.getWorkbook();
        setPropertiesFromSheet(internalSheet);
    }

    HSSFSheet cloneSheet(HSSFWorkbook hSSFWorkbook) {
        getDrawingPatriarch();
        HSSFSheet hSSFSheet = new HSSFSheet(hSSFWorkbook, this._sheet.cloneSheet());
        int findFirstRecordLocBySid = hSSFSheet._sheet.findFirstRecordLocBySid((short) 236);
        DrawingRecord drawingRecord = (DrawingRecord) hSSFSheet._sheet.findFirstRecordBySid((short) 236);
        if (drawingRecord != null) {
            hSSFSheet._sheet.getRecords().remove(drawingRecord);
        }
        if (getDrawingPatriarch() != null) {
            HSSFPatriarch createPatriarch = HSSFPatriarch.createPatriarch(getDrawingPatriarch(), hSSFSheet);
            hSSFSheet._sheet.getRecords().add(findFirstRecordLocBySid, createPatriarch._getBoundAggregate());
            hSSFSheet._patriarch = createPatriarch;
        }
        return hSSFSheet;
    }

    protected void preSerialize() {
        HSSFPatriarch hSSFPatriarch = this._patriarch;
        if (hSSFPatriarch != null) {
            hSSFPatriarch.preSerialize();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFWorkbook getWorkbook() {
        return this._workbook;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setPropertiesFromSheet(InternalSheet internalSheet) {
        HSSFRow hSSFRow;
        RowRecord nextRow = internalSheet.getNextRow();
        boolean z = nextRow != null;
        while (nextRow != null) {
            createRowFromRecord(nextRow);
            nextRow = internalSheet.getNextRow();
        }
        Iterator<CellValueRecordInterface> cellValueIterator = internalSheet.getCellValueIterator();
        long currentTimeMillis = System.currentTimeMillis();
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "Time at start of cell creating in HSSF sheet = ", Long.valueOf(currentTimeMillis));
        }
        HSSFRow hSSFRow2 = null;
        while (cellValueIterator.hasNext()) {
            CellValueRecordInterface next = cellValueIterator.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            if ((hSSFRow2 != null && hSSFRow2.getRowNum() == next.getRow()) || (hSSFRow2 = getRow(next.getRow())) != null) {
                hSSFRow = hSSFRow2;
            } else {
                if (z) {
                    throw new RuntimeException("Unexpected missing row when some rows already present");
                }
                RowRecord rowRecord = new RowRecord(next.getRow());
                internalSheet.addRow(rowRecord);
                hSSFRow = createRowFromRecord(rowRecord);
            }
            POILogger pOILogger2 = log;
            if (pOILogger2.check(1)) {
                if (next instanceof Record) {
                    pOILogger2.log(1, "record id = " + Integer.toHexString(((Record) next).getSid()));
                } else {
                    pOILogger2.log(1, "record = " + next);
                }
            }
            hSSFRow.createCellFromRecord(next);
            if (pOILogger2.check(1)) {
                pOILogger2.log(1, "record took ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
        }
        POILogger pOILogger3 = log;
        if (pOILogger3.check(1)) {
            pOILogger3.log(1, "total sheet cell creation took ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFRow createRow(int i) {
        HSSFRow hSSFRow = new HSSFRow(this._workbook, this, i);
        hSSFRow.setHeight(getDefaultRowHeight());
        hSSFRow.getRowRecord().setBadFontHeight(false);
        addRow(hSSFRow, true);
        return hSSFRow;
    }

    private HSSFRow createRowFromRecord(RowRecord rowRecord) {
        HSSFRow hSSFRow = new HSSFRow(this._workbook, this, rowRecord);
        addRow(hSSFRow, false);
        return hSSFRow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRow(Row row) {
        HSSFRow hSSFRow = (HSSFRow) row;
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        Iterator<Cell> it = row.iterator();
        while (it.hasNext()) {
            HSSFCell hSSFCell = (HSSFCell) it.next();
            if (hSSFCell.isPartOfArrayFormulaGroup()) {
                hSSFCell.notifyArrayFormulaChanging("Row[rownum=" + row.getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.");
            }
        }
        if (this._rows.size() > 0) {
            if (this._rows.remove(Integer.valueOf(row.getRowNum())) != row) {
                throw new IllegalArgumentException("Specified row does not belong to this sheet");
            }
            if (hSSFRow.getRowNum() == getLastRowNum()) {
                this._lastrow = findLastRow(this._lastrow);
            }
            if (hSSFRow.getRowNum() == getFirstRowNum()) {
                this._firstrow = findFirstRow(this._firstrow);
            }
            this._sheet.removeRow(hSSFRow.getRowRecord());
        }
    }

    private int findLastRow(int i) {
        if (i < 1) {
            return 0;
        }
        int i2 = i - 1;
        HSSFRow row = getRow(i2);
        while (row == null && i2 > 0) {
            i2--;
            row = getRow(i2);
        }
        if (row == null) {
            return 0;
        }
        return i2;
    }

    private int findFirstRow(int i) {
        int i2 = i + 1;
        HSSFRow row = getRow(i2);
        while (row == null && i2 <= getLastRowNum()) {
            i2++;
            row = getRow(i2);
        }
        if (i2 > getLastRowNum()) {
            return 0;
        }
        return i2;
    }

    private void addRow(HSSFRow hSSFRow, boolean z) {
        this._rows.put(Integer.valueOf(hSSFRow.getRowNum()), hSSFRow);
        if (z) {
            this._sheet.addRow(hSSFRow.getRowRecord());
        }
        boolean z2 = this._rows.size() == 1;
        if (hSSFRow.getRowNum() > getLastRowNum() || z2) {
            this._lastrow = hSSFRow.getRowNum();
        }
        if (hSSFRow.getRowNum() < getFirstRowNum() || z2) {
            this._firstrow = hSSFRow.getRowNum();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFRow getRow(int i) {
        return this._rows.get(Integer.valueOf(i));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getFirstRowNum() {
        return this._firstrow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getLastRowNum() {
        return this._lastrow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<HSSFDataValidation> getDataValidations() {
        DataValidityTable orCreateDataValidityTable = this._sheet.getOrCreateDataValidityTable();
        final ArrayList arrayList = new ArrayList();
        orCreateDataValidityTable.visitContainedRecords(new RecordAggregate.RecordVisitor() { // from class: org.apache.poi.hssf.usermodel.HSSFSheet.1
            private HSSFEvaluationWorkbook book;

            {
                this.book = HSSFEvaluationWorkbook.create(HSSFSheet.this.getWorkbook());
            }

            @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
            public void visitRecord(Record record) {
                if (record instanceof DVRecord) {
                    DVRecord dVRecord = (DVRecord) record;
                    HSSFDataValidation hSSFDataValidation = new HSSFDataValidation(dVRecord.getCellRangeAddress().copy(), DVConstraint.createDVConstraint(dVRecord, this.book));
                    hSSFDataValidation.setErrorStyle(dVRecord.getErrorStyle());
                    hSSFDataValidation.setEmptyCellAllowed(dVRecord.getEmptyCellAllowed());
                    hSSFDataValidation.setSuppressDropDownArrow(dVRecord.getSuppressDropdownArrow());
                    hSSFDataValidation.createPromptBox(dVRecord.getPromptTitle(), dVRecord.getPromptText());
                    hSSFDataValidation.setShowPromptBox(dVRecord.getShowPromptOnCellSelected());
                    hSSFDataValidation.createErrorBox(dVRecord.getErrorTitle(), dVRecord.getErrorText());
                    hSSFDataValidation.setShowErrorBox(dVRecord.getShowErrorOnInvalidValue());
                    arrayList.add(hSSFDataValidation);
                }
            }
        });
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void addValidationData(DataValidation dataValidation) {
        if (dataValidation == null) {
            throw new IllegalArgumentException("objValidation must not be null");
        }
        this._sheet.getOrCreateDataValidityTable().addDataValidation(((HSSFDataValidation) dataValidation).createDVRecord(this));
    }

    public void setColumnHidden(short s, boolean z) {
        setColumnHidden(s & 65535, z);
    }

    public boolean isColumnHidden(short s) {
        return isColumnHidden(s & 65535);
    }

    public void setColumnWidth(short s, short s2) {
        setColumnWidth(s & 65535, s2 & 65535);
    }

    public short getColumnWidth(short s) {
        return (short) getColumnWidth(s & 65535);
    }

    public void setDefaultColumnWidth(short s) {
        setDefaultColumnWidth(s & 65535);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnHidden(int i, boolean z) {
        this._sheet.setColumnHidden(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnHidden(int i) {
        return this._sheet.isColumnHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnWidth(int i, int i2) {
        this._sheet.setColumnWidth(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnWidth(int i) {
        return this._sheet.getColumnWidth(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i) {
        int columnWidth = getColumnWidth(i);
        return columnWidth / (columnWidth == getDefaultColumnWidth() * 256 ? PX_DEFAULT : PX_MODIFIED);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        return this._sheet.getDefaultColumnWidth();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i) {
        this._sheet.setDefaultColumnWidth(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return this._sheet.getDefaultRowHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        return this._sheet.getDefaultRowHeight() / 20.0f;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeight(short s) {
        this._sheet.setDefaultRowHeight(s);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f) {
        this._sheet.setDefaultRowHeight((short) (f * 20.0f));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFCellStyle getColumnStyle(int i) {
        short xFIndexForColAt = this._sheet.getXFIndexForColAt((short) i);
        if (xFIndexForColAt == 15) {
            return null;
        }
        return new HSSFCellStyle(xFIndexForColAt, this._book.getExFormatAt(xFIndexForColAt), this._book);
    }

    public boolean isGridsPrinted() {
        return this._sheet.isGridsPrinted();
    }

    public void setGridsPrinted(boolean z) {
        this._sheet.setGridsPrinted(z);
    }

    public int addMergedRegion(Region region) {
        return this._sheet.addMergedRegion(region.getRowFrom(), region.getColumnFrom(), region.getRowTo(), region.getColumnTo());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegion(CellRangeAddress cellRangeAddress) {
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
        validateArrayFormulas(cellRangeAddress);
        return this._sheet.addMergedRegion(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastRow(), cellRangeAddress.getLastColumn());
    }

    private void validateArrayFormulas(CellRangeAddress cellRangeAddress) {
        HSSFCell cell;
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            for (int i = firstColumn; i <= lastColumn; i++) {
                HSSFRow row = getRow(firstRow);
                if (row != null && (cell = row.getCell(i)) != null && cell.isPartOfArrayFormulaGroup()) {
                    CellRangeAddress arrayFormulaRange = cell.getArrayFormulaRange();
                    if (arrayFormulaRange.getNumberOfCells() > 1 && (arrayFormulaRange.isInRange(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn()) || arrayFormulaRange.isInRange(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn()))) {
                        throw new IllegalStateException("The range " + cellRangeAddress.formatAsString() + " intersects with a multi-cell array formula. You cannot merge cells of an array.");
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z) {
        this._sheet.setUncalced(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        return this._sheet.getUncalced();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z) {
        this._sheet.getPageSettings().getVCenter().setVCenter(z);
    }

    public boolean getVerticallyCenter(boolean z) {
        return getVerticallyCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        return this._sheet.getPageSettings().getVCenter().getVCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z) {
        this._sheet.getPageSettings().getHCenter().setHCenter(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        return this._sheet.getPageSettings().getHCenter().getHCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRightToLeft(boolean z) {
        this._sheet.getWindowTwo().setArabic(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRightToLeft() {
        return this._sheet.getWindowTwo().getArabic();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegion(int i) {
        this._sheet.removeMergedRegion(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        return this._sheet.getNumMergedRegions();
    }

    public org.apache.poi.hssf.util.Region getMergedRegionAt(int i) {
        CellRangeAddress mergedRegion = getMergedRegion(i);
        return new org.apache.poi.hssf.util.Region(mergedRegion.getFirstRow(), (short) mergedRegion.getFirstColumn(), mergedRegion.getLastRow(), (short) mergedRegion.getLastColumn());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i) {
        return this._sheet.getMergedRegionAt(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Row> iterator() {
        return rowIterator();
    }

    InternalSheet getSheet() {
        return this._sheet;
    }

    public void setAlternativeExpression(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setAlternateExpression(z);
    }

    public void setAlternativeFormula(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setAlternateFormula(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setAutobreaks(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setAutobreaks(z);
    }

    public void setDialog(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setDialog(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGuts(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setDisplayGuts(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setFitToPage(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setFitToPage(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z) {
        WSBoolRecord wSBoolRecord = (WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129);
        wSBoolRecord.setRowSumsBelow(z);
        wSBoolRecord.setAlternateExpression(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsRight(boolean z) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setRowSumsRight(z);
    }

    public boolean getAlternateExpression() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getAlternateExpression();
    }

    public boolean getAlternateFormula() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getAlternateFormula();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getAutobreaks() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getAutobreaks();
    }

    public boolean getDialog() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getDialog();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getDisplayGuts();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        return this._sheet.getWindowTwo().getDisplayZeros();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayZeros(boolean z) {
        this._sheet.getWindowTwo().setDisplayZeros(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getFitToPage() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getFitToPage();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getRowSumsBelow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getRowSumsRight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        return getSheet().getPrintGridlines().getPrintGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintGridlines(boolean z) {
        getSheet().getPrintGridlines().setPrintGridlines(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFPrintSetup getPrintSetup() {
        return new HSSFPrintSetup(this._sheet.getPageSettings().getPrintSetup());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFHeader getHeader() {
        return new HSSFHeader(this._sheet.getPageSettings());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFFooter getFooter() {
        return new HSSFFooter(this._sheet.getPageSettings());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isSelected() {
        return getSheet().getWindowTwo().getSelected();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setSelected(boolean z) {
        getSheet().getWindowTwo().setSelected(z);
    }

    public boolean isActive() {
        return getSheet().getWindowTwo().isActive();
    }

    public void setActive(boolean z) {
        getSheet().getWindowTwo().setActive(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public double getMargin(short s) {
        if (s == 4) {
            return this._sheet.getPageSettings().getPrintSetup().getHeaderMargin();
        }
        if (s == 5) {
            return this._sheet.getPageSettings().getPrintSetup().getFooterMargin();
        }
        return this._sheet.getPageSettings().getMargin(s);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setMargin(short s, double d) {
        if (s == 4) {
            this._sheet.getPageSettings().getPrintSetup().setHeaderMargin(d);
        } else if (s == 5) {
            this._sheet.getPageSettings().getPrintSetup().setFooterMargin(d);
        } else {
            this._sheet.getPageSettings().setMargin(s, d);
        }
    }

    private WorksheetProtectionBlock getProtectionBlock() {
        return this._sheet.getProtectionBlock();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getProtect() {
        return getProtectionBlock().isSheetProtected();
    }

    public short getPassword() {
        return (short) getProtectionBlock().getPasswordHash();
    }

    public boolean getObjectProtect() {
        return getProtectionBlock().isObjectProtected();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return getProtectionBlock().isScenarioProtected();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void protectSheet(String str) {
        getProtectionBlock().protectSheet(str, true, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setZoom(int i, int i2) {
        if (i < 1 || i > 65535) {
            throw new IllegalArgumentException("Numerator must be greater than 0 and less than 65536");
        }
        if (i2 < 1 || i2 > 65535) {
            throw new IllegalArgumentException("Denominator must be greater than 0 and less than 65536");
        }
        SCLRecord sCLRecord = new SCLRecord();
        sCLRecord.setNumerator((short) i);
        sCLRecord.setDenominator((short) i2);
        getSheet().setSCLRecord(sCLRecord);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getTopRow() {
        return this._sheet.getTopRow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getLeftCol() {
        return this._sheet.getLeftCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(int i, int i2) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i > lastRowIndex) {
            throw new IllegalArgumentException("Maximum row number is " + lastRowIndex);
        }
        showInPane((short) i, (short) i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(short s, short s2) {
        this._sheet.setTopRow(s);
        this._sheet.setLeftCol(s2);
    }

    protected void shiftMerged(int i, int i2, int i3, boolean z) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < getNumMergedRegions()) {
            CellRangeAddress mergedRegion = getMergedRegion(i4);
            boolean z2 = mergedRegion.getFirstRow() >= i || mergedRegion.getLastRow() >= i;
            boolean z3 = mergedRegion.getFirstRow() <= i2 || mergedRegion.getLastRow() <= i2;
            if (z2 && z3 && !SheetUtil.containsCell(mergedRegion, i - 1, 0) && !SheetUtil.containsCell(mergedRegion, i2 + 1, 0)) {
                mergedRegion.setFirstRow(mergedRegion.getFirstRow() + i3);
                mergedRegion.setLastRow(mergedRegion.getLastRow() + i3);
                arrayList.add(mergedRegion);
                removeMergedRegion(i4);
                i4--;
            }
            i4++;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            addMergedRegion((CellRangeAddress) it.next());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i, int i2, int i3) {
        shiftRows(i, i2, i3, false, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i, int i2, int i3, boolean z, boolean z2) {
        shiftRows(i, i2, i3, z, z2, true);
    }

    public void shiftRows(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        int i4;
        int i5;
        if (i3 < 0) {
            i5 = i;
            i4 = 1;
        } else {
            if (i3 <= 0) {
                return;
            }
            i4 = -1;
            i5 = i2;
        }
        if (z3) {
            this._sheet.getNoteRecords();
        } else {
            NoteRecord[] noteRecordArr = NoteRecord.EMPTY_ARRAY;
        }
        shiftMerged(i, i2, i3, true);
        this._sheet.getPageSettings().shiftRowBreaks(i, i2, i3);
        while (i5 >= i && i5 <= i2 && i5 >= 0 && i5 < 65536) {
            HSSFRow row = getRow(i5);
            if (row != null) {
                notifyRowShifting(row);
            }
            int i6 = i5 + i3;
            HSSFRow row2 = getRow(i6);
            if (row2 == null) {
                row2 = createRow(i6);
            }
            row2.removeAllCells();
            if (row != null) {
                if (z) {
                    row2.setHeight(row.getHeight());
                }
                if (z2) {
                    row.setHeight((short) 255);
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    HSSFCell hSSFCell = (HSSFCell) cellIterator.next();
                    row.removeCell(hSSFCell);
                    CellValueRecordInterface cellValueRecord = hSSFCell.getCellValueRecord();
                    cellValueRecord.setRow(i6);
                    row2.createCellFromRecord(cellValueRecord);
                    this._sheet.addValueRecord(i6, cellValueRecord);
                    HSSFHyperlink hyperlink = hSSFCell.getHyperlink();
                    if (hyperlink != null) {
                        hyperlink.setFirstRow(hyperlink.getFirstRow() + i3);
                        hyperlink.setLastRow(hyperlink.getLastRow() + i3);
                    }
                }
                row.removeAllCells();
                if (z3) {
                    HSSFPatriarch createDrawingPatriarch = createDrawingPatriarch();
                    for (int size = createDrawingPatriarch.getChildren().size() - 1; size >= 0; size--) {
                        HSSFShape hSSFShape = createDrawingPatriarch.getChildren().get(size);
                        if (hSSFShape instanceof HSSFComment) {
                            HSSFComment hSSFComment = (HSSFComment) hSSFShape;
                            if (hSSFComment.getRow() == i5) {
                                hSSFComment.setRow(i6);
                            }
                        }
                    }
                }
            }
            i5 += i4;
        }
        if (i3 > 0) {
            if (i == this._firstrow) {
                int i7 = i + i3;
                this._firstrow = Math.max(i7, 0);
                int i8 = i + 1;
                while (true) {
                    if (i8 >= i7) {
                        break;
                    }
                    if (getRow(i8) != null) {
                        this._firstrow = i8;
                        break;
                    }
                    i8++;
                }
            }
            int i9 = i2 + i3;
            if (i9 > this._lastrow) {
                this._lastrow = Math.min(i9, SpreadsheetVersion.EXCEL97.getLastRowIndex());
            }
        } else {
            int i10 = i + i3;
            if (i10 < this._firstrow) {
                this._firstrow = Math.max(i10, 0);
            }
            if (i2 == this._lastrow) {
                int i11 = i2 + i3;
                this._lastrow = Math.min(i11, SpreadsheetVersion.EXCEL97.getLastRowIndex());
                int i12 = i2 - 1;
                while (true) {
                    if (i12 <= i11) {
                        break;
                    }
                    if (getRow(i12) != null) {
                        this._lastrow = i12;
                        break;
                    }
                    i12++;
                }
            }
        }
        int sheetIndex = this._workbook.getSheetIndex(this);
        String sheetName = this._workbook.getSheetName(sheetIndex);
        short checkExternSheet = this._book.checkExternSheet(sheetIndex);
        FormulaShifter createForRowShift = FormulaShifter.createForRowShift(checkExternSheet, sheetName, i, i2, i3);
        this._sheet.updateFormulasAfterCellShift(createForRowShift, checkExternSheet);
        int numberOfSheets = this._workbook.getNumberOfSheets();
        for (int i13 = 0; i13 < numberOfSheets; i13++) {
            InternalSheet sheet = this._workbook.getSheetAt(i13).getSheet();
            if (sheet != this._sheet) {
                sheet.updateFormulasAfterCellShift(createForRowShift, this._book.checkExternSheet(i13));
            }
        }
        this._workbook.getWorkbook().updateNamesAfterCellShift(createForRowShift);
    }

    protected void insertChartRecords(List<Record> list) {
        this._sheet.getRecords().addAll(this._sheet.findFirstRecordLocBySid((short) 574), list);
    }

    private void notifyRowShifting(HSSFRow hSSFRow) {
        String str = "Row[rownum=" + hSSFRow.getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.";
        Iterator<Cell> it = hSSFRow.iterator();
        while (it.hasNext()) {
            HSSFCell hSSFCell = (HSSFCell) it.next();
            if (hSSFCell.isPartOfArrayFormulaGroup()) {
                hSSFCell.notifyArrayFormulaChanging(str);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i, int i2, int i3, int i4) {
        validateColumn(i);
        validateRow(i2);
        if (i3 < i) {
            throw new IllegalArgumentException("leftmostColumn parameter must not be less than colSplit parameter");
        }
        if (i4 < i2) {
            throw new IllegalArgumentException("topRow parameter must not be less than leftmostColumn parameter");
        }
        getSheet().createFreezePane(i, i2, i4, i3);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i, int i2) {
        createFreezePane(i, i2, i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createSplitPane(int i, int i2, int i3, int i4, int i5) {
        getSheet().createSplitPane(i, i2, i4, i3, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        return getSheet().getPaneInformation();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z) {
        this._sheet.setDisplayGridlines(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        return this._sheet.isDisplayGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z) {
        this._sheet.setDisplayFormulas(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        return this._sheet.isDisplayFormulas();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z) {
        this._sheet.setDisplayRowColHeadings(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        return this._sheet.isDisplayRowColHeadings();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowBreak(int i) {
        validateRow(i);
        this._sheet.getPageSettings().setRowBreak(i, (short) 0, (short) 255);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRowBroken(int i) {
        return this._sheet.getPageSettings().isRowBroken(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRowBreak(int i) {
        this._sheet.getPageSettings().removeRowBreak(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getRowBreaks() {
        return this._sheet.getPageSettings().getRowBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this._sheet.getPageSettings().getColumnBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnBreak(int i) {
        short s = (short) i;
        validateColumn(s);
        this._sheet.getPageSettings().setColumnBreak(s, (short) 0, (short) SpreadsheetVersion.EXCEL97.getLastRowIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnBroken(int i) {
        return this._sheet.getPageSettings().isColumnBroken(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeColumnBreak(int i) {
        this._sheet.getPageSettings().removeColumnBreak(i);
    }

    protected void validateRow(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i > lastRowIndex) {
            throw new IllegalArgumentException("Maximum row number is " + lastRowIndex);
        }
        if (i < 0) {
            throw new IllegalArgumentException("Minumum row number is 0");
        }
    }

    protected void validateColumn(int i) {
        int lastColumnIndex = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
        if (i > lastColumnIndex) {
            throw new IllegalArgumentException("Maximum column number is " + lastColumnIndex);
        }
        if (i < 0) {
            throw new IllegalArgumentException("Minimum column number is 0");
        }
    }

    public void dumpDrawingRecords(boolean z) {
        this._sheet.aggregateDrawingRecords(this._book.getDrawingManager(), false);
        List<EscherRecord> escherRecords = ((EscherAggregate) getSheet().findFirstRecordBySid(EscherAggregate.sid)).getEscherRecords();
        PrintWriter printWriter = new PrintWriter(System.out);
        for (EscherRecord escherRecord : escherRecords) {
            if (z) {
                System.out.println(escherRecord.toString());
            } else {
                escherRecord.display(printWriter, 0);
            }
        }
        printWriter.flush();
    }

    public EscherAggregate getDrawingEscherAggregate() {
        this._book.findDrawingGroup();
        if (this._book.getDrawingManager() == null || this._sheet.aggregateDrawingRecords(this._book.getDrawingManager(), false) == -1) {
            return null;
        }
        return (EscherAggregate) this._sheet.findFirstRecordBySid(EscherAggregate.sid);
    }

    public HSSFPatriarch getDrawingPatriarch() {
        HSSFPatriarch patriarch = getPatriarch(false);
        this._patriarch = patriarch;
        return patriarch;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFPatriarch createDrawingPatriarch() {
        HSSFPatriarch patriarch = getPatriarch(true);
        this._patriarch = patriarch;
        return patriarch;
    }

    private HSSFPatriarch getPatriarch(boolean z) {
        HSSFPatriarch hSSFPatriarch = this._patriarch;
        if (hSSFPatriarch != null) {
            return hSSFPatriarch;
        }
        DrawingManager2 findDrawingGroup = this._book.findDrawingGroup();
        if (findDrawingGroup == null) {
            if (!z) {
                return null;
            }
            this._book.createDrawingGroup();
            findDrawingGroup = this._book.getDrawingManager();
        }
        EscherAggregate escherAggregate = (EscherAggregate) this._sheet.findFirstRecordBySid(EscherAggregate.sid);
        if (escherAggregate == null) {
            int aggregateDrawingRecords = this._sheet.aggregateDrawingRecords(findDrawingGroup, false);
            if (-1 == aggregateDrawingRecords) {
                if (!z) {
                    return null;
                }
                HSSFPatriarch hSSFPatriarch2 = new HSSFPatriarch(this, (EscherAggregate) this._sheet.getRecords().get(this._sheet.aggregateDrawingRecords(findDrawingGroup, true)));
                hSSFPatriarch2.afterCreate();
                return hSSFPatriarch2;
            }
            escherAggregate = (EscherAggregate) this._sheet.getRecords().get(aggregateDrawingRecords);
        }
        return new HSSFPatriarch(this, escherAggregate);
    }

    public void setColumnGroupCollapsed(short s, boolean z) {
        setColumnGroupCollapsed(s & 65535, z);
    }

    public void groupColumn(short s, short s2) {
        groupColumn(s & 65535, s2 & 65535);
    }

    public void ungroupColumn(short s, short s2) {
        ungroupColumn(s & 65535, s2 & 65535);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i, boolean z) {
        this._sheet.setColumnGroupCollapsed(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupColumn(int i, int i2) {
        this._sheet.groupColumnRange(i, i2, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupColumn(int i, int i2) {
        this._sheet.groupColumnRange(i, i2, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupRow(int i, int i2) {
        this._sheet.groupRowRange(i, i2, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupRow(int i, int i2) {
        this._sheet.groupRowRange(i, i2, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i, boolean z) {
        if (z) {
            this._sheet.getRowsAggregate().collapseRow(i);
        } else {
            this._sheet.getRowsAggregate().expandRow(i);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i, CellStyle cellStyle) {
        this._sheet.setDefaultColumnStyle(i, ((HSSFCellStyle) cellStyle).getIndex());
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
    public HSSFComment getCellComment(int i, int i2) {
        return findCellComment(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new HSSFSheetConditionalFormatting(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        HSSFWorkbook workbook = getWorkbook();
        return workbook.getSheetName(workbook.getSheetIndex(this));
    }

    private CellRange<HSSFCell> getCellRange(CellRangeAddress cellRangeAddress) {
        int firstRow = cellRangeAddress.getFirstRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        int i = (lastRow - firstRow) + 1;
        int i2 = (lastColumn - firstColumn) + 1;
        ArrayList arrayList = new ArrayList(i * i2);
        for (int i3 = firstRow; i3 <= lastRow; i3++) {
            for (int i4 = firstColumn; i4 <= lastColumn; i4++) {
                HSSFRow row = getRow(i3);
                if (row == null) {
                    row = createRow(i3);
                }
                HSSFCell cell = row.getCell(i4);
                if (cell == null) {
                    cell = row.createCell(i4);
                }
                arrayList.add(cell);
            }
        }
        return SSCellRange.create(firstRow, firstColumn, i, i2, arrayList, HSSFCell.class);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<HSSFCell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        Ptg[] parse = HSSFFormulaParser.parse(str, this._workbook, 2, this._workbook.getSheetIndex(this));
        CellRange<HSSFCell> cellRange = getCellRange(cellRangeAddress);
        Iterator<HSSFCell> it = cellRange.iterator();
        while (it.hasNext()) {
            it.next().setCellArrayFormula(cellRangeAddress);
        }
        ((FormulaRecordAggregate) cellRange.getTopLeftCell().getCellValueRecord()).setArrayFormula(cellRangeAddress, parse);
        return cellRange;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<HSSFCell> removeArrayFormula(Cell cell) {
        if (cell.getSheet() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
        }
        CellValueRecordInterface cellValueRecord = ((HSSFCell) cell).getCellValueRecord();
        if (!(cellValueRecord instanceof FormulaRecordAggregate)) {
            throw new IllegalArgumentException("Cell " + new CellReference(cell).formatAsString() + " is not part of an array formula.");
        }
        CellRange<HSSFCell> cellRange = getCellRange(((FormulaRecordAggregate) cellValueRecord).removeArrayFormula(cell.getRowIndex(), cell.getColumnIndex()));
        Iterator<HSSFCell> it = cellRange.iterator();
        while (it.hasNext()) {
            it.next().setCellType(3);
        }
        return cellRange;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return new HSSFDataValidationHelper(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFAutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        InternalWorkbook workbook = this._workbook.getWorkbook();
        int sheetIndex = this._workbook.getSheetIndex(this);
        int i = sheetIndex + 1;
        NameRecord specificBuiltinRecord = workbook.getSpecificBuiltinRecord((byte) 13, i);
        if (specificBuiltinRecord == null) {
            specificBuiltinRecord = workbook.createBuiltInName((byte) 13, i);
        }
        NameRecord nameRecord = specificBuiltinRecord;
        int firstRow = cellRangeAddress.getFirstRow();
        if (firstRow == -1) {
            firstRow = 0;
        }
        nameRecord.setNameDefinition(new Ptg[]{new Area3DPtg(firstRow, cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), false, false, false, false, sheetIndex)});
        AutoFilterInfoRecord autoFilterInfoRecord = new AutoFilterInfoRecord();
        autoFilterInfoRecord.setNumEntries((short) ((cellRangeAddress.getLastColumn() + 1) - cellRangeAddress.getFirstColumn()));
        this._sheet.getRecords().add(this._sheet.findFirstRecordLocBySid((short) 512), autoFilterInfoRecord);
        HSSFPatriarch createDrawingPatriarch = createDrawingPatriarch();
        int firstColumn = cellRangeAddress.getFirstColumn();
        while (firstColumn <= cellRangeAddress.getLastColumn()) {
            short s = (short) firstColumn;
            firstColumn++;
            createDrawingPatriarch.createComboBox(new HSSFClientAnchor(0, 0, 0, 0, s, firstRow, (short) firstColumn, firstRow + 1));
        }
        return new HSSFAutoFilter(this);
    }

    protected HSSFComment findCellComment(int i, int i2) {
        HSSFPatriarch drawingPatriarch = getDrawingPatriarch();
        if (drawingPatriarch == null) {
            drawingPatriarch = createDrawingPatriarch();
        }
        return lookForComment(drawingPatriarch, i, i2);
    }

    private HSSFComment lookForComment(HSSFShapeContainer hSSFShapeContainer, int i, int i2) {
        for (Object obj : hSSFShapeContainer.getChildren()) {
            if (obj instanceof HSSFShapeGroup) {
                HSSFComment lookForComment = lookForComment((HSSFShapeContainer) obj, i, i2);
                if (lookForComment != null) {
                    return lookForComment;
                }
            } else if (obj instanceof HSSFComment) {
                HSSFComment hSSFComment = (HSSFComment) obj;
                if (hSSFComment.hasPosition() && hSSFComment.getColumn() == i2 && hSSFComment.getRow() == i) {
                    return hSSFComment;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingRows() {
        return getRepeatingRowsOrColums(true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingColumns() {
        return getRepeatingRowsOrColums(false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingRows(CellRangeAddress cellRangeAddress) {
        setRepeatingRowsAndColumns(cellRangeAddress, getRepeatingColumns());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingColumns(CellRangeAddress cellRangeAddress) {
        setRepeatingRowsAndColumns(getRepeatingRows(), cellRangeAddress);
    }

    private void setRepeatingRowsAndColumns(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        boolean z;
        int sheetIndex = this._workbook.getSheetIndex(this);
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        int lastColumnIndex = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
        if (cellRangeAddress != null) {
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            if ((firstRow == -1 && lastRow != -1) || firstRow > lastRow || firstRow < 0 || firstRow > lastRowIndex || lastRow < 0 || lastRow > lastRowIndex) {
                throw new IllegalArgumentException("Invalid row range specification");
            }
            i = firstRow;
            i2 = lastRow;
        } else {
            i = -1;
            i2 = -1;
        }
        if (cellRangeAddress2 != null) {
            int firstColumn = cellRangeAddress2.getFirstColumn();
            int lastColumn = cellRangeAddress2.getLastColumn();
            if ((firstColumn == -1 && lastColumn != -1) || firstColumn > lastColumn || firstColumn < 0 || firstColumn > lastColumnIndex || lastColumn < 0 || lastColumn > lastColumnIndex) {
                throw new IllegalArgumentException("Invalid column range specification");
            }
            i4 = lastColumn;
            i3 = firstColumn;
        } else {
            i3 = -1;
            i4 = -1;
        }
        short checkExternSheet = this._workbook.getWorkbook().checkExternSheet(sheetIndex);
        boolean z2 = (cellRangeAddress == null || cellRangeAddress2 == null) ? false : true;
        boolean z3 = cellRangeAddress == null && cellRangeAddress2 == null;
        HSSFName builtInName = this._workbook.getBuiltInName((byte) 7, sheetIndex);
        if (z3) {
            if (builtInName != null) {
                this._workbook.removeName(builtInName);
                return;
            }
            return;
        }
        if (builtInName == null) {
            builtInName = this._workbook.createBuiltInName((byte) 7, sheetIndex);
        }
        HSSFName hSSFName = builtInName;
        ArrayList arrayList2 = new ArrayList();
        if (z2) {
            arrayList2.add(new MemFuncPtg(23));
        }
        if (cellRangeAddress2 != null) {
            z = true;
            arrayList = arrayList2;
            arrayList.add(new Area3DPtg(0, lastRowIndex, i3, i4, false, false, false, false, checkExternSheet));
        } else {
            arrayList = arrayList2;
            z = true;
        }
        if (cellRangeAddress != null) {
            arrayList.add(new Area3DPtg(i, i2, 0, lastColumnIndex, false, false, false, false, checkExternSheet));
        }
        if (z2) {
            arrayList.add(UnionPtg.instance);
        }
        Ptg[] ptgArr = new Ptg[arrayList.size()];
        arrayList.toArray(ptgArr);
        hSSFName.setNameDefinition(ptgArr);
        getPrintSetup().setValidSettings(false);
        setActive(z);
    }

    private CellRangeAddress getRepeatingRowsOrColums(boolean z) {
        Ptg[] nameDefinition;
        NameRecord builtinNameRecord = getBuiltinNameRecord((byte) 7);
        if (builtinNameRecord == null || (nameDefinition = builtinNameRecord.getNameDefinition()) == null) {
            return null;
        }
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        int lastColumnIndex = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
        for (Ptg ptg : nameDefinition) {
            if (ptg instanceof Area3DPtg) {
                Area3DPtg area3DPtg = (Area3DPtg) ptg;
                if (area3DPtg.getFirstColumn() == 0 && area3DPtg.getLastColumn() == lastColumnIndex) {
                    if (z) {
                        return new CellRangeAddress(area3DPtg.getFirstRow(), area3DPtg.getLastRow(), -1, -1);
                    }
                } else if (area3DPtg.getFirstRow() == 0 && area3DPtg.getLastRow() == lastRowIndex && !z) {
                    return new CellRangeAddress(-1, -1, area3DPtg.getFirstColumn(), area3DPtg.getLastColumn());
                }
            }
        }
        return null;
    }

    private NameRecord getBuiltinNameRecord(byte b) {
        int findExistingBuiltinNameRecordIdx = this._workbook.findExistingBuiltinNameRecordIdx(this._workbook.getSheetIndex(this), b);
        if (findExistingBuiltinNameRecordIdx == -1) {
            return null;
        }
        return this._workbook.getNameRecord(findExistingBuiltinNameRecordIdx);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i) {
        return this._sheet.getColumnOutlineLevel(i);
    }
}
