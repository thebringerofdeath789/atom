package org.apache.xmlbeans.impl.inst2xsd.util;

import aavax.xml.namespace.QName;

/* loaded from: classes5.dex */
public class Element {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int UNBOUNDED = -1;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$inst2xsd$util$Element;
    private QName _name = null;
    private Element _ref = null;
    private boolean _isGlobal = false;
    private int _minOccurs = 1;
    private int _maxOccurs = 1;
    private boolean _isNillable = false;
    private Type _type = null;
    private String _comment = null;

    static {
        if (class$org$apache$xmlbeans$impl$inst2xsd$util$Element == null) {
            class$org$apache$xmlbeans$impl$inst2xsd$util$Element = class$("org.apache.xmlbeans.impl.inst2xsd.util.Element");
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

    public boolean isRef() {
        return this._ref != null;
    }

    public Element getRef() {
        return this._ref;
    }

    public void setRef(Element element) {
        if (!$assertionsDisabled && this._isGlobal) {
            throw new AssertionError();
        }
        this._ref = element;
        this._type = null;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public void setGlobal(boolean z) {
        this._isGlobal = z;
        this._minOccurs = 1;
        this._maxOccurs = 1;
    }

    public int getMinOccurs() {
        return this._minOccurs;
    }

    public void setMinOccurs(int i) {
        this._minOccurs = i;
    }

    public int getMaxOccurs() {
        return this._maxOccurs;
    }

    public void setMaxOccurs(int i) {
        this._maxOccurs = i;
    }

    public boolean isNillable() {
        return this._isNillable;
    }

    public void setNillable(boolean z) {
        this._isNillable = z;
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

    public String getComment() {
        return this._comment;
    }

    public void setComment(String str) {
        this._comment = str;
    }

    public String toString() {
        StringBuffer append = new StringBuffer().append("\n  Element{ _name = ").append(this._name).append(", _ref = ").append(this._ref != null).append(", _isGlobal = ").append(this._isGlobal).append(", _minOccurs = ").append(this._minOccurs).append(", _maxOccurs = ").append(this._maxOccurs).append(", _isNillable = ").append(this._isNillable).append(", _comment = ").append(this._comment).append(",\n    _type = ");
        Type type = this._type;
        return append.append(type == null ? "null" : type.isGlobal() ? this._type.getName().toString() : this._type.toString()).append("\n  }").toString();
    }
}
