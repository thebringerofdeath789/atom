package com.ipotensic.baselib.listener;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class CustomClickListener implements View.OnTouchListener {
    private long downTime;
    private float lastX;
    private float lastY;
    private final int TOUCH_SLOP = 30;
    private final int LONG_TIMEOUT = 800;
    private final int SHORT_TIMEOUT = 800;
    private Runnable longClickRunnable = new Runnable() { // from class: com.ipotensic.baselib.listener.CustomClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            CustomClickListener.this.onLongClicked();
        }
    };

    public abstract void onLongClicked();

    public abstract void onShortClicked();

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastX = x;
            this.lastY = y;
            view.postDelayed(this.longClickRunnable, 800L);
            this.downTime = System.currentTimeMillis();
        } else if (action == 1) {
            view.removeCallbacks(this.longClickRunnable);
            if (System.currentTimeMillis() - this.downTime <= 800) {
                onShortClicked();
            }
        } else if (action != 2) {
            if (action == 3) {
                view.removeCallbacks(this.longClickRunnable);
            }
        } else if (Math.abs(this.lastX - x) > 30.0f || Math.abs(this.lastY - y) > 30.0f) {
            view.removeCallbacks(this.longClickRunnable);
        }
        return true;
    }
}
