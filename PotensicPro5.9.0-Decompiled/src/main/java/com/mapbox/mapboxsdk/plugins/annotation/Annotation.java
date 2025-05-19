package com.mapbox.mapboxsdk.plugins.annotation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mapbox.android.gestures.MoveDistancesObject;
import com.mapbox.geojson.Geometry;
import com.mapbox.mapboxsdk.maps.Projection;

/* loaded from: classes3.dex */
public abstract class Annotation<T extends Geometry> {
    static final String ID_DATA = "custom_data";
    static final String ID_KEY = "id";
    protected T geometry;
    private boolean isDraggable;
    protected JsonObject jsonObject;

    abstract String getName();

    abstract Geometry getOffsetGeometry(Projection projection, MoveDistancesObject moveDistancesObject, float f, float f2);

    abstract void setUsedDataDrivenProperties();

    Annotation(long j, JsonObject jsonObject, T t) {
        this.jsonObject = jsonObject;
        jsonObject.addProperty("id", Long.valueOf(j));
        this.geometry = t;
    }

    public void setGeometry(T t) {
        this.geometry = t;
    }

    public T getGeometry() {
        T t = this.geometry;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    public long getId() {
        return this.jsonObject.get("id").getAsLong();
    }

    JsonObject getFeature() {
        return this.jsonObject;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    public void setData(JsonElement jsonElement) {
        this.jsonObject.add(ID_DATA, jsonElement);
    }

    public JsonElement getData() {
        return this.jsonObject.get(ID_DATA);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        if (this.isDraggable == annotation.isDraggable && this.jsonObject.equals(annotation.jsonObject)) {
            return this.geometry.equals(annotation.geometry);
        }
        return false;
    }

    public int hashCode() {
        return (((this.jsonObject.hashCode() * 31) + this.geometry.hashCode()) * 31) + (this.isDraggable ? 1 : 0);
    }

    public String toString() {
        return getName() + "{geometry=" + this.geometry + ", properties=" + this.jsonObject + ", isDraggable=" + this.isDraggable + '}';
    }
}
