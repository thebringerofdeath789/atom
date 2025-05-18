package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleObserver;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class CountDownView extends AppCompatTextView implements LifecycleObserver {
    private String str;
    private String temp;
    private int time;
    private Timer timer;

    static /* synthetic */ int access$010(CountDownView countDownView) {
        int i = countDownView.time;
        countDownView.time = i - 1;
        return i;
    }

    public CountDownView(Context context) {
        this(context, null);
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void startCountDown(final int i) {
        if (this.timer == null) {
            this.time = i;
            String charSequence = getText().toString();
            this.temp = charSequence;
            this.str = charSequence;
            Timer timer = new Timer();
            this.timer = timer;
            timer.schedule(new TimerTask() { // from class: com.ipotensic.kernel.view.CountDownView.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (CountDownView.this.time >= 0) {
                        CountDownView countDownView = CountDownView.this;
                        countDownView.str = String.format(countDownView.temp, Integer.valueOf(CountDownView.this.time));
                        CountDownView.access$010(CountDownView.this);
                        DDLog.e("str: " + CountDownView.this.str);
                        CountDownView.this.postInvalidate();
                        return;
                    }
                    CountDownView.this.stopCountDown();
                    EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_COUNT_DOWN_FINISH, Integer.valueOf(i));
                }
            }, 0L, 1000L);
        }
    }

    public void stopCountDown() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.str)) {
            setText(this.str);
        }
        super.onDraw(canvas);
    }
}