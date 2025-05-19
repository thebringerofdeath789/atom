package com.logan.user.model.send;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.flight.FlightConfig;

/* loaded from: classes3.dex */
public class SendVersionData extends BaseUserSendData {
    public SendVersionData init(Token token) {
        this.jsonObject.clear();
        put(TtmlNode.ATTR_ID, Integer.valueOf(token.getId()));
        put("token", getBase64String(token.getToken()));
        put("brandcode", 2);
        put("appver", CommonUtil.getAppVersion() + "");
        put("appname", CommonUtil.getAppName() + "");
        put("clienttype", 1);
        put("language_type", LanguageHelper.getPhoneLanguageType() + "");
        put("product_class", FlightConfig.getLastProductClass() + "");
        put("fc_sn", SPHelper.getInstance().getFlightControllerSN());
        return this;
    }
}
