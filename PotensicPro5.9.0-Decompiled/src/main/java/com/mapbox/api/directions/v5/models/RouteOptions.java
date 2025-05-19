package com.mapbox.api.directions.v5.models;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.models.AutoValue_RouteOptions;
import com.mapbox.api.directions.v5.models.C$AutoValue_RouteOptions;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import com.mapbox.api.directions.v5.utils.FormatUtils;
import com.mapbox.api.directions.v5.utils.ParseUtils;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import com.mapbox.geojson.Point;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public abstract class RouteOptions extends DirectionsJsonObject {
    private static final String ACCESS_TOKEN_URL_PARAM_NAME = "access_token";
    private static final Set<String> DEPRECATED_SERIALIZED_FIELDS = Collections.unmodifiableSet(new HashSet<String>() { // from class: com.mapbox.api.directions.v5.models.RouteOptions.1
        {
            add(RouteOptions.ACCESS_TOKEN_URL_PARAM_NAME);
            add("uuid");
        }
    });
    private static final String UTF_8 = "UTF-8";

    @SerializedName("alley_bias")
    public abstract Double alleyBias();

    public abstract Boolean alternatives();

    public abstract String annotations();

    public abstract String approaches();

    @SerializedName("arrive_by")
    public abstract String arriveBy();

    @SerializedName("avoid_maneuver_radius")
    public abstract Double avoidManeuverRadius();

    @SerializedName("banner_instructions")
    public abstract Boolean bannerInstructions();

    public abstract String baseUrl();

    public abstract String bearings();

    @SerializedName("compute_toll_cost")
    public abstract Boolean computeTollCost();

    @SerializedName("continue_straight")
    public abstract Boolean continueStraight();

    public abstract String coordinates();

    @SerializedName("depart_at")
    public abstract String departAt();

    @SerializedName("enable_refresh")
    public abstract Boolean enableRefresh();

    public abstract String exclude();

    public abstract String geometries();

    public abstract String include();

    public abstract String language();

    public abstract String layers();

    @SerializedName("max_height")
    public abstract Double maxHeight();

    @SerializedName("max_weight")
    public abstract Double maxWeight();

    @SerializedName("max_width")
    public abstract Double maxWidth();

    @SerializedName(TtmlNode.TAG_METADATA)
    public abstract Boolean metadata();

    public abstract String overview();

    public abstract String profile();

    public abstract String radiuses();

    @SerializedName("roundabout_exits")
    public abstract Boolean roundaboutExits();

    @SerializedName("snapping_include_closures")
    public abstract String snappingIncludeClosures();

    @SerializedName("snapping_include_static_closures")
    public abstract String snappingIncludeStaticClosures();

    public abstract Boolean steps();

    public abstract Builder toBuilder();

    public abstract String user();

    @SerializedName("voice_instructions")
    public abstract Boolean voiceInstructions();

    @SerializedName("voice_units")
    public abstract String voiceUnits();

    @SerializedName("walking_speed")
    public abstract Double walkingSpeed();

    @SerializedName("walkway_bias")
    public abstract Double walkwayBias();

    @SerializedName("waypoints")
    public abstract String waypointIndices();

    @SerializedName("waypoint_names")
    public abstract String waypointNames();

    @SerializedName("waypoint_targets")
    public abstract String waypointTargets();

    public static Builder builder() {
        return new C$AutoValue_RouteOptions.Builder().baseUrl("https://api.mapbox.com").user("mapbox").geometries(DirectionsCriteria.GEOMETRY_POLYLINE6);
    }

    public List<Point> coordinatesList() {
        return ParseUtils.parseToPoints(coordinates());
    }

    public List<Double> radiusesList() {
        return ParseUtils.parseToDoubles(radiuses());
    }

    public List<Bearing> bearingsList() {
        return ParseUtils.parseBearings(bearings());
    }

    public List<Integer> layersList() {
        return ParseUtils.parseToIntegers(layers());
    }

    public List<String> annotationsList() {
        return ParseUtils.parseToStrings(annotations(), ",");
    }

    public List<String> excludeList() {
        return ParseUtils.parseToStrings(exclude(), ",");
    }

    public Exclude excludeObject() {
        return Exclude.fromUrlQueryParameter(exclude());
    }

    public List<String> includeList() {
        return ParseUtils.parseToStrings(include(), ",");
    }

    public List<String> approachesList() {
        return ParseUtils.parseToStrings(approaches());
    }

    public List<Integer> waypointIndicesList() {
        return ParseUtils.parseToIntegers(waypointIndices());
    }

    public List<String> waypointNamesList() {
        return ParseUtils.parseToStrings(waypointNames());
    }

    public List<Point> waypointTargetsList() {
        return ParseUtils.parseToPoints(waypointTargets());
    }

    public List<Boolean> snappingIncludeClosuresList() {
        return ParseUtils.parseToBooleans(snappingIncludeClosures());
    }

    public List<Boolean> snappingIncludeStaticClosuresList() {
        return ParseUtils.parseToBooleans(snappingIncludeStaticClosures());
    }

    public static TypeAdapter<RouteOptions> typeAdapter(Gson gson) {
        return new AutoValue_RouteOptions.GsonTypeAdapter(gson);
    }

    public static RouteOptions fromJson(String str) {
        return fromJsonString(str);
    }

    @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
    public String toJson() {
        return super.toJson();
    }

    public static RouteOptions fromUrl(URL url) {
        JsonObject jsonObject = new JsonObject();
        String str = url.getProtocol() + "://" + url.getHost();
        int port = url.getPort();
        if (port != -1) {
            str = str + ":" + port;
        }
        jsonObject.addProperty("baseUrl", str);
        try {
            String[] split = url.getPath().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
            jsonObject.addProperty("user", URLDecoder.decode(split[3], "UTF-8"));
            jsonObject.addProperty("profile", URLDecoder.decode(split[4], "UTF-8"));
            jsonObject.addProperty("coordinates", URLDecoder.decode(split[5], "UTF-8"));
            for (String str2 : url.getQuery().split("&")) {
                int indexOf = str2.indexOf("=");
                String decode = URLDecoder.decode(str2.substring(0, indexOf), "UTF-8");
                String decode2 = URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8");
                if (!decode.equals(ACCESS_TOKEN_URL_PARAM_NAME)) {
                    jsonObject.addProperty(decode, decode2);
                }
            }
            return fromJsonString(jsonObject.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public URL toUrl(String str) {
        StringBuilder append = new StringBuilder().append(baseUrl());
        if (!Character.valueOf(baseUrl().charAt(baseUrl().length() - 1)).equals('/')) {
            append.append('/');
        }
        append.append("directions/v5").append(String.format("/%s", user())).append(String.format("/%s", profile())).append(String.format("/%s", coordinates())).append(String.format("?%s=%s", ACCESS_TOKEN_URL_PARAM_NAME, str)).append(String.format("&geometries=%s", geometries()));
        appendQueryParameter(append, "alternatives", alternatives());
        appendQueryParameter(append, "overview", overview());
        appendQueryParameter(append, "radiuses", radiuses());
        appendQueryParameter(append, "steps", steps());
        appendQueryParameter(append, "avoid_maneuver_radius", avoidManeuverRadius());
        appendQueryParameter(append, "bearings", bearings());
        appendQueryParameter(append, RtspHeaders.Values.LAYERS, layers());
        appendQueryParameter(append, "continue_straight", continueStraight());
        appendQueryParameter(append, "annotations", annotations());
        appendQueryParameter(append, IjkMediaMeta.IJKM_KEY_LANGUAGE, language());
        appendQueryParameter(append, "roundabout_exits", roundaboutExits());
        appendQueryParameter(append, "voice_instructions", voiceInstructions());
        appendQueryParameter(append, "banner_instructions", bannerInstructions());
        appendQueryParameter(append, "voice_units", voiceUnits());
        appendQueryParameter(append, "exclude", exclude());
        appendQueryParameter(append, "include", include());
        appendQueryParameter(append, "approaches", approaches());
        appendQueryParameter(append, "waypoints", waypointIndices());
        appendQueryParameter(append, "waypoint_names", waypointNames());
        appendQueryParameter(append, "waypoint_targets", waypointTargets());
        appendQueryParameter(append, "enable_refresh", enableRefresh());
        appendQueryParameter(append, "walking_speed", walkingSpeed());
        appendQueryParameter(append, "walkway_bias", walkwayBias());
        appendQueryParameter(append, "alley_bias", alleyBias());
        appendQueryParameter(append, "snapping_include_closures", snappingIncludeClosures());
        appendQueryParameter(append, "snapping_include_static_closures", snappingIncludeStaticClosures());
        appendQueryParameter(append, "arrive_by", arriveBy());
        appendQueryParameter(append, "depart_at", departAt());
        appendQueryParameter(append, "max_height", maxHeight());
        appendQueryParameter(append, "max_width", maxWidth());
        appendQueryParameter(append, "max_weight", maxWeight());
        appendQueryParameter(append, "compute_toll_cost", computeTollCost());
        appendQueryParameter(append, TtmlNode.TAG_METADATA, metadata());
        Map<String, SerializableJsonElement> unrecognized = unrecognized();
        if (unrecognized != null) {
            for (Map.Entry<String, SerializableJsonElement> entry : unrecognized.entrySet()) {
                JsonElement element = entry.getValue().getElement();
                if (!DEPRECATED_SERIALIZED_FIELDS.contains(entry.getKey())) {
                    if (element.isJsonPrimitive()) {
                        appendQueryParameter(append, entry.getKey(), element.getAsString());
                    } else {
                        throw new IllegalStateException(String.format("RouteOptions.toUrl supports only primitive unrecognized properties. '%s' isn't a primitive value.", entry.getKey()));
                    }
                }
            }
        }
        try {
            return new URL(append.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendQueryParameter(StringBuilder sb, String str, Number number) {
        if (number != null) {
            appendQueryParameter(sb, str, String.valueOf(number));
        }
    }

    private static void appendQueryParameter(StringBuilder sb, String str, Boolean bool) {
        if (bool != null) {
            appendQueryParameter(sb, str, String.valueOf(bool));
        }
    }

    private static void appendQueryParameter(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append("&").append(str).append("=").append(escape(str2));
        }
    }

    private static String escape(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static RouteOptions fromJsonString(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (RouteOptions) gsonBuilder.create().fromJson(str, RouteOptions.class);
    }

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder alleyBias(Double d);

        public abstract Builder alternatives(Boolean bool);

        public abstract Builder annotations(String str);

        public abstract Builder approaches(String str);

        public abstract Builder arriveBy(String str);

        public abstract Builder avoidManeuverRadius(Double d);

        public abstract Builder bannerInstructions(Boolean bool);

        public abstract Builder baseUrl(String str);

        public abstract Builder bearings(String str);

        public abstract RouteOptions build();

        public abstract Builder computeTollCost(Boolean bool);

        public abstract Builder continueStraight(Boolean bool);

        public abstract Builder coordinates(String str);

        public abstract Builder departAt(String str);

        public abstract Builder enableRefresh(Boolean bool);

        public abstract Builder exclude(String str);

        public abstract Builder geometries(String str);

        public abstract Builder include(String str);

        public abstract Builder language(String str);

        public abstract Builder layers(String str);

        public abstract Builder maxHeight(Double d);

        public abstract Builder maxWeight(Double d);

        public abstract Builder maxWidth(Double d);

        public abstract Builder metadata(Boolean bool);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        public abstract Builder radiuses(String str);

        public abstract Builder roundaboutExits(Boolean bool);

        public abstract Builder snappingIncludeClosures(String str);

        public abstract Builder snappingIncludeStaticClosures(String str);

        public abstract Builder steps(Boolean bool);

        public abstract Builder user(String str);

        public abstract Builder voiceInstructions(Boolean bool);

        public abstract Builder voiceUnits(String str);

        public abstract Builder walkingSpeed(Double d);

        public abstract Builder walkwayBias(Double d);

        public abstract Builder waypointIndices(String str);

        public abstract Builder waypointNames(String str);

        public abstract Builder waypointTargets(String str);

        public Builder coordinatesList(List<Point> list) {
            String formatPointsList = FormatUtils.formatPointsList(list);
            if (formatPointsList == null) {
                formatPointsList = "";
            }
            coordinates(formatPointsList);
            return this;
        }

        public Builder radiusesList(List<Double> list) {
            radiuses(FormatUtils.formatRadiuses(list));
            return this;
        }

        public Builder bearingsList(List<Bearing> list) {
            bearings(FormatUtils.formatBearings(list));
            return this;
        }

        public Builder layersList(List<Integer> list) {
            layers(FormatUtils.formatIntegers(list));
            return this;
        }

        public Builder annotationsList(List<String> list) {
            annotations(FormatUtils.join(",", list));
            return this;
        }

        public Builder excludeList(List<String> list) {
            exclude(FormatUtils.join(",", list));
            return this;
        }

        public Builder excludeObject(Exclude exclude) {
            if (exclude != null) {
                exclude(exclude.toUrlQueryParameter());
            } else {
                exclude(null);
            }
            return this;
        }

        public Builder includeList(List<String> list) {
            include(FormatUtils.join(",", list));
            return this;
        }

        public Builder approachesList(List<String> list) {
            approaches(FormatUtils.join(";", list));
            return this;
        }

        public Builder waypointIndicesList(List<Integer> list) {
            waypointIndices(FormatUtils.join(";", list));
            return this;
        }

        public Builder waypointNamesList(List<String> list) {
            waypointNames(FormatUtils.join(";", list));
            return this;
        }

        public Builder waypointTargetsList(List<Point> list) {
            waypointTargets(FormatUtils.formatPointsList(list));
            return this;
        }

        public Builder snappingIncludeClosuresList(List<Boolean> list) {
            snappingIncludeClosures(FormatUtils.join(";", list));
            return this;
        }

        public Builder snappingIncludeStaticClosuresList(List<Boolean> list) {
            snappingIncludeStaticClosures(FormatUtils.join(";", list));
            return this;
        }

        public Builder unrecognizedProperties(Map<String, String> map) {
            if (map != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), new SerializableJsonElement(new JsonPrimitive(entry.getValue())));
                }
                return (Builder) unrecognized(linkedHashMap);
            }
            return (Builder) unrecognized(null);
        }
    }
}
