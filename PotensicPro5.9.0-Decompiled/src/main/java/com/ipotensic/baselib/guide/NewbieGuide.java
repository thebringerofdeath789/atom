package com.ipotensic.baselib.guide;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import com.ipotensic.baselib.guide.core.Builder;

/* loaded from: classes2.dex */
public class NewbieGuide {
    public static final int FAILED = -1;
    public static final int SUCCESS = 1;
    public static final String TAG = "NewbieGuide";

    public static Builder with(Activity activity) {
        return new Builder(activity);
    }

    public static Builder with(Fragment fragment) {
        return new Builder(fragment);
    }

    public static Builder with(androidx.fragment.app.Fragment fragment) {
        return new Builder(fragment);
    }

    public static void resetLabel(Context context, String str) {
        context.getSharedPreferences(TAG, 0).edit().putInt(str, 0).apply();
    }
}
