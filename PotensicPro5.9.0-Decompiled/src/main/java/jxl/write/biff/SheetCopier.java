package jxl.write.biff;

import common.Assert;
import common.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Hyperlink;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Range;
import jxl.Sheet;
import jxl.WorkbookSettings;
import jxl.biff.DataValidation;
import jxl.biff.FormattingRecords;
import jxl.biff.FormulaData;
import jxl.biff.NumFormatRecordsException;
import jxl.biff.SheetRangeImpl;
import jxl.biff.XFRecord;
import jxl.biff.drawing.Button;
import jxl.biff.drawing.ComboBox;
import jxl.biff.drawing.Comment;
import jxl.biff.drawing.Drawing;
import jxl.biff.drawing.DrawingGroupObject;
import jxl.format.CellFormat;
import jxl.read.biff.SheetImpl;
import jxl.write.Blank;
import jxl.write.Boolean;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableHyperlink;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* loaded from: classes4.dex */
class SheetCopier {
    static /* synthetic */ Class class$jxl$write$biff$SheetCopier;
    private static Logger logger;
    private ButtonPropertySetRecord buttonPropertySet;
    private boolean chartOnly = false;
    private ArrayList columnBreaks;
    private TreeSet columnFormats;
    private ComboBox comboBox;
    private DataValidation dataValidation;
    private ArrayList drawings;
    private HashMap fonts;
    private FormattingRecords formatRecords;
    private HashMap formats;
    private SheetImpl fromSheet;
    private ArrayList hyperlinks;
    private ArrayList images;
    private MergedCells mergedCells;
    private PLSRecord plsRecord;
    private ArrayList rowBreaks;
    private SheetWriter sheetWriter;
    private WritableSheetImpl toSheet;
    private WorkbookSettings workbookSettings;
    private HashMap xfRecords;

