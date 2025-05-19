package org.apache.poi.xslf.model;

import org.apache.poi.util.Internal;
import org.apache.poi.xslf.usermodel.XSLFSimpleShape;

@Internal
/* loaded from: classes5.dex */
public abstract class PropertyFetcher<T> {
    private T _value;

    public abstract boolean fetch(XSLFSimpleShape xSLFSimpleShape);

    public T getValue() {
        return this._value;
    }

    public void setValue(T t) {
        this._value = t;
    }
}
