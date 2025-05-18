package com.logan.user.model.send;

import com.baidu.geofence.GeoFence;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.utils.CommonUtil;
import com.logan.flight.FlightConfig;
import com.logan.usb.utils.Md5Util;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SendAppDumpLogData extends BaseUserSendData {
    private HashMap<String, String> mapParams = new HashMap<>();

    public SendAppDumpLogData init(Token token, File file) {
        this.mapParams.clear();
        if (token != null) {
            this.mapParams.put(TtmlNode.ATTR_ID, token.getId() + "");
            this.mapParams.put("token", getBase64String(token.getToken()) + "");
            this.mapParams.put("location", token.getLocation() + "");
        }
        this.mapParams.put("brandcode", GeoFence.BUNDLE_KEY_CUSTOMID);
        this.mapParams.put("logmd5", Md5Util.getFile(file) + "");
        this.mapParams.put("logclass", FlightConfig.getLastProductClass() + "");
        this.mapParams.put("appver", CommonUtil.getAppVersion() + "");
        this.mapParams.put("appname", CommonUtil.getAppName() + "");
        return this;
    }

    public HashMap<String, String> getMapParams() {
        return this.mapParams;
    }
}