package io.netty.handler.codec.redis;

import com.logan.usb.UsbCameraHandler;

/* loaded from: classes3.dex */
public enum RedisMessageType {
    SIMPLE_STRING((byte) 43, true),
    ERROR(UsbCameraHandler.MSG_ID_SET_TARGET, true),
    INTEGER((byte) 58, true),
    BULK_STRING((byte) 36, false),
    ARRAY_HEADER((byte) 42, false),
    ARRAY((byte) 42, false);

    private final boolean inline;
    private final byte value;

    RedisMessageType(byte b, boolean z) {
        this.value = b;
        this.inline = z;
    }

    public byte value() {
        return this.value;
    }

    public boolean isInline() {
        return this.inline;
    }

    public static RedisMessageType valueOf(byte b) {
        if (b == 36) {
            return BULK_STRING;
        }
        if (b == 45) {
            return ERROR;
        }
        if (b == 58) {
            return INTEGER;
        }
        if (b == 42) {
            return ARRAY_HEADER;
        }
        if (b == 43) {
            return SIMPLE_STRING;
        }
        throw new RedisCodecException("Unknown RedisMessageType: " + ((int) b));
    }
}
