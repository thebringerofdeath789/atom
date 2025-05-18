package com.logan.user.model.send;

import com.baidu.geofence.GeoFence;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.logan.flight.FlightConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public class SendGetPdfData extends BaseUserSendData {
    public SendGetPdfData init(Token token, String str) {
        this.jsonObject.clear();
        put(TtmlNode.ATTR_ID, Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        put("userdevice", 1);
        put("brandcode", GeoFence.BUNDLE_KEY_CUSTOMID);
        put("model", FlightConfig.getLastFlightModel() + "");
        put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str);
        return this;
    }
}