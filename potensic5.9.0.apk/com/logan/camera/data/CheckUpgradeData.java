package com.logan.camera.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class CheckUpgradeData extends BaseData {
    public static final int RESULT_LOW_VERSION_ERROR = -3;
    public static final int RESULT_MEMORY_CARD_ERROR = -2;
    public static final int RESULT_MEMORY_NOT_ENOUGH = -1;
    public static final int RESULT_OK = 0;
    private int result;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckUpgradeResult {
    }

    public CheckUpgradeData(int i) {
        this.result = i;
    }

    public int getResult() {
        return this.result;
    }
}