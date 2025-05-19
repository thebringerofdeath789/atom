package org.apache.poi.util;

import com.baidu.geofence.GeoFence;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class SystemOutLogger extends POILogger {
    private String _cat;

    @Override // org.apache.poi.util.POILogger
    public void initialize(String str) {
        this._cat = str;
    }

    @Override // org.apache.poi.util.POILogger
    public void log(int i, Object obj) {
        log(i, obj, (Throwable) null);
    }

    @Override // org.apache.poi.util.POILogger
    public void log(int i, Object obj, Throwable th) {
        if (check(i)) {
            System.out.println("[" + this._cat + "]" + LEVEL_STRINGS_SHORT[Math.min(LEVEL_STRINGS_SHORT.length - 1, i)] + StringUtils.SPACE + obj);
            if (th != null) {
                th.printStackTrace(System.out);
            }
        }
    }

    @Override // org.apache.poi.util.POILogger
    public boolean check(int i) {
        int i2;
        try {
            i2 = Integer.parseInt(System.getProperty("poi.log.level", GeoFence.BUNDLE_KEY_FENCE));
        } catch (SecurityException unused) {
            i2 = 1;
        }
        return i >= i2;
    }
}
