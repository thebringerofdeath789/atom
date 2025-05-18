package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;

/* loaded from: classes3.dex */
public class SendGetFeedbackData extends BaseUserSendData {
    public SendGetFeedbackData init(Token token, int i) {
        if (token != null) {
            this.jsonObject.clear();
            this.jsonObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(token.getId()));
            this.jsonObject.put("token", (Object) getBase64String(token.getToken()));
            this.jsonObject.put("brandcode", (Object) 2);
            this.jsonObject.put("day_count", (Object) Integer.valueOf(i));
        }
        return this;
    }
}