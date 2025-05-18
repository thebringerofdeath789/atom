package com.logan.flight;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.bean.Gps;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.logan.camera.enums.BigPackageFlight;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.type.Flight;

/* loaded from: classes.dex */
public class FlightConfig {
    public static final byte ATOM = -79;
    public static final byte ATOM_GIMBAL = -126;
    public static final byte ATOM_LT = -78;
    public static final byte ATOM_PLUS_18650_BATTERY = 114;
    public static final byte ATOM_POLYMER_BATTERY = 113;
    public static final byte ATOM_RC = 87;
    public static final byte ATOM_SE = -80;
    public static final byte ATOM_SE_18650_BATTERY = 112;
    public static final byte ATOM_SE_RC = 86;
    public static final byte ATOM_SE_V2 = -76;
    public static final byte ATOM_SE_V3 = -74;
    public static final byte ATOM_TI_18650_BATTERY = 116;
    public static final byte ATOM_TI_POLYMER_BATTERY = 115;
    public static final byte ATOM_V2 = -73;
    public static final float COMPASS_HEIGHT = 1.5f;

    /* renamed from: IP */
    public static final String f2423IP = "192.168.29.1";
    public static final double KM_TO_MPH = 0.6213712d;
    public static final short LIMIT_CIRCLE_RADIUS = 10;
    public static final short LIMIT_CIRCLE_SPEED = 3;
    public static final short LIMIT_DISTANCE = 30;
    public static final int LIMIT_HEIGHT = 30;
    public static final short LIMIT_RETURN_HEIGHT = 30;
    public static final String LOG_NAME_ATOM = "Atom";
    public static final String LOG_NAME_ATOMLT = "Atom_LT";
    public static final String LOG_NAME_ATOMSE = "AtomSE";
    public static final String LOG_NAME_ATOMSEV2 = "AtomSE_V2";
    public static final String LOG_NAME_ATOMSEV3 = "AtomSE_V3";
    public static final String LOG_NAME_ATOMV2 = "Atom_V2";
    public static final short LOST_RETURN_HEIGHT = 120;
    public static final int MAX_RADIUS = 50;
    public static final int MAX_SPEED = 5;
    public static final int MIN_DISTANCE = 20;
    public static final int MIN_HEIGHT = 10;
    public static final int MIN_RADIUS = 10;
    public static final int MIN_SPEED = 1;
    public static final String MODEL_ATOM = "Mini";
    public static final String MODEL_ATOM_LT = "MiniLT";
    public static final String MODEL_ATOM_SE = "MiniSE";
    public static final String MODEL_P1PRO = "p1pro";
    public static final String MODEL_P1SELF = "p1self";
    public static final String MODEL_P1SELF_A = "P1A";
    public static final String MODEL_P1SELF_B = "P1B";
    public static final String MODEL_P1_4K = "P1-4K";
    public static final String MODEL_P3 = "P3-SE";
    public static final String MODEL_P3SE_V0 = "P3SE_V0";
    public static final String MODEL_P4 = "P4";
    public static final String MODEL_P5 = "P5-2.7K";
    public static final double M_TO_FT = 3.28083989501d;
    public static final double M_TO_MPH = 2.23693632d;
    public static final int NO_BEGINNER_LIMIT_DISTANCE = 500;
    public static final int NO_BEGINNER_LIMIT_HEIGHT = 60;
    public static final short NO_BEGINNER_LIMIT_RETURN_HEIGHT = 60;
    public static final byte P1_4K = -94;
    public static final byte P1_PRO = -93;
    public static final byte P1_PRO_2 = -87;
    public static final byte P1_PRO_GIMBAL = Byte.MIN_VALUE;
    public static final byte P1_PRO_GIMBAL_2 = -127;
    public static final byte P1_PRO_POLYMER_BATTERY = 114;
    public static final byte P1_PRO_RC = 80;
    public static final byte P1_PRO_RC_2 = 85;
    public static final byte P1_SELF = -96;
    public static final byte P1_SELF_A = -89;
    public static final byte P1_SELF_B = -88;
    public static final byte P1_SELF_B_RC = 81;
    public static final byte P3_SE = -92;
    public static final byte P3_SE_TOF = 32;
    public static final byte P3_SE_V0 = -86;

    /* renamed from: P4 */
    public static final byte f2424P4 = -91;

