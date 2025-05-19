package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.common.ValidatorListener;

/* loaded from: classes5.dex */
final class Validate implements ValidatorListener.Event {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Validate;
    private Cur _cur;
    private boolean _hasText;
    private boolean _oneChunk;
    private ValidatorListener _sink;
    private Cur _textCur;
    private StringBuffer _textSb;

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public Location getLocation() {
        return null;
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Validate == null) {
            class$org$apache$xmlbeans$impl$store$Validate = class$("org.apache.xmlbeans.impl.store.Validate");
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

    Validate(Cur cur, ValidatorListener validatorListener) {
        if (!cur.isUserNode()) {
            throw new IllegalStateException("Inappropriate location to validate");
        }
        this._sink = validatorListener;
        this._cur = cur;
        this._textCur = cur.tempCur();
        this._hasText = false;
        this._cur.push();
        try {
            process();
        } finally {
            this._cur.pop();
            this._cur = null;
            this._sink = null;
            this._textCur.release();
        }
    }

    private void process() {
        emitEvent(1);
        if (this._cur.isAttr()) {
            this._cur.next();
            if (this._cur.isText()) {
                emitText();
            }
        } else {
            if (!$assertionsDisabled && !this._cur.isContainer()) {
                throw new AssertionError();
            }
            doAttrs();
            while (true) {
                this._cur.next();
                if (this._cur.isAtEndOfLastPush()) {
                    break;
                }
                int kind = this._cur.kind();
                if (kind == -2) {
                    emitEvent(2);
                } else if (kind == 0) {
                    emitText();
                } else if (kind == 2) {
                    emitEvent(1);
                    doAttrs();
                } else if (kind == 4 || kind == 5) {
                    this._cur.toEnd();
                } else {
                    throw new RuntimeException(new StringBuffer().append("Unexpected kind: ").append(this._cur.kind()).toString());
                }
            }
        }
        emitEvent(2);
    }

    private void doAttrs() {
        if (!$assertionsDisabled && this._hasText) {
            throw new AssertionError();
        }
        if (this._cur.toFirstAttr()) {
            do {
                if (this._cur.isNormalAttr() && !this._cur.getUri().equals("http://www.w3.org/2001/XMLSchema-instance")) {
                    this._sink.nextEvent(4, this);
                }
            } while (this._cur.toNextAttr());
            this._cur.toParent();
        }
        this._sink.nextEvent(5, this);
    }

    private void emitText() {
        StringBuffer stringBuffer;
        boolean z = $assertionsDisabled;
        if (!z && !this._cur.isText()) {
            throw new AssertionError();
        }
        if (this._hasText) {
            if (this._oneChunk) {
                StringBuffer stringBuffer2 = this._textSb;
                if (stringBuffer2 == null) {
                    this._textSb = new StringBuffer();
                } else {
                    stringBuffer2.delete(0, stringBuffer2.length());
                }
                if (!z && !this._textCur.isText()) {
                    throw new AssertionError();
                }
                CharUtil.getString(this._textSb, this._textCur.getChars(-1), this._textCur._offSrc, this._textCur._cchSrc);
                this._oneChunk = false;
            }
            if (!z && ((stringBuffer = this._textSb) == null || stringBuffer.length() <= 0)) {
                throw new AssertionError();
            }
            CharUtil.getString(this._textSb, this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
            return;
        }
        this._hasText = true;
        this._oneChunk = true;
        this._textCur.moveToCur(this._cur);
    }

    private void emitEvent(int i) {
        boolean z = $assertionsDisabled;
        if (!z && i == 3) {
            throw new AssertionError();
        }
        if (!z && i == 4 && this._hasText) {
            throw new AssertionError();
        }
        if (!z && i == 5 && this._hasText) {
            throw new AssertionError();
        }
        if (this._hasText) {
            this._sink.nextEvent(3, this);
            this._hasText = false;
        }
        this._sink.nextEvent(i, this);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText() {
        StringBuffer stringBuffer;
        if (this._cur.isAttr()) {
            return this._cur.getValueAsString();
        }
        boolean z = $assertionsDisabled;
        if (!z && !this._hasText) {
            throw new AssertionError();
        }
        if (!z && !this._oneChunk && ((stringBuffer = this._textSb) == null || stringBuffer.length() <= 0)) {
            throw new AssertionError();
        }
        if (z || !this._oneChunk || this._textCur.isText()) {
            return this._oneChunk ? this._textCur.getCharsAsString(-1) : this._textSb.toString();
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText(int i) {
        StringBuffer stringBuffer;
        if (this._cur.isAttr()) {
            return this._cur.getValueAsString(i);
        }
        boolean z = $assertionsDisabled;
        if (!z && !this._hasText) {
            throw new AssertionError();
        }
        if (!z && !this._oneChunk && ((stringBuffer = this._textSb) == null || stringBuffer.length() <= 0)) {
            throw new AssertionError();
        }
        if (!z && this._oneChunk && !this._textCur.isText()) {
            throw new AssertionError();
        }
        if (this._oneChunk) {
            return this._textCur.getCharsAsString(-1, i);
        }
        return Locale.applyWhiteSpaceRule(this._textSb.toString(), i);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public boolean textIsWhitespace() {
        if (this._cur.isAttr()) {
            return this._cur._locale.getCharUtil().isWhiteSpace(this._cur.getFirstChars(), this._cur._offSrc, this._cur._cchSrc);
        }
        if (!$assertionsDisabled && !this._hasText) {
            throw new AssertionError();
        }
        if (this._oneChunk) {
            return this._cur._locale.getCharUtil().isWhiteSpace(this._textCur.getChars(-1), this._textCur._offSrc, this._textCur._cchSrc);
        }
        String stringBuffer = this._textSb.toString();
        return this._cur._locale.getCharUtil().isWhiteSpace(stringBuffer, 0, stringBuffer.length());
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        return this._cur.namespaceForPrefix(str, true);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public XmlCursor getLocationAsCursor() {
        return new Cursor(this._cur);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiType() {
        return this._cur.getAttrValue(Locale._xsiType);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNil() {
        return this._cur.getAttrValue(Locale._xsiNil);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiLoc() {
        return this._cur.getAttrValue(Locale._xsiLoc);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNoLoc() {
        return this._cur.getAttrValue(Locale._xsiNoLoc);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public QName getName() {
        if (this._cur.isAtLastPush()) {
            return null;
        }
        return this._cur.getName();
    }
}
