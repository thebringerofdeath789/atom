package org.w3c.dom.stylesheets;

import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface StyleSheet {
    boolean getDisabled();

    String getHref();

    MediaList getMedia();

    Node getOwnerNode();

    StyleSheet getParentStyleSheet();

    String getTitle();

    String getType();

    void setDisabled(boolean z);
}
