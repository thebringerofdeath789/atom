package com.logan.user.model.send;

import android.text.TextUtils;
import com.baidu.geofence.GeoFence;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.share2.FileUtil;
import com.logan.usb.utils.Md5Util;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class SendFpvFcLogsData extends BaseUserSendData {
    private HashMap<String, String> mapParams = new HashMap<>();

    public SendFpvFcLogsData init(Token token, String[] strArr, String str, String str2) {
        this.mapParams.clear();
        this.mapParams.put(TtmlNode.ATTR_ID, "" + token.getId());
        this.mapParams.put("token", getBase64String(token.getToken()));
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str3 = null;
        for (int i = 0; i < strArr.length; i++) {
            File file = new File(strArr[i]);
            if (file.exists()) {
                String fileNameNoEx = FileUtil.getFileNameNoEx(file.getName());
                try {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getFlightTypeByFileName(fileNameNoEx);
                    }
                } catch (Exception unused) {
                }
                sb.append("\"" + fileNameNoEx + "\":\"" + (Md5Util.getFile(file) + "") + "\"");
                if (i != strArr.length - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        this.mapParams.put("logmd5", sb.toString() + "");
        this.mapParams.put("logclass", str3 + "");
        this.mapParams.put("brandcode", GeoFence.BUNDLE_KEY_CUSTOMID);
        return this;
    }

    public HashMap<String, String> getMapParams() {
        return this.mapParams;
    }

    private String getFlightTypeByFileName(String str) {
        int i = 0;
        if (str.contains("(") && str.contains(")")) {
            str = str.substring(0, str.indexOf("(")) + str.substring(str.indexOf(")") + 2);
        }
        String[] split = str.split("-");
        int i2 = 0;
        while (true) {
            if (i2 >= split.length) {
                i2 = 0;
                break;
            }
            try {
                Long.parseLong(split[i2]);
                break;
            } catch (Exception unused) {
                i2++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            while (i < split.length) {
                if (i != 0 && i != split.length - 1) {
                    sb.append(split[i]);
                    if (i != split.length - 2) {
                        sb.append("-");
                    }
                }
                i++;
            }
            return sb.toString();
        }
        while (i < split.length && i != i2) {
            sb.append(split[i]);
            i++;
        }
        return sb.toString();
    }
}