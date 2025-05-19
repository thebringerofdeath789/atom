package com.ipotensic.baselib.guide.model;

import android.graphics.RectF;
import android.view.View;
import com.ipotensic.baselib.guide.model.HighLight;

/* loaded from: classes2.dex */
public class HighlightRectF implements HighLight {
    private HighlightOptions options;
    private RectF rectF;
    private int round;
    private HighLight.Shape shape;

    public HighlightRectF(RectF rectF, HighLight.Shape shape, int i) {
        this.rectF = rectF;
        this.shape = shape;
        this.round = i;
    }

    public void setOptions(HighlightOptions highlightOptions) {
        this.options = highlightOptions;
    }

    @Override // com.ipotensic.baselib.guide.model.HighLight
    public HighLight.Shape getShape() {
        return this.shape;
    }

    @Override // com.ipotensic.baselib.guide.model.HighLight
    public RectF getRectF(View view) {
        return this.rectF;
    }

    @Override // com.ipotensic.baselib.guide.model.HighLight
    public float getRadius() {
        return Math.min(this.rectF.width() / 2.0f, this.rectF.height() / 2.0f);
    }

    @Override // com.ipotensic.baselib.guide.model.HighLight
    public int getRound() {
        return this.round;
    }

    @Override // com.ipotensic.baselib.guide.model.HighLight
    public HighlightOptions getOptions() {
        return this.options;
    }
}
