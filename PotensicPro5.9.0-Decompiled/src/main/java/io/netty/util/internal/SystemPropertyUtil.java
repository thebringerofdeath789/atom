package io.netty.util.internal;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Objects;
import org.apache.commons.lang3.BooleanUtils;

/* loaded from: classes4.dex */
public final class SystemPropertyUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SystemPropertyUtil.class);

    public static boolean contains(String str) {
        return get(str) != null;
    }

    public static String get(String str) {
        return get(str, null);
    }

    public static String get(final String str, String str2) {
        Objects.requireNonNull(str, "key");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }
        String str3 = null;
        try {
            if (System.getSecurityManager() == null) {
                str = System.getProperty(str);
                str3 = str;
            } else {
                str3 = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.SystemPropertyUtil.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty(str);
                    }
                });
            }
        } catch (SecurityException e) {
            logger.warn("Unable to retrieve a system property '{}'; default values will be used.", str, e);
        }
        return str3 == null ? str2 : str3;
    }

    public static boolean getBoolean(String str, boolean z) {
        String str2 = get(str);
        if (str2 == null) {
            return z;
        }
        String lowerCase = str2.trim().toLowerCase();
        if (lowerCase.isEmpty()) {
            return z;
        }
        if (BooleanUtils.TRUE.equals(lowerCase) || BooleanUtils.YES.equals(lowerCase) || "1".equals(lowerCase)) {
            return true;
        }
        if ("false".equals(lowerCase) || BooleanUtils.NO.equals(lowerCase) || SessionDescription.SUPPORTED_SDP_VERSION.equals(lowerCase)) {
            return false;
        }
        logger.warn("Unable to parse the boolean system property '{}':{} - using the default value: {}", str, lowerCase, Boolean.valueOf(z));
        return z;
    }

    public static int getInt(String str, int i) {
        String str2 = get(str);
        if (str2 == null) {
            return i;
        }
        String trim = str2.trim();
        try {
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the integer system property '{}':{} - using the default value: {}", str, trim, Integer.valueOf(i));
            return i;
        }
    }

    public static long getLong(String str, long j) {
        String str2 = get(str);
        if (str2 == null) {
            return j;
        }
        String trim = str2.trim();
        try {
            return Long.parseLong(trim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the long integer system property '{}':{} - using the default value: {}", str, trim, Long.valueOf(j));
            return j;
        }
    }

    private SystemPropertyUtil() {
    }
}
