package com.logan.upgrade.local.flight.recv;

/* loaded from: classes3.dex */
public abstract class BaseUpgradeRevData {
    public static final byte REV_FROM_DEVICE = 16;
    public static final byte REV_FUNCTION_CODE_REMOTE_CONTROL = 63;
    public static final byte REV_HEAD = 2;
    public static final byte REV_TO_DEVICE = 3;

    public abstract void parse(byte[] bArr, int i);
}