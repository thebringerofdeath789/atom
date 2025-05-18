package com.baidu.android.bbalbs.common.security;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.baidu.android.bbalbs.common.security.b */
/* loaded from: classes.dex */
public final class C0597b {
    /* renamed from: a */
    public static String m28a(byte[] bArr, String str, boolean z) {
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

    /* renamed from: a */
    public static String m29a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return m28a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}