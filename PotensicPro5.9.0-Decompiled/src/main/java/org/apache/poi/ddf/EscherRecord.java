package org.apache.poi.ddf;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public abstract class EscherRecord {
    private static BitField fInstance = BitFieldFactory.getInstance(65520);
    private static BitField fVersion = BitFieldFactory.getInstance(15);
    private short _options;
    private short _recordId;

    public abstract int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory);

    public abstract String getRecordName();

    public abstract int getRecordSize();

    public abstract int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener);

    protected int fillFields(byte[] bArr, EscherRecordFactory escherRecordFactory) {
        return fillFields(bArr, 0, escherRecordFactory);
    }

    protected int readHeader(byte[] bArr, int i) {
        this._options = LittleEndian.getShort(bArr, i);
        this._recordId = LittleEndian.getShort(bArr, i + 2);
        return LittleEndian.getInt(bArr, i + 4);
    }

    protected static short readInstance(byte[] bArr, int i) {
        return fInstance.getShortValue(LittleEndian.getShort(bArr, i));
    }

    public boolean isContainerRecord() {
        return getVersion() == 15;
    }

    @Internal
    public short getOptions() {
        return this._options;
    }

    @Internal
    public void setOptions(short s) {
        setVersion(fVersion.getShortValue(s));
        setInstance(fInstance.getShortValue(s));
        this._options = s;
    }

    public byte[] serialize() {
        byte[] bArr = new byte[getRecordSize()];
        serialize(0, bArr);
        return bArr;
    }

    public int serialize(int i, byte[] bArr) {
        return serialize(i, bArr, new NullEscherSerializationListener());
    }

    public short getRecordId() {
        return this._recordId;
    }

    public void setRecordId(short s) {
        this._recordId = s;
    }

    public List<EscherRecord> getChildRecords() {
        return Collections.emptyList();
    }

    public void setChildRecords(List<EscherRecord> list) {
        throw new UnsupportedOperationException("This record does not support child records.");
    }

    public Object clone() {
        throw new RuntimeException("The class " + getClass().getName() + " needs to define a clone method");
    }

    public EscherRecord getChild(int i) {
        return getChildRecords().get(i);
    }

    public void display(PrintWriter printWriter, int i) {
        for (int i2 = 0; i2 < i * 4; i2++) {
            printWriter.print(' ');
        }
        printWriter.println(getRecordName());
    }

    public short getInstance() {
        return fInstance.getShortValue(this._options);
    }

    public void setInstance(short s) {
        this._options = fInstance.setShortValue(this._options, s);
    }

    public short getVersion() {
        return fVersion.getShortValue(this._options);
    }

    public void setVersion(short s) {
        this._options = fVersion.setShortValue(this._options, s);
    }

    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(">\n").append(str).append("\t").append("<RecordId>0x").append(HexDump.toHex(this._recordId)).append("</RecordId>\n").append(str).append("\t").append("<Options>").append((int) this._options).append("</Options>\n").append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }

    protected String formatXmlRecordHeader(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(str).append(" recordId=\"0x").append(str2).append("\" version=\"0x").append(str3).append("\" instance=\"0x").append(str4).append("\" size=\"").append(getRecordSize()).append("\">\n");
        return sb.toString();
    }

    public String toXml() {
        return toXml("");
    }
}
