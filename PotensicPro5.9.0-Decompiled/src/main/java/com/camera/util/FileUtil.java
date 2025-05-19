package com.camera.util;

import android.graphics.Bitmap;
import android.os.Environment;
import com.ipotensic.baselib.configs.PhoneConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class FileUtil {
    private static final String TAG = "CJT";
    private static final File parentPath = Environment.getExternalStorageDirectory();
    private static String storagePath = "";
    public static String DST_FOLDER_NAME = "JCamera";
    private static String jpegName = null;

    public interface OnWriteCompleteListener {
        void getStoragePath(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String initPath() {
        if (storagePath.equals("")) {
            storagePath = PhoneConfig.applicationContext.getCacheDir().getPath() + File.separator + DST_FOLDER_NAME;
            File file = new File(storagePath);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return storagePath;
    }

    public static void saveBitmap(final String str, final Bitmap bitmap, final OnWriteCompleteListener onWriteCompleteListener) {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.camera.util.FileUtil.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.DST_FOLDER_NAME = str;
                String unused = FileUtil.jpegName = FileUtil.initPath() + File.separator + "picture_" + System.currentTimeMillis() + ".jpg";
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FileUtil.jpegName));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.camera.util.FileUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (onWriteCompleteListener != null) {
                            onWriteCompleteListener.getStoragePath(FileUtil.jpegName);
                        }
                    }
                });
            }
        });
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
