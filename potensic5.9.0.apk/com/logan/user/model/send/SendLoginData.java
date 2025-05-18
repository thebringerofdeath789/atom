package com.logan.user.model.send;

import androidx.core.app.NotificationCompat;
import com.baidu.geofence.GeoFence;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes3.dex */
public class SendLoginData extends BaseUserSendData {
    public SendLoginData init(String str, String str2) {
        this.jsonObject.clear();
        put(NotificationCompat.CATEGORY_EMAIL, str);
        put("password", getBase64String(str2));
        put("brandcode", GeoFence.BUNDLE_KEY_CUSTOMID);
        DDLog.m1687i("jsonobject:" + this.jsonObject.toJSONString());
        return this;
    }
}