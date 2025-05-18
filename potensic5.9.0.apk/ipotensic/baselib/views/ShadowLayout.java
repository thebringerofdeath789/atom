package com.ipotensic.baselib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ipotensic.baselib.R;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ShadowLayout extends FrameLayout {
    private boolean bottomShow;
    private final HashMap<Key, Bitmap> cache;
    private boolean leftShow;
    private float mCornerRadius;
    private float mDx;
    private float mDy;
    private boolean mForceInvalidateShadow;
    private boolean mInvalidateShadowOnSizeChanged;
    private int mShadowColor;
    private float mShadowLimit;
    private boolean rightShow;
    private boolean topShow;

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return 0;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return 0;
    }

    public ShadowLayout(Context context) {
        super(context);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mForceInvalidateShadow = false;
        this.cache = new HashMap<>();
        initView(context, null);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mForceInvalidateShadow = false;
        this.cache = new HashMap<>();
        initView(context, attributeSet);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mForceInvalidateShadow = false;
        this.cache = new HashMap<>();
        initView(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (getBackground() == null || this.mInvalidateShadowOnSizeChanged || this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(i, i2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(i3 - i, i4 - i2);
        }
    }

    public void setInvalidateShadowOnSizeChanged(boolean z) {
        this.mInvalidateShadowOnSizeChanged = z;
    }

    public void invalidateShadow() {
        this.mForceInvalidateShadow = true;
        requestLayout();
        invalidate();
    }

    private void initView(Context context, AttributeSet attributeSet) {
        initAttributes(context, attributeSet);
        int abs = (int) (this.mShadowLimit + Math.abs(this.mDx));
        int abs2 = (int) (this.mShadowLimit + Math.abs(this.mDy));
        int i = this.leftShow ? abs : 0;
        int i2 = this.topShow ? abs2 : 0;
        if (!this.rightShow) {
            abs = 0;
        }
        if (!this.bottomShow) {
            abs2 = 0;
        }
        setPadding(i, i2, abs, abs2);
    }

    private void setBackgroundCompat(int i, int i2) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createShadowBitmap(i, i2, this.mCornerRadius, this.mShadowLimit, this.mDx, this.mDy, this.mShadowColor, 0));
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(bitmapDrawable);
        } else {
            setBackground(bitmapDrawable);
        }
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = getTypedArray(context, attributeSet, R.styleable.ShadowLayout);
        if (typedArray == null) {
            return;
        }
        try {
            this.leftShow = typedArray.getBoolean(R.styleable.ShadowLayout_yc_leftShow, true);
            this.rightShow = typedArray.getBoolean(R.styleable.ShadowLayout_yc_rightShow, true);
            this.bottomShow = typedArray.getBoolean(R.styleable.ShadowLayout_yc_bottomShow, true);
            this.topShow = typedArray.getBoolean(R.styleable.ShadowLayout_yc_topShow, true);
            this.mCornerRadius = typedArray.getDimension(R.styleable.ShadowLayout_yc_cornerRadius, 0.0f);
            this.mShadowLimit = typedArray.getDimension(R.styleable.ShadowLayout_yc_shadowLimit, 0.0f);
            this.mDx = typedArray.getDimension(R.styleable.ShadowLayout_yc_dx, 0.0f);
            this.mDy = typedArray.getDimension(R.styleable.ShadowLayout_yc_dy, 0.0f);
            this.mShadowColor = typedArray.getColor(R.styleable.ShadowLayout_yc_shadowColor, getResources().getColor(R.color.color_shadow));
        } finally {
            typedArray.recycle();
        }
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private Bitmap createShadowBitmap(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Key key = new Key("bitmap", i, i2);
        Bitmap bitmap = this.cache.get(key);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            this.cache.put(key, bitmap);
        }
        this.cache.size();
        Canvas canvas = new Canvas(bitmap);
        RectF rectF = new RectF(f2, f2, i - f2, i2 - f2);
        if (f4 > 0.0f) {
            rectF.top += f4;
            rectF.bottom -= f4;
        } else if (f4 < 0.0f) {
            rectF.top += Math.abs(f4);
            rectF.bottom -= Math.abs(f4);
        }
        if (f3 > 0.0f) {
            rectF.left += f3;
            rectF.right -= f3;
        } else if (f3 < 0.0f) {
            rectF.left += Math.abs(f3);
            rectF.right -= Math.abs(f3);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(f2, f3, f4, i3);
        }
        canvas.drawRoundRect(rectF, f, f, paint);
        return bitmap;
    }

    public class Key {
        private final int height;
        private final String name;
        private final int width;

        public Key(String str, int i, int i2) {
            this.name = str;
            this.width = i;
            this.height = i2;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            if (this.width != key.width || this.height != key.height) {
                return false;
            }
            String str = this.name;
            String str2 = key.name;
            return str != null ? str.equals(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.name;
            return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
        }
    }
}