package com.mapbox.geojson;

import java.io.Serializable;

/* loaded from: classes3.dex */
public interface GeoJson extends Serializable {
    BoundingBox bbox();

    String toJson();

    String type();
}
