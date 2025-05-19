package com.ipotensic.baselib.notchtools.helper;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.ipotensic.baselib.notchtools.NotchTools;
import org.apache.commons.net.bsd.RCommandClient;

/* loaded from: classes2.dex */
public class NotchStatusBarUtils {
    public static boolean sShowNavigation = true;
    private static int statusBarHeight = -1;

    public static int getStatusBarHeight(Context context) {
        int identifier;
        int i = statusBarHeight;
        if (i != -1) {
            return i;
        }
        if (i <= 0 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
        }
        return statusBarHeight;
    }

    public static void setFullScreenWithSystemUi(final Window window, boolean z) {
        int i = (Build.VERSION.SDK_INT < 16 || sShowNavigation) ? 0 : RCommandClient.DEFAULT_PORT;
        if (Build.VERSION.SDK_INT >= 19) {
            i |= 4096;
        }
        window.getDecorView().setSystemUiVisibility(i);
        if (z) {
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i2) {
                    if (i2 == 0) {
                        NotchStatusBarUtils.setFullScreenWithSystemUi(window, false);
                    }
                }
            });
        }
    }

    public static void setFullScreenWithSystemUiDialog(final Window window, boolean z) {
        int i;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 1024;
        window.setAttributes(attributes);
        if (Build.VERSION.SDK_INT >= 16) {
            i = AnalyticsListener.EVENT_VIDEO_SIZE_CHANGED;
            if (!sShowNavigation) {
                i = 1542;
            }
        } else {
            i = 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            i |= 4096;
        }
        window.getDecorView().setSystemUiVisibility(i);
        if (z) {
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i2) {
                    if (i2 == 0) {
                        NotchStatusBarUtils.setFullScreenWithSystemUiDialog(window, false);
                    }
                }
            });
        }
    }

    public static void setFakeNotchView(Window window) {
        ViewGroup removeFakeNotchView = removeFakeNotchView(window);
        if (removeFakeNotchView == null) {
            return;
        }
        View view = new View(window.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, NotchTools.getFullScreenTools().getNotchHeight(window)));
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        removeFakeNotchView.addView(view);
    }

    public static ViewGroup removeFakeNotchView(Window window) {
        ViewGroup notchContainer = getNotchContainer(window);
        if (notchContainer == null) {
            return null;
        }
        if (notchContainer.getChildCount() > 0) {
            notchContainer.removeAllViews();
        }
        return notchContainer;
    }

    public static ViewGroup getNotchContainer(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return (ViewGroup) decorView.findViewWithTag(NotchTools.NOTCH_CONTAINER);
    }
}
