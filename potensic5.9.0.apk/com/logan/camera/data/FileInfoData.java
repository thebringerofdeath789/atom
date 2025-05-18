package com.logan.camera.data;

import com.ipotensic.baselib.utils.FormatUtil;
import java.text.ParseException;

/* loaded from: classes2.dex */
public class FileInfoData extends BaseData {
    private long createTime;
    private String createTimeStr;
    private String path;
    private long size;
    private long time;

    public FileInfoData(long j, String str, long j2, String str2) {
        this.createTime = -1L;
        this.size = j;
        this.path = str;
        this.time = j2;
        this.createTimeStr = str2;
        try {
            this.createTime = FormatUtil.getMillisTime1(str2);
        } catch (ParseException e) {
            e.printStackTrace();
            this.createTime = -1L;
        }
    }

    public long getSize() {
        return this.size;
    }

    public String getPath() {
        return this.path;
    }

    public long getTime() {
        return this.time;
    }

    public String getCreateTimeStr() {
        return this.createTimeStr;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String toString() {
        return "FileInfoData{size=" + this.size + ", path='" + this.path + "', time=" + this.time + ", createTimeStr='" + this.createTimeStr + "'}";
    }
}