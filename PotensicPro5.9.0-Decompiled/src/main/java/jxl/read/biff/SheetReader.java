package jxl.read.biff;

import common.Assert;
import common.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.Cell;
import jxl.CellFeatures;
import jxl.CellReferenceHelper;
import jxl.CellType;
import jxl.HeaderFooter;
import jxl.Range;
import jxl.SheetSettings;
import jxl.WorkbookSettings;
import jxl.biff.ContinueRecord;
import jxl.biff.DataValidation;
import jxl.biff.DataValidityListRecord;
import jxl.biff.DataValiditySettingsRecord;
import jxl.biff.FormattingRecords;
import jxl.biff.Type;
import jxl.biff.WorkspaceInformationRecord;
import jxl.biff.drawing.Button;
import jxl.biff.drawing.Chart;
import jxl.biff.drawing.ComboBox;
import jxl.biff.drawing.Comment;
import jxl.biff.drawing.Drawing;
import jxl.biff.drawing.Drawing2;
import jxl.biff.drawing.DrawingData;
import jxl.biff.drawing.MsoDrawingRecord;
import jxl.biff.drawing.NoteRecord;
import jxl.biff.drawing.ObjRecord;
import jxl.biff.drawing.TextObjectRecord;
import jxl.biff.formula.FormulaException;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
final class SheetReader {
    static /* synthetic */ Class class$jxl$read$biff$SheetReader;
    private static Logger logger;
    private ButtonPropertySetRecord buttonPropertySet;
    private Cell[][] cells;
    private int[] columnBreaks;
    private DataValidation dataValidation;
    private DrawingData drawingData;
    private File excelFile;
    private FormattingRecords formattingRecords;
    private Range[] mergedCells;
    private boolean nineteenFour;
    private int numCols;
    private int numRows;
    private PLSRecord plsRecord;
    private int[] rowBreaks;
    private SSTRecord sharedStrings;
    private SheetImpl sheet;
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
    private ArrayList charts = new ArrayList();
    private ArrayList drawings = new ArrayList();
    private ArrayList outOfBoundsCells = new ArrayList();
    private SheetSettings settings = new SheetSettings();