    /* renamed from: P5 */
    public static final byte f2425P5 = -90;
    public static final int PLANE_BATTERY_VALUE = 20;
    public static final int PORT = 8888;
    public static final int PORT_UDP = 8889;
    public static final String PRODUCT_CLASS_ATOM = "Mini";
    public static final String PRODUCT_CLASS_ATOM_LT = "atomlt";
    public static final String PRODUCT_CLASS_ATOM_SE = "MiniSE";
    public static final String PRODUCT_CLASS_ATOM_SE_V2 = "atomsev2";
    public static final String PRODUCT_CLASS_ATOM_SE_V3 = "AtomSEV3";
    public static final String PRODUCT_CLASS_ATOM_V2 = "AtomV2";
    public static final String PRODUCT_CLASS_BATTERY = "battery";
    public static final String PRODUCT_CLASS_CAMERA = "camera";
    public static final String PRODUCT_CLASS_FLIGHT_CTRL = "flight_control";
    public static final String PRODUCT_CLASS_P1PRO_BATTERY = "p1pro_battery";
    public static final String PRODUCT_CLASS_P1_4K = "P1-4K";
    public static final String PRODUCT_CLASS_P1_PRO = "P1-Pro";
    public static final String PRODUCT_CLASS_P1_PRO_FPV = "biography";
    public static final String PRODUCT_CLASS_P1_PRO_GIMBAL = "gimbal";
    public static final String PRODUCT_CLASS_P1_PRO_RC = "P1-Pro-RC";
    public static final String PRODUCT_CLASS_P1_SELF = "P1-self";
    public static final String PRODUCT_CLASS_P1_SELF_A = "P1A";
    public static final String PRODUCT_CLASS_P1_SELF_B = "P1B";
    public static final String PRODUCT_CLASS_P3 = "P3-SE";
    public static final String PRODUCT_CLASS_P3SE_V0 = "P3SE_V0";
    public static final String PRODUCT_CLASS_P4 = "P4";
    public static final String PRODUCT_CLASS_P5 = "P5-2.7K";
    public static final String PRODUCT_CLASS_TOF = "tof";
    public static final float RESTRICTED_HEIGHT_THRESHOLD = 3.0f;
    public static final int SATELLITES_SIX = 6;
    public static final String TYPE_ATOM = "Atom";
    public static final String TYPE_ATOM_LT = "Atom LT";
    public static final String TYPE_ATOM_SE = "Atom SE";
    public static final String TYPE_DREAMER_4K = "Dreamer 4K";
    public static final String TYPE_DREAMER_P3 = "Falcon 4K";
    public static final String TYPE_DREAMER_P5 = "Dreamer mini 4K";
    public static final String TYPE_DREAMER_PRO = "Dreamer Pro";
    public static final byte TYPE_NONE = -1;
    public static final int WARN_MAX_HEIGHT = 120;
    public static final int WARN_MAX_HEIGHT_150 = 150;
    public static final int WARN_MAX_HEIGHT_800 = 800;
    public static final int WIFI_LEVEL_0 = 0;
    public static final int WIFI_LEVEL_1 = 1;
    public static final int WIFI_LEVEL_2 = 2;
    public static final int WIFI_LEVEL_3 = 3;
    public static final int WIFI_LEVEL_4 = 4;
    public static int connectStatus;
    public static boolean enterPointFly;
    public static long flightFlyTime;
    public static boolean isInterruptFly;
    public static boolean isPointFlyFinished;
    public static final Gps GPS = new Gps();
    public static boolean isConnectFlightSocket = false;
    public static boolean isRecordingFlightData = false;
    public static boolean isSettingCalibration = false;
    public static boolean isShowRemoteControllerButton = false;
    public static boolean isOpenRemoteControllerButton = false;
    public static Flight curFlight = null;
    public static long windStrongStartTime = 0;

    public static boolean isConnectFlight() {
        return connectStatus == 1;
    }

    public static int get_value(int i) {
        return PhoneConfig.isFt ? UnitUtil.round((float) (i * 3.28083989501d)) : i;
    }

    public static String getValueWithUnit(int i) {
        StringBuilder append;
        String str;
        if (PhoneConfig.isFt) {
            append = new StringBuilder().append(UnitUtil.round((float) (i * 3.28083989501d)));
            str = "ft";
        } else {
            append = new StringBuilder().append(i);
            str = "m";
        }
        return append.append(str).toString();
    }

    public static String getValueWithUnit(float f) {
        StringBuilder append;
        String str;
        if (PhoneConfig.isFt) {
            append = new StringBuilder().append(UnitUtil.round((float) (f * 3.28083989501d)));
            str = "ft";
        } else {
            append = new StringBuilder().append(f);
            str = "m";
        }
        return append.append(str).toString();
    }

