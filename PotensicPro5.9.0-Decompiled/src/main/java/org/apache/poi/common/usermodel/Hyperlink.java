package org.apache.poi.common.usermodel;

/* loaded from: classes.dex */
public interface Hyperlink {
    public static final int LINK_DOCUMENT = 2;
    public static final int LINK_EMAIL = 3;
    public static final int LINK_FILE = 4;
    public static final int LINK_URL = 1;

    String getAddress();

    String getLabel();

    int getType();

    void setAddress(String str);

    void setLabel(String str);
}
