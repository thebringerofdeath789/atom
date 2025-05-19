package org.apache.poi.ddf;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes4.dex */
public final class EscherContainerRecord extends EscherRecord {
    public static final short BSTORE_CONTAINER = -4095;
    public static final short DGG_CONTAINER = -4096;
    public static final short DG_CONTAINER = -4094;
    public static final short SOLVER_CONTAINER = -4091;
    public static final short SPGR_CONTAINER = -4093;
    public static final short SP_CONTAINER = -4092;
    private static POILogger log = POILogFactory.getLogger((Class<?>) EscherContainerRecord.class);
    private final List<EscherRecord> _childRecords = new ArrayList();
    private int _remainingLength;

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        int i2 = 8;
        int i3 = i + 8;
        while (readHeader > 0 && i3 < bArr.length) {
            EscherRecord createRecord = escherRecordFactory.createRecord(bArr, i3);
            int fillFields = createRecord.fillFields(bArr, i3, escherRecordFactory);
            i2 += fillFields;
            i3 += fillFields;
            readHeader -= fillFields;
            addChildRecord(createRecord);
            if (i3 >= bArr.length && readHeader > 0) {
                this._remainingLength = readHeader;
                if (log.check(5)) {
                    log.log(5, "Not enough Escher data: " + readHeader + " bytes remaining but no space left");
                }
            }
        }
        return i2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        Iterator<EscherRecord> it = this._childRecords.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().getRecordSize();
        }
        LittleEndian.putInt(bArr, i + 4, i2 + this._remainingLength);
        int i3 = i + 8;
        Iterator<EscherRecord> it2 = this._childRecords.iterator();
        while (it2.hasNext()) {
            i3 += it2.next().serialize(i3, bArr, escherSerializationListener);
        }
        int i4 = i3 - i;
        escherSerializationListener.afterRecordSerialize(i3, getRecordId(), i4, this);
        return i4;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        Iterator<EscherRecord> it = this._childRecords.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getRecordSize();
        }
        return i + 8;
    }

    public boolean hasChildOfType(short s) {
        Iterator<EscherRecord> it = this._childRecords.iterator();
        while (it.hasNext()) {
            if (it.next().getRecordId() == s) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public EscherRecord getChild(int i) {
        return this._childRecords.get(i);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return new ArrayList(this._childRecords);
    }

    public Iterator<EscherRecord> getChildIterator() {
        return new ReadOnlyIterator(this._childRecords);
    }

    private static final class ReadOnlyIterator implements Iterator<EscherRecord> {
        private int _index = 0;
        private final List<EscherRecord> _list;

        public ReadOnlyIterator(List<EscherRecord> list) {
            this._list = list;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._index < this._list.size();
        }

        @Override // java.util.Iterator
        public EscherRecord next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<EscherRecord> list = this._list;
            int i = this._index;
            this._index = i + 1;
            return list.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setChildRecords(List<EscherRecord> list) {
        List<EscherRecord> list2 = this._childRecords;
        if (list == list2) {
            throw new IllegalStateException("Child records private data member has escaped");
        }
        list2.clear();
        this._childRecords.addAll(list);
    }

    public boolean removeChildRecord(EscherRecord escherRecord) {
        return this._childRecords.remove(escherRecord);
    }

    public List<EscherContainerRecord> getChildContainers() {
        ArrayList arrayList = new ArrayList();
        for (EscherRecord escherRecord : this._childRecords) {
            if (escherRecord instanceof EscherContainerRecord) {
                arrayList.add((EscherContainerRecord) escherRecord);
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        switch (getRecordId()) {
            case -4096:
                return "DggContainer";
            case -4095:
                return "BStoreContainer";
            case -4094:
                return "DgContainer";
            case -4093:
                return "SpgrContainer";
            case -4092:
                return "SpContainer";
            case -4091:
                return "SolverContainer";
            default:
                return "Container 0x" + HexDump.toHex(getRecordId());
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void display(PrintWriter printWriter, int i) {
        super.display(printWriter, i);
        Iterator<EscherRecord> it = this._childRecords.iterator();
        while (it.hasNext()) {
            it.next().display(printWriter, i + 1);
        }
    }

    public void addChildRecord(EscherRecord escherRecord) {
        this._childRecords.add(escherRecord);
    }

    public void addChildBefore(EscherRecord escherRecord, int i) {
        int i2 = 0;
        while (i2 < this._childRecords.size()) {
            if (this._childRecords.get(i2).getRecordId() == i) {
                this._childRecords.add(i2, escherRecord);
                i2++;
            }
            i2++;
        }
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        if (this._childRecords.size() > 0) {
            stringBuffer.append("  children: " + property);
            int i = 0;
            for (EscherRecord escherRecord : this._childRecords) {
                stringBuffer.append("   Child " + i + ":" + property);
                String replaceAll = String.valueOf(escherRecord).replaceAll("\n", "\n    ");
                stringBuffer.append("    ");
                stringBuffer.append(replaceAll);
                stringBuffer.append(property);
                i++;
            }
        }
        return getClass().getName() + " (" + getRecordName() + "):" + property + "  isContainer: " + isContainerRecord() + property + "  version: 0x" + HexDump.toHex(getVersion()) + property + "  instance: 0x" + HexDump.toHex(getInstance()) + property + "  recordId: 0x" + HexDump.toHex(getRecordId()) + property + "  numchildren: " + this._childRecords.size() + property + stringBuffer.toString();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getRecordName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance())));
        Iterator<EscherRecord> it = this._childRecords.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXml(str + "\t"));
        }
        sb.append(str).append("</").append(getRecordName()).append(">\n");
        return sb.toString();
    }

    public <T extends EscherRecord> T getChildById(short s) {
        Iterator<EscherRecord> it = this._childRecords.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getRecordId() == s) {
                return t;
            }
        }
        return null;
    }

    public void getRecordsById(short s, List<EscherRecord> list) {
        for (EscherRecord escherRecord : this._childRecords) {
            if (escherRecord instanceof EscherContainerRecord) {
                ((EscherContainerRecord) escherRecord).getRecordsById(s, list);
            } else if (escherRecord.getRecordId() == s) {
                list.add(escherRecord);
            }
        }
    }
}
