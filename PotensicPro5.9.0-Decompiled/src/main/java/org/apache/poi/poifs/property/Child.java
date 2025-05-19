package org.apache.poi.poifs.property;

/* loaded from: classes5.dex */
public interface Child {
    Child getNextChild();

    Child getPreviousChild();

    void setNextChild(Child child);

    void setPreviousChild(Child child);
}
