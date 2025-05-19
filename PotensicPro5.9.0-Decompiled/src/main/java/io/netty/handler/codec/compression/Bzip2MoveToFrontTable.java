package io.netty.handler.codec.compression;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.send.SendOthersData;
import com.logan.upgrade.local.flight.recv.UpgradeRevFwLengthData;
import com.logan.upgrade.local.flight.recv.UpgradeRevShakeHandData;
import com.logan.usb.UsbCameraHandler;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;

/* loaded from: classes.dex */
final class Bzip2MoveToFrontTable {
    private final byte[] mtf = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, UsbCameraHandler.MSG_ID_GET_OSD_STATE, UsbCameraHandler.MSG_ID_GET_REMAIN_CAPTURE_SIZE, MemFuncPtg.sid, 42, 43, 44, UsbCameraHandler.MSG_ID_SET_TARGET, UsbCameraHandler.MSG_ID_EXECUTE_SHORT_VIDEO, UsbCameraHandler.MSG_ID_VISION_ERROR, 48, 49, 50, UsbConfig.REV_REMOTER_STATE, UsbConfig.REV_REMOTER_MUTE_CODE, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 58, 59, DeletedRef3DPtg.sid, 61, 62, 63, 64, 65, 66, 67, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, FlightConfig.P1_PRO_RC, FlightConfig.P1_SELF_B_RC, 82, 83, 84, FlightConfig.P1_PRO_RC_2, FlightConfig.ATOM_SE_RC, FlightConfig.ATOM_RC, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, FlightConfig.ATOM_TI_18650_BATTERY, 117, 118, 119, 120, 121, 122, 123, 124, SendOthersData.FUNC_ID_REMOTER_OUTPUT, UsbConfig.SEND_FUNCTION_CODE_REMOTE_CONTROL, Byte.MAX_VALUE, Byte.MIN_VALUE, -127, FlightConfig.ATOM_GIMBAL, -125, -124, -123, -122, -121, -120, -119, -118, -117, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -106, -105, -104, -103, -102, -101, -100, -99, -98, -97, FlightConfig.P1_SELF, -95, FlightConfig.P1_4K, FlightConfig.P1_PRO, FlightConfig.P3_SE, FlightConfig.P4, FlightConfig.P5, FlightConfig.P1_SELF_A, FlightConfig.P1_SELF_B, FlightConfig.P1_PRO_2, FlightConfig.P3_SE_V0, -85, -84, -83, -82, -81, FlightConfig.ATOM_SE, FlightConfig.ATOM, FlightConfig.ATOM_LT, -77, FlightConfig.ATOM_SE_V2, -75, FlightConfig.ATOM_SE_V3, FlightConfig.ATOM_V2, -72, -71, -70, -69, -68, -67, -66, -65, -64, -63, -62, -61, -60, -59, -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45, -44, -43, -42, -41, -40, -39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, UpgradeRevShakeHandData.REV_REQUEST_CODE, -14, -13, -12, UpgradeRevFwLengthData.REV_REQUEST_CODE, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1};

    Bzip2MoveToFrontTable() {
    }

    int valueToFront(byte b) {
        byte[] bArr = this.mtf;
        int i = 0;
        byte b2 = bArr[0];
        if (b != b2) {
            bArr[0] = b;
            while (b != b2) {
                i++;
                byte[] bArr2 = this.mtf;
                byte b3 = bArr2[i];
                bArr2[i] = b2;
                b2 = b3;
            }
        }
        return i;
    }

    byte indexToFront(int i) {
        byte[] bArr = this.mtf;
        byte b = bArr[i];
        System.arraycopy(bArr, 0, bArr, 1, i);
        this.mtf[0] = b;
        return b;
    }
}
