package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

@Internal
/* loaded from: classes4.dex */
class CodePageString {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) CodePageString.class);
    private byte[] _value;

    CodePageString(byte[] bArr, int i) {
        int i2 = LittleEndian.getInt(bArr, i);
        int i3 = i + 4;
        byte[] byteArray = LittleEndian.getByteArray(bArr, i3, i2);
        this._value = byteArray;
        if (i2 == 0 || byteArray[i2 - 1] == 0) {
            return;
        }
        logger.log(5, "CodePageString started at offset #" + i3 + " is not NULL-terminated");
    }

    CodePageString(String str, int i) throws UnsupportedEncodingException {
        setJavaValue(str, i);
    }

    String getJavaValue(int i) throws UnsupportedEncodingException {
        String stringFromCodePage;
        if (i == -1) {
            stringFromCodePage = new String(this._value);
        } else {
            stringFromCodePage = CodePageUtil.getStringFromCodePage(this._value, i);
        }
        int indexOf = stringFromCodePage.indexOf(0);
        if (indexOf == -1) {
            logger.log(5, "String terminator (\\0) for CodePageString property value not found.Continue without trimming and hope for the best.");
            return stringFromCodePage;
        }
        if (indexOf != stringFromCodePage.length() - 1) {
            logger.log(5, "String terminator (\\0) for CodePageString property value occured before the end of string. Trimming and hope for the best.");
        }
        return stringFromCodePage.substring(0, indexOf);
    }

    int getSize() {
        return this._value.length + 4;
    }

    void setJavaValue(String str, int i) throws UnsupportedEncodingException {
        String str2 = str + "\u0000";
        if (i == -1) {
            this._value = str2.getBytes();
        } else {
            this._value = CodePageUtil.getBytesInCodePage(str2, i);
        }
    }

    int write(OutputStream outputStream) throws IOException {
        LittleEndian.putInt(this._value.length, outputStream);
        outputStream.write(this._value);
        return this._value.length + 4;
    }
}
