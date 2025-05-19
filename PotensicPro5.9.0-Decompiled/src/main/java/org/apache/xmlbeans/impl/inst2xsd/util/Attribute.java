package org.apache.xmlbeans.impl.inst2xsd.util;

import aavax.xml.namespace.QName;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes5.dex */
public class Attribute {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$inst2xsd$util$Attribute;
    private QName _name;
    private Type _type;
    private Attribute _ref = null;
    private boolean _isGlobal = false;
    private boolean _isOptional = false;

    static {
        if (class$org$apache$xmlbeans$impl$inst2xsd$util$Attribute == null) {
            class$org$apache$xmlbeans$impl$inst2xsd$util$Attribute = class$("org.apache.xmlbeans.impl.inst2xsd.util.Attribute");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public Type getType() {
        return isRef() ? getRef().getType() : this._type;
    }

    public void setType(Type type) {
        if (!$assertionsDisabled && isRef()) {
            throw new AssertionError();
        }
        this._type = type;
    }

    public boolean isRef() {
        return this._ref != null;
    }

    public Attribute getRef() {
        return this._ref;
    }

    public void setRef(Attribute attribute) {
        if (!$assertionsDisabled && isGlobal()) {
            throw new AssertionError();
        }
        this._ref = attribute;
        this._type = null;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public void setGlobal(boolean z) {
        this._isGlobal = z;
    }

    public boolean isOptional() {
        return this._isOptional;
    }

    public void setOptional(boolean z) {
        if (!$assertionsDisabled && (!z || isGlobal())) {
            throw new AssertionError("Global attributes cannot be optional.");
        }
        this._isOptional = z;
    }

    public String toString() {
        return new StringBuffer().append("\n    Attribute{_name=").append(this._name).append(", _type=").append(this._type).append(", _ref=").append(this._ref != null).append(", _isGlobal=").append(this._isGlobal).append(", _isOptional=").append(this._isOptional).append(StringSubstitutor.DEFAULT_VAR_END).toString();
    }
}
