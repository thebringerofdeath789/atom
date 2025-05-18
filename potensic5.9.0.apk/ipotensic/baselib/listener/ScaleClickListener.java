package com.ipotensic.baselib.listener;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class ScaleClickListener implements View.OnClickListener {
    private final int ANIM_TIME;
    private int VALID_TIME;
    private long firstClickTime;
    private float scale;
    private boolean showAnim;

    public abstract void click(View view);

    public ScaleClickListener() {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.scale = 0.9f;
        this.firstClickTime = 0L;
        this.showAnim = true;
    }

    public ScaleClickListener(Integer num) {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.scale = 0.9f;
        this.firstClickTime = 0L;
        this.showAnim = true;
        this.VALID_TIME = num.intValue();
    }

    public ScaleClickListener(boolean z) {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.scale = 0.9f;
        this.firstClickTime = 0L;
        this.showAnim = true;
        this.showAnim = z;
    }

    public ScaleClickListener(Integer num, boolean z) {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.scale = 0.9f;
        this.firstClickTime = 0L;
        this.showAnim = true;
        this.VALID_TIME = num.intValue();
        this.showAnim = z;
    }

    public ScaleClickListener(Integer num, float f) {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.scale = 0.9f;
        this.firstClickTime = 0L;
        this.showAnim = true;
        this.VALID_TIME = num.intValue();
        this.scale = f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        if (this.firstClickTime > System.currentTimeMillis()) {
            this.firstClickTime = 0L;
        }
        if (System.currentTimeMillis() - this.firstClickTime > this.VALID_TIME) {
            click(view);
            if (this.showAnim) {
                view.animate().scaleX(this.scale).scaleY(this.scale).alpha(0.9f).setDuration(150L).withEndAction(new Runnable() { // from class: com.ipotensic.baselib.listener.ScaleClickListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.ipotensic.baselib.listener.ScaleClickListener.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                view.clearAnimation();
                            }
                        }).start();
                    }
                }).start();
            }
            this.firstClickTime = System.currentTimeMillis();
        }
    }
}