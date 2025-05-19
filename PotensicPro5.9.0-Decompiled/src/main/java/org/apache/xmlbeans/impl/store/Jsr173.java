package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class Jsr173 {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlLineNumber;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Jsr173;

    static {
        if (class$org$apache$xmlbeans$impl$store$Jsr173 == null) {
            class$org$apache$xmlbeans$impl$store$Jsr173 = class$("org.apache.xmlbeans.impl.store.Jsr173");
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

    /* JADX WARN: Multi-variable type inference failed */
    public static Node nodeFromStream(XMLStreamReader xMLStreamReader) {
        Node nodeFromStreamImpl;
        if (!(xMLStreamReader instanceof Jsr173GateWay)) {
            return null;
        }
        Jsr173GateWay jsr173GateWay = (Jsr173GateWay) xMLStreamReader;
        Locale locale = jsr173GateWay._l;
        if (locale.noSync()) {
            locale.enter();
            try {
                return nodeFromStreamImpl(jsr173GateWay);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nodeFromStreamImpl = nodeFromStreamImpl(jsr173GateWay);
            } finally {
            }
        }
        return nodeFromStreamImpl;
    }

    public static Node nodeFromStreamImpl(Jsr173GateWay jsr173GateWay) {
        Cur streamCur = jsr173GateWay._xs.getStreamCur();
        return (Node) (streamCur.isNode() ? streamCur.getDom() : null);
    }

    public static XMLStreamReader newXmlStreamReader(Cur cur, Object obj, int i, int i2) {
        XMLStreamReaderForString xMLStreamReaderForString = new XMLStreamReaderForString(cur, obj, i, i2);
        if (cur._locale.noSync()) {
            return new UnsyncedJsr173(cur._locale, xMLStreamReaderForString);
        }
        return new SyncedJsr173(cur._locale, xMLStreamReaderForString);
    }

    public static XMLStreamReader newXmlStreamReader(Cur cur, XmlOptions xmlOptions) {
        XMLStreamReaderBase xMLStreamReaderForString;
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        boolean z = maskNull.hasOption(XmlOptions.SAVE_INNER) && !maskNull.hasOption(XmlOptions.SAVE_OUTER);
        int kind = cur.kind();
        if (kind == 0 || kind < 0) {
            xMLStreamReaderForString = new XMLStreamReaderForString(cur, cur.getChars(-1), cur._offSrc, cur._cchSrc);
        } else if (z) {
            if (!cur.hasAttrs() && !cur.hasChildren()) {
                xMLStreamReaderForString = new XMLStreamReaderForString(cur, cur.getFirstChars(), cur._offSrc, cur._cchSrc);
            } else {
                if (!$assertionsDisabled && !cur.isContainer()) {
                    throw new AssertionError();
                }
                xMLStreamReaderForString = new XMLStreamReaderForNode(cur, true);
            }
        } else {
            xMLStreamReaderForString = new XMLStreamReaderForNode(cur, false);
        }
        if (cur._locale.noSync()) {
            return new UnsyncedJsr173(cur._locale, xMLStreamReaderForString);
        }
        return new SyncedJsr173(cur._locale, xMLStreamReaderForString);
    }

    private static final class XMLStreamReaderForNode extends XMLStreamReaderBase {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int _cchChars;
        private int _cchSrc;
        private char[] _chars;
        private Cur _cur;
        private boolean _done;
        private Cur _end;
        private int _offChars;
        private int _offSrc;
        private Object _src;
        private boolean _srcFetched;
        private boolean _textFetched;
        private boolean _wholeDoc;

        static {
            if (Jsr173.class$org$apache$xmlbeans$impl$store$Jsr173 == null) {
                Jsr173.class$org$apache$xmlbeans$impl$store$Jsr173 = Jsr173.class$("org.apache.xmlbeans.impl.store.Jsr173");
            } else {
                Class cls = Jsr173.class$org$apache$xmlbeans$impl$store$Jsr173;
            }
            $assertionsDisabled = true;
        }

        public XMLStreamReaderForNode(Cur cur, boolean z) {
            super(cur);
            boolean z2 = $assertionsDisabled;
            if (!z2 && !cur.isContainer() && !cur.isComment() && !cur.isProcinst() && !cur.isAttr()) {
                throw new AssertionError();
            }
            if (z) {
                if (!z2 && !cur.isContainer()) {
                    throw new AssertionError();
                }
                Cur weakCur = cur.weakCur(this);
                this._cur = weakCur;
                if (!weakCur.toFirstAttr()) {
                    this._cur.next();
                }
                Cur weakCur2 = cur.weakCur(this);
                this._end = weakCur2;
                weakCur2.toEnd();
            } else {
                this._cur = cur.weakCur(this);
                if (cur.isRoot()) {
                    this._wholeDoc = true;
                } else {
                    this._end = cur.weakCur(this);
                    if (cur.isAttr()) {
                        if (!this._end.toNextAttr()) {
                            this._end.toParent();
                            this._end.next();
                        }
                    } else {
                        this._end.skip();
                    }
                }
            }
            if (!this._wholeDoc) {
                this._cur.push();
                try {
                    next();
                    this._cur.pop();
                } catch (XMLStreamException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
            if (!z2 && !this._wholeDoc && this._cur.isSamePos(this._end)) {
                throw new AssertionError();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        protected Cur getStreamCur() {
            return this._cur;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasNext() throws XMLStreamException {
            checkChanged();
            return !this._done;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getEventType() {
            switch (this._cur.kind()) {
                case -2:
                    return 2;
                case -1:
                    return 8;
                case 0:
                    return 4;
                case 1:
                    return 7;
                case 2:
                    return 1;
                case 3:
                    return this._cur.isXmlns() ? 13 : 10;
                case 4:
                    return 5;
                case 5:
                    return 3;
                default:
                    throw new IllegalStateException();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            checkChanged();
            if (!hasNext()) {
                throw new IllegalStateException("No next event in stream");
            }
            int kind = this._cur.kind();
            boolean z = true;
            if (kind == -1) {
                if (!$assertionsDisabled && !this._wholeDoc) {
                    throw new AssertionError();
                }
                this._done = true;
            } else {
                if (kind == 3) {
                    if (!this._cur.toNextAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                } else if (kind == 4 || kind == 5) {
                    this._cur.skip();
                } else if (kind == 1) {
                    if (!this._cur.toFirstAttr()) {
                        this._cur.next();
                    }
                } else {
                    this._cur.next();
                }
                if (!$assertionsDisabled && !this._wholeDoc && this._end == null) {
                    throw new AssertionError();
                }
                if (!this._wholeDoc) {
                    z = this._cur.isSamePos(this._end);
                } else if (this._cur.kind() != -1) {
                    z = false;
                }
                this._done = z;
            }
            this._textFetched = false;
            this._srcFetched = false;
            return getEventType();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getText() {
            checkChanged();
            int kind = this._cur.kind();
            if (kind == 4) {
                return this._cur.getValueAsString();
            }
            if (kind == 0) {
                return this._cur.getCharsAsString(-1);
            }
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            return getEventType() == 1;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            return getEventType() == 2;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            return getEventType() == 4;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getElementText() throws XMLStreamException {
            checkChanged();
            if (!isStartElement()) {
                throw new IllegalStateException();
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (hasNext()) {
                int next = next();
                if (next == 2) {
                    return stringBuffer.toString();
                }
                if (next == 1) {
                    throw new XMLStreamException();
                }
                if (next != 5 && next != 3) {
                    stringBuffer.append(getText());
                }
            }
            throw new XMLStreamException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int nextTag() throws XMLStreamException {
            checkChanged();
            while (!isStartElement() && !isEndElement()) {
                if (!isWhiteSpace()) {
                    throw new XMLStreamException();
                }
                if (!hasNext()) {
                    throw new XMLStreamException();
                }
                next();
            }
            return getEventType();
        }

        private static boolean matchAttr(Cur cur, String str, String str2) {
            if (!$assertionsDisabled && !cur.isNormalAttr()) {
                throw new AssertionError();
            }
            QName name = cur.getName();
            return name.getLocalPart().equals(str2) && (str == null || name.getNamespaceURI().equals(str));
        }

        private static Cur toAttr(Cur cur, String str, String str2) {
            if (str == null || str2 == null || str2.length() == 0) {
                throw new IllegalArgumentException();
            }
            Cur tempCur = cur.tempCur();
            boolean z = false;
            if (cur.isElem()) {
                if (tempCur.toFirstAttr()) {
                    while (true) {
                        if (tempCur.isNormalAttr() && matchAttr(tempCur, str, str2)) {
                            z = true;
                            break;
                        }
                        if (!tempCur.toNextSibling()) {
                            break;
                        }
                    }
                }
            } else if (cur.isNormalAttr()) {
                z = matchAttr(cur, str, str2);
            } else {
                throw new IllegalStateException();
            }
            if (z) {
                return tempCur;
            }
            tempCur.release();
            return null;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            Cur attr = toAttr(this._cur, str, str2);
            if (attr == null) {
                return null;
            }
            String valueAsString = attr.getValueAsString();
            attr.release();
            return valueAsString;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:
        
            if (r5 == 0) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static org.apache.xmlbeans.impl.store.Cur toAttr(org.apache.xmlbeans.impl.store.Cur r4, int r5) {
            /*
                if (r5 < 0) goto L44
                org.apache.xmlbeans.impl.store.Cur r0 = r4.tempCur()
                boolean r1 = r4.isElem()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L28
                boolean r4 = r0.toFirstAttr()
                if (r4 == 0) goto L26
            L14:
                boolean r4 = r0.isNormalAttr()
                if (r4 == 0) goto L20
                int r4 = r5 + (-1)
                if (r5 != 0) goto L1f
                goto L30
            L1f:
                r5 = r4
            L20:
                boolean r4 = r0.toNextSibling()
                if (r4 != 0) goto L14
            L26:
                r2 = r3
                goto L30
            L28:
                boolean r4 = r4.isNormalAttr()
                if (r4 == 0) goto L3e
                if (r5 != 0) goto L26
            L30:
                if (r2 == 0) goto L33
                return r0
            L33:
                r0.release()
                java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException
                java.lang.String r5 = "Attribute index is too large"
                r4.<init>(r5)
                throw r4
            L3e:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                r4.<init>()
                throw r4
            L44:
                java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException
                java.lang.String r5 = "Attribute index is negative"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderForNode.toAttr(org.apache.xmlbeans.impl.store.Cur, int):org.apache.xmlbeans.impl.store.Cur");
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            if (this._cur.isElem()) {
                Cur tempCur = this._cur.tempCur();
                int i = 0;
                if (tempCur.toFirstAttr()) {
                    do {
                        if (tempCur.isNormalAttr()) {
                            i++;
                        }
                    } while (tempCur.toNextSibling());
                }
                tempCur.release();
                return i;
            }
            if (this._cur.isNormalAttr()) {
                return 1;
            }
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i) {
            Cur attr = toAttr(this._cur, i);
            QName name = attr.getName();
            attr.release();
            return name;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i) {
            return getAttributeName(i).getNamespaceURI();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i) {
            return getAttributeName(i).getLocalPart();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i) {
            return getAttributeName(i).getPrefix();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeType(int i) {
            toAttr(this._cur, i).release();
            return "CDATA";
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i) {
            Cur attr = toAttr(this._cur, i);
            if (attr == null) {
                return null;
            }
            String valueAsString = attr.getValueAsString();
            attr.release();
            return valueAsString;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i) {
            toAttr(this._cur, i).release();
            return false;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            if (this._cur.isElem() || this._cur.kind() == -2) {
                Cur tempCur = this._cur.tempCur();
                if (this._cur.kind() == -2) {
                    tempCur.toParent();
                }
                int i = 0;
                if (tempCur.toFirstAttr()) {
                    do {
                        if (tempCur.isXmlns()) {
                            i++;
                        }
                    } while (tempCur.toNextSibling());
                }
                tempCur.release();
                return i;
            }
            if (this._cur.isXmlns()) {
                return 1;
            }
            throw new IllegalStateException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        
            if (r6 == 0) goto L28;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static org.apache.xmlbeans.impl.store.Cur toXmlns(org.apache.xmlbeans.impl.store.Cur r5, int r6) {
            /*
                if (r6 < 0) goto L55
                org.apache.xmlbeans.impl.store.Cur r0 = r5.tempCur()
                boolean r1 = r5.isElem()
                r2 = 1
                r3 = -2
                r4 = 0
                if (r1 != 0) goto L25
                int r1 = r5.kind()
                if (r1 != r3) goto L16
                goto L25
            L16:
                boolean r5 = r5.isXmlns()
                if (r5 == 0) goto L1f
                if (r6 != 0) goto L46
                goto L47
            L1f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r5.<init>()
                throw r5
            L25:
                int r5 = r5.kind()
                if (r5 != r3) goto L2e
                r0.toParent()
            L2e:
                boolean r5 = r0.toFirstAttr()
                if (r5 == 0) goto L46
            L34:
                boolean r5 = r0.isXmlns()
                if (r5 == 0) goto L40
                int r5 = r6 + (-1)
                if (r6 != 0) goto L3f
                goto L47
            L3f:
                r6 = r5
            L40:
                boolean r5 = r0.toNextSibling()
                if (r5 != 0) goto L34
            L46:
                r2 = r4
            L47:
                if (r2 == 0) goto L4a
                return r0
            L4a:
                r0.release()
                java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException
                java.lang.String r6 = "Namespace index is too large"
                r5.<init>(r6)
                throw r5
            L55:
                java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException
                java.lang.String r6 = "Namespace index is negative"
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderForNode.toXmlns(org.apache.xmlbeans.impl.store.Cur, int):org.apache.xmlbeans.impl.store.Cur");
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i) {
            Cur xmlns = toXmlns(this._cur, i);
            String xmlnsPrefix = xmlns.getXmlnsPrefix();
            xmlns.release();
            return xmlnsPrefix;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i) {
            Cur xmlns = toXmlns(this._cur, i);
            String xmlnsUri = xmlns.getXmlnsUri();
            xmlns.release();
            return xmlnsUri;
        }

        private void fetchChars() {
            Cur cur;
            if (this._textFetched) {
                return;
            }
            int kind = this._cur.kind();
            if (kind == 4) {
                cur = this._cur.tempCur();
                cur.next();
            } else if (kind == 0) {
                cur = this._cur;
            } else {
                throw new IllegalStateException();
            }
            Object chars = cur.getChars(-1);
            ensureCharBufLen(cur._cchSrc);
            char[] cArr = this._chars;
            this._offChars = 0;
            int i = cur._offSrc;
            int i2 = cur._cchSrc;
            this._cchChars = i2;
            CharUtil.getChars(cArr, 0, chars, i, i2);
            if (cur != this._cur) {
                cur.release();
            }
            this._textFetched = true;
        }

        private void ensureCharBufLen(int i) {
            char[] cArr = this._chars;
            if (cArr == null || cArr.length < i) {
                int i2 = 256;
                while (i2 < i) {
                    i2 *= 2;
                }
                this._chars = new char[i2];
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            checkChanged();
            fetchChars();
            return this._chars;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextStart() {
            checkChanged();
            fetchChars();
            return this._offChars;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextLength() {
            checkChanged();
            fetchChars();
            return this._cchChars;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
            Cur cur;
            if (i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 < 0 || i2 >= cArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 + i3 > cArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (!this._srcFetched) {
                int kind = this._cur.kind();
                if (kind == 4) {
                    cur = this._cur.tempCur();
                    cur.next();
                } else if (kind == 0) {
                    cur = this._cur;
                } else {
                    throw new IllegalStateException();
                }
                this._src = cur.getChars(-1);
                this._offSrc = cur._offSrc;
                this._cchSrc = cur._cchSrc;
                if (cur != this._cur) {
                    cur.release();
                }
                this._srcFetched = true;
            }
            int i4 = this._cchSrc;
            if (i > i4) {
                throw new IndexOutOfBoundsException();
            }
            if (i + i3 > i4) {
                i3 = i4 - i;
            }
            CharUtil.getChars(cArr, i2, this._src, this._offSrc, i3);
            return i3;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasText() {
            int kind = this._cur.kind();
            return kind == 4 || kind == 0;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasName() {
            int kind = this._cur.kind();
            return kind == 2 || kind == -2;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getName() {
            if (!hasName()) {
                throw new IllegalStateException();
            }
            return this._cur.getName();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            return getName().getNamespaceURI();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getLocalName() {
            return getName().getLocalPart();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPrefix() {
            return getName().getPrefix();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPITarget() {
            if (this._cur.kind() == 5) {
                return this._cur.getName().getLocalPart();
            }
            return null;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPIData() {
            if (this._cur.kind() == 5) {
                return this._cur.getValueAsString();
            }
            return null;
        }
    }

    private static abstract class XMLStreamReaderBase implements XMLStreamReader, NamespaceContext, Location {
        private Locale _locale;
        String _uri;
        private long _version;
        int _line = -1;
        int _column = -1;
        int _offset = -1;

        @Override // aavax.xml.stream.XMLStreamReader
        public String getEncoding() {
            return null;
        }

        @Override // aavax.xml.stream.Location
        public String getPublicId() {
            return null;
        }

        protected abstract Cur getStreamCur();

        @Override // aavax.xml.stream.Location
        public String getSystemId() {
            return null;
        }

        XMLStreamReaderBase(Cur cur) {
            Locale locale = cur._locale;
            this._locale = locale;
            this._version = locale.version();
        }

        protected final void checkChanged() {
            if (this._version != this._locale.version()) {
                throw new ConcurrentModificationException("Document changed while streaming");
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public void close() throws XMLStreamException {
            checkChanged();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            checkChanged();
            String text = getText();
            return this._locale.getCharUtil().isWhiteSpace(text, 0, text.length());
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public Location getLocation() {
            Class cls;
            checkChanged();
            Cur streamCur = getStreamCur();
            if (Jsr173.class$org$apache$xmlbeans$XmlLineNumber == null) {
                cls = Jsr173.class$("org.apache.xmlbeans.XmlLineNumber");
                Jsr173.class$org$apache$xmlbeans$XmlLineNumber = cls;
            } else {
                cls = Jsr173.class$org$apache$xmlbeans$XmlLineNumber;
            }
            XmlLineNumber xmlLineNumber = (XmlLineNumber) streamCur.getBookmark(cls);
            this._uri = null;
            if (xmlLineNumber != null) {
                this._line = xmlLineNumber.getLine();
                this._column = xmlLineNumber.getColumn();
                this._offset = xmlLineNumber.getOffset();
            } else {
                this._line = -1;
                this._column = -1;
                this._offset = -1;
            }
            return this;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public Object getProperty(String str) {
            checkChanged();
            if (str != null) {
                return null;
            }
            throw new IllegalArgumentException("Property name is null");
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getCharacterEncodingScheme() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return null;
            }
            return docProps.getEncoding();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getVersion() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return null;
            }
            return docProps.getVersion();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStandalone() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return false;
            }
            return docProps.getStandalone();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean standaloneSet() {
            checkChanged();
            return false;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public void require(int i, String str, String str2) throws XMLStreamException {
            checkChanged();
            if (i != getEventType()) {
                throw new XMLStreamException();
            }
            if (str != null && !getNamespaceURI().equals(str)) {
                throw new XMLStreamException();
            }
            if (str2 != null && !getLocalName().equals(str2)) {
                throw new XMLStreamException();
            }
        }

        @Override // aavax.xml.stream.Location
        public int getCharacterOffset() {
            return this._offset;
        }

        @Override // aavax.xml.stream.Location
        public int getColumnNumber() {
            return this._column;
        }

        @Override // aavax.xml.stream.Location
        public int getLineNumber() {
            return this._line;
        }

        public String getLocationURI() {
            return this._uri;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public NamespaceContext getNamespaceContext() {
            throw new RuntimeException("This version of getNamespaceContext should not be called");
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(String str) {
            checkChanged();
            Cur streamCur = getStreamCur();
            streamCur.push();
            if (!streamCur.isContainer()) {
                streamCur.toParent();
            }
            String namespaceForPrefix = streamCur.namespaceForPrefix(str, true);
            streamCur.pop();
            return namespaceForPrefix;
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            checkChanged();
            Cur streamCur = getStreamCur();
            streamCur.push();
            if (!streamCur.isContainer()) {
                streamCur.toParent();
            }
            String prefixForNamespace = streamCur.prefixForNamespace(str, null, false);
            streamCur.pop();
            return prefixForNamespace;
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            checkChanged();
            HashMap hashMap = new HashMap();
            hashMap.put(str, getPrefix(str));
            return hashMap.values().iterator();
        }
    }

    private static final class XMLStreamReaderForString extends XMLStreamReaderBase {
        private int _cch;
        private Cur _cur;
        private int _off;
        private Object _src;

        XMLStreamReaderForString(Cur cur, Object obj, int i, int i2) {
            super(cur);
            this._src = obj;
            this._off = i;
            this._cch = i2;
            this._cur = cur;
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        protected Cur getStreamCur() {
            return this._cur;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getText() {
            checkChanged();
            return CharUtil.getString(this._src, this._off, this._cch);
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            checkChanged();
            int i = this._cch;
            char[] cArr = new char[i];
            CharUtil.getChars(cArr, 0, this._src, this._off, i);
            return cArr;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextStart() {
            checkChanged();
            return this._off;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextLength() {
            checkChanged();
            return this._cch;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i, char[] cArr, int i2, int i3) {
            checkChanged();
            if (i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            int i4 = this._cch;
            if (i > i4) {
                throw new IndexOutOfBoundsException();
            }
            if (i + i3 > i4) {
                i3 = i4 - i;
            }
            CharUtil.getChars(cArr, i2, this._src, this._off + i, i3);
            return i3;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getEventType() {
            checkChanged();
            return 4;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasName() {
            checkChanged();
            return false;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasNext() {
            checkChanged();
            return false;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasText() {
            checkChanged();
            return true;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            checkChanged();
            return true;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            checkChanged();
            return false;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            checkChanged();
            return false;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeType(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getElementText() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getLocalName() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getName() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPIData() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPITarget() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPrefix() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i) {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int next() {
            throw new IllegalStateException();
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int nextTag() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase, aavax.xml.stream.Location
        public String getPublicId() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase, aavax.xml.stream.Location
        public String getSystemId() {
            throw new IllegalStateException();
        }
    }

    private static abstract class Jsr173GateWay {
        Locale _l;
        XMLStreamReaderBase _xs;

        public Jsr173GateWay(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            this._l = locale;
            this._xs = xMLStreamReaderBase;
        }
    }

    private static final class SyncedJsr173 extends Jsr173GateWay implements XMLStreamReader, Location, NamespaceContext {
        @Override // aavax.xml.stream.XMLStreamReader
        public NamespaceContext getNamespaceContext() {
            return this;
        }

        public SyncedJsr173(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            super(locale, xMLStreamReaderBase);
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public Object getProperty(String str) {
            Object property;
            synchronized (this._l) {
                this._l.enter();
                try {
                    property = this._xs.getProperty(str);
                } finally {
                    this._l.exit();
                }
            }
            return property;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            int next;
            synchronized (this._l) {
                this._l.enter();
                try {
                    next = this._xs.next();
                } finally {
                    this._l.exit();
                }
            }
            return next;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public void require(int i, String str, String str2) throws XMLStreamException {
            synchronized (this._l) {
                this._l.enter();
                try {
                    this._xs.require(i, str, str2);
                } finally {
                    this._l.exit();
                }
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getElementText() throws XMLStreamException {
            String elementText;
            synchronized (this._l) {
                this._l.enter();
                try {
                    elementText = this._xs.getElementText();
                } finally {
                    this._l.exit();
                }
            }
            return elementText;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int nextTag() throws XMLStreamException {
            int nextTag;
            synchronized (this._l) {
                this._l.enter();
                try {
                    nextTag = this._xs.nextTag();
                } finally {
                    this._l.exit();
                }
            }
            return nextTag;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasNext() throws XMLStreamException {
            boolean hasNext;
            synchronized (this._l) {
                this._l.enter();
                try {
                    hasNext = this._xs.hasNext();
                } finally {
                    this._l.exit();
                }
            }
            return hasNext;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public void close() throws XMLStreamException {
            synchronized (this._l) {
                this._l.enter();
                try {
                    this._xs.close();
                } finally {
                    this._l.exit();
                }
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(String str) {
            String namespaceURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceURI = this._xs.getNamespaceURI(str);
                } finally {
                    this._l.exit();
                }
            }
            return namespaceURI;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            boolean isStartElement;
            synchronized (this._l) {
                this._l.enter();
                try {
                    isStartElement = this._xs.isStartElement();
                } finally {
                    this._l.exit();
                }
            }
            return isStartElement;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            boolean isEndElement;
            synchronized (this._l) {
                this._l.enter();
                try {
                    isEndElement = this._xs.isEndElement();
                } finally {
                    this._l.exit();
                }
            }
            return isEndElement;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            boolean isCharacters;
            synchronized (this._l) {
                this._l.enter();
                try {
                    isCharacters = this._xs.isCharacters();
                } finally {
                    this._l.exit();
                }
            }
            return isCharacters;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            boolean isWhiteSpace;
            synchronized (this._l) {
                this._l.enter();
                try {
                    isWhiteSpace = this._xs.isWhiteSpace();
                } finally {
                    this._l.exit();
                }
            }
            return isWhiteSpace;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            String attributeValue;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeValue = this._xs.getAttributeValue(str, str2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeValue;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            int attributeCount;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeCount = this._xs.getAttributeCount();
                } finally {
                    this._l.exit();
                }
            }
            return attributeCount;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i) {
            QName attributeName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeName = this._xs.getAttributeName(i);
                } finally {
                    this._l.exit();
                }
            }
            return attributeName;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i) {
            String attributeNamespace;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeNamespace = this._xs.getAttributeNamespace(i);
                } finally {
                    this._l.exit();
                }
            }
            return attributeNamespace;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i) {
            String attributeLocalName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeLocalName = this._xs.getAttributeLocalName(i);
                } finally {
                    this._l.exit();
                }
            }
            return attributeLocalName;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i) {
            String attributePrefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributePrefix = this._xs.getAttributePrefix(i);
                } finally {
                    this._l.exit();
                }
            }
            return attributePrefix;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeType(int i) {
            String attributeType;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeType = this._xs.getAttributeType(i);
                } finally {
                    this._l.exit();
                }
            }
            return attributeType;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i) {
            String attributeValue;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeValue = this._xs.getAttributeValue(i);
                } finally {
                    this._l.exit();
                }
            }
            return attributeValue;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i) {
            boolean isAttributeSpecified;
            synchronized (this._l) {
                this._l.enter();
                try {
                    isAttributeSpecified = this._xs.isAttributeSpecified(i);
                } finally {
                    this._l.exit();
                }
            }
            return isAttributeSpecified;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            int namespaceCount;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceCount = this._xs.getNamespaceCount();
                } finally {
                    this._l.exit();
                }
            }
            return namespaceCount;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i) {
            String namespacePrefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespacePrefix = this._xs.getNamespacePrefix(i);
                } finally {
                    this._l.exit();
                }
            }
            return namespacePrefix;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i) {
            String namespaceURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceURI = this._xs.getNamespaceURI(i);
                } finally {
                    this._l.exit();
                }
            }
            return namespaceURI;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getEventType() {
            int eventType;
            synchronized (this._l) {
                this._l.enter();
                try {
                    eventType = this._xs.getEventType();
                } finally {
                    this._l.exit();
                }
            }
            return eventType;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getText() {
            String text;
            synchronized (this._l) {
                this._l.enter();
                try {
                    text = this._xs.getText();
                } finally {
                    this._l.exit();
                }
            }
            return text;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            char[] textCharacters;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textCharacters = this._xs.getTextCharacters();
                } finally {
                    this._l.exit();
                }
            }
            return textCharacters;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
            int textCharacters;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textCharacters = this._xs.getTextCharacters(i, cArr, i2, i3);
                } finally {
                    this._l.exit();
                }
            }
            return textCharacters;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextStart() {
            int textStart;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textStart = this._xs.getTextStart();
                } finally {
                    this._l.exit();
                }
            }
            return textStart;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextLength() {
            int textLength;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textLength = this._xs.getTextLength();
                } finally {
                    this._l.exit();
                }
            }
            return textLength;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getEncoding() {
            String encoding;
            synchronized (this._l) {
                this._l.enter();
                try {
                    encoding = this._xs.getEncoding();
                } finally {
                    this._l.exit();
                }
            }
            return encoding;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasText() {
            boolean hasText;
            synchronized (this._l) {
                this._l.enter();
                try {
                    hasText = this._xs.hasText();
                } finally {
                    this._l.exit();
                }
            }
            return hasText;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public Location getLocation() {
            Location location;
            synchronized (this._l) {
                this._l.enter();
                try {
                    location = this._xs.getLocation();
                } finally {
                    this._l.exit();
                }
            }
            return location;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getName() {
            QName name;
            synchronized (this._l) {
                this._l.enter();
                try {
                    name = this._xs.getName();
                } finally {
                    this._l.exit();
                }
            }
            return name;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getLocalName() {
            String localName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    localName = this._xs.getLocalName();
                } finally {
                    this._l.exit();
                }
            }
            return localName;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasName() {
            boolean hasName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    hasName = this._xs.hasName();
                } finally {
                    this._l.exit();
                }
            }
            return hasName;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            String namespaceURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceURI = this._xs.getNamespaceURI();
                } finally {
                    this._l.exit();
                }
            }
            return namespaceURI;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPrefix() {
            String prefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    prefix = this._xs.getPrefix();
                } finally {
                    this._l.exit();
                }
            }
            return prefix;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getVersion() {
            String version;
            synchronized (this._l) {
                this._l.enter();
                try {
                    version = this._xs.getVersion();
                } finally {
                    this._l.exit();
                }
            }
            return version;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStandalone() {
            boolean isStandalone;
            synchronized (this._l) {
                this._l.enter();
                try {
                    isStandalone = this._xs.isStandalone();
                } finally {
                    this._l.exit();
                }
            }
            return isStandalone;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean standaloneSet() {
            boolean standaloneSet;
            synchronized (this._l) {
                this._l.enter();
                try {
                    standaloneSet = this._xs.standaloneSet();
                } finally {
                    this._l.exit();
                }
            }
            return standaloneSet;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getCharacterEncodingScheme() {
            String characterEncodingScheme;
            synchronized (this._l) {
                this._l.enter();
                try {
                    characterEncodingScheme = this._xs.getCharacterEncodingScheme();
                } finally {
                    this._l.exit();
                }
            }
            return characterEncodingScheme;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPITarget() {
            String pITarget;
            synchronized (this._l) {
                this._l.enter();
                try {
                    pITarget = this._xs.getPITarget();
                } finally {
                    this._l.exit();
                }
            }
            return pITarget;
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPIData() {
            String pIData;
            synchronized (this._l) {
                this._l.enter();
                try {
                    pIData = this._xs.getPIData();
                } finally {
                    this._l.exit();
                }
            }
            return pIData;
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            String prefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    prefix = this._xs.getPrefix(str);
                } finally {
                    this._l.exit();
                }
            }
            return prefix;
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            Iterator prefixes;
            synchronized (this._l) {
                this._l.enter();
                try {
                    prefixes = this._xs.getPrefixes(str);
                } finally {
                    this._l.exit();
                }
            }
            return prefixes;
        }

        @Override // aavax.xml.stream.Location
        public int getCharacterOffset() {
            int characterOffset;
            synchronized (this._l) {
                this._l.enter();
                try {
                    characterOffset = this._xs.getCharacterOffset();
                } finally {
                    this._l.exit();
                }
            }
            return characterOffset;
        }

        @Override // aavax.xml.stream.Location
        public int getColumnNumber() {
            int columnNumber;
            synchronized (this._l) {
                this._l.enter();
                try {
                    columnNumber = this._xs.getColumnNumber();
                } finally {
                    this._l.exit();
                }
            }
            return columnNumber;
        }

        @Override // aavax.xml.stream.Location
        public int getLineNumber() {
            int lineNumber;
            synchronized (this._l) {
                this._l.enter();
                try {
                    lineNumber = this._xs.getLineNumber();
                } finally {
                    this._l.exit();
                }
            }
            return lineNumber;
        }

        public String getLocationURI() {
            String locationURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    locationURI = this._xs.getLocationURI();
                } finally {
                    this._l.exit();
                }
            }
            return locationURI;
        }

        @Override // aavax.xml.stream.Location
        public String getPublicId() {
            String publicId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    publicId = this._xs.getPublicId();
                } finally {
                    this._l.exit();
                }
            }
            return publicId;
        }

        @Override // aavax.xml.stream.Location
        public String getSystemId() {
            String systemId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    systemId = this._xs.getSystemId();
                } finally {
                    this._l.exit();
                }
            }
            return systemId;
        }
    }

    private static final class UnsyncedJsr173 extends Jsr173GateWay implements XMLStreamReader, Location, NamespaceContext {
        @Override // aavax.xml.stream.XMLStreamReader
        public NamespaceContext getNamespaceContext() {
            return this;
        }

        public UnsyncedJsr173(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            super(locale, xMLStreamReaderBase);
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public Object getProperty(String str) {
            try {
                this._l.enter();
                return this._xs.getProperty(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.next();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public void require(int i, String str, String str2) throws XMLStreamException {
            try {
                this._l.enter();
                this._xs.require(i, str, str2);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getElementText() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.getElementText();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int nextTag() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.nextTag();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasNext() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.hasNext();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public void close() throws XMLStreamException {
            try {
                this._l.enter();
                this._xs.close();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(String str) {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            try {
                this._l.enter();
                return this._xs.isStartElement();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            try {
                this._l.enter();
                return this._xs.isEndElement();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            try {
                this._l.enter();
                return this._xs.isCharacters();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            try {
                this._l.enter();
                return this._xs.isWhiteSpace();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            try {
                this._l.enter();
                return this._xs.getAttributeValue(str, str2);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            try {
                this._l.enter();
                return this._xs.getAttributeCount();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i) {
            try {
                this._l.enter();
                return this._xs.getAttributeName(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i) {
            try {
                this._l.enter();
                return this._xs.getAttributeNamespace(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i) {
            try {
                this._l.enter();
                return this._xs.getAttributeLocalName(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i) {
            try {
                this._l.enter();
                return this._xs.getAttributePrefix(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeType(int i) {
            try {
                this._l.enter();
                return this._xs.getAttributeType(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i) {
            try {
                this._l.enter();
                return this._xs.getAttributeValue(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i) {
            try {
                this._l.enter();
                return this._xs.isAttributeSpecified(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            try {
                this._l.enter();
                return this._xs.getNamespaceCount();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i) {
            try {
                this._l.enter();
                return this._xs.getNamespacePrefix(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i) {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI(i);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getEventType() {
            try {
                this._l.enter();
                return this._xs.getEventType();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getText() {
            try {
                this._l.enter();
                return this._xs.getText();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            try {
                this._l.enter();
                return this._xs.getTextCharacters();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i, char[] cArr, int i2, int i3) throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.getTextCharacters(i, cArr, i2, i3);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextStart() {
            try {
                this._l.enter();
                return this._xs.getTextStart();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public int getTextLength() {
            try {
                this._l.enter();
                return this._xs.getTextLength();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getEncoding() {
            try {
                this._l.enter();
                return this._xs.getEncoding();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasText() {
            try {
                this._l.enter();
                return this._xs.hasText();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public Location getLocation() {
            try {
                this._l.enter();
                return this._xs.getLocation();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public QName getName() {
            try {
                this._l.enter();
                return this._xs.getName();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getLocalName() {
            try {
                this._l.enter();
                return this._xs.getLocalName();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean hasName() {
            try {
                this._l.enter();
                return this._xs.hasName();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPrefix() {
            try {
                this._l.enter();
                return this._xs.getPrefix();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getVersion() {
            try {
                this._l.enter();
                return this._xs.getVersion();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean isStandalone() {
            try {
                this._l.enter();
                return this._xs.isStandalone();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public boolean standaloneSet() {
            try {
                this._l.enter();
                return this._xs.standaloneSet();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getCharacterEncodingScheme() {
            try {
                this._l.enter();
                return this._xs.getCharacterEncodingScheme();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPITarget() {
            try {
                this._l.enter();
                return this._xs.getPITarget();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.XMLStreamReader
        public String getPIData() {
            try {
                this._l.enter();
                return this._xs.getPIData();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            try {
                this._l.enter();
                return this._xs.getPrefix(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            try {
                this._l.enter();
                return this._xs.getPrefixes(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.Location
        public int getCharacterOffset() {
            try {
                this._l.enter();
                return this._xs.getCharacterOffset();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.Location
        public int getColumnNumber() {
            try {
                this._l.enter();
                return this._xs.getColumnNumber();
            } finally {
                this._l.exit();
            }
        }

        @Override // aavax.xml.stream.Location
        public int getLineNumber() {
            int lineNumber;
            synchronized (this._l) {
                this._l.enter();
                try {
                    lineNumber = this._xs.getLineNumber();
                } finally {
                    this._l.exit();
                }
            }
            return lineNumber;
        }

        public String getLocationURI() {
            String locationURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    locationURI = this._xs.getLocationURI();
                } finally {
                    this._l.exit();
                }
            }
            return locationURI;
        }

        @Override // aavax.xml.stream.Location
        public String getPublicId() {
            String publicId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    publicId = this._xs.getPublicId();
                } finally {
                    this._l.exit();
                }
            }
            return publicId;
        }

        @Override // aavax.xml.stream.Location
        public String getSystemId() {
            String systemId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    systemId = this._xs.getSystemId();
                } finally {
                    this._l.exit();
                }
            }
            return systemId;
        }
    }
}
