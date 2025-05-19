package org.apache.poi.hssf.record;

/* loaded from: classes5.dex */
public final class HeaderRecord extends HeaderFooterBase {
    public static final short sid = 20;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 20;
    }

    public HeaderRecord(String str) {
        super(str);
    }

    public HeaderRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[HEADER]\n");
        stringBuffer.append("    .header = ").append(getText()).append("\n");
        stringBuffer.append("[/HEADER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new HeaderRecord(getText());
    }
}
