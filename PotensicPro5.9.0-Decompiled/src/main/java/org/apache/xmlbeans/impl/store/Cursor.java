package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.store.Path;
import org.apache.xmlbeans.impl.store.Saver;
import org.apache.xmlbeans.impl.store.Xobj;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes5.dex */
public final class Cursor implements XmlCursor, Locale.ChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    private static final int COPY_CHARS = 5;
    private static final int COPY_XML = 1;
    private static final int COPY_XML_CONTENTS = 3;
    static final int ELEM = 2;
    private static final int MOVE_CHARS = 4;
    private static final int MOVE_XML = 0;
    private static final int MOVE_XML_CONTENTS = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Cursor;
    private Cur _cur;
    private int _currentSelection;
    private Locale.ChangeListener _nextChangeListener;
    private Path.PathEngine _pathEngine;

    static {
        if (class$org$apache$xmlbeans$impl$store$Cursor == null) {
            class$org$apache$xmlbeans$impl$store$Cursor = class$("org.apache.xmlbeans.impl.store.Cursor");
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

    Cursor(Xobj xobj, int i) {
        Cur weakCur = xobj._locale.weakCur(this);
        this._cur = weakCur;
        weakCur.moveTo(xobj, i);
        this._currentSelection = -1;
    }

    Cursor(Cur cur) {
        this(cur._xobj, cur._pos);
    }

    private static boolean isValid(Cur cur) {
        int kind;
        if (cur.kind() > 0) {
            return true;
        }
        cur.push();
        if (cur.toParentRaw() && ((kind = cur.kind()) == 4 || kind == 5 || kind == 3)) {
            return false;
        }
        cur.pop();
        return true;
    }

    private boolean isValid() {
        return isValid(this._cur);
    }

    Locale locale() {
        return this._cur._locale;
    }

    Cur tempCur() {
        return this._cur.tempCur();
    }

    public void dump(PrintStream printStream) {
        this._cur.dump(printStream);
    }

    static void validateLocalName(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("QName is null");
        }
        validateLocalName(qName.getLocalPart());
    }

    static void validateLocalName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidNCName(str)) {
            throw new IllegalArgumentException("Name is not valid");
        }
    }

    static void validatePrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Prefix is empty");
        }
        if (Locale.beginsWithXml(str)) {
            throw new IllegalArgumentException("Prefix begins with 'xml'");
        }
        if (!XMLChar.isValidNCName(str)) {
            throw new IllegalArgumentException("Prefix is not valid");
        }
    }

    private static void complain(String str) {
        throw new IllegalArgumentException(str);
    }

    private void checkInsertionValidity(Cur cur) {
        int kind = cur.kind();
        if (kind < 0) {
            complain("Can't move/copy/insert an end token.");
        }
        if (kind == 1) {
            complain("Can't move/copy/insert a whole document.");
        }
        int kind2 = this._cur.kind();
        if (kind2 == 1) {
            complain("Can't insert before the start of the document.");
        }
        if (kind == 3) {
            this._cur.push();
            this._cur.prevWithAttrs();
            int kind3 = this._cur.kind();
            this._cur.pop();
            if (kind3 != 2 && kind3 != 1 && kind3 != -3) {
                complain("Can only insert attributes before other attributes or after containers.");
            }
        }
        if (kind2 != 3 || kind == 3) {
            return;
        }
        complain("Can only insert attributes before other attributes or after containers.");
    }

    private void insertNode(Cur cur, String str) {
        boolean z = $assertionsDisabled;
        if (!z && cur.isRoot()) {
            throw new AssertionError();
        }
        if (!z && !cur.isNode()) {
            throw new AssertionError();
        }
        if (!z && !isValid(cur)) {
            throw new AssertionError();
        }
        if (!z && !isValid()) {
            throw new AssertionError();
        }
        if (str != null && str.length() > 0) {
            cur.next();
            cur.insertString(str);
            cur.toParent();
        }
        checkInsertionValidity(cur);
        cur.moveNode(this._cur);
        this._cur.toEnd();
        this._cur.nextWithAttrs();
    }

    public void _dispose() {
        this._cur.release();
        this._cur = null;
    }

    public XmlCursor _newCursor() {
        return new Cursor(this._cur);
    }

    public QName _getName() {
        int kind = this._cur.kind();
        if (kind != 2) {
            if (kind != 3) {
                if (kind != 5) {
                    return null;
                }
            } else if (this._cur.isXmlns()) {
                return this._cur._locale.makeQNameNoCheck(this._cur.getXmlnsUri(), this._cur.getXmlnsPrefix());
            }
        }
        return this._cur.getName();
    }

    public void _setName(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Name is null");
        }
        int kind = this._cur.kind();
        if (kind == 2 || kind == 3) {
            validateLocalName(qName.getLocalPart());
        } else if (kind == 5) {
            validatePrefix(qName.getLocalPart());
            if (qName.getNamespaceURI().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no URI");
            }
            if (qName.getPrefix().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no prefix");
            }
        } else {
            throw new IllegalStateException("Can set name on element, atrtribute and procinst only");
        }
        this._cur.setName(qName);
    }

    public XmlCursor.TokenType _currentTokenType() {
        if (!$assertionsDisabled && !isValid()) {
            throw new AssertionError();
        }
        switch (this._cur.kind()) {
            case -2:
                return XmlCursor.TokenType.END;
            case -1:
                return XmlCursor.TokenType.ENDDOC;
            case 0:
                return XmlCursor.TokenType.TEXT;
            case 1:
                return XmlCursor.TokenType.STARTDOC;
            case 2:
                return XmlCursor.TokenType.START;
            case 3:
                return this._cur.isXmlns() ? XmlCursor.TokenType.NAMESPACE : XmlCursor.TokenType.ATTR;
            case 4:
                return XmlCursor.TokenType.COMMENT;
            case 5:
                return XmlCursor.TokenType.PROCINST;
            default:
                throw new IllegalStateException();
        }
    }

    public boolean _isStartdoc() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isRoot();
        }
        throw new AssertionError();
    }

    public boolean _isEnddoc() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isEndRoot();
        }
        throw new AssertionError();
    }

    public boolean _isStart() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isElem();
        }
        throw new AssertionError();
    }

    public boolean _isEnd() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isEnd();
        }
        throw new AssertionError();
    }

    public boolean _isText() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isText();
        }
        throw new AssertionError();
    }

    public boolean _isAttr() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isNormalAttr();
        }
        throw new AssertionError();
    }

    public boolean _isNamespace() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isXmlns();
        }
        throw new AssertionError();
    }

    public boolean _isComment() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isComment();
        }
        throw new AssertionError();
    }

    public boolean _isProcinst() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isProcinst();
        }
        throw new AssertionError();
    }

    public boolean _isContainer() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isContainer();
        }
        throw new AssertionError();
    }

    public boolean _isFinish() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isFinish();
        }
        throw new AssertionError();
    }

    public boolean _isAnyAttr() {
        if ($assertionsDisabled || isValid()) {
            return this._cur.isAttr();
        }
        throw new AssertionError();
    }

    public XmlCursor.TokenType _toNextToken() {
        if (!$assertionsDisabled && !isValid()) {
            throw new AssertionError();
        }
        int kind = this._cur.kind();
        if (kind == 1 || kind == 2) {
            if (!this._cur.toFirstAttr()) {
                this._cur.next();
            }
        } else if (kind != 3) {
            if (kind == 4 || kind == 5) {
                this._cur.skip();
            } else if (!this._cur.next()) {
                return XmlCursor.TokenType.NONE;
            }
        } else if (!this._cur.toNextSibling()) {
            this._cur.toParent();
            this._cur.next();
        }
        return _currentTokenType();
    }

    public XmlCursor.TokenType _toPrevToken() {
        boolean z = $assertionsDisabled;
        if (!z && !isValid()) {
            throw new AssertionError();
        }
        boolean isText = this._cur.isText();
        if (!this._cur.prev()) {
            if (!z && !this._cur.isRoot() && !this._cur.isAttr()) {
                throw new AssertionError();
            }
            if (this._cur.isRoot()) {
                return XmlCursor.TokenType.NONE;
            }
            this._cur.toParent();
        } else {
            int kind = this._cur.kind();
            if (kind < 0 && (kind == -4 || kind == -5 || kind == -3)) {
                this._cur.toParent();
            } else if (this._cur.isContainer()) {
                this._cur.toLastAttr();
            } else if (isText && this._cur.isText()) {
                return _toPrevToken();
            }
        }
        return _currentTokenType();
    }

    public Object _monitor() {
        return this._cur._locale;
    }

    public boolean _toParent() {
        Cur tempCur = this._cur.tempCur();
        if (!tempCur.toParent()) {
            return false;
        }
        this._cur.moveToCur(tempCur);
        tempCur.release();
        return true;
    }

    private static final class ChangeStampImpl implements XmlCursor.ChangeStamp {
        private final Locale _locale;
        private final long _versionStamp;

        ChangeStampImpl(Locale locale) {
            this._locale = locale;
            this._versionStamp = locale.version();
        }

        @Override // org.apache.xmlbeans.XmlCursor.ChangeStamp
        public boolean hasChanged() {
            return this._versionStamp != this._locale.version();
        }
    }

    public XmlCursor.ChangeStamp _getDocChangeStamp() {
        return new ChangeStampImpl(this._cur._locale);
    }

    public XMLInputStream _newXMLInputStream() {
        return _newXMLInputStream(null);
    }

    public XMLStreamReader _newXMLStreamReader() {
        return _newXMLStreamReader(null);
    }

    public Node _newDomNode() {
        return _newDomNode(null);
    }

    public InputStream _newInputStream() {
        return _newInputStream(null);
    }

    public String _xmlText() {
        return _xmlText(null);
    }

    public Reader _newReader() {
        return _newReader(null);
    }

    public void _save(File file) throws IOException {
        _save(file, (XmlOptions) null);
    }

    public void _save(OutputStream outputStream) throws IOException {
        _save(outputStream, (XmlOptions) null);
    }

    public void _save(Writer writer) throws IOException {
        _save(writer, (XmlOptions) null);
    }

    public void _save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        _save(contentHandler, lexicalHandler, null);
    }

    public XmlDocumentProperties _documentProperties() {
        return Locale.getDocProps(this._cur, true);
    }

    public XMLStreamReader _newXMLStreamReader(XmlOptions xmlOptions) {
        return Jsr173.newXmlStreamReader(this._cur, xmlOptions);
    }

    public XMLInputStream _newXMLInputStream(XmlOptions xmlOptions) {
        return new Saver.XmlInputStreamImpl(this._cur, xmlOptions);
    }

    public String _xmlText(XmlOptions xmlOptions) {
        if ($assertionsDisabled || isValid()) {
            return new Saver.TextSaver(this._cur, xmlOptions, null).saveToString();
        }
        throw new AssertionError();
    }

    public InputStream _newInputStream(XmlOptions xmlOptions) {
        return new Saver.InputStreamSaver(this._cur, xmlOptions);
    }

    public Reader _newReader(XmlOptions xmlOptions) {
        return new Saver.TextReader(this._cur, xmlOptions);
    }

    public void _save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        new Saver.SaxSaver(this._cur, xmlOptions, contentHandler, lexicalHandler);
    }

    public void _save(File file, XmlOptions xmlOptions) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Null file specified");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            _save(fileOutputStream, xmlOptions);
        } finally {
            fileOutputStream.close();
        }
    }

    public void _save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null OutputStream specified");
        }
        InputStream _newInputStream = _newInputStream(xmlOptions);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = _newInputStream.read(bArr);
                if (read < 0) {
                    return;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
        } finally {
            _newInputStream.close();
        }
    }

    public void _save(Writer writer, XmlOptions xmlOptions) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("Null Writer specified");
        }
        if (xmlOptions != null && xmlOptions.hasOption(XmlOptions.SAVE_OPTIMIZE_FOR_SPEED)) {
            Saver.OptimizedForSpeedSaver.save(this._cur, writer);
            return;
        }
        Reader _newReader = _newReader(xmlOptions);
        try {
            char[] cArr = new char[8192];
            while (true) {
                int read = _newReader.read(cArr);
                if (read < 0) {
                    return;
                } else {
                    writer.write(cArr, 0, read);
                }
            }
        } finally {
            _newReader.close();
        }
    }

    public Node _getDomNode() {
        return (Node) this._cur.getDom();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
    
        r2.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return !r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isDomFragment() {
        /*
            r4 = this;
            boolean r0 = r4.isStartdoc()
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 0
            org.apache.xmlbeans.XmlCursor r2 = r4.newCursor()
            org.apache.xmlbeans.XmlCursor$TokenType r3 = r2.toNextToken()
            int r3 = r3.intValue()
        L15:
            switch(r3) {
                case 0: goto L5d;
                case 1: goto L4d;
                case 2: goto L5d;
                case 3: goto L3d;
                case 4: goto L34;
                case 5: goto L1d;
                case 6: goto L19;
                case 7: goto L19;
                case 8: goto L34;
                case 9: goto L34;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            r2.dispose()
            return r1
        L1d:
            java.lang.String r3 = r2.getChars()     // Catch: java.lang.Throwable -> L58
            boolean r3 = org.apache.xmlbeans.impl.store.Locale.isWhiteSpace(r3)     // Catch: java.lang.Throwable -> L58
            if (r3 != 0) goto L2b
            r2.dispose()
            return r1
        L2b:
            org.apache.xmlbeans.XmlCursor$TokenType r3 = r2.toNextToken()     // Catch: java.lang.Throwable -> L58
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L58
            goto L15
        L34:
            org.apache.xmlbeans.XmlCursor$TokenType r3 = r2.toNextToken()     // Catch: java.lang.Throwable -> L58
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L58
            goto L15
        L3d:
            if (r0 == 0) goto L43
            r2.dispose()
            return r1
        L43:
            org.apache.xmlbeans.XmlCursor$TokenType r0 = r2.toEndToken()     // Catch: java.lang.Throwable -> L58
            int r3 = r0.intValue()     // Catch: java.lang.Throwable -> L58
            r0 = r1
            goto L15
        L4d:
            boolean r3 = org.apache.xmlbeans.impl.store.Cursor.$assertionsDisabled     // Catch: java.lang.Throwable -> L58
            if (r3 == 0) goto L52
            goto L5d
        L52:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L58
            r0.<init>()     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        L58:
            r0 = move-exception
            r2.dispose()
            throw r0
        L5d:
            r2.dispose()
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Cursor.isDomFragment():boolean");
    }

    private static final class DomSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled;
        private boolean _isFrag;
        private Cur _nodeCur;
        private XmlOptions _options;
        private SchemaTypeLoader _stl;
        private SchemaType _type;

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(Saver.SaveCur saveCur) {
        }

        static {
            if (Cursor.class$org$apache$xmlbeans$impl$store$Cursor == null) {
                Cursor.class$org$apache$xmlbeans$impl$store$Cursor = Cursor.class$("org.apache.xmlbeans.impl.store.Cursor");
            } else {
                Class cls = Cursor.class$org$apache$xmlbeans$impl$store$Cursor;
            }
            $assertionsDisabled = true;
        }

        DomSaver(Cur cur, boolean z, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
            if (cur.isUserNode()) {
                this._type = cur.getUser().get_schema_type();
            }
            this._stl = cur._locale._schemaTypeLoader;
            this._options = xmlOptions;
            this._isFrag = z;
        }

        Node saveDom() {
            Locale locale = Locale.getLocale(this._stl, this._options);
            locale.enter();
            try {
                this._nodeCur = locale.getCur();
                while (process()) {
                }
                while (!this._nodeCur.isRoot()) {
                    this._nodeCur.toParent();
                }
                SchemaType schemaType = this._type;
                if (schemaType != null) {
                    this._nodeCur.setType(schemaType);
                }
                Node node = (Node) this._nodeCur.getDom();
                this._nodeCur.release();
                this._nodeCur = null;
                return node;
            } finally {
                locale.exit();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(Saver.SaveCur saveCur, ArrayList arrayList, ArrayList arrayList2) {
            if (Locale.isFragmentQName(saveCur.getName())) {
                this._nodeCur.moveTo(null, -2);
            }
            ensureDoc();
            this._nodeCur.createElement(getQualifiedName(saveCur, saveCur.getName()));
            this._nodeCur.next();
            iterateMappings();
            while (hasMapping()) {
                Cur cur = this._nodeCur;
                cur.createAttr(cur._locale.createXmlns(mappingPrefix()));
                this._nodeCur.next();
                this._nodeCur.insertString(mappingUri());
                this._nodeCur.toParent();
                this._nodeCur.skipWithAttrs();
                nextMapping();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                this._nodeCur.createAttr(getQualifiedName(saveCur, (QName) arrayList.get(i)));
                this._nodeCur.next();
                this._nodeCur.insertString((String) arrayList2.get(i));
                this._nodeCur.toParent();
                this._nodeCur.skipWithAttrs();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(Saver.SaveCur saveCur) {
            if (Locale.isFragmentQName(saveCur.getName())) {
                return;
            }
            if (!$assertionsDisabled && !this._nodeCur.isEnd()) {
                throw new AssertionError();
            }
            this._nodeCur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(Saver.SaveCur saveCur) {
            ensureDoc();
            Object chars = saveCur.getChars();
            if (saveCur._cchSrc > 0) {
                this._nodeCur.insertChars(chars, saveCur._offSrc, saveCur._cchSrc);
                this._nodeCur.next();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(Saver.SaveCur saveCur) {
            ensureDoc();
            this._nodeCur.createComment();
            emitTextValue(saveCur);
            this._nodeCur.skip();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(Saver.SaveCur saveCur) {
            ensureDoc();
            this._nodeCur.createProcinst(saveCur.getName().getLocalPart());
            emitTextValue(saveCur);
            this._nodeCur.skip();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            ensureDoc();
            XmlDocumentProperties docProps = Locale.getDocProps(this._nodeCur, true);
            docProps.setDoctypeName(str);
            docProps.setDoctypePublicId(str2);
            docProps.setDoctypeSystemId(str3);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(Saver.SaveCur saveCur) {
            ensureDoc();
        }

        private QName getQualifiedName(Saver.SaveCur saveCur, QName qName) {
            String namespaceURI = qName.getNamespaceURI();
            String uriMapping = namespaceURI.length() > 0 ? getUriMapping(namespaceURI) : "";
            return uriMapping.equals(qName.getPrefix()) ? qName : this._nodeCur._locale.makeQName(namespaceURI, qName.getLocalPart(), uriMapping);
        }

        private void emitTextValue(Saver.SaveCur saveCur) {
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                this._nodeCur.next();
                this._nodeCur.insertChars(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
                this._nodeCur.toParent();
            }
            saveCur.pop();
        }

        private void ensureDoc() {
            if (this._nodeCur.isPositioned()) {
                return;
            }
            if (this._isFrag) {
                this._nodeCur.createDomDocFragRoot();
            } else {
                this._nodeCur.createDomDocumentRoot();
            }
            this._nodeCur.next();
        }
    }

    public Node _newDomNode(XmlOptions xmlOptions) {
        if (XmlOptions.hasOption(xmlOptions, XmlOptions.SAVE_INNER)) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.remove(XmlOptions.SAVE_INNER);
            xmlOptions = xmlOptions2;
        }
        return new DomSaver(this._cur, isDomFragment(), xmlOptions).saveDom();
    }

    public boolean _toCursor(Cursor cursor) {
        if (!$assertionsDisabled && this._cur._locale != cursor._cur._locale) {
            throw new AssertionError();
        }
        this._cur.moveToCur(cursor._cur);
        return true;
    }

    public void _push() {
        this._cur.push();
    }

    public boolean _pop() {
        return this._cur.pop();
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void notifyChange() {
        if (this._cur != null) {
            _getSelectionCount();
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void setNextChangeListener(Locale.ChangeListener changeListener) {
        this._nextChangeListener = changeListener;
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public Locale.ChangeListener getNextChangeListener() {
        return this._nextChangeListener;
    }

    public void _selectPath(String str) {
        _selectPath(str, null);
    }

    public void _selectPath(String str, XmlOptions xmlOptions) {
        _clearSelections();
        if (!$assertionsDisabled && this._pathEngine != null) {
            throw new AssertionError();
        }
        this._pathEngine = Path.getCompiledPath(str, xmlOptions).execute(this._cur, xmlOptions);
        this._cur._locale.registerForChange(this);
    }

    public boolean _hasNextSelection() {
        int i = this._currentSelection;
        push();
        try {
            return _toNextSelection();
        } finally {
            this._currentSelection = i;
            pop();
        }
    }

    public boolean _toNextSelection() {
        return _toSelection(this._currentSelection + 1);
    }

    public boolean _toSelection(int i) {
        if (i < 0) {
            return false;
        }
        while (i >= this._cur.selectionCount()) {
            Path.PathEngine pathEngine = this._pathEngine;
            if (pathEngine == null) {
                return false;
            }
            if (!pathEngine.next(this._cur)) {
                this._pathEngine.release();
                this._pathEngine = null;
                return false;
            }
        }
        Cur cur = this._cur;
        this._currentSelection = i;
        cur.moveToSelection(i);
        return true;
    }

    public int _getSelectionCount() {
        _toSelection(Integer.MAX_VALUE);
        return this._cur.selectionCount();
    }

    public void _addToSelection() {
        _toSelection(Integer.MAX_VALUE);
        this._cur.addToSelection();
    }

    public void _clearSelections() {
        Path.PathEngine pathEngine = this._pathEngine;
        if (pathEngine != null) {
            pathEngine.release();
            this._pathEngine = null;
        }
        this._cur.clearSelection();
        this._currentSelection = -1;
    }

    public String _namespaceForPrefix(String str) {
        if (!this._cur.isContainer()) {
            throw new IllegalStateException("Not on a container");
        }
        return this._cur.namespaceForPrefix(str, true);
    }

    public String _prefixForNamespace(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must specify a namespace");
        }
        return this._cur.prefixForNamespace(str, null, true);
    }

    public void _getAllNamespaces(Map map) {
        if (!this._cur.isContainer()) {
            throw new IllegalStateException("Not on a container");
        }
        if (map != null) {
            Locale.getAllNamespaces(this._cur, map);
        }
    }

    public XmlObject _getObject() {
        return this._cur.getObject();
    }

    public XmlCursor.TokenType _prevTokenType() {
        this._cur.push();
        XmlCursor.TokenType _toPrevToken = _toPrevToken();
        this._cur.pop();
        return _toPrevToken;
    }

    public boolean _hasNextToken() {
        return (this._cur._pos == -1 && this._cur._xobj.kind() == 1) ? false : true;
    }

    public boolean _hasPrevToken() {
        return this._cur.kind() != 1;
    }

    public XmlCursor.TokenType _toFirstContentToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.next();
        return currentTokenType();
    }

    public XmlCursor.TokenType _toEndToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.toEnd();
        return currentTokenType();
    }

    public boolean _toChild(String str) {
        return _toChild((String) null, str);
    }

    public boolean _toChild(QName qName) {
        return _toChild(qName, 0);
    }

    public boolean _toChild(int i) {
        return _toChild((QName) null, i);
    }

    public boolean _toChild(String str, String str2) {
        validateLocalName(str2);
        return _toChild(this._cur._locale.makeQName(str, str2), 0);
    }

    public boolean _toChild(QName qName, int i) {
        return Locale.toChild(this._cur, qName, i);
    }

    public int _toNextChar(int i) {
        return this._cur.nextChars(i);
    }

    public int _toPrevChar(int i) {
        return this._cur.prevChars(i);
    }

    public boolean _toPrevSibling() {
        return Locale.toPrevSiblingElement(this._cur);
    }

    public boolean _toLastChild() {
        return Locale.toLastChildElement(this._cur);
    }

    public boolean _toFirstChild() {
        return Locale.toFirstChildElement(this._cur);
    }

    public boolean _toNextSibling(String str) {
        return _toNextSibling(new QName(str));
    }

    public boolean _toNextSibling(String str, String str2) {
        validateLocalName(str2);
        return _toNextSibling(this._cur._locale._qnameFactory.getQName(str, str2));
    }

    public boolean _toNextSibling(QName qName) {
        this._cur.push();
        while (___toNextSibling()) {
            if (this._cur.getName().equals(qName)) {
                this._cur.popButStay();
                return true;
            }
        }
        this._cur.pop();
        return false;
    }

    public boolean _toFirstAttribute() {
        return this._cur.isContainer() && Locale.toFirstNormalAttr(this._cur);
    }

    public boolean _toLastAttribute() {
        if (this._cur.isContainer()) {
            this._cur.push();
            this._cur.push();
            boolean z = false;
            while (this._cur.toNextAttr()) {
                if (this._cur.isNormalAttr()) {
                    this._cur.popButStay();
                    this._cur.push();
                    z = true;
                }
            }
            this._cur.pop();
            if (z) {
                this._cur.popButStay();
                return true;
            }
            this._cur.pop();
        }
        return false;
    }

    public boolean _toNextAttribute() {
        return this._cur.isAttr() && Locale.toNextNormalAttr(this._cur);
    }

    public boolean _toPrevAttribute() {
        return this._cur.isAttr() && Locale.toPrevNormalAttr(this._cur);
    }

    public String _getAttributeText(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.getAttrValue(qName);
        }
        return null;
    }

    public boolean _setAttributeText(QName qName, String str) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        validateLocalName(qName.getLocalPart());
        if (!this._cur.isContainer()) {
            return false;
        }
        this._cur.setAttrValue(qName, str);
        return true;
    }

    public boolean _removeAttribute(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.removeAttr(qName);
        }
        return false;
    }

    public String _getTextValue() {
        if (this._cur.isText()) {
            return _getChars();
        }
        if (this._cur.isNode()) {
            return this._cur.hasChildren() ? Locale.getTextValue(this._cur) : this._cur.getValueAsString();
        }
        throw new IllegalStateException("Can't get text value, current token can have no text value");
    }

    public int _getTextValue(char[] cArr, int i, int i2) {
        if (this._cur.isText()) {
            return _getChars(cArr, i, i2);
        }
        if (cArr == null) {
            throw new IllegalArgumentException("char buffer is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (i >= cArr.length) {
            throw new IllegalArgumentException("offset off end");
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        if (i + i2 > cArr.length) {
            i2 = cArr.length - i;
        }
        if (!this._cur.isNode()) {
            throw new IllegalStateException("Can't get text value, current token can have no text value");
        }
        if (this._cur.hasChildren()) {
            return Locale.getTextValue(this._cur, 1, cArr, i, i2);
        }
        Object firstChars = this._cur.getFirstChars();
        if (this._cur._cchSrc > i2) {
            this._cur._cchSrc = i2;
        }
        if (this._cur._cchSrc <= 0) {
            return 0;
        }
        CharUtil.getChars(cArr, i, firstChars, this._cur._offSrc, this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    private void setTextValue(Object obj, int i, int i2) {
        if (!this._cur.isNode()) {
            throw new IllegalStateException("Can't set text value, current token can have no text value");
        }
        this._cur.moveNodeContents(null, false);
        this._cur.next();
        this._cur.insertChars(obj, i, i2);
        this._cur.toParent();
    }

    public void _setTextValue(String str) {
        if (str == null) {
            str = "";
        }
        setTextValue(str, 0, str.length());
    }

    public void _setTextValue(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("setTextValue: length < 0");
        }
        if (cArr == null) {
            if (i2 > 0) {
                throw new IllegalArgumentException("setTextValue: sourceChars == null");
            }
            setTextValue((char[]) null, 0, 0);
        } else {
            if (i < 0 || i >= cArr.length) {
                throw new IndexOutOfBoundsException("setTextValue: offset out of bounds");
            }
            if (i + i2 > cArr.length) {
                i2 = cArr.length - i;
            }
            CharUtil charUtil = this._cur._locale.getCharUtil();
            setTextValue(charUtil.saveChars(cArr, i, i2), charUtil._offSrc, charUtil._cchSrc);
        }
    }

    public String _getChars() {
        return this._cur.getCharsAsString(-1);
    }

    public int _getChars(char[] cArr, int i, int i2) {
        int cchRight = this._cur.cchRight();
        if (i2 < 0 || i2 > cchRight) {
            i2 = cchRight;
        }
        if (cArr == null || i >= cArr.length) {
            return 0;
        }
        if (cArr.length - i < i2) {
            i2 = cArr.length - i;
        }
        CharUtil.getChars(cArr, i, this._cur.getChars(i2), this._cur._offSrc, this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public void _toStartDoc() {
        this._cur.toRoot();
    }

    public void _toEndDoc() {
        _toStartDoc();
        this._cur.toEnd();
    }

    public int _comparePosition(Cursor cursor) {
        int comparePosition = this._cur.comparePosition(cursor._cur);
        if (comparePosition == 2) {
            throw new IllegalArgumentException("Cursors not in same document");
        }
        if ($assertionsDisabled || (comparePosition >= -1 && comparePosition <= 1)) {
            return comparePosition;
        }
        throw new AssertionError();
    }

    public boolean _isLeftOf(Cursor cursor) {
        return _comparePosition(cursor) < 0;
    }

    public boolean _isAtSamePositionAs(Cursor cursor) {
        return this._cur.isSamePos(cursor._cur);
    }

    public boolean _isRightOf(Cursor cursor) {
        return _comparePosition(cursor) > 0;
    }

    public XmlCursor _execQuery(String str) {
        return _execQuery(str, null);
    }

    public XmlCursor _execQuery(String str, XmlOptions xmlOptions) {
        checkThisCursor();
        return Query.cursorExecQuery(this._cur, str, xmlOptions);
    }

    public boolean _toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        if (xmlBookmark != null && (xmlBookmark._currentMark instanceof Xobj.Bookmark)) {
            Xobj.Bookmark bookmark = (Xobj.Bookmark) xmlBookmark._currentMark;
            if (bookmark._xobj != null && bookmark._xobj._locale == this._cur._locale) {
                this._cur.moveTo(bookmark._xobj, bookmark._pos);
                return true;
            }
        }
        return false;
    }

    public XmlCursor.XmlBookmark _toNextBookmark(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int cchRight = this._cur.cchRight();
            if (cchRight > 1) {
                this._cur.nextChars(1);
                Cur cur = this._cur;
                int firstBookmarkInChars = cur.firstBookmarkInChars(obj, cchRight - 1);
                if (firstBookmarkInChars < 0) {
                    firstBookmarkInChars = -1;
                }
                cur.nextChars(firstBookmarkInChars);
            } else if (_toNextToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != -1);
        this._cur.pop();
        return null;
    }

    public XmlCursor.XmlBookmark _toPrevBookmark(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int cchLeft = this._cur.cchLeft();
            if (cchLeft > 1) {
                this._cur.prevChars(1);
                Cur cur = this._cur;
                int firstBookmarkInCharsLeft = cur.firstBookmarkInCharsLeft(obj, cchLeft - 1);
                if (firstBookmarkInCharsLeft < 0) {
                    firstBookmarkInCharsLeft = -1;
                }
                cur.prevChars(firstBookmarkInCharsLeft);
            } else if (cchLeft == 1) {
                this._cur.prevChars(1);
            } else if (_toPrevToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != 1);
        this._cur.pop();
        return null;
    }

    public void _setBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        if (xmlBookmark != null) {
            if (xmlBookmark.getKey() == null) {
                throw new IllegalArgumentException("Annotation key is null");
            }
            xmlBookmark._currentMark = this._cur.setBookmark(xmlBookmark.getKey(), xmlBookmark);
        }
    }

    static XmlCursor.XmlBookmark getBookmark(Object obj, Cur cur) {
        Object bookmark;
        if (obj == null || (bookmark = cur.getBookmark(obj)) == null || !(bookmark instanceof XmlCursor.XmlBookmark)) {
            return null;
        }
        return (XmlCursor.XmlBookmark) bookmark;
    }

    public XmlCursor.XmlBookmark _getBookmark(Object obj) {
        if (obj == null) {
            return null;
        }
        return getBookmark(obj, this._cur);
    }

    public void _clearBookmark(Object obj) {
        if (obj != null) {
            this._cur.setBookmark(obj, null);
        }
    }

    public void _getAllBookmarkRefs(Collection collection) {
        if (collection != null) {
            for (Xobj.Bookmark bookmark = this._cur._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (bookmark._value instanceof XmlCursor.XmlBookmark) {
                    collection.add(bookmark._value);
                }
            }
        }
    }

    public boolean _removeXml() {
        if (this._cur.isRoot()) {
            throw new IllegalStateException("Can't remove a whole document.");
        }
        if (this._cur.isFinish()) {
            return false;
        }
        if (!$assertionsDisabled && !this._cur.isText() && !this._cur.isNode()) {
            throw new AssertionError();
        }
        if (this._cur.isText()) {
            this._cur.moveChars(null, -1);
            return true;
        }
        this._cur.moveNode(null);
        return true;
    }

    public boolean _moveXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        if (this._cur.isText()) {
            int cchRight = this._cur.cchRight();
            if (!$assertionsDisabled && cchRight <= 0) {
                throw new AssertionError();
            }
            if (this._cur.inChars(cursor._cur, cchRight, true)) {
                return false;
            }
            this._cur.moveChars(cursor._cur, cchRight);
            cursor._cur.nextChars(cchRight);
            return true;
        }
        if (this._cur.contains(cursor._cur)) {
            return false;
        }
        Cur tempCur = cursor.tempCur();
        this._cur.moveNode(cursor._cur);
        cursor._cur.moveToCur(tempCur);
        tempCur.release();
        return true;
    }

    public boolean _copyXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        if (!$assertionsDisabled && !this._cur.isText() && !this._cur.isNode()) {
            throw new AssertionError();
        }
        Cur tempCur = cursor.tempCur();
        if (this._cur.isText()) {
            cursor._cur.insertChars(this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
        } else {
            this._cur.copyNode(cursor._cur);
        }
        cursor._cur.moveToCur(tempCur);
        tempCur.release();
        return true;
    }

    public boolean _removeXmlContents() {
        if (!this._cur.isContainer()) {
            return false;
        }
        this._cur.moveNodeContents(null, false);
        return true;
    }

    private boolean checkContentInsertionValidity(Cursor cursor) {
        this._cur.push();
        this._cur.next();
        if (this._cur.isFinish()) {
            this._cur.pop();
            return false;
        }
        try {
            cursor.checkInsertionValidity(this._cur);
            this._cur.pop();
            return true;
        } catch (IllegalArgumentException e) {
            this._cur.pop();
            throw e;
        }
    }

    public boolean _moveXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return false;
        }
        Cur tempCur = cursor.tempCur();
        this._cur.moveNodeContents(cursor._cur, false);
        cursor._cur.moveToCur(tempCur);
        tempCur.release();
        return true;
    }

    public boolean _copyXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return false;
        }
        Cur tempCur = this._cur._locale.tempCur();
        this._cur.copyNode(tempCur);
        Cur tempCur2 = cursor._cur.tempCur();
        tempCur.moveNodeContents(cursor._cur, false);
        tempCur.release();
        cursor._cur.moveToCur(tempCur2);
        tempCur2.release();
        return true;
    }

    public int _removeChars(int i) {
        int cchRight = this._cur.cchRight();
        if (cchRight == 0 || i == 0) {
            return 0;
        }
        if (i < 0 || i > cchRight) {
            i = cchRight;
        }
        this._cur.moveChars(null, i);
        return this._cur._cchSrc;
    }

    public int _moveChars(int i, Cursor cursor) {
        int cchRight = this._cur.cchRight();
        if (cchRight <= 0 || i == 0) {
            return 0;
        }
        if (i < 0 || i > cchRight) {
            i = cchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        this._cur.moveChars(cursor._cur, i);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public int _copyChars(int i, Cursor cursor) {
        int cchRight = this._cur.cchRight();
        if (cchRight <= 0 || i == 0) {
            return 0;
        }
        if (i < 0 || i > cchRight) {
            i = cchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        cursor._cur.insertChars(this._cur.getChars(i), this._cur._offSrc, this._cur._cchSrc);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public void _insertChars(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            if (this._cur.isRoot() || this._cur.isAttr()) {
                throw new IllegalStateException("Can't insert before the document or an attribute.");
            }
            this._cur.insertChars(str, 0, length);
            this._cur.nextChars(length);
        }
    }

    public void _beginElement(String str) {
        _insertElementWithText(str, null, null);
        _toPrevToken();
    }

    public void _beginElement(String str, String str2) {
        _insertElementWithText(str, str2, null);
        _toPrevToken();
    }

    public void _beginElement(QName qName) {
        _insertElementWithText(qName, (String) null);
        _toPrevToken();
    }

    public void _insertElement(String str) {
        _insertElementWithText(str, null, null);
    }

    public void _insertElement(String str, String str2) {
        _insertElementWithText(str, str2, null);
    }

    public void _insertElement(QName qName) {
        _insertElementWithText(qName, (String) null);
    }

    public void _insertElementWithText(String str, String str2) {
        _insertElementWithText(str, null, str2);
    }

    public void _insertElementWithText(String str, String str2, String str3) {
        validateLocalName(str);
        _insertElementWithText(this._cur._locale.makeQName(str2, str), str3);
    }

    public void _insertElementWithText(QName qName, String str) {
        validateLocalName(qName.getLocalPart());
        Cur tempCur = this._cur._locale.tempCur();
        tempCur.createElement(qName);
        insertNode(tempCur, str);
        tempCur.release();
    }

    public void _insertAttribute(String str) {
        _insertAttributeWithValue(str, (String) null);
    }

    public void _insertAttribute(String str, String str2) {
        _insertAttributeWithValue(str, str2, null);
    }

    public void _insertAttribute(QName qName) {
        _insertAttributeWithValue(qName, (String) null);
    }

    public void _insertAttributeWithValue(String str, String str2) {
        _insertAttributeWithValue(str, null, str2);
    }

    public void _insertAttributeWithValue(String str, String str2, String str3) {
        validateLocalName(str);
        _insertAttributeWithValue(this._cur._locale.makeQName(str2, str), str3);
    }

    public void _insertAttributeWithValue(QName qName, String str) {
        validateLocalName(qName.getLocalPart());
        Cur tempCur = this._cur._locale.tempCur();
        tempCur.createAttr(qName);
        insertNode(tempCur, str);
        tempCur.release();
    }

    public void _insertNamespace(String str, String str2) {
        _insertAttributeWithValue(this._cur._locale.createXmlns(str), str2);
    }

    public void _insertComment(String str) {
        Cur tempCur = this._cur._locale.tempCur();
        tempCur.createComment();
        insertNode(tempCur, str);
        tempCur.release();
    }

    public void _insertProcInst(String str, String str2) {
        validateLocalName(str);
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new IllegalArgumentException("Target is 'xml'");
        }
        Cur tempCur = this._cur._locale.tempCur();
        tempCur.createProcinst(str);
        insertNode(tempCur, str2);
        tempCur.release();
    }

    public void _dump() {
        this._cur.dump();
    }

    private void checkThisCursor() {
        if (this._cur == null) {
            throw new IllegalStateException("This cursor has been disposed");
        }
    }

    private Cursor checkCursors(XmlCursor xmlCursor) {
        checkThisCursor();
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Other cursor is <null>");
        }
        if (!(xmlCursor instanceof Cursor)) {
            throw new IllegalArgumentException(new StringBuffer().append("Incompatible cursors: ").append(xmlCursor).toString());
        }
        Cursor cursor = (Cursor) xmlCursor;
        if (cursor._cur != null) {
            return cursor;
        }
        throw new IllegalStateException("Other cursor has been disposed");
    }

    private int twoLocaleOp(XmlCursor xmlCursor, int i, int i2) {
        int twoLocaleOp;
        int twoLocaleOp2;
        int twoLocaleOp3;
        Cursor checkCursors = checkCursors(xmlCursor);
        Locale locale = this._cur._locale;
        Locale locale2 = checkCursors._cur._locale;
        if (locale == locale2) {
            if (locale.noSync()) {
                return twoLocaleOp(checkCursors, i, i2);
            }
            synchronized (locale) {
                twoLocaleOp3 = twoLocaleOp(checkCursors, i, i2);
            }
            return twoLocaleOp3;
        }
        if (locale.noSync()) {
            if (locale2.noSync()) {
                return twoLocaleOp(checkCursors, i, i2);
            }
            synchronized (locale2) {
                twoLocaleOp2 = twoLocaleOp(checkCursors, i, i2);
            }
            return twoLocaleOp2;
        }
        if (locale2.noSync()) {
            synchronized (locale) {
                twoLocaleOp = twoLocaleOp(checkCursors, i, i2);
            }
            return twoLocaleOp;
        }
        boolean z = false;
        try {
            try {
                GlobalLock.acquire();
                try {
                    try {
                        synchronized (locale) {
                            try {
                                try {
                                    synchronized (locale2) {
                                        try {
                                            GlobalLock.release();
                                            return twoLocaleOp(checkCursors, i, i2);
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new RuntimeException(e.getMessage(), e);
                    } catch (Throwable th4) {
                        th = th4;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private int twoLocaleOp(Cursor cursor, int i, int i2) {
        Locale locale = this._cur._locale;
        Locale locale2 = cursor._cur._locale;
        locale.enter(locale2);
        try {
            if (i == 0) {
                return _moveXml(cursor) ? 1 : 0;
            }
            if (i == 1) {
                return _copyXml(cursor) ? 1 : 0;
            }
            if (i == 2) {
                return _moveXmlContents(cursor) ? 1 : 0;
            }
            if (i == 3) {
                return _copyXmlContents(cursor) ? 1 : 0;
            }
            if (i == 4) {
                return _moveChars(i2, cursor);
            }
            if (i == 5) {
                return _copyChars(i2, cursor);
            }
            throw new RuntimeException(new StringBuffer().append("Unknown operation: ").append(i).toString());
        } finally {
            locale.exit(locale2);
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean moveXml(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 0, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXml(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 1, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean moveXmlContents(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 2, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXmlContents(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 3, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int moveChars(int i, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 4, i);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int copyChars(int i, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 5, i);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toCursor(XmlCursor xmlCursor) {
        boolean _toCursor;
        Cursor checkCursors = checkCursors(xmlCursor);
        if (this._cur._locale != checkCursors._cur._locale) {
            return false;
        }
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _toCursor(checkCursors);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toCursor = _toCursor(checkCursors);
            } finally {
            }
        }
        return _toCursor;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isInSameDocument(XmlCursor xmlCursor) {
        if (xmlCursor == null) {
            return false;
        }
        return this._cur.isInSameTree(checkCursors(xmlCursor)._cur);
    }

    private Cursor preCheck(XmlCursor xmlCursor) {
        Cursor checkCursors = checkCursors(xmlCursor);
        if (this._cur._locale == checkCursors._cur._locale) {
            return checkCursors;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int comparePosition(XmlCursor xmlCursor) {
        int _comparePosition;
        Cursor preCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _comparePosition(preCheck);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _comparePosition = _comparePosition(preCheck);
            } finally {
            }
        }
        return _comparePosition;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isLeftOf(XmlCursor xmlCursor) {
        boolean _isLeftOf;
        Cursor preCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _isLeftOf(preCheck);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _isLeftOf = _isLeftOf(preCheck);
            } finally {
            }
        }
        return _isLeftOf;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAtSamePositionAs(XmlCursor xmlCursor) {
        boolean _isAtSamePositionAs;
        Cursor preCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _isAtSamePositionAs(preCheck);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _isAtSamePositionAs = _isAtSamePositionAs(preCheck);
            } finally {
            }
        }
        return _isAtSamePositionAs;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isRightOf(XmlCursor xmlCursor) {
        boolean _isRightOf;
        Cursor preCheck = preCheck(xmlCursor);
        if (this._cur._locale.noSync()) {
            this._cur._locale.enter();
            try {
                return _isRightOf(preCheck);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _isRightOf = _isRightOf(preCheck);
            } finally {
            }
        }
        return _isRightOf;
    }

    public static XmlCursor newCursor(Xobj xobj, int i) {
        Cursor cursor;
        Locale locale = xobj._locale;
        if (locale.noSync()) {
            locale.enter();
            try {
                return new Cursor(xobj, i);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                cursor = new Cursor(xobj, i);
            } finally {
            }
        }
        return cursor;
    }

    private boolean preCheck() {
        checkThisCursor();
        return this._cur._locale.noSync();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void dispose() {
        Cur cur = this._cur;
        if (cur != null) {
            Locale locale = cur._locale;
            if (preCheck()) {
                locale.enter();
                try {
                    _dispose();
                } finally {
                }
            } else {
                synchronized (locale) {
                    locale.enter();
                    try {
                        _dispose();
                    } finally {
                    }
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Object monitor() {
        Object _monitor;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _monitor();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _monitor = _monitor();
            } finally {
            }
        }
        return _monitor;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        XmlDocumentProperties _documentProperties;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _documentProperties();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _documentProperties = _documentProperties();
            } finally {
            }
        }
        return _documentProperties;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        XmlCursor _newCursor;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newCursor();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newCursor = _newCursor();
            } finally {
            }
        }
        return _newCursor;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        XMLStreamReader _newXMLStreamReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLStreamReader();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newXMLStreamReader = _newXMLStreamReader();
            } finally {
            }
        }
        return _newXMLStreamReader;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        XMLStreamReader _newXMLStreamReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLStreamReader(xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newXMLStreamReader = _newXMLStreamReader(xmlOptions);
            } finally {
            }
        }
        return _newXMLStreamReader;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream() {
        XMLInputStream _newXMLInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLInputStream();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newXMLInputStream = _newXMLInputStream();
            } finally {
            }
        }
        return _newXMLInputStream;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        String _xmlText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _xmlText();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _xmlText = _xmlText();
            } finally {
            }
        }
        return _xmlText;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        InputStream _newInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newInputStream();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newInputStream = _newInputStream();
            } finally {
            }
        }
        return _newInputStream;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        Reader _newReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newReader();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newReader = _newReader();
            } finally {
            }
        }
        return _newReader;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        Node _newDomNode;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newDomNode();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newDomNode = _newDomNode();
            } finally {
            }
        }
        return _newDomNode;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        Node _getDomNode;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getDomNode();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getDomNode = _getDomNode();
            } finally {
            }
        }
        return _getDomNode;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(contentHandler, lexicalHandler);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(contentHandler, lexicalHandler);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(file);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(file);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(outputStream);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(outputStream);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(writer);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(writer);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream(XmlOptions xmlOptions) {
        XMLInputStream _newXMLInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newXMLInputStream(xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newXMLInputStream = _newXMLInputStream(xmlOptions);
            } finally {
            }
        }
        return _newXMLInputStream;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        String _xmlText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _xmlText(xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _xmlText = _xmlText(xmlOptions);
            } finally {
            }
        }
        return _xmlText;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        InputStream _newInputStream;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newInputStream(xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newInputStream = _newInputStream(xmlOptions);
            } finally {
            }
        }
        return _newInputStream;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        Reader _newReader;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newReader(xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newReader = _newReader(xmlOptions);
            } finally {
            }
        }
        return _newReader;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        Node _newDomNode;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _newDomNode(xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _newDomNode = _newDomNode(xmlOptions);
            } finally {
            }
        }
        return _newDomNode;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(contentHandler, lexicalHandler, xmlOptions);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(contentHandler, lexicalHandler, xmlOptions);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(file, xmlOptions);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(file, xmlOptions);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(outputStream, xmlOptions);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(outputStream, xmlOptions);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) throws IOException {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _save(writer, xmlOptions);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _save(writer, xmlOptions);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void push() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _push();
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _push();
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean pop() {
        boolean _pop;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _pop();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _pop = _pop();
            } finally {
            }
        }
        return _pop;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _selectPath(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _selectPath(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(String str, XmlOptions xmlOptions) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _selectPath(str, xmlOptions);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _selectPath(str, xmlOptions);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextSelection() {
        boolean _hasNextSelection;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _hasNextSelection();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _hasNextSelection = _hasNextSelection();
            } finally {
            }
        }
        return _hasNextSelection;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSelection() {
        boolean _toNextSelection;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSelection();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextSelection = _toNextSelection();
            } finally {
            }
        }
        return _toNextSelection;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toSelection(int i) {
        boolean _toSelection;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toSelection(i);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toSelection = _toSelection(i);
            } finally {
            }
        }
        return _toSelection;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getSelectionCount() {
        int _getSelectionCount;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getSelectionCount();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getSelectionCount = _getSelectionCount();
            } finally {
            }
        }
        return _getSelectionCount;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void addToSelection() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _addToSelection();
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _addToSelection();
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void clearSelections() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _clearSelections();
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _clearSelections();
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        boolean _toBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toBookmark(xmlBookmark);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toBookmark = _toBookmark(xmlBookmark);
            } finally {
            }
        }
        return _toBookmark;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toNextBookmark(Object obj) {
        XmlCursor.XmlBookmark _toNextBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextBookmark(obj);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextBookmark = _toNextBookmark(obj);
            } finally {
            }
        }
        return _toNextBookmark;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toPrevBookmark(Object obj) {
        XmlCursor.XmlBookmark _toPrevBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevBookmark(obj);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toPrevBookmark = _toPrevBookmark(obj);
            } finally {
            }
        }
        return _toPrevBookmark;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public QName getName() {
        QName _getName;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getName();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getName = _getName();
            } finally {
            }
        }
        return _getName;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setName(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setName(qName);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _setName(qName);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String namespaceForPrefix(String str) {
        String _namespaceForPrefix;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _namespaceForPrefix(str);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _namespaceForPrefix = _namespaceForPrefix(str);
            } finally {
            }
        }
        return _namespaceForPrefix;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String prefixForNamespace(String str) {
        String _prefixForNamespace;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _prefixForNamespace(str);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _prefixForNamespace = _prefixForNamespace(str);
            } finally {
            }
        }
        return _prefixForNamespace;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void getAllNamespaces(Map map) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _getAllNamespaces(map);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _getAllNamespaces(map);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlObject getObject() {
        XmlObject _getObject;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getObject();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getObject = _getObject();
            } finally {
            }
        }
        return _getObject;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType currentTokenType() {
        XmlCursor.TokenType _currentTokenType;
        if (preCheck()) {
            return _currentTokenType();
        }
        synchronized (this._cur._locale) {
            _currentTokenType = _currentTokenType();
        }
        return _currentTokenType;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStartdoc() {
        boolean _isStartdoc;
        if (preCheck()) {
            return _isStartdoc();
        }
        synchronized (this._cur._locale) {
            _isStartdoc = _isStartdoc();
        }
        return _isStartdoc;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnddoc() {
        boolean _isEnddoc;
        if (preCheck()) {
            return _isEnddoc();
        }
        synchronized (this._cur._locale) {
            _isEnddoc = _isEnddoc();
        }
        return _isEnddoc;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStart() {
        boolean _isStart;
        if (preCheck()) {
            return _isStart();
        }
        synchronized (this._cur._locale) {
            _isStart = _isStart();
        }
        return _isStart;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnd() {
        boolean _isEnd;
        if (preCheck()) {
            return _isEnd();
        }
        synchronized (this._cur._locale) {
            _isEnd = _isEnd();
        }
        return _isEnd;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isText() {
        boolean _isText;
        if (preCheck()) {
            return _isText();
        }
        synchronized (this._cur._locale) {
            _isText = _isText();
        }
        return _isText;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAttr() {
        boolean _isAttr;
        if (preCheck()) {
            return _isAttr();
        }
        synchronized (this._cur._locale) {
            _isAttr = _isAttr();
        }
        return _isAttr;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isNamespace() {
        boolean _isNamespace;
        if (preCheck()) {
            return _isNamespace();
        }
        synchronized (this._cur._locale) {
            _isNamespace = _isNamespace();
        }
        return _isNamespace;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isComment() {
        boolean _isComment;
        if (preCheck()) {
            return _isComment();
        }
        synchronized (this._cur._locale) {
            _isComment = _isComment();
        }
        return _isComment;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isProcinst() {
        boolean _isProcinst;
        if (preCheck()) {
            return _isProcinst();
        }
        synchronized (this._cur._locale) {
            _isProcinst = _isProcinst();
        }
        return _isProcinst;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isContainer() {
        boolean _isContainer;
        if (preCheck()) {
            return _isContainer();
        }
        synchronized (this._cur._locale) {
            _isContainer = _isContainer();
        }
        return _isContainer;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isFinish() {
        boolean _isFinish;
        if (preCheck()) {
            return _isFinish();
        }
        synchronized (this._cur._locale) {
            _isFinish = _isFinish();
        }
        return _isFinish;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAnyAttr() {
        boolean _isAnyAttr;
        if (preCheck()) {
            return _isAnyAttr();
        }
        synchronized (this._cur._locale) {
            _isAnyAttr = _isAnyAttr();
        }
        return _isAnyAttr;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType prevTokenType() {
        XmlCursor.TokenType _prevTokenType;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _prevTokenType();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _prevTokenType = _prevTokenType();
            } finally {
            }
        }
        return _prevTokenType;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextToken() {
        boolean _hasNextToken;
        if (preCheck()) {
            return _hasNextToken();
        }
        synchronized (this._cur._locale) {
            _hasNextToken = _hasNextToken();
        }
        return _hasNextToken;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasPrevToken() {
        boolean _hasPrevToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _hasPrevToken();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _hasPrevToken = _hasPrevToken();
            } finally {
            }
        }
        return _hasPrevToken;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toNextToken() {
        XmlCursor.TokenType _toNextToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextToken();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextToken = _toNextToken();
            } finally {
            }
        }
        return _toNextToken;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toPrevToken() {
        XmlCursor.TokenType _toPrevToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevToken();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toPrevToken = _toPrevToken();
            } finally {
            }
        }
        return _toPrevToken;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toFirstContentToken() {
        XmlCursor.TokenType _toFirstContentToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toFirstContentToken();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toFirstContentToken = _toFirstContentToken();
            } finally {
            }
        }
        return _toFirstContentToken;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toEndToken() {
        XmlCursor.TokenType _toEndToken;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toEndToken();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toEndToken = _toEndToken();
            } finally {
            }
        }
        return _toEndToken;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int toNextChar(int i) {
        int _toNextChar;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextChar(i);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextChar = _toNextChar(i);
            } finally {
            }
        }
        return _toNextChar;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int toPrevChar(int i) {
        int _toPrevChar;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevChar(i);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toPrevChar = _toPrevChar(i);
            } finally {
            }
        }
        return _toPrevChar;
    }

    public boolean ___toNextSibling() {
        if (!this._cur.hasParent()) {
            return false;
        }
        Xobj parentNoRoot = this._cur.getParentNoRoot();
        if (parentNoRoot == null) {
            this._cur._locale.enter();
            try {
                parentNoRoot = this._cur.getParent();
            } finally {
                this._cur._locale.exit();
            }
        }
        return Locale.toNextSiblingElement(this._cur, parentNoRoot);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling() {
        boolean ___toNextSibling;
        if (preCheck()) {
            return ___toNextSibling();
        }
        synchronized (this._cur._locale) {
            ___toNextSibling = ___toNextSibling();
        }
        return ___toNextSibling;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toPrevSibling() {
        boolean _toPrevSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevSibling();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toPrevSibling = _toPrevSibling();
            } finally {
            }
        }
        return _toPrevSibling;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toParent() {
        boolean _toParent;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toParent();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toParent = _toParent();
            } finally {
            }
        }
        return _toParent;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstChild() {
        boolean _toFirstChild;
        if (preCheck()) {
            return _toFirstChild();
        }
        synchronized (this._cur._locale) {
            _toFirstChild = _toFirstChild();
        }
        return _toFirstChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toLastChild() {
        boolean _toLastChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toLastChild();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toLastChild = _toLastChild();
            } finally {
            }
        }
        return _toLastChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(String str) {
        boolean _toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(str);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toChild = _toChild(str);
            } finally {
            }
        }
        return _toChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(String str, String str2) {
        boolean _toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(str, str2);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toChild = _toChild(str, str2);
            } finally {
            }
        }
        return _toChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(QName qName) {
        boolean _toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(qName);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toChild = _toChild(qName);
            } finally {
            }
        }
        return _toChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(int i) {
        boolean _toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(i);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toChild = _toChild(i);
            } finally {
            }
        }
        return _toChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(QName qName, int i) {
        boolean _toChild;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toChild(qName, i);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toChild = _toChild(qName, i);
            } finally {
            }
        }
        return _toChild;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(String str) {
        boolean _toNextSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSibling(str);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextSibling = _toNextSibling(str);
            } finally {
            }
        }
        return _toNextSibling;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(String str, String str2) {
        boolean _toNextSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSibling(str, str2);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextSibling = _toNextSibling(str, str2);
            } finally {
            }
        }
        return _toNextSibling;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(QName qName) {
        boolean _toNextSibling;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextSibling(qName);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextSibling = _toNextSibling(qName);
            } finally {
            }
        }
        return _toNextSibling;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstAttribute() {
        boolean _toFirstAttribute;
        if (preCheck()) {
            return _toFirstAttribute();
        }
        synchronized (this._cur._locale) {
            _toFirstAttribute = _toFirstAttribute();
        }
        return _toFirstAttribute;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toLastAttribute() {
        boolean _toLastAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toLastAttribute();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toLastAttribute = _toLastAttribute();
            } finally {
            }
        }
        return _toLastAttribute;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextAttribute() {
        boolean _toNextAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toNextAttribute();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toNextAttribute = _toNextAttribute();
            } finally {
            }
        }
        return _toNextAttribute;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toPrevAttribute() {
        boolean _toPrevAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _toPrevAttribute();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _toPrevAttribute = _toPrevAttribute();
            } finally {
            }
        }
        return _toPrevAttribute;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getAttributeText(QName qName) {
        String _getAttributeText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getAttributeText(qName);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getAttributeText = _getAttributeText(qName);
            } finally {
            }
        }
        return _getAttributeText;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean setAttributeText(QName qName, String str) {
        boolean _setAttributeText;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _setAttributeText(qName, str);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _setAttributeText = _setAttributeText(qName, str);
            } finally {
            }
        }
        return _setAttributeText;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeAttribute(QName qName) {
        boolean _removeAttribute;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeAttribute(qName);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _removeAttribute = _removeAttribute(qName);
            } finally {
            }
        }
        return _removeAttribute;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getTextValue() {
        String _getTextValue;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getTextValue();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getTextValue = _getTextValue();
            } finally {
            }
        }
        return _getTextValue;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getTextValue(char[] cArr, int i, int i2) {
        int _getTextValue;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getTextValue(cArr, i, i2);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getTextValue = _getTextValue(cArr, i, i2);
            } finally {
            }
        }
        return _getTextValue;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setTextValue(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setTextValue(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _setTextValue(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setTextValue(char[] cArr, int i, int i2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setTextValue(cArr, i, i2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _setTextValue(cArr, i, i2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getChars() {
        String _getChars;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getChars();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getChars = _getChars();
            } finally {
            }
        }
        return _getChars;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getChars(char[] cArr, int i, int i2) {
        int _getChars;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getChars(cArr, i, i2);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getChars = _getChars(cArr, i, i2);
            } finally {
            }
        }
        return _getChars;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toStartDoc() {
        if (preCheck()) {
            _toStartDoc();
            return;
        }
        synchronized (this._cur._locale) {
            _toStartDoc();
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toEndDoc() {
        if (preCheck()) {
            _toEndDoc();
            return;
        }
        synchronized (this._cur._locale) {
            _toEndDoc();
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor execQuery(String str) {
        XmlCursor _execQuery;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _execQuery(str);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _execQuery = _execQuery(str);
            } finally {
            }
        }
        return _execQuery;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor execQuery(String str, XmlOptions xmlOptions) {
        XmlCursor _execQuery;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _execQuery(str, xmlOptions);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _execQuery = _execQuery(str, xmlOptions);
            } finally {
            }
        }
        return _execQuery;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.ChangeStamp getDocChangeStamp() {
        XmlCursor.ChangeStamp _getDocChangeStamp;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getDocChangeStamp();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getDocChangeStamp = _getDocChangeStamp();
            } finally {
            }
        }
        return _getDocChangeStamp;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _setBookmark(xmlBookmark);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _setBookmark(xmlBookmark);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark getBookmark(Object obj) {
        XmlCursor.XmlBookmark _getBookmark;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _getBookmark(obj);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _getBookmark = _getBookmark(obj);
            } finally {
            }
        }
        return _getBookmark;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void clearBookmark(Object obj) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _clearBookmark(obj);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _clearBookmark(obj);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void getAllBookmarkRefs(Collection collection) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _getAllBookmarkRefs(collection);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _getAllBookmarkRefs(collection);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeXml() {
        boolean _removeXml;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeXml();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _removeXml = _removeXml();
            } finally {
            }
        }
        return _removeXml;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeXmlContents() {
        boolean _removeXmlContents;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeXmlContents();
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _removeXmlContents = _removeXmlContents();
            } finally {
            }
        }
        return _removeXmlContents;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int removeChars(int i) {
        int _removeChars;
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                return _removeChars(i);
            } finally {
            }
        }
        synchronized (this._cur._locale) {
            this._cur._locale.enter();
            try {
                _removeChars = _removeChars(i);
            } finally {
            }
        }
        return _removeChars;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertChars(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertChars(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertChars(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElement(qName);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertElement(qName);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElement(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertElement(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElement(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertElement(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _beginElement(qName);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _beginElement(qName);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _beginElement(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _beginElement(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _beginElement(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _beginElement(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(QName qName, String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(qName, str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertElementWithText(qName, str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertElementWithText(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(String str, String str2, String str3) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertElementWithText(str, str2, str3);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertElementWithText(str, str2, str3);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttribute(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertAttribute(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttribute(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertAttribute(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(QName qName) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttribute(qName);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertAttribute(qName);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertAttributeWithValue(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(String str, String str2, String str3) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(str, str2, str3);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertAttributeWithValue(str, str2, str3);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(QName qName, String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertAttributeWithValue(qName, str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertAttributeWithValue(qName, str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertNamespace(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertNamespace(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertNamespace(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertComment(String str) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertComment(str);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertComment(str);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertProcInst(String str, String str2) {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _insertProcInst(str, str2);
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _insertProcInst(str, str2);
                } finally {
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        if (preCheck()) {
            this._cur._locale.enter();
            try {
                _dump();
            } finally {
            }
        } else {
            synchronized (this._cur._locale) {
                this._cur._locale.enter();
                try {
                    _dump();
                } finally {
                }
            }
        }
    }
}
