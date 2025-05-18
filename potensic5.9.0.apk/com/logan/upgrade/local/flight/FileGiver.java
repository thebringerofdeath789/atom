package com.logan.upgrade.local.flight;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.JniUtils;
import com.logan.upgrade.local.flight.send.SendFwFileData;

/* loaded from: classes3.dex */
public class FileGiver {
    private byte[] buffer;
    private int checkCode;
    private SendFwFileData fileData;
    private int fileLength;
    private boolean isFileOpened;
    private int packageLength;
    private int readIndex = 0;

    public FileGiver(String str, int i) {
        this.packageLength = i;
        boolean openFile = JniUtils.openFile(str);
        this.isFileOpened = openFile;
        if (openFile) {
            this.fileLength = JniUtils.getFileLength();
            this.checkCode = JniUtils.getFileCheckCode();
            DDLog.m1687i("checkCode:" + ParseUtil.byteToHexString(ParseUtil.intBigByteArr(this.checkCode)));
        }
    }

    public int getFileLength() {
        return this.fileLength;
    }

    public int getCheckCode() {
        return this.checkCode;
    }

    public long getUnsignedCheckCode() {
        return this.checkCode & 4294967295L;
    }

    public SendFwFileData readFile() throws Exception {
        if (this.buffer == null) {
            this.buffer = new byte[this.packageLength];
        }
        int readBinFile = JniUtils.readBinFile(this.buffer, this.packageLength);
        if (readBinFile <= 0) {
            return null;
        }
        if (this.fileData == null) {
            this.fileData = new SendFwFileData();
        }
        if (readBinFile < this.packageLength) {
            this.fileData.init(this.buffer, (short) this.readIndex, (short) readBinFile, true);
            this.readIndex = 0;
        } else {
            this.fileData.init(this.buffer, (short) this.readIndex, (short) readBinFile, false);
            this.readIndex++;
        }
        return this.fileData;
    }
}