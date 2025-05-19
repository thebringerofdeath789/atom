package org.w3c.dom.css;

import org.w3c.dom.Element;
import org.w3c.dom.views.AbstractView;

/* loaded from: classes6.dex */
public interface ViewCSS extends AbstractView {
    CSSStyleDeclaration getComputedStyle(Element element, String str);
}
