package org.apache.poi.ss.formula.functions;

import org.apache.commons.net.nntp.NNTPReply;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes5.dex */
public class Roman extends Fixed2ArgFunction {
    public static final int[] VALUES = {1000, IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR, 500, NNTPReply.SERVICE_DISCONTINUED, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            int coerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
            if (coerceValueToInt < 0) {
                return ErrorEval.VALUE_INVALID;
            }
            if (coerceValueToInt > 3999) {
                return ErrorEval.VALUE_INVALID;
            }
            if (coerceValueToInt == 0) {
                return new StringEval("");
            }
            try {
                int coerceValueToInt2 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i, i2));
                if (coerceValueToInt2 > 4 || coerceValueToInt2 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                String integerToRoman = integerToRoman(coerceValueToInt);
                if (coerceValueToInt2 == 0) {
                    return new StringEval(integerToRoman);
                }
                return new StringEval(makeConcise(integerToRoman, coerceValueToInt2));
            } catch (EvaluationException unused) {
                return ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    private String integerToRoman(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 13; i2++) {
            while (true) {
                int[] iArr = VALUES;
                if (i >= iArr[i2]) {
                    i -= iArr[i2];
                    sb.append(ROMAN[i2]);
                }
            }
        }
        return sb.toString();
    }

    public String makeConcise(String str, int i) {
        if (i > 0) {
            str = str.replaceAll("XLV", "VL").replaceAll("XCV", "VC").replaceAll("CDL", "LD").replaceAll("CML", "LM").replaceAll("CMVC", "LMVL");
        }
        if (i == 1) {
            str = str.replaceAll("CDXC", "LDXL").replaceAll("CDVC", "LDVL").replaceAll("CMXC", "LMXL").replaceAll("XCIX", "VCIV").replaceAll("XLIX", "VLIV");
        }
        if (i > 1) {
            str = str.replaceAll("XLIX", "IL").replaceAll("XCIX", "IC").replaceAll("CDXC", "XD").replaceAll("CDVC", "XDV").replaceAll("CDIC", "XDIX").replaceAll("LMVL", "XMV").replaceAll("CMIC", "XMIX").replaceAll("CMXC", "XM");
        }
        if (i > 2) {
            str = str.replaceAll("XDV", "VD").replaceAll("XDIX", "VDIV").replaceAll("XMV", "VM").replaceAll("XMIX", "VMIV");
        }
        return i == 4 ? str.replaceAll("VDIV", "ID").replaceAll("VMIV", "IM") : str;
    }
}
