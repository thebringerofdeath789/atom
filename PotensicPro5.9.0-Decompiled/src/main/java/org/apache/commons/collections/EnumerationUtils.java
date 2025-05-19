package org.apache.commons.collections;

import java.util.Enumeration;
import java.util.List;
import org.apache.commons.collections.iterators.EnumerationIterator;

/* loaded from: classes4.dex */
public class EnumerationUtils {
    public static List toList(Enumeration enumeration) {
        return IteratorUtils.toList(new EnumerationIterator(enumeration));
    }
}
