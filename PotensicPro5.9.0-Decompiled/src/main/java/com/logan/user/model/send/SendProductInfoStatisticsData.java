package com.logan.user.model.send;

import android.os.Build;
import android.text.TextUtils;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.flight.FlightConfig;
import com.logan.user.model.UserConstants;

/* loaded from: classes3.dex */
public class SendProductInfoStatisticsData extends BaseUserSendData {
    public SendProductInfoStatisticsData init(Token token, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8) {
        this.jsonObject.clear();
        put("uid", Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        put("brandcode", 2);
        put("product_class", str);
        put(UserConstants.FC_VER, str3);
        put("brand", Build.MODEL);
        put("devicever", Build.VERSION.RELEASE);
        put("appver", CommonUtil.getAppVersion());
        put("appname", CommonUtil.getAppName());
        put(UserConstants.REMOTECTROL_VER, str4);
        put("remotectrol_sn", str5);
        put("fc_sn", str6);
        put("location", Integer.valueOf(i));
        put("state", 0);
        if (!TextUtils.isEmpty(SPHelper.getInstance().getGimbalCurVersion()) && !"0.0.0".equals(SPHelper.getInstance().getGimbalCurVersion()) && !FlightConfig.isAtomLT() && !FlightConfig.is_Atom_SE_Series()) {
            put(UserConstants.GIMBAL_VER, SPHelper.getInstance().getGimbalCurVersion());
        }
        if (!TextUtils.isEmpty(SPHelper.getInstance().getEscCurVersion()) && !"0.0.0".equals(SPHelper.getInstance().getEscCurVersion()) && !FlightConfig.isAtomLT() && !FlightConfig.is_Atom_SE_Series()) {
            put("esc_ver", SPHelper.getInstance().getEscCurVersion());
        }
        put(UserConstants.BIOGRAPHY_VER, SPHelper.getInstance().getFpvCurVersion());
        put(UserConstants.CAMERA_VER, SPHelper.getInstance().getBigPackageCameraVersion());
        put(UserConstants.BATTERY_VER, SPHelper.getInstance().getBatteryCurVersion());
        put(UserConstants.LARGEPACKAGE_VER, str2);
        put("clienttype", 1);
        if (!TextUtils.isEmpty(str7)) {
            put("update_filed", str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            put("error_code", str8);
        }
        return this;
    }
}
