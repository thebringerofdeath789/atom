package com.logan.usb.utils;

import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public class FileReceiver {
    private File downloadFile;
    private boolean isLrv = false;
    private long length = 0;
    private FileOutputStream outputStream;

    public FileReceiver(File file) {
        this.downloadFile = file;
    }

    public boolean isLrv() {
        return this.isLrv;
    }

    public void setLrv(boolean z) {
        this.isLrv = z;
    }

    public void receive(byte[] bArr, int i, int i2) throws Exception {
        if (this.outputStream == null) {
            this.outputStream = new FileOutputStream(this.downloadFile);
        }
        this.outputStream.write(bArr, i, i2);
        this.length += i2;
        this.outputStream.flush();
    }

    public void interrupt() {
        finish();
        if (this.downloadFile.exists()) {
            this.downloadFile.delete();
            this.downloadFile = null;
        }
    }

    public void finish() {
        try {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.outputStream = null;
            }
        } catch (Exception unused) {
        }
    }

    public long getLength() {
        return this.length;
    }

    public File getFile() {
        return this.downloadFile;
    }
}