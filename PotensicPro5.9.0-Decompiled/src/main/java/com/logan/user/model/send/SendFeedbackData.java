package com.logan.user.model.send;

import android.os.Build;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;
import com.logan.flight.FlightConfig;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SendFeedbackData extends BaseUserSendData {
    private HashMap<String, String> mapParams = new HashMap<>();

    public SendFeedbackData init(Token token, String str, int i, int i2, String str2) {
        this.mapParams.clear();
        this.mapParams.put(TtmlNode.ATTR_ID, "" + token.getId());
        this.mapParams.put("token", getBase64String(token.getToken()));
        this.mapParams.put("content", str);
        this.mapParams.put("brand", Build.MODEL);
        this.mapParams.put("devicever", Build.VERSION.RELEASE);
        this.mapParams.put("appver", CommonUtil.getAppVersion());
        this.mapParams.put("product_class", FlightConfig.getLastProductClass() + "");
        this.mapParams.put("fid", i + "");
        this.mapParams.put("video_pos", i2 + "");
        return this;
    }

    public HashMap<String, String> getMapParams() {
        return this.mapParams;
    }
}
