package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SendUploadImgData extends BaseUserSendData {
    private HashMap<String, String> mapParams = new HashMap<>();

    public SendUploadImgData init(Token token, String str) {
        this.mapParams.clear();
        this.mapParams.put(TtmlNode.ATTR_ID, "" + token.getId());
        this.mapParams.put("token", getBase64String(token.getToken()));
        this.mapParams.put("vercontrol", "1");
        if (str != null) {
            this.mapParams.put("nicname", str);
        }
        return this;
    }

    public HashMap<String, String> getMapParams() {
        return this.mapParams;
    }

    public String toString() {
        return "id:" + this.mapParams.get(TtmlNode.ATTR_ID) + ",token:" + this.mapParams.get("token") + ",nicname:" + this.mapParams.get("nicname");
    }
}