package com.logan.user.model.send;

import android.os.Build;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;

/* loaded from: classes3.dex */
public class SendEvaluatingData extends BaseUserSendData {
    public SendEvaluatingData init(Token token, String str) {
        this.jsonObject.clear();
        put(TtmlNode.ATTR_ID, Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        put("evaluating", str);
        put("brand", Build.MODEL);
        put("devicever", Build.VERSION.RELEASE);
        put("appver", CommonUtil.getAppVersion());
        put("vercontrol", 1);
        return this;
    }
}
