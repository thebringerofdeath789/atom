package com.ipotensic.baselib.listener;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class AlphaClickListener implements View.OnClickListener {
    private final int ANIM_TIME;
    private int VALID_TIME;
    private long firstClickTime;

    public abstract void click(View view);

    public AlphaClickListener() {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.firstClickTime = 0L;
    }

    public AlphaClickListener(Integer num) {
        this.ANIM_TIME = 150;
        this.VALID_TIME = 300;
        this.firstClickTime = 0L;
        this.VALID_TIME = num.intValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        if (this.firstClickTime > System.currentTimeMillis()) {
            this.firstClickTime = 0L;
        }
        if (System.currentTimeMillis() - this.firstClickTime > this.VALID_TIME) {
            click(view);
            view.animate().alpha(0.6f).setDuration(150L).withEndAction(new Runnable() { // from class: com.ipotensic.baselib.listener.AlphaClickListener.1
                @Override // java.lang.Runnable
                public void run() {
                    view.animate().alpha(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.ipotensic.baselib.listener.AlphaClickListener.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.clearAnimation();
                        }
                    }).start();
                }
            }).start();
            this.firstClickTime = System.currentTimeMillis();
        }
    }
}