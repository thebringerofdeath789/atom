package com.logan.user.model.send;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.geofence.GeoFence;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.LanguageHelper;

/* loaded from: classes3.dex */
public class SendRegisterData extends BaseUserSendData {
    public SendRegisterData init(String str, String str2, String str3, String str4) {
        this.jsonObject.clear();
        put(NotificationCompat.CATEGORY_EMAIL, str);
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
        put("language_type", Integer.valueOf(LanguageHelper.getPhoneLanguageType()));
        return this;
    }
}
