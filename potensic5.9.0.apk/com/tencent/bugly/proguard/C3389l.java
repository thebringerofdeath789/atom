package com.tencent.bugly.proguard;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.usb.UsbCameraHandler;
import java.nio.ByteBuffer;
import org.apache.poi.hssf.record.PaletteRecord;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.l */
/* loaded from: classes3.dex */
public final class C3389l {
    /* renamed from: a */
    public static boolean m2160a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m2161a(long j, long j2) {
        return j == j2;
    }

    /* renamed from: a */
    public static boolean m2163a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static boolean m2162a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static byte[] m2164a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }

    static {
        byte[] bArr = {48, 49, 50, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 65, 66, 67, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
    }
}