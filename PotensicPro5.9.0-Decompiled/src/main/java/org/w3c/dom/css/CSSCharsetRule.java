package org.w3c.dom.css;

import org.w3c.dom.DOMException;

/* loaded from: classes6.dex */
public interface CSSCharsetRule extends CSSRule {
    String getEncoding();

    void setEncoding(String str) throws DOMException;
}
