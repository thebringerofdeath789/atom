package org.apache.xmlcommons;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class Version {
    public static String getProduct() {
        return "XmlCommons";
    }

    public static String getVersion() {
        return new StringBuffer().append(getProduct()).append(StringUtils.SPACE).append(getVersionNum()).toString();
    }

    public static String getVersionNum() {
        return "1.0";
    }

    public static void main(String[] strArr) {
        System.out.println(getVersion());
    }
}
