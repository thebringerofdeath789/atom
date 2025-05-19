package com.mapbox.mapboxsdk.annotations;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.PopupWindow;

@Deprecated
/* loaded from: classes3.dex */
class BubblePopupHelper {
    BubblePopupHelper() {
    }

    static PopupWindow create(Context context, BubbleLayout bubbleLayout) {
        Drawable drawable;
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(bubbleLayout);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = context.getDrawable(com.mapbox.mapboxsdk.R.drawable.mapbox_popup_window_transparent);
        } else {
            drawable = context.getResources().getDrawable(com.mapbox.mapboxsdk.R.drawable.mapbox_popup_window_transparent);
        }
        popupWindow.setBackgroundDrawable(drawable);
        return popupWindow;
    }
}
