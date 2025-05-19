package com.logan.usb.utils;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.netty.ParseUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public final class Md5Util {
    public static String md5Decode32(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(SessionDescription.SUPPORTED_SDP_VERSION);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("NoSuchAlgorithmException", e2);
        }
    }

    public static String md5Decode16(String str) {
        return md5Decode32(str).substring(8, 24);
    }

    public static byte[] getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return ParseUtil.byteToHexString(messageDigest.digest()).getBytes();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getFile(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return ParseUtil.byteToHexString(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] strArr) {
        try {
            System.out.println(new String(getFileMD5(new File("E:\\迅雷下载\\P1-PRO-FC-V2.3.22-20211216-Beta-update.bin")), "utf-8"));
        } catch (Exception unused) {
        }
    }
}
