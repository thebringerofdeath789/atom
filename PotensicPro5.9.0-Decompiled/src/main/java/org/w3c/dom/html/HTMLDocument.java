package org.w3c.dom.html;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes6.dex */
public interface HTMLDocument extends Document {
    void close();

    HTMLCollection getAnchors();

    HTMLCollection getApplets();

    HTMLElement getBody();

    String getCookie();

    String getDomain();

    @Override // org.w3c.dom.Document
    Element getElementById(String str);

    NodeList getElementsByName(String str);

    HTMLCollection getForms();

    HTMLCollection getImages();

    HTMLCollection getLinks();

    String getReferrer();

    String getTitle();

    String getURL();

    void open();

    void setBody(HTMLElement hTMLElement);

    void setCookie(String str);

    void setTitle(String str);

    void write(String str);

    void writeln(String str);
}
