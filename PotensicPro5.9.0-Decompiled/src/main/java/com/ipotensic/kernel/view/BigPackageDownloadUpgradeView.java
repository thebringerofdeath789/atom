package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class BigPackageDownloadUpgradeView extends View {
    private Paint bitmapPaint;
    private float center;
    private final Context context;
    private State currentState;
    private Paint downUpgradePaint;
    private int height;
    private int innerCircleColor;
    private float innerCircleRadius;
    private Paint innerPaint;
    private boolean isInit;
    private boolean isUnableUpgrade;
    private int outerCircleColor;
    private float outerCircleRadius;
    private Paint outerPaint;
    private long progress;
    private int progressBackgroundColor;
    private int progressColor;
    private Paint progressPaint;
    private float progressRadius;
    private RectF progressRectF;
    private int textColor;
    private Paint textPaint;
    private Bitmap unableBitmap;
    private int width;

    private enum State {
        FW_DOWNLOAD,
        FW_UPLOAD,
        FW_UPGRADE,
        FW_SUCCESS
    }

    public BigPackageDownloadUpgradeView(Context context) {
        this(context, null);
        DDLog.e("下载进度。。。。");
    }

    public BigPackageDownloadUpgradeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BigPackageDownloadUpgradeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInit = false;
        this.progress = 0L;
        this.isUnableUpgrade = false;
        this.currentState = State.FW_DOWNLOAD;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DownloadUpgradeView);
        this.outerCircleColor = obtainStyledAttributes.getColor(R.styleable.DownloadUpgradeView_outer_color, -1);
        this.innerCircleColor = obtainStyledAttributes.getColor(R.styleable.DownloadUpgradeView_inner_color, -1);
        this.progressBackgroundColor = obtainStyledAttributes.getColor(R.styleable.DownloadUpgradeView_progress_bg_color, -1);
        this.progressColor = obtainStyledAttributes.getColor(R.styleable.DownloadUpgradeView_progress_color, -1);
        this.textColor = obtainStyledAttributes.getColor(R.styleable.DownloadUpgradeView_text_color, -1);
        obtainStyledAttributes.recycle();
        this.unableBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_upgrade_unable_fail);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        DDLog.e("下载进度 onSizeChanged width= " + this.width + ", height = " + this.height);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.width != 0 && this.height != 0 && !this.isInit) {
            this.isInit = true;
            Paint paint = new Paint();
            this.outerPaint = paint;
            paint.setColor(this.outerCircleColor);
            this.outerPaint.setAntiAlias(true);
            this.outerPaint.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.innerPaint = paint2;
            paint2.setAntiAlias(true);
            this.innerPaint.setColor(this.innerCircleColor);
            this.outerPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.textPaint = paint3;
            paint3.setAntiAlias(true);
            this.textPaint.setColor(this.textColor);
            this.textPaint.setTextSize(UnitUtil.sp2px(25));
            this.textPaint.setStyle(Paint.Style.FILL);
            this.textPaint.setTextAlign(Paint.Align.CENTER);
            this.textPaint.setTypeface(PhoneConfig.typeface);
            Paint paint4 = new Paint();
            this.progressPaint = paint4;
            paint4.setAntiAlias(true);
            this.progressPaint.setColor(this.progressBackgroundColor);
            this.progressPaint.setStyle(Paint.Style.STROKE);
            this.progressPaint.setStrokeWidth(UnitUtil.dp2px(7));
            Paint paint5 = new Paint();
            this.downUpgradePaint = paint5;
            paint5.setAntiAlias(true);
            this.downUpgradePaint.setColor(this.textColor);
            this.downUpgradePaint.setStyle(Paint.Style.STROKE);
            this.downUpgradePaint.setStrokeCap(Paint.Cap.ROUND);
            this.downUpgradePaint.setStrokeWidth(UnitUtil.dp2px(7));
            Paint paint6 = new Paint();
            this.bitmapPaint = paint6;
            paint6.setDither(true);
            this.bitmapPaint.setAntiAlias(true);
            float f = this.width >> 1;
            this.center = f;
            this.outerCircleRadius = f;
            this.innerCircleRadius = (float) (f * 0.85d);
            this.progressRadius = (float) (f * 0.625d);
            float f2 = this.center;
            float f3 = this.progressRadius;
            this.progressRectF = new RectF(f2 - f3, f2 - f3, f2 + f3, f2 + f3);
        }
        if (this.isUnableUpgrade) {
            canvas.drawBitmap(this.unableBitmap, new Rect(0, 0, this.unableBitmap.getWidth(), this.unableBitmap.getHeight()), new Rect(0, 0, this.width, this.height), this.bitmapPaint);
            return;
        }
        float f4 = this.center;
        canvas.drawCircle(f4, f4, this.outerCircleRadius, this.outerPaint);
        float f5 = this.center;
        canvas.drawCircle(f5, f5, this.innerCircleRadius, this.innerPaint);
        float f6 = this.center;
        canvas.drawCircle(f6, f6, this.progressRadius, this.progressPaint);
        canvas.drawArc(this.progressRectF, 90.0f, this.progress * 3.6f, false, this.downUpgradePaint);
        String str = this.progress + "%";
        Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
        canvas.drawText(str, (this.width - str.length()) >> 1, (getHeight() / 2) + (((fontMetricsInt.bottom - fontMetricsInt.top) / 2) - fontMetricsInt.bottom), this.textPaint);
    }

    public void downloadProgress(long j) {
        DDLog.e("大包", "下载进度条：" + j);
        this.progress = j;
        invalidate();
    }

    public void uploadProgress(long j) {
        DDLog.e("大包", "升级进度条：" + j);
        this.progress = j;
        invalidate();
    }

    public void unableUpgrade(boolean z) {
        this.isUnableUpgrade = z;
        invalidate();
    }

    public void clearProgress() {
        if (this.progress == 100) {
            this.progress = 0L;
        }
    }
}
