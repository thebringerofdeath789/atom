package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.PrintStream;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.store.Xobj;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
final class Cur {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int DISPOSED = 3;
    static final int ELEM = 2;
    static final int EMBEDDED = 2;
    static final int END_POS = -1;
    static final String LOAD_USE_LOCALE_CHAR_UTIL = "LOAD_USE_LOCALE_CHAR_UTIL";
    static final int NO_POS = -2;
    static final int POOLED = 0;
    static final int PROCINST = 5;
    static final int REGISTERED = 1;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static /* synthetic */ Class class$org$apache$xmlbeans$CDataBookmark;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlLineNumber;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$Detail;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$DetailEntry;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPBody;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPBodyElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPEnvelope;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPFault;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPFaultElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPHeader;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$SOAPHeaderElement;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Cur;
    int _cchSrc;
    String _id;
    Locale _locale;
    Cur _next;
    Cur _nextTemp;
    int _offSrc;
    private int _posTemp;
    Cur _prev;
    Cur _prevTemp;
    Locale.Ref _ref;
    Xobj _xobj;
    int _pos = -2;
    int _tempFrame = -1;
    int _state = 0;
    int _stackTop = -1;
    int _selectionFirst = -1;
    int _selectionN = -1;
    int _selectionLoc = -1;
    int _selectionCount = 0;

    static void dump(PrintStream printStream, DomImpl.Dom dom, Object obj) {
    }

    static boolean kindIsContainer(int i) {
        return i == 2 || i == 1;
    }

    static boolean kindIsFinish(int i) {
        return i == -2 || i == -1;
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Cur == null) {
            class$org$apache$xmlbeans$impl$store$Cur = class$("org.apache.xmlbeans.impl.store.Cur");
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

    Cur(Locale locale) {
        this._locale = locale;
    }

    boolean isPositioned() {
        if ($assertionsDisabled || isNormal()) {
            return this._xobj != null;
        }
        throw new AssertionError();
    }

    int kind() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int kind = this._xobj.kind();
        int i = this._pos;
        if (i == 0) {
            return kind;
        }
        if (i == -1) {
            return -kind;
        }
        return 0;
    }

