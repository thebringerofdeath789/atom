package com.ipotensic.baselib.xtoast;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public interface OnTouchListener<V extends View> {
    boolean onTouch(XToast xToast, V v, MotionEvent motionEvent);
}