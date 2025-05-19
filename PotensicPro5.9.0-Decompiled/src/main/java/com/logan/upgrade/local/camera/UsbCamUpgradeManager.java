package com.logan.upgrade.local.camera;

import com.baidu.geofence.GeoFence;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.logan.flight.data.FlightRevData;
import com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener;
import com.logan.usb.UsbCameraHandler;
import com.logan.usb.utils.Md5Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

/* loaded from: classes3.dex */
public class UsbCamUpgradeManager {
    public static final int CRC_ERROR = 1;
    public static final int IO_ERROR = 2;
    public static final int ORDER_ERROR = 3;
    public static final int STATE_ERROR = 4;
    private static volatile UsbCamUpgradeManager instance;
    private short pkgNum;
    private onCameraUpgradingListener upgradingListener;
    private File upgradeFile = null;
    private final int PKG_SIZE = 4000;
    private int needReloadNum = -1;
    private boolean isInterrupt = false;
    private boolean isMD5Check = false;
    private CancelRunnable shakeHandRunnable = null;
    private byte upgradeTo = UsbConfig.USB_TYPE_APP_TO_CAMERA;
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.logan.upgrade.local.camera.UsbCamUpgradeManager.2
        @Override // java.lang.Runnable
        public void run() {
            if (UsbCamUpgradeManager.this.upgradeTo == UsbConfig.USB_TYPE_APP_TO_CAMERA) {
                UsbCamUpgradeManager.this.upgradeFailed(new Exception(GeoFence.BUNDLE_KEY_LOCERRORCODE));
            }
        }
    };
    private IFlightUpgradeProgressListener progressListener = null;

    public interface onCameraUpgradingListener {
        void onUpgradeTo(byte b, int i);
    }

    private UsbCamUpgradeManager() {
    }

    public static UsbCamUpgradeManager getInstance() {
        if (instance == null) {
            synchronized (UsbCamUpgradeManager.class) {
                if (instance == null) {
                    UsbCamUpgradeManager usbCamUpgradeManager = new UsbCamUpgradeManager();
                    instance = usbCamUpgradeManager;
                    return usbCamUpgradeManager;
                }
            }
        }
        return instance;
    }

    public void UpgradeTo(byte b) {
        DDLog.e("相机/图传升级:" + ((int) b));
        this.upgradeTo = b;
    }

    public void onUpgradeResponse(byte[] bArr) {
        int payloadIndex = UsbConfig.getPayloadIndex(0);
        if (bArr.length <= payloadIndex || UsbConfig.getMsgId(bArr, 0) != 33) {
            if (bArr.length > payloadIndex && UsbConfig.getMsgId(bArr, 0) == 34) {
                DDLog.e("相机升级握手:" + ParseUtil.byteToHexString(bArr));
                if (bArr[payloadIndex] == 0 || bArr[payloadIndex] == 1) {
                    IFlightUpgradeProgressListener iFlightUpgradeProgressListener = this.progressListener;
                    if (iFlightUpgradeProgressListener != null) {
                        iFlightUpgradeProgressListener.isFileAccept(true);
                    }
                    sendUpgradeFile();
                    return;
                }
                if (bArr[payloadIndex] == 3) {
                    DDLog.e("升级失败 提示不能升级");
                    upgradeFailed(new Exception("you can not upgrade!!"));
                    return;
                }
                return;
            }
            if (bArr.length > payloadIndex && UsbConfig.getMsgId(bArr, 0) == 35) {
                int i = payloadIndex + 2;
                if (bArr[i] == 2 || bArr[i] == 4) {
                    DDLog.e("升级失败 提示不能升级1");
                    PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
                    PhoneConfig.mainHandler.post(this.timeoutRunnable);
                    this.isInterrupt = true;
                    return;
                }
                this.needReloadNum = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex);
                DDLog.e("相机升级重传的包号：" + this.needReloadNum);
                DDLog.e("相机升级重传返回值：" + ((int) bArr[i]));
                return;
            }
            if (bArr.length > payloadIndex && UsbConfig.getMsgId(bArr, 0) == 36) {
                PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
                if (bArr[payloadIndex] == 0) {
                    this.isMD5Check = true;
                    DDLog.e("相机升级MD5校验成功：");
                    return;
                } else {
                    if (bArr[payloadIndex] == 1) {
                        DDLog.e("相机升级MD5校验失败：");
                        upgradeFailed(new Exception("you can not upgrade!!"));
                        return;
                    }
                    return;
                }
            }
            if (bArr.length > payloadIndex && UsbConfig.getMsgId(bArr, 0) == 37) {
                byte b = bArr[payloadIndex];
                DDLog.e("相机升级进度：" + ((int) b));
                IFlightUpgradeProgressListener iFlightUpgradeProgressListener2 = this.progressListener;
                if (iFlightUpgradeProgressListener2 != null) {
                    iFlightUpgradeProgressListener2.onUploadProgress(b, 100);
                }
                if (b >= 100) {
                    if (this.upgradeTo == UsbConfig.USB_TYPE_APP_TO_FPV) {
                        FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
                    }
                    IFlightUpgradeProgressListener iFlightUpgradeProgressListener3 = this.progressListener;
                    if (iFlightUpgradeProgressListener3 != null) {
                        iFlightUpgradeProgressListener3.onUpgradeSuccess();
                        return;
                    }
                    return;
                }
                onCameraUpgradingListener oncameraupgradinglistener = this.upgradingListener;
                if (oncameraupgradinglistener != null) {
                    oncameraupgradinglistener.onUpgradeTo(this.upgradeTo, b);
                    return;
                }
                return;
            }
            if (bArr.length <= payloadIndex || UsbConfig.getMsgId(bArr, 0) != 38) {
                return;
            }
            byte b2 = bArr[payloadIndex];
            DDLog.e("相机升级是否成功：" + (b2 == 0));
            if (b2 == 0) {
                upgradeSuccess();
            } else if (b2 == 1) {
                DDLog.e("相机升级失败xxxxxx：");
                upgradeFailed(new Exception(""));
            }
        }
    }

    public void requestUpgrade(File file) throws Exception {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (this.upgradeTo == UsbConfig.USB_TYPE_APP_TO_FPV) {
            FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(true);
        }
        int length = (int) file.length();
        short s = (short) (length / 4000);
        this.pkgNum = s;
        if (length % 4000 != 0) {
            this.pkgNum = (short) (s + 1);
        }
        byte[] bArr = {0, 0, 0};
        ParseUtil.short2ByteArr(this.pkgNum, bArr, 0);
        DDLog.e("发送相机升级请求 升级文件总包数:" + ((int) this.pkgNum) + "   ， 升级数据 ：" + ParseUtil.byteToHexString(bArr));
        UsbCameraHandler.getInstance().send((byte) 34, bArr, this.upgradeTo);
        this.upgradeFile = file;
    }

    public void sendUpgradeFile() {
        File file = this.upgradeFile;
        if (file == null || !file.exists()) {
            return;
        }
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.local.camera.UsbCamUpgradeManager.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:76:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r1v2, types: [android.os.Handler] */
            /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Runnable] */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.io.FileInputStream] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 536
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.logan.upgrade.local.camera.UsbCamUpgradeManager.AnonymousClass1.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMD5Align() {
        byte[] fileMD5 = Md5Util.getFileMD5(this.upgradeFile);
        Objects.requireNonNull(fileMD5);
        byte[] bArr = new byte[fileMD5.length];
        System.arraycopy(fileMD5, 0, bArr, 0, fileMD5.length);
        DDLog.e("发送相机升级MD5:" + ParseUtil.byteToHexString(bArr));
        UsbCameraHandler.getInstance().send((byte) 36, bArr, this.upgradeTo);
    }

    private void upgradeSuccess() {
        if (this.upgradeTo == UsbConfig.USB_TYPE_APP_TO_FPV) {
            FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
        }
        IFlightUpgradeProgressListener iFlightUpgradeProgressListener = this.progressListener;
        if (iFlightUpgradeProgressListener != null) {
            iFlightUpgradeProgressListener.onUpgradeSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upgradeFailed(Exception exc) {
        if (this.upgradeTo == UsbConfig.USB_TYPE_APP_TO_FPV) {
            FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
        }
        IFlightUpgradeProgressListener iFlightUpgradeProgressListener = this.progressListener;
        if (iFlightUpgradeProgressListener != null) {
            iFlightUpgradeProgressListener.onUpgradeFailed(exc);
        }
    }

    public void setUpgradeProgressListener(IFlightUpgradeProgressListener iFlightUpgradeProgressListener) {
        this.progressListener = iFlightUpgradeProgressListener;
    }

    public void setCameraUpgradingListener(onCameraUpgradingListener oncameraupgradinglistener) {
        this.upgradingListener = oncameraupgradinglistener;
    }
}
