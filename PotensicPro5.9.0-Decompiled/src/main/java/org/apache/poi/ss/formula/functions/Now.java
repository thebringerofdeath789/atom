package org.apache.poi.ss.formula.functions;

import java.util.Date;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public final class Now extends Fixed0ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        return new NumberEval(DateUtil.getExcelDate(new Date(System.currentTimeMillis())));
    }
}
