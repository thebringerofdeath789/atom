package com.logan.upgrade.big;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.logan.flight.FlightConfig;
import kotlin.Metadata;

/* compiled from: UpgradeHandshakeState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/logan/upgrade/big/UpgradeHandshakeState;", "", TtmlNode.COMBINE_ALL, "", "fc", "esc", FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL, "bms", "(IIIII)V", "getAll", "()I", "getBms", "getEsc", "getFc", "getGimbal", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class UpgradeHandshakeState {
    private final int all;
    private final int bms;
    private final int esc;
    private final int fc;
    private final int gimbal;

    public UpgradeHandshakeState(int i, int i2, int i3, int i4, int i5) {
        this.all = i;
        this.fc = i2;
        this.esc = i3;
        this.gimbal = i4;
        this.bms = i5;
    }

    public final int getAll() {
        return this.all;
    }

    public final int getFc() {
        return this.fc;
    }

    public final int getEsc() {
        return this.esc;
    }

    public final int getGimbal() {
        return this.gimbal;
    }

    public final int getBms() {
        return this.bms;
    }
}
