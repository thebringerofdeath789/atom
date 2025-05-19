package org.apache.poi.xssf.usermodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.xmlbeans.XmlErrorCodes;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes5.dex */
public final class XSSFCell implements Cell {
    private static final String FALSE_AS_STRING = "0";
    private static final String TRUE_AS_STRING = "1";
    private CTCell _cell;
    private int _cellNum;
    private final XSSFRow _row;
    private SharedStringsTable _sharedStringSource;
    private StylesTable _stylesSource;

    protected XSSFCell(XSSFRow xSSFRow, CTCell cTCell) {
        this._cell = cTCell;
        this._row = xSSFRow;
        if (cTCell.getR() != null) {
            this._cellNum = new CellReference(cTCell.getR()).getCol();
        } else {
            short lastCellNum = xSSFRow.getLastCellNum();
            if (lastCellNum != -1) {
                this._cellNum = xSSFRow.getCell(lastCellNum - 1, Row.RETURN_NULL_AND_BLANK).getColumnIndex() + 1;
            }
        }
        this._sharedStringSource = xSSFRow.getSheet().getWorkbook().getSharedStringSource();
        this._stylesSource = xSSFRow.getSheet().getWorkbook().getStylesSource();
    }

    protected SharedStringsTable getSharedStringSource() {
        return this._sharedStringSource;
    }

