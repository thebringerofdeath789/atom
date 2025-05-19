package io.netty.handler.codec.spdy;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import org.apache.poi.hssf.record.PaletteRecord;

/* loaded from: classes3.dex */
final class SpdyCodecUtil {
    static final byte SPDY_DATA_FLAG_FIN = 1;
    static final int SPDY_DATA_FRAME = 0;
    static final byte[] SPDY_DICT = {0, 0, 0, 7, 111, 112, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 115, 0, 0, 0, 4, 104, 101, 97, 100, 0, 0, 0, 4, 112, 111, 115, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 3, 112, 117, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 6, 100, 101, 108, 101, FlightConfig.ATOM_TI_18650_BATTERY, 101, 0, 0, 0, 5, FlightConfig.ATOM_TI_18650_BATTERY, 114, 97, 99, 101, 0, 0, 0, 6, 97, 99, 99, 101, 112, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 14, 97, 99, 99, 101, 112, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 99, 104, 97, 114, 115, 101, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 15, 97, 99, 99, 101, 112, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 15, 97, 99, 99, 101, 112, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 108, 97, 110, 103, 117, 97, 103, 101, 0, 0, 0, 13, 97, 99, 99, 101, 112, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 114, 97, 110, 103, 101, 115, 0, 0, 0, 3, 97, 103, 101, 0, 0, 0, 5, 97, 108, 108, 111, 119, 0, 0, 0, 13, 97, 117, FlightConfig.ATOM_TI_18650_BATTERY, 104, 111, 114, 105, 122, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 0, 0, 0, 13, 99, 97, 99, 104, 101, UsbCameraHandler.MSG_ID_SET_TARGET, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 114, 111, 108, 0, 0, 0, 10, 99, 111, 110, 110, 101, 99, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 0, 0, 0, 12, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 98, 97, 115, 101, 0, 0, 0, 16, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 16, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 108, 97, 110, 103, 117, 97, 103, 101, 0, 0, 0, 14, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 108, 101, 110, 103, FlightConfig.ATOM_TI_18650_BATTERY, 104, 0, 0, 0, 16, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 108, 111, 99, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 0, 0, 0, 11, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 109, 100, 53, 0, 0, 0, 13, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 114, 97, 110, 103, 101, 0, 0, 0, 12, 99, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, FlightConfig.ATOM_TI_18650_BATTERY, 121, 112, 101, 0, 0, 0, 4, 100, 97, FlightConfig.ATOM_TI_18650_BATTERY, 101, 0, 0, 0, 4, 101, FlightConfig.ATOM_TI_18650_BATTERY, 97, 103, 0, 0, 0, 6, 101, 120, 112, 101, 99, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 7, 101, 120, 112, 105, 114, 101, 115, 0, 0, 0, 4, 102, 114, 111, 109, 0, 0, 0, 4, 104, 111, 115, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 8, 105, 102, UsbCameraHandler.MSG_ID_SET_TARGET, 109, 97, FlightConfig.ATOM_TI_18650_BATTERY, 99, 104, 0, 0, 0, 17, 105, 102, UsbCameraHandler.MSG_ID_SET_TARGET, 109, 111, 100, 105, 102, 105, 101, 100, UsbCameraHandler.MSG_ID_SET_TARGET, 115, 105, 110, 99, 101, 0, 0, 0, 13, 105, 102, UsbCameraHandler.MSG_ID_SET_TARGET, 110, 111, 110, 101, UsbCameraHandler.MSG_ID_SET_TARGET, 109, 97, FlightConfig.ATOM_TI_18650_BATTERY, 99, 104, 0, 0, 0, 8, 105, 102, UsbCameraHandler.MSG_ID_SET_TARGET, 114, 97, 110, 103, 101, 0, 0, 0, 19, 105, 102, UsbCameraHandler.MSG_ID_SET_TARGET, 117, 110, 109, 111, 100, 105, 102, 105, 101, 100, UsbCameraHandler.MSG_ID_SET_TARGET, 115, 105, 110, 99, 101, 0, 0, 0, 13, 108, 97, 115, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 109, 111, 100, 105, 102, 105, 101, 100, 0, 0, 0, 8, 108, 111, 99, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 0, 0, 0, 12, 109, 97, 120, UsbCameraHandler.MSG_ID_SET_TARGET, 102, 111, 114, 119, 97, 114, 100, 115, 0, 0, 0, 6, 112, 114, 97, 103, 109, 97, 0, 0, 0, 18, 112, 114, 111, 120, 121, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 117, FlightConfig.ATOM_TI_18650_BATTERY, 104, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, 105, 99, 97, FlightConfig.ATOM_TI_18650_BATTERY, 101, 0, 0, 0, 19, 112, 114, 111, 120, 121, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 117, FlightConfig.ATOM_TI_18650_BATTERY, 104, 111, 114, 105, 122, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 0, 0, 0, 5, 114, 97, 110, 103, 101, 0, 0, 0, 7, 114, 101, 102, 101, 114, 101, 114, 0, 0, 0, 11, 114, 101, FlightConfig.ATOM_TI_18650_BATTERY, 114, 121, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 102, FlightConfig.ATOM_TI_18650_BATTERY, 101, 114, 0, 0, 0, 6, 115, 101, 114, 118, 101, 114, 0, 0, 0, 2, FlightConfig.ATOM_TI_18650_BATTERY, 101, 0, 0, 0, 7, FlightConfig.ATOM_TI_18650_BATTERY, 114, 97, 105, 108, 101, 114, 0, 0, 0, 17, FlightConfig.ATOM_TI_18650_BATTERY, 114, 97, 110, 115, 102, 101, 114, UsbCameraHandler.MSG_ID_SET_TARGET, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 7, 117, 112, 103, 114, 97, 100, 101, 0, 0, 0, 10, 117, 115, 101, 114, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 103, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 4, 118, 97, 114, 121, 0, 0, 0, 3, 118, 105, 97, 0, 0, 0, 7, 119, 97, 114, 110, 105, 110, 103, 0, 0, 0, 16, 119, 119, 119, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 117, FlightConfig.ATOM_TI_18650_BATTERY, 104, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, 105, 99, 97, FlightConfig.ATOM_TI_18650_BATTERY, 101, 0, 0, 0, 6, 109, 101, FlightConfig.ATOM_TI_18650_BATTERY, 104, 111, 100, 0, 0, 0, 3, 103, 101, FlightConfig.ATOM_TI_18650_BATTERY, 0, 0, 0, 6, 115, FlightConfig.ATOM_TI_18650_BATTERY, 97, FlightConfig.ATOM_TI_18650_BATTERY, 117, 115, 0, 0, 0, 6, 50, 48, 48, 32, 79, 75, 0, 0, 0, 7, 118, 101, 114, 115, 105, 111, 110, 0, 0, 0, 8, 72, 84, 84, FlightConfig.P1_PRO_RC, UsbCameraHandler.MSG_ID_VISION_ERROR, 49, UsbCameraHandler.MSG_ID_EXECUTE_SHORT_VIDEO, 49, 0, 0, 0, 3, 117, 114, 108, 0, 0, 0, 6, 112, 117, 98, 108, 105, 99, 0, 0, 0, 10, 115, 101, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_SET_TARGET, 99, 111, 111, 107, 105, 101, 0, 0, 0, 10, 107, 101, 101, 112, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 108, 105, 118, 101, 0, 0, 0, 6, 111, 114, 105, 103, 105, 110, 49, 48, 48, 49, 48, 49, 50, 48, 49, 50, 48, 50, 50, 48, 53, 50, 48, 54, UsbConfig.REV_REMOTER_STATE, 48, 48, UsbConfig.REV_REMOTER_STATE, 48, 50, UsbConfig.REV_REMOTER_STATE, 48, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_STATE, 48, UsbConfig.REV_REMOTER_MUTE_CODE, UsbConfig.REV_REMOTER_STATE, 48, 53, UsbConfig.REV_REMOTER_STATE, 48, 54, UsbConfig.REV_REMOTER_STATE, 48, 55, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 50, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 53, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 54, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 55, UsbConfig.REV_REMOTER_MUTE_CODE, 48, PaletteRecord.STANDARD_PALETTE_SIZE, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 57, UsbConfig.REV_REMOTER_MUTE_CODE, 49, 48, UsbConfig.REV_REMOTER_MUTE_CODE, 49, 49, UsbConfig.REV_REMOTER_MUTE_CODE, 49, 50, UsbConfig.REV_REMOTER_MUTE_CODE, 49, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 49, UsbConfig.REV_REMOTER_MUTE_CODE, UsbConfig.REV_REMOTER_MUTE_CODE, 49, 53, UsbConfig.REV_REMOTER_MUTE_CODE, 49, 54, UsbConfig.REV_REMOTER_MUTE_CODE, 49, 55, 53, 48, 50, 53, 48, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 48, 53, 50, 48, UsbConfig.REV_REMOTER_STATE, 32, 78, 111, 110, UsbCameraHandler.MSG_ID_SET_TARGET, 65, 117, FlightConfig.ATOM_TI_18650_BATTERY, 104, 111, 114, 105, FlightConfig.ATOM_TI_18650_BATTERY, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 118, 101, 32, 73, 110, 102, 111, 114, 109, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, 50, 48, UsbConfig.REV_REMOTER_MUTE_CODE, 32, 78, 111, 32, 67, 111, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, UsbConfig.REV_REMOTER_STATE, 48, 49, 32, 77, 111, 118, 101, 100, 32, FlightConfig.P1_PRO_RC, 101, 114, 109, 
    97, 110, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, 108, 121, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 48, 32, 66, 97, 100, 32, 82, 101, 113, 117, 101, 115, FlightConfig.ATOM_TI_18650_BATTERY, UsbConfig.REV_REMOTER_MUTE_CODE, 48, 49, 32, FlightConfig.P1_PRO_RC_2, 110, 97, 117, FlightConfig.ATOM_TI_18650_BATTERY, 104, 111, 114, 105, 122, 101, 100, UsbConfig.REV_REMOTER_MUTE_CODE, 48, UsbConfig.REV_REMOTER_STATE, 32, 70, 111, 114, 98, 105, 100, 100, 101, 110, UsbConfig.REV_REMOTER_MUTE_CODE, 48, UsbConfig.REV_REMOTER_MUTE_CODE, 32, 78, 111, FlightConfig.ATOM_TI_18650_BATTERY, 32, 70, 111, 117, 110, 100, 53, 48, 48, 32, 73, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 114, 110, 97, 108, 32, 83, 101, 114, 118, 101, 114, 32, 69, 114, 114, 111, 114, 53, 48, 49, 32, 78, 111, FlightConfig.ATOM_TI_18650_BATTERY, 32, 73, 109, 112, 108, 101, 109, 101, 110, FlightConfig.ATOM_TI_18650_BATTERY, 101, 100, 53, 48, UsbConfig.REV_REMOTER_STATE, 32, 83, 101, 114, 118, 105, 99, 101, 32, FlightConfig.P1_PRO_RC_2, 110, 97, 118, 97, 105, 108, 97, 98, 108, 101, 74, 97, 110, 32, 70, 101, 98, 32, 77, 97, 114, 32, 65, 112, 114, 32, 77, 97, 121, 32, 74, 117, 110, 32, 74, 117, 108, 32, 65, 117, 103, 32, 83, 101, 112, FlightConfig.ATOM_TI_18650_BATTERY, 32, 79, 99, FlightConfig.ATOM_TI_18650_BATTERY, 32, 78, 111, 118, 32, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 101, 99, 32, 48, 48, 58, 48, 48, 58, 48, 48, 32, 77, 111, 110, 44, 32, 84, 117, 101, 44, 32, FlightConfig.ATOM_RC, 101, 100, 44, 32, 84, 104, 117, 44, 32, 70, 114, 105, 44, 32, 83, 97, FlightConfig.ATOM_TI_18650_BATTERY, 44, 32, 83, 117, 110, 44, 32, 71, 77, 84, 99, 104, 117, 110, 107, 101, 100, 44, FlightConfig.ATOM_TI_18650_BATTERY, 101, 120, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_VISION_ERROR, 104, FlightConfig.ATOM_TI_18650_BATTERY, 109, 108, 44, 105, 109, 97, 103, 101, UsbCameraHandler.MSG_ID_VISION_ERROR, 112, 110, 103, 44, 105, 109, 97, 103, 101, UsbCameraHandler.MSG_ID_VISION_ERROR, 106, 112, 103, 44, 105, 109, 97, 103, 101, UsbCameraHandler.MSG_ID_VISION_ERROR, 103, 105, 102, 44, 97, 112, 112, 108, 105, 99, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, UsbCameraHandler.MSG_ID_VISION_ERROR, 120, 109, 108, 44, 97, 112, 112, 108, 105, 99, 97, FlightConfig.ATOM_TI_18650_BATTERY, 105, 111, 110, UsbCameraHandler.MSG_ID_VISION_ERROR, 120, 104, FlightConfig.ATOM_TI_18650_BATTERY, 109, 108, 43, 120, 109, 108, 44, FlightConfig.ATOM_TI_18650_BATTERY, 101, 120, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_VISION_ERROR, 112, 108, 97, 105, 110, 44, FlightConfig.ATOM_TI_18650_BATTERY, 101, 120, FlightConfig.ATOM_TI_18650_BATTERY, UsbCameraHandler.MSG_ID_VISION_ERROR, 106, 97, 118, 97, 115, 99, 114, 105, 112, FlightConfig.ATOM_TI_18650_BATTERY, 44, 112, 117, 98, 108, 105, 99, 112, 114, 105, 118, 97, FlightConfig.ATOM_TI_18650_BATTERY, 101, 109, 97, 120, UsbCameraHandler.MSG_ID_SET_TARGET, 97, 103, 101, 61, 103, 122, 105, 112, 44, 100, 101, 102, 108, 97, FlightConfig.ATOM_TI_18650_BATTERY, 101, 44, 115, 100, 99, 104, 99, 104, 97, 114, 115, 101, FlightConfig.ATOM_TI_18650_BATTERY, 61, 117, FlightConfig.ATOM_TI_18650_BATTERY, 102, UsbCameraHandler.MSG_ID_SET_TARGET, PaletteRecord.STANDARD_PALETTE_SIZE, 99, 104, 97, 114, 115, 101, FlightConfig.ATOM_TI_18650_BATTERY, 61, 105, 115, 111, UsbCameraHandler.MSG_ID_SET_TARGET, PaletteRecord.STANDARD_PALETTE_SIZE, PaletteRecord.STANDARD_PALETTE_SIZE, 53, 57, UsbCameraHandler.MSG_ID_SET_TARGET, 49, 44, 117, FlightConfig.ATOM_TI_18650_BATTERY, 102, UsbCameraHandler.MSG_ID_SET_TARGET, 44, 42, 44, 101, 110, 113, 61, 48, UsbCameraHandler.MSG_ID_EXECUTE_SHORT_VIDEO};
    static final byte SPDY_FLAG_FIN = 1;
    static final byte SPDY_FLAG_UNIDIRECTIONAL = 2;
    static final int SPDY_GOAWAY_FRAME = 7;
    static final int SPDY_HEADERS_FRAME = 8;
    static final int SPDY_HEADER_FLAGS_OFFSET = 4;
    static final int SPDY_HEADER_LENGTH_OFFSET = 5;
    static final int SPDY_HEADER_SIZE = 8;
    static final int SPDY_HEADER_TYPE_OFFSET = 2;
    static final int SPDY_MAX_LENGTH = 16777215;
    static final int SPDY_MAX_NV_LENGTH = 65535;
    static final int SPDY_PING_FRAME = 6;
    static final int SPDY_PUSH_PROMISE_FRAME = 5;
    static final int SPDY_RST_STREAM_FRAME = 3;
    static final int SPDY_SESSION_STREAM_ID = 0;
    static final byte SPDY_SETTINGS_CLEAR = 1;
    static final int SPDY_SETTINGS_FRAME = 4;
    static final int SPDY_SETTINGS_MAX_ID = 16777215;
    static final byte SPDY_SETTINGS_PERSISTED = 2;
    static final byte SPDY_SETTINGS_PERSIST_VALUE = 1;
    static final int SPDY_SYN_REPLY_FRAME = 2;
    static final int SPDY_SYN_STREAM_FRAME = 1;
    static final int SPDY_WINDOW_UPDATE_FRAME = 9;

