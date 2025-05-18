package com.logan.uom.utils;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

/* loaded from: classes3.dex */
public class SM3Util {
    private static final String ENCODING = "UTF-8";

    public static String encrypt(String str, String str2) throws Exception {
        return ByteUtils.toHexString(getEncryptByKey(str, str2));
    }

    public static byte[] getEncryptByKey(String str, String str2) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        KeyParameter keyParameter = new KeyParameter(str2.getBytes("UTF-8"));
        HMac hMac = new HMac(new SM3Digest());
        hMac.init(keyParameter);
        hMac.update(bytes, 0, bytes.length);
        byte[] bArr = new byte[hMac.getMacSize()];
        hMac.doFinal(bArr, 0);
        return bArr;
    }
}