package org.apache.poi.poifs.crypt;

/* loaded from: classes5.dex */
public enum ChainingMode {
    ecb("ECB", 1),
    cbc("CBC", 2),
    cfb("CFB8", 3);

    public final int ecmaId;
    public final String jceId;

    ChainingMode(String str, int i) {
        this.jceId = str;
        this.ecmaId = i;
    }
}
