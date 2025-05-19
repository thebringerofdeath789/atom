package jxl.read.biff;

import common.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.Cell;
import jxl.CellType;
import jxl.CellView;
import jxl.Hyperlink;
import jxl.Image;
import jxl.LabelCell;
import jxl.Range;
import jxl.Sheet;
import jxl.SheetSettings;
import jxl.WorkbookSettings;
import jxl.biff.CellReferenceHelper;
import jxl.biff.DataValidation;
import jxl.biff.EmptyCell;
import jxl.biff.FormattingRecords;
import jxl.biff.Type;
import jxl.biff.WorkspaceInformationRecord;
import jxl.biff.drawing.Chart;
import jxl.biff.drawing.Drawing;
import jxl.biff.drawing.DrawingData;
import jxl.biff.drawing.DrawingGroupObject;
import jxl.format.CellFormat;

/* loaded from: classes4.dex */
public class SheetImpl implements Sheet {
    static /* synthetic */ Class class$jxl$read$biff$SheetImpl;
    private static Logger logger;
    private ButtonPropertySetRecord buttonPropertySet;
    private Cell[][] cells;
    private ArrayList charts;
    private int[] columnBreaks;
    private ColumnInfoRecord[] columnInfos;
    private DataValidation dataValidation;
    private ArrayList drawings;
    private File excelFile;
    private FormattingRecords formattingRecords;
    private boolean hidden;
    private ArrayList images;
    private Range[] mergedCells;
    private String name;
    private boolean nineteenFour;
    private int numCols;
    private int numRows;
    private PLSRecord plsRecord;
    private int[] rowBreaks;
    private RowRecord[] rowRecords;
    private SheetSettings settings;
    private SSTRecord sharedStrings;
    private BOFRecord sheetBof;
    private int startPosition;
    private WorkbookParser workbook;
    private BOFRecord workbookBof;
    private WorkbookSettings workbookSettings;
    private WorkspaceInformationRecord workspaceOptions;
    private ArrayList columnInfosArray = new ArrayList();
    private ArrayList sharedFormulas = new ArrayList();
    private ArrayList hyperlinks = new ArrayList();
    private ArrayList rowProperties = new ArrayList(10);
    private boolean columnInfosInitialized = false;
    private boolean rowRecordsInitialized = false;

