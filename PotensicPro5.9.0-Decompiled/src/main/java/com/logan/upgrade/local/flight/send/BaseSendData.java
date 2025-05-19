package com.logan.upgrade.local.flight.send;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.JniUtils;
import com.logan.upgrade.local.flight.UpgradeManager;

/* loaded from: classes3.dex */
public abstract class BaseSendData {
    private static final byte UPGRADE_HEAD = 2;
    private byte[] finalData;

    protected abstract byte[] getDataLength();

    protected abstract byte getRequestCode();

    protected void setData(byte... bArr) {
        int byteArrayToInt = ParseUtil.byteArrayToInt(getDataLength());
        byte[] bArr2 = new byte[byteArrayToInt + 8];
        this.finalData = bArr2;
        bArr2[0] = 2;
        bArr2[1] = 3;
        bArr2[2] = UpgradeManager.getInstance().getUpgradeType();
        this.finalData[3] = getRequestCode();
        this.finalData[4] = getDataLength()[0];
        this.finalData[5] = getDataLength()[1];
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.finalData, 6, byteArrayToInt);
        }
        byte[] bArr3 = this.finalData;
        byte[] short2ByteArr = ParseUtil.short2ByteArr(JniUtils.getCheckCode(bArr3, 1, bArr3.length - 2));
        byte[] bArr4 = this.finalData;
        System.arraycopy(short2ByteArr, 0, bArr4, bArr4.length - 2, short2ByteArr.length);
    }

    public byte[] getBytes() {
        return this.finalData;
    }

    public String toString() {
        return getClass().getSimpleName() + " : data长度 : " + this.finalData.length + ",data内容 : " + ParseUtil.byteToHexString(this.finalData);
    }
}
