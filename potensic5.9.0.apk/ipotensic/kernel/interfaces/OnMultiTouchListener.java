package com.ipotensic.kernel.interfaces;

import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes2.dex */
public abstract class OnMultiTouchListener implements View.OnTouchListener {
    private long lastTouchTime = 0;
    private final AtomicInteger touchCount = new AtomicInteger(0);

    protected int getMultiTouchInterval() {
        return NNTPReply.SERVICE_DISCONTINUED;
    }

    public abstract void onMultiTouch(View view, MotionEvent motionEvent, int i);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastTouchTime < getMultiTouchInterval()) {
                this.touchCount.incrementAndGet();
                onMultiTouch(view, motionEvent, this.touchCount.get());
            } else {
                this.touchCount.set(1);
            }
            this.lastTouchTime = currentTimeMillis;
        }
        return true;
    }
}