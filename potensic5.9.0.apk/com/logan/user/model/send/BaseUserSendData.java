package com.logan.user.model.send;

import android.util.Base64;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseUserSendData {
    protected String finalJson;
    protected JSONObject jsonObject = new JSONObject();

    protected void put(String str, Object obj) {
        this.jsonObject.put(str, obj);
    }

    protected String getBase64String(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public String getJsonString() {
        String jSONObject = this.jsonObject.toString();
        this.finalJson = jSONObject;
        return jSONObject;
    }
}