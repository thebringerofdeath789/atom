package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class UpDownSlideView extends RelativeLayout {
    private final int HORIZONTAL_PADDING;
    private final int VERTICAL_PADDING;
    private int bottomLimit;
    private ImageView imgSlidePoint;
    private boolean isSlide;
    private OnSlideListener slideListener;
    private int slidePercent;
    private int topLimit;
    private int viewCenter;
    private int viewHeight;

    public interface OnSlideListener {
        void onSlideValue(int i);
    }

    public UpDownSlideView(Context context) {
        super(context);
        this.HORIZONTAL_PADDING = 20;
        this.VERTICAL_PADDING = 40;
        this.isSlide = false;
    }

    public UpDownSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HORIZONTAL_PADDING = 20;
        this.VERTICAL_PADDING = 40;
        this.isSlide = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        setBackgroundColor(getContext().getResources().getColor(R.color.colorTransparent));
        addBg();
        addSlidePoint();
        post(new Runnable() { // from class: com.ipotensic.kernel.view.UpDownSlideView.1
            @Override // java.lang.Runnable
            public void run() {
                UpDownSlideView upDownSlideView = UpDownSlideView.this;
                upDownSlideView.viewHeight = upDownSlideView.getHeight();
            }
        });
    }

    private void addBg() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.mipmap.icon_slie_line);
        imageView.setPadding(20, 40, 20, 40);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        addView(imageView, layoutParams);
    }

    private void addSlidePoint() {
        ImageView imageView = new ImageView(getContext());
        this.imgSlidePoint = imageView;
        imageView.setImageResource(R.mipmap.icon_blue_point);
        this.imgSlidePoint.setScaleX(1.5f);
        this.imgSlidePoint.setScaleY(1.5f);
        this.imgSlidePoint.setPadding(20, 0, 20, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.imgSlidePoint, layoutParams);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        DDLog.e("slidePercent eventY:" + y);
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            int top = this.imgSlidePoint.getTop() - 20;
            int bottom = this.imgSlidePoint.getBottom() + 20;
            if (top <= y && y <= bottom) {
                z = true;
            }
            this.isSlide = z;
        } else if (action != 1) {
            if (action == 2 && this.isSlide) {
                this.topLimit = getTop() + 40;
                int bottom2 = (int) (getBottom() - 60.0f);
                this.bottomLimit = bottom2;
                int i = this.topLimit;
                this.viewCenter = (i + bottom2) / 2;
                if (i <= y && y <= bottom2) {
                    this.imgSlidePoint.setY(y);
                    this.imgSlidePoint.setImageResource(R.mipmap.icon_blue_point);
                    int i2 = this.viewCenter;
                    this.slidePercent = ((i2 - y) * 100) / i2;
                } else if (y <= i) {
                    this.imgSlidePoint.setY(i);
                    this.imgSlidePoint.setImageResource(R.mipmap.icon_red_point);
                    this.slidePercent = 100;
                } else if (y >= bottom2) {
                    this.imgSlidePoint.setY(bottom2);
                    this.imgSlidePoint.setImageResource(R.mipmap.icon_red_point);
                    this.slidePercent = -100;
                }
            }
        } else {
            performClick();
            this.imgSlidePoint.setImageResource(R.mipmap.icon_blue_point);
            this.imgSlidePoint.animate().translationY(0.0f).setDuration(200L).start();
            this.slidePercent = 0;
        }
        if (this.isSlide) {
            if (this.slidePercent > 100) {
                this.slidePercent = 100;
            }
            if (this.slidePercent < -100) {
                this.slidePercent = -100;
            }
            DDLog.d("slidePercent:" + this.slidePercent);
            OnSlideListener onSlideListener = this.slideListener;
            if (onSlideListener != null) {
                onSlideListener.onSlideValue(getValue(this.slidePercent));
            }
        }
        return true;
    }

    private int getValue(int i) {
        return ((i * 125) / 100) + 125;
    }

    public void setSlideListener(OnSlideListener onSlideListener) {
        this.slideListener = onSlideListener;
    }
}