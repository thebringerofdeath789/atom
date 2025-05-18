package com.logan.uom.bean;

import com.logan.uom.enums.UomState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.litepal.crud.LitePalSupport;

/* compiled from: UomRecord.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m2338d2 = {"Lcom/logan/uom/bean/UomRecord;", "Lorg/litepal/crud/LitePalSupport;", "uomStateEnumName", "", "uomStateChangedTime", "", "sorties", "", "(Ljava/lang/String;JI)V", "getSorties", "()I", "getUomStateChangedTime", "()J", "getUomStateEnumName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getUomStateEnum", "Lcom/logan/uom/enums/UomState;", "hashCode", "toString", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class UomRecord extends LitePalSupport {
    private final int sorties;
    private final long uomStateChangedTime;
    private final String uomStateEnumName;

    public static /* synthetic */ UomRecord copy$default(UomRecord uomRecord, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uomRecord.uomStateEnumName;
        }
        if ((i2 & 2) != 0) {
            j = uomRecord.uomStateChangedTime;
        }
        if ((i2 & 4) != 0) {
            i = uomRecord.sorties;
        }
        return uomRecord.copy(str, j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUomStateEnumName() {
        return this.uomStateEnumName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUomStateChangedTime() {
        return this.uomStateChangedTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSorties() {
        return this.sorties;
    }

    public final UomRecord copy(String uomStateEnumName, long uomStateChangedTime, int sorties) {
        Intrinsics.checkParameterIsNotNull(uomStateEnumName, "uomStateEnumName");
        return new UomRecord(uomStateEnumName, uomStateChangedTime, sorties);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof UomRecord) {
                UomRecord uomRecord = (UomRecord) other;
                if (Intrinsics.areEqual(this.uomStateEnumName, uomRecord.uomStateEnumName)) {
                    if (this.uomStateChangedTime == uomRecord.uomStateChangedTime) {
                        if (this.sorties == uomRecord.sorties) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.uomStateEnumName;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.uomStateChangedTime;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.sorties;
    }

    public String toString() {
        return "UomRecord(uomStateEnumName=" + this.uomStateEnumName + ", uomStateChangedTime=" + this.uomStateChangedTime + ", sorties=" + this.sorties + ")";
    }

    public final String getUomStateEnumName() {
        return this.uomStateEnumName;
    }

    public final long getUomStateChangedTime() {
        return this.uomStateChangedTime;
    }

    public final int getSorties() {
        return this.sorties;
    }

    public UomRecord(String uomStateEnumName, long j, int i) {
        Intrinsics.checkParameterIsNotNull(uomStateEnumName, "uomStateEnumName");
        this.uomStateEnumName = uomStateEnumName;
        this.uomStateChangedTime = j;
        this.sorties = i;
    }

    public final UomState getUomStateEnum() {
        return UomState.valueOf(this.uomStateEnumName);
    }
}