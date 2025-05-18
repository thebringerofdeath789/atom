package com.mapbox.api.routetiles.p028v1.versions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mapbox.api.routetiles.p028v1.versions.models.AutoValue_RouteTileVersionsResponse;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class RouteTileVersionsResponse {
    public abstract List<String> availableVersions();

    public RouteTileVersionsResponse create(List<String> list) {
        return new AutoValue_RouteTileVersionsResponse(list);
    }

    public static TypeAdapter<RouteTileVersionsResponse> typeAdapter(Gson gson) {
        return new AutoValue_RouteTileVersionsResponse.GsonTypeAdapter(gson);
    }
}