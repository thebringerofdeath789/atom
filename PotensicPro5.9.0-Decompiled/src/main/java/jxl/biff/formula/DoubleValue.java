package jxl.biff.formula;

import common.Logger;
import jxl.biff.DoubleHelper;

/* loaded from: classes4.dex */
class DoubleValue extends NumberValue implements ParsedThing {
    static /* synthetic */ Class class$jxl$biff$formula$DoubleValue;
    private static Logger logger;
    private double value;

    static {
        Class cls = class$jxl$biff$formula$DoubleValue;
        if (cls == null) {
            cls = class$("jxl.biff.formula.DoubleValue");
            class$jxl$biff$formula$DoubleValue = cls;
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

    public DoubleValue() {
    }

    DoubleValue(double d) {
        this.value = d;
    }

    public DoubleValue(String str) {
        try {
            this.value = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            logger.warn(e, e);
            this.value = 0.0d;
        }
    }

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        this.value = DoubleHelper.getIEEEDouble(bArr, i);
        return 8;
    }

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        byte[] bArr = new byte[9];
        bArr[0] = Token.DOUBLE.getCode();
        DoubleHelper.getIEEEBytes(this.value, bArr, 1);
        return bArr;
    }

    @Override // jxl.biff.formula.NumberValue
    public double getValue() {
        return this.value;
    }
}
