package io.netty.handler.codec.base64;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;

/* loaded from: classes.dex */
public enum Base64Dialect {
    STANDARD(new byte[]{65, 66, 67, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, FlightConfig.P1_PRO_RC, FlightConfig.P1_SELF_B_RC, 82, 83, 84, FlightConfig.P1_PRO_RC_2, FlightConfig.ATOM_SE_RC, FlightConfig.ATOM_RC, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, FlightConfig.ATOM_TI_18650_BATTERY, 117, 118, 119, 120, 121, 122, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 43, UsbCameraHandler.MSG_ID_VISION_ERROR}, new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 58, 59, DeletedRef3DPtg.sid, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, UsbCameraHandler.MSG_ID_GET_OSD_STATE, UsbCameraHandler.MSG_ID_GET_REMAIN_CAPTURE_SIZE, MemFuncPtg.sid, 42, 43, 44, UsbCameraHandler.MSG_ID_SET_TARGET, UsbCameraHandler.MSG_ID_EXECUTE_SHORT_VIDEO, UsbCameraHandler.MSG_ID_VISION_ERROR, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, -9, -9, -9, -9}, true),
    URL_SAFE(new byte[]{65, 66, 67, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, FlightConfig.P1_PRO_RC, FlightConfig.P1_SELF_B_RC, 82, 83, 84, FlightConfig.P1_PRO_RC_2, FlightConfig.ATOM_SE_RC, FlightConfig.ATOM_RC, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, FlightConfig.ATOM_TI_18650_BATTERY, 117, 118, 119, 120, 121, 122, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, UsbCameraHandler.MSG_ID_SET_TARGET, 95}, new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 58, 59, DeletedRef3DPtg.sid, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, UsbCameraHandler.MSG_ID_GET_OSD_STATE, UsbCameraHandler.MSG_ID_GET_REMAIN_CAPTURE_SIZE, MemFuncPtg.sid, 42, 43, 44, UsbCameraHandler.MSG_ID_SET_TARGET, UsbCameraHandler.MSG_ID_EXECUTE_SHORT_VIDEO, UsbCameraHandler.MSG_ID_VISION_ERROR, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, -9, -9, -9, -9}, false),
    ORDERED(new byte[]{UsbCameraHandler.MSG_ID_SET_TARGET, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 65, 66, 67, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, FlightConfig.P1_PRO_RC, FlightConfig.P1_SELF_B_RC, 82, 83, 84, FlightConfig.P1_PRO_RC_2, FlightConfig.ATOM_SE_RC, FlightConfig.ATOM_RC, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, FlightConfig.ATOM_TI_18650_BATTERY, 117, 118, 119, 120, 121, 122}, new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, UsbCameraHandler.MSG_ID_GET_OSD_STATE, UsbCameraHandler.MSG_ID_GET_REMAIN_CAPTURE_SIZE, MemFuncPtg.sid, 42, 43, 44, UsbCameraHandler.MSG_ID_SET_TARGET, UsbCameraHandler.MSG_ID_EXECUTE_SHORT_VIDEO, UsbCameraHandler.MSG_ID_VISION_ERROR, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 58, 59, DeletedRef3DPtg.sid, 61, 62, 63, -9, -9, -9, -9}, true);

    final byte[] alphabet;
    final boolean breakLinesByDefault;
    final byte[] decodabet;

    Base64Dialect(byte[] bArr, byte[] bArr2, boolean z) {
        this.alphabet = bArr;
        this.decodabet = bArr2;
        this.breakLinesByDefault = z;
    }
}
