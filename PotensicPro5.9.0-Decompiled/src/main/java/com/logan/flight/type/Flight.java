package com.logan.flight.type;

import com.ipotensic.baselib.record.AtomSERecord;
import com.ipotensic.baselib.record.BaseRecord;
import com.logan.flight.FlightConfig;
import com.logan.flight.R;

/* loaded from: classes.dex */
public enum Flight implements BaseConfig {
    Flight_ATOM_LT(new Config_ATOM_LT()),
    Flight_ATOM(new Config_ATOM()),
    Flight_ATOM_V2(new Config_ATOM_V2()),
    Flight_ATOM_SE(new BaseConfig() { // from class: com.logan.flight.type.Config_ATOM_SE
        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.ATOM_SE;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "MiniSE";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "MiniSE";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_ATOM_SE;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return FlightConfig.LOG_NAME_ATOMSE;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 4000;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "MiniSE";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return FlightConfig.ATOM_SE_RC;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return true;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return new byte[]{112, 113, 114};
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_mini_se;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return new AtomSERecord();
        }
    }),
    Flight_ATOM_SE_V2(new Config_ATOM_SE_V2()),
    Flight_ATOM_SE_V3(new Config_ATOM_SE_V3()),
    Flight_P1_4K(new BaseConfig() { // from class: com.logan.flight.type.Config_P1_4K
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P1_4K;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P1-4K";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P14K";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_4K;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P1-4K";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_4k;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P1_PRO(new BaseConfig() { // from class: com.logan.flight.type.Config_P1_PRO
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return new byte[]{114};
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P1_PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return FlightConfig.MODEL_P1PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P1Pro";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return Byte.MIN_VALUE;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 2000;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return FlightConfig.PRODUCT_CLASS_P1_PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return FlightConfig.P1_PRO_RC;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return true;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_pro;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P1_PRO_2(new BaseConfig() { // from class: com.logan.flight.type.Config_P1_PRO_2
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P1_PRO_2;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return FlightConfig.MODEL_P1PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P1Pro2";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -127;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 2000;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return FlightConfig.PRODUCT_CLASS_P1_PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return FlightConfig.P1_PRO_RC_2;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return true;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_pro;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P1_SELF(new BaseConfig() { // from class: com.logan.flight.type.Config_P1_SELF
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P1_SELF;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return FlightConfig.MODEL_P1SELF;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P1Self";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_4K;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return FlightConfig.PRODUCT_CLASS_P1_SELF;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_4k;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P1_SELF_A(new BaseConfig() { // from class: com.logan.flight.type.Config_P1_SELF_A
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P1_SELF_A;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P1A";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P1Self-A";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_4K;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P1A";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_4k;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P1_SELF_B(new BaseConfig() { // from class: com.logan.flight.type.Config_P1_SELF_B
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P1_SELF_B;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P1B";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P1Self-B";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_PRO;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P1B";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return FlightConfig.P1_SELF_B_RC;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return true;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_pro;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P3SE(new BaseConfig() { // from class: com.logan.flight.type.Config_P3SE
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P3_SE;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P3-SE";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P3se";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_P3;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P3-SE";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) 32;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_p3;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P3SE_V0(new BaseConfig() { // from class: com.logan.flight.type.Config_P3SE_V0
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P3_SE_V0;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P3SE_V0";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P3seV0";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_P3;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P3SE_V0";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_p3;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P4(new BaseConfig() { // from class: com.logan.flight.type.Config_P4
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P4;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P4";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P4";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return "";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 800;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 500;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P4";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_p5;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    }),
    Flight_P5(new BaseConfig() { // from class: com.logan.flight.type.Config_P5
        @Override // com.logan.flight.type.BaseConfig
        public byte[] getBatteryBytes() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getFlightByte() {
            return FlightConfig.P5;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightModel() {
            return "P5-2.7K";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightName() {
            return "P5";
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getFlightTypeString() {
            return FlightConfig.TYPE_DREAMER_P5;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getGimbalByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDistance() {
            return 300;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxDrawDistance() {
            return 300;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getMaxReturnHeight() {
            return 120;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getProductClass() {
            return "P5-2.7K";
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getRcByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public byte getTofByte() {
            return (byte) -1;
        }

        @Override // com.logan.flight.type.BaseConfig
        public boolean isUsb() {
            return false;
        }

        @Override // com.logan.flight.type.BaseConfig
        public BaseRecord newFlightRecorder() {
            return null;
        }

        @Override // com.logan.flight.type.BaseConfig
        public int getFlightBg() {
            return R.mipmap.img_bg_main_device_p5;
        }

        @Override // com.logan.flight.type.BaseConfig
        public String getLogName() {
            return getProductClass();
        }
    });

    private final BaseConfig config;

    Flight(BaseConfig baseConfig) {
        this.config = baseConfig;
    }

    public static Flight getFlightByName(String str) {
        for (Flight flight : values()) {
            if (flight.toString().equals(str)) {
                return flight;
            }
        }
        return null;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightName() {
        return this.config.getFlightName();
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getFlightByte() {
        return this.config.getFlightByte();
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getTofByte() {
        return this.config.getTofByte();
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getRcByte() {
        return this.config.getRcByte();
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte getGimbalByte() {
        return this.config.getGimbalByte();
    }

    @Override // com.logan.flight.type.BaseConfig
    public byte[] getBatteryBytes() {
        return this.config.getBatteryBytes();
    }

    public boolean isBatteryBytes(byte b) {
        byte[] batteryBytes = getBatteryBytes();
        if (batteryBytes != null) {
            for (byte b2 : batteryBytes) {
                if (b2 == b) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getProductClass() {
        return this.config.getProductClass();
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightModel() {
        return this.config.getFlightModel();
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxDrawDistance() {
        return this.config.getMaxDrawDistance();
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxDistance() {
        return this.config.getMaxDistance();
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxReturnHeight() {
        return this.config.getMaxReturnHeight();
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getMaxHeight() {
        return this.config.getMaxHeight();
    }

    @Override // com.logan.flight.type.BaseConfig
    public boolean isUsb() {
        return this.config.isUsb();
    }

    @Override // com.logan.flight.type.BaseConfig
    public int getFlightBg() {
        return this.config.getFlightBg();
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getFlightTypeString() {
        return this.config.getFlightTypeString();
    }

    @Override // com.logan.flight.type.BaseConfig
    public String getLogName() {
        return this.config.getLogName();
    }

    @Override // com.logan.flight.type.BaseConfig
    public BaseRecord newFlightRecorder() {
        return this.config.newFlightRecorder();
    }
}
