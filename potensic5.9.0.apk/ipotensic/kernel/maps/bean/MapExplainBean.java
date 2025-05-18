package com.ipotensic.kernel.maps.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MapExplainBean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/ipotensic/kernel/maps/bean/MapExplainBean;", "", "explainName", "", "explainRes", "(II)V", "getExplainName", "()I", "setExplainName", "(I)V", "getExplainRes", "setExplainRes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class MapExplainBean {
    private int explainName;
    private int explainRes;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MapExplainBean() {
        this(r0, r0, 3, null);
        int i = 0;
    }

    public static /* synthetic */ MapExplainBean copy$default(MapExplainBean mapExplainBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mapExplainBean.explainName;
        }
        if ((i3 & 2) != 0) {
            i2 = mapExplainBean.explainRes;
        }
        return mapExplainBean.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getExplainName() {
        return this.explainName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getExplainRes() {
        return this.explainRes;
    }

    public final MapExplainBean copy(int explainName, int explainRes) {
        return new MapExplainBean(explainName, explainRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof MapExplainBean) {
                MapExplainBean mapExplainBean = (MapExplainBean) other;
                if (this.explainName == mapExplainBean.explainName) {
                    if (this.explainRes == mapExplainBean.explainRes) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.explainName) * 31) + Integer.hashCode(this.explainRes);
    }

    public String toString() {
        return "MapExplainBean(explainName=" + this.explainName + ", explainRes=" + this.explainRes + ")";
    }

    public MapExplainBean(int i, int i2) {
        this.explainName = i;
        this.explainRes = i2;
    }

    public /* synthetic */ MapExplainBean(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2);
    }

    public final int getExplainName() {
        return this.explainName;
    }

    public final int getExplainRes() {
        return this.explainRes;
    }

    public final void setExplainName(int i) {
        this.explainName = i;
    }

    public final void setExplainRes(int i) {
        this.explainRes = i;
    }
}