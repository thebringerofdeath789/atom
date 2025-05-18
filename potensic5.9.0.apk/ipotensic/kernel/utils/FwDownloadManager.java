package com.ipotensic.kernel.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.DownloadListener2;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.CameraUpgradeDialog;
import com.ipotensic.kernel.view.dialog.FlightUpgradeDialog;
import com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.enums.SdCardState;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.type.Flight;
import com.logan.upgrade.server.Version;
import com.logan.usb.utils.Md5Util;
import com.logan.user.model.UserConstants;
import com.logan.user.presenter.UserRequestPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class FwDownloadManager {
    private static volatile FwDownloadManager instance;
    private CameraUpgradeDialog cameraUpgradeDialog;
    private FlightUpgradeDialog flightUpgradeDialog;
    private FwUpgradeConditionDialog fwUpgradeConditionDialog;
    private Set<String> oldVersions;
    private boolean isStopDownload = false;
    private ArrayList<Version> versions = new ArrayList<>();
    private boolean isRequesting = false;

    private FwDownloadManager() {
    }

    public static FwDownloadManager getInstance() {
        if (instance == null) {
            synchronized (FwDownloadManager.class) {
                if (instance == null) {
                    FwDownloadManager fwDownloadManager = new FwDownloadManager();
                    instance = fwDownloadManager;
                    return fwDownloadManager;
                }
            }
        }
        return instance;
    }

    public void getFwFromServer(final OnResultListener<Boolean> onResultListener) {
        DDLog.e("\u4ece\u4e92\u8054\u7f51\u83b7\u53d6\u56fa\u4ef6\u7248\u672c...");
        String requestJson = getRequestJson();
        if (requestJson == null) {
            return;
        }
        DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "json\uff1a" + requestJson + ", isRequesting = " + this.isRequesting);
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        OkHttpUtil.getInstance().postJson(300, UserConstants.URL_GET_FW_VERSION_FROM_SERVER, requestJson, new CallBackString<Integer>() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public Integer onParseResponse(int i, String str) throws Exception {
                DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d:", "\u83b7\u53d6\u56fa\u4ef6\u4fe1\u606f\u7ed3\u679c" + str);
                return Integer.valueOf(FwDownloadManager.this.parseToVersions(str));
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public void onResponse(int i, Integer num) {
                if (num.intValue() == 0) {
                    PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FwDownloadManager.this.isRequesting = false;
                            UserRequestPresenter.getInstance().onTokenError();
                        }
                    }, 3000L);
                    return;
                }
                FwDownloadManager.this.saveToLocal();
                if (FwDownloadManager.this.needDownload()) {
                    DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "\u9700\u8981\u4e0b\u8f7d\u5347\u7ea7\u6587\u4ef6");
                    onResultListener.onSuccess(FwDownloadManager.this.isForceDownload());
                } else {
                    DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "\u4e0d\u9700\u8981\u4e0b\u8f7d\u5347\u7ea7\u6587\u4ef6");
                    onResultListener.onFailed(new Exception());
                }
                FwDownloadManager.this.isRequesting = false;
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public void onFailure(int i, Exception exc) {
                FwDownloadManager.this.isRequesting = false;
                onResultListener.onFailed(exc);
                DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "\u83b7\u53d6\u65b0\u56fa\u4ef6\u9519\u8bef" + exc.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean isForceDownload() {
        ArrayList<Version> arrayList = this.versions;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < this.versions.size(); i++) {
                if (this.versions.get(i).getIsforce() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needDownload() {
        ArrayList<Version> arrayList = this.versions;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < this.versions.size(); i++) {
                if (needDownload(this.versions.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needDownload(Version version) {
        if (version == null || TextUtils.isEmpty(version.getDownloadurl()) || TextUtils.isEmpty(version.getClassname()) || version.getVersion().equalsIgnoreCase("0.0.0")) {
            return false;
        }
        if (SPHelper.getInstance().isNeedDownloadFw()) {
            DDLog.e(OutputKeys.VERSION, "boot\u6a21\u5f0f\u4e0b\u68c0\u6d4b\u5230\u6ca1\u6709\u5347\u7ea7\u56fa\u4ef6");
            if (version.getIsdel() != 1) {
                return version.getLocalPath() == null || !updateFileMD5Align(version, version.getLocalPath());
            }
            return false;
        }
        DDLog.e(OutputKeys.VERSION, "\u975eboot\u6a21\u5f0f\u4e0b\u8f7d\u56fa\u4ef6");
        if (version.getIsdel() == 1 || !versionComparison(version)) {
            return false;
        }
        return version.getLocalPath() == null || !updateFileMD5Align(version, version.getLocalPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int parseToVersions(String str) {
        byte flightByte;
        JSONObject parseObject;
        int i = -100;
        try {
            flightByte = FlightConfig.getLastFlight().getFlightByte();
            parseObject = JSONObject.parseObject(str);
            i = parseObject.getInteger("code").intValue();
        } catch (Exception e) {
            this.isRequesting = false;
            DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "\u89e3\u6790\u51fa\u9519" + e.getMessage());
        }
        if (i == 0) {
            return i;
        }
        if (i != 1) {
            return i;
        }
        this.versions.clear();
        JSONObject jSONObject = parseObject.getJSONObject(JamXmlElements.CLASS);
        for (String str2 : jSONObject.keySet()) {
            JSONObject parseObject2 = JSONObject.parseObject(jSONObject.getString(str2));
            for (String str3 : parseObject2.keySet()) {
                String string = parseObject2.getString(str3);
                if (str3.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1PRO_BATTERY) && FlightConfig.getLastFlight() == Flight.Flight_P1_PRO && SPHelper.getInstance().isP1ProBatteryUpdate() && string.contains("\"classname\":\"p1pro_battery\"")) {
                    string = string.replace("\"classname\":\"p1pro_battery\"", "\"classname\":\"battery\"");
                }
                Version version = (Version) JSONObject.parseObject(string, Version.class);
                version.setFlightType(str2);
                if (flightByte != 0) {
                    version.setFlightCode(flightByte);
                }
                this.versions.add(version);
                DDLog.e("version:" + version.toString());
            }
        }
        return i;
    }

    private String getRequestJson() {
        if (PhoneConfig.usrToken != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_ID, PhoneConfig.usrToken.getId());
                jSONObject.put("token", getBase64String(PhoneConfig.usrToken.getToken()));
                jSONObject.put("brand_code", 2);
                jSONObject.put("product_class", FlightConfig.getLastProductClass() + "");
                jSONObject.put("firmware_class", (Object) null);
                jSONObject.put("biography_vernum", SPHelper.getInstance().getFpvCurVersion());
                if (CameraConfig.ATOM_SP.equals(SPHelper.getInstance().getCameraClass())) {
                    jSONObject.put("camera_class", CameraConfig.ATOM_SP);
                } else {
                    jSONObject.put("camera_class", (Object) null);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                DDLog.e("\u53d1\u751f\u9519\u8bef:" + e.getMessage());
            }
        }
        return null;
    }

    private String getBase64String(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public void downloadFwManual(Version version, String str, String str2, DownloadListener2 downloadListener2) {
        File file = new File(LocalFileManager.getInstance().getFwDir(), version.getFilename());
        if (file.exists()) {
            downloadListener2.onDownloadEnd(file.getAbsolutePath(), str, str2);
            return;
        }
        if (version == null || version.getDownloadurl() == null) {
            return;
        }
        try {
            DDLog.e("\u4e0b\u8f7d\u5730\u5740:" + version.toString());
            OkHttpUtil.getInstance().downloadUpgradeFileSyncManual(str, str2, UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER, version.getDownloadurl(), LocalFileManager.getInstance().getFwDir(), version.getFilename(), System.currentTimeMillis(), downloadListener2);
        } catch (Exception e) {
            DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6\u53d1\u751f\u9519\u8bef:" + e.getMessage());
            downloadListener2.onDownloadError(e);
        }
    }

    private boolean versionComparison(Version version) {
        String flightType = version.getFlightType();
        String classname = version.getClassname();
        String version2 = version.getVersion();
        if (classname == null || version2 == null || flightType == null || FlightConfig.getLastProductClass() == null || !flightType.equalsIgnoreCase(FlightConfig.getLastProductClass())) {
            return false;
        }
        if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL)) {
            DDLog.e(OutputKeys.VERSION, "\u5f53\u524d\u98de\u63a7\u7248\u672c: " + FlightRevData.get().getFlightRevVersionData().getFlightControlVersion() + "\uff0c\u540e\u53f0\uff1a" + version2 + ", \u4f18\u5148\u7ea7\uff1a" + version.getWeight() + ", \u5f3a\u5236\u5347\u7ea7\uff1a" + version.getIsforce() + ", SP\u98de\u63a7\u7248\u672c\uff1a" + SPHelper.getInstance().getFlightCurVersion());
            if (SPHelper.getInstance().getFlightCurVersion() == null) {
                return CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getFlightControlVersion(), version2);
            }
            return CommonUtil.hasNewVersion(SPHelper.getInstance().getFlightCurVersion(), version2);
        }
        if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA) || classname.equalsIgnoreCase(CameraConfig.ATOM_SP)) {
            DDLog.e(OutputKeys.VERSION, "\u5f53\u524d\u76f8\u673a\u7248\u672c: " + CameraConfig.get().getSoftVersion() + "\uff0c\u540e\u53f0\uff1a" + version2 + ", \u4f18\u5148\u7ea7\uff1a" + version.getWeight() + ", \u5f3a\u5236\u5347\u7ea7\uff1a" + version.getIsforce() + ", SP\u76f8\u673a\u7248\u672c: " + SPHelper.getInstance().getCameraCurVersion());
            if (SPHelper.getInstance().getCameraCurVersion() == null) {
                return CommonUtil.hasNewVersion(CameraConfig.get().getSoftVersion(), version2);
            }
            return CommonUtil.hasNewVersion(SPHelper.getInstance().getCameraCurVersion(), version2);
        }
        if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL)) {
            DDLog.e(OutputKeys.VERSION, "\u5f53\u524d\u4e91\u53f0\u7248\u672c: " + FlightRevData.get().getFlightRevVersionData().getGimbalVersion() + "\uff0c\u540e\u53f0\uff1a" + version2 + ", \u4f18\u5148\u7ea7\uff1a" + version.getWeight() + ", \u5f3a\u5236\u5347\u7ea7\uff1a" + version.getIsforce() + ", SP\u4e91\u53f0\u7248\u672c\uff1a" + SPHelper.getInstance().getGimbalCurVersion());
            if (SPHelper.getInstance().getGimbalCurVersion() == null) {
                return CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getGimbalVersion(), version2);
            }
            return CommonUtil.hasNewVersion(SPHelper.getInstance().getGimbalCurVersion(), version2);
        }
        if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_RC)) {
            DDLog.e(OutputKeys.VERSION, "\u5f53\u524d\u9065\u63a7\u5668\u7248\u672c: " + FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() + "\uff0c\u540e\u53f0\uff1a" + version2 + ", \u4f18\u5148\u7ea7\uff1a" + version.getWeight() + ", \u5f3a\u5236\u5347\u7ea7\uff1a" + version.getIsforce() + ", SP\u9065\u63a7\u5668\u7248\u672c\uff1a" + SPHelper.getInstance().getRemoterCurVersion());
            if (SPHelper.getInstance().getRemoterCurVersion() == null) {
                if (UsbConfig.isUsbConnected) {
                    return CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion(), version2);
                }
                return CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getRemoterVersion(), version2);
            }
            return CommonUtil.hasNewVersion(SPHelper.getInstance().getRemoterCurVersion(), version2);
        }
        if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV)) {
            DDLog.e(OutputKeys.VERSION, "\u5f53\u524d\u56fe\u4f20\u7248\u672c: " + FlightRevData.get().getFlightRevFpvData().getFpvVersion() + "\uff0c\u540e\u53f0\uff1a" + version2 + ", \u4f18\u5148\u7ea7\uff1a" + version.getWeight() + ", \u5f3a\u5236\u5347\u7ea7\uff1a" + version.getIsforce() + ", SP\u56fe\u4f20\u7248\u672c\uff1a" + SPHelper.getInstance().getFpvCurVersion());
            if (SPHelper.getInstance().getFpvCurVersion() == null) {
                return CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevFpvData().getFpvVersion(), version2);
            }
            return CommonUtil.hasNewVersion(SPHelper.getInstance().getFpvCurVersion(), version2);
        }
        if (!classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_BATTERY)) {
            return false;
        }
        DDLog.e(OutputKeys.VERSION, "\u5f53\u524d\u7535\u6c60\u7248\u672c: " + FlightRevData.get().getFlightRevVersionData().getBatteryVersion() + "\uff0c\u540e\u53f0\uff1a" + version2 + ", \u4f18\u5148\u7ea7\uff1a" + version.getWeight() + ", \u5f3a\u5236\u5347\u7ea7\uff1a" + version.getIsforce() + ", SP\u7535\u6c60\u7248\u672c\uff1a" + SPHelper.getInstance().getBatteryCurVersion());
        if (SPHelper.getInstance().getBatteryCurVersion() == null) {
            return CommonUtil.hasNewVersion(FlightRevData.get().getFlightRevVersionData().getBatteryVersion(), version2);
        }
        return CommonUtil.hasNewVersion(SPHelper.getInstance().getBatteryCurVersion(), version2);
    }

    public void saveToLocal() {
        try {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < this.versions.size(); i++) {
                Version version = this.versions.get(i);
                if (!TextUtils.isEmpty(version.getFilename()) && !TextUtils.isEmpty(version.getDownloadurl())) {
                    File file = new File(LocalFileManager.getInstance().getFwDir(), version.getFilename());
                    DDLog.e("\u5347\u7ea7\u6587\u4ef6:" + version.toString());
                    DDLog.e("\u5347\u7ea7\u6587\u4ef6\u662f\u5426\u5b58\u5728:" + file.exists());
                    this.versions.get(i).setLocalPath(file.exists() ? file.getAbsolutePath() : null);
                    hashSet.add(JSONObject.toJSONString(version));
                }
            }
            SPHelper.getInstance().setUpgradeVersions(hashSet);
        } catch (Exception e) {
            DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "\u56fa\u4ef6\u4fdd\u5b58\u51fa\u9519\uff1a" + e.getMessage());
        }
    }

    public void startDownloadFw(final DownloadListener2 downloadListener2) {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                FwDownloadManager.this.isStopDownload = false;
                if (FwDownloadManager.this.versions == null || FwDownloadManager.this.versions.size() <= 0) {
                    return;
                }
                long j = 0;
                for (int i = 0; i < FwDownloadManager.this.versions.size(); i++) {
                    Version version = (Version) FwDownloadManager.this.versions.get(i);
                    if (FwDownloadManager.this.needDownload(version)) {
                        String substring = version.getFilesize().substring(0, version.getFilesize().length() - 2);
                        DDLog.e("file size:" + substring);
                        DDLog.e("file version:" + version.toString());
                        j += Long.parseLong(substring) * 1024;
                    }
                }
                DDLog.e("\u9700\u4e0b\u8f7d\u603b\u5927\u5c0f:" + j);
                if (FwDownloadManager.this.needDownload()) {
                    downloadListener2.onDownloadStart(j);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= FwDownloadManager.this.versions.size()) {
                            break;
                        }
                        if (FwDownloadManager.this.isStopDownload) {
                            FwDownloadManager.this.isStopDownload = false;
                            break;
                        }
                        Version version2 = (Version) FwDownloadManager.this.versions.get(i2);
                        if (FwDownloadManager.this.needDownload(version2)) {
                            if (version2.getLocalPath() != null && !FwDownloadManager.this.updateFileMD5Align(version2, version2.getLocalPath())) {
                                new File(version2.getLocalPath()).delete();
                                downloadListener2.onDownloadError(new Exception(""));
                                break;
                            }
                            FwDownloadManager.this.downloadFwManual(version2, version2.getProductclass(), version2.getFilesize().substring(0, version2.getFilesize().length() - 2), downloadListener2);
                        }
                        i2++;
                    }
                }
                downloadListener2.onDownloadFinished();
                FwDownloadManager.this.saveToLocal();
            }
        });
    }

    public void cancelDownload() {
        this.isStopDownload = true;
        OkHttpUtil.getInstance().cancelDownload();
    }

    public boolean updateFileMD5Align(Version version, String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            String str2 = new String(Md5Util.getFileMD5(file), "utf-8");
            DDLog.e("MD5\u6821\u9a8c \u8fdc\u7aef\uff1a" + version.getMd5file());
            DDLog.e("MD5\u6821\u9a8c \u672c\u5730\uff1a" + str2);
            if (version.getMd5file().equals(str2)) {
                return true;
            }
            DDLog.e("MD5\u5bf9\u6bd4\u4e0d\u540c\uff1a" + version);
            file.delete();
            DDLog.e("MD5\u5bf9\u6bd4\u4e0d\u540c\uff0c\u5220\u9664\u5df2\u4e0b\u8f7d\u7684\u6587\u4ef6");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Version getNewBatteryVersion(boolean z) {
        DDLog.w("\u7535\u6c60\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.getLastProductClass());
        return getNewVersion(FlightConfig.PRODUCT_CLASS_BATTERY, FlightRevData.get().getFlightRevVersionData().getBatteryVersion(), z);
    }

    public Version getNewFlightControlVersion(boolean z) {
        DDLog.w("\u98de\u63a7\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.getLastProductClass());
        return getNewVersion(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL, FlightRevData.get().getFlightRevVersionData().getFlightControlVersion(), z);
    }

    public Version getNewCameraVersion(boolean z) {
        DDLog.w("\u76f8\u673a\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.getLastProductClass());
        String cameraClass = SPHelper.getInstance().getCameraClass();
        DDLog.e("cameraType = " + cameraClass);
        if (CameraConfig.ATOM_SP.equals(cameraClass)) {
            return getNewVersion(CameraConfig.ATOM_SP, CameraConfig.get().getSoftVersion() != null ? CameraConfig.get().getSoftVersion() : null, z);
        }
        DDLog.w("\u76f8\u673a\u5347\u7ea7\u68c0\u6d4b\uff1a1");
        return getNewVersion(FlightConfig.PRODUCT_CLASS_CAMERA, CameraConfig.get().getSoftVersion() != null ? CameraConfig.get().getSoftVersion() : null, z);
    }

    public Version getNewGimbalVersion(boolean z) {
        DDLog.w("\u4e91\u53f0\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.getLastProductClass());
        return getNewVersion(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL, FlightRevData.get().getFlightRevVersionData().getGimbalVersion(), z);
    }

    public Version getNewRemoterVersion(boolean z) {
        DDLog.w("\u9065\u63a7\u5668\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.curFlight);
        return getNewVersion(FlightConfig.PRODUCT_CLASS_P1_PRO_RC, FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion(), z);
    }

    public Version getNewFpvVersion(boolean z) {
        DDLog.e("\u56fe\u4f20\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.curFlight);
        Set<String> upgradeVersions = SPHelper.getInstance().getUpgradeVersions();
        if (upgradeVersions == null) {
            return null;
        }
        Iterator<String> it = upgradeVersions.iterator();
        while (it.hasNext()) {
            Version version = (Version) JSONObject.parseObject(it.next(), Version.class);
            if (version != null && version.getClassname().equals(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV) && FlightConfig.curFlight != null && FlightConfig.curFlight.getFlightByte() == version.getFlightCode()) {
                DDLog.e("\u56fe\u4f20\u5347\u7ea71111111111");
                if (version.getLocalPath() != null && new File(version.getLocalPath()).exists() && updateFileMD5Align(version, version.getLocalPath())) {
                    DDLog.e("\u56fe\u4f20\u5347\u7ea7222222222");
                    String fpvVersion = FlightRevData.get().getFlightRevFpvData().getFpvVersion();
                    String lowerCase = version.getVersion().trim().toLowerCase();
                    DDLog.e("\u56fe\u4f20\u5347\u7ea7\u7248\u672c\u53f7:" + fpvVersion + ", newVersion = " + lowerCase);
                    if (fpvVersion != null) {
                        String[] split = fpvVersion.replace("V", "").replace("v", "").split("\\.");
                        String[] split2 = lowerCase.replace("V", "").replace("v", "").split("\\.");
                        if (Integer.parseInt(split[0]) < 2 && Integer.parseInt(split2[0]) < 2) {
                            DDLog.e("\u56fe\u4f20\u5347\u7ea7\u5916\u8d2d");
                            if (z || CommonUtil.hasNewVersion(fpvVersion, lowerCase)) {
                                return version;
                            }
                            return null;
                        }
                        if (Integer.parseInt(split[0]) >= 2 && Integer.parseInt(split2[0]) >= 2) {
                            if (z) {
                                return version;
                            }
                            DDLog.e("\u56fe\u4f20\u5347\u7ea7\u81ea\u7814");
                            if (CommonUtil.hasNewVersion(fpvVersion, lowerCase)) {
                                return version;
                            }
                            return null;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public Version getNewTofVersion(boolean z) {
        DDLog.w("tof\u5347\u7ea7\u68c0\u6d4b\uff1a" + FlightConfig.curFlight);
        return null;
    }

    private Version getNewVersion(String str, String str2, boolean z) {
        Set<String> upgradeVersions = SPHelper.getInstance().getUpgradeVersions();
        if (upgradeVersions == null) {
            return null;
        }
        Iterator<String> it = upgradeVersions.iterator();
        while (it.hasNext()) {
            Version version = (Version) JSONObject.parseObject(it.next(), Version.class);
            if (version != null && FlightConfig.curFlight != null && FlightConfig.curFlight.getFlightByte() == version.getFlightCode() && version.getClassname().equalsIgnoreCase(str) && version.getLocalPath() != null && new File(version.getLocalPath()).exists() && updateFileMD5Align(version, version.getLocalPath())) {
                if (z) {
                    return version;
                }
                if (str2 == null || !CommonUtil.hasNewVersion(str2, version.getVersion().trim().toLowerCase())) {
                    return null;
                }
                return version;
            }
        }
        return null;
    }

    public Version getBigPackageVersion() {
        String localPath;
        Version version = (Version) JSONObject.parseObject(SPHelper.getInstance().getLocalBigPackageVersion(), Version.class);
        if (version == null || FlightConfig.curFlight == null || FlightConfig.curFlight.getFlightByte() != version.getFlightCode() || (localPath = version.getLocalPath()) == null || !new File(localPath).exists() || !updateFileMD5Align(version, version.getLocalPath())) {
            return null;
        }
        return version;
    }

    public void showUpgradeDialog(Context context, Version version, boolean z) {
        showUpgradeDialog(context, version, false, 0, z);
    }

    public void showUpgradeDialog(final Context context, Version version, boolean z, int i, boolean z2) {
        if (FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
            return;
        }
        FlightUpgradeDialog flightUpgradeDialog = this.flightUpgradeDialog;
        if (flightUpgradeDialog == null || !flightUpgradeDialog.isShowing()) {
            DDLog.e("\u5f39\u51fa\u5347\u7ea7\u5f39\u7a97");
            FlightUpgradeDialog flightUpgradeDialog2 = this.flightUpgradeDialog;
            if (flightUpgradeDialog2 != null) {
                flightUpgradeDialog2.setDialogDismiss();
                this.flightUpgradeDialog.dismiss();
                this.flightUpgradeDialog = null;
            }
            FlightUpgradeDialog flightUpgradeDialog3 = new FlightUpgradeDialog(context, version, z2);
            this.flightUpgradeDialog = flightUpgradeDialog3;
            if (z) {
                flightUpgradeDialog3.forceUpgrade(i);
            }
            this.flightUpgradeDialog.show();
            this.flightUpgradeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (FwDownloadManager.this.flightUpgradeDialog != null) {
                        FwDownloadManager.this.flightUpgradeDialog.setOnDismissListener(null);
                    }
                }
            });
            this.flightUpgradeDialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Context context2 = context;
                    new GeneralDialog(context2, context2.getString(R.string.dialog_exit_upgrade), context.getString(R.string.dialog_exit_upgrade_describe), true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.4.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                            if (FwDownloadManager.this.flightUpgradeDialog != null) {
                                FwDownloadManager.this.flightUpgradeDialog.dismiss();
                                FwDownloadManager.this.flightUpgradeDialog = null;
                            }
                        }
                    }).show();
                }
            });
        }
    }

    public void showCamUpgradeDialog(Context context, Version version, boolean z) {
        if (PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
            return;
        }
        CameraUpgradeDialog cameraUpgradeDialog = this.cameraUpgradeDialog;
        if (cameraUpgradeDialog != null) {
            cameraUpgradeDialog.dismiss();
            this.cameraUpgradeDialog = null;
        }
        CameraUpgradeDialog cameraUpgradeDialog2 = new CameraUpgradeDialog(context, version, z);
        this.cameraUpgradeDialog = cameraUpgradeDialog2;
        cameraUpgradeDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.utils.FwDownloadManager.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (FwDownloadManager.this.cameraUpgradeDialog != null) {
                    FwDownloadManager.this.cameraUpgradeDialog.dismiss();
                    FwDownloadManager.this.cameraUpgradeDialog = null;
                }
            }
        });
        this.cameraUpgradeDialog.show();
    }

    public void setCamUpgradeDismiss() {
        try {
            if (this.cameraUpgradeDialog != null) {
                DDLog.w("\u5347\u7ea7\u5f39\u7a97\u6d88\u59310");
                this.cameraUpgradeDialog.setDialogDismiss();
                this.cameraUpgradeDialog.dismiss();
                this.cameraUpgradeDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    public void setFlightUpgradeDismiss() {
        try {
            if (this.flightUpgradeDialog != null) {
                DDLog.w("\u5347\u7ea7\u5f39\u7a97\u6d88\u59311");
                this.flightUpgradeDialog.setDialogDismiss();
                this.flightUpgradeDialog.dismiss();
                this.flightUpgradeDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    public void setFlightDialogDismiss() {
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.fwUpgradeConditionDialog;
        if (fwUpgradeConditionDialog == null || !fwUpgradeConditionDialog.isShowing()) {
            return;
        }
        this.fwUpgradeConditionDialog.dismiss();
        this.fwUpgradeConditionDialog = null;
    }

    public void setCamUpgradeProgress(int i) {
        CameraUpgradeDialog cameraUpgradeDialog = this.cameraUpgradeDialog;
        if (cameraUpgradeDialog == null || !cameraUpgradeDialog.isShowing()) {
            return;
        }
        this.cameraUpgradeDialog.refreshProgress(i);
    }

    public boolean isDialogShowing() {
        FlightUpgradeDialog flightUpgradeDialog;
        FwUpgradeConditionDialog fwUpgradeConditionDialog;
        CameraUpgradeDialog cameraUpgradeDialog = this.cameraUpgradeDialog;
        return (cameraUpgradeDialog != null && cameraUpgradeDialog.isShowing()) || ((flightUpgradeDialog = this.flightUpgradeDialog) != null && flightUpgradeDialog.isShowing()) || (((fwUpgradeConditionDialog = this.fwUpgradeConditionDialog) != null && fwUpgradeConditionDialog.isShowing()) || isSuccessDialogShowing());
    }

    private boolean isSuccessDialogShowing() {
        FlightUpgradeDialog flightUpgradeDialog = this.flightUpgradeDialog;
        if (flightUpgradeDialog != null) {
            return flightUpgradeDialog.isUpgradeTipsDialogShowing();
        }
        CameraUpgradeDialog cameraUpgradeDialog = this.cameraUpgradeDialog;
        if (cameraUpgradeDialog != null) {
            return cameraUpgradeDialog.isUpgradeTipsDialogShowing();
        }
        return false;
    }

    public boolean upgradeCondition(Context context, Version version) {
        if (FlightRevData.get().getFlightRevUpgradeData().isUpgradeMode()) {
            DDLog.e("\u5347\u7ea7\u6761\u4ef6 bootloader\u5347\u7ea7\u6a21\u5f0f\u4e2d");
            return true;
        }
        boolean z = FlightRevData.get().getFlightRemoterBatteryData() != null && FlightRevData.get().getFlightRemoterBatteryData().isRemoterLowPower();
        boolean z2 = FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() != -1 && FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() < 30;
        String classname = version.getClassname();
        if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL)) {
            if (z2 || z) {
                upgradeDismiss();
                FwUpgradeConditionDialog fwUpgradeConditionDialog = new FwUpgradeConditionDialog(context, context.getString(R.string.flightcontrol), true, z2, z, null, true);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog;
                fwUpgradeConditionDialog.show();
                return false;
            }
        } else if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA) || classname.equalsIgnoreCase(CameraConfig.ATOM_SP)) {
            String string = CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_EXIST ? context.getString(R.string.sd_no_sdcard) : null;
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NEED_FORMAT) {
                string = context.getString(R.string.title_pls_format);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_ENOUGH_SPACE) {
                string = context.getString(R.string.sd_sdcard_is_full);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_LOW_SPEED) {
                string = context.getString(R.string.sd_speed_low);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_UNRECOGNIZED) {
                string = context.getString(R.string.sd_unknown_type);
            }
            String str = string;
            if (z2 || z || str != null) {
                upgradeDismiss();
                FwUpgradeConditionDialog fwUpgradeConditionDialog2 = new FwUpgradeConditionDialog(context, context.getString(R.string.camera), true, z2, z, str, true);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog2;
                fwUpgradeConditionDialog2.show();
                return false;
            }
        } else if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL)) {
            if (z2 || z) {
                upgradeDismiss();
                FwUpgradeConditionDialog fwUpgradeConditionDialog3 = new FwUpgradeConditionDialog(context, context.getString(R.string.gimbal), true, z2, z, null, true);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog3;
                fwUpgradeConditionDialog3.show();
                return false;
            }
        } else if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV)) {
            if (FlightConfig.isConnectFlight()) {
                if (z2 || z) {
                    upgradeDismiss();
                    FwUpgradeConditionDialog fwUpgradeConditionDialog4 = new FwUpgradeConditionDialog(context, context.getString(R.string.fpv), true, z2, z, null, true);
                    this.fwUpgradeConditionDialog = fwUpgradeConditionDialog4;
                    fwUpgradeConditionDialog4.show();
                    return false;
                }
            } else if (z) {
                upgradeDismiss();
                FwUpgradeConditionDialog fwUpgradeConditionDialog5 = new FwUpgradeConditionDialog(context, context.getString(R.string.fpv), false, false, true, null, true);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog5;
                fwUpgradeConditionDialog5.show();
                return false;
            }
        } else if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_BATTERY)) {
            if (z2 || z) {
                upgradeDismiss();
                FwUpgradeConditionDialog fwUpgradeConditionDialog6 = new FwUpgradeConditionDialog(context, context.getString(R.string.battery), true, z2, z, null, true);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog6;
                fwUpgradeConditionDialog6.show();
                return false;
            }
        } else if (classname.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_RC) && z) {
            upgradeDismiss();
            FwUpgradeConditionDialog fwUpgradeConditionDialog7 = new FwUpgradeConditionDialog(context, context.getString(R.string.remotecontrol), false, false, true, null, true);
            this.fwUpgradeConditionDialog = fwUpgradeConditionDialog7;
            fwUpgradeConditionDialog7.show();
            return false;
        }
        getUpdateVersion(version);
        return true;
    }

    public void refreshFwUpgradeConditionDialogShow() {
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.fwUpgradeConditionDialog;
        if (fwUpgradeConditionDialog == null || !fwUpgradeConditionDialog.isShowing()) {
            return;
        }
        this.fwUpgradeConditionDialog.refreshSdcard();
    }

    private void getUpdateVersion(Version version) {
        String cameraCurVersion;
        String str;
        DDLog.e("\u63d0\u4ea4\u5c1d\u8bd5\u5347\u7ea7\u63a5\u53e3");
        if (PhoneConfig.usrToken == null || FlightConfig.getLastProductClass() == null || SPHelper.getInstance().getFlightControllerSN() == null || version.getVersion() == null) {
            return;
        }
        String lowerCase = version.getClassname().toLowerCase();
        if (lowerCase.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL)) {
            cameraCurVersion = SPHelper.getInstance().getFlightCurVersion();
            str = UserConstants.FC_VER;
        } else if (lowerCase.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA) || lowerCase.equalsIgnoreCase(CameraConfig.ATOM_SP)) {
            cameraCurVersion = SPHelper.getInstance().getCameraCurVersion();
            str = UserConstants.CAMERA_VER;
        } else if (lowerCase.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV)) {
            cameraCurVersion = SPHelper.getInstance().getFpvCurVersion();
            str = UserConstants.BIOGRAPHY_VER;
        } else if (lowerCase.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL)) {
            cameraCurVersion = SPHelper.getInstance().getGimbalCurVersion();
            str = UserConstants.GIMBAL_VER;
        } else if (lowerCase.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_RC)) {
            cameraCurVersion = SPHelper.getInstance().getRemoterCurVersion();
            str = UserConstants.REMOTECTROL_VER;
        } else if (lowerCase.equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_BATTERY)) {
            cameraCurVersion = SPHelper.getInstance().getBatteryCurVersion();
            str = UserConstants.BATTERY_VER;
        } else {
            str = null;
            cameraCurVersion = "0.0.0";
        }
        if (SPHelper.getInstance().getIsBigPackage()) {
            cameraCurVersion = SPHelper.getInstance().getBigPackageVersion();
            str = UserConstants.LARGEPACKAGE_VER;
        }
        String str2 = cameraCurVersion;
        String str3 = str;
        DDLog.e("\u63d0\u4ea4\u5c1d\u8bd5\u5347\u7ea7\u63a5\u53e3:" + str3 + "," + str2);
        if (str3 == null || str2 == null) {
            return;
        }
        DDLog.e("updateVersion", "className: " + lowerCase + ", firmwareType: " + str3 + ", currentVersion: " + str2);
        UserRequestPresenter.getInstance().getUpdateVersion(PhoneConfig.usrToken, FlightConfig.getLastProductClass(), SPHelper.getInstance().getFlightControllerSN(), str3, str2, version.getVersion(), SPHelper.getInstance().getRemoteControllerSN());
    }

    private void upgradeDismiss() {
        DDLog.e("\u5347\u7ea7\u5f39\u7a97\u6d88\u59312");
        CameraUpgradeDialog cameraUpgradeDialog = this.cameraUpgradeDialog;
        if (cameraUpgradeDialog != null) {
            cameraUpgradeDialog.dismiss();
            this.cameraUpgradeDialog = null;
        }
        FlightUpgradeDialog flightUpgradeDialog = this.flightUpgradeDialog;
        if (flightUpgradeDialog != null) {
            flightUpgradeDialog.dismiss();
            this.flightUpgradeDialog = null;
        }
    }
}