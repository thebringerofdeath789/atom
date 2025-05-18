package com.ipotensic.kernel.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.DownloadListener2;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.activitys.BigPackageActivity;
import com.ipotensic.kernel.maps.utils.NoFlyZoneUtil;
import com.ipotensic.kernel.utils.ForceUpgradeCheck;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog;
import com.logan.camera.CameraConfig;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.upgrade.big.BigPackageHelper;
import com.logan.upgrade.server.Version;
import com.logan.usb.utils.Md5Util;
import com.logan.user.model.UserConstants;
import com.logan.user.presenter.UserRequestPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes2.dex */
public class BigPackageFirmwareDownload {
    private static final String TAG = "BigPackageFirmwareDownload";
    private BaseActivity activity;
    private FwUpgradeConditionDialog downLoadDialog;
    private boolean isCancelDownload;
    private boolean isForceDownload;
    private boolean isRequesting;
    private Version version;

    public interface BigPackageRequestResultListener {
        void requestFailed();

        void requestSuccess();
    }

    private BigPackageFirmwareDownload() {
        this.isRequesting = false;
        this.isCancelDownload = false;
    }

    private static class Holder {
        private static final BigPackageFirmwareDownload instance = new BigPackageFirmwareDownload();

        private Holder() {
        }
    }

    public static BigPackageFirmwareDownload getInstance() {
        return Holder.instance;
    }

