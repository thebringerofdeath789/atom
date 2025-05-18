package com.ipotensic.baselib.mediadataretriever.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.ipotensic.baselib.DDLog;
import java.io.File;
import java.io.OutputStream;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes2.dex */
public class Utils {
    public static final int OPTIONS_RECYCLE_INPUT = 2;
    private static final int OPTIONS_SCALE_UP = 1;
    public static final int TARGET_SIZE_MICRO_THUMBNAIL = 96;
    public static final int TARGET_SIZE_MINI_THUMBNAIL = 320;

    public static boolean isLocalFile(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return false;
        }
        String scheme = parse.getScheme();
        return (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase(StringLookupFactory.KEY_FILE)) && new File(str).exists();
    }

    public static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static OutputStream Bitmap2OutputStream(Bitmap bitmap, OutputStream outputStream) {
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        }
        return outputStream;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i) {
        if (i == 1) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > 512) {
                float f = 512.0f / max;
                bitmap = Bitmap.createScaledBitmap(bitmap, Math.round(width * f), Math.round(f * height), true);
            }
        } else if (i == 3) {
            bitmap = extractThumbnail(bitmap, 96, 96, 2);
        }
        DDLog.w("bitmap width:" + bitmap.getWidth());
        DDLog.w("bitmap height:" + bitmap.getHeight());
        return bitmap;
    }

    public static Bitmap extractThumbnail(Bitmap bitmap, int i, int i2, int i3) {
        float f;
        int height;
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() < bitmap.getHeight()) {
            f = i;
            height = bitmap.getWidth();
        } else {
            f = i2;
            height = bitmap.getHeight();
        }
        float f2 = f / height;
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        return transform(matrix, bitmap, i, i2, i3 | 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap transform(Matrix matrix, Bitmap bitmap, int i, int i2, int i3) {
        Matrix matrix2;
        Bitmap createBitmap;
        Bitmap createBitmap2;
        Matrix matrix3 = matrix;
        boolean z = (i3 & 1) != 0;
        boolean z2 = (i3 & 2) != 0;
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        if (!z && (width < 0 || height < 0)) {
            Bitmap createBitmap3 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap3);
            int max = Math.max(0, width / 2);
            int max2 = Math.max(0, height / 2);
            Rect rect = new Rect(max, max2, Math.min(i, bitmap.getWidth()) + max, Math.min(i2, bitmap.getHeight()) + max2);
            int width2 = (i - rect.width()) / 2;
            int height2 = (i2 - rect.height()) / 2;
            canvas.drawBitmap(bitmap, rect, new Rect(width2, height2, i - width2, i2 - height2), (Paint) null);
            if (z2) {
                bitmap.recycle();
            }
            canvas.setBitmap(null);
            return createBitmap3;
        }
        float width3 = bitmap.getWidth();
        float height3 = bitmap.getHeight();
        float f = i;
        float f2 = i2;
        if (width3 / height3 > f / f2) {
            float f3 = f2 / height3;
            if (f3 < 0.9f || f3 > 1.0f) {
                matrix.setScale(f3, f3);
            } else {
                matrix3 = null;
            }
        } else {
            float f4 = f / width3;
            if (f4 < 0.9f || f4 > 1.0f) {
                matrix.setScale(f4, f4);
            } else {
                matrix2 = null;
                createBitmap = matrix2 == null ? Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true) : bitmap;
                if (z2 && createBitmap != bitmap) {
                    bitmap.recycle();
                }
                createBitmap2 = Bitmap.createBitmap(createBitmap, Math.max(0, createBitmap.getWidth() - i) / 2, Math.max(0, createBitmap.getHeight() - i2) / 2, i, i2);
                if (createBitmap2 != createBitmap && (z2 || createBitmap != bitmap)) {
                    createBitmap.recycle();
                }
                return createBitmap2;
            }
        }
        matrix2 = matrix3;
        if (matrix2 == null) {
        }
        if (z2) {
            bitmap.recycle();
        }
        createBitmap2 = Bitmap.createBitmap(createBitmap, Math.max(0, createBitmap.getWidth() - i) / 2, Math.max(0, createBitmap.getHeight() - i2) / 2, i, i2);
        if (createBitmap2 != createBitmap) {
            createBitmap.recycle();
        }
        return createBitmap2;
    }
}