package com.ipotensic.baselib.guide.listener;

import com.ipotensic.baselib.guide.core.Controller;

/* loaded from: classes2.dex */
public interface OnGuideChangedListener {
    void onRemoved(Controller controller);

    void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4);

    void onShowed(Controller controller);
}
