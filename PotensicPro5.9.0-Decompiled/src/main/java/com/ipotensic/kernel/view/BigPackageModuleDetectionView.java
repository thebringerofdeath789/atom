package com.ipotensic.kernel.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class BigPackageModuleDetectionView extends View {
    private Paint bgPaint;
    private Bitmap bitmap;
    private Paint bitmapPaint;
    private int center;
    private Matrix matrix;
    private int num;
    private float progress;
    private ObjectAnimator rotateAnimator;
    private Bitmap rotateBitmap;

    public BigPackageModuleDetectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BigPackageModuleDetectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.center = 0;
        this.num = -1;
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint();
        this.bgPaint = paint;
        paint.setAntiAlias(true);
        this.bgPaint.setStyle(Paint.Style.FILL);
        this.bgPaint.setColor(context.getColor(R.color.colorOuter));
        Paint paint2 = new Paint();
        this.bitmapPaint = paint2;
        paint2.setAntiAlias(true);
        this.bitmapPaint.setDither(true);
        this.bitmapPaint.setStyle(Paint.Style.FILL);
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_big_package_cheaking);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.center == 0) {
            this.center = getWidth() >> 1;
            this.matrix = new Matrix();
        }
        this.rotateBitmap = getRotateBitmap(this.bitmap, this.progress);
        int i = this.center;
        canvas.drawCircle(i, i, i, this.bgPaint);
        canvas.drawBitmap(this.rotateBitmap, (getWidth() - this.rotateBitmap.getWidth()) >> 1, (getWidth() - this.rotateBitmap.getHeight()) >> 1, this.bitmapPaint);
    }

    public static Bitmap getRotateBitmap(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public void startCheckModule() {
        if (this.rotateAnimator == null) {
            this.num = -1;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, NotificationCompat.CATEGORY_PROGRESS, 0.0f, 720.0f);
            this.rotateAnimator = ofFloat;
            ofFloat.setDuration(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            this.rotateAnimator.setInterpolator(new LinearInterpolator());
            this.rotateAnimator.start();
            this.rotateAnimator.addListener(new Animator.AnimatorListener() { // from class: com.ipotensic.kernel.view.BigPackageModuleDetectionView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DDLog.e("大包 onAnimationStar");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DDLog.e("大包 onAnimationEnd");
                    EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPGRADE_STOP_ENVIRONMENT_CHECK);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DDLog.e("大包 onAnimationCancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    DDLog.e("大包 onAnimationRepeat");
                }
            });
        }
    }

    public void stopCheckModule() {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.rotateAnimator = null;
        }
        setVisibility(8);
    }

    public void setProgress(float f) {
        this.progress = f;
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }
}
