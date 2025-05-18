package com.p019gs.keyboard;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
class KeyboardAttribute {
    public Drawable chooserBackground;
    public ColorStateList chooserSelectedColor;
    public ColorStateList chooserUnselectedColor;
    public boolean isKeyPreview;
    public Drawable keyboardBackground;

    public KeyboardAttribute(ColorStateList colorStateList, ColorStateList colorStateList2, Drawable drawable, Drawable drawable2, boolean z) {
        this.chooserSelectedColor = colorStateList;
        this.chooserUnselectedColor = colorStateList2;
        this.chooserBackground = drawable;
        this.keyboardBackground = drawable2;
        this.isKeyPreview = z;
    }
}