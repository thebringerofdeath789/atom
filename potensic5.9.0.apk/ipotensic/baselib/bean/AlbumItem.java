package com.ipotensic.baselib.bean;

/* loaded from: classes2.dex */
public class AlbumItem {
    public boolean isVideo;
    public String url;
    public String videoThumbnailUrl;

    public AlbumItem(boolean z, String str) {
        this.isVideo = z;
        this.url = str;
    }

    public void setVideoThumbnailUrl(String str) {
        this.videoThumbnailUrl = str;
    }
}