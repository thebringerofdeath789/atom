package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberComparer;

/* loaded from: classes5.dex */
public final class DStarRunner implements Function3Arg {
    private IDStarAlgorithm algorithm;

    private enum operator {
        largerThan,
        largerEqualThan,
        smallerThan,
        smallerEqualThan,
        equal
    }

    public DStarRunner(IDStarAlgorithm iDStarAlgorithm) {
        this.algorithm = iDStarAlgorithm;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length == 3) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        if (!(valueEval instanceof TwoDEval) || !(valueEval3 instanceof TwoDEval)) {
            return ErrorEval.VALUE_INVALID;
        }
        TwoDEval twoDEval = (TwoDEval) valueEval;
        TwoDEval twoDEval2 = (TwoDEval) valueEval3;
        try {
            int columnForName = getColumnForName(valueEval2, twoDEval);
            if (columnForName == -1) {
                return ErrorEval.VALUE_INVALID;
            }
            this.algorithm.reset();
            for (int i3 = 1; i3 < twoDEval.getHeight(); i3++) {
                try {
                    if (fullfillsConditions(twoDEval, i3, twoDEval2)) {
                        try {
                            if (!this.algorithm.processMatch(solveReference(twoDEval.getValue(i3, columnForName)))) {
                                break;
                            }
                        } catch (EvaluationException e) {
                            return e.getErrorEval();
                        }
                    }
                } catch (EvaluationException unused) {
                    return ErrorEval.VALUE_INVALID;
                }
            }
            return this.algorithm.getResult();
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    private static ValueEval solveReference(ValueEval valueEval) throws EvaluationException {
        if (!(valueEval instanceof RefEval)) {
            return valueEval;
        }
        RefEval refEval = (RefEval) valueEval;
        if (refEval.getNumberOfSheets() > 1) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        return solveReference(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
    }

    private static int getColumnForTag(ValueEval valueEval, TwoDEval twoDEval) throws EvaluationException {
        if (valueEval instanceof NumericValueEval) {
            double numberValue = ((NumericValueEval) valueEval).getNumberValue();
            int i = (int) numberValue;
            if (numberValue - i == 0.0d) {
                return i - 1;
            }
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        return getColumnForName(valueEval, twoDEval);
    }

    private static int getColumnForName(ValueEval valueEval, TwoDEval twoDEval) throws EvaluationException {
        return getColumnForString(twoDEval, getStringFromValueEval(valueEval));
    }

    private static int getColumnForString(TwoDEval twoDEval, String str) throws EvaluationException {
        for (int i = 0; i < twoDEval.getWidth(); i++) {
            if (str.equals(getStringFromValueEval(twoDEval.getValue(0, i)))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r3 != true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean fullfillsConditions(org.apache.poi.ss.formula.TwoDEval r9, int r10, org.apache.poi.ss.formula.TwoDEval r11) throws org.apache.poi.ss.formula.eval.EvaluationException {
        /*
            r0 = 1
            r1 = r0
        L2:
            int r2 = r11.getHeight()
            r3 = 0
            if (r1 >= r2) goto L62
            r2 = r3
        La:
            int r4 = r11.getWidth()
            if (r2 >= r4) goto L5b
            r4 = 0
            org.apache.poi.ss.formula.eval.ValueEval r5 = r11.getValue(r1, r2)     // Catch: java.lang.RuntimeException -> L1b
            org.apache.poi.ss.formula.eval.ValueEval r4 = solveReference(r5)     // Catch: java.lang.RuntimeException -> L1b
            r5 = r0
            goto L1c
        L1b:
            r5 = r3
        L1c:
            boolean r6 = r4 instanceof org.apache.poi.ss.formula.eval.BlankEval
            if (r6 == 0) goto L21
            goto L50
        L21:
            org.apache.poi.ss.formula.eval.ValueEval r6 = r11.getValue(r3, r2)
            org.apache.poi.ss.formula.eval.ValueEval r6 = solveReference(r6)
            org.apache.poi.ss.formula.eval.ValueEval r6 = solveReference(r6)
            boolean r7 = r6 instanceof org.apache.poi.ss.formula.eval.StringValueEval
            if (r7 != 0) goto L33
        L31:
            r5 = r3
            goto L3b
        L33:
            int r7 = getColumnForName(r6, r9)
            r8 = -1
            if (r7 != r8) goto L3b
            goto L31
        L3b:
            if (r5 != r0) goto L53
            int r5 = getColumnForName(r6, r9)
            org.apache.poi.ss.formula.eval.ValueEval r5 = r9.getValue(r10, r5)
            java.lang.String r4 = getStringFromValueEval(r4)
            boolean r4 = testNormalCondition(r5, r4)
            if (r4 != 0) goto L50
            goto L5c
        L50:
            int r2 = r2 + 1
            goto La
        L53:
            org.apache.poi.ss.formula.eval.NotImplementedException r9 = new org.apache.poi.ss.formula.eval.NotImplementedException
            java.lang.String r10 = "D* function with formula conditions"
            r9.<init>(r10)
            throw r9
        L5b:
            r3 = r0
        L5c:
            if (r3 != r0) goto L5f
            return r0
        L5f:
            int r1 = r1 + 1
            goto L2
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.functions.DStarRunner.fullfillsConditions(org.apache.poi.ss.formula.TwoDEval, int, org.apache.poi.ss.formula.TwoDEval):boolean");
    }

    private static boolean testNormalCondition(ValueEval valueEval, String str) throws EvaluationException {
        boolean z = true;
        if (str.startsWith("<")) {
            String substring = str.substring(1);
            if (substring.startsWith("=")) {
                return testNumericCondition(valueEval, operator.smallerEqualThan, substring.substring(1));
            }
            return testNumericCondition(valueEval, operator.smallerThan, substring);
        }
        if (str.startsWith(">")) {
            String substring2 = str.substring(1);
            if (substring2.startsWith("=")) {
                return testNumericCondition(valueEval, operator.largerEqualThan, substring2.substring(1));
            }
            return testNumericCondition(valueEval, operator.largerThan, substring2);
        }
        if (str.startsWith("=")) {
            String substring3 = str.substring(1);
            try {
                try {
                    Integer.parseInt(substring3);
                } catch (NumberFormatException unused) {
                    Double.parseDouble(substring3);
                }
            } catch (NumberFormatException unused2) {
                z = false;
            }
            if (z) {
                return testNumericCondition(valueEval, operator.equal, substring3);
            }
            return substring3.equals(getStringFromValueEval(valueEval));
        }
        return getStringFromValueEval(valueEval).startsWith(str);
    }

    private static boolean testNumericCondition(ValueEval valueEval, operator operatorVar, String str) throws EvaluationException {
        double parseDouble;
        if (!(valueEval instanceof NumericValueEval)) {
            return false;
        }
        double numberValue = ((NumericValueEval) valueEval).getNumberValue();
        try {
            try {
                parseDouble = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                parseDouble = Double.parseDouble(str);
            }
            int compare = NumberComparer.compare(numberValue, parseDouble);
            int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operatorVar.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i == 5 && compare == 0 : compare <= 0 : compare < 0 : compare >= 0 : compare > 0;
        } catch (NumberFormatException unused2) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
    }

    /* renamed from: org.apache.poi.ss.formula.functions.DStarRunner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator;

        static {
            int[] iArr = new int[operator.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator = iArr;
            try {
                iArr[operator.largerThan.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.largerEqualThan.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerThan.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerEqualThan.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.equal.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String getStringFromValueEval(ValueEval valueEval) throws EvaluationException {
        ValueEval solveReference = solveReference(valueEval);
        if (solveReference instanceof BlankEval) {
            return "";
        }
        if (!(solveReference instanceof StringValueEval)) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        return ((StringValueEval) solveReference).getStringValue();
    }
}
