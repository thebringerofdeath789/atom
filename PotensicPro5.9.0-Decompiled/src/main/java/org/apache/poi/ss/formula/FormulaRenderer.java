package org.apache.poi.ss.formula;

import java.util.Stack;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* loaded from: classes5.dex */
public class FormulaRenderer {
    /* JADX WARN: Multi-variable type inference failed */
    public static String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook, Ptg[] ptgArr) {
        if (ptgArr == 0 || ptgArr.length == 0) {
            throw new IllegalArgumentException("ptgs must not be null");
        }
        Stack stack = new Stack();
        for (AbstractFunctionPtg abstractFunctionPtg : ptgArr) {
            if (!(abstractFunctionPtg instanceof MemAreaPtg) && !(abstractFunctionPtg instanceof MemFuncPtg) && !(abstractFunctionPtg instanceof MemErrPtg)) {
                if (abstractFunctionPtg instanceof ParenthesisPtg) {
                    stack.push("(" + ((String) stack.pop()) + ")");
                } else if (abstractFunctionPtg instanceof AttrPtg) {
                    AttrPtg attrPtg = (AttrPtg) abstractFunctionPtg;
                    if (!attrPtg.isOptimizedIf() && !attrPtg.isOptimizedChoose() && !attrPtg.isSkip() && !attrPtg.isSpace() && !attrPtg.isSemiVolatile()) {
                        if (attrPtg.isSum()) {
                            stack.push(attrPtg.toFormulaString(getOperands(stack, attrPtg.getNumberOfOperands())));
                        } else {
                            throw new RuntimeException("Unexpected tAttr: " + attrPtg.toString());
                        }
                    }
                } else if (abstractFunctionPtg instanceof WorkbookDependentFormula) {
                    stack.push(((WorkbookDependentFormula) abstractFunctionPtg).toFormulaString(formulaRenderingWorkbook));
                } else if (!(abstractFunctionPtg instanceof OperationPtg)) {
                    stack.push(abstractFunctionPtg.toFormulaString());
                } else {
                    AbstractFunctionPtg abstractFunctionPtg2 = abstractFunctionPtg;
                    stack.push(abstractFunctionPtg2.toFormulaString(getOperands(stack, abstractFunctionPtg2.getNumberOfOperands())));
                }
            }
        }
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        String str = (String) stack.pop();
        if (stack.isEmpty()) {
            return str;
        }
        throw new IllegalStateException("too much stuff left on the stack");
    }

    private static String[] getOperands(Stack<String> stack, int i) {
        String[] strArr = new String[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Too few arguments supplied to operation. Expected (" + i + ") operands but got (" + ((i - i2) - 1) + ")");
            }
            strArr[i2] = stack.pop();
        }
        return strArr;
    }
}
