package com.ipotensic.kernel.maps.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.kernel.maps.enums.NoFlyZoneShape;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: NoFlyZoneSubModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010/\u001a\u00020\fH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00060"}, d2 = {"Lcom/ipotensic/kernel/maps/bean/NoFlyZoneSubModel;", "", "lat", "", "lng", "radius", "", "level", "", "height", "shape", TtmlNode.ATTR_TTS_COLOR, "", "polygon_points", "Ljava/util/ArrayList;", "Lcom/ipotensic/kernel/maps/bean/CommonLatLng;", "Lkotlin/collections/ArrayList;", "(DDFLjava/lang/Integer;FILjava/lang/String;Ljava/util/ArrayList;)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getHeight", "()F", "setHeight", "(F)V", "getLat", "()D", "setLat", "(D)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLng", "setLng", "getPolygon_points", "()Ljava/util/ArrayList;", "setPolygon_points", "(Ljava/util/ArrayList;)V", "getRadius", "setRadius", "getShape", "()I", "setShape", "(I)V", "toString", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class NoFlyZoneSubModel {
    private String color;
    private float height;
    private double lat;
    private Integer level;
    private double lng;
    private ArrayList<CommonLatLng> polygon_points;
    private float radius;
    private int shape;

    public NoFlyZoneSubModel(double d, double d2, float f, Integer num, float f2, int i, String str, ArrayList<CommonLatLng> arrayList) {
        this.lat = d;
        this.lng = d2;
        this.radius = f;
        this.level = num;
        this.height = f2;
        this.shape = i;
        this.color = str;
        this.polygon_points = arrayList;
    }

    public final double getLat() {
        return this.lat;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final double getLng() {
        return this.lng;
    }

    public final void setLng(double d) {
        this.lng = d;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final void setLevel(Integer num) {
        this.level = num;
    }

    public final float getHeight() {
        return this.height;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public /* synthetic */ NoFlyZoneSubModel(double d, double d2, float f, Integer num, float f2, int i, String str, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 300.0d : d, (i2 & 2) != 0 ? 300.0d : d2, (i2 & 4) != 0 ? 0.0f : f, num, (i2 & 16) != 0 ? 0.0f : f2, (i2 & 32) != 0 ? NoFlyZoneShape.UNKNOW.getValue() : i, str, arrayList);
    }

    public final int getShape() {
        return this.shape;
    }

    public final void setShape(int i) {
        this.shape = i;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final ArrayList<CommonLatLng> getPolygon_points() {
        return this.polygon_points;
    }

    public final void setPolygon_points(ArrayList<CommonLatLng> arrayList) {
        this.polygon_points = arrayList;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("NoFlyZoneSubModel(lat=").append(this.lat).append(", lng=").append(this.lng).append(", radius=").append(this.radius).append(", level=").append(this.level).append(", height=").append(this.height).append(", shape=").append(this.shape).append(", color=").append(this.color).append(", polygon_points.size=");
        ArrayList<CommonLatLng> arrayList = this.polygon_points;
        return append.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null).append(PropertyUtils.MAPPED_DELIM2).toString();
    }
}