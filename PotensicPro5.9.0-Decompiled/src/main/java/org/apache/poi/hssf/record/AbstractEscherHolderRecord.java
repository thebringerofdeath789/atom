package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public abstract class AbstractEscherHolderRecord extends Record {
    private static boolean DESERIALISE;
    private LazilyConcatenatedByteArray rawDataContainer = new LazilyConcatenatedByteArray();
    private List<EscherRecord> escherRecords = new ArrayList();

    protected abstract String getRecordName();

    @Override // org.apache.poi.hssf.record.Record
    public abstract short getSid();

    static {
        try {
            DESERIALISE = System.getProperty("poi.deserialize.escher") != null;
        } catch (SecurityException unused) {
            DESERIALISE = false;
        }
    }

    public AbstractEscherHolderRecord() {
    }

    public AbstractEscherHolderRecord(RecordInputStream recordInputStream) {
        if (!DESERIALISE) {
            this.rawDataContainer.concatenate(recordInputStream.readRemainder());
        } else {
            byte[] readAllContinuedRemainder = recordInputStream.readAllContinuedRemainder();
            convertToEscherRecords(0, readAllContinuedRemainder.length, readAllContinuedRemainder);
        }
    }

    protected void convertRawBytesToEscherRecords() {
        if (DESERIALISE) {
            return;
        }
        byte[] rawData = getRawData();
        convertToEscherRecords(0, rawData.length, rawData);
    }

    private void convertToEscherRecords(int i, int i2, byte[] bArr) {
        this.escherRecords.clear();
        EscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
        int i3 = i;
        while (i3 < i + i2) {
            EscherRecord createRecord = defaultEscherRecordFactory.createRecord(bArr, i3);
            int fillFields = createRecord.fillFields(bArr, i3, defaultEscherRecordFactory);
            this.escherRecords.add(createRecord);
            i3 += fillFields;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append(PropertyUtils.INDEXED_DELIM + getRecordName() + PropertyUtils.INDEXED_DELIM2 + property);
        if (this.escherRecords.size() == 0) {
            stringBuffer.append("No Escher Records Decoded" + property);
        }
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        stringBuffer.append("[/" + getRecordName() + PropertyUtils.INDEXED_DELIM2 + property);
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        int i2 = i + 0;
        LittleEndian.putShort(bArr, i2, getSid());
        int i3 = i + 2;
        LittleEndian.putShort(bArr, i3, (short) (getRecordSize() - 4));
        byte[] rawData = getRawData();
        if (this.escherRecords.size() == 0 && rawData != null) {
            LittleEndian.putShort(bArr, i2, getSid());
            LittleEndian.putShort(bArr, i3, (short) (getRecordSize() - 4));
            System.arraycopy(rawData, 0, bArr, i + 4, rawData.length);
            return rawData.length + 4;
        }
        LittleEndian.putShort(bArr, i2, getSid());
        LittleEndian.putShort(bArr, i3, (short) (getRecordSize() - 4));
        int i4 = i + 4;
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            i4 += it.next().serialize(i4, bArr, new NullEscherSerializationListener());
        }
        return getRecordSize();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] rawData = getRawData();
        if (this.escherRecords.size() == 0 && rawData != null) {
            return rawData.length;
        }
        int i = 0;
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            i += it.next().getRecordSize();
        }
        return i;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }

    public void addEscherRecord(int i, EscherRecord escherRecord) {
        this.escherRecords.add(i, escherRecord);
    }

    public boolean addEscherRecord(EscherRecord escherRecord) {
        return this.escherRecords.add(escherRecord);
    }

    public List<EscherRecord> getEscherRecords() {
        return this.escherRecords;
    }

    public void clearEscherRecords() {
        this.escherRecords.clear();
    }

    public EscherContainerRecord getEscherContainer() {
        for (EscherRecord escherRecord : this.escherRecords) {
            if (escherRecord instanceof EscherContainerRecord) {
                return (EscherContainerRecord) escherRecord;
            }
        }
        return null;
    }

    public EscherRecord findFirstWithId(short s) {
        return findFirstWithId(s, getEscherRecords());
    }

    private EscherRecord findFirstWithId(short s, List<EscherRecord> list) {
        EscherRecord findFirstWithId;
        for (EscherRecord escherRecord : list) {
            if (escherRecord.getRecordId() == s) {
                return escherRecord;
            }
        }
        for (EscherRecord escherRecord2 : list) {
            if (escherRecord2.isContainerRecord() && (findFirstWithId = findFirstWithId(s, escherRecord2.getChildRecords())) != null) {
                return findFirstWithId;
            }
        }
        return null;
    }

    public EscherRecord getEscherRecord(int i) {
        return this.escherRecords.get(i);
    }

    public void join(AbstractEscherHolderRecord abstractEscherHolderRecord) {
        this.rawDataContainer.concatenate(abstractEscherHolderRecord.getRawData());
    }

    public void processContinueRecord(byte[] bArr) {
        this.rawDataContainer.concatenate(bArr);
    }

    public byte[] getRawData() {
        return this.rawDataContainer.toArray();
    }

    public void setRawData(byte[] bArr) {
        this.rawDataContainer.clear();
        this.rawDataContainer.concatenate(bArr);
    }

    public void decode() {
        List<EscherRecord> list = this.escherRecords;
        if (list == null || list.size() == 0) {
            byte[] rawData = getRawData();
            convertToEscherRecords(0, rawData.length, rawData);
        }
    }
}
