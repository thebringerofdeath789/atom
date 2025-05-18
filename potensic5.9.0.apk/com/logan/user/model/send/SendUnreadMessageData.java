package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;

/* loaded from: classes3.dex */
public class SendUnreadMessageData extends BaseUserSendData {
    public SendUnreadMessageData init(Token token) {
        if (token != null) {
            this.jsonObject.clear();
            this.jsonObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(token.getId()));
            this.jsonObject.put("token", (Object) getBase64String(token.getToken()));
            this.jsonObject.put("brandcode", (Object) 2);
        }
        return this;
    }
}