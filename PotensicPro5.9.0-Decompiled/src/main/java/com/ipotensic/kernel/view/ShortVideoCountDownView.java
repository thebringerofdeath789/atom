package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.CustomTimer;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ShortVideoCountDownView extends RelativeLayout {
    private int num;
    private CustomTimer timer;
    private TextView tvCount;

    public interface OnCountDownListener {
        void onCountDownEnd();

        void onCounting(int i);
    }

    static /* synthetic */ int access$010(ShortVideoCountDownView shortVideoCountDownView) {
        int i = shortVideoCountDownView.num;
        shortVideoCountDownView.num = i - 1;
        return i;
    }

    public ShortVideoCountDownView(Context context) {
        super(context);
        init();
    }

    public ShortVideoCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ShortVideoCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ShortVideoCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        TextView textView = new TextView(getContext());
        this.tvCount = textView;
        textView.setTextSize(2, 50.0f);
        this.tvCount.getPaint().setFakeBoldText(true);
        this.tvCount.setTextColor(getResources().getColor(R.color.white));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.tvCount, layoutParams);
    }

    public void startCount(int i, final OnCountDownListener onCountDownListener) {
        if (isCountingDown()) {
            return;
        }
        setVisibility(0);
        this.num = i;
        CustomTimer customTimer = new CustomTimer(0L, 1000L, -1, new CustomTimer.OnUpdateInMainThreadListener() { // from class: com.ipotensic.kernel.view.ShortVideoCountDownView.1
            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInMainThreadListener
            public void timeout() {
            }

            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInMainThreadListener
            public void update() {
                try {
                    if (ShortVideoCountDownView.this.num == 0) {
                        DDLog.e("倒计时结束：" + ShortVideoCountDownView.this.num);
                        ShortVideoCountDownView.this.interrupt();
                        OnCountDownListener onCountDownListener2 = onCountDownListener;
                        if (onCountDownListener2 != null) {
                            onCountDownListener2.onCountDownEnd();
                            return;
                        }
                        return;
                    }
                    OnCountDownListener onCountDownListener3 = onCountDownListener;
                    if (onCountDownListener3 != null) {
                        onCountDownListener3.onCounting(ShortVideoCountDownView.this.num);
                    }
                    ShortVideoCountDownView.this.tvCount.setText("" + ShortVideoCountDownView.this.num);
                    ShortVideoCountDownView.access$010(ShortVideoCountDownView.this);
                    DDLog.e("倒计时：" + ShortVideoCountDownView.this.num);
                } catch (Exception e) {
                    DDLog.e("倒计时出错:" + e);
                }
            }
        });
        this.timer = customTimer;
        customTimer.start();
    }

    public boolean isCountingDown() {
        CustomTimer customTimer = this.timer;
        return customTimer != null && customTimer.isRunning();
    }

    public void interrupt() {
        CustomTimer customTimer = this.timer;
        if (customTimer != null) {
            customTimer.cancel();
            this.timer = null;
        }
        setVisibility(8);
    }
}
