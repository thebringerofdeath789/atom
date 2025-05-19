package org.apache.commons.collections4.sequence;

import java.util.List;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface ReplacementsHandler<T> {
    void handleReplacement(int i, List<T> list, List<T> list2);
}
