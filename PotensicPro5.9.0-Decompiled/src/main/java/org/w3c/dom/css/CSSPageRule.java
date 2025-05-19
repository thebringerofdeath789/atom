package org.w3c.dom.css;

import org.w3c.dom.DOMException;

/* loaded from: classes6.dex */
public interface CSSPageRule extends CSSRule {
    String getSelectorText();

    CSSStyleDeclaration getStyle();

    void setSelectorText(String str) throws DOMException;
}
