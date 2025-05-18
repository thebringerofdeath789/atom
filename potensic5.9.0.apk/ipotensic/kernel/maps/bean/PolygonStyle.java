package com.ipotensic.kernel.maps.bean;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PolygonStyle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010!\u001a\u00020\nH\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJV\u0010#\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0007H\u00d6\u0001J\t\u0010)\u001a\u00020*H\u00d6\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/ipotensic/kernel/maps/bean/PolygonStyle;", "", "points", "Ljava/util/ArrayList;", "Lcom/ipotensic/kernel/maps/bean/CommonLatLng;", "Lkotlin/collections/ArrayList;", "strokeColor", "", "fillColor", "strokeWidth", "", "zIndex", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;FLjava/lang/Integer;)V", "getFillColor", "()Ljava/lang/Integer;", "setFillColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPoints", "()Ljava/util/ArrayList;", "setPoints", "(Ljava/util/ArrayList;)V", "getStrokeColor", "setStrokeColor", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "getZIndex", "setZIndex", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;FLjava/lang/Integer;)Lcom/ipotensic/kernel/maps/bean/PolygonStyle;", "equals", "", "other", "hashCode", "toString", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class PolygonStyle {
    private Integer fillColor;
    private ArrayList<CommonLatLng> points;
    private Integer strokeColor;
    private float strokeWidth;
    private Integer zIndex;

    public static /* synthetic */ PolygonStyle copy$default(PolygonStyle polygonStyle, ArrayList arrayList, Integer num, Integer num2, float f, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = polygonStyle.points;
        }
        if ((i & 2) != 0) {
            num = polygonStyle.strokeColor;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = polygonStyle.fillColor;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            f = polygonStyle.strokeWidth;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            num3 = polygonStyle.zIndex;
        }
        return polygonStyle.copy(arrayList, num4, num5, f2, num3);
    }

    public final ArrayList<CommonLatLng> component1() {
        return this.points;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getFillColor() {
        return this.fillColor;
    }

    /* renamed from: component4, reason: from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getZIndex() {
        return this.zIndex;
    }

    public final PolygonStyle copy(ArrayList<CommonLatLng> points, Integer strokeColor, Integer fillColor, float strokeWidth, Integer zIndex) {
        Intrinsics.checkParameterIsNotNull(points, "points");
        return new PolygonStyle(points, strokeColor, fillColor, strokeWidth, zIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolygonStyle)) {
            return false;
        }
        PolygonStyle polygonStyle = (PolygonStyle) other;
        return Intrinsics.areEqual(this.points, polygonStyle.points) && Intrinsics.areEqual(this.strokeColor, polygonStyle.strokeColor) && Intrinsics.areEqual(this.fillColor, polygonStyle.fillColor) && Float.compare(this.strokeWidth, polygonStyle.strokeWidth) == 0 && Intrinsics.areEqual(this.zIndex, polygonStyle.zIndex);
    }

    public int hashCode() {
        ArrayList<CommonLatLng> arrayList = this.points;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        Integer num = this.strokeColor;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.fillColor;
        int hashCode3 = (((hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Float.hashCode(this.strokeWidth)) * 31;
        Integer num3 = this.zIndex;
        return hashCode3 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "PolygonStyle(points=" + this.points + ", strokeColor=" + this.strokeColor + ", fillColor=" + this.fillColor + ", strokeWidth=" + this.strokeWidth + ", zIndex=" + this.zIndex + ")";
    }

    public PolygonStyle(ArrayList<CommonLatLng> points, Integer num, Integer num2, float f, Integer num3) {
        Intrinsics.checkParameterIsNotNull(points, "points");
        this.points = points;
        this.strokeColor = num;
        this.fillColor = num2;
        this.strokeWidth = f;
        this.zIndex = num3;
    }

    public final ArrayList<CommonLatLng> getPoints() {
        return this.points;
    }

    public final void setPoints(ArrayList<CommonLatLng> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.points = arrayList;
    }

    public /* synthetic */ PolygonStyle(ArrayList arrayList, Integer num, Integer num2, float f, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i & 2) != 0 ? (Integer) null : num, (i & 4) != 0 ? (Integer) null : num2, (i & 8) != 0 ? 5.0f : f, (i & 16) != 0 ? (Integer) null : num3);
    }

    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    public final void setStrokeColor(Integer num) {
        this.strokeColor = num;
    }

    public final Integer getFillColor() {
        return this.fillColor;
    }

    public final void setFillColor(Integer num) {
        this.fillColor = num;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final void setStrokeWidth(float f) {
        this.strokeWidth = f;
    }

    public final Integer getZIndex() {
        return this.zIndex;
    }

    public final void setZIndex(Integer num) {
        this.zIndex = num;
    }
}