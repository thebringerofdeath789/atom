package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/* loaded from: classes4.dex */
public class RoundedCornersTransformation implements Transformation<Bitmap> {
    private BitmapPool mBitmapPool;
    private CornerType mCornerType;
    private int mDiameter;
    private int mMargin;
    private int mRadius;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(Context context, int i, int i2) {
        this(context, i, i2, CornerType.ALL);
    }

    public RoundedCornersTransformation(BitmapPool bitmapPool, int i, int i2) {
        this(bitmapPool, i, i2, CornerType.ALL);
    }

    public RoundedCornersTransformation(Context context, int i, int i2, CornerType cornerType) {
        this(Glide.get(context).getBitmapPool(), i, i2, cornerType);
    }

    public RoundedCornersTransformation(BitmapPool bitmapPool, int i, int i2, CornerType cornerType) {
        this.mBitmapPool = bitmapPool;
        this.mRadius = i;
        this.mDiameter = i * 2;
        this.mMargin = i2;
        this.mCornerType = cornerType;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int i, int i2) {
        Bitmap bitmap = resource.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = this.mBitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        drawRoundRect(canvas, paint, width, height);
        return BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        float f3 = f - i;
        float f4 = f2 - i;
        switch (AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[this.mCornerType.ordinal()]) {
            case 1:
                int i2 = this.mMargin;
                RectF rectF = new RectF(i2, i2, f3, f4);
                int i3 = this.mRadius;
                canvas.drawRoundRect(rectF, i3, i3, paint);
                break;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f3, f4);
                break;
            case 3:
                drawTopRightRoundRect(canvas, paint, f3, f4);
                break;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f3, f4);
                break;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f3, f4);
                break;
            case 6:
                drawTopRoundRect(canvas, paint, f3, f4);
                break;
            case 7:
                drawBottomRoundRect(canvas, paint, f3, f4);
                break;
            case 8:
                drawLeftRoundRect(canvas, paint, f3, f4);
                break;
            case 9:
                drawRightRoundRect(canvas, paint, f3, f4);
                break;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f3, f4);
                break;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f3, f4);
                break;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f3, f4);
                break;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f3, f4);
                break;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f3, f4);
                break;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f3, f4);
                break;
            default:
                int i4 = this.mMargin;
                RectF rectF2 = new RectF(i4, i4, f3, f4);
                int i5 = this.mRadius;
                canvas.drawRoundRect(rectF2, i5, i5, paint);
                break;
        }
    }

    /* renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        int i2 = this.mDiameter;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.mMargin;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF(i4, i4 + i5, i4 + i5, f2), paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mDiameter;
        RectF rectF = new RectF(f - i, this.mMargin, f, r3 + i);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.mMargin;
        canvas.drawRect(new RectF(i3, i3, f - this.mRadius, f2), paint);
        canvas.drawRect(new RectF(f - this.mRadius, this.mMargin + r1, f, f2), paint);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.mMargin, f2 - this.mDiameter, r1 + r3, f2);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.mMargin;
        canvas.drawRect(new RectF(i2, i2, i2 + this.mDiameter, f2 - this.mRadius), paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mDiameter;
        RectF rectF = new RectF(f - i, f2 - i, f, f2);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.mMargin;
        canvas.drawRect(new RectF(i3, i3, f - this.mRadius, f2), paint);
        int i4 = this.mRadius;
        canvas.drawRect(new RectF(f - i4, this.mMargin, f, f2 - i4), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        RectF rectF = new RectF(i, i, f, i + this.mDiameter);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + this.mRadius, f, f2), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.mMargin;
        canvas.drawRect(new RectF(i2, i2, f, f2 - this.mRadius), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        RectF rectF = new RectF(i, i, i + this.mDiameter, f2);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - this.mDiameter, this.mMargin, f, f2);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.mMargin;
        canvas.drawRect(new RectF(i2, i2, f - this.mRadius, f2), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, i, i, paint);
        RectF rectF2 = new RectF(f - this.mDiameter, this.mMargin, f, f2);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF2, i2, i2, paint);
        int i3 = this.mMargin;
        int i4 = this.mRadius;
        canvas.drawRect(new RectF(i3, i3, f - i4, f2 - i4), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        RectF rectF = new RectF(i, i, i + this.mDiameter, f2);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(r1 + r2, this.mMargin, f, f2 - this.mRadius), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        RectF rectF = new RectF(i, i, f, i + this.mDiameter);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(f - this.mDiameter, this.mMargin, f, f2);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + r3, f - this.mRadius, f2), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        RectF rectF = new RectF(i, i, f, i + this.mDiameter);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.mMargin;
        RectF rectF2 = new RectF(i3, i3, i3 + this.mDiameter, f2);
        int i4 = this.mRadius;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.mMargin;
        int i6 = this.mRadius;
        canvas.drawRect(new RectF(i5 + i6, i5 + i6, f, f2), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mMargin;
        int i2 = this.mDiameter;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.mDiameter;
        RectF rectF2 = new RectF(f - i4, f2 - i4, f, f2);
        int i5 = this.mRadius;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        canvas.drawRect(new RectF(this.mMargin, r1 + this.mRadius, f - this.mDiameter, f2), paint);
        canvas.drawRect(new RectF(this.mDiameter + r1, this.mMargin, f, f2 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.mDiameter;
        RectF rectF = new RectF(f - i, this.mMargin, f, r3 + i);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.mMargin, f2 - this.mDiameter, r1 + r3, f2);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.mMargin;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF(i4, i4, f - i5, f2 - i5), paint);
        int i6 = this.mMargin;
        int i7 = this.mRadius;
        canvas.drawRect(new RectF(i6 + i7, i6 + i7, f, f2), paint);
    }

    @Override // com.bumptech.glide.load.Transformation
    public String getId() {
        return "RoundedTransformation(radius=" + this.mRadius + ", margin=" + this.mMargin + ", diameter=" + this.mDiameter + ", cornerType=" + this.mCornerType.name() + ")";
    }
}
