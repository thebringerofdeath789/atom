package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;

/* loaded from: classes5.dex */
public final class HSSFName implements Name {
    private HSSFWorkbook _book;
    private NameCommentRecord _commentRec;
    private NameRecord _definedNameRec;

    HSSFName(HSSFWorkbook hSSFWorkbook, NameRecord nameRecord) {
        this(hSSFWorkbook, nameRecord, null);
    }

    HSSFName(HSSFWorkbook hSSFWorkbook, NameRecord nameRecord, NameCommentRecord nameCommentRecord) {
        this._book = hSSFWorkbook;
        this._definedNameRec = nameRecord;
        this._commentRec = nameCommentRecord;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getSheetName() {
        return this._book.getWorkbook().findSheetFirstNameFromExternSheet(this._definedNameRec.getExternSheetNumber());
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getNameName() {
        return this._definedNameRec.getNameText();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setNameName(String str) {
        validateName(str);
        InternalWorkbook workbook = this._book.getWorkbook();
        this._definedNameRec.setNameText(str);
        int sheetNumber = this._definedNameRec.getSheetNumber();
        for (int numNames = workbook.getNumNames() - 1; numNames >= 0; numNames--) {
            NameRecord nameRecord = workbook.getNameRecord(numNames);
            if (nameRecord != this._definedNameRec && nameRecord.getNameText().equalsIgnoreCase(str) && sheetNumber == nameRecord.getSheetNumber()) {
                String str2 = "The " + (sheetNumber == 0 ? "workbook" : "sheet") + " already contains this name: " + str;
                this._definedNameRec.setNameText(str + "(2)");
                throw new IllegalArgumentException(str2);
            }
        }
        NameCommentRecord nameCommentRecord = this._commentRec;
        if (nameCommentRecord != null) {
            nameCommentRecord.getNameText();
            this._commentRec.setNameText(str);
            this._book.getWorkbook().updateNameCommentRecordCache(this._commentRec);
        }
    }

    private static void validateName(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        char charAt = str.charAt(0);
        if ((charAt != '_' && !Character.isLetter(charAt)) || str.indexOf(32) != -1) {
            throw new IllegalArgumentException("Invalid name: '" + str + "'; Names must begin with a letter or underscore and not contain spaces");
        }
    }

    public String getReference() {
        return getRefersToFormula();
    }

    public void setReference(String str) {
        setRefersToFormula(str);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setRefersToFormula(String str) {
        this._definedNameRec.setNameDefinition(HSSFFormulaParser.parse(str, this._book, 4, getSheetIndex()));
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getRefersToFormula() {
        if (this._definedNameRec.isFunctionName()) {
            throw new IllegalStateException("Only applicable to named ranges");
        }
        Ptg[] nameDefinition = this._definedNameRec.getNameDefinition();
        if (nameDefinition.length < 1) {
            return null;
        }
        return HSSFFormulaParser.toFormulaString(this._book, nameDefinition);
    }

    void setNameDefinition(Ptg[] ptgArr) {
        this._definedNameRec.setNameDefinition(ptgArr);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isDeleted() {
        return Ptg.doesFormulaReferToDeletedCell(this._definedNameRec.getNameDefinition());
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isFunctionName() {
        return this._definedNameRec.isFunctionName();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(this._definedNameRec.getNameText());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setSheetIndex(int i) {
        int numberOfSheets = this._book.getNumberOfSheets() - 1;
        if (i < -1 || i > numberOfSheets) {
            throw new IllegalArgumentException("Sheet index (" + i + ") is out of range" + (numberOfSheets == -1 ? "" : " (0.." + numberOfSheets + ")"));
        }
        this._definedNameRec.setSheetNumber(i + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public int getSheetIndex() {
        return this._definedNameRec.getSheetNumber() - 1;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getComment() {
        NameCommentRecord nameCommentRecord = this._commentRec;
        if (nameCommentRecord != null && nameCommentRecord.getCommentText() != null && this._commentRec.getCommentText().length() > 0) {
            return this._commentRec.getCommentText();
        }
        return this._definedNameRec.getDescriptionText();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setComment(String str) {
        this._definedNameRec.setDescriptionText(str);
        NameCommentRecord nameCommentRecord = this._commentRec;
        if (nameCommentRecord != null) {
            nameCommentRecord.setCommentText(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setFunction(boolean z) {
        this._definedNameRec.setFunction(z);
    }
}
