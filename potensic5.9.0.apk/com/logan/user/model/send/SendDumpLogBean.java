package com.logan.user.model.send;

import com.logan.uom.UomConfig;
import com.logan.usb.utils.Md5Util;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SendDumpLogBean implements Serializable {
    private String logmd5;
    private int brandcode = 1;
    private String logclass = UomConfig.HTTP_HEAD_PLATFORM;
    private String appname = UomConfig.HTTP_HEAD_PLATFORM;
    private String appver = "V6.9.0";

    public SendDumpLogBean(String str) {
        this.logmd5 = Md5Util.getFile(new File(str));
    }

    public HashMap<String, String> getMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("brandcode", this.brandcode + "");
        hashMap.put("logmd5", this.logmd5);
        hashMap.put("logclass", this.logclass);
        hashMap.put("appver", this.appver);
        hashMap.put("appname", this.appname);
        return hashMap;
    }
}