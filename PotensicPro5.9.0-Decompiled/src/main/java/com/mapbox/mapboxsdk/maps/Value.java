package com.mapbox.mapboxsdk.maps;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Value {
    private Object contents;

    private Value(Object obj) {
        this.contents = obj;
    }

    public Value(double d) {
        this.contents = Double.valueOf(d);
    }

    public Value(long j) {
        this.contents = Long.valueOf(j);
    }

    public Value(boolean z) {
        this.contents = Boolean.valueOf(z);
    }

    public Value(String str) {
        this.contents = str;
    }

    public Value(ArrayList<Value> arrayList) {
        this.contents = arrayList;
    }

    public Value(HashMap<String, Value> hashMap) {
        this.contents = hashMap;
    }

    public Object getContents() {
        return this.contents;
    }

    public String toString() {
        return this.contents.toString();
    }
}
