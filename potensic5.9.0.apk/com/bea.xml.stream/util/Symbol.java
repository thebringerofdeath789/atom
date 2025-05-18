package com.bea.xml.stream.util;

/* loaded from: classes.dex */
class Symbol {
    int depth;
    String name;
    String value;

    Symbol(String str, String str2, int i) {
        this.name = str;
        this.value = str2;
        this.depth = i;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int getDepth() {
        return this.depth;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.depth).append("][").append(this.name).append("][").append(this.value).append("]").toString();
    }
}