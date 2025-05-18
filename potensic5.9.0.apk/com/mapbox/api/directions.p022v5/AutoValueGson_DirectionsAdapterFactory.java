package com.mapbox.api.directions.p022v5;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.mapbox.api.directions.p022v5.models.Admin;
import com.mapbox.api.directions.p022v5.models.Amenity;
import com.mapbox.api.directions.p022v5.models.BannerComponents;
import com.mapbox.api.directions.p022v5.models.BannerInstructions;
import com.mapbox.api.directions.p022v5.models.BannerText;
import com.mapbox.api.directions.p022v5.models.BannerView;
import com.mapbox.api.directions.p022v5.models.Closure;
import com.mapbox.api.directions.p022v5.models.Congestion;
import com.mapbox.api.directions.p022v5.models.CostPerVehicleSize;
import com.mapbox.api.directions.p022v5.models.DirectionsError;
import com.mapbox.api.directions.p022v5.models.DirectionsResponse;
import com.mapbox.api.directions.p022v5.models.DirectionsRoute;
import com.mapbox.api.directions.p022v5.models.DirectionsWaypoint;
import com.mapbox.api.directions.p022v5.models.Incident;
import com.mapbox.api.directions.p022v5.models.IntersectionLanes;
import com.mapbox.api.directions.p022v5.models.LegAnnotation;
import com.mapbox.api.directions.p022v5.models.LegStep;
import com.mapbox.api.directions.p022v5.models.MapboxShield;
import com.mapbox.api.directions.p022v5.models.MapboxStreetsV8;
import com.mapbox.api.directions.p022v5.models.MaxSpeed;
import com.mapbox.api.directions.p022v5.models.Metadata;
import com.mapbox.api.directions.p022v5.models.PaymentMethods;
import com.mapbox.api.directions.p022v5.models.RestStop;
import com.mapbox.api.directions.p022v5.models.RouteLeg;
import com.mapbox.api.directions.p022v5.models.RouteOptions;
import com.mapbox.api.directions.p022v5.models.ShieldSprite;
import com.mapbox.api.directions.p022v5.models.ShieldSpriteAttribute;
import com.mapbox.api.directions.p022v5.models.ShieldSprites;
import com.mapbox.api.directions.p022v5.models.ShieldSvg;
import com.mapbox.api.directions.p022v5.models.SilentWaypoint;
import com.mapbox.api.directions.p022v5.models.StepIntersection;
import com.mapbox.api.directions.p022v5.models.StepManeuver;
import com.mapbox.api.directions.p022v5.models.TollCollection;
import com.mapbox.api.directions.p022v5.models.TollCost;
import com.mapbox.api.directions.p022v5.models.VoiceInstructions;

/* loaded from: classes3.dex */
final class AutoValueGson_DirectionsAdapterFactory extends DirectionsAdapterFactory {
    AutoValueGson_DirectionsAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Admin.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Admin.typeAdapter(gson);
        }
        if (Amenity.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Amenity.typeAdapter(gson);
        }
        if (BannerComponents.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BannerComponents.typeAdapter(gson);
        }
        if (BannerInstructions.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BannerInstructions.typeAdapter(gson);
        }
        if (BannerText.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BannerText.typeAdapter(gson);
        }
        if (BannerView.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BannerView.typeAdapter(gson);
        }
        if (Closure.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Closure.typeAdapter(gson);
        }
        if (Congestion.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Congestion.typeAdapter(gson);
        }
        if (CostPerVehicleSize.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CostPerVehicleSize.typeAdapter(gson);
        }
        if (DirectionsError.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DirectionsError.typeAdapter(gson);
        }
        if (DirectionsResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DirectionsResponse.typeAdapter(gson);
        }
        if (DirectionsRoute.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DirectionsRoute.typeAdapter(gson);
        }
        if (DirectionsWaypoint.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) DirectionsWaypoint.typeAdapter(gson);
        }
        if (Incident.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Incident.typeAdapter(gson);
        }
        if (IntersectionLanes.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) IntersectionLanes.typeAdapter(gson);
        }
        if (LegAnnotation.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LegAnnotation.typeAdapter(gson);
        }
        if (LegStep.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) LegStep.typeAdapter(gson);
        }
        if (MapboxShield.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MapboxShield.typeAdapter(gson);
        }
        if (MapboxStreetsV8.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MapboxStreetsV8.typeAdapter(gson);
        }
        if (MaxSpeed.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MaxSpeed.typeAdapter(gson);
        }
        if (Metadata.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) Metadata.typeAdapter(gson);
        }
        if (PaymentMethods.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PaymentMethods.typeAdapter(gson);
        }
        if (RestStop.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RestStop.typeAdapter(gson);
        }
        if (RouteLeg.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RouteLeg.typeAdapter(gson);
        }
        if (RouteOptions.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RouteOptions.typeAdapter(gson);
        }
        if (ShieldSprite.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ShieldSprite.typeAdapter(gson);
        }
        if (ShieldSpriteAttribute.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ShieldSpriteAttribute.typeAdapter(gson);
        }
        if (ShieldSprites.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ShieldSprites.typeAdapter(gson);
        }
        if (ShieldSvg.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) ShieldSvg.typeAdapter(gson);
        }
        if (SilentWaypoint.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) SilentWaypoint.typeAdapter(gson);
        }
        if (StepIntersection.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) StepIntersection.typeAdapter(gson);
        }
        if (StepManeuver.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) StepManeuver.typeAdapter(gson);
        }
        if (TollCollection.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TollCollection.typeAdapter(gson);
        }
        if (TollCost.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) TollCost.typeAdapter(gson);
        }
        if (VoiceInstructions.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) VoiceInstructions.typeAdapter(gson);
        }
        return null;
    }
}