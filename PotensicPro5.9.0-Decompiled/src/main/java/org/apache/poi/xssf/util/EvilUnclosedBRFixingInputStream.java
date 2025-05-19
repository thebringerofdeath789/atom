package org.apache.poi.xssf.util;

import com.logan.usb.UsbCameraHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;

/* loaded from: classes5.dex */
public class EvilUnclosedBRFixingInputStream extends InputStream {
    private static byte[] detect = {DeletedRef3DPtg.sid, 98, 114, 62};
    private InputStream source;
    private byte[] spare;

    public EvilUnclosedBRFixingInputStream(InputStream inputStream) {
        this.source = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.source.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFromSpare = readFromSpare(bArr, i, i2);
        int read = this.source.read(bArr, i + readFromSpare, i2 - readFromSpare);
        if (read != -1 && read != 0) {
            readFromSpare += read;
        }
        return readFromSpare > 0 ? fixUp(bArr, i, readFromSpare) : readFromSpare;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    private int readFromSpare(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.spare;
        if (bArr2 == null) {
            return 0;
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("Asked to read 0 bytes");
        }
        if (bArr2.length <= i2) {
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            int length = this.spare.length;
            this.spare = null;
            return length;
        }
        int length2 = bArr2.length - i2;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr, i, i2);
        System.arraycopy(this.spare, i2, bArr3, 0, length2);
        this.spare = bArr3;
        return i2;
    }

    private void addToSpare(byte[] bArr, int i, int i2, boolean z) {
        byte[] bArr2 = this.spare;
        if (bArr2 == null) {
            byte[] bArr3 = new byte[i2];
            this.spare = bArr3;
            System.arraycopy(bArr, i, bArr3, 0, i2);
            return;
        }
        byte[] bArr4 = new byte[bArr2.length + i2];
        if (z) {
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            System.arraycopy(bArr, i, bArr4, this.spare.length, i2);
        } else {
            System.arraycopy(bArr, i, bArr4, 0, i2);
            byte[] bArr5 = this.spare;
            System.arraycopy(bArr5, 0, bArr4, i2, bArr5.length);
        }
        this.spare = bArr4;
    }

    private int fixUp(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = 0;
        while (true) {
            if (i4 >= detect.length - 1) {
                break;
            }
            int i5 = ((i + i2) - 1) - i4;
            if (i5 >= 0) {
                boolean z = true;
                for (int i6 = 0; i6 <= i4 && z; i6++) {
                    if (bArr[i5 + i6] != detect[i6]) {
                        z = false;
                    }
                }
                if (z) {
                    addToSpare(bArr, i5, i4 + 1, true);
                    i2 = (i2 - 1) - i4;
                    break;
                }
            }
            i4++;
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i;
        while (true) {
            i3 = i + i2;
            if (i7 > i3 - detect.length) {
                break;
            }
            int i8 = 0;
            boolean z2 = true;
            while (true) {
                byte[] bArr2 = detect;
                if (i8 >= bArr2.length || !z2) {
                    break;
                }
                if (bArr[i7 + i8] != bArr2[i8]) {
                    z2 = false;
                }
                i8++;
            }
            if (z2) {
                arrayList.add(Integer.valueOf(i7));
            }
            i7++;
        }
        if (arrayList.size() == 0) {
            return i2;
        }
        int size = arrayList.size() + i3;
        int length = size - bArr.length;
        if (length > 0) {
            Iterator it = arrayList.iterator();
            int i9 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int intValue = ((Integer) it.next()).intValue();
                if (intValue > ((i3 - detect.length) - length) - i9) {
                    length = ((size - intValue) - 1) - i9;
                    break;
                }
                i9++;
            }
            addToSpare(bArr, i3 - length, length, false);
            i2 -= length;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            int intValue2 = ((Integer) arrayList.get(size2)).intValue();
            if (intValue2 < i2 + i && intValue2 <= i2 - 3) {
                int i10 = (i2 - intValue2) - 3;
                byte[] bArr3 = new byte[i10];
                int i11 = intValue2 + 3;
                System.arraycopy(bArr, i11, bArr3, 0, i10);
                bArr[i11] = UsbCameraHandler.MSG_ID_VISION_ERROR;
                System.arraycopy(bArr3, 0, bArr, intValue2 + 4, i10);
                i2++;
            }
        }
        return i2;
    }
}
