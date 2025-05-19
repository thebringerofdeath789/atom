package com.ipotensic.baselib.netty.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class HeartUtil {
    public static String getFaceCacheDir(Context context) {
        if (isExternalStorageWritable()) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        }
        return context.getFilesDir().getPath();
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, getFileByPath(str), compressFormat, z);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x002f -> B:18:0x0044). Please report as a decompilation issue!!! */
    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        boolean z2 = false;
        if (isEmptyBitmap(bitmap) || !createFileByDeleteOldFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    z2 = bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                    if (z && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    bufferedOutputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return z2;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    private static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }
}
