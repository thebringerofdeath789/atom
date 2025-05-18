package com.logan.flight;

import com.camera.JCameraView;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.netty.handler.OnConnectStateListener;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.logan.camera.CameraConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevCalibrationFeedbackData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.data.recv.FlightRevRemoteCtrlInfoData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.recv.FlightRevUpgradeData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.data.send.SendOthersData;
import com.logan.flight.data.send.UsbPayloadWrapper;
import com.logan.flight.enums.CommonMsgType;
import com.logan.flight.enums.CtrlType;
import com.logan.flight.listeners.OnCloseListener;
import com.logan.upgrade.local.flight.UpgradeManager;
import com.logan.usb.AOAEngine;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DataManager implements EventDispatcher.OnEventListener {
    private static volatile DataManager instance;
    private boolean isGpsSending = false;
    private boolean isAxisSending = false;
    private boolean isRequestSettingInfo = false;
    private boolean isSyncSuccess = false;
    private boolean isSettingSuccess = false;
    private boolean isCalibrationInfo = false;
    private boolean isInRemoterCalibration = false;
    private int reconnectTimes = JCameraView.MEDIA_QUALITY_FUNNY;
    private boolean isMiniPairing = false;
    private CancelRunnable sendOpenSilentReturnTimer = null;
    private CancelRunnable sendCloseSilentReturnTimer = null;
    private AOAEngine.IEngineCallback usbConnectListener = new AOAEngine.IEngineCallback() { // from class: com.logan.flight.DataManager.21
        @Override // com.logan.usb.AOAEngine.IEngineCallback
        public void onUsbAccessoryConnected() {
        }

        @Override // com.logan.usb.AOAEngine.IEngineCallback
        public void onUsbAccessoryDisconnected() {
            if (PhoneConfig.isConnectFlightWifi()) {
                return;
            }
            DataManager.this.connectFailed();
        }

        @Override // com.logan.usb.AOAEngine.IEngineCallback
        public void onUsbAccessoryConnectError() {
            if (PhoneConfig.isConnectFlightWifi()) {
                return;
            }
            DataManager.this.connectFailed();
        }
    };
    private OnConnectStateListener<byte[]> connectStateListener = new OnConnectStateListener<byte[]>() { // from class: com.logan.flight.DataManager.22
        @Override // com.ipotensic.baselib.netty.handler.OnConnectStateListener
        public void onMessageResponseClient(byte[] bArr) {
            DataParser.getInstance().write(bArr);
        }

        @Override // com.ipotensic.baselib.netty.handler.OnConnectStateListener
        public void onClientStatusConnectChanged(int i) {
            try {
                if (i == -1 || i == 0) {
                    DataManager.this.connectFailed();
                    DataManager.this.reConnect();
                } else {
                    if (i != 1) {
                        return;
                    }
                    FlightConfig.isConnectFlightSocket = true;
                    FlightSendData.get().release();
                    FlightRevData.get().release();
                    DataManager.this.requestSettingInfo();
                }
            } catch (Exception unused) {
            }
        }
    };
    private boolean isReconnecting = false;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    public void init() {
    }

    private DataManager() {
        AOAEngine.getInstance().addConnectListener(this.usbConnectListener);
        UpgradeManager.getInstance().init();
        EventDispatcher.get().registerEvent(this);
    }

    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    DataManager dataManager = new DataManager();
                    instance = dataManager;
                    return dataManager;
                }
            }
        }
        return instance;
    }

    public void connect() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataManager.class) {
                    if (!FlightConfig.isConnectFlight()) {
                        DataSender.getInstance().connect(DataManager.this.connectStateListener);
                    }
                }
            }
        });
    }

    public void close() {
        close(null);
    }

    public void close(final OnCloseListener onCloseListener) {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (UsbConfig.isUsbConnected) {
                    DataManager.this.connectFailed();
                    OnCloseListener onCloseListener2 = onCloseListener;
                    if (onCloseListener2 != null) {
                        onCloseListener2.onClosed();
                        return;
                    }
                    return;
                }
                DataSender.getInstance().close(onCloseListener);
            }
        });
    }

    public void requestSettingInfo() {
        DDLog.m1684e("同步飞控版本");
        if (this.isRequestSettingInfo) {
            return;
        }
        this.isRequestSettingInfo = true;
        this.isSyncSuccess = false;
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.3
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    if ((UsbConfig.isUsbConnected || FlightConfig.isConnectFlightSocket) && !DataManager.this.isSyncSuccess) {
                        try {
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            DDLog.m1684e("飞控版本同步设置错误:" + e.getMessage());
                        }
                        if (!PhoneConfig.isKernelActivityRunning && !PhoneConfig.isMainActivityRunning) {
                            Thread.sleep(100L);
                        }
                        DDLog.m1684e("版本 是否还在升级中:" + UpgradeManager.getInstance().isUpgradeStart());
                        DDLog.m1684e("发送飞控版本同步数据:" + ParseUtil.byteToHexString(SendOthersData.getSettingInfoBytes()));
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, SendOthersData.getSettingInfoBytes());
                        Thread.sleep(500L);
                    }
                }
                DataManager.this.isRequestSettingInfo = false;
                DataManager.this.requestGimbalSettingData();
                DDLog.m1691w("飞控版本同步设置结束！");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestGimbalSettingData() {
        if (FlightConfig.isAtomPanTilt()) {
            while (!FlightRevData.get().getGimbalSettingData().isInit() && UsbConfig.isUsbConnected && PhoneConfig.isKernelActivityRunning) {
                DDLog.m1691w("发送同步云台数据");
                FlightSendData.get().getSendGeneralData().setDataType(CommonMsgType.GET_GIMBAL_INFO);
                getInstance().sendGeneralData();
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    DDLog.m1684e("同步云台数据错误:" + e.getMessage());
                }
            }
        }
    }

    public void requestRemoteCtrlInfo() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (UsbConfig.isUsbConnected && FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() == null && !UpgradeManager.getInstance().isUpgradeStart()) {
                        DDLog.m1684e("发送同步遥控器数据:" + ParseUtil.byteToHexString(SendOthersData.getRemoterInfoBytes()));
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getRemoterInfoBytes());
                    }
                } catch (Exception e) {
                    DDLog.m1684e("同步遥控器错误:" + e.getMessage());
                }
            }
        });
    }

    public void requestFpvInfo() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (UsbConfig.isUsbConnected && FlightRevData.get().getFlightRevFpvData().getFpvVersion() == null && !UpgradeManager.getInstance().isUpgradeStart()) {
                        DDLog.m1684e("发送同步图传版本号：" + ParseUtil.byteToHexString(SendOthersData.getFpvInfoBytes()));
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FPV, SendOthersData.getFpvInfoBytes());
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void startSendGps() {
        this.isGpsSending = true;
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.6
            @Override // java.lang.Runnable
            public void run() {
                while (DataManager.this.isGpsSending) {
                    try {
                        Thread.sleep(80L);
                        if (PhoneConfig.isKernelActivityRunning && DataManager.this.isSyncSuccess && FlightConfig.isConnectFlight() && !UpgradeManager.getInstance().isUpgradeStart() && FlightConfig.GPS.getLat() != 0.0d && FlightConfig.GPS.getLng() != 0.0d) {
                            FlightSendData.get().getSendGpsData().setGpsInfo(FlightConfig.GPS.getLat(), FlightConfig.GPS.getLng(), FlightConfig.GPS.getAccuracy(), FlightConfig.GPS.getDirection(), FlightConfig.GPS.getAltitude());
                            DDLog.m1684e("发送gps数据:" + ParseUtil.byteToHexString(FlightSendData.get().getSendGpsData().getBytes()));
                            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendGpsData().getBytes());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void startSend4Axis() {
        this.isAxisSending = true;
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.7
            @Override // java.lang.Runnable
            public void run() {
                while (DataManager.this.isAxisSending) {
                    try {
                        Thread.sleep(80L);
                        if (PhoneConfig.isKernelActivityRunning && DataManager.this.isSyncSuccess && FlightConfig.isConnectFlight() && !UpgradeManager.getInstance().isUpgradeStart()) {
                            DDLog.m1684e("发送四轴数据:" + ParseUtil.byteToHexString(FlightSendData.get().getSend4AxisData().getBytes()));
                            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSend4AxisData().getBytes());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void startSendSetting() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DataManager.this.isSettingSuccess = false;
                    while (FlightConfig.isConnectFlight() && DataManager.this.isSyncSuccess && PhoneConfig.isKernelActivityRunning && !DataManager.this.isSettingSuccess && FlightSendData.get().getSendFlightSetData().isInit()) {
                        byte[] bytes = FlightSendData.get().getSendFlightSetData().getBytes();
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, bytes);
                        DDLog.m1684e("发送飞控设置数据: " + ParseUtil.byteToHexString(bytes));
                        Thread.sleep(1000L);
                    }
                    FlightSendData.get().getSendFlightSetData().finishSpeedSetting();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void startSendMultiPointData() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (DataManager.this.isSyncSuccess) {
                    DDLog.m1684e("发送指点航行数据:" + ParseUtil.byteToHexString(FlightSendData.get().getSendMultiPointData().getBytes()));
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendMultiPointData().getBytes());
                }
            }
        });
    }

    public void startSendHexahedralCalibration() {
        this.isCalibrationInfo = true;
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.10
            @Override // java.lang.Runnable
            public void run() {
                while (DataManager.this.isCalibrationInfo) {
                    try {
                        if (PhoneConfig.isKernelActivityRunning && FlightConfig.isConnectFlight() && DataManager.this.isSyncSuccess) {
                            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendCalibrationControlData().getBytes());
                            DDLog.m1687i("发送校准反馈信息：" + ParseUtil.byteToHexString(FlightSendData.get().getSendCalibrationControlData().getBytes()));
                            Thread.sleep(500L);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
    }

    public void startSendPTZData() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.11
            @Override // java.lang.Runnable
            public void run() {
                if (PhoneConfig.isKernelActivityRunning && FlightConfig.isConnectFlight() && DataManager.this.isSyncSuccess) {
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendPTZData().getBytes());
                    DDLog.m1687i("发送云台信息反馈：" + ParseUtil.byteToHexString(FlightSendData.get().getSendPTZData().getBytes()));
                }
            }
        });
    }

    public void startSendCtrlData() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.12
            @Override // java.lang.Runnable
            public void run() {
                if (FlightConfig.isConnectFlight() && DataManager.this.isSyncSuccess) {
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendCtrlData().getBytes());
                    DDLog.m1684e("发送控制指令：" + ParseUtil.byteToHexString(FlightSendData.get().getSendCtrlData().getBytes()));
                }
            }
        });
    }

    public void sendReturnAltitude() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.13
            @Override // java.lang.Runnable
            public void run() {
                if (PhoneConfig.isKernelActivityRunning && FlightConfig.isConnectFlight() && DataManager.this.isSyncSuccess) {
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getReturnAltitudeData().getBytes());
                }
            }
        });
    }

    public void sendReturnHover() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.14
            @Override // java.lang.Runnable
            public void run() {
                if (PhoneConfig.isKernelActivityRunning && FlightConfig.isConnectFlight()) {
                    for (int i = 0; i < 3; i++) {
                        DDLog.m1684e("发送返航悬停" + ParseUtil.byteToHexString(FlightSendData.get().getSendReturnHoverData().getBytes()));
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendReturnHoverData().getBytes());
                        try {
                            Thread.sleep(80L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void sendMiniPair() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.15
            @Override // java.lang.Runnable
            public void run() {
                DataManager.this.isMiniPairing = false;
                if (PhoneConfig.isKernelActivityRunning && FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FPV, FlightSendData.get().getSendMiniPairData().getBytes());
                    DDLog.m1684e("发送对频数据：" + ParseUtil.byteToHexString(FlightSendData.get().getSendMiniPairData().getBytes()));
                }
            }
        });
    }

    public void openRemoterCalibration() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.16
            @Override // java.lang.Runnable
            public void run() {
                DataManager.this.isInRemoterCalibration = false;
                while (!DataManager.this.isInRemoterCalibration && PhoneConfig.isKernelActivityRunning && FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
                    try {
                        Thread.sleep(500L);
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getOpenRemoterCalibrationBytes());
                        DDLog.m1684e("发送开启遥控器校准：" + ParseUtil.byteToHexString(SendOthersData.getOpenRemoterCalibrationBytes()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void closeRemoterCalibration() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.17
            @Override // java.lang.Runnable
            public void run() {
                if (DataManager.this.isInRemoterCalibration && FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
                    try {
                        Thread.sleep(80L);
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getCloseRemoterCalibrationBytes());
                        Thread.sleep(80L);
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getCloseRemoterCalibrationBytes());
                        DDLog.m1684e("发送关闭遥控器校准：" + ParseUtil.byteToHexString(SendOthersData.getCloseRemoterCalibrationBytes()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                DataManager.this.isInRemoterCalibration = false;
            }
        });
    }

    public void controlRemoterMute(final boolean z) {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.flight.-$$Lambda$DataManager$sSBhH1iZnnNg7HjDhmHRyA3eRfs
            @Override // java.lang.Runnable
            public final void run() {
                DataManager.this.lambda$controlRemoterMute$0$DataManager(z);
            }
        });
    }

    public /* synthetic */ void lambda$controlRemoterMute$0$DataManager(boolean z) {
        try {
            if (z) {
                startSendOpenRemoterMuteData();
                DDLog.m1684e("发送开启遥控器静音：" + ParseUtil.byteToHexString(SendOthersData.getOpenRemoterMuteBytes()));
            } else {
                startSendCloseRemoterMuteData();
                DDLog.m1684e("发送关闭遥控器静音：" + ParseUtil.byteToHexString(SendOthersData.getCloseRemoterMuteBytes()));
            }
        } catch (Exception e) {
            DDLog.m1684e("controlRemoterMute exception is " + e.getMessage());
        }
    }

    private void startSendOpenRemoterMuteData() {
        if (this.sendOpenSilentReturnTimer == null) {
            CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.logan.flight.DataManager.18
                @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
                public void run() {
                    if (FlightRevData.get().getRemoterMuteData().isRemoterMuteOpened()) {
                        DataManager.this.lambda$startSendOpenRemoterMuteData$1$DataManager();
                    } else {
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getOpenRemoterMuteBytes());
                    }
                }
            };
            this.sendOpenSilentReturnTimer = cancelRunnable;
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.sendOpenSilentReturnTimer, 0L, 100L, TimeUnit.MILLISECONDS));
            PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.logan.flight.-$$Lambda$DataManager$5aemFAqRhVlQTBjxKAKuOhBsWgg
                @Override // java.lang.Runnable
                public final void run() {
                    DataManager.this.lambda$startSendOpenRemoterMuteData$1$DataManager();
                }
            }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    private void startSendCloseRemoterMuteData() {
        if (this.sendCloseSilentReturnTimer == null) {
            CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.logan.flight.DataManager.19
                @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
                public void run() {
                    if (FlightRevData.get().getRemoterMuteData().isRemoterMuteClosed()) {
                        DataManager.this.lambda$startSendCloseRemoterMuteData$2$DataManager();
                    } else {
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getCloseRemoterMuteBytes());
                    }
                }
            };
            this.sendCloseSilentReturnTimer = cancelRunnable;
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.sendCloseSilentReturnTimer, 0L, 100L, TimeUnit.MILLISECONDS));
            PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.logan.flight.-$$Lambda$DataManager$BlMxYvV3mQyT3zqsJt0tIYJoPc4
                @Override // java.lang.Runnable
                public final void run() {
                    DataManager.this.lambda$startSendCloseRemoterMuteData$2$DataManager();
                }
            }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: stopSendOpenRemoterMuteData, reason: merged with bridge method [inline-methods] */
    public void lambda$startSendOpenRemoterMuteData$1$DataManager() {
        CancelRunnable cancelRunnable = this.sendOpenSilentReturnTimer;
        if (cancelRunnable != null) {
            cancelRunnable.getFuture().cancel(true);
            this.sendOpenSilentReturnTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: stopSendCloseRemoterMuteData, reason: merged with bridge method [inline-methods] */
    public void lambda$startSendCloseRemoterMuteData$2$DataManager() {
        CancelRunnable cancelRunnable = this.sendCloseSilentReturnTimer;
        if (cancelRunnable != null) {
            cancelRunnable.getFuture().cancel(true);
            this.sendCloseSilentReturnTimer = null;
        }
    }

    public void sendReplyTakeoff() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.20
            @Override // java.lang.Runnable
            public void run() {
                if (PhoneConfig.isKernelActivityRunning && FlightConfig.isConnectFlight()) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendReplyTakeoff().getBytes());
                            Thread.sleep(50L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void sendCtrlData(CtrlType ctrlType) {
        if (PhoneConfig.isKernelActivityRunning && this.isSyncSuccess) {
            FlightSendData.get().getSendCtrlData().setCtrlType(ctrlType);
            DDLog.m1684e("发送控制指令:" + ctrlType);
            DDLog.m1684e("发送控制指令:" + ParseUtil.byteToHexString(FlightSendData.get().getSendCtrlData().getBytes()));
            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendCtrlData().getBytes());
        }
    }

    public void sendGimbalSettingData() {
        if (PhoneConfig.isKernelActivityRunning && this.isSyncSuccess) {
            DDLog.m1684e("发送云台设置:" + ParseUtil.byteToHexString(FlightSendData.get().getSendGimbalSettingData().getBytes()));
            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendGimbalSettingData().getBytes());
        }
    }

    public void stopAutoSend() {
        this.isGpsSending = false;
        this.isAxisSending = false;
    }

    public void resetSetting() {
        this.isSyncSuccess = false;
    }

    public boolean isSettingSyncSuccess() {
        return this.isSyncSuccess;
    }

    private void connectSuccess() {
        FlightConfig.connectStatus = 1;
        EventDispatcher.get().sendEvent(EventID.FLIGHT_CONNECT_STATE_CHANGED, Boolean.valueOf(FlightConfig.connectStatus == 1));
        DDLog.m1684e("飞控连接状态 = 连接成功");
        this.reconnectTimes = 4000;
        if (!this.isGpsSending) {
            startSendGps();
        }
        if (this.isAxisSending) {
            return;
        }
        startSend4Axis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectFailed() {
        FlightConfig.connectStatus = 0;
        EventDispatcher.get().sendEvent(EventID.FLIGHT_CONNECT_STATE_CHANGED, Boolean.valueOf(FlightConfig.connectStatus == 1));
        DDLog.m1684e("飞控连接状态 = 连接断开");
        FlightConfig.curFlight = null;
        UsbConfig.isNewFC = false;
        UsbConfig.isInit = false;
        FlightConfig.isConnectFlightSocket = false;
        this.isSyncSuccess = false;
        UpgradeManager.getInstance().upgradeFailed();
        stopAutoSend();
        DataParser.getInstance().release();
        FlightSendData.get().release();
        FlightRevData.get().release();
        CameraConfig.get().release();
        AOAEngine.getInstance().releaseDecoder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reConnect() {
        int i = this.reconnectTimes - 1;
        this.reconnectTimes = i;
        if (i >= 0 && PhoneConfig.isConnectFlightWifi() && PhoneConfig.isKernelActivityRunning) {
            this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.23
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DataManager.this.isReconnecting) {
                            return;
                        }
                        DataManager.this.isReconnecting = true;
                        Thread.sleep(1000L);
                        DDLog.m1684e("重连第" + (4000 - DataManager.this.reconnectTimes) + "次");
                        DataManager.this.connect();
                        DataManager.this.isReconnecting = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public int sendFactoryTestData(final byte[] bArr) {
        if (!this.isSyncSuccess) {
            return 1;
        }
        if (!FlightRevData.get().getFlightRevStateData().isSmartBatteryAbnormal()) {
            return 2;
        }
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.24
            @Override // java.lang.Runnable
            public void run() {
                byte[] wrap = UsbPayloadWrapper.wrap((short) 16, bArr);
                DDLog.m1691w("发送产测测试数据:" + ParseUtil.byteToHexString(wrap));
                DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, wrap);
            }
        });
        return 0;
    }

    public int sendRestoreDevice() {
        if (!this.isSyncSuccess) {
            DDLog.m1691w("发送测试数据返回1");
            return 1;
        }
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.DataManager.25
            @Override // java.lang.Runnable
            public void run() {
                byte[] wrap = UsbPayloadWrapper.wrap((short) 7, new byte[]{1});
                DDLog.m1691w("发送 p1self 测试数据:" + ParseUtil.byteToHexString(wrap));
                DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, wrap);
            }
        });
        return 0;
    }

    public void sendGeneralData() {
        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendGeneralData().getBytes());
    }

    /* renamed from: com.logan.flight.DataManager$26 */
    static /* synthetic */ class C294926 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_SETTING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_UPGRADE_MODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_HOME_POINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_FPV_INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_CALIBRATION_FEEDBACK_INFO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_CALIBRATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_INFO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_GIMBAL_SETTING_DATA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        boolean z = false;
        switch (C294926.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                FlightSendData.get().getSendFlightSetData().init((FlightRevSettingData) event.obj);
                DDLog.m1684e("同步：" + FlightRevData.get().getFlightRevVersionData().getFlightControlVersion());
                if (FlightRevData.get().getFlightRevVersionData().getFlightControlVersion() != null) {
                    this.isSyncSuccess = true;
                }
                this.isSettingSuccess = true;
                break;
            case 2:
                FlightRevVersionData flightRevVersionData = (FlightRevVersionData) event.obj;
                if (flightRevVersionData.getFlightControlVersion() != null && !FlightConfig.isConnectFlight()) {
                    connectSuccess();
                }
                UpgradeManager.getInstance().onReceiveFlightVersion(flightRevVersionData);
                break;
            case 3:
                DDLog.m1687i("收到遥控器信息:" + ((FlightRevRemoteCtrlInfoData) event.obj).toString());
                break;
            case 4:
                if (!FlightConfig.isConnectFlight()) {
                    FlightRevUpgradeData flightRevUpgradeData = (FlightRevUpgradeData) event.obj;
                    if (flightRevUpgradeData.getUpgradeType() != 80) {
                        flightRevUpgradeData.getUpgradeType();
                        break;
                    }
                }
                break;
            case 5:
                FlightRevConnectData flightRevConnectData = (FlightRevConnectData) event.obj;
                if (flightRevConnectData.isWirelessConnected() && flightRevConnectData.isFlightCtrlConnected()) {
                    if (FlightConfig.connectStatus != 1 && (((PhoneConfig.isKernelActivityRunning && !PhoneConfig.isKernelActivityPause) || PhoneConfig.isMainActivityRunning) && FlightRevData.get().getFlightRevVersionData().getFlightControlVersion() == null)) {
                        DDLog.m1684e("开始同步飞控版本");
                        requestSettingInfo();
                    }
                } else if (FlightConfig.connectStatus != 0) {
                    connectFailed();
                }
                DDLog.m1691w("图传版本号:" + FlightRevData.get().getFlightRevFpvData().getFpvVersion());
                if (FlightRevData.get().getFlightRevFpvData().getFpvVersion() == null) {
                    DDLog.m1685e("66666", " 同步图传信息");
                    requestFpvInfo();
                }
                DDLog.m1691w("遥控器版本号:" + FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion());
                if (FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() == null) {
                    DDLog.m1685e("66666", " 同步遥控器信息");
                    requestRemoteCtrlInfo();
                }
                if (flightRevConnectData.isMiniPairing()) {
                    this.isMiniPairing = true;
                    break;
                }
                break;
            case 6:
                FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
                FlightRevHomePointData flightRevHomePointData = FlightRevData.get().getFlightRevHomePointData();
                if (flightRevStateData != null && (flightRevStateData.isFlight() || flightRevStateData.isTakeOff() || flightRevStateData.isUnLock())) {
                    z = true;
                }
                flightRevHomePointData.setInitThisFly(z);
                DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, FlightSendData.get().getSendHomeRevData().getBytes());
                DDLog.m1687i("发送home点已收到指令：" + ParseUtil.byteToHexString(FlightSendData.get().getSendHomeRevData().getBytes()));
                break;
            case 7:
                FlightRevData.get().getFlightRevFpvData().isFpvData();
                break;
            case 8:
                if (((FlightRevCalibrationFeedbackData) event.obj).isSixFacesCalibrationStart()) {
                    this.isCalibrationInfo = false;
                    break;
                }
                break;
            case 9:
                this.isInRemoterCalibration = true;
                break;
            case 11:
                FlightRevStateData flightRevStateData2 = (FlightRevStateData) event.obj;
                if (flightRevStateData2 != null) {
                    FlightSendData.get().getSendFlightSetData().init(flightRevStateData2);
                    if (!flightRevStateData2.isFlight() && !flightRevStateData2.isTakeOff()) {
                        FlightRevData.get().getFlightRevHomePointData().setInitThisFly(false);
                        break;
                    }
                }
                break;
            case 12:
                FlightRevGimbalSettingData flightRevGimbalSettingData = (FlightRevGimbalSettingData) event.obj;
                if (flightRevGimbalSettingData != null) {
                    FlightSendData.get().getSendGimbalSettingData().init(flightRevGimbalSettingData);
                    break;
                }
                break;
        }
    }
}