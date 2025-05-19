package com.ipotensic.kernel.manager;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.utils.FwDownloadHelper;
import com.logan.camera.CameraConfig;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.type.Flight;
import com.logan.upgrade.server.Version;
import com.logan.user.model.UserConstants;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class FlightFirmwareChecker {
    private static volatile FlightFirmwareChecker instance;
    private BaseActivity activity;
    private String msg;
    private int index = 0;
    private ArrayList<RegisterVersion> versions = new ArrayList<>();

    static /* synthetic */ int access$208(FlightFirmwareChecker flightFirmwareChecker) {
        int i = flightFirmwareChecker.index;
        flightFirmwareChecker.index = i + 1;
        return i;
    }

    private FlightFirmwareChecker() {
    }

    public static FlightFirmwareChecker getInstance() {
        if (instance == null) {
            synchronized (FlightFirmwareChecker.class) {
                if (instance == null) {
                    instance = new FlightFirmwareChecker();
                }
            }
        }
        return instance;
    }

    public void checkFirmwareVersion(final BaseActivity baseActivity, final boolean z, final FwDownloadHelper.DownloadResultListener downloadResultListener) {
        this.activity = baseActivity;
        if (FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isTakeOff() || SPHelper.getInstance().getIsBigPackage() || !isSmallPackageFlightModel() || PhoneConfig.usrToken == null) {
            return;
        }
        String requestJson = getRequestJson();
        DDLog.e("开始获取升级固件:" + requestJson);
        if (requestJson == null) {
            return;
        }
        OkHttpUtil.getInstance().postJson(29, UserConstants.URL_SEND_FIRMWARE_INFO, requestJson, new CallBackString<Integer>() { // from class: com.ipotensic.kernel.manager.FlightFirmwareChecker.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public Integer onParseResponse(int i, String str) throws Exception {
                Log.e("network", "response:" + str);
                return Integer.valueOf(FlightFirmwareChecker.this.parseToVersions(str));
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public void onResponse(int i, Integer num) {
                DDLog.e("network", "有网络");
                if (num.intValue() == 0) {
                    FlightFirmwareChecker.this.saveToLocal();
                }
                FwDownloadHelper.getInstance().downloadFw(baseActivity, z, downloadResultListener);
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackString
            public void onFailure(int i, Exception exc) {
                DDLog.e("network", "无网络:" + exc);
                if (exc instanceof UnknownHostException) {
                    DDLog.e("network", "request code :" + i + " , 无网络");
                    FlightFirmwareChecker.access$208(FlightFirmwareChecker.this);
                    if (FlightFirmwareChecker.this.index < 2) {
                        FlightFirmwareChecker.this.checkFirmwareVersion(baseActivity, z, downloadResultListener);
                        return;
                    }
                    FwDownloadHelper.DownloadResultListener downloadResultListener2 = downloadResultListener;
                    if (downloadResultListener2 != null) {
                        downloadResultListener2.downloadFailed();
                    }
                    FlightFirmwareChecker.this.index = 0;
                    return;
                }
                FwDownloadHelper.DownloadResultListener downloadResultListener3 = downloadResultListener;
                if (downloadResultListener3 != null) {
                    downloadResultListener3.downloadFailed();
                }
            }
        });
    }

    private String getRequestJson() {
        String languageType = LanguageHelper.getLanguageType(this.activity);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TtmlNode.ATTR_ID, PhoneConfig.usrToken.getId());
            jSONObject.put("token", getBase64String(PhoneConfig.usrToken.getToken()));
            jSONObject.put("brandcode", 2);
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, languageType);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getBase64String(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int parseToVersions(String str) {
        int intValue;
        DDLog.e("版本检测:" + str);
        com.alibaba.fastjson.JSONObject parseObject = com.alibaba.fastjson.JSONObject.parseObject(str);
        intValue = parseObject.getIntValue("code");
        if (intValue == 0) {
            this.versions.clear();
            com.alibaba.fastjson.JSONObject jSONObject = parseObject.getJSONObject("classname");
            for (String str2 : jSONObject.keySet()) {
                RegisterVersion registerVersion = (RegisterVersion) com.alibaba.fastjson.JSONObject.parseObject(jSONObject.getString(str2), RegisterVersion.class);
                registerVersion.setClassname(str2);
                this.versions.add(registerVersion);
            }
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToLocal() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.versions.size(); i++) {
            hashSet.add(com.alibaba.fastjson.JSONObject.toJSONString(this.versions.get(i)));
        }
        SPHelper.getInstance().setRegisterFirmwareInfo(hashSet);
    }

    public static class RegisterVersion {
        private String battery;
        private String biography;
        private String camera;
        private String classname;
        private String flight_control;
        private String gimbal;
        private int id;
        private String language;
        private String remote_control;

        public void setFlight_control(String str) {
            this.flight_control = str;
        }

        public void setRemote_control(String str) {
            this.remote_control = str;
        }

        public void setBiography(String str) {
            this.biography = str;
        }

        public void setClassname(String str) {
            this.classname = str;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public String getCamera() {
            return this.camera;
        }

        public void setCamera(String str) {
            this.camera = str;
        }

        public String getGimbal() {
            return this.gimbal;
        }

        public void setGimbal(String str) {
            this.gimbal = str;
        }

        public String getClassname() {
            return this.classname;
        }

        public String getFlight_control() {
            return this.flight_control;
        }

        public String getRemote_control() {
            return this.remote_control;
        }

        public String getBiography() {
            return this.biography;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setLanguage(String str) {
            this.language = str;
        }

        public String getBattery() {
            return this.battery;
        }

        public void setBattery(String str) {
            this.battery = str;
        }
    }

    private boolean isNeedUpgrade() {
        if (!FlightConfig.isConnectFlight()) {
            return false;
        }
        Set<String> registerFirmwareInfo = SPHelper.getInstance().getRegisterFirmwareInfo();
        FlightRevVersionData flightRevVersionData = FlightRevData.get().getFlightRevVersionData();
        String lastProductClass = FlightConfig.getLastProductClass();
        String remoteCtrlVersion = FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion();
        if (registerFirmwareInfo != null && flightRevVersionData != null && lastProductClass != null) {
            Iterator<String> it = registerFirmwareInfo.iterator();
            while (it.hasNext()) {
                RegisterVersion registerVersion = (RegisterVersion) com.alibaba.fastjson.JSONObject.parseObject(it.next(), RegisterVersion.class);
                if (registerVersion != null && registerVersion.getClassname().equalsIgnoreCase(lastProductClass)) {
                    this.msg = registerVersion.getLanguage();
                    DDLog.e("network", "version: " + registerVersion.getClassname() + ", flight: " + registerVersion.getFlight_control() + ", camera: " + registerVersion.getCamera() + ", gimbal: " + registerVersion.getGimbal() + ", biography: " + registerVersion.getBiography() + ", remote：" + registerVersion.getRemote_control());
                    if (localHasNewVersion(registerVersion)) {
                        DDLog.e("network", "msg:" + this.msg);
                        boolean hasNewVersion = hasNewVersion(flightRevVersionData.getFlightControlVersion(), registerVersion.getFlight_control());
                        boolean hasNewVersion2 = hasNewVersion(CameraConfig.get().getSoftVersion(), registerVersion.getCamera());
                        if (!hasNewVersion && !hasNewVersion2) {
                            if (FlightConfig.isP1ProByProductClass(registerVersion.getClassname()) || FlightConfig.isP1SelfBByProductClass(registerVersion.getClassname()) || FlightConfig.isAtomOrAtomSeByProductClass(registerVersion.getClassname())) {
                                boolean hasNewVersion3 = hasNewVersion(flightRevVersionData.getFpvVersion(), registerVersion.getBiography());
                                boolean hasNewVersion4 = hasNewVersion(flightRevVersionData.getGimbalVersion(), registerVersion.getGimbal());
                                boolean hasNewVersion5 = hasNewVersion(remoteCtrlVersion, registerVersion.getRemote_control());
                                if (!hasNewVersion3) {
                                    if (!hasNewVersion4) {
                                        if (hasNewVersion5) {
                                        }
                                    }
                                }
                            }
                            if (FlightConfig.isAtomOrAtomSeByProductClass(registerVersion.getClassname()) && hasNewVersion(flightRevVersionData.getBatteryVersion(), registerVersion.getBattery())) {
                            }
                        }
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private boolean localHasNewVersion(RegisterVersion registerVersion) {
        String flight_control = registerVersion.getFlight_control();
        String camera = registerVersion.getCamera();
        String biography = registerVersion.getBiography();
        String gimbal = registerVersion.getGimbal();
        String remote_control = registerVersion.getRemote_control();
        String battery = registerVersion.getBattery();
        Set<String> upgradeVersions = SPHelper.getInstance().getUpgradeVersions();
        if (upgradeVersions == null) {
            return false;
        }
        Iterator<String> it = upgradeVersions.iterator();
        while (it.hasNext()) {
            Version version = (Version) com.alibaba.fastjson.JSONObject.parseObject(it.next(), Version.class);
            if (version != null && version.getProductclass().equalsIgnoreCase(registerVersion.classname)) {
                if (!TextUtils.isEmpty(flight_control) && !flight_control.equals("0.0.0") && version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL) && (version.getLocalPath() == null || hasNewVersion(version.getVersion(), flight_control))) {
                    return true;
                }
                if (!TextUtils.isEmpty(camera) && !camera.equals("0.0.0") && ((version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA) || version.getClassname().equalsIgnoreCase(CameraConfig.ATOM_SP)) && (version.getLocalPath() == null || hasNewVersion(version.getVersion(), camera)))) {
                    return true;
                }
                if (!TextUtils.isEmpty(gimbal) && !gimbal.equals("0.0.0") && version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL) && (version.getLocalPath() == null || hasNewVersion(version.getVersion(), gimbal))) {
                    return true;
                }
                if (!TextUtils.isEmpty(biography) && !biography.equals("0.0.0") && version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV) && (version.getLocalPath() == null || hasNewVersion(version.getVersion(), biography))) {
                    return true;
                }
                if (!TextUtils.isEmpty(remote_control) && !remote_control.equals("0.0.0") && version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_RC) && (version.getLocalPath() == null || hasNewVersion(version.getVersion(), remote_control))) {
                    return true;
                }
                if (!TextUtils.isEmpty(battery) && !battery.equals("0.0.0") && version.getVersion().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_BATTERY) && (version.getLocalPath() == null || hasNewVersion(version.getVersion(), battery))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasNewVersion(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String[] split = str.replace("V", "").replace("v", "").split("\\.");
                String[] split2 = str2.replace("V", "").replace("v", "").split("\\.");
                for (int i = 0; i < split2.length && Integer.parseInt(split[i]) <= Integer.parseInt(split2[i]); i++) {
                    if (Integer.parseInt(split[i]) < Integer.parseInt(split2[i])) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean isSmallPackageFlightModel() {
        return (!FlightConfig.isConnectFlight() || FlightConfig.curFlight == Flight.Flight_ATOM || FlightConfig.curFlight == Flight.Flight_ATOM_SE_V2 || FlightConfig.curFlight == Flight.Flight_ATOM_SE_V3) ? false : true;
    }
}
