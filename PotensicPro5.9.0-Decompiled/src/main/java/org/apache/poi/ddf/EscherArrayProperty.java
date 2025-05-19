package org.apache.poi.ddf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public final class EscherArrayProperty extends EscherComplexProperty implements Iterable<byte[]> {
    private static final int FIXED_SIZE = 6;
    private boolean emptyComplexPart;
    private boolean sizeIncludesHeaderSize;

    public static int getActualSizeOfElements(short s) {
        return s < 0 ? (short) ((-s) >> 2) : s;
    }

    public EscherArrayProperty(short s, byte[] bArr) {
        super(s, checkComplexData(bArr));
        this.sizeIncludesHeaderSize = true;
        this.emptyComplexPart = false;
        this.emptyComplexPart = bArr.length == 0;
    }

    public EscherArrayProperty(short s, boolean z, byte[] bArr) {
        super(s, z, checkComplexData(bArr));
        this.sizeIncludesHeaderSize = true;
        this.emptyComplexPart = false;
    }

    private static byte[] checkComplexData(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[6] : bArr;
    }

    public int getNumberOfElementsInArray() {
        if (this.emptyComplexPart) {
            return 0;
        }
        return LittleEndian.getUShort(this._complexData, 0);
    }

    public void setNumberOfElementsInArray(int i) {
        int actualSizeOfElements = (getActualSizeOfElements(getSizeOfElements()) * i) + 6;
        if (actualSizeOfElements != this._complexData.length) {
            byte[] bArr = new byte[actualSizeOfElements];
            System.arraycopy(this._complexData, 0, bArr, 0, this._complexData.length);
            this._complexData = bArr;
        }
        LittleEndian.putShort(this._complexData, 0, (short) i);
    }

    public int getNumberOfElementsInMemory() {
        return LittleEndian.getUShort(this._complexData, 2);
    }

    public void setNumberOfElementsInMemory(int i) {
        int actualSizeOfElements = (getActualSizeOfElements(getSizeOfElements()) * i) + 6;
        if (actualSizeOfElements != this._complexData.length) {
            byte[] bArr = new byte[actualSizeOfElements];
            System.arraycopy(this._complexData, 0, bArr, 0, actualSizeOfElements);
            this._complexData = bArr;
        }
        LittleEndian.putShort(this._complexData, 2, (short) i);
    }

    public short getSizeOfElements() {
        return LittleEndian.getShort(this._complexData, 4);
    }

    public void setSizeOfElements(int i) {
        LittleEndian.putShort(this._complexData, 4, (short) i);
        int numberOfElementsInArray = (getNumberOfElementsInArray() * getActualSizeOfElements(getSizeOfElements())) + 6;
        if (numberOfElementsInArray != this._complexData.length) {
            byte[] bArr = new byte[numberOfElementsInArray];
            System.arraycopy(this._complexData, 0, bArr, 0, 6);
            this._complexData = bArr;
        }
    }

    public byte[] getElement(int i) {
        int actualSizeOfElements = getActualSizeOfElements(getSizeOfElements());
        byte[] bArr = new byte[actualSizeOfElements];
        System.arraycopy(this._complexData, (i * actualSizeOfElements) + 6, bArr, 0, actualSizeOfElements);
        return bArr;
    }

    public void setElement(int i, byte[] bArr) {
        int actualSizeOfElements = getActualSizeOfElements(getSizeOfElements());
        System.arraycopy(bArr, 0, this._complexData, (i * actualSizeOfElements) + 6, actualSizeOfElements);
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    {EscherArrayProperty:\n");
        stringBuffer.append("     Num Elements: " + getNumberOfElementsInArray() + '\n');
        stringBuffer.append("     Num Elements In Memory: " + getNumberOfElementsInMemory() + '\n');
        stringBuffer.append("     Size of elements: " + ((int) getSizeOfElements()) + '\n');
        for (int i = 0; i < getNumberOfElementsInArray(); i++) {
            stringBuffer.append("     Element " + i + ": " + HexDump.toHex(getElement(i)) + '\n');
        }
        stringBuffer.append("}\n");
        return "propNum: " + ((int) getPropertyNumber()) + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", data: \n" + stringBuffer.toString();
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\">\n");
        for (int i = 0; i < getNumberOfElementsInArray(); i++) {
            sb.append("\t").append(str).append("<Element>").append(HexDump.toHex(getElement(i))).append("</Element>\n");
        }
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }

    public int setArrayData(byte[] bArr, int i) {
        if (this.emptyComplexPart) {
            this._complexData = new byte[0];
        } else {
            short s = LittleEndian.getShort(bArr, i);
            LittleEndian.getShort(bArr, i + 2);
            int actualSizeOfElements = getActualSizeOfElements(LittleEndian.getShort(bArr, i + 4)) * s;
            if (actualSizeOfElements == this._complexData.length) {
                this._complexData = new byte[actualSizeOfElements + 6];
                this.sizeIncludesHeaderSize = false;
            }
            System.arraycopy(bArr, i, this._complexData, 0, this._complexData.length);
        }
        return this._complexData.length;
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i) {
        LittleEndian.putShort(bArr, i, getId());
        int length = this._complexData.length;
        if (!this.sizeIncludesHeaderSize) {
            length -= 6;
        }
        LittleEndian.putInt(bArr, i + 2, length);
        return 6;
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new Iterator<byte[]>() { // from class: org.apache.poi.ddf.EscherArrayProperty.1
            int idx = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.idx < EscherArrayProperty.this.getNumberOfElementsInArray();
            }

            @Override // java.util.Iterator
            public byte[] next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                EscherArrayProperty escherArrayProperty = EscherArrayProperty.this;
                int i = this.idx;
                this.idx = i + 1;
                return escherArrayProperty.getElement(i);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("not yet implemented");
            }
        };
    }
}
