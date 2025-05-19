package org.w3c.dom.stylesheets;

import org.w3c.dom.DOMException;

/* loaded from: classes6.dex */
public interface MediaList {
    void appendMedium(String str) throws DOMException;

    void deleteMedium(String str) throws DOMException;

    int getLength();

    String getMediaText();

    String item(int i);

    void setMediaText(String str) throws DOMException;
}
