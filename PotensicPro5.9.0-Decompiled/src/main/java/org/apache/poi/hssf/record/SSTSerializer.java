package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.IntMapper;

/* loaded from: classes5.dex */
final class SSTSerializer {
    private final int _numStrings;
    private final int _numUniqueStrings;
    private final int[] bucketAbsoluteOffsets;
    private final int[] bucketRelativeOffsets;
    private final IntMapper<org.apache.poi.hssf.record.common.UnicodeString> strings;

    public SSTSerializer(IntMapper<org.apache.poi.hssf.record.common.UnicodeString> intMapper, int i, int i2) {
        this.strings = intMapper;
        this._numStrings = i;
        this._numUniqueStrings = i2;
        int numberOfInfoRecsForStrings = ExtSSTRecord.getNumberOfInfoRecsForStrings(intMapper.size());
        this.bucketAbsoluteOffsets = new int[numberOfInfoRecsForStrings];
        this.bucketRelativeOffsets = new int[numberOfInfoRecsForStrings];
    }

    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeInt(this._numStrings);
        continuableRecordOutput.writeInt(this._numUniqueStrings);
        for (int i = 0; i < this.strings.size(); i++) {
            if (i % 8 == 0) {
                int totalSize = continuableRecordOutput.getTotalSize();
                int i2 = i / 8;
                if (i2 < 128) {
                    this.bucketAbsoluteOffsets[i2] = totalSize;
                    this.bucketRelativeOffsets[i2] = totalSize;
                }
            }
            getUnicodeString(i).serialize(continuableRecordOutput);
        }
    }

    private org.apache.poi.hssf.record.common.UnicodeString getUnicodeString(int i) {
        return getUnicodeString(this.strings, i);
    }

    private static org.apache.poi.hssf.record.common.UnicodeString getUnicodeString(IntMapper<org.apache.poi.hssf.record.common.UnicodeString> intMapper, int i) {
        return intMapper.get(i);
    }

    public int[] getBucketAbsoluteOffsets() {
        return this.bucketAbsoluteOffsets;
    }

    public int[] getBucketRelativeOffsets() {
        return this.bucketRelativeOffsets;
    }
}
