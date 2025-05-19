package jxl.biff.formula;

import java.util.Stack;
import jxl.biff.IntegerHelper;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
class MemFunc extends Operand implements ParsedThing {
    private int length;
    private ParseItem[] subExpression;

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        return null;
    }

    public void getOperands(Stack stack) {
    }

    int getPrecedence() {
        return 5;
    }

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        this.length = IntegerHelper.getInt(bArr[i], bArr[i + 1]);
        return 2;
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        ParseItem[] parseItemArr = this.subExpression;
        if (parseItemArr.length == 1) {
            parseItemArr[0].getString(stringBuffer);
        } else if (parseItemArr.length == 2) {
            parseItemArr[1].getString(stringBuffer);
            stringBuffer.append(NameUtil.COLON);
            this.subExpression[0].getString(stringBuffer);
        }
    }

    public int getLength() {
        return this.length;
    }

    public void setSubExpression(ParseItem[] parseItemArr) {
        this.subExpression = parseItemArr;
    }
}
