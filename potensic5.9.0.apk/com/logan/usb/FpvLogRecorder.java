package com.logan.usb;

import android.os.Handler;
import android.os.Message;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.CustomHandlerThread;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.usb.AOAEngine;
import java.io.File;
import java.io.FileWriter;

/* loaded from: classes3.dex */
public class FpvLogRecorder {
    private static volatile FpvLogRecorder instance;
    private CustomHandlerThread handlerThread;
    private final int WRITE_LOG = 1;
    private final int CLOSE_THREAD = 2;
    private FileWriter fileWriter = null;
    private String filePath = null;
    public EventDispatcher.OnEventListener writeLogEvenListener = new EventDispatcher.OnEventListener() { // from class: com.logan.usb.FpvLogRecorder.2
        @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
        public void onEvent(EventID eventID, Event event) {
            if (eventID == EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE) {
                FlightRevConnectData flightRevConnectData = (FlightRevConnectData) event.obj;
                try {
                    if (FpvLogRecorder.this.filePath != null && !new File(FpvLogRecorder.this.filePath).exists() && FpvLogRecorder.this.handlerThread != null) {
                        FpvLogRecorder.this.handlerThread.getHandler().sendEmptyMessage(2);
                    }
                    if (FpvLogRecorder.this.handlerThread == null) {
                        FpvLogRecorder.this.start();
                    }
                    Message message = new Message();
                    message.what = 1;
                    message.obj = flightRevConnectData;
                    FpvLogRecorder.this.handlerThread.getHandler().sendMessage(message);
                } catch (Exception e) {
                    DDLog.m1684e("fpv data save error:" + e.getMessage());
                }
            }
        }
    };

    private FpvLogRecorder() {
        init();
    }

    public static FpvLogRecorder getInstance() {
        if (instance == null) {
            synchronized (FpvLogRecorder.class) {
                if (instance == null) {
                    FpvLogRecorder fpvLogRecorder = new FpvLogRecorder();
                    instance = fpvLogRecorder;
                    return fpvLogRecorder;
                }
            }
        }
        return instance;
    }

    private void init() {
        AOAEngine.getInstance().addConnectListener(new AOAEngine.IEngineCallback() { // from class: com.logan.usb.FpvLogRecorder.1
            @Override // com.logan.usb.AOAEngine.IEngineCallback
            public void onUsbAccessoryConnectError() {
            }

            @Override // com.logan.usb.AOAEngine.IEngineCallback
            public void onUsbAccessoryConnected() {
            }

            @Override // com.logan.usb.AOAEngine.IEngineCallback
            public void onUsbAccessoryDisconnected() {
                if (FpvLogRecorder.this.handlerThread != null) {
                    FpvLogRecorder.this.handlerThread.getHandler().sendEmptyMessage(2);
                }
            }
        });
    }

    public void start() {
        if (this.handlerThread == null) {
            this.handlerThread = new CustomHandlerThread("save_fpv_log", new Handler.Callback() { // from class: com.logan.usb.FpvLogRecorder.3
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FpvLogRecorder fpvLogRecorder;
                    try {
                        if (message.what == 1) {
                            FlightRevConnectData flightRevConnectData = (FlightRevConnectData) message.obj;
                            if (FpvLogRecorder.this.fileWriter == null && FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null) {
                                String logName = FlightConfig.getLogName();
                                if (logName == null) {
                                    return false;
                                }
                                FpvLogRecorder.this.filePath = LocalFileManager.getInstance().getFlightLogDir() + File.separator + (FormatUtil.getCurTime() + "-" + logName + LocalFileManager.ANDROID_TAG + "(" + PhoneConfig.deviceBrand + ")-FPV.bin");
                                DDLog.m1684e("存储图传日志路径：" + FpvLogRecorder.this.filePath);
                                FpvLogRecorder.this.fileWriter = new FileWriter(new File(FpvLogRecorder.this.filePath));
                            }
                            if (FpvLogRecorder.this.fileWriter != null) {
                                FpvLogRecorder.this.fileWriter.write(flightRevConnectData.getLogString());
                                FpvLogRecorder.this.fileWriter.flush();
                            }
                        } else if (message.what == 2) {
                            if (FpvLogRecorder.this.fileWriter != null) {
                                try {
                                    FpvLogRecorder.this.fileWriter.close();
                                    fpvLogRecorder = FpvLogRecorder.this;
                                } catch (Exception unused) {
                                    fpvLogRecorder = FpvLogRecorder.this;
                                } catch (Throwable th) {
                                    FpvLogRecorder.this.fileWriter = null;
                                    throw th;
                                }
                                fpvLogRecorder.fileWriter = null;
                            }
                            if (FpvLogRecorder.this.handlerThread != null) {
                                FpvLogRecorder.this.handlerThread.quit();
                                FpvLogRecorder.this.handlerThread = null;
                            }
                            DDLog.m1684e("停止存储图传日志");
                        }
                    } catch (Exception e) {
                        DDLog.m1684e("存储图传日志报错 ：" + e.getMessage());
                    }
                    return false;
                }
            });
        }
    }

    public void finish() {
        CustomHandlerThread customHandlerThread = this.handlerThread;
        if (customHandlerThread != null) {
            customHandlerThread.getHandler().sendEmptyMessage(2);
        }
    }
}