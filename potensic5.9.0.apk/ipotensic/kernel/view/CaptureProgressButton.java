package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.enums.CaptureUIType;
import com.ipotensic.kernel.utils.AnimationUtil;

/* loaded from: classes2.dex */
public class CaptureProgressButton extends ImageButton {
    private final float LINE_WIDTH;
    private final int PADDING;
    private Bitmap bmpCaptureBg;
    private Bitmap bmpCaptureCenter;
    private CaptureUIType captureType;
    private boolean isInit;
    private boolean isTimedTakingPhoto;
    private Paint paint;
    private int progressPercent;
    private Paint textPaint;
    private int time;

    public CaptureProgressButton(Context context) {
        super(context);
        this.captureType = CaptureUIType.CAPTURE_UI_RECORD;
        this.isInit = false;
        this.progressPercent = 0;
        this.LINE_WIDTH = 4.5f;
        this.PADDING = 8;
        init();
    }

    public CaptureProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.captureType = CaptureUIType.CAPTURE_UI_RECORD;
        this.isInit = false;
        this.progressPercent = 0;
        this.LINE_WIDTH = 4.5f;
        this.PADDING = 8;
        init();
    }

    public CaptureProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.captureType = CaptureUIType.CAPTURE_UI_RECORD;
        this.isInit = false;
        this.progressPercent = 0;
        this.LINE_WIDTH = 4.5f;
        this.PADDING = 8;
        init();
    }

    public CaptureProgressButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.captureType = CaptureUIType.CAPTURE_UI_RECORD;
        this.isInit = false;
        this.progressPercent = 0;
        this.LINE_WIDTH = 4.5f;
        this.PADDING = 8;
        init();
    }

    public void setTimedTakingPhoto(boolean z) {
        this.isTimedTakingPhoto = z;
        setCaptureType(this.captureType);
        DDLog.d("CaptureProgressButton", "isTimedTakingPhoto=" + z);
    }

    public CaptureUIType getCaptureType() {
        return this.captureType;
    }

    public void setCaptureType(CaptureUIType captureUIType) {
        this.captureType = captureUIType;
        DDLog.d("CaptureProgressButton", "CaptureUIType=" + captureUIType);
        if (captureUIType != CaptureUIType.CAPTURE_UI_TAKING_PHOTO) {
            clearAnimation();
        }
        if (captureUIType == CaptureUIType.CAPTURE_UI_PROGRESS) {
            setImageDrawable(null);
        } else {
            this.progressPercent = 0;
            switch (AnonymousClass1.$SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[captureUIType.ordinal()]) {
                case 1:
                    setImageResource(R.mipmap.img_btn_capture_photo);
                    break;
                case 2:
                    setImageResource(R.mipmap.img_btn_capture_record_enable);
                    break;
                case 3:
                    setImageResource(R.mipmap.img_btn_capture_go);
                    break;
                case 4:
                    setImageResource(R.mipmap.img_btn_capture_recording);
                    break;
                case 5:
                    setImageResource(R.mipmap.img_btn_capture_photo_loading);
                    AnimationUtil.selfRotateRepeat(this);
                    break;
                case 6:
                    if (this.isTimedTakingPhoto) {
                        setImageResource(R.mipmap.img_btn_capture_photo_timed_loading);
                        AnimationUtil.selfRotateRepeat(this);
                        break;
                    } else {
                        setImageResource(R.mipmap.img_btn_time_capture_photo);
                        break;
                    }
                case 7:
                    setImageResource(R.mipmap.img_btn_capture_exit);
                    break;
                case 8:
                    setImageResource(R.mipmap.img_btn_capture_cancel_countdown);
                    break;
                case 9:
                    setImageResource(R.mipmap.img_btn_capture_cancel_countdown);
                    break;
            }
        }
        postInvalidate();
    }

    /* renamed from: com.ipotensic.kernel.view.CaptureProgressButton$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType;

        static {
            int[] iArr = new int[CaptureUIType.values().length];
            $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType = iArr;
            try {
                iArr[CaptureUIType.CAPTURE_UI_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_RECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_GO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_RECORDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_TAKING_PHOTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_TIMER_TAKING_PHOTO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_EXIT_TRACK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$kernel$enums$CaptureUIType[CaptureUIType.CAPTURE_UI_CANCEL_BACK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // android.view.View
    public void clearAnimation() {
        if (this.captureType != CaptureUIType.CAPTURE_UI_TAKING_PHOTO) {
            super.clearAnimation();
        }
    }

    private void init() {
        if (this.isInit) {
            return;
        }
        this.bmpCaptureBg = BitmapFactory.decodeResource(getResources(), R.mipmap.img_bg_capture_progress);
        this.bmpCaptureCenter = BitmapFactory.decodeResource(getResources(), R.mipmap.img_btn_capture_progress);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.textPaint = paint2;
        paint2.setAntiAlias(true);
        this.textPaint.setColor(Color.parseColor("#21D525"));
        this.textPaint.setTextSize(UnitUtil.dip2px(12.0f));
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.isInit = true;
    }

    public void setProgressPercent(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.progressPercent = i;
        postInvalidate();
    }

    public void setTime(int i) {
        this.time = i;
        postInvalidate();
        DDLog.d("CaptureProgressButton", "time=" + i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isInit && this.captureType == CaptureUIType.CAPTURE_UI_PROGRESS) {
            Rect rect = new Rect(8, 8, getMeasuredWidth() - 8, getMeasuredHeight() - 8);
            canvas.drawBitmap(this.bmpCaptureBg, new Rect(0, 0, this.bmpCaptureBg.getWidth(), this.bmpCaptureBg.getHeight()), rect, this.paint);
            canvas.drawBitmap(this.bmpCaptureCenter, new Rect(0, 0, this.bmpCaptureCenter.getWidth(), this.bmpCaptureCenter.getHeight()), new Rect(rect.centerX() - (this.bmpCaptureCenter.getWidth() / 2), rect.centerY() - (this.bmpCaptureCenter.getHeight() / 2), rect.centerX() + (this.bmpCaptureCenter.getWidth() / 2), rect.centerY() + (this.bmpCaptureCenter.getHeight() / 2)), this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setColor(getResources().getColor(R.color.colorBlack));
            this.paint.setStrokeWidth(4.5f);
            RectF rectF = new RectF((r0.left - 4.5f) - 3.0f, (r0.top - 4.5f) - 3.0f, r0.right + 4.5f + 3.0f, r0.bottom + 4.5f + 3.0f);
            canvas.drawArc(rectF, 0.0f, 360.0f, false, this.paint);
            RectF rectF2 = new RectF(rect.left + 4.5f, rect.top + 4.5f, rect.right - 4.5f, rect.bottom - 4.5f);
            canvas.drawArc(rectF2, 0.0f, 360.0f, false, this.paint);
            this.paint.setColor(getResources().getColor(R.color.white));
            this.paint.setStrokeWidth((rectF2.width() - rectF.width()) / 2.0f);
            canvas.drawArc(new RectF((rectF2.left + rectF.left) / 2.0f, (rectF2.top + rectF.top) / 2.0f, (rectF2.right + rectF.right) / 2.0f, (rectF2.bottom + rectF.bottom) / 2.0f), -90.0f, (this.progressPercent * 360) / 100, false, this.paint);
            return;
        }
        if (this.captureType != CaptureUIType.CAPTURE_UI_PHOTO || this.time <= 0) {
            return;
        }
        canvas.drawText(this.time + "s", getWidth() / 2.0f, (getHeight() + Math.abs(this.textPaint.ascent() + this.textPaint.descent())) / 2.0f, this.textPaint);
    }
}