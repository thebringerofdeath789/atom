package org.apache.poi.ss.formula.functions;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Bin2Dec extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new Bin2Dec();

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        String coerceValueToString;
        String substring;
        boolean startsWith;
        String str;
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            coerceValueToString = OperandResolver.coerceValueToString(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
        } else {
            coerceValueToString = OperandResolver.coerceValueToString(valueEval);
        }
        if (coerceValueToString.length() > 10) {
            return ErrorEval.NUM_ERROR;
        }
        if (coerceValueToString.length() < 10) {
            substring = coerceValueToString;
            startsWith = true;
        } else {
            substring = coerceValueToString.substring(1);
            startsWith = coerceValueToString.startsWith(SessionDescription.SUPPORTED_SDP_VERSION);
        }
        try {
            if (startsWith) {
                str = String.valueOf(getDecimalValue(substring));
            } else {
                str = "-" + String.valueOf(getDecimalValue(toggleBits(substring)) + 1);
            }
            return new NumberEval(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return ErrorEval.NUM_ERROR;
        }
    }

    private int getDecimalValue(String str) {
        int length = str.length();
        int i = length - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += (int) (Integer.parseInt(str.substring(i3, r4)) * Math.pow(2.0d, i));
            i--;
        }
        return i2;
    }

    private static String toggleBits(String str) {
        String binaryString = Long.toBinaryString(Long.parseLong(str, 2) ^ ((1 << str.length()) - 1));
        while (binaryString.length() < str.length()) {
            binaryString = '0' + binaryString;
        }
        return binaryString;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}
