package com.mapbox.mapboxsdk.attribution;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Attribution {
    static final List<String> IMPROVE_MAP_URLS;
    static final String MAPBOX_URL = "https://www.mapbox.com/about/maps/";
    private static final String OPENSTREETMAP = "OpenStreetMap";
    private static final String OPENSTREETMAP_ABBR = "OSM";
    static final String TELEMETRY = "Telemetry Settings";
    static final String TELEMETRY_URL = "https://www.mapbox.com/telemetry/";
    private String title;
    private String url;

    static {
        ArrayList arrayList = new ArrayList();
        IMPROVE_MAP_URLS = arrayList;
        arrayList.add("https://www.mapbox.com/feedback/");
        arrayList.add("https://www.mapbox.com/map-feedback/");
        arrayList.add("https://apps.mapbox.com/feedback/");
    }

    Attribution(String str, String str2) {
        this.title = str;
        this.url = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleAbbreviated() {
        return this.title.equals(OPENSTREETMAP) ? OPENSTREETMAP_ABBR : this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribution attribution = (Attribution) obj;
        String str = this.title;
        if (str == null ? attribution.title != null : !str.equals(attribution.title)) {
            return false;
        }
        String str2 = this.url;
        String str3 = attribution.url;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
