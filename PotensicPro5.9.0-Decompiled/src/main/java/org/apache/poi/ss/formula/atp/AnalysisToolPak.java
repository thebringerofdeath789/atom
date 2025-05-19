package org.apache.poi.ss.formula.atp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.functions.Bin2Dec;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.formula.functions.Countifs;
import org.apache.poi.ss.formula.functions.Dec2Bin;
import org.apache.poi.ss.formula.functions.Dec2Hex;
import org.apache.poi.ss.formula.functions.Delta;
import org.apache.poi.ss.formula.functions.EDate;
import org.apache.poi.ss.formula.functions.EOMonth;
import org.apache.poi.ss.formula.functions.FactDouble;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Hex2Dec;
import org.apache.poi.ss.formula.functions.ImReal;
import org.apache.poi.ss.formula.functions.Imaginary;
import org.apache.poi.ss.formula.functions.Oct2Dec;
import org.apache.poi.ss.formula.functions.Quotient;
import org.apache.poi.ss.formula.functions.Sumifs;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.apache.poi.ss.formula.udf.UDFFinder;

/* loaded from: classes5.dex */
public final class AnalysisToolPak implements UDFFinder {
    public static final UDFFinder instance = new AnalysisToolPak();
    private final Map<String, FreeRefFunction> _functionsByName = createFunctionsMap();

    private static final class NotImplemented implements FreeRefFunction {
        private final String _functionName;

        public NotImplemented(String str) {
            this._functionName = str;
        }

