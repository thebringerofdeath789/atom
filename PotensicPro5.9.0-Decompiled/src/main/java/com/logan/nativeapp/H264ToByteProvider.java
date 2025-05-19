package com.logan.nativeapp;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class H264ToByteProvider {
    private byte[] fileData = null;
    private ArrayList<Frame> frames = new ArrayList<>();
    private int headIndex = -1;

    public interface OnParseListener {
        void onParse(Frame frame);
    }

    public void init(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                this.fileData = bArr;
                fileInputStream.read(bArr);
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void parse() {
        int i;
        for (int i2 = 0; i2 < this.fileData.length - 4; i2++) {
            if (isHead(i2)) {
                int i3 = this.headIndex;
                if (i3 != -1) {
                    int i4 = i2 - i3;
                    byte[] bArr = new byte[i4];
                    System.arraycopy(this.fileData, i3, bArr, 0, i4);
                    this.frames.add(new Frame(bArr));
                }
                this.headIndex = i2;
            }
            byte[] bArr2 = this.fileData;
            if (i2 == bArr2.length - 5 && (i = this.headIndex) != -1) {
                int length = bArr2.length - i;
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr2, i, bArr3, 0, length);
                this.frames.add(new Frame(bArr3));
            }
        }
    }

    private boolean isHead(int i) {
        byte[] bArr = this.fileData;
        return bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1;
    }

    public ArrayList<Frame> getFrames() {
        return this.frames;
    }
}
