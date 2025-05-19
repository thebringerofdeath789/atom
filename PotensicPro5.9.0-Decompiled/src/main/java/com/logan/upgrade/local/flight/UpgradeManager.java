package com.logan.upgrade.local.flight;

import android.os.Handler;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.DataManager;
import com.logan.flight.DataSender;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.data.send.SendOthersData;
import com.logan.flight.data.send.UsbPayloadWrapper;
import com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwFileData;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwRunData;
import com.logan.upgrade.local.flight.send.SendFwFileData;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes3.dex */
public class UpgradeManager {
    private static volatile UpgradeManager instance;
    private FileGiver fileGiver;
    private SendFwFileData sendFile;
    private int totalNum;
    private Handler upgradeHandler;
    private IFlightUpgradeProgressListener upgradeProgressListener;
    private final int SEND_TIMEOUT = 2000;
    private final byte[] upgradeLock = new byte[1];
    private boolean isRun = false;
    private boolean needReUpload = false;
    private boolean isUploadFinish = false;
    private int reUploadTimes = 10;
    private boolean isUpgradeStart = false;
    private boolean isUpgradeShakeHandSuccess = false;
    private boolean isReceiveCheckLen = false;
    private boolean isReceiveFwRun = false;
    private byte upgradeType = 16;
    private byte upgradeFuncCode = 31;
    private byte upgradeSendTo = UsbConfig.USB_TYPE_APP_TO_FLIGHT;
    final Runnable reUploadRunnable = new Runnable() { // from class: com.logan.upgrade.local.flight.UpgradeManager.4
        @Override // java.lang.Runnable
        public void run() {
            synchronized (UpgradeManager.this.upgradeLock) {
                UpgradeManager.this.needReUpload = true;
                UpgradeManager.this.upgradeLock.notify();
            }
        }
    };
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    static /* synthetic */ int access$810(UpgradeManager upgradeManager) {
        int i = upgradeManager.reUploadTimes;
        upgradeManager.reUploadTimes = i - 1;
        return i;
    }

    private UpgradeManager() {
    }

    public void init() {
        this.upgradeHandler = new Handler();
    }

    public static UpgradeManager getInstance() {
        if (instance == null) {
            synchronized (UpgradeManager.class) {
                if (instance == null) {
                    UpgradeManager upgradeManager = new UpgradeManager();
                    instance = upgradeManager;
                    return upgradeManager;
                }
            }
        }
        return instance;
    }

    public void setFlightUpgradeProgressListener(IFlightUpgradeProgressListener iFlightUpgradeProgressListener) {
        this.upgradeProgressListener = iFlightUpgradeProgressListener;
    }

    public void setUpgradeType(byte b) {
        this.upgradeType = b;
        if (b == 17) {
            this.upgradeFuncCode = UsbConfig.SEND_FUNCTION_CODE_REMOTE_CONTROL;
            this.upgradeSendTo = UsbConfig.USB_TYPE_APP_TO_REMOTER;
        } else {
            this.upgradeFuncCode = (byte) 31;
            this.upgradeSendTo = UsbConfig.USB_TYPE_APP_TO_FLIGHT;
        }
    }

    public byte getUpgradeType() {
        return this.upgradeType;
    }

