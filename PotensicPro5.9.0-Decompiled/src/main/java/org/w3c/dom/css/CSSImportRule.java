package org.w3c.dom.css;

import org.w3c.dom.stylesheets.MediaList;

/* loaded from: classes6.dex */
public interface CSSImportRule extends CSSRule {
    String getHref();

    MediaList getMedia();

    CSSStyleSheet getStyleSheet();
}
