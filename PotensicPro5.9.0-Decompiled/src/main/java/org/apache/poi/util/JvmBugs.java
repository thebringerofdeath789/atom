package org.apache.poi.util;

/* loaded from: classes5.dex */
public class JvmBugs {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) JvmBugs.class);

    public static boolean hasLineBreakMeasurerBug() {
        String property = System.getProperty("java.version");
        boolean z = !Boolean.getBoolean("org.apache.poi.JvmBugs.LineBreakMeasurer.ignore") && System.getProperty("os.name").toLowerCase().contains("win") && ("1.6.0_45".equals(property) || "1.7.0_21".equals(property));
        if (z) {
            LOG.log(5, "JVM has LineBreakMeasurer bug - see POI bug #54904 - caller code might default to Lucida Sans");
        }
        return z;
    }
}