    public void switchToUpgradeMode() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.local.flight.UpgradeManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DDLog.e("开始升级");
                    UpgradeManager.this.isUpgradeStart = true;
                    UpgradeManager.this.isUpgradeShakeHandSuccess = false;
                    while (!UpgradeManager.this.isUpgradeShakeHandSuccess) {
                        if (!FlightConfig.isConnectFlightSocket && !UsbConfig.isUsbConnected) {
                            return;
                        }
                        if (UsbConfig.isUsbConnected) {
                            if (UpgradeManager.this.upgradeType == 17 || UpgradeManager.this.upgradeType == 16) {
                                FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(true);
                            }
                            if (UpgradeManager.this.upgradeType == 17) {
                                DDLog.e("升级屏蔽飞控数据");
                                DataSender.getInstance().sendUpgradeData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, SendOthersData.getCloseFlightOutputBytes());
                            } else {
                                DDLog.e("升级屏蔽遥控器数据");
                                DataSender.getInstance().sendUpgradeData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getCloseRemoterOutputBytes());
                            }
                        }
                        if (UpgradeManager.this.upgradeType != 17) {
                            DDLog.e("切换升级模式");
                            DataSender.getInstance().sendUpgradeData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, UsbPayloadWrapper.wrap((short) 9, new byte[]{2, UpgradeManager.this.upgradeType}));
                        }
                        Thread.sleep(1000L);
                        byte[] wrap = UsbPayloadWrapper.wrap(UpgradeManager.this.upgradeFuncCode, FlightSendData.get().getSendShakeHandData().getBytes());
                        DDLog.e("发送升级握手：" + ParseUtil.byteToHexString(wrap));
                        DDLog.e("发送升级握手：" + ParseUtil.byteToHexString(new byte[]{UpgradeManager.this.upgradeFuncCode}));
                        DataSender.getInstance().sendUpgradeData(UpgradeManager.this.upgradeSendTo, wrap);
                        Thread.sleep(1000L);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void checkFile(final String str) {
        this.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.local.flight.UpgradeManager.2
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(str);
                DDLog.e("升级文件是否存在:" + file.exists());
                if (file.exists()) {
                    int maxSupportLength = FlightRevData.get().getRevShakeHandData().getMaxSupportLength();
                    byte supportLength = FlightRevData.get().getRevShakeHandData().getSupportLength();
                    UpgradeManager.this.fileGiver = new FileGiver(file.getAbsolutePath(), maxSupportLength);
                    DDLog.e("升级文件:len=" + UpgradeManager.this.fileGiver.getFileLength() + ",checkCode:" + UpgradeManager.this.fileGiver.getCheckCode());
                    FlightSendData.get().getSendFwLengthData().init(UpgradeManager.this.fileGiver.getFileLength(), supportLength, UpgradeManager.this.fileGiver.getCheckCode());
                    DDLog.e("发送升级文件校验");
                    UpgradeManager.this.isReceiveCheckLen = false;
                    while (!UpgradeManager.this.isReceiveCheckLen) {
                        DataSender.getInstance().sendUpgradeData(UpgradeManager.this.upgradeSendTo, UsbPayloadWrapper.wrap(UpgradeManager.this.upgradeFuncCode, FlightSendData.get().getSendFwLengthData().getBytes()));
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    return;
                }
                DDLog.e("上传升级文件失败:文件不存在:" + str);
            }
        });
    }

    public void uploadFle() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.local.flight.UpgradeManager.3
            /* JADX WARN: Code restructure failed: missing block: B:17:0x00d0, code lost:
            
                r7.this$0.isRun = false;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 306
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.logan.upgrade.local.flight.UpgradeManager.AnonymousClass3.run():void");
            }
        });
    }

    public void sendRunFw() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.local.flight.UpgradeManager.5
            @Override // java.lang.Runnable
            public void run() {
                DDLog.e("开始运行升级固件");
                UpgradeManager.this.isReceiveFwRun = false;
                while (!UpgradeManager.this.isReceiveFwRun) {
                    DDLog.e("发送升级运行固件");
                    DataSender.getInstance().sendUpgradeData(UpgradeManager.this.upgradeSendTo, UsbPayloadWrapper.wrap(UpgradeManager.this.upgradeFuncCode, FlightSendData.get().getSendFwRunData().getBytes()));
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        });
    }

    public void onRevData(int i, byte[] bArr, int i2) {
        if (i == -15) {
            DDLog.e("【升级握手】: " + ParseUtil.byteToHexString(bArr));
            FlightRevData.get().getRevShakeHandData().parse(bArr, i2);
            DDLog.e("收到升级握手:" + this.isUpgradeShakeHandSuccess);
            if (this.isUpgradeShakeHandSuccess) {
                return;
            }
            this.isUpgradeShakeHandSuccess = true;
            IFlightUpgradeProgressListener iFlightUpgradeProgressListener = this.upgradeProgressListener;
            if (iFlightUpgradeProgressListener != null) {
                iFlightUpgradeProgressListener.onSwitchUpgradeModeSuccess();
                return;
            }
            return;
        }
        if (i == -11) {
            DDLog.e("【升级长度告知】: " + ParseUtil.byteToHexString(bArr));
            FlightRevData.get().getRevFwLengthData().parse(bArr, i2);
            this.isReceiveCheckLen = true;
            IFlightUpgradeProgressListener iFlightUpgradeProgressListener2 = this.upgradeProgressListener;
            if (iFlightUpgradeProgressListener2 != null) {
                iFlightUpgradeProgressListener2.isFileAccept(FlightRevData.get().getRevFwLengthData().isLengthAccept());
                return;
            }
            return;
        }
        if (i == -9) {
            DDLog.e("【升级上传文件】: " + ParseUtil.byteToHexString(bArr));
            FlightRevData.get().getRevFwFileData().parse(bArr, i2);
            UpgradeRevFwFileData revFwFileData = FlightRevData.get().getRevFwFileData();
            synchronized (this.upgradeLock) {
                try {
                    if (this.sendFile != null && revFwFileData.getPackageIndex() == this.sendFile.getIndex()) {
                        this.needReUpload = false;
                        this.upgradeHandler.removeCallbacks(this.reUploadRunnable);
                        if (revFwFileData.isSaveSuccess() && this.sendFile.isLastPackage()) {
                            this.isRun = false;
                            this.isUploadFinish = true;
                        } else if (!revFwFileData.isSaveSuccess()) {
                            this.needReUpload = true;
                        }
                        this.upgradeLock.notify();
                        IFlightUpgradeProgressListener iFlightUpgradeProgressListener3 = this.upgradeProgressListener;
                        if (iFlightUpgradeProgressListener3 != null) {
                            iFlightUpgradeProgressListener3.onUploadProgress(this.sendFile.getIndex(), this.totalNum);
                        }
                        if (!revFwFileData.isSaveSuccess()) {
                            DDLog.e("上传第" + ((int) this.sendFile.getIndex()) + InternalZipConstants.ZIP_FILE_SEPARATOR + this.totalNum + "包升级文件：" + revFwFileData.isSaveSuccess() + "," + revFwFileData.isNotSave());
                        } else {
                            DDLog.e("上传第" + ((int) this.sendFile.getIndex()) + InternalZipConstants.ZIP_FILE_SEPARATOR + this.totalNum + "包升级文件：" + revFwFileData.isSaveSuccess());
                        }
                    }
                } catch (Exception e) {
                    DDLog.e("升级上传文件出错 e:" + e);
                }
            }
            return;
        }
        if (i != -7) {
            return;
        }
        DDLog.e("【升级运行固件】: " + ParseUtil.byteToHexString(bArr));
        FlightRevData.get().getRevFwRunData().parse(bArr, i2);
        UpgradeRevFwRunData revFwRunData = FlightRevData.get().getRevFwRunData();
        this.isReceiveFwRun = true;
        IFlightUpgradeProgressListener iFlightUpgradeProgressListener4 = this.upgradeProgressListener;
        if (iFlightUpgradeProgressListener4 != null) {
            iFlightUpgradeProgressListener4.onRunFwSuccess();
        }
        DDLog.e("升级运行是否成功:" + revFwRunData.isHasRightFwToRun());
        if (revFwRunData.isHasRightFwToRun()) {
            if (UsbConfig.isUsbConnected && this.upgradeType == 17) {
                DDLog.e("升级完成打开飞控数据");
                DataSender.getInstance().sendUpgradeData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, SendOthersData.getOpenFlightOutputBytes());
            }
            this.isUpgradeStart = false;
            if (!FlightConfig.is_Atom_Series()) {
                DataManager.getInstance().requestSettingInfo();
            }
            IFlightUpgradeProgressListener iFlightUpgradeProgressListener5 = this.upgradeProgressListener;
            if (iFlightUpgradeProgressListener5 != null) {
                iFlightUpgradeProgressListener5.onUpgradeSuccess();
                return;
            }
            return;
        }
        if (this.upgradeProgressListener != null) {
            DDLog.e("升级失败 没有正确的固件");
            this.upgradeProgressListener.onUpgradeFailed(new Exception("升级失败"));
        }
    }

    public void onReceiveFlightVersion(FlightRevVersionData flightRevVersionData) {
        DDLog.i("升级成功 接收飞机数据");
        upgradeSuccess();
        if (UsbConfig.isUsbConnected) {
            DDLog.w("升级完成打开遥控器数据");
            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_REMOTER, SendOthersData.getOpenRemoterOutputBytes());
        }
    }

    public boolean isUpgradeStart() {
        return this.isUpgradeStart;
    }

    public void upgradeFailed() {
        this.isRun = false;
        synchronized (this.upgradeLock) {
            this.upgradeLock.notify();
        }
        this.isUpgradeStart = false;
        this.isUpgradeShakeHandSuccess = false;
        FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
    }

    public void upgradeSuccess() {
        this.isUpgradeStart = false;
        this.isUpgradeShakeHandSuccess = false;
        FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
        IFlightUpgradeProgressListener iFlightUpgradeProgressListener = this.upgradeProgressListener;
        if (iFlightUpgradeProgressListener != null) {
            iFlightUpgradeProgressListener.onUpgradeSuccess();
        }
    }
}