    public void checkDownloadFW(BaseActivity baseActivity, final BigPackageRequestResultListener bigPackageRequestResultListener) {
        this.activity = baseActivity;
        if (FlightRevData.get().getFlightRevStateData().isFlight() || !FlightConfig.isConnectFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isTakeOff() || !SPHelper.getInstance().getIsBigPackage() || this.isCancelDownload || PhoneConfig.usrToken == null) {
            return;
        }
        if (FlightConfig.getBigPackageLastProductClass() == null && FlightConfig.getLastFlight() == null) {
            return;
        }
        String requestJson = getRequestJson();
        DDLog.e("\u5927\u5305\u5f00\u59cb\u83b7\u53d6\u5347\u7ea7\u56fa\u4ef6:" + requestJson);
        if (requestJson == null) {
            return;
        }
        OkHttpUtil.getInstance().postJson(300, UserConstants.URL_GET_FW_VERSION_FROM_SERVER, requestJson, new CallBackString<Integer>() { // from class: com.ipotensic.kernel.manager.BigPackageFirmwareDownload.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public Integer onParseResponse(int i, String str) throws Exception {
                DDLog.e("\u5927\u5305\u56fa\u4ef6\u4e0b\u8f7d:", "\u83b7\u53d6\u56fa\u4ef6\u4fe1\u606f\u7ed3\u679c" + str);
                return Integer.valueOf(BigPackageFirmwareDownload.this.parseToVersions(str));
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public void onResponse(int i, Integer num) {
                if (num.intValue() == 0) {
                    PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.manager.BigPackageFirmwareDownload.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BigPackageFirmwareDownload.this.isRequesting = false;
                            UserRequestPresenter.getInstance().onTokenError();
                        }
                    }, 3000L);
                    return;
                }
                if (num.intValue() == 1) {
                    BigPackageFirmwareDownload.this.saveToLocal();
                    BigPackageFirmwareDownload bigPackageFirmwareDownload = BigPackageFirmwareDownload.this;
                    if (bigPackageFirmwareDownload.needDownload(bigPackageFirmwareDownload.version)) {
                        BigPackageFirmwareDownload bigPackageFirmwareDownload2 = BigPackageFirmwareDownload.this;
                        bigPackageFirmwareDownload2.showFirmwareDownDialog(bigPackageFirmwareDownload2.isForceDownload, true);
                    } else {
                        ForceUpgradeCheck.getInstance().checkBigPackageUpgrade();
                    }
                    BigPackageFirmwareDownload.this.isRequesting = false;
                    BigPackageRequestResultListener bigPackageRequestResultListener2 = bigPackageRequestResultListener;
                    if (bigPackageRequestResultListener2 != null) {
                        bigPackageRequestResultListener2.requestSuccess();
                    }
                }
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public void onFailure(int i, Exception exc) {
                BigPackageFirmwareDownload.this.isRequesting = false;
                DDLog.e("\u5927\u5305\u56fa\u4ef6\u4e0b\u8f7d", "\u83b7\u53d6\u65b0\u56fa\u4ef6\u9519\u8bef" + exc);
                BigPackageRequestResultListener bigPackageRequestResultListener2 = bigPackageRequestResultListener;
                if (bigPackageRequestResultListener2 != null) {
                    bigPackageRequestResultListener2.requestFailed();
                }
                ForceUpgradeCheck.getInstance().checkBigPackageUpgrade();
            }
        });
    }

    public void saveToLocal() {
        try {
            if (TextUtils.isEmpty(this.version.getFilename())) {
                return;
            }
            File file = new File(LocalFileManager.getInstance().getFwDir(), this.version.getFilename());
            DDLog.e("\u5927\u5305\u5347\u7ea7\u6587\u4ef6:" + this.version.toString());
            DDLog.e("\u5927\u5305\u5347\u7ea7\u6587\u4ef6\u662f\u5426\u5b58\u5728:" + file.exists());
            this.version.setLocalPath(file.exists() ? file.getAbsolutePath() : null);
            SPHelper.getInstance().setLocalBigPackageVersion(JSONObject.toJSONString(this.version));
        } catch (Exception e) {
            DDLog.e("\u5927\u5305\u56fa\u4ef6\u4e0b\u8f7d", "\u56fa\u4ef6\u4fdd\u5b58\u51fa\u9519\uff1a" + e);
        }
    }

    public void showFirmwareDownDialog(final boolean z, final boolean z2) {
        DDLog.e("\u5927\u5305\u9700\u8981\u4e0b\u8f7d\u56fa\u4ef6");
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.downLoadDialog;
        if ((fwUpgradeConditionDialog == null || !fwUpgradeConditionDialog.isShowing()) && !FlightRevData.get().getFlightRevStateData().isUnLock() && !this.activity.isFinishing() && BigPackageHelper.get().isGimbalTestPass() && SPHelper.getInstance().isUpgradeHandshakePass() && !NoFlyZoneUtil.INSTANCE.isShowUpdateNoFlyZoneTip(SPHelper.getInstance().getBigPackageVersion())) {
            FwUpgradeConditionDialog fwUpgradeConditionDialog2 = this.downLoadDialog;
            if (fwUpgradeConditionDialog2 != null) {
                fwUpgradeConditionDialog2.dismiss();
                this.downLoadDialog = null;
            }
            DDLog.e("\u5927\u5305\u4e0b\u8f7d\u56fa\u4ef6\u5f39\u6846");
            if (this.downLoadDialog == null) {
                this.downLoadDialog = new FwUpgradeConditionDialog((Context) this.activity, R.layout.view_dialog_big_package_fw_download_black, true, z, new FwUpgradeConditionDialog.FwDownLoadListener() { // from class: com.ipotensic.kernel.manager.BigPackageFirmwareDownload.2
                    @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                    public void startDownLoad() {
                        try {
                            Intent intent = new Intent(BigPackageFirmwareDownload.this.activity, (Class<?>) BigPackageActivity.class);
                            intent.putExtra(BigPackageHelper.NEED_DOWNLOAD_FILE, z2);
                            intent.putExtra(BigPackageHelper.UPGRADING_PROGRESS, false);
                            BigPackageFirmwareDownload.this.activity.startActivity(intent);
                            FwDownloadManager.getInstance().upgradeCondition(BigPackageFirmwareDownload.this.activity, (Version) JSONObject.parseObject(SPHelper.getInstance().getLocalBigPackageVersion(), Version.class));
                        } catch (Exception e) {
                            DDLog.e("FwUpgradeConditionDialog startDownLoad exception " + e.getMessage());
                        }
                    }

                    @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                    public void cancelDownLoad() {
                        BigPackageFirmwareDownload.this.isCancelDownload = true;
                    }
                });
            }
            if (!this.downLoadDialog.isShowing()) {
                this.downLoadDialog.show();
            }
            this.downLoadDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.manager.BigPackageFirmwareDownload.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    DDLog.d(BigPackageFirmwareDownload.TAG, "downLoadDialog onDismiss");
                    BigPackageFirmwareDownload.this.downLoadDialog = null;
                    ForceUpgradeCheck.getInstance().setNeedForceUpgradeTips(Boolean.valueOf(z));
                }
            });
        }
    }

    public boolean isShowFirmwareDownDialog() {
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.downLoadDialog;
        return fwUpgradeConditionDialog != null && fwUpgradeConditionDialog.isShowing();
    }

    public void dismissDialog() {
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.downLoadDialog;
        if (fwUpgradeConditionDialog == null || !fwUpgradeConditionDialog.isShowing()) {
            return;
        }
        this.downLoadDialog.dismiss();
        this.downLoadDialog = null;
    }

    public void resetCancelDownload() {
        this.isCancelDownload = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needDownload(Version version) {
        if (version == null || TextUtils.isEmpty(version.getClassname()) || TextUtils.isEmpty(version.getDownloadurl())) {
            return false;
        }
        this.isForceDownload = version.getIsforce() == 0;
        if (SPHelper.getInstance().isNeedDownloadFw()) {
            DDLog.e("\u5927\u5305\u5347\u7ea7\u68c0\u6d4b \u6ca1\u6709\u56fa\u4ef6");
            if (version.getIsdel() != 1) {
                return version.getLocalPath() == null || !updateFileMD5Align(version, version.getLocalPath());
            }
            return false;
        }
        DDLog.e("\u5927\u5305\u5347\u7ea7\u68c0\u6d4b \u975eboot\u6a21\u5f0f");
        if (version.getIsdel() == 1 || !versionComparison(version)) {
            return false;
        }
        return version.getLocalPath() == null || !updateFileMD5Align(version, version.getLocalPath());
    }

    private boolean versionComparison(Version version) {
        String bigPackageVersion = SPHelper.getInstance().getBigPackageVersion();
        if (bigPackageVersion == null) {
            return true;
        }
        return CommonUtil.hasNewVersion(bigPackageVersion, version.getVersion());
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
            DDLog.e("MD5\u5bf9\u6bd4\u4e0d\u540c\uff1a" + version.toString());
            file.delete();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
            DDLog.e("\u5927\u5305\u83b7\u53d6\u56fa\u4ef6\u89e3\u6790\u51fa\u9519" + e);
        }
        if (i != 1) {
            return i;
        }
        JSONObject jSONObject = parseObject.getJSONObject(JamXmlElements.CLASS);
        for (String str2 : jSONObject.keySet()) {
            if (str2.equalsIgnoreCase(!TextUtils.isEmpty(FlightConfig.getBigPackageLastProductClass()) ? FlightConfig.getBigPackageLastProductClass() : FlightConfig.getLastProductClass())) {
                JSONObject parseObject2 = JSONObject.parseObject(jSONObject.getString(str2));
                Iterator<String> it = parseObject2.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (next.equalsIgnoreCase("largePackage")) {
                        DDLog.e("\u5927\u5305json: " + parseObject2);
                        String string = parseObject2.getString(next);
                        JSONObject parseObject3 = JSONObject.parseObject(string);
                        this.version = (Version) JSONObject.parseObject(string, Version.class);
                        JSONObject parseObject4 = JSONObject.parseObject(parseObject3.getString("language_more"));
                        Set<String> keySet = parseObject4.keySet();
                        ArrayList<Version.ProductData> arrayList = new ArrayList<>();
                        for (String str3 : keySet) {
                            String string2 = parseObject4.getString(str3);
                            if (str3.equalsIgnoreCase("bms")) {
                                JSONArray parseArray = JSONObject.parseArray(string2);
                                for (int i2 = 0; i2 < parseArray.size(); i2++) {
                                    Version.ProductData productData = (Version.ProductData) ((JSONObject) parseArray.get(i2)).toJavaObject(Version.ProductData.class);
                                    productData.setType(str3);
                                    arrayList.add(productData);
                                }
                            } else {
                                Version.ProductData productData2 = (Version.ProductData) JSONObject.parseObject(string2, Version.ProductData.class);
                                productData2.setType(str3);
                                arrayList.add(productData2);
                            }
                        }
                        this.version.setTypeList(arrayList);
                    }
                }
                this.version.setFlightType(str2);
                if (flightByte != 0) {
                    this.version.setFlightCode(flightByte);
                }
                DDLog.e("\u5927\u5305version:" + this.version.toString());
                return i;
            }
        }
        return i;
    }

    private String getRequestJson() {
        if (PhoneConfig.usrToken != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(PhoneConfig.usrToken.getId()));
                jSONObject.put("token", (Object) getBase64String(PhoneConfig.usrToken.getToken()));
                jSONObject.put("brand_code", (Object) 2);
                if (TextUtils.isEmpty(FlightConfig.getBigPackageLastProductClass())) {
                    jSONObject.put("product_class", (Object) (FlightConfig.getLastProductClass() + ""));
                } else {
                    jSONObject.put("product_class", (Object) (FlightConfig.getBigPackageLastProductClass() + ""));
                }
                jSONObject.put("firmware_class", (Object) "largePackage");
                jSONObject.put("language_more", (Object) Integer.valueOf(LanguageHelper.getPhoneLanguageType()));
                jSONObject.put("biography_vernum", (Object) SPHelper.getInstance().getFpvCurVersion());
                jSONObject.put("clienttype", (Object) 1);
                jSONObject.put("appver", (Object) CommonUtil.getAppVersion());
                if (CameraConfig.ATOM_SP.equals(SPHelper.getInstance().getCameraClass())) {
                    jSONObject.put("camera_class", (Object) CameraConfig.ATOM_SP);
                } else {
                    jSONObject.put("camera_class", (Object) null);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                DDLog.e("\u5927\u5305\u53d1\u751f\u9519\u8bef:" + e.getMessage());
            }
        }
        return null;
    }

    private String getBase64String(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public void startDownloadFirmware(final DownloadListener2 downloadListener2) {
        try {
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.manager.BigPackageFirmwareDownload.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BigPackageFirmwareDownload.this.version == null) {
                        downloadListener2.onDownloadError(new Exception(BigPackageFirmwareDownload.this.activity.getString(R.string.download_fail)));
                        return;
                    }
                    BigPackageFirmwareDownload bigPackageFirmwareDownload = BigPackageFirmwareDownload.this;
                    if (bigPackageFirmwareDownload.needDownload(bigPackageFirmwareDownload.version)) {
                        if (BigPackageFirmwareDownload.this.version.getLocalPath() != null) {
                            BigPackageFirmwareDownload bigPackageFirmwareDownload2 = BigPackageFirmwareDownload.this;
                            if (!bigPackageFirmwareDownload2.updateFileMD5Align(bigPackageFirmwareDownload2.version, BigPackageFirmwareDownload.this.version.getLocalPath())) {
                                new File(BigPackageFirmwareDownload.this.version.getLocalPath()).delete();
                                downloadListener2.onDownloadError(new Exception(BigPackageFirmwareDownload.this.activity.getString(R.string.download_fail)));
                                return;
                            }
                        }
                        String substring = BigPackageFirmwareDownload.this.version.getFilesize().substring(0, BigPackageFirmwareDownload.this.version.getFilesize().length() - 2);
                        File file = new File(LocalFileManager.getInstance().getFwDir(), BigPackageFirmwareDownload.this.version.getFilename());
                        downloadListener2.onDownloadStart(Long.parseLong(substring) * 1024);
                        if (file.exists()) {
                            downloadListener2.onDownloadEnd(file.getAbsolutePath(), BigPackageFirmwareDownload.this.version.getProductclass(), substring);
                            return;
                        }
                        if (TextUtils.isEmpty(BigPackageFirmwareDownload.this.version.getDownloadurl())) {
                            return;
                        }
                        try {
                            DDLog.e("\u5927\u5305\u4e0b\u8f7d\u5730\u5740:" + BigPackageFirmwareDownload.this.version.toString());
                            OkHttpUtil.getInstance().downloadUpgradeFileSyncManual(BigPackageFirmwareDownload.this.version.getProductclass(), substring, UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER, BigPackageFirmwareDownload.this.version.getDownloadurl(), LocalFileManager.getInstance().getFwDir(), BigPackageFirmwareDownload.this.version.getFilename(), System.currentTimeMillis(), downloadListener2);
                        } catch (Exception e) {
                            DDLog.e("\u5927\u5305\u4e0b\u8f7d\u56fa\u4ef6\u53d1\u751f\u9519\u8bef:" + e.getMessage());
                            BigPackageFirmwareDownload.this.retryDownload(downloadListener2);
                        }
                    }
                }
            });
        } catch (Exception e) {
            DDLog.e("\u5927\u5305\u56fa\u4ef6\u4e0b\u8f7d\u5f02\u5e38e: " + e);
        }
    }

    public void retryDownload(DownloadListener2 downloadListener2) {
        try {
            DDLog.e("\u5927\u5305\u4e0b\u8f7d\u56fa\u4ef6\u91cd\u8bd5");
            if (TextUtils.isEmpty(this.version.getDownloadUrlBackup())) {
                return;
            }
            OkHttpUtil.getInstance().downloadUpgradeFileSyncManual(this.version.getProductclass(), this.version.getFilesize().substring(0, this.version.getFilesize().length() - 2), UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER, this.version.getDownloadUrlBackup(), LocalFileManager.getInstance().getFwDir(), this.version.getFilename(), System.currentTimeMillis(), downloadListener2);
        } catch (Exception e) {
            DDLog.e("\u5927\u5305\u4e0b\u8f7d\u56fa\u4ef6\u91cd\u8bd5\u53d1\u751f\u9519\u8bef:" + e.getMessage());
            downloadListener2.onDownloadError(e);
        }
    }
}