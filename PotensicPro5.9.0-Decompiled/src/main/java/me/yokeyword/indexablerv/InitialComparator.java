package me.yokeyword.indexablerv;

import java.util.Comparator;
import me.yokeyword.indexablerv.IndexableEntity;

/* loaded from: classes4.dex */
class InitialComparator<T extends IndexableEntity> implements Comparator<EntityWrapper<T>> {
    InitialComparator() {
    }

    @Override // java.util.Comparator
    public int compare(EntityWrapper<T> entityWrapper, EntityWrapper<T> entityWrapper2) {
        return entityWrapper.getIndex().compareTo(entityWrapper2.getIndex());
    }
}
