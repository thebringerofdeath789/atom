package com.logan.camera.data;

import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.UnitUtil;
import com.logan.camera.RemoteFileManager;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class MediaInfoData extends BaseData implements Serializable {
    private String createtime;
    private long downloadBytes;
    private String filename;
    private long filesize;
    private int filetime;
    private String format;
    private double fps;
    private int height;
    private boolean isVideo;
    private long lrv_filesize;
    private int width;

    public boolean isVideo() {
        return this.isVideo;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String str) {
        this.filename = str;
        if (str.endsWith(RemoteFileManager.VIDEO_SUFFIX) || str.endsWith(".mp4") || str.endsWith("LRV") || str.endsWith("lrv")) {
            this.isVideo = true;
        }
    }

    public void setVideo(boolean z) {
        this.isVideo = z;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public void setFilesize(long j) {
        this.filesize = j;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public long getCreateTime() {
        try {
            return FormatUtil.getMillisTime1(this.createtime);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getFiletime() {
        return this.filetime;
    }

    public void setFiletime(int i) {
        this.filetime = i;
    }

    public double getFps() {
        return UnitUtil.round((float) this.fps);
    }

    public void setFps(double d) {
        this.fps = d;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public long getDownloadBytes() {
        return this.downloadBytes;
    }

    public void setDownloadBytes(long j) {
        this.downloadBytes = j;
    }

    public long getLrv_filesize() {
        return this.lrv_filesize;
    }

    public void setLrv_filesize(long j) {
        this.lrv_filesize = j;
    }

    public String toString() {
        return "MediaInfoData{isVideo=" + this.isVideo + ", filename='" + this.filename + "', filesize=" + this.filesize + ", createtime='" + this.createtime + "', width=" + this.width + ", height=" + this.height + ", filetime=" + this.filetime + ", fps=" + this.fps + '}';
    }
}