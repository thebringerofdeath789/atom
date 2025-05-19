package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class MiniLandSlideUnlockView extends View implements View.OnTouchListener {
    private Paint backGroundPaint;
    private RectF backGroundRect;
    private Paint bitmapPaint;
    private Canvas canvas;
    private Bitmap centerCircleBp;
    private int gradientEndColor;
    private int gradientStartColor;
    private int height;
    private Bitmap landGrayBp;
    private String landStr;
    private Bitmap landWhiteBp;
    private String[] lands;
    private Bitmap leftArrowBp;
    private Bitmap leftArrowNorBp;
    private SlideProgressListener listener;
    private int maxOffset;
    private boolean needCountDown;
    private float offsetX;
    private Resources res;
    private Bitmap returnGrayBp;
    private String returnStr;
    private Bitmap returnWhiteBp;
    private String[] returns;
    private Bitmap rightArrowBp;
    private Bitmap rightArrowNorBp;
    private Bitmap slideBarBp;
    private int slideBtnWidth;
    private Bitmap slideCircleBp;
    private int space;
    private int space1;
    private float startX;
    private TextPaint textGrayPaint;
    private int textLeftStartX;
    private int textRightStartX;
    private TextPaint textWhitePaint;
    private int width;

    public interface SlideProgressListener {
        void onProgressChanged(int i);
    }

    public MiniLandSlideUnlockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiniLandSlideUnlockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnTouchListener(this);
        initResources();
        initPaint();
    }

    private void initResources() {
        Resources resources = getResources();
        this.res = resources;
        this.landGrayBp = BitmapFactory.decodeResource(resources, R.mipmap.icon_flight_land_disable);
        this.landWhiteBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_take_landing_big);
        this.returnGrayBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_flight_return_disable);
        this.returnWhiteBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_go_home);
        this.leftArrowBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_left_arrow);
        this.leftArrowNorBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_left_arrow_nor);
        this.rightArrowBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_right_arrow);
        this.rightArrowNorBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_right_arrow_nor);
        this.centerCircleBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_center_point);
        this.slideCircleBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_slide_button);
        this.slideBarBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_land_slide_bar);
        this.landStr = this.res.getString(R.string.dialog_slip_left_to_land);
        this.returnStr = this.res.getString(R.string.dialog_swipe_right_to_return);
        this.gradientStartColor = this.res.getColor(R.color.gradientStartColor);
        this.gradientEndColor = this.res.getColor(R.color.gradientEndColor);
        this.lands = this.landStr.split("\n");
        this.returns = this.returnStr.split("\n");
    }

    public void switchCenterCircleBpToNoContent(boolean z) {
        Bitmap decodeResource;
        this.needCountDown = z;
        if (z) {
            decodeResource = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_center_gray_point);
        } else {
            decodeResource = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_center_point);
        }
        this.centerCircleBp = decodeResource;
        invalidate();
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.bitmapPaint = paint;
        paint.setAntiAlias(true);
        this.bitmapPaint.setDither(true);
        Paint paint2 = new Paint();
        this.backGroundPaint = paint2;
        paint2.setAntiAlias(true);
        TextPaint textPaint = new TextPaint();
        this.textWhitePaint = textPaint;
        textPaint.setColor(-1);
        this.textWhitePaint.setTextSize(dp2px(10));
        this.textWhitePaint.setAntiAlias(true);
        this.textWhitePaint.setTextAlign(Paint.Align.CENTER);
        this.textWhitePaint.setTypeface(PhoneConfig.typeface);
        TextPaint textPaint2 = new TextPaint();
        this.textGrayPaint = textPaint2;
        textPaint2.setColor(this.res.getColor(R.color.color_white_fifty_percent));
        this.textGrayPaint.setTextSize(dp2px(10));
        this.textGrayPaint.setAntiAlias(true);
        this.textGrayPaint.setTextAlign(Paint.Align.CENTER);
        this.textGrayPaint.setTypeface(PhoneConfig.typeface);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float x = motionEvent.getX();
            this.startX = x;
            if (x < this.maxOffset - dp2px(30) || this.startX > this.maxOffset + this.slideBtnWidth + dp2px(30)) {
                return false;
            }
        } else if (action == 1) {
            SlideProgressListener slideProgressListener = this.listener;
            if (slideProgressListener != null) {
                float f = this.offsetX;
                if (f + 30.0f >= this.maxOffset) {
                    slideProgressListener.onProgressChanged(100);
                } else if (f - 30.0f <= (-r3)) {
                    slideProgressListener.onProgressChanged(-100);
                }
            }
            if (this.offsetX < 0.0f) {
                while (this.offsetX < 0.0f) {
                    invalidate();
                    this.offsetX += 1.0f;
                }
            } else {
                while (this.offsetX > 0.0f) {
                    invalidate();
                    this.offsetX -= 1.0f;
                }
            }
        } else if (action == 2) {
            this.offsetX = motionEvent.getX() - this.startX;
            invalidate();
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
            this.space1 = dp2px(8);
            this.textLeftStartX = dp2px(103);
            this.textRightStartX = dp2px(300);
            int width = this.slideCircleBp.getWidth();
            this.slideBtnWidth = width;
            this.maxOffset = (this.width - width) / 2;
        }
        float f = this.offsetX;
        int i = this.maxOffset;
        if (f >= i) {
            this.offsetX = i;
        } else if ((-f) >= i) {
            this.offsetX = -i;
        }
        drawBackground();
        drawBitmap();
        drawTextContent();
    }

    private Shader getLinearShader() {
        if (this.offsetX > 0.0f) {
            int i = this.width;
            return new LinearGradient(i >> 1, this.space1, i - r4, this.height - r4, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
        }
        float f = this.width >> 1;
        int i2 = this.space1;
        return new LinearGradient(f, i2, i2, this.height - i2, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
    }

    private void textCenter(String[] strArr, Paint paint, Canvas canvas, Point point, Paint.Align align) {
        paint.setTextAlign(align);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.top;
        float f2 = fontMetrics.bottom;
        int length = strArr.length;
        float f3 = (-f) + f2;
        float f4 = ((((length - 1) * f3) + ((-fontMetrics.ascent) + fontMetrics.descent)) / 2.0f) - f2;
        for (int i = 0; i < length; i++) {
            canvas.drawText(strArr[i] + "", point.x, point.y + ((-((length - i) - 1)) * f3) + f4, paint);
        }
    }

    private void drawTextContent() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        TextPaint textPaint = this.textWhitePaint;
        String str = this.landStr;
        textPaint.getTextBounds(str, 0, str.length(), rect);
        TextPaint textPaint2 = this.textWhitePaint;
        String str2 = this.returnStr;
        textPaint2.getTextBounds(str2, 0, str2.length(), rect2);
        Paint.FontMetrics fontMetrics = this.textWhitePaint.getFontMetrics();
        float f = (((this.height - this.space1) + 2) >> 1) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
        float f2 = this.offsetX;
        float f3 = f2 - 30.0f;
        int i = this.maxOffset;
        if (f3 <= (-i)) {
            this.canvas.drawText(this.landStr, this.space + this.landGrayBp.getWidth() + this.leftArrowBp.getWidth() + dp2px(2) + rect.width(), f, this.textWhitePaint);
            this.canvas.drawText(this.returnStr, ((((this.width - this.space) - this.returnGrayBp.getWidth()) - this.rightArrowBp.getWidth()) - rect2.width()) - dp2px(2), f, this.textGrayPaint);
        } else if (f2 + 30.0f >= i) {
            this.canvas.drawText(this.landStr, this.space + this.landGrayBp.getWidth() + this.leftArrowBp.getWidth() + dp2px(2) + rect.width(), f, this.textGrayPaint);
            this.canvas.drawText(this.returnStr, ((((this.width - this.space) - this.returnGrayBp.getWidth()) - this.rightArrowBp.getWidth()) - rect2.width()) - dp2px(2), f, this.textWhitePaint);
        } else {
            this.canvas.drawText(this.landStr, this.space + this.landGrayBp.getWidth() + this.leftArrowBp.getWidth() + dp2px(2) + rect.width(), f, this.textGrayPaint);
            this.canvas.drawText(this.returnStr, ((((this.width - this.space) - this.returnGrayBp.getWidth()) - this.rightArrowBp.getWidth()) - rect2.width()) - dp2px(2), f, this.textGrayPaint);
        }
    }

    private void drawBackground() {
        if (this.offsetX == 0.0f) {
            return;
        }
        this.backGroundPaint.setShader(getLinearShader());
        int i = this.width;
        RectF rectF = new RectF(i >> 1, this.space1, (i >> 1) + this.offsetX, this.height - r4);
        this.backGroundRect = rectF;
        this.canvas.drawRoundRect(rectF, 0.0f, 0.0f, this.backGroundPaint);
    }

    private void drawBitmap() {
        this.canvas.drawBitmap(this.slideBarBp, 0.0f, 0.0f, this.bitmapPaint);
        int i = this.slideBtnWidth;
        Rect rect = new Rect(0, 0, i, i);
        int i2 = this.maxOffset;
        float f = this.offsetX;
        float f2 = i2 + f;
        float f3 = i2 + f;
        int i3 = this.slideBtnWidth;
        RectF rectF = new RectF(f2, 0.0f, f3 + i3, i3);
        if (this.needCountDown) {
            this.canvas.drawBitmap(this.centerCircleBp, (this.width - r5.getWidth()) >> 1, dp2px(4), this.bitmapPaint);
            this.canvas.drawBitmap(this.slideCircleBp, rect, rectF, this.bitmapPaint);
        } else {
            this.canvas.drawBitmap(this.slideCircleBp, rect, rectF, this.bitmapPaint);
            this.canvas.drawBitmap(this.centerCircleBp, (this.width - r1.getWidth()) >> 1, dp2px(4), this.bitmapPaint);
        }
        float f4 = this.offsetX;
        if (f4 - 30.0f <= (-this.maxOffset) && f4 < 0.0f) {
            this.canvas.drawBitmap(this.leftArrowNorBp, this.space + this.landGrayBp.getWidth() + this.space1 + 5, (this.height - this.leftArrowBp.getHeight()) >> 1, this.bitmapPaint);
            Canvas canvas = this.canvas;
            Bitmap bitmap = this.landWhiteBp;
            int i4 = this.space;
            canvas.drawBitmap(bitmap, i4, i4, this.bitmapPaint);
        } else {
            this.canvas.drawBitmap(this.leftArrowBp, this.space + this.landGrayBp.getWidth() + this.space1 + 5, (this.height - this.leftArrowBp.getHeight()) >> 1, this.bitmapPaint);
            Canvas canvas2 = this.canvas;
            Bitmap bitmap2 = this.landGrayBp;
            int i5 = this.space;
            canvas2.drawBitmap(bitmap2, i5, i5, this.bitmapPaint);
        }
        if (this.offsetX + 30.0f >= this.maxOffset) {
            this.canvas.drawBitmap(this.rightArrowNorBp, ((((this.width - this.space) - this.returnGrayBp.getWidth()) - this.rightArrowBp.getWidth()) - this.space1) - 5, (this.height - this.rightArrowBp.getHeight()) >> 1, this.bitmapPaint);
            this.canvas.drawBitmap(this.returnWhiteBp, (this.width - this.space) - r1.getWidth(), this.space, this.bitmapPaint);
            return;
        }
        this.canvas.drawBitmap(this.rightArrowBp, ((((this.width - this.space) - this.returnGrayBp.getWidth()) - this.rightArrowBp.getWidth()) - this.space1) - 5, (this.height - this.rightArrowBp.getHeight()) >> 1, this.bitmapPaint);
        this.canvas.drawBitmap(this.returnGrayBp, (this.width - this.space) - r1.getWidth(), this.space, this.bitmapPaint);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, this.res.getDisplayMetrics());
    }

    public void setSlideProgressListener(SlideProgressListener slideProgressListener) {
        this.listener = slideProgressListener;
    }
}
