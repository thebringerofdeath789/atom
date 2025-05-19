package org.dom4j;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class XPathException extends RuntimeException {
    private String xpath;

    public XPathException(String str) {
        super(new StringBuffer().append("Exception occurred evaluting XPath: ").append(str).toString());
        this.xpath = str;
    }

    public XPathException(String str, String str2) {
        super(new StringBuffer().append("Exception occurred evaluting XPath: ").append(str).append(StringUtils.SPACE).append(str2).toString());
        this.xpath = str;
    }

    public XPathException(String str, Exception exc) {
        super(new StringBuffer().append("Exception occurred evaluting XPath: ").append(str).append(". Exception: ").append(exc.getMessage()).toString());
        this.xpath = str;
    }

    public String getXPath() {
        return this.xpath;
    }
}
