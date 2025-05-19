package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes5.dex */
public abstract class PageBreakRecord extends StandardRecord {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private Map<Integer, Break> _breakMap;
    private List<Break> _breaks;

    public static final class Break {
        public static final int ENCODED_SIZE = 6;
        public int main;
        public int subFrom;
        public int subTo;

        public Break(int i, int i2, int i3) {
            this.main = i;
            this.subFrom = i2;
            this.subTo = i3;
        }

        public Break(RecordInputStream recordInputStream) {
            this.main = recordInputStream.readUShort() - 1;
            this.subFrom = recordInputStream.readUShort();
            this.subTo = recordInputStream.readUShort();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this.main + 1);
            littleEndianOutput.writeShort(this.subFrom);
            littleEndianOutput.writeShort(this.subTo);
        }
    }

    protected PageBreakRecord() {
        this._breaks = new ArrayList();
        this._breakMap = new HashMap();
    }

    public PageBreakRecord(RecordInputStream recordInputStream) {
        short readShort = recordInputStream.readShort();
        this._breaks = new ArrayList(readShort + 2);
        this._breakMap = new HashMap();
        for (int i = 0; i < readShort; i++) {
            Break r2 = new Break(recordInputStream);
            this._breaks.add(r2);
            this._breakMap.put(Integer.valueOf(r2.main), r2);
        }
    }

    public boolean isEmpty() {
        return this._breaks.isEmpty();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._breaks.size() * 6) + 2;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        int size = this._breaks.size();
        littleEndianOutput.writeShort(size);
        for (int i = 0; i < size; i++) {
            this._breaks.get(i).serialize(littleEndianOutput);
        }
    }

    public int getNumBreaks() {
        return this._breaks.size();
    }

    public final Iterator<Break> getBreaksIterator() {
        return this._breaks.iterator();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = "row";
        if (getSid() == 27) {
            str = "HORIZONTALPAGEBREAK";
            str2 = "col";
        } else {
            str = "VERTICALPAGEBREAK";
            str2 = "row";
            str3 = JamXmlElements.COLUMN;
        }
        stringBuffer.append("[" + str + "]").append("\n");
        stringBuffer.append("     .sid        =").append((int) getSid()).append("\n");
        stringBuffer.append("     .numbreaks =").append(getNumBreaks()).append("\n");
        Iterator<Break> breaksIterator = getBreaksIterator();
        for (int i = 0; i < getNumBreaks(); i++) {
            Break next = breaksIterator.next();
            stringBuffer.append("     .").append(str3).append(" (zero-based) =").append(next.main).append("\n");
            stringBuffer.append("     .").append(str2).append("From    =").append(next.subFrom).append("\n");
            stringBuffer.append("     .").append(str2).append("To      =").append(next.subTo).append("\n");
        }
        stringBuffer.append("[" + str + "]").append("\n");
        return stringBuffer.toString();
    }

    public void addBreak(int i, int i2, int i3) {
        Integer valueOf = Integer.valueOf(i);
        Break r1 = this._breakMap.get(valueOf);
        if (r1 == null) {
            Break r12 = new Break(i, i2, i3);
            this._breakMap.put(valueOf, r12);
            this._breaks.add(r12);
        } else {
            r1.main = i;
            r1.subFrom = i2;
            r1.subTo = i3;
        }
    }

    public final void removeBreak(int i) {
        Integer valueOf = Integer.valueOf(i);
        this._breaks.remove(this._breakMap.get(valueOf));
        this._breakMap.remove(valueOf);
    }

    public final Break getBreak(int i) {
        return this._breakMap.get(Integer.valueOf(i));
    }

    public final int[] getBreaks() {
        int numBreaks = getNumBreaks();
        if (numBreaks < 1) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numBreaks];
        for (int i = 0; i < numBreaks; i++) {
            iArr[i] = this._breaks.get(i).main;
        }
        return iArr;
    }
}
