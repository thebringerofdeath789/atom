package org.apache.commons.collections.functors;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.BooleanUtils;

/* loaded from: classes4.dex */
class FunctorUtils {
    static final String UNSAFE_SERIALIZABLE_PROPERTY = "org.apache.commons.collections.enableUnsafeSerialization";

    private FunctorUtils() {
    }

    static Predicate[] copy(Predicate[] predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    static void validate(Predicate[] predicateArr) {
        if (predicateArr == null) {
            throw new IllegalArgumentException("The predicate array must not be null");
        }
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                throw new IllegalArgumentException(new StringBuffer().append("The predicate array must not contain a null predicate, index ").append(i).append(" was null").toString());
            }
        }
    }

    static Predicate[] validate(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("The predicate collection must not be null");
        }
        Predicate[] predicateArr = new Predicate[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            predicateArr[i] = (Predicate) it.next();
            if (predicateArr[i] == null) {
                throw new IllegalArgumentException(new StringBuffer().append("The predicate collection must not contain a null predicate, index ").append(i).append(" was null").toString());
            }
            i++;
        }
        return predicateArr;
    }

    static Closure[] copy(Closure[] closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    static void validate(Closure[] closureArr) {
        if (closureArr == null) {
            throw new IllegalArgumentException("The closure array must not be null");
        }
        for (int i = 0; i < closureArr.length; i++) {
            if (closureArr[i] == null) {
                throw new IllegalArgumentException(new StringBuffer().append("The closure array must not contain a null closure, index ").append(i).append(" was null").toString());
            }
        }
    }

    static Transformer[] copy(Transformer[] transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    static void validate(Transformer[] transformerArr) {
        if (transformerArr == null) {
            throw new IllegalArgumentException("The transformer array must not be null");
        }
        for (int i = 0; i < transformerArr.length; i++) {
            if (transformerArr[i] == null) {
                throw new IllegalArgumentException(new StringBuffer().append("The transformer array must not contain a null transformer, index ").append(i).append(" was null").toString());
            }
        }
    }

    static void checkUnsafeSerialization(Class cls) {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.collections.functors.FunctorUtils.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty(FunctorUtils.UNSAFE_SERIALIZABLE_PROPERTY);
                }
            });
        } catch (SecurityException unused) {
            str = null;
        }
        if (!BooleanUtils.TRUE.equalsIgnoreCase(str)) {
            throw new UnsupportedOperationException(new StringBuffer().append("Serialization support for ").append(cls.getName()).append(" is disabled for security reasons. ").append("To enable it set system property '").append(UNSAFE_SERIALIZABLE_PROPERTY).append("' to 'true', ").append("but you must ensure that your application does not de-serialize objects from untrusted sources.").toString());
        }
    }
}
