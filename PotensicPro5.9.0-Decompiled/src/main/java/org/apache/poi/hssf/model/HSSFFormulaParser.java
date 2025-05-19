package org.apache.poi.hssf.model;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.ptg.Ptg;

/* loaded from: classes4.dex */
public final class HSSFFormulaParser {
    private static FormulaParsingWorkbook createParsingWorkbook(HSSFWorkbook hSSFWorkbook) {
        return HSSFEvaluationWorkbook.create(hSSFWorkbook);
    }

    private HSSFFormulaParser() {
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook) throws FormulaParseException {
        return parse(str, hSSFWorkbook, 0);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, int i) throws FormulaParseException {
        return parse(str, hSSFWorkbook, i, -1);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, int i, int i2) throws FormulaParseException {
        return FormulaParser.parse(str, createParsingWorkbook(hSSFWorkbook), i, i2);
    }

    public static String toFormulaString(HSSFWorkbook hSSFWorkbook, Ptg[] ptgArr) {
        return FormulaRenderer.toFormulaString(HSSFEvaluationWorkbook.create(hSSFWorkbook), ptgArr);
    }
}
