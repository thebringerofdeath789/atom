package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/* loaded from: classes4.dex */
public class CropTransformation implements Transformation<Bitmap> {
    private BitmapPool mBitmapPool;
    private CropType mCropType;
    private int mHeight;
    private int mWidth;

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    public CropTransformation(BitmapPool bitmapPool) {
        this(bitmapPool, 0, 0);
    }

    public CropTransformation(Context context, int i, int i2) {
        this(Glide.get(context).getBitmapPool(), i, i2);
    }

    public CropTransformation(BitmapPool bitmapPool, int i, int i2) {
        this(bitmapPool, i, i2, CropType.CENTER);
    }

    public CropTransformation(Context context, int i, int i2, CropType cropType) {
        this(Glide.get(context).getBitmapPool(), i, i2, cropType);
    }

    public CropTransformation(BitmapPool bitmapPool, int i, int i2, CropType cropType) {
        this.mCropType = CropType.CENTER;
        this.mBitmapPool = bitmapPool;
        this.mWidth = i;
        this.mHeight = i2;
        this.mCropType = cropType;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int i, int i2) {
        Bitmap bitmap = resource.get();
        int i3 = this.mWidth;
        if (i3 == 0) {
            i3 = bitmap.getWidth();
        }
        this.mWidth = i3;
        int i4 = this.mHeight;
        if (i4 == 0) {
            i4 = bitmap.getHeight();
        }
        this.mHeight = i4;
        Bitmap.Config config = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = this.mBitmapPool.get(this.mWidth, this.mHeight, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(this.mWidth, this.mHeight, config);
        }
        float max = Math.max(this.mWidth / bitmap.getWidth(), this.mHeight / bitmap.getHeight());
        float width = bitmap.getWidth() * max;
        float height = max * bitmap.getHeight();
        float f = (this.mWidth - width) / 2.0f;
        float top = getTop(height);
        new Canvas(bitmap2).drawBitmap(bitmap, (Rect) null, new RectF(f, top, width + f, height + top), (Paint) null);
        return BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }

    @Override // com.bumptech.glide.load.Transformation
    public String getId() {
        return "CropTransformation(width=" + this.mWidth + ", height=" + this.mHeight + ", cropType=" + this.mCropType + ")";
    }

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType;

        static {
            int[] iArr = new int[CropType.values().length];
            $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType = iArr;
            try {
                iArr[CropType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[CropType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[CropType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private float getTop(float f) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[this.mCropType.ordinal()];
        if (i == 2) {
            return (this.mHeight - f) / 2.0f;
        }
        if (i != 3) {
            return 0.0f;
        }
        return this.mHeight - f;
    }
}
