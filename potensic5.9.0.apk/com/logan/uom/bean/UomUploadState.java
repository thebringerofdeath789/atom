package com.logan.uom.bean;

import kotlin.Metadata;

/* compiled from: UomUploadState.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, m2338d2 = {"Lcom/logan/uom/bean/UomUploadState;", "", "sorties", "", "isNetworkAvailable", "", "(IZ)V", "()Z", "setNetworkAvailable", "(Z)V", "getSorties", "()I", "setSorties", "(I)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class UomUploadState {
    private boolean isNetworkAvailable;
    private int sorties;

    public static /* synthetic */ UomUploadState copy$default(UomUploadState uomUploadState, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uomUploadState.sorties;
        }
        if ((i2 & 2) != 0) {
            z = uomUploadState.isNetworkAvailable;
        }
        return uomUploadState.copy(i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSorties() {
        return this.sorties;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    public final UomUploadState copy(int sorties, boolean isNetworkAvailable) {
        return new UomUploadState(sorties, isNetworkAvailable);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof UomUploadState) {
                UomUploadState uomUploadState = (UomUploadState) other;
                if (this.sorties == uomUploadState.sorties) {
                    if (this.isNetworkAvailable == uomUploadState.isNetworkAvailable) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.sorties * 31;
        boolean z = this.isNetworkAvailable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public String toString() {
        return "UomUploadState(sorties=" + this.sorties + ", isNetworkAvailable=" + this.isNetworkAvailable + ")";
    }

    public UomUploadState(int i, boolean z) {
        this.sorties = i;
        this.isNetworkAvailable = z;
    }

    public final int getSorties() {
        return this.sorties;
    }

    public final boolean isNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    public final void setNetworkAvailable(boolean z) {
        this.isNetworkAvailable = z;
    }

    public final void setSorties(int i) {
        this.sorties = i;
    }
}