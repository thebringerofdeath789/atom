package com.ipotensic.baselib.utils.compress;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ImageUtil {
    private static int calculateInSampleSize(BitmapFactory.Options options, String str, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 == -1 || i4 == -1) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                i3 = exifInterface.getAttributeInt("ImageLength", 1);
                i4 = exifInterface.getAttributeInt("ImageWidth", 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeResource(resources, i, options), i2, i3, options.inSampleSize);
    }

    private static Bitmap createScaleBitmap(Bitmap bitmap, int i, int i2, int i3) {
        if (i3 % 2 == 0) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
        if (bitmap != createScaledBitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, str, i, i2);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeFile(str, options), i, i2, options.inSampleSize);
    }

    public static void deleteTempFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }
}
