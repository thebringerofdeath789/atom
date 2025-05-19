package com.baidu.lbsapi.auth;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Util.java */
/* loaded from: classes.dex */
public final class p {
    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append(SessionDescription.SUPPORTED_SDP_VERSION);
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}
