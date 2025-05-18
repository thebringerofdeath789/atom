package com.logan.camera;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.broadcasts.NetworkStateReceiver;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.listener.OnNetworkChangeListener;
import com.logan.camera.enums.CaptureMode;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class NotifyReceiver {
    private static final int MSG_ID_CAM_PROGRESS = 7;
    private static final int MSG_ID_CAPTURE_ERROR = 6;
    private static final int MSG_ID_CAPTURE_RECORD = 5;
    private static final int MSG_ID_CARD_STATUS = 3;
    private static final int MSG_ID_EV = 2;
    private static final int MSG_ID_REFRESH_RTSP = 4;
    private static final int MSG_ID_WORK_MODE = 1;
    public static final int STATE_CARD_FULL = 1;
    public static final int STATE_CARD_HAS_READ = 7;
    public static final int STATE_CARD_INSERT = 2;
    public static final int STATE_CARD_LOW_SPEED = 5;
    public static final int STATE_CARD_NEED_FORMAT = 0;
    public static final int STATE_CARD_NOT_KNOWN = 4;
    public static final int STATE_CARD_PULL_OUT = 3;
    public static final int STATE_CARD_TF_MOUNT = 6;
    private static volatile NotifyReceiver instance;

    /* renamed from: in */
    private InputStream f2420in;
    private OnNotifyReceiverListener notifyListener;
    private boolean isConnected = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Socket socket = null;
    private boolean isRevThreadRunning = false;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    public @interface CardState {
    }

    public interface OnCloseListener {
        void onClosed();
    }

    public interface OnNotifyReceiverListener {
        void notifyCamUpgradeProgress(int i);

        void notifyCameraModeChanged(CaptureMode captureMode);

        void notifyCaptureError(String str);

        void notifyCardStateChanged(int i);

        void notifyEndCapture();

        void notifyEndRecord();

        void notifyEvChanged(double d, double d2);

        void notifyNeedRefreshRtsp();

        void notifyStartCapture();

        void notifyStartRecord();
    }

    private NotifyReceiver() {
        NetworkStateReceiver.getInstance().addCallback(new OnNetworkChangeListener() { // from class: com.logan.camera.NotifyReceiver.1
            @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
            public void onCellularStateChanged(boolean z) {
            }

            @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
            public void onNetworkChanged(NetworkType networkType) {
                if (PhoneConfig.isConnectFlightWifi()) {
                    NotifyReceiver.this.startRevThread();
                } else {
                    NotifyReceiver.this.closeSocket(null);
                }
            }
        });
    }

    public static NotifyReceiver getInstance() {
        if (instance == null) {
            synchronized (NotifyReceiver.class) {
                if (instance == null) {
                    NotifyReceiver notifyReceiver = new NotifyReceiver();
                    instance = notifyReceiver;
                    return notifyReceiver;
                }
            }
        }
        return instance;
    }

    public void setNotifyListener(OnNotifyReceiverListener onNotifyReceiverListener) {
        this.notifyListener = onNotifyReceiverListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRevThread() {
        if (this.isRevThreadRunning) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: com.logan.camera.NotifyReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                NotifyReceiver.this.isRevThreadRunning = true;
                while (PhoneConfig.isConnectFlightWifi()) {
                    if (PhoneConfig.isKernelActivityRunning && !NotifyReceiver.this.isConnected && NotifyReceiver.this.notifyListener != null) {
                        try {
                            NotifyReceiver.this.socket = new Socket("192.168.29.1", CameraConfig.PORT);
                            if (NotifyReceiver.this.socket.isConnected()) {
                                NotifyReceiver.this.isConnected = true;
                                NotifyReceiver notifyReceiver = NotifyReceiver.this;
                                notifyReceiver.f2420in = notifyReceiver.socket.getInputStream();
                                byte[] bArr = new byte[100];
                                while (NotifyReceiver.this.f2420in.read(bArr) != -1) {
                                    try {
                                        String str = new String(bArr, "utf-8");
                                        bArr = new byte[100];
                                        String trim = str.trim();
                                        DDLog.m1684e("reslut:" + trim);
                                        final JSONObject parseObject = JSONObject.parseObject(trim);
                                        NotifyReceiver.this.handler.post(new Runnable() { // from class: com.logan.camera.NotifyReceiver.2.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                CaptureMode captureMode;
                                                try {
                                                    switch (parseObject.getInteger("msg_id").intValue()) {
                                                        case 1:
                                                            String string = parseObject.getString(RtspHeaders.Values.MODE);
                                                            DDLog.m1684e("mode: " + string);
                                                            if (NotifyReceiver.this.isEqual(string, CaptureMode.MODE_REC.getValue())) {
                                                                captureMode = CaptureMode.MODE_REC;
                                                            } else {
                                                                captureMode = NotifyReceiver.this.isEqual(string, CaptureMode.MODE_PHOTO.getValue()) ? CaptureMode.MODE_PHOTO : null;
                                                            }
                                                            CameraConfig.get().setCaptureMode(captureMode);
                                                            if (captureMode != null) {
                                                                NotifyReceiver.this.notifyListener.notifyCameraModeChanged(captureMode);
                                                                break;
                                                            }
                                                            break;
                                                        case 2:
                                                            double doubleValue = parseObject.getDouble("cap_ev").doubleValue();
                                                            double doubleValue2 = parseObject.getDouble("rec_ev").doubleValue();
                                                            DDLog.m1684e("cap_ev:" + doubleValue);
                                                            DDLog.m1684e("cap_ev:" + doubleValue2);
                                                            CameraConfig.get().setPhotoEV(doubleValue);
                                                            CameraConfig.get().setRecordEV(doubleValue2);
                                                            NotifyReceiver.this.notifyListener.notifyEvChanged(doubleValue, doubleValue2);
                                                            break;
                                                        case 3:
                                                            int intValue = parseObject.getInteger(NotificationCompat.CATEGORY_STATUS).intValue();
                                                            NotifyReceiver.this.notifyListener.notifyCardStateChanged(intValue);
                                                            EventDispatcher.get().sendEvent(EventID.EVENT_NOTIFY_SD_CARD_STATE, Integer.valueOf(intValue));
                                                            break;
                                                        case 4:
                                                            if (parseObject.getInteger(NotificationCompat.CATEGORY_STATUS).intValue() == 0) {
                                                                NotifyReceiver.this.notifyListener.notifyNeedRefreshRtsp();
                                                                break;
                                                            }
                                                            break;
                                                        case 5:
                                                            String string2 = parseObject.getString(RtspHeaders.Values.MODE);
                                                            String string3 = parseObject.getString("op");
                                                            if (NotifyReceiver.this.isEqual(string2, "cap")) {
                                                                if (NotifyReceiver.this.isEqual(string3, TtmlNode.START)) {
                                                                    NotifyReceiver.this.notifyListener.notifyStartCapture();
                                                                    break;
                                                                } else if (NotifyReceiver.this.isEqual(string3, TtmlNode.END)) {
                                                                    NotifyReceiver.this.notifyListener.notifyEndCapture();
                                                                    break;
                                                                }
                                                            } else if (NotifyReceiver.this.isEqual(string2, "rec")) {
                                                                if (NotifyReceiver.this.isEqual(string3, TtmlNode.START)) {
                                                                    NotifyReceiver.this.notifyListener.notifyStartRecord();
                                                                    break;
                                                                } else if (NotifyReceiver.this.isEqual(string3, TtmlNode.END)) {
                                                                    NotifyReceiver.this.notifyListener.notifyEndRecord();
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case 6:
                                                            NotifyReceiver.this.notifyListener.notifyCaptureError(parseObject.getString("error_msg"));
                                                            break;
                                                        case 7:
                                                            int intValue2 = parseObject.getInteger(NotificationCompat.CATEGORY_STATUS).intValue();
                                                            DDLog.m1685e("ftp", ", 相机给的进度progress: " + intValue2);
                                                            NotifyReceiver.this.notifyListener.notifyCamUpgradeProgress(intValue2);
                                                            break;
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                        });
                                    } catch (Exception e) {
                                        DDLog.m1684e("相机通知解析失败:" + e.getMessage());
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            DDLog.m1684e("相机连接失败:" + e2.getMessage());
                            NotifyReceiver.this.closeSocket(null);
                        }
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (Exception unused) {
                    }
                }
                NotifyReceiver.this.isRevThreadRunning = false;
            }
        });
    }

    public void closeSocket(final OnCloseListener onCloseListener) {
        this.threadPool.execute(new Runnable() { // from class: com.logan.camera.NotifyReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                if (NotifyReceiver.this.socket != null) {
                    try {
                        NotifyReceiver.this.socket.shutdownInput();
                        NotifyReceiver.this.socket.close();
                        NotifyReceiver.this.socket = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (NotifyReceiver.this.f2420in != null) {
                    try {
                        NotifyReceiver.this.f2420in.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    NotifyReceiver.this.f2420in = null;
                }
                NotifyReceiver.this.isConnected = false;
                OnCloseListener onCloseListener2 = onCloseListener;
                if (onCloseListener2 != null) {
                    onCloseListener2.onClosed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEqual(String str, String str2) {
        return str.trim().toLowerCase().equals(str2.trim().toLowerCase());
    }
}