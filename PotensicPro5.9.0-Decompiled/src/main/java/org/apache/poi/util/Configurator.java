package org.apache.poi.util;

/* loaded from: classes5.dex */
public class Configurator {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) Configurator.class);

    public static int getIntValue(String str, int i) {
        String property = System.getProperty(str);
        try {
            return Integer.valueOf(property).intValue();
        } catch (Exception unused) {
            logger.log(7, "System property -D" + str + " do not contains a valid integer " + property);
            return i;
        }
    }
}
