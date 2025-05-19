package com.logan.camera;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.camera.data.CameraLogData;
import com.logan.flight.FlightConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class CameraLogRecorder {
    private static volatile CameraLogRecorder instance;
    private FileOutputStream gimbalOutputStream;
    private FileOutputStream linuxOutputStream;
    private FileOutputStream liteOsOutputStream;
    private Thread writeThread = null;
    private boolean isStart = false;
    private final Queue<CameraLogData> dataQueue = new LinkedBlockingQueue();

    private CameraLogRecorder() {
    }

    public static CameraLogRecorder get() {
        if (instance == null) {
            synchronized (CameraLogRecorder.class) {
                if (instance == null) {
                    CameraLogRecorder cameraLogRecorder = new CameraLogRecorder();
                    instance = cameraLogRecorder;
                    return cameraLogRecorder;
                }
            }
        }
        return instance;
    }

    public void start() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        if (this.writeThread == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.logan.camera.CameraLogRecorder.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            try {
                                if (!CameraLogRecorder.this.isStart) {
                                    break;
                                }
                                if (!CameraLogRecorder.this.dataQueue.isEmpty()) {
                                    while (CameraLogRecorder.this.isStart && CameraLogRecorder.this.dataQueue.size() > 0) {
                                        CameraLogRecorder.this.write((CameraLogData) CameraLogRecorder.this.dataQueue.remove());
                                    }
                                } else {
                                    Thread.sleep(1L);
                                }
                            } catch (Exception e) {
                                DDLog.e("存储相机日志报错:" + e);
                            }
                        } finally {
                            CameraLogRecorder.this.isStart = false;
                            CameraLogRecorder.this.writeThread = null;
                            CameraLogRecorder.this.dataQueue.clear();
                        }
                    }
                }
            });
            this.writeThread = thread;
            thread.start();
        }
    }

    public void writeLog(CameraLogData cameraLogData) {
        if (this.isStart) {
            this.dataQueue.offer(cameraLogData);
        }
    }

    public void release() {
        if (this.isStart) {
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.camera.CameraLogRecorder.2
                @Override // java.lang.Runnable
                public void run() {
                    CameraLogRecorder.this.stop();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(CameraLogData cameraLogData) throws Exception {
        if (this.isStart) {
            if (cameraLogData.isLinux()) {
                if (this.linuxOutputStream == null) {
                    String logName = FlightConfig.getLogName();
                    if (logName == null) {
                        return;
                    }
                    LocalFileManager.getInstance().deleteOldLogFiles(LocalFileManager.getInstance().getFlightLogDir());
                    String str = FormatUtil.getCurTime() + "-" + logName + LocalFileManager.ANDROID_TAG + PhoneConfig.deviceBrand + "-CAMLinux" + LocalFileManager.LOG_TAIL;
                    DDLog.e("相机日志存储路径:" + str);
                    this.linuxOutputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getFlightLogDir(), str));
                }
                this.linuxOutputStream.write(cameraLogData.getPayload());
            }
            if (cameraLogData.isLiteOs()) {
                if (this.liteOsOutputStream == null) {
                    String logName2 = FlightConfig.getLogName();
                    if (logName2 == null) {
                        return;
                    }
                    LocalFileManager.getInstance().deleteOldLogFiles(LocalFileManager.getInstance().getFlightLogDir());
                    String str2 = FormatUtil.getCurTime() + "-" + logName2 + LocalFileManager.ANDROID_TAG + PhoneConfig.deviceBrand + "-CAMLiteos" + LocalFileManager.LOG_TAIL;
                    DDLog.e("相机日志存储路径:" + str2);
                    this.liteOsOutputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getFlightLogDir(), str2));
                }
                this.liteOsOutputStream.write(cameraLogData.getPayload());
            }
            if (cameraLogData.isGimbal()) {
                if (this.gimbalOutputStream == null) {
                    String logName3 = FlightConfig.getLogName();
                    if (logName3 == null) {
                        return;
                    }
                    LocalFileManager.getInstance().deleteOldLogFiles(LocalFileManager.getInstance().getFlightLogDir());
                    String str3 = FormatUtil.getCurTime() + "-" + logName3 + LocalFileManager.ANDROID_TAG + PhoneConfig.deviceBrand + "-gimbal" + LocalFileManager.LOG_TAIL;
                    DDLog.e("云台日志存储路径:" + str3);
                    this.gimbalOutputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getFlightLogDir(), str3));
                }
                this.gimbalOutputStream.write(cameraLogData.getPayload());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        this.isStart = false;
        FileOutputStream fileOutputStream = this.liteOsOutputStream;
        if (fileOutputStream != null) {
            try {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                this.liteOsOutputStream = null;
            }
        }
        FileOutputStream fileOutputStream2 = this.linuxOutputStream;
        try {
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream3 = this.gimbalOutputStream;
            if (fileOutputStream3 != null) {
                try {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } finally {
                    this.gimbalOutputStream = null;
                }
            }
            DDLog.e("停止存储相机日志");
        } finally {
            this.linuxOutputStream = null;
        }
    }
}
