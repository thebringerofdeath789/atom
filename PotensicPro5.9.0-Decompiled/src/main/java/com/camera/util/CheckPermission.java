package com.camera.util;

import android.hardware.Camera;
import android.media.AudioRecord;
import android.util.Log;

/* loaded from: classes.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                Log.d("CheckAudioPermission", "录音机被占用");
                return -1;
            }
            if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                Log.d("CheckAudioPermission", "录音的结果为空");
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }

    public static synchronized boolean isCameraUseable(int i) {
        boolean z;
        synchronized (CheckPermission.class) {
            z = false;
            Camera camera = null;
            try {
                try {
                    try {
                        camera = Camera.open(i);
                        camera.setParameters(camera.getParameters());
                        if (camera != null) {
                            camera.release();
                            z = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (camera != null) {
                        camera.release();
                    }
                }
            } catch (Throwable th2) {
                if (camera != null) {
                    camera.release();
                }
                throw th2;
            }
        }
        return z;
    }
}
