package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class SwitchButton extends View {
    private Canvas canvas;
    private long firstClickTime;
    private int gradientEndColor;
    private int gradientStartColor;
    private float height;
    private boolean isEnable;
    private boolean isOpen;
    private Paint mPaint;
    private float maxOffsetX;
    private Handler myHandler;
    private float r;
    private Shader shader;
    private float spaceX;
    private float spaceY;
    private SwitchStateListener stateListener;
    private float width;

    public interface SwitchStateListener {
        void onDisableClick();

        void onStateChanged(View view, boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        this.isOpen = false;
        this.isEnable = true;
        this.firstClickTime = 0L;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SwitchButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SwitchButton.this.invalidate();
                return false;
            }
        });
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOpen = false;
        this.isEnable = true;
        this.firstClickTime = 0L;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SwitchButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SwitchButton.this.invalidate();
                return false;
            }
        });
        initButton();
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isOpen = false;
        this.isEnable = true;
        this.firstClickTime = 0L;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SwitchButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SwitchButton.this.invalidate();
                return false;
            }
        });
        initButton();
    }

    public void switchStateListener(SwitchStateListener switchStateListener) {
        this.stateListener = switchStateListener;
        DDLog.w("switch: setListener:" + this.stateListener);
    }

    private void initButton() {
        this.gradientStartColor = getResources().getColor(R.color.colorGradientBlueStart);
        this.gradientEndColor = getResources().getColor(R.color.colorGradientBlueEnd);
    }

    private Shader getShader() {
        float f = this.spaceX;
        float f2 = this.spaceY;
        float f3 = this.r;
        LinearGradient linearGradient = new LinearGradient(f, f2, (2.0f * f3) + f + this.maxOffsetX, f2 + f3, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
        this.shader = linearGradient;
        return linearGradient;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnable) {
            if (this.stateListener != null && motionEvent.getAction() == 1) {
                this.stateListener.onDisableClick();
            }
            return true;
        }
        if (motionEvent.getAction() == 1) {
            boolean z = !this.isOpen;
            this.isOpen = z;
            SwitchStateListener switchStateListener = this.stateListener;
            if (switchStateListener != null) {
                switchStateListener.onStateChanged(this, z);
            }
            refreshUI();
        }
        return true;
    }

    private void refreshUI() {
        Message message = new Message();
        message.obj = "refresh";
        this.myHandler.sendMessage(message);
    }

    public boolean isChecked() {
        return this.isOpen;
    }

    public void setChecked(boolean z) {
        this.isOpen = z;
        refreshUI();
    }

    public void setViewEnable(boolean z) {
        this.isEnable = z;
        setEnabled(z);
        setClickable(z);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        if (this.width == 0.0f) {
            this.width = getWidth();
            float height = getHeight();
            this.height = height;
            this.spaceY = height / 8.0f;
            this.spaceX = this.width / 21.0f;
            this.r = (getHeight() - (this.spaceY * 2.0f)) / 2.0f;
            this.maxOffsetX = getWidth() - ((this.spaceX + this.r) * 2.0f);
        }
        paint();
    }

    private void paint() {
        printBackground();
        printCircle(this.r);
    }

    private void printBackground() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        RectF rectF = new RectF(this.spaceX, this.spaceY, getWidth() - this.spaceX, getHeight() - this.spaceY);
        if (this.isOpen) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setShader(getShader());
        } else {
            this.mPaint.setStrokeWidth(dp2px(3));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(Color.parseColor("#707070"));
        }
        this.canvas.drawRoundRect(rectF, 4095.0f, 4095.0f, this.mPaint);
    }

    private void printCircle(float f) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        if (this.isOpen) {
            this.canvas.drawCircle(this.spaceX + f + this.maxOffsetX, this.spaceY + f, f, paint);
        } else {
            this.canvas.drawCircle(this.spaceX + f, this.spaceY + f, f, paint);
        }
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }
}