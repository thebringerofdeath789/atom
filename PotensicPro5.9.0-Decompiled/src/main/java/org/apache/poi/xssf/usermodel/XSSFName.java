package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.AreaReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;

/* loaded from: classes5.dex */
public final class XSSFName implements Name {
    public static final String BUILTIN_CONSOLIDATE_AREA = "_xlnm.Consolidate_Area";
    public static final String BUILTIN_CRITERIA = "_xlnm.Criteria:";
    public static final String BUILTIN_DATABASE = "_xlnm.Database";
    public static final String BUILTIN_EXTRACT = "_xlnm.Extract:";
    public static final String BUILTIN_FILTER_DB = "_xlnm._FilterDatabase";
    public static final String BUILTIN_PRINT_AREA = "_xlnm.Print_Area";
    public static final String BUILTIN_PRINT_TITLE = "_xlnm.Print_Titles";
    public static final String BUILTIN_SHEET_TITLE = "_xlnm.Sheet_Title";
    private CTDefinedName _ctName;
    private XSSFWorkbook _workbook;

    protected XSSFName(CTDefinedName cTDefinedName, XSSFWorkbook xSSFWorkbook) {
        this._workbook = xSSFWorkbook;
        this._ctName = cTDefinedName;
    }

    protected CTDefinedName getCTName() {
        return this._ctName;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getNameName() {
        return this._ctName.getName();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setNameName(String str) {
        validateName(str);
        int sheetIndex = getSheetIndex();
        for (int i = 0; i < this._workbook.getNumberOfNames(); i++) {
            XSSFName nameAt = this._workbook.getNameAt(i);
            if (nameAt != this && str.equalsIgnoreCase(nameAt.getNameName()) && sheetIndex == nameAt.getSheetIndex()) {
                throw new IllegalArgumentException("The " + (sheetIndex == -1 ? "workbook" : "sheet") + " already contains this name: " + str);
            }
        }
        this._ctName.setName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getRefersToFormula() {
        String stringValue = this._ctName.getStringValue();
        if (stringValue == null || stringValue.length() < 1) {
            return null;
        }
        return stringValue;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setRefersToFormula(String str) {
        FormulaParser.parse(str, XSSFEvaluationWorkbook.create(this._workbook), 4, getSheetIndex());
        this._ctName.setStringValue(str);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isDeleted() {
        String refersToFormula = getRefersToFormula();
        if (refersToFormula == null) {
            return false;
        }
        return Ptg.doesFormulaReferToDeletedCell(FormulaParser.parse(refersToFormula, XSSFEvaluationWorkbook.create(this._workbook), 4, getSheetIndex()));
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setSheetIndex(int i) {
        int numberOfSheets = this._workbook.getNumberOfSheets() - 1;
        if (i < -1 || i > numberOfSheets) {
            throw new IllegalArgumentException("Sheet index (" + i + ") is out of range" + (numberOfSheets == -1 ? "" : " (0.." + numberOfSheets + ")"));
        }
        if (i == -1) {
            if (this._ctName.isSetLocalSheetId()) {
                this._ctName.unsetLocalSheetId();
                return;
            }
            return;
        }
        this._ctName.setLocalSheetId(i);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public int getSheetIndex() {
        if (this._ctName.isSetLocalSheetId()) {
            return (int) this._ctName.getLocalSheetId();
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setFunction(boolean z) {
        this._ctName.setFunction(z);
    }

    public boolean getFunction() {
        return this._ctName.getFunction();
    }

    public void setFunctionGroupId(int i) {
        this._ctName.setFunctionGroupId(i);
    }

    public int getFunctionGroupId() {
        return (int) this._ctName.getFunctionGroupId();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getSheetName() {
        if (this._ctName.isSetLocalSheetId()) {
            return this._workbook.getSheetName((int) this._ctName.getLocalSheetId());
        }
        return new AreaReference(getRefersToFormula()).getFirstCell().getSheetName();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isFunctionName() {
        return getFunction();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getComment() {
        return this._ctName.getComment();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setComment(String str) {
        this._ctName.setComment(str);
    }

    public int hashCode() {
        return this._ctName.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XSSFName) {
            return this._ctName.toString().equals(((XSSFName) obj).getCTName().toString());
        }
        return false;
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
}
