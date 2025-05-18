package com.ipotensic.baselib.utils;

import android.os.FileObserver;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import java.io.File;

/* loaded from: classes2.dex */
public class FileSystemChangeListener extends FileObserver {
    private OnFileChangeListener changeListener;
    private final Runnable fileChangeRunnable;
    private File[] lastFiles;
    private String path;

    public interface OnFileChangeListener {
        void onFileChanged();
    }

    public FileSystemChangeListener(String str, OnFileChangeListener onFileChangeListener) {
        super(str, 4034);
        this.fileChangeRunnable = new Runnable() { // from class: com.ipotensic.baselib.utils.FileSystemChangeListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (FileSystemChangeListener.this.changeListener != null) {
                    FileSystemChangeListener.this.changeListener.onFileChanged();
                }
            }
        };
        this.path = str;
        this.changeListener = onFileChangeListener;
        this.lastFiles = getFiles();
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        boolean z;
        try {
            if (ActivityHelper.getInstance().isAppInForeground()) {
                return;
            }
            DDLog.e("\u6587\u4ef6\u53d8\u52a8:" + i + " , " + str);
            File[] files = getFiles();
            int length = files.length;
            File[] fileArr = this.lastFiles;
            if (length > fileArr.length) {
                callback();
            } else if (files.length < fileArr.length) {
                callback();
            } else {
                for (File file : files) {
                    File[] fileArr2 = this.lastFiles;
                    int length2 = fileArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = false;
                            break;
                        }
                        if (file.getAbsolutePath().equals(fileArr2[i2].getAbsolutePath())) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        callback();
                    }
                }
            }
            this.lastFiles = files;
        } catch (Exception e) {
            DDLog.e("\u6587\u4ef6\u53d8\u5316\u901a\u77e5\u9519\u8bef \uff1a" + e);
        }
    }

    private File[] getFiles() {
        File[] listFiles = new File(this.path).listFiles();
        return listFiles == null ? new File[0] : listFiles;
    }

    private void callback() {
        PhoneConfig.mainHandler.removeCallbacks(this.fileChangeRunnable);
        PhoneConfig.mainHandler.postDelayed(this.fileChangeRunnable, 200L);
    }
}