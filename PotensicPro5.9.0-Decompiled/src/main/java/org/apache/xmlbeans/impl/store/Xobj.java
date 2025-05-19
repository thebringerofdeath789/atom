package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.transform.Source;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

/* loaded from: classes5.dex */
abstract class Xobj implements TypeStore {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int END_POS = -1;
    static final int INHIBIT_DISCONNECT = 1024;
    static final int NO_POS = -2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int STABLE_USER = 512;
    static final int TEXT = 0;
    static final int VACANT = 256;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Xobj;
    int _bits;
    Bookmark _bookmarks;
    int _cchAfter;
    int _cchValue;
    DomImpl.CharNode _charNodesAfter;
    DomImpl.CharNode _charNodesValue;
    Cur _embedded;
    Xobj _firstChild;
    Xobj _lastChild;
    Locale _locale;
    QName _name;
    Xobj _nextSibling;
    int _offAfter;
    int _offValue;
    Xobj _parent;
    Xobj _prevSibling;
    Object _srcAfter;
    Object _srcValue;
    TypeStoreUser _user;

    abstract DomImpl.Dom getDom();

    abstract Xobj newNode(Locale locale);

    static {
        if (class$org$apache$xmlbeans$impl$store$Xobj == null) {
            class$org$apache$xmlbeans$impl$store$Xobj = class$("org.apache.xmlbeans.impl.store.Xobj");
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

    Xobj(Locale locale, int i, int i2) {
        if (!$assertionsDisabled && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            throw new AssertionError();
        }
        this._locale = locale;
        this._bits = (i2 << 4) + i;
    }

    final boolean entered() {
        return this._locale.entered();
    }

    final int kind() {
        return this._bits & 15;
    }

    final int domType() {
        return (this._bits & 240) >> 4;
    }

    final boolean isRoot() {
        return kind() == 1;
    }

    final boolean isAttr() {
        return kind() == 3;
    }

    final boolean isElem() {
        return kind() == 2;
    }

    final boolean isProcinst() {
        return kind() == 5;
    }

    final boolean isComment() {
        return kind() == 4;
    }

    final boolean isContainer() {
        return Cur.kindIsContainer(kind());
    }

    final boolean isUserNode() {
        int kind = kind();
        if (kind == 2 || kind == 1) {
            return true;
        }
        return kind == 3 && !isXmlns();
    }

    final boolean isNormalAttr() {
        return isAttr() && !Locale.isXmlns(this._name);
    }

    final boolean isXmlns() {
        return isAttr() && Locale.isXmlns(this._name);
    }

    final int cchValue() {
        return this._cchValue;
    }

    final int cchAfter() {
        return this._cchAfter;
    }

    final int posAfter() {
        return this._cchValue + 2;
    }

    final int posMax() {
        return this._cchValue + 2 + this._cchAfter;
    }

    final String getXmlnsPrefix() {
        return Locale.xmlnsPrefix(this._name);
    }

    final String getXmlnsUri() {
        return getValueAsString();
    }

    final boolean hasTextEnsureOccupancy() {
        ensureOccupancy();
        return hasTextNoEnsureOccupancy();
    }

    final boolean hasTextNoEnsureOccupancy() {
        if (this._cchValue > 0) {
            return true;
        }
        Xobj lastAttr = lastAttr();
        return lastAttr != null && lastAttr._cchAfter > 0;
    }

    final boolean hasAttrs() {
        Xobj xobj = this._firstChild;
        return xobj != null && xobj.isAttr();
    }

    final boolean hasChildren() {
        Xobj xobj = this._lastChild;
        return (xobj == null || xobj.isAttr()) ? false : true;
    }

    protected final int getDomZeroOneChildren() {
        DomImpl.CharNode charNode;
        if (this._firstChild == null && this._srcValue == null && this._charNodesValue == null) {
            return 0;
        }
        Xobj xobj = this._lastChild;
        if (xobj != null && xobj.isAttr()) {
            Xobj xobj2 = this._lastChild;
            if (xobj2._charNodesAfter == null && xobj2._srcAfter == null && this._srcValue == null && this._charNodesValue == null) {
                return 0;
            }
        }
        Xobj xobj3 = this._firstChild;
        if (xobj3 == this._lastChild && xobj3 != null && !xobj3.isAttr() && this._srcValue == null && this._charNodesValue == null && this._firstChild._srcAfter == null) {
            return 1;
        }
        if (this._firstChild == null && this._srcValue != null && ((charNode = this._charNodesValue) == null || (charNode._next == null && this._charNodesValue._cch == this._cchValue))) {
            return 1;
        }
        Xobj lastAttr = lastAttr();
        Xobj xobj4 = lastAttr == null ? null : lastAttr._nextSibling;
        return (lastAttr != null && lastAttr._srcAfter == null && xobj4 != null && xobj4._srcAfter == null && xobj4._nextSibling == null) ? 1 : 2;
    }

    protected final boolean isFirstChildPtrDomUsable() {
        Xobj xobj = this._firstChild;
        if (xobj == null && this._srcValue == null && this._charNodesValue == null) {
            return true;
        }
        if (xobj == null || xobj.isAttr() || this._srcValue != null || this._charNodesValue != null) {
            return false;
        }
        if ($assertionsDisabled || (this._firstChild instanceof NodeXobj)) {
            return true;
        }
        throw new AssertionError("wrong node type");
    }

    protected final boolean isNextSiblingPtrDomUsable() {
        Xobj xobj;
        if (this._charNodesAfter != null || this._srcAfter != null) {
            return false;
        }
        if ($assertionsDisabled || (xobj = this._nextSibling) == null || (xobj instanceof NodeXobj)) {
            return true;
        }
        throw new AssertionError("wrong node type");
    }

    protected final boolean isExistingCharNodesValueUsable() {
        DomImpl.CharNode charNode;
        return this._srcValue != null && (charNode = this._charNodesValue) != null && charNode._next == null && this._charNodesValue._cch == this._cchValue;
    }

    protected final boolean isCharNodesValueUsable() {
        if (!isExistingCharNodesValueUsable()) {
            DomImpl.CharNode updateCharNodes = Cur.updateCharNodes(this._locale, this, this._charNodesValue, this._cchValue);
            this._charNodesValue = updateCharNodes;
            if (updateCharNodes == null) {
                return false;
            }
        }
        return true;
    }

    protected final boolean isCharNodesAfterUsable() {
        if (this._srcAfter == null) {
            return false;
        }
        DomImpl.CharNode charNode = this._charNodesAfter;
        if (charNode != null && charNode._next == null && this._charNodesAfter._cch == this._cchAfter) {
            return true;
        }
        DomImpl.CharNode updateCharNodes = Cur.updateCharNodes(this._locale, this, this._charNodesAfter, this._cchAfter);
        this._charNodesAfter = updateCharNodes;
        return updateCharNodes != null;
    }

    final Xobj lastAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        Xobj xobj2 = this._firstChild;
        while (true) {
            Xobj xobj3 = xobj2._nextSibling;
            if (xobj3 == null || !xobj3.isAttr()) {
                break;
            }
            xobj2 = xobj2._nextSibling;
        }
        return xobj2;
    }

    final int cchLeft(int i) {
        if (isRoot() && i == 0) {
            return 0;
        }
        Xobj denormal = getDenormal(i);
        int posTemp = posTemp();
        int posAfter = denormal.posAfter();
        if (posTemp < posAfter) {
            posAfter = 1;
        }
        return posTemp - posAfter;
    }

    final int cchRight(int i) {
        if (!$assertionsDisabled && i >= posMax()) {
            throw new AssertionError();
        }
        if (i <= 0) {
            return 0;
        }
        return i < posAfter() ? (r0 - i) - 1 : posMax() - i;
    }

    public final Locale locale() {
        return this._locale;
    }

    public final int nodeType() {
        return domType();
    }

    public final QName getQName() {
        return this._name;
    }

    public final Cur tempCur() {
        Cur tempCur = this._locale.tempCur();
        tempCur.moveTo(this);
        return tempCur;
    }

    public void dump(PrintStream printStream, Object obj) {
        Cur.dump(printStream, this, obj);
    }

    public void dump(PrintStream printStream) {
        Cur.dump(printStream, this, this);
    }

    public void dump() {
        dump(System.out);
    }

    final Cur getEmbedded() {
        this._locale.embedCurs();
        return this._embedded;
    }

    final boolean inChars(int i, Xobj xobj, int i2, int i3, boolean z) {
        int i4;
        boolean z2 = $assertionsDisabled;
        if (!z2 && (i <= 0 || i >= posMax() || i == posAfter() - 1 || i3 <= 0)) {
            throw new AssertionError();
        }
        if (!z2 && !xobj.isNormal(i2)) {
            throw new AssertionError();
        }
        if (!z) {
            i4 = 0;
        } else {
            if (xobj.isRoot() && i2 == 0) {
                return false;
            }
            xobj = xobj.getDenormal(i2);
            i2 = xobj.posTemp();
            i4 = 1;
        }
        if (xobj == this && i2 >= i) {
            if (i3 < 0) {
                i3 = cchRight(i);
            }
            if (i2 < i + i3 + i4) {
                return true;
            }
        }
        return false;
    }

    final boolean isJustAfterEnd(Xobj xobj, int i) {
        if (!$assertionsDisabled && !xobj.isNormal(i)) {
            throw new AssertionError();
        }
        if (xobj.isRoot() && i == 0) {
            return false;
        }
        if (xobj == this) {
            if (i != posAfter()) {
                return false;
            }
        } else if (xobj.getDenormal(i) != this || xobj.posTemp() != posAfter()) {
            return false;
        }
        return true;
    }

    final boolean isInSameTree(Xobj xobj) {
        if (this._locale != xobj._locale) {
            return false;
        }
        Xobj xobj2 = this;
        while (xobj2 != xobj) {
            Xobj xobj3 = xobj2._parent;
            if (xobj3 == null) {
                while (xobj != this) {
                    Xobj xobj4 = xobj._parent;
                    if (xobj4 == null) {
                        return xobj == xobj2;
                    }
                    xobj = xobj4;
                }
                return true;
            }
            xobj2 = xobj3;
        }
        return true;
    }

    final boolean contains(Cur cur) {
        if ($assertionsDisabled || cur.isNormal()) {
            return contains(cur._xobj, cur._pos);
        }
        throw new AssertionError();
    }

    final boolean contains(Xobj xobj, int i) {
        if (!$assertionsDisabled && !xobj.isNormal(i)) {
            throw new AssertionError();
        }
        if (this == xobj) {
            if (i != -1) {
                return i > 0 && i < posAfter();
            }
            return true;
        }
        if (this._firstChild == null) {
            return false;
        }
        while (xobj != null) {
            if (xobj == this) {
                return true;
            }
            xobj = xobj._parent;
        }
        return false;
    }

    final Bookmark setBookmark(int i, Object obj, Object obj2) {
        if (!$assertionsDisabled && !isNormal(i)) {
            throw new AssertionError();
        }
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (i == bookmark._pos && obj == bookmark._key) {
                if (obj2 == null) {
                    this._bookmarks = bookmark.listRemove(this._bookmarks);
                    return null;
                }
                bookmark._value = obj2;
                return bookmark;
            }
        }
        if (obj2 == null) {
            return null;
        }
        Bookmark bookmark2 = new Bookmark();
        bookmark2._xobj = this;
        bookmark2._pos = i;
        bookmark2._key = obj;
        bookmark2._value = obj2;
        this._bookmarks = bookmark2.listInsert(this._bookmarks);
        return bookmark2;
    }

