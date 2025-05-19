package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

@Internal
/* loaded from: classes4.dex */
class ClipboardData {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) ClipboardData.class);
    private int _format;
    private byte[] _value;

    ClipboardData(byte[] bArr, int i) {
        int i2 = LittleEndian.getInt(bArr, i);
        if (i2 < 4) {
            logger.log(5, "ClipboardData at offset ", Integer.valueOf(i), " size less than 4 bytes (doesn't even have format field!). Setting to format == 0 and hope for the best");
            this._format = 0;
            this._value = new byte[0];
        } else {
            this._format = LittleEndian.getInt(bArr, i + 4);
            this._value = LittleEndian.getByteArray(bArr, i + 8, i2 - 4);
        }
    }

    int getSize() {
        return this._value.length + 8;
    }

    byte[] getValue() {
        return this._value;
    }

    byte[] toByteArray() {
        byte[] bArr = new byte[getSize()];
        LittleEndian.putInt(bArr, 0, this._value.length + 4);
        LittleEndian.putInt(bArr, 4, this._format);
        byte[] bArr2 = this._value;
        System.arraycopy(bArr2, 0, bArr, 8, bArr2.length);
        return bArr;
    }

    int write(OutputStream outputStream) throws IOException {
        LittleEndian.putInt(this._value.length + 4, outputStream);
        LittleEndian.putInt(this._format, outputStream);
        outputStream.write(this._value);
        return this._value.length + 8;
    }
}
