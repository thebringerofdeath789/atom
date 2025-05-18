package com.atom.common.extensions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* compiled from: ContextExtends.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\b\u001a\u00020\u000b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\u000b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\r\u001a\u00020\u000b*\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000bJ\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000bJ\n\u0010\u0012\u001a\u00020\u0007*\u00020\u0005J\n\u0010\u0013\u001a\u00020\u000b*\u00020\u0005J\n\u0010\u0014\u001a\u00020\u000b*\u00020\u0005J\n\u0010\u0015\u001a\u00020\u000b*\u00020\u0005J\n\u0010\u0016\u001a\u00020\u000b*\u00020\u0005J\u0012\u0010\u0017\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\t¨\u0006\u0019"}, m2338d2 = {"Lcom/atom/common/extensions/ContextExtends;", "", "()V", "copyToBoard", "", "Landroid/content/Context;", "text", "", "dpToPx", "", "dpValue", "", "dpToSp", "getColorCompat", TtmlNode.ATTR_ID, "getDimensionCompat", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "getFileProviderAuthority", "getRealHeight", "getRealWidth", "getScreenHeight", "getScreenWidth", "pxToDp", "px", "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class ContextExtends {
    public static final ContextExtends INSTANCE = new ContextExtends();

    private ContextExtends() {
    }

    public final int getScreenWidth(Context getScreenWidth) {
        Intrinsics.checkParameterIsNotNull(getScreenWidth, "$this$getScreenWidth");
        Object systemService = getScreenWidth.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int getScreenHeight(Context getScreenHeight) {
        Intrinsics.checkParameterIsNotNull(getScreenHeight, "$this$getScreenHeight");
        Object systemService = getScreenHeight.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int getRealWidth(Context getRealWidth) {
        Intrinsics.checkParameterIsNotNull(getRealWidth, "$this$getRealWidth");
        Object systemService = getRealWidth.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            Object invoke = Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception unused) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return displayMetrics2.widthPixels;
        }
    }

    public final int getRealHeight(Context getRealHeight) {
        Intrinsics.checkParameterIsNotNull(getRealHeight, "$this$getRealHeight");
        Object systemService = getRealHeight.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            Object invoke = Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception unused) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return displayMetrics2.heightPixels;
        }
    }

    public final float pxToDp(Context pxToDp, float f) {
        Intrinsics.checkParameterIsNotNull(pxToDp, "$this$pxToDp");
        Resources resources = pxToDp.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return f / resources.getDisplayMetrics().density;
    }

    public final int dpToPx(Context dpToPx, int i) {
        Intrinsics.checkParameterIsNotNull(dpToPx, "$this$dpToPx");
        Resources resources = dpToPx.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) ((i * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final float dpToPx(Context dpToPx, float f) {
        Intrinsics.checkParameterIsNotNull(dpToPx, "$this$dpToPx");
        Resources resources = dpToPx.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return f * resources.getDisplayMetrics().density;
    }

    public final int dpToSp(Context dpToSp, int i) {
        Intrinsics.checkParameterIsNotNull(dpToSp, "$this$dpToSp");
        Resources resources = dpToSp.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) ((i * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final float dpToSp(Context dpToSp, float f) {
        Intrinsics.checkParameterIsNotNull(dpToSp, "$this$dpToSp");
        Resources resources = dpToSp.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return f * resources.getDisplayMetrics().scaledDensity;
    }

    public final int getColorCompat(Context getColorCompat, int i) {
        Intrinsics.checkParameterIsNotNull(getColorCompat, "$this$getColorCompat");
        return ContextCompat.getColor(getColorCompat, i);
    }

    public final int getDimensionCompat(Context getDimensionCompat, int i) {
        Intrinsics.checkParameterIsNotNull(getDimensionCompat, "$this$getDimensionCompat");
        return getDimensionCompat.getResources().getDimensionPixelSize(i);
    }

    public final Drawable getDrawableCompat(Context getDrawableCompat, int i) {
        Intrinsics.checkParameterIsNotNull(getDrawableCompat, "$this$getDrawableCompat");
        return ResourcesCompat.getDrawable(getDrawableCompat.getResources(), i, null);
    }

    public final String getFileProviderAuthority(Context getFileProviderAuthority) {
        Intrinsics.checkParameterIsNotNull(getFileProviderAuthority, "$this$getFileProviderAuthority");
        try {
            PackageInfo packageInfo = getFileProviderAuthority.getPackageManager().getPackageInfo(getFileProviderAuthority.getPackageName(), 8);
            Intrinsics.checkExpressionValueIsNotNull(packageInfo, "this.packageManager.getP…ageManager.GET_PROVIDERS)");
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr.length <= 0) {
                return "com.ipotensic.atom.fileprovider";
            }
            String str = providerInfoArr[0].authority;
            Intrinsics.checkExpressionValueIsNotNull(str, "provider.authority");
            return str;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "com.ipotensic.atom.fileprovider";
        }
    }

    public final void copyToBoard(Context copyToBoard, String text) {
        Intrinsics.checkParameterIsNotNull(copyToBoard, "$this$copyToBoard");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Object systemService = copyToBoard.getSystemService("clipboard");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(AnnotatedPrivateKey.LABEL, text));
    }
}