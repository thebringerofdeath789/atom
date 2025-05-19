package org.apache.poi.hssf.record;

import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class BoolErrRecord extends CellRecord {
    public static final short sid = 517;
    private boolean _isError;
    private int _value;

    @Override // org.apache.poi.hssf.record.CellRecord
    protected String getRecordName() {
        return "BOOLERR";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 517;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected int getValueDataSize() {
        return 2;
    }

    public BoolErrRecord() {
    }

    public BoolErrRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        int remaining = recordInputStream.remaining();
        if (remaining == 2) {
            this._value = recordInputStream.readByte();
        } else if (remaining == 3) {
            this._value = recordInputStream.readUShort();
        } else {
            throw new RecordFormatException("Unexpected size (" + recordInputStream.remaining() + ") for BOOLERR record.");
        }
        int readUByte = recordInputStream.readUByte();
        if (readUByte == 0) {
            this._isError = false;
        } else {
            if (readUByte == 1) {
                this._isError = true;
                return;
            }
            throw new RecordFormatException("Unexpected isError flag (" + readUByte + ") for BOOLERR record.");
        }
    }

    public void setValue(boolean z) {
        this._value = z ? 1 : 0;
        this._isError = false;
    }

    public void setValue(byte b) {
        if (b == 0 || b == 7 || b == 15 || b == 23 || b == 29 || b == 36 || b == 42) {
            this._value = b;
            this._isError = true;
            return;
        }
        throw new IllegalArgumentException("Error Value can only be 0,7,15,23,29,36 or 42. It cannot be " + ((int) b));
    }

    public boolean getBooleanValue() {
        return this._value != 0;
    }

    public byte getErrorValue() {
        return (byte) this._value;
    }

    public boolean isBoolean() {
        return !this._isError;
    }

    public boolean isError() {
        return this._isError;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void appendValueText(StringBuilder sb) {
        if (isBoolean()) {
            sb.append("  .boolVal = ");
            sb.append(getBooleanValue());
        } else {
            sb.append("  .errCode = ");
            sb.append(ErrorConstants.getText(getErrorValue()));
            sb.append(" (").append(HexDump.byteToHex(getErrorValue())).append(")");
        }
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._value);
        littleEndianOutput.writeByte(this._isError ? 1 : 0);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        BoolErrRecord boolErrRecord = new BoolErrRecord();
        copyBaseFields(boolErrRecord);
        boolErrRecord._value = this._value;
        boolErrRecord._isError = this._isError;
        return boolErrRecord;
    }
}
