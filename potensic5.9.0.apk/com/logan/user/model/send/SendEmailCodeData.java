package com.logan.user.model.send;

import androidx.core.app.NotificationCompat;

/* loaded from: classes3.dex */
public class SendEmailCodeData extends BaseUserSendData {
    public SendEmailCodeData init(String str, int i) {
        this.jsonObject.clear();
        this.jsonObject.put(NotificationCompat.CATEGORY_EMAIL, (Object) str);
        this.jsonObject.put("language_type", (Object) Integer.valueOf(i));
        this.jsonObject.put("brandcode", (Object) 2);
        return this;
    }
}