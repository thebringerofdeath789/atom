package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.PaymentMethods;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_PaymentMethods extends C$AutoValue_PaymentMethods {
    AutoValue_PaymentMethods(Map<String, SerializableJsonElement> map, CostPerVehicleSize costPerVehicleSize, CostPerVehicleSize costPerVehicleSize2) {
        new PaymentMethods(map, costPerVehicleSize, costPerVehicleSize2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_PaymentMethods
            private final CostPerVehicleSize cash;
            private final CostPerVehicleSize etc;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.etc = costPerVehicleSize;
                this.cash = costPerVehicleSize2;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.PaymentMethods
            public CostPerVehicleSize etc() {
                return this.etc;
            }

            @Override // com.mapbox.api.directions.v5.models.PaymentMethods
            public CostPerVehicleSize cash() {
                return this.cash;
            }

            public String toString() {
                return "PaymentMethods{unrecognized=" + this.unrecognized + ", etc=" + this.etc + ", cash=" + this.cash + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof PaymentMethods)) {
                    return false;
                }
                PaymentMethods paymentMethods = (PaymentMethods) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(paymentMethods.unrecognized()) : paymentMethods.unrecognized() == null) {
                    CostPerVehicleSize costPerVehicleSize3 = this.etc;
                    if (costPerVehicleSize3 != null ? costPerVehicleSize3.equals(paymentMethods.etc()) : paymentMethods.etc() == null) {
                        CostPerVehicleSize costPerVehicleSize4 = this.cash;
                        if (costPerVehicleSize4 == null) {
                            if (paymentMethods.cash() == null) {
                                return true;
                            }
                        } else if (costPerVehicleSize4.equals(paymentMethods.cash())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                CostPerVehicleSize costPerVehicleSize3 = this.etc;
                int hashCode2 = (hashCode ^ (costPerVehicleSize3 == null ? 0 : costPerVehicleSize3.hashCode())) * 1000003;
                CostPerVehicleSize costPerVehicleSize4 = this.cash;
                return hashCode2 ^ (costPerVehicleSize4 != null ? costPerVehicleSize4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.PaymentMethods
            public PaymentMethods.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_PaymentMethods$Builder */
            static class Builder extends PaymentMethods.Builder {
                private CostPerVehicleSize cash;
                private CostPerVehicleSize etc;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ PaymentMethods.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(PaymentMethods paymentMethods) {
                    this.unrecognized = paymentMethods.unrecognized();
                    this.etc = paymentMethods.etc();
                    this.cash = paymentMethods.cash();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                PaymentMethods.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.PaymentMethods.Builder
                public PaymentMethods.Builder etc(CostPerVehicleSize costPerVehicleSize) {
                    this.etc = costPerVehicleSize;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.PaymentMethods.Builder
                public PaymentMethods.Builder cash(CostPerVehicleSize costPerVehicleSize) {
                    this.cash = costPerVehicleSize;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.PaymentMethods.Builder
                public PaymentMethods build() {
                    return new AutoValue_PaymentMethods(this.unrecognized, this.etc, this.cash);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<PaymentMethods> {
        private volatile TypeAdapter<CostPerVehicleSize> costPerVehicleSize_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, PaymentMethods paymentMethods) throws IOException {
            if (paymentMethods == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (paymentMethods.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : paymentMethods.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("etc");
            if (paymentMethods.etc() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<CostPerVehicleSize> typeAdapter = this.costPerVehicleSize_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(CostPerVehicleSize.class);
                    this.costPerVehicleSize_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, paymentMethods.etc());
            }
            jsonWriter.name("cash");
            if (paymentMethods.cash() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<CostPerVehicleSize> typeAdapter2 = this.costPerVehicleSize_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(CostPerVehicleSize.class);
                    this.costPerVehicleSize_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, paymentMethods.cash());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public PaymentMethods read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            PaymentMethods.Builder builder = PaymentMethods.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("etc".equals(nextName)) {
                        TypeAdapter<CostPerVehicleSize> typeAdapter = this.costPerVehicleSize_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(CostPerVehicleSize.class);
                            this.costPerVehicleSize_adapter = typeAdapter;
                        }
                        builder.etc(typeAdapter.read2(jsonReader));
                    } else if ("cash".equals(nextName)) {
                        TypeAdapter<CostPerVehicleSize> typeAdapter2 = this.costPerVehicleSize_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(CostPerVehicleSize.class);
                            this.costPerVehicleSize_adapter = typeAdapter2;
                        }
                        builder.cash(typeAdapter2.read2(jsonReader));
                    } else {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                            builder.unrecognized(linkedHashMap);
                        }
                        linkedHashMap.put(nextName, new SerializableJsonElement((JsonElement) this.gson.fromJson(jsonReader, JsonElement.class)));
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(PaymentMethods)";
        }
    }
}