    static {
        Class cls = class$jxl$read$biff$SheetReader;
        if (cls == null) {
            cls = class$("jxl.read.biff.SheetReader");
            class$jxl$read$biff$SheetReader = cls;
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

    SheetReader(File file, SSTRecord sSTRecord, FormattingRecords formattingRecords, BOFRecord bOFRecord, BOFRecord bOFRecord2, boolean z, WorkbookParser workbookParser, int i, SheetImpl sheetImpl) {
        this.excelFile = file;
        this.sharedStrings = sSTRecord;
        this.formattingRecords = formattingRecords;
        this.sheetBof = bOFRecord;
        this.workbookBof = bOFRecord2;
        this.nineteenFour = z;
        this.workbook = workbookParser;
        this.startPosition = i;
        this.sheet = sheetImpl;
        this.workbookSettings = this.workbook.getSettings();
    }

    private void addCell(Cell cell) {
        if (cell.getRow() < this.numRows && cell.getColumn() < this.numCols) {
            if (this.cells[cell.getRow()][cell.getColumn()] != null) {
                StringBuffer stringBuffer = new StringBuffer();
                CellReferenceHelper.getCellReference(cell.getColumn(), cell.getRow(), stringBuffer);
                logger.warn(new StringBuffer().append("Cell ").append(stringBuffer.toString()).append(" already contains data").toString());
            }
            this.cells[cell.getRow()][cell.getColumn()] = cell;
            return;
        }
        this.outOfBoundsCells.add(cell);
    }

    final void read() {
        ObjRecord objRecord;
        BaseSharedFormulaRecord baseSharedFormulaRecord;
        char c;
        MsoDrawingRecord msoDrawingRecord;
        VerticalPageBreaksRecord verticalPageBreaksRecord;
        HorizontalPageBreaksRecord horizontalPageBreaksRecord;
        FooterRecord footerRecord;
        HeaderRecord headerRecord;
        Cell labelRecord;
        BaseSharedFormulaRecord baseSharedFormulaRecord2;
        DimensionRecord dimensionRecord;
        this.excelFile.setPos(this.startPosition);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        char c2 = 1;
        int i = 0;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = false;
        ObjRecord objRecord2 = null;
        BaseSharedFormulaRecord baseSharedFormulaRecord3 = null;
        MsoDrawingRecord msoDrawingRecord2 = null;
        Window2Record window2Record = null;
        while (z) {
            Record next = this.excelFile.next();
            Type type = next.getType();
            if (type == Type.UNKNOWN && next.getCode() == 0) {
                logger.warn("Biff code zero found");
                if (next.getLength() == 10) {
                    logger.warn("Biff code zero found - trying a dimension record.");
                    next.setType(Type.DIMENSION);
                } else {
                    logger.warn("Biff code zero found - Ignoring.");
                }
            }
            if (type == Type.DIMENSION) {
                if (this.workbookBof.isBiff8()) {
                    dimensionRecord = new DimensionRecord(next);
                } else {
                    dimensionRecord = new DimensionRecord(next, DimensionRecord.biff7);
                }
                this.numRows = dimensionRecord.getNumberOfRows();
                int numberOfColumns = dimensionRecord.getNumberOfColumns();
                this.numCols = numberOfColumns;
                int i2 = this.numRows;
                int[] iArr = new int[2];
                iArr[c2] = numberOfColumns;
                iArr[i] = i2;
                this.cells = (Cell[][]) Array.newInstance((Class<?>) Cell.class, iArr);
            } else if (type == Type.LABELSST) {
                addCell(new LabelSSTRecord(next, this.sharedStrings, this.formattingRecords, this.sheet));
            } else {
                if (type == Type.RK || type == Type.RK2) {
                    objRecord = objRecord2;
                    baseSharedFormulaRecord = baseSharedFormulaRecord3;
                    c = c2;
                    msoDrawingRecord = msoDrawingRecord2;
                    RKRecord rKRecord = new RKRecord(next, this.formattingRecords, this.sheet);
                    if (this.formattingRecords.isDate(rKRecord.getXFIndex())) {
                        addCell(new DateRecord(rKRecord, rKRecord.getXFIndex(), this.formattingRecords, this.nineteenFour, this.sheet));
                    } else {
                        addCell(rKRecord);
                    }
                } else if (type == Type.HLINK) {
                    this.hyperlinks.add(new HyperlinkRecord(next, this.sheet, this.workbookSettings));
                } else if (type == Type.MERGEDCELLS) {
                    MergedCellsRecord mergedCellsRecord = new MergedCellsRecord(next, this.sheet);
                    Range[] rangeArr = this.mergedCells;
                    if (rangeArr == null) {
                        this.mergedCells = mergedCellsRecord.getRanges();
                    } else {
                        Range[] rangeArr2 = new Range[rangeArr.length + mergedCellsRecord.getRanges().length];
                        Range[] rangeArr3 = this.mergedCells;
                        System.arraycopy(rangeArr3, i, rangeArr2, i, rangeArr3.length);
                        System.arraycopy(mergedCellsRecord.getRanges(), i, rangeArr2, this.mergedCells.length, mergedCellsRecord.getRanges().length);
                        this.mergedCells = rangeArr2;
                    }
                } else if (type == Type.MULRK) {
                    MulRKRecord mulRKRecord = new MulRKRecord(next);
                    int numberOfColumns2 = mulRKRecord.getNumberOfColumns();
                    int i3 = i;
                    while (i3 < numberOfColumns2) {
                        int xFIndex = mulRKRecord.getXFIndex(i3);
                        NumberValue numberValue = new NumberValue(mulRKRecord.getRow(), mulRKRecord.getFirstColumn() + i3, RKHelper.getDouble(mulRKRecord.getRKNumber(i3)), xFIndex, this.formattingRecords, this.sheet);
                        if (this.formattingRecords.isDate(xFIndex)) {
                            addCell(new DateRecord(numberValue, xFIndex, this.formattingRecords, this.nineteenFour, this.sheet));
                        } else {
                            numberValue.setNumberFormat(this.formattingRecords.getNumberFormat(xFIndex));
                            addCell(numberValue);
                        }
                        i3++;
                        c2 = 1;
                    }
                } else {
                    if (type == Type.NUMBER) {
                        NumberRecord numberRecord = new NumberRecord(next, this.formattingRecords, this.sheet);
                        if (this.formattingRecords.isDate(numberRecord.getXFIndex())) {
                            addCell(new DateRecord(numberRecord, numberRecord.getXFIndex(), this.formattingRecords, this.nineteenFour, this.sheet));
                        } else {
                            addCell(numberRecord);
                        }
                    } else if (type == Type.BOOLERR) {
                        BooleanRecord booleanRecord = new BooleanRecord(next, this.formattingRecords, this.sheet);
                        if (booleanRecord.isError()) {
                            addCell(new ErrorRecord(booleanRecord.getRecord(), this.formattingRecords, this.sheet));
                        } else {
                            addCell(booleanRecord);
                        }
                    } else if (type == Type.PRINTGRIDLINES) {
                        this.settings.setPrintGridLines(new PrintGridLinesRecord(next).getPrintGridLines());
                    } else if (type == Type.PRINTHEADERS) {
                        this.settings.setPrintHeaders(new PrintHeadersRecord(next).getPrintHeaders());
                    } else {
                        if (type == Type.WINDOW2) {
                            Window2Record window2Record2 = new Window2Record(next);
                            this.settings.setShowGridLines(window2Record2.getShowGridLines());
                            this.settings.setDisplayZeroValues(window2Record2.getDisplayZeroValues());
                            this.settings.setSelected(true);
                            this.settings.setPageBreakPreviewMode(window2Record2.isPageBreakPreview());
                            window2Record = window2Record2;
                        } else if (type == Type.PANE) {
                            PaneRecord paneRecord = new PaneRecord(next);
                            if (window2Record != null && window2Record.getFrozen()) {
                                this.settings.setVerticalFreeze(paneRecord.getRowsVisible());
                                this.settings.setHorizontalFreeze(paneRecord.getColumnsVisible());
                            }
                        } else if (type != Type.CONTINUE) {
                            if (type == Type.NOTE) {
                                if (!this.workbookSettings.getDrawingsDisabled()) {
                                    NoteRecord noteRecord = new NoteRecord(next);
                                    Comment comment = (Comment) hashMap.remove(new Integer(noteRecord.getObjectId()));
                                    if (comment == null) {
                                        logger.warn(new StringBuffer().append(" cannot find comment for note id ").append(noteRecord.getObjectId()).append("...ignoring").toString());
                                    } else {
                                        comment.setNote(noteRecord);
                                        this.drawings.add(comment);
                                        objRecord = objRecord2;
                                        baseSharedFormulaRecord = baseSharedFormulaRecord3;
                                        msoDrawingRecord = msoDrawingRecord2;
                                        addCellComment(comment.getColumn(), comment.getRow(), comment.getText(), comment.getWidth(), comment.getHeight());
                                    }
                                }
                            } else {
                                objRecord = objRecord2;
                                baseSharedFormulaRecord = baseSharedFormulaRecord3;
                                msoDrawingRecord = msoDrawingRecord2;
                                if (type != Type.ARRAY) {
                                    if (type == Type.PROTECT) {
                                        this.settings.setProtected(new ProtectRecord(next).isProtected());
                                    } else {
                                        if (type == Type.SHAREDFORMULA) {
                                            if (baseSharedFormulaRecord == null) {
                                                logger.warn("Shared template formula is null - trying most recent formula template");
                                                ArrayList arrayList2 = this.sharedFormulas;
                                                SharedFormulaRecord sharedFormulaRecord = (SharedFormulaRecord) arrayList2.get(arrayList2.size() - 1);
                                                if (sharedFormulaRecord != null) {
                                                    baseSharedFormulaRecord2 = sharedFormulaRecord.getTemplateFormula();
                                                    WorkbookParser workbookParser = this.workbook;
                                                    this.sharedFormulas.add(new SharedFormulaRecord(next, baseSharedFormulaRecord2, workbookParser, workbookParser, this.sheet));
                                                    msoDrawingRecord2 = msoDrawingRecord;
                                                    objRecord2 = objRecord;
                                                    c = 1;
                                                    baseSharedFormulaRecord3 = null;
                                                }
                                            }
                                            baseSharedFormulaRecord2 = baseSharedFormulaRecord;
                                            WorkbookParser workbookParser2 = this.workbook;
                                            this.sharedFormulas.add(new SharedFormulaRecord(next, baseSharedFormulaRecord2, workbookParser2, workbookParser2, this.sheet));
                                            msoDrawingRecord2 = msoDrawingRecord;
                                            objRecord2 = objRecord;
                                            c = 1;
                                            baseSharedFormulaRecord3 = null;
                                        } else if (type == Type.FORMULA || type == Type.FORMULA2) {
                                            c = 1;
                                            File file = this.excelFile;
                                            FormattingRecords formattingRecords = this.formattingRecords;
                                            WorkbookParser workbookParser3 = this.workbook;
                                            FormulaRecord formulaRecord = new FormulaRecord(next, file, formattingRecords, workbookParser3, workbookParser3, this.sheet, this.workbookSettings);
                                            if (formulaRecord.isShared()) {
                                                baseSharedFormulaRecord3 = (BaseSharedFormulaRecord) formulaRecord.getFormula();
                                                z3 = addToSharedFormulas(baseSharedFormulaRecord3);
                                                if (z3) {
                                                    baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                }
                                                if (!z3 && baseSharedFormulaRecord != null) {
                                                    addCell(revertSharedFormula(baseSharedFormulaRecord));
                                                }
                                            } else {
                                                Cell formula = formulaRecord.getFormula();
                                                try {
                                                    if (formulaRecord.getFormula().getType() == CellType.NUMBER_FORMULA) {
                                                        NumberFormulaRecord numberFormulaRecord = (NumberFormulaRecord) formulaRecord.getFormula();
                                                        if (this.formattingRecords.isDate(numberFormulaRecord.getXFIndex())) {
                                                            FormattingRecords formattingRecords2 = this.formattingRecords;
                                                            WorkbookParser workbookParser4 = this.workbook;
                                                            formula = new DateFormulaRecord(numberFormulaRecord, formattingRecords2, workbookParser4, workbookParser4, this.nineteenFour, this.sheet);
                                                        }
                                                    }
                                                    addCell(formula);
                                                } catch (FormulaException e) {
                                                    logger.warn(new StringBuffer().append(CellReferenceHelper.getCellReference(formula.getColumn(), formula.getRow())).append(StringUtils.SPACE).append(e.getMessage()).toString());
                                                }
                                                baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                            }
                                            msoDrawingRecord2 = msoDrawingRecord;
                                            objRecord2 = objRecord;
                                        } else if (type == Type.LABEL) {
                                            if (this.workbookBof.isBiff8()) {
                                                labelRecord = new LabelRecord(next, this.formattingRecords, this.sheet, this.workbookSettings);
                                            } else {
                                                labelRecord = new LabelRecord(next, this.formattingRecords, this.sheet, this.workbookSettings, LabelRecord.biff7);
                                            }
                                            addCell(labelRecord);
                                        } else if (type == Type.RSTRING) {
                                            Assert.verify(!this.workbookBof.isBiff8());
                                            addCell(new RStringRecord(next, this.formattingRecords, this.sheet, this.workbookSettings, RStringRecord.biff7));
                                        } else if (type != Type.NAME) {
                                            if (type == Type.PASSWORD) {
                                                this.settings.setPasswordHash(new PasswordRecord(next).getPasswordHash());
                                            } else if (type == Type.ROW) {
                                                RowRecord rowRecord = new RowRecord(next);
                                                if (!rowRecord.isDefaultHeight() || !rowRecord.matchesDefaultFontHeight() || rowRecord.isCollapsed() || rowRecord.hasDefaultFormat()) {
                                                    this.rowProperties.add(rowRecord);
                                                }
                                            } else if (type == Type.BLANK) {
                                                if (!this.workbookSettings.getIgnoreBlanks()) {
                                                    addCell(new BlankCell(next, this.formattingRecords, this.sheet));
                                                }
                                            } else if (type == Type.MULBLANK) {
                                                if (!this.workbookSettings.getIgnoreBlanks()) {
                                                    MulBlankRecord mulBlankRecord = new MulBlankRecord(next);
                                                    int i4 = 0;
                                                    for (int numberOfColumns3 = mulBlankRecord.getNumberOfColumns(); i4 < numberOfColumns3; numberOfColumns3 = numberOfColumns3) {
                                                        addCell(new MulBlankCell(mulBlankRecord.getRow(), mulBlankRecord.getFirstColumn() + i4, mulBlankRecord.getXFIndex(i4), this.formattingRecords, this.sheet));
                                                        i4++;
                                                    }
                                                }
                                            } else if (type == Type.SCL) {
                                                this.settings.setZoomFactor(new SCLRecord(next).getZoomFactor());
                                            } else if (type == Type.COLINFO) {
                                                this.columnInfosArray.add(new ColumnInfoRecord(next));
                                            } else if (type == Type.HEADER) {
                                                if (this.workbookBof.isBiff8()) {
                                                    headerRecord = new HeaderRecord(next, this.workbookSettings);
                                                } else {
                                                    headerRecord = new HeaderRecord(next, this.workbookSettings, HeaderRecord.biff7);
                                                }
                                                this.settings.setHeader(new HeaderFooter(headerRecord.getHeader()));
                                            } else if (type == Type.FOOTER) {
                                                if (this.workbookBof.isBiff8()) {
                                                    footerRecord = new FooterRecord(next, this.workbookSettings);
                                                } else {
                                                    footerRecord = new FooterRecord(next, this.workbookSettings, FooterRecord.biff7);
                                                }
                                                this.settings.setFooter(new HeaderFooter(footerRecord.getFooter()));
                                            } else if (type == Type.SETUP) {
                                                SetupRecord setupRecord = new SetupRecord(next);
                                                if (setupRecord.isPortrait()) {
                                                    this.settings.setOrientation(PageOrientation.PORTRAIT);
                                                } else {
                                                    this.settings.setOrientation(PageOrientation.LANDSCAPE);
                                                }
                                                this.settings.setPaperSize(PaperSize.getPaperSize(setupRecord.getPaperSize()));
                                                this.settings.setHeaderMargin(setupRecord.getHeaderMargin());
                                                this.settings.setFooterMargin(setupRecord.getFooterMargin());
                                                this.settings.setScaleFactor(setupRecord.getScaleFactor());
                                                this.settings.setPageStart(setupRecord.getPageStart());
                                                this.settings.setFitWidth(setupRecord.getFitWidth());
                                                this.settings.setFitHeight(setupRecord.getFitHeight());
                                                this.settings.setHorizontalPrintResolution(setupRecord.getHorizontalPrintResolution());
                                                this.settings.setVerticalPrintResolution(setupRecord.getVerticalPrintResolution());
                                                this.settings.setCopies(setupRecord.getCopies());
                                                WorkspaceInformationRecord workspaceInformationRecord = this.workspaceOptions;
                                                if (workspaceInformationRecord != null) {
                                                    this.settings.setFitToPages(workspaceInformationRecord.getFitToPages());
                                                }
                                            } else if (type == Type.WSBOOL) {
                                                this.workspaceOptions = new WorkspaceInformationRecord(next);
                                            } else if (type == Type.DEFCOLWIDTH) {
                                                this.settings.setDefaultColumnWidth(new DefaultColumnWidthRecord(next).getWidth());
                                            } else if (type == Type.DEFAULTROWHEIGHT) {
                                                DefaultRowHeightRecord defaultRowHeightRecord = new DefaultRowHeightRecord(next);
                                                if (defaultRowHeightRecord.getHeight() != 0) {
                                                    this.settings.setDefaultRowHeight(defaultRowHeightRecord.getHeight());
                                                }
                                            } else if (type == Type.LEFTMARGIN) {
                                                this.settings.setLeftMargin(new LeftMarginRecord(next).getMargin());
                                            } else if (type == Type.RIGHTMARGIN) {
                                                this.settings.setRightMargin(new RightMarginRecord(next).getMargin());
                                            } else if (type == Type.TOPMARGIN) {
                                                this.settings.setTopMargin(new TopMarginRecord(next).getMargin());
                                            } else if (type == Type.BOTTOMMARGIN) {
                                                this.settings.setBottomMargin(new BottomMarginRecord(next).getMargin());
                                            } else if (type == Type.HORIZONTALPAGEBREAKS) {
                                                if (this.workbookBof.isBiff8()) {
                                                    horizontalPageBreaksRecord = new HorizontalPageBreaksRecord(next);
                                                } else {
                                                    horizontalPageBreaksRecord = new HorizontalPageBreaksRecord(next, HorizontalPageBreaksRecord.biff7);
                                                }
                                                this.rowBreaks = horizontalPageBreaksRecord.getRowBreaks();
                                            } else if (type == Type.VERTICALPAGEBREAKS) {
                                                if (this.workbookBof.isBiff8()) {
                                                    verticalPageBreaksRecord = new VerticalPageBreaksRecord(next);
                                                } else {
                                                    verticalPageBreaksRecord = new VerticalPageBreaksRecord(next, VerticalPageBreaksRecord.biff7);
                                                }
                                                this.columnBreaks = verticalPageBreaksRecord.getColumnBreaks();
                                            } else if (type == Type.PLS) {
                                                this.plsRecord = new PLSRecord(next);
                                            } else if (type == Type.DVAL) {
                                                if (!this.workbookSettings.getCellValidationDisabled()) {
                                                    DataValidityListRecord dataValidityListRecord = new DataValidityListRecord(next);
                                                    if (dataValidityListRecord.getObjectId() == -1) {
                                                        if (msoDrawingRecord != null && objRecord == null) {
                                                            if (this.drawingData == null) {
                                                                this.drawingData = new DrawingData();
                                                            }
                                                            this.drawings.add(new Drawing2(msoDrawingRecord, this.drawingData, this.workbook.getDrawingGroup()));
                                                            this.dataValidation = new DataValidation(dataValidityListRecord);
                                                            msoDrawingRecord2 = null;
                                                            baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                            objRecord2 = objRecord;
                                                        } else {
                                                            this.dataValidation = new DataValidation(dataValidityListRecord);
                                                        }
                                                    } else if (arrayList.contains(new Integer(dataValidityListRecord.getObjectId()))) {
                                                        this.dataValidation = new DataValidation(dataValidityListRecord);
                                                    } else {
                                                        logger.warn(new StringBuffer().append("object id ").append(dataValidityListRecord.getObjectId()).append(" referenced ").append(" by data validity list record not found - ignoring").toString());
                                                    }
                                                    msoDrawingRecord2 = msoDrawingRecord;
                                                    baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                    objRecord2 = objRecord;
                                                }
                                            } else if (type == Type.HCENTER) {
                                                this.settings.setHorizontalCentre(new CentreRecord(next).isCentre());
                                            } else if (type == Type.VCENTER) {
                                                this.settings.setVerticalCentre(new CentreRecord(next).isCentre());
                                            } else if (type == Type.DV) {
                                                if (!this.workbookSettings.getCellValidationDisabled()) {
                                                    WorkbookParser workbookParser5 = this.workbook;
                                                    DataValiditySettingsRecord dataValiditySettingsRecord = new DataValiditySettingsRecord(next, workbookParser5, workbookParser5, workbookParser5.getSettings());
                                                    DataValidation dataValidation = this.dataValidation;
                                                    if (dataValidation != null) {
                                                        dataValidation.add(dataValiditySettingsRecord);
                                                        addCellValidation(dataValiditySettingsRecord.getFirstColumn(), dataValiditySettingsRecord.getFirstRow(), dataValiditySettingsRecord.getLastColumn(), dataValiditySettingsRecord.getLastRow(), dataValiditySettingsRecord);
                                                    } else {
                                                        logger.warn("cannot add data validity settings");
                                                    }
                                                }
                                            } else if (type == Type.OBJ) {
                                                objRecord2 = new ObjRecord(next);
                                                if (!this.workbookSettings.getDrawingsDisabled()) {
                                                    handleObjectRecord(objRecord2, msoDrawingRecord, hashMap);
                                                    arrayList.add(new Integer(objRecord2.getObjectId()));
                                                }
                                                if (objRecord2.getType() != ObjRecord.CHART) {
                                                    baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                    c = 1;
                                                    objRecord2 = null;
                                                    msoDrawingRecord2 = null;
                                                } else {
                                                    msoDrawingRecord2 = msoDrawingRecord;
                                                    baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                }
                                            } else if (type == Type.MSODRAWING) {
                                                if (!this.workbookSettings.getDrawingsDisabled()) {
                                                    if (msoDrawingRecord != null) {
                                                        this.drawingData.addRawData(msoDrawingRecord.getData());
                                                    }
                                                    msoDrawingRecord2 = new MsoDrawingRecord(next);
                                                    if (z2) {
                                                        msoDrawingRecord2.setFirst();
                                                        baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                        objRecord2 = objRecord;
                                                        c = 1;
                                                        z2 = false;
                                                    }
                                                    baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                    objRecord2 = objRecord;
                                                }
                                            } else if (type == Type.BUTTONPROPERTYSET) {
                                                this.buttonPropertySet = new ButtonPropertySetRecord(next);
                                            } else if (type == Type.CALCMODE) {
                                                this.settings.setAutomaticFormulaCalculation(new CalcModeRecord(next).isAutomatic());
                                            } else if (type == Type.SAVERECALC) {
                                                this.settings.setRecalculateFormulasBeforeSave(new SaveRecalcRecord(next).getRecalculateOnSave());
                                            } else if (type == Type.BOF) {
                                                BOFRecord bOFRecord = new BOFRecord(next);
                                                c = 1;
                                                Assert.verify(!bOFRecord.isWorksheet());
                                                int pos = (this.excelFile.getPos() - next.getLength()) - 4;
                                                Record next2 = this.excelFile.next();
                                                while (next2.getCode() != Type.EOF.value) {
                                                    next2 = this.excelFile.next();
                                                }
                                                if (bOFRecord.isChart()) {
                                                    if (!this.workbook.getWorkbookBof().isBiff8()) {
                                                        logger.warn("only biff8 charts are supported");
                                                    } else {
                                                        if (this.drawingData == null) {
                                                            this.drawingData = new DrawingData();
                                                        }
                                                        if (!this.workbookSettings.getDrawingsDisabled()) {
                                                            Chart chart = new Chart(msoDrawingRecord, objRecord, this.drawingData, pos, this.excelFile.getPos(), this.excelFile, this.workbookSettings);
                                                            this.charts.add(chart);
                                                            if (this.workbook.getDrawingGroup() != null) {
                                                                this.workbook.getDrawingGroup().add(chart);
                                                            }
                                                        }
                                                    }
                                                    objRecord2 = null;
                                                    msoDrawingRecord2 = null;
                                                } else {
                                                    msoDrawingRecord2 = msoDrawingRecord;
                                                    objRecord2 = objRecord;
                                                }
                                                if (this.sheetBof.isChart()) {
                                                    z = false;
                                                }
                                                baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                            } else {
                                                c = 1;
                                                if (type == Type.EOF) {
                                                    msoDrawingRecord2 = msoDrawingRecord;
                                                    baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                                                    objRecord2 = objRecord;
                                                    z = false;
                                                }
                                            }
                                        }
                                        c2 = c;
                                        i = 0;
                                    }
                                }
                            }
                            c = 1;
                        }
                        c = 1;
                        c2 = c;
                        i = 0;
                    }
                    objRecord = objRecord2;
                    baseSharedFormulaRecord = baseSharedFormulaRecord3;
                    msoDrawingRecord = msoDrawingRecord2;
                    c = 1;
                }
                msoDrawingRecord2 = msoDrawingRecord;
                baseSharedFormulaRecord3 = baseSharedFormulaRecord;
                objRecord2 = objRecord;
                c2 = c;
                i = 0;
            }
            objRecord = objRecord2;
            baseSharedFormulaRecord = baseSharedFormulaRecord3;
            c = c2;
            msoDrawingRecord = msoDrawingRecord2;
            msoDrawingRecord2 = msoDrawingRecord;
            baseSharedFormulaRecord3 = baseSharedFormulaRecord;
            objRecord2 = objRecord;
            c2 = c;
            i = 0;
        }
        ObjRecord objRecord3 = objRecord2;
        BaseSharedFormulaRecord baseSharedFormulaRecord4 = baseSharedFormulaRecord3;
        MsoDrawingRecord msoDrawingRecord3 = msoDrawingRecord2;
        this.excelFile.restorePos();
        if (this.outOfBoundsCells.size() > 0) {
            handleOutOfBoundsCells();
        }
        Iterator it = this.sharedFormulas.iterator();
        while (it.hasNext()) {
            for (Cell cell : ((SharedFormulaRecord) it.next()).getFormulas(this.formattingRecords, this.nineteenFour)) {
                addCell(cell);
            }
        }
        if (!z3 && baseSharedFormulaRecord4 != null) {
            addCell(revertSharedFormula(baseSharedFormulaRecord4));
        }
        if (msoDrawingRecord3 != null && this.workbook.getDrawingGroup() != null) {
            this.workbook.getDrawingGroup().setDrawingsOmitted(msoDrawingRecord3, objRecord3);
        }
        if (hashMap.isEmpty()) {
            return;
        }
        logger.warn("Not all comments have a corresponding Note record");
    }

    private boolean addToSharedFormulas(BaseSharedFormulaRecord baseSharedFormulaRecord) {
        int size = this.sharedFormulas.size();
        boolean z = false;
        for (int i = 0; i < size && !z; i++) {
            z = ((SharedFormulaRecord) this.sharedFormulas.get(i)).add(baseSharedFormulaRecord);
        }
        return z;
    }

    private Cell revertSharedFormula(BaseSharedFormulaRecord baseSharedFormulaRecord) {
        int pos = this.excelFile.getPos();
        this.excelFile.setPos(baseSharedFormulaRecord.getFilePos());
        Record record = baseSharedFormulaRecord.getRecord();
        File file = this.excelFile;
        FormattingRecords formattingRecords = this.formattingRecords;
        WorkbookParser workbookParser = this.workbook;
        FormulaRecord formulaRecord = new FormulaRecord(record, file, formattingRecords, workbookParser, workbookParser, FormulaRecord.ignoreSharedFormula, this.sheet, this.workbookSettings);
        try {
            Cell formula = formulaRecord.getFormula();
            if (formulaRecord.getFormula().getType() == CellType.NUMBER_FORMULA) {
                NumberFormulaRecord numberFormulaRecord = (NumberFormulaRecord) formulaRecord.getFormula();
                if (this.formattingRecords.isDate(formulaRecord.getXFIndex())) {
                    FormattingRecords formattingRecords2 = this.formattingRecords;
                    WorkbookParser workbookParser2 = this.workbook;
                    formula = new DateFormulaRecord(numberFormulaRecord, formattingRecords2, workbookParser2, workbookParser2, this.nineteenFour, this.sheet);
                }
            }
            this.excelFile.setPos(pos);
            return formula;
        } catch (FormulaException e) {
            logger.warn(new StringBuffer().append(CellReferenceHelper.getCellReference(formulaRecord.getColumn(), formulaRecord.getRow())).append(StringUtils.SPACE).append(e.getMessage()).toString());
            return null;
        }
    }

    final int getNumRows() {
        return this.numRows;
    }

    final int getNumCols() {
        return this.numCols;
    }

    final Cell[][] getCells() {
        return this.cells;
    }

    final ArrayList getRowProperties() {
        return this.rowProperties;
    }

    final ArrayList getColumnInfosArray() {
        return this.columnInfosArray;
    }

    final ArrayList getHyperlinks() {
        return this.hyperlinks;
    }

    final ArrayList getCharts() {
        return this.charts;
    }

    final ArrayList getDrawings() {
        return this.drawings;
    }

    final DataValidation getDataValidation() {
        return this.dataValidation;
    }

    final Range[] getMergedCells() {
        return this.mergedCells;
    }

    final SheetSettings getSettings() {
        return this.settings;
    }

    final int[] getRowBreaks() {
        return this.rowBreaks;
    }

    final int[] getColumnBreaks() {
        return this.columnBreaks;
    }

    final WorkspaceInformationRecord getWorkspaceOptions() {
        return this.workspaceOptions;
    }

    final PLSRecord getPLS() {
        return this.plsRecord;
    }

    final ButtonPropertySetRecord getButtonPropertySet() {
        return this.buttonPropertySet;
    }

    private void addCellComment(int i, int i2, String str, double d, double d2) {
        Cell cell = this.cells[i2][i];
        if (cell == null) {
            logger.warn(new StringBuffer().append("Cell at ").append(CellReferenceHelper.getCellReference(i, i2)).append(" not present - adding a blank").toString());
            MulBlankCell mulBlankCell = new MulBlankCell(i2, i, 0, this.formattingRecords, this.sheet);
            CellFeatures cellFeatures = new CellFeatures();
            cellFeatures.setReadComment(str, d, d2);
            mulBlankCell.setCellFeatures(cellFeatures);
            addCell(mulBlankCell);
            return;
        }
        if (cell instanceof CellFeaturesAccessor) {
            CellFeaturesAccessor cellFeaturesAccessor = (CellFeaturesAccessor) cell;
            CellFeatures cellFeatures2 = cellFeaturesAccessor.getCellFeatures();
            if (cellFeatures2 == null) {
                cellFeatures2 = new CellFeatures();
                cellFeaturesAccessor.setCellFeatures(cellFeatures2);
            }
            cellFeatures2.setReadComment(str, d, d2);
            return;
        }
        logger.warn(new StringBuffer().append("Not able to add comment to cell type ").append(cell.getClass().getName()).append(" at ").append(CellReferenceHelper.getCellReference(i, i2)).toString());
    }

    private void addCellValidation(int i, int i2, int i3, int i4, DataValiditySettingsRecord dataValiditySettingsRecord) {
        for (int i5 = i2; i5 <= i4; i5++) {
            for (int i6 = i; i6 <= i3; i6++) {
                Cell cell = null;
                Cell[][] cellArr = this.cells;
                if (cellArr.length > i5 && cellArr[i5].length > i6) {
                    cell = cellArr[i5][i6];
                }
                if (cell == null) {
                    logger.warn(new StringBuffer().append("Cell at ").append(CellReferenceHelper.getCellReference(i6, i5)).append(" not present - adding a blank").toString());
                    MulBlankCell mulBlankCell = new MulBlankCell(i5, i6, 0, this.formattingRecords, this.sheet);
                    CellFeatures cellFeatures = new CellFeatures();
                    cellFeatures.setValidationSettings(dataValiditySettingsRecord);
                    mulBlankCell.setCellFeatures(cellFeatures);
                    addCell(mulBlankCell);
                    return;
                }
                if (cell instanceof CellFeaturesAccessor) {
                    CellFeaturesAccessor cellFeaturesAccessor = (CellFeaturesAccessor) cell;
                    CellFeatures cellFeatures2 = cellFeaturesAccessor.getCellFeatures();
                    if (cellFeatures2 == null) {
                        cellFeatures2 = new CellFeatures();
                        cellFeaturesAccessor.setCellFeatures(cellFeatures2);
                    }
                    cellFeatures2.setValidationSettings(dataValiditySettingsRecord);
                } else {
                    logger.warn(new StringBuffer().append("Not able to add comment to cell type ").append(cell.getClass().getName()).append(" at ").append(CellReferenceHelper.getCellReference(i6, i5)).toString());
                }
            }
        }
    }

    private void handleObjectRecord(ObjRecord objRecord, MsoDrawingRecord msoDrawingRecord, HashMap hashMap) {
        if (msoDrawingRecord == null) {
            logger.warn("Object record is not associated with a drawing  record - ignoring");
            return;
        }
        if (objRecord.getType() == ObjRecord.PICTURE) {
            if (this.drawingData == null) {
                this.drawingData = new DrawingData();
            }
            this.drawings.add(new Drawing(msoDrawingRecord, objRecord, this.drawingData, this.workbook.getDrawingGroup(), this.sheet));
            return;
        }
        if (objRecord.getType() == ObjRecord.EXCELNOTE) {
            if (this.drawingData == null) {
                this.drawingData = new DrawingData();
            }
            Comment comment = new Comment(msoDrawingRecord, objRecord, this.drawingData, this.workbook.getDrawingGroup(), this.workbookSettings);
            Record next = this.excelFile.next();
            if (next.getType() == Type.MSODRAWING) {
                comment.addMso(new MsoDrawingRecord(next));
                next = this.excelFile.next();
            }
            Assert.verify(next.getType() == Type.TXO);
            comment.setTextObject(new TextObjectRecord(next));
            Record next2 = this.excelFile.next();
            Assert.verify(next2.getType() == Type.CONTINUE);
            comment.setText(new ContinueRecord(next2));
            Record next3 = this.excelFile.next();
            if (next3.getType() == Type.CONTINUE) {
                comment.setFormatting(new ContinueRecord(next3));
            }
            hashMap.put(new Integer(comment.getObjectId()), comment);
            return;
        }
        if (objRecord.getType() == ObjRecord.COMBOBOX) {
            if (this.drawingData == null) {
                this.drawingData = new DrawingData();
            }
            this.drawings.add(new ComboBox(msoDrawingRecord, objRecord, this.drawingData, this.workbook.getDrawingGroup(), this.workbookSettings));
            return;
        }
        if (objRecord.getType() == ObjRecord.BUTTON) {
            if (this.drawingData == null) {
                this.drawingData = new DrawingData();
            }
            Button button = new Button(msoDrawingRecord, objRecord, this.drawingData, this.workbook.getDrawingGroup(), this.workbookSettings);
            Record next4 = this.excelFile.next();
            if (next4.getType() == Type.MSODRAWING) {
                button.addMso(new MsoDrawingRecord(next4));
                next4 = this.excelFile.next();
            }
            Assert.verify(next4.getType() == Type.TXO);
            button.setTextObject(new TextObjectRecord(next4));
            Record next5 = this.excelFile.next();
            Assert.verify(next5.getType() == Type.CONTINUE);
            button.setText(new ContinueRecord(next5));
            Record next6 = this.excelFile.next();
            if (next6.getType() == Type.CONTINUE) {
                button.setFormatting(new ContinueRecord(next6));
            }
            this.drawings.add(button);
            return;
        }
        if (objRecord.getType() != ObjRecord.CHART) {
            logger.warn(new StringBuffer().append(objRecord.getType()).append(" on sheet \"").append(this.sheet.getName()).append("\" not supported - omitting").toString());
            if (this.drawingData == null) {
                this.drawingData = new DrawingData();
            }
            this.drawingData.addData(msoDrawingRecord.getData());
            if (this.workbook.getDrawingGroup() != null) {
                this.workbook.getDrawingGroup().setDrawingsOmitted(msoDrawingRecord, objRecord);
            }
        }
    }

    DrawingData getDrawingData() {
        return this.drawingData;
    }

    private void handleOutOfBoundsCells() {
        int i = this.numRows;
        int i2 = this.numCols;
        Iterator it = this.outOfBoundsCells.iterator();
        while (it.hasNext()) {
            Cell cell = (Cell) it.next();
            i = Math.max(i, cell.getRow() + 1);
            i2 = Math.max(i2, cell.getColumn() + 1);
        }
        logger.warn(new StringBuffer().append("Some cells exceeded the specified bounds.  Resizing sheet dimensions from ").append(this.numCols).append("x").append(this.numRows).append(" to ").append(i2).append("x").append(i).toString());
        if (i2 > this.numCols) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                Cell[] cellArr = new Cell[i2];
                Cell[][] cellArr2 = this.cells;
                System.arraycopy(cellArr2[i3], 0, cellArr, 0, cellArr2[i3].length);
                this.cells[i3] = cellArr;
            }
        }
        if (i > this.numRows) {
            Cell[][] cellArr3 = new Cell[i][];
            Cell[][] cellArr4 = this.cells;
            System.arraycopy(cellArr4, 0, cellArr3, 0, cellArr4.length);
            this.cells = cellArr3;
        }
        this.numRows = i;
        this.numCols = i2;
        Iterator it2 = this.outOfBoundsCells.iterator();
        while (it2.hasNext()) {
            addCell((Cell) it2.next());
        }
        this.outOfBoundsCells.clear();
    }
}
