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
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class MiniLandSlideUnlockView2 extends View implements View.OnTouchListener {
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
    private SlideProgressListener listener;
    private int maxOffset;
    private int offsetX;
    private Resources res;
    private Bitmap returnGrayBp;
    private String returnStr;
    private Bitmap returnWhiteBp;
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

    public MiniLandSlideUnlockView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiniLandSlideUnlockView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offsetX = 0;
        setOnTouchListener(this);
        initResources();
        initPaint();
    }

    private void initResources() {
        Resources resources = getResources();
        this.res = resources;
        this.landGrayBp = BitmapFactory.decodeResource(resources, R.mipmap.icon_flight_land_disable);
        this.landWhiteBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_take_landing);
        this.returnGrayBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_flight_return_disable);
        this.returnWhiteBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_go_home);
        this.centerCircleBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_center_point);
        this.slideCircleBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_flight_slide_button);
        this.slideBarBp = BitmapFactory.decodeResource(this.res, R.mipmap.icon_mini_land_slide_bar);
        this.landStr = this.res.getString(R.string.dialog_slip_left_to_land);
        this.returnStr = this.res.getString(R.string.dialog_swipe_right_to_return);
        this.gradientStartColor = this.res.getColor(R.color.gradientStartColor);
        this.gradientEndColor = this.res.getColor(R.color.gradientEndColor);
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
        this.textWhitePaint.setTypeface(Typeface.defaultFromStyle(0));
        TextPaint textPaint2 = new TextPaint();
        this.textGrayPaint = textPaint2;
        textPaint2.setColor(this.res.getColor(R.color.color_white_fifty_percent));
        this.textGrayPaint.setTextSize(dp2px(10));
        this.textGrayPaint.setAntiAlias(true);
        this.textGrayPaint.setTextAlign(Paint.Align.CENTER);
        this.textGrayPaint.setTypeface(Typeface.defaultFromStyle(0));
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
            DDLog.e("123", "up_maxOffset -> " + this.maxOffset + ", offsetX -> " + this.offsetX);
            SlideProgressListener slideProgressListener = this.listener;
            if (slideProgressListener != null) {
                int i = this.offsetX;
                int i2 = this.maxOffset;
                if (i >= i2) {
                    slideProgressListener.onProgressChanged(100);
                } else if (i <= (-i2)) {
                    slideProgressListener.onProgressChanged(-100);
                }
            }
            if (this.offsetX < 0) {
                while (this.offsetX < 0) {
                    invalidate();
                    this.offsetX++;
                }
            } else {
                while (this.offsetX > 0) {
                    invalidate();
                    this.offsetX--;
                }
            }
        } else if (action == 2) {
            this.offsetX = (int) ((motionEvent.getX() - this.startX) + 0.5f);
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
        int i = this.offsetX;
        int i2 = this.maxOffset;
        if (i >= i2) {
            this.offsetX = i2;
        } else if ((-i) >= i2) {
            this.offsetX = -i2;
        }
        drawBackground();
        drawTextContent();
        drawBitmap();
    }

    private Shader getLinearShader() {
        if (this.offsetX > 0) {
            int i = this.width;
            return new LinearGradient(i >> 1, this.space1, i - r4, this.height - r4, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
        }
        float f = this.width >> 1;
        int i2 = this.space1;
        return new LinearGradient(f, i2, i2, this.height - i2, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
    }

    private void drawTextContent() {
        Rect rect = new Rect();
        TextPaint textPaint = this.textWhitePaint;
        String str = this.landStr;
        textPaint.getTextBounds(str, 0, str.length(), rect);
        rect.width();
        rect.height();
        Paint.FontMetrics fontMetrics = this.textWhitePaint.getFontMetrics();
        float f = ((this.height >> 1) - this.space1) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom);
        int i = this.offsetX;
        int i2 = this.maxOffset;
        if (i <= (-i2)) {
            StaticLayout staticLayout = new StaticLayout(this.landStr, this.textWhitePaint, dp2px(90), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            StaticLayout staticLayout2 = new StaticLayout(this.returnStr, this.textGrayPaint, dp2px(90), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.canvas.save();
            this.canvas.translate(this.textLeftStartX, f);
            staticLayout.draw(this.canvas);
            this.canvas.restore();
            this.canvas.save();
            this.canvas.translate(this.textRightStartX, f);
            staticLayout2.draw(this.canvas);
            this.canvas.restore();
            return;
        }
        if (i >= i2) {
            StaticLayout staticLayout3 = new StaticLayout(this.landStr, this.textGrayPaint, dp2px(90), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            StaticLayout staticLayout4 = new StaticLayout(this.returnStr, this.textWhitePaint, dp2px(90), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.canvas.save();
            this.canvas.translate(this.textLeftStartX, f);
            staticLayout3.draw(this.canvas);
            this.canvas.restore();
            this.canvas.save();
            this.canvas.translate(this.textRightStartX, f);
            staticLayout4.draw(this.canvas);
            this.canvas.restore();
            return;
        }
        StaticLayout staticLayout5 = new StaticLayout(this.landStr, this.textGrayPaint, dp2px(90), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        StaticLayout staticLayout6 = new StaticLayout(this.returnStr, this.textGrayPaint, dp2px(90), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.canvas.save();
        this.canvas.translate(this.textLeftStartX, f);
        staticLayout5.draw(this.canvas);
        this.canvas.restore();
        this.canvas.save();
        this.canvas.translate(this.textRightStartX, f);
        staticLayout6.draw(this.canvas);
        this.canvas.restore();
    }

    private void rowTextCenter(String[] strArr, Paint paint, Canvas canvas, Point point) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            char[] charArray = strArr[i].toCharArray();
            float measureText = paint.measureText(charArray[0] + "");
            for (int i2 = 1; i2 < length; i2++) {
                measureText = Math.max(paint.measureText(charArray[i2] + ""), measureText);
                if (i == 0) {
                    point.x = ((int) (-(0.0f - measureText))) / 2;
                }
                point.x += (int) measureText;
            }
        }
    }

    private void manualLine(String[] strArr, float f, float f2, float f3, Canvas canvas, Paint paint) {
        int i = 0;
        for (String str : strArr) {
            float f4 = i;
            canvas.drawText(str, 0 + f2, f3 + f4, paint);
            i = (int) (f4 + f);
            f = 0.0f;
        }
    }

    private void drawBackground() {
        if (this.offsetX == 0) {
            return;
        }
        this.backGroundPaint.setShader(getLinearShader());
        int i = this.width;
        RectF rectF = new RectF(i >> 1, this.space1, (i >> 1) + this.offsetX, this.height - r3);
        this.backGroundRect = rectF;
        this.canvas.drawRoundRect(rectF, 0.0f, 0.0f, this.backGroundPaint);
    }

    private void drawBitmap() {
        this.canvas.drawBitmap(this.slideBarBp, 0.0f, 0.0f, this.bitmapPaint);
        int i = this.slideBtnWidth;
        Rect rect = new Rect(0, 0, i, i);
        int i2 = this.maxOffset;
        int i3 = this.offsetX;
        int i4 = i2 + i3;
        int i5 = i2 + i3;
        int i6 = this.slideBtnWidth;
        this.canvas.drawBitmap(this.slideCircleBp, rect, new Rect(i4, 0, i5 + i6, i6), this.bitmapPaint);
        int i7 = this.offsetX;
        if (i7 <= (-this.maxOffset) && i7 < 0) {
            Canvas canvas = this.canvas;
            Bitmap bitmap = this.landWhiteBp;
            int i8 = this.space;
            canvas.drawBitmap(bitmap, i8, i8, this.bitmapPaint);
        } else {
            Canvas canvas2 = this.canvas;
            Bitmap bitmap2 = this.landGrayBp;
            int i9 = this.space;
            canvas2.drawBitmap(bitmap2, i9, i9, this.bitmapPaint);
        }
        if (this.offsetX >= this.maxOffset) {
            this.canvas.drawBitmap(this.returnWhiteBp, (this.width - this.space) - r1.getWidth(), this.space, this.bitmapPaint);
        } else {
            this.canvas.drawBitmap(this.returnGrayBp, (this.width - this.space) - r1.getWidth(), this.space, this.bitmapPaint);
        }
        this.canvas.drawBitmap(this.centerCircleBp, (this.width - r1.getWidth()) >> 1, dp2px(4), this.bitmapPaint);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, this.res.getDisplayMetrics());
    }

    public void setSlideProgressListener(SlideProgressListener slideProgressListener) {
        this.listener = slideProgressListener;
    }
}