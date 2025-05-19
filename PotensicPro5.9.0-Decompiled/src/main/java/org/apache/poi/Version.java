package org.apache.poi;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class Version {
    private static final String RELEASE_DATE = "20150511";
    private static final String VERSION_STRING = "3.12";

    public static String getImplementationLanguage() {
        return "Java";
    }

    public static String getProduct() {
        return "POI";
    }

    public static String getReleaseDate() {
        return RELEASE_DATE;
    }

    public static String getVersion() {
        return VERSION_STRING;
    }

    public static void main(String[] strArr) {
        System.out.println("Apache " + getProduct() + StringUtils.SPACE + getVersion() + " (" + getReleaseDate() + ")");
    }
}
