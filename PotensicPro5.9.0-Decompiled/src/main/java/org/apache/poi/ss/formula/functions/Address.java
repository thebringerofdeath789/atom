package org.apache.poi.ss.formula.functions;

/* loaded from: classes5.dex */
public class Address implements Function {
    public static final int REF_ABSOLUTE = 1;
    public static final int REF_RELATIVE = 4;
    public static final int REF_ROW_ABSOLUTE_COLUMN_RELATIVE = 2;
    public static final int REF_ROW_RELATIVE_RELATIVE_ABSOLUTE = 3;

    /* JADX WARN: Removed duplicated region for block: B:33:0x0081 A[Catch: EvaluationException -> 0x009a, TryCatch #0 {EvaluationException -> 0x009a, blocks: (B:7:0x000b, B:9:0x001d, B:11:0x0023, B:19:0x0048, B:21:0x004b, B:24:0x0056, B:25:0x005d, B:27:0x0061, B:30:0x006c, B:31:0x0071, B:33:0x0081, B:34:0x0089, B:37:0x0038, B:38:0x003f), top: B:6:0x000b }] */
    @Override // org.apache.poi.ss.formula.functions.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.poi.ss.formula.eval.ValueEval evaluate(org.apache.poi.ss.formula.eval.ValueEval[] r11, int r12, int r13) {
        /*
            r10 = this;
            int r0 = r11.length
            r1 = 2
            if (r0 < r1) goto La0
            int r0 = r11.length
            r2 = 5
            if (r0 <= r2) goto La
            goto La0
        La:
            r0 = 0
            r3 = r11[r0]     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            double r3 = org.apache.poi.ss.formula.functions.NumericFunction.singleOperandEvaluate(r3, r12, r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            int r3 = (int) r3     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r4 = 1
            r5 = r11[r4]     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            double r5 = org.apache.poi.ss.formula.functions.NumericFunction.singleOperandEvaluate(r5, r12, r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            int r5 = (int) r5     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            int r6 = r11.length     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            if (r6 <= r1) goto L2b
            r6 = r11[r1]     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.MissingArgEval r7 = org.apache.poi.ss.formula.eval.MissingArgEval.instance     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            if (r6 == r7) goto L2b
            r6 = r11[r1]     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            double r6 = org.apache.poi.ss.formula.functions.NumericFunction.singleOperandEvaluate(r6, r12, r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            int r6 = (int) r6     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            goto L2c
        L2b:
            r6 = r4
        L2c:
            r7 = 4
            r8 = 3
            if (r6 == r4) goto L46
            if (r6 == r1) goto L43
            if (r6 == r8) goto L40
            if (r6 != r7) goto L38
            r1 = r0
            goto L47
        L38:
            org.apache.poi.ss.formula.eval.EvaluationException r11 = new org.apache.poi.ss.formula.eval.EvaluationException     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.ErrorEval r12 = org.apache.poi.ss.formula.eval.ErrorEval.VALUE_INVALID     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r11.<init>(r12)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            throw r11     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
        L40:
            r1 = r0
            r6 = r4
            goto L48
        L43:
            r6 = r0
            r1 = r4
            goto L48
        L46:
            r1 = r4
        L47:
            r6 = r1
        L48:
            int r9 = r11.length     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            if (r9 <= r8) goto L5d
            r8 = r11[r8]     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.ValueEval r8 = org.apache.poi.ss.formula.eval.OperandResolver.getSingleValue(r8, r12, r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.MissingArgEval r9 = org.apache.poi.ss.formula.eval.MissingArgEval.instance     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            if (r8 != r9) goto L56
            goto L5d
        L56:
            java.lang.Boolean r0 = org.apache.poi.ss.formula.eval.OperandResolver.coerceValueToBoolean(r8, r0)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r0.booleanValue()     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
        L5d:
            int r0 = r11.length     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r8 = 0
            if (r0 != r2) goto L71
            r11 = r11[r7]     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.ValueEval r11 = org.apache.poi.ss.formula.eval.OperandResolver.getSingleValue(r11, r12, r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.MissingArgEval r12 = org.apache.poi.ss.formula.eval.MissingArgEval.instance     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            if (r11 != r12) goto L6c
            goto L71
        L6c:
            java.lang.String r11 = org.apache.poi.ss.formula.eval.OperandResolver.coerceValueToString(r11)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r8 = r11
        L71:
            org.apache.poi.ss.util.CellReference r11 = new org.apache.poi.ss.util.CellReference     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            int r3 = r3 - r4
            int r5 = r5 - r4
            r11.<init>(r3, r5, r1, r6)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            java.lang.StringBuffer r12 = new java.lang.StringBuffer     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r13 = 32
            r12.<init>(r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            if (r8 == 0) goto L89
            org.apache.poi.ss.formula.SheetNameFormatter.appendFormat(r12, r8)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r13 = 33
            r12.append(r13)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
        L89:
            java.lang.String r11 = r11.formatAsString()     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r12.append(r11)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            org.apache.poi.ss.formula.eval.StringEval r11 = new org.apache.poi.ss.formula.eval.StringEval     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            java.lang.String r12 = r12.toString()     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            r11.<init>(r12)     // Catch: org.apache.poi.ss.formula.eval.EvaluationException -> L9a
            return r11
        L9a:
            r11 = move-exception
            org.apache.poi.ss.formula.eval.ErrorEval r11 = r11.getErrorEval()
            return r11
        La0:
            org.apache.poi.ss.formula.eval.ErrorEval r11 = org.apache.poi.ss.formula.eval.ErrorEval.VALUE_INVALID
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.functions.Address.evaluate(org.apache.poi.ss.formula.eval.ValueEval[], int, int):org.apache.poi.ss.formula.eval.ValueEval");
    }
}
