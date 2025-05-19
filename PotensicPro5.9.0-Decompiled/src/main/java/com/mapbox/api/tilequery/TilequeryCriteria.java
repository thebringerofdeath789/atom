package com.mapbox.api.tilequery;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class TilequeryCriteria {
    public static final String TILEQUERY_GEOMETRY_LINESTRING = "linestring";
    public static final String TILEQUERY_GEOMETRY_POINT = "point";
    public static final String TILEQUERY_GEOMETRY_POLYGON = "polygon";

    @Retention(RetentionPolicy.CLASS)
    public @interface TilequeryGeometry {
    }
}
