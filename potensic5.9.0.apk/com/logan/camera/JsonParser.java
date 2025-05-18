package com.logan.camera;

import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.potensicpro.utils.PhotoChooserUtil;
import com.logan.camera.data.CameraInfoData;
import com.logan.camera.data.CameraTimeData;
import com.logan.camera.data.CheckUpgradeData;
import com.logan.camera.data.DeviceInfoData;
import com.logan.camera.data.FileInfoData;
import com.logan.camera.data.FileListData;
import com.logan.camera.data.FileNumData;
import com.logan.camera.data.FormatSdCardData;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.data.SizeData;
import com.logan.camera.data.StartUpgradeData;
import com.logan.camera.data.StatusData;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.data.UsbFileLenData;
import com.logan.camera.data.ValueData;
import com.logan.camera.data.WifiSignalData;
import com.logan.upgrade.big.UpgradeHandshakeState;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.lookup.StringLookupFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public class JsonParser {
    public static StatusData parseStatusData(String str) throws Exception {
        String string = JSONObject.parseObject(str).getString(NotificationCompat.CATEGORY_STATUS);
        if (string == null) {
            return null;
        }
        return new StatusData(string);
    }

    public static CameraInfoData parseCameraInfo(String str) throws Exception {
        JSONObject parseObject = JSONObject.parseObject(str);
        String string = parseObject.getString("workmode");
        boolean booleanValue = parseObject.getBoolean("running").booleanValue();
        int intValue = parseObject.getIntValue("recordtime");
        if (string == null) {
            return null;
        }
        return new CameraInfoData(string, booleanValue, intValue);
    }

    public static DeviceInfoData parseDeviceInfo(String str) {
        JSONObject parseObject = JSONObject.parseObject(str);
        String string = parseObject.getString("model");
        String string2 = parseObject.getString("softversion");
        if (string == null || string2 == null) {
            return null;
        }
        return new DeviceInfoData(string, string2);
    }

    public static CameraTimeData parseCameraTime(String str) {
        String string = JSONObject.parseObject(str).getString(RtspHeaders.Values.TIME);
        if (string == null) {
            return null;
        }
        return new CameraTimeData(string);
    }

    public static ValueData parseValue(String str) {
        String string = JSONObject.parseObject(str).getString("value");
        if (string == null) {
            return null;
        }
        return new ValueData(string);
    }

    public static WifiSignalData parseWifi(String str) {
        int i;
        JSONObject parseObject = JSONObject.parseObject(str);
        int intValue = parseObject.getIntValue("value");
        try {
            i = parseObject.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE).intValue();
        } catch (Exception unused) {
            i = 0;
        }
        return new WifiSignalData(intValue, i);
    }

    public static SizeData parseSize(String str) {
        JSONArray jSONArray = JSONObject.parseObject(str).getJSONArray("capability");
        List javaList = jSONArray.toJavaList(String.class);
        if (jSONArray.size() <= 0 || javaList == null || javaList.size() <= 0) {
            return null;
        }
        return new SizeData(javaList);
    }

    public static FormatSdCardData parseFormatSdCard(String str) {
        DDLog.m1684e("相机 parseFormatSdCard:" + str);
        JSONObject parseObject = JSONObject.parseObject(str);
        String string = parseObject.getString("sdstatus");
        String string2 = parseObject.getString("sdfreespace");
        String string3 = parseObject.getString("sdtotalspace");
        String string4 = parseObject.getString("partitionnum");
        if (string == null || string2 == null || string3 == null || string4 == null) {
            return null;
        }
        return new FormatSdCardData(Integer.parseInt(string), Long.parseLong(string2), Long.parseLong(string3), Integer.parseInt(string4));
    }

    public static FileNumData parseFileNum(String str) throws Exception {
        JSONObject parseObject = JSONObject.parseObject(str);
        return new FileNumData(parseObject.getIntValue("count"), parseObject.getIntValue("video"), parseObject.getIntValue(PhotoChooserUtil.PHOTO));
    }

    public static FileListData parseFileList(String str) {
        return new FileListData(JSONObject.parseObject(str).getJSONArray(StringLookupFactory.KEY_FILE).toJavaList(String.class));
    }

    public static FileInfoData parseFileInfo(String str) throws Exception {
        JSONObject parseObject = JSONObject.parseObject(str);
        return new FileInfoData(parseObject.getLongValue("size"), parseObject.getString("path"), parseObject.getLongValue(RtspHeaders.Values.TIME), parseObject.getString("create"));
    }

    public static CheckUpgradeData parseCheckUpgrade(String str) throws Exception {
        return new CheckUpgradeData(JSONObject.parseObject(str).getIntValue("Result"));
    }

    public static StartUpgradeData parseStartUpgrade(String str) throws Exception {
        return new StartUpgradeData(JSONObject.parseObject(str).getIntValue("Result"));
    }

    public static MediaInfoData parseMediaInfo(String str) throws Exception {
        return (MediaInfoData) JSON.parseObject(str, MediaInfoData.class);
    }

    public static List<UsbFileLenData> getUsbFileLenList(String str) throws Exception {
        List javaList = JSONObject.parseObject(str).getJSONArray("file_info").toJavaList(String.class);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < javaList.size(); i++) {
            arrayList.add((UsbFileLenData) JSON.parseObject((String) javaList.get(i), UsbFileLenData.class));
        }
        return arrayList;
    }

    public static CameraConfig parseConfigMenu(String str) throws Exception {
        DDLog.m1684e("相机configmenu:" + str);
        JSONObject parseObject = JSONObject.parseObject(str);
        JSONObject parseObject2 = JSONObject.parseObject(parseObject.getString("cameravision"));
        String string = parseObject2.getString("model");
        String string2 = parseObject2.getString("softversion");
        CameraConfig.get().setCameraModel(string);
        CameraConfig.get().setSoftVersion(string2);
        String string3 = parseObject.getString("rec_res");
        String string4 = parseObject.getString("pho_res");
        String string5 = parseObject.getString("split_cur");
        CameraConfig.get().supportVideoSizes.setCurrentValue(string3);
        CameraConfig.get().supportPhotoSizes.setCurrentValue(string4);
        CameraConfig.get().supportSplitSizes.setCurrentValue(string5);
        try {
            CameraConfig.get().supportVideoSizes.setSupportListForWIFI(new SizeData(parseObject.getJSONArray("rec_all").toJavaList(String.class)));
            CameraConfig.get().supportPhotoSizes.setSupportListForWIFI(new SizeData(parseObject.getJSONArray("pho_all").toJavaList(String.class)));
            CameraConfig.get().supportSplitSizes.setSupportListForWIFI(new SizeData(parseObject.getJSONArray("split_all").toJavaList(String.class)));
        } catch (Exception unused) {
        }
        CameraConfig.get().setCaptureMode(parseObject.getString("workmode"));
        try {
            CameraConfig.get().setPhotoEV(parseObject.getDouble("photo_ev").doubleValue());
            CameraConfig.get().setRecordEV(parseObject.getDouble("record_ev").doubleValue());
        } catch (Exception unused2) {
        }
        JSONObject parseObject3 = JSONObject.parseObject(parseObject.getString("card_info"));
        int intValue = parseObject3.getIntValue("sdstatus");
        long longValue = parseObject3.getLong("sdfreespace").longValue();
        long longValue2 = parseObject3.getLong("sdtotalspace").longValue();
        CameraConfig.get().setSdState(intValue);
        CameraConfig.get().setSdFreeSpace(longValue);
        CameraConfig.get().setSdTotalSpace(longValue2);
        CameraConfig.get().isGetConfigMenu = true;
        return CameraConfig.get();
    }

    public static TrackTarget parseTargetTrack(String str) {
        try {
            return (TrackTarget) JSON.parseObject(str, TrackTarget.class);
        } catch (Exception e) {
            DDLog.m1684e("解析目标跟踪出错 ：" + e.getMessage());
            return null;
        }
    }

    public static Boolean parseUpgradeHandshakeState(String str) {
        try {
            int all = ((UpgradeHandshakeState) new Gson().fromJson(str, UpgradeHandshakeState.class)).getAll();
            DDLog.m1684e("parseUpgradeHandshakeState result: " + all);
            boolean z = true;
            SPHelper.getInstance().setUpgradeHandshakePass(all == 1);
            if (all != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            DDLog.m1684e("parseUpgradeHandshakeState error: " + e.getMessage());
            return false;
        }
    }
}