package org.apache.poi.ss.formula.functions;

import java.util.regex.Pattern;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DataFormatter;

/* loaded from: classes5.dex */
public abstract class TextFunction implements Function {
    protected static final String EMPTY_STRING = "";
    protected static final DataFormatter formatter = new DataFormatter();
    public static final Function CHAR = new Fixed1ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.1
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            try {
                int evaluateIntArg = TextFunction.evaluateIntArg(valueEval, i, i2);
                if (evaluateIntArg < 0 || evaluateIntArg >= 256) {
                    throw new EvaluationException(ErrorEval.VALUE_INVALID);
                }
                return new StringEval(String.valueOf((char) evaluateIntArg));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function LEN = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.2
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        protected ValueEval evaluate(String str) {
            return new NumberEval(str.length());
        }
    };
    public static final Function LOWER = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.3
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        protected ValueEval evaluate(String str) {
            return new StringEval(str.toLowerCase());
        }
    };
    public static final Function UPPER = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.4
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        protected ValueEval evaluate(String str) {
            return new StringEval(str.toUpperCase());
        }
    };
    public static final Function PROPER = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.5
        final Pattern nonAlphabeticPattern = Pattern.compile("\\P{L}");

        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        protected ValueEval evaluate(String str) {
            StringBuilder sb = new StringBuilder();
            String lowerCase = str.toLowerCase();
            String upperCase = str.toUpperCase();
            boolean z = true;
            int i = 0;
            while (i < str.length()) {
                if (z) {
                    sb.append(upperCase.charAt(i));
                } else {
                    sb.append(lowerCase.charAt(i));
                }
                int i2 = i + 1;
                z = this.nonAlphabeticPattern.matcher(str.subSequence(i, i2)).matches();
                i = i2;
            }
            return new StringEval(sb.toString());
        }
    };
    public static final Function TRIM = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.6
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        protected ValueEval evaluate(String str) {
            return new StringEval(str.trim());
        }
    };
    public static final Function CLEAN = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.7
        private boolean isPrintable(char c) {
            return c >= ' ';
        }

        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        protected ValueEval evaluate(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (isPrintable(charAt)) {
                    sb.append(charAt);
                }
            }
            return new StringEval(sb.toString());
        }
    };
    public static final Function MID = new Fixed3ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.8
        @Override // org.apache.poi.ss.formula.functions.Function3Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
            try {
                String evaluateStringArg = TextFunction.evaluateStringArg(valueEval, i, i2);
                int evaluateIntArg = TextFunction.evaluateIntArg(valueEval2, i, i2);
                int evaluateIntArg2 = TextFunction.evaluateIntArg(valueEval3, i, i2);
                int i3 = evaluateIntArg - 1;
                if (i3 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                if (evaluateIntArg2 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                int length = evaluateStringArg.length();
                if (evaluateIntArg2 < 0 || i3 > length) {
                    return new StringEval("");
                }
                return new StringEval(evaluateStringArg.substring(i3, Math.min(evaluateIntArg2 + i3, length)));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function LEFT = new LeftRight(true);
    public static final Function RIGHT = new LeftRight(false);
    public static final Function CONCATENATE = new Function() { // from class: org.apache.poi.ss.formula.functions.TextFunction.9
        @Override // org.apache.poi.ss.formula.functions.Function
        public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            for (ValueEval valueEval : valueEvalArr) {
                try {
                    sb.append(TextFunction.evaluateStringArg(valueEval, i, i2));
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            }
            return new StringEval(sb.toString());
        }
    };
    public static final Function EXACT = new Fixed2ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.10
        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                return BoolEval.valueOf(TextFunction.evaluateStringArg(valueEval, i, i2).equals(TextFunction.evaluateStringArg(valueEval2, i, i2)));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function TEXT = new Fixed2ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.11
        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                try {
                    return new StringEval(TextFunction.formatter.formatRawCellContents(TextFunction.evaluateDoubleArg(valueEval, i, i2), -1, TextFunction.evaluateStringArg(valueEval2, i, i2)));
                } catch (Exception unused) {
                    return ErrorEval.VALUE_INVALID;
                }
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function FIND = new SearchFind(true);
    public static final Function SEARCH = new SearchFind(false);

    protected abstract ValueEval evaluateFunc(ValueEval[] valueEvalArr, int i, int i2) throws EvaluationException;

    protected static final String evaluateStringArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2));
    }

    protected static final int evaluateIntArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
    }

    protected static final double evaluateDoubleArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        try {
            return evaluateFunc(valueEvalArr, i, i2);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static abstract class SingleArgTextFunc extends Fixed1ArgFunction {
        protected abstract ValueEval evaluate(String str);

        protected SingleArgTextFunc() {
        }

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            try {
                return evaluate(TextFunction.evaluateStringArg(valueEval, i, i2));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    }

    private static final class LeftRight extends Var1or2ArgFunction {
        private static final ValueEval DEFAULT_ARG1 = new NumberEval(1.0d);
        private final boolean _isLeft;

        protected LeftRight(boolean z) {
            this._isLeft = z;
        }

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            return evaluate(i, i2, valueEval, DEFAULT_ARG1);
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            String substring;
            try {
                String evaluateStringArg = TextFunction.evaluateStringArg(valueEval, i, i2);
                int evaluateIntArg = TextFunction.evaluateIntArg(valueEval2, i, i2);
                if (evaluateIntArg < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                if (this._isLeft) {
                    substring = evaluateStringArg.substring(0, Math.min(evaluateStringArg.length(), evaluateIntArg));
                } else {
                    substring = evaluateStringArg.substring(Math.max(0, evaluateStringArg.length() - evaluateIntArg));
                }
                return new StringEval(substring);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    }

    private static final class SearchFind extends Var2or3ArgFunction {
        private final boolean _isCaseSensitive;

        public SearchFind(boolean z) {
            this._isCaseSensitive = z;
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
            try {
                return eval(TextFunction.evaluateStringArg(valueEval2, i, i2), TextFunction.evaluateStringArg(valueEval, i, i2), 0);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }

        @Override // org.apache.poi.ss.formula.functions.Function3Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
            try {
                String evaluateStringArg = TextFunction.evaluateStringArg(valueEval, i, i2);
                String evaluateStringArg2 = TextFunction.evaluateStringArg(valueEval2, i, i2);
                int evaluateIntArg = TextFunction.evaluateIntArg(valueEval3, i, i2) - 1;
                if (evaluateIntArg < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                return eval(evaluateStringArg2, evaluateStringArg, evaluateIntArg);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }

        private ValueEval eval(String str, String str2, int i) {
            int indexOf;
            if (this._isCaseSensitive) {
                indexOf = str.indexOf(str2, i);
            } else {
                indexOf = str.toUpperCase().indexOf(str2.toUpperCase(), i);
            }
            if (indexOf == -1) {
                return ErrorEval.VALUE_INVALID;
            }
            return new NumberEval(indexOf + 1);
        }
    }
}
