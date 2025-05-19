package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* loaded from: classes5.dex */
public class XmlValueNotSupportedException extends XmlValueOutOfRangeException {
    public XmlValueNotSupportedException() {
    }

    public XmlValueNotSupportedException(String str) {
        super(str);
    }

    public XmlValueNotSupportedException(String str, Object[] objArr) {
        super(XmlError.formattedMessage(str, objArr));
    }
}
