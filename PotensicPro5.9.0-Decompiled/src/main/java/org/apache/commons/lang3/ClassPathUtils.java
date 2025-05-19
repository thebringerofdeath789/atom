package org.apache.commons.lang3;

import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r3, String str) {
        Validate.notNull(r3, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return r3.getName() + "." + str;
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Package r3, String str) {
        Validate.notNull(r3, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return r3.getName().replace('.', '/') + InternalZipConstants.ZIP_FILE_SEPARATOR + str;
    }
}
