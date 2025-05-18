package com.logan.user.model.send;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.geofence.GeoFence;
import com.ipotensic.baselib.utils.CommonUtil;

/* loaded from: classes3.dex */
public class SendRegisterData2 extends BaseUserSendData {
    public SendRegisterData2 init(String str, String str2, String str3, String str4, String str5) {
        this.jsonObject.clear();
        put(NotificationCompat.CATEGORY_EMAIL, str + "");
        put("password", getBase64String(str2));
        put("nicname", "");
        put("location", str3);
        put("userdevice", "");
        put("brandcode", GeoFence.BUNDLE_KEY_CUSTOMID);
        put("countryname", str4);
        put("appversion", "");
        put("devicetoken", "");
        put("appname", "");
        put("brand", Build.MODEL);
        put("devicever", Build.VERSION.RELEASE);
        put("appver", CommonUtil.getAppVersion());
        put("pin", str5);
        return this;
    }
}