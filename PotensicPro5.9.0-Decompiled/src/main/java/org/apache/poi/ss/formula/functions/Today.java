package org.apache.poi.ss.formula.functions;

import java.util.GregorianCalendar;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
public final class Today extends Fixed0ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), 0, 0, 0);
        gregorianCalendar.set(14, 0);
        return new NumberEval(DateUtil.getExcelDate(gregorianCalendar.getTime()));
    }
}
