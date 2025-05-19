package org.apache.poi.xssf.usermodel;

import androidx.core.view.MotionEventCompat;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.usermodel.helpers.ColumnHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFPaswordHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

/* loaded from: classes5.dex */
public class XSSFSheet extends POIXMLDocumentPart implements Sheet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFSheet.class);
    private SortedMap<Integer, XSSFRow> _rows;
    private List<CellRangeAddress> arrayFormulas;
    private ColumnHelper columnHelper;
    private XSSFDataValidationHelper dataValidationHelper;
    private List<XSSFHyperlink> hyperlinks;
    private Map<Integer, CTCellFormula> sharedFormulas;
    protected CTSheet sheet;
    private CommentsTable sheetComments;
    private SortedMap<String, XSSFTable> tables;
    protected CTWorksheet worksheet;

    private int shiftedRowNum(int i, int i2, int i3, int i4) {
        return (i4 >= i || (i3 <= 0 && i - i4 <= i3)) ? (i4 <= i2 || (i3 >= 0 && i4 - i2 <= i3)) ? i4 < i ? i4 + (i2 - i) : i4 > i2 ? i4 - (i2 - i) : i4 + i3 : i4 : i4;
    }

    private boolean shouldRemoveRow(int i, int i2, int i3, int i4) {
        if (i4 < i + i3 || i4 > i2 + i3) {
            return false;
        }
        if (i3 <= 0 || i4 <= i2) {
            return i3 < 0 && i4 < i;
        }
        return true;
    }

    protected XSSFSheet() {
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
        onDocumentCreate();
    }

    protected XSSFSheet(PackagePart packagePart, PackageRelationship packageRelationship) {
        super(packagePart, packageRelationship);
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFWorkbook getWorkbook() {
        return (XSSFWorkbook) getParent();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() {
        try {
            read(getPackagePart().getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    protected void read(InputStream inputStream) throws IOException {
        try {
            CTWorksheet worksheet = WorksheetDocument.Factory.parse(inputStream).getWorksheet();
            this.worksheet = worksheet;
            initRows(worksheet);
            this.columnHelper = new ColumnHelper(this.worksheet);
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof CommentsTable) {
                    this.sheetComments = (CommentsTable) pOIXMLDocumentPart;
                }
                if (pOIXMLDocumentPart instanceof XSSFTable) {
                    this.tables.put(pOIXMLDocumentPart.getPackageRelationship().getId(), (XSSFTable) pOIXMLDocumentPart);
                }
                if (pOIXMLDocumentPart instanceof XSSFPivotTable) {
                    getWorkbook().getPivotTables().add((XSSFPivotTable) pOIXMLDocumentPart);
                }
            }
            initHyperlinks();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentCreate() {
        CTWorksheet newSheet = newSheet();
        this.worksheet = newSheet;
        initRows(newSheet);
        this.columnHelper = new ColumnHelper(this.worksheet);
        this.hyperlinks = new ArrayList();
    }

    private void initRows(CTWorksheet cTWorksheet) {
        this._rows = new TreeMap();
        this.tables = new TreeMap();
        this.sharedFormulas = new HashMap();
        this.arrayFormulas = new ArrayList();
        for (CTRow cTRow : cTWorksheet.getSheetData().getRowArray()) {
            XSSFRow xSSFRow = new XSSFRow(cTRow, this);
            this._rows.put(Integer.valueOf(xSSFRow.getRowNum()), xSSFRow);
        }
    }

    private void initHyperlinks() {
        this.hyperlinks = new ArrayList();
        if (this.worksheet.isSetHyperlinks()) {
            try {
                PackageRelationshipCollection relationshipsByType = getPackagePart().getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation());
                for (CTHyperlink cTHyperlink : this.worksheet.getHyperlinks().getHyperlinkArray()) {
                    this.hyperlinks.add(new XSSFHyperlink(cTHyperlink, cTHyperlink.getId() != null ? relationshipsByType.getRelationshipByID(cTHyperlink.getId()) : null));
                }
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }
    }

    private static CTWorksheet newSheet() {
        CTWorksheet newInstance = CTWorksheet.Factory.newInstance();
        newInstance.addNewSheetFormatPr().setDefaultRowHeight(15.0d);
        newInstance.addNewSheetViews().addNewSheetView().setWorkbookViewId(0L);
        newInstance.addNewDimension().setRef("A1");
        newInstance.addNewSheetData();
        CTPageMargins addNewPageMargins = newInstance.addNewPageMargins();
        addNewPageMargins.setBottom(0.75d);
        addNewPageMargins.setFooter(0.3d);
        addNewPageMargins.setHeader(0.3d);
        addNewPageMargins.setLeft(0.7d);
        addNewPageMargins.setRight(0.7d);
        addNewPageMargins.setTop(0.75d);
        return newInstance;
    }

    @Internal
    public CTWorksheet getCTWorksheet() {
        return this.worksheet;
    }

    public ColumnHelper getColumnHelper() {
        return this.columnHelper;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        return this.sheet.getName();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegion(CellRangeAddress cellRangeAddress) {
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
        validateArrayFormulas(cellRangeAddress);
        CTMergeCells mergeCells = this.worksheet.isSetMergeCells() ? this.worksheet.getMergeCells() : this.worksheet.addNewMergeCells();
        mergeCells.addNewMergeCell().setRef(cellRangeAddress.formatAsString());
        return mergeCells.sizeOfMergeCellArray();
    }

    private void validateArrayFormulas(CellRangeAddress cellRangeAddress) {
        XSSFCell cell;
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            for (int i = firstColumn; i <= lastColumn; i++) {
                XSSFRow row = getRow(firstRow);
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
            this.columnHelper.setColBestFit(i, true);
        }
    }

    public XSSFDrawing getDrawingPatriarch() {
        CTDrawing cTDrawing = getCTDrawing();
        if (cTDrawing == null) {
            return null;
        }
        Iterator<POIXMLDocumentPart> it = getRelations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            POIXMLDocumentPart next = it.next();
            if (next instanceof XSSFDrawing) {
                XSSFDrawing xSSFDrawing = (XSSFDrawing) next;
                if (xSSFDrawing.getPackageRelationship().getId().equals(cTDrawing.getId())) {
                    return xSSFDrawing;
                }
            }
        }
        logger.log(7, "Can't find drawing with id=" + cTDrawing.getId() + " in the list of the sheet's relationships");
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFDrawing createDrawingPatriarch() {
        if (getCTDrawing() != null) {
            return getDrawingPatriarch();
        }
        XSSFDrawing xSSFDrawing = (XSSFDrawing) createRelationship(XSSFRelation.DRAWINGS, XSSFFactory.getInstance(), getPackagePart().getPackage().getPartsByContentType(XSSFRelation.DRAWINGS.getContentType()).size() + 1);
        this.worksheet.addNewDrawing().setId(xSSFDrawing.getPackageRelationship().getId());
        return xSSFDrawing;
    }

    protected XSSFVMLDrawing getVMLDrawing(boolean z) {
        CTLegacyDrawing cTLegacyDrawing = getCTLegacyDrawing();
        XSSFVMLDrawing xSSFVMLDrawing = null;
        if (cTLegacyDrawing == null) {
            if (!z) {
                return null;
            }
            XSSFVMLDrawing xSSFVMLDrawing2 = (XSSFVMLDrawing) createRelationship(XSSFRelation.VML_DRAWINGS, XSSFFactory.getInstance(), getPackagePart().getPackage().getPartsByContentType(XSSFRelation.VML_DRAWINGS.getContentType()).size() + 1);
            this.worksheet.addNewLegacyDrawing().setId(xSSFVMLDrawing2.getPackageRelationship().getId());
            return xSSFVMLDrawing2;
        }
        Iterator<POIXMLDocumentPart> it = getRelations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            POIXMLDocumentPart next = it.next();
            if (next instanceof XSSFVMLDrawing) {
                XSSFVMLDrawing xSSFVMLDrawing3 = (XSSFVMLDrawing) next;
                if (xSSFVMLDrawing3.getPackageRelationship().getId().equals(cTLegacyDrawing.getId())) {
                    xSSFVMLDrawing = xSSFVMLDrawing3;
                }
            }
        }
        if (xSSFVMLDrawing != null) {
            return xSSFVMLDrawing;
        }
        logger.log(7, "Can't find VML drawing with id=" + cTLegacyDrawing.getId() + " in the list of the sheet's relationships");
        return xSSFVMLDrawing;
    }

    protected CTDrawing getCTDrawing() {
        return this.worksheet.getDrawing();
    }

    protected CTLegacyDrawing getCTLegacyDrawing() {
        return this.worksheet.getLegacyDrawing();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i, int i2) {
        createFreezePane(i, i2, i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i, int i2, int i3, int i4) {
        CTSheetView defaultSheetView = getDefaultSheetView();
        if (i == 0 && i2 == 0) {
            if (defaultSheetView.isSetPane()) {
                defaultSheetView.unsetPane();
            }
            defaultSheetView.setSelectionArray(null);
            return;
        }
        if (!defaultSheetView.isSetPane()) {
            defaultSheetView.addNewPane();
        }
        CTPane pane = defaultSheetView.getPane();
        if (i > 0) {
            pane.setXSplit(i);
        } else if (pane.isSetXSplit()) {
            pane.unsetXSplit();
        }
        if (i2 > 0) {
            pane.setYSplit(i2);
        } else if (pane.isSetYSplit()) {
            pane.unsetYSplit();
        }
        pane.setState(STPaneState.FROZEN);
        if (i2 == 0) {
            pane.setTopLeftCell(new CellReference(0, i3).formatAsString());
            pane.setActivePane(STPane.TOP_RIGHT);
        } else if (i == 0) {
            pane.setTopLeftCell(new CellReference(i4, 0).formatAsString());
            pane.setActivePane(STPane.BOTTOM_LEFT);
        } else {
            pane.setTopLeftCell(new CellReference(i4, i3).formatAsString());
            pane.setActivePane(STPane.BOTTOM_RIGHT);
        }
        defaultSheetView.setSelectionArray(null);
        defaultSheetView.addNewSelection().setPane(pane.getActivePane());
    }

    @Deprecated
    public XSSFComment createComment() {
        return createDrawingPatriarch().createCellComment((ClientAnchor) new XSSFClientAnchor());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFRow createRow(int i) {
        CTRow addNewRow;
        XSSFRow xSSFRow = this._rows.get(Integer.valueOf(i));
        if (xSSFRow != null) {
            addNewRow = xSSFRow.getCTRow();
            addNewRow.set(CTRow.Factory.newInstance());
        } else if (this._rows.isEmpty() || i > this._rows.lastKey().intValue()) {
            addNewRow = this.worksheet.getSheetData().addNewRow();
        } else {
            addNewRow = this.worksheet.getSheetData().insertNewRow(this._rows.headMap(Integer.valueOf(i)).size());
        }
        XSSFRow xSSFRow2 = new XSSFRow(addNewRow, this);
        xSSFRow2.setRowNum(i);
        this._rows.put(Integer.valueOf(i), xSSFRow2);
        return xSSFRow2;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createSplitPane(int i, int i2, int i3, int i4, int i5) {
        createFreezePane(i, i2, i3, i4);
        getPane().setState(STPaneState.SPLIT);
        getPane().setActivePane(STPane.Enum.forInt(i5));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFComment getCellComment(int i, int i2) {
        if (this.sheetComments == null) {
            return null;
        }
        CTComment cTComment = this.sheetComments.getCTComment(new CellReference(i, i2).formatAsString());
        if (cTComment == null) {
            return null;
        }
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(false);
        return new XSSFComment(this.sheetComments, cTComment, vMLDrawing != null ? vMLDrawing.findCommentShape(i, i2) : null);
    }

    public XSSFHyperlink getHyperlink(int i, int i2) {
        String formatAsString = new CellReference(i, i2).formatAsString();
        for (XSSFHyperlink xSSFHyperlink : this.hyperlinks) {
            if (xSSFHyperlink.getCellRef().equals(formatAsString)) {
                return xSSFHyperlink;
            }
        }
        return null;
    }

    private int[] getBreaks(CTPageBreak cTPageBreak) {
        CTBreak[] brkArray = cTPageBreak.getBrkArray();
        int[] iArr = new int[brkArray.length];
        for (int i = 0; i < brkArray.length; i++) {
            iArr[i] = ((int) brkArray[i].getId()) - 1;
        }
        return iArr;
    }

    private void removeBreak(int i, CTPageBreak cTPageBreak) {
        int i2 = i + 1;
        CTBreak[] brkArray = cTPageBreak.getBrkArray();
        for (int i3 = 0; i3 < brkArray.length; i3++) {
            if (brkArray[i3].getId() == i2) {
                cTPageBreak.removeBrk(i3);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this.worksheet.isSetColBreaks() ? getBreaks(this.worksheet.getColBreaks()) : new int[0];
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnWidth(int i) {
        CTCol column = this.columnHelper.getColumn(i, false);
        return (int) (((column == null || !column.isSetWidth()) ? getDefaultColumnWidth() : column.getWidth()) * 256.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i) {
        return (float) ((getColumnWidth(i) / 256.0d) * 7.001699924468994d);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        CTSheetFormatPr sheetFormatPr = this.worksheet.getSheetFormatPr();
        if (sheetFormatPr == null) {
            return 8;
        }
        return (int) sheetFormatPr.getBaseColWidth();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return (short) (getDefaultRowHeightInPoints() * 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        CTSheetFormatPr sheetFormatPr = this.worksheet.getSheetFormatPr();
        return (float) (sheetFormatPr == null ? 0.0d : sheetFormatPr.getDefaultRowHeight());
    }

    private CTSheetFormatPr getSheetTypeSheetFormatPr() {
        return this.worksheet.isSetSheetFormatPr() ? this.worksheet.getSheetFormatPr() : this.worksheet.addNewSheetFormatPr();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellStyle getColumnStyle(int i) {
        int colDefaultStyle = this.columnHelper.getColDefaultStyle(i);
        XSSFWorkbook workbook = getWorkbook();
        if (colDefaultStyle == -1) {
            colDefaultStyle = 0;
        }
        return workbook.getCellStyleAt((short) colDefaultStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRightToLeft(boolean z) {
        getDefaultSheetView().setRightToLeft(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRightToLeft() {
        CTSheetView defaultSheetView = getDefaultSheetView();
        return defaultSheetView != null && defaultSheetView.getRightToLeft();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return (sheetTypeSheetPr.getOutlinePr() == null ? CTOutlinePr.Factory.newInstance() : sheetTypeSheetPr.getOutlinePr()).getShowOutlineSymbols();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGuts(boolean z) {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        (sheetTypeSheetPr.getOutlinePr() == null ? sheetTypeSheetPr.addNewOutlinePr() : sheetTypeSheetPr.getOutlinePr()).setShowOutlineSymbols(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        CTSheetView defaultSheetView = getDefaultSheetView();
        return defaultSheetView == null || defaultSheetView.getShowZeros();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayZeros(boolean z) {
        getSheetTypeSheetView().setShowZeros(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getFirstRowNum() {
        if (this._rows.isEmpty()) {
            return 0;
        }
        return this._rows.firstKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getFitToPage() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return ((sheetTypeSheetPr == null || !sheetTypeSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : sheetTypeSheetPr.getPageSetUpPr()).getFitToPage();
    }

    private CTSheetPr getSheetTypeSheetPr() {
        if (this.worksheet.getSheetPr() == null) {
            this.worksheet.setSheetPr(CTSheetPr.Factory.newInstance());
        }
        return this.worksheet.getSheetPr();
    }

    private CTHeaderFooter getSheetTypeHeaderFooter() {
        if (this.worksheet.getHeaderFooter() == null) {
            this.worksheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
        }
        return this.worksheet.getHeaderFooter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Footer getFooter() {
        return getOddFooter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Header getHeader() {
        return getOddHeader();
    }

    public Footer getOddFooter() {
        return new XSSFOddFooter(getSheetTypeHeaderFooter());
    }

    public Footer getEvenFooter() {
        return new XSSFEvenFooter(getSheetTypeHeaderFooter());
    }

    public Footer getFirstFooter() {
        return new XSSFFirstFooter(getSheetTypeHeaderFooter());
    }

    public Header getOddHeader() {
        return new XSSFOddHeader(getSheetTypeHeaderFooter());
    }

    public Header getEvenHeader() {
        return new XSSFEvenHeader(getSheetTypeHeaderFooter());
    }

    public Header getFirstHeader() {
        return new XSSFFirstHeader(getSheetTypeHeaderFooter());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getHorizontalCentered();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getLastRowNum() {
        if (this._rows.isEmpty()) {
            return 0;
        }
        return this._rows.lastKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getLeftCol() {
        String topLeftCell = this.worksheet.getSheetViews().getSheetViewArray(0).getTopLeftCell();
        if (topLeftCell == null) {
            return (short) 0;
        }
        return new CellReference(topLeftCell).getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public double getMargin(short s) {
        if (!this.worksheet.isSetPageMargins()) {
            return 0.0d;
        }
        CTPageMargins pageMargins = this.worksheet.getPageMargins();
        if (s == 0) {
            return pageMargins.getLeft();
        }
        if (s == 1) {
            return pageMargins.getRight();
        }
        if (s == 2) {
            return pageMargins.getTop();
        }
        if (s == 3) {
            return pageMargins.getBottom();
        }
        if (s == 4) {
            return pageMargins.getHeader();
        }
        if (s == 5) {
            return pageMargins.getFooter();
        }
        throw new IllegalArgumentException("Unknown margin constant:  " + ((int) s));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setMargin(short s, double d) {
        CTPageMargins pageMargins = this.worksheet.isSetPageMargins() ? this.worksheet.getPageMargins() : this.worksheet.addNewPageMargins();
        if (s == 0) {
            pageMargins.setLeft(d);
            return;
        }
        if (s == 1) {
            pageMargins.setRight(d);
            return;
        }
        if (s == 2) {
            pageMargins.setTop(d);
            return;
        }
        if (s == 3) {
            pageMargins.setBottom(d);
        } else if (s == 4) {
            pageMargins.setHeader(d);
        } else {
            if (s == 5) {
                pageMargins.setFooter(d);
                return;
            }
            throw new IllegalArgumentException("Unknown margin constant:  " + ((int) s));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i) {
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells == null) {
            throw new IllegalStateException("This worksheet does not contain merged regions");
        }
        return CellRangeAddress.valueOf(mergeCells.getMergeCellArray(i).getRef());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells == null) {
            return 0;
        }
        return mergeCells.sizeOfMergeCellArray();
    }

    public int getNumHyperlinks() {
        return this.hyperlinks.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        CTPane pane = getDefaultSheetView().getPane();
        if (pane == null) {
            return null;
        }
        CellReference cellReference = pane.isSetTopLeftCell() ? new CellReference(pane.getTopLeftCell()) : null;
        return new PaneInformation((short) pane.getXSplit(), (short) pane.getYSplit(), (short) (cellReference == null ? 0 : cellReference.getRow()), cellReference == null ? (short) 0 : cellReference.getCol(), (byte) (pane.getActivePane().intValue() - 1), pane.getState() == STPaneState.FROZEN);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFPrintSetup getPrintSetup() {
        return new XSSFPrintSetup(this.worksheet);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getProtect() {
        return isSheetLocked();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void protectSheet(String str) {
        if (str != null) {
            CTSheetProtection safeGetProtectionField = safeGetProtectionField();
            setSheetPassword(str, null);
            safeGetProtectionField.setSheet(true);
            safeGetProtectionField.setScenarios(true);
            safeGetProtectionField.setObjects(true);
            return;
        }
        this.worksheet.unsetSheetProtection();
    }

    public void setSheetPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || isSheetProtectionEnabled()) {
            XSSFPaswordHelper.setPassword(safeGetProtectionField(), str, hashAlgorithm, null);
        }
    }

    public boolean validateSheetPassword(String str) {
        if (isSheetProtectionEnabled()) {
            return XSSFPaswordHelper.validatePassword(safeGetProtectionField(), str, null);
        }
        return str == null;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFRow getRow(int i) {
        return this._rows.get(Integer.valueOf(i));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getRowBreaks() {
        return this.worksheet.isSetRowBreaks() ? getBreaks(this.worksheet.getRowBreaks()) : new int[0];
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        CTOutlinePr outlinePr = (sheetPr == null || !sheetPr.isSetOutlinePr()) ? null : sheetPr.getOutlinePr();
        return outlinePr == null || outlinePr.getSummaryBelow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z) {
        ensureOutlinePr().setSummaryBelow(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        return ((sheetPr == null || !sheetPr.isSetOutlinePr()) ? CTOutlinePr.Factory.newInstance() : sheetPr.getOutlinePr()).getSummaryRight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsRight(boolean z) {
        ensureOutlinePr().setSummaryRight(z);
    }

    private CTOutlinePr ensureOutlinePr() {
        CTSheetPr sheetPr = this.worksheet.isSetSheetPr() ? this.worksheet.getSheetPr() : this.worksheet.addNewSheetPr();
        return sheetPr.isSetOutlinePr() ? sheetPr.getOutlinePr() : sheetPr.addNewOutlinePr();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return this.worksheet.isSetSheetProtection() && this.worksheet.getSheetProtection().getScenarios();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getTopRow() {
        String topLeftCell = getSheetTypeSheetView().getTopLeftCell();
        if (topLeftCell == null) {
            return (short) 0;
        }
        return (short) new CellReference(topLeftCell).getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getVerticalCentered();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupColumn(int i, int i2) {
        groupColumn1Based(i + 1, i2 + 1);
    }

    private void groupColumn1Based(int i, int i2) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol newInstance = CTCol.Factory.newInstance();
        long j = i2;
        CTCol column1Based = this.columnHelper.getColumn1Based(j, false);
        if (column1Based != null) {
            column1Based = (CTCol) column1Based.copy();
        }
        newInstance.setMin(i);
        newInstance.setMax(j);
        this.columnHelper.addCleanColIntoCols(colsArray, newInstance);
        CTCol column1Based2 = this.columnHelper.getColumn1Based(j, false);
        if (column1Based != null && column1Based2 != null) {
            this.columnHelper.setColumnAttributes(column1Based, column1Based2);
        }
        while (i <= i2) {
            CTCol column1Based3 = this.columnHelper.getColumn1Based(i, false);
            column1Based3.setOutlineLevel((short) (column1Based3.getOutlineLevel() + 1));
            i = ((int) column1Based3.getMax()) + 1;
        }
        this.worksheet.setColsArray(0, colsArray);
        setSheetFormatPrOutlineLevelCol();
    }

    private void setColWidthAttribute(CTCols cTCols) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (!cTCol.isSetWidth()) {
                cTCol.setWidth(getDefaultColumnWidth());
                cTCol.setCustomWidth(false);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupRow(int i, int i2) {
        while (i <= i2) {
            XSSFRow row = getRow(i);
            if (row == null) {
                row = createRow(i);
            }
            CTRow cTRow = row.getCTRow();
            cTRow.setOutlineLevel((short) (cTRow.getOutlineLevel() + 1));
            i++;
        }
        setSheetFormatPrOutlineLevelRow();
    }

    private short getMaxOutlineLevelRows() {
        Iterator<XSSFRow> it = this._rows.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i = Math.max(i, (int) it.next().getCTRow().getOutlineLevel());
        }
        return (short) i;
    }

    private short getMaxOutlineLevelCols() {
        int i = 0;
        for (CTCol cTCol : this.worksheet.getColsArray(0).getColArray()) {
            i = Math.max(i, (int) cTCol.getOutlineLevel());
        }
        return (short) i;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnBroken(int i) {
        for (int i2 : getColumnBreaks()) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnHidden(int i) {
        CTCol column = this.columnHelper.getColumn(i, false);
        return column != null && column.getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        return getSheetTypeSheetView().getShowFormulas();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        return getSheetTypeSheetView().getShowGridLines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z) {
        getSheetTypeSheetView().setShowGridLines(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        return getSheetTypeSheetView().getShowRowColHeaders();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z) {
        getSheetTypeSheetView().setShowRowColHeaders(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getGridLines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintGridlines(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setGridLines(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRowBroken(int i) {
        for (int i2 : getRowBreaks()) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void setBreak(int i, CTPageBreak cTPageBreak, int i2) {
        CTBreak addNewBrk = cTPageBreak.addNewBrk();
        addNewBrk.setId(i + 1);
        addNewBrk.setMan(true);
        addNewBrk.setMax(i2);
        long sizeOfBrkArray = cTPageBreak.sizeOfBrkArray();
        cTPageBreak.setCount(sizeOfBrkArray);
        cTPageBreak.setManualBreakCount(sizeOfBrkArray);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowBreak(int i) {
        if (isRowBroken(i)) {
            return;
        }
        setBreak(i, this.worksheet.isSetRowBreaks() ? this.worksheet.getRowBreaks() : this.worksheet.addNewRowBreaks(), SpreadsheetVersion.EXCEL2007.getLastColumnIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeColumnBreak(int i) {
        if (this.worksheet.isSetColBreaks()) {
            removeBreak(i, this.worksheet.getColBreaks());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegion(int i) {
        if (this.worksheet.isSetMergeCells()) {
            CTMergeCells mergeCells = this.worksheet.getMergeCells();
            if (mergeCells.sizeOfMergeCellArray() > 1) {
                mergeCells.removeMergeCell(i);
            } else {
                this.worksheet.unsetMergeCells();
            }
        }
    }

    public void removeMergedRegions(Set<Integer> set) {
        if (this.worksheet.isSetMergeCells()) {
            CTMergeCells mergeCells = this.worksheet.getMergeCells();
            ArrayList arrayList = new ArrayList(mergeCells.sizeOfMergeCellArray());
            CTMergeCell[] mergeCellArray = mergeCells.getMergeCellArray();
            int length = mergeCellArray.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                CTMergeCell cTMergeCell = mergeCellArray[i];
                int i3 = i2 + 1;
                if (!set.contains(Integer.valueOf(i2))) {
                    arrayList.add(cTMergeCell);
                }
                i++;
                i2 = i3;
            }
            if (arrayList.isEmpty()) {
                this.worksheet.unsetMergeCells();
            } else {
                mergeCells.setMergeCellArray((CTMergeCell[]) arrayList.toArray(new CTMergeCell[arrayList.size()]));
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRow(Row row) {
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Cell> it = row.iterator();
        while (it.hasNext()) {
            arrayList.add((XSSFCell) it.next());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            row.removeCell((XSSFCell) it2.next());
        }
        int size = this._rows.headMap(Integer.valueOf(row.getRowNum())).size();
        this._rows.remove(Integer.valueOf(row.getRowNum()));
        this.worksheet.getSheetData().removeRow(size);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRowBreak(int i) {
        if (this.worksheet.isSetRowBreaks()) {
            removeBreak(i, this.worksheet.getRowBreaks());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z) {
        CTCalcPr calcPr = getWorkbook().getCTWorkbook().getCalcPr();
        if (this.worksheet.isSetSheetCalcPr()) {
            this.worksheet.getSheetCalcPr().setFullCalcOnLoad(z);
        } else if (z) {
            this.worksheet.addNewSheetCalcPr().setFullCalcOnLoad(z);
        }
        if (z && calcPr != null && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        if (this.worksheet.isSetSheetCalcPr()) {
            return this.worksheet.getSheetCalcPr().getFullCalcOnLoad();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Row> iterator() {
        return rowIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getAutobreaks() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return ((sheetTypeSheetPr == null || !sheetTypeSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : sheetTypeSheetPr.getPageSetUpPr()).getAutoPageBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setAutobreaks(boolean z) {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        (sheetTypeSheetPr.isSetPageSetUpPr() ? sheetTypeSheetPr.getPageSetUpPr() : sheetTypeSheetPr.addNewPageSetUpPr()).setAutoPageBreaks(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnBreak(int i) {
        if (isColumnBroken(i)) {
            return;
        }
        setBreak(i, this.worksheet.isSetColBreaks() ? this.worksheet.getColBreaks() : this.worksheet.addNewColBreaks(), SpreadsheetVersion.EXCEL2007.getLastRowIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i, boolean z) {
        if (z) {
            collapseColumn(i);
        } else {
            expandColumn(i);
        }
    }

    private void collapseColumn(int i) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        int indexOfColumn = this.columnHelper.getIndexOfColumn(colsArray, this.columnHelper.getColumn(i, false));
        if (indexOfColumn == -1) {
            return;
        }
        int findStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(indexOfColumn);
        setColumn(setGroupHidden(findStartOfColumnOutlineGroup, colsArray.getColArray(findStartOfColumnOutlineGroup).getOutlineLevel(), true) + 1, 0, null, null, Boolean.TRUE);
    }

    private void setColumn(int i, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        CTCol cTCol;
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            cTCol = colArray[i2];
            long min = cTCol.getMin();
            long max = cTCol.getMax();
            long j = i;
            if (min >= j && max <= j) {
                break;
            } else {
                if (min > j) {
                    break;
                }
            }
        }
        cTCol = null;
        if (cTCol == null) {
            CTCol newInstance = CTCol.Factory.newInstance();
            long j2 = i;
            newInstance.setMin(j2);
            newInstance.setMax(j2);
            unsetCollapsed(bool2.booleanValue(), newInstance);
            this.columnHelper.addCleanColIntoCols(colsArray, newInstance);
            return;
        }
        if ((num2 != null && cTCol.getOutlineLevel() != num2.intValue()) || (bool != null && cTCol.getHidden() != bool.booleanValue()) || (bool2 != null && cTCol.getCollapsed() != bool2.booleanValue()) || (num != null && (cTCol.getStyle() > ((long) num.intValue()) ? 1 : (cTCol.getStyle() == ((long) num.intValue()) ? 0 : -1)) != 0)) {
            long min2 = cTCol.getMin();
            long max2 = cTCol.getMax();
            long j3 = i;
            if (min2 == j3 && max2 == j3) {
                unsetCollapsed(bool2.booleanValue(), cTCol);
                return;
            }
            if (min2 == j3 || max2 == j3) {
                if (min2 == j3) {
                    cTCol.setMin(i + 1);
                } else {
                    cTCol.setMax(i - 1);
                }
                CTCol cloneCol = this.columnHelper.cloneCol(colsArray, cTCol);
                cloneCol.setMin(j3);
                unsetCollapsed(bool2.booleanValue(), cloneCol);
                this.columnHelper.addCleanColIntoCols(colsArray, cloneCol);
                return;
            }
            CTCol cloneCol2 = this.columnHelper.cloneCol(colsArray, cTCol);
            CTCol cloneCol3 = this.columnHelper.cloneCol(colsArray, cTCol);
            cTCol.setMax(i - 1);
            cloneCol2.setMin(j3);
            cloneCol2.setMax(j3);
            unsetCollapsed(bool2.booleanValue(), cloneCol2);
            this.columnHelper.addCleanColIntoCols(colsArray, cloneCol2);
            cloneCol3.setMin(i + 1);
            cloneCol3.setMax((int) max2);
            this.columnHelper.addCleanColIntoCols(colsArray, cloneCol3);
        }
    }

    private void unsetCollapsed(boolean z, CTCol cTCol) {
        if (z) {
            cTCol.setCollapsed(z);
        } else {
            cTCol.unsetCollapsed();
        }
    }

    private int setGroupHidden(int i, int i2, boolean z) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i];
        while (i < colArray.length) {
            cTCol.setHidden(z);
            i++;
            if (i < colArray.length) {
                CTCol cTCol2 = colArray[i];
                if (!isAdjacentBefore(cTCol, cTCol2) || cTCol2.getOutlineLevel() < i2) {
                    break;
                }
                cTCol = cTCol2;
            }
        }
        return (int) cTCol.getMax();
    }

    private boolean isAdjacentBefore(CTCol cTCol, CTCol cTCol2) {
        return cTCol.getMax() == cTCol2.getMin() - 1;
    }

    private int findStartOfColumnOutlineGroup(int i) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i];
        short outlineLevel = cTCol.getOutlineLevel();
        while (i != 0) {
            CTCol cTCol2 = colArray[i - 1];
            if (!isAdjacentBefore(cTCol2, cTCol) || cTCol2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i--;
            cTCol = cTCol2;
        }
        return i;
    }

    private int findEndOfColumnOutlineGroup(int i) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i];
        short outlineLevel = cTCol.getOutlineLevel();
        int length = colArray.length - 1;
        while (i < length) {
            int i2 = i + 1;
            CTCol cTCol2 = colArray[i2];
            if (!isAdjacentBefore(cTCol, cTCol2) || cTCol2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i = i2;
            cTCol = cTCol2;
        }
        return i;
    }

    private void expandColumn(int i) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol column = this.columnHelper.getColumn(i, false);
        int findColInfoIdx = findColInfoIdx((int) column.getMax(), this.columnHelper.getIndexOfColumn(colsArray, column));
        if (findColInfoIdx != -1 && isColumnGroupCollapsed(findColInfoIdx)) {
            int findEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(findColInfoIdx);
            CTCol[] colArray = colsArray.getColArray();
            CTCol cTCol = colArray[findEndOfColumnOutlineGroup];
            if (!isColumnGroupHiddenByParent(findColInfoIdx)) {
                short outlineLevel = cTCol.getOutlineLevel();
                boolean z = false;
                for (int findStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(findColInfoIdx); findStartOfColumnOutlineGroup <= findEndOfColumnOutlineGroup; findStartOfColumnOutlineGroup++) {
                    CTCol cTCol2 = colArray[findStartOfColumnOutlineGroup];
                    if (outlineLevel == cTCol2.getOutlineLevel()) {
                        cTCol2.unsetHidden();
                        if (z) {
                            cTCol2.setCollapsed(true);
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                }
            }
            setColumn(((int) cTCol.getMax()) + 1, null, null, Boolean.FALSE, Boolean.FALSE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isColumnGroupHiddenByParent(int r6) {
        /*
            r5 = this;
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r5.worksheet
            r1 = 0
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols r0 = r0.getColsArray(r1)
            int r2 = r5.findEndOfColumnOutlineGroup(r6)
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol[] r0 = r0.getColArray()
            int r3 = r0.length
            if (r2 >= r3) goto L27
            int r3 = r2 + 1
            r3 = r0[r3]
            r2 = r0[r2]
            boolean r2 = r5.isAdjacentBefore(r2, r3)
            if (r2 == 0) goto L27
            short r2 = r3.getOutlineLevel()
            boolean r3 = r3.getHidden()
            goto L29
        L27:
            r2 = r1
            r3 = r2
        L29:
            int r6 = r5.findStartOfColumnOutlineGroup(r6)
            if (r6 <= 0) goto L44
            int r4 = r6 + (-1)
            r4 = r0[r4]
            r6 = r0[r6]
            boolean r6 = r5.isAdjacentBefore(r4, r6)
            if (r6 == 0) goto L44
            short r1 = r4.getOutlineLevel()
            boolean r6 = r4.getHidden()
            goto L45
        L44:
            r6 = r1
        L45:
            if (r2 <= r1) goto L48
            return r3
        L48:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xssf.usermodel.XSSFSheet.isColumnGroupHiddenByParent(int):boolean");
    }

    private int findColInfoIdx(int i, int i2) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        if (i < 0) {
            throw new IllegalArgumentException("column parameter out of range: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("fromIdx parameter out of range: " + i2);
        }
        CTCol[] colArray = colsArray.getColArray();
        for (int i3 = i2; i3 < colArray.length; i3++) {
            CTCol cTCol = colArray[i3];
            if (containsColumn(cTCol, i)) {
                return i3;
            }
            if (cTCol.getMin() > i2) {
                return -1;
            }
        }
        return -1;
    }

    private boolean containsColumn(CTCol cTCol, int i) {
        long j = i;
        return cTCol.getMin() <= j && j <= cTCol.getMax();
    }

    private boolean isColumnGroupCollapsed(int i) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        int findEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i);
        int i2 = findEndOfColumnOutlineGroup + 1;
        if (i2 >= colArray.length) {
            return false;
        }
        CTCol cTCol = colArray[i2];
        if (isAdjacentBefore(colArray[findEndOfColumnOutlineGroup], cTCol)) {
            return cTCol.getCollapsed();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnHidden(int i, boolean z) {
        this.columnHelper.setColHidden(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnWidth(int i, int i2) {
        if (i2 > 65280) {
            throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
        }
        long j = i;
        this.columnHelper.setColWidth(j, i2 / 256.0d);
        this.columnHelper.setCustomWidth(j, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i, CellStyle cellStyle) {
        this.columnHelper.setColDefaultStyle(i, cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i) {
        getSheetTypeSheetFormatPr().setBaseColWidth(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeight(short s) {
        setDefaultRowHeightInPoints(s / 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f) {
        CTSheetFormatPr sheetTypeSheetFormatPr = getSheetTypeSheetFormatPr();
        sheetTypeSheetFormatPr.setDefaultRowHeight(f);
        sheetTypeSheetFormatPr.setCustomHeight(true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z) {
        getSheetTypeSheetView().setShowFormulas(z);
    }

    private CTSheetView getSheetTypeSheetView() {
        if (getDefaultSheetView() == null) {
            getSheetTypeSheetViews().setSheetViewArray(0, CTSheetView.Factory.newInstance());
        }
        return getDefaultSheetView();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setFitToPage(boolean z) {
        getSheetTypePageSetUpPr().setFitToPage(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setHorizontalCentered(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setVerticalCentered(z);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i, boolean z) {
        if (z) {
            collapseRow(i);
        } else {
            expandRow(i);
        }
    }

    private void collapseRow(int i) {
        XSSFRow row = getRow(i);
        if (row != null) {
            int writeHidden = writeHidden(row, findStartOfRowOutlineGroup(i), true);
            if (getRow(writeHidden) != null) {
                getRow(writeHidden).getCTRow().setCollapsed(true);
            } else {
                createRow(writeHidden).getCTRow().setCollapsed(true);
            }
        }
    }

    private int findStartOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getCTRow().getOutlineLevel();
        while (getRow(i) != null) {
            if (getRow(i).getCTRow().getOutlineLevel() < outlineLevel) {
                return i + 1;
            }
            i--;
        }
        return i;
    }

    private int writeHidden(XSSFRow xSSFRow, int i, boolean z) {
        short outlineLevel = xSSFRow.getCTRow().getOutlineLevel();
        Iterator<Row> rowIterator = rowIterator();
        while (rowIterator.hasNext()) {
            XSSFRow xSSFRow2 = (XSSFRow) rowIterator.next();
            if (xSSFRow2.getRowNum() >= i && xSSFRow2.getCTRow().getOutlineLevel() >= outlineLevel) {
                xSSFRow2.getCTRow().setHidden(z);
                i++;
            }
        }
        return i;
    }

    private void expandRow(int i) {
        if (i == -1) {
            return;
        }
        XSSFRow row = getRow(i);
        if (row.getCTRow().isSetHidden()) {
            int findEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i);
            short outlineLevel = row.getCTRow().getOutlineLevel();
            if (!isRowGroupHiddenByParent(i)) {
                for (int findStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i); findStartOfRowOutlineGroup < findEndOfRowOutlineGroup; findStartOfRowOutlineGroup++) {
                    if (outlineLevel == getRow(findStartOfRowOutlineGroup).getCTRow().getOutlineLevel()) {
                        getRow(findStartOfRowOutlineGroup).getCTRow().unsetHidden();
                    } else if (!isRowGroupCollapsed(findStartOfRowOutlineGroup)) {
                        getRow(findStartOfRowOutlineGroup).getCTRow().unsetHidden();
                    }
                }
            }
            CTRow cTRow = getRow(findEndOfRowOutlineGroup).getCTRow();
            if (cTRow.getCollapsed()) {
                cTRow.unsetCollapsed();
            }
        }
    }

    public int findEndOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getCTRow().getOutlineLevel();
        while (i < getLastRowNum() && getRow(i) != null && getRow(i).getCTRow().getOutlineLevel() >= outlineLevel) {
            i++;
        }
        return i;
    }

    private boolean isRowGroupHiddenByParent(int i) {
        short outlineLevel;
        boolean hidden;
        boolean z;
        int findEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i);
        short s = 0;
        if (getRow(findEndOfRowOutlineGroup) == null) {
            hidden = false;
            outlineLevel = 0;
        } else {
            outlineLevel = getRow(findEndOfRowOutlineGroup).getCTRow().getOutlineLevel();
            hidden = getRow(findEndOfRowOutlineGroup).getCTRow().getHidden();
        }
        int findStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i);
        if (findStartOfRowOutlineGroup < 0 || getRow(findStartOfRowOutlineGroup) == null) {
            z = false;
        } else {
            s = getRow(findStartOfRowOutlineGroup).getCTRow().getOutlineLevel();
            z = getRow(findStartOfRowOutlineGroup).getCTRow().getHidden();
        }
        return outlineLevel > s ? hidden : z;
    }

    private boolean isRowGroupCollapsed(int i) {
        int findEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i) + 1;
        if (getRow(findEndOfRowOutlineGroup) == null) {
            return false;
        }
        return getRow(findEndOfRowOutlineGroup).getCTRow().getCollapsed();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setZoom(int i, int i2) {
        setZoom((i * 100) / i2);
    }

    public void setZoom(int i) {
        if (i < 10 || i > 400) {
            throw new IllegalArgumentException("Valid scale values range from 10 to 400");
        }
        getSheetTypeSheetView().setZoomScale(i);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i, int i2, int i3) {
        shiftRows(i, i2, i3, false, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i, int i2, final int i3, boolean z, boolean z2) {
        int shiftedRowNum;
        Iterator<Row> it;
        int i4 = 0;
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(false);
        Iterator<Row> rowIterator = rowIterator();
        while (rowIterator.hasNext()) {
            XSSFRow xSSFRow = (XSSFRow) rowIterator.next();
            int rowNum = xSSFRow.getRowNum();
            if (shouldRemoveRow(i, i2, i3, rowNum)) {
                this.worksheet.getSheetData().removeRow(this._rows.headMap(Integer.valueOf(xSSFRow.getRowNum())).size());
                rowIterator.remove();
                CommentsTable commentsTable = this.sheetComments;
                if (commentsTable != null) {
                    for (CTComment cTComment : commentsTable.getCTComments().getCommentList().getCommentArray()) {
                        String ref = cTComment.getRef();
                        CellReference cellReference = new CellReference(ref);
                        if (cellReference.getRow() == rowNum) {
                            this.sheetComments.removeComment(ref);
                            vMLDrawing.removeCommentShape(cellReference.getRow(), cellReference.getCol());
                        }
                    }
                }
            }
        }
        TreeMap treeMap = new TreeMap(new Comparator<XSSFComment>() { // from class: org.apache.poi.xssf.usermodel.XSSFSheet.1
            @Override // java.util.Comparator
            public int compare(XSSFComment xSSFComment, XSSFComment xSSFComment2) {
                int row = xSSFComment.getRow();
                int row2 = xSSFComment2.getRow();
                if (row == row2) {
                    return xSSFComment.hashCode() - xSSFComment2.hashCode();
                }
                return i3 > 0 ? row < row2 ? 1 : -1 : row > row2 ? 1 : -1;
            }
        });
        Iterator<Row> rowIterator2 = rowIterator();
        while (rowIterator2.hasNext()) {
            XSSFRow xSSFRow2 = (XSSFRow) rowIterator2.next();
            int rowNum2 = xSSFRow2.getRowNum();
            if (this.sheetComments != null && (shiftedRowNum = shiftedRowNum(i, i2, i3, rowNum2)) != rowNum2) {
                CTComment[] commentArray = this.sheetComments.getCTComments().getCommentList().getCommentArray();
                int length = commentArray.length;
                int i5 = i4;
                while (i5 < length) {
                    CTComment cTComment2 = commentArray[i5];
                    CellReference cellReference2 = new CellReference(cTComment2.getRef());
                    if (cellReference2.getRow() == rowNum2) {
                        it = rowIterator2;
                        treeMap.put(new XSSFComment(this.sheetComments, cTComment2, vMLDrawing == null ? null : vMLDrawing.findCommentShape(rowNum2, cellReference2.getCol())), Integer.valueOf(shiftedRowNum));
                    } else {
                        it = rowIterator2;
                    }
                    i5++;
                    rowIterator2 = it;
                }
            }
            Iterator<Row> it2 = rowIterator2;
            if (rowNum2 >= i && rowNum2 <= i2) {
                if (!z) {
                    xSSFRow2.setHeight((short) -1);
                }
                xSSFRow2.shift(i3);
            }
            rowIterator2 = it2;
            i4 = 0;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            ((XSSFComment) entry.getKey()).setRow(((Integer) entry.getValue()).intValue());
        }
        XSSFRowShifter xSSFRowShifter = new XSSFRowShifter(this);
        int sheetIndex = getWorkbook().getSheetIndex(this);
        FormulaShifter createForRowShift = FormulaShifter.createForRowShift(sheetIndex, getWorkbook().getSheetName(sheetIndex), i, i2, i3);
        xSSFRowShifter.updateNamedRanges(createForRowShift);
        xSSFRowShifter.updateFormulas(createForRowShift);
        xSSFRowShifter.shiftMerged(i, i2, i3);
        xSSFRowShifter.updateConditionalFormatting(createForRowShift);
        TreeMap treeMap2 = new TreeMap();
        for (XSSFRow xSSFRow3 : this._rows.values()) {
            treeMap2.put(Integer.valueOf(xSSFRow3.getRowNum()), xSSFRow3);
        }
        this._rows = treeMap2;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(int i, int i2) {
        getPane().setTopLeftCell(new CellReference(i, i2).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Deprecated
    public void showInPane(short s, short s2) {
        showInPane((int) s, (int) s2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupColumn(int i, int i2) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        while (i <= i2) {
            CTCol column = this.columnHelper.getColumn(i, false);
            if (column != null) {
                column.setOutlineLevel((short) (column.getOutlineLevel() - 1));
                i = (int) column.getMax();
                if (column.getOutlineLevel() <= 0) {
                    this.worksheet.getColsArray(0).removeCol(this.columnHelper.getIndexOfColumn(colsArray, column));
                }
            }
            i++;
        }
        this.worksheet.setColsArray(0, colsArray);
        setSheetFormatPrOutlineLevelCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupRow(int i, int i2) {
        while (i <= i2) {
            XSSFRow row = getRow(i);
            if (row != null) {
                CTRow cTRow = row.getCTRow();
                short outlineLevel = cTRow.getOutlineLevel();
                cTRow.setOutlineLevel((short) (outlineLevel - 1));
                if (outlineLevel == 1 && row.getFirstCellNum() == -1) {
                    removeRow(row);
                }
            }
            i++;
        }
        setSheetFormatPrOutlineLevelRow();
    }

    private void setSheetFormatPrOutlineLevelRow() {
        getSheetTypeSheetFormatPr().setOutlineLevelRow(getMaxOutlineLevelRows());
    }

    private void setSheetFormatPrOutlineLevelCol() {
        getSheetTypeSheetFormatPr().setOutlineLevelCol(getMaxOutlineLevelCols());
    }

    private CTSheetViews getSheetTypeSheetViews() {
        if (this.worksheet.getSheetViews() == null) {
            this.worksheet.setSheetViews(CTSheetViews.Factory.newInstance());
            this.worksheet.getSheetViews().addNewSheetView();
        }
        return this.worksheet.getSheetViews();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isSelected() {
        CTSheetView defaultSheetView = getDefaultSheetView();
        return defaultSheetView != null && defaultSheetView.getTabSelected();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setSelected(boolean z) {
        for (CTSheetView cTSheetView : getSheetTypeSheetViews().getSheetViewArray()) {
            cTSheetView.setTabSelected(z);
        }
    }

    @Deprecated
    public static void setCellComment(String str, XSSFComment xSSFComment) {
        CellReference cellReference = new CellReference(str);
        xSSFComment.setRow(cellReference.getRow());
        xSSFComment.setColumn(cellReference.getCol());
    }

    @Internal
    public void addHyperlink(XSSFHyperlink xSSFHyperlink) {
        this.hyperlinks.add(xSSFHyperlink);
    }

    @Internal
    public void removeHyperlink(int i, int i2) {
        String formatAsString = new CellReference(i, i2).formatAsString();
        Iterator<XSSFHyperlink> it = this.hyperlinks.iterator();
        while (it.hasNext()) {
            if (it.next().getCellRef().equals(formatAsString)) {
                it.remove();
                return;
            }
        }
    }

    public String getActiveCell() {
        return getSheetTypeSelection().getActiveCell();
    }

    public void setActiveCell(String str) {
        CTSelection sheetTypeSelection = getSheetTypeSelection();
        sheetTypeSelection.setActiveCell(str);
        sheetTypeSelection.setSqref(Arrays.asList(str));
    }

    public boolean hasComments() {
        CommentsTable commentsTable = this.sheetComments;
        return commentsTable != null && commentsTable.getNumberOfComments() > 0;
    }

    protected int getNumberOfComments() {
        CommentsTable commentsTable = this.sheetComments;
        if (commentsTable == null) {
            return 0;
        }
        return commentsTable.getNumberOfComments();
    }

    private CTSelection getSheetTypeSelection() {
        if (getSheetTypeSheetView().sizeOfSelectionArray() == 0) {
            getSheetTypeSheetView().insertNewSelection(0);
        }
        return getSheetTypeSheetView().getSelectionArray(0);
    }

    private CTSheetView getDefaultSheetView() {
        CTSheetViews sheetTypeSheetViews = getSheetTypeSheetViews();
        int sizeOfSheetViewArray = sheetTypeSheetViews == null ? 0 : sheetTypeSheetViews.sizeOfSheetViewArray();
        if (sizeOfSheetViewArray == 0) {
            return null;
        }
        return sheetTypeSheetViews.getSheetViewArray(sizeOfSheetViewArray - 1);
    }

    protected CommentsTable getCommentsTable(boolean z) {
        if (this.sheetComments == null && z) {
            try {
                this.sheetComments = (CommentsTable) createRelationship(XSSFRelation.SHEET_COMMENTS, XSSFFactory.getInstance(), (int) this.sheet.getSheetId());
            } catch (PartAlreadyExistsException unused) {
                this.sheetComments = (CommentsTable) createRelationship(XSSFRelation.SHEET_COMMENTS, XSSFFactory.getInstance(), -1);
            }
        }
        return this.sheetComments;
    }

    private CTPageSetUpPr getSheetTypePageSetUpPr() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return sheetTypeSheetPr.isSetPageSetUpPr() ? sheetTypeSheetPr.getPageSetUpPr() : sheetTypeSheetPr.addNewPageSetUpPr();
    }

    private CTPane getPane() {
        if (getDefaultSheetView().getPane() == null) {
            getDefaultSheetView().addNewPane();
        }
        return getDefaultSheetView().getPane();
    }

    @Internal
    public CTCellFormula getSharedFormula(int i) {
        return this.sharedFormulas.get(Integer.valueOf(i));
    }

    void onReadCell(XSSFCell xSSFCell) {
        CTCellFormula f = xSSFCell.getCTCell().getF();
        if (f != null && f.getT() == STCellFormulaType.SHARED && f.isSetRef() && f.getStringValue() != null) {
            CTCellFormula cTCellFormula = (CTCellFormula) f.copy();
            CellRangeAddress valueOf = CellRangeAddress.valueOf(cTCellFormula.getRef());
            CellReference cellReference = new CellReference(xSSFCell);
            if (cellReference.getCol() > valueOf.getFirstColumn() || cellReference.getRow() > valueOf.getFirstRow()) {
                cTCellFormula.setRef(new CellRangeAddress(Math.max(cellReference.getRow(), valueOf.getFirstRow()), valueOf.getLastRow(), Math.max((int) cellReference.getCol(), valueOf.getFirstColumn()), valueOf.getLastColumn()).formatAsString());
            }
            this.sharedFormulas.put(Integer.valueOf((int) f.getSi()), cTCellFormula);
        }
        if (f == null || f.getT() != STCellFormulaType.ARRAY || f.getRef() == null) {
            return;
        }
        this.arrayFormulas.add(CellRangeAddress.valueOf(f.getRef()));
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        write(outputStream);
        outputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[LOOP:1: B:17:0x006b->B:19:0x0071, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void write(java.io.OutputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r6.worksheet
            int r0 = r0.sizeOfColsArray()
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L20
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r6.worksheet
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols r0 = r0.getColsArray(r2)
            int r3 = r0.sizeOfColArray()
            if (r3 != 0) goto L1d
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r6.worksheet
            r3 = 0
            r0.setColsArray(r3)
            goto L21
        L1d:
            r6.setColWidthAttribute(r0)
        L20:
            r1 = r2
        L21:
            java.util.List<org.apache.poi.xssf.usermodel.XSSFHyperlink> r0 = r6.hyperlinks
            int r0 = r0.size()
            if (r0 <= 0) goto L61
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r6.worksheet
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks r0 = r0.getHyperlinks()
            if (r0 != 0) goto L36
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r6.worksheet
            r0.addNewHyperlinks()
        L36:
            java.util.List<org.apache.poi.xssf.usermodel.XSSFHyperlink> r0 = r6.hyperlinks
            int r0 = r0.size()
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink[] r3 = new org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink[r0]
        L3e:
            if (r2 >= r0) goto L58
            java.util.List<org.apache.poi.xssf.usermodel.XSSFHyperlink> r4 = r6.hyperlinks
            java.lang.Object r4 = r4.get(r2)
            org.apache.poi.xssf.usermodel.XSSFHyperlink r4 = (org.apache.poi.xssf.usermodel.XSSFHyperlink) r4
            org.apache.poi.openxml4j.opc.PackagePart r5 = r6.getPackagePart()
            r4.generateRelationIfNeeded(r5)
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink r4 = r4.getCTHyperlink()
            r3[r2] = r4
            int r2 = r2 + 1
            goto L3e
        L58:
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r0 = r6.worksheet
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks r0 = r0.getHyperlinks()
            r0.setHyperlinkArray(r3)
        L61:
            java.util.SortedMap<java.lang.Integer, org.apache.poi.xssf.usermodel.XSSFRow> r0 = r6._rows
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L6b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L7b
            java.lang.Object r2 = r0.next()
            org.apache.poi.xssf.usermodel.XSSFRow r2 = (org.apache.poi.xssf.usermodel.XSSFRow) r2
            r2.onDocumentWrite()
            goto L6b
        L7b:
            org.apache.xmlbeans.XmlOptions r0 = new org.apache.xmlbeans.XmlOptions
            org.apache.xmlbeans.XmlOptions r2 = org.apache.poi.xssf.usermodel.XSSFSheet.DEFAULT_XML_OPTIONS
            r0.<init>(r2)
            aavax.xml.namespace.QName r2 = new aavax.xml.namespace.QName
            org.apache.xmlbeans.SchemaType r3 = org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet.type
            aavax.xml.namespace.QName r3 = r3.getName()
            java.lang.String r3 = r3.getNamespaceURI()
            java.lang.String r4 = "worksheet"
            r2.<init>(r3, r4)
            r0.setSaveSyntheticDocumentElement(r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            org.apache.xmlbeans.SchemaType r3 = org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId.type
            aavax.xml.namespace.QName r3 = r3.getName()
            java.lang.String r3 = r3.getNamespaceURI()
            java.lang.String r4 = "r"
            r2.put(r3, r4)
            r0.setSaveSuggestedPrefixes(r2)
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r2 = r6.worksheet
            r2.save(r7, r0)
            if (r1 == 0) goto Lb9
            org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet r7 = r6.worksheet
            r7.addNewCols()
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xssf.usermodel.XSSFSheet.write(java.io.OutputStream):void");
    }

    public boolean isAutoFilterLocked() {
        return isSheetLocked() && safeGetProtectionField().getAutoFilter();
    }

    public boolean isDeleteColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getDeleteColumns();
    }

    public boolean isDeleteRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getDeleteRows();
    }

    public boolean isFormatCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatCells();
    }

    public boolean isFormatColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatColumns();
    }

    public boolean isFormatRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatRows();
    }

    public boolean isInsertColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertColumns();
    }

    public boolean isInsertHyperlinksLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertHyperlinks();
    }

    public boolean isInsertRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertRows();
    }

    public boolean isPivotTablesLocked() {
        return isSheetLocked() && safeGetProtectionField().getPivotTables();
    }

    public boolean isSortLocked() {
        return isSheetLocked() && safeGetProtectionField().getSort();
    }

    public boolean isObjectsLocked() {
        return isSheetLocked() && safeGetProtectionField().getObjects();
    }

    public boolean isScenariosLocked() {
        return isSheetLocked() && safeGetProtectionField().getScenarios();
    }

    public boolean isSelectLockedCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getSelectLockedCells();
    }

    public boolean isSelectUnlockedCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getSelectUnlockedCells();
    }

    public boolean isSheetLocked() {
        return this.worksheet.isSetSheetProtection() && safeGetProtectionField().getSheet();
    }

    public void enableLocking() {
        safeGetProtectionField().setSheet(true);
    }

    public void disableLocking() {
        safeGetProtectionField().setSheet(false);
    }

    public void lockAutoFilter() {
        lockAutoFilter(true);
    }

    public void lockAutoFilter(boolean z) {
        safeGetProtectionField().setAutoFilter(z);
    }

    public void lockDeleteColumns() {
        lockDeleteColumns(true);
    }

    public void lockDeleteColumns(boolean z) {
        safeGetProtectionField().setDeleteColumns(z);
    }

    public void lockDeleteRows() {
        lockDeleteRows(true);
    }

    public void lockDeleteRows(boolean z) {
        safeGetProtectionField().setDeleteRows(z);
    }

    public void lockFormatCells() {
        lockFormatCells(true);
    }

    public void lockFormatCells(boolean z) {
        safeGetProtectionField().setFormatCells(z);
    }

    public void lockFormatColumns() {
        lockFormatColumns(true);
    }

    public void lockFormatColumns(boolean z) {
        safeGetProtectionField().setFormatColumns(z);
    }

    public void lockFormatRows() {
        lockFormatRows(true);
    }

    public void lockFormatRows(boolean z) {
        safeGetProtectionField().setFormatRows(z);
    }

    public void lockInsertColumns() {
        lockInsertColumns(true);
    }

    public void lockInsertColumns(boolean z) {
        safeGetProtectionField().setInsertColumns(z);
    }

    public void lockInsertHyperlinks() {
        lockInsertHyperlinks(true);
    }

    public void lockInsertHyperlinks(boolean z) {
        safeGetProtectionField().setInsertHyperlinks(z);
    }

    public void lockInsertRows() {
        lockInsertRows(true);
    }

    public void lockInsertRows(boolean z) {
        safeGetProtectionField().setInsertRows(z);
    }

    public void lockPivotTables() {
        lockPivotTables(true);
    }

    public void lockPivotTables(boolean z) {
        safeGetProtectionField().setPivotTables(z);
    }

    public void lockSort() {
        lockSort(true);
    }

    public void lockSort(boolean z) {
        safeGetProtectionField().setSort(z);
    }

    public void lockObjects() {
        lockObjects(true);
    }

    public void lockObjects(boolean z) {
        safeGetProtectionField().setObjects(z);
    }

    public void lockScenarios() {
        lockScenarios(true);
    }

    public void lockScenarios(boolean z) {
        safeGetProtectionField().setScenarios(z);
    }

    public void lockSelectLockedCells() {
        lockSelectLockedCells(true);
    }

    public void lockSelectLockedCells(boolean z) {
        safeGetProtectionField().setSelectLockedCells(z);
    }

    public void lockSelectUnlockedCells() {
        lockSelectUnlockedCells(true);
    }

    public void lockSelectUnlockedCells(boolean z) {
        safeGetProtectionField().setSelectUnlockedCells(z);
    }

    private CTSheetProtection safeGetProtectionField() {
        if (!isSheetProtectionEnabled()) {
            return this.worksheet.addNewSheetProtection();
        }
        return this.worksheet.getSheetProtection();
    }

    boolean isSheetProtectionEnabled() {
        return this.worksheet.isSetSheetProtection();
    }

    boolean isCellInArrayFormulaContext(XSSFCell xSSFCell) {
        Iterator<CellRangeAddress> it = this.arrayFormulas.iterator();
        while (it.hasNext()) {
            if (it.next().isInRange(xSSFCell.getRowIndex(), xSSFCell.getColumnIndex())) {
                return true;
            }
        }
        return false;
    }

    XSSFCell getFirstCellInArrayFormula(XSSFCell xSSFCell) {
        for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
            if (cellRangeAddress.isInRange(xSSFCell.getRowIndex(), xSSFCell.getColumnIndex())) {
                return getRow(cellRangeAddress.getFirstRow()).getCell(cellRangeAddress.getFirstColumn());
            }
        }
        return null;
    }

    private CellRange<XSSFCell> getCellRange(CellRangeAddress cellRangeAddress) {
        int firstRow = cellRangeAddress.getFirstRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        int i = (lastRow - firstRow) + 1;
        int i2 = (lastColumn - firstColumn) + 1;
        ArrayList arrayList = new ArrayList(i * i2);
        for (int i3 = firstRow; i3 <= lastRow; i3++) {
            for (int i4 = firstColumn; i4 <= lastColumn; i4++) {
                XSSFRow row = getRow(i3);
                if (row == null) {
                    row = createRow(i3);
                }
                XSSFCell cell = row.getCell(i4);
                if (cell == null) {
                    cell = row.createCell(i4);
                }
                arrayList.add(cell);
            }
        }
        return SSCellRange.create(firstRow, firstColumn, i, i2, arrayList, XSSFCell.class);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<XSSFCell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
        cellRange.getTopLeftCell().setCellArrayFormula(str, cellRangeAddress);
        this.arrayFormulas.add(cellRangeAddress);
        return cellRange;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<XSSFCell> removeArrayFormula(Cell cell) {
        if (cell.getSheet() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
        }
        for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
            if (cellRangeAddress.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
                this.arrayFormulas.remove(cellRangeAddress);
                CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
                Iterator<XSSFCell> it = cellRange.iterator();
                while (it.hasNext()) {
                    it.next().setCellType(3);
                }
                return cellRange;
            }
        }
        throw new IllegalArgumentException("Cell " + ((XSSFCell) cell).getCTCell().getR() + " is not part of an array formula.");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return this.dataValidationHelper;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<XSSFDataValidation> getDataValidations() {
        ArrayList arrayList = new ArrayList();
        CTDataValidations dataValidations = this.worksheet.getDataValidations();
        if (dataValidations != null && dataValidations.getCount() > 0) {
            CTDataValidation[] dataValidationArray = dataValidations.getDataValidationArray();
            int length = dataValidationArray.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                CTDataValidation cTDataValidation = dataValidationArray[i2];
                CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
                Iterator it = cTDataValidation.getSqref().iterator();
                while (it.hasNext()) {
                    String[] split = ((String) it.next()).split(StringUtils.SPACE);
                    int length2 = split.length;
                    int i3 = i;
                    while (i3 < length2) {
                        String[] split2 = split[i3].split(":");
                        CellReference cellReference = new CellReference(split2[i]);
                        CellReference cellReference2 = split2.length > 1 ? new CellReference(split2[1]) : cellReference;
                        cellRangeAddressList.addCellRangeAddress(new CellRangeAddress(cellReference.getRow(), cellReference2.getRow(), cellReference.getCol(), cellReference2.getCol()));
                        i3++;
                        i = 0;
                    }
                }
                arrayList.add(new XSSFDataValidation(cellRangeAddressList, cTDataValidation));
                i2++;
                i = 0;
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void addValidationData(DataValidation dataValidation) {
        XSSFDataValidation xSSFDataValidation = (XSSFDataValidation) dataValidation;
        CTDataValidations dataValidations = this.worksheet.getDataValidations();
        if (dataValidations == null) {
            dataValidations = this.worksheet.addNewDataValidations();
        }
        int sizeOfDataValidationArray = dataValidations.sizeOfDataValidationArray();
        dataValidations.addNewDataValidation().set(xSSFDataValidation.getCtDdataValidation());
        dataValidations.setCount(sizeOfDataValidationArray + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFAutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        CTAutoFilter autoFilter = this.worksheet.getAutoFilter();
        if (autoFilter == null) {
            autoFilter = this.worksheet.addNewAutoFilter();
        }
        autoFilter.setRef(new CellRangeAddress(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn()).formatAsString());
        XSSFWorkbook workbook = getWorkbook();
        int sheetIndex = getWorkbook().getSheetIndex(this);
        XSSFName builtInName = workbook.getBuiltInName(XSSFName.BUILTIN_FILTER_DB, sheetIndex);
        if (builtInName == null) {
            builtInName = workbook.createBuiltInName(XSSFName.BUILTIN_FILTER_DB, sheetIndex);
        }
        builtInName.getCTName().setHidden(true);
        builtInName.setRefersToFormula(new CellReference(getSheetName(), cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn(), true, true).formatAsString() + ":" + new CellReference(null, cellRangeAddress.getLastRow(), cellRangeAddress.getLastColumn(), true, true).formatAsString());
        return new XSSFAutoFilter(this);
    }

    public XSSFTable createTable() {
        if (!this.worksheet.isSetTableParts()) {
            this.worksheet.addNewTableParts();
        }
        CTTablePart addNewTablePart = this.worksheet.getTableParts().addNewTablePart();
        XSSFTable xSSFTable = (XSSFTable) createRelationship(XSSFRelation.TABLE, XSSFFactory.getInstance(), getPackagePart().getPackage().getPartsByContentType(XSSFRelation.TABLE.getContentType()).size() + 1);
        addNewTablePart.setId(xSSFTable.getPackageRelationship().getId());
        this.tables.put(addNewTablePart.getId(), xSSFTable);
        return xSSFTable;
    }

    public List<XSSFTable> getTables() {
        return new ArrayList(this.tables.values());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new XSSFSheetConditionalFormatting(this);
    }

    public void setTabColor(int i) {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        if (sheetPr == null) {
            sheetPr = this.worksheet.addNewSheetPr();
        }
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(i);
        sheetPr.setTabColor(newInstance);
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
        int i4 = -1;
        if (cellRangeAddress != null) {
            i = cellRangeAddress.getFirstRow();
            i2 = cellRangeAddress.getLastRow();
            if ((i == -1 && i2 != -1) || i < -1 || i2 < -1 || i > i2) {
                throw new IllegalArgumentException("Invalid row range specification");
            }
        } else {
            i = -1;
            i2 = -1;
        }
        if (cellRangeAddress2 != null) {
            int firstColumn = cellRangeAddress2.getFirstColumn();
            i3 = cellRangeAddress2.getLastColumn();
            if ((firstColumn == -1 && i3 != -1) || firstColumn < -1 || i3 < -1 || firstColumn > i3) {
                throw new IllegalArgumentException("Invalid column range specification");
            }
            i4 = firstColumn;
        } else {
            i3 = -1;
        }
        int sheetIndex = getWorkbook().getSheetIndex(this);
        boolean z = cellRangeAddress == null && cellRangeAddress2 == null;
        XSSFName builtInName = getWorkbook().getBuiltInName(XSSFName.BUILTIN_PRINT_TITLE, sheetIndex);
        if (z) {
            if (builtInName != null) {
                getWorkbook().removeName(builtInName);
                return;
            }
            return;
        }
        if (builtInName == null) {
            builtInName = getWorkbook().createBuiltInName(XSSFName.BUILTIN_PRINT_TITLE, sheetIndex);
        }
        builtInName.setRefersToFormula(getReferenceBuiltInRecord(builtInName.getSheetName(), i4, i3, i, i2));
        if (this.worksheet.isSetPageSetup() && this.worksheet.isSetPageMargins()) {
            return;
        }
        getPrintSetup().setValidSettings(false);
    }

    private static String getReferenceBuiltInRecord(String str, int i, int i2, int i3, int i4) {
        String str2;
        int i5;
        CellReference cellReference = new CellReference(str, 0, i, true, true);
        CellReference cellReference2 = new CellReference(str, 0, i2, true, true);
        CellReference cellReference3 = new CellReference(str, i3, 0, true, true);
        CellReference cellReference4 = new CellReference(str, i4, 0, true, true);
        String format = SheetNameFormatter.format(str);
        String str3 = "";
        if (i == -1 && i2 == -1) {
            i5 = i3;
            str2 = "";
        } else {
            str2 = format + "!$" + cellReference.getCellRefParts()[2] + ":$" + cellReference2.getCellRefParts()[2];
            i5 = i3;
        }
        if ((i5 != -1 || i4 != -1) && !cellReference3.getCellRefParts()[1].equals(SessionDescription.SUPPORTED_SDP_VERSION) && !cellReference4.getCellRefParts()[1].equals(SessionDescription.SUPPORTED_SDP_VERSION)) {
            str3 = format + "!$" + cellReference3.getCellRefParts()[1] + ":$" + cellReference4.getCellRefParts()[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (sb.length() > 0 && str3.length() > 0) {
            sb.append(',');
        }
        sb.append(str3);
        return sb.toString();
    }

    private CellRangeAddress getRepeatingRowsOrColums(boolean z) {
        String refersToFormula;
        XSSFName builtInName = getWorkbook().getBuiltInName(XSSFName.BUILTIN_PRINT_TITLE, getWorkbook().getSheetIndex(this));
        if (builtInName == null || (refersToFormula = builtInName.getRefersToFormula()) == null) {
            return null;
        }
        String[] split = refersToFormula.split(",");
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        int lastColumnIndex = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        for (String str : split) {
            CellRangeAddress valueOf = CellRangeAddress.valueOf(str);
            if ((valueOf.getFirstColumn() == 0 && valueOf.getLastColumn() == lastColumnIndex) || (valueOf.getFirstColumn() == -1 && valueOf.getLastColumn() == -1)) {
                if (z) {
                    return valueOf;
                }
            } else if (((valueOf.getFirstRow() == 0 && valueOf.getLastRow() == lastRowIndex) || (valueOf.getFirstRow() == -1 && valueOf.getLastRow() == -1)) && !z) {
                return valueOf;
            }
        }
        return null;
    }

    private XSSFPivotTable createPivotTable() {
        XSSFWorkbook workbook = getWorkbook();
        List<XSSFPivotTable> pivotTables = workbook.getPivotTables();
        int size = getWorkbook().getPivotTables().size() + 1;
        XSSFPivotTable xSSFPivotTable = (XSSFPivotTable) createRelationship(XSSFRelation.PIVOT_TABLE, XSSFFactory.getInstance(), size);
        xSSFPivotTable.setParentSheet(this);
        pivotTables.add(xSSFPivotTable);
        XSSFWorkbook workbook2 = getWorkbook();
        XSSFPivotCacheDefinition xSSFPivotCacheDefinition = (XSSFPivotCacheDefinition) workbook2.createRelationship(XSSFRelation.PIVOT_CACHE_DEFINITION, XSSFFactory.getInstance(), size);
        String relationId = workbook2.getRelationId(xSSFPivotCacheDefinition);
        xSSFPivotTable.getPackagePart().addRelationship(xSSFPivotCacheDefinition.getPackagePart().getPartName(), TargetMode.INTERNAL, XSSFRelation.PIVOT_CACHE_DEFINITION.getRelation());
        xSSFPivotTable.setPivotCacheDefinition(xSSFPivotCacheDefinition);
        xSSFPivotTable.setPivotCache(new XSSFPivotCache(workbook2.addPivotCache(relationId)));
        xSSFPivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().setId(xSSFPivotCacheDefinition.getRelationId((XSSFPivotCacheRecords) xSSFPivotCacheDefinition.createRelationship(XSSFRelation.PIVOT_CACHE_RECORDS, XSSFFactory.getInstance(), size)));
        workbook.setPivotTables(pivotTables);
        return xSSFPivotTable;
    }

    public XSSFPivotTable createPivotTable(AreaReference areaReference, CellReference cellReference, Sheet sheet) {
        if (areaReference.getFirstCell().getSheetName() != null && !areaReference.getFirstCell().getSheetName().equals(sheet.getSheetName())) {
            throw new IllegalArgumentException("The area is referenced in another sheet than the defined source sheet " + sheet.getSheetName() + ".");
        }
        XSSFPivotTable createPivotTable = createPivotTable();
        createPivotTable.setDefaultPivotTableDefinition();
        createPivotTable.createSourceReferences(areaReference, cellReference, sheet);
        createPivotTable.getPivotCacheDefinition().createCacheFields(sheet);
        createPivotTable.createDefaultDataColumns();
        return createPivotTable;
    }

    public XSSFPivotTable createPivotTable(AreaReference areaReference, CellReference cellReference) {
        if (areaReference.getFirstCell().getSheetName() != null && !areaReference.getFirstCell().getSheetName().equals(getSheetName())) {
            return createPivotTable(areaReference, cellReference, getWorkbook().getSheet(areaReference.getFirstCell().getSheetName()));
        }
        return createPivotTable(areaReference, cellReference, this);
    }

    public List<XSSFPivotTable> getPivotTables() {
        ArrayList arrayList = new ArrayList();
        for (XSSFPivotTable xSSFPivotTable : getWorkbook().getPivotTables()) {
            if (xSSFPivotTable.getParent() == this) {
                arrayList.add(xSSFPivotTable);
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i) {
        CTCol column = this.columnHelper.getColumn(i, false);
        if (column == null) {
            return 0;
        }
        return column.getOutlineLevel();
    }
}
