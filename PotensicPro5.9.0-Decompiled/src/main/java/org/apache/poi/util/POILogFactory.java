package org.apache.poi.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class POILogFactory {
    private static Map<String, POILogger> _loggers = new HashMap();
    private static POILogger _nullLogger = new NullLogger();
    private static String _loggerClassName = null;

    private POILogFactory() {
    }

    public static POILogger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static POILogger getLogger(String str) {
        POILogger pOILogger;
        if (_loggerClassName == null) {
            try {
                _loggerClassName = System.getProperty("org.apache.poi.util.POILogger");
            } catch (Exception unused) {
            }
            if (_loggerClassName == null) {
                _loggerClassName = _nullLogger.getClass().getName();
            }
        }
        if (_loggerClassName.equals(_nullLogger.getClass().getName())) {
            return _nullLogger;
        }
        if (_loggers.containsKey(str)) {
            return _loggers.get(str);
        }
        try {
            pOILogger = (POILogger) Class.forName(_loggerClassName).newInstance();
            pOILogger.initialize(str);
        } catch (Exception unused2) {
            pOILogger = _nullLogger;
        }
        _loggers.put(str, pOILogger);
        return pOILogger;
    }
}