    final boolean hasBookmark(Object obj, int i) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == i && obj == bookmark._key) {
                return true;
            }
        }
        return false;
    }

    final Xobj findXmlnsForPrefix(String str) {
        if (!$assertionsDisabled && (!isContainer() || str == null)) {
            throw new AssertionError();
        }
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj firstAttr = xobj.firstAttr(); firstAttr != null; firstAttr = firstAttr.nextAttr()) {
                if (firstAttr.isXmlns() && firstAttr.getXmlnsPrefix().equals(str)) {
                    return firstAttr;
                }
            }
        }
        return null;
    }

    final boolean removeAttr(QName qName) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return false;
        }
        Cur tempCur = attr.tempCur();
        while (true) {
            tempCur.moveNode(null);
            Xobj attr2 = getAttr(qName);
            if (attr2 != null) {
                tempCur.moveTo(attr2);
            } else {
                tempCur.release();
                return true;
            }
        }
    }

    final Xobj setAttr(QName qName, String str) {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        Cur tempCur = tempCur();
        if (tempCur.toAttr(qName)) {
            tempCur.removeFollowingAttrs();
        } else {
            tempCur.next();
            tempCur.createAttr(qName);
        }
        tempCur.setValue(str);
        Xobj xobj = tempCur._xobj;
        tempCur.release();
        return xobj;
    }

    final void setName(QName qName) {
        Xobj xobj;
        boolean z = $assertionsDisabled;
        if (!z && !isAttr() && !isElem() && !isProcinst()) {
            throw new AssertionError();
        }
        if (!z && qName == null) {
            throw new AssertionError();
        }
        if (this._name.equals(qName) && this._name.getPrefix().equals(qName.getPrefix())) {
            return;
        }
        this._locale.notifyChange();
        QName qName2 = this._name;
        this._name = qName;
        if (this instanceof NamedNodeXobj) {
            ((NamedNodeXobj) this)._canHavePrefixUri = true;
        }
        if (!isProcinst()) {
            if (!isAttr() || this._parent == null) {
                xobj = this;
            } else {
                xobj = (qName2.equals(Locale._xsiType) || qName.equals(Locale._xsiType)) ? this._parent : this;
                if (qName2.equals(Locale._xsiNil) || qName.equals(Locale._xsiNil)) {
                    this._parent.invalidateNil();
                }
            }
            xobj.disconnectNonRootUsers();
        }
        this._locale._versionAll++;
        this._locale._versionSansText++;
    }

    final Xobj ensureParent() {
        if (!$assertionsDisabled && this._parent == null && (isRoot() || cchAfter() != 0)) {
            throw new AssertionError();
        }
        Xobj xobj = this._parent;
        return xobj == null ? new DocumentFragXobj(this._locale).appendXobj(this) : xobj;
    }

    final Xobj firstAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        return this._firstChild;
    }

    final Xobj nextAttr() {
        Xobj xobj = this._firstChild;
        if (xobj != null && xobj.isAttr()) {
            return this._firstChild;
        }
        Xobj xobj2 = this._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return null;
        }
        return this._nextSibling;
    }

    final boolean isValid() {
        if (isVacant()) {
            return this._cchValue == 0 && this._user != null;
        }
        return true;
    }

    final int posTemp() {
        return this._locale._posTemp;
    }

    final Xobj getNormal(int i) {
        Xobj xobj;
        if (!$assertionsDisabled && i != -1 && (i < 0 || i > posMax())) {
            throw new AssertionError();
        }
        if (i == posMax()) {
            Xobj xobj2 = this._nextSibling;
            if (xobj2 != null) {
                xobj = xobj2;
                i = 0;
            } else {
                xobj = ensureParent();
                i = -1;
            }
        } else if (i == posAfter() - 1) {
            xobj = this;
            i = -1;
        } else {
            xobj = this;
        }
        this._locale._posTemp = i;
        return xobj;
    }

    final Xobj getDenormal(int i) {
        Xobj xobj;
        Xobj xobj2;
        int posMax;
        if (!$assertionsDisabled && isRoot() && i != -1 && i <= 0) {
            throw new AssertionError();
        }
        if (i == 0) {
            xobj2 = this._prevSibling;
            if (xobj2 == null) {
                xobj2 = ensureParent();
                posMax = xobj2.posAfter() - 1;
            } else {
                posMax = xobj2.posMax();
            }
        } else {
            if (i == -1) {
                xobj2 = this._lastChild;
                if (xobj2 == null) {
                    i = posAfter() - 1;
                } else {
                    posMax = xobj2.posMax();
                }
            }
            xobj = this;
            this._locale._posTemp = i;
            return xobj;
        }
        int i2 = posMax;
        xobj = xobj2;
        i = i2;
        this._locale._posTemp = i;
        return xobj;
    }

    final boolean isNormal(int i) {
        Xobj xobj;
        if (!isValid()) {
            return false;
        }
        if (i == -1 || i == 0) {
            return true;
        }
        if (i < 0 || i >= posMax()) {
            return false;
        }
        if (i >= posAfter()) {
            if (isRoot()) {
                return false;
            }
            Xobj xobj2 = this._nextSibling;
            if ((xobj2 != null && xobj2.isAttr()) || (xobj = this._parent) == null || !xobj.isContainer()) {
                return false;
            }
        }
        return i != posAfter() - 1;
    }

    final Xobj walk(Xobj xobj, boolean z) {
        Xobj xobj2 = this._firstChild;
        if (xobj2 != null && z) {
            return xobj2;
        }
        for (Xobj xobj3 = this; xobj3 != xobj; xobj3 = xobj3._parent) {
            Xobj xobj4 = xobj3._nextSibling;
            if (xobj4 != null) {
                return xobj4;
            }
        }
        return null;
    }

    final Xobj removeXobj() {
        Xobj xobj = this._parent;
        if (xobj != null) {
            if (xobj._firstChild == this) {
                xobj._firstChild = this._nextSibling;
            }
            if (xobj._lastChild == this) {
                xobj._lastChild = this._prevSibling;
            }
            Xobj xobj2 = this._prevSibling;
            if (xobj2 != null) {
                xobj2._nextSibling = this._nextSibling;
            }
            Xobj xobj3 = this._nextSibling;
            if (xobj3 != null) {
                xobj3._prevSibling = xobj2;
            }
            this._parent = null;
            this._prevSibling = null;
            this._nextSibling = null;
        }
        return this;
    }

    final Xobj insertXobj(Xobj xobj) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && (xobj.isRoot() || isRoot())) {
            throw new AssertionError();
        }
        if (!z && xobj._parent != null) {
            throw new AssertionError();
        }
        if (!z && xobj._prevSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj._nextSibling != null) {
            throw new AssertionError();
        }
        ensureParent();
        xobj._parent = this._parent;
        xobj._prevSibling = this._prevSibling;
        xobj._nextSibling = this;
        Xobj xobj2 = this._prevSibling;
        if (xobj2 != null) {
            xobj2._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj;
        return this;
    }

    final Xobj appendXobj(Xobj xobj) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj.isRoot()) {
            throw new AssertionError();
        }
        if (!z && xobj._parent != null) {
            throw new AssertionError();
        }
        if (!z && xobj._prevSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj._nextSibling != null) {
            throw new AssertionError();
        }
        if (!z && this._lastChild != null && this._firstChild == null) {
            throw new AssertionError();
        }
        xobj._parent = this;
        Xobj xobj2 = this._lastChild;
        xobj._prevSibling = xobj2;
        if (xobj2 == null) {
            this._firstChild = xobj;
        } else {
            xobj2._nextSibling = xobj;
        }
        this._lastChild = xobj;
        return this;
    }

    final void removeXobjs(Xobj xobj, Xobj xobj2) {
        boolean z = $assertionsDisabled;
        if (!z && xobj2._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj._parent != this) {
            throw new AssertionError();
        }
        if (!z && xobj2._parent != this) {
            throw new AssertionError();
        }
        if (this._firstChild == xobj) {
            this._firstChild = xobj2._nextSibling;
        }
        if (this._lastChild == xobj2) {
            this._lastChild = xobj._prevSibling;
        }
        Xobj xobj3 = xobj._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj2._nextSibling;
        }
        Xobj xobj4 = xobj2._nextSibling;
        if (xobj4 != null) {
            xobj4._prevSibling = xobj3;
        }
        xobj._prevSibling = null;
        xobj2._nextSibling = null;
        while (xobj != null) {
            xobj._parent = null;
            xobj = xobj._nextSibling;
        }
    }

    final void insertXobjs(Xobj xobj, Xobj xobj2) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj2._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && (xobj._parent != null || xobj2._parent != null)) {
            throw new AssertionError();
        }
        if (!z && xobj._prevSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj2._nextSibling != null) {
            throw new AssertionError();
        }
        xobj._prevSibling = this._prevSibling;
        xobj2._nextSibling = this;
        Xobj xobj3 = this._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj2;
        while (xobj != this) {
            xobj._parent = this._parent;
            xobj = xobj._nextSibling;
        }
    }

    final void appendXobjs(Xobj xobj, Xobj xobj2) {
        boolean z = $assertionsDisabled;
        if (!z && this._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && xobj2._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && (xobj._parent != null || xobj2._parent != null)) {
            throw new AssertionError();
        }
        if (!z && xobj._prevSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj2._nextSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj.isRoot()) {
            throw new AssertionError();
        }
        Xobj xobj3 = this._lastChild;
        xobj._prevSibling = xobj3;
        if (xobj3 == null) {
            this._firstChild = xobj;
        } else {
            xobj3._nextSibling = xobj;
        }
        this._lastChild = xobj2;
        while (xobj != null) {
            xobj._parent = this;
            xobj = xobj._nextSibling;
        }
    }

    static final void disbandXobjs(Xobj xobj, Xobj xobj2) {
        boolean z = $assertionsDisabled;
        if (!z && xobj2._locale != xobj._locale) {
            throw new AssertionError();
        }
        if (!z && (xobj._parent != null || xobj2._parent != null)) {
            throw new AssertionError();
        }
        if (!z && xobj._prevSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj2._nextSibling != null) {
            throw new AssertionError();
        }
        if (!z && xobj.isRoot()) {
            throw new AssertionError();
        }
        while (xobj != null) {
            Xobj xobj3 = xobj._nextSibling;
            xobj._prevSibling = null;
            xobj._nextSibling = null;
            xobj = xobj3;
        }
    }

    final void invalidateSpecialAttr(Xobj xobj) {
        if (isAttr()) {
            if (this._name.equals(Locale._xsiType)) {
                Xobj xobj2 = this._parent;
                if (xobj2 != null) {
                    xobj2.disconnectNonRootUsers();
                }
                if (xobj != null) {
                    xobj.disconnectNonRootUsers();
                }
            }
            if (this._name.equals(Locale._xsiNil)) {
                Xobj xobj3 = this._parent;
                if (xobj3 != null) {
                    xobj3.invalidateNil();
                }
                if (xobj != null) {
                    xobj.invalidateNil();
                }
            }
        }
    }

    final void removeCharsHelper(int i, int i2, Xobj xobj, int i3, boolean z, boolean z2) {
        Xobj xobj2;
        boolean z3 = $assertionsDisabled;
        if (!z3 && (i <= 0 || i >= posMax() || i == posAfter() - 1)) {
            throw new AssertionError();
        }
        if (!z3 && i2 <= 0) {
            throw new AssertionError();
        }
        if (!z3 && cchRight(i) < i2) {
            throw new AssertionError();
        }
        if (!z3 && z && xobj == null) {
            throw new AssertionError();
        }
        Cur embedded = getEmbedded();
        while (embedded != null) {
            Cur cur = embedded._next;
            if (!$assertionsDisabled && embedded._xobj != this) {
                throw new AssertionError();
            }
            if (embedded._pos >= i && embedded._pos < i + i2) {
                if (z) {
                    embedded.moveToNoCheck(xobj, (embedded._pos + i3) - i);
                } else {
                    embedded.nextChars((i2 - embedded._pos) + i);
                }
            }
            if (embedded._xobj == this && embedded._pos >= i + i2) {
                embedded._pos -= i2;
            }
            embedded = cur;
        }
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            Bookmark bookmark2 = bookmark._next;
            boolean z4 = $assertionsDisabled;
            if (!z4 && bookmark._xobj != this) {
                throw new AssertionError();
            }
            if (bookmark._pos >= i && bookmark._pos < i + i2) {
                if (!z4 && xobj == null) {
                    throw new AssertionError();
                }
                bookmark.moveTo(xobj, (bookmark._pos + i3) - i);
            }
            if (bookmark._xobj == this && bookmark._pos >= i + i2) {
                bookmark._pos -= i2;
            }
        }
        int posAfter = posAfter();
        CharUtil charUtil = this._locale.getCharUtil();
        if (i < posAfter) {
            this._srcValue = charUtil.removeChars(i - 1, i2, this._srcValue, this._offValue, this._cchValue);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z2) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.removeChars(i - posAfter, i2, this._srcAfter, this._offAfter, this._cchAfter);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z2 || (xobj2 = this._parent) == null) {
            return;
        }
        xobj2.invalidateUser();
    }

    final void insertCharsHelper(int i, Object obj, int i2, int i3, boolean z) {
        Xobj xobj;
        boolean z2 = $assertionsDisabled;
        if (!z2 && i <= 0) {
            throw new AssertionError();
        }
        if (!z2 && i < posAfter() && !isOccupied()) {
            throw new AssertionError();
        }
        int posAfter = posAfter();
        if (i - (i < posAfter ? 1 : 2) < this._cchValue + this._cchAfter) {
            for (Cur embedded = getEmbedded(); embedded != null; embedded = embedded._next) {
                if (embedded._pos >= i) {
                    embedded._pos += i3;
                }
            }
            for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (bookmark._pos >= i) {
                    bookmark._pos += i3;
                }
            }
        }
        CharUtil charUtil = this._locale.getCharUtil();
        if (i < posAfter) {
            this._srcValue = charUtil.insertChars(i - 1, this._srcValue, this._offValue, this._cchValue, obj, i2, i3);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.insertChars(i - posAfter, this._srcAfter, this._offAfter, this._cchAfter, obj, i2, i3);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z || (xobj = this._parent) == null) {
            return;
        }
        xobj.invalidateUser();
    }

    Xobj copyNode(Locale locale) {
        Xobj xobj = this;
        Xobj xobj2 = null;
        Xobj xobj3 = null;
        while (true) {
            xobj.ensureOccupancy();
            Xobj newNode = xobj.newNode(locale);
            newNode._srcValue = xobj._srcValue;
            newNode._offValue = xobj._offValue;
            newNode._cchValue = xobj._cchValue;
            newNode._srcAfter = xobj._srcAfter;
            newNode._offAfter = xobj._offAfter;
            newNode._cchAfter = xobj._cchAfter;
            for (Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (xobj.hasBookmark(CDataBookmark.CDATA_BOOKMARK.getKey(), bookmark._pos)) {
                    newNode.setBookmark(bookmark._pos, CDataBookmark.CDATA_BOOKMARK.getKey(), CDataBookmark.CDATA_BOOKMARK);
                }
            }
            if (xobj2 == null) {
                xobj3 = newNode;
            } else {
                xobj2.appendXobj(newNode);
            }
            Xobj walk = xobj.walk(this, true);
            if (walk != null) {
                if (xobj == walk._parent) {
                    xobj2 = newNode;
                } else {
                    while (true) {
                        xobj = xobj._parent;
                        if (xobj != walk._parent) {
                            xobj2 = xobj2._parent;
                        }
                    }
                }
                xobj = walk;
            } else {
                xobj3._srcAfter = null;
                xobj3._offAfter = 0;
                xobj3._cchAfter = 0;
                return xobj3;
            }
        }
    }

    String getCharsAsString(int i, int i2, int i3) {
        if (cchRight(i) == 0) {
            return "";
        }
        Object chars = getChars(i, i2);
        if (i3 == 1) {
            return CharUtil.getString(chars, this._locale._offSrc, this._locale._cchSrc);
        }
        Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i3);
        scrubBuffer.scrub(chars, this._locale._offSrc, this._locale._cchSrc);
        return scrubBuffer.getResultAsString();
    }

    String getCharsAfterAsString(int i, int i2) {
        int i3 = i + this._cchValue + 2;
        if (i3 == posMax()) {
            i3 = -1;
        }
        return getCharsAsString(i3, i2, 1);
    }

    String getCharsValueAsString(int i, int i2) {
        return getCharsAsString(i + 1, i2, 1);
    }

    String getValueAsString(int i) {
        if (!hasChildren()) {
            Object firstChars = getFirstChars();
            if (i == 1) {
                String string = CharUtil.getString(firstChars, this._locale._offSrc, this._locale._cchSrc);
                int length = string.length();
                if (length > 0) {
                    Xobj lastAttr = lastAttr();
                    if (!$assertionsDisabled) {
                        if ((lastAttr == null ? this._cchValue : lastAttr._cchAfter) != length) {
                            throw new AssertionError();
                        }
                    }
                    if (lastAttr != null) {
                        lastAttr._srcAfter = string;
                        lastAttr._offAfter = 0;
                    } else {
                        this._srcValue = string;
                        this._offValue = 0;
                    }
                }
                return string;
            }
            Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i);
            scrubBuffer.scrub(firstChars, this._locale._offSrc, this._locale._cchSrc);
            return scrubBuffer.getResultAsString();
        }
        Locale.ScrubBuffer scrubBuffer2 = Locale.getScrubBuffer(i);
        Cur tempCur = tempCur();
        tempCur.push();
        tempCur.next();
        while (!tempCur.isAtEndOfLastPush()) {
            if (tempCur.isText()) {
                scrubBuffer2.scrub(tempCur.getChars(-1), tempCur._offSrc, tempCur._cchSrc);
            }
            if (tempCur.isComment() || tempCur.isProcinst()) {
                tempCur.skip();
            } else {
                tempCur.next();
            }
        }
        String resultAsString = scrubBuffer2.getResultAsString();
        tempCur.release();
        return resultAsString;
    }

    String getValueAsString() {
        return getValueAsString(1);
    }

    String getString(int i, int i2) {
        String string;
        int cchRight = cchRight(i);
        if (cchRight == 0) {
            return "";
        }
        if (i2 < 0 || i2 > cchRight) {
            i2 = cchRight;
        }
        int posAfter = posAfter();
        if (!$assertionsDisabled && i <= 0) {
            throw new AssertionError();
        }
        if (i >= posAfter) {
            string = CharUtil.getString(this._srcAfter, (this._offAfter + i) - posAfter, i2);
            if (i == posAfter && i2 == this._cchAfter) {
                this._srcAfter = string;
                this._offAfter = 0;
            }
        } else {
            string = CharUtil.getString(this._srcValue, (this._offValue + i) - 1, i2);
            if (i == 1 && i2 == this._cchValue) {
                this._srcValue = string;
                this._offValue = 0;
            }
        }
        return string;
    }

    Object getFirstChars() {
        ensureOccupancy();
        if (this._cchValue > 0) {
            return getChars(1, -1);
        }
        Xobj lastAttr = lastAttr();
        if (lastAttr == null || lastAttr._cchAfter <= 0) {
            this._locale._offSrc = 0;
            this._locale._cchSrc = 0;
            return null;
        }
        return lastAttr.getChars(lastAttr.posAfter(), -1);
    }

    Object getChars(int i, int i2, Cur cur) {
        Object chars = getChars(i, i2);
        cur._offSrc = this._locale._offSrc;
        cur._cchSrc = this._locale._cchSrc;
        return chars;
    }

    Object getChars(int i, int i2) {
        if (!$assertionsDisabled && !isNormal(i)) {
            throw new AssertionError();
        }
        int cchRight = cchRight(i);
        if (i2 < 0 || i2 > cchRight) {
            i2 = cchRight;
        }
        if (i2 == 0) {
            this._locale._offSrc = 0;
            this._locale._cchSrc = 0;
            return null;
        }
        return getCharsHelper(i, i2);
    }

    Object getCharsHelper(int i, int i2) {
        Object obj;
        if (!$assertionsDisabled && (i2 <= 0 || cchRight(i) < i2)) {
            throw new AssertionError();
        }
        int posAfter = posAfter();
        if (i >= posAfter) {
            obj = this._srcAfter;
            this._locale._offSrc = (this._offAfter + i) - posAfter;
        } else {
            obj = this._srcValue;
            this._locale._offSrc = (this._offValue + i) - 1;
        }
        this._locale._cchSrc = i2;
        return obj;
    }

    final void setBit(int i) {
        this._bits = i | this._bits;
    }

    final void clearBit(int i) {
        this._bits = (~i) & this._bits;
    }

    final boolean bitIsSet(int i) {
        return (i & this._bits) != 0;
    }

    final boolean bitIsClear(int i) {
        return (i & this._bits) == 0;
    }

    final boolean isVacant() {
        return bitIsSet(256);
    }

    final boolean isOccupied() {
        return bitIsClear(256);
    }

    final boolean inhibitDisconnect() {
        return bitIsSet(1024);
    }

    final boolean isStableUser() {
        return bitIsSet(512);
    }

    void invalidateNil() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_nilvalue();
        }
    }

    void setStableType(SchemaType schemaType) {
        setStableUser(((TypeStoreUserFactory) schemaType).createTypeStoreUser());
    }

    void setStableUser(TypeStoreUser typeStoreUser) {
        disconnectNonRootUsers();
        disconnectUser();
        if (!$assertionsDisabled && this._user != null) {
            throw new AssertionError();
        }
        this._user = typeStoreUser;
        typeStoreUser.attach_store(this);
        setBit(512);
    }

    void disconnectUser() {
        if (this._user == null || inhibitDisconnect()) {
            return;
        }
        ensureOccupancy();
        this._user.disconnect_store();
        this._user = null;
    }

    void disconnectNonRootUsers() {
        Xobj xobj = this;
        while (xobj != null) {
            Xobj walk = xobj.walk(this, xobj._user != null);
            if (!xobj.isRoot()) {
                xobj.disconnectUser();
            }
            xobj = walk;
        }
    }

    void disconnectChildrenUsers() {
        Xobj walk = walk(this, this._user == null);
        while (walk != null) {
            Xobj walk2 = walk.walk(this, walk._user != null);
            walk.disconnectUser();
            walk = walk2;
        }
    }

    final String namespaceForPrefix(String str, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if (str.equals("xmlns")) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobj2 = xobj._firstChild; xobj2 != null && xobj2.isAttr(); xobj2 = xobj2._nextSibling) {
                if (xobj2.isXmlns() && xobj2.getXmlnsPrefix().equals(str)) {
                    return xobj2.getXmlnsUri();
                }
            }
        }
        if (z && str.length() == 0) {
            return "";
        }
        return null;
    }

    final String prefixForNamespace(String str, String str2, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str.equals("http://www.w3.org/XML/1998/namespace")) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        Xobj xobj = this;
        while (!xobj.isContainer()) {
            xobj = xobj.ensureParent();
        }
        if (str.length() == 0) {
            Xobj findXmlnsForPrefix = xobj.findXmlnsForPrefix("");
            if (findXmlnsForPrefix != null && findXmlnsForPrefix.getXmlnsUri().length() != 0) {
                if (!z) {
                    return null;
                }
                xobj.setAttr(this._locale.createXmlns(null), "");
            }
            return "";
        }
        for (Xobj xobj2 = xobj; xobj2 != null; xobj2 = xobj2._parent) {
            for (Xobj firstAttr = xobj2.firstAttr(); firstAttr != null; firstAttr = firstAttr.nextAttr()) {
                if (firstAttr.isXmlns() && firstAttr.getXmlnsUri().equals(str) && xobj.findXmlnsForPrefix(firstAttr.getXmlnsPrefix()) == firstAttr) {
                    return firstAttr.getXmlnsPrefix();
                }
            }
        }
        if (!z) {
            return null;
        }
        if (str2 != null && (str2.length() == 0 || str2.toLowerCase().startsWith("xml") || xobj.findXmlnsForPrefix(str2) != null)) {
            str2 = null;
        }
        if (str2 == null) {
            String suggestPrefix = QNameHelper.suggestPrefix(str);
            int i = 1;
            str2 = suggestPrefix;
            while (xobj.findXmlnsForPrefix(str2) != null) {
                str2 = new StringBuffer().append(suggestPrefix).append(i).toString();
                i++;
            }
        }
        for (Xobj xobj3 = xobj; !xobj3.isRoot() && !xobj3.ensureParent().isRoot(); xobj3 = xobj3._parent) {
        }
        xobj.setAttr(this._locale.createXmlns(str2), str);
        return str2;
    }

    final QName getValueAsQName() {
        String str;
        if (!$assertionsDisabled && hasChildren()) {
            throw new AssertionError();
        }
        String valueAsString = getValueAsString(3);
        int indexOf = valueAsString.indexOf(58);
        if (indexOf >= 0) {
            str = valueAsString.substring(0, indexOf);
            valueAsString = valueAsString.substring(indexOf + 1);
        } else {
            str = "";
        }
        String namespaceForPrefix = namespaceForPrefix(str, true);
        if (namespaceForPrefix == null) {
            return null;
        }
        return new QName(namespaceForPrefix, valueAsString);
    }

    final Xobj getAttr(QName qName) {
        for (Xobj xobj = this._firstChild; xobj != null && xobj.isAttr(); xobj = xobj._nextSibling) {
            if (xobj._name.equals(qName)) {
                return xobj;
            }
        }
        return null;
    }

    final QName getXsiTypeName() {
        if (!$assertionsDisabled && !isContainer()) {
            throw new AssertionError();
        }
        Xobj attr = getAttr(Locale._xsiType);
        if (attr == null) {
            return null;
        }
        return attr.getValueAsQName();
    }

    final XmlObject getObject() {
        if (isUserNode()) {
            return (XmlObject) getUser();
        }
        return null;
    }

    final TypeStoreUser getUser() {
        boolean z = $assertionsDisabled;
        if (!z && !isUserNode()) {
            throw new AssertionError();
        }
        if (!z && this._user == null && (isRoot() || isStableUser())) {
            throw new AssertionError();
        }
        if (this._user == null) {
            Xobj xobj = this._parent;
            TypeStoreUser createTypeStoreUser = xobj == null ? ((TypeStoreUserFactory) XmlBeans.NO_TYPE).createTypeStoreUser() : xobj.getUser();
            TypeStoreUser create_element_user = isElem() ? createTypeStoreUser.create_element_user(this._name, getXsiTypeName()) : createTypeStoreUser.create_attribute_user(this._name);
            this._user = create_element_user;
            create_element_user.attach_store(this);
        }
        return this._user;
    }

    final void invalidateUser() {
        boolean z = $assertionsDisabled;
        if (!z && !isValid()) {
            throw new AssertionError();
        }
        if (!z && this._user != null && !isUserNode()) {
            throw new AssertionError();
        }
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_value();
        }
    }

    final void ensureOccupancy() {
        boolean z = $assertionsDisabled;
        if (!z && !isValid()) {
            throw new AssertionError();
        }
        if (isVacant()) {
            if (!z && !isUserNode()) {
                throw new AssertionError();
            }
            clearBit(256);
            TypeStoreUser typeStoreUser = this._user;
            this._user = null;
            String build_text = typeStoreUser.build_text(this);
            long j = this._locale._versionAll;
            long j2 = this._locale._versionSansText;
            setValue(build_text);
            if (!z && j2 != this._locale._versionSansText) {
                throw new AssertionError();
            }
            this._locale._versionAll = j;
            if (!z && this._user != null) {
                throw new AssertionError();
            }
            this._user = typeStoreUser;
        }
    }

    private void setValue(String str) {
        Xobj xobj;
        if (!$assertionsDisabled && !CharUtil.isValid(str, 0, str.length())) {
            throw new AssertionError();
        }
        if (str.length() <= 0) {
            return;
        }
        this._locale.notifyChange();
        Xobj lastAttr = lastAttr();
        int i = 1;
        if (lastAttr != null) {
            i = lastAttr.posAfter();
            xobj = lastAttr;
        } else {
            xobj = this;
        }
        xobj.insertCharsHelper(i, str, 0, str.length(), true);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaTypeLoader get_schematypeloader() {
        return this._locale._schemaTypeLoader;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlLocale get_locale() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public Object get_root_object() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean is_attribute() {
        if ($assertionsDisabled || isValid()) {
            return isAttr();
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean validate_on_set() {
        if ($assertionsDisabled || isValid()) {
            return this._locale._validateOnSet;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_text() {
        this._locale.enter();
        try {
            boolean z = $assertionsDisabled;
            if (!z && !isValid()) {
                throw new AssertionError();
            }
            if (isOccupied()) {
                if (hasTextNoEnsureOccupancy() || hasChildren()) {
                    TypeStoreUser typeStoreUser = this._user;
                    this._user = null;
                    Cur tempCur = tempCur();
                    tempCur.moveNodeContents(null, false);
                    tempCur.release();
                    if (!z && this._user != null) {
                        throw new AssertionError();
                    }
                    this._user = typeStoreUser;
                }
                setBit(256);
            }
            if (!z && !isValid()) {
                throw new AssertionError();
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String fetch_text(int i) {
        this._locale.enter();
        try {
            if (!$assertionsDisabled && (!isValid() || !isOccupied())) {
                throw new AssertionError();
            }
            return getValueAsString(i);
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlCursor new_cursor() {
        this._locale.enter();
        try {
            Cur tempCur = tempCur();
            Cursor cursor = new Cursor(tempCur);
            tempCur.release();
            return cursor;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaField get_schema_field() {
        boolean z = $assertionsDisabled;
        if (!z && !isValid()) {
            throw new AssertionError();
        }
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attribute_field(this._name);
        }
        if (!z && !isElem()) {
            throw new AssertionError();
        }
        TypeStoreVisitor new_visitor = user.new_visitor();
        if (new_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                new_visitor.visit(xobj._name);
                if (xobj == this) {
                    return new_visitor.get_schema_field();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void validate(ValidatorListener validatorListener) {
        this._locale.enter();
        try {
            Cur tempCur = tempCur();
            new Validate(tempCur, validatorListener);
            tempCur.release();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser change_type(SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur tempCur = tempCur();
            tempCur.setType(schemaType, false);
            tempCur.release();
            this._locale.exit();
            return getUser();
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser substitute(QName qName, SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur tempCur = tempCur();
            tempCur.setSubstitution(qName, schemaType, false);
            tempCur.release();
            this._locale.exit();
            return getUser();
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public QName get_xsi_type() {
        return getXsiTypeName();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void store_text(String str) {
        this._locale.enter();
        TypeStoreUser typeStoreUser = this._user;
        this._user = null;
        try {
            Cur tempCur = tempCur();
            tempCur.moveNodeContents(null, false);
            if (str != null && str.length() > 0) {
                tempCur.next();
                tempCur.insertString(str);
            }
            tempCur.release();
            if (!$assertionsDisabled && this._user != null) {
                throw new AssertionError();
            }
            this._user = typeStoreUser;
            this._locale.exit();
        } catch (Throwable th) {
            if (!$assertionsDisabled && this._user != null) {
                throw new AssertionError();
            }
            this._user = typeStoreUser;
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int compute_flags() {
        if (isRoot()) {
            return 0;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attributeflags(this._name);
        }
        int i = user.get_elementflags(this._name);
        if (i != -1) {
            return i;
        }
        TypeStoreVisitor new_visitor = user.new_visitor();
        if (new_visitor == null) {
            return 0;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                new_visitor.visit(xobj._name);
                if (xobj == this) {
                    return new_visitor.get_elementflags();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String compute_default_text() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_default_attribute_text(this._name);
        }
        String str = user.get_default_element_text(this._name);
        if (str != null) {
            return str;
        }
        TypeStoreVisitor new_visitor = user.new_visitor();
        if (new_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                new_visitor.visit(xobj._name);
                if (xobj == this) {
                    return new_visitor.get_default_text();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r0.equals("1") != false) goto L15;
     */
    @Override // org.apache.xmlbeans.impl.values.TypeStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean find_nil() {
        /*
            r3 = this;
            boolean r0 = r3.isAttr()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            org.apache.xmlbeans.impl.store.Locale r0 = r3._locale
            r0.enter()
            aavax.xml.namespace.QName r0 = org.apache.xmlbeans.impl.store.Locale._xsiNil     // Catch: java.lang.Throwable -> L32
            org.apache.xmlbeans.impl.store.Xobj r0 = r3.getAttr(r0)     // Catch: java.lang.Throwable -> L32
            if (r0 != 0) goto L1b
        L15:
            org.apache.xmlbeans.impl.store.Locale r0 = r3._locale
            r0.exit()
            return r1
        L1b:
            r2 = 3
            java.lang.String r0 = r0.getValueAsString(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = "true"
            boolean r2 = r0.equals(r2)     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L30
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L15
        L30:
            r1 = 1
            goto L15
        L32:
            r0 = move-exception
            org.apache.xmlbeans.impl.store.Locale r1 = r3._locale
            r1.exit()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Xobj.find_nil():boolean");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_nil() {
        if (isAttr()) {
            return;
        }
        this._locale.enter();
        try {
            if (!this._user.build_nil()) {
                removeAttr(Locale._xsiNil);
            } else {
                setAttr(Locale._xsiNil, BooleanUtils.TRUE);
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QName qName) {
        return this._locale.count(this, qName, null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QNameSet qNameSet) {
        return this._locale.count(this, null, qNameSet);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QName qName, int i) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName) && i - 1 < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QNameSet qNameSet, int i) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name) && i - 1 < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void find_all_element_users(QName qName, List list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName)) {
                list.add(xobj.getUser());
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void find_all_element_users(QNameSet qNameSet, List list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name)) {
                list.add(xobj.getUser());
            }
        }
    }

    private static TypeStoreUser insertElement(QName qName, Xobj xobj, int i) {
        xobj._locale.enter();
        try {
            Cur tempCur = xobj._locale.tempCur();
            tempCur.moveTo(xobj, i);
            tempCur.createElement(qName);
            TypeStoreUser user = tempCur.getUser();
            tempCur.release();
            return user;
        } finally {
            xobj._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QName qName, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj findNthChildElem = this._locale.findNthChildElem(this, qName, null, i);
        if (findNthChildElem == null) {
            if (i > this._locale.count(this, qName, null) + 1) {
                throw new IndexOutOfBoundsException();
            }
            return add_element_user(qName);
        }
        return insertElement(qName, findNthChildElem, 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QNameSet qNameSet, QName qName, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj findNthChildElem = this._locale.findNthChildElem(this, null, qNameSet, i);
        if (findNthChildElem == null) {
            if (i > this._locale.count(this, null, qNameSet) + 1) {
                throw new IndexOutOfBoundsException();
            }
            return add_element_user(qName);
        }
        return insertElement(qName, findNthChildElem, 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_element_user(QName qName) {
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = null;
        boolean z = false;
        QNameSet qNameSet = null;
        for (Xobj xobj2 = this._lastChild; xobj2 != null; xobj2 = xobj2._prevSibling) {
            if (xobj2.isContainer()) {
                if (xobj2._name.equals(qName)) {
                    break;
                }
                if (!z) {
                    qNameSet = this._user.get_element_ending_delimiters(qName);
                    z = true;
                }
                if (qNameSet == null || qNameSet.contains(xobj2._name)) {
                    xobj = xobj2;
                }
            }
        }
        return xobj == null ? insertElement(qName, this, -1) : insertElement(qName, xobj, 0);
    }

    private static void removeElement(Xobj xobj) {
        if (xobj == null) {
            throw new IndexOutOfBoundsException();
        }
        xobj._locale.enter();
        try {
            Cur tempCur = xobj.tempCur();
            tempCur.moveNode(null);
            tempCur.release();
        } finally {
            xobj._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QName qName, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = this._firstChild;
        while (xobj != null && (!xobj.isElem() || !xobj._name.equals(qName) || i - 1 >= 0)) {
            xobj = xobj._nextSibling;
        }
        removeElement(xobj);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QNameSet qNameSet, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = this._firstChild;
        while (xobj != null && (!xobj.isElem() || !qNameSet.contains(xobj._name) || i - 1 >= 0)) {
            xobj = xobj._nextSibling;
        }
        removeElement(xobj);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_attribute_user(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return null;
        }
        return attr.getUser();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_attribute_user(QName qName) {
        if (getAttr(qName) != null) {
            throw new IndexOutOfBoundsException();
        }
        this._locale.enter();
        try {
            return setAttr(qName, "").getUser();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_attribute(QName qName) {
        this._locale.enter();
        try {
            if (removeAttr(qName)) {
            } else {
                throw new IndexOutOfBoundsException();
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy_contents_from(TypeStore typeStore) {
        Xobj xobj = (Xobj) typeStore;
        if (xobj == this) {
            return getUser();
        }
        this._locale.enter();
        try {
            xobj._locale.enter();
            Cur tempCur = tempCur();
            try {
                Cur tempCur2 = xobj.tempCur();
                Map allNamespaces = Locale.getAllNamespaces(tempCur2, null);
                tempCur2.release();
                if (isAttr()) {
                    Cur tempCur3 = xobj.tempCur();
                    String textValue = Locale.getTextValue(tempCur3);
                    tempCur3.release();
                    tempCur.setValue(textValue);
                } else {
                    disconnectChildrenUsers();
                    boolean z = $assertionsDisabled;
                    if (!z && inhibitDisconnect()) {
                        throw new AssertionError();
                    }
                    setBit(1024);
                    QName xsiTypeName = isContainer() ? getXsiTypeName() : null;
                    Xobj copyNode = xobj.copyNode(this._locale);
                    Cur.moveNodeContents(this, null, true);
                    tempCur.next();
                    Cur.moveNodeContents(copyNode, tempCur, true);
                    tempCur.moveTo(this);
                    if (xsiTypeName != null) {
                        tempCur.setXsiType(xsiTypeName);
                    }
                    if (!z && !inhibitDisconnect()) {
                        throw new AssertionError();
                    }
                    clearBit(1024);
                }
                if (allNamespaces != null) {
                    if (!tempCur.isContainer()) {
                        tempCur.toParent();
                    }
                    Locale.applyNamespaces(tempCur, allNamespaces);
                }
                this._locale.exit();
                return getUser();
            } finally {
                tempCur.release();
                xobj._locale.exit();
            }
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        Xobj createDomDocumentRootXobj;
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        SchemaType schemaType2 = (SchemaType) maskNull.get(XmlOptions.DOCUMENT_TYPE);
        if (schemaType2 == null) {
            schemaType2 = schemaType == null ? XmlObject.type : schemaType;
        }
        Locale locale = locale();
        if (Boolean.TRUE.equals(maskNull.get("COPY_USE_NEW_LOCALE"))) {
            locale = Locale.getLocale(schemaTypeLoader, maskNull);
        }
        if (schemaType2.isDocumentType() || (schemaType2.isNoType() && (this instanceof DocumentXobj))) {
            createDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale, false);
        } else {
            createDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale, true);
        }
        locale.enter();
        try {
            Cur tempCur = createDomDocumentRootXobj.tempCur();
            tempCur.setType(schemaType);
            tempCur.release();
            locale.exit();
            return createDomDocumentRootXobj.copy_contents_from(this);
        } catch (Throwable th) {
            locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void array_setter(XmlObject[] xmlObjectArr, QName qName) {
        this._locale.enter();
        try {
            int length = xmlObjectArr.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < length; i++) {
                if (xmlObjectArr[i] == null) {
                    throw new IllegalArgumentException("Array element null");
                }
                if (xmlObjectArr[i].isImmutable()) {
                    arrayList.add(null);
                    arrayList2.add(null);
                } else {
                    Xobj xobj = (Xobj) ((TypeStoreUser) xmlObjectArr[i]).get_store();
                    Locale locale = xobj._locale;
                    Locale locale2 = this._locale;
                    if (locale == locale2) {
                        arrayList.add(xobj.copyNode(locale2));
                    } else {
                        locale.enter();
                        try {
                            arrayList.add(xobj.copyNode(this._locale));
                        } finally {
                            xobj._locale.exit();
                        }
                    }
                    arrayList2.add(xmlObjectArr[i].schemaType());
                }
            }
            int count_elements = count_elements(qName);
            while (count_elements > length) {
                remove_element(qName, length);
                count_elements--;
            }
            while (length > count_elements) {
                add_element_user(qName);
                count_elements++;
            }
            if (!$assertionsDisabled && length != count_elements) {
                throw new AssertionError();
            }
            ArrayList arrayList3 = new ArrayList();
            find_all_element_users(qName, arrayList3);
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                arrayList3.set(i2, (Xobj) ((TypeStoreUser) arrayList3.get(i2)).get_store());
            }
            if (!$assertionsDisabled && arrayList3.size() != count_elements) {
                throw new AssertionError();
            }
            Cur tempCur = tempCur();
            for (int i3 = 0; i3 < count_elements; i3++) {
                Xobj xobj2 = (Xobj) arrayList3.get(i3);
                if (xmlObjectArr[i3].isImmutable()) {
                    xobj2.getObject().set(xmlObjectArr[i3]);
                } else {
                    Cur.moveNodeContents(xobj2, null, true);
                    tempCur.moveTo(xobj2);
                    tempCur.next();
                    Cur.moveNodeContents((Xobj) arrayList.get(i3), tempCur, true);
                    xobj2.change_type((SchemaType) arrayList2.get(i3));
                }
            }
            tempCur.release();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void visit_elements(TypeStoreVisitor typeStoreVisitor) {
        throw new RuntimeException("Not implemeneted");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlObject[] exec_query(String str, XmlOptions xmlOptions) throws XmlException {
        this._locale.enter();
        try {
            Cur tempCur = tempCur();
            XmlObject[] objectExecQuery = Query.objectExecQuery(tempCur, str, xmlOptions);
            tempCur.release();
            return objectExecQuery;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.NamespaceManager
    public String find_prefix_for_nsuri(String str, String str2) {
        this._locale.enter();
        try {
            return prefixForNamespace(str, str2, true);
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        return namespaceForPrefix(str, true);
    }

    static abstract class NodeXobj extends Xobj implements DomImpl.Dom, Node, NodeList {
        public NamedNodeMap getAttributes() {
            return null;
        }

        public NodeList getChildNodes() {
            return this;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        DomImpl.Dom getDom() {
            return this;
        }

        public boolean nodeCanHavePrefixUri() {
            return false;
        }

        NodeXobj(Locale locale, int i, int i2) {
            super(locale, i, i2);
        }

        public int getLength() {
            return DomImpl._childNodes_getLength(this);
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return DomImpl._childNodes_item(this, i);
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        public Node getFirstChild() {
            return DomImpl._node_getFirstChild(this);
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return DomImpl._node_getLastChild(this);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return DomImpl._node_hasAttributes(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return DomImpl._node_hasChildNodes(this);
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }
    }

    static class DocumentXobj extends NodeXobj implements Document {
        private Hashtable _idToElement;

        DocumentXobj(Locale locale) {
            super(locale, 1, 9);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DocumentXobj(locale);
        }

        @Override // org.w3c.dom.Document
        public Attr createAttribute(String str) {
            return DomImpl._document_createAttribute(this, str);
        }

        @Override // org.w3c.dom.Document
        public Attr createAttributeNS(String str, String str2) {
            return DomImpl._document_createAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public CDATASection createCDATASection(String str) {
            return DomImpl._document_createCDATASection(this, str);
        }

        @Override // org.w3c.dom.Document
        public Comment createComment(String str) {
            return DomImpl._document_createComment(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentFragment createDocumentFragment() {
            return DomImpl._document_createDocumentFragment(this);
        }

        @Override // org.w3c.dom.Document
        public Element createElement(String str) {
            return DomImpl._document_createElement(this, str);
        }

        @Override // org.w3c.dom.Document
        public Element createElementNS(String str, String str2) {
            return DomImpl._document_createElementNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public EntityReference createEntityReference(String str) {
            return DomImpl._document_createEntityReference(this, str);
        }

        @Override // org.w3c.dom.Document
        public ProcessingInstruction createProcessingInstruction(String str, String str2) {
            return DomImpl._document_createProcessingInstruction(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public Text createTextNode(String str) {
            return DomImpl._document_createTextNode(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentType getDoctype() {
            return DomImpl._document_getDoctype(this);
        }

        @Override // org.w3c.dom.Document
        public Element getDocumentElement() {
            return DomImpl._document_getDocumentElement(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.w3c.dom.Document
        public Element getElementById(String str) {
            Xobj xobj;
            Hashtable hashtable = this._idToElement;
            if (hashtable == null || (xobj = (Xobj) hashtable.get(str)) == 0) {
                return null;
            }
            if (!isInSameTree(xobj)) {
                this._idToElement.remove(str);
            }
            return (Element) xobj;
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagName(String str) {
            return DomImpl._document_getElementsByTagName(this, str);
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagNameNS(String str, String str2) {
            return DomImpl._document_getElementsByTagNameNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public DOMImplementation getImplementation() {
            return DomImpl._document_getImplementation(this);
        }

        @Override // org.w3c.dom.Document
        public Node importNode(Node node, boolean z) {
            return DomImpl._document_importNode(this, node, z);
        }

        public Node adoptNode(Node node) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getDocumentURI() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public DOMConfiguration getDomConfig() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getInputEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public boolean getStrictErrorChecking() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getXmlEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public boolean getXmlStandalone() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getXmlVersion() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void normalizeDocument() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public Node renameNode(Node node, String str, String str2) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setDocumentURI(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setStrictErrorChecking(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setXmlStandalone(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setXmlVersion(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        protected void addIdElement(String str, DomImpl.Dom dom) {
            if (this._idToElement == null) {
                this._idToElement = new Hashtable();
            }
            this._idToElement.put(str, dom);
        }

        void removeIdElement(String str) {
            Hashtable hashtable = this._idToElement;
            if (hashtable != null) {
                hashtable.remove(str);
            }
        }
    }

    static class DocumentFragXobj extends NodeXobj implements DocumentFragment {
        DocumentFragXobj(Locale locale) {
            super(locale, 1, 11);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DocumentFragXobj(locale);
        }
    }

    static final class ElementAttributes implements NamedNodeMap {
        private ElementXobj _elementXobj;

        ElementAttributes(ElementXobj elementXobj) {
            this._elementXobj = elementXobj;
        }

        @Override // org.w3c.dom.NamedNodeMap
        public int getLength() {
            return DomImpl._attributes_getLength(this._elementXobj);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node getNamedItem(String str) {
            return DomImpl._attributes_getNamedItem(this._elementXobj, str);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node getNamedItemNS(String str, String str2) {
            return DomImpl._attributes_getNamedItemNS(this._elementXobj, str, str2);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node item(int i) {
            return DomImpl._attributes_item(this._elementXobj, i);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node removeNamedItem(String str) {
            return DomImpl._attributes_removeNamedItem(this._elementXobj, str);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node removeNamedItemNS(String str, String str2) {
            return DomImpl._attributes_removeNamedItemNS(this._elementXobj, str, str2);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node setNamedItem(Node node) {
            return DomImpl._attributes_setNamedItem(this._elementXobj, node);
        }

        @Override // org.w3c.dom.NamedNodeMap
        public Node setNamedItemNS(Node node) {
            return DomImpl._attributes_setNamedItemNS(this._elementXobj, node);
        }
    }

    static abstract class NamedNodeXobj extends NodeXobj {
        boolean _canHavePrefixUri;

        NamedNodeXobj(Locale locale, int i, int i2) {
            super(locale, i, i2);
            this._canHavePrefixUri = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return this._canHavePrefixUri;
        }
    }

    static class ElementXobj extends NamedNodeXobj implements Element {
        private ElementAttributes _attributes;

        ElementXobj(Locale locale, QName qName) {
            super(locale, 2, 1);
            this._name = qName;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new ElementXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            if (this._attributes == null) {
                this._attributes = new ElementAttributes(this);
            }
            return this._attributes;
        }

        @Override // org.w3c.dom.Element
        public String getAttribute(String str) {
            return DomImpl._element_getAttribute(this, str);
        }

        @Override // org.w3c.dom.Element
        public Attr getAttributeNode(String str) {
            return DomImpl._element_getAttributeNode(this, str);
        }

        @Override // org.w3c.dom.Element
        public Attr getAttributeNodeNS(String str, String str2) {
            return DomImpl._element_getAttributeNodeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public String getAttributeNS(String str, String str2) {
            return DomImpl._element_getAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public NodeList getElementsByTagName(String str) {
            return DomImpl._element_getElementsByTagName(this, str);
        }

        @Override // org.w3c.dom.Element
        public NodeList getElementsByTagNameNS(String str, String str2) {
            return DomImpl._element_getElementsByTagNameNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public String getTagName() {
            return DomImpl._element_getTagName(this);
        }

        @Override // org.w3c.dom.Element
        public boolean hasAttribute(String str) {
            return DomImpl._element_hasAttribute(this, str);
        }

        @Override // org.w3c.dom.Element
        public boolean hasAttributeNS(String str, String str2) {
            return DomImpl._element_hasAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public void removeAttribute(String str) {
            DomImpl._element_removeAttribute(this, str);
        }

        @Override // org.w3c.dom.Element
        public Attr removeAttributeNode(Attr attr) {
            return DomImpl._element_removeAttributeNode(this, attr);
        }

        @Override // org.w3c.dom.Element
        public void removeAttributeNS(String str, String str2) {
            DomImpl._element_removeAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public void setAttribute(String str, String str2) {
            DomImpl._element_setAttribute(this, str, str2);
        }

        @Override // org.w3c.dom.Element
        public Attr setAttributeNode(Attr attr) {
            return DomImpl._element_setAttributeNode(this, attr);
        }

        @Override // org.w3c.dom.Element
        public Attr setAttributeNodeNS(Attr attr) {
            return DomImpl._element_setAttributeNodeNS(this, attr);
        }

        @Override // org.w3c.dom.Element
        public void setAttributeNS(String str, String str2, String str3) {
            DomImpl._element_setAttributeNS(this, str, str2, str3);
        }

        public TypeInfo getSchemaTypeInfo() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setIdAttribute(String str, boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setIdAttributeNS(String str, String str2, boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setIdAttributeNode(Attr attr, boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }
    }

    static class AttrXobj extends NamedNodeXobj implements Attr {
        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public Node getNextSibling() {
            return null;
        }

        public boolean isId() {
            return false;
        }

        AttrXobj(Locale locale, QName qName) {
            super(locale, 3, 2);
            this._name = qName;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new AttrXobj(locale, this._name);
        }

        @Override // org.w3c.dom.Attr
        public String getName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Attr
        public Element getOwnerElement() {
            return DomImpl._attr_getOwnerElement(this);
        }

        @Override // org.w3c.dom.Attr
        public boolean getSpecified() {
            return DomImpl._attr_getSpecified(this);
        }

        @Override // org.w3c.dom.Attr
        public String getValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Attr
        public void setValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        public TypeInfo getSchemaTypeInfo() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }
    }

    static class AttrIdXobj extends AttrXobj {
        @Override // org.apache.xmlbeans.impl.store.Xobj.AttrXobj
        public boolean isId() {
            return true;
        }

        AttrIdXobj(Locale locale, QName qName) {
            super(locale, qName);
        }
    }

    static class CommentXobj extends NodeXobj implements Comment {
        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        CommentXobj(Locale locale) {
            super(locale, 4, 8);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new CommentXobj(locale);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public NodeList getChildNodes() {
            return DomImpl._emptyNodeList;
        }

        @Override // org.w3c.dom.CharacterData
        public void appendData(String str) {
            DomImpl._characterData_appendData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void deleteData(int i, int i2) {
            DomImpl._characterData_deleteData(this, i, i2);
        }

        @Override // org.w3c.dom.CharacterData
        public String getData() {
            return DomImpl._characterData_getData(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.NodeList
        public int getLength() {
            return DomImpl._characterData_getLength(this);
        }

        @Override // org.w3c.dom.CharacterData
        public void insertData(int i, String str) {
            DomImpl._characterData_insertData(this, i, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void replaceData(int i, int i2, String str) {
            DomImpl._characterData_replaceData(this, i, i2, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void setData(String str) {
            DomImpl._characterData_setData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public String substringData(int i, int i2) {
            return DomImpl._characterData_substringData(this, i, i2);
        }
    }

    static class ProcInstXobj extends NodeXobj implements ProcessingInstruction {
        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        ProcInstXobj(Locale locale, String str) {
            super(locale, 5, 7);
            this._name = this._locale.makeQName(null, str);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new ProcInstXobj(locale, this._name.getLocalPart());
        }

        @Override // org.w3c.dom.ProcessingInstruction
        public String getData() {
            return DomImpl._processingInstruction_getData(this);
        }

        @Override // org.w3c.dom.ProcessingInstruction
        public String getTarget() {
            return DomImpl._processingInstruction_getTarget(this);
        }

        @Override // org.w3c.dom.ProcessingInstruction
        public void setData(String str) {
            DomImpl._processingInstruction_setData(this, str);
        }
    }

    static class SoapPartDocXobj extends DocumentXobj {
        SoapPartDom _soapPartDom;

        SoapPartDocXobj(Locale locale) {
            super(locale);
            this._soapPartDom = new SoapPartDom(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.NodeXobj, org.apache.xmlbeans.impl.store.Xobj
        DomImpl.Dom getDom() {
            return this._soapPartDom;
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.DocumentXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapPartDocXobj(locale);
        }
    }

    static class SoapPartDom extends SOAPPart implements DomImpl.Dom, Document, NodeList {
        SoapPartDocXobj _docXobj;

        @Override // org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public NodeList getChildNodes() {
            return this;
        }

        public String name() {
            return "#document";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 9;
        }

        SoapPartDom(SoapPartDocXobj soapPartDocXobj) {
            this._docXobj = soapPartDocXobj;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Locale locale() {
            return this._docXobj._locale;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Cur tempCur() {
            return this._docXobj.tempCur();
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public QName getQName() {
            return this._docXobj._name;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump() {
            dump(System.out);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream) {
            this._docXobj.dump(printStream);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream, Object obj) {
            this._docXobj.dump(printStream, obj);
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node getFirstChild() {
            return DomImpl._node_getFirstChild(this);
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return DomImpl._node_getLastChild(this);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        @Override // org.w3c.dom.Node
        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return DomImpl._node_hasAttributes(this);
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return DomImpl._node_hasChildNodes(this);
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }

        public Node adoptNode(Node node) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getDocumentURI() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public DOMConfiguration getDomConfig() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getInputEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public boolean getStrictErrorChecking() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getXmlEncoding() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public boolean getXmlStandalone() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public String getXmlVersion() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void normalizeDocument() {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public Node renameNode(Node node, String str, String str2) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setDocumentURI(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setStrictErrorChecking(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setXmlStandalone(boolean z) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        public void setXmlVersion(String str) {
            throw new RuntimeException("DOM Level 3 Not implemented");
        }

        @Override // org.w3c.dom.Document
        public Attr createAttribute(String str) {
            return DomImpl._document_createAttribute(this, str);
        }

        @Override // org.w3c.dom.Document
        public Attr createAttributeNS(String str, String str2) {
            return DomImpl._document_createAttributeNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public CDATASection createCDATASection(String str) {
            return DomImpl._document_createCDATASection(this, str);
        }

        @Override // org.w3c.dom.Document
        public Comment createComment(String str) {
            return DomImpl._document_createComment(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentFragment createDocumentFragment() {
            return DomImpl._document_createDocumentFragment(this);
        }

        @Override // org.w3c.dom.Document
        public Element createElement(String str) {
            return DomImpl._document_createElement(this, str);
        }

        @Override // org.w3c.dom.Document
        public Element createElementNS(String str, String str2) {
            return DomImpl._document_createElementNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public EntityReference createEntityReference(String str) {
            return DomImpl._document_createEntityReference(this, str);
        }

        @Override // org.w3c.dom.Document
        public ProcessingInstruction createProcessingInstruction(String str, String str2) {
            return DomImpl._document_createProcessingInstruction(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public Text createTextNode(String str) {
            return DomImpl._document_createTextNode(this, str);
        }

        @Override // org.w3c.dom.Document
        public DocumentType getDoctype() {
            return DomImpl._document_getDoctype(this);
        }

        @Override // org.w3c.dom.Document
        public Element getDocumentElement() {
            return DomImpl._document_getDocumentElement(this);
        }

        @Override // org.w3c.dom.Document
        public Element getElementById(String str) {
            return DomImpl._document_getElementById(this, str);
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagName(String str) {
            return DomImpl._document_getElementsByTagName(this, str);
        }

        @Override // org.w3c.dom.Document
        public NodeList getElementsByTagNameNS(String str, String str2) {
            return DomImpl._document_getElementsByTagNameNS(this, str, str2);
        }

        @Override // org.w3c.dom.Document
        public DOMImplementation getImplementation() {
            return DomImpl._document_getImplementation(this);
        }

        @Override // org.w3c.dom.Document
        public Node importNode(Node node, boolean z) {
            return DomImpl._document_importNode(this, node, z);
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return DomImpl._childNodes_getLength(this);
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return DomImpl._childNodes_item(this, i);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void removeAllMimeHeaders() {
            DomImpl._soapPart_removeAllMimeHeaders(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void removeMimeHeader(String str) {
            DomImpl._soapPart_removeMimeHeader(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Iterator getAllMimeHeaders() {
            return DomImpl._soapPart_getAllMimeHeaders(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public SOAPEnvelope getEnvelope() {
            return DomImpl._soapPart_getEnvelope(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Source getContent() {
            return DomImpl._soapPart_getContent(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void setContent(Source source) {
            DomImpl._soapPart_setContent(this, source);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public String[] getMimeHeader(String str) {
            return DomImpl._soapPart_getMimeHeader(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void addMimeHeader(String str, String str2) {
            DomImpl._soapPart_addMimeHeader(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public void setMimeHeader(String str, String str2) {
            DomImpl._soapPart_setMimeHeader(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Iterator getMatchingMimeHeaders(String[] strArr) {
            return DomImpl._soapPart_getMatchingMimeHeaders(this, strArr);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPPart
        public Iterator getNonMatchingMimeHeaders(String[] strArr) {
            return DomImpl._soapPart_getNonMatchingMimeHeaders(this, strArr);
        }
    }

    static class SoapElementXobj extends ElementXobj implements SOAPElement, org.apache.xmlbeans.impl.soap.Node {
        SoapElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapElementXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public void removeContents() {
            DomImpl._soapElement_removeContents(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public String getEncodingStyle() {
            return DomImpl._soapElement_getEncodingStyle(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public void setEncodingStyle(String str) {
            DomImpl._soapElement_setEncodingStyle(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public boolean removeNamespaceDeclaration(String str) {
            return DomImpl._soapElement_removeNamespaceDeclaration(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getAllAttributes() {
            return DomImpl._soapElement_getAllAttributes(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getChildElements() {
            return DomImpl._soapElement_getChildElements(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getNamespacePrefixes() {
            return DomImpl._soapElement_getNamespacePrefixes(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addAttribute(Name name, String str) throws SOAPException {
            return DomImpl._soapElement_addAttribute(this, name, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(SOAPElement sOAPElement) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, sOAPElement);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(Name name) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(String str) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(String str, String str2) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addChildElement(String str, String str2, String str3) throws SOAPException {
            return DomImpl._soapElement_addChildElement(this, str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addNamespaceDeclaration(String str, String str2) {
            return DomImpl._soapElement_addNamespaceDeclaration(this, str, str2);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public SOAPElement addTextNode(String str) {
            return DomImpl._soapElement_addTextNode(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public String getAttributeValue(Name name) {
            return DomImpl._soapElement_getAttributeValue(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getChildElements(Name name) {
            return DomImpl._soapElement_getChildElements(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Name getElementName() {
            return DomImpl._soapElement_getElementName(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public String getNamespaceURI(String str) {
            return DomImpl._soapElement_getNamespaceURI(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public Iterator getVisibleNamespacePrefixes() {
            return DomImpl._soapElement_getVisibleNamespacePrefixes(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPElement
        public boolean removeAttribute(Name name) {
            return DomImpl._soapElement_removeAttribute(this, name);
        }
    }

    static class SoapBodyXobj extends SoapElementXobj implements SOAPBody {
        SoapBodyXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapBodyXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public boolean hasFault() {
            return DomImpl.soapBody_hasFault(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault addFault() throws SOAPException {
            return DomImpl.soapBody_addFault(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault getFault() {
            return DomImpl.soapBody_getFault(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPBodyElement addBodyElement(Name name) {
            return DomImpl.soapBody_addBodyElement(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPBodyElement addDocument(Document document) {
            return DomImpl.soapBody_addDocument(this, document);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault addFault(Name name, String str) throws SOAPException {
            return DomImpl.soapBody_addFault(this, name, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPBody
        public SOAPFault addFault(Name name, String str, java.util.Locale locale) throws SOAPException {
            return DomImpl.soapBody_addFault(this, name, str, locale);
        }
    }

    static class SoapBodyElementXobj extends SoapElementXobj implements SOAPBodyElement {
        SoapBodyElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapBodyElementXobj(locale, this._name);
        }
    }

    static class SoapEnvelopeXobj extends SoapElementXobj implements SOAPEnvelope {
        SoapEnvelopeXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapEnvelopeXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPBody addBody() throws SOAPException {
            return DomImpl._soapEnvelope_addBody(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPBody getBody() throws SOAPException {
            return DomImpl._soapEnvelope_getBody(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPHeader getHeader() throws SOAPException {
            return DomImpl._soapEnvelope_getHeader(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public SOAPHeader addHeader() throws SOAPException {
            return DomImpl._soapEnvelope_addHeader(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public Name createName(String str) {
            return DomImpl._soapEnvelope_createName(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPEnvelope
        public Name createName(String str, String str2, String str3) {
            return DomImpl._soapEnvelope_createName(this, str, str2, str3);
        }
    }

    static class SoapHeaderXobj extends SoapElementXobj implements SOAPHeader {
        SoapHeaderXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapHeaderXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator examineAllHeaderElements() {
            return DomImpl.soapHeader_examineAllHeaderElements(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator extractAllHeaderElements() {
            return DomImpl.soapHeader_extractAllHeaderElements(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator examineHeaderElements(String str) {
            return DomImpl.soapHeader_examineHeaderElements(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator examineMustUnderstandHeaderElements(String str) {
            return DomImpl.soapHeader_examineMustUnderstandHeaderElements(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public Iterator extractHeaderElements(String str) {
            return DomImpl.soapHeader_extractHeaderElements(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
        public SOAPHeaderElement addHeaderElement(Name name) {
            return DomImpl.soapHeader_addHeaderElement(this, name);
        }
    }

    static class SoapHeaderElementXobj extends SoapElementXobj implements SOAPHeaderElement {
        SoapHeaderElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapHeaderElementXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public void setMustUnderstand(boolean z) {
            DomImpl.soapHeaderElement_setMustUnderstand(this, z);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public boolean getMustUnderstand() {
            return DomImpl.soapHeaderElement_getMustUnderstand(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public void setActor(String str) {
            DomImpl.soapHeaderElement_setActor(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
        public String getActor() {
            return DomImpl.soapHeaderElement_getActor(this);
        }
    }

    static class SoapFaultXobj extends SoapBodyElementXobj implements SOAPFault {
        SoapFaultXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapBodyElementXobj, org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapFaultXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultString(String str) {
            DomImpl.soapFault_setFaultString(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultString(String str, java.util.Locale locale) {
            DomImpl.soapFault_setFaultString(this, str, locale);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultCode(Name name) throws SOAPException {
            DomImpl.soapFault_setFaultCode(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultActor(String str) {
            DomImpl.soapFault_setFaultActor(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public String getFaultActor() {
            return DomImpl.soapFault_getFaultActor(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public String getFaultCode() {
            return DomImpl.soapFault_getFaultCode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public void setFaultCode(String str) throws SOAPException {
            DomImpl.soapFault_setFaultCode(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public java.util.Locale getFaultStringLocale() {
            return DomImpl.soapFault_getFaultStringLocale(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public Name getFaultCodeAsName() {
            return DomImpl.soapFault_getFaultCodeAsName(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public String getFaultString() {
            return DomImpl.soapFault_getFaultString(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public Detail addDetail() throws SOAPException {
            return DomImpl.soapFault_addDetail(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.SOAPFault
        public Detail getDetail() {
            return DomImpl.soapFault_getDetail(this);
        }
    }

    static class SoapFaultElementXobj extends SoapElementXobj implements SOAPFaultElement {
        SoapFaultElementXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new SoapFaultElementXobj(locale, this._name);
        }
    }

    static class DetailXobj extends SoapFaultElementXobj implements Detail {
        DetailXobj(Locale locale, QName qName) {
            super(locale, qName);
        }

        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapFaultElementXobj, org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DetailXobj(locale, this._name);
        }

        @Override // org.apache.xmlbeans.impl.soap.Detail
        public DetailEntry addDetailEntry(Name name) {
            return DomImpl.detail_addDetailEntry(this, name);
        }

        @Override // org.apache.xmlbeans.impl.soap.Detail
        public Iterator getDetailEntries() {
            return DomImpl.detail_getDetailEntries(this);
        }
    }

    static class DetailEntryXobj extends SoapElementXobj implements DetailEntry {
        @Override // org.apache.xmlbeans.impl.store.Xobj.SoapElementXobj, org.apache.xmlbeans.impl.store.Xobj.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
        Xobj newNode(Locale locale) {
            return new DetailEntryXobj(locale, this._name);
        }

        DetailEntryXobj(Locale locale, QName qName) {
            super(locale, qName);
        }
    }

    static class Bookmark implements XmlCursor.XmlMark {
        static final /* synthetic */ boolean $assertionsDisabled;
        Object _key;
        Bookmark _next;
        int _pos;
        Bookmark _prev;
        Object _value;
        Xobj _xobj;

        static {
            if (Xobj.class$org$apache$xmlbeans$impl$store$Xobj == null) {
                Xobj.class$org$apache$xmlbeans$impl$store$Xobj = Xobj.class$("org.apache.xmlbeans.impl.store.Xobj");
            } else {
                Class cls = Xobj.class$org$apache$xmlbeans$impl$store$Xobj;
            }
            $assertionsDisabled = true;
        }

        Bookmark() {
        }

        boolean isOnList(Bookmark bookmark) {
            while (bookmark != null) {
                if (bookmark == this) {
                    return true;
                }
                bookmark = bookmark._next;
            }
            return false;
        }

        Bookmark listInsert(Bookmark bookmark) {
            if (!$assertionsDisabled && (this._next != null || this._prev != null)) {
                throw new AssertionError();
            }
            if (bookmark == null) {
                this._prev = this;
                return this;
            }
            this._prev = bookmark._prev;
            bookmark._prev._next = this;
            bookmark._prev = this;
            return bookmark;
        }

        Bookmark listRemove(Bookmark bookmark) {
            boolean z = $assertionsDisabled;
            if (!z && (this._prev == null || !isOnList(bookmark))) {
                throw new AssertionError();
            }
            Bookmark bookmark2 = this._prev;
            if (bookmark2 == this) {
                bookmark = null;
            } else {
                if (bookmark == this) {
                    bookmark = this._next;
                } else {
                    bookmark2._next = this._next;
                }
                Bookmark bookmark3 = this._next;
                if (bookmark3 == null) {
                    bookmark._prev = bookmark2;
                } else {
                    bookmark3._prev = bookmark2;
                    this._next = null;
                }
            }
            this._prev = null;
            if (z || this._next == null) {
                return bookmark;
            }
            throw new AssertionError();
        }

        void moveTo(Xobj xobj, int i) {
            if (!$assertionsDisabled && !isOnList(this._xobj._bookmarks)) {
                throw new AssertionError();
            }
            Xobj xobj2 = this._xobj;
            if (xobj2 != xobj) {
                xobj2._bookmarks = listRemove(xobj2._bookmarks);
                xobj._bookmarks = listInsert(xobj._bookmarks);
                this._xobj = xobj;
            }
            this._pos = i;
        }

        @Override // org.apache.xmlbeans.XmlCursor.XmlMark
        public XmlCursor createCursor() {
            Xobj xobj = this._xobj;
            if (xobj == null) {
                throw new IllegalStateException("Attempting to create a cursor on a bookmark that has been cleared or replaced.");
            }
            return Cursor.newCursor(xobj, this._pos);
        }
    }
}
