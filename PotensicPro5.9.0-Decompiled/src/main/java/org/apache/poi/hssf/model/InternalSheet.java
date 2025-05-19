package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CalcCountRecord;
import org.apache.poi.hssf.record.CalcModeRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.hssf.record.DefaultColWidthRecord;
import org.apache.poi.hssf.record.DefaultRowHeightRecord;
import org.apache.poi.hssf.record.DeltaRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.DrawingRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.GridsetRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.IterationRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.PaneRecord;
import org.apache.poi.hssf.record.PrintGridlinesRecord;
import org.apache.poi.hssf.record.PrintHeadersRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RecordFormatException;
import org.apache.poi.hssf.record.RefModeRecord;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SCLRecord;
import org.apache.poi.hssf.record.SaveRecalcRecord;
import org.apache.poi.hssf.record.SelectionRecord;
import org.apache.poi.hssf.record.UncalcedRecord;
import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.hssf.record.WindowTwoRecord;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

@Internal
/* loaded from: classes4.dex */
public final class InternalSheet {
    public static final short BottomMargin = 3;
    public static final short LeftMargin = 0;
    public static final byte PANE_LOWER_LEFT = 2;
    public static final byte PANE_LOWER_RIGHT = 0;
    public static final byte PANE_UPPER_LEFT = 3;
    public static final byte PANE_UPPER_RIGHT = 1;
    public static final short RightMargin = 1;
    public static final short TopMargin = 2;
    private static POILogger log = POILogFactory.getLogger((Class<?>) InternalSheet.class);
    ColumnInfoRecordsAggregate _columnInfos;
    private DataValidityTable _dataValidityTable;
    private DimensionsRecord _dimensions;
    private GutsRecord _gutsRecord;
    protected boolean _isUncalced;
    private final MergedCellsTable _mergedCellsTable;
    private final WorksheetProtectionBlock _protectionBlock;
    private PageSettingsBlock _psBlock;
    private List<RecordBase> _records;
    protected final RowRecordsAggregate _rowsAggregate;
    protected SelectionRecord _selection;
    private ConditionalFormattingTable condFormatting;
    protected DefaultColWidthRecord defaultcolwidth;
    protected DefaultRowHeightRecord defaultrowheight;
    protected GridsetRecord gridset;
    protected PrintGridlinesRecord printGridlines;
    private Iterator<RowRecord> rowRecIterator;
    protected WindowTwoRecord windowTwo;

