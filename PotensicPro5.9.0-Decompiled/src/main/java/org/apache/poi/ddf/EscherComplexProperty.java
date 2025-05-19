package org.apache.poi.ddf;

import java.util.Arrays;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public class EscherComplexProperty extends EscherProperty {
    protected byte[] _complexData;

    public EscherComplexProperty(short s, byte[] bArr) {
        super(s);
        this._complexData = bArr;
    }

    public EscherComplexProperty(short s, boolean z, byte[] bArr) {
        super(s, true, z);
        this._complexData = bArr;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i) {
        LittleEndian.putShort(bArr, i, getId());
        LittleEndian.putInt(bArr, i + 2, this._complexData.length);
        return 6;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] bArr, int i) {
        byte[] bArr2 = this._complexData;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        return this._complexData.length;
    }

    public byte[] getComplexData() {
        return this._complexData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EscherComplexProperty) && Arrays.equals(this._complexData, ((EscherComplexProperty) obj)._complexData);
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int getPropertySize() {
        return this._complexData.length + 6;
    }

    public int hashCode() {
        return getId() * 11;
    }

    public String toString() {
        return "propNum: " + ((int) getPropertyNumber()) + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", data: " + System.getProperty("line.separator") + HexDump.toHex(this._complexData, 32);
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        HexDump.toHex(this._complexData, 32);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\">\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }
}
