package com.logan.flight;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.usb.parser_new.Frame;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/* loaded from: classes.dex */
public class DataParser {
    private static volatile DataParser instance;
    private final int SIZE = 16384;
    private volatile ByteBuf buffer = Unpooled.buffer(16384);
    private byte[] readData;

    private DataParser() {
    }

    public static DataParser getInstance() {
        if (instance == null) {
            synchronized (DataParser.class) {
                if (instance == null) {
                    DataParser dataParser = new DataParser();
                    instance = dataParser;
                    return dataParser;
                }
            }
        }
        return instance;
    }

    public synchronized void write(byte[] bArr, int i) {
        if (this.buffer.readableBytes() >= 16384) {
            this.buffer.clear();
        }
        this.buffer.writeBytes(bArr, 0, i);
        try {
            startParse();
        } catch (Exception e) {
            DDLog.e("flight socket解析出错:" + e.getMessage());
        }
    }

    public void write(byte[] bArr) {
        if (this.buffer.readableBytes() >= 16384) {
            this.buffer.clear();
        }
        this.buffer.writeBytes(bArr);
        try {
            startParse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private byte[] getWroteBytes() {
        if (this.buffer.writerIndex() <= 0) {
            this.readData = null;
            return null;
        }
        this.readData = new byte[this.buffer.writerIndex()];
        this.buffer.getBytes(0, this.readData);
        return this.readData;
    }

    private synchronized void startParse() throws Exception {
        if (getWroteBytes() != null) {
            int length = this.readData.length;
            int i = -1;
            int i2 = 0;
            while (i2 < length - 5) {
                if (this.readData[i2] == UsbConfig.REV_HEAD[0] && this.readData[i2 + 1] == UsbConfig.REV_HEAD[1]) {
                    int i3 = i2 + 2;
                    int unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(this.readData, i3) + i3;
                    int i4 = unsignedShortFromByteArr + 1;
                    if (i4 > length - 1) {
                        break;
                    }
                    byte checkCode = ParseUtil.getCheckCode(this.readData, i3, unsignedShortFromByteArr);
                    byte[] bArr = this.readData;
                    if (checkCode == bArr[i4]) {
                        int i5 = (unsignedShortFromByteArr - i2) + 2;
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i2, bArr2, 0, i5);
                        Frame frame = new Frame();
                        frame.setMsgId(bArr2[4]);
                        frame.setData(bArr2);
                        frame.setPayloadLen(i5 - 6);
                        DataReceiver.getInstance().onDataParsed(frame);
                        i2 = i4;
                        i = i2;
                    } else {
                        int i6 = (unsignedShortFromByteArr - i2) + 2;
                        System.arraycopy(bArr, i2, new byte[i6], 0, i6);
                    }
                }
                i2++;
            }
            if (i != -1) {
                discardReadIndex(i);
            }
        }
    }

    private void discardReadIndex(int i) {
        this.buffer.readerIndex(i);
        this.buffer.discardReadBytes();
    }

    public void release() {
        this.buffer.clear();
    }
}
