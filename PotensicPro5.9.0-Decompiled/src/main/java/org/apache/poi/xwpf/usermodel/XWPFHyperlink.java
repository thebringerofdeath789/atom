package org.apache.poi.xwpf.usermodel;

/* loaded from: classes5.dex */
public class XWPFHyperlink {
    String id;
    String url;

    public XWPFHyperlink(String str, String str2) {
        this.id = str;
        this.url = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getURL() {
        return this.url;
    }
}
