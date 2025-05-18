package com.logan.uom.enums;

import com.logan.uom.C3001R;
import kotlin.Metadata;

/* compiled from: UomState.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m2338d2 = {"Lcom/logan/uom/enums/UomState;", "", "strId", "", "colorId", "(Ljava/lang/String;III)V", "getColorId", "()I", "getStrId", "NORMAL_NETWORK_AVAILABLE", "NORMAL_UPLOAD", "ABNORMAL_SERVER_ERROR", "ABNORMAL_NO_NETWORK", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public enum UomState {
    NORMAL_NETWORK_AVAILABLE(C3001R.string.uom_normal, C3001R.color.white),
    NORMAL_UPLOAD(C3001R.string.uom_normal, C3001R.color.color_connect_green),
    ABNORMAL_SERVER_ERROR(C3001R.string.uom_abnormal_server_error, C3001R.color.red),
    ABNORMAL_NO_NETWORK(C3001R.string.uom_abnormal_no_network_connection, C3001R.color.red);

    private final int colorId;
    private final int strId;

    UomState(int i, int i2) {
        this.strId = i;
        this.colorId = i2;
    }

    public final int getColorId() {
        return this.colorId;
    }

    public final int getStrId() {
        return this.strId;
    }
}