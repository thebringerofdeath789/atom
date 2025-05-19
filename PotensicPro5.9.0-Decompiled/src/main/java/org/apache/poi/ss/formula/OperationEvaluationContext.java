package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.util.CellReference;

/* loaded from: classes5.dex */
public final class OperationEvaluationContext {
    public static final FreeRefFunction UDF = UserDefinedFunction.instance;
    private final WorkbookEvaluator _bookEvaluator;
    private final int _columnIndex;
    private final int _rowIndex;
    private final int _sheetIndex;
    private final EvaluationTracker _tracker;
    private final EvaluationWorkbook _workbook;

    public OperationEvaluationContext(WorkbookEvaluator workbookEvaluator, EvaluationWorkbook evaluationWorkbook, int i, int i2, int i3, EvaluationTracker evaluationTracker) {
        this._bookEvaluator = workbookEvaluator;
        this._workbook = evaluationWorkbook;
        this._sheetIndex = i;
        this._rowIndex = i2;
        this._columnIndex = i3;
        this._tracker = evaluationTracker;
    }

    public EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    public int getRowIndex() {
        return this._rowIndex;
    }

    public int getColumnIndex() {
        return this._columnIndex;
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(ExternSheetReferenceToken externSheetReferenceToken) {
        return createExternSheetRefEvaluator(externSheetReferenceToken.getExternSheetIndex());
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(String str, String str2, int i) {
        return createExternSheetRefEvaluator(this._workbook.getExternalSheet(str, str2, i));
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(int i) {
        return createExternSheetRefEvaluator(this._workbook.getExternalSheet(i));
    }

    SheetRangeEvaluator createExternSheetRefEvaluator(EvaluationWorkbook.ExternalSheet externalSheet) {
        WorkbookEvaluator workbookEvaluator;
        int sheetIndex;
        int sheetIndex2;
        if (externalSheet == null || externalSheet.getWorkbookName() == null) {
            workbookEvaluator = this._bookEvaluator;
            sheetIndex = this._workbook.getSheetIndex(externalSheet.getSheetName());
            sheetIndex2 = externalSheet instanceof EvaluationWorkbook.ExternalSheetRange ? this._workbook.getSheetIndex(((EvaluationWorkbook.ExternalSheetRange) externalSheet).getLastSheetName()) : -1;
        } else {
            String workbookName = externalSheet.getWorkbookName();
            try {
                workbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(workbookName);
                sheetIndex = workbookEvaluator.getSheetIndex(externalSheet.getSheetName());
                sheetIndex2 = externalSheet instanceof EvaluationWorkbook.ExternalSheetRange ? workbookEvaluator.getSheetIndex(((EvaluationWorkbook.ExternalSheetRange) externalSheet).getLastSheetName()) : -1;
                if (sheetIndex < 0) {
                    throw new RuntimeException("Invalid sheet name '" + externalSheet.getSheetName() + "' in bool '" + workbookName + "'.");
                }
            } catch (CollaboratingWorkbooksEnvironment.WorkbookNotFoundException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        if (sheetIndex2 == -1) {
            sheetIndex2 = sheetIndex;
        }
        int i = (sheetIndex2 - sheetIndex) + 1;
        SheetRefEvaluator[] sheetRefEvaluatorArr = new SheetRefEvaluator[i];
        for (int i2 = 0; i2 < i; i2++) {
            sheetRefEvaluatorArr[i2] = new SheetRefEvaluator(workbookEvaluator, this._tracker, i2 + sheetIndex);
        }
        return new SheetRangeEvaluator(sheetIndex, sheetIndex2, sheetRefEvaluatorArr);
    }

    private SheetRefEvaluator createExternSheetRefEvaluator(String str, String str2) {
        WorkbookEvaluator otherWorkbookEvaluator;
        if (str == null) {
            otherWorkbookEvaluator = this._bookEvaluator;
        } else {
            if (str2 == null) {
                throw new IllegalArgumentException("sheetName must not be null if workbookName is provided");
            }
            try {
                otherWorkbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(str);
            } catch (CollaboratingWorkbooksEnvironment.WorkbookNotFoundException unused) {
                return null;
            }
        }
        int sheetIndex = str2 == null ? this._sheetIndex : otherWorkbookEvaluator.getSheetIndex(str2);
        if (sheetIndex < 0) {
            return null;
        }
        return new SheetRefEvaluator(otherWorkbookEvaluator, this._tracker, sheetIndex);
    }

    public SheetRangeEvaluator getRefEvaluatorForCurrentSheet() {
        return new SheetRangeEvaluator(this._sheetIndex, new SheetRefEvaluator(this._bookEvaluator, this._tracker, this._sheetIndex));
    }

    public ValueEval getDynamicReference(String str, String str2, String str3, String str4, boolean z) {
        int lastRowIndex;
        int parseColRef;
        int parseColRef2;
        int i;
        int i2;
        int i3;
        int i4;
        int lastColumnIndex;
        int parseRowRef;
        int parseRowRef2;
        if (!z) {
            throw new RuntimeException("R1C1 style not supported yet");
        }
        SheetRefEvaluator createExternSheetRefEvaluator = createExternSheetRefEvaluator(str, str2);
        if (createExternSheetRefEvaluator == null) {
            return ErrorEval.REF_INVALID;
        }
        SheetRangeEvaluator sheetRangeEvaluator = new SheetRangeEvaluator(this._sheetIndex, createExternSheetRefEvaluator);
        SpreadsheetVersion spreadsheetVersion = ((FormulaParsingWorkbook) this._workbook).getSpreadsheetVersion();
        CellReference.NameType classifyCellReference = classifyCellReference(str3, spreadsheetVersion);
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[classifyCellReference.ordinal()];
        if (i5 == 1) {
            return ErrorEval.REF_INVALID;
        }
        if (i5 == 2) {
            EvaluationName name = ((FormulaParsingWorkbook) this._workbook).getName(str3, this._sheetIndex);
            if (!name.isRange()) {
                throw new RuntimeException("Specified name '" + str3 + "' is not a range as expected.");
            }
            return this._bookEvaluator.evaluateNameFormula(name.getNameDefinition(), this);
        }
        if (str4 == null) {
            int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[classifyCellReference.ordinal()];
            if (i6 == 3 || i6 == 4) {
                return ErrorEval.REF_INVALID;
            }
            if (i6 == 5) {
                CellReference cellReference = new CellReference(str3);
                return new LazyRefEval(cellReference.getRow(), cellReference.getCol(), sheetRangeEvaluator);
            }
            throw new IllegalStateException("Unexpected reference classification of '" + str3 + "'.");
        }
        CellReference.NameType classifyCellReference2 = classifyCellReference(str3, spreadsheetVersion);
        int i7 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[classifyCellReference2.ordinal()];
        if (i7 == 1) {
            return ErrorEval.REF_INVALID;
        }
        if (i7 == 2) {
            throw new RuntimeException("Cannot evaluate '" + str3 + "'. Indirect evaluation of defined names not supported yet");
        }
        if (classifyCellReference2 != classifyCellReference) {
            return ErrorEval.REF_INVALID;
        }
        int i8 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType[classifyCellReference.ordinal()];
        if (i8 == 3) {
            if (classifyCellReference2.equals(CellReference.NameType.COLUMN)) {
                lastRowIndex = spreadsheetVersion.getLastRowIndex();
                parseColRef = parseRowRef(str3);
                parseColRef2 = parseRowRef(str4);
            } else {
                lastRowIndex = spreadsheetVersion.getLastRowIndex();
                parseColRef = parseColRef(str3);
                parseColRef2 = parseColRef(str4);
            }
            i = lastRowIndex;
            i2 = parseColRef;
            i3 = parseColRef2;
            i4 = 0;
        } else if (i8 == 4) {
            if (classifyCellReference2.equals(CellReference.NameType.ROW)) {
                parseRowRef = parseColRef(str3);
                parseRowRef2 = parseColRef(str4);
                lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
            } else {
                lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
                parseRowRef = parseRowRef(str3);
                parseRowRef2 = parseRowRef(str4);
            }
            i3 = lastColumnIndex;
            i4 = parseRowRef;
            i = parseRowRef2;
            i2 = 0;
        } else if (i8 == 5) {
            CellReference cellReference2 = new CellReference(str3);
            int row = cellReference2.getRow();
            short col = cellReference2.getCol();
            CellReference cellReference3 = new CellReference(str4);
            int row2 = cellReference3.getRow();
            i2 = col;
            i4 = row;
            i3 = cellReference3.getCol();
            i = row2;
        } else {
            throw new IllegalStateException("Unexpected reference classification of '" + str3 + "'.");
        }
        return new LazyAreaEval(i4, i2, i, i3, sheetRangeEvaluator);
    }

    /* renamed from: org.apache.poi.ss.formula.OperationEvaluationContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$util$CellReference$NameType;

        static {
            int[] iArr = new int[CellReference.NameType.values().length];
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType = iArr;
            try {
                iArr[CellReference.NameType.BAD_CELL_OR_NAMED_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.NAMED_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.COLUMN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.ROW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.CELL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static int parseRowRef(String str) {
        return CellReference.convertColStringToIndex(str);
    }

    private static int parseColRef(String str) {
        return Integer.parseInt(str) - 1;
    }

    private static CellReference.NameType classifyCellReference(String str, SpreadsheetVersion spreadsheetVersion) {
        if (str.length() < 1) {
            return CellReference.NameType.BAD_CELL_OR_NAMED_RANGE;
        }
        return CellReference.classifyCellReference(str, spreadsheetVersion);
    }

    public FreeRefFunction findUserDefinedFunction(String str) {
        return this._bookEvaluator.findUserDefinedFunction(str);
    }

    public ValueEval getRefEval(int i, int i2) {
        return new LazyRefEval(i, i2, getRefEvaluatorForCurrentSheet());
    }

    public ValueEval getRef3DEval(Ref3DPtg ref3DPtg) {
        return new LazyRefEval(ref3DPtg.getRow(), ref3DPtg.getColumn(), createExternSheetRefEvaluator(ref3DPtg.getExternSheetIndex()));
    }

    public ValueEval getRef3DEval(Ref3DPxg ref3DPxg) {
        return new LazyRefEval(ref3DPxg.getRow(), ref3DPxg.getColumn(), createExternSheetRefEvaluator(ref3DPxg.getSheetName(), ref3DPxg.getLastSheetName(), ref3DPxg.getExternalWorkbookNumber()));
    }

    public ValueEval getAreaEval(int i, int i2, int i3, int i4) {
        return new LazyAreaEval(i, i2, i3, i4, getRefEvaluatorForCurrentSheet());
    }

    public ValueEval getArea3DEval(Area3DPtg area3DPtg) {
        return new LazyAreaEval(area3DPtg.getFirstRow(), area3DPtg.getFirstColumn(), area3DPtg.getLastRow(), area3DPtg.getLastColumn(), createExternSheetRefEvaluator(area3DPtg.getExternSheetIndex()));
    }

    public ValueEval getArea3DEval(Area3DPxg area3DPxg) {
        return new LazyAreaEval(area3DPxg.getFirstRow(), area3DPxg.getFirstColumn(), area3DPxg.getLastRow(), area3DPxg.getLastColumn(), createExternSheetRefEvaluator(area3DPxg.getSheetName(), area3DPxg.getLastSheetName(), area3DPxg.getExternalWorkbookNumber()));
    }

    public ValueEval getNameXEval(NameXPtg nameXPtg) {
        EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(nameXPtg.getSheetRefIndex());
        if (externalSheet == null || externalSheet.getWorkbookName() == null) {
            return getLocalNameXEval(nameXPtg);
        }
        return getExternalNameXEval(this._workbook.getExternalName(nameXPtg.getSheetRefIndex(), nameXPtg.getNameIndex()), externalSheet.getWorkbookName());
    }

    public ValueEval getNameXEval(NameXPxg nameXPxg) {
        EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(nameXPxg.getSheetName(), null, nameXPxg.getExternalWorkbookNumber());
        if (externalSheet == null || externalSheet.getWorkbookName() == null) {
            return getLocalNameXEval(nameXPxg);
        }
        return getExternalNameXEval(this._workbook.getExternalName(nameXPxg.getNameName(), nameXPxg.getSheetName(), nameXPxg.getExternalWorkbookNumber()), externalSheet.getWorkbookName());
    }

    private ValueEval getLocalNameXEval(NameXPxg nameXPxg) {
        int sheetIndex = nameXPxg.getSheetName() != null ? this._workbook.getSheetIndex(nameXPxg.getSheetName()) : -1;
        String nameName = nameXPxg.getNameName();
        EvaluationName name = this._workbook.getName(nameName, sheetIndex);
        if (name != null) {
            return new ExternalNameEval(name);
        }
        return new FunctionNameEval(nameName);
    }

    private ValueEval getLocalNameXEval(NameXPtg nameXPtg) {
        EvaluationName name;
        String resolveNameXText = this._workbook.resolveNameXText(nameXPtg);
        int indexOf = resolveNameXText.indexOf(33);
        if (indexOf > -1) {
            String substring = resolveNameXText.substring(0, indexOf);
            String substring2 = resolveNameXText.substring(indexOf + 1);
            EvaluationWorkbook evaluationWorkbook = this._workbook;
            name = evaluationWorkbook.getName(substring2, evaluationWorkbook.getSheetIndex(substring));
        } else {
            name = this._workbook.getName(resolveNameXText, -1);
        }
        if (name != null) {
            return new ExternalNameEval(name);
        }
        return new FunctionNameEval(resolveNameXText);
    }

    private ValueEval getExternalNameXEval(EvaluationWorkbook.ExternalName externalName, String str) {
        try {
            WorkbookEvaluator otherWorkbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(str);
            EvaluationName name = otherWorkbookEvaluator.getName(externalName.getName(), externalName.getIx() - 1);
            if (name != null && name.hasFormula()) {
                if (name.getNameDefinition().length > 1) {
                    throw new RuntimeException("Complex name formulas not supported yet");
                }
                OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(otherWorkbookEvaluator, otherWorkbookEvaluator.getWorkbook(), -1, -1, -1, this._tracker);
                Ptg ptg = name.getNameDefinition()[0];
                if (ptg instanceof Ref3DPtg) {
                    return operationEvaluationContext.getRef3DEval((Ref3DPtg) ptg);
                }
                if (ptg instanceof Ref3DPxg) {
                    return operationEvaluationContext.getRef3DEval((Ref3DPxg) ptg);
                }
                if (ptg instanceof Area3DPtg) {
                    return operationEvaluationContext.getArea3DEval((Area3DPtg) ptg);
                }
                if (ptg instanceof Area3DPxg) {
                    return operationEvaluationContext.getArea3DEval((Area3DPxg) ptg);
                }
            }
            return ErrorEval.REF_INVALID;
        } catch (CollaboratingWorkbooksEnvironment.WorkbookNotFoundException unused) {
            return ErrorEval.REF_INVALID;
        }
    }
}
