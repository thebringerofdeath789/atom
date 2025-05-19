package org.w3c.dom.css;

import org.w3c.dom.Element;
import org.w3c.dom.stylesheets.DocumentStyle;

/* loaded from: classes6.dex */
public interface DocumentCSS extends DocumentStyle {
    CSSStyleDeclaration getOverrideStyle(Element element, String str);
}
