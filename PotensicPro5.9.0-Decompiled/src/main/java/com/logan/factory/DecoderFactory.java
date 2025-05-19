package com.logan.factory;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.h264.H264DecodeThread;
import com.logan.h264.H264DecodeThread1;
import com.logan.h264.IDecoder;

/* loaded from: classes2.dex */
public class DecoderFactory {
    public static IDecoder newDecoder(byte b) {
        if (b == UsbConfig.USB_TYPE_LIVE_VIEW) {
            return new H264DecodeThread();
        }
        if (b == UsbConfig.USB_TYPE_LIVE_VIEW_NEW) {
            return new H264DecodeThread1();
        }
        return null;
    }
}
