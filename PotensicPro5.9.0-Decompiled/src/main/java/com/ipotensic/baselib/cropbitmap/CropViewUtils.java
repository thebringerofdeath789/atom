package com.ipotensic.baselib.cropbitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.util.TypedValue;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class CropViewUtils {
    public static Bitmap compressBitmap(Context context, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        options.inSampleSize = (options.outHeight > i3 || options.outWidth > i2) ? Math.max((int) Math.floor(r2 / i3), (int) Math.floor(r3 / i2)) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmap(BitmapFactory.decodeResource(context.getResources(), i, options), i2, i3);
    }

    public static Bitmap compressBitmap(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int readPictureDegree = readPictureDegree(str);
        if (is90And270(readPictureDegree)) {
            int i5 = i2 - i;
            i2 -= i5;
            i = i5 + i2;
        }
        options.inSampleSize = (i3 > i2 || i4 > i) ? Math.max((int) Math.floor(i3 / i2), (int) Math.floor(i4 / i)) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmap(BitmapFactory.decodeFile(str, options), i, i2, readPictureDegree);
    }

    public static Bitmap compressBitmap(byte[] bArr, int i, int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        options.inSampleSize = (options.outHeight > i4 || options.outWidth > i3) ? Math.max((int) Math.floor(r2 / i4), (int) Math.floor(r3 / i3)) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmap(BitmapFactory.decodeByteArray(bArr, i, i2, options), i3, i4);
    }

    public static Bitmap compressBitmap(FileDescriptor fileDescriptor, Rect rect, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        options.inSampleSize = (options.outHeight > i2 || options.outWidth > i) ? Math.max((int) Math.floor(r2 / i2), (int) Math.floor(r3 / i)) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmap(BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options), i, i2);
    }

    public static Bitmap compressBitmap(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        options.inSampleSize = (options.outHeight > i2 || options.outWidth > i) ? Math.max((int) Math.floor(r2 / i2), (int) Math.floor(r3 / i)) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmap(BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options), i, i2);
    }

    public static Bitmap compressBitmap(InputStream inputStream, Rect rect, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, rect, options);
        options.inSampleSize = (options.outHeight > i2 || options.outWidth > i) ? Math.max((int) Math.floor(r2 / i2), (int) Math.floor(r3 / i)) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmap(BitmapFactory.decodeStream(inputStream, rect, options), i, i2);
    }

    public static Bitmap compressBitmapForHeight(Context context, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        options.inSampleSize = options.outHeight > i2 ? (int) Math.floor(r2 / i2) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForHeight(BitmapFactory.decodeResource(context.getResources(), i, options), i2);
    }

    public static Bitmap compressBitmapForHeight(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outHeight;
        int readPictureDegree = readPictureDegree(str);
        if (is90And270(readPictureDegree)) {
            i2 = options.outWidth;
        }
        options.inSampleSize = i2 > i ? (int) Math.floor(i2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForHeight(BitmapFactory.decodeFile(str, options), i, readPictureDegree);
    }

    public static Bitmap compressBitmapForHeight(byte[] bArr, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        options.inSampleSize = options.outHeight > i3 ? (int) Math.floor(r2 / i3) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForHeight(BitmapFactory.decodeByteArray(bArr, i, i2, options), i3);
    }

    public static Bitmap compressBitmapForHeight(FileDescriptor fileDescriptor, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        options.inSampleSize = options.outHeight > i ? (int) Math.floor(r2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForHeight(BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options), i);
    }

    public static Bitmap compressBitmapForHeight(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        options.inSampleSize = options.outHeight > i ? (int) Math.floor(r2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForHeight(BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options), i);
    }

    public static Bitmap compressBitmapForHeight(InputStream inputStream, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, rect, options);
        options.inSampleSize = options.outHeight > i ? (int) Math.floor(r2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForHeight(BitmapFactory.decodeStream(inputStream, rect, options), i);
    }

    public static Bitmap compressBitmapForWidth(Context context, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        options.inSampleSize = options.outWidth > i2 ? (int) Math.floor(r2 / i2) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForWidth(BitmapFactory.decodeResource(context.getResources(), i, options), i2);
    }

    public static Bitmap compressBitmapForWidth(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int readPictureDegree = readPictureDegree(str);
        if (is90And270(readPictureDegree)) {
            i2 = options.outHeight;
        }
        options.inSampleSize = i2 > i ? (int) Math.floor(i2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForWidth(BitmapFactory.decodeFile(str, options), i, readPictureDegree);
    }

    public static Bitmap compressBitmapForWidth(byte[] bArr, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        options.inSampleSize = options.outWidth > i3 ? (int) Math.floor(r2 / i3) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForWidth(BitmapFactory.decodeByteArray(bArr, i, i2, options), i3);
    }

    public static Bitmap compressBitmapForWidth(FileDescriptor fileDescriptor, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        options.inSampleSize = options.outWidth > i ? (int) Math.floor(r2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForWidth(BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options), i);
    }

    public static Bitmap compressBitmapForWidth(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        options.inSampleSize = options.outWidth > i ? (int) Math.floor(r2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForWidth(BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options), i);
    }

    public static Bitmap compressBitmapForWidth(InputStream inputStream, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, rect, options);
        options.inSampleSize = options.outWidth > i ? (int) Math.floor(r2 / i) : 1;
        options.inJustDecodeBounds = false;
        return scaleBitmapForWidth(BitmapFactory.decodeStream(inputStream, rect, options), i);
    }

    public static Bitmap compressBitmapForScale(Context context, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i2 > 1) {
            options.inSampleSize = i2;
        } else {
            options.inSampleSize = 1;
        }
        return BitmapFactory.decodeResource(context.getResources(), i, options);
    }

    public static Bitmap compressBitmapForScale(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i > 1) {
            options.inSampleSize = i;
        } else {
            options.inSampleSize = 1;
        }
        int readPictureDegree = readPictureDegree(str);
        if (is90And270(readPictureDegree)) {
            return createBitmapForMatrix(BitmapFactory.decodeFile(str, options), 1.0f, readPictureDegree);
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap compressBitmapForScale(byte[] bArr, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i3 > 1) {
            options.inSampleSize = i3;
        } else {
            options.inSampleSize = 1;
        }
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    public static Bitmap compressBitmapForScale(FileDescriptor fileDescriptor, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i > 1) {
            options.inSampleSize = i;
        } else {
            options.inSampleSize = 1;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    public static Bitmap compressBitmapForScale(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i > 1) {
            options.inSampleSize = i;
        } else {
            options.inSampleSize = 1;
        }
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    public static Bitmap compressBitmapForScale(InputStream inputStream, Rect rect, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i > 1) {
            options.inSampleSize = i;
        } else {
            options.inSampleSize = 1;
        }
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    public static Bitmap scaleBitmapForWidth(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        bitmap.getHeight();
        if (is90And270(i2)) {
            width = bitmap.getHeight();
            bitmap.getWidth();
        }
        return createBitmapForMatrix(bitmap, (i * 1.0f) / width, i2);
    }

    public static Bitmap scaleBitmapForWidth(Bitmap bitmap, int i) {
        return scaleBitmapForWidth(bitmap, i, 0);
    }

    public static Bitmap scaleBitmapForHeight(Bitmap bitmap, int i, int i2) {
        try {
            bitmap.getWidth();
            int height = bitmap.getHeight();
            if (is90And270(i2)) {
                bitmap.getHeight();
                height = bitmap.getWidth();
            }
            return createBitmapForMatrix(bitmap, (i * 1.0f) / height, i2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap scaleBitmapForHeight(Bitmap bitmap, int i) {
        return scaleBitmapForHeight(bitmap, i, 0);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2, int i3) {
        float height;
        float f;
        float f2 = i;
        float f3 = f2 * 1.0f;
        float f4 = i2;
        float f5 = 0.0f;
        if ((bitmap.getWidth() * 1.0f) / bitmap.getHeight() > f3 / f4) {
            height = f3 / bitmap.getWidth();
            f = (f4 - (bitmap.getHeight() * height)) / 2.0f;
        } else {
            height = (f4 * 1.0f) / bitmap.getHeight();
            f = 0.0f;
            f5 = (f2 - (bitmap.getWidth() * height)) / 2.0f;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(height, height);
        matrix.postTranslate(f5, f);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
        matrix.setRotate(i3);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2) {
        return scaleBitmap(bitmap, i, i2, 0);
    }

    public static int[] getBitmapSize(Resources resources, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] getBitmapSize(byte[] bArr, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] getBitmapSize(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] getBitmapSize(FileDescriptor fileDescriptor, Rect rect) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] getBitmapSize(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] getBitmapSize(InputStream inputStream, Rect rect) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, rect, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int readPictureDegree(String str) {
        int i;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else {
                if (attributeInt != 8) {
                    return 0;
                }
                i = 270;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static boolean is90And270(int i) {
        if (i > 0) {
            return i == 90 || i % 270 == 0;
        }
        return false;
    }

    private static Bitmap createBitmapForMatrix(Bitmap bitmap, float f, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
