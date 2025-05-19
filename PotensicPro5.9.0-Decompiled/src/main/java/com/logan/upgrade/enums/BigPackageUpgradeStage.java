package com.logan.upgrade.enums;

/* loaded from: classes3.dex */
public enum BigPackageUpgradeStage {
    STAGE_UPGRADE_DEFAULT(0),
    STAGE_INIT(1),
    STAGE_TRANSFER(2),
    STAGE_PARSE_FW(3),
    STAGE_UPGRADE_CAM(4),
    STAGE_UPGRADE_FCS(5),
    STAGE_UPGRADE_ITA(6),
    STAGE_UPGRADE_GIMBAL(7),
    STAGE_UPGRADE_ESC(8),
    STAGE_UPGRADE_BMS(9),
    STAGE_UPGRADE_ITG(10),
    STAGE_UPGRADE_RC(11);

    public int value;

    BigPackageUpgradeStage(int i) {
        this.value = i;
    }

    public static BigPackageUpgradeStage getByValue(int i) {
        for (BigPackageUpgradeStage bigPackageUpgradeStage : values()) {
            if (bigPackageUpgradeStage.value == i) {
                return bigPackageUpgradeStage;
            }
        }
        return null;
    }
}
