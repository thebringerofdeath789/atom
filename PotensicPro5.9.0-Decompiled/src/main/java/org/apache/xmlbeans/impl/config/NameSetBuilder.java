package org.apache.xmlbeans.impl.config;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class NameSetBuilder {
    private boolean _isFinite = true;
    private Set _finiteSet = new HashSet();

    public void invert() {
        this._isFinite = !this._isFinite;
    }

    public void add(String str) {
        if (this._isFinite) {
            this._finiteSet.add(str);
        } else {
            this._finiteSet.remove(str);
        }
    }

    public NameSet toNameSet() {
        if (this._finiteSet.size() == 0) {
            if (this._isFinite) {
                return NameSet.EMPTY;
            }
            return NameSet.EVERYTHING;
        }
        return NameSet.newInstance(this._isFinite, this._finiteSet);
    }
}
