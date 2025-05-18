package com.ipotensic.baselib.mediadataretriever.entity;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public class MediaData implements Serializable {
    private Bitmap frame;
    private Map<MetadataKey, String> metaData;

    public MediaData() {
    }

    public MediaData(Bitmap bitmap, Map<MetadataKey, String> map) {
        this.frame = bitmap;
        this.metaData = map;
    }

    public Bitmap getFrame() {
        return this.frame;
    }

    public void setFrame(Bitmap bitmap) {
        this.frame = bitmap;
    }

    public Map<MetadataKey, String> getMetaData() {
        return this.metaData;
    }

    public void setMetaData(Map<MetadataKey, String> map) {
        this.metaData = map;
    }
}