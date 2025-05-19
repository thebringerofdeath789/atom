package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class ViewFieldsRecord extends StandardRecord {
    private static final int BASE_SIZE = 10;
    private static final int STRING_NOT_PRESENT_LEN = 65535;
    public static final short sid = 177;
    private int _cItm;
    private int _cSub;
    private int _grbitSub;
    private String _name;
    private int _sxaxis;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 177;
    }

    private static final class Axis {
        public static final int COLUMN = 2;
        public static final int DATA = 8;
        public static final int NO_AXIS = 0;
        public static final int PAGE = 4;
        public static final int ROW = 1;

        private Axis() {
        }
    }

    public ViewFieldsRecord(RecordInputStream recordInputStream) {
        this._sxaxis = recordInputStream.readShort();
        this._cSub = recordInputStream.readShort();
        this._grbitSub = recordInputStream.readShort();
        this._cItm = recordInputStream.readShort();
        int readUShort = recordInputStream.readUShort();
        if (readUShort != 65535) {
            if ((recordInputStream.readByte() & 1) != 0) {
                this._name = recordInputStream.readUnicodeLEString(readUShort);
            } else {
                this._name = recordInputStream.readCompressedUnicode(readUShort);
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._sxaxis);
        littleEndianOutput.writeShort(this._cSub);
        littleEndianOutput.writeShort(this._grbitSub);
        littleEndianOutput.writeShort(this._cItm);
        String str = this._name;
        if (str != null) {
            StringUtil.writeUnicodeString(littleEndianOutput, str);
        } else {
            littleEndianOutput.writeShort(65535);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        String str = this._name;
        if (str == null) {
            return 10;
        }
        return (str.length() * (StringUtil.hasMultibyte(this._name) ? 2 : 1)) + 11;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SXVD]\n");
        stringBuffer.append("    .sxaxis    = ").append(HexDump.shortToHex(this._sxaxis)).append('\n');
        stringBuffer.append("    .cSub      = ").append(HexDump.shortToHex(this._cSub)).append('\n');
        stringBuffer.append("    .grbitSub  = ").append(HexDump.shortToHex(this._grbitSub)).append('\n');
        stringBuffer.append("    .cItm      = ").append(HexDump.shortToHex(this._cItm)).append('\n');
        stringBuffer.append("    .name      = ").append(this._name).append('\n');
        stringBuffer.append("[/SXVD]\n");
        return stringBuffer.toString();
    }
}
