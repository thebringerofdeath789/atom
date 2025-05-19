package org.apache.poi.ss.formula.ptg;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public abstract class Ptg {
    public static final byte CLASS_ARRAY = 64;
    public static final byte CLASS_REF = 0;
    public static final byte CLASS_VALUE = 32;
    public static final Ptg[] EMPTY_PTG_ARRAY = new Ptg[0];
    private byte ptgClass = 0;

    public abstract byte getDefaultOperandClass();

    public abstract int getSize();

    public abstract boolean isBaseToken();

    public abstract String toFormulaString();

    public abstract void write(LittleEndianOutput littleEndianOutput);

    public static Ptg[] readTokens(int i, LittleEndianInput littleEndianInput) {
        ArrayList arrayList = new ArrayList((i / 2) + 4);
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            Ptg createPtg = createPtg(littleEndianInput);
            if (createPtg instanceof ArrayPtg.Initial) {
                z = true;
            }
            i2 += createPtg.getSize();
            arrayList.add(createPtg);
        }
        if (i2 != i) {
            throw new RuntimeException("Ptg array size mismatch");
        }
        if (z) {
            Ptg[] ptgArray = toPtgArray(arrayList);
            for (int i3 = 0; i3 < ptgArray.length; i3++) {
                if (ptgArray[i3] instanceof ArrayPtg.Initial) {
                    ptgArray[i3] = ((ArrayPtg.Initial) ptgArray[i3]).finishReading(littleEndianInput);
                }
            }
            return ptgArray;
        }
        return toPtgArray(arrayList);
    }

    public static Ptg createPtg(LittleEndianInput littleEndianInput) {
        byte readByte = littleEndianInput.readByte();
        if (readByte < 32) {
            return createBasePtg(readByte, littleEndianInput);
        }
        Ptg createClassifiedPtg = createClassifiedPtg(readByte, littleEndianInput);
        if (readByte >= 96) {
            createClassifiedPtg.setClass((byte) 64);
        } else if (readByte >= 64) {
            createClassifiedPtg.setClass((byte) 32);
        } else {
            createClassifiedPtg.setClass((byte) 0);
        }
        return createClassifiedPtg;
    }

    private static Ptg createClassifiedPtg(byte b, LittleEndianInput littleEndianInput) {
        int i = (b & 31) | 32;
        switch (i) {
            case 32:
                return new ArrayPtg.Initial(littleEndianInput);
            case 33:
                return FuncPtg.create(littleEndianInput);
            case 34:
                return FuncVarPtg.create(littleEndianInput);
            case 35:
                return new NamePtg(littleEndianInput);
            case 36:
                return new RefPtg(littleEndianInput);
            case 37:
                return new AreaPtg(littleEndianInput);
            case 38:
                return new MemAreaPtg(littleEndianInput);
            case 39:
                return new MemErrPtg(littleEndianInput);
            default:
                switch (i) {
                    case 41:
                        return new MemFuncPtg(littleEndianInput);
                    case 42:
                        return new RefErrorPtg(littleEndianInput);
                    case 43:
                        return new AreaErrPtg(littleEndianInput);
                    case 44:
                        return new RefNPtg(littleEndianInput);
                    case 45:
                        return new AreaNPtg(littleEndianInput);
                    default:
                        switch (i) {
                            case 57:
                                return new NameXPtg(littleEndianInput);
                            case 58:
                                return new Ref3DPtg(littleEndianInput);
                            case 59:
                                return new Area3DPtg(littleEndianInput);
                            case 60:
                                return new DeletedRef3DPtg(littleEndianInput);
                            case 61:
                                return new DeletedArea3DPtg(littleEndianInput);
                            default:
                                throw new UnsupportedOperationException(" Unknown Ptg in Formula: 0x" + Integer.toHexString(b) + " (" + ((int) b) + ")");
                        }
                }
        }
    }

    private static Ptg createBasePtg(byte b, LittleEndianInput littleEndianInput) {
        switch (b) {
            case 0:
                return new UnknownPtg(b);
            case 1:
                return new ExpPtg(littleEndianInput);
            case 2:
                return new TblPtg(littleEndianInput);
            case 3:
                return AddPtg.instance;
            case 4:
                return SubtractPtg.instance;
            case 5:
                return MultiplyPtg.instance;
            case 6:
                return DividePtg.instance;
            case 7:
                return PowerPtg.instance;
            case 8:
                return ConcatPtg.instance;
            case 9:
                return LessThanPtg.instance;
            case 10:
                return LessEqualPtg.instance;
            case 11:
                return EqualPtg.instance;
            case 12:
                return GreaterEqualPtg.instance;
            case 13:
                return GreaterThanPtg.instance;
            case 14:
                return NotEqualPtg.instance;
            case 15:
                return IntersectionPtg.instance;
            case 16:
                return UnionPtg.instance;
            case 17:
                return RangePtg.instance;
            case 18:
                return UnaryPlusPtg.instance;
            case 19:
                return UnaryMinusPtg.instance;
            case 20:
                return PercentPtg.instance;
            case 21:
                return ParenthesisPtg.instance;
            case 22:
                return MissingArgPtg.instance;
            case 23:
                return new StringPtg(littleEndianInput);
            case 24:
            case 26:
            case 27:
            default:
                throw new RuntimeException("Unexpected base token id (" + ((int) b) + ")");
            case 25:
                return new AttrPtg(littleEndianInput);
            case 28:
                return ErrPtg.read(littleEndianInput);
            case 29:
                return BoolPtg.read(littleEndianInput);
            case 30:
                return new IntPtg(littleEndianInput);
            case 31:
                return new NumberPtg(littleEndianInput);
        }
    }

    private static Ptg[] toPtgArray(List<Ptg> list) {
        if (list.isEmpty()) {
            return EMPTY_PTG_ARRAY;
        }
        Ptg[] ptgArr = new Ptg[list.size()];
        list.toArray(ptgArr);
        return ptgArr;
    }

    public static int getEncodedSize(Ptg[] ptgArr) {
        int i = 0;
        for (Ptg ptg : ptgArr) {
            i += ptg.getSize();
        }
        return i;
    }

    public static int getEncodedSizeWithoutArrayData(Ptg[] ptgArr) {
        int i = 0;
        for (Ptg ptg : ptgArr) {
            i = ptg instanceof ArrayPtg ? i + 8 : i + ptg.getSize();
        }
        return i;
    }

    public static int serializePtgs(Ptg[] ptgArr, byte[] bArr, int i) {
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i);
        ArrayList arrayList = null;
        for (Ptg ptg : ptgArr) {
            ptg.write(littleEndianByteArrayOutputStream);
            if (ptg instanceof ArrayPtg) {
                if (arrayList == null) {
                    arrayList = new ArrayList(5);
                }
                arrayList.add(ptg);
            }
        }
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((ArrayPtg) arrayList.get(i2)).writeTokenValueBytes(littleEndianByteArrayOutputStream);
            }
        }
        return littleEndianByteArrayOutputStream.getWriteIndex() - i;
    }

    public String toString() {
        return getClass().toString();
    }

    public final void setClass(byte b) {
        if (isBaseToken()) {
            throw new RuntimeException("setClass should not be called on a base token");
        }
        this.ptgClass = b;
    }

    public final byte getPtgClass() {
        return this.ptgClass;
    }

    public final char getRVAType() {
        if (isBaseToken()) {
            return '.';
        }
        byte b = this.ptgClass;
        if (b == 0) {
            return 'R';
        }
        if (b == 32) {
            return 'V';
        }
        if (b == 64) {
            return 'A';
        }
        throw new RuntimeException("Unknown operand class (" + ((int) this.ptgClass) + ")");
    }

    public static boolean doesFormulaReferToDeletedCell(Ptg[] ptgArr) {
        for (Ptg ptg : ptgArr) {
            if (isDeletedCellRef(ptg)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDeletedCellRef(Ptg ptg) {
        return ptg == ErrPtg.REF_INVALID || (ptg instanceof DeletedArea3DPtg) || (ptg instanceof DeletedRef3DPtg) || (ptg instanceof AreaErrPtg) || (ptg instanceof RefErrorPtg);
    }
}
