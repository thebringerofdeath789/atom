package com.mapbox.api.staticmap.p030v1;

import com.mapbox.api.staticmap.p030v1.AutoValue_MapboxStaticMap;
import com.mapbox.api.staticmap.p030v1.models.StaticMarkerAnnotation;
import com.mapbox.api.staticmap.p030v1.models.StaticPolylineAnnotation;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.GeoJson;
import com.mapbox.geojson.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public abstract class MapboxStaticMap {
    private static final String BEFORE_LAYER = "before_layer";
    private static final String CAMERA_AUTO = "auto";

    abstract String accessToken();

    abstract boolean attribution();

    abstract String baseUrl();

    abstract String beforeLayer();

    abstract boolean cameraAuto();

    abstract double cameraBearing();

    abstract double cameraPitch();

    abstract Point cameraPoint();

    abstract double cameraZoom();

    abstract GeoJson geoJson();

    abstract int height();

    abstract boolean logo();

    abstract int precision();

    abstract boolean retina();

    abstract List<StaticMarkerAnnotation> staticMarkerAnnotations();

    abstract List<StaticPolylineAnnotation> staticPolylineAnnotations();

    abstract String styleId();

    abstract String user();

    abstract int width();

    public HttpUrl url() {
        HttpUrl.Builder addQueryParameter = HttpUrl.parse(baseUrl()).newBuilder().addPathSegment("styles").addPathSegment("v1").addPathSegment(user()).addPathSegment(styleId()).addPathSegment("static").addQueryParameter("access_token", accessToken());
        ArrayList arrayList = new ArrayList();
        if (staticMarkerAnnotations() != null) {
            ArrayList arrayList2 = new ArrayList(staticMarkerAnnotations().size());
            Iterator<StaticMarkerAnnotation> it = staticMarkerAnnotations().iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().url());
            }
            arrayList.addAll(arrayList2);
        }
        if (staticPolylineAnnotations() != null) {
            String[] strArr = new String[staticPolylineAnnotations().size()];
            for (StaticPolylineAnnotation staticPolylineAnnotation : staticPolylineAnnotations()) {
                strArr[staticPolylineAnnotations().indexOf(staticPolylineAnnotation)] = staticPolylineAnnotation.url();
            }
            arrayList.addAll(Arrays.asList(strArr));
        }
        if (geoJson() != null) {
            arrayList.add(String.format(Locale.US, "geojson(%s)", geoJson().toJson()));
        }
        if (!arrayList.isEmpty()) {
            addQueryParameter.addPathSegment(TextUtils.join(",", arrayList.toArray()));
        }
        addQueryParameter.addPathSegment(cameraAuto() ? "auto" : generateLocationPathSegment());
        if (beforeLayer() != null) {
            addQueryParameter.addQueryParameter(BEFORE_LAYER, beforeLayer());
        }
        if (!attribution()) {
            addQueryParameter.addQueryParameter("attribution", "false");
        }
        if (!logo()) {
            addQueryParameter.addQueryParameter("logo", "false");
        }
        addQueryParameter.addPathSegment(generateSizePathSegment());
        return addQueryParameter.build();
    }

    private String generateLocationPathSegment() {
        if (precision() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TextUtils.formatCoordinate(cameraPoint().longitude(), precision()));
            arrayList.add(TextUtils.formatCoordinate(cameraPoint().latitude(), precision()));
            arrayList.add(TextUtils.formatCoordinate(cameraZoom(), precision()));
            arrayList.add(TextUtils.formatCoordinate(cameraBearing(), precision()));
            arrayList.add(TextUtils.formatCoordinate(cameraPitch(), precision()));
            return TextUtils.join(",", arrayList.toArray());
        }
        return String.format(Locale.US, "%f,%f,%f,%f,%f", Double.valueOf(cameraPoint().longitude()), Double.valueOf(cameraPoint().latitude()), Double.valueOf(cameraZoom()), Double.valueOf(cameraBearing()), Double.valueOf(cameraPitch()));
    }

    private String generateSizePathSegment() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(width());
        objArr[1] = Integer.valueOf(height());
        objArr[2] = retina() ? "@2x" : "";
        return String.format(locale, "%dx%d%s", objArr);
    }

    public static Builder builder() {
        return new AutoValue_MapboxStaticMap.Builder().styleId(StaticMapCriteria.STREET_STYLE).baseUrl("https://api.mapbox.com").user("mapbox").cameraPoint(Point.fromLngLat(0.0d, 0.0d)).cameraAuto(false).attribution(true).width(250).logo(true).attribution(true).retina(true).height(250).cameraZoom(0.0d).cameraPitch(0.0d).cameraBearing(0.0d).precision(0).retina(false);
    }

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        public abstract Builder attribution(boolean z);

        abstract MapboxStaticMap autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder beforeLayer(String str);

        public abstract Builder cameraAuto(boolean z);

        public abstract Builder cameraBearing(double d);

        public abstract Builder cameraPitch(double d);

        public abstract Builder cameraPoint(Point point);

        public abstract Builder cameraZoom(double d);

        public abstract Builder geoJson(GeoJson geoJson);

        public abstract Builder height(int i);

        public abstract Builder logo(boolean z);

        public abstract Builder precision(int i);

        public abstract Builder retina(boolean z);

        public abstract Builder staticMarkerAnnotations(List<StaticMarkerAnnotation> list);

        public abstract Builder staticPolylineAnnotations(List<StaticPolylineAnnotation> list);

        public abstract Builder styleId(String str);

        public abstract Builder user(String str);

        public abstract Builder width(int i);

        public MapboxStaticMap build() {
            MapboxStaticMap autoBuild = autoBuild();
            if (!MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                throw new ServicesException("Using Mapbox Services requires setting a valid access token.");
            }
            if (autoBuild.styleId().isEmpty()) {
                throw new ServicesException("You need to set a map style.");
            }
            return autoBuild;
        }
    }
}