package com.mapbox.auto.value.gson;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes3.dex */
public class SerializableJsonElement implements Serializable {
    private JsonElement element;

    public SerializableJsonElement(JsonElement jsonElement) {
        this.element = jsonElement;
    }

    public JsonElement getElement() {
        return this.element;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.element, ((SerializableJsonElement) obj).element);
    }

    public int hashCode() {
        return Objects.hash(this.element);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.element = (JsonElement) new GsonBuilder().create().fromJson(objectInputStream.readUTF(), JsonElement.class);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.element.toString());
    }
}
