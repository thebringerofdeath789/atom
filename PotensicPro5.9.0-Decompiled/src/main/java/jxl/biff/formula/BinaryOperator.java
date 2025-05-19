package jxl.biff.formula;

import java.util.Stack;

/* loaded from: classes4.dex */
abstract class BinaryOperator extends Operator implements ParsedThing {
    abstract String getSymbol();

    abstract Token getToken();

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        return 0;
    }

    @Override // jxl.biff.formula.Operator
    public void getOperands(Stack stack) {
        ParseItem parseItem = (ParseItem) stack.pop();
        ParseItem parseItem2 = (ParseItem) stack.pop();
        add(parseItem);
        add(parseItem2);
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        ParseItem[] operands = getOperands();
        operands[1].getString(stringBuffer);
        stringBuffer.append(getSymbol());
        operands[0].getString(stringBuffer);
    }

    @Override // jxl.biff.formula.ParseItem
    public void adjustRelativeCellReferences(int i, int i2) {
        ParseItem[] operands = getOperands();
        operands[1].adjustRelativeCellReferences(i, i2);
        operands[0].adjustRelativeCellReferences(i, i2);
    }

    @Override // jxl.biff.formula.ParseItem
    void columnInserted(int i, int i2, boolean z) {
        ParseItem[] operands = getOperands();
        operands[1].columnInserted(i, i2, z);
        operands[0].columnInserted(i, i2, z);
    }

    @Override // jxl.biff.formula.ParseItem
    void columnRemoved(int i, int i2, boolean z) {
        ParseItem[] operands = getOperands();
        operands[1].columnRemoved(i, i2, z);
        operands[0].columnRemoved(i, i2, z);
    }

    @Override // jxl.biff.formula.ParseItem
    void rowInserted(int i, int i2, boolean z) {
        ParseItem[] operands = getOperands();
        operands[1].rowInserted(i, i2, z);
        operands[0].rowInserted(i, i2, z);
    }

    @Override // jxl.biff.formula.ParseItem
    void rowRemoved(int i, int i2, boolean z) {
        ParseItem[] operands = getOperands();
        operands[1].rowRemoved(i, i2, z);
        operands[0].rowRemoved(i, i2, z);
    }

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        ParseItem[] operands = getOperands();
        byte[] bArr = new byte[0];
        int length = operands.length - 1;
        while (length >= 0) {
            byte[] bytes = operands[length].getBytes();
            byte[] bArr2 = new byte[bArr.length + bytes.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
            length--;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 1];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = getToken().getCode();
        return bArr3;
    }
}
