package com.ipotensic.baselib;

import com.ipotensic.baselib.enums.FileTypeEnum;
import com.ipotensic.baselib.utils.FormatUtil;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class LocalFile implements Serializable {
    private String absPath;
    private int childNum;
    private long createTime;
    private long duration;
    private String durationFormatStr;
    private FileTypeEnum fileTypeEnum;
    public int height;
    private boolean isSelect = false;
    public int left;
    private long size;
    public int top;
    public int width;

    public LocalFile(FileTypeEnum fileTypeEnum, long j) {
        this.fileTypeEnum = fileTypeEnum;
        this.createTime = j;
    }

    public LocalFile(FileTypeEnum fileTypeEnum, String str, long j, long j2) {
        this.fileTypeEnum = fileTypeEnum;
        this.absPath = str;
        this.size = j;
        this.createTime = j2;
    }

    public LocalFile(FileTypeEnum fileTypeEnum, String str, long j, long j2, long j3) {
        this.fileTypeEnum = fileTypeEnum;
        this.absPath = str;
        this.size = j;
        this.createTime = j3;
        j2 = j2 % 1000 >= 500 ? j2 + 1000 : j2;
        this.duration = j2;
        this.durationFormatStr = FormatUtil.formatDuration(j2);
    }

    public int getChildNum() {
        return this.childNum;
    }

    public void setChildNum(int i) {
        this.childNum = i;
    }

    public String getAbsPath() {
        return this.absPath;
    }

    public long getSize() {
        return this.size;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public FileTypeEnum getFileTypeEnum() {
        return this.fileTypeEnum;
    }

    public String getDurationFormatStr() {
        return this.durationFormatStr;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public String toString() {
        return "LocalFile{absPath='" + this.absPath + "', size=" + this.size + ", duration=" + this.duration + ", durationFormatStr='" + this.durationFormatStr + "', createTime=" + this.createTime + ", fileTypeEnum=" + this.fileTypeEnum + ", childNum=" + this.childNum + ", isSelect=" + this.isSelect + ", width=" + this.width + ", height=" + this.height + ", left=" + this.left + ", top=" + this.top + '}';
    }
}