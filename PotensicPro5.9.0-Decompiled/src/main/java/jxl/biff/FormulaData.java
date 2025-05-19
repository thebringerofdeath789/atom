package jxl.biff;

import jxl.Cell;
import jxl.biff.formula.FormulaException;

/* loaded from: classes4.dex */
public interface FormulaData extends Cell {
    byte[] getFormulaData() throws FormulaException;
}