    private SpdyCodecUtil() {
    }

    static int getUnsignedShort(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 1) & 255) | ((byteBuf.getByte(i) & 255) << 8);
    }

    static int getUnsignedMedium(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 2) & 255) | ((byteBuf.getByte(i) & 255) << 16) | ((byteBuf.getByte(i + 1) & 255) << 8);
    }

    static int getUnsignedInt(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 3) & 255) | ((byteBuf.getByte(i) & Byte.MAX_VALUE) << 24) | ((byteBuf.getByte(i + 1) & 255) << 16) | ((byteBuf.getByte(i + 2) & 255) << 8);
    }

    static int getSignedInt(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 3) & 255) | ((byteBuf.getByte(i) & 255) << 24) | ((byteBuf.getByte(i + 1) & 255) << 16) | ((byteBuf.getByte(i + 2) & 255) << 8);
    }

    static boolean isServerId(int i) {
        return i % 2 == 0;
    }

    static void validateHeaderName(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "name");
        if (charSequence.length() == 0) {
            throw new IllegalArgumentException("name cannot be length zero");
        }
        if (charSequence.length() > 65535) {
            throw new IllegalArgumentException("name exceeds allowable length: " + ((Object) charSequence));
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == 0) {
                throw new IllegalArgumentException("name contains null character: " + ((Object) charSequence));
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                throw new IllegalArgumentException("name must be all lower case.");
            }
            if (charAt > 127) {
                throw new IllegalArgumentException("name contains non-ascii character: " + ((Object) charSequence));
            }
        }
    }

    static void validateHeaderValue(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "value");
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == 0) {
                throw new IllegalArgumentException("value contains null character: " + ((Object) charSequence));
            }
        }
    }
}
