package com.mapbox.api.staticmap.p030v1;

import com.mapbox.api.staticmap.p030v1.MapboxStaticMap;
import com.mapbox.api.staticmap.p030v1.models.StaticMarkerAnnotation;
import com.mapbox.api.staticmap.p030v1.models.StaticPolylineAnnotation;
import com.mapbox.geojson.GeoJson;
import com.mapbox.geojson.Point;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxStaticMap extends MapboxStaticMap {
    private final String accessToken;
    private final boolean attribution;
    private final String baseUrl;
    private final String beforeLayer;
    private final boolean cameraAuto;
    private final double cameraBearing;
    private final double cameraPitch;
    private final Point cameraPoint;
    private final double cameraZoom;
    private final GeoJson geoJson;
    private final int height;
    private final boolean logo;
    private final int precision;
    private final boolean retina;
    private final List<StaticMarkerAnnotation> staticMarkerAnnotations;
    private final List<StaticPolylineAnnotation> staticPolylineAnnotations;
    private final String styleId;
    private final String user;
    private final int width;

    private AutoValue_MapboxStaticMap(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, Point point, double d, double d2, double d3, boolean z4, String str5, int i, int i2, GeoJson geoJson, List<StaticMarkerAnnotation> list, List<StaticPolylineAnnotation> list2, int i3) {
        this.accessToken = str;
        this.baseUrl = str2;
        this.user = str3;
        this.styleId = str4;
        this.logo = z;
        this.attribution = z2;
        this.retina = z3;
        this.cameraPoint = point;
        this.cameraZoom = d;
        this.cameraBearing = d2;
        this.cameraPitch = d3;
        this.cameraAuto = z4;
        this.beforeLayer = str5;
        this.width = i;
        this.height = i2;
        this.geoJson = geoJson;
        this.staticMarkerAnnotations = list;
        this.staticPolylineAnnotations = list2;
        this.precision = i3;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    String accessToken() {
        return this.accessToken;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    String user() {
        return this.user;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    String styleId() {
        return this.styleId;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    boolean logo() {
        return this.logo;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    boolean attribution() {
        return this.attribution;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    boolean retina() {
        return this.retina;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    Point cameraPoint() {
        return this.cameraPoint;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    double cameraZoom() {
        return this.cameraZoom;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    double cameraBearing() {
        return this.cameraBearing;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    double cameraPitch() {
        return this.cameraPitch;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    boolean cameraAuto() {
        return this.cameraAuto;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    String beforeLayer() {
        return this.beforeLayer;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    int width() {
        return this.width;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    int height() {
        return this.height;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    GeoJson geoJson() {
        return this.geoJson;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    List<StaticMarkerAnnotation> staticMarkerAnnotations() {
        return this.staticMarkerAnnotations;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    List<StaticPolylineAnnotation> staticPolylineAnnotations() {
        return this.staticPolylineAnnotations;
    }

    @Override // com.mapbox.api.staticmap.p030v1.MapboxStaticMap
    int precision() {
        return this.precision;
    }

    public String toString() {
        return "MapboxStaticMap{accessToken=" + this.accessToken + ", baseUrl=" + this.baseUrl + ", user=" + this.user + ", styleId=" + this.styleId + ", logo=" + this.logo + ", attribution=" + this.attribution + ", retina=" + this.retina + ", cameraPoint=" + this.cameraPoint + ", cameraZoom=" + this.cameraZoom + ", cameraBearing=" + this.cameraBearing + ", cameraPitch=" + this.cameraPitch + ", cameraAuto=" + this.cameraAuto + ", beforeLayer=" + this.beforeLayer + ", width=" + this.width + ", height=" + this.height + ", geoJson=" + this.geoJson + ", staticMarkerAnnotations=" + this.staticMarkerAnnotations + ", staticPolylineAnnotations=" + this.staticPolylineAnnotations + ", precision=" + this.precision + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        String str;
        GeoJson geoJson;
        List<StaticMarkerAnnotation> list;
        List<StaticPolylineAnnotation> list2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapboxStaticMap)) {
            return false;
        }
        MapboxStaticMap mapboxStaticMap = (MapboxStaticMap) obj;
        return this.accessToken.equals(mapboxStaticMap.accessToken()) && this.baseUrl.equals(mapboxStaticMap.baseUrl()) && this.user.equals(mapboxStaticMap.user()) && this.styleId.equals(mapboxStaticMap.styleId()) && this.logo == mapboxStaticMap.logo() && this.attribution == mapboxStaticMap.attribution() && this.retina == mapboxStaticMap.retina() && this.cameraPoint.equals(mapboxStaticMap.cameraPoint()) && Double.doubleToLongBits(this.cameraZoom) == Double.doubleToLongBits(mapboxStaticMap.cameraZoom()) && Double.doubleToLongBits(this.cameraBearing) == Double.doubleToLongBits(mapboxStaticMap.cameraBearing()) && Double.doubleToLongBits(this.cameraPitch) == Double.doubleToLongBits(mapboxStaticMap.cameraPitch()) && this.cameraAuto == mapboxStaticMap.cameraAuto() && ((str = this.beforeLayer) != null ? str.equals(mapboxStaticMap.beforeLayer()) : mapboxStaticMap.beforeLayer() == null) && this.width == mapboxStaticMap.width() && this.height == mapboxStaticMap.height() && ((geoJson = this.geoJson) != null ? geoJson.equals(mapboxStaticMap.geoJson()) : mapboxStaticMap.geoJson() == null) && ((list = this.staticMarkerAnnotations) != null ? list.equals(mapboxStaticMap.staticMarkerAnnotations()) : mapboxStaticMap.staticMarkerAnnotations() == null) && ((list2 = this.staticPolylineAnnotations) != null ? list2.equals(mapboxStaticMap.staticPolylineAnnotations()) : mapboxStaticMap.staticPolylineAnnotations() == null) && this.precision == mapboxStaticMap.precision();
    }

    public int hashCode() {
        int hashCode = (((((((((((((((((((((((this.accessToken.hashCode() ^ 1000003) * 1000003) ^ this.baseUrl.hashCode()) * 1000003) ^ this.user.hashCode()) * 1000003) ^ this.styleId.hashCode()) * 1000003) ^ (this.logo ? 1231 : 1237)) * 1000003) ^ (this.attribution ? 1231 : 1237)) * 1000003) ^ (this.retina ? 1231 : 1237)) * 1000003) ^ this.cameraPoint.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.cameraZoom) >>> 32) ^ Double.doubleToLongBits(this.cameraZoom)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.cameraBearing) >>> 32) ^ Double.doubleToLongBits(this.cameraBearing)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.cameraPitch) >>> 32) ^ Double.doubleToLongBits(this.cameraPitch)))) * 1000003) ^ (this.cameraAuto ? 1231 : 1237)) * 1000003;
        String str = this.beforeLayer;
        int hashCode2 = (((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.width) * 1000003) ^ this.height) * 1000003;
        GeoJson geoJson = this.geoJson;
        int hashCode3 = (hashCode2 ^ (geoJson == null ? 0 : geoJson.hashCode())) * 1000003;
        List<StaticMarkerAnnotation> list = this.staticMarkerAnnotations;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<StaticPolylineAnnotation> list2 = this.staticPolylineAnnotations;
        return ((hashCode4 ^ (list2 != null ? list2.hashCode() : 0)) * 1000003) ^ this.precision;
    }

    static final class Builder extends MapboxStaticMap.Builder {
        private String accessToken;
        private Boolean attribution;
        private String baseUrl;
        private String beforeLayer;
        private Boolean cameraAuto;
        private Double cameraBearing;
        private Double cameraPitch;
        private Point cameraPoint;
        private Double cameraZoom;
        private GeoJson geoJson;
        private Integer height;
        private Boolean logo;
        private Integer precision;
        private Boolean retina;
        private List<StaticMarkerAnnotation> staticMarkerAnnotations;
        private List<StaticPolylineAnnotation> staticPolylineAnnotations;
        private String styleId;
        private String user;
        private Integer width;

        Builder() {
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder accessToken(String str) {
            Objects.requireNonNull(str, "Null accessToken");
            this.accessToken = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder baseUrl(String str) {
            Objects.requireNonNull(str, "Null baseUrl");
            this.baseUrl = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder user(String str) {
            Objects.requireNonNull(str, "Null user");
            this.user = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder styleId(String str) {
            Objects.requireNonNull(str, "Null styleId");
            this.styleId = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder logo(boolean z) {
            this.logo = Boolean.valueOf(z);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder attribution(boolean z) {
            this.attribution = Boolean.valueOf(z);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder retina(boolean z) {
            this.retina = Boolean.valueOf(z);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder cameraPoint(Point point) {
            Objects.requireNonNull(point, "Null cameraPoint");
            this.cameraPoint = point;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder cameraZoom(double d) {
            this.cameraZoom = Double.valueOf(d);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder cameraBearing(double d) {
            this.cameraBearing = Double.valueOf(d);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder cameraPitch(double d) {
            this.cameraPitch = Double.valueOf(d);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder cameraAuto(boolean z) {
            this.cameraAuto = Boolean.valueOf(z);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder beforeLayer(String str) {
            this.beforeLayer = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder width(int i) {
            this.width = Integer.valueOf(i);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder height(int i) {
            this.height = Integer.valueOf(i);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder geoJson(GeoJson geoJson) {
            this.geoJson = geoJson;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder staticMarkerAnnotations(List<StaticMarkerAnnotation> list) {
            this.staticMarkerAnnotations = list;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder staticPolylineAnnotations(List<StaticPolylineAnnotation> list) {
            this.staticPolylineAnnotations = list;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        public MapboxStaticMap.Builder precision(int i) {
            this.precision = Integer.valueOf(i);
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.MapboxStaticMap.Builder
        MapboxStaticMap autoBuild() {
            String str = this.accessToken == null ? " accessToken" : "";
            if (this.baseUrl == null) {
                str = str + " baseUrl";
            }
            if (this.user == null) {
                str = str + " user";
            }
            if (this.styleId == null) {
                str = str + " styleId";
            }
            if (this.logo == null) {
                str = str + " logo";
            }
            if (this.attribution == null) {
                str = str + " attribution";
            }
            if (this.retina == null) {
                str = str + " retina";
            }
            if (this.cameraPoint == null) {
                str = str + " cameraPoint";
            }
            if (this.cameraZoom == null) {
                str = str + " cameraZoom";
            }
            if (this.cameraBearing == null) {
                str = str + " cameraBearing";
            }
            if (this.cameraPitch == null) {
                str = str + " cameraPitch";
            }
            if (this.cameraAuto == null) {
                str = str + " cameraAuto";
            }
            if (this.width == null) {
                str = str + " width";
            }
            if (this.height == null) {
                str = str + " height";
            }
            if (this.precision == null) {
                str = str + " precision";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapboxStaticMap(this.accessToken, this.baseUrl, this.user, this.styleId, this.logo.booleanValue(), this.attribution.booleanValue(), this.retina.booleanValue(), this.cameraPoint, this.cameraZoom.doubleValue(), this.cameraBearing.doubleValue(), this.cameraPitch.doubleValue(), this.cameraAuto.booleanValue(), this.beforeLayer, this.width.intValue(), this.height.intValue(), this.geoJson, this.staticMarkerAnnotations, this.staticPolylineAnnotations, this.precision.intValue());
        }
    }
}