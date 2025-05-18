package com.ipotensic.baselib.utils.aes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class AESUtils {
    private static final String AES = "AES";
    private static final String ECB_PKCS7_PADDING = "AES/ECB/PKCS7Padding";
    private static final String SECRET_KEY = "D2o4XyQ@#Fob!4tS";

    public static String encrypt(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("utf-8"), AES);
            Cipher cipher = Cipher.getInstance(ECB_PKCS7_PADDING);
            cipher.init(1, secretKeySpec);
            return Base64Encoder.encode(cipher.doFinal(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String str) {
        try {
            byte[] decodeToBytes = Base64Decoder.decodeToBytes(str);
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("utf-8"), AES);
            Cipher cipher = Cipher.getInstance(ECB_PKCS7_PADDING);
            cipher.init(2, secretKeySpec);
            try {
                return new String(cipher.doFinal(decodeToBytes));
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}