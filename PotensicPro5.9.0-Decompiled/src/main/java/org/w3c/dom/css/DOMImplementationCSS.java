package org.w3c.dom.css;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;

/* loaded from: classes6.dex */
public interface DOMImplementationCSS extends DOMImplementation {
    CSSStyleSheet createCSSStyleSheet(String str, String str2) throws DOMException;
}
