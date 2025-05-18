package com.logan.user.model.send;

import android.os.Build;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;

/* loaded from: classes3.dex */
public class SendUpdateVersionData extends BaseUserSendData {
    public SendUpdateVersionData init(Token token, String str, String str2, String str3, String str4, String str5, String str6) {
        this.jsonObject.clear();
        put("uid", Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        put("brandcode", 2);
        put("product_class", str);
        put("fc_sn", str2);
        put("firmware_type", str3);
        put("ver_current", str4);
        put("ver_try", str5);
        put("remotectrol_sn", str6);
        put("brand", Build.MODEL);
        put("devicever", Build.VERSION.RELEASE);
        put("appver", CommonUtil.getAppVersion());
        put("appname", CommonUtil.getAppName());
        put("location", 86);
        put("state", 0);
        put("clienttype", 1);
        return this;
    }
}