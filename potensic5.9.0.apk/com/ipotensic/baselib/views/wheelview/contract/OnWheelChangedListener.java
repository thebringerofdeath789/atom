package com.ipotensic.baselib.views.wheelview.contract;

import com.ipotensic.baselib.views.wheelview.widget.WheelView;

/* loaded from: classes2.dex */
public interface OnWheelChangedListener {
    void onWheelLoopFinished(WheelView wheelView);

    void onWheelScrollStateChanged(WheelView wheelView, int i);

    void onWheelScrolled(WheelView wheelView, int i);

    void onWheelSelected(WheelView wheelView, int i);
}