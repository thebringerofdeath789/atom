package com.lib.bean;

/* loaded from: classes2.dex */
public class XmlCell {
    private String key;
    private String value;

    public XmlCell(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "XmlCell{key='" + this.key + "', value='" + this.value + "'}";
    }
}