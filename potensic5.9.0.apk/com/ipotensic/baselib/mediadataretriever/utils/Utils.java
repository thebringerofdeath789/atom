package com.ipotensic.baselib.mediadataretriever.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
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
        DDLog.m1691w("bitmap width:" + bitmap.getWidth());
        DDLog.m1691w("bitmap height:" + bitmap.getHeight());
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap transform(android.graphics.Matrix r14, android.graphics.Bitmap r15, int r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.mediadataretriever.utils.Utils.transform(android.graphics.Matrix, android.graphics.Bitmap, int, int, int):android.graphics.Bitmap");
    }
}