package com.ipotensic.kernel.view.blur;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class NoOpController implements BlurController {
    @Override // com.ipotensic.kernel.view.blur.BlurController
    public void destroy() {
    }

    @Override // com.ipotensic.kernel.view.blur.BlurController
    public boolean draw(Canvas canvas) {
        return true;
    }

    @Override // com.ipotensic.kernel.view.blur.BlurViewFacade
    public BlurViewFacade setBlurAutoUpdate(boolean z) {
        return this;
    }

    @Override // com.ipotensic.kernel.view.blur.BlurViewFacade
    public BlurViewFacade setBlurEnabled(boolean z) {
        return this;
    }

    @Override // com.ipotensic.kernel.view.blur.BlurViewFacade
    public BlurViewFacade setBlurRadius(float f) {
        return this;
    }

    @Override // com.ipotensic.kernel.view.blur.BlurViewFacade
    public BlurViewFacade setFrameClearDrawable(Drawable drawable) {
        return this;
    }

    @Override // com.ipotensic.kernel.view.blur.BlurViewFacade
    public BlurViewFacade setOverlayColor(int i) {
        return this;
    }

    @Override // com.ipotensic.kernel.view.blur.BlurController
    public void updateBlurViewSize() {
    }
}