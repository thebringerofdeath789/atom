package com.ipotensic.kernel.bean;

/* loaded from: classes2.dex */
public class SoundTip {
    private boolean isPlayFirst;
    private int rawId;
    private int strId;

    public SoundTip(int i, int i2) {
        this.rawId = -1;
        this.isPlayFirst = false;
        this.strId = -1;
        this.rawId = i;
        this.strId = i2;
    }

    public SoundTip(int i, int i2, boolean z) {
        this.rawId = -1;
        this.isPlayFirst = false;
        this.strId = -1;
        this.rawId = i;
        this.strId = i2;
        this.isPlayFirst = z;
    }

    public boolean isPlayFirst() {
        return this.isPlayFirst;
    }

    public int getRawId() {
        return this.rawId;
    }

    public int getStrId() {
        return this.strId;
    }

    public void setRawId(int i) {
        this.rawId = i;
    }

    public void setPlayFirst(boolean z) {
        this.isPlayFirst = z;
    }

    public void setStrId(int i) {
        this.strId = i;
    }
}
