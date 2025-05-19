package org.apache.poi.xssf.usermodel;

import java.util.List;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationName;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;

/* loaded from: classes5.dex */
public final class XSSFEvaluationWorkbook implements FormulaRenderingWorkbook, EvaluationWorkbook, FormulaParsingWorkbook {
    private final XSSFWorkbook _uBook;

    private int convertFromExternalSheetIndex(int i) {
        return i;
    }

    private int convertToExternalSheetIndex(int i) {
        return i;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int convertFromExternSheetIndex(int i) {
        return i;
    }

    public static XSSFEvaluationWorkbook create(XSSFWorkbook xSSFWorkbook) {
        if (xSSFWorkbook == null) {
            return null;
        }
        return new XSSFEvaluationWorkbook(xSSFWorkbook);
    }

    private XSSFEvaluationWorkbook(XSSFWorkbook xSSFWorkbook) {
        this._uBook = xSSFWorkbook;
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public int getExternalSheetIndex(String str) {
        return convertToExternalSheetIndex(this._uBook.getSheetIndex(str));
    }

    private int resolveBookIndex(String str) {
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 2);
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            List<ExternalLinksTable> externalLinksTable = this._uBook.getExternalLinksTable();
            int findExternalLinkIndex = findExternalLinkIndex(str, externalLinksTable);
            if (findExternalLinkIndex != -1) {
                return findExternalLinkIndex;
            }
            if (str.startsWith("'file:///") && str.endsWith("'")) {
                String substring = str.substring(str.lastIndexOf(47) + 1);
                String substring2 = substring.substring(0, substring.length() - 1);
                int findExternalLinkIndex2 = findExternalLinkIndex(substring2, externalLinksTable);
                if (findExternalLinkIndex2 != -1) {
                    return findExternalLinkIndex2;
                }
                externalLinksTable.add(new FakeExternalLinksTable(substring2));
                return externalLinksTable.size();
            }
            throw new RuntimeException("Book not linked for filename " + str);
        }
    }

