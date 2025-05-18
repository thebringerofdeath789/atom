package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* compiled from: RSAUtil.java */
/* renamed from: com.baidu.lbsapi.auth.q */
/* loaded from: classes.dex */
public final class C0636q {

    /* renamed from: a */
    private static KeyPair f256a;

    /* renamed from: a */
    public static KeyPair m218a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (f256a == null) {
                f256a = keyPairGenerator.generateKeyPair();
            }
            return f256a;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m219b() {
        PublicKey publicKey;
        KeyPair keyPair = f256a;
        if (keyPair == null || (publicKey = keyPair.getPublic()) == null) {
            return null;
        }
        try {
            return C0622c.m180a(publicKey.getEncoded(), StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m217a(String str) {
        if (!TextUtils.isEmpty(str) && f256a != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, f256a.getPrivate());
                return C0622c.m180a(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8.name());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static byte[] m220b(String str) {
        if (!TextUtils.isEmpty(str) && f256a != null) {
            try {
                byte[] m181a = C0622c.m181a(str.getBytes(StandardCharsets.UTF_8));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, f256a.getPrivate());
                return cipher.doFinal(m181a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}