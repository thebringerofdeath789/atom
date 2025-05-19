package org.apache.poi.ss.util;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class CellRangeAddress extends CellRangeAddressBase {
    public static final int ENCODED_SIZE = 8;

    public static int getEncodedSize(int i) {
        return i * 8;
    }

    public CellRangeAddress(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        if (i2 < i || i4 < i3) {
            throw new IllegalArgumentException("lastRow < firstRow || lastCol < firstCol");
        }
    }

    @Deprecated
    public int serialize(int i, byte[] bArr) {
        serialize(new LittleEndianByteArrayOutputStream(bArr, i, 8));
        return 8;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFirstRow());
        littleEndianOutput.writeShort(getLastRow());
        littleEndianOutput.writeShort(getFirstColumn());
        littleEndianOutput.writeShort(getLastColumn());
    }

    public CellRangeAddress(RecordInputStream recordInputStream) {
        super(readUShortAndCheck(recordInputStream), recordInputStream.readUShort(), recordInputStream.readUShort(), recordInputStream.readUShort());
    }

    private static int readUShortAndCheck(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() < 8) {
            throw new RuntimeException("Ran out of data reading CellRangeAddress");
        }
        return recordInputStream.readUShort();
    }

    public CellRangeAddress copy() {
        return new CellRangeAddress(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());
    }

    public String formatAsString() {
        return formatAsString(null, false);
    }

    public String formatAsString(String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(SheetNameFormatter.format(str));
            stringBuffer.append("!");
        }
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn(), z, z);
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn(), z, z);
        stringBuffer.append(cellReference.formatAsString());
        if (!cellReference.equals(cellReference2) || isFullColumnRange() || isFullRowRange()) {
            stringBuffer.append(NameUtil.COLON);
            stringBuffer.append(cellReference2.formatAsString());
        }
        return stringBuffer.toString();
    }

    public static CellRangeAddress valueOf(String str) {
        CellReference cellReference;
        CellReference cellReference2;
        int indexOf = str.indexOf(":");
        if (indexOf == -1) {
            cellReference2 = new CellReference(str);
            cellReference = cellReference2;
        } else {
            CellReference cellReference3 = new CellReference(str.substring(0, indexOf));
            cellReference = new CellReference(str.substring(indexOf + 1));
            cellReference2 = cellReference3;
        }
        return new CellRangeAddress(cellReference2.getRow(), cellReference.getRow(), cellReference2.getCol(), cellReference.getCol());
    }
}
