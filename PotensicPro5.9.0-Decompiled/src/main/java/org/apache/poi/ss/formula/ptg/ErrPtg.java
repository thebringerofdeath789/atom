package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ErrPtg extends ScalarConstantPtg {
    private static final ErrorConstants EC = null;
    private static final int SIZE = 2;
    public static final short sid = 28;
    private final int field_1_error_code;
    public static final ErrPtg NULL_INTERSECTION = new ErrPtg(0);
    public static final ErrPtg DIV_ZERO = new ErrPtg(7);
    public static final ErrPtg VALUE_INVALID = new ErrPtg(15);
    public static final ErrPtg REF_INVALID = new ErrPtg(23);
    public static final ErrPtg NAME_INVALID = new ErrPtg(29);
    public static final ErrPtg NUM_ERROR = new ErrPtg(36);
    public static final ErrPtg N_A = new ErrPtg(42);

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 2;
    }

    private ErrPtg(int i) {
        if (!ErrorConstants.isValidCode(i)) {
            throw new IllegalArgumentException("Invalid error code (" + i + ")");
        }
        this.field_1_error_code = i;
    }

    public static ErrPtg read(LittleEndianInput littleEndianInput) {
        return valueOf(littleEndianInput.readByte());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 28);
        littleEndianOutput.writeByte(this.field_1_error_code);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return ErrorConstants.getText(this.field_1_error_code);
    }

    public int getErrorCode() {
        return this.field_1_error_code;
    }

    public static ErrPtg valueOf(int i) {
        if (i == 0) {
            return NULL_INTERSECTION;
        }
        if (i == 7) {
            return DIV_ZERO;
        }
        if (i == 15) {
            return VALUE_INVALID;
        }
        if (i == 23) {
            return REF_INVALID;
        }
        if (i == 29) {
            return NAME_INVALID;
        }
        if (i == 36) {
            return NUM_ERROR;
        }
        if (i == 42) {
            return N_A;
        }
        throw new RuntimeException("Unexpected error code (" + i + ")");
    }
}
