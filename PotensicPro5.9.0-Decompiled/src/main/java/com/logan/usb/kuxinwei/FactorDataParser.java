package com.logan.usb.kuxinwei;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.usb.parser_new.Buffer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FactorDataParser {
    private static volatile FactorDataParser instance;
    private OnFactoryDataResultListener resultListener;
    private final int HEAD_LEN = 15;
    private final Buffer usbBuffer = new Buffer(204800);

    public interface OnFactoryDataResultListener {
        void onDataOutput(byte[] bArr);
    }

    private FactorDataParser() {
    }

    public static FactorDataParser get() {
        if (instance == null) {
            synchronized (FactorDataParser.class) {
                if (instance == null) {
                    FactorDataParser factorDataParser = new FactorDataParser();
                    instance = factorDataParser;
                    return factorDataParser;
                }
            }
        }
        return instance;
    }

    public static void main(String[] strArr) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test.aaa");
        int available = fileInputStream.available();
        byte[] bArr = new byte[available];
        fileInputStream.read(bArr);
        fileInputStream.close();
        final FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test\\test.h264");
        get().setResultListener(new OnFactoryDataResultListener() { // from class: com.logan.usb.kuxinwei.FactorDataParser.1
            @Override // com.logan.usb.kuxinwei.FactorDataParser.OnFactoryDataResultListener
            public void onDataOutput(byte[] bArr2) {
                try {
                    fileOutputStream.write(bArr2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        int i = -1;
        for (int i2 = 0; i2 < available - 5; i2++) {
            if (isFactoryData(bArr, i2)) {
                if (i != -1) {
                    int i3 = i2 - i;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i, bArr2, 0, i3);
                    System.out.println(ParseUtil.byteToHexString(bArr2));
                    System.out.println(i3);
                    get().parse(bArr2, i3);
                }
                i = i2;
            }
        }
    }

    public void setResultListener(OnFactoryDataResultListener onFactoryDataResultListener) {
        this.resultListener = onFactoryDataResultListener;
    }

    public void parse(byte[] bArr, int i) {
        this.usbBuffer.write(bArr, i);
        byte[] data = this.usbBuffer.getData();
        int i2 = 0;
        int i3 = -1;
        while (i2 < this.usbBuffer.getWriteIndex() - 15) {
            if (isFactoryData(data, i2) && i > 15) {
                int signedShortFromByteArr = ParseUtil.getSignedShortFromByteArr(data, i2 + 5);
                int i4 = i2 + 15;
                int i5 = (i4 + signedShortFromByteArr) - 1;
                if (i5 <= this.usbBuffer.getWriteIndex()) {
                    byte[] bArr2 = new byte[signedShortFromByteArr];
                    System.arraycopy(data, i4, bArr2, 0, signedShortFromByteArr);
                    OnFactoryDataResultListener onFactoryDataResultListener = this.resultListener;
                    if (onFactoryDataResultListener != null) {
                        onFactoryDataResultListener.onDataOutput(bArr2);
                    }
                    System.out.println(i5);
                    i2 = i5;
                    i3 = i2;
                }
            }
            i2++;
        }
        if (i3 != -1) {
            this.usbBuffer.discard(i3);
        }
    }

    public static boolean isFactoryData(byte[] bArr, int i) {
        return i + 5 <= bArr.length && bArr[i] == -1 && bArr[i + 1] == -91 && bArr[i + 2] == -86 && bArr[i + 3] == 90 && bArr[i + 4] == -1;
    }
}
