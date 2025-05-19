package com.logan.server.jhttp;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpConfig {
    public static Map<Integer, IHttpRouter> customPageActionHashMap = new HashMap();

    public static void addCustomPageAction(int i, IHttpRouter iHttpRouter) {
        customPageActionHashMap.put(Integer.valueOf(i), iHttpRouter);
    }

    public static void removeCustomPageAction(int i) {
        if (customPageActionHashMap.containsKey(Integer.valueOf(i))) {
            customPageActionHashMap.remove(Integer.valueOf(i));
        }
    }
}
