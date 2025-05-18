package com.ipotensic.kernel.utils;

import android.view.View;
import android.view.animation.Animation;

/* loaded from: classes2.dex */
public class ScreenShotUtil {
    private static ScreenShotUtil instance;

    public static ScreenShotUtil getInstance() {
        if (instance == null) {
            synchronized (ScreenShotUtil.class) {
                if (instance == null) {
                    ScreenShotUtil screenShotUtil = new ScreenShotUtil();
                    instance = screenShotUtil;
                    return screenShotUtil;
                }
            }
        }
        return instance;
    }

    public void flashScreen(final View view) {
        view.setVisibility(0);
        Animation splashScreenAlpha = AnimationUtil.splashScreenAlpha();
        splashScreenAlpha.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.ScreenShotUtil.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }
        });
        view.startAnimation(splashScreenAlpha);
    }
}