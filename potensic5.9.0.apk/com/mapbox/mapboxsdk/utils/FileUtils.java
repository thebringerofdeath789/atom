package com.mapbox.mapboxsdk.utils;

import android.os.AsyncTask;
import com.mapbox.mapboxsdk.log.Logger;
import java.io.File;

/* loaded from: classes3.dex */
public class FileUtils {
    private static final String TAG = "Mbgl-FileUtils";

    public interface OnCheckFileReadPermissionListener {
        void onError();

        void onReadPermissionGranted();
    }

    public interface OnCheckFileWritePermissionListener {
        void onError();

        void onWritePermissionGranted();
    }

    public static class CheckFileReadPermissionTask extends AsyncTask<File, Void, Boolean> {
        private final OnCheckFileReadPermissionListener listener;

        public CheckFileReadPermissionTask(OnCheckFileReadPermissionListener onCheckFileReadPermissionListener) {
            this.listener = onCheckFileReadPermissionListener;
        }

        @Override // android.os.AsyncTask
        protected Boolean doInBackground(File... fileArr) {
            try {
                return Boolean.valueOf(fileArr[0].canRead());
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            this.listener.onError();
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.listener.onReadPermissionGranted();
            } else {
                this.listener.onError();
            }
        }
    }

    public static class CheckFileWritePermissionTask extends AsyncTask<File, Void, Boolean> {
        private final OnCheckFileWritePermissionListener listener;

        public CheckFileWritePermissionTask(OnCheckFileWritePermissionListener onCheckFileWritePermissionListener) {
            this.listener = onCheckFileWritePermissionListener;
        }

        @Override // android.os.AsyncTask
        protected Boolean doInBackground(File... fileArr) {
            try {
                return Boolean.valueOf(fileArr[0].canWrite());
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            this.listener.onError();
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.listener.onWritePermissionGranted();
            } else {
                this.listener.onError();
            }
        }
    }

    public static void deleteFile(final String str) {
        new Thread(new Runnable() { // from class: com.mapbox.mapboxsdk.utils.FileUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        if (file.delete()) {
                            Logger.m1754d(FileUtils.TAG, "File deleted to save space: " + str);
                        } else {
                            Logger.m1756e(FileUtils.TAG, "Failed to delete file: " + str);
                        }
                    }
                } catch (Exception e) {
                    Logger.m1757e(FileUtils.TAG, "Failed to delete file: ", e);
                }
            }
        }).start();
    }
}