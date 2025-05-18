package com.ipotensic.kernel.maps.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.kernel.maps.enums.NoFlyZoneShape;
import com.mapbox.api.geocoding.p024v5.GeocodingCriteria;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoFlyZoneModel.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\u0018\u00002\u00020\u0001Bñ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b\u0012\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001b¢\u0006\u0002\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u0010\u0015\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00109\"\u0004\bK\u0010;R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R.\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010G\"\u0004\bO\u0010IR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\bP\u0010$\"\u0004\bQ\u0010&R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010 \"\u0004\bS\u0010\"¨\u0006T"}, m2338d2 = {"Lcom/ipotensic/kernel/maps/bean/NoFlyZoneModel;", "", "area_id", "", "name", "", "type", "description", "url", "data_source", "begin_at", "end_at", GeocodingCriteria.TYPE_COUNTRY, "city", GeocodingCriteria.TYPE_ADDRESS, "lat", "", "lng", "radius", "", "level", "height", "shape", TtmlNode.ATTR_TTS_COLOR, "polygon_points", "Ljava/util/ArrayList;", "Lcom/ipotensic/kernel/maps/bean/CommonLatLng;", "Lkotlin/collections/ArrayList;", "sub_areas", "Lcom/ipotensic/kernel/maps/bean/NoFlyZoneSubModel;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDFLjava/lang/Integer;FILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getArea_id", "()Ljava/lang/Integer;", "setArea_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBegin_at", "()I", "setBegin_at", "(I)V", "getCity", "setCity", "getColor", "setColor", "getCountry", "setCountry", "getData_source", "setData_source", "getDescription", "setDescription", "getEnd_at", "setEnd_at", "getHeight", "()F", "setHeight", "(F)V", "getLat", "()D", "setLat", "(D)V", "getLevel", "setLevel", "getLng", "setLng", "getName", "setName", "getPolygon_points", "()Ljava/util/ArrayList;", "setPolygon_points", "(Ljava/util/ArrayList;)V", "getRadius", "setRadius", "getShape", "setShape", "getSub_areas", "setSub_areas", "getType", "setType", "getUrl", "setUrl", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class NoFlyZoneModel {
    private String address;
    private Integer area_id;
    private int begin_at;
    private String city;
    private String color;
    private String country;
    private int data_source;
    private String description;
    private int end_at;
    private float height;
    private double lat;
    private Integer level;
    private double lng;
    private String name;
    private ArrayList<CommonLatLng> polygon_points;
    private float radius;
    private int shape;
    private ArrayList<NoFlyZoneSubModel> sub_areas;
    private Integer type;
    private String url;

    public NoFlyZoneModel(Integer num, String str, Integer num2, String description, String url, int i, int i2, int i3, String str2, String str3, String str4, double d, double d2, float f, Integer num3, float f2, int i4, String str5, ArrayList<CommonLatLng> arrayList, ArrayList<NoFlyZoneSubModel> arrayList2) {
        Intrinsics.checkParameterIsNotNull(description, "description");
        Intrinsics.checkParameterIsNotNull(url, "url");
        this.area_id = num;
        this.name = str;
        this.type = num2;
        this.description = description;
        this.url = url;
        this.data_source = i;
        this.begin_at = i2;
        this.end_at = i3;
        this.country = str2;
        this.city = str3;
        this.address = str4;
        this.lat = d;
        this.lng = d2;
        this.radius = f;
        this.level = num3;
        this.height = f2;
        this.shape = i4;
        this.color = str5;
        this.polygon_points = arrayList;
        this.sub_areas = arrayList2;
    }

    public final Integer getArea_id() {
        return this.area_id;
    }

    public final void setArea_id(Integer num) {
        this.area_id = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.description = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.url = str;
    }

    public final int getData_source() {
        return this.data_source;
    }

    public final void setData_source(int i) {
        this.data_source = i;
    }

    public final int getBegin_at() {
        return this.begin_at;
    }

    public final void setBegin_at(int i) {
        this.begin_at = i;
    }

    public final int getEnd_at() {
        return this.end_at;
    }

    public final void setEnd_at(int i) {
        this.end_at = i;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
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

    public /* synthetic */ NoFlyZoneModel(Integer num, String str, Integer num2, String str2, String str3, int i, int i2, int i3, String str4, String str5, String str6, double d, double d2, float f, Integer num3, float f2, int i4, String str7, ArrayList arrayList, ArrayList arrayList2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, num2, (i5 & 8) != 0 ? "" : str2, (i5 & 16) != 0 ? "" : str3, (i5 & 32) != 0 ? 0 : i, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? 0 : i3, str4, str5, str6, (i5 & 2048) != 0 ? 300.0d : d, (i5 & 4096) != 0 ? 300.0d : d2, (i5 & 8192) != 0 ? 0.0f : f, num3, (32768 & i5) != 0 ? 0.0f : f2, (i5 & 65536) != 0 ? NoFlyZoneShape.UNKNOW.getValue() : i4, str7, arrayList, arrayList2);
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

    public final ArrayList<NoFlyZoneSubModel> getSub_areas() {
        return this.sub_areas;
    }

    public final void setSub_areas(ArrayList<NoFlyZoneSubModel> arrayList) {
        this.sub_areas = arrayList;
    }
}