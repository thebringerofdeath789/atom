package com.baidu.geofence.a;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a {
    private static String a(String str) {
        String str2 = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append(SessionDescription.SUPPORTED_SDP_VERSION);
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            str2 = stringBuffer.toString();
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String a(HashMap<String, String> hashMap, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(b(hashMap, str));
        return a(stringBuffer.toString() + "99754106633f94d350db34d548d6091a");
    }

    private static String b(HashMap<String, String> hashMap, String str) {
        Iterator<String> it = hashMap.keySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Collections.sort(arrayList);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < arrayList.size()) {
            String str2 = (String) arrayList.get(i);
            stringBuffer.append(str2);
            stringBuffer.append("=");
            String str3 = null;
            if (str == null) {
                try {
                    str3 = URLEncoder.encode(hashMap.get(str2), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
            } else {
                str3 = URLEncoder.encode(hashMap.get(str2), "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%7E", "~");
            }
            stringBuffer.append(str3);
            i++;
            if (i < arrayList.size() && str != null) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }
}
