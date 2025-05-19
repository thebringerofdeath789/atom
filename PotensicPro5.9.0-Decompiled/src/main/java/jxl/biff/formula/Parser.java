package jxl.biff.formula;

/* loaded from: classes4.dex */
interface Parser {
    void adjustRelativeCellReferences(int i, int i2);

    void columnInserted(int i, int i2, boolean z);

    void columnRemoved(int i, int i2, boolean z);

    byte[] getBytes();

    String getFormula();

    void parse() throws FormulaException;

    void rowInserted(int i, int i2, boolean z);

    void rowRemoved(int i, int i2, boolean z);
}
