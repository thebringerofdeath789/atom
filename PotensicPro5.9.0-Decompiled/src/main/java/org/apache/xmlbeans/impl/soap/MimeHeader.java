package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public class MimeHeader {
    private String name;
    private String value;

    public MimeHeader(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
