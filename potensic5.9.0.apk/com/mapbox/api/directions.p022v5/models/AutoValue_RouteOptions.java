package com.mapbox.api.directions.p022v5.models;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.RouteOptions;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
final class AutoValue_RouteOptions extends C$AutoValue_RouteOptions {
    AutoValue_RouteOptions(final Map<String, SerializableJsonElement> map, final String str, final String str2, final String str3, final String str4, final Boolean bool, final String str5, final String str6, final String str7, final Double d, final String str8, final Boolean bool2, final Boolean bool3, final String str9, final String str10, final Boolean bool4, final String str11, final String str12, final String str13, final Boolean bool5, final Boolean bool6, final String str14, final String str15, final String str16, final String str17, final String str18, final Double d2, final Double d3, final Double d4, final String str19, final String str20, final String str21, final String str22, final Double d5, final Double d6, final Double d7, final Boolean bool7, final Boolean bool8, final Boolean bool9) {
        new RouteOptions(map, str, str2, str3, str4, bool, str5, str6, str7, d, str8, bool2, bool3, str9, str10, bool4, str11, str12, str13, bool5, bool6, str14, str15, str16, str17, str18, d2, d3, d4, str19, str20, str21, str22, d5, d6, d7, bool7, bool8, bool9) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_RouteOptions
            private final Double alleyBias;
            private final Boolean alternatives;
            private final String annotations;
            private final String approaches;
            private final String arriveBy;
            private final Double avoidManeuverRadius;
            private final Boolean bannerInstructions;
            private final String baseUrl;
            private final String bearings;
            private final Boolean computeTollCost;
            private final Boolean continueStraight;
            private final String coordinates;
            private final String departAt;
            private final Boolean enableRefresh;
            private final String exclude;
            private final String geometries;
            private final String include;
            private final String language;
            private final String layers;
            private final Double maxHeight;
            private final Double maxWeight;
            private final Double maxWidth;
            private final Boolean metadata;
            private final String overview;
            private final String profile;
            private final String radiuses;
            private final Boolean roundaboutExits;
            private final String snappingIncludeClosures;
            private final String snappingIncludeStaticClosures;
            private final Boolean steps;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final String user;
            private final Boolean voiceInstructions;
            private final String voiceUnits;
            private final Double walkingSpeed;
            private final Double walkwayBias;
            private final String waypointIndices;
            private final String waypointNames;
            private final String waypointTargets;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null baseUrl");
                this.baseUrl = str;
                Objects.requireNonNull(str2, "Null user");
                this.user = str2;
                Objects.requireNonNull(str3, "Null profile");
                this.profile = str3;
                Objects.requireNonNull(str4, "Null coordinates");
                this.coordinates = str4;
                this.alternatives = bool;
                this.language = str5;
                this.radiuses = str6;
                this.bearings = str7;
                this.avoidManeuverRadius = d;
                this.layers = str8;
                this.continueStraight = bool2;
                this.roundaboutExits = bool3;
                Objects.requireNonNull(str9, "Null geometries");
                this.geometries = str9;
                this.overview = str10;
                this.steps = bool4;
                this.annotations = str11;
                this.exclude = str12;
                this.include = str13;
                this.voiceInstructions = bool5;
                this.bannerInstructions = bool6;
                this.voiceUnits = str14;
                this.approaches = str15;
                this.waypointIndices = str16;
                this.waypointNames = str17;
                this.waypointTargets = str18;
                this.alleyBias = d2;
                this.walkingSpeed = d3;
                this.walkwayBias = d4;
                this.snappingIncludeClosures = str19;
                this.snappingIncludeStaticClosures = str20;
                this.arriveBy = str21;
                this.departAt = str22;
                this.maxHeight = d5;
                this.maxWidth = d6;
                this.maxWeight = d7;
                this.enableRefresh = bool7;
                this.computeTollCost = bool8;
                this.metadata = bool9;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String baseUrl() {
                return this.baseUrl;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String user() {
                return this.user;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String profile() {
                return this.profile;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String coordinates() {
                return this.coordinates;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public Boolean alternatives() {
                return this.alternatives;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String language() {
                return this.language;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String radiuses() {
                return this.radiuses;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String bearings() {
                return this.bearings;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("avoid_maneuver_radius")
            public Double avoidManeuverRadius() {
                return this.avoidManeuverRadius;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String layers() {
                return this.layers;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("continue_straight")
            public Boolean continueStraight() {
                return this.continueStraight;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("roundabout_exits")
            public Boolean roundaboutExits() {
                return this.roundaboutExits;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String geometries() {
                return this.geometries;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String overview() {
                return this.overview;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public Boolean steps() {
                return this.steps;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String annotations() {
                return this.annotations;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String exclude() {
                return this.exclude;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String include() {
                return this.include;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("voice_instructions")
            public Boolean voiceInstructions() {
                return this.voiceInstructions;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("banner_instructions")
            public Boolean bannerInstructions() {
                return this.bannerInstructions;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("voice_units")
            public String voiceUnits() {
                return this.voiceUnits;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public String approaches() {
                return this.approaches;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("waypoints")
            public String waypointIndices() {
                return this.waypointIndices;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("waypoint_names")
            public String waypointNames() {
                return this.waypointNames;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("waypoint_targets")
            public String waypointTargets() {
                return this.waypointTargets;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("alley_bias")
            public Double alleyBias() {
                return this.alleyBias;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("walking_speed")
            public Double walkingSpeed() {
                return this.walkingSpeed;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("walkway_bias")
            public Double walkwayBias() {
                return this.walkwayBias;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("snapping_include_closures")
            public String snappingIncludeClosures() {
                return this.snappingIncludeClosures;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("snapping_include_static_closures")
            public String snappingIncludeStaticClosures() {
                return this.snappingIncludeStaticClosures;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("arrive_by")
            public String arriveBy() {
                return this.arriveBy;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("depart_at")
            public String departAt() {
                return this.departAt;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("max_height")
            public Double maxHeight() {
                return this.maxHeight;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("max_width")
            public Double maxWidth() {
                return this.maxWidth;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("max_weight")
            public Double maxWeight() {
                return this.maxWeight;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("enable_refresh")
            public Boolean enableRefresh() {
                return this.enableRefresh;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName("compute_toll_cost")
            public Boolean computeTollCost() {
                return this.computeTollCost;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            @SerializedName(TtmlNode.TAG_METADATA)
            public Boolean metadata() {
                return this.metadata;
            }

            public String toString() {
                return "RouteOptions{unrecognized=" + this.unrecognized + ", baseUrl=" + this.baseUrl + ", user=" + this.user + ", profile=" + this.profile + ", coordinates=" + this.coordinates + ", alternatives=" + this.alternatives + ", language=" + this.language + ", radiuses=" + this.radiuses + ", bearings=" + this.bearings + ", avoidManeuverRadius=" + this.avoidManeuverRadius + ", layers=" + this.layers + ", continueStraight=" + this.continueStraight + ", roundaboutExits=" + this.roundaboutExits + ", geometries=" + this.geometries + ", overview=" + this.overview + ", steps=" + this.steps + ", annotations=" + this.annotations + ", exclude=" + this.exclude + ", include=" + this.include + ", voiceInstructions=" + this.voiceInstructions + ", bannerInstructions=" + this.bannerInstructions + ", voiceUnits=" + this.voiceUnits + ", approaches=" + this.approaches + ", waypointIndices=" + this.waypointIndices + ", waypointNames=" + this.waypointNames + ", waypointTargets=" + this.waypointTargets + ", alleyBias=" + this.alleyBias + ", walkingSpeed=" + this.walkingSpeed + ", walkwayBias=" + this.walkwayBias + ", snappingIncludeClosures=" + this.snappingIncludeClosures + ", snappingIncludeStaticClosures=" + this.snappingIncludeStaticClosures + ", arriveBy=" + this.arriveBy + ", departAt=" + this.departAt + ", maxHeight=" + this.maxHeight + ", maxWidth=" + this.maxWidth + ", maxWeight=" + this.maxWeight + ", enableRefresh=" + this.enableRefresh + ", computeTollCost=" + this.computeTollCost + ", metadata=" + this.metadata + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                Boolean bool10;
                String str23;
                String str24;
                String str25;
                Double d8;
                String str26;
                Boolean bool11;
                Boolean bool12;
                String str27;
                Boolean bool13;
                String str28;
                String str29;
                String str30;
                Boolean bool14;
                Boolean bool15;
                String str31;
                String str32;
                String str33;
                String str34;
                String str35;
                Double d9;
                Double d10;
                Double d11;
                String str36;
                String str37;
                String str38;
                String str39;
                Double d12;
                Double d13;
                Double d14;
                Boolean bool16;
                Boolean bool17;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RouteOptions)) {
                    return false;
                }
                RouteOptions routeOptions = (RouteOptions) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(routeOptions.unrecognized()) : routeOptions.unrecognized() == null) {
                    if (this.baseUrl.equals(routeOptions.baseUrl()) && this.user.equals(routeOptions.user()) && this.profile.equals(routeOptions.profile()) && this.coordinates.equals(routeOptions.coordinates()) && ((bool10 = this.alternatives) != null ? bool10.equals(routeOptions.alternatives()) : routeOptions.alternatives() == null) && ((str23 = this.language) != null ? str23.equals(routeOptions.language()) : routeOptions.language() == null) && ((str24 = this.radiuses) != null ? str24.equals(routeOptions.radiuses()) : routeOptions.radiuses() == null) && ((str25 = this.bearings) != null ? str25.equals(routeOptions.bearings()) : routeOptions.bearings() == null) && ((d8 = this.avoidManeuverRadius) != null ? d8.equals(routeOptions.avoidManeuverRadius()) : routeOptions.avoidManeuverRadius() == null) && ((str26 = this.layers) != null ? str26.equals(routeOptions.layers()) : routeOptions.layers() == null) && ((bool11 = this.continueStraight) != null ? bool11.equals(routeOptions.continueStraight()) : routeOptions.continueStraight() == null) && ((bool12 = this.roundaboutExits) != null ? bool12.equals(routeOptions.roundaboutExits()) : routeOptions.roundaboutExits() == null) && this.geometries.equals(routeOptions.geometries()) && ((str27 = this.overview) != null ? str27.equals(routeOptions.overview()) : routeOptions.overview() == null) && ((bool13 = this.steps) != null ? bool13.equals(routeOptions.steps()) : routeOptions.steps() == null) && ((str28 = this.annotations) != null ? str28.equals(routeOptions.annotations()) : routeOptions.annotations() == null) && ((str29 = this.exclude) != null ? str29.equals(routeOptions.exclude()) : routeOptions.exclude() == null) && ((str30 = this.include) != null ? str30.equals(routeOptions.include()) : routeOptions.include() == null) && ((bool14 = this.voiceInstructions) != null ? bool14.equals(routeOptions.voiceInstructions()) : routeOptions.voiceInstructions() == null) && ((bool15 = this.bannerInstructions) != null ? bool15.equals(routeOptions.bannerInstructions()) : routeOptions.bannerInstructions() == null) && ((str31 = this.voiceUnits) != null ? str31.equals(routeOptions.voiceUnits()) : routeOptions.voiceUnits() == null) && ((str32 = this.approaches) != null ? str32.equals(routeOptions.approaches()) : routeOptions.approaches() == null) && ((str33 = this.waypointIndices) != null ? str33.equals(routeOptions.waypointIndices()) : routeOptions.waypointIndices() == null) && ((str34 = this.waypointNames) != null ? str34.equals(routeOptions.waypointNames()) : routeOptions.waypointNames() == null) && ((str35 = this.waypointTargets) != null ? str35.equals(routeOptions.waypointTargets()) : routeOptions.waypointTargets() == null) && ((d9 = this.alleyBias) != null ? d9.equals(routeOptions.alleyBias()) : routeOptions.alleyBias() == null) && ((d10 = this.walkingSpeed) != null ? d10.equals(routeOptions.walkingSpeed()) : routeOptions.walkingSpeed() == null) && ((d11 = this.walkwayBias) != null ? d11.equals(routeOptions.walkwayBias()) : routeOptions.walkwayBias() == null) && ((str36 = this.snappingIncludeClosures) != null ? str36.equals(routeOptions.snappingIncludeClosures()) : routeOptions.snappingIncludeClosures() == null) && ((str37 = this.snappingIncludeStaticClosures) != null ? str37.equals(routeOptions.snappingIncludeStaticClosures()) : routeOptions.snappingIncludeStaticClosures() == null) && ((str38 = this.arriveBy) != null ? str38.equals(routeOptions.arriveBy()) : routeOptions.arriveBy() == null) && ((str39 = this.departAt) != null ? str39.equals(routeOptions.departAt()) : routeOptions.departAt() == null) && ((d12 = this.maxHeight) != null ? d12.equals(routeOptions.maxHeight()) : routeOptions.maxHeight() == null) && ((d13 = this.maxWidth) != null ? d13.equals(routeOptions.maxWidth()) : routeOptions.maxWidth() == null) && ((d14 = this.maxWeight) != null ? d14.equals(routeOptions.maxWeight()) : routeOptions.maxWeight() == null) && ((bool16 = this.enableRefresh) != null ? bool16.equals(routeOptions.enableRefresh()) : routeOptions.enableRefresh() == null) && ((bool17 = this.computeTollCost) != null ? bool17.equals(routeOptions.computeTollCost()) : routeOptions.computeTollCost() == null)) {
                        Boolean bool18 = this.metadata;
                        if (bool18 == null) {
                            if (routeOptions.metadata() == null) {
                                return true;
                            }
                        } else if (bool18.equals(routeOptions.metadata())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.baseUrl.hashCode()) * 1000003) ^ this.user.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.coordinates.hashCode()) * 1000003;
                Boolean bool10 = this.alternatives;
                int hashCode2 = (hashCode ^ (bool10 == null ? 0 : bool10.hashCode())) * 1000003;
                String str23 = this.language;
                int hashCode3 = (hashCode2 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
                String str24 = this.radiuses;
                int hashCode4 = (hashCode3 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
                String str25 = this.bearings;
                int hashCode5 = (hashCode4 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
                Double d8 = this.avoidManeuverRadius;
                int hashCode6 = (hashCode5 ^ (d8 == null ? 0 : d8.hashCode())) * 1000003;
                String str26 = this.layers;
                int hashCode7 = (hashCode6 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
                Boolean bool11 = this.continueStraight;
                int hashCode8 = (hashCode7 ^ (bool11 == null ? 0 : bool11.hashCode())) * 1000003;
                Boolean bool12 = this.roundaboutExits;
                int hashCode9 = (((hashCode8 ^ (bool12 == null ? 0 : bool12.hashCode())) * 1000003) ^ this.geometries.hashCode()) * 1000003;
                String str27 = this.overview;
                int hashCode10 = (hashCode9 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003;
                Boolean bool13 = this.steps;
                int hashCode11 = (hashCode10 ^ (bool13 == null ? 0 : bool13.hashCode())) * 1000003;
                String str28 = this.annotations;
                int hashCode12 = (hashCode11 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
                String str29 = this.exclude;
                int hashCode13 = (hashCode12 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
                String str30 = this.include;
                int hashCode14 = (hashCode13 ^ (str30 == null ? 0 : str30.hashCode())) * 1000003;
                Boolean bool14 = this.voiceInstructions;
                int hashCode15 = (hashCode14 ^ (bool14 == null ? 0 : bool14.hashCode())) * 1000003;
                Boolean bool15 = this.bannerInstructions;
                int hashCode16 = (hashCode15 ^ (bool15 == null ? 0 : bool15.hashCode())) * 1000003;
                String str31 = this.voiceUnits;
                int hashCode17 = (hashCode16 ^ (str31 == null ? 0 : str31.hashCode())) * 1000003;
                String str32 = this.approaches;
                int hashCode18 = (hashCode17 ^ (str32 == null ? 0 : str32.hashCode())) * 1000003;
                String str33 = this.waypointIndices;
                int hashCode19 = (hashCode18 ^ (str33 == null ? 0 : str33.hashCode())) * 1000003;
                String str34 = this.waypointNames;
                int hashCode20 = (hashCode19 ^ (str34 == null ? 0 : str34.hashCode())) * 1000003;
                String str35 = this.waypointTargets;
                int hashCode21 = (hashCode20 ^ (str35 == null ? 0 : str35.hashCode())) * 1000003;
                Double d9 = this.alleyBias;
                int hashCode22 = (hashCode21 ^ (d9 == null ? 0 : d9.hashCode())) * 1000003;
                Double d10 = this.walkingSpeed;
                int hashCode23 = (hashCode22 ^ (d10 == null ? 0 : d10.hashCode())) * 1000003;
                Double d11 = this.walkwayBias;
                int hashCode24 = (hashCode23 ^ (d11 == null ? 0 : d11.hashCode())) * 1000003;
                String str36 = this.snappingIncludeClosures;
                int hashCode25 = (hashCode24 ^ (str36 == null ? 0 : str36.hashCode())) * 1000003;
                String str37 = this.snappingIncludeStaticClosures;
                int hashCode26 = (hashCode25 ^ (str37 == null ? 0 : str37.hashCode())) * 1000003;
                String str38 = this.arriveBy;
                int hashCode27 = (hashCode26 ^ (str38 == null ? 0 : str38.hashCode())) * 1000003;
                String str39 = this.departAt;
                int hashCode28 = (hashCode27 ^ (str39 == null ? 0 : str39.hashCode())) * 1000003;
                Double d12 = this.maxHeight;
                int hashCode29 = (hashCode28 ^ (d12 == null ? 0 : d12.hashCode())) * 1000003;
                Double d13 = this.maxWidth;
                int hashCode30 = (hashCode29 ^ (d13 == null ? 0 : d13.hashCode())) * 1000003;
                Double d14 = this.maxWeight;
                int hashCode31 = (hashCode30 ^ (d14 == null ? 0 : d14.hashCode())) * 1000003;
                Boolean bool16 = this.enableRefresh;
                int hashCode32 = (hashCode31 ^ (bool16 == null ? 0 : bool16.hashCode())) * 1000003;
                Boolean bool17 = this.computeTollCost;
                int hashCode33 = (hashCode32 ^ (bool17 == null ? 0 : bool17.hashCode())) * 1000003;
                Boolean bool18 = this.metadata;
                return hashCode33 ^ (bool18 != null ? bool18.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteOptions
            public RouteOptions.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_RouteOptions$Builder */
            static class Builder extends RouteOptions.Builder {
                private Double alleyBias;
                private Boolean alternatives;
                private String annotations;
                private String approaches;
                private String arriveBy;
                private Double avoidManeuverRadius;
                private Boolean bannerInstructions;
                private String baseUrl;
                private String bearings;
                private Boolean computeTollCost;
                private Boolean continueStraight;
                private String coordinates;
                private String departAt;
                private Boolean enableRefresh;
                private String exclude;
                private String geometries;
                private String include;
                private String language;
                private String layers;
                private Double maxHeight;
                private Double maxWeight;
                private Double maxWidth;
                private Boolean metadata;
                private String overview;
                private String profile;
                private String radiuses;
                private Boolean roundaboutExits;
                private String snappingIncludeClosures;
                private String snappingIncludeStaticClosures;
                private Boolean steps;
                private Map<String, SerializableJsonElement> unrecognized;
                private String user;
                private Boolean voiceInstructions;
                private String voiceUnits;
                private Double walkingSpeed;
                private Double walkwayBias;
                private String waypointIndices;
                private String waypointNames;
                private String waypointTargets;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ RouteOptions.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(RouteOptions routeOptions) {
                    this.unrecognized = routeOptions.unrecognized();
                    this.baseUrl = routeOptions.baseUrl();
                    this.user = routeOptions.user();
                    this.profile = routeOptions.profile();
                    this.coordinates = routeOptions.coordinates();
                    this.alternatives = routeOptions.alternatives();
                    this.language = routeOptions.language();
                    this.radiuses = routeOptions.radiuses();
                    this.bearings = routeOptions.bearings();
                    this.avoidManeuverRadius = routeOptions.avoidManeuverRadius();
                    this.layers = routeOptions.layers();
                    this.continueStraight = routeOptions.continueStraight();
                    this.roundaboutExits = routeOptions.roundaboutExits();
                    this.geometries = routeOptions.geometries();
                    this.overview = routeOptions.overview();
                    this.steps = routeOptions.steps();
                    this.annotations = routeOptions.annotations();
                    this.exclude = routeOptions.exclude();
                    this.include = routeOptions.include();
                    this.voiceInstructions = routeOptions.voiceInstructions();
                    this.bannerInstructions = routeOptions.bannerInstructions();
                    this.voiceUnits = routeOptions.voiceUnits();
                    this.approaches = routeOptions.approaches();
                    this.waypointIndices = routeOptions.waypointIndices();
                    this.waypointNames = routeOptions.waypointNames();
                    this.waypointTargets = routeOptions.waypointTargets();
                    this.alleyBias = routeOptions.alleyBias();
                    this.walkingSpeed = routeOptions.walkingSpeed();
                    this.walkwayBias = routeOptions.walkwayBias();
                    this.snappingIncludeClosures = routeOptions.snappingIncludeClosures();
                    this.snappingIncludeStaticClosures = routeOptions.snappingIncludeStaticClosures();
                    this.arriveBy = routeOptions.arriveBy();
                    this.departAt = routeOptions.departAt();
                    this.maxHeight = routeOptions.maxHeight();
                    this.maxWidth = routeOptions.maxWidth();
                    this.maxWeight = routeOptions.maxWeight();
                    this.enableRefresh = routeOptions.enableRefresh();
                    this.computeTollCost = routeOptions.computeTollCost();
                    this.metadata = routeOptions.metadata();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                RouteOptions.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder baseUrl(String str) {
                    Objects.requireNonNull(str, "Null baseUrl");
                    this.baseUrl = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder user(String str) {
                    Objects.requireNonNull(str, "Null user");
                    this.user = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder profile(String str) {
                    Objects.requireNonNull(str, "Null profile");
                    this.profile = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder coordinates(String str) {
                    Objects.requireNonNull(str, "Null coordinates");
                    this.coordinates = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder alternatives(Boolean bool) {
                    this.alternatives = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder language(String str) {
                    this.language = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder radiuses(String str) {
                    this.radiuses = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder bearings(String str) {
                    this.bearings = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder avoidManeuverRadius(Double d) {
                    this.avoidManeuverRadius = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder layers(String str) {
                    this.layers = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder continueStraight(Boolean bool) {
                    this.continueStraight = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder roundaboutExits(Boolean bool) {
                    this.roundaboutExits = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder geometries(String str) {
                    Objects.requireNonNull(str, "Null geometries");
                    this.geometries = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder overview(String str) {
                    this.overview = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder steps(Boolean bool) {
                    this.steps = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder annotations(String str) {
                    this.annotations = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder exclude(String str) {
                    this.exclude = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder include(String str) {
                    this.include = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder voiceInstructions(Boolean bool) {
                    this.voiceInstructions = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder bannerInstructions(Boolean bool) {
                    this.bannerInstructions = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder voiceUnits(String str) {
                    this.voiceUnits = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder approaches(String str) {
                    this.approaches = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder waypointIndices(String str) {
                    this.waypointIndices = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder waypointNames(String str) {
                    this.waypointNames = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder waypointTargets(String str) {
                    this.waypointTargets = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder alleyBias(Double d) {
                    this.alleyBias = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder walkingSpeed(Double d) {
                    this.walkingSpeed = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder walkwayBias(Double d) {
                    this.walkwayBias = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder snappingIncludeClosures(String str) {
                    this.snappingIncludeClosures = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder snappingIncludeStaticClosures(String str) {
                    this.snappingIncludeStaticClosures = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder arriveBy(String str) {
                    this.arriveBy = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder departAt(String str) {
                    this.departAt = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder maxHeight(Double d) {
                    this.maxHeight = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder maxWidth(Double d) {
                    this.maxWidth = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder maxWeight(Double d) {
                    this.maxWeight = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder enableRefresh(Boolean bool) {
                    this.enableRefresh = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder computeTollCost(Boolean bool) {
                    this.computeTollCost = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions.Builder metadata(Boolean bool) {
                    this.metadata = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteOptions.Builder
                public RouteOptions build() {
                    String str = this.baseUrl == null ? " baseUrl" : "";
                    if (this.user == null) {
                        str = str + " user";
                    }
                    if (this.profile == null) {
                        str = str + " profile";
                    }
                    if (this.coordinates == null) {
                        str = str + " coordinates";
                    }
                    if (this.geometries == null) {
                        str = str + " geometries";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_RouteOptions(this.unrecognized, this.baseUrl, this.user, this.profile, this.coordinates, this.alternatives, this.language, this.radiuses, this.bearings, this.avoidManeuverRadius, this.layers, this.continueStraight, this.roundaboutExits, this.geometries, this.overview, this.steps, this.annotations, this.exclude, this.include, this.voiceInstructions, this.bannerInstructions, this.voiceUnits, this.approaches, this.waypointIndices, this.waypointNames, this.waypointTargets, this.alleyBias, this.walkingSpeed, this.walkwayBias, this.snappingIncludeClosures, this.snappingIncludeStaticClosures, this.arriveBy, this.departAt, this.maxHeight, this.maxWidth, this.maxWeight, this.enableRefresh, this.computeTollCost, this.metadata);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteOptions> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteOptions routeOptions) throws IOException {
            if (routeOptions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (routeOptions.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : routeOptions.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("baseUrl");
            if (routeOptions.baseUrl() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, routeOptions.baseUrl());
            }
            jsonWriter.name("user");
            if (routeOptions.user() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, routeOptions.user());
            }
            jsonWriter.name("profile");
            if (routeOptions.profile() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, routeOptions.profile());
            }
            jsonWriter.name("coordinates");
            if (routeOptions.coordinates() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, routeOptions.coordinates());
            }
            jsonWriter.name("alternatives");
            if (routeOptions.alternatives() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter5 = this.boolean__adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, routeOptions.alternatives());
            }
            jsonWriter.name(IjkMediaMeta.IJKM_KEY_LANGUAGE);
            if (routeOptions.language() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, routeOptions.language());
            }
            jsonWriter.name("radiuses");
            if (routeOptions.radiuses() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, routeOptions.radiuses());
            }
            jsonWriter.name("bearings");
            if (routeOptions.bearings() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, routeOptions.bearings());
            }
            jsonWriter.name("avoid_maneuver_radius");
            if (routeOptions.avoidManeuverRadius() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter9 = this.double__adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, routeOptions.avoidManeuverRadius());
            }
            jsonWriter.name(RtspHeaders.Values.LAYERS);
            if (routeOptions.layers() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter10 = this.string_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, routeOptions.layers());
            }
            jsonWriter.name("continue_straight");
            if (routeOptions.continueStraight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter11 = this.boolean__adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, routeOptions.continueStraight());
            }
            jsonWriter.name("roundabout_exits");
            if (routeOptions.roundaboutExits() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter12 = this.boolean__adapter;
                if (typeAdapter12 == null) {
                    typeAdapter12 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter12;
                }
                typeAdapter12.write(jsonWriter, routeOptions.roundaboutExits());
            }
            jsonWriter.name("geometries");
            if (routeOptions.geometries() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter13 = this.string_adapter;
                if (typeAdapter13 == null) {
                    typeAdapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter13;
                }
                typeAdapter13.write(jsonWriter, routeOptions.geometries());
            }
            jsonWriter.name("overview");
            if (routeOptions.overview() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter14 = this.string_adapter;
                if (typeAdapter14 == null) {
                    typeAdapter14 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter14;
                }
                typeAdapter14.write(jsonWriter, routeOptions.overview());
            }
            jsonWriter.name("steps");
            if (routeOptions.steps() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter15 = this.boolean__adapter;
                if (typeAdapter15 == null) {
                    typeAdapter15 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter15;
                }
                typeAdapter15.write(jsonWriter, routeOptions.steps());
            }
            jsonWriter.name("annotations");
            if (routeOptions.annotations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter16 = this.string_adapter;
                if (typeAdapter16 == null) {
                    typeAdapter16 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter16;
                }
                typeAdapter16.write(jsonWriter, routeOptions.annotations());
            }
            jsonWriter.name("exclude");
            if (routeOptions.exclude() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter17 = this.string_adapter;
                if (typeAdapter17 == null) {
                    typeAdapter17 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter17;
                }
                typeAdapter17.write(jsonWriter, routeOptions.exclude());
            }
            jsonWriter.name("include");
            if (routeOptions.include() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter18 = this.string_adapter;
                if (typeAdapter18 == null) {
                    typeAdapter18 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter18;
                }
                typeAdapter18.write(jsonWriter, routeOptions.include());
            }
            jsonWriter.name("voice_instructions");
            if (routeOptions.voiceInstructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter19 = this.boolean__adapter;
                if (typeAdapter19 == null) {
                    typeAdapter19 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter19;
                }
                typeAdapter19.write(jsonWriter, routeOptions.voiceInstructions());
            }
            jsonWriter.name("banner_instructions");
            if (routeOptions.bannerInstructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter20 = this.boolean__adapter;
                if (typeAdapter20 == null) {
                    typeAdapter20 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter20;
                }
                typeAdapter20.write(jsonWriter, routeOptions.bannerInstructions());
            }
            jsonWriter.name("voice_units");
            if (routeOptions.voiceUnits() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter21 = this.string_adapter;
                if (typeAdapter21 == null) {
                    typeAdapter21 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter21;
                }
                typeAdapter21.write(jsonWriter, routeOptions.voiceUnits());
            }
            jsonWriter.name("approaches");
            if (routeOptions.approaches() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter22 = this.string_adapter;
                if (typeAdapter22 == null) {
                    typeAdapter22 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter22;
                }
                typeAdapter22.write(jsonWriter, routeOptions.approaches());
            }
            jsonWriter.name("waypoints");
            if (routeOptions.waypointIndices() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter23 = this.string_adapter;
                if (typeAdapter23 == null) {
                    typeAdapter23 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter23;
                }
                typeAdapter23.write(jsonWriter, routeOptions.waypointIndices());
            }
            jsonWriter.name("waypoint_names");
            if (routeOptions.waypointNames() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter24 = this.string_adapter;
                if (typeAdapter24 == null) {
                    typeAdapter24 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter24;
                }
                typeAdapter24.write(jsonWriter, routeOptions.waypointNames());
            }
            jsonWriter.name("waypoint_targets");
            if (routeOptions.waypointTargets() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter25 = this.string_adapter;
                if (typeAdapter25 == null) {
                    typeAdapter25 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter25;
                }
                typeAdapter25.write(jsonWriter, routeOptions.waypointTargets());
            }
            jsonWriter.name("alley_bias");
            if (routeOptions.alleyBias() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter26 = this.double__adapter;
                if (typeAdapter26 == null) {
                    typeAdapter26 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter26;
                }
                typeAdapter26.write(jsonWriter, routeOptions.alleyBias());
            }
            jsonWriter.name("walking_speed");
            if (routeOptions.walkingSpeed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter27 = this.double__adapter;
                if (typeAdapter27 == null) {
                    typeAdapter27 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter27;
                }
                typeAdapter27.write(jsonWriter, routeOptions.walkingSpeed());
            }
            jsonWriter.name("walkway_bias");
            if (routeOptions.walkwayBias() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter28 = this.double__adapter;
                if (typeAdapter28 == null) {
                    typeAdapter28 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter28;
                }
                typeAdapter28.write(jsonWriter, routeOptions.walkwayBias());
            }
            jsonWriter.name("snapping_include_closures");
            if (routeOptions.snappingIncludeClosures() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter29 = this.string_adapter;
                if (typeAdapter29 == null) {
                    typeAdapter29 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter29;
                }
                typeAdapter29.write(jsonWriter, routeOptions.snappingIncludeClosures());
            }
            jsonWriter.name("snapping_include_static_closures");
            if (routeOptions.snappingIncludeStaticClosures() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter30 = this.string_adapter;
                if (typeAdapter30 == null) {
                    typeAdapter30 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter30;
                }
                typeAdapter30.write(jsonWriter, routeOptions.snappingIncludeStaticClosures());
            }
            jsonWriter.name("arrive_by");
            if (routeOptions.arriveBy() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter31 = this.string_adapter;
                if (typeAdapter31 == null) {
                    typeAdapter31 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter31;
                }
                typeAdapter31.write(jsonWriter, routeOptions.arriveBy());
            }
            jsonWriter.name("depart_at");
            if (routeOptions.departAt() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter32 = this.string_adapter;
                if (typeAdapter32 == null) {
                    typeAdapter32 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter32;
                }
                typeAdapter32.write(jsonWriter, routeOptions.departAt());
            }
            jsonWriter.name("max_height");
            if (routeOptions.maxHeight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter33 = this.double__adapter;
                if (typeAdapter33 == null) {
                    typeAdapter33 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter33;
                }
                typeAdapter33.write(jsonWriter, routeOptions.maxHeight());
            }
            jsonWriter.name("max_width");
            if (routeOptions.maxWidth() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter34 = this.double__adapter;
                if (typeAdapter34 == null) {
                    typeAdapter34 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter34;
                }
                typeAdapter34.write(jsonWriter, routeOptions.maxWidth());
            }
            jsonWriter.name("max_weight");
            if (routeOptions.maxWeight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter35 = this.double__adapter;
                if (typeAdapter35 == null) {
                    typeAdapter35 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter35;
                }
                typeAdapter35.write(jsonWriter, routeOptions.maxWeight());
            }
            jsonWriter.name("enable_refresh");
            if (routeOptions.enableRefresh() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter36 = this.boolean__adapter;
                if (typeAdapter36 == null) {
                    typeAdapter36 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter36;
                }
                typeAdapter36.write(jsonWriter, routeOptions.enableRefresh());
            }
            jsonWriter.name("compute_toll_cost");
            if (routeOptions.computeTollCost() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter37 = this.boolean__adapter;
                if (typeAdapter37 == null) {
                    typeAdapter37 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter37;
                }
                typeAdapter37.write(jsonWriter, routeOptions.computeTollCost());
            }
            jsonWriter.name(TtmlNode.TAG_METADATA);
            if (routeOptions.metadata() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter38 = this.boolean__adapter;
                if (typeAdapter38 == null) {
                    typeAdapter38 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter38;
                }
                typeAdapter38.write(jsonWriter, routeOptions.metadata());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public RouteOptions read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RouteOptions.Builder builder = RouteOptions.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "banner_instructions":
                            TypeAdapter<Boolean> typeAdapter = this.boolean__adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter;
                            }
                            builder.bannerInstructions(typeAdapter.read(jsonReader));
                            break;
                        case "alley_bias":
                            TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter2;
                            }
                            builder.alleyBias(typeAdapter2.read(jsonReader));
                            break;
                        case "voice_instructions":
                            TypeAdapter<Boolean> typeAdapter3 = this.boolean__adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter3;
                            }
                            builder.voiceInstructions(typeAdapter3.read(jsonReader));
                            break;
                        case "depart_at":
                            TypeAdapter<String> typeAdapter4 = this.string_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter4;
                            }
                            builder.departAt(typeAdapter4.read(jsonReader));
                            break;
                        case "arrive_by":
                            TypeAdapter<String> typeAdapter5 = this.string_adapter;
                            if (typeAdapter5 == null) {
                                typeAdapter5 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter5;
                            }
                            builder.arriveBy(typeAdapter5.read(jsonReader));
                            break;
                        case "avoid_maneuver_radius":
                            TypeAdapter<Double> typeAdapter6 = this.double__adapter;
                            if (typeAdapter6 == null) {
                                typeAdapter6 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter6;
                            }
                            builder.avoidManeuverRadius(typeAdapter6.read(jsonReader));
                            break;
                        case "waypoint_targets":
                            TypeAdapter<String> typeAdapter7 = this.string_adapter;
                            if (typeAdapter7 == null) {
                                typeAdapter7 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter7;
                            }
                            builder.waypointTargets(typeAdapter7.read(jsonReader));
                            break;
                        case "enable_refresh":
                            TypeAdapter<Boolean> typeAdapter8 = this.boolean__adapter;
                            if (typeAdapter8 == null) {
                                typeAdapter8 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter8;
                            }
                            builder.enableRefresh(typeAdapter8.read(jsonReader));
                            break;
                        case "metadata":
                            TypeAdapter<Boolean> typeAdapter9 = this.boolean__adapter;
                            if (typeAdapter9 == null) {
                                typeAdapter9 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter9;
                            }
                            builder.metadata(typeAdapter9.read(jsonReader));
                            break;
                        case "max_width":
                            TypeAdapter<Double> typeAdapter10 = this.double__adapter;
                            if (typeAdapter10 == null) {
                                typeAdapter10 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter10;
                            }
                            builder.maxWidth(typeAdapter10.read(jsonReader));
                            break;
                        case "continue_straight":
                            TypeAdapter<Boolean> typeAdapter11 = this.boolean__adapter;
                            if (typeAdapter11 == null) {
                                typeAdapter11 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter11;
                            }
                            builder.continueStraight(typeAdapter11.read(jsonReader));
                            break;
                        case "snapping_include_closures":
                            TypeAdapter<String> typeAdapter12 = this.string_adapter;
                            if (typeAdapter12 == null) {
                                typeAdapter12 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter12;
                            }
                            builder.snappingIncludeClosures(typeAdapter12.read(jsonReader));
                            break;
                        case "waypoints":
                            TypeAdapter<String> typeAdapter13 = this.string_adapter;
                            if (typeAdapter13 == null) {
                                typeAdapter13 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter13;
                            }
                            builder.waypointIndices(typeAdapter13.read(jsonReader));
                            break;
                        case "voice_units":
                            TypeAdapter<String> typeAdapter14 = this.string_adapter;
                            if (typeAdapter14 == null) {
                                typeAdapter14 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter14;
                            }
                            builder.voiceUnits(typeAdapter14.read(jsonReader));
                            break;
                        case "walking_speed":
                            TypeAdapter<Double> typeAdapter15 = this.double__adapter;
                            if (typeAdapter15 == null) {
                                typeAdapter15 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter15;
                            }
                            builder.walkingSpeed(typeAdapter15.read(jsonReader));
                            break;
                        case "waypoint_names":
                            TypeAdapter<String> typeAdapter16 = this.string_adapter;
                            if (typeAdapter16 == null) {
                                typeAdapter16 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter16;
                            }
                            builder.waypointNames(typeAdapter16.read(jsonReader));
                            break;
                        case "walkway_bias":
                            TypeAdapter<Double> typeAdapter17 = this.double__adapter;
                            if (typeAdapter17 == null) {
                                typeAdapter17 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter17;
                            }
                            builder.walkwayBias(typeAdapter17.read(jsonReader));
                            break;
                        case "max_height":
                            TypeAdapter<Double> typeAdapter18 = this.double__adapter;
                            if (typeAdapter18 == null) {
                                typeAdapter18 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter18;
                            }
                            builder.maxHeight(typeAdapter18.read(jsonReader));
                            break;
                        case "compute_toll_cost":
                            TypeAdapter<Boolean> typeAdapter19 = this.boolean__adapter;
                            if (typeAdapter19 == null) {
                                typeAdapter19 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter19;
                            }
                            builder.computeTollCost(typeAdapter19.read(jsonReader));
                            break;
                        case "max_weight":
                            TypeAdapter<Double> typeAdapter20 = this.double__adapter;
                            if (typeAdapter20 == null) {
                                typeAdapter20 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter20;
                            }
                            builder.maxWeight(typeAdapter20.read(jsonReader));
                            break;
                        case "snapping_include_static_closures":
                            TypeAdapter<String> typeAdapter21 = this.string_adapter;
                            if (typeAdapter21 == null) {
                                typeAdapter21 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter21;
                            }
                            builder.snappingIncludeStaticClosures(typeAdapter21.read(jsonReader));
                            break;
                        case "roundabout_exits":
                            TypeAdapter<Boolean> typeAdapter22 = this.boolean__adapter;
                            if (typeAdapter22 == null) {
                                typeAdapter22 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter22;
                            }
                            builder.roundaboutExits(typeAdapter22.read(jsonReader));
                            break;
                        default:
                            if ("baseUrl".equals(nextName)) {
                                TypeAdapter<String> typeAdapter23 = this.string_adapter;
                                if (typeAdapter23 == null) {
                                    typeAdapter23 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter23;
                                }
                                builder.baseUrl(typeAdapter23.read(jsonReader));
                                break;
                            } else if ("user".equals(nextName)) {
                                TypeAdapter<String> typeAdapter24 = this.string_adapter;
                                if (typeAdapter24 == null) {
                                    typeAdapter24 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter24;
                                }
                                builder.user(typeAdapter24.read(jsonReader));
                                break;
                            } else if ("profile".equals(nextName)) {
                                TypeAdapter<String> typeAdapter25 = this.string_adapter;
                                if (typeAdapter25 == null) {
                                    typeAdapter25 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter25;
                                }
                                builder.profile(typeAdapter25.read(jsonReader));
                                break;
                            } else if ("coordinates".equals(nextName)) {
                                TypeAdapter<String> typeAdapter26 = this.string_adapter;
                                if (typeAdapter26 == null) {
                                    typeAdapter26 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter26;
                                }
                                builder.coordinates(typeAdapter26.read(jsonReader));
                                break;
                            } else if ("alternatives".equals(nextName)) {
                                TypeAdapter<Boolean> typeAdapter27 = this.boolean__adapter;
                                if (typeAdapter27 == null) {
                                    typeAdapter27 = this.gson.getAdapter(Boolean.class);
                                    this.boolean__adapter = typeAdapter27;
                                }
                                builder.alternatives(typeAdapter27.read(jsonReader));
                                break;
                            } else if (IjkMediaMeta.IJKM_KEY_LANGUAGE.equals(nextName)) {
                                TypeAdapter<String> typeAdapter28 = this.string_adapter;
                                if (typeAdapter28 == null) {
                                    typeAdapter28 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter28;
                                }
                                builder.language(typeAdapter28.read(jsonReader));
                                break;
                            } else if ("radiuses".equals(nextName)) {
                                TypeAdapter<String> typeAdapter29 = this.string_adapter;
                                if (typeAdapter29 == null) {
                                    typeAdapter29 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter29;
                                }
                                builder.radiuses(typeAdapter29.read(jsonReader));
                                break;
                            } else if ("bearings".equals(nextName)) {
                                TypeAdapter<String> typeAdapter30 = this.string_adapter;
                                if (typeAdapter30 == null) {
                                    typeAdapter30 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter30;
                                }
                                builder.bearings(typeAdapter30.read(jsonReader));
                                break;
                            } else if (RtspHeaders.Values.LAYERS.equals(nextName)) {
                                TypeAdapter<String> typeAdapter31 = this.string_adapter;
                                if (typeAdapter31 == null) {
                                    typeAdapter31 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter31;
                                }
                                builder.layers(typeAdapter31.read(jsonReader));
                                break;
                            } else if ("geometries".equals(nextName)) {
                                TypeAdapter<String> typeAdapter32 = this.string_adapter;
                                if (typeAdapter32 == null) {
                                    typeAdapter32 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter32;
                                }
                                builder.geometries(typeAdapter32.read(jsonReader));
                                break;
                            } else if ("overview".equals(nextName)) {
                                TypeAdapter<String> typeAdapter33 = this.string_adapter;
                                if (typeAdapter33 == null) {
                                    typeAdapter33 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter33;
                                }
                                builder.overview(typeAdapter33.read(jsonReader));
                                break;
                            } else if ("steps".equals(nextName)) {
                                TypeAdapter<Boolean> typeAdapter34 = this.boolean__adapter;
                                if (typeAdapter34 == null) {
                                    typeAdapter34 = this.gson.getAdapter(Boolean.class);
                                    this.boolean__adapter = typeAdapter34;
                                }
                                builder.steps(typeAdapter34.read(jsonReader));
                                break;
                            } else if ("annotations".equals(nextName)) {
                                TypeAdapter<String> typeAdapter35 = this.string_adapter;
                                if (typeAdapter35 == null) {
                                    typeAdapter35 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter35;
                                }
                                builder.annotations(typeAdapter35.read(jsonReader));
                                break;
                            } else if ("exclude".equals(nextName)) {
                                TypeAdapter<String> typeAdapter36 = this.string_adapter;
                                if (typeAdapter36 == null) {
                                    typeAdapter36 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter36;
                                }
                                builder.exclude(typeAdapter36.read(jsonReader));
                                break;
                            } else if ("include".equals(nextName)) {
                                TypeAdapter<String> typeAdapter37 = this.string_adapter;
                                if (typeAdapter37 == null) {
                                    typeAdapter37 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter37;
                                }
                                builder.include(typeAdapter37.read(jsonReader));
                                break;
                            } else if ("approaches".equals(nextName)) {
                                TypeAdapter<String> typeAdapter38 = this.string_adapter;
                                if (typeAdapter38 == null) {
                                    typeAdapter38 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter38;
                                }
                                builder.approaches(typeAdapter38.read(jsonReader));
                                break;
                            } else {
                                if (linkedHashMap == null) {
                                    linkedHashMap = new LinkedHashMap();
                                    builder.unrecognized(linkedHashMap);
                                }
                                linkedHashMap.put(nextName, new SerializableJsonElement((JsonElement) this.gson.fromJson(jsonReader, JsonElement.class)));
                                break;
                            }
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(RouteOptions)";
        }
    }
}