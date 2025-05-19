package org.w3c.dom.css;

import org.w3c.dom.DOMException;
import org.w3c.dom.stylesheets.StyleSheet;

/* loaded from: classes6.dex */
public interface CSSStyleSheet extends StyleSheet {
    void deleteRule(int i) throws DOMException;

    CSSRuleList getCssRules();

    CSSRule getOwnerRule();

    int insertRule(String str, int i) throws DOMException;
}