    protected StylesTable getStylesSource() {
        return this._stylesSource;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFSheet getSheet() {
        return getRow().getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRow getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        int cellType = getCellType();
        if (cellType == 2) {
            return this._cell.isSetV() && "1".equals(this._cell.getV());
        }
        if (cellType == 3) {
            return false;
        }
        if (cellType == 4) {
            return this._cell.isSetV() && "1".equals(this._cell.getV());
        }
        throw typeMismatch(4, cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z) {
        this._cell.setT(STCellType.B);
        this._cell.setV(z ? "1" : "0");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        int cellType = getCellType();
        if (cellType != 0 && cellType != 2) {
            if (cellType == 3) {
                return 0.0d;
            }
            throw typeMismatch(0, cellType, false);
        }
        if (!this._cell.isSetV()) {
            return 0.0d;
        }
        String v = this._cell.getV();
        if (v.isEmpty()) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(v);
        } catch (NumberFormatException unused) {
            throw typeMismatch(0, 1, false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double d) {
        if (Double.isInfinite(d)) {
            this._cell.setT(STCellType.E);
            this._cell.setV(FormulaError.DIV0.getString());
        } else if (Double.isNaN(d)) {
            this._cell.setT(STCellType.E);
            this._cell.setV(FormulaError.NUM.getString());
        } else {
            this._cell.setT(STCellType.N);
            this._cell.setV(String.valueOf(d));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        XSSFRichTextString richStringCellValue = getRichStringCellValue();
        if (richStringCellValue == null) {
            return null;
        }
        return richStringCellValue.getString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRichTextString getRichStringCellValue() {
        XSSFRichTextString xSSFRichTextString;
        int cellType = getCellType();
        if (cellType != 1) {
            if (cellType == 2) {
                checkFormulaCachedValueType(1, getBaseCellType(false));
                xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : "");
            } else if (cellType == 3) {
                xSSFRichTextString = new XSSFRichTextString("");
            } else {
                throw typeMismatch(1, cellType, false);
            }
        } else if (this._cell.getT() == STCellType.INLINE_STR) {
            if (this._cell.isSetIs()) {
                xSSFRichTextString = new XSSFRichTextString(this._cell.getIs());
            } else if (this._cell.isSetV()) {
                xSSFRichTextString = new XSSFRichTextString(this._cell.getV());
            } else {
                xSSFRichTextString = new XSSFRichTextString("");
            }
        } else if (this._cell.getT() == STCellType.STR) {
            xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : "");
        } else if (this._cell.isSetV()) {
            xSSFRichTextString = new XSSFRichTextString(this._sharedStringSource.getEntryAt(Integer.parseInt(this._cell.getV())));
        } else {
            xSSFRichTextString = new XSSFRichTextString("");
        }
        xSSFRichTextString.setStylesTableReference(this._stylesSource);
        return xSSFRichTextString;
    }

    private static void checkFormulaCachedValueType(int i, int i2) {
        if (i2 != i) {
            throw typeMismatch(i, i2, true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        setCellValue(str == null ? null : new XSSFRichTextString(str));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        if (richTextString == null || richTextString.getString() == null) {
            setCellType(3);
            return;
        }
        if (richTextString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
            throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
        }
        if (getCellType() == 2) {
            this._cell.setV(richTextString.getString());
            this._cell.setT(STCellType.STR);
        } else {
            if (this._cell.getT() == STCellType.INLINE_STR) {
                this._cell.setV(richTextString.getString());
                return;
            }
            this._cell.setT(STCellType.S);
            XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
            xSSFRichTextString.setStylesTableReference(this._stylesSource);
            this._cell.setV(Integer.toString(this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst())));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        int cellType = getCellType();
        if (cellType != 2) {
            throw typeMismatch(2, cellType, false);
        }
        CTCellFormula f = this._cell.getF();
        if (isPartOfArrayFormulaGroup() && f == null) {
            return getSheet().getFirstCellInArrayFormula(this).getCellFormula();
        }
        if (f.getT() == STCellFormulaType.SHARED) {
            return convertSharedFormula((int) f.getSi());
        }
        return f.getStringValue();
    }

    private String convertSharedFormula(int i) {
        XSSFSheet sheet = getSheet();
        CTCellFormula sharedFormula = sheet.getSharedFormula(i);
        if (sharedFormula == null) {
            throw new IllegalStateException("Master cell of a shared formula with sid=" + i + " was not found");
        }
        String stringValue = sharedFormula.getStringValue();
        CellRangeAddress valueOf = CellRangeAddress.valueOf(sharedFormula.getRef());
        int sheetIndex = sheet.getWorkbook().getSheetIndex(sheet);
        XSSFEvaluationWorkbook create = XSSFEvaluationWorkbook.create(sheet.getWorkbook());
        return FormulaRenderer.toFormulaString(create, new SharedFormula(SpreadsheetVersion.EXCEL2007).convertSharedFormulas(FormulaParser.parse(stringValue, create, 0, sheetIndex), getRowIndex() - valueOf.getFirstRow(), getColumnIndex() - valueOf.getFirstColumn()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellFormula(String str) {
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        setFormula(str, 0);
    }

    void setCellArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        setFormula(str, 2);
        CTCellFormula f = this._cell.getF();
        f.setT(STCellFormulaType.ARRAY);
        f.setRef(cellRangeAddress.formatAsString());
    }

    private void setFormula(String str, int i) {
        XSSFWorkbook workbook = this._row.getSheet().getWorkbook();
        if (str == null) {
            workbook.onDeleteFormula(this);
            if (this._cell.isSetF()) {
                this._cell.unsetF();
                return;
            }
            return;
        }
        FormulaParser.parse(str, XSSFEvaluationWorkbook.create(workbook), i, workbook.getSheetIndex(getSheet()));
        CTCellFormula newInstance = CTCellFormula.Factory.newInstance();
        newInstance.setStringValue(str);
        this._cell.setF(newInstance);
        if (this._cell.isSetV()) {
            this._cell.unsetV();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._cellNum;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    public String getReference() {
        String r = this._cell.getR();
        return r == null ? new CellReference(this).formatAsString() : r;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFCellStyle getCellStyle() {
        if (this._stylesSource.getNumCellStyles() > 0) {
            return this._stylesSource.getStyleAt((int) (this._cell.isSetS() ? this._cell.getS() : 0L));
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            if (this._cell.isSetS()) {
                this._cell.unsetS();
            }
        } else {
            ((XSSFCellStyle) cellStyle).verifyBelongsToStylesSource(this._stylesSource);
            this._cell.setS(this._stylesSource.putStyle(r3));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCellType() {
        if (this._cell.getF() != null || getSheet().isCellInArrayFormulaContext(this)) {
            return 2;
        }
        return getBaseCellType(true);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCachedFormulaResultType() {
        if (this._cell.getF() == null) {
            throw new IllegalStateException("Only formula cells have cached results");
        }
        return getBaseCellType(false);
    }

    private int getBaseCellType(boolean z) {
        switch (this._cell.getT().intValue()) {
            case 1:
                return 4;
            case 2:
                return (this._cell.isSetV() || !z) ? 0 : 3;
            case 3:
                return 5;
            case 4:
            case 5:
            case 6:
                return 1;
            default:
                throw new IllegalStateException("Illegal cell type: " + this._cell.getT());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellType() == 3) {
            return null;
        }
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Date date) {
        setCellValue(DateUtil.getExcelDate(date, getSheet().getWorkbook().isDate1904()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Calendar calendar) {
        setCellValue(DateUtil.getExcelDate(calendar, getSheet().getWorkbook().isDate1904()));
    }

    public String getErrorCellString() {
        int baseCellType = getBaseCellType(true);
        if (baseCellType != 5) {
            throw typeMismatch(5, baseCellType, false);
        }
        return this._cell.getV();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        String errorCellString = getErrorCellString();
        if (errorCellString == null) {
            return (byte) 0;
        }
        return FormulaError.forString(errorCellString).getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        setCellErrorValue(FormulaError.forInt(b));
    }

    public void setCellErrorValue(FormulaError formulaError) {
        this._cell.setT(STCellType.E);
        this._cell.setV(formulaError.getString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        getSheet().setActiveCell(getReference());
    }

    private void setBlank() {
        CTCell newInstance = CTCell.Factory.newInstance();
        newInstance.setR(this._cell.getR());
        if (this._cell.isSetS()) {
            newInstance.setS(this._cell.getS());
        }
        this._cell.set(newInstance);
    }

    protected void setCellNum(int i) {
        checkBounds(i);
        this._cellNum = i;
        this._cell.setR(new CellReference(getRowIndex(), getColumnIndex()).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(int i) {
        int cellType = getCellType();
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        if (cellType == 2 && i != 2) {
            getSheet().getWorkbook().onDeleteFormula(this);
        }
        if (i == 0) {
            this._cell.setT(STCellType.N);
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    setBlank();
                } else if (i == 4) {
                    String str = convertCellValueToBoolean() ? "1" : "0";
                    this._cell.setT(STCellType.B);
                    this._cell.setV(str);
                } else if (i == 5) {
                    this._cell.setT(STCellType.E);
                } else {
                    throw new IllegalArgumentException("Illegal cell type: " + i);
                }
            } else if (!this._cell.isSetF()) {
                CTCellFormula newInstance = CTCellFormula.Factory.newInstance();
                newInstance.setStringValue("0");
                this._cell.setF(newInstance);
                if (this._cell.isSetT()) {
                    this._cell.unsetT();
                }
            }
        } else {
            if (cellType != 1) {
                XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(convertCellValueToString());
                xSSFRichTextString.setStylesTableReference(this._stylesSource);
                this._cell.setV(Integer.toString(this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst())));
            }
            this._cell.setT(STCellType.S);
        }
        if (i == 2 || !this._cell.isSetF()) {
            return;
        }
        this._cell.unsetF();
    }

    public String toString() {
        int cellType = getCellType();
        if (cellType == 0) {
            if (DateUtil.isCellDateFormatted(this)) {
                return new SimpleDateFormat("dd-MMM-yyyy").format(getDateCellValue());
            }
            return Double.toString(getNumericCellValue());
        }
        if (cellType == 1) {
            return getRichStringCellValue().toString();
        }
        if (cellType == 2) {
            return getCellFormula();
        }
        if (cellType == 3) {
            return "";
        }
        if (cellType == 4) {
            return getBooleanCellValue() ? "TRUE" : "FALSE";
        }
        if (cellType == 5) {
            return ErrorEval.getText(getErrorCellValue());
        }
        return "Unknown Cell Type: " + getCellType();
    }

    public String getRawValue() {
        return this._cell.getV();
    }

    private static String getCellTypeName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "#unknown cell type (" + i + ")#" : IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR : XmlErrorCodes.BOOLEAN : "blank" : "formula" : "text" : "numeric";
    }

    private static RuntimeException typeMismatch(int i, int i2, boolean z) {
        return new IllegalStateException("Cannot get a " + getCellTypeName(i) + " value from a " + getCellTypeName(i2) + StringUtils.SPACE + (z ? "formula " : "") + "cell");
    }

    private static void checkBounds(int i) {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastColumnIndex = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        if (i < 0 || i > lastColumnIndex) {
            throw new IllegalArgumentException("Invalid column index (" + i + ").  Allowable column range for " + spreadsheetVersion.name() + " is (0.." + lastColumnIndex + ") or ('A'..'" + spreadsheetVersion.getLastColumnName() + "')");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFComment getCellComment() {
        return getSheet().getCellComment(this._row.getRowNum(), getColumnIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        if (comment == null) {
            removeCellComment();
        } else {
            comment.setRow(getRowIndex());
            comment.setColumn(getColumnIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        if (getCellComment() != null) {
            String reference = getReference();
            XSSFSheet sheet = getSheet();
            sheet.getCommentsTable(false).removeComment(reference);
            sheet.getVMLDrawing(false).removeCommentShape(getRowIndex(), getColumnIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFHyperlink getHyperlink() {
        return getSheet().getHyperlink(this._row.getRowNum(), this._cellNum);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) hyperlink;
        xSSFHyperlink.setCellReference(new CellReference(this._row.getRowNum(), this._cellNum).formatAsString());
        getSheet().addHyperlink(xSSFHyperlink);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        getSheet().removeHyperlink(this._row.getRowNum(), this._cellNum);
    }

    @Internal
    public CTCell getCTCell() {
        return this._cell;
    }

    @Internal
    public void setCTCell(CTCell cTCell) {
        this._cell = cTCell;
    }

    private boolean convertCellValueToBoolean() {
        int cellType = getCellType();
        if (cellType == 2) {
            cellType = getBaseCellType(false);
        }
        if (cellType == 0) {
            return Double.parseDouble(this._cell.getV()) != 0.0d;
        }
        if (cellType == 1) {
            return Boolean.parseBoolean(new XSSFRichTextString(this._sharedStringSource.getEntryAt(Integer.parseInt(this._cell.getV()))).getString());
        }
        if (cellType != 3) {
            if (cellType == 4) {
                return "1".equals(this._cell.getV());
            }
            if (cellType != 5) {
                throw new RuntimeException("Unexpected cell type (" + cellType + ")");
            }
        }
        return false;
    }

    private String convertCellValueToString() {
        int cellType = getCellType();
        if (cellType != 0) {
            if (cellType == 1) {
                return new XSSFRichTextString(this._sharedStringSource.getEntryAt(Integer.parseInt(this._cell.getV()))).getString();
            }
            if (cellType == 2) {
                int baseCellType = getBaseCellType(false);
                String v = this._cell.getV();
                if (baseCellType != 0 && baseCellType != 1) {
                    if (baseCellType == 4) {
                        if ("1".equals(v)) {
                            return "TRUE";
                        }
                        if ("0".equals(v)) {
                            return "FALSE";
                        }
                        throw new IllegalStateException("Unexpected boolean cached formula value '" + v + "'.");
                    }
                    if (baseCellType != 5) {
                        throw new IllegalStateException("Unexpected formula result type (" + baseCellType + ")");
                    }
                }
                return v;
            }
            if (cellType == 3) {
                return "";
            }
            if (cellType == 4) {
                return "1".equals(this._cell.getV()) ? "TRUE" : "FALSE";
            }
            if (cellType != 5) {
                throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
            }
        }
        return this._cell.getV();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        XSSFCell firstCellInArrayFormula = getSheet().getFirstCellInArrayFormula(this);
        if (firstCellInArrayFormula == null) {
            throw new IllegalStateException("Cell " + getReference() + " is not part of an array formula.");
        }
        return CellRangeAddress.valueOf(firstCellInArrayFormula._cell.getF().getRef());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        return getSheet().isCellInArrayFormulaContext(this);
    }

    void notifyArrayFormulaChanging(String str) {
        if (isPartOfArrayFormulaGroup()) {
            if (getArrayFormulaRange().getNumberOfCells() > 1) {
                throw new IllegalStateException(str);
            }
            getRow().getSheet().removeArrayFormula(this);
        }
    }

    void notifyArrayFormulaChanging() {
        notifyArrayFormulaChanging("Cell " + new CellReference(this).formatAsString() + " is part of a multi-cell array formula. You cannot change part of an array.");
    }
}
