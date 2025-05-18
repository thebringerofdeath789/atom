package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.logan.flight.FlightConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public class SendSecurityTipsData extends BaseUserSendData {
    public SendSecurityTipsData init(Token token, String str) {
        if (token != null) {
            this.jsonObject.clear();
            this.jsonObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(token.getId()));
            this.jsonObject.put("token", (Object) getBase64String(token.getToken()));
            this.jsonObject.put("brandcode", (Object) 2);
            this.jsonObject.put("product_class", (Object) (FlightConfig.getLastProductClass() + ""));
            this.jsonObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, (Object) str);
        }
        return this;
    }
}