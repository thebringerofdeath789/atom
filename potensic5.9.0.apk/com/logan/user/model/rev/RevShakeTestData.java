package com.logan.user.model.rev;

/* loaded from: classes3.dex */
public class RevShakeTestData extends BaseUserRevData {
    public static final int CODE_SUCCESS = 0;
    private int code;
    private float shakeValue;

    public RevShakeTestData parse(int i, float f) {
        this.code = i;
        this.shakeValue = f;
        return this;
    }

    public float getShakeValue() {
        return this.shakeValue;
    }

    public int getCode() {
        return this.code;
    }
}