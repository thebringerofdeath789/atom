package org.apache.poi.ss.usermodel;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.util.CellRangeAddress;

/* loaded from: classes5.dex */
public interface Cell {
    public static final int CELL_TYPE_BLANK = 3;
    public static final int CELL_TYPE_BOOLEAN = 4;
    public static final int CELL_TYPE_ERROR = 5;
    public static final int CELL_TYPE_FORMULA = 2;
    public static final int CELL_TYPE_NUMERIC = 0;
    public static final int CELL_TYPE_STRING = 1;

    CellRangeAddress getArrayFormulaRange();

    boolean getBooleanCellValue();

    int getCachedFormulaResultType();

    Comment getCellComment();

    String getCellFormula();

    CellStyle getCellStyle();

    int getCellType();

    int getColumnIndex();

    Date getDateCellValue();

    byte getErrorCellValue();

    Hyperlink getHyperlink();

    double getNumericCellValue();

    RichTextString getRichStringCellValue();

    Row getRow();

    int getRowIndex();

    Sheet getSheet();

    String getStringCellValue();

    boolean isPartOfArrayFormulaGroup();

    void removeCellComment();

    void removeHyperlink();

    void setAsActiveCell();

    void setCellComment(Comment comment);

    void setCellErrorValue(byte b);

    void setCellFormula(String str) throws FormulaParseException;

    void setCellStyle(CellStyle cellStyle);

    void setCellType(int i);

    void setCellValue(double d);

    void setCellValue(String str);

    void setCellValue(Calendar calendar);

    void setCellValue(Date date);

    void setCellValue(RichTextString richTextString);

    void setCellValue(boolean z);

    void setHyperlink(Hyperlink hyperlink);
}
