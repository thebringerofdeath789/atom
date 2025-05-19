package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* loaded from: classes5.dex */
public class XmlValueOutOfRangeException extends IllegalArgumentException {
    public XmlValueOutOfRangeException() {
    }

    public XmlValueOutOfRangeException(String str) {
        super(str);
    }

    public XmlValueOutOfRangeException(String str, Object[] objArr) {
        super(XmlError.formattedMessage(str, objArr));
    }
}
