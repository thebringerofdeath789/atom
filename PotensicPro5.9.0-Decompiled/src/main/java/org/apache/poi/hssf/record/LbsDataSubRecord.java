package org.apache.poi.hssf.record;

import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public class LbsDataSubRecord extends SubRecord {
    public static final int sid = 19;
    private boolean[] _bsels;
    private int _cLines;
    private int _cbFContinued;
    private LbsDropData _dropData;
    private int _flags;
    private int _iSel;
    private int _idEdit;
    private Ptg _linkPtg;
    private String[] _rgLines;
    private Byte _unknownPostFormulaByte;
    private int _unknownPreFormulaInt;

    @Override // org.apache.poi.hssf.record.SubRecord
    public Object clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public boolean isTerminating() {
        return true;
    }

    public LbsDataSubRecord(LittleEndianInput littleEndianInput, int i, int i2) {
        this._cbFContinued = i;
        int readUShort = littleEndianInput.readUShort();
        if (readUShort > 0) {
            int readUShort2 = littleEndianInput.readUShort();
            this._unknownPreFormulaInt = littleEndianInput.readInt();
            Ptg[] readTokens = Ptg.readTokens(readUShort2, littleEndianInput);
            if (readTokens.length != 1) {
                throw new RecordFormatException("Read " + readTokens.length + " tokens but expected exactly 1");
            }
            this._linkPtg = readTokens[0];
            int i3 = (readUShort - readUShort2) - 6;
            if (i3 == 0) {
                this._unknownPostFormulaByte = null;
            } else if (i3 == 1) {
                this._unknownPostFormulaByte = Byte.valueOf(littleEndianInput.readByte());
            } else {
                throw new RecordFormatException("Unexpected leftover bytes");
            }
        }
        this._cLines = littleEndianInput.readUShort();
        this._iSel = littleEndianInput.readUShort();
        this._flags = littleEndianInput.readUShort();
        this._idEdit = littleEndianInput.readUShort();
        if (i2 == 20) {
            this._dropData = new LbsDropData(littleEndianInput);
        }
        if ((this._flags & 2) != 0) {
            this._rgLines = new String[this._cLines];
            for (int i4 = 0; i4 < this._cLines; i4++) {
                this._rgLines[i4] = StringUtil.readUnicodeString(littleEndianInput);
            }
        }
        if (((this._flags >> 4) & 2) != 0) {
            this._bsels = new boolean[this._cLines];
            for (int i5 = 0; i5 < this._cLines; i5++) {
                this._bsels[i5] = littleEndianInput.readByte() == 1;
            }
        }
    }

    LbsDataSubRecord() {
    }

    public static LbsDataSubRecord newAutoFilterInstance() {
        LbsDataSubRecord lbsDataSubRecord = new LbsDataSubRecord();
        lbsDataSubRecord._cbFContinued = 8174;
        lbsDataSubRecord._iSel = 0;
        lbsDataSubRecord._flags = 769;
        LbsDropData lbsDropData = new LbsDropData();
        lbsDataSubRecord._dropData = lbsDropData;
        lbsDropData._wStyle = 2;
        lbsDataSubRecord._dropData._cLine = 8;
        return lbsDataSubRecord;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        int i;
        Ptg ptg = this._linkPtg;
        if (ptg != null) {
            i = ptg.getSize() + 8;
            if (this._unknownPostFormulaByte != null) {
                i++;
            }
        } else {
            i = 2;
        }
        int i2 = i + 8;
        LbsDropData lbsDropData = this._dropData;
        if (lbsDropData != null) {
            i2 += lbsDropData.getDataSize();
        }
        String[] strArr = this._rgLines;
        if (strArr != null) {
            for (String str : strArr) {
                i2 += StringUtil.getEncodedSize(str);
            }
        }
        boolean[] zArr = this._bsels;
        return zArr != null ? i2 + zArr.length : i2;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(19);
        littleEndianOutput.writeShort(this._cbFContinued);
        Ptg ptg = this._linkPtg;
        if (ptg == null) {
            littleEndianOutput.writeShort(0);
        } else {
            int size = ptg.getSize();
            int i = size + 6;
            if (this._unknownPostFormulaByte != null) {
                i++;
            }
            littleEndianOutput.writeShort(i);
            littleEndianOutput.writeShort(size);
            littleEndianOutput.writeInt(this._unknownPreFormulaInt);
            this._linkPtg.write(littleEndianOutput);
            Byte b = this._unknownPostFormulaByte;
            if (b != null) {
                littleEndianOutput.writeByte(b.intValue());
            }
        }
        littleEndianOutput.writeShort(this._cLines);
        littleEndianOutput.writeShort(this._iSel);
        littleEndianOutput.writeShort(this._flags);
        littleEndianOutput.writeShort(this._idEdit);
        LbsDropData lbsDropData = this._dropData;
        if (lbsDropData != null) {
            lbsDropData.serialize(littleEndianOutput);
        }
        String[] strArr = this._rgLines;
        if (strArr != null) {
            for (String str : strArr) {
                StringUtil.writeUnicodeString(littleEndianOutput, str);
            }
        }
        boolean[] zArr = this._bsels;
        if (zArr != null) {
            for (boolean z : zArr) {
                littleEndianOutput.writeByte(z ? 1 : 0);
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("[ftLbsData]\n");
        stringBuffer.append("    .unknownShort1 =").append(HexDump.shortToHex(this._cbFContinued)).append("\n");
        stringBuffer.append("    .formula        = ").append('\n');
        Ptg ptg = this._linkPtg;
        if (ptg != null) {
            stringBuffer.append(ptg.toString()).append(this._linkPtg.getRVAType()).append('\n');
        }
        stringBuffer.append("    .nEntryCount   =").append(HexDump.shortToHex(this._cLines)).append("\n");
        stringBuffer.append("    .selEntryIx    =").append(HexDump.shortToHex(this._iSel)).append("\n");
        stringBuffer.append("    .style         =").append(HexDump.shortToHex(this._flags)).append("\n");
        stringBuffer.append("    .unknownShort10=").append(HexDump.shortToHex(this._idEdit)).append("\n");
        if (this._dropData != null) {
            stringBuffer.append('\n').append(this._dropData.toString());
        }
        stringBuffer.append("[/ftLbsData]\n");
        return stringBuffer.toString();
    }

    public Ptg getFormula() {
        return this._linkPtg;
    }

    public int getNumberOfItems() {
        return this._cLines;
    }

    public static class LbsDropData {
        public static final int STYLE_COMBO_DROPDOWN = 0;
        public static final int STYLE_COMBO_EDIT_DROPDOWN = 1;
        public static final int STYLE_COMBO_SIMPLE_DROPDOWN = 2;
        private int _cLine;
        private int _dxMin;
        private String _str;
        private Byte _unused;
        private int _wStyle;

        public LbsDropData() {
            this._str = "";
            this._unused = (byte) 0;
        }

        public LbsDropData(LittleEndianInput littleEndianInput) {
            this._wStyle = littleEndianInput.readUShort();
            this._cLine = littleEndianInput.readUShort();
            this._dxMin = littleEndianInput.readUShort();
            String readUnicodeString = StringUtil.readUnicodeString(littleEndianInput);
            this._str = readUnicodeString;
            if (StringUtil.getEncodedSize(readUnicodeString) % 2 != 0) {
                this._unused = Byte.valueOf(littleEndianInput.readByte());
            }
        }

        public void setStyle(int i) {
            this._wStyle = i;
        }

        public void setNumLines(int i) {
            this._cLine = i;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._wStyle);
            littleEndianOutput.writeShort(this._cLine);
            littleEndianOutput.writeShort(this._dxMin);
            StringUtil.writeUnicodeString(littleEndianOutput, this._str);
            Byte b = this._unused;
            if (b != null) {
                littleEndianOutput.writeByte(b.byteValue());
            }
        }

        public int getDataSize() {
            int encodedSize = StringUtil.getEncodedSize(this._str) + 6;
            return this._unused != null ? encodedSize + 1 : encodedSize;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[LbsDropData]\n");
            stringBuffer.append("  ._wStyle:  ").append(this._wStyle).append('\n');
            stringBuffer.append("  ._cLine:  ").append(this._cLine).append('\n');
            stringBuffer.append("  ._dxMin:  ").append(this._dxMin).append('\n');
            stringBuffer.append("  ._str:  ").append(this._str).append('\n');
            if (this._unused != null) {
                stringBuffer.append("  ._unused:  ").append(this._unused).append('\n');
            }
            stringBuffer.append("[/LbsDropData]\n");
            return stringBuffer.toString();
        }
    }
}