    boolean isRoot() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 1;
        }
        throw new AssertionError();
    }

    boolean isElem() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 2;
        }
        throw new AssertionError();
    }

    boolean isAttr() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 3;
        }
        throw new AssertionError();
    }

    boolean isComment() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 4;
        }
        throw new AssertionError();
    }

    boolean isProcinst() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && this._xobj.kind() == 5;
        }
        throw new AssertionError();
    }

    boolean isText() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos > 0;
        }
        throw new AssertionError();
    }

    boolean isEnd() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == -1 && this._xobj.kind() == 2;
        }
        throw new AssertionError();
    }

    boolean isEndRoot() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == -1 && this._xobj.kind() == 1;
        }
        throw new AssertionError();
    }

    boolean isNode() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0;
        }
        throw new AssertionError();
    }

    boolean isContainer() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == 0 && kindIsContainer(this._xobj.kind());
        }
        throw new AssertionError();
    }

    boolean isFinish() {
        if ($assertionsDisabled || isPositioned()) {
            return this._pos == -1 && kindIsContainer(this._xobj.kind());
        }
        throw new AssertionError();
    }

    boolean isUserNode() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int kind = kind();
        if (kind == 2 || kind == 1) {
            return true;
        }
        return kind == 3 && !isXmlns();
    }

    boolean isContainerOrFinish() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i != 0 && i != -1) {
            return false;
        }
        int kind = this._xobj.kind();
        return kind == 2 || kind == -2 || kind == 1 || kind == -1;
    }

    boolean isNormalAttr() {
        return isNode() && this._xobj.isNormalAttr();
    }

    boolean isXmlns() {
        return isNode() && this._xobj.isXmlns();
    }

    boolean isTextCData() {
        Xobj xobj = this._xobj;
        Class cls = class$org$apache$xmlbeans$CDataBookmark;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.CDataBookmark");
            class$org$apache$xmlbeans$CDataBookmark = cls;
        }
        return xobj.hasBookmark(cls, this._pos);
    }

    QName getName() {
        if ($assertionsDisabled || isNode() || isEnd()) {
            return this._xobj._name;
        }
        throw new AssertionError();
    }

    String getLocal() {
        return getName().getLocalPart();
    }

    String getUri() {
        return getName().getNamespaceURI();
    }

    String getXmlnsPrefix() {
        if ($assertionsDisabled || isXmlns()) {
            return this._xobj.getXmlnsPrefix();
        }
        throw new AssertionError();
    }

    String getXmlnsUri() {
        if ($assertionsDisabled || isXmlns()) {
            return this._xobj.getXmlnsUri();
        }
        throw new AssertionError();
    }

    boolean isDomDocRoot() {
        return isRoot() && (this._xobj.getDom() instanceof Document);
    }

    boolean isDomFragRoot() {
        return isRoot() && (this._xobj.getDom() instanceof DocumentFragment);
    }

    int cchRight() {
        if ($assertionsDisabled || isPositioned()) {
            return this._xobj.cchRight(this._pos);
        }
        throw new AssertionError();
    }

    int cchLeft() {
        if ($assertionsDisabled || isPositioned()) {
            return this._xobj.cchLeft(this._pos);
        }
        throw new AssertionError();
    }

    void createRoot() {
        createDomDocFragRoot();
    }

    void createDomDocFragRoot() {
        moveTo(new Xobj.DocumentFragXobj(this._locale));
    }

    void createDomDocumentRoot() {
        moveTo(createDomDocumentRootXobj(this._locale));
    }

    void createAttr(QName qName) {
        createHelper(new Xobj.AttrXobj(this._locale, qName));
    }

    void createComment() {
        createHelper(new Xobj.CommentXobj(this._locale));
    }

    void createProcinst(String str) {
        createHelper(new Xobj.ProcInstXobj(this._locale, str));
    }

    void createElement(QName qName) {
        createElement(qName, null);
    }

    void createElement(QName qName, QName qName2) {
        createHelper(createElementXobj(this._locale, qName, qName2));
    }

    static Xobj createDomDocumentRootXobj(Locale locale) {
        return createDomDocumentRootXobj(locale, false);
    }

    static Xobj createDomDocumentRootXobj(Locale locale, boolean z) {
        Xobj soapPartDocXobj;
        if (locale._saaj != null) {
            soapPartDocXobj = new Xobj.SoapPartDocXobj(locale);
        } else if (z) {
            soapPartDocXobj = new Xobj.DocumentFragXobj(locale);
        } else {
            soapPartDocXobj = new Xobj.DocumentXobj(locale);
        }
        if (locale._ownerDoc == null) {
            locale._ownerDoc = soapPartDocXobj.getDom();
        }
        return soapPartDocXobj;
    }

    static Xobj createElementXobj(Locale locale, QName qName, QName qName2) {
        if (locale._saaj == null) {
            return new Xobj.ElementXobj(locale, qName);
        }
        Class identifyElement = locale._saaj.identifyElement(qName, qName2);
        Class cls = class$org$apache$xmlbeans$impl$soap$SOAPElement;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.soap.SOAPElement");
            class$org$apache$xmlbeans$impl$soap$SOAPElement = cls;
        }
        if (identifyElement == cls) {
            return new Xobj.SoapElementXobj(locale, qName);
        }
        Class cls2 = class$org$apache$xmlbeans$impl$soap$SOAPBody;
        if (cls2 == null) {
            cls2 = class$("org.apache.xmlbeans.impl.soap.SOAPBody");
            class$org$apache$xmlbeans$impl$soap$SOAPBody = cls2;
        }
        if (identifyElement == cls2) {
            return new Xobj.SoapBodyXobj(locale, qName);
        }
        Class cls3 = class$org$apache$xmlbeans$impl$soap$SOAPBodyElement;
        if (cls3 == null) {
            cls3 = class$("org.apache.xmlbeans.impl.soap.SOAPBodyElement");
            class$org$apache$xmlbeans$impl$soap$SOAPBodyElement = cls3;
        }
        if (identifyElement == cls3) {
            return new Xobj.SoapBodyElementXobj(locale, qName);
        }
        Class cls4 = class$org$apache$xmlbeans$impl$soap$SOAPEnvelope;
        if (cls4 == null) {
            cls4 = class$("org.apache.xmlbeans.impl.soap.SOAPEnvelope");
            class$org$apache$xmlbeans$impl$soap$SOAPEnvelope = cls4;
        }
        if (identifyElement == cls4) {
            return new Xobj.SoapEnvelopeXobj(locale, qName);
        }
        Class cls5 = class$org$apache$xmlbeans$impl$soap$SOAPHeader;
        if (cls5 == null) {
            cls5 = class$("org.apache.xmlbeans.impl.soap.SOAPHeader");
            class$org$apache$xmlbeans$impl$soap$SOAPHeader = cls5;
        }
        if (identifyElement == cls5) {
            return new Xobj.SoapHeaderXobj(locale, qName);
        }
        Class cls6 = class$org$apache$xmlbeans$impl$soap$SOAPHeaderElement;
        if (cls6 == null) {
            cls6 = class$("org.apache.xmlbeans.impl.soap.SOAPHeaderElement");
            class$org$apache$xmlbeans$impl$soap$SOAPHeaderElement = cls6;
        }
        if (identifyElement == cls6) {
            return new Xobj.SoapHeaderElementXobj(locale, qName);
        }
        Class cls7 = class$org$apache$xmlbeans$impl$soap$SOAPFaultElement;
        if (cls7 == null) {
            cls7 = class$("org.apache.xmlbeans.impl.soap.SOAPFaultElement");
            class$org$apache$xmlbeans$impl$soap$SOAPFaultElement = cls7;
        }
        if (identifyElement == cls7) {
            return new Xobj.SoapFaultElementXobj(locale, qName);
        }
        Class cls8 = class$org$apache$xmlbeans$impl$soap$Detail;
        if (cls8 == null) {
            cls8 = class$("org.apache.xmlbeans.impl.soap.Detail");
            class$org$apache$xmlbeans$impl$soap$Detail = cls8;
        }
        if (identifyElement == cls8) {
            return new Xobj.DetailXobj(locale, qName);
        }
        Class cls9 = class$org$apache$xmlbeans$impl$soap$DetailEntry;
        if (cls9 == null) {
            cls9 = class$("org.apache.xmlbeans.impl.soap.DetailEntry");
            class$org$apache$xmlbeans$impl$soap$DetailEntry = cls9;
        }
        if (identifyElement == cls9) {
            return new Xobj.DetailEntryXobj(locale, qName);
        }
        Class cls10 = class$org$apache$xmlbeans$impl$soap$SOAPFault;
        if (cls10 == null) {
            cls10 = class$("org.apache.xmlbeans.impl.soap.SOAPFault");
            class$org$apache$xmlbeans$impl$soap$SOAPFault = cls10;
        }
        if (identifyElement == cls10) {
            return new Xobj.SoapFaultXobj(locale, qName);
        }
        throw new IllegalStateException(new StringBuffer().append("Unknown SAAJ element class: ").append(identifyElement).toString());
    }

    private void createHelper(Xobj xobj) {
        if (!$assertionsDisabled && xobj._locale != this._locale) {
            throw new AssertionError();
        }
        if (isPositioned()) {
            Cur tempCur = tempCur(xobj, 0);
            tempCur.moveNode(this);
            tempCur.release();
        }
        moveTo(xobj);
    }

    boolean isSamePos(Cur cur) {
        if ($assertionsDisabled || (isNormal() && (cur == null || cur.isNormal()))) {
            return this._xobj == cur._xobj && this._pos == cur._pos;
        }
        throw new AssertionError();
    }

    boolean isJustAfterEnd(Cur cur) {
        if ($assertionsDisabled || (isNormal() && cur != null && cur.isNormal() && cur.isNode())) {
            return cur._xobj.isJustAfterEnd(this._xobj, this._pos);
        }
        throw new AssertionError();
    }

    boolean isJustAfterEnd(Xobj xobj) {
        return xobj.isJustAfterEnd(this._xobj, this._pos);
    }

    boolean isAtEndOf(Cur cur) {
        if ($assertionsDisabled || (cur != null && cur.isNormal() && cur.isNode())) {
            return this._xobj == cur._xobj && this._pos == -1;
        }
        throw new AssertionError();
    }

    boolean isInSameTree(Cur cur) {
        if ($assertionsDisabled || (isPositioned() && cur.isPositioned())) {
            return this._xobj.isInSameTree(cur._xobj);
        }
        throw new AssertionError();
    }

    int comparePosition(Cur cur) {
        if (!$assertionsDisabled && (!isPositioned() || !cur.isPositioned())) {
            throw new AssertionError();
        }
        if (this._locale != cur._locale) {
            return 2;
        }
        Xobj xobj = this._xobj;
        int i = this._pos;
        if (i == -1) {
            i = xobj.posAfter() - 1;
        }
        Xobj xobj2 = cur._xobj;
        int i2 = cur._pos;
        if (i2 == -1) {
            i2 = xobj2.posAfter() - 1;
        }
        int i3 = 0;
        if (xobj == xobj2) {
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
        int i4 = 0;
        for (Xobj xobj3 = xobj._parent; xobj3 != null; xobj3 = xobj3._parent) {
            i4++;
            if (xobj3 == xobj2) {
                return i2 < xobj2.posAfter() - 1 ? 1 : -1;
            }
        }
        for (Xobj xobj4 = xobj2._parent; xobj4 != null; xobj4 = xobj4._parent) {
            i3++;
            if (xobj4 == xobj) {
                return i < xobj.posAfter() - 1 ? -1 : 1;
            }
        }
        while (i4 > i3) {
            i4--;
            xobj = xobj._parent;
        }
        while (i3 > i4) {
            i3--;
            xobj2 = xobj2._parent;
        }
        boolean z = $assertionsDisabled;
        if (!z && i3 != i4) {
            throw new AssertionError();
        }
        if (i3 == 0) {
            return 2;
        }
        if (!z && (xobj._parent == null || xobj2._parent == null)) {
            throw new AssertionError();
        }
        while (xobj._parent != xobj2._parent) {
            xobj = xobj._parent;
            if (xobj == null) {
                return 2;
            }
            xobj2 = xobj2._parent;
        }
        if (xobj._prevSibling == null || xobj2._nextSibling == null) {
            return -1;
        }
        if (xobj._nextSibling == null || xobj2._prevSibling == null) {
            return 1;
        }
        while (xobj != null) {
            xobj = xobj._prevSibling;
            if (xobj == xobj2) {
                return 1;
            }
        }
        return -1;
    }

    void setName(QName qName) {
        if (!$assertionsDisabled && (!isNode() || qName == null)) {
            throw new AssertionError();
        }
        this._xobj.setName(qName);
    }

    void moveTo(Xobj xobj) {
        moveTo(xobj, 0);
    }

    void moveTo(Xobj xobj, int i) {
        Xobj xobj2;
        Xobj xobj3;
        int i2;
        boolean z = $assertionsDisabled;
        if (!z && xobj != null && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj == null && i != -2) {
            throw new AssertionError();
        }
        if (!z && xobj != null && !xobj.isNormal(i) && (!xobj.isVacant() || xobj._cchValue != 0 || xobj._user != null)) {
            throw new AssertionError();
        }
        if (!z && (i2 = this._state) != 1 && i2 != 2) {
            throw new AssertionError();
        }
        if (!z && this._state != 2 && (xobj3 = this._xobj) != null && isOnList(xobj3._embedded)) {
            throw new AssertionError();
        }
        if (!z && this._state != 1 && ((xobj2 = this._xobj) == null || !isOnList(xobj2._embedded))) {
            throw new AssertionError();
        }
        moveToNoCheck(xobj, i);
        if (z || isNormal()) {
            return;
        }
        if (!this._xobj.isVacant() || this._xobj._cchValue != 0 || this._xobj._user != null) {
            throw new AssertionError();
        }
    }

    void moveToNoCheck(Xobj xobj, int i) {
        Xobj xobj2;
        if (this._state == 2 && xobj != (xobj2 = this._xobj)) {
            xobj2._embedded = listRemove(xobj2._embedded);
            Locale locale = this._locale;
            locale._registered = listInsert(locale._registered);
            this._state = 1;
        }
        this._xobj = xobj;
        this._pos = i;
    }

    void moveToCur(Cur cur) {
        if (!$assertionsDisabled && (!isNormal() || (cur != null && !cur.isNormal()))) {
            throw new AssertionError();
        }
        if (cur == null) {
            moveTo(null, -2);
        } else {
            moveTo(cur._xobj, cur._pos);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void moveToDom(DomImpl.Dom dom) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != dom.locale()) {
            throw new AssertionError();
        }
        if (!z && !(dom instanceof Xobj) && !(dom instanceof Xobj.SoapPartDom)) {
            throw new AssertionError();
        }
        moveTo(dom instanceof Xobj ? (Xobj) dom : ((Xobj.SoapPartDom) dom)._docXobj);
    }

    static final class Locations {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final int NULL = -1;
        private static final int _initialSize = 32;
        private int _free;
        private Locale _locale;
        private int _naked;
        private Xobj[] _xobjs = new Xobj[32];
        private int[] _poses = new int[32];
        private Cur[] _curs = new Cur[32];
        private int[] _next = new int[32];
        private int[] _prev = new int[32];
        private int[] _nextN = new int[32];
        private int[] _prevN = new int[32];

        static {
            if (Cur.class$org$apache$xmlbeans$impl$store$Cur == null) {
                Cur.class$org$apache$xmlbeans$impl$store$Cur = Cur.class$("org.apache.xmlbeans.impl.store.Cur");
            } else {
                Class cls = Cur.class$org$apache$xmlbeans$impl$store$Cur;
            }
            $assertionsDisabled = true;
        }

        Locations(Locale locale) {
            this._locale = locale;
            for (int i = 31; i >= 0; i--) {
                if (!$assertionsDisabled && this._xobjs[i] != null) {
                    throw new AssertionError();
                }
                this._poses[i] = -2;
                this._next[i] = i + 1;
                this._prev[i] = -1;
                this._nextN[i] = -1;
                this._prevN[i] = -1;
            }
            this._next[31] = -1;
            this._free = 0;
            this._naked = -1;
        }

        boolean isSamePos(int i, Cur cur) {
            Cur[] curArr = this._curs;
            if (curArr[i] == null) {
                return cur._xobj == this._xobjs[i] && cur._pos == this._poses[i];
            }
            return cur.isSamePos(curArr[i]);
        }

        boolean isAtEndOf(int i, Cur cur) {
            boolean z = $assertionsDisabled;
            if (!z && this._curs[i] == null && this._poses[i] != 0) {
                throw new AssertionError();
            }
            if (!z) {
                Cur[] curArr = this._curs;
                if (curArr[i] != null && !curArr[i].isNode()) {
                    throw new AssertionError();
                }
            }
            Cur[] curArr2 = this._curs;
            if (curArr2[i] == null) {
                return cur._xobj == this._xobjs[i] && cur._pos == -1;
            }
            return cur.isAtEndOf(curArr2[i]);
        }

        void moveTo(int i, Cur cur) {
            Cur[] curArr = this._curs;
            if (curArr[i] == null) {
                cur.moveTo(this._xobjs[i], this._poses[i]);
            } else {
                cur.moveToCur(curArr[i]);
            }
        }

        int insert(int i, int i2, int i3) {
            return insert(i, i2, i3, this._next, this._prev);
        }

        int remove(int i, int i2) {
            Cur[] curArr = this._curs;
            Cur cur = curArr[i2];
            boolean z = $assertionsDisabled;
            if (!z && cur == null && this._xobjs[i2] == null) {
                throw new AssertionError();
            }
            if (!z && cur == null && this._xobjs[i2] == null) {
                throw new AssertionError();
            }
            if (cur != null) {
                curArr[i2].release();
                this._curs[i2] = null;
                if (!z && this._xobjs[i2] != null) {
                    throw new AssertionError();
                }
                if (!z && this._poses[i2] != -2) {
                    throw new AssertionError();
                }
            } else {
                if (!z && (this._xobjs[i2] == null || this._poses[i2] == -2)) {
                    throw new AssertionError();
                }
                this._xobjs[i2] = null;
                this._poses[i2] = -2;
                this._naked = remove(this._naked, i2, this._nextN, this._prevN);
            }
            int remove = remove(i, i2, this._next, this._prev);
            this._next[i2] = this._free;
            this._free = i2;
            return remove;
        }

        int allocate(Cur cur) {
            boolean z = $assertionsDisabled;
            if (!z && !cur.isPositioned()) {
                throw new AssertionError();
            }
            if (this._free == -1) {
                makeRoom();
            }
            int i = this._free;
            int[] iArr = this._next;
            this._free = iArr[i];
            iArr[i] = -1;
            if (!z && this._prev[i] != -1) {
                throw new AssertionError();
            }
            if (!z && this._curs[i] != null) {
                throw new AssertionError();
            }
            if (!z && this._xobjs[i] != null) {
                throw new AssertionError();
            }
            if (!z && this._poses[i] != -2) {
                throw new AssertionError();
            }
            this._xobjs[i] = cur._xobj;
            this._poses[i] = cur._pos;
            this._naked = insert(this._naked, -1, i, this._nextN, this._prevN);
            return i;
        }

        private static int insert(int i, int i2, int i3, int[] iArr, int[] iArr2) {
            if (i == -1) {
                if (!$assertionsDisabled && i2 != -1) {
                    throw new AssertionError();
                }
                iArr2[i3] = i3;
            } else if (i2 != -1) {
                iArr2[i3] = iArr2[i2];
                iArr[i3] = i2;
                iArr2[i2] = i3;
                if (i != i2) {
                    return i;
                }
            } else {
                iArr2[i3] = iArr2[i];
                if (!$assertionsDisabled && iArr[i3] != -1) {
                    throw new AssertionError();
                }
                iArr[iArr2[i]] = i3;
                iArr2[i] = i3;
                return i;
            }
            return i3;
        }

        private static int remove(int i, int i2, int[] iArr, int[] iArr2) {
            if (iArr2[i2] == i2) {
                if (!$assertionsDisabled && i != i2) {
                    throw new AssertionError();
                }
                i = -1;
            } else {
                if (i == i2) {
                    i = iArr[i2];
                } else {
                    iArr[iArr2[i2]] = iArr[i2];
                }
                if (iArr[i2] == -1) {
                    iArr2[i] = iArr2[i2];
                } else {
                    iArr2[iArr[i2]] = iArr2[i2];
                    iArr[i2] = -1;
                }
            }
            iArr2[i2] = -1;
            if ($assertionsDisabled || iArr[i2] == -1) {
                return i;
            }
            throw new AssertionError();
        }

        void notifyChange() {
            while (true) {
                int i = this._naked;
                if (i == -1) {
                    return;
                }
                if ($assertionsDisabled || (this._curs[i] == null && this._xobjs[i] != null && this._poses[i] != -2)) {
                    this._naked = remove(i, i, this._nextN, this._prevN);
                    this._curs[i] = this._locale.getCur();
                    this._curs[i].moveTo(this._xobjs[i], this._poses[i]);
                    this._xobjs[i] = null;
                    this._poses[i] = -2;
                }
            }
            throw new AssertionError();
        }

        int next(int i) {
            return this._next[i];
        }

        int prev(int i) {
            return this._prev[i];
        }

        private void makeRoom() {
            if (!$assertionsDisabled && this._free != -1) {
                throw new AssertionError();
            }
            Xobj[] xobjArr = this._xobjs;
            int length = xobjArr.length;
            int[] iArr = this._poses;
            Cur[] curArr = this._curs;
            int[] iArr2 = this._next;
            int[] iArr3 = this._prev;
            int[] iArr4 = this._nextN;
            int[] iArr5 = this._prevN;
            int i = length * 2;
            Xobj[] xobjArr2 = new Xobj[i];
            this._xobjs = xobjArr2;
            this._poses = new int[i];
            this._curs = new Cur[i];
            this._next = new int[i];
            this._prev = new int[i];
            this._nextN = new int[i];
            this._prevN = new int[i];
            System.arraycopy(xobjArr, 0, xobjArr2, 0, length);
            System.arraycopy(iArr, 0, this._poses, 0, length);
            System.arraycopy(curArr, 0, this._curs, 0, length);
            System.arraycopy(iArr2, 0, this._next, 0, length);
            System.arraycopy(iArr3, 0, this._prev, 0, length);
            System.arraycopy(iArr4, 0, this._nextN, 0, length);
            System.arraycopy(iArr5, 0, this._prevN, 0, length);
            int i2 = i - 1;
            for (int i3 = i2; i3 >= length; i3--) {
                this._next[i3] = i3 + 1;
                this._prev[i3] = -1;
                this._nextN[i3] = -1;
                this._prevN[i3] = -1;
                this._poses[i3] = -2;
            }
            this._next[i2] = -1;
            this._free = length;
        }
    }

    void push() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int allocate = this._locale._locations.allocate(this);
        Locations locations = this._locale._locations;
        int i = this._stackTop;
        this._stackTop = locations.insert(i, i, allocate);
    }

    void pop(boolean z) {
        if (z) {
            popButStay();
        } else {
            pop();
        }
    }

    void popButStay() {
        if (this._stackTop != -1) {
            Locations locations = this._locale._locations;
            int i = this._stackTop;
            this._stackTop = locations.remove(i, i);
        }
    }

    boolean pop() {
        if (this._stackTop == -1) {
            return false;
        }
        this._locale._locations.moveTo(this._stackTop, this);
        Locations locations = this._locale._locations;
        int i = this._stackTop;
        this._stackTop = locations.remove(i, i);
        return true;
    }

    boolean isAtLastPush() {
        if ($assertionsDisabled || this._stackTop != -1) {
            return this._locale._locations.isSamePos(this._stackTop, this);
        }
        throw new AssertionError();
    }

    boolean isAtEndOfLastPush() {
        if ($assertionsDisabled || this._stackTop != -1) {
            return this._locale._locations.isAtEndOf(this._stackTop, this);
        }
        throw new AssertionError();
    }

    void addToSelection(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (cur == null || !cur.isNormal())) {
            throw new AssertionError();
        }
        if (!z && (!isPositioned() || !cur.isPositioned())) {
            throw new AssertionError();
        }
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(cur));
        this._selectionCount++;
    }

    void addToSelection() {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(this));
        this._selectionCount++;
    }

    private int selectionIndex(int i) {
        if (!$assertionsDisabled && (this._selectionN < -1 || i < 0 || i >= this._selectionCount)) {
            throw new AssertionError();
        }
        if (this._selectionN == -1) {
            this._selectionN = 0;
            this._selectionLoc = this._selectionFirst;
        }
        while (this._selectionN < i) {
            this._selectionLoc = this._locale._locations.next(this._selectionLoc);
            this._selectionN++;
        }
        while (this._selectionN > i) {
            this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            this._selectionN--;
        }
        return this._selectionLoc;
    }

    void removeSelection(int i) {
        if (!$assertionsDisabled && (i < 0 || i >= this._selectionCount)) {
            throw new AssertionError();
        }
        int selectionIndex = selectionIndex(i);
        int i2 = this._selectionN;
        if (i < i2) {
            this._selectionN = i2 - 1;
        } else if (i == i2) {
            this._selectionN = i2 - 1;
            if (i == 0) {
                this._selectionLoc = -1;
            } else {
                this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            }
        }
        this._selectionFirst = this._locale._locations.remove(this._selectionFirst, selectionIndex);
        this._selectionCount--;
    }

    int selectionCount() {
        return this._selectionCount;
    }

    void moveToSelection(int i) {
        if (!$assertionsDisabled && (i < 0 || i >= this._selectionCount)) {
            throw new AssertionError();
        }
        this._locale._locations.moveTo(selectionIndex(i), this);
    }

    void clearSelection() {
        if (!$assertionsDisabled && this._selectionCount < 0) {
            throw new AssertionError();
        }
        while (this._selectionCount > 0) {
            removeSelection(0);
        }
    }

    boolean toParent() {
        return toParent(false);
    }

    boolean toParentRaw() {
        return toParent(true);
    }

    Xobj getParent() {
        return getParent(false);
    }

    Xobj getParentRaw() {
        return getParent(true);
    }

    boolean hasParent() {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i == -1) {
            return true;
        }
        if (i >= 1 && i < this._xobj.posAfter()) {
            return true;
        }
        if (z || this._pos == 0 || this._xobj._parent != null) {
            return this._xobj._parent != null;
        }
        throw new AssertionError();
    }

    Xobj getParentNoRoot() {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return this._xobj;
        }
        if (!z && this._pos != 0 && this._xobj._parent == null) {
            throw new AssertionError();
        }
        if (this._xobj._parent != null) {
            return this._xobj._parent;
        }
        return null;
    }

    Xobj getParent(boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && !isPositioned()) {
            throw new AssertionError();
        }
        int i = this._pos;
        if (i == -1 || (i >= 1 && i < this._xobj.posAfter())) {
            return this._xobj;
        }
        if (!z2 && this._pos != 0 && this._xobj._parent == null) {
            throw new AssertionError();
        }
        if (this._xobj._parent != null) {
            return this._xobj._parent;
        }
        if (z || this._xobj.isRoot()) {
            return null;
        }
        Cur tempCur = this._locale.tempCur();
        tempCur.createRoot();
        Xobj xobj = tempCur._xobj;
        tempCur.next();
        moveNode(tempCur);
        tempCur.release();
        return xobj;
    }

    boolean toParent(boolean z) {
        Xobj parent = getParent(z);
        if (parent == null) {
            return false;
        }
        moveTo(parent);
        return true;
    }

    void toRoot() {
        Xobj xobj = this._xobj;
        while (true) {
            if (xobj.isRoot()) {
                break;
            }
            if (xobj._parent == null) {
                Cur tempCur = this._locale.tempCur();
                tempCur.createRoot();
                Xobj xobj2 = tempCur._xobj;
                tempCur.next();
                moveNode(tempCur);
                tempCur.release();
                xobj = xobj2;
                break;
            }
            xobj = xobj._parent;
        }
        moveTo(xobj);
    }

    boolean hasText() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.hasTextEnsureOccupancy();
        }
        throw new AssertionError();
    }

    boolean hasAttrs() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.hasAttrs();
        }
        throw new AssertionError();
    }

    boolean hasChildren() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.hasChildren();
        }
        throw new AssertionError();
    }

    boolean toFirstChild() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!this._xobj.hasChildren()) {
            return false;
        }
        Xobj xobj = this._xobj._firstChild;
        while (xobj.isAttr()) {
            xobj = xobj._nextSibling;
        }
        moveTo(xobj);
        return true;
    }

    protected boolean toLastChild() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!this._xobj.hasChildren()) {
            return false;
        }
        moveTo(this._xobj._lastChild);
        return true;
    }

    boolean toNextSibling() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (this._xobj.isAttr()) {
            if (this._xobj._nextSibling == null || !this._xobj._nextSibling.isAttr()) {
                return false;
            }
            moveTo(this._xobj._nextSibling);
            return true;
        }
        if (this._xobj._nextSibling == null) {
            return false;
        }
        moveTo(this._xobj._nextSibling);
        return true;
    }

    void setValueAsQName(QName qName) {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        String localPart = qName.getLocalPart();
        String prefixForNamespace = prefixForNamespace(qName.getNamespaceURI(), qName.getPrefix().length() > 0 ? qName.getPrefix() : null, true);
        if (prefixForNamespace.length() > 0) {
            localPart = new StringBuffer().append(prefixForNamespace).append(":").append(localPart).toString();
        }
        setValue(localPart);
    }

    void setValue(String str) {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        moveNodeContents(null, false);
        next();
        insertString(str);
        toParent();
    }

    void removeFollowingAttrs() {
        if (!$assertionsDisabled && !isAttr()) {
            throw new AssertionError();
        }
        QName name = getName();
        push();
        if (toNextAttr()) {
            while (isAttr()) {
                if (getName().equals(name)) {
                    moveNode(null);
                } else if (!toNextAttr()) {
                    break;
                }
            }
        }
        pop();
    }

    String getAttrValue(QName qName) {
        push();
        String valueAsString = toAttr(qName) ? getValueAsString() : null;
        pop();
        return valueAsString;
    }

    void setAttrValueAsQName(QName qName, QName qName2) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        if (qName2 == null) {
            this._xobj.removeAttr(qName);
            return;
        }
        if (toAttr(qName)) {
            removeFollowingAttrs();
        } else {
            next();
            createAttr(qName);
        }
        setValueAsQName(qName2);
        toParent();
    }

    boolean removeAttr(QName qName) {
        if ($assertionsDisabled || isContainer()) {
            return this._xobj.removeAttr(qName);
        }
        throw new AssertionError();
    }

    void setAttrValue(QName qName, String str) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        this._xobj.setAttr(qName, str);
    }

    boolean toAttr(QName qName) {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        Xobj attr = this._xobj.getAttr(qName);
        if (attr == null) {
            return false;
        }
        moveTo(attr);
        return true;
    }

    boolean toFirstAttr() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        Xobj firstAttr = this._xobj.firstAttr();
        if (firstAttr == null) {
            return false;
        }
        moveTo(firstAttr);
        return true;
    }

    boolean toLastAttr() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (!toFirstAttr()) {
            return false;
        }
        while (toNextAttr()) {
        }
        return true;
    }

    boolean toNextAttr() {
        if (!$assertionsDisabled && !isAttr() && !isContainer()) {
            throw new AssertionError();
        }
        Xobj nextAttr = this._xobj.nextAttr();
        if (nextAttr == null) {
            return false;
        }
        moveTo(nextAttr);
        return true;
    }

    boolean toPrevAttr() {
        if (isAttr()) {
            if (this._xobj._prevSibling == null) {
                moveTo(this._xobj.ensureParent());
                return true;
            }
            moveTo(this._xobj._prevSibling);
            return true;
        }
        prev();
        if (!isContainer()) {
            next();
            return false;
        }
        return toLastAttr();
    }

    boolean skipWithAttrs() {
        boolean z = $assertionsDisabled;
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        if (skip()) {
            return true;
        }
        if (this._xobj.isRoot()) {
            return false;
        }
        if (!z && !this._xobj.isAttr()) {
            throw new AssertionError();
        }
        toParent();
        next();
        return true;
    }

    boolean skip() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        if (this._xobj.isRoot()) {
            return false;
        }
        if (this._xobj.isAttr()) {
            if (this._xobj._nextSibling == null || !this._xobj._nextSibling.isAttr()) {
                return false;
            }
            moveTo(this._xobj._nextSibling, 0);
            return true;
        }
        Xobj xobj = this._xobj;
        moveTo(getNormal(xobj, xobj.posAfter()), this._posTemp);
        return true;
    }

    void toEnd() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        moveTo(this._xobj, -1);
    }

    void moveToCharNode(DomImpl.CharNode charNode) {
        if (!$assertionsDisabled && (charNode.getDom() == null || charNode.getDom().locale() != this._locale)) {
            throw new AssertionError();
        }
        moveToDom(charNode.getDom());
        this._xobj.ensureOccupancy();
        Xobj xobj = this._xobj;
        DomImpl.CharNode updateCharNodes = updateCharNodes(this._locale, xobj, xobj._charNodesValue, this._xobj._cchValue);
        xobj._charNodesValue = updateCharNodes;
        while (updateCharNodes != null) {
            if (charNode != updateCharNodes) {
                updateCharNodes = updateCharNodes._next;
            } else {
                moveTo(getNormal(this._xobj, updateCharNodes._off + 1), this._posTemp);
                return;
            }
        }
        Xobj xobj2 = this._xobj;
        DomImpl.CharNode updateCharNodes2 = updateCharNodes(this._locale, xobj2, xobj2._charNodesAfter, this._xobj._cchAfter);
        xobj2._charNodesAfter = updateCharNodes2;
        while (updateCharNodes2 != null) {
            if (charNode != updateCharNodes2) {
                updateCharNodes2 = updateCharNodes2._next;
            } else {
                moveTo(getNormal(this._xobj, updateCharNodes2._off + this._xobj._cchValue + 2), this._posTemp);
                return;
            }
        }
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
    }

    boolean prevWithAttrs() {
        if (prev()) {
            return true;
        }
        if (!isAttr()) {
            return false;
        }
        toParent();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
    
        if (r1._cchValue > 0) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean prev() {
        /*
            r7 = this;
            boolean r0 = org.apache.xmlbeans.impl.store.Cur.$assertionsDisabled
            if (r0 != 0) goto L11
            boolean r1 = r7.isPositioned()
            if (r1 == 0) goto Lb
            goto L11
        Lb:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L11:
            org.apache.xmlbeans.impl.store.Xobj r1 = r7._xobj
            boolean r1 = r1.isRoot()
            r2 = 0
            if (r1 == 0) goto L1f
            int r1 = r7._pos
            if (r1 != 0) goto L1f
            return r2
        L1f:
            org.apache.xmlbeans.impl.store.Xobj r1 = r7._xobj
            boolean r1 = r1.isAttr()
            if (r1 == 0) goto L32
            int r1 = r7._pos
            if (r1 != 0) goto L32
            org.apache.xmlbeans.impl.store.Xobj r1 = r7._xobj
            org.apache.xmlbeans.impl.store.Xobj r1 = r1._prevSibling
            if (r1 != 0) goto L32
            return r2
        L32:
            org.apache.xmlbeans.impl.store.Xobj r1 = r7.getDenormal()
            int r3 = r7._posTemp
            r4 = -1
            if (r0 != 0) goto L46
            if (r3 <= 0) goto L40
            if (r3 == r4) goto L40
            goto L46
        L40:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L46:
            int r5 = r1.posAfter()
            r6 = 1
            if (r3 <= r5) goto L4f
            r2 = r5
            goto L89
        L4f:
            if (r3 != r5) goto L6e
            boolean r0 = r1.isAttr()
            if (r0 == 0) goto L6c
            int r0 = r1._cchAfter
            if (r0 > 0) goto L67
            org.apache.xmlbeans.impl.store.Xobj r0 = r1._nextSibling
            if (r0 == 0) goto L67
            org.apache.xmlbeans.impl.store.Xobj r0 = r1._nextSibling
            boolean r0 = r0.isAttr()
            if (r0 != 0) goto L6c
        L67:
            org.apache.xmlbeans.impl.store.Xobj r1 = r1.ensureParent()
            goto L89
        L6c:
            r2 = r4
            goto L89
        L6e:
            int r5 = r5 + (-1)
            if (r3 != r5) goto L7a
            r1.ensureOccupancy()
            int r0 = r1._cchValue
            if (r0 <= 0) goto L89
            goto L7c
        L7a:
            if (r3 <= r6) goto L7e
        L7c:
            r2 = r6
            goto L89
        L7e:
            if (r0 != 0) goto L89
            if (r3 != r6) goto L83
            goto L89
        L83:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L89:
            org.apache.xmlbeans.impl.store.Xobj r0 = r7.getNormal(r1, r2)
            int r1 = r7._posTemp
            r7.moveTo(r0, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Cur.prev():boolean");
    }

    boolean next(boolean z) {
        return z ? nextWithAttrs() : next();
    }

    boolean nextWithAttrs() {
        int kind = kind();
        if (kindIsContainer(kind)) {
            if (toFirstAttr()) {
                return true;
            }
        } else if (kind == -3) {
            if (next()) {
                return true;
            }
            toParent();
            if (!toParentRaw()) {
                return false;
            }
        }
        return next();
    }

    boolean next() {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        Xobj xobj = this._xobj;
        int i = this._pos;
        int posAfter = xobj.posAfter();
        if (i >= posAfter) {
            posAfter = this._xobj.posMax();
        } else if (i == -1) {
            if (xobj.isRoot() || (xobj.isAttr() && (xobj._nextSibling == null || !xobj._nextSibling.isAttr()))) {
                return false;
            }
        } else if (i > 0) {
            if (!z && xobj._firstChild != null && xobj._firstChild.isAttr()) {
                throw new AssertionError();
            }
            if (xobj._firstChild != null) {
                xobj = xobj._firstChild;
                posAfter = 0;
            } else {
                posAfter = -1;
            }
        } else {
            if (!z && i != 0) {
                throw new AssertionError();
            }
            xobj.ensureOccupancy();
            if (xobj._cchValue == 0 && xobj._firstChild != null) {
                if (xobj._firstChild.isAttr()) {
                    Xobj xobj2 = xobj._firstChild;
                    while (xobj2._nextSibling != null && xobj2._nextSibling.isAttr()) {
                        xobj2 = xobj2._nextSibling;
                    }
                    if (xobj2._cchAfter > 0) {
                        posAfter = xobj2.posAfter();
                        xobj = xobj2;
                    } else if (xobj2._nextSibling != null) {
                        xobj = xobj2._nextSibling;
                    }
                } else {
                    xobj = xobj._firstChild;
                }
                posAfter = 0;
            }
            posAfter = 1;
        }
        moveTo(getNormal(xobj, posAfter), this._posTemp);
        return true;
    }

    int prevChars(int i) {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int cchLeft = cchLeft();
        if (i < 0 || i > cchLeft) {
            i = cchLeft;
        }
        if (i != 0) {
            moveTo(getNormal(getDenormal(), this._posTemp - i), this._posTemp);
        }
        return i;
    }

    int nextChars(int i) {
        if (!$assertionsDisabled && !isPositioned()) {
            throw new AssertionError();
        }
        int cchRight = cchRight();
        if (cchRight == 0) {
            return 0;
        }
        if (i < 0 || i >= cchRight) {
            next();
            return cchRight;
        }
        moveTo(getNormal(this._xobj, this._pos + i), this._posTemp);
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void setCharNodes(DomImpl.CharNode charNode) {
        boolean z = $assertionsDisabled;
        if (!z && charNode != null && this._locale != charNode.locale()) {
            throw new AssertionError();
        }
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        Xobj denormal = getDenormal();
        int i = this._posTemp;
        if (!z && denormal.isRoot() && (i <= 0 || i >= denormal.posAfter())) {
            throw new AssertionError();
        }
        if (i >= denormal.posAfter()) {
            denormal._charNodesAfter = charNode;
        } else {
            denormal._charNodesValue = charNode;
        }
        while (charNode != null) {
            charNode.setDom((DomImpl.Dom) denormal);
            charNode = charNode._next;
        }
    }

    DomImpl.CharNode getCharNodes() {
        boolean z = $assertionsDisabled;
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        if (!z && isRoot()) {
            throw new AssertionError();
        }
        Xobj denormal = getDenormal();
        if (this._posTemp >= denormal.posAfter()) {
            DomImpl.CharNode updateCharNodes = updateCharNodes(this._locale, denormal, denormal._charNodesAfter, denormal._cchAfter);
            denormal._charNodesAfter = updateCharNodes;
            return updateCharNodes;
        }
        denormal.ensureOccupancy();
        DomImpl.CharNode updateCharNodes2 = updateCharNodes(this._locale, denormal, denormal._charNodesValue, denormal._cchValue);
        denormal._charNodesValue = updateCharNodes2;
        return updateCharNodes2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static DomImpl.CharNode updateCharNodes(Locale locale, Xobj xobj, DomImpl.CharNode charNode, int i) {
        if (!$assertionsDisabled && charNode != null && charNode.locale() != locale) {
            throw new AssertionError();
        }
        DomImpl.CharNode charNode2 = charNode;
        int i2 = 0;
        while (charNode2 != null && i > 0) {
            if (!$assertionsDisabled && charNode2.getDom() != xobj) {
                throw new AssertionError();
            }
            if (charNode2._cch > i) {
                charNode2._cch = i;
            }
            charNode2._off = i2;
            i2 += charNode2._cch;
            i -= charNode2._cch;
            charNode2 = charNode2._next;
        }
        if (i > 0) {
            DomImpl.TextNode createTextNode = locale.createTextNode();
            createTextNode.setDom((DomImpl.Dom) xobj);
            createTextNode._cch = i;
            createTextNode._off = i2;
            return DomImpl.CharNode.appendNode(charNode, createTextNode);
        }
        while (charNode2 != null) {
            if (!$assertionsDisabled && charNode2.getDom() != xobj) {
                throw new AssertionError();
            }
            if (charNode2._cch != 0) {
                charNode2._cch = 0;
            }
            charNode2._off = i2;
            charNode2 = charNode2._next;
        }
        return charNode;
    }

    final QName getXsiTypeName() {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.getXsiTypeName();
        }
        throw new AssertionError();
    }

    final void setXsiType(QName qName) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        setAttrValueAsQName(Locale._xsiType, qName);
    }

    final QName valueAsQName() {
        throw new RuntimeException("Not implemented");
    }

    final String namespaceForPrefix(String str, boolean z) {
        return this._xobj.namespaceForPrefix(str, z);
    }

    final String prefixForNamespace(String str, String str2, boolean z) {
        return (isContainer() ? this._xobj : getParent()).prefixForNamespace(str, str2, z);
    }

    boolean contains(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        if (z || (cur != null && cur.isPositioned())) {
            return this._xobj.contains(cur);
        }
        throw new AssertionError();
    }

    void insertString(String str) {
        if (str != null) {
            insertChars(str, 0, str.length());
        }
    }

    void insertChars(Object obj, int i, int i2) {
        boolean z = $assertionsDisabled;
        if (!z && (!isPositioned() || isRoot())) {
            throw new AssertionError();
        }
        if (!z && !CharUtil.isValid(obj, i, i2)) {
            throw new AssertionError();
        }
        if (i2 <= 0) {
            return;
        }
        this._locale.notifyChange();
        if (this._pos == -1) {
            this._xobj.ensureOccupancy();
        }
        Xobj denormal = getDenormal();
        int i3 = this._posTemp;
        if (!z && i3 <= 0) {
            throw new AssertionError();
        }
        denormal.insertCharsHelper(i3, obj, i, i2, true);
        moveTo(denormal, i3);
        this._locale._versionAll++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        if ((r10._pos >= r10._xobj.posAfter() ? r10._xobj._parent : r10._xobj).isOccupied() != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.Object moveChars(org.apache.xmlbeans.impl.store.Cur r11, int r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Cur.moveChars(org.apache.xmlbeans.impl.store.Cur, int):java.lang.Object");
    }

    void moveNode(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (!isNode() || isRoot())) {
            throw new AssertionError();
        }
        if (!z && cur != null && !cur.isPositioned()) {
            throw new AssertionError();
        }
        if (!z && cur != null && contains(cur)) {
            throw new AssertionError();
        }
        if (!z && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        Xobj xobj = this._xobj;
        skip();
        moveNode(xobj, cur);
    }

    private static void transferChars(Xobj xobj, int i, Xobj xobj2, int i2, int i3) {
        boolean z = $assertionsDisabled;
        if (!z && xobj == xobj2) {
            throw new AssertionError();
        }
        if (!z && xobj._locale != xobj2._locale) {
            throw new AssertionError();
        }
        if (!z && (i <= 0 || i >= xobj.posMax())) {
            throw new AssertionError();
        }
        if (!z && (i2 <= 0 || i2 > xobj2.posMax())) {
            throw new AssertionError();
        }
        if (!z && (i3 <= 0 || i3 > xobj.cchRight(i))) {
            throw new AssertionError();
        }
        if (!z && i2 < xobj2.posAfter() && !xobj2.isOccupied()) {
            throw new AssertionError();
        }
        xobj2.insertCharsHelper(i2, xobj.getCharsHelper(i, i3), xobj._locale._offSrc, xobj._locale._cchSrc, false);
        xobj.removeCharsHelper(i, i3, xobj2, i2, true, false);
    }

    static void moveNode(Xobj xobj, Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (xobj == null || xobj.isRoot())) {
            throw new AssertionError();
        }
        if (!z && cur != null && !cur.isPositioned()) {
            throw new AssertionError();
        }
        if (!z && cur != null && xobj.contains(cur)) {
            throw new AssertionError();
        }
        if (!z && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        if (cur != null) {
            if (cur._pos == -1) {
                cur._xobj.ensureOccupancy();
            }
            if ((cur._pos == 0 && cur._xobj == xobj) || cur.isJustAfterEnd(xobj)) {
                cur.moveTo(xobj);
                return;
            }
        }
        xobj._locale.notifyChange();
        xobj._locale._versionAll++;
        xobj._locale._versionSansText++;
        if (cur != null && cur._locale != xobj._locale) {
            cur._locale.notifyChange();
            cur._locale._versionAll++;
            cur._locale._versionSansText++;
        }
        if (xobj.isAttr()) {
            xobj.invalidateSpecialAttr(cur == null ? null : cur.getParentRaw());
        } else {
            if (xobj._parent != null) {
                xobj._parent.invalidateUser();
            }
            if (cur != null && cur.hasParent()) {
                cur.getParent().invalidateUser();
            }
        }
        if (xobj._cchAfter > 0) {
            transferChars(xobj, xobj.posAfter(), xobj.getDenormal(0), xobj.posTemp(), xobj._cchAfter);
        }
        if (!z && xobj._cchAfter != 0) {
            throw new AssertionError();
        }
        xobj._locale.embedCurs();
        Xobj xobj2 = xobj;
        while (xobj2 != null) {
            while (xobj2._embedded != null) {
                xobj2._embedded.moveTo(xobj.getNormal(xobj.posAfter()));
            }
            xobj2.disconnectUser();
            if (cur != null) {
                xobj2._locale = cur._locale;
            }
            xobj2 = xobj2.walk(xobj, true);
        }
        xobj.removeXobj();
        if (cur != null) {
            Xobj xobj3 = cur._xobj;
            boolean z2 = cur._pos != 0;
            int cchRight = cur.cchRight();
            if (cchRight > 0) {
                cur.push();
                cur.next();
                xobj3 = cur._xobj;
                boolean z3 = cur._pos != 0;
                cur.pop();
                z2 = z3;
            }
            if (z2) {
                xobj3.appendXobj(xobj);
            } else {
                xobj3.insertXobj(xobj);
            }
            if (cchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj, xobj.posAfter(), cchRight);
            }
            cur.moveTo(xobj);
        }
    }

    void moveNodeContents(Cur cur, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && this._pos != 0) {
            throw new AssertionError();
        }
        if (!z2 && cur != null && cur.isRoot()) {
            throw new AssertionError();
        }
        moveNodeContents(this._xobj, cur, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void moveNodeContents(org.apache.xmlbeans.impl.store.Xobj r11, org.apache.xmlbeans.impl.store.Cur r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Cur.moveNodeContents(org.apache.xmlbeans.impl.store.Xobj, org.apache.xmlbeans.impl.store.Cur, boolean):void");
    }

    protected final Xobj.Bookmark setBookmark(Object obj, Object obj2) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        return this._xobj.setBookmark(this._pos, obj, obj2);
    }

    Object getBookmark(Object obj) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == this._pos && bookmark._key == obj) {
                return bookmark._value;
            }
        }
        return null;
    }

    int firstBookmarkInChars(Object obj, int i) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        if (!z && i <= 0) {
            throw new AssertionError();
        }
        if (!z && i > cchRight()) {
            throw new AssertionError();
        }
        if (!isText()) {
            return -1;
        }
        int i2 = -1;
        for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._key == obj && inChars(bookmark, i, false) && (i2 == -1 || bookmark._pos - this._pos < i2)) {
                i2 = bookmark._pos - this._pos;
            }
        }
        return i2;
    }

    int firstBookmarkInCharsLeft(Object obj, int i) {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && obj == null) {
            throw new AssertionError();
        }
        if (!z && i <= 0) {
            throw new AssertionError();
        }
        if (!z && i > cchLeft()) {
            throw new AssertionError();
        }
        if (cchLeft() <= 0) {
            return -1;
        }
        Xobj denormal = getDenormal();
        int i2 = this._posTemp - i;
        int i3 = -1;
        for (Xobj.Bookmark bookmark = denormal._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._key == obj && denormal.inChars(i2, bookmark._xobj, bookmark._pos, i, false) && (i3 == -1 || bookmark._pos - i2 < i3)) {
                i3 = bookmark._pos - i2;
            }
        }
        return i3;
    }

    String getCharsAsString(int i) {
        if ($assertionsDisabled || (isNormal() && this._xobj != null)) {
            return getCharsAsString(i, 1);
        }
        throw new AssertionError();
    }

    String getCharsAsString(int i, int i2) {
        return this._xobj.getCharsAsString(this._pos, i, i2);
    }

    String getValueAsString(int i) {
        if ($assertionsDisabled || isNode()) {
            return this._xobj.getValueAsString(i);
        }
        throw new AssertionError();
    }

    String getValueAsString() {
        boolean z = $assertionsDisabled;
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        if (z || !hasChildren()) {
            return this._xobj.getValueAsString();
        }
        throw new AssertionError();
    }

    Object getChars(int i) {
        if ($assertionsDisabled || isPositioned()) {
            return this._xobj.getChars(this._pos, i, this);
        }
        throw new AssertionError();
    }

    Object getFirstChars() {
        if (!$assertionsDisabled && !isNode()) {
            throw new AssertionError();
        }
        Object firstChars = this._xobj.getFirstChars();
        this._offSrc = this._locale._offSrc;
        this._cchSrc = this._locale._cchSrc;
        return firstChars;
    }

    void copyNode(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && cur == null) {
            throw new AssertionError();
        }
        if (!z && !isNode()) {
            throw new AssertionError();
        }
        Xobj copyNode = this._xobj.copyNode(cur._locale);
        if (cur.isPositioned()) {
            moveNode(copyNode, cur);
        } else {
            cur.moveTo(copyNode);
        }
    }

    Cur weakCur(Object obj) {
        Cur weakCur = this._locale.weakCur(obj);
        weakCur.moveToCur(this);
        return weakCur;
    }

    Cur tempCur() {
        return tempCur(null);
    }

    Cur tempCur(String str) {
        Cur tempCur = this._locale.tempCur(str);
        tempCur.moveToCur(this);
        return tempCur;
    }

    private Cur tempCur(Xobj xobj, int i) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj == null && i != -2) {
            throw new AssertionError();
        }
        Cur tempCur = this._locale.tempCur();
        if (xobj != null) {
            tempCur.moveTo(getNormal(xobj, i), this._posTemp);
        }
        return tempCur;
    }

    boolean inChars(Cur cur, int i, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && (!isPositioned() || !isText() || cchRight() < i)) {
            throw new AssertionError();
        }
        if (z2 || cur.isNormal()) {
            return this._xobj.inChars(this._pos, cur._xobj, cur._pos, i, z);
        }
        throw new AssertionError();
    }

    boolean inChars(Xobj.Bookmark bookmark, int i, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && (!isPositioned() || !isText() || cchRight() < i)) {
            throw new AssertionError();
        }
        if (z2 || bookmark._xobj.isNormal(bookmark._pos)) {
            return this._xobj.inChars(this._pos, bookmark._xobj, bookmark._pos, i, z);
        }
        throw new AssertionError();
    }

    private Xobj getNormal(Xobj xobj, int i) {
        Xobj normal = xobj.getNormal(i);
        this._posTemp = xobj._locale._posTemp;
        return normal;
    }

    private Xobj getDenormal() {
        if ($assertionsDisabled || isPositioned()) {
            return getDenormal(this._xobj, this._pos);
        }
        throw new AssertionError();
    }

    private Xobj getDenormal(Xobj xobj, int i) {
        Xobj denormal = xobj.getDenormal(i);
        this._posTemp = xobj._locale._posTemp;
        return denormal;
    }

    void setType(SchemaType schemaType) {
        setType(schemaType, true);
    }

    void setType(SchemaType schemaType, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && schemaType == null) {
            throw new AssertionError();
        }
        if (!z2 && !isUserNode()) {
            throw new AssertionError();
        }
        TypeStoreUser peekUser = peekUser();
        if (peekUser == null || peekUser.get_schema_type() != schemaType) {
            if (isRoot()) {
                this._xobj.setStableType(schemaType);
                return;
            }
            TypeStoreUser user = this._xobj.ensureParent().getUser();
            if (isAttr()) {
                if (z && user.get_attribute_type(getName()) != schemaType) {
                    throw new IllegalArgumentException(new StringBuffer().append("Can't set type of attribute to ").append(schemaType.toString()).toString());
                }
                return;
            }
            if (!z2 && !isElem()) {
                throw new AssertionError();
            }
            if (user.get_element_type(getName(), null) == schemaType) {
                removeAttr(Locale._xsiType);
                return;
            }
            QName name = schemaType.getName();
            if (name == null) {
                if (z) {
                    throw new IllegalArgumentException("Can't set type of element, type is un-named");
                }
            } else if (user.get_element_type(getName(), name) == schemaType) {
                setAttrValueAsQName(Locale._xsiType, name);
            } else if (z) {
                throw new IllegalArgumentException("Can't set type of element, invalid type");
            }
        }
    }

    void setSubstitution(QName qName, SchemaType schemaType) {
        setSubstitution(qName, schemaType, true);
    }

    void setSubstitution(QName qName, SchemaType schemaType, boolean z) {
        boolean z2 = $assertionsDisabled;
        if (!z2 && qName == null) {
            throw new AssertionError();
        }
        if (!z2 && schemaType == null) {
            throw new AssertionError();
        }
        if (!z2 && !isUserNode()) {
            throw new AssertionError();
        }
        TypeStoreUser peekUser = peekUser();
        if ((peekUser != null && peekUser.get_schema_type() == schemaType && qName.equals(getName())) || isRoot()) {
            return;
        }
        TypeStoreUser user = this._xobj.ensureParent().getUser();
        if (isAttr()) {
            if (z) {
                throw new IllegalArgumentException("Can't use substitution with attributes");
            }
            return;
        }
        if (!z2 && !isElem()) {
            throw new AssertionError();
        }
        if (user.get_element_type(qName, null) == schemaType) {
            setName(qName);
            removeAttr(Locale._xsiType);
            return;
        }
        QName name = schemaType.getName();
        if (name == null) {
            if (z) {
                throw new IllegalArgumentException("Can't set xsi:type on element, type is un-named");
            }
        } else if (user.get_element_type(qName, name) != schemaType) {
            if (z) {
                throw new IllegalArgumentException("Can't set xsi:type on element, invalid type");
            }
        } else {
            setName(qName);
            setAttrValueAsQName(Locale._xsiType, name);
        }
    }

    TypeStoreUser peekUser() {
        if ($assertionsDisabled || isUserNode()) {
            return this._xobj._user;
        }
        throw new AssertionError();
    }

    XmlObject getObject() {
        if (isUserNode()) {
            return (XmlObject) getUser();
        }
        return null;
    }

    TypeStoreUser getUser() {
        if ($assertionsDisabled || isUserNode()) {
            return this._xobj.getUser();
        }
        throw new AssertionError();
    }

    DomImpl.Dom getDom() {
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && !isPositioned()) {
            throw new AssertionError();
        }
        if (isText()) {
            int cchLeft = cchLeft();
            DomImpl.CharNode charNodes = getCharNodes();
            while (true) {
                cchLeft -= charNodes._cch;
                if (cchLeft < 0) {
                    return charNodes;
                }
                charNodes = charNodes._next;
            }
        } else {
            return this._xobj.getDom();
        }
    }

    static void release(Cur cur) {
        if (cur != null) {
            cur.release();
        }
    }

    void release() {
        if (this._tempFrame >= 0) {
            Cur cur = this._nextTemp;
            if (cur != null) {
                cur._prevTemp = this._prevTemp;
            }
            Cur cur2 = this._prevTemp;
            if (cur2 == null) {
                this._locale._tempFrames[this._tempFrame] = this._nextTemp;
            } else {
                cur2._nextTemp = cur;
            }
            this._nextTemp = null;
            this._prevTemp = null;
            this._tempFrame = -1;
        }
        int i = this._state;
        if (i == 0 || i == 3) {
            return;
        }
        while (this._stackTop != -1) {
            popButStay();
        }
        clearSelection();
        this._id = null;
        moveToCur(null);
        boolean z = $assertionsDisabled;
        if (!z && !isNormal()) {
            throw new AssertionError();
        }
        if (!z && this._xobj != null) {
            throw new AssertionError();
        }
        if (!z && this._pos != -2) {
            throw new AssertionError();
        }
        Locale.Ref ref = this._ref;
        if (ref != null) {
            ref.clear();
            this._ref._cur = null;
        }
        this._ref = null;
        if (!z && this._state != 1) {
            throw new AssertionError();
        }
        Locale locale = this._locale;
        locale._registered = listRemove(locale._registered);
        if (this._locale._curPoolCount < 16) {
            Locale locale2 = this._locale;
            locale2._curPool = listInsert(locale2._curPool);
            this._state = 0;
            this._locale._curPoolCount++;
            return;
        }
        this._locale = null;
        this._state = 3;
    }

    boolean isOnList(Cur cur) {
        while (cur != null) {
            if (cur == this) {
                return true;
            }
            cur = cur._next;
        }
        return false;
    }

    Cur listInsert(Cur cur) {
        if (!$assertionsDisabled && (this._next != null || this._prev != null)) {
            throw new AssertionError();
        }
        if (cur == null) {
            this._prev = this;
            return this;
        }
        this._prev = cur._prev;
        cur._prev._next = this;
        cur._prev = this;
        return cur;
    }

    Cur listRemove(Cur cur) {
        boolean z = $assertionsDisabled;
        if (!z && (this._prev == null || !isOnList(cur))) {
            throw new AssertionError();
        }
        Cur cur2 = this._prev;
        if (cur2 == this) {
            cur = null;
        } else {
            if (cur == this) {
                cur = this._next;
            } else {
                cur2._next = this._next;
            }
            Cur cur3 = this._next;
            if (cur3 == null) {
                cur._prev = cur2;
            } else {
                cur3._prev = cur2;
                this._next = null;
            }
        }
        this._prev = null;
        if (z || this._next == null) {
            return cur;
        }
        throw new AssertionError();
    }

    boolean isNormal() {
        int i = this._state;
        if (i == 0 || i == 3) {
            return false;
        }
        Xobj xobj = this._xobj;
        if (xobj == null) {
            return this._pos == -2;
        }
        if (!xobj.isNormal(this._pos)) {
            return false;
        }
        int i2 = this._state;
        if (i2 == 2) {
            return isOnList(this._xobj._embedded);
        }
        if ($assertionsDisabled || i2 == 1) {
            return isOnList(this._locale._registered);
        }
        throw new AssertionError();
    }

    static final class CurLoadContext extends Locale.LoadContext {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Map _additionalNamespaces;
        private boolean _after;
        private CharUtil _charUtil;
        private boolean _discardDocElem;
        private String _doctypeName;
        private String _doctypePublicId;
        private String _doctypeSystemId;
        private Xobj _frontier;
        private int _lastPos;
        private Xobj _lastXobj;
        private Locale _locale;
        private QName _replaceDocElem;
        private boolean _stripComments;
        private boolean _stripLeft = true;
        private boolean _stripProcinsts;
        private boolean _stripWhitespace;
        private Map _substituteNamespaces;

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void endDTD() {
        }

        static {
            if (Cur.class$org$apache$xmlbeans$impl$store$Cur == null) {
                Cur.class$org$apache$xmlbeans$impl$store$Cur = Cur.class$("org.apache.xmlbeans.impl.store.Cur");
            } else {
                Class cls = Cur.class$org$apache$xmlbeans$impl$store$Cur;
            }
            $assertionsDisabled = true;
        }

        CurLoadContext(Locale locale, XmlOptions xmlOptions) {
            XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
            this._locale = locale;
            this._charUtil = maskNull.hasOption(Cur.LOAD_USE_LOCALE_CHAR_UTIL) ? this._locale.getCharUtil() : CharUtil.getThreadLocalCharUtil();
            Xobj createDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale);
            this._frontier = createDomDocumentRootXobj;
            this._after = false;
            this._lastXobj = createDomDocumentRootXobj;
            this._lastPos = 0;
            if (maskNull.hasOption(XmlOptions.LOAD_REPLACE_DOCUMENT_ELEMENT)) {
                this._replaceDocElem = (QName) maskNull.get(XmlOptions.LOAD_REPLACE_DOCUMENT_ELEMENT);
                this._discardDocElem = true;
            }
            this._stripWhitespace = maskNull.hasOption(XmlOptions.LOAD_STRIP_WHITESPACE);
            this._stripComments = maskNull.hasOption(XmlOptions.LOAD_STRIP_COMMENTS);
            this._stripProcinsts = maskNull.hasOption(XmlOptions.LOAD_STRIP_PROCINSTS);
            this._substituteNamespaces = (Map) maskNull.get(XmlOptions.LOAD_SUBSTITUTE_NAMESPACES);
            this._additionalNamespaces = (Map) maskNull.get(XmlOptions.LOAD_ADDITIONAL_NAMESPACES);
            this._locale._versionAll++;
            this._locale._versionSansText++;
        }

        private void start(Xobj xobj) {
            boolean z = $assertionsDisabled;
            if (!z && this._frontier == null) {
                throw new AssertionError();
            }
            if (!z && this._after && this._frontier._parent == null) {
                throw new AssertionError();
            }
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
                this._after = false;
            }
            this._frontier.appendXobj(xobj);
            this._frontier = xobj;
            this._lastXobj = xobj;
            this._lastPos = 0;
        }

        private void end() {
            boolean z = $assertionsDisabled;
            if (!z && this._frontier == null) {
                throw new AssertionError();
            }
            if (!z && this._after && this._frontier._parent == null) {
                throw new AssertionError();
            }
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            } else {
                this._after = true;
            }
            this._lastXobj = this._frontier;
            this._lastPos = -1;
        }

        private void text(Object obj, int i, int i2) {
            if (i2 <= 0) {
                return;
            }
            Xobj xobj = this._frontier;
            this._lastXobj = xobj;
            int i3 = xobj._cchValue + 1;
            this._lastPos = i3;
            if (this._after) {
                this._lastPos = i3 + this._frontier._cchAfter + 1;
                Xobj xobj2 = this._frontier;
                xobj2._srcAfter = this._charUtil.saveChars(obj, i, i2, xobj2._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
                this._frontier._offAfter = this._charUtil._offSrc;
                this._frontier._cchAfter = this._charUtil._cchSrc;
                return;
            }
            Xobj xobj3 = this._frontier;
            xobj3._srcValue = this._charUtil.saveChars(obj, i, i2, xobj3._srcValue, this._frontier._offValue, this._frontier._cchValue);
            this._frontier._offValue = this._charUtil._offSrc;
            this._frontier._cchValue = this._charUtil._cchSrc;
        }

        private void flushText() {
            if (this._stripWhitespace) {
                if (this._after) {
                    Xobj xobj = this._frontier;
                    xobj._srcAfter = this._charUtil.stripRight(xobj._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
                    this._frontier._offAfter = this._charUtil._offSrc;
                    this._frontier._cchAfter = this._charUtil._cchSrc;
                    return;
                }
                Xobj xobj2 = this._frontier;
                xobj2._srcValue = this._charUtil.stripRight(xobj2._srcValue, this._frontier._offValue, this._frontier._cchValue);
                this._frontier._offValue = this._charUtil._offSrc;
                this._frontier._cchValue = this._charUtil._cchSrc;
            }
        }

        private Xobj parent() {
            return this._after ? this._frontier._parent : this._frontier;
        }

        private QName checkName(QName qName, boolean z) {
            String str;
            return this._substituteNamespaces != null ? ((!z || qName.getNamespaceURI().length() > 0) && (str = (String) this._substituteNamespaces.get(qName.getNamespaceURI())) != null) ? this._locale.makeQName(str, qName.getLocalPart(), qName.getPrefix()) : qName : qName;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void startDTD(String str, String str2, String str3) {
            this._doctypeName = str;
            this._doctypePublicId = str2;
            this._doctypeSystemId = str3;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void startElement(QName qName) {
            start(Cur.createElementXobj(this._locale, checkName(qName, false), parent()._name));
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void endElement() {
            if (!$assertionsDisabled && !parent().isElem()) {
                throw new AssertionError();
            }
            end();
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void xmlns(String str, String str2) {
            String str3;
            if (!$assertionsDisabled && !parent().isContainer()) {
                throw new AssertionError();
            }
            Map map = this._substituteNamespaces;
            if (map != null && (str3 = (String) map.get(str2)) != null) {
                str2 = str3;
            }
            Locale locale = this._locale;
            Xobj.AttrXobj attrXobj = new Xobj.AttrXobj(locale, locale.createXmlns(str));
            start(attrXobj);
            text(str2, 0, str2.length());
            end();
            this._lastXobj = attrXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void attr(QName qName, String str) {
            if (!$assertionsDisabled && !parent().isContainer()) {
                throw new AssertionError();
            }
            boolean isAttrOfTypeId = isAttrOfTypeId(qName, (this._after ? this._lastXobj._parent : this._lastXobj).getQName());
            Xobj attrIdXobj = isAttrOfTypeId ? new Xobj.AttrIdXobj(this._locale, checkName(qName, true)) : new Xobj.AttrXobj(this._locale, checkName(qName, true));
            start(attrIdXobj);
            text(str, 0, str.length());
            end();
            if (isAttrOfTypeId) {
                Cur tempCur = attrIdXobj.tempCur();
                tempCur.toRoot();
                Xobj xobj = tempCur._xobj;
                tempCur.release();
                if (xobj instanceof Xobj.DocumentXobj) {
                    ((Xobj.DocumentXobj) xobj).addIdElement(str, attrIdXobj._parent.getDom());
                }
            }
            this._lastXobj = attrIdXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void attr(String str, String str2, String str3, String str4) {
            attr(this._locale.makeQName(str2, str, str3), str4);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void procInst(String str, String str2) {
            if (!this._stripProcinsts) {
                Xobj.ProcInstXobj procInstXobj = new Xobj.ProcInstXobj(this._locale, str);
                start(procInstXobj);
                text(str2, 0, str2.length());
                end();
                this._lastXobj = procInstXobj;
                this._lastPos = 0;
            }
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void comment(String str) {
            if (!this._stripComments) {
                comment(str, 0, str.length());
            }
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void comment(char[] cArr, int i, int i2) {
            if (!this._stripComments) {
                comment(this._charUtil.saveChars(cArr, i, i2), this._charUtil._offSrc, this._charUtil._cchSrc);
            }
            this._stripLeft = true;
        }

        private void comment(Object obj, int i, int i2) {
            Xobj.CommentXobj commentXobj = new Xobj.CommentXobj(this._locale);
            start(commentXobj);
            text(obj, i, i2);
            end();
            this._lastXobj = commentXobj;
            this._lastPos = 0;
        }

        private void stripText(Object obj, int i, int i2) {
            if (this._stripWhitespace && this._stripLeft) {
                obj = this._charUtil.stripLeft(obj, i, i2);
                this._stripLeft = false;
                i = this._charUtil._offSrc;
                i2 = this._charUtil._cchSrc;
            }
            text(obj, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void text(String str) {
            if (str == null) {
                return;
            }
            stripText(str, 0, str.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void text(char[] cArr, int i, int i2) {
            stripText(cArr, i, i2);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void bookmark(XmlCursor.XmlBookmark xmlBookmark) {
            this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark) {
            if (this._lastPos > 0 || !this._lastXobj.isAttr()) {
                this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
            } else {
                if (!$assertionsDisabled && this._lastXobj._parent == null) {
                    throw new AssertionError();
                }
                this._lastXobj._parent.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            if (this._lastPos == 0 && this._lastXobj.isAttr()) {
                if (!$assertionsDisabled && this._lastXobj._parent == null) {
                    throw new AssertionError();
                }
                Xobj attr = this._lastXobj._parent.getAttr(qName);
                if (attr != null) {
                    attr.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void lineNumber(int i, int i2, int i3) {
            Class cls;
            Xobj xobj = this._lastXobj;
            int i4 = this._lastPos;
            if (Cur.class$org$apache$xmlbeans$XmlLineNumber == null) {
                cls = Cur.class$("org.apache.xmlbeans.XmlLineNumber");
                Cur.class$org$apache$xmlbeans$XmlLineNumber = cls;
            } else {
                cls = Cur.class$org$apache$xmlbeans$XmlLineNumber;
            }
            xobj.setBookmark(i4, cls, new XmlLineNumber(i, i2, i3));
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected void abort() {
            this._stripLeft = true;
            while (!parent().isRoot()) {
                end();
            }
            finish().release();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        protected Cur finish() {
            Xobj xobj;
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            }
            if (!$assertionsDisabled && ((xobj = this._frontier) == null || xobj._parent != null || !this._frontier.isRoot())) {
                throw new AssertionError();
            }
            Cur tempCur = this._frontier.tempCur();
            if (!Locale.toFirstChildElement(tempCur)) {
                return tempCur;
            }
            boolean isFragmentQName = Locale.isFragmentQName(tempCur.getName());
            if (this._discardDocElem || isFragmentQName) {
                QName qName = this._replaceDocElem;
                if (qName != null) {
                    tempCur.setName(qName);
                } else {
                    while (tempCur.toParent()) {
                    }
                    tempCur.next();
                    while (!tempCur.isElem()) {
                        if (tempCur.isText()) {
                            tempCur.moveChars(null, -1);
                        } else {
                            tempCur.moveNode(null);
                        }
                    }
                    if (!$assertionsDisabled && !tempCur.isElem()) {
                        throw new AssertionError();
                    }
                    tempCur.skip();
                    while (!tempCur.isFinish()) {
                        if (tempCur.isText()) {
                            tempCur.moveChars(null, -1);
                        } else {
                            tempCur.moveNode(null);
                        }
                    }
                    tempCur.toParent();
                    tempCur.next();
                    if (!$assertionsDisabled && !tempCur.isElem()) {
                        throw new AssertionError();
                    }
                    Cur tempCur2 = tempCur.tempCur();
                    tempCur.moveNodeContents(tempCur, true);
                    tempCur.moveToCur(tempCur2);
                    tempCur2.release();
                    tempCur.moveNode(null);
                }
                if (isFragmentQName) {
                    tempCur.moveTo(this._frontier);
                    if (tempCur.toFirstAttr()) {
                        while (true) {
                            if (tempCur.isXmlns() && tempCur.getXmlnsUri().equals("http://www.openuri.org/fragment")) {
                                tempCur.moveNode(null);
                                if (!tempCur.isAttr()) {
                                    break;
                                }
                            } else if (!tempCur.toNextAttr()) {
                                break;
                            }
                        }
                    }
                    tempCur.moveTo(this._frontier);
                    Xobj createDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale, true);
                    this._frontier = createDomDocumentRootXobj;
                    Cur tempCur3 = createDomDocumentRootXobj.tempCur();
                    tempCur3.next();
                    tempCur.moveNodeContents(tempCur3, true);
                    tempCur.moveTo(this._frontier);
                    tempCur3.release();
                }
            }
            if (this._additionalNamespaces != null) {
                tempCur.moveTo(this._frontier);
                Locale.toFirstChildElement(tempCur);
                Locale.applyNamespaces(tempCur, this._additionalNamespaces);
            }
            if (this._doctypeName != null && (this._doctypePublicId != null || this._doctypeSystemId != null)) {
                XmlDocumentProperties docProps = Locale.getDocProps(tempCur, true);
                docProps.setDoctypeName(this._doctypeName);
                String str = this._doctypePublicId;
                if (str != null) {
                    docProps.setDoctypePublicId(str);
                }
                String str2 = this._doctypeSystemId;
                if (str2 != null) {
                    docProps.setDoctypeSystemId(str2);
                }
            }
            tempCur.moveTo(this._frontier);
            if ($assertionsDisabled || tempCur.isRoot()) {
                return tempCur;
            }
            throw new AssertionError();
        }

        public void dump() {
            this._frontier.dump();
        }
    }

    static String kindName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new StringBuffer().append("<< Unknown Kind (").append(i).append(") >>").toString() : "PROCINST" : "COMMENT" : "ATTR" : "ELEM" : "ROOT" : "TEXT";
    }

    static void dump(PrintStream printStream, DomImpl.Dom dom) {
        dom.dump(printStream);
    }

    static void dump(DomImpl.Dom dom) {
        dump(System.out, dom);
    }

    static void dump(Node node) {
        dump(System.out, node);
    }

    static void dump(PrintStream printStream, Node node) {
        dump(printStream, (DomImpl.Dom) node);
    }

    void dump() {
        dump(System.out, this._xobj, this);
    }

    void dump(PrintStream printStream) {
        Xobj xobj = this._xobj;
        if (xobj == null) {
            printStream.println("Unpositioned xptr");
        } else {
            dump(printStream, xobj, this);
        }
    }

    public static void dump(PrintStream printStream, Xobj xobj, Object obj) {
        if (obj == null) {
            obj = xobj;
        }
        while (xobj._parent != null) {
            xobj = xobj._parent;
        }
        dumpXobj(printStream, xobj, 0, obj);
        printStream.println();
    }

    private static void dumpCur(PrintStream printStream, String str, Cur cur, Object obj) {
        printStream.print(StringUtils.SPACE);
        if (obj == cur) {
            printStream.print("*:");
        }
        StringBuffer append = new StringBuffer().append(str);
        String str2 = cur._id;
        if (str2 == null) {
            str2 = "<cur>";
        }
        printStream.print(append.append(str2).append("[").append(cur._pos).append("]").toString());
    }

    private static void dumpCurs(PrintStream printStream, Xobj xobj, Object obj) {
        for (Cur cur = xobj._embedded; cur != null; cur = cur._next) {
            dumpCur(printStream, "E:", cur, obj);
        }
        for (Cur cur2 = xobj._locale._registered; cur2 != null; cur2 = cur2._next) {
            if (cur2._xobj == xobj) {
                dumpCur(printStream, "R:", cur2, obj);
            }
        }
    }

    private static void dumpBookmarks(PrintStream printStream, Xobj xobj, Object obj) {
        for (Xobj.Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            printStream.print(StringUtils.SPACE);
            if (obj == bookmark) {
                printStream.print("*:");
            }
            if (bookmark._value instanceof XmlLineNumber) {
                printStream.print(new StringBuffer().append("<line:").append(((XmlLineNumber) bookmark._value).getLine()).append(">").append("[").append(bookmark._pos).append("]").toString());
            } else {
                printStream.print(new StringBuffer().append("<mark>[").append(bookmark._pos).append("]").toString());
            }
        }
    }

    private static void dumpCharNodes(PrintStream printStream, DomImpl.CharNode charNode, Object obj) {
        while (charNode != null) {
            printStream.print(StringUtils.SPACE);
            if (charNode == obj) {
                printStream.print(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
            }
            printStream.print(new StringBuffer().append(charNode instanceof DomImpl.TextNode ? "TEXT" : "CDATA").append("[").append(charNode._cch).append("]").toString());
            charNode = charNode._next;
        }
    }

    private static void dumpChars(PrintStream printStream, Object obj, int i, int i2) {
        printStream.print("\"");
        String string = CharUtil.getString(obj, i, i2);
        int i3 = 0;
        while (true) {
            if (i3 >= string.length()) {
                break;
            }
            if (i3 == 36) {
                printStream.print("...");
                break;
            }
            char charAt = string.charAt(i3);
            if (charAt >= ' ' && charAt < 127) {
                printStream.print(charAt);
            } else if (charAt == '\n') {
                printStream.print("\\n");
            } else if (charAt == '\r') {
                printStream.print("\\r");
            } else if (charAt == '\t') {
                printStream.print("\\t");
            } else if (charAt == '\"') {
                printStream.print("\\\"");
            } else {
                printStream.print(new StringBuffer().append("<#").append((int) charAt).append(">").toString());
            }
            i3++;
        }
        printStream.print("\"");
    }

    private static void dumpXobj(PrintStream printStream, Xobj xobj, int i, Object obj) {
        int lastIndexOf;
        if (xobj == null) {
            return;
        }
        if (xobj == obj) {
            printStream.print("* ");
        } else {
            printStream.print("  ");
        }
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print("  ");
        }
        printStream.print(kindName(xobj.kind()));
        if (xobj._name != null) {
            printStream.print(StringUtils.SPACE);
            if (xobj._name.getPrefix().length() > 0) {
                printStream.print(new StringBuffer().append(xobj._name.getPrefix()).append(":").toString());
            }
            printStream.print(xobj._name.getLocalPart());
            if (xobj._name.getNamespaceURI().length() > 0) {
                printStream.print(new StringBuffer().append("@").append(xobj._name.getNamespaceURI()).toString());
            }
        }
        if (xobj._srcValue != null || xobj._charNodesValue != null) {
            printStream.print(" Value( ");
            dumpChars(printStream, xobj._srcValue, xobj._offValue, xobj._cchValue);
            dumpCharNodes(printStream, xobj._charNodesValue, obj);
            printStream.print(" )");
        }
        if (xobj._user != null) {
            printStream.print(" (USER)");
        }
        if (xobj.isVacant()) {
            printStream.print(" (VACANT)");
        }
        if (xobj._srcAfter != null || xobj._charNodesAfter != null) {
            printStream.print(" After( ");
            dumpChars(printStream, xobj._srcAfter, xobj._offAfter, xobj._cchAfter);
            dumpCharNodes(printStream, xobj._charNodesAfter, obj);
            printStream.print(" )");
        }
        dumpCurs(printStream, xobj, obj);
        dumpBookmarks(printStream, xobj, obj);
        String name = xobj.getClass().getName();
        int lastIndexOf2 = name.lastIndexOf(46);
        if (lastIndexOf2 > 0 && (lastIndexOf = (name = name.substring(lastIndexOf2 + 1)).lastIndexOf(36)) > 0) {
            name = name.substring(lastIndexOf + 1);
        }
        printStream.print(" (");
        printStream.print(name);
        printStream.print(")");
        printStream.println();
        for (Xobj xobj2 = xobj._firstChild; xobj2 != null; xobj2 = xobj2._nextSibling) {
            dumpXobj(printStream, xobj2, i + 1, obj);
        }
    }

    void setId(String str) {
        this._id = str;
    }
}
