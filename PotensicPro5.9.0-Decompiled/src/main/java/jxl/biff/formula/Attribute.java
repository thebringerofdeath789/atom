package jxl.biff.formula;

import common.Logger;
import java.util.Stack;
import jxl.WorkbookSettings;
import jxl.biff.IntegerHelper;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
class Attribute extends Operator implements ParsedThing {
    private static final int GOTO_MASK = 8;
    private static final int IF_MASK = 2;
    private static final int SUM_MASK = 16;
    static /* synthetic */ Class class$jxl$biff$formula$Attribute;
    private static Logger logger;
    private VariableArgFunction ifConditions;
    private int options;
    private WorkbookSettings settings;
    private int word;

    @Override // jxl.biff.formula.Operator
    int getPrecedence() {
        return 3;
    }

    static {
        Class cls = class$jxl$biff$formula$Attribute;
        if (cls == null) {
            cls = class$("jxl.biff.formula.Attribute");
            class$jxl$biff$formula$Attribute = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public Attribute(WorkbookSettings workbookSettings) {
        this.settings = workbookSettings;
    }

    public Attribute(StringFunction stringFunction, WorkbookSettings workbookSettings) {
        this.settings = workbookSettings;
        if (stringFunction.getFunction(workbookSettings) == Function.SUM) {
            this.options |= 16;
        } else if (stringFunction.getFunction(this.settings) == Function.IF) {
            this.options |= 2;
        }
    }

    void setIfConditions(VariableArgFunction variableArgFunction) {
        this.ifConditions = variableArgFunction;
        this.options |= 2;
    }

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        this.options = bArr[i];
        this.word = IntegerHelper.getInt(bArr[i + 1], bArr[i + 2]);
        return 3;
    }

    public boolean isFunction() {
        return (this.options & 18) != 0;
    }

    public boolean isSum() {
        return (this.options & 16) != 0;
    }

    public boolean isIf() {
        return (this.options & 2) != 0;
    }

    public boolean isGoto() {
        return (this.options & 8) != 0;
    }

    @Override // jxl.biff.formula.Operator
    public void getOperands(Stack stack) {
        int i = this.options;
        if ((i & 16) != 0) {
            add((ParseItem) stack.pop());
        } else if ((i & 2) != 0) {
            add((ParseItem) stack.pop());
        }
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        int i = this.options;
        if ((i & 16) != 0) {
            ParseItem[] operands = getOperands();
            stringBuffer.append(Function.SUM.getName(this.settings));
            stringBuffer.append(PropertyUtils.MAPPED_DELIM);
            operands[0].getString(stringBuffer);
            stringBuffer.append(PropertyUtils.MAPPED_DELIM2);
            return;
        }
        if ((i & 2) != 0) {
            stringBuffer.append(Function.IF.getName(this.settings));
            stringBuffer.append(PropertyUtils.MAPPED_DELIM);
            ParseItem[] operands2 = this.ifConditions.getOperands();
            for (int i2 = 0; i2 < operands2.length - 1; i2++) {
                operands2[i2].getString(stringBuffer);
                stringBuffer.append(',');
            }
            operands2[operands2.length - 1].getString(stringBuffer);
            stringBuffer.append(PropertyUtils.MAPPED_DELIM2);
        }
    }

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        byte[] bArr = new byte[0];
        if (!isSum()) {
            return isIf() ? getIf() : bArr;
        }
        ParseItem[] operands = getOperands();
        int length = operands.length - 1;
        while (length >= 0) {
            byte[] bytes = operands[length].getBytes();
            byte[] bArr2 = new byte[bArr.length + bytes.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
            length--;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 4];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = Token.ATTRIBUTE.getCode();
        bArr3[bArr.length + 1] = 16;
        return bArr3;
    }

    private byte[] getIf() {
        ParseItem[] operands = this.ifConditions.getOperands();
        int length = operands.length;
        byte[] bytes = operands[0].getBytes();
        int length2 = bytes.length;
        int length3 = bytes.length + 4;
        byte[] bArr = new byte[length3];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        bArr[length2] = Token.ATTRIBUTE.getCode();
        bArr[length2 + 1] = 2;
        int i = length2 + 2;
        byte[] bytes2 = operands[1].getBytes();
        int length4 = bytes2.length + length3;
        byte[] bArr2 = new byte[length4];
        System.arraycopy(bArr, 0, bArr2, 0, length3);
        System.arraycopy(bytes2, 0, bArr2, length3, bytes2.length);
        int i2 = length4 + 4;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, length4);
        bArr3[length4] = Token.ATTRIBUTE.getCode();
        bArr3[length4 + 1] = 8;
        int i3 = length4 + 2;
        if (length > 2) {
            IntegerHelper.getTwoBytes((i2 - i) - 2, bArr3, i);
            byte[] bytes3 = operands[length - 1].getBytes();
            int length5 = bytes3.length + i2;
            byte[] bArr4 = new byte[length5];
            System.arraycopy(bArr3, 0, bArr4, 0, i2);
            System.arraycopy(bytes3, 0, bArr4, i2, bytes3.length);
            bArr3 = new byte[length5 + 4];
            System.arraycopy(bArr4, 0, bArr3, 0, length5);
            bArr3[length5] = Token.ATTRIBUTE.getCode();
            bArr3[length5 + 1] = 8;
            bArr3[length5 + 2] = 3;
        }
        int length6 = bArr3.length;
        int length7 = bArr3.length + 4;
        byte[] bArr5 = new byte[length7];
        System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        bArr5[length6] = Token.FUNCTIONVARARG.getCode();
        bArr5[length6 + 1] = (byte) length;
        bArr5[length6 + 2] = 1;
        bArr5[length6 + 3] = 0;
        int i4 = length7 - 1;
        if (length < 3) {
            IntegerHelper.getTwoBytes((i4 - i) - 5, bArr5, i);
        }
        IntegerHelper.getTwoBytes((i4 - i3) - 2, bArr5, i3);
        return bArr5;
    }

    @Override // jxl.biff.formula.ParseItem
    public void adjustRelativeCellReferences(int i, int i2) {
        ParseItem[] operands;
        if (isIf()) {
            operands = this.ifConditions.getOperands();
        } else {
            operands = getOperands();
        }
        for (ParseItem parseItem : operands) {
            parseItem.adjustRelativeCellReferences(i, i2);
        }
    }

    @Override // jxl.biff.formula.ParseItem
    void columnInserted(int i, int i2, boolean z) {
        ParseItem[] operands;
        if (isIf()) {
            operands = this.ifConditions.getOperands();
        } else {
            operands = getOperands();
        }
        for (ParseItem parseItem : operands) {
            parseItem.columnInserted(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.ParseItem
    void columnRemoved(int i, int i2, boolean z) {
        ParseItem[] operands;
        if (isIf()) {
            operands = this.ifConditions.getOperands();
        } else {
            operands = getOperands();
        }
        for (ParseItem parseItem : operands) {
            parseItem.columnRemoved(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.ParseItem
    void rowInserted(int i, int i2, boolean z) {
        ParseItem[] operands;
        if (isIf()) {
            operands = this.ifConditions.getOperands();
        } else {
            operands = getOperands();
        }
        for (ParseItem parseItem : operands) {
            parseItem.rowInserted(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.ParseItem
    void rowRemoved(int i, int i2, boolean z) {
        ParseItem[] operands;
        if (isIf()) {
            operands = this.ifConditions.getOperands();
        } else {
            operands = getOperands();
        }
        for (ParseItem parseItem : operands) {
            parseItem.rowRemoved(i, i2, z);
        }
    }
}
