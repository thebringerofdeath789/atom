package com.logan.camera.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class StartUpgradeData extends BaseData {
    public static final int RESULT_CAMERA_NOT_MATCH = 3;
    public static final int RESULT_CRC_ERROR = 2;
    public static final int RESULT_FILE_ERROR = 4;
    public static final int RESULT_FILE_NOT_EXIST = 1;
    public static final int RESULT_OK = 0;
    private int result;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StartUpgradeResult {
    }

    public StartUpgradeData(int i) {
        this.result = i;
    }

    public int getResult() {
        return this.result;
    }
}