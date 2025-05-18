package com.ipotensic.kernel.view.mapscaleview;

/* loaded from: classes2.dex */
class Scales {
    private final Scale bottom;
    private final Scale top;

    Scales(Scale scale, Scale scale2) {
        this.top = scale;
        this.bottom = scale2;
    }

    public Scale top() {
        return this.top;
    }

    public Scale bottom() {
        return this.bottom;
    }
}