package org.apache.xmlbeans;

import org.apache.xmlbeans.XmlCursor;

/* loaded from: classes5.dex */
public class SchemaBookmark extends XmlCursor.XmlBookmark {
    private Object _value;

    public SchemaBookmark(Object obj) {
        this._value = obj;
    }

    public Object getValue() {
        return this._value;
    }
}
