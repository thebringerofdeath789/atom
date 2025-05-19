package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* compiled from: RSAUtil.java */
/* loaded from: classes.dex */
public final class q {
    private static KeyPair a;

    public static KeyPair a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (a == null) {
                a = keyPairGenerator.generateKeyPair();
            }
            return a;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        PublicKey publicKey;
        KeyPair keyPair = a;
        if (keyPair == null || (publicKey = keyPair.getPublic()) == null) {
            return null;
        }
        try {
            return c.a(publicKey.getEncoded(), StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && a != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, a.getPrivate());
                return c.a(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8.name());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] b(String str) {
        if (!TextUtils.isEmpty(str) && a != null) {
            try {
                byte[] a2 = c.a(str.getBytes(StandardCharsets.UTF_8));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, a.getPrivate());
                return cipher.doFinal(a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