    static {
        Class cls = class$jxl$write$biff$SheetCopier;
        if (cls == null) {
            cls = class$("jxl.write.biff.SheetCopier");
            class$jxl$write$biff$SheetCopier = cls;
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

    public SheetCopier(Sheet sheet, WritableSheet writableSheet) {
        this.fromSheet = (SheetImpl) sheet;
        WritableSheetImpl writableSheetImpl = (WritableSheetImpl) writableSheet;
        this.toSheet = writableSheetImpl;
        this.workbookSettings = writableSheetImpl.getWorkbook().getSettings();
    }

    void setColumnFormats(TreeSet treeSet) {
        this.columnFormats = treeSet;
    }

    void setFormatRecords(FormattingRecords formattingRecords) {
        this.formatRecords = formattingRecords;
    }

    void setHyperlinks(ArrayList arrayList) {
        this.hyperlinks = arrayList;
    }

    void setMergedCells(MergedCells mergedCells) {
        this.mergedCells = mergedCells;
    }

    void setRowBreaks(ArrayList arrayList) {
        this.rowBreaks = arrayList;
    }

    void setColumnBreaks(ArrayList arrayList) {
        this.columnBreaks = arrayList;
    }

    void setSheetWriter(SheetWriter sheetWriter) {
        this.sheetWriter = sheetWriter;
    }

    void setDrawings(ArrayList arrayList) {
        this.drawings = arrayList;
    }

    void setImages(ArrayList arrayList) {
        this.images = arrayList;
    }

    DataValidation getDataValidation() {
        return this.dataValidation;
    }

    ComboBox getComboBox() {
        return this.comboBox;
    }

    PLSRecord getPLSRecord() {
        return this.plsRecord;
    }

    boolean isChartOnly() {
        return this.chartOnly;
    }

    ButtonPropertySetRecord getButtonPropertySet() {
        return this.buttonPropertySet;
    }

    public void copySheet() {
        shallowCopyCells();
        for (jxl.read.biff.ColumnInfoRecord columnInfoRecord : this.fromSheet.getColumnInfos()) {
            for (int startColumn = columnInfoRecord.getStartColumn(); startColumn <= columnInfoRecord.getEndColumn(); startColumn++) {
                ColumnInfoRecord columnInfoRecord2 = new ColumnInfoRecord(columnInfoRecord, startColumn, this.formatRecords);
                columnInfoRecord2.setHidden(columnInfoRecord.getHidden());
                this.columnFormats.add(columnInfoRecord2);
            }
        }
        for (Hyperlink hyperlink : this.fromSheet.getHyperlinks()) {
            this.hyperlinks.add(new WritableHyperlink(hyperlink, this.toSheet));
        }
        for (Range range : this.fromSheet.getMergedCells()) {
            this.mergedCells.add(new SheetRangeImpl((SheetRangeImpl) range, this.toSheet));
        }
        try {
            jxl.read.biff.RowRecord[] rowProperties = this.fromSheet.getRowProperties();
            for (int i = 0; i < rowProperties.length; i++) {
                this.toSheet.getRowRecord(rowProperties[i].getRowNumber()).setRowDetails(rowProperties[i].getRowHeight(), rowProperties[i].matchesDefaultFontHeight(), rowProperties[i].isCollapsed(), rowProperties[i].hasDefaultFormat() ? this.formatRecords.getXFRecord(rowProperties[i].getXFIndex()) : null);
            }
        } catch (RowsExceededException unused) {
            Assert.verify(false);
        }
        int[] rowPageBreaks = this.fromSheet.getRowPageBreaks();
        if (rowPageBreaks != null) {
            for (int i2 : rowPageBreaks) {
                this.rowBreaks.add(new Integer(i2));
            }
        }
        int[] columnPageBreaks = this.fromSheet.getColumnPageBreaks();
        if (columnPageBreaks != null) {
            for (int i3 : columnPageBreaks) {
                this.columnBreaks.add(new Integer(i3));
            }
        }
        this.sheetWriter.setCharts(this.fromSheet.getCharts());
        DrawingGroupObject[] drawings = this.fromSheet.getDrawings();
        int i4 = 0;
        while (true) {
            if (i4 >= drawings.length) {
                break;
            }
            if (drawings[i4] instanceof Drawing) {
                WritableImage writableImage = new WritableImage(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup());
                this.drawings.add(writableImage);
                this.images.add(writableImage);
            } else if (drawings[i4] instanceof Comment) {
                Comment comment = new Comment(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup(), this.workbookSettings);
                this.drawings.add(comment);
                CellValue cellValue = (CellValue) this.toSheet.getWritableCell(comment.getColumn(), comment.getRow());
                Assert.verify(cellValue.getCellFeatures() != null);
                cellValue.getWritableCellFeatures().setCommentDrawing(comment);
            } else if (drawings[i4] instanceof Button) {
                this.drawings.add(new Button(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup(), this.workbookSettings));
            } else if (drawings[i4] instanceof ComboBox) {
                this.drawings.add(new ComboBox(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup(), this.workbookSettings));
            }
            i4++;
        }
        DataValidation dataValidation = this.fromSheet.getDataValidation();
        if (dataValidation != null) {
            DataValidation dataValidation2 = new DataValidation(dataValidation, this.toSheet.getWorkbook(), this.toSheet.getWorkbook(), this.workbookSettings);
            this.dataValidation = dataValidation2;
            int comboBoxObjectId = dataValidation2.getComboBoxObjectId();
            if (comboBoxObjectId != 0) {
                this.comboBox = (ComboBox) this.drawings.get(comboBoxObjectId);
            }
        }
        this.sheetWriter.setWorkspaceOptions(this.fromSheet.getWorkspaceOptions());
        if (this.fromSheet.getSheetBof().isChart()) {
            this.chartOnly = true;
            this.sheetWriter.setChartOnly();
        }
        if (this.fromSheet.getPLS() != null) {
            if (this.fromSheet.getWorkbookBof().isBiff7()) {
                logger.warn("Cannot copy Biff7 print settings record - ignoring");
            } else {
                this.plsRecord = new PLSRecord(this.fromSheet.getPLS());
            }
        }
        if (this.fromSheet.getButtonPropertySet() != null) {
            this.buttonPropertySet = new ButtonPropertySetRecord(this.fromSheet.getButtonPropertySet());
        }
    }

    public void importSheet() {
        this.xfRecords = new HashMap();
        this.fonts = new HashMap();
        this.formats = new HashMap();
        deepCopyCells();
        for (jxl.read.biff.ColumnInfoRecord columnInfoRecord : this.fromSheet.getColumnInfos()) {
            for (int startColumn = columnInfoRecord.getStartColumn(); startColumn <= columnInfoRecord.getEndColumn(); startColumn++) {
                ColumnInfoRecord columnInfoRecord2 = new ColumnInfoRecord(columnInfoRecord, startColumn);
                WritableCellFormat writableCellFormat = (WritableCellFormat) this.xfRecords.get(new Integer(columnInfoRecord2.getXfIndex()));
                if (writableCellFormat == null) {
                    copyCellFormat(this.fromSheet.getColumnView(startColumn).getFormat());
                }
                columnInfoRecord2.setCellFormat(writableCellFormat);
                columnInfoRecord2.setHidden(columnInfoRecord.getHidden());
                this.columnFormats.add(columnInfoRecord2);
            }
        }
        for (Hyperlink hyperlink : this.fromSheet.getHyperlinks()) {
            this.hyperlinks.add(new WritableHyperlink(hyperlink, this.toSheet));
        }
        for (Range range : this.fromSheet.getMergedCells()) {
            this.mergedCells.add(new SheetRangeImpl((SheetRangeImpl) range, this.toSheet));
        }
        try {
            jxl.read.biff.RowRecord[] rowProperties = this.fromSheet.getRowProperties();
            for (int i = 0; i < rowProperties.length; i++) {
                this.toSheet.getRowRecord(rowProperties[i].getRowNumber()).setRowDetails(rowProperties[i].getRowHeight(), rowProperties[i].matchesDefaultFontHeight(), rowProperties[i].isCollapsed(), rowProperties[i].hasDefaultFormat() ? this.formatRecords.getXFRecord(rowProperties[i].getXFIndex()) : null);
            }
        } catch (RowsExceededException unused) {
            Assert.verify(false);
        }
        int[] rowPageBreaks = this.fromSheet.getRowPageBreaks();
        if (rowPageBreaks != null) {
            for (int i2 : rowPageBreaks) {
                this.rowBreaks.add(new Integer(i2));
            }
        }
        int[] columnPageBreaks = this.fromSheet.getColumnPageBreaks();
        if (columnPageBreaks != null) {
            for (int i3 : columnPageBreaks) {
                this.columnBreaks.add(new Integer(i3));
            }
        }
        logger.warn("Importing of charts is not supported");
        DrawingGroupObject[] drawings = this.fromSheet.getDrawings();
        int i4 = 0;
        while (true) {
            if (i4 >= drawings.length) {
                break;
            }
            if (drawings[i4] instanceof Drawing) {
                WritableImage writableImage = new WritableImage(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup());
                this.drawings.add(writableImage);
                this.images.add(writableImage);
            } else if (drawings[i4] instanceof Comment) {
                Comment comment = new Comment(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup(), this.workbookSettings);
                this.drawings.add(comment);
                CellValue cellValue = (CellValue) this.toSheet.getWritableCell(comment.getColumn(), comment.getRow());
                Assert.verify(cellValue.getCellFeatures() != null);
                cellValue.getWritableCellFeatures().setCommentDrawing(comment);
            } else if (drawings[i4] instanceof Button) {
                this.drawings.add(new Button(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup(), this.workbookSettings));
            } else if (drawings[i4] instanceof ComboBox) {
                this.drawings.add(new ComboBox(drawings[i4], this.toSheet.getWorkbook().getDrawingGroup(), this.workbookSettings));
            }
            i4++;
        }
        DataValidation dataValidation = this.fromSheet.getDataValidation();
        if (dataValidation != null) {
            DataValidation dataValidation2 = new DataValidation(dataValidation, this.toSheet.getWorkbook(), this.toSheet.getWorkbook(), this.workbookSettings);
            this.dataValidation = dataValidation2;
            int comboBoxObjectId = dataValidation2.getComboBoxObjectId();
            if (comboBoxObjectId != 0) {
                this.comboBox = (ComboBox) this.drawings.get(comboBoxObjectId);
            }
        }
        this.sheetWriter.setWorkspaceOptions(this.fromSheet.getWorkspaceOptions());
        if (this.fromSheet.getSheetBof().isChart()) {
            this.chartOnly = true;
            this.sheetWriter.setChartOnly();
        }
        if (this.fromSheet.getPLS() != null) {
            if (this.fromSheet.getWorkbookBof().isBiff7()) {
                logger.warn("Cannot copy Biff7 print settings record - ignoring");
            } else {
                this.plsRecord = new PLSRecord(this.fromSheet.getPLS());
            }
        }
        if (this.fromSheet.getButtonPropertySet() != null) {
            this.buttonPropertySet = new ButtonPropertySetRecord(this.fromSheet.getButtonPropertySet());
        }
    }

    private WritableCell shallowCopyCell(Cell cell) {
        CellType type = cell.getType();
        if (type == CellType.LABEL) {
            return new Label((LabelCell) cell);
        }
        if (type == CellType.NUMBER) {
            return new Number((NumberCell) cell);
        }
        if (type == CellType.DATE) {
            return new DateTime((DateCell) cell);
        }
        if (type == CellType.BOOLEAN) {
            return new Boolean((BooleanCell) cell);
        }
        if (type == CellType.NUMBER_FORMULA) {
            return new ReadNumberFormulaRecord((FormulaData) cell);
        }
        if (type == CellType.STRING_FORMULA) {
            return new ReadStringFormulaRecord((FormulaData) cell);
        }
        if (type == CellType.BOOLEAN_FORMULA) {
            return new ReadBooleanFormulaRecord((FormulaData) cell);
        }
        if (type == CellType.DATE_FORMULA) {
            return new ReadDateFormulaRecord((FormulaData) cell);
        }
        if (type == CellType.FORMULA_ERROR) {
            return new ReadErrorFormulaRecord((FormulaData) cell);
        }
        if (type != CellType.EMPTY || cell.getCellFormat() == null) {
            return null;
        }
        return new Blank(cell);
    }

    private WritableCell deepCopyCell(Cell cell) {
        WritableCell shallowCopyCell = shallowCopyCell(cell);
        if (shallowCopyCell == null) {
            return shallowCopyCell;
        }
        CellFormat cellFormat = shallowCopyCell.getCellFormat();
        WritableCellFormat writableCellFormat = (WritableCellFormat) this.xfRecords.get(new Integer(((XFRecord) cellFormat).getXFIndex()));
        if (writableCellFormat == null) {
            writableCellFormat = copyCellFormat(cellFormat);
        }
        shallowCopyCell.setCellFormat(writableCellFormat);
        return shallowCopyCell;
    }

    void shallowCopyCells() {
        int rows = this.fromSheet.getRows();
        for (int i = 0; i < rows; i++) {
            for (Cell cell : this.fromSheet.getRow(i)) {
                WritableCell shallowCopyCell = shallowCopyCell(cell);
                if (shallowCopyCell != null) {
                    try {
                        this.toSheet.addCell(shallowCopyCell);
                    } catch (WriteException unused) {
                        Assert.verify(false);
                    }
                }
            }
        }
    }

    void deepCopyCells() {
        int rows = this.fromSheet.getRows();
        for (int i = 0; i < rows; i++) {
            for (Cell cell : this.fromSheet.getRow(i)) {
                WritableCell deepCopyCell = deepCopyCell(cell);
                if (deepCopyCell != null) {
                    try {
                        this.toSheet.addCell(deepCopyCell);
                    } catch (WriteException unused) {
                        Assert.verify(false);
                    }
                }
            }
        }
    }

    private WritableCellFormat copyCellFormat(CellFormat cellFormat) {
        try {
            XFRecord xFRecord = (XFRecord) cellFormat;
            WritableCellFormat writableCellFormat = new WritableCellFormat(xFRecord);
            this.formatRecords.addStyle(writableCellFormat);
            this.xfRecords.put(new Integer(xFRecord.getXFIndex()), writableCellFormat);
            this.fonts.put(new Integer(xFRecord.getFontIndex()), new Integer(writableCellFormat.getFontIndex()));
            this.formats.put(new Integer(xFRecord.getFormatRecord()), new Integer(writableCellFormat.getFormatRecord()));
            return writableCellFormat;
        } catch (NumFormatRecordsException unused) {
            logger.warn("Maximum number of format records exceeded.  Using default format.");
            return WritableWorkbook.NORMAL_STYLE;
        }
    }
}