    public static float get_value(float f) {
        return PhoneConfig.isFt ? UnitUtil.double2Float(f * 3.28083989501d) : f;
    }

    public static int get_speed_value(int i) {
        return PhoneConfig.isFt ? UnitUtil.round((float) (i * 2.23693632d)) : i;
    }

    public static Flight getLastFlight() {
        Flight flightByName;
        String flight = SPHelper.getInstance().getFlight();
        if (flight == null || (flightByName = Flight.getFlightByName(flight)) == null) {
            return null;
        }
        return flightByName;
    }

    public static String getLastProductClass() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return null;
        }
        return lastFlight.getProductClass();
    }

    public static BigPackageFlight getBigPackageLastFlight() {
        BigPackageFlight flightByName;
        String bigPackageFlight = SPHelper.getInstance().getBigPackageFlight();
        if (bigPackageFlight == null || (flightByName = BigPackageFlight.getFlightByName(bigPackageFlight)) == null) {
            return null;
        }
        return flightByName;
    }

    public static String getBigPackageLastProductClass() {
        BigPackageFlight bigPackageLastFlight = getBigPackageLastFlight();
        if (bigPackageLastFlight == null) {
            return null;
        }
        return bigPackageLastFlight.getProductClass();
    }

    public static String getLastFlightModel() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return null;
        }
        return lastFlight.getFlightModel();
    }

    public static boolean isUsb() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return false;
        }
        return lastFlight.isUsb();
    }

    public static String getLogName() {
        Flight flight = curFlight;
        if (flight == null) {
            return null;
        }
        return flight.getLogName();
    }

    public static int getMaxDistance() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return 800;
        }
        return lastFlight.getMaxDistance();
    }

    public static int getMaxHeight() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return 120;
        }
        return lastFlight.getMaxHeight();
    }

    public static int getMaxReturnHeight() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return 120;
        }
        return lastFlight.getMaxReturnHeight();
    }

    public static int getMaxPointDistance() {
        Flight lastFlight = getLastFlight();
        if (lastFlight == null) {
            return 500;
        }
        return lastFlight.getMaxDrawDistance();
    }

    public static void setFlightType(byte b) {
        DDLog.m1684e("设置 飞机类型:" + ParseUtil.byteToHexString(new byte[]{b}));
        if (b == 86 || b == 112 || b == 113 || b == 114 || b == 87 || FlightRevData.get().getFlightRevVersionData().isInit()) {
            return;
        }
        for (Flight flight : Flight.values()) {
            if (flight.getFlightByte() == b || flight.getGimbalByte() == b || flight.getRcByte() == b || flight.getTofByte() == b || flight.isBatteryBytes(b)) {
                curFlight = flight;
                break;
            }
        }
        Flight flight2 = curFlight;
        if (flight2 != null) {
            if (flight2 != getLastFlight()) {
                SPHelper.getInstance().clearUpgradeVersions();
            }
            String flight3 = curFlight.toString();
            DDLog.m1684e("flightType:" + flight3);
            SPHelper.getInstance().setFlight(flight3);
        }
        if (curFlight == Flight.Flight_P1_PRO) {
            if (isP1ProBattery()) {
                DDLog.m1684e("设置p1pro电池升级：true");
                SPHelper.getInstance().setP1ProBatteryUpdate(true);
            } else {
                DDLog.m1684e("设置p1pro电池升级：false");
                SPHelper.getInstance().setP1ProBatteryUpdate(false);
            }
        }
        EventDispatcher.get().sendEvent(EventID.FLIGHT_TYPE_DEFINED);
    }

    public static boolean isP1ProBattery() {
        return 114 == FlightRevData.get().getFlightRevUpgradeData().getUpgradeType() || 114 == FlightRevData.get().getFlightRevVersionData().getBatteryCode() || 114 == FlightRevData.get().getRevShakeHandData().getTypeByte();
    }

    public static boolean isOldProduct() {
        Flight lastFlight = getLastFlight();
        return lastFlight == Flight.Flight_P1_PRO || lastFlight == Flight.Flight_P1_SELF || lastFlight == Flight.Flight_P1_SELF_A || lastFlight == Flight.Flight_P3SE || lastFlight == Flight.Flight_P3SE_V0 || lastFlight == Flight.Flight_P5;
    }

    public static boolean is_Atom_Series() {
        Flight lastFlight = getLastFlight();
        return lastFlight == Flight.Flight_ATOM_LT || lastFlight == Flight.Flight_ATOM_SE || lastFlight == Flight.Flight_ATOM || lastFlight == Flight.Flight_ATOM_V2 || lastFlight == Flight.Flight_ATOM_SE_V2 || lastFlight == Flight.Flight_ATOM_SE_V3;
    }

    public static boolean is_Atom_SE_Series() {
        Flight lastFlight = getLastFlight();
        return lastFlight == Flight.Flight_ATOM_SE || lastFlight == Flight.Flight_ATOM_SE_V2 || lastFlight == Flight.Flight_ATOM_SE_V3;
    }

    public static boolean isAtomSE() {
        return getLastFlight() == Flight.Flight_ATOM_SE;
    }

    public static boolean isAtomSEV2() {
        return getLastFlight() == Flight.Flight_ATOM_SE_V2;
    }

    public static boolean isAtomSEV3() {
        return getLastFlight() == Flight.Flight_ATOM_SE_V3;
    }

    public static boolean isBigPackageAtomSEV3() {
        return getBigPackageLastFlight() == BigPackageFlight.atomsev3;
    }

    public static boolean isAtomV2() {
        return getLastFlight() == Flight.Flight_ATOM_V2;
    }

    public static boolean isBigPackageAtomV2() {
        return getBigPackageLastFlight() == BigPackageFlight.atomv2;
    }

    public static boolean isAtomPanTilt() {
        return isAtomPanTilt(getLastFlight());
    }

    public static boolean isAtomPanTilt(Flight flight) {
        return flight == Flight.Flight_ATOM || flight == Flight.Flight_ATOM_V2;
    }

    public static boolean isAtomLT() {
        return isAtomLT(getLastFlight());
    }

    public static boolean isAtomLT(Flight flight) {
        return flight == Flight.Flight_ATOM_LT;
    }

    public static boolean isBigPackageSeries() {
        BigPackageFlight bigPackageLastFlight = getBigPackageLastFlight();
        return bigPackageLastFlight == BigPackageFlight.atomlt || bigPackageLastFlight == BigPackageFlight.atom || bigPackageLastFlight == BigPackageFlight.atomv2 || bigPackageLastFlight == BigPackageFlight.atomsev2 || bigPackageLastFlight == BigPackageFlight.atomsev3;
    }

    public static boolean isP1Pro() {
        Flight lastFlight = getLastFlight();
        return lastFlight == Flight.Flight_P1_PRO || lastFlight == Flight.Flight_P1_PRO_2;
    }

    public static boolean isP1SelfB() {
        return getLastFlight() == Flight.Flight_P1_SELF_B;
    }

    public static boolean isP1Self() {
        Flight lastFlight = getLastFlight();
        return lastFlight == Flight.Flight_P1_SELF || lastFlight == Flight.Flight_P1_SELF_A;
    }

    public static boolean isP1ProByProductClass(String str) {
        return str != null && (str.equalsIgnoreCase(Flight.Flight_P1_PRO.getProductClass()) || str.equalsIgnoreCase(Flight.Flight_P1_PRO_2.getProductClass()));
    }

    public static boolean isP1SelfBByProductClass(String str) {
        return str != null && str.equalsIgnoreCase(Flight.Flight_P1_SELF_B.getProductClass());
    }

    public static boolean isAtomOrAtomSeByProductClass(String str) {
        return str != null && (str.equalsIgnoreCase(Flight.Flight_ATOM.getProductClass()) || str.equalsIgnoreCase(Flight.Flight_ATOM_SE.getProductClass()));
    }

    public static boolean isAtomSeriesProductClass(String str) {
        return str != null && (str.equalsIgnoreCase(Flight.Flight_ATOM.getProductClass()) || str.equalsIgnoreCase(Flight.Flight_ATOM_V2.getProductClass()));
    }

    public static boolean isAtomSeSeriesProductClass(String str) {
        return str != null && (str.equalsIgnoreCase(Flight.Flight_ATOM_SE.getProductClass()) || str.equalsIgnoreCase(Flight.Flight_ATOM_SE_V2.getProductClass()) || str.equalsIgnoreCase(Flight.Flight_ATOM_SE_V3.getProductClass()));
    }

    public static boolean isP3SE() {
        Flight lastFlight = getLastFlight();
        return lastFlight == Flight.Flight_P3SE || lastFlight == Flight.Flight_P3SE_V0;
    }

    public static boolean isP5() {
        return getLastFlight() == Flight.Flight_P5;
    }

    public static boolean isUnableRiseFurther(int i) {
        return ((double) (((float) i) - 3.0f)) < FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance();
    }
}