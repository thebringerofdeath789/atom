package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class MiniTakeoffSlideUnlockView extends View implements View.OnTouchListener {
    private int arrowLeft;
    private int arrowTop;
    private Paint backGroundPaint;
    private Paint bgPaint;
    private Paint bitmapPaint;
    private Canvas canvas;
    private int gradientEndColor;
    private int gradientStartColor;
    private int height;
    private boolean isShowBitmap;
    private boolean isTakeoff;
    private Bitmap landGrayBp;
    private Bitmap landWhiteBp;
    private Bitmap leftBgCircleBp;
    private SlideProgressListener listener;
    private float maxOffset;
    private float offset;
    private Resources res;
    private Bitmap rightArrowBp;
    private Bitmap rightArrowNorBp;
    private Bitmap rightTakeoffBp;
    private Bitmap rightTakeoffWhiteBp;
    private Bitmap slideBarBp;
    private int slideBtnWidth;
    private Bitmap slideCircleBp;
    private String slipStr;
    private int space;
    private int space2;
    private float startX;
    private Paint textPaint;
    private int width;

    public interface SlideProgressListener {
        void onProgressChanged(int i);
    }

    public MiniTakeoffSlideUnlockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiniTakeoffSlideUnlockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnTouchListener(this);
        initResources();
        initPaint();
    }

    private void initResources() {
        Resources resources = getResources();
        this.res = resources;
        this.leftBgCircleBp = BitmapFactory.decodeResource(resources, R.mipmap.icon_mini_flight_center_point);
        this.slideCircleBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_slide_button);
        this.rightArrowBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_right_arrow);
        this.rightArrowNorBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_right_arrow_nor);
        this.slideBarBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_slide_bar_disable);
        this.rightTakeoffBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_land_nor);
        this.rightTakeoffWhiteBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_land);
        this.landGrayBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_flight_land_disable);
        this.landWhiteBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_take_landing);
        this.slipStr = this.res.getString(R.string.slip);
        this.gradientStartColor = this.res.getColor(R.color.gradientStartColor);
        this.gradientEndColor = this.res.getColor(R.color.gradientEndColor);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.bgPaint = paint;
        paint.setAntiAlias(true);
        this.bgPaint.setStyle(Paint.Style.STROKE);
        this.bgPaint.setStrokeWidth(dp2px(4));
        this.bgPaint.setColor(this.res.getColor(R.color.colorMiniSlideBarBg));
        Paint paint2 = new Paint();
        this.bitmapPaint = paint2;
        paint2.setAntiAlias(true);
        this.bitmapPaint.setDither(true);
        Paint paint3 = new Paint();
        this.backGroundPaint = paint3;
        paint3.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.textPaint = paint4;
        paint4.setColor(-1);
        this.textPaint.setTextSize(dp2px(10));
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setTypeface(PhoneConfig.typeface);
    }

    public void setTakeOff(boolean z, boolean z2) {
        this.isTakeoff = z;
        this.isShowBitmap = z2;
        postInvalidate();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float x = motionEvent.getX();
            this.startX = x;
            if (x > this.slideBtnWidth + dp2px(8)) {
                return false;
            }
        } else if (action == 1) {
            DDLog.e("123", "up_maxOffset -> " + this.maxOffset + ", offsetX -> " + this.offset);
            SlideProgressListener slideProgressListener = this.listener;
            if (slideProgressListener != null && this.offset + 30.0f >= this.maxOffset) {
                slideProgressListener.onProgressChanged(100);
            }
            while (this.offset > 0.0f) {
                invalidate();
                this.offset -= 1.0f;
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX() - this.startX;
            if (x2 > 0.0f) {
                this.offset = x2;
                invalidate();
            }
            DDLog.e("123", "offsetX = " + x2);
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        if (this.width == 0) {
            this.width = getWidth();
            this.height = getHeight();
            this.space = dp2px(12);
            this.space2 = dp2px(4);
            this.slideBtnWidth = this.slideCircleBp.getWidth();
            this.maxOffset = this.width - r2;
        }
        float f = this.offset;
        float f2 = this.maxOffset;
        if (f >= f2) {
            this.offset = f2;
        }
        drawBackground();
        drawTextContent();
        drawBitmap();
    }

    private void drawTextContent() {
        Rect rect = new Rect();
        Paint paint = this.textPaint;
        String str = this.slipStr;
        paint.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.canvas.drawText(this.slipStr, ((this.width >> 1) + this.space) - rect.centerX(), (this.height >> 1) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.textPaint);
        this.arrowLeft = (this.width / 2) + this.space + 2;
        this.arrowTop = (this.height - this.rightArrowBp.getHeight()) / 2;
    }

    private void drawBackground() {
        if (this.offset > 0.0f) {
            this.backGroundPaint.setShader(getLinearShader());
            int i = this.space2;
            this.canvas.drawRoundRect(new RectF(i * 2, i * 2, this.offset + (this.slideBtnWidth / 2), this.height - (i * 2)), 4095.0f, 4095.0f, this.backGroundPaint);
        }
    }

    private void drawBitmap() {
        this.canvas.drawBitmap(this.slideBarBp, 0.0f, 0.0f, this.bitmapPaint);
        Canvas canvas = this.canvas;
        Bitmap bitmap = this.slideCircleBp;
        int i = this.slideBtnWidth;
        Rect rect = new Rect(0, 0, i, i);
        float f = this.offset;
        int i2 = this.slideBtnWidth;
        canvas.drawBitmap(bitmap, rect, new RectF(f, 0.0f, i2 + f, i2), this.bitmapPaint);
        Canvas canvas2 = this.canvas;
        Bitmap bitmap2 = this.leftBgCircleBp;
        int i3 = this.space2;
        canvas2.drawBitmap(bitmap2, i3, i3, this.bitmapPaint);
        if (this.offset + 30.0f >= this.maxOffset) {
            if (this.isShowBitmap) {
                this.canvas.drawBitmap(this.isTakeoff ? this.rightTakeoffWhiteBp : this.landWhiteBp, (this.width - this.space) - this.rightTakeoffBp.getWidth(), this.space, this.bitmapPaint);
            }
            this.canvas.drawBitmap(this.rightArrowNorBp, this.arrowLeft, this.arrowTop, this.bitmapPaint);
        } else {
            if (this.isShowBitmap) {
                this.canvas.drawBitmap(this.isTakeoff ? this.rightTakeoffBp : this.landGrayBp, (this.width - this.space) - this.rightTakeoffBp.getWidth(), this.space, this.bitmapPaint);
            }
            this.canvas.drawBitmap(this.rightArrowBp, this.arrowLeft, this.arrowTop, this.bitmapPaint);
        }
    }

    private Shader getLinearShader() {
        int i = this.space2;
        return new LinearGradient(i * 2, i * 2, this.width - (i * 2), this.height - (i * 2), this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, this.res.getDisplayMetrics());
    }

    public void setSlideProgressListener(SlideProgressListener slideProgressListener) {
        this.listener = slideProgressListener;
    }
}
