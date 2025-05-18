package com.ipotensic.baselib.guide.model;

import android.graphics.RectF;
import android.view.View;

/* loaded from: classes2.dex */
public interface HighLight {

    public enum Shape {
        CIRCLE,
        RECTANGLE,
        OVAL,
        ROUND_RECTANGLE
    }

    HighlightOptions getOptions();

    float getRadius();

    RectF getRectF(View view);

    int getRound();

    Shape getShape();
}