package com.ipotensic.baselib.views.wheelview.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface ScrollState {
    public static final int DRAGGING = 1;
    public static final int IDLE = 0;
    public static final int SCROLLING = 2;
}