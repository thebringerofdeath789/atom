package org.w3c.dom.html;

/* loaded from: classes6.dex */
public interface HTMLFormElement extends HTMLElement {
    String getAcceptCharset();

    String getAction();

    HTMLCollection getElements();

    String getEnctype();

    int getLength();

    String getMethod();

    String getName();

    String getTarget();

    void reset();

    void setAcceptCharset(String str);

    void setAction(String str);

    void setEnctype(String str);

    void setMethod(String str);

    void setName(String str);

    void setTarget(String str);

    void submit();
}
