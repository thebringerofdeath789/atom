package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public class ChartTitleFormatRecord extends StandardRecord {
    public static final short sid = 4176;
    private CTFormat[] _formats;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private static final class CTFormat {
        public static final int ENCODED_SIZE = 4;
        private int _fontIndex;
        private int _offset;

        public CTFormat(RecordInputStream recordInputStream) {
            this._offset = recordInputStream.readShort();
            this._fontIndex = recordInputStream.readShort();
        }

        public int getOffset() {
            return this._offset;
        }

        public void setOffset(int i) {
            this._offset = i;
        }

        public int getFontIndex() {
            return this._fontIndex;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._offset);
            littleEndianOutput.writeShort(this._fontIndex);
        }
    }

    public ChartTitleFormatRecord(RecordInputStream recordInputStream) {
        int readUShort = recordInputStream.readUShort();
        this._formats = new CTFormat[readUShort];
        for (int i = 0; i < readUShort; i++) {
            this._formats[i] = new CTFormat(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._formats.length);
        int i = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i >= cTFormatArr.length) {
                return;
            }
            cTFormatArr[i].serialize(littleEndianOutput);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._formats.length * 4) + 2;
    }

    public int getFormatCount() {
        return this._formats.length;
    }

    public void modifyFormatRun(short s, short s2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i >= cTFormatArr.length) {
                return;
            }
            CTFormat cTFormat = cTFormatArr[i];
            if (i2 != 0) {
                cTFormat.setOffset(cTFormat.getOffset() + i2);
            } else if (s == cTFormat.getOffset()) {
                CTFormat[] cTFormatArr2 = this._formats;
                if (i < cTFormatArr2.length - 1) {
                    i2 = s2 - (cTFormatArr2[i + 1].getOffset() - cTFormat.getOffset());
                }
            }
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[CHARTTITLEFORMAT]\n");
        stringBuffer.append("    .format_runs       = ").append(this._formats.length).append("\n");
        int i = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i < cTFormatArr.length) {
                CTFormat cTFormat = cTFormatArr[i];
                stringBuffer.append("       .char_offset= ").append(cTFormat.getOffset());
                stringBuffer.append(",.fontidx= ").append(cTFormat.getFontIndex());
                stringBuffer.append("\n");
                i++;
            } else {
                stringBuffer.append("[/CHARTTITLEFORMAT]\n");
                return stringBuffer.toString();
            }
        }
    }
}