    public static InternalSheet createSheet(RecordStream recordStream) {
        return new InternalSheet(recordStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e6, code lost:
    
        r3 = findFirstRecordLocBySid(574);
        r11 = r0.createDimensions();
        r10._dimensions = r11;
        r1.add(r3, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01dd, code lost:
    
        if (org.apache.poi.hssf.model.InternalSheet.log.check(5) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01df, code lost:
    
        org.apache.poi.hssf.model.InternalSheet.log.log(5, "DIMENSION record not found even though row/cells present");
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f3, code lost:
    
        if (r0 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f5, code lost:
    
        r0 = new org.apache.poi.hssf.record.aggregates.RowRecordsAggregate();
        r1.add(r3 + 1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01fe, code lost:
    
        r10._rowsAggregate = r0;
        org.apache.poi.hssf.model.RecordOrderer.addNewSheetRecord(r1, r10._mergedCellsTable);
        org.apache.poi.hssf.model.RecordOrderer.addNewSheetRecord(r1, r10._protectionBlock);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0210, code lost:
    
        if (org.apache.poi.hssf.model.InternalSheet.log.check(1) == false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0212, code lost:
    
        org.apache.poi.hssf.model.InternalSheet.log.log(1, "sheet createSheet (existing file) exited");
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0219, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0221, code lost:
    
        throw new java.lang.RuntimeException("WINDOW2 was not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01c7, code lost:
    
        if (r10.windowTwo == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01cb, code lost:
    
        if (r10._dimensions != null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01cd, code lost:
    
        if (r0 != null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01cf, code lost:
    
        r0 = new org.apache.poi.hssf.record.aggregates.RowRecordsAggregate();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private InternalSheet(org.apache.poi.hssf.model.RecordStream r11) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hssf.model.InternalSheet.<init>(org.apache.poi.hssf.model.RecordStream):void");
    }

    private static void spillAggregate(RecordAggregate recordAggregate, final List<RecordBase> list) {
        recordAggregate.visitContainedRecords(new RecordAggregate.RecordVisitor() { // from class: org.apache.poi.hssf.model.InternalSheet.1
            @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
            public void visitRecord(Record record) {
                list.add(record);
            }
        });
    }

    public static class UnsupportedBOFType extends RecordFormatException {
        private final int type;

        protected UnsupportedBOFType(int i) {
            super("BOF not of a supported type, found " + i);
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    private static final class RecordCloner implements RecordAggregate.RecordVisitor {
        private final List<Record> _destList;

        public RecordCloner(List<Record> list) {
            this._destList = list;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._destList.add((Record) record.clone());
        }
    }

    public InternalSheet cloneSheet() {
        ArrayList arrayList = new ArrayList(this._records.size());
        for (int i = 0; i < this._records.size(); i++) {
            Object obj = (RecordBase) this._records.get(i);
            if (obj instanceof RecordAggregate) {
                ((RecordAggregate) obj).visitContainedRecords(new RecordCloner(arrayList));
            } else {
                if (obj instanceof EscherAggregate) {
                    obj = new DrawingRecord();
                }
                arrayList.add((Record) ((Record) obj).clone());
            }
        }
        return createSheet(new RecordStream(arrayList, 0));
    }

    public static InternalSheet createSheet() {
        return new InternalSheet();
    }

    private InternalSheet() {
        this.printGridlines = null;
        this.gridset = null;
        this.defaultcolwidth = new DefaultColWidthRecord();
        this.defaultrowheight = new DefaultRowHeightRecord();
        WorksheetProtectionBlock worksheetProtectionBlock = new WorksheetProtectionBlock();
        this._protectionBlock = worksheetProtectionBlock;
        this.windowTwo = null;
        this._selection = null;
        this._dataValidityTable = null;
        this.rowRecIterator = null;
        this._isUncalced = false;
        MergedCellsTable mergedCellsTable = new MergedCellsTable();
        this._mergedCellsTable = mergedCellsTable;
        ArrayList arrayList = new ArrayList(32);
        if (log.check(1)) {
            log.log(1, "Sheet createsheet from scratch called");
        }
        arrayList.add(createBOF());
        arrayList.add(createCalcMode());
        arrayList.add(createCalcCount());
        arrayList.add(createRefMode());
        arrayList.add(createIteration());
        arrayList.add(createDelta());
        arrayList.add(createSaveRecalc());
        arrayList.add(createPrintHeaders());
        PrintGridlinesRecord createPrintGridlines = createPrintGridlines();
        this.printGridlines = createPrintGridlines;
        arrayList.add(createPrintGridlines);
        GridsetRecord createGridset = createGridset();
        this.gridset = createGridset;
        arrayList.add(createGridset);
        GutsRecord createGuts = createGuts();
        this._gutsRecord = createGuts;
        arrayList.add(createGuts);
        DefaultRowHeightRecord createDefaultRowHeight = createDefaultRowHeight();
        this.defaultrowheight = createDefaultRowHeight;
        arrayList.add(createDefaultRowHeight);
        arrayList.add(createWSBool());
        PageSettingsBlock pageSettingsBlock = new PageSettingsBlock();
        this._psBlock = pageSettingsBlock;
        arrayList.add(pageSettingsBlock);
        arrayList.add(worksheetProtectionBlock);
        DefaultColWidthRecord createDefaultColWidth = createDefaultColWidth();
        this.defaultcolwidth = createDefaultColWidth;
        arrayList.add(createDefaultColWidth);
        ColumnInfoRecordsAggregate columnInfoRecordsAggregate = new ColumnInfoRecordsAggregate();
        arrayList.add(columnInfoRecordsAggregate);
        this._columnInfos = columnInfoRecordsAggregate;
        DimensionsRecord createDimensions = createDimensions();
        this._dimensions = createDimensions;
        arrayList.add(createDimensions);
        RowRecordsAggregate rowRecordsAggregate = new RowRecordsAggregate();
        this._rowsAggregate = rowRecordsAggregate;
        arrayList.add(rowRecordsAggregate);
        WindowTwoRecord createWindowTwo = createWindowTwo();
        this.windowTwo = createWindowTwo;
        arrayList.add(createWindowTwo);
        SelectionRecord createSelection = createSelection();
        this._selection = createSelection;
        arrayList.add(createSelection);
        arrayList.add(mergedCellsTable);
        arrayList.add(EOFRecord.instance);
        this._records = arrayList;
        if (log.check(1)) {
            log.log(1, "Sheet createsheet from scratch exit");
        }
    }

    public RowRecordsAggregate getRowsAggregate() {
        return this._rowsAggregate;
    }

    private MergedCellsTable getMergedRecords() {
        return this._mergedCellsTable;
    }

    public void updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i) {
        getRowsAggregate().updateFormulasAfterRowShift(formulaShifter, i);
        if (this.condFormatting != null) {
            getConditionalFormattingTable().updateFormulasAfterCellShift(formulaShifter, i);
        }
    }

    public int addMergedRegion(int i, int i2, int i3, int i4) {
        if (i3 < i) {
            throw new IllegalArgumentException("The 'to' row (" + i3 + ") must not be less than the 'from' row (" + i + ")");
        }
        if (i4 < i2) {
            throw new IllegalArgumentException("The 'to' col (" + i4 + ") must not be less than the 'from' col (" + i2 + ")");
        }
        getMergedRecords().addArea(i, i2, i3, i4);
        return r0.getNumberOfMergedRegions() - 1;
    }

    public void removeMergedRegion(int i) {
        MergedCellsTable mergedRecords = getMergedRecords();
        if (i >= mergedRecords.getNumberOfMergedRegions()) {
            return;
        }
        mergedRecords.remove(i);
    }

    public CellRangeAddress getMergedRegionAt(int i) {
        MergedCellsTable mergedRecords = getMergedRecords();
        if (i >= mergedRecords.getNumberOfMergedRegions()) {
            return null;
        }
        return mergedRecords.get(i);
    }

    public int getNumMergedRegions() {
        return getMergedRecords().getNumberOfMergedRegions();
    }

    public ConditionalFormattingTable getConditionalFormattingTable() {
        if (this.condFormatting == null) {
            ConditionalFormattingTable conditionalFormattingTable = new ConditionalFormattingTable();
            this.condFormatting = conditionalFormattingTable;
            RecordOrderer.addNewSheetRecord(this._records, conditionalFormattingTable);
        }
        return this.condFormatting;
    }

    public void setDimensions(int i, short s, int i2, short s2) {
        if (log.check(1)) {
            log.log(1, "Sheet.setDimensions");
            log.log(1, new StringBuffer("firstrow").append(i).append("firstcol").append((int) s).append("lastrow").append(i2).append("lastcol").append((int) s2).toString());
        }
        this._dimensions.setFirstCol(s);
        this._dimensions.setFirstRow(i);
        this._dimensions.setLastCol(s2);
        this._dimensions.setLastRow(i2);
        if (log.check(1)) {
            log.log(1, "Sheet.setDimensions exiting");
        }
    }

    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor, int i) {
        RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(recordVisitor, i);
        boolean z = false;
        for (int i2 = 0; i2 < this._records.size(); i2++) {
            RecordBase recordBase = this._records.get(i2);
            if (recordBase instanceof RecordAggregate) {
                ((RecordAggregate) recordBase).visitContainedRecords(positionTrackingVisitor);
            } else {
                positionTrackingVisitor.visitRecord((Record) recordBase);
            }
            if ((recordBase instanceof BOFRecord) && !z) {
                if (this._isUncalced) {
                    positionTrackingVisitor.visitRecord(new UncalcedRecord());
                }
                if (this._rowsAggregate != null) {
                    positionTrackingVisitor.visitRecord(this._rowsAggregate.createIndexRecord(positionTrackingVisitor.getPosition(), getSizeOfInitialSheetRecords(i2)));
                }
                z = true;
            }
        }
    }

    private int getSizeOfInitialSheetRecords(int i) {
        int i2 = 0;
        for (int i3 = i + 1; i3 < this._records.size(); i3++) {
            RecordBase recordBase = this._records.get(i3);
            if (recordBase instanceof RowRecordsAggregate) {
                break;
            }
            i2 += recordBase.getRecordSize();
        }
        return this._isUncalced ? i2 + UncalcedRecord.getStaticRecordSize() : i2;
    }

    public void addValueRecord(int i, CellValueRecordInterface cellValueRecordInterface) {
        if (log.check(1)) {
            log.log(1, "add value record  row" + i);
        }
        DimensionsRecord dimensionsRecord = this._dimensions;
        if (cellValueRecordInterface.getColumn() >= dimensionsRecord.getLastCol()) {
            dimensionsRecord.setLastCol((short) (cellValueRecordInterface.getColumn() + 1));
        }
        if (cellValueRecordInterface.getColumn() < dimensionsRecord.getFirstCol()) {
            dimensionsRecord.setFirstCol(cellValueRecordInterface.getColumn());
        }
        this._rowsAggregate.insertCell(cellValueRecordInterface);
    }

    public void removeValueRecord(int i, CellValueRecordInterface cellValueRecordInterface) {
        log.logFormatted(1, "remove value record row %", new int[]{i});
        this._rowsAggregate.removeCell(cellValueRecordInterface);
    }

    public void replaceValueRecord(CellValueRecordInterface cellValueRecordInterface) {
        if (log.check(1)) {
            log.log(1, "replaceValueRecord ");
        }
        this._rowsAggregate.removeCell(cellValueRecordInterface);
        this._rowsAggregate.insertCell(cellValueRecordInterface);
    }

    public void addRow(RowRecord rowRecord) {
        if (log.check(1)) {
            log.log(1, "addRow ");
        }
        DimensionsRecord dimensionsRecord = this._dimensions;
        if (rowRecord.getRowNumber() >= dimensionsRecord.getLastRow()) {
            dimensionsRecord.setLastRow(rowRecord.getRowNumber() + 1);
        }
        if (rowRecord.getRowNumber() < dimensionsRecord.getFirstRow()) {
            dimensionsRecord.setFirstRow(rowRecord.getRowNumber());
        }
        RowRecord row = this._rowsAggregate.getRow(rowRecord.getRowNumber());
        if (row != null) {
            this._rowsAggregate.removeRow(row);
        }
        this._rowsAggregate.insertRow(rowRecord);
        if (log.check(1)) {
            log.log(1, "exit addRow");
        }
    }

    public void removeRow(RowRecord rowRecord) {
        this._rowsAggregate.removeRow(rowRecord);
    }

    public Iterator<CellValueRecordInterface> getCellValueIterator() {
        return this._rowsAggregate.getCellValueIterator();
    }

    @Deprecated
    public CellValueRecordInterface[] getValueRecords() {
        return this._rowsAggregate.getValueRecords();
    }

    public RowRecord getNextRow() {
        if (this.rowRecIterator == null) {
            this.rowRecIterator = this._rowsAggregate.getIterator();
        }
        if (this.rowRecIterator.hasNext()) {
            return this.rowRecIterator.next();
        }
        return null;
    }

    public RowRecord getRow(int i) {
        return this._rowsAggregate.getRow(i);
    }

    static BOFRecord createBOF() {
        BOFRecord bOFRecord = new BOFRecord();
        bOFRecord.setVersion(BOFRecord.VERSION);
        bOFRecord.setType(16);
        bOFRecord.setBuild(3515);
        bOFRecord.setBuildYear(BOFRecord.BUILD_YEAR);
        bOFRecord.setHistoryBitMask(193);
        bOFRecord.setRequiredVersion(6);
        return bOFRecord;
    }

    private static CalcModeRecord createCalcMode() {
        CalcModeRecord calcModeRecord = new CalcModeRecord();
        calcModeRecord.setCalcMode((short) 1);
        return calcModeRecord;
    }

    private static CalcCountRecord createCalcCount() {
        CalcCountRecord calcCountRecord = new CalcCountRecord();
        calcCountRecord.setIterations((short) 100);
        return calcCountRecord;
    }

    private static RefModeRecord createRefMode() {
        RefModeRecord refModeRecord = new RefModeRecord();
        refModeRecord.setMode((short) 1);
        return refModeRecord;
    }

    private static IterationRecord createIteration() {
        return new IterationRecord(false);
    }

    private static DeltaRecord createDelta() {
        return new DeltaRecord(0.001d);
    }

    private static SaveRecalcRecord createSaveRecalc() {
        SaveRecalcRecord saveRecalcRecord = new SaveRecalcRecord();
        saveRecalcRecord.setRecalc(true);
        return saveRecalcRecord;
    }

    private static PrintHeadersRecord createPrintHeaders() {
        PrintHeadersRecord printHeadersRecord = new PrintHeadersRecord();
        printHeadersRecord.setPrintHeaders(false);
        return printHeadersRecord;
    }

    private static PrintGridlinesRecord createPrintGridlines() {
        PrintGridlinesRecord printGridlinesRecord = new PrintGridlinesRecord();
        printGridlinesRecord.setPrintGridlines(false);
        return printGridlinesRecord;
    }

    private static GridsetRecord createGridset() {
        GridsetRecord gridsetRecord = new GridsetRecord();
        gridsetRecord.setGridset(true);
        return gridsetRecord;
    }

    private static GutsRecord createGuts() {
        GutsRecord gutsRecord = new GutsRecord();
        gutsRecord.setLeftRowGutter((short) 0);
        gutsRecord.setTopColGutter((short) 0);
        gutsRecord.setRowLevelMax((short) 0);
        gutsRecord.setColLevelMax((short) 0);
        return gutsRecord;
    }

    private GutsRecord getGutsRecord() {
        if (this._gutsRecord == null) {
            GutsRecord createGuts = createGuts();
            RecordOrderer.addNewSheetRecord(this._records, createGuts);
            this._gutsRecord = createGuts;
        }
        return this._gutsRecord;
    }

    private static DefaultRowHeightRecord createDefaultRowHeight() {
        DefaultRowHeightRecord defaultRowHeightRecord = new DefaultRowHeightRecord();
        defaultRowHeightRecord.setOptionFlags((short) 0);
        defaultRowHeightRecord.setRowHeight((short) 255);
        return defaultRowHeightRecord;
    }

    private static WSBoolRecord createWSBool() {
        WSBoolRecord wSBoolRecord = new WSBoolRecord();
        wSBoolRecord.setWSBool1((byte) 4);
        wSBoolRecord.setWSBool2((byte) -63);
        return wSBoolRecord;
    }

    private static DefaultColWidthRecord createDefaultColWidth() {
        DefaultColWidthRecord defaultColWidthRecord = new DefaultColWidthRecord();
        defaultColWidthRecord.setColWidth(8);
        return defaultColWidthRecord;
    }

    public int getDefaultColumnWidth() {
        return this.defaultcolwidth.getColWidth();
    }

    public boolean isGridsPrinted() {
        if (this.gridset == null) {
            this.gridset = createGridset();
            this._records.add(findFirstRecordLocBySid((short) 10), this.gridset);
        }
        return !this.gridset.getGridset();
    }

    public void setGridsPrinted(boolean z) {
        this.gridset.setGridset(!z);
    }

    public void setDefaultColumnWidth(int i) {
        this.defaultcolwidth.setColWidth(i);
    }

    public void setDefaultRowHeight(short s) {
        this.defaultrowheight.setRowHeight(s);
        this.defaultrowheight.setOptionFlags((short) 1);
    }

    public short getDefaultRowHeight() {
        return this.defaultrowheight.getRowHeight();
    }

    public int getColumnWidth(int i) {
        ColumnInfoRecord findColumnInfo = this._columnInfos.findColumnInfo(i);
        if (findColumnInfo != null) {
            return findColumnInfo.getColumnWidth();
        }
        return this.defaultcolwidth.getColWidth() * 256;
    }

    public short getXFIndexForColAt(short s) {
        ColumnInfoRecord findColumnInfo = this._columnInfos.findColumnInfo(s);
        if (findColumnInfo != null) {
            return (short) findColumnInfo.getXFIndex();
        }
        return (short) 15;
    }

    public void setColumnWidth(int i, int i2) {
        if (i2 > 65280) {
            throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
        }
        setColumn(i, null, Integer.valueOf(i2), null, null, null);
    }

    public boolean isColumnHidden(int i) {
        ColumnInfoRecord findColumnInfo = this._columnInfos.findColumnInfo(i);
        if (findColumnInfo == null) {
            return false;
        }
        return findColumnInfo.getHidden();
    }

    public void setColumnHidden(int i, boolean z) {
        setColumn(i, null, null, null, Boolean.valueOf(z), null);
    }

    public void setDefaultColumnStyle(int i, int i2) {
        setColumn(i, Short.valueOf((short) i2), null, null, null, null);
    }

    private void setColumn(int i, Short sh, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        this._columnInfos.setColumn(i, sh, num, num2, bool, bool2);
    }

    public void groupColumnRange(int i, int i2, boolean z) {
        this._columnInfos.groupColumnRange(i, i2, z);
        int maxOutlineLevel = this._columnInfos.getMaxOutlineLevel();
        GutsRecord gutsRecord = getGutsRecord();
        gutsRecord.setColLevelMax((short) (maxOutlineLevel + 1));
        if (maxOutlineLevel == 0) {
            gutsRecord.setTopColGutter((short) 0);
        } else {
            gutsRecord.setTopColGutter((short) (((maxOutlineLevel - 1) * 12) + 29));
        }
    }

    private static DimensionsRecord createDimensions() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.setFirstCol((short) 0);
        dimensionsRecord.setLastRow(1);
        dimensionsRecord.setFirstRow(0);
        dimensionsRecord.setLastCol((short) 1);
        return dimensionsRecord;
    }

    private static WindowTwoRecord createWindowTwo() {
        WindowTwoRecord windowTwoRecord = new WindowTwoRecord();
        windowTwoRecord.setOptions((short) 1718);
        windowTwoRecord.setTopRow((short) 0);
        windowTwoRecord.setLeftCol((short) 0);
        windowTwoRecord.setHeaderColor(64);
        windowTwoRecord.setPageBreakZoom((short) 0);
        windowTwoRecord.setNormalZoom((short) 0);
        return windowTwoRecord;
    }

    private static SelectionRecord createSelection() {
        return new SelectionRecord(0, 0);
    }

    public short getTopRow() {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord == null) {
            return (short) 0;
        }
        return windowTwoRecord.getTopRow();
    }

    public void setTopRow(short s) {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord != null) {
            windowTwoRecord.setTopRow(s);
        }
    }

    public void setLeftCol(short s) {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord != null) {
            windowTwoRecord.setLeftCol(s);
        }
    }

    public short getLeftCol() {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord == null) {
            return (short) 0;
        }
        return windowTwoRecord.getLeftCol();
    }

    public int getActiveCellRow() {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord == null) {
            return 0;
        }
        return selectionRecord.getActiveCellRow();
    }

    public void setActiveCellRow(int i) {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord != null) {
            selectionRecord.setActiveCellRow(i);
        }
    }

    public short getActiveCellCol() {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord == null) {
            return (short) 0;
        }
        return (short) selectionRecord.getActiveCellCol();
    }

    public void setActiveCellCol(short s) {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord != null) {
            selectionRecord.setActiveCellCol(s);
        }
    }

    public List<RecordBase> getRecords() {
        return this._records;
    }

    public GridsetRecord getGridsetRecord() {
        return this.gridset;
    }

    public Record findFirstRecordBySid(short s) {
        int findFirstRecordLocBySid = findFirstRecordLocBySid(s);
        if (findFirstRecordLocBySid < 0) {
            return null;
        }
        return (Record) this._records.get(findFirstRecordLocBySid);
    }

    public void setSCLRecord(SCLRecord sCLRecord) {
        int findFirstRecordLocBySid = findFirstRecordLocBySid((short) 160);
        if (findFirstRecordLocBySid == -1) {
            this._records.add(findFirstRecordLocBySid((short) 574) + 1, sCLRecord);
        } else {
            this._records.set(findFirstRecordLocBySid, sCLRecord);
        }
    }

    public int findFirstRecordLocBySid(short s) {
        int size = this._records.size();
        for (int i = 0; i < size; i++) {
            RecordBase recordBase = this._records.get(i);
            if ((recordBase instanceof Record) && ((Record) recordBase).getSid() == s) {
                return i;
            }
        }
        return -1;
    }

    public WindowTwoRecord getWindowTwo() {
        return this.windowTwo;
    }

    public PrintGridlinesRecord getPrintGridlines() {
        return this.printGridlines;
    }

    public void setPrintGridlines(PrintGridlinesRecord printGridlinesRecord) {
        this.printGridlines = printGridlinesRecord;
    }

    public void setSelected(boolean z) {
        this.windowTwo.setSelected(z);
    }

    public void createFreezePane(int i, int i2, int i3, int i4) {
        int findFirstRecordLocBySid = findFirstRecordLocBySid((short) 65);
        if (findFirstRecordLocBySid != -1) {
            this._records.remove(findFirstRecordLocBySid);
        }
        if (i == 0 && i2 == 0) {
            this.windowTwo.setFreezePanes(false);
            this.windowTwo.setFreezePanesNoSplit(false);
            ((SelectionRecord) findFirstRecordBySid((short) 29)).setPane((byte) 3);
            return;
        }
        int findFirstRecordLocBySid2 = findFirstRecordLocBySid((short) 574);
        PaneRecord paneRecord = new PaneRecord();
        paneRecord.setX((short) i);
        paneRecord.setY((short) i2);
        paneRecord.setTopRow((short) i3);
        paneRecord.setLeftColumn((short) i4);
        if (i2 == 0) {
            paneRecord.setTopRow((short) 0);
            paneRecord.setActivePane((short) 1);
        } else if (i == 0) {
            paneRecord.setLeftColumn((short) 0);
            paneRecord.setActivePane((short) 2);
        } else {
            paneRecord.setActivePane((short) 0);
        }
        this._records.add(findFirstRecordLocBySid2 + 1, paneRecord);
        this.windowTwo.setFreezePanes(true);
        this.windowTwo.setFreezePanesNoSplit(true);
        ((SelectionRecord) findFirstRecordBySid((short) 29)).setPane((byte) paneRecord.getActivePane());
    }

    public void createSplitPane(int i, int i2, int i3, int i4, int i5) {
        int findFirstRecordLocBySid = findFirstRecordLocBySid((short) 65);
        if (findFirstRecordLocBySid != -1) {
            this._records.remove(findFirstRecordLocBySid);
        }
        int findFirstRecordLocBySid2 = findFirstRecordLocBySid((short) 574);
        PaneRecord paneRecord = new PaneRecord();
        paneRecord.setX((short) i);
        paneRecord.setY((short) i2);
        paneRecord.setTopRow((short) i3);
        paneRecord.setLeftColumn((short) i4);
        paneRecord.setActivePane((short) i5);
        this._records.add(findFirstRecordLocBySid2 + 1, paneRecord);
        this.windowTwo.setFreezePanes(false);
        this.windowTwo.setFreezePanesNoSplit(false);
        ((SelectionRecord) findFirstRecordBySid((short) 29)).setPane((byte) 0);
    }

    public PaneInformation getPaneInformation() {
        PaneRecord paneRecord = (PaneRecord) findFirstRecordBySid((short) 65);
        if (paneRecord == null) {
            return null;
        }
        return new PaneInformation(paneRecord.getX(), paneRecord.getY(), paneRecord.getTopRow(), paneRecord.getLeftColumn(), (byte) paneRecord.getActivePane(), this.windowTwo.getFreezePanes());
    }

    public SelectionRecord getSelection() {
        return this._selection;
    }

    public void setSelection(SelectionRecord selectionRecord) {
        this._selection = selectionRecord;
    }

    public WorksheetProtectionBlock getProtectionBlock() {
        return this._protectionBlock;
    }

    public void setDisplayGridlines(boolean z) {
        this.windowTwo.setDisplayGridlines(z);
    }

    public boolean isDisplayGridlines() {
        return this.windowTwo.getDisplayGridlines();
    }

    public void setDisplayFormulas(boolean z) {
        this.windowTwo.setDisplayFormulas(z);
    }

    public boolean isDisplayFormulas() {
        return this.windowTwo.getDisplayFormulas();
    }

    public void setDisplayRowColHeadings(boolean z) {
        this.windowTwo.setDisplayRowColHeadings(z);
    }

    public boolean isDisplayRowColHeadings() {
        return this.windowTwo.getDisplayRowColHeadings();
    }

    public boolean getUncalced() {
        return this._isUncalced;
    }

    public void setUncalced(boolean z) {
        this._isUncalced = z;
    }

    public int aggregateDrawingRecords(DrawingManager2 drawingManager2, boolean z) {
        int findFirstRecordLocBySid = findFirstRecordLocBySid((short) 236);
        if (!(findFirstRecordLocBySid == -1)) {
            EscherAggregate.createAggregate(getRecords(), findFirstRecordLocBySid);
            return findFirstRecordLocBySid;
        }
        if (!z) {
            return -1;
        }
        EscherAggregate escherAggregate = new EscherAggregate(true);
        int findFirstRecordLocBySid2 = findFirstRecordLocBySid(EscherAggregate.sid);
        if (findFirstRecordLocBySid2 == -1) {
            findFirstRecordLocBySid2 = findFirstRecordLocBySid((short) 574);
        } else {
            getRecords().remove(findFirstRecordLocBySid2);
        }
        getRecords().add(findFirstRecordLocBySid2, escherAggregate);
        return findFirstRecordLocBySid2;
    }

    public void preSerialize() {
        for (RecordBase recordBase : getRecords()) {
            if (recordBase instanceof EscherAggregate) {
                recordBase.getRecordSize();
            }
        }
    }

    public PageSettingsBlock getPageSettings() {
        if (this._psBlock == null) {
            PageSettingsBlock pageSettingsBlock = new PageSettingsBlock();
            this._psBlock = pageSettingsBlock;
            RecordOrderer.addNewSheetRecord(this._records, pageSettingsBlock);
        }
        return this._psBlock;
    }

    public void setColumnGroupCollapsed(int i, boolean z) {
        if (z) {
            this._columnInfos.collapseColumn(i);
        } else {
            this._columnInfos.expandColumn(i);
        }
    }

    public void groupRowRange(int i, int i2, boolean z) {
        while (i <= i2) {
            RowRecord row = getRow(i);
            if (row == null) {
                row = RowRecordsAggregate.createRow(i);
                addRow(row);
            }
            short outlineLevel = row.getOutlineLevel();
            row.setOutlineLevel((short) Math.min(7, Math.max(0, z ? outlineLevel + 1 : outlineLevel - 1)));
            i++;
        }
        recalcRowGutter();
    }

    private void recalcRowGutter() {
        Iterator<RowRecord> iterator = this._rowsAggregate.getIterator();
        int i = 0;
        while (iterator.hasNext()) {
            i = Math.max((int) iterator.next().getOutlineLevel(), i);
        }
        GutsRecord gutsRecord = getGutsRecord();
        gutsRecord.setRowLevelMax((short) (i + 1));
        gutsRecord.setLeftRowGutter((short) ((i * 12) + 29));
    }

    public DataValidityTable getOrCreateDataValidityTable() {
        if (this._dataValidityTable == null) {
            DataValidityTable dataValidityTable = new DataValidityTable();
            RecordOrderer.addNewSheetRecord(this._records, dataValidityTable);
            this._dataValidityTable = dataValidityTable;
        }
        return this._dataValidityTable;
    }

    public NoteRecord[] getNoteRecords() {
        ArrayList arrayList = new ArrayList();
        for (int size = this._records.size() - 1; size >= 0; size--) {
            RecordBase recordBase = this._records.get(size);
            if (recordBase instanceof NoteRecord) {
                arrayList.add((NoteRecord) recordBase);
            }
        }
        if (arrayList.size() < 1) {
            return NoteRecord.EMPTY_ARRAY;
        }
        NoteRecord[] noteRecordArr = new NoteRecord[arrayList.size()];
        arrayList.toArray(noteRecordArr);
        return noteRecordArr;
    }

    public int getColumnOutlineLevel(int i) {
        return this._columnInfos.getOutlineLevel(i);
    }
}
