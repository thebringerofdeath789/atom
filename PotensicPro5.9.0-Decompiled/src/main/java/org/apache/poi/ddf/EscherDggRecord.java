package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* loaded from: classes4.dex */
public final class EscherDggRecord extends EscherRecord {
    private static final Comparator<FileIdCluster> MY_COMP = new Comparator<FileIdCluster>() { // from class: org.apache.poi.ddf.EscherDggRecord.1
        @Override // java.util.Comparator
        public int compare(FileIdCluster fileIdCluster, FileIdCluster fileIdCluster2) {
            if (fileIdCluster.getDrawingGroupId() == fileIdCluster2.getDrawingGroupId()) {
                return 0;
            }
            return fileIdCluster.getDrawingGroupId() < fileIdCluster2.getDrawingGroupId() ? -1 : 1;
        }
    };
    public static final String RECORD_DESCRIPTION = "MsofbtDgg";
    public static final short RECORD_ID = -4090;
    private int field_1_shapeIdMax;
    private int field_3_numShapesSaved;
    private int field_4_drawingsSaved;
    private FileIdCluster[] field_5_fileIdClusters;
    private int maxDgId;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Dgg";
    }

    public static class FileIdCluster {
        private int field_1_drawingGroupId;
        private int field_2_numShapeIdsUsed;

        public FileIdCluster(int i, int i2) {
            this.field_1_drawingGroupId = i;
            this.field_2_numShapeIdsUsed = i2;
        }

        public int getDrawingGroupId() {
            return this.field_1_drawingGroupId;
        }

        public int getNumShapeIdsUsed() {
            return this.field_2_numShapeIdsUsed;
        }

        public void incrementShapeId() {
            this.field_2_numShapeIdsUsed++;
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_shapeIdMax = LittleEndian.getInt(bArr, i2 + 0);
        LittleEndian.getInt(bArr, i2 + 4);
        this.field_3_numShapesSaved = LittleEndian.getInt(bArr, i2 + 8);
        this.field_4_drawingsSaved = LittleEndian.getInt(bArr, i2 + 12);
        this.field_5_fileIdClusters = new FileIdCluster[(readHeader - 16) / 8];
        int i3 = 0;
        int i4 = 16;
        while (true) {
            FileIdCluster[] fileIdClusterArr = this.field_5_fileIdClusters;
            if (i3 >= fileIdClusterArr.length) {
                break;
            }
            int i5 = i2 + i4;
            fileIdClusterArr[i3] = new FileIdCluster(LittleEndian.getInt(bArr, i5), LittleEndian.getInt(bArr, i5 + 4));
            this.maxDgId = Math.max(this.maxDgId, this.field_5_fileIdClusters[i3].getDrawingGroupId());
            i4 += 8;
            i3++;
        }
        int i6 = readHeader - i4;
        if (i6 == 0) {
            return i4 + 8 + i6;
        }
        throw new RecordFormatException("Expecting no remaining data but got " + i6 + " byte(s).");
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        int i2 = i + 2;
        LittleEndian.putShort(bArr, i2, getRecordId());
        int i3 = i2 + 2;
        LittleEndian.putInt(bArr, i3, getRecordSize() - 8);
        int i4 = i3 + 4;
        LittleEndian.putInt(bArr, i4, this.field_1_shapeIdMax);
        int i5 = i4 + 4;
        LittleEndian.putInt(bArr, i5, getNumIdClusters());
        int i6 = i5 + 4;
        LittleEndian.putInt(bArr, i6, this.field_3_numShapesSaved);
        int i7 = i6 + 4;
        LittleEndian.putInt(bArr, i7, this.field_4_drawingsSaved);
        int i8 = i7 + 4;
        int i9 = 0;
        while (true) {
            FileIdCluster[] fileIdClusterArr = this.field_5_fileIdClusters;
            if (i9 < fileIdClusterArr.length) {
                LittleEndian.putInt(bArr, i8, fileIdClusterArr[i9].field_1_drawingGroupId);
                int i10 = i8 + 4;
                LittleEndian.putInt(bArr, i10, this.field_5_fileIdClusters[i9].field_2_numShapeIdsUsed);
                i8 = i10 + 4;
                i9++;
            } else {
                escherSerializationListener.afterRecordSerialize(i8, getRecordId(), getRecordSize(), this);
                return getRecordSize();
            }
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return (this.field_5_fileIdClusters.length * 8) + 24;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.field_5_fileIdClusters != null) {
            int i = 0;
            while (i < this.field_5_fileIdClusters.length) {
                int i2 = i + 1;
                stringBuffer.append("  DrawingGroupId").append(i2).append(": ");
                stringBuffer.append(this.field_5_fileIdClusters[i].field_1_drawingGroupId);
                stringBuffer.append('\n');
                stringBuffer.append("  NumShapeIdsUsed").append(i2).append(": ");
                stringBuffer.append(this.field_5_fileIdClusters[i].field_2_numShapeIdsUsed);
                stringBuffer.append('\n');
                i = i2;
            }
        }
        return getClass().getName() + ":\n  RecordId: 0x" + HexDump.toHex(RECORD_ID) + "\n  Version: 0x" + HexDump.toHex(getVersion()) + "\n  Instance: 0x" + HexDump.toHex(getInstance()) + "\n  ShapeIdMax: " + this.field_1_shapeIdMax + "\n  NumIdClusters: " + getNumIdClusters() + "\n  NumShapesSaved: " + this.field_3_numShapesSaved + "\n  DrawingsSaved: " + this.field_4_drawingsSaved + "\n" + stringBuffer.toString();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<ShapeIdMax>").append(this.field_1_shapeIdMax).append("</ShapeIdMax>\n").append(str).append("\t").append("<NumIdClusters>").append(getNumIdClusters()).append("</NumIdClusters>\n").append(str).append("\t").append("<NumShapesSaved>").append(this.field_3_numShapesSaved).append("</NumShapesSaved>\n").append(str).append("\t").append("<DrawingsSaved>").append(this.field_4_drawingsSaved).append("</DrawingsSaved>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }

    public int getShapeIdMax() {
        return this.field_1_shapeIdMax;
    }

    public void setShapeIdMax(int i) {
        this.field_1_shapeIdMax = i;
    }

    public int getNumIdClusters() {
        FileIdCluster[] fileIdClusterArr = this.field_5_fileIdClusters;
        if (fileIdClusterArr == null) {
            return 0;
        }
        return fileIdClusterArr.length + 1;
    }

    public int getNumShapesSaved() {
        return this.field_3_numShapesSaved;
    }

    public void setNumShapesSaved(int i) {
        this.field_3_numShapesSaved = i;
    }

    public int getDrawingsSaved() {
        return this.field_4_drawingsSaved;
    }

    public void setDrawingsSaved(int i) {
        this.field_4_drawingsSaved = i;
    }

    public int getMaxDrawingGroupId() {
        return this.maxDgId;
    }

    public void setMaxDrawingGroupId(int i) {
        this.maxDgId = i;
    }

    public FileIdCluster[] getFileIdClusters() {
        return this.field_5_fileIdClusters;
    }

    public void setFileIdClusters(FileIdCluster[] fileIdClusterArr) {
        this.field_5_fileIdClusters = fileIdClusterArr;
    }

    public void addCluster(int i, int i2) {
        addCluster(i, i2, true);
    }

    public void addCluster(int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.field_5_fileIdClusters));
        arrayList.add(new FileIdCluster(i, i2));
        if (z) {
            Collections.sort(arrayList, MY_COMP);
        }
        this.maxDgId = Math.min(this.maxDgId, i);
        this.field_5_fileIdClusters = (FileIdCluster[]) arrayList.toArray(new FileIdCluster[arrayList.size()]);
    }
}
