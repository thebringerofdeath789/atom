package org.apache.poi.ss.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum FormulaError {
    NULL(0, "#NULL!"),
    DIV0(7, "#DIV/0!"),
    VALUE(15, "#VALUE!"),
    REF(23, "#REF!"),
    NAME(29, "#NAME?"),
    NUM(36, "#NUM!"),
    NA(42, "#N/A"),
    CIRCULAR_REF(-60, "~CIRCULAR~REF~"),
    FUNCTION_NOT_IMPLEMENTED(-30, "~FUNCTION~NOT~IMPLEMENTED~");

    private final int longType;
    private final String repr;
    private final byte type;
    private static Map<String, FormulaError> smap = new HashMap();
    private static Map<Byte, FormulaError> bmap = new HashMap();
    private static Map<Integer, FormulaError> imap = new HashMap();

    static {
        for (FormulaError formulaError : values()) {
            bmap.put(Byte.valueOf(formulaError.getCode()), formulaError);
            imap.put(Integer.valueOf(formulaError.getLongCode()), formulaError);
            smap.put(formulaError.getString(), formulaError);
        }
    }

    FormulaError(int i, String str) {
        this.type = (byte) i;
        this.longType = i;
        this.repr = str;
    }

    public byte getCode() {
        return this.type;
    }

    public int getLongCode() {
        return this.longType;
    }

    public String getString() {
        return this.repr;
    }

    public static final boolean isValidCode(int i) {
        for (FormulaError formulaError : values()) {
            if (formulaError.getCode() == i || formulaError.getLongCode() == i) {
                return true;
            }
        }
        return false;
    }

    public static FormulaError forInt(byte b) {
        FormulaError formulaError = bmap.get(Byte.valueOf(b));
        if (formulaError != null) {
            return formulaError;
        }
        throw new IllegalArgumentException("Unknown error type: " + ((int) b));
    }

    public static FormulaError forInt(int i) {
        FormulaError formulaError = imap.get(Integer.valueOf(i));
        if (formulaError == null) {
            formulaError = bmap.get(Byte.valueOf((byte) i));
        }
        if (formulaError != null) {
            return formulaError;
        }
        throw new IllegalArgumentException("Unknown error type: " + i);
    }

    public static FormulaError forString(String str) {
        FormulaError formulaError = smap.get(str);
        if (formulaError != null) {
            return formulaError;
        }
        throw new IllegalArgumentException("Unknown error code: " + str);
    }
}
