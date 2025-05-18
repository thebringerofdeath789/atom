package com.ipotensic.kernel.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.ipotensic.kernel.R;
import org.apache.commons.net.nntp.NNTPReply;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes2.dex */
public class AnimationUtil {
    public static void transInBottom(View view) {
        transInBottom(view, NNTPReply.SERVICE_DISCONTINUED);
    }

    public static void transInBottom(final View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_bottom);
        loadAnimation.setDuration(i);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
    }

    public static void transOutBottom(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_bottom);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.2
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
    }

    public static void transInTop(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_top);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
    }

    public static void transInTop(final View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_top);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        loadAnimation.setDuration(i);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
    }

    public static void transInTop(View view, Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_top);
        view.startAnimation(loadAnimation);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        loadAnimation.setAnimationListener(animationListener);
    }

    public static void transOutTop(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_top);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(8);
            }
        });
    }

    public static void transOutTop(View view, Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_top);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(animationListener);
    }

    public static void transInLeft(View view) {
        transInLeft(view, NNTPReply.SERVICE_DISCONTINUED);
    }

    public static void transSpringBack(View view, Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_left);
        loadAnimation.setDuration(400L);
        loadAnimation.setInterpolator(new OvershootInterpolator(0.8f));
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(animationListener);
    }

    public static void transInLeft(final View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_left);
        loadAnimation.setDuration(i);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
    }

    public static void transOutLeft(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_left);
        loadAnimation.setDuration(400L);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(8);
            }
        });
    }

    public static void transInRight(View view) {
        transInRight(view, NNTPReply.SERVICE_DISCONTINUED);
    }

    public static void transInRight(final View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_right);
        loadAnimation.setDuration(i);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
    }

    public static void transOutRight(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_right);
        loadAnimation.setDuration(400L);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(8);
            }
        });
    }

    public static void transOutRight(final View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_right);
        loadAnimation.setDuration(i);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(8);
            }
        });
    }

    public static void selfRotate(View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.rotate_self_repeat);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.utils.AnimationUtil.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public static void selfRotateRepeat(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        view.startAnimation(rotateAnimation);
    }

    public static void fadeOut(View view, int i, int i2, int i3, int i4, Animation.AnimationListener animationListener) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(i, i3, i2, i4);
        long j = IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR;
        translateAnimation.setDuration(j);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.25f, 1.0f, 0.25f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(j);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        view.startAnimation(animationSet);
        animationSet.setAnimationListener(animationListener);
    }

    public static Animation enterAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    public static Animation exitAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    public static Animation splashScreenAlpha() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(150L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    public static Animation getTwinkleAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(333L);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        return alphaAnimation;
    }

    public static void alphaIn(View view, int i, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i);
        alphaAnimation.setAnimationListener(animationListener);
        view.startAnimation(alphaAnimation);
    }

    public static void alphaOut(View view, int i, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i);
        alphaAnimation.setAnimationListener(animationListener);
        view.startAnimation(alphaAnimation);
    }

    public static void scaleMin(View view, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(100.0f, 100.0f, 20.0f, 20.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setAnimationListener(animationListener);
        view.startAnimation(scaleAnimation);
    }
}