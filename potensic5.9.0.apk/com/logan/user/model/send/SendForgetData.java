package com.logan.user.model.send;

import androidx.core.app.NotificationCompat;

/* loaded from: classes3.dex */
public class SendForgetData extends BaseUserSendData {
    public SendForgetData init(String str) {
        this.jsonObject.clear();
        put(NotificationCompat.CATEGORY_EMAIL, str);
        put("brandcode", 2);
        return this;
    }
}