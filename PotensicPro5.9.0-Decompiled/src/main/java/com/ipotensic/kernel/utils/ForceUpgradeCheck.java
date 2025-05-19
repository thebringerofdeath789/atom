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
            DDLog.e("强制升级....");
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
                                DDLog.e("强制升级 当前固件：" + version.getClassname());
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
                    DDLog.e("强制升级version:" + version);
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
                DDLog.e("强制升级 当前飞控版本：" + FlightRevData.get().getFlightRevVersionData().getFlightControlVersion());
                DDLog.e("强制升级 本地飞控本号：" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getFlightControlVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("强制升级 飞控文件存在");
                    addVersion(FwDownloadManager.getInstance().getNewFlightControlVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_CAMERA.equalsIgnoreCase(next.getClassname()) || CameraConfig.ATOM_SP.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("强制升级 当前相机版本：" + CameraConfig.get().getSoftVersion());
                DDLog.e("强制升级 后台相机版本：" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(CameraConfig.get().getSoftVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("强制升级 相机文件存在");
                    addVersion(FwDownloadManager.getInstance().getNewCameraVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_FPV.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("强制升级 当前图传版本：" + FlightRevData.get().getFlightRevFpvData().getFpvVersion());
                DDLog.e("强制升级 本地图传本号：" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevFpvData().getFpvVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("强制升级 图传文件存在");
                    addVersion(FwDownloadManager.getInstance().getNewFpvVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("强制升级 当前云台版本：" + FlightRevData.get().getFlightRevVersionData().getGimbalVersion());
                DDLog.e("强制升级 本地云台本号：" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getGimbalVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("强制升级 云台文件存在");
                    addVersion(FwDownloadManager.getInstance().getNewGimbalVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_P1_PRO_RC.equalsIgnoreCase(next.getClassname())) {
                if (UsbConfig.isUsbConnected) {
                    remoterVersion = FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion();
                } else {
                    remoterVersion = FlightRevData.get().getFlightRevVersionData().getRemoterVersion();
                }
                DDLog.e("强制升级 当前遥控器版本：" + remoterVersion);
                DDLog.e("强制升级 本地遥控器本号：" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(remoterVersion, next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("强制升级 遥控器文件存在");
                    addVersion(FwDownloadManager.getInstance().getNewRemoterVersion(true));
                }
            } else if (FlightConfig.PRODUCT_CLASS_BATTERY.equalsIgnoreCase(next.getClassname())) {
                DDLog.e("强制升级 当前电池版本号：" + FlightRevData.get().getFlightRevVersionData().getBatteryVersion());
                DDLog.e("强制升级 本地电池版本号：" + next.getVersion().trim().toLowerCase());
                if (!CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getBatteryVersion(), next.getVersion().trim().toLowerCase())) {
                    continue;
                } else {
                    if (!isFileDownloaded(next)) {
                        break;
                    }
                    DDLog.e("强制升级 电池文件存在");
                    addVersion(FwDownloadManager.getInstance().getNewBatteryVersion(true));
                }
            } else {
                continue;
            }
        }
        DDLog.e("强制升级", "forceVersions = " + this.forceVersions.size());
    }

    private void addVersion(Version version) {
        DDLog.e("强制升级", "添加强制升级固件 = " + version);
        if (version == null || version.getIsforce() != 0) {
            return;
        }
        DDLog.e("强制升级", "添加强制升级固件成功");
        this.forceVersions.add(version);
    }

    public synchronized void forceUpgradeCamera(Context context, int i) {
        DDLog.e("相机升级失败，强制升级");
        Version newCameraVersion = FwDownloadManager.getInstance().getNewCameraVersion(true);
        if (newCameraVersion != null) {
            FwDownloadManager.getInstance().showUpgradeDialog(context, newCameraVersion, true, i, true);
        }
    }

    public void forceUpgradeFpv(Context context, int i) {
        DDLog.e("图传升级失败，强制升级");
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
        DDLog.e("未连飞机时图传单独升级");
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
                            DDLog.e("未连飞机图传单独升级fpvVersion：" + fpvVersion);
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
                            DDLog.e("未连飞机图传单独升级remoteCtrlVersion11：" + remoteCtrlVersion);
                            if (remoteCtrlVersion == null) {
                                remoteCtrlVersion = SPHelper.getInstance().getRemoterCurVersion();
                                DDLog.e("未连飞机图传单独升级remoteCtrlVersion22：" + remoteCtrlVersion);
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
        DDLog.e("未连飞机时遥控器单独升级");
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
                            DDLog.e("未连飞机遥控器单独升级fpvVersion11：" + fpvVersion);
                            if (fpvVersion == null) {
                                fpvVersion = SPHelper.getInstance().getFpvCurVersion();
                                DDLog.e("未连飞机遥控器单独升级fpvVersion22：" + fpvVersion);
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
                            DDLog.e("未连飞机遥控器单独升级remoteCtrlVersion：" + remoteCtrlVersion);
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
        DDLog.e("检测是否需要大包强制升级");
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.ForceUpgradeCheck.5
            @Override // java.lang.Runnable
            public void run() {
                Version version = (Version) JSONObject.parseObject(SPHelper.getInstance().getLocalBigPackageVersion(), Version.class);
                if (version != null && version.getIsforce() == 0 && CommonUtil.hasNewVersion(SPHelper.getInstance().getBigPackageVersion(), version.getVersion().trim().toLowerCase())) {
                    ForceUpgradeCheck forceUpgradeCheck = ForceUpgradeCheck.this;
                    forceUpgradeCheck.needForceUpgradeTips = forceUpgradeCheck.isFileDownloaded(version);
                    DDLog.e("检测是否需要大包强制升级:" + ForceUpgradeCheck.this.needForceUpgradeTips);
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
                        DDLog.e("大包当前版本:" + bigPackageVersion + ", 后台版本：" + version.getVersion().trim());
                        if (version.getProductclass() != null) {
                            if (version.getProductclass().equalsIgnoreCase(!TextUtils.isEmpty(FlightConfig.getBigPackageLastProductClass()) ? FlightConfig.getBigPackageLastProductClass() : FlightConfig.getLastProductClass()) && CommonUtil.hasNewVersion(bigPackageVersion, version.getVersion().trim().toLowerCase())) {
                                if (ForceUpgradeCheck.this.isFileDownloaded(version)) {
                                    DDLog.e("大包本地已有固件：" + bigPackageVersion + ", 本地version: " + version.getVersion());
                                    Event event = new Event(EventID.MSG_BIG_PACKAGE_FIRMWARE_DOES_NEED_DOWN_LOAD);
                                    event.obj = false;
                                    event.arg1 = version.getIsforce();
                                    EventDispatcher.get().sendEvent(event);
                                } else {
                                    DDLog.e("大包需要下载固件，本地文件不存在");
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
