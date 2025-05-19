package org.apache.poi.hssf.record;

import java.util.Iterator;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.IntMapper;

/* loaded from: classes5.dex */
public final class SSTRecord extends ContinuableRecord {
    private static final org.apache.poi.hssf.record.common.UnicodeString EMPTY_STRING = new org.apache.poi.hssf.record.common.UnicodeString("");
    static final int MAX_DATA_SPACE = 8216;
    static final int SST_RECORD_OVERHEAD = 12;
    static final int STD_RECORD_OVERHEAD = 4;
    public static final short sid = 252;
    int[] bucketAbsoluteOffsets;
    int[] bucketRelativeOffsets;
    private SSTDeserializer deserializer;
    private int field_1_num_strings;
    private int field_2_num_unique_strings;
    private IntMapper<org.apache.poi.hssf.record.common.UnicodeString> field_3_strings;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 252;
    }

    public SSTRecord() {
        this.field_1_num_strings = 0;
        this.field_2_num_unique_strings = 0;
        this.field_3_strings = new IntMapper<>();
        this.deserializer = new SSTDeserializer(this.field_3_strings);
    }

    public int addString(org.apache.poi.hssf.record.common.UnicodeString unicodeString) {
        this.field_1_num_strings++;
        if (unicodeString == null) {
            unicodeString = EMPTY_STRING;
        }
        int index = this.field_3_strings.getIndex(unicodeString);
        if (index != -1) {
            return index;
        }
        int size = this.field_3_strings.size();
        this.field_2_num_unique_strings++;
        SSTDeserializer.addToStringTable(this.field_3_strings, unicodeString);
        return size;
    }

    public int getNumStrings() {
        return this.field_1_num_strings;
    }

    public int getNumUniqueStrings() {
        return this.field_2_num_unique_strings;
    }

    public org.apache.poi.hssf.record.common.UnicodeString getString(int i) {
        return this.field_3_strings.get(i);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SST]\n");
        stringBuffer.append("    .numstrings     = ").append(Integer.toHexString(getNumStrings())).append("\n");
        stringBuffer.append("    .uniquestrings  = ").append(Integer.toHexString(getNumUniqueStrings())).append("\n");
        for (int i = 0; i < this.field_3_strings.size(); i++) {
            stringBuffer.append("    .string_" + i + "      = ").append(this.field_3_strings.get(i).getDebugInfo()).append("\n");
        }
        stringBuffer.append("[/SST]\n");
        return stringBuffer.toString();
    }

    public SSTRecord(RecordInputStream recordInputStream) {
        this.field_1_num_strings = recordInputStream.readInt();
        this.field_2_num_unique_strings = recordInputStream.readInt();
        this.field_3_strings = new IntMapper<>();
        SSTDeserializer sSTDeserializer = new SSTDeserializer(this.field_3_strings);
        this.deserializer = sSTDeserializer;
        if (this.field_1_num_strings == 0) {
            this.field_2_num_unique_strings = 0;
        } else {
            sSTDeserializer.manufactureStrings(this.field_2_num_unique_strings, recordInputStream);
        }
    }

    Iterator<org.apache.poi.hssf.record.common.UnicodeString> getStrings() {
        return this.field_3_strings.iterator();
    }

    int countStrings() {
        return this.field_3_strings.size();
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    protected void serialize(ContinuableRecordOutput continuableRecordOutput) {
        SSTSerializer sSTSerializer = new SSTSerializer(this.field_3_strings, getNumStrings(), getNumUniqueStrings());
        sSTSerializer.serialize(continuableRecordOutput);
        this.bucketAbsoluteOffsets = sSTSerializer.getBucketAbsoluteOffsets();
        this.bucketRelativeOffsets = sSTSerializer.getBucketRelativeOffsets();
    }

    SSTDeserializer getDeserializer() {
        return this.deserializer;
    }

    public ExtSSTRecord createExtSSTRecord(int i) {
        int[] iArr = this.bucketAbsoluteOffsets;
        if (iArr == null || iArr == null) {
            throw new IllegalStateException("SST record has not yet been serialized.");
        }
        ExtSSTRecord extSSTRecord = new ExtSSTRecord();
        extSSTRecord.setNumStringsPerBucket((short) 8);
        int[] iArr2 = (int[]) this.bucketAbsoluteOffsets.clone();
        int[] iArr3 = (int[]) this.bucketRelativeOffsets.clone();
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            iArr2[i2] = iArr2[i2] + i;
        }
        extSSTRecord.setBucketOffsets(iArr2, iArr3);
        return extSSTRecord;
    }

    public int calcExtSSTRecordSize() {
        return ExtSSTRecord.getRecordSizeForStrings(this.field_3_strings.size());
    }
}