    static {
        Class cls = class$jxl$read$biff$SheetImpl;
        if (cls == null) {
            cls = class$("jxl.read.biff.SheetImpl");
            class$jxl$read$biff$SheetImpl = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    SheetImpl(File file, SSTRecord sSTRecord, FormattingRecords formattingRecords, BOFRecord bOFRecord, BOFRecord bOFRecord2, boolean z, WorkbookParser workbookParser) throws BiffException {
        this.excelFile = file;
        this.sharedStrings = sSTRecord;
        this.formattingRecords = formattingRecords;
        this.sheetBof = bOFRecord;
        this.workbookBof = bOFRecord2;
        this.nineteenFour = z;
        this.workbook = workbookParser;
        this.workbookSettings = workbookParser.getSettings();
        this.startPosition = file.getPos();
        if (this.sheetBof.isChart()) {
            this.startPosition -= this.sheetBof.getLength() + 4;
        }
        int i = 1;
        while (i >= 1) {
            Record next = file.next();
            i = next.getCode() == Type.EOF.value ? i - 1 : i;
            if (next.getCode() == Type.BOF.value) {
                i++;
            }
        }
    }

    @Override // jxl.Sheet
    public Cell getCell(String str) {
        return getCell(CellReferenceHelper.getColumn(str), CellReferenceHelper.getRow(str));
    }

    @Override // jxl.Sheet
    public Cell getCell(int i, int i2) {
        if (this.cells == null) {
            readSheet();
        }
        Cell cell = this.cells[i2][i];
        if (cell != null) {
            return cell;
        }
        EmptyCell emptyCell = new EmptyCell(i, i2);
        this.cells[i2][i] = emptyCell;
        return emptyCell;
    }

    @Override // jxl.Sheet
    public Cell findCell(String str) {
        Cell cell = null;
        boolean z = false;
        for (int i = 0; i < getRows() && !z; i++) {
            Cell[] row = getRow(i);
            for (int i2 = 0; i2 < row.length && !z; i2++) {
                if (row[i2].getContents().equals(str)) {
                    cell = row[i2];
                    z = true;
                }
            }
        }
        return cell;
    }

    @Override // jxl.Sheet
    public LabelCell findLabelCell(String str) {
        LabelCell labelCell = null;
        boolean z = false;
        for (int i = 0; i < getRows() && !z; i++) {
            Cell[] row = getRow(i);
            for (int i2 = 0; i2 < row.length && !z; i2++) {
                if ((row[i2].getType() == CellType.LABEL || row[i2].getType() == CellType.STRING_FORMULA) && row[i2].getContents().equals(str)) {
                    labelCell = (LabelCell) row[i2];
                    z = true;
                }
            }
        }
        return labelCell;
    }

    @Override // jxl.Sheet
    public int getRows() {
        if (this.cells == null) {
            readSheet();
        }
        return this.numRows;
    }

    @Override // jxl.Sheet
    public int getColumns() {
        if (this.cells == null) {
            readSheet();
        }
        return this.numCols;
    }

    @Override // jxl.Sheet
    public Cell[] getRow(int i) {
        if (this.cells == null) {
            readSheet();
        }
        int i2 = this.numCols - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            if (this.cells[i][i2] != null) {
                z = true;
            } else {
                i2--;
            }
        }
        Cell[] cellArr = new Cell[i2 + 1];
        for (int i3 = 0; i3 <= i2; i3++) {
            cellArr[i3] = getCell(i3, i);
        }
        return cellArr;
    }

    @Override // jxl.Sheet
    public Cell[] getColumn(int i) {
        if (this.cells == null) {
            readSheet();
        }
        int i2 = this.numRows - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            if (this.cells[i2][i] != null) {
                z = true;
            } else {
                i2--;
            }
        }
        Cell[] cellArr = new Cell[i2 + 1];
        for (int i3 = 0; i3 <= i2; i3++) {
            cellArr[i3] = getCell(i, i3);
        }
        return cellArr;
    }

    @Override // jxl.Sheet
    public String getName() {
        return this.name;
    }

    final void setName(String str) {
        this.name = str;
    }

    @Override // jxl.Sheet
    public boolean isHidden() {
        return this.hidden;
    }

    public ColumnInfoRecord getColumnInfo(int i) {
        if (!this.columnInfosInitialized) {
            Iterator it = this.columnInfosArray.iterator();
            while (it.hasNext()) {
                ColumnInfoRecord columnInfoRecord = (ColumnInfoRecord) it.next();
                int max = Math.max(0, columnInfoRecord.getStartColumn());
                int min = Math.min(this.columnInfos.length - 1, columnInfoRecord.getEndColumn());
                for (int i2 = max; i2 <= min; i2++) {
                    this.columnInfos[i2] = columnInfoRecord;
                }
                if (min < max) {
                    this.columnInfos[max] = columnInfoRecord;
                }
            }
            this.columnInfosInitialized = true;
        }
        ColumnInfoRecord[] columnInfoRecordArr = this.columnInfos;
        if (i < columnInfoRecordArr.length) {
            return columnInfoRecordArr[i];
        }
        return null;
    }

    public ColumnInfoRecord[] getColumnInfos() {
        ColumnInfoRecord[] columnInfoRecordArr = new ColumnInfoRecord[this.columnInfosArray.size()];
        for (int i = 0; i < this.columnInfosArray.size(); i++) {
            columnInfoRecordArr[i] = (ColumnInfoRecord) this.columnInfosArray.get(i);
        }
        return columnInfoRecordArr;
    }

    final void setHidden(boolean z) {
        this.hidden = z;
    }

