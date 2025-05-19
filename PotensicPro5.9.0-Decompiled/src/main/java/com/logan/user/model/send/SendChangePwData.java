package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;

/* loaded from: classes3.dex */
public class SendChangePwData extends BaseUserSendData {
    private String newpassword;
    private String oldpassword;
    private String token;

    public SendChangePwData init(Token token, String str, String str2) {
        this.oldpassword = str;
        this.newpassword = str2;
        this.token = token.getToken();
        this.jsonObject.clear();
        put(TtmlNode.ATTR_ID, Integer.valueOf(token.getId()));
        put("oldpassword", getBase64String(str));
        put("newpassword", getBase64String(str2));
        put("token", getBase64String(this.token));
        return this;
    }

    public String getOldpassword() {
        return this.oldpassword;
    }

    public void setOldpassword(String str) {
        this.oldpassword = str;
    }

    public String getNewpassword() {
        return this.newpassword;
    }

    public void setNewpassword(String str) {
        this.newpassword = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
