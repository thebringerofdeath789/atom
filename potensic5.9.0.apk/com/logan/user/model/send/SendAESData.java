package com.logan.user.model.send;

/* loaded from: classes3.dex */
public class SendAESData extends BaseUserSendData {
    public SendAESData init(String str) {
        this.jsonObject.clear();
        put("data", str);
        return this;
    }
}