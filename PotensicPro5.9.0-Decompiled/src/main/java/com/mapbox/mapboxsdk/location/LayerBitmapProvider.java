package com.mapbox.mapboxsdk.location;

import android.content.Context;
import android.graphics.Bitmap;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.utils.BitmapUtils;

/* loaded from: classes3.dex */
class LayerBitmapProvider {
    private final Context context;

    LayerBitmapProvider(Context context) {
        this.context = context;
    }

    Bitmap generateBitmap(int i, Integer num) {
        return BitmapUtils.getBitmapFromDrawable(BitmapUtils.getDrawableFromRes(this.context, i, num));
    }

    Bitmap generateShadowBitmap(LocationComponentOptions locationComponentOptions) {
        return Utils.generateShadow(BitmapUtils.getDrawableFromRes(this.context, R.drawable.mapbox_user_icon_shadow), locationComponentOptions.elevation());
    }
}
