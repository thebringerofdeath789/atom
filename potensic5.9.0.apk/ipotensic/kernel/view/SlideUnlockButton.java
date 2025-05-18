package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class SlideUnlockButton extends View implements View.OnTouchListener {
    private int backgroundColor;
    private float baseline;
    private float bottom;
    private Canvas canvas;
    private float centerX;
    private float centerY;
    private int circleColor;
    private int gradientEndColor;
    private int gradientStartColor;
    private float height;
    private SlideProgressListener listener;
    private Paint mPaint;
    private float maxOffsetX;
    private Handler myHandler;
    private float offset;
    private float r;
    private Shader shader;
    private float spaceX;
    private float spaceY;
    private float startX;
    private String textContent;
    private float top;
    private float width;

    public interface SlideProgressListener {
        void onProgressChanged(int i);
    }

    public SlideUnlockButton(Context context) {
        super(context);
        this.offset = 0.0f;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SlideUnlockButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SlideUnlockButton.this.invalidate();
                return false;
            }
        });
    }

    public SlideUnlockButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 0.0f;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SlideUnlockButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SlideUnlockButton.this.invalidate();
                return false;
            }
        });
        initButton(context, attributeSet);
    }

    public SlideUnlockButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 0.0f;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SlideUnlockButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SlideUnlockButton.this.invalidate();
                return false;
            }
        });
        initButton(context, attributeSet);
    }

    public SlideUnlockButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.offset = 0.0f;
        this.myHandler = new Handler(new Handler.Callback() { // from class: com.ipotensic.kernel.view.SlideUnlockButton.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                String str = (String) message.obj;
                str.hashCode();
                if (!str.equals("refresh")) {
                    return false;
                }
                SlideUnlockButton.this.invalidate();
                return false;
            }
        });
        initButton(context, attributeSet);
    }

    public void setProgressListener(SlideProgressListener slideProgressListener) {
        this.listener = slideProgressListener;
    }

    private void initButton(Context context, AttributeSet attributeSet) {
        setOnTouchListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlideUnlockButton);
        this.circleColor = obtainStyledAttributes.getColor(R.styleable.SlideUnlockButton_circleColor, -1);
        this.textContent = obtainStyledAttributes.getString(R.styleable.SlideUnlockButton_text);
        obtainStyledAttributes.recycle();
        this.gradientStartColor = getResources().getColor(R.color.colorGradientBlueStart);
        this.gradientEndColor = getResources().getColor(R.color.colorGradientBlueEnd);
    }

    private Shader getShader() {
        float f = this.spaceX;
        float f2 = this.spaceY;
        float f3 = this.offset;
        float f4 = this.maxOffsetX;
        LinearGradient linearGradient = new LinearGradient(f, f2, f3 > f4 ? (this.r * 2.0f) + f + f3 : (this.r * 2.0f) + f + f4, f2 + this.r, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
        this.shader = linearGradient;
        return linearGradient;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float x = motionEvent.getX();
            this.startX = x;
            if (x > this.spaceX + (this.r * 4.0f)) {
                return false;
            }
        } else if (action == 1) {
            SlideProgressListener slideProgressListener = this.listener;
            if (slideProgressListener != null && this.offset + 25.0f >= this.maxOffsetX) {
                slideProgressListener.onProgressChanged(100);
            }
            while (this.offset > 0.0f) {
                refreshUI();
                this.offset -= 1.0f;
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX() - this.startX;
            if (x2 > 0.0f) {
                this.offset = x2;
                refreshUI();
            }
        }
        return true;
    }

    private void refreshUI() {
        Message message = new Message();
        message.obj = "refresh";
        this.myHandler.sendMessage(message);
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
        printTextContent();
        printBitmap();
        printCircle(this.r);
    }

    private void printBitmap() {
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setDither(true);
        this.canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_slide_right), this.centerX + paint.measureText(this.textContent) + 30.0f, this.centerY - 3.0f, paint);
    }

    private void printTextContent() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        paint.setColor(-1);
        this.baseline = this.centerY - fontMetricsInt.top;
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(3.0f);
        paint.setTextSize(40.0f);
        paint.setTypeface(PhoneConfig.typeface);
        this.canvas.drawText(this.textContent, this.centerX, this.baseline, paint);
    }

    private void printBackground() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        RectF rectF = new RectF(this.spaceX, this.spaceY, getWidth() - this.spaceX, getHeight() - this.spaceY);
        this.bottom = rectF.bottom;
        this.top = rectF.top;
        this.centerX = rectF.centerX();
        this.centerY = rectF.centerY();
        if (this.offset < this.maxOffsetX) {
            this.mPaint.setShader(getShader());
            this.canvas.drawRoundRect(rectF, 4095.0f, 4095.0f, this.mPaint);
            printSlidedBackground();
        } else {
            this.mPaint.setShader(getShader());
            this.canvas.drawRoundRect(rectF, 4095.0f, 4095.0f, this.mPaint);
        }
    }

    private void printSlidedBackground() {
        this.mPaint.setShader(getShader());
        float f = this.spaceX;
        float f2 = this.spaceY;
        float f3 = this.r;
        this.canvas.drawRoundRect(new RectF(f, f2, (f3 * 2.0f) + f + this.offset, (f3 * 2.0f) + f2), 4095.0f, 4095.0f, this.mPaint);
    }

    private int getTextAlpha() {
        float f = this.offset;
        float f2 = this.maxOffsetX;
        if (f >= f2) {
            f = f2;
        }
        int i = (int) (255.0f - ((f * 255.0f) / f2));
        return i <= 235 ? i + 20 : i;
    }

    private void printCircle(float f) {
        Paint paint = new Paint();
        paint.setColor(this.circleColor);
        paint.setAntiAlias(true);
        float f2 = this.offset;
        float f3 = this.maxOffsetX;
        if (f2 >= f3) {
            this.offset = f3;
        }
        this.canvas.drawCircle(this.spaceX + f + this.offset, this.spaceY + f, f, paint);
    }
}