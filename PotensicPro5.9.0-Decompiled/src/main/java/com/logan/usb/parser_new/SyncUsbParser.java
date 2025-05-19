package com.logan.usb.parser_new;

import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes3.dex */
public class SyncUsbParser {
    private OnFrameOutputListener frameOutputListener;
    private final int USB_FRAME_HEAD_LEN = 16;
    private final Buffer usbBuffer = new Buffer(204800);
    private final Buffer cameraBuffer = new Buffer(204800);
    private final Buffer flightCtrlBuffer = new Buffer(51200);
    private final Buffer fpvBuffer = new Buffer(51200);
    private final Buffer remoterBuffer = new Buffer(51200);

    public interface OnFrameOutputListener {
        void onFrameOutput(Frame frame);

        void onInitFinished();

        void onLiveView(Frame frame);
    }

    public void release() {
    }

    public void init(OnFrameOutputListener onFrameOutputListener) {
        this.frameOutputListener = onFrameOutputListener;
    }

    public synchronized void parseUsbFrame(UsbBytes usbBytes) throws Exception {
        this.usbBuffer.write(usbBytes.data, usbBytes.len);
        byte[] data = this.usbBuffer.getData();
        int i = 0;
        int i2 = -1;
        while (i < this.usbBuffer.getWriteIndex() - 16) {
            if (isUsbFrameHead(data, i)) {
                int bigIntFromByteArr = ParseUtil.getBigIntFromByteArr(data, i + 12);
                int i3 = i + 16;
                int i4 = (i3 + bigIntFromByteArr) - 1;
                if (i4 <= this.usbBuffer.getWriteIndex()) {
                    Frame frame = new Frame();
                    frame.setFrom(data[i + 7]);
                    frame.setPayloadLen(bigIntFromByteArr);
                    byte[] bArr = new byte[bigIntFromByteArr];
                    System.arraycopy(data, i3, bArr, 0, bigIntFromByteArr);
                    frame.setData(bArr);
                    if (!UsbConfig.isInit) {
                        UsbConfig.initCmdID((byte) frame.getFrom());
                        OnFrameOutputListener onFrameOutputListener = this.frameOutputListener;
                        if (onFrameOutputListener != null) {
                            onFrameOutputListener.onInitFinished();
                        }
                    }
                    parsePacket(frame);
                    i = i4;
                    i2 = i;
                }
            }
            i++;
        }
        if (i2 != -1) {
            this.usbBuffer.discard(i2);
        }
    }

    private void parsePacket(Frame frame) {
        byte from = (byte) frame.getFrom();
        if (from == UsbConfig.USB_TYPE_LIVE_VIEW_NEW || from == UsbConfig.USB_TYPE_LIVE_VIEW) {
            OnFrameOutputListener onFrameOutputListener = this.frameOutputListener;
            if (onFrameOutputListener != null) {
                onFrameOutputListener.onLiveView(frame);
                return;
            }
            return;
        }
        if (from == UsbConfig.USB_TYPE_CAMERA_TO_APP) {
            this.cameraBuffer.write(frame.getData(), frame.getPayloadLen());
            parseBuffer(this.cameraBuffer, from);
            return;
        }
        if (from == UsbConfig.USB_TYPE_FPV_TO_APP) {
            this.fpvBuffer.write(frame.getData(), frame.getPayloadLen());
            parseBuffer(this.fpvBuffer, from);
        } else if (from == UsbConfig.USB_TYPE_REMOTER_TO_APP) {
            this.remoterBuffer.write(frame.getData(), frame.getPayloadLen());
            parseBuffer(this.remoterBuffer, from);
        } else if (from == UsbConfig.USB_TYPE_FLIGHT_TO_APP) {
            this.flightCtrlBuffer.write(frame.getData(), frame.getPayloadLen());
            parseBuffer(this.flightCtrlBuffer, from);
        }
    }

    private void parseBuffer(Buffer buffer, byte b) {
        int i;
        int unsignedShortFromByteArr;
        int unsignedShortFromByteArr2;
        if (buffer.getWriteIndex() > 6) {
            int i2 = -1;
            int i3 = 0;
            while (i3 < buffer.getWriteIndex() - 6) {
                if (isPacketHead(buffer.getData(), i3) && buffer.getWriteIndex() >= (unsignedShortFromByteArr2 = i3 + 3 + (unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(buffer.getData(), (i = i3 + 2)))) && ParseUtil.getCheckCode(buffer.getData(), i, unsignedShortFromByteArr2 - 1) == buffer.getData()[unsignedShortFromByteArr2]) {
                    Frame frame = new Frame();
                    frame.setMsgId(UsbConfig.getMsgId(buffer.getData(), i3));
                    frame.setFrom(b);
                    frame.setPayloadLen(unsignedShortFromByteArr - (UsbConfig.isNewFC ? 3 : 2));
                    int payloadLen = frame.getPayloadLen() + (UsbConfig.isNewFC ? 7 : 6);
                    byte[] bArr = new byte[payloadLen];
                    System.arraycopy(buffer.getData(), i3, bArr, 0, payloadLen);
                    frame.setData(bArr);
                    OnFrameOutputListener onFrameOutputListener = this.frameOutputListener;
                    if (onFrameOutputListener != null) {
                        onFrameOutputListener.onFrameOutput(frame);
                    }
                    i2 = unsignedShortFromByteArr2;
                    i3 = i2;
                }
                i3++;
            }
            if (i2 >= 0) {
                buffer.discard(i2);
            }
        }
    }

    public void resetCameraBuffer() {
        this.cameraBuffer.reset();
    }

    public boolean isUsbFrameHead(byte[] bArr, int i) {
        int i2 = i + 6;
        return bArr.length >= i2 && bArr[i] == -2 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 0 && bArr[i + 4] == 0 && bArr[i + 5] == 0 && bArr[i2] == 0;
    }

    private boolean isPacketHead(byte[] bArr, int i) {
        if (bArr[i] == -1) {
            int i2 = i + 1;
            if (bArr[i2] == -2 || bArr[i2] == -3) {
                return true;
            }
        }
        return false;
    }
}
