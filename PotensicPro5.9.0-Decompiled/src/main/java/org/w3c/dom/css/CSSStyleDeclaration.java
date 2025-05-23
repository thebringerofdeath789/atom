package org.w3c.dom.css;

import org.w3c.dom.DOMException;

/* loaded from: classes6.dex */
public interface CSSStyleDeclaration {
    String getCssText();

    int getLength();

    CSSRule getParentRule();

    CSSValue getPropertyCSSValue(String str);

    String getPropertyPriority(String str);

    String getPropertyValue(String str);

    String item(int i);

    String removeProperty(String str) throws DOMException;

    void setCssText(String str) throws DOMException;

    void setProperty(String str, String str2, String str3) throws DOMException;
}