    private int findExternalLinkIndex(String str, List<ExternalLinksTable> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLinkedFileName().equals(str)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static class FakeExternalLinksTable extends ExternalLinksTable {
        private final String fileName;

        private FakeExternalLinksTable(String str) {
            this.fileName = str;
        }

        @Override // org.apache.poi.xssf.model.ExternalLinksTable
        public String getLinkedFileName() {
            return this.fileName;
        }
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public EvaluationName getName(String str, int i) {
        for (int i2 = 0; i2 < this._uBook.getNumberOfNames(); i2++) {
            XSSFName nameAt = this._uBook.getNameAt(i2);
            String nameName = nameAt.getNameName();
            int sheetIndex = nameAt.getSheetIndex();
            if (str.equalsIgnoreCase(nameName) && (sheetIndex == -1 || sheetIndex == i)) {
                return new Name(this._uBook.getNameAt(i2), i2, this);
            }
        }
        if (i == -1) {
            return null;
        }
        return getName(str, -1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet evaluationSheet) {
        return this._uBook.getSheetIndex(((XSSFEvaluationSheet) evaluationSheet).getXSSFSheet());
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public String getSheetName(int i) {
        return this._uBook.getSheetName(i);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(int i, int i2) {
        throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(String str, String str2, int i) {
        if (i > 0) {
            ExternalLinksTable externalLinksTable = this._uBook.getExternalLinksTable().get(i - 1);
            for (org.apache.poi.ss.usermodel.Name name : externalLinksTable.getDefinedNames()) {
                if (name.getNameName().equals(str)) {
                    return new EvaluationWorkbook.ExternalName(str, -1, name.getSheetIndex() + 1);
                }
            }
            throw new IllegalArgumentException("Name '" + str + "' not found in reference to " + externalLinksTable.getLinkedFileName());
        }
        return new EvaluationWorkbook.ExternalName(str, this._uBook.getNameIndex(str), 0);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public NameXPxg getNameXPtg(String str, SheetIdentifier sheetIdentifier) {
        if (((IndexedUDFFinder) getUDFFinder()).findFunction(str) != null) {
            return new NameXPxg(null, str);
        }
        if (sheetIdentifier == null) {
            if (this._uBook.getNameIndex(str) > -1) {
                return new NameXPxg(null, str);
            }
            return null;
        }
        if (sheetIdentifier._sheetIdentifier == null) {
            return new NameXPxg(resolveBookIndex(sheetIdentifier._bookName), null, str);
        }
        String name = sheetIdentifier._sheetIdentifier.getName();
        if (sheetIdentifier._bookName != null) {
            return new NameXPxg(resolveBookIndex(sheetIdentifier._bookName), name, str);
        }
        return new NameXPxg(name, str);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(CellReference cellReference, SheetIdentifier sheetIdentifier) {
        if (sheetIdentifier._bookName != null) {
            return new Ref3DPxg(resolveBookIndex(sheetIdentifier._bookName), sheetIdentifier, cellReference);
        }
        return new Ref3DPxg(sheetIdentifier, cellReference);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(AreaReference areaReference, SheetIdentifier sheetIdentifier) {
        if (sheetIdentifier._bookName != null) {
            return new Area3DPxg(resolveBookIndex(sheetIdentifier._bookName), sheetIdentifier, areaReference);
        }
        return new Area3DPxg(sheetIdentifier, areaReference);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook, org.apache.poi.ss.formula.EvaluationWorkbook
    public String resolveNameXText(NameXPtg nameXPtg) {
        XSSFName nameAt;
        int nameIndex = nameXPtg.getNameIndex();
        String functionName = ((IndexedUDFFinder) getUDFFinder()).getFunctionName(nameIndex);
        return (functionName == null && (nameAt = this._uBook.getNameAt(nameIndex)) != null) ? nameAt.getNameName() : functionName;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int i) {
        return new XSSFEvaluationSheet(this._uBook.getSheetAt(i));
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook, org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(int i) {
        throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(String str, String str2, int i) {
        String str3;
        if (i > 0) {
            str3 = this._uBook.getExternalLinksTable().get(i - 1).getLinkedFileName();
        } else {
            str3 = null;
        }
        if (str2 == null || str.equals(str2)) {
            return new EvaluationWorkbook.ExternalSheet(str3, str);
        }
        return new EvaluationWorkbook.ExternalSheetRange(str3, str, str2);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public int getExternalSheetIndex(String str, String str2) {
        throw new RuntimeException("not implemented yet");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(String str) {
        return this._uBook.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetFirstNameByExternSheet(int i) {
        return this._uBook.getSheetName(convertFromExternalSheetIndex(i));
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetLastNameByExternSheet(int i) {
        return getSheetFirstNameByExternSheet(i);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getNameText(NamePtg namePtg) {
        return this._uBook.getNameAt(namePtg.getIndex()).getNameName();
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationName getName(NamePtg namePtg) {
        int index = namePtg.getIndex();
        return new Name(this._uBook.getNameAt(index), index, this);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell evaluationCell) {
        XSSFCell xSSFCell = ((XSSFEvaluationCell) evaluationCell).getXSSFCell();
        return FormulaParser.parse(xSSFCell.getCellFormula(), create(this._uBook), 0, this._uBook.getSheetIndex(xSSFCell.getSheet()));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public UDFFinder getUDFFinder() {
        return this._uBook.getUDFFinder();
    }

    private static final class Name implements EvaluationName {
        private final FormulaParsingWorkbook _fpBook;
        private final int _index;
        private final XSSFName _nameRecord;

        public Name(XSSFName xSSFName, int i, FormulaParsingWorkbook formulaParsingWorkbook) {
            this._nameRecord = xSSFName;
            this._index = i;
            this._fpBook = formulaParsingWorkbook;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public Ptg[] getNameDefinition() {
            return FormulaParser.parse(this._nameRecord.getRefersToFormula(), this._fpBook, 4, this._nameRecord.getSheetIndex());
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public String getNameText() {
            return this._nameRecord.getNameName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean hasFormula() {
            CTDefinedName cTName = this._nameRecord.getCTName();
            String stringValue = cTName.getStringValue();
            return (cTName.getFunction() || stringValue == null || stringValue.length() <= 0) ? false : true;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isFunctionName() {
            return this._nameRecord.isFunctionName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isRange() {
            return hasFormula();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public NamePtg createPtg() {
            return new NamePtg(this._index);
        }
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }
}
