package com.logan.upgrade.big;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.enums.GimbalErrorType;
import com.logan.upgrade.enums.BigPackageUpgradeStage;
import com.logan.upgrade.enums.BigPackageUploadFailType;
import com.logan.usb.UsbCameraHandler;
import com.logan.usb.utils.Md5Util;
import com.logan.user.presenter.UserRequestPresenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class BigPackageHelper {
    public static String NEED_DOWNLOAD_FILE = "need_download_file";
    private static final int RECEIVE_UPGRADE_DATA_TIME_OUT = 60000;
    public static final byte REV_CMD_UPGRADE_PROGRESS = 0;
    public static final byte REV_CMD_UPGRADE_RESULT = 1;
    public static final byte SUB_CMD_ASK_UPLOAD = 0;
    public static final byte SUB_CMD_INTERRUPT = 2;
    public static final byte SUB_CMD_UPLOAD_FILE = 1;
    public static final byte SUB_CMD_UPLOAD_SUCCESS = 3;
    public static String UPGRADING_PROGRESS = "upgrading_progress";
    public static String UPGRADING_PROGRESS_VALUE = "upgrading_progress_value";
    public static String UPGRADING_STATE = "upgrading_state";
    public static String UPGRADING_TOTAL_PROGRESS_VALUE = "upgrading_total_progress_value";
    private static volatile BigPackageHelper instance;
    private long needOffset;
    private FileInputStream randomFile;
    private int reUploadTimes;
    private int reUploadTotalTimes;
    private int readLen;
    private long startTime;
    private UpgradeInfo upgradeInfo;
    private File uploadFile;
    private int uploadFileSize;
    private boolean needReUpload = false;
    private final Object upgradeLock = new Object();
    private final int FILE_UPLOAD_TIME_OUT = 1000;
    private boolean isTimeout = false;
    private boolean stopSendData = false;
    private int maxReUploadTimes = 30;
    private int lostNum = 4;
    private boolean isStartCheck = false;
    private CancelRunnable receiveUpgradeDataRunnable = null;
    private long offset = 0;
    private byte[] data = new byte[10000];
    private final Runnable uploadTimeOutRunnable = new Runnable() { // from class: com.logan.upgrade.big.-$$Lambda$BigPackageHelper$iXKKpuBqgfqH7ZJXTYdkt-YvMnE
        @Override // java.lang.Runnable
        public final void run() {
            BigPackageHelper.this.lambda$new$0$BigPackageHelper();
        }
    };

    static /* synthetic */ long access$414(BigPackageHelper bigPackageHelper, long j) {
        long j2 = bigPackageHelper.offset + j;
        bigPackageHelper.offset = j2;
        return j2;
    }

    private BigPackageHelper() {
    }

    public static BigPackageHelper get() {
        if (instance == null) {
            synchronized (BigPackageHelper.class) {
                if (instance == null) {
                    BigPackageHelper bigPackageHelper = new BigPackageHelper();
                    instance = bigPackageHelper;
                    return bigPackageHelper;
                }
            }
        }
        return instance;
    }

    public void setUploadFile(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            return;
        }
        this.uploadFile = file;
        askUploadFile();
    }

    public void askUploadFile() {
        if (this.uploadFile != null) {
            DDLog.m1684e("请求大包文件传输");
            String name = this.uploadFile.getName();
            long length = this.uploadFile.length();
            DDLog.m1684e("大包文件大小：" + length);
            String file = Md5Util.getFile(this.uploadFile);
            this.uploadFileSize = (int) (length / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            String format = String.format("{\"filename\":\"%s\",\"length\":\"%s\",\"MD5\":\"%s\",\"purpose\":\"upgrade\"}", name, length + "", file);
            byte[] concatAll = ParseUtil.concatAll(new byte[]{48}, new byte[]{0}, format.getBytes());
            DDLog.m1684e("大包请求文件上传0:" + format);
            DDLog.m1684e("大包请求文件上传1:" + ParseUtil.byteToHexString(concatAll));
            UsbCameraHandler.getInstance().send(concatAll);
        }
    }

    public void uploadFileSlice(long j, byte[] bArr) {
        DDLog.m1684e("大包 file_offset:" + j + ", data: " + bArr.length);
        byte[] longToBytesLittle = ParseUtil.longToBytesLittle(j);
        byte[] short2ByteArr1 = ParseUtil.short2ByteArr1((short) bArr.length);
        DDLog.m1684e("大包 当前文件偏移值：" + longToBytesLittle.length + ", 长度：" + short2ByteArr1.length);
        UsbCameraHandler.getInstance().send(ParseUtil.concatAll(new byte[]{48}, new byte[]{1}, longToBytesLittle, short2ByteArr1, bArr));
    }

    public /* synthetic */ void lambda$new$0$BigPackageHelper() {
        synchronized (this.upgradeLock) {
            this.isTimeout = true;
            this.needReUpload = true;
            onReupload();
        }
    }

    public void uploadTotalFile() {
        if (this.uploadFile != null) {
            try {
                this.reUploadTotalTimes = this.uploadFileSize * this.lostNum * this.maxReUploadTimes;
                this.needReUpload = false;
                this.stopSendData = false;
                this.randomFile = new FileInputStream(this.uploadFile);
                this.reUploadTimes = 0;
                getNextResult();
                DDLog.m1684e("大包文件上传完成 ：" + this.offset);
            } catch (Exception e) {
                DDLog.m1684e("大包上传文件异常:" + e.getMessage());
            }
        }
    }

    private void getNextResult() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.big.BigPackageHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BigPackageHelper bigPackageHelper = BigPackageHelper.this;
                    bigPackageHelper.readLen = bigPackageHelper.randomFile.read(BigPackageHelper.this.data);
                    DDLog.m1684e("大包文件上传 :" + BigPackageHelper.this.readLen);
                    if (BigPackageHelper.this.readLen != -1 && !BigPackageHelper.this.stopSendData) {
                        if (BigPackageHelper.this.offset != BigPackageHelper.this.needOffset) {
                            DDLog.m1684e("大包文件上传 offset=" + BigPackageHelper.this.offset + ", needOffset=" + BigPackageHelper.this.needOffset);
                            BigPackageHelper.this.randomFile.skip(BigPackageHelper.this.needOffset - BigPackageHelper.this.offset);
                            BigPackageHelper bigPackageHelper2 = BigPackageHelper.this;
                            bigPackageHelper2.offset = bigPackageHelper2.needOffset;
                        }
                        if (BigPackageHelper.this.readLen != BigPackageHelper.this.data.length) {
                            DDLog.m1684e("大包最后一包文件上传：" + BigPackageHelper.this.readLen);
                            int i = BigPackageHelper.this.readLen;
                            byte[] bArr = new byte[i];
                            System.arraycopy(BigPackageHelper.this.data, 0, bArr, 0, i);
                            BigPackageHelper bigPackageHelper3 = BigPackageHelper.this;
                            bigPackageHelper3.uploadFileSlice(bigPackageHelper3.offset, bArr);
                        } else {
                            BigPackageHelper bigPackageHelper4 = BigPackageHelper.this;
                            bigPackageHelper4.uploadFileSlice(bigPackageHelper4.offset, BigPackageHelper.this.data);
                        }
                        BigPackageHelper.access$414(BigPackageHelper.this, r0.readLen);
                        DDLog.m1684e("大包上传的当前偏移量offset :" + BigPackageHelper.this.offset);
                        PhoneConfig.mainHandler.postDelayed(BigPackageHelper.this.uploadTimeOutRunnable, 1000L);
                        DDLog.m1684e("大包========================================================");
                    }
                } catch (Exception e) {
                    DDLog.m1684e("大包 getNextResult exception " + e.getMessage());
                }
            }
        });
    }

    private void onReupload() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.upgrade.big.-$$Lambda$BigPackageHelper$IR8NTPBvdLc5Gi0tETpNLZcwIPc
            @Override // java.lang.Runnable
            public final void run() {
                BigPackageHelper.this.lambda$onReupload$1$BigPackageHelper();
            }
        });
    }

    /* renamed from: handleUploadTimeout, reason: merged with bridge method [inline-methods] */
    private void lambda$onReupload$1$BigPackageHelper() {
        int i = this.reUploadTotalTimes;
        if (i > 0) {
            this.reUploadTotalTimes = i - 1;
        } else if (i <= 0) {
            DDLog.m1684e("大包 固件传输超时，退出升级");
            this.stopSendData = true;
            this.needReUpload = false;
            PhoneConfig.mainHandler.removeCallbacks(this.uploadTimeOutRunnable);
            EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPLOAD_FAIL, BigPackageUploadFailType.UPLOAD_FAIL_TIMEOUT.value);
            return;
        }
        DDLog.m1684e("大包 reUploadTotalTimes： " + this.reUploadTotalTimes);
        if (this.reUploadTimes >= 30) {
            DDLog.m1684e("大包 单包固件传输超时，退出升级");
            this.reUploadTimes = 0;
            this.stopSendData = true;
            this.needReUpload = false;
            PhoneConfig.mainHandler.removeCallbacks(this.uploadTimeOutRunnable);
            EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPLOAD_FAIL, BigPackageUploadFailType.UPLOAD_FAIL_TIMEOUT.value);
            return;
        }
        if (this.isTimeout) {
            try {
                this.randomFile.skip(-this.readLen);
                this.offset -= this.readLen;
            } catch (Exception e) {
                e.printStackTrace();
            }
            DDLog.m1684e("大包超时重传offset：" + this.offset);
        } else {
            try {
                this.randomFile.skip(this.needOffset - this.offset);
                this.offset = this.needOffset;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            DDLog.m1684e("大包重传offset：" + this.offset);
        }
        this.reUploadTimes++;
        getNextResult();
    }

    public void interruptUploadFile() {
        UsbCameraHandler.getInstance().send(ParseUtil.concatAll(new byte[]{48}, new byte[]{2}));
    }

    public void onReceivedUploadFile(byte[] bArr, int i) {
        DDLog.m1684e("收到大包——文件上传:" + ParseUtil.byteToHexString(bArr, 20));
        byte b = bArr[i];
        byte b2 = bArr[i + 2];
        DDLog.m1684e("收到大包cmd：" + ((int) b2));
        if (this.stopSendData) {
            return;
        }
        if (b2 == 0) {
            uploadTotalFile();
            return;
        }
        if (b2 != 1) {
            if (b2 != 3) {
                return;
            }
            DDLog.m1684e("收到大包文件上传完成");
            return;
        }
        synchronized (this.upgradeLock) {
            DDLog.m1684e("收到大包同步上传文件");
            this.isTimeout = false;
            this.needReUpload = false;
            this.stopSendData = false;
            PhoneConfig.mainHandler.removeCallbacks(this.uploadTimeOutRunnable);
            this.reUploadTimes = 0;
            this.needOffset = ParseUtil.byteArrayToLong(bArr, i + 3);
            getNextResult();
        }
    }

    public void onReceivedUpgradeProgress(byte[] bArr, int i) {
        this.startTime = System.currentTimeMillis();
        if (this.stopSendData) {
            return;
        }
        if (!this.isStartCheck) {
            DDLog.m1684e("大包  开始检查相机下行数据");
            this.isStartCheck = true;
            checkReceivedUpgradeData();
        }
        DDLog.m1684e("收到大包升级阶段：" + ParseUtil.byteToHexString(bArr));
        int i2 = i + 5;
        if (bArr.length > i2) {
            byte b = bArr[i + 2];
            if (b == 0) {
                DDLog.m1684e("收到大包——升级进度0x00");
                int byteToDecimalInt = ParseUtil.byteToDecimalInt(bArr[i + 3]);
                int byteToDecimalInt2 = ParseUtil.byteToDecimalInt(bArr[i + 4]);
                int byteToDecimalInt3 = ParseUtil.byteToDecimalInt(bArr[i2]);
                if (this.upgradeInfo == null) {
                    this.upgradeInfo = new UpgradeInfo();
                }
                this.upgradeInfo.setState(byteToDecimalInt);
                this.upgradeInfo.setProgress(byteToDecimalInt2);
                this.upgradeInfo.setTotalProgress(byteToDecimalInt3);
                DDLog.m1684e("收到大包——升级进度：state: " + byteToDecimalInt + ", 总升级进度：" + byteToDecimalInt3);
                EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPGRADE_STATE, this.upgradeInfo);
                return;
            }
            if (b != 1) {
                return;
            }
            int byteToDecimalInt4 = ParseUtil.byteToDecimalInt(bArr[i + 3]);
            int byteToDecimalInt5 = ParseUtil.byteToDecimalInt(bArr[i + 4]);
            boolean z = ParseUtil.byteToDecimalInt(bArr[i2]) == 1;
            DDLog.m1684e("收到大包——升级结果0x01, upgradeStage = " + byteToDecimalInt4 + ", errorCode = " + byteToDecimalInt5 + ", endUpgrade = " + z);
            deInit();
            if (z && byteToDecimalInt5 == 0) {
                EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPGRADE_FINISHED);
            }
            if (byteToDecimalInt5 != 0) {
                if (byteToDecimalInt4 > BigPackageUpgradeStage.STAGE_PARSE_FW.value) {
                    EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPGRADE_FAIL, byteToDecimalInt4 + "_" + byteToDecimalInt5);
                } else {
                    EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPLOAD_FAIL, byteToDecimalInt4 + "_" + byteToDecimalInt5);
                }
            }
        }
    }

    private void checkReceivedUpgradeData() {
        if (this.receiveUpgradeDataRunnable == null) {
            CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.logan.upgrade.big.BigPackageHelper.2
                @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
                public void run() {
                    DDLog.m1684e("大包  startTime= " + BigPackageHelper.this.startTime + ", System.currentTimeMillis()= " + System.currentTimeMillis() + ", 时间差= " + (System.currentTimeMillis() - BigPackageHelper.this.startTime));
                    if (System.currentTimeMillis() - BigPackageHelper.this.startTime >= 60000) {
                        DDLog.m1684e("大包 超过60s没有接收到相机下发的数据");
                        BigPackageHelper.this.deInit();
                        if (BigPackageHelper.this.stopSendData) {
                            return;
                        }
                        EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPGRADE_FAIL, BigPackageUploadFailType.UPLOAD_FAIL_TIMEOUT.value);
                    }
                }
            };
            this.receiveUpgradeDataRunnable = cancelRunnable;
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.receiveUpgradeDataRunnable, 0L, 1000L, TimeUnit.MILLISECONDS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deInit() {
        CancelRunnable cancelRunnable = this.receiveUpgradeDataRunnable;
        if (cancelRunnable == null || cancelRunnable.getFuture() == null) {
            return;
        }
        this.receiveUpgradeDataRunnable.getFuture().cancel(true);
        this.receiveUpgradeDataRunnable = null;
        this.startTime = 0L;
        this.isStartCheck = false;
    }

    public static class UpgradeInfo {
        private int progress;
        private int state;
        private int totalProgress;

        public int getState() {
            return this.state;
        }

        public void setState(int i) {
            this.state = i;
        }

        public int getProgress() {
            return this.progress;
        }

        public void setProgress(int i) {
            this.progress = i;
        }

        public int getTotalProgress() {
            return this.totalProgress;
        }

        public void setTotalProgress(int i) {
            this.totalProgress = i;
        }
    }

    public void onReceivedError(byte b, int i, byte[] bArr) {
        DDLog.m1684e("收到大包上传文件失败消息resultCode = " + ((int) b));
        DDLog.m1684e("收到大包上传文件失败消息data = " + ParseUtil.byteToHexString(bArr));
        if (this.stopSendData) {
            return;
        }
        int i2 = i + 2;
        if (bArr[i2] != 1) {
            if (bArr[i2] == 0) {
                EventDispatcher.get().sendEvent(EventID.MSG_BIG_PACKAGE_UPLOAD_FAIL, "0x30_" + ParseUtil.byteToDecimalInt(b));
            }
        } else {
            if (b != 23) {
                return;
            }
            synchronized (this.upgradeLock) {
                if (!this.stopSendData) {
                    this.isTimeout = false;
                    this.needReUpload = true;
                    this.stopSendData = false;
                    PhoneConfig.mainHandler.removeCallbacks(this.uploadTimeOutRunnable);
                    this.needOffset = ParseUtil.byteArrayToLong(bArr, i + 3);
                    DDLog.m1684e("收到大包文件上传期待的偏移量:" + this.needOffset);
                }
                onReupload();
            }
        }
    }

    public void onSendBigPackageStatistics(String str, String str2) {
        String flightCurVersion = SPHelper.getInstance().getFlightCurVersion();
        String bigPackageLastProductClass = !TextUtils.isEmpty(FlightConfig.getBigPackageLastProductClass()) ? FlightConfig.getBigPackageLastProductClass() : FlightConfig.getLastProductClass();
        String bigPackageFlightSn = SPHelper.getInstance().getBigPackageFlightSn();
        String bigPackageRemoteSn = SPHelper.getInstance().getBigPackageRemoteSn();
        String remoterCurVersion = SPHelper.getInstance().getRemoterCurVersion();
        String bigPackageNewVersion = SPHelper.getInstance().getBigPackageNewVersion();
        Token token = PhoneConfig.usrToken;
        if (!FlightConfig.isConnectFlight() || !FlightConfig.isBigPackageSeries() || TextUtils.isEmpty(bigPackageFlightSn) || TextUtils.isEmpty(bigPackageRemoteSn) || TextUtils.isEmpty(bigPackageNewVersion) || token == null) {
            return;
        }
        UserRequestPresenter.getInstance().productInfoStatistics(token, bigPackageLastProductClass, bigPackageNewVersion, flightCurVersion, remoterCurVersion, bigPackageRemoteSn, bigPackageFlightSn, 0, str, str2);
        if (TextUtils.isEmpty(str)) {
            SPHelper.getInstance().setEnterKernelActivityFirstConnected(false);
        }
    }

    public boolean isGimbalTestPass() {
        short error_status = FlightRevData.get().getGimbalStateData().getError_status();
        return (GimbalErrorType.BOOT_SELF_TEST_STALL.getValue() == error_status || GimbalErrorType.OPERATION_STALL.getValue() == error_status || GimbalErrorType.TEMP_HIGH.getValue() == error_status) ? false : true;
    }

    public void release() {
        DDLog.m1684e("释放大包BigPackageHelper");
        deInit();
        this.isTimeout = false;
        this.stopSendData = true;
        this.needReUpload = false;
        instance = null;
    }
}