    final void clear() {
        this.cells = (Cell[][]) null;
        this.mergedCells = null;
        this.columnInfosArray.clear();
        this.sharedFormulas.clear();
        this.hyperlinks.clear();
        this.columnInfosInitialized = false;
        if (this.workbookSettings.getGCDisabled()) {
            return;
        }
        System.gc();
    }

    final void readSheet() {
        if (!this.sheetBof.isWorksheet()) {
            this.numRows = 0;
            this.numCols = 0;
            this.cells = (Cell[][]) Array.newInstance((Class<?>) Cell.class, 0, 0);
        }
        SheetReader sheetReader = new SheetReader(this.excelFile, this.sharedStrings, this.formattingRecords, this.sheetBof, this.workbookBof, this.nineteenFour, this.workbook, this.startPosition, this);
        sheetReader.read();
        this.numRows = sheetReader.getNumRows();
        this.numCols = sheetReader.getNumCols();
        this.cells = sheetReader.getCells();
        this.rowProperties = sheetReader.getRowProperties();
        this.columnInfosArray = sheetReader.getColumnInfosArray();
        this.hyperlinks = sheetReader.getHyperlinks();
        this.charts = sheetReader.getCharts();
        this.drawings = sheetReader.getDrawings();
        this.dataValidation = sheetReader.getDataValidation();
        this.mergedCells = sheetReader.getMergedCells();
        SheetSettings settings = sheetReader.getSettings();
        this.settings = settings;
        settings.setHidden(this.hidden);
        this.rowBreaks = sheetReader.getRowBreaks();
        this.columnBreaks = sheetReader.getColumnBreaks();
        this.workspaceOptions = sheetReader.getWorkspaceOptions();
        this.plsRecord = sheetReader.getPLS();
        this.buttonPropertySet = sheetReader.getButtonPropertySet();
        if (!this.workbookSettings.getGCDisabled()) {
            System.gc();
        }
        if (this.columnInfosArray.size() > 0) {
            this.columnInfos = new ColumnInfoRecord[((ColumnInfoRecord) this.columnInfosArray.get(r0.size() - 1)).getEndColumn() + 1];
        } else {
            this.columnInfos = new ColumnInfoRecord[0];
        }
    }

    @Override // jxl.Sheet
    public Hyperlink[] getHyperlinks() {
        Hyperlink[] hyperlinkArr = new Hyperlink[this.hyperlinks.size()];
        for (int i = 0; i < this.hyperlinks.size(); i++) {
            hyperlinkArr[i] = (Hyperlink) this.hyperlinks.get(i);
        }
        return hyperlinkArr;
    }

    @Override // jxl.Sheet
    public Range[] getMergedCells() {
        Range[] rangeArr = this.mergedCells;
        return rangeArr == null ? new Range[0] : rangeArr;
    }

    public RowRecord[] getRowProperties() {
        int size = this.rowProperties.size();
        RowRecord[] rowRecordArr = new RowRecord[size];
        for (int i = 0; i < size; i++) {
            rowRecordArr[i] = (RowRecord) this.rowProperties.get(i);
        }
        return rowRecordArr;
    }

    public DataValidation getDataValidation() {
        return this.dataValidation;
    }

    RowRecord getRowInfo(int i) {
        if (!this.rowRecordsInitialized) {
            this.rowRecords = new RowRecord[getRows()];
            Iterator it = this.rowProperties.iterator();
            while (it.hasNext()) {
                RowRecord rowRecord = (RowRecord) it.next();
                int rowNumber = rowRecord.getRowNumber();
                RowRecord[] rowRecordArr = this.rowRecords;
                if (rowNumber < rowRecordArr.length) {
                    rowRecordArr[rowNumber] = rowRecord;
                }
            }
            this.rowRecordsInitialized = true;
        }
        RowRecord[] rowRecordArr2 = this.rowRecords;
        if (i < rowRecordArr2.length) {
            return rowRecordArr2[i];
        }
        return null;
    }

