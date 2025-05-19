package org.apache.poi.xssf.streaming;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.xmlbeans.XmlErrorCodes;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes5.dex */
public class SXSSFCell implements Cell {
    Property _firstProperty;
    SXSSFRow _row;
    CellStyle _style;
    Value _value;

    interface Value {
        int getType();
    }

    int computeTypeFromFormula(String str) {
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
    }

    public SXSSFCell(SXSSFRow sXSSFRow, int i) {
        this._row = sXSSFRow;
        setType(i);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._row.getCellIndex(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Sheet getSheet() {
        return this._row.getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Row getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(int i) {
        ensureType(i);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCellType() {
        return this._value.getType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCachedFormulaResultType() {
        if (this._value.getType() != 2) {
            throw new IllegalStateException("Only formula cells have cached results");
        }
        return ((FormulaValue) this._value).getFormulaType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double d) {
        if (Double.isInfinite(d)) {
            setCellErrorValue(FormulaError.DIV0.getCode());
            return;
        }
        if (Double.isNaN(d)) {
            setCellErrorValue(FormulaError.NUM.getCode());
            return;
        }
        ensureTypeOrFormulaType(0);
        if (this._value.getType() == 2) {
            ((NumericFormulaValue) this._value).setPreEvaluatedValue(d);
        } else {
            ((NumericValue) this._value).setValue(d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Date date) {
        setCellValue(DateUtil.getExcelDate(date, false));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Calendar calendar) {
        setCellValue(DateUtil.getExcelDate(calendar, false));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        ensureRichTextStringType();
        if (richTextString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
            throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
        }
        ((RichTextValue) this._value).setValue(richTextString);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        ensureTypeOrFormulaType(1);
        if (str.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
            throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
        }
        if (this._value.getType() == 2) {
            ((StringFormulaValue) this._value).setPreEvaluatedValue(str);
        } else {
            ((PlainStringValue) this._value).setValue(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellFormula(String str) throws FormulaParseException {
        if (str == null) {
            setType(3);
        } else {
            ensureFormulaType(computeTypeFromFormula(str));
            ((FormulaValue) this._value).setValue(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        if (this._value.getType() != 2) {
            throw typeMismatch(2, this._value.getType(), false);
        }
        return ((FormulaValue) this._value).getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        int cellType = getCellType();
        if (cellType == 0) {
            return ((NumericValue) this._value).getValue();
        }
        if (cellType != 2) {
            if (cellType == 3) {
                return 0.0d;
            }
            throw typeMismatch(0, cellType, false);
        }
        if (((FormulaValue) this._value).getFormulaType() != 0) {
            throw typeMismatch(0, 2, false);
        }
        return ((NumericFormulaValue) this._value).getPreEvaluatedValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellType() == 3) {
            return null;
        }
        return DateUtil.getJavaDate(getNumericCellValue(), false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public RichTextString getRichStringCellValue() {
        int cellType = getCellType();
        if (getCellType() != 1) {
            throw typeMismatch(1, cellType, false);
        }
        if (((StringValue) this._value).isRichText()) {
            return ((RichTextValue) this._value).getValue();
        }
        return getSheet().getWorkbook().getCreationHelper().createRichTextString(getStringCellValue());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        int cellType = getCellType();
        if (cellType == 1) {
            if (((StringValue) this._value).isRichText()) {
                return ((RichTextValue) this._value).getValue().getString();
            }
            return ((PlainStringValue) this._value).getValue();
        }
        if (cellType != 2) {
            if (cellType == 3) {
                return "";
            }
            throw typeMismatch(1, cellType, false);
        }
        if (((FormulaValue) this._value).getFormulaType() != 1) {
            throw typeMismatch(1, 2, false);
        }
        return ((StringFormulaValue) this._value).getPreEvaluatedValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z) {
        ensureTypeOrFormulaType(4);
        if (this._value.getType() == 2) {
            ((BooleanFormulaValue) this._value).setPreEvaluatedValue(z);
        } else {
            ((BooleanValue) this._value).setValue(z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        ensureType(5);
        if (this._value.getType() == 2) {
            ((ErrorFormulaValue) this._value).setPreEvaluatedValue(b);
        } else {
            ((ErrorValue) this._value).setValue(b);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        int cellType = getCellType();
        if (cellType == 2) {
            if (((FormulaValue) this._value).getFormulaType() != 4) {
                throw typeMismatch(4, 2, false);
            }
            return ((BooleanFormulaValue) this._value).getPreEvaluatedValue();
        }
        if (cellType == 3) {
            return false;
        }
        if (cellType == 4) {
            return ((BooleanValue) this._value).getValue();
        }
        throw typeMismatch(4, cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        int cellType = getCellType();
        if (cellType == 2) {
            if (((FormulaValue) this._value).getFormulaType() != 5) {
                throw typeMismatch(5, 2, false);
            }
            return ((ErrorFormulaValue) this._value).getPreEvaluatedValue();
        }
        if (cellType == 3) {
            return (byte) 0;
        }
        if (cellType == 5) {
            return ((ErrorValue) this._value).getValue();
        }
        throw typeMismatch(5, cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        this._style = cellStyle;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellStyle getCellStyle() {
        CellStyle cellStyle = this._style;
        return cellStyle == null ? ((SXSSFWorkbook) getRow().getSheet().getWorkbook()).getCellStyleAt((short) 0) : cellStyle;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        setProperty(1, comment);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Comment getCellComment() {
        return (Comment) getPropertyValue(1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        removeProperty(1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Hyperlink getHyperlink() {
        return (Hyperlink) getPropertyValue(2);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        setProperty(2, hyperlink);
        XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) hyperlink;
        xSSFHyperlink.getCTHyperlink().setRef(new CellReference(getRowIndex(), getColumnIndex()).formatAsString());
        ((SXSSFSheet) getSheet())._sh.addHyperlink(xSSFHyperlink);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        removeProperty(2);
        ((SXSSFSheet) getSheet())._sh.removeHyperlink(getRowIndex(), getColumnIndex());
    }

    public String toString() {
        int cellType = getCellType();
        if (cellType == 0) {
            if (DateUtil.isCellDateFormatted(this)) {
                return new SimpleDateFormat("dd-MMM-yyyy").format(getDateCellValue());
            }
            return getNumericCellValue() + "";
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

    void removeProperty(int i) {
        Property property = this._firstProperty;
        Property property2 = null;
        while (property != null && property.getType() != i) {
            property2 = property;
            property = property._next;
        }
        if (property != null) {
            if (property2 != null) {
                property2._next = property._next;
            } else {
                this._firstProperty = property._next;
            }
        }
    }

    void setProperty(int i, Object obj) {
        Property property = this._firstProperty;
        Property property2 = null;
        while (property != null && property.getType() != i) {
            property2 = property;
            property = property._next;
        }
        if (property != null) {
            property.setValue(obj);
            return;
        }
        if (i == 1) {
            property = new CommentProperty(obj);
        } else if (i == 2) {
            property = new HyperlinkProperty(obj);
        }
        if (property2 != null) {
            property2._next = property;
        } else {
            this._firstProperty = property;
        }
    }

    Object getPropertyValue(int i) {
        return getPropertyValue(i, null);
    }

    Object getPropertyValue(int i, String str) {
        Property property = this._firstProperty;
        while (property != null && property.getType() != i) {
            property = property._next;
        }
        return property == null ? str : property.getValue();
    }

    void ensurePlainStringType() {
        if (this._value.getType() != 1 || ((StringValue) this._value).isRichText()) {
            this._value = new PlainStringValue();
        }
    }

    void ensureRichTextStringType() {
        if (this._value.getType() == 1 && ((StringValue) this._value).isRichText()) {
            return;
        }
        this._value = new RichTextValue();
    }

    void ensureType(int i) {
        if (this._value.getType() != i) {
            setType(i);
        }
    }

    void ensureFormulaType(int i) {
        if (this._value.getType() == 2 && ((FormulaValue) this._value).getFormulaType() == i) {
            return;
        }
        setFormulaType(i);
    }

    void ensureTypeOrFormulaType(int i) {
        if (this._value.getType() == i) {
            if (i == 1 && ((StringValue) this._value).isRichText()) {
                setType(1);
                return;
            }
            return;
        }
        if (this._value.getType() == 2) {
            if (((FormulaValue) this._value).getFormulaType() == i) {
                return;
            }
            setFormulaType(i);
            return;
        }
        setType(i);
    }

    void setType(int i) {
        if (i == 0) {
            this._value = new NumericValue();
            return;
        }
        if (i == 1) {
            PlainStringValue plainStringValue = new PlainStringValue();
            if (this._value != null) {
                plainStringValue.setValue(convertCellValueToString());
            }
            this._value = plainStringValue;
            return;
        }
        if (i == 2) {
            this._value = new NumericFormulaValue();
            return;
        }
        if (i == 3) {
            this._value = new BlankValue();
            return;
        }
        if (i != 4) {
            if (i == 5) {
                this._value = new ErrorValue();
                return;
            }
            throw new IllegalArgumentException("Illegal type " + i);
        }
        BooleanValue booleanValue = new BooleanValue();
        if (this._value != null) {
            booleanValue.setValue(convertCellValueToBoolean());
        }
        this._value = booleanValue;
    }

    void setFormulaType(int i) {
        if (i == 0) {
            this._value = new NumericFormulaValue();
            return;
        }
        if (i == 1) {
            this._value = new StringFormulaValue();
        } else if (i == 4) {
            this._value = new BooleanFormulaValue();
        } else {
            if (i == 5) {
                this._value = new ErrorFormulaValue();
                return;
            }
            throw new IllegalArgumentException("Illegal type " + i);
        }
    }

    private static RuntimeException typeMismatch(int i, int i2, boolean z) {
        return new IllegalStateException("Cannot get a " + getCellTypeName(i) + " value from a " + getCellTypeName(i2) + StringUtils.SPACE + (z ? "formula " : "") + "cell");
    }

    private static String getCellTypeName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "#unknown cell type (" + i + ")#" : IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR : XmlErrorCodes.BOOLEAN : "blank" : "formula" : "text" : "numeric";
    }

    private boolean convertCellValueToBoolean() {
        int cellType = getCellType();
        if (cellType == 2) {
            cellType = getCachedFormulaResultType();
        }
        if (cellType == 0) {
            return getNumericCellValue() != 0.0d;
        }
        if (cellType == 1) {
            return Boolean.parseBoolean(getStringCellValue());
        }
        if (cellType != 3) {
            if (cellType == 4) {
                return getBooleanCellValue();
            }
            if (cellType != 5) {
                throw new RuntimeException("Unexpected cell type (" + cellType + ")");
            }
        }
        return false;
    }

    private String convertCellValueToString() {
        int cellType = getCellType();
        if (cellType == 0) {
            return Double.toString(getNumericCellValue());
        }
        if (cellType == 1) {
            return getStringCellValue();
        }
        if (cellType == 2 || cellType == 3) {
            return "";
        }
        if (cellType == 4) {
            return getBooleanCellValue() ? "TRUE" : "FALSE";
        }
        if (cellType == 5) {
            return FormulaError.forInt(getErrorCellValue()).getString();
        }
        throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
    }

    static abstract class Property {
        static final int COMMENT = 1;
        static final int HYPERLINK = 2;
        Property _next;
        Object _value;

        abstract int getType();

        public Property(Object obj) {
            this._value = obj;
        }

        void setValue(Object obj) {
            this._value = obj;
        }

        Object getValue() {
            return this._value;
        }
    }

    static class CommentProperty extends Property {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Property
        public int getType() {
            return 1;
        }

        public CommentProperty(Object obj) {
            super(obj);
        }
    }

    static class HyperlinkProperty extends Property {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Property
        public int getType() {
            return 2;
        }

        public HyperlinkProperty(Object obj) {
            super(obj);
        }
    }

    static class NumericValue implements Value {
        double _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 0;
        }

        NumericValue() {
        }

        void setValue(double d) {
            this._value = d;
        }

        double getValue() {
            return this._value;
        }
    }

    static abstract class StringValue implements Value {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 1;
        }

        abstract boolean isRichText();

        StringValue() {
        }
    }

    static class PlainStringValue extends StringValue {
        String _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        boolean isRichText() {
            return false;
        }

        PlainStringValue() {
        }

        void setValue(String str) {
            this._value = str;
        }

        String getValue() {
            return this._value;
        }
    }

    static class RichTextValue extends StringValue {
        RichTextString _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue, org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 1;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        boolean isRichText() {
            return true;
        }

        RichTextValue() {
        }

        void setValue(RichTextString richTextString) {
            this._value = richTextString;
        }

        RichTextString getValue() {
            return this._value;
        }
    }

    static abstract class FormulaValue implements Value {
        String _value;

        abstract int getFormulaType();

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 2;
        }

        FormulaValue() {
        }

        void setValue(String str) {
            this._value = str;
        }

        String getValue() {
            return this._value;
        }
    }

    static class NumericFormulaValue extends FormulaValue {
        double _preEvaluatedValue;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        int getFormulaType() {
            return 0;
        }

        NumericFormulaValue() {
        }

        void setPreEvaluatedValue(double d) {
            this._preEvaluatedValue = d;
        }

        double getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class StringFormulaValue extends FormulaValue {
        String _preEvaluatedValue;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        int getFormulaType() {
            return 1;
        }

        StringFormulaValue() {
        }

        void setPreEvaluatedValue(String str) {
            this._preEvaluatedValue = str;
        }

        String getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class BooleanFormulaValue extends FormulaValue {
        boolean _preEvaluatedValue;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        int getFormulaType() {
            return 4;
        }

        BooleanFormulaValue() {
        }

        void setPreEvaluatedValue(boolean z) {
            this._preEvaluatedValue = z;
        }

        boolean getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class ErrorFormulaValue extends FormulaValue {
        byte _preEvaluatedValue;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        int getFormulaType() {
            return 5;
        }

        ErrorFormulaValue() {
        }

        void setPreEvaluatedValue(byte b) {
            this._preEvaluatedValue = b;
        }

        byte getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class BlankValue implements Value {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 3;
        }

        BlankValue() {
        }
    }

    static class BooleanValue implements Value {
        boolean _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 4;
        }

        BooleanValue() {
        }

        void setValue(boolean z) {
            this._value = z;
        }

        boolean getValue() {
            return this._value;
        }
    }

    static class ErrorValue implements Value {
        byte _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public int getType() {
            return 5;
        }

        ErrorValue() {
        }

        void setValue(byte b) {
            this._value = b;
        }

        byte getValue() {
            return this._value;
        }
    }
}
