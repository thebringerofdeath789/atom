package org.apache.poi.ss.formula;

import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.Choose;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.UnknownPtg;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class WorkbookEvaluator {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) WorkbookEvaluator.class);
    private final POILogger EVAL_LOG;
    private EvaluationCache _cache;
    private CollaboratingWorkbooksEnvironment _collaboratingWorkbookEnvironment;
    private final IEvaluationListener _evaluationListener;
    private boolean _ignoreMissingWorkbooks;
    private final Map<String, Integer> _sheetIndexesByName;
    private final Map<EvaluationSheet, Integer> _sheetIndexesBySheet;
    private final IStabilityClassifier _stabilityClassifier;
    private final AggregatingUDFFinder _udfFinder;
    private final EvaluationWorkbook _workbook;
    private int _workbookIx;
    private boolean dbgEvaluationOutputForNextEval;
    private int dbgEvaluationOutputIndent;

    public WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(evaluationWorkbook, null, iStabilityClassifier, uDFFinder);
    }

    WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IEvaluationListener iEvaluationListener, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this._ignoreMissingWorkbooks = false;
        this.dbgEvaluationOutputForNextEval = false;
        this.EVAL_LOG = POILogFactory.getLogger("POI.FormulaEval");
        this.dbgEvaluationOutputIndent = -1;
        this._workbook = evaluationWorkbook;
        this._evaluationListener = iEvaluationListener;
        this._cache = new EvaluationCache(iEvaluationListener);
        this._sheetIndexesBySheet = new IdentityHashMap();
        this._sheetIndexesByName = new IdentityHashMap();
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._workbookIx = 0;
        this._stabilityClassifier = iStabilityClassifier;
        AggregatingUDFFinder aggregatingUDFFinder = evaluationWorkbook == null ? null : (AggregatingUDFFinder) evaluationWorkbook.getUDFFinder();
        if (aggregatingUDFFinder != null && uDFFinder != null) {
            aggregatingUDFFinder.add(uDFFinder);
        }
        this._udfFinder = aggregatingUDFFinder;
    }

    String getSheetName(int i) {
        return this._workbook.getSheetName(i);
    }

    EvaluationSheet getSheet(int i) {
        return this._workbook.getSheet(i);
    }

    EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    EvaluationName getName(String str, int i) {
        return this._workbook.getName(str, i);
    }

    private static boolean isDebugLogEnabled() {
        return LOG.check(1);
    }

    private static boolean isInfoLogEnabled() {
        return LOG.check(3);
    }

    private static void logDebug(String str) {
        if (isDebugLogEnabled()) {
            LOG.log(1, str);
        }
    }

    private static void logInfo(String str) {
        if (isInfoLogEnabled()) {
            LOG.log(3, str);
        }
    }

    void attachToEnvironment(CollaboratingWorkbooksEnvironment collaboratingWorkbooksEnvironment, EvaluationCache evaluationCache, int i) {
        this._collaboratingWorkbookEnvironment = collaboratingWorkbooksEnvironment;
        this._cache = evaluationCache;
        this._workbookIx = i;
    }

    CollaboratingWorkbooksEnvironment getEnvironment() {
        return this._collaboratingWorkbookEnvironment;
    }

    void detachFromEnvironment() {
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._cache = new EvaluationCache(this._evaluationListener);
        this._workbookIx = 0;
    }

    WorkbookEvaluator getOtherWorkbookEvaluator(String str) throws CollaboratingWorkbooksEnvironment.WorkbookNotFoundException {
        return this._collaboratingWorkbookEnvironment.getWorkbookEvaluator(str);
    }

    IEvaluationListener getEvaluationListener() {
        return this._evaluationListener;
    }

    public void clearAllCachedResultValues() {
        this._cache.clear();
        this._sheetIndexesBySheet.clear();
    }

    public void notifyUpdateCell(EvaluationCell evaluationCell) {
        this._cache.notifyUpdateCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    public void notifyDeleteCell(EvaluationCell evaluationCell) {
        this._cache.notifyDeleteCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    private int getSheetIndex(EvaluationSheet evaluationSheet) {
        Integer num = this._sheetIndexesBySheet.get(evaluationSheet);
        if (num == null) {
            int sheetIndex = this._workbook.getSheetIndex(evaluationSheet);
            if (sheetIndex < 0) {
                throw new RuntimeException("Specified sheet from a different book");
            }
            num = Integer.valueOf(sheetIndex);
            this._sheetIndexesBySheet.put(evaluationSheet, num);
        }
        return num.intValue();
    }

    public ValueEval evaluate(EvaluationCell evaluationCell) {
        return evaluateAny(evaluationCell, getSheetIndex(evaluationCell.getSheet()), evaluationCell.getRowIndex(), evaluationCell.getColumnIndex(), new EvaluationTracker(this._cache));
    }

    int getSheetIndex(String str) {
        Integer num = this._sheetIndexesByName.get(str);
        if (num == null) {
            int sheetIndex = this._workbook.getSheetIndex(str);
            if (sheetIndex < 0) {
                return -1;
            }
            num = Integer.valueOf(sheetIndex);
            this._sheetIndexesByName.put(str, num);
        }
        return num.intValue();
    }

    int getSheetIndexByExternIndex(int i) {
        return this._workbook.convertFromExternSheetIndex(i);
    }

    private ValueEval evaluateAny(EvaluationCell evaluationCell, int i, int i2, int i3, EvaluationTracker evaluationTracker) {
        ValueEval numberEval;
        IStabilityClassifier iStabilityClassifier = this._stabilityClassifier;
        boolean z = iStabilityClassifier == null || !iStabilityClassifier.isCellFinal(i, i2, i3);
        if (evaluationCell == null || evaluationCell.getCellType() != 2) {
            ValueEval valueFromNonFormulaCell = getValueFromNonFormulaCell(evaluationCell);
            if (z) {
                evaluationTracker.acceptPlainValueDependency(this._workbookIx, i, i2, i3, valueFromNonFormulaCell);
            }
            return valueFromNonFormulaCell;
        }
        FormulaCellCacheEntry orCreateFormulaCellEntry = this._cache.getOrCreateFormulaCellEntry(evaluationCell);
        if (z || orCreateFormulaCellEntry.isInputSensitive()) {
            evaluationTracker.acceptFormulaDependency(orCreateFormulaCellEntry);
        }
        IEvaluationListener iEvaluationListener = this._evaluationListener;
        if (orCreateFormulaCellEntry.getValue() == null) {
            if (!evaluationTracker.startEvaluate(orCreateFormulaCellEntry)) {
                return ErrorEval.CIRCULAR_REF_ERROR;
            }
            OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(this, this._workbook, i, i2, i3, evaluationTracker);
            try {
                try {
                    Ptg[] formulaTokens = this._workbook.getFormulaTokens(evaluationCell);
                    if (iEvaluationListener == null) {
                        numberEval = evaluateFormula(operationEvaluationContext, formulaTokens);
                    } else {
                        iEvaluationListener.onStartEvaluate(evaluationCell, orCreateFormulaCellEntry);
                        ValueEval evaluateFormula = evaluateFormula(operationEvaluationContext, formulaTokens);
                        iEvaluationListener.onEndEvaluate(orCreateFormulaCellEntry, evaluateFormula);
                        numberEval = evaluateFormula;
                    }
                    evaluationTracker.updateCacheResult(numberEval);
                } catch (NotImplementedException e) {
                    throw addExceptionInfo(e, i, i2, i3);
                } catch (RuntimeException e2) {
                    if ((e2.getCause() instanceof CollaboratingWorkbooksEnvironment.WorkbookNotFoundException) && this._ignoreMissingWorkbooks) {
                        logInfo(e2.getCause().getMessage() + " - Continuing with cached value!");
                        int cachedFormulaResultType = evaluationCell.getCachedFormulaResultType();
                        if (cachedFormulaResultType == 0) {
                            numberEval = new NumberEval(evaluationCell.getNumericCellValue());
                        } else if (cachedFormulaResultType == 1) {
                            numberEval = new StringEval(evaluationCell.getStringCellValue());
                        } else if (cachedFormulaResultType == 3) {
                            numberEval = BlankEval.instance;
                        } else if (cachedFormulaResultType == 4) {
                            numberEval = BoolEval.valueOf(evaluationCell.getBooleanCellValue());
                        } else if (cachedFormulaResultType == 5) {
                            numberEval = ErrorEval.valueOf(evaluationCell.getErrorCellValue());
                        } else {
                            throw new RuntimeException("Unexpected cell type '" + evaluationCell.getCellType() + "' found!");
                        }
                    } else {
                        throw e2;
                    }
                }
                if (isDebugLogEnabled()) {
                    logDebug("Evaluated " + getSheetName(i) + "!" + new CellReference(i2, i3).formatAsString() + " to " + numberEval.toString());
                }
                return numberEval;
            } finally {
                evaluationTracker.endEvaluate(orCreateFormulaCellEntry);
            }
        }
        if (iEvaluationListener != null) {
            iEvaluationListener.onCacheHit(i, i2, i3, orCreateFormulaCellEntry.getValue());
        }
        return orCreateFormulaCellEntry.getValue();
    }

    private NotImplementedException addExceptionInfo(NotImplementedException notImplementedException, int i, int i2, int i3) {
        try {
            return new NotImplementedException("Error evaluating cell " + new CellReference(this._workbook.getSheetName(i), i2, i3, false, false).formatAsString(), notImplementedException);
        } catch (Exception e) {
            e.printStackTrace();
            return notImplementedException;
        }
    }

    static ValueEval getValueFromNonFormulaCell(EvaluationCell evaluationCell) {
        if (evaluationCell == null) {
            return BlankEval.instance;
        }
        int cellType = evaluationCell.getCellType();
        if (cellType == 0) {
            return new NumberEval(evaluationCell.getNumericCellValue());
        }
        if (cellType == 1) {
            return new StringEval(evaluationCell.getStringCellValue());
        }
        if (cellType == 3) {
            return BlankEval.instance;
        }
        if (cellType == 4) {
            return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
        }
        if (cellType == 5) {
            return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
        }
        throw new RuntimeException("Unexpected cell type (" + cellType + ")");
    }

    ValueEval evaluateFormula(OperationEvaluationContext operationEvaluationContext, Ptg[] ptgArr) {
        ValueEval evalForPtg;
        int countTokensToBeSkipped;
        int chooseFuncOffset;
        int i;
        int evaluateFirstArg;
        int i2 = 0;
        if (this.dbgEvaluationOutputForNextEval) {
            this.dbgEvaluationOutputIndent = 1;
            this.dbgEvaluationOutputForNextEval = false;
        }
        int i3 = this.dbgEvaluationOutputIndent;
        String str = "";
        if (i3 > 0) {
            String substring = "                                                                                                    ".substring(0, Math.min(100, i3 * 2));
            this.EVAL_LOG.log(5, substring + "- evaluateFormula('" + operationEvaluationContext.getRefEvaluatorForCurrentSheet().getSheetNameRange() + "'/" + new CellReference(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()).formatAsString() + "): " + Arrays.toString(ptgArr).replaceAll("\\Qorg.apache.poi.ss.formula.ptg.\\E", ""));
            this.dbgEvaluationOutputIndent++;
            str = substring;
        }
        Stack stack = new Stack();
        int length = ptgArr.length;
        while (i2 < length) {
            Ptg ptg = ptgArr[i2];
            if (this.dbgEvaluationOutputIndent > 0) {
                this.EVAL_LOG.log(3, str + "  * ptg " + i2 + ": " + ptg);
            }
            if (ptg instanceof AttrPtg) {
                AttrPtg attrPtg = (AttrPtg) ptg;
                if (attrPtg.isSum()) {
                    ptg = FuncVarPtg.SUM;
                }
                if (attrPtg.isOptimizedChoose()) {
                    ValueEval valueEval = (ValueEval) stack.pop();
                    int[] jumpTable = attrPtg.getJumpTable();
                    int length2 = jumpTable.length;
                    try {
                        evaluateFirstArg = Choose.evaluateFirstArg(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    } catch (EvaluationException e) {
                        stack.push(e.getErrorEval());
                        chooseFuncOffset = attrPtg.getChooseFuncOffset();
                    }
                    if (evaluateFirstArg >= 1 && evaluateFirstArg <= length2) {
                        i = jumpTable[evaluateFirstArg - 1];
                        countTokensToBeSkipped = countTokensToBeSkipped(ptgArr, i2, i - ((length2 * 2) + 2));
                    }
                    stack.push(ErrorEval.VALUE_INVALID);
                    chooseFuncOffset = attrPtg.getChooseFuncOffset();
                    i = chooseFuncOffset + 4;
                    countTokensToBeSkipped = countTokensToBeSkipped(ptgArr, i2, i - ((length2 * 2) + 2));
                } else {
                    if (attrPtg.isOptimizedIf()) {
                        try {
                            if (!IfFunc.evaluateFirstArg((ValueEval) stack.pop(), operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) {
                                i2 += countTokensToBeSkipped(ptgArr, i2, attrPtg.getData());
                                int i4 = i2 + 1;
                                Ptg ptg2 = ptgArr[i4];
                                if ((ptgArr[i2] instanceof AttrPtg) && (ptg2 instanceof FuncVarPtg) && ((FuncVarPtg) ptg2).getFunctionIndex() == 1) {
                                    stack.push(BoolEval.FALSE);
                                    i2 = i4;
                                }
                            }
                        } catch (EvaluationException e2) {
                            stack.push(e2.getErrorEval());
                            i2 += countTokensToBeSkipped(ptgArr, i2, attrPtg.getData());
                            countTokensToBeSkipped = countTokensToBeSkipped(ptgArr, i2, ((AttrPtg) ptgArr[i2]).getData() + 1);
                        }
                    } else if (attrPtg.isSkip()) {
                        i2 += countTokensToBeSkipped(ptgArr, i2, attrPtg.getData() + 1);
                        if (stack.peek() == MissingArgEval.instance) {
                            stack.pop();
                            stack.push(BlankEval.instance);
                        }
                    }
                    i2++;
                }
                i2 += countTokensToBeSkipped;
                i2++;
            }
            if (!(ptg instanceof ControlPtg) && !(ptg instanceof MemFuncPtg) && !(ptg instanceof MemAreaPtg) && !(ptg instanceof MemErrPtg)) {
                if (ptg instanceof OperationPtg) {
                    OperationPtg operationPtg = (OperationPtg) ptg;
                    if (operationPtg instanceof UnionPtg) {
                        continue;
                    } else {
                        int numberOfOperands = operationPtg.getNumberOfOperands();
                        ValueEval[] valueEvalArr = new ValueEval[numberOfOperands];
                        for (int i5 = numberOfOperands - 1; i5 >= 0; i5--) {
                            valueEvalArr[i5] = (ValueEval) stack.pop();
                        }
                        evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg, valueEvalArr, operationEvaluationContext);
                    }
                } else {
                    evalForPtg = getEvalForPtg(ptg, operationEvaluationContext);
                }
                if (evalForPtg == null) {
                    throw new RuntimeException("Evaluation result must not be null");
                }
                stack.push(evalForPtg);
                if (this.dbgEvaluationOutputIndent > 0) {
                    this.EVAL_LOG.log(3, str + "    = " + evalForPtg);
                }
            }
            i2++;
        }
        ValueEval valueEval2 = (ValueEval) stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("evaluation stack not empty");
        }
        ValueEval dereferenceResult = dereferenceResult(valueEval2, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        if (this.dbgEvaluationOutputIndent > 0) {
            this.EVAL_LOG.log(3, str + "finshed eval of " + new CellReference(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()).formatAsString() + ": " + dereferenceResult);
            int i6 = this.dbgEvaluationOutputIndent - 1;
            this.dbgEvaluationOutputIndent = i6;
            if (i6 == 1) {
                this.dbgEvaluationOutputIndent = -1;
            }
        }
        return dereferenceResult;
    }

    private static int countTokensToBeSkipped(Ptg[] ptgArr, int i, int i2) {
        int i3 = i;
        while (i2 != 0) {
            i3++;
            i2 -= ptgArr[i3].getSize();
            if (i2 < 0) {
                throw new RuntimeException("Bad skip distance (wrong token size calculation).");
            }
            if (i3 >= ptgArr.length) {
                throw new RuntimeException("Skip distance too far (ran out of formula tokens).");
            }
        }
        return i3 - i;
    }

    public static ValueEval dereferenceResult(ValueEval valueEval, int i, int i2) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            return singleValue == BlankEval.instance ? NumberEval.ZERO : singleValue;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private ValueEval getEvalForPtg(Ptg ptg, OperationEvaluationContext operationEvaluationContext) {
        if (ptg instanceof NamePtg) {
            return getEvalForNameRecord(this._workbook.getName((NamePtg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof NameXPtg) {
            return processNameEval(operationEvaluationContext.getNameXEval((NameXPtg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof NameXPxg) {
            return processNameEval(operationEvaluationContext.getNameXEval((NameXPxg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof IntPtg) {
            return new NumberEval(((IntPtg) ptg).getValue());
        }
        if (ptg instanceof NumberPtg) {
            return new NumberEval(((NumberPtg) ptg).getValue());
        }
        if (ptg instanceof StringPtg) {
            return new StringEval(((StringPtg) ptg).getValue());
        }
        if (ptg instanceof BoolPtg) {
            return BoolEval.valueOf(((BoolPtg) ptg).getValue());
        }
        if (ptg instanceof ErrPtg) {
            return ErrorEval.valueOf(((ErrPtg) ptg).getErrorCode());
        }
        if (ptg instanceof MissingArgPtg) {
            return MissingArgEval.instance;
        }
        if ((ptg instanceof AreaErrPtg) || (ptg instanceof RefErrorPtg) || (ptg instanceof DeletedArea3DPtg) || (ptg instanceof DeletedRef3DPtg)) {
            return ErrorEval.REF_INVALID;
        }
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
        if (ptg instanceof RefPtg) {
            RefPtg refPtg = (RefPtg) ptg;
            return operationEvaluationContext.getRefEval(refPtg.getRow(), refPtg.getColumn());
        }
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return operationEvaluationContext.getAreaEval(areaPtg.getFirstRow(), areaPtg.getFirstColumn(), areaPtg.getLastRow(), areaPtg.getLastColumn());
        }
        if (ptg instanceof UnknownPtg) {
            throw new RuntimeException("UnknownPtg not allowed");
        }
        if (ptg instanceof ExpPtg) {
            throw new RuntimeException("ExpPtg currently not supported");
        }
        throw new RuntimeException("Unexpected ptg class (" + ptg.getClass().getName() + ")");
    }

    private ValueEval processNameEval(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) {
        return valueEval instanceof ExternalNameEval ? getEvalForNameRecord(((ExternalNameEval) valueEval).getName(), operationEvaluationContext) : valueEval;
    }

    private ValueEval getEvalForNameRecord(EvaluationName evaluationName, OperationEvaluationContext operationEvaluationContext) {
        if (evaluationName.isFunctionName()) {
            return new FunctionNameEval(evaluationName.getNameText());
        }
        if (evaluationName.hasFormula()) {
            return evaluateNameFormula(evaluationName.getNameDefinition(), operationEvaluationContext);
        }
        throw new RuntimeException("Don't now how to evalate name '" + evaluationName.getNameText() + "'");
    }

    ValueEval evaluateNameFormula(Ptg[] ptgArr, OperationEvaluationContext operationEvaluationContext) {
        if (ptgArr.length == 1) {
            return getEvalForPtg(ptgArr[0], operationEvaluationContext);
        }
        return evaluateFormula(operationEvaluationContext, ptgArr);
    }

    ValueEval evaluateReference(EvaluationSheet evaluationSheet, int i, int i2, int i3, EvaluationTracker evaluationTracker) {
        return evaluateAny(evaluationSheet.getCell(i2, i3), i, i2, i3, evaluationTracker);
    }

    public FreeRefFunction findUserDefinedFunction(String str) {
        return this._udfFinder.findFunction(str);
    }

    public void setIgnoreMissingWorkbooks(boolean z) {
        this._ignoreMissingWorkbooks = z;
    }

    public static Collection<String> getSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(FunctionEval.getSupportedFunctionNames());
        treeSet.addAll(AnalysisToolPak.getSupportedFunctionNames());
        return treeSet;
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(FunctionEval.getNotSupportedFunctionNames());
        treeSet.addAll(AnalysisToolPak.getNotSupportedFunctionNames());
        return treeSet;
    }

    public static void registerFunction(String str, FreeRefFunction freeRefFunction) {
        AnalysisToolPak.registerFunction(str, freeRefFunction);
    }

    public static void registerFunction(String str, Function function) {
        FunctionEval.registerFunction(str, function);
    }

    public void setDebugEvaluationOutputForNextEval(boolean z) {
        this.dbgEvaluationOutputForNextEval = z;
    }
}
