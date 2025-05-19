package com.ipotensic.kernel.view.mapscaleview;

/* loaded from: classes2.dex */
class Scale {
    private final float length;
    private final String text;

    Scale(String str, float f) {
        this.text = str;
        this.length = f;
    }

    public String text() {
        return this.text;
    }

    public float length() {
        return this.length;
    }
}