        @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
        public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
            throw new NotImplementedFunctionException(this._functionName);
        }
    }

    private AnalysisToolPak() {
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        if (str.startsWith("_xlfn.")) {
            str = str.substring(6);
        }
        return this._functionsByName.get(str.toUpperCase());
    }

    private Map<String, FreeRefFunction> createFunctionsMap() {
        HashMap hashMap = new HashMap(108);
        r(hashMap, "ACCRINT", null);
        r(hashMap, "ACCRINTM", null);
        r(hashMap, "AMORDEGRC", null);
        r(hashMap, "AMORLINC", null);
        r(hashMap, "AVERAGEIF", null);
        r(hashMap, "AVERAGEIFS", null);
        r(hashMap, "BAHTTEXT", null);
        r(hashMap, "BESSELI", null);
        r(hashMap, "BESSELJ", null);
        r(hashMap, "BESSELK", null);
        r(hashMap, "BESSELY", null);
        r(hashMap, "BIN2DEC", Bin2Dec.instance);
        r(hashMap, "BIN2HEX", null);
        r(hashMap, "BIN2OCT", null);
        r(hashMap, "COMPLEX", Complex.instance);
        r(hashMap, "CONVERT", null);
        r(hashMap, "COUNTIFS", null);
        r(hashMap, "COUPDAYBS", null);
        r(hashMap, "COUPDAYS", null);
        r(hashMap, "COUPDAYSNC", null);
        r(hashMap, "COUPNCD", null);
        r(hashMap, "COUPNUM", null);
        r(hashMap, "COUPPCD", null);
        r(hashMap, "CUBEKPIMEMBER", null);
        r(hashMap, "CUBEMEMBER", null);
        r(hashMap, "CUBEMEMBERPROPERTY", null);
        r(hashMap, "CUBERANKEDMEMBER", null);
        r(hashMap, "CUBESET", null);
        r(hashMap, "CUBESETCOUNT", null);
        r(hashMap, "CUBEVALUE", null);
        r(hashMap, "CUMIPMT", null);
        r(hashMap, "CUMPRINC", null);
        r(hashMap, "DEC2BIN", Dec2Bin.instance);
        r(hashMap, "DEC2HEX", Dec2Hex.instance);
        r(hashMap, "DEC2OCT", null);
        r(hashMap, "DELTA", Delta.instance);
        r(hashMap, "DISC", null);
        r(hashMap, "DOLLARDE", null);
        r(hashMap, "DOLLARFR", null);
        r(hashMap, "DURATION", null);
        r(hashMap, "EDATE", EDate.instance);
        r(hashMap, "EFFECT", null);
        r(hashMap, "EOMONTH", EOMonth.instance);
        r(hashMap, "ERF", null);
        r(hashMap, "ERFC", null);
        r(hashMap, "FACTDOUBLE", FactDouble.instance);
        r(hashMap, "FVSCHEDULE", null);
        r(hashMap, "GCD", null);
        r(hashMap, "GESTEP", null);
        r(hashMap, "HEX2BIN", null);
        r(hashMap, "HEX2DEC", Hex2Dec.instance);
        r(hashMap, "HEX2OCT", null);
        r(hashMap, "IFERROR", IfError.instance);
        r(hashMap, "IMABS", null);
        r(hashMap, "IMAGINARY", Imaginary.instance);
        r(hashMap, "IMARGUMENT", null);
        r(hashMap, "IMCONJUGATE", null);
        r(hashMap, "IMCOS", null);
        r(hashMap, "IMDIV", null);
        r(hashMap, "IMEXP", null);
        r(hashMap, "IMLN", null);
        r(hashMap, "IMLOG10", null);
        r(hashMap, "IMLOG2", null);
        r(hashMap, "IMPOWER", null);
        r(hashMap, "IMPRODUCT", null);
        r(hashMap, "IMREAL", ImReal.instance);
        r(hashMap, "IMSIN", null);
        r(hashMap, "IMSQRT", null);
        r(hashMap, "IMSUB", null);
        r(hashMap, "IMSUM", null);
        r(hashMap, "INTRATE", null);
        r(hashMap, "ISEVEN", ParityFunction.IS_EVEN);
        r(hashMap, "ISODD", ParityFunction.IS_ODD);
        r(hashMap, "JIS", null);
        r(hashMap, "LCM", null);
        r(hashMap, "MDURATION", null);
        r(hashMap, "MROUND", MRound.instance);
        r(hashMap, "MULTINOMIAL", null);
        r(hashMap, "NETWORKDAYS", NetworkdaysFunction.instance);
        r(hashMap, "NOMINAL", null);
        r(hashMap, "OCT2BIN", null);
        r(hashMap, "OCT2DEC", Oct2Dec.instance);
        r(hashMap, "OCT2HEX", null);
        r(hashMap, "ODDFPRICE", null);
        r(hashMap, "ODDFYIELD", null);
        r(hashMap, "ODDLPRICE", null);
        r(hashMap, "ODDLYIELD", null);
        r(hashMap, "PRICE", null);
        r(hashMap, "PRICEDISC", null);
        r(hashMap, "PRICEMAT", null);
        r(hashMap, "QUOTIENT", Quotient.instance);
        r(hashMap, "RANDBETWEEN", RandBetween.instance);
        r(hashMap, "RECEIVED", null);
        r(hashMap, "RTD", null);
        r(hashMap, "SERIESSUM", null);
        r(hashMap, "SQRTPI", null);
        r(hashMap, "SUMIFS", Sumifs.instance);
        r(hashMap, "TBILLEQ", null);
        r(hashMap, "TBILLPRICE", null);
        r(hashMap, "TBILLYIELD", null);
        r(hashMap, "WEEKNUM", WeekNum.instance);
        r(hashMap, "WORKDAY", WorkdayFunction.instance);
        r(hashMap, "XIRR", null);
        r(hashMap, "XNPV", null);
        r(hashMap, "YEARFRAC", YearFrac.instance);
        r(hashMap, "YIELD", null);
        r(hashMap, "YIELDDISC", null);
        r(hashMap, "YIELDMAT", null);
        r(hashMap, "COUNTIFS", Countifs.instance);
        return hashMap;
    }

    private static void r(Map<String, FreeRefFunction> map, String str, FreeRefFunction freeRefFunction) {
        if (freeRefFunction == null) {
            freeRefFunction = new NotImplemented(str);
        }
        map.put(str, freeRefFunction);
    }

    public static boolean isATPFunction(String str) {
        return ((AnalysisToolPak) instance)._functionsByName.containsKey(str);
    }

    public static Collection<String> getSupportedFunctionNames() {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        TreeSet treeSet = new TreeSet();
        for (String str : analysisToolPak._functionsByName.keySet()) {
            FreeRefFunction freeRefFunction = analysisToolPak._functionsByName.get(str);
            if (freeRefFunction != null && !(freeRefFunction instanceof NotImplemented)) {
                treeSet.add(str);
            }
        }
        return Collections.unmodifiableCollection(treeSet);
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        TreeSet treeSet = new TreeSet();
        for (String str : analysisToolPak._functionsByName.keySet()) {
            FreeRefFunction freeRefFunction = analysisToolPak._functionsByName.get(str);
            if (freeRefFunction != null && (freeRefFunction instanceof NotImplemented)) {
                treeSet.add(str);
            }
        }
        return Collections.unmodifiableCollection(treeSet);
    }

    public static void registerFunction(String str, FreeRefFunction freeRefFunction) {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        if (!isATPFunction(str)) {
            if (FunctionMetadataRegistry.getFunctionByName(str) != null) {
                throw new IllegalArgumentException(str + " is a built-in Excel function. Use FunctoinEval.registerFunction(String name, Function func) instead.");
            }
            throw new IllegalArgumentException(str + " is not a function from the Excel Analysis Toolpack.");
        }
        FreeRefFunction findFunction = analysisToolPak.findFunction(str);
        if (findFunction != null && !(findFunction instanceof NotImplemented)) {
            throw new IllegalArgumentException("POI already implememts " + str + ". You cannot override POI's implementations of Excel functions");
        }
        analysisToolPak._functionsByName.put(str, freeRefFunction);
    }
}
