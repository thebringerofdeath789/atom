package com.ipotensic.baselib.utils;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.SimpleResultListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class FileSaver extends Thread {
    private File file;
    private SimpleResultListener<Boolean> resultListener;
    private AtomicBoolean isStartSave = new AtomicBoolean(false);
    private volatile Queue<byte[]> bytes = new LinkedBlockingQueue();

    public FileSaver(File file) {
        this.file = file;
    }

    public void write(byte[] bArr) {
        if (this.bytes.size() < 100) {
            this.bytes.add(bArr);
        }
    }

    public void close(SimpleResultListener<Boolean> simpleResultListener) {
        this.resultListener = simpleResultListener;
        this.isStartSave.set(false);
        this.bytes.clear();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.isStartSave.set(true);
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            while (this.isStartSave.get()) {
                if (this.bytes.size() > 0) {
                    fileOutputStream.write(this.bytes.remove());
                    fileOutputStream.flush();
                } else {
                    Thread.sleep(10L);
                }
            }
            fileOutputStream.close();
        } catch (Exception e) {
            DDLog.e("FileSaver存储报错:" + e.getMessage());
        }
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.utils.FileSaver.1
            @Override // java.lang.Runnable
            public void run() {
                if (FileSaver.this.resultListener != null) {
                    FileSaver.this.resultListener.onResult(true);
                }
            }
        });
    }
}
