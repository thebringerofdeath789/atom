package org.dom4j;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class InvalidXPathException extends IllegalArgumentException {
    private static final long serialVersionUID = 3257009869058881592L;

    public InvalidXPathException(String str) {
        super(new StringBuffer().append("Invalid XPath expression: ").append(str).toString());
    }

    public InvalidXPathException(String str, String str2) {
        super(new StringBuffer().append("Invalid XPath expression: ").append(str).append(StringUtils.SPACE).append(str2).toString());
    }

    public InvalidXPathException(String str, Throwable th) {
        super(new StringBuffer().append("Invalid XPath expression: '").append(str).append("'. Caused by: ").append(th.getMessage()).toString());
    }
}
