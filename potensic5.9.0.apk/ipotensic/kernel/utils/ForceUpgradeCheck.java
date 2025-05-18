package com.ipotensic.kernel.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.type.Flight;
import com.logan.upgrade.server.Version;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class ForceUpgradeCheck {
    private static volatile ForceUpgradeCheck instance;
    private GeneralDialog remoteUpgradeDialog;
    private AtomicBoolean isFirstGetVersion = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<Version> forceVersions = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Version> versions = new CopyOnWriteArrayList<>();
    private boolean isShowRemoteDialog = false;
    private boolean needForceUpgradeTips = false;
    private boolean isStart = false;
    private boolean isFirstGetBigPackage = false;
    private boolean isShowForceUpgradeTip = false;

    private ForceUpgradeCheck() {
    }

    public static ForceUpgradeCheck getInstance() {
        if (instance == null) {
            synchronized (ForceUpgradeCheck.class) {
                if (instance == null) {
                    instance = new ForceUpgradeCheck();
                }
            }
        }
        return instance;
    }

    public synchronized void checkUpgrade(final Activity activity) {
        if (FlightConfig.curFlight != null && !this.isFirstGetVersion.get()) {
            DDLog.e("\u5f3a\u5236\u5347\u7ea7....");
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.1
                @Override // java.lang.Runnable
                public void run() {
                    String flightControlVersion = FlightRevData.get().getFlightRevVersionData().getFlightControlVersion();
                    if (FlightConfig.curFlight == Flight.Flight_P1_PRO || FlightConfig.curFlight == Flight.Flight_P1_PRO_2) {
                        if (FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null && FlightRevData.get().getFlightRevVersionData().getGimbalVersion() != null && flightControlVersion != null && CameraConfig.get().getSoftVersion() != null && FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() != null) {
                            ForceUpgradeCheck.this.isFirstGetVersion.set(true);
                            ForceUpgradeCheck.this.addVersion();
                        }
                    } else if (FlightConfig.curFlight == Flight.Flight_P1_SELF_B) {
                        if (FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null && FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() != null && flightControlVersion != null && CameraConfig.get().getSoftVersion() != null) {
                            ForceUpgradeCheck.this.isFirstGetVersion.set(true);
                            ForceUpgradeCheck.this.addVersion();
                        }
                    } else if (FlightConfig.curFlight == Flight.Flight_ATOM_SE || FlightConfig.curFlight == Flight.Flight_ATOM_LT) {
                        if (flightControlVersion != null && FlightRevData.get().getFlightRevVersionData().getBatteryVersion() != null && FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null && FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() != null && CameraConfig.get().getSoftVersion() != null) {
                            ForceUpgradeCheck.this.isFirstGetVersion.set(true);
                            ForceUpgradeCheck.this.addVersion();
                        }
                    } else if (FlightConfig.curFlight == Flight.Flight_ATOM) {
                        if (flightControlVersion != null && FlightRevData.get().getFlightRevVersionData().getBatteryVersion() != null && FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null && FlightRevData.get().getFlightRevVersionData().getGimbalVersion() != null && FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() != null && CameraConfig.get().getSoftVersion() != null) {
                            ForceUpgradeCheck.this.isFirstGetVersion.set(true);
                            ForceUpgradeCheck.this.addVersion();
                        }
                    } else if (flightControlVersion != null && CameraConfig.get().getSoftVersion() != null) {
                        ForceUpgradeCheck.this.isFirstGetVersion.set(true);
                        ForceUpgradeCheck.this.addVersion();
                    }
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ForceUpgradeCheck.this.forceVersions.isEmpty()) {
                                return;
                            }
                            Iterator it = ForceUpgradeCheck.this.forceVersions.iterator();
                            while (it.hasNext()) {
                                Version version = (Version) it.next();
                                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u56fa\u4ef6\uff1a" + version.getClassname());
                                if (BaseSyncDialog.isShow) {
                                    return;
                                }
                                if (FlightConfig.PRODUCT_CLASS_P1_PRO_RC.equalsIgnoreCase(version.getClassname())) {
                                    if (FlightRevData.get().getFlightRemoterBatteryData().isRemoterLowPower() || BaseSyncDialog.isShow || ForceUpgradeCheck.this.isShowRemoteDialog) {
                                        return;
                                    }
                                    ForceUpgradeCheck.this.isShowRemoteDialog = true;
                                    ForceUpgradeCheck.this.remoteUpgradeDialog = new GeneralDialog((Context) activity, true, "");
                                    ForceUpgradeCheck.this.remoteUpgradeDialog.setCanceledOnTouchOutside(false);
                                    ForceUpgradeCheck.this.remoteUpgradeDialog.setCancelable(false);
                                    ForceUpgradeCheck.this.remoteUpgradeDialog.show();
                                    return;
                                }
                                if (Flight.Flight_P1_PRO != FlightConfig.curFlight && FlightConfig.curFlight != Flight.Flight_ATOM_SE && FlightConfig.curFlight != Flight.Flight_ATOM_LT && FlightConfig.curFlight != Flight.Flight_ATOM && FlightConfig.curFlight != Flight.Flight_P1_SELF_B && FlightConfig.curFlight != Flight.Flight_P1_PRO_2 && version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA)) {
                                    FwDownloadManager.getInstance().showCamUpgradeDialog(activity, version, true);
                                } else {
                                    FwDownloadManager.getInstance().showUpgradeDialog(activity, version, true);
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFileDownloaded(Version version) {
        return version.getLocalPath() != null && new File(version.getLocalPath()).exists() && FwDownloadManager.getInstance().updateFileMD5Align(version, version.getLocalPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVersion() {
        String remoterVersion;
        this.isShowForceUpgradeTip = false;
        this.versions.clear();
        this.forceVersions.clear();
        Set<String> upgradeVersions = SPHelper.getInstance().getUpgradeVersions();
        if (upgradeVersions != null) {
            Iterator<String> it = upgradeVersions.iterator();
            while (it.hasNext()) {
                Version version = (Version) JSONObject.parseObject(it.next(), Version.class);
                if (version != null) {
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7version:" + version);
                    if (version.getIsforce() == 0) {
                        this.versions.add(version);
                    } else {
                        FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL.equalsIgnoreCase(version.getClassname());
                    }
                }
            }
        }
        if (this.versions.isEmpty()) {
            return;
        }
        this.versions.sort(new Comparator<Version>() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.2
            @Override // java.util.Comparator
            public int compare(Version version2, Version version3) {
                return version3.getWeight() - version2.getWeight();
            }
        });
        Iterator<Version> it2 = this.versions.iterator();
        while (it2.hasNext()) {
            Version next = it2.next();
            if (FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u98de\u63a7\u7248\u672c\uff1a" + FlightRevData.get().getFlightRevVersionData().getFlightControlVersion());
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u672c\u5730\u98de\u63a7\u672c\u53f7\uff1a" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getFlightControlVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u98de\u63a7\u6587\u4ef6\u5b58\u5728");
                    addVersion(FwDownloadManager.getInstance().getNewFlightControlVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_CAMERA.equalsIgnoreCase(next.getClassname()) || CameraConfig.ATOM_SP.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u76f8\u673a\u7248\u672c\uff1a" + CameraConfig.get().getSoftVersion());
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u540e\u53f0\u76f8\u673a\u7248\u672c\uff1a" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(CameraConfig.get().getSoftVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u76f8\u673a\u6587\u4ef6\u5b58\u5728");
                    addVersion(FwDownloadManager.getInstance().getNewCameraVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_FPV.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u56fe\u4f20\u7248\u672c\uff1a" + FlightRevData.get().getFlightRevFpvData().getFpvVersion());
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u672c\u5730\u56fe\u4f20\u672c\u53f7\uff1a" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevFpvData().getFpvVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u56fe\u4f20\u6587\u4ef6\u5b58\u5728");
                    addVersion(FwDownloadManager.getInstance().getNewFpvVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u4e91\u53f0\u7248\u672c\uff1a" + FlightRevData.get().getFlightRevVersionData().getGimbalVersion());
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u672c\u5730\u4e91\u53f0\u672c\u53f7\uff1a" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getGimbalVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u4e91\u53f0\u6587\u4ef6\u5b58\u5728");
                    addVersion(FwDownloadManager.getInstance().getNewGimbalVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_RC.equalsIgnoreCase(next.getClassname())) {
                if (UsbConfig.isUsbConnected) {
                    remoterVersion = FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion();
                } else {
                    remoterVersion = FlightRevData.get().getFlightRevVersionData().getRemoterVersion();
                }
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u9065\u63a7\u5668\u7248\u672c\uff1a" + remoterVersion);
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u672c\u5730\u9065\u63a7\u5668\u672c\u53f7\uff1a" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(remoterVersion, next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u9065\u63a7\u5668\u6587\u4ef6\u5b58\u5728");
                    addVersion(FwDownloadManager.getInstance().getNewRemoterVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_BATTERY.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u5f53\u524d\u7535\u6c60\u7248\u672c\u53f7\uff1a" + FlightRevData.get().getFlightRevVersionData().getBatteryVersion());
                DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u672c\u5730\u7535\u6c60\u7248\u672c\u53f7\uff1a" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getBatteryVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("\u5f3a\u5236\u5347\u7ea7 \u7535\u6c60\u6587\u4ef6\u5b58\u5728");
                    addVersion(FwDownloadManager.getInstance().getNewBatteryVersion(true));
                }
            } else {
                continue;
            }
        }
        DDLog.e("\u5f3a\u5236\u5347\u7ea7", "forceVersions = " + this.forceVersions.size());
    }

    private void addVersion(Version version) {
        DDLog.e("\u5f3a\u5236\u5347\u7ea7", "\u6dfb\u52a0\u5f3a\u5236\u5347\u7ea7\u56fa\u4ef6 = " + version);
        if (version == null || version.getIsforce() != 0) {
            return;
        }
        DDLog.e("\u5f3a\u5236\u5347\u7ea7", "\u6dfb\u52a0\u5f3a\u5236\u5347\u7ea7\u56fa\u4ef6\u6210\u529f");
        this.forceVersions.add(version);
    }

    public synchronized void forceUpgradeCamera(Context context, int i) {
        DDLog.e("\u76f8\u673a\u5347\u7ea7\u5931\u8d25\uff0c\u5f3a\u5236\u5347\u7ea7");
        Version newCameraVersion = FwDownloadManager.getInstance().getNewCameraVersion(true);
        if (newCameraVersion != null) {
            FwDownloadManager.getInstance().showUpgradeDialog(context, newCameraVersion, true, i, true);
        }
    }

    public void forceUpgradeFpv(Context context, int i) {
        DDLog.e("\u56fe\u4f20\u5347\u7ea7\u5931\u8d25\uff0c\u5f3a\u5236\u5347\u7ea7");
        Version newFpvVersion = FwDownloadManager.getInstance().getNewFpvVersion(true);
        if (newFpvVersion != null) {
            FwDownloadManager.getInstance().showUpgradeDialog(context, newFpvVersion, true, i, true);
        }
    }

    public boolean canUpgrade() {
        return (FlightConfig.curFlight == null || FlightRevData.get().getFlightRevStateData().isLowPowerMode() || FlightRevData.get().getFlightRevStateData().isFlight() || !FlightConfig.isConnectFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isTakeOff() || FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() < 30) ? false : true;
    }

    public void release() {
        try {
            this.isStart = false;
            this.forceVersions.clear();
            this.versions.clear();
            this.isFirstGetVersion.set(false);
            this.isShowRemoteDialog = false;
            GeneralDialog generalDialog = this.remoteUpgradeDialog;
            if (generalDialog == null || !generalDialog.isShowing()) {
                return;
            }
            this.remoteUpgradeDialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public CopyOnWriteArrayList<Version> getForceVersions() {
        return this.forceVersions;
    }

    public boolean isNeedForceUpgrade() {
        return this.isShowForceUpgradeTip;
    }

    public void setNeedForceUpgrade() {
        this.isShowForceUpgradeTip = false;
    }

    public synchronized void checkFpvUpgrade(final Context context) {
        DDLog.e("\u672a\u8fde\u98de\u673a\u65f6\u56fe\u4f20\u5355\u72ec\u5347\u7ea7");
        if (BaseSyncDialog.isShow) {
            return;
        }
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.3
            @Override // java.lang.Runnable
            public void run() {
                ForceUpgradeCheck.this.versions.clear();
                Set<String> upgradeVersions = SPHelper.getInstance().getUpgradeVersions();
                if (upgradeVersions != null) {
                    Iterator<String> it = upgradeVersions.iterator();
                    while (it.hasNext()) {
                        Version version = (Version) JSONObject.parseObject(it.next(), Version.class);
                        if (version != null && version.getIsforce() == 0) {
                            ForceUpgradeCheck.this.versions.add(version);
                        }
                    }
                    if (ForceUpgradeCheck.this.versions.isEmpty()) {
                        return;
                    }
                    ForceUpgradeCheck.this.versions.sort(new Comparator<Version>() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.3.1
                        @Override // java.util.Comparator
                        public int compare(Version version2, Version version3) {
                            return version3.getWeight() - version2.getWeight();
                        }
                    });
                    Iterator it2 = ForceUpgradeCheck.this.versions.iterator();
                    while (it2.hasNext()) {
                        final Version version2 = (Version) it2.next();
                        if (FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL.equalsIgnoreCase(version2.getClassname())) {
                            if (CommonUtil.hasNewVersion(SPHelper.getInstance().getFlightCurVersion(), version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_CAMERA.equalsIgnoreCase(version2.getClassname()) || CameraConfig.ATOM_SP.equalsIgnoreCase(version2.getClassname())) {
                            if (CommonUtil.hasNewVersion(SPHelper.getInstance().getCameraCurVersion(), version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_FPV.equalsIgnoreCase(version2.getClassname())) {
                            String fpvVersion = FlightRevData.get().getFlightRevFpvData().getFpvVersion();
                            DDLog.e("\u672a\u8fde\u98de\u673a\u56fe\u4f20\u5355\u72ec\u5347\u7ea7fpvVersion\uff1a" + fpvVersion);
                            if (CommonUtil.hasNewVersion(fpvVersion, version2.getVersion().trim().toLowerCase()) && ForceUpgradeCheck.this.isFileDownloaded(version2)) {
                                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.3.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        FwDownloadManager.getInstance().showUpgradeDialog(context, version2, true);
                                    }
                                });
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL.equalsIgnoreCase(version2.getClassname())) {
                            if (CommonUtil.hasNewVersion(SPHelper.getInstance().getGimbalCurVersion(), version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_RC.equalsIgnoreCase(version2.getClassname())) {
                            String remoteCtrlVersion = FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion();
                            DDLog.e("\u672a\u8fde\u98de\u673a\u56fe\u4f20\u5355\u72ec\u5347\u7ea7remoteCtrlVersion11\uff1a" + remoteCtrlVersion);
                            if (remoteCtrlVersion == null) {
                                remoteCtrlVersion = SPHelper.getInstance().getRemoterCurVersion();
                                DDLog.e("\u672a\u8fde\u98de\u673a\u56fe\u4f20\u5355\u72ec\u5347\u7ea7remoteCtrlVersion22\uff1a" + remoteCtrlVersion);
                            }
                            if (CommonUtil.hasNewVersion(remoteCtrlVersion, version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_BATTERY.equalsIgnoreCase(version2.getClassname()) && CommonUtil.hasNewVersion(SPHelper.getInstance().getBatteryCurVersion(), version2.getVersion().trim().toLowerCase())) {
                            return;
                        }
                    }
                }
            }
        });
    }

    public synchronized void checkRcUpgrade(final Context context) {
        DDLog.e("\u672a\u8fde\u98de\u673a\u65f6\u9065\u63a7\u5668\u5355\u72ec\u5347\u7ea7");
        if (BaseSyncDialog.isShow) {
            return;
        }
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.4
            @Override // java.lang.Runnable
            public void run() {
                ForceUpgradeCheck.this.versions.clear();
                Set<String> upgradeVersions = SPHelper.getInstance().getUpgradeVersions();
                if (upgradeVersions != null) {
                    Iterator<String> it = upgradeVersions.iterator();
                    while (it.hasNext()) {
                        Version version = (Version) JSONObject.parseObject(it.next(), Version.class);
                        if (version != null && version.getIsforce() == 0) {
                            ForceUpgradeCheck.this.versions.add(version);
                        }
                    }
                    if (ForceUpgradeCheck.this.versions.isEmpty()) {
                        return;
                    }
                    ForceUpgradeCheck.this.versions.sort(new Comparator<Version>() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.4.1
                        @Override // java.util.Comparator
                        public int compare(Version version2, Version version3) {
                            return version3.getWeight() - version2.getWeight();
                        }
                    });
                    Iterator it2 = ForceUpgradeCheck.this.versions.iterator();
                    while (it2.hasNext()) {
                        Version version2 = (Version) it2.next();
                        if (FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL.equalsIgnoreCase(version2.getClassname())) {
                            if (CommonUtil.hasNewVersion(SPHelper.getInstance().getFlightCurVersion(), version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_CAMERA.equalsIgnoreCase(version2.getClassname()) || CameraConfig.ATOM_SP.equalsIgnoreCase(version2.getClassname())) {
                            if (CommonUtil.hasNewVersion(SPHelper.getInstance().getCameraCurVersion(), version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_FPV.equalsIgnoreCase(version2.getClassname())) {
                            String fpvVersion = FlightRevData.get().getFlightRevFpvData().getFpvVersion();
                            DDLog.e("\u672a\u8fde\u98de\u673a\u9065\u63a7\u5668\u5355\u72ec\u5347\u7ea7fpvVersion11\uff1a" + fpvVersion);
                            if (fpvVersion == null) {
                                fpvVersion = SPHelper.getInstance().getFpvCurVersion();
                                DDLog.e("\u672a\u8fde\u98de\u673a\u9065\u63a7\u5668\u5355\u72ec\u5347\u7ea7fpvVersion22\uff1a" + fpvVersion);
                            }
                            if (CommonUtil.hasNewVersion(fpvVersion, version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL.equalsIgnoreCase(version2.getClassname())) {
                            if (CommonUtil.hasNewVersion(SPHelper.getInstance().getGimbalCurVersion(), version2.getVersion().trim().toLowerCase())) {
                                return;
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_RC.equalsIgnoreCase(version2.getClassname())) {
                            String remoteCtrlVersion = FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion();
                            DDLog.e("\u672a\u8fde\u98de\u673a\u9065\u63a7\u5668\u5355\u72ec\u5347\u7ea7remoteCtrlVersion\uff1a" + remoteCtrlVersion);
                            if (!CommonUtil.hasNewVersion(remoteCtrlVersion, version2.getVersion().trim().toLowerCase())) {
                                continue;
                            } else if (!ForceUpgradeCheck.this.isFileDownloaded(version2)) {
                                return;
                            } else {
                                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.4.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        new GeneralDialog(context, true, "").show();
                                    }
                                });
                            }
                        } else if (FlightConfig.PRODUCT_CLASS_BATTERY.equalsIgnoreCase(version2.getClassname()) && CommonUtil.hasNewVersion(SPHelper.getInstance().getBatteryCurVersion(), version2.getVersion().trim().toLowerCase())) {
                            return;
                        }
                    }
                }
            }
        });
    }

    public void startBigPackageNeedForceUpgrade() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        DDLog.e("\u68c0\u6d4b\u662f\u5426\u9700\u8981\u5927\u5305\u5f3a\u5236\u5347\u7ea7");
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.5
            @Override // java.lang.Runnable
            public void run() {
                Version version = (Version) JSONObject.parseObject(SPHelper.getInstance().getLocalBigPackageVersion(), Version.class);
                if (version != null && version.getIsforce() == 0 && CommonUtil.hasNewVersion(SPHelper.getInstance().getBigPackageVersion(), version.getVersion().trim().toLowerCase())) {
                    ForceUpgradeCheck forceUpgradeCheck = ForceUpgradeCheck.this;
                    forceUpgradeCheck.needForceUpgradeTips = forceUpgradeCheck.isFileDownloaded(version);
                    DDLog.e("\u68c0\u6d4b\u662f\u5426\u9700\u8981\u5927\u5305\u5f3a\u5236\u5347\u7ea7:" + ForceUpgradeCheck.this.needForceUpgradeTips);
                }
            }
        });
    }

    public boolean isNeedForceUpgradeTips() {
        return this.needForceUpgradeTips;
    }

    public void setNeedForceUpgradeTips(Boolean bool) {
        this.needForceUpgradeTips = bool.booleanValue();
    }

    public void reset() {
        this.isStart = false;
        this.needForceUpgradeTips = false;
    }

    public synchronized void checkBigPackageUpgrade() {
        if (SPHelper.getInstance().getIsBigPackage() && FlightConfig.curFlight != null && !FlightRevData.get().getFlightRevStateData().isUnLock() && !this.isFirstGetBigPackage) {
            this.isFirstGetBigPackage = true;
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.6
                @Override // java.lang.Runnable
                public void run() {
                    Version version = (Version) JSONObject.parseObject(SPHelper.getInstance().getLocalBigPackageVersion(), Version.class);
                    if (version != null) {
                        String bigPackageVersion = SPHelper.getInstance().getBigPackageVersion();
                        DDLog.e("\u5927\u5305\u5f53\u524d\u7248\u672c:" + bigPackageVersion + ", \u540e\u53f0\u7248\u672c\uff1a" + version.getVersion().trim());
                        if (version.getProductclass() != null) {
                            if (version.getProductclass().equalsIgnoreCase(!TextUtils.isEmpty(FlightConfig.getBigPackageLastProductClass()) ? FlightConfig.getBigPackageLastProductClass() : FlightConfig.getLastProductClass()) && CommonUtil.hasNewVersion(bigPackageVersion, version.getVersion().trim().toLowerCase())) {
                                if (ForceUpgradeCheck.this.isFileDownloaded(version)) {
                                    DDLog.e("\u5927\u5305\u672c\u5730\u5df2\u6709\u56fa\u4ef6\uff1a" + bigPackageVersion + ", \u672c\u5730version: " + version.getVersion());
                                    Event event = new Event(EventID.MSG_BIG_PACKAGE_FIRMWARE_DOES_NEED_DOWN_LOAD);
                                    event.obj = false;
                                    event.arg1 = version.getIsforce();
                                    EventDispatcher.get().sendEvent(event);
                                } else {
                                    DDLog.e("\u5927\u5305\u9700\u8981\u4e0b\u8f7d\u56fa\u4ef6\uff0c\u672c\u5730\u6587\u4ef6\u4e0d\u5b58\u5728");
                                    Event event2 = new Event(EventID.MSG_BIG_PACKAGE_FIRMWARE_DOES_NEED_DOWN_LOAD);
                                    event2.obj = true;
                                    event2.arg1 = version.getIsforce();
                                    EventDispatcher.get().sendEvent(event2);
                                }
                            }
                        }
                    }
                    ForceUpgradeCheck.this.isFirstGetBigPackage = false;
                }
            });
        }
    }
}