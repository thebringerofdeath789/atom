package org.w3c.dom.events;

import org.w3c.dom.views.AbstractView;

/* loaded from: classes6.dex */
public interface UIEvent extends Event {
    int getDetail();

    AbstractView getView();

    void initUIEvent(String str, boolean z, boolean z2, AbstractView abstractView, int i);
}
