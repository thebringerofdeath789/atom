package com.logan.camera.data;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UsbFileLenData implements Serializable {
    private String createtime;
    private String file;
    private long len;
    private long lrv_len;

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public long getLen() {
        return this.len;
    }

    public void setLen(long j) {
        this.len = j;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public long getLrv_len() {
        return this.lrv_len;
    }

    public void setLrv_len(long j) {
        this.lrv_len = j;
    }

    public String toString() {
        return "UsbFileLenData{file='" + this.file + "', len=" + this.len + ", lrv_len=" + this.lrv_len + ", createtime='" + this.createtime + "'}";
    }
}
