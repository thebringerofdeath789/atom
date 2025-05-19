package com.logan.camera.data;

/* loaded from: classes2.dex */
public class FileNumData extends BaseData {
    private int count;
    private int photo;
    private int video;

    public FileNumData(int i, int i2, int i3) {
        this.count = i;
        this.video = i2;
        this.photo = i3;
    }

    public int getCount() {
        return this.count;
    }

    public int getVideo() {
        return this.video;
    }

    public int getPhoto() {
        return this.photo;
    }
}
