package org.apache.xmlbeans.impl.regex;

/* loaded from: classes5.dex */
public class ParseException extends RuntimeException {
    int location;

    public ParseException(String str, int i) {
        super(str);
        this.location = i;
    }

    public int getLocation() {
        return this.location;
    }
}
