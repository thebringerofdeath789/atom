package com.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import com.camera.listener.CaptureListener;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes.dex */
public class CaptureButton extends View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    private float button_inside_radius;
    private float button_outside_radius;
    private float button_radius;
    private int button_size;
    private int button_state;
    private CaptureListener captureLisenter;
    private float center_X;
    private float center_Y;
    private int duration;
    private float event_Y;
    private int inside_color;
    private int inside_reduce_size;
    private LongPressRunnable longPressRunnable;
    private Paint mPaint;
    private int min_duration;
    private int outside_add_size;
    private int outside_color;
    private float progress;
    private int progress_color;
    private int recorded_time;
    private RectF rectF;
    private int state;
    private float strokeWidth;
    private RecordCountDownTimer timer;

    public CaptureButton(Context context) {
        super(context);
        this.progress_color = -300503530;
        this.outside_color = -287515428;
        this.inside_color = -1;
    }

    public CaptureButton(Context context, int i) {
        super(context);
        this.progress_color = -300503530;
        this.outside_color = -287515428;
        this.inside_color = -1;
        this.button_size = i;
        float f = i / 2.0f;
        this.button_radius = f;
        this.button_outside_radius = f;
        this.button_inside_radius = f * 0.75f;
        this.strokeWidth = i / 15;
        this.outside_add_size = i / 5;
        this.inside_reduce_size = i / 8;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new LongPressRunnable();
        this.state = 1;
        this.button_state = JCameraView.BUTTON_STATE_BOTH;
        DDLog.i("CaptureButtom start");
        this.duration = 10000;
        DDLog.i("CaptureButtom end");
        this.min_duration = 1000;
        int i2 = this.button_size;
        int i3 = this.outside_add_size;
        this.center_X = ((i3 * 2) + i2) / 2;
        this.center_Y = (i2 + (i3 * 2)) / 2;
        float f2 = this.center_X;
        float f3 = this.button_radius;
        int i4 = this.outside_add_size;
        float f4 = this.strokeWidth;
        float f5 = this.center_Y;
        this.rectF = new RectF(f2 - ((i4 + f3) - (f4 / 2.0f)), f5 - ((i4 + f3) - (f4 / 2.0f)), f2 + ((i4 + f3) - (f4 / 2.0f)), f5 + ((f3 + i4) - (f4 / 2.0f)));
        this.timer = new RecordCountDownTimer(this.duration, r15 / 360);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        setMeasuredDimension((i4 * 2) + i3, i3 + (i4 * 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.outside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(this.inside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state == 4) {
            this.mPaint.setColor(this.progress_color);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CaptureListener captureListener;
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            DDLog.i("state = " + this.state);
            if (motionEvent.getPointerCount() <= 1 && this.state == 1) {
                this.event_Y = motionEvent.getY();
                this.state = 2;
                int i2 = this.button_state;
                if (i2 == 258 || i2 == 259) {
                    postDelayed(this.longPressRunnable, 500L);
                }
            }
        } else if (action == 1) {
            DDLog.e("录制结束");
            handlerUnpressByState();
        } else if (action == 2 && (captureListener = this.captureLisenter) != null && this.state == 4 && ((i = this.button_state) == 258 || i == 259)) {
            captureListener.recordZoom(this.event_Y - motionEvent.getY());
        }
        return true;
    }

    private void handlerUnpressByState() {
        int i;
        removeCallbacks(this.longPressRunnable);
        int i2 = this.state;
        if (i2 != 2) {
            if (i2 != 4) {
                return;
            }
            this.timer.cancel();
            recordEnd();
            return;
        }
        if (this.captureLisenter != null && ((i = this.button_state) == 257 || i == 259)) {
            startCaptureAnimation(this.button_inside_radius);
        } else {
            this.state = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordEnd() {
        CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            int i = this.recorded_time;
            if (i < this.min_duration) {
                captureListener.recordShort(i);
            } else {
                captureListener.recordEnd(i);
            }
        }
        resetRecordAnim();
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        DDLog.e("录制resetRecordAnim1111111111");
        invalidate();
        DDLog.e("录制resetRecordAnim22222");
        float f = this.button_outside_radius;
        float f2 = this.button_radius;
        startRecordAnimation(f, f2, this.button_inside_radius, 0.75f * f2);
    }

    private void startCaptureAnimation(float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 0.75f * f, f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera.CaptureButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CaptureButton.this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CaptureButton.this.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.camera.CaptureButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureButton.this.captureLisenter.takePictures();
                CaptureButton.this.state = 5;
            }
        });
        ofFloat.setDuration(100L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecordAnimation(float f, float f2, float f3, float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f3, f4);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera.CaptureButton.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CaptureButton.this.button_outside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CaptureButton.this.invalidate();
            }
        });
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera.CaptureButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CaptureButton.this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CaptureButton.this.invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.camera.CaptureButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CaptureButton.this.state == 3) {
                    if (CaptureButton.this.captureLisenter != null) {
                        CaptureButton.this.captureLisenter.recordStart();
                    }
                    CaptureButton.this.state = 4;
                    CaptureButton.this.timer.start();
                }
            }
        });
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        int i = this.duration;
        this.recorded_time = (int) (i - j);
        this.progress = 360.0f - ((j / i) * 360.0f);
        invalidate();
    }

    private class RecordCountDownTimer extends CountDownTimer {
        RecordCountDownTimer(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CaptureButton.this.updateProgress(j);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CaptureButton.this.updateProgress(0L);
            CaptureButton.this.recordEnd();
        }
    }

    private class LongPressRunnable implements Runnable {
        private LongPressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CaptureButton.this.state = 3;
            CaptureButton captureButton = CaptureButton.this;
            captureButton.startRecordAnimation(captureButton.button_outside_radius, CaptureButton.this.button_outside_radius + CaptureButton.this.outside_add_size, CaptureButton.this.button_inside_radius, CaptureButton.this.button_inside_radius - CaptureButton.this.inside_reduce_size);
        }
    }

    public void setDuration(int i) {
        this.duration = i;
        this.timer = new RecordCountDownTimer(i, i / 360);
    }

    public void setMinDuration(int i) {
        this.min_duration = i;
    }

    public void setCaptureLisenter(CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setButtonFeatures(int i) {
        this.button_state = i;
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    public void resetState() {
        this.state = 1;
    }
}
