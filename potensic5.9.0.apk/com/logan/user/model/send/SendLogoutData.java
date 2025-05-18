package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;

/* loaded from: classes3.dex */
public class SendLogoutData extends BaseUserSendData {
    public SendLogoutData init(Token token) {
        this.jsonObject.clear();
        put(TtmlNode.ATTR_ID, Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        return this;
    }
}