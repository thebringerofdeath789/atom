package com.ipotensic.kernel.maps.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircleStyle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\fJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010'\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010(\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010)\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJT\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u00020\tH\u0016J\t\u00100\u001a\u000201H\u00d6\u0001R\u001e\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010\u00a8\u00062"}, d2 = {"Lcom/ipotensic/kernel/maps/bean/CircleStyle;", "", "point", "Lcom/ipotensic/kernel/maps/bean/CommonLatLng;", "radius", "", "strokeWidth", "", "strokeColor", "", "fillColor", "zIndex", "(Lcom/ipotensic/kernel/maps/bean/CommonLatLng;Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFillColor", "()Ljava/lang/Integer;", "setFillColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPoint", "()Lcom/ipotensic/kernel/maps/bean/CommonLatLng;", "setPoint", "(Lcom/ipotensic/kernel/maps/bean/CommonLatLng;)V", "getRadius", "()Ljava/lang/Double;", "setRadius", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getStrokeColor", "setStrokeColor", "getStrokeWidth", "()Ljava/lang/Float;", "setStrokeWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getZIndex", "setZIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/ipotensic/kernel/maps/bean/CommonLatLng;Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ipotensic/kernel/maps/bean/CircleStyle;", "equals", "", "other", "hashCode", "toString", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class CircleStyle {
    private Integer fillColor;
    private CommonLatLng point;
    private Double radius;
    private Integer strokeColor;
    private Float strokeWidth;
    private Integer zIndex;

    public static /* synthetic */ CircleStyle copy$default(CircleStyle circleStyle, CommonLatLng commonLatLng, Double d, Float f, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            commonLatLng = circleStyle.point;
        }
        if ((i & 2) != 0) {
            d = circleStyle.radius;
        }
        Double d2 = d;
        if ((i & 4) != 0) {
            f = circleStyle.strokeWidth;
        }
        Float f2 = f;
        if ((i & 8) != 0) {
            num = circleStyle.strokeColor;
        }
        Integer num4 = num;
        if ((i & 16) != 0) {
            num2 = circleStyle.fillColor;
        }
        Integer num5 = num2;
        if ((i & 32) != 0) {
            num3 = circleStyle.zIndex;
        }
        return circleStyle.copy(commonLatLng, d2, f2, num4, num5, num3);
    }

    /* renamed from: component1, reason: from getter */
    public final CommonLatLng getPoint() {
        return this.point;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getRadius() {
        return this.radius;
    }

    /* renamed from: component3, reason: from getter */
    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getFillColor() {
        return this.fillColor;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getZIndex() {
        return this.zIndex;
    }

    public final CircleStyle copy(CommonLatLng point, Double radius, Float strokeWidth, Integer strokeColor, Integer fillColor, Integer zIndex) {
        Intrinsics.checkParameterIsNotNull(point, "point");
        return new CircleStyle(point, radius, strokeWidth, strokeColor, fillColor, zIndex);
    }

    public String toString() {
        return "CircleStyle(point=" + this.point + ", radius=" + this.radius + ", strokeWidth=" + this.strokeWidth + ", strokeColor=" + this.strokeColor + ", fillColor=" + this.fillColor + ", zIndex=" + this.zIndex + ")";
    }

    public CircleStyle(CommonLatLng point, Double d, Float f, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkParameterIsNotNull(point, "point");
        this.point = point;
        this.radius = d;
        this.strokeWidth = f;
        this.strokeColor = num;
        this.fillColor = num2;
        this.zIndex = num3;
    }

    public final CommonLatLng getPoint() {
        return this.point;
    }

    public final void setPoint(CommonLatLng commonLatLng) {
        Intrinsics.checkParameterIsNotNull(commonLatLng, "<set-?>");
        this.point = commonLatLng;
    }

    public /* synthetic */ CircleStyle(CommonLatLng commonLatLng, Double d, Float f, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(commonLatLng, (i & 2) != 0 ? (Double) null : d, (i & 4) != 0 ? (Float) null : f, (i & 8) != 0 ? (Integer) null : num, (i & 16) != 0 ? (Integer) null : num2, (i & 32) != 0 ? (Integer) null : num3);
    }

    public final Double getRadius() {
        return this.radius;
    }

    public final void setRadius(Double d) {
        this.radius = d;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final void setStrokeWidth(Float f) {
        this.strokeWidth = f;
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

    public final Integer getZIndex() {
        return this.zIndex;
    }

    public final void setZIndex(Integer num) {
        this.zIndex = num;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CircleStyle) {
            return Intrinsics.areEqual(this.point, ((CircleStyle) other).point);
        }
        return false;
    }

    public int hashCode() {
        return this.point.hashCode();
    }
}