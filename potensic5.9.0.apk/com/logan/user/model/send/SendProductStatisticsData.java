package com.logan.user.model.send;

import android.os.Build;
import android.text.TextUtils;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.flight.FlightConfig;
import com.logan.flight.type.Flight;
import com.logan.user.model.UserConstants;

/* loaded from: classes3.dex */
public class SendProductStatisticsData extends BaseUserSendData {
    public SendProductStatisticsData init(Token token, String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this.jsonObject.clear();
        put("uid", Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        put("brandcode", 2);
        put("product_class", str);
        put(UserConstants.FC_VER, str2);
        put("brand", Build.MODEL);
        put("devicever", Build.VERSION.RELEASE);
        put("appver", CommonUtil.getAppVersion());
        put("appname", CommonUtil.getAppName());
        put(UserConstants.REMOTECTROL_VER, str3);
        put("remotectrol_sn", str4);
        put("fc_sn", str5);
        put("location", Integer.valueOf(i));
        put("state", 0);
        if (!TextUtils.isEmpty(SPHelper.getInstance().getGimbalCurVersion()) && !"0.0.0".equals(SPHelper.getInstance().getGimbalCurVersion()) && !FlightConfig.isAtomLT() && !FlightConfig.is_Atom_SE_Series()) {
            put(UserConstants.GIMBAL_VER, SPHelper.getInstance().getGimbalCurVersion());
        }
        put(UserConstants.BIOGRAPHY_VER, SPHelper.getInstance().getFpvCurVersion());
        put(UserConstants.CAMERA_VER, SPHelper.getInstance().getCameraCurVersion());
        put("camera_class", SPHelper.getInstance().getCameraClass());
        put(UserConstants.BATTERY_VER, SPHelper.getInstance().getBatteryCurVersion());
        if (z) {
            put(UserConstants.LARGEPACKAGE_VER, SPHelper.getInstance().getBigPackageVersion());
        }
        put("clienttype", 1);
        int i2 = Flight.Flight_P1_PRO_2 == FlightConfig.getLastFlight() ? 1 : 0;
        put("fc_ver_die", Integer.valueOf(i2));
        put("remotectrol_ver_die", Integer.valueOf(i2));
        put("gimbal_ver_die", Integer.valueOf(i2));
        return this;
    }
}