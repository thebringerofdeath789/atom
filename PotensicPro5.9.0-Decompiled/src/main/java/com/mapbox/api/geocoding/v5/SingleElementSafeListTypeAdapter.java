package com.mapbox.api.geocoding.v5;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class SingleElementSafeListTypeAdapter<E> extends TypeAdapter<List<E>> {
    static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.mapbox.api.geocoding.v5.SingleElementSafeListTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (List.class.isAssignableFrom(rawType)) {
                return new SingleElementSafeListTypeAdapter(gson.getAdapter(TypeToken.get(C$Gson$Types.getCollectionElementType(typeToken.getType(), rawType))));
            }
            return null;
        }
    };
    private final TypeAdapter<E> elementTypeAdapter;

    private SingleElementSafeListTypeAdapter(TypeAdapter<E> typeAdapter) {
        this.elementTypeAdapter = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public List<E> read2(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        ArrayList arrayList = new ArrayList();
        switch (AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()]) {
            case 1:
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(this.elementTypeAdapter.read2(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
            case 3:
            case 4:
            case 5:
                arrayList.add(this.elementTypeAdapter.read2(jsonReader));
                return arrayList;
            case 6:
                jsonReader.nextNull();
                return null;
            case 7:
            case 8:
            case 9:
            case 10:
                throw new MalformedJsonException("Unexpected token: " + peek);
            default:
                throw new IllegalStateException("Unprocessed token: " + peek);
        }
    }

    /* renamed from: com.mapbox.api.geocoding.v5.SingleElementSafeListTypeAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, List<E> list) throws IOException {
        if (list == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            this.elementTypeAdapter.write(jsonWriter, it.next());
        }
        jsonWriter.endArray();
    }
}