    @Override // jxl.Sheet
    public final int[] getRowPageBreaks() {
        return this.rowBreaks;
    }

    @Override // jxl.Sheet
    public final int[] getColumnPageBreaks() {
        return this.columnBreaks;
    }

    public final Chart[] getCharts() {
        int size = this.charts.size();
        Chart[] chartArr = new Chart[size];
        for (int i = 0; i < size; i++) {
            chartArr[i] = (Chart) this.charts.get(i);
        }
        return chartArr;
    }

    public final DrawingGroupObject[] getDrawings() {
        return (DrawingGroupObject[]) this.drawings.toArray(new DrawingGroupObject[this.drawings.size()]);
    }

    @Override // jxl.Sheet
    public boolean isProtected() {
        return this.settings.isProtected();
    }

    public WorkspaceInformationRecord getWorkspaceOptions() {
        return this.workspaceOptions;
    }

    @Override // jxl.Sheet
    public SheetSettings getSettings() {
        return this.settings;
    }

    WorkbookParser getWorkbook() {
        return this.workbook;
    }

    @Override // jxl.Sheet
    public CellFormat getColumnFormat(int i) {
        return getColumnView(i).getFormat();
    }

    @Override // jxl.Sheet
    public int getColumnWidth(int i) {
        return getColumnView(i).getSize() / 256;
    }

    @Override // jxl.Sheet
    public CellView getColumnView(int i) {
        ColumnInfoRecord columnInfo = getColumnInfo(i);
        CellView cellView = new CellView();
        if (columnInfo != null) {
            cellView.setDimension(columnInfo.getWidth() / 256);
            cellView.setSize(columnInfo.getWidth());
            cellView.setHidden(columnInfo.getHidden());
            cellView.setFormat(this.formattingRecords.getXFRecord(columnInfo.getXFIndex()));
        } else {
            cellView.setDimension(this.settings.getDefaultColumnWidth() / 256);
            cellView.setSize(this.settings.getDefaultColumnWidth());
        }
        return cellView;
    }

    @Override // jxl.Sheet
    public int getRowHeight(int i) {
        return getRowView(i).getDimension();
    }

    @Override // jxl.Sheet
    public CellView getRowView(int i) {
        RowRecord rowInfo = getRowInfo(i);
        CellView cellView = new CellView();
        if (rowInfo != null) {
            cellView.setDimension(rowInfo.getRowHeight());
            cellView.setSize(rowInfo.getRowHeight());
            cellView.setHidden(rowInfo.isCollapsed());
        } else {
            cellView.setDimension(this.settings.getDefaultRowHeight());
            cellView.setSize(this.settings.getDefaultRowHeight());
        }
        return cellView;
    }

    public BOFRecord getSheetBof() {
        return this.sheetBof;
    }

    public BOFRecord getWorkbookBof() {
        return this.workbookBof;
    }

    public PLSRecord getPLS() {
        return this.plsRecord;
    }

    public ButtonPropertySetRecord getButtonPropertySet() {
        return this.buttonPropertySet;
    }

    @Override // jxl.Sheet
    public int getNumberOfImages() {
        if (this.images == null) {
            initializeImages();
        }
        return this.images.size();
    }

    @Override // jxl.Sheet
    public Image getDrawing(int i) {
        if (this.images == null) {
            initializeImages();
        }
        return (Image) this.images.get(i);
    }

    private void initializeImages() {
        if (this.images != null) {
            return;
        }
        this.images = new ArrayList();
        DrawingGroupObject[] drawings = getDrawings();
        for (int i = 0; i < drawings.length; i++) {
            if (drawings[i] instanceof Drawing) {
                this.images.add(drawings[i]);
            }
        }
    }

    public DrawingData getDrawingData() {
        SheetReader sheetReader = new SheetReader(this.excelFile, this.sharedStrings, this.formattingRecords, this.sheetBof, this.workbookBof, this.nineteenFour, this.workbook, this.startPosition, this);
        sheetReader.read();
        return sheetReader.getDrawingData();
    }
}
