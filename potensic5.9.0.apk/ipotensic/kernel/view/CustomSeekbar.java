package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes2.dex */
public class CustomSeekbar extends SeekBar {
    private int defaultValue;
    private int max;
    private int min;
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener;

    public CustomSeekbar(Context context) {
        super(context);
    }

    public CustomSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomSeekbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomSeekbar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setLimit(int i, int i2, int i3) {
        this.max = i;
        this.defaultValue = i2;
        this.min = i3;
        setMax(i - i3);
    }

    public int getLimitMin() {
        return this.min;
    }

    public int getLimitMax() {
        return this.max;
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public void setValue(int i) {
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        int i3 = this.min;
        if (i < i3) {
            i = i3;
        }
        setProgress(i - i3);
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.seekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(this, i, false);
        }
    }

    public int getValue() {
        return getProgress() + this.min;
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener);
        this.seekBarChangeListener = onSeekBarChangeListener;
    }
}