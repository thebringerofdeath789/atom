package com.baidu.location.p006b;

import android.util.Base64;
import com.baidu.location.Jni;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.baidu.location.b.n */
/* loaded from: classes.dex */
public class C0660n {

    /* renamed from: a */
    private boolean f597a;

    /* renamed from: b */
    private String[] f598b;

    /* renamed from: com.baidu.location.b.n$a */
    private static class a {

        /* renamed from: a */
        private static C0660n f599a = new C0660n();
    }

    private C0660n() {
        this.f597a = false;
        this.f598b = null;
        try {
            String str = Jni.getldkaiv();
            if (str == null || !str.contains("|")) {
                return;
            }
            String[] split = str.split("\\|");
            this.f598b = split;
            if (split == null || split.length != 2) {
                return;
            }
            this.f597a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C0660n m467a() {
        return a.f599a;
    }

    /* renamed from: a */
    public synchronized String m468a(String str) {
        if (this.f597a) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f598b[1].getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(this.f598b[0].getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    public synchronized String m469b(String str) {
        if (!this.f597a) {
            return null;
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f598b[1].getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f598b[0].getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public boolean m470b() {
        return this.f597a;
    }
}