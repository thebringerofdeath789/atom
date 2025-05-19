package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameCache;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.apache.xmlbeans.impl.piccolo.xml.Piccolo;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Saaj;
import org.apache.xmlbeans.xml.stream.Location;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes5.dex */
public final class Locale implements DOMImplementation, Saaj.SaajCallback, XmlLocale {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    public static final String COPY_USE_NEW_LOCALE = "COPY_USE_NEW_LOCALE";
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    public static final String USE_SAME_LOCALE = "USE_SAME_LOCALE";
    static final int WS_COLLAPSE = 3;
    static final int WS_PRESERVE = 1;
    static final int WS_REPLACE = 2;
    static final int WS_UNSPECIFIED = 0;
    static final String _openFragUri = "http://www.openuri.org/fragment";
    static final QName _openuriFragment;
    static final String _schema = "http://www.w3.org/2001/XMLSchema";
    static final String _xml1998Uri = "http://www.w3.org/XML/1998/namespace";
    static final QName _xmlFragment;
    static final String _xmlnsUri = "http://www.w3.org/2000/xmlns/";
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiLoc;
    static final QName _xsiNil;
    static final QName _xsiNoLoc;
    static final QName _xsiType;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Locale;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Locale$DocProps;
    private static ThreadLocal tl_scrubBuffer;
    int _cchSrc;
    ChangeListener _changeListeners;
    private CharUtil _charUtil;
    Cur _curPool;
    int _curPoolCount;
    private int _entryCount;
    Cur.Locations _locations;
    boolean _noSync;
    int _numTempFramesLeft;
    int _offSrc;
    DomImpl.Dom _ownerDoc;
    int _posTemp;
    QNameFactory _qnameFactory;
    private ReferenceQueue _refQueue;
    Cur _registered;
    Saaj _saaj;
    SchemaTypeLoader _schemaTypeLoader;
    Cur[] _tempFrames;
    boolean _validateOnSet;
    long _versionAll;
    long _versionSansText;
    nthCache _nthCache_A = new nthCache();
    nthCache _nthCache_B = new nthCache();
    domNthCache _domNthCache_A = new domNthCache();
    domNthCache _domNthCache_B = new domNthCache();

    interface ChangeListener {
        ChangeListener getNextChangeListener();

        void notifyChange();

        void setNextChangeListener(ChangeListener changeListener);
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$Locale == null) {
            class$org$apache$xmlbeans$impl$store$Locale = class$("org.apache.xmlbeans.impl.store.Locale");
        }
        $assertionsDisabled = true;
        _xsiNil = new QName(_xsi, "nil", "xsi");
        _xsiType = new QName(_xsi, "type", "xsi");
        _xsiLoc = new QName(_xsi, "schemaLocation", "xsi");
        _xsiNoLoc = new QName(_xsi, "noNamespaceSchemaLocation", "xsi");
        _openuriFragment = new QName(_openFragUri, "fragment", "frag");
        _xmlFragment = new QName("xml-fragment");
        tl_scrubBuffer = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.store.Locale.1
            @Override // java.lang.ThreadLocal
            protected Object initialValue() {
                return new SoftReference(new ScrubBuffer());
            }
        };
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private Locale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        this._noSync = maskNull.hasOption(XmlOptions.UNSYNCHRONIZED);
        this._numTempFramesLeft = 8;
        this._tempFrames = new Cur[8];
        this._qnameFactory = new DefaultQNameFactory();
        this._locations = new Cur.Locations(this);
        this._schemaTypeLoader = schemaTypeLoader;
        this._validateOnSet = maskNull.hasOption(XmlOptions.VALIDATE_ON_SET);
        Object obj = maskNull.get(Saaj.SAAJ_IMPL);
        if (obj != null) {
            if (!(obj instanceof Saaj)) {
                throw new IllegalStateException(new StringBuffer().append("Saaj impl not correct type: ").append(obj).toString());
            }
            Saaj saaj = (Saaj) obj;
            this._saaj = saaj;
            saaj.setCallback(this);
        }
    }

    static Locale getLocale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        Locale locale;
        if (schemaTypeLoader == null) {
            schemaTypeLoader = XmlBeans.getContextTypeLoader();
        }
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        if (maskNull.hasOption(USE_SAME_LOCALE)) {
            Object obj = maskNull.get(USE_SAME_LOCALE);
            if (obj instanceof Locale) {
                locale = (Locale) obj;
            } else if (obj instanceof XmlTokenSource) {
                locale = (Locale) ((XmlTokenSource) obj).monitor();
            } else {
                throw new IllegalArgumentException(new StringBuffer().append("Source locale not understood: ").append(obj).toString());
            }
            if (locale._schemaTypeLoader != schemaTypeLoader) {
                throw new IllegalArgumentException("Source locale does not support same schema type loader");
            }
            Saaj saaj = locale._saaj;
            if (saaj != null && saaj != maskNull.get(Saaj.SAAJ_IMPL)) {
                throw new IllegalArgumentException("Source locale does not support same saaj");
            }
            if (!locale._validateOnSet || maskNull.hasOption(XmlOptions.VALIDATE_ON_SET)) {
                return locale;
            }
            throw new IllegalArgumentException("Source locale does not support same validate on set");
        }
        return new Locale(schemaTypeLoader, maskNull);
    }

    static void associateSourceName(Cur cur, XmlOptions xmlOptions) {
        String str = (String) XmlOptions.safeGet(xmlOptions, XmlOptions.DOCUMENT_SOURCE_NAME);
        if (str != null) {
            getDocProps(cur, true).setSourceName(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0042, code lost:
    
        if (r5.isAssignableFrom(r1) == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void autoTypeDocument(org.apache.xmlbeans.impl.store.Cur r4, org.apache.xmlbeans.SchemaType r5, org.apache.xmlbeans.XmlOptions r6) throws org.apache.xmlbeans.XmlException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.autoTypeDocument(org.apache.xmlbeans.impl.store.Cur, org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.XmlOptions):void");
    }

    private static boolean namespacesSame(QName qName, QName qName2) {
        if (qName == qName2) {
            return true;
        }
        if (qName != null && qName2 != null) {
            if (qName.getNamespaceURI() == qName2.getNamespaceURI()) {
                return true;
            }
            if (qName.getNamespaceURI() != null && qName2.getNamespaceURI() != null) {
                return qName.getNamespaceURI().equals(qName2.getNamespaceURI());
            }
        }
        return false;
    }

    private static void addNamespace(StringBuffer stringBuffer, QName qName) {
        if (qName.getNamespaceURI() == null) {
            stringBuffer.append("<no namespace>");
            return;
        }
        stringBuffer.append("\"");
        stringBuffer.append(qName.getNamespaceURI());
        stringBuffer.append("\"");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5 A[Catch: all -> 0x00ec, TRY_ENTER, TryCatch #0 {all -> 0x00ec, blocks: (B:10:0x0014, B:13:0x001d, B:16:0x0025, B:18:0x002f, B:21:0x0050, B:25:0x00d5, B:26:0x00eb, B:28:0x0062, B:30:0x0068, B:31:0x009e, B:33:0x00b2, B:36:0x00cc), top: B:9:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void verifyDocumentType(org.apache.xmlbeans.impl.store.Cur r6, aavax.xml.namespace.QName r7) throws org.apache.xmlbeans.XmlException {
        /*
            boolean r0 = org.apache.xmlbeans.impl.store.Locale.$assertionsDisabled
            if (r0 != 0) goto L11
            boolean r0 = r6.isRoot()
            if (r0 == 0) goto Lb
            goto L11
        Lb:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        L11:
            r6.push()
            boolean r0 = toFirstChildElement(r6)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = "The document is not a "
            r2 = 0
            if (r0 == 0) goto Lb2
            boolean r0 = toNextSiblingElement(r6)     // Catch: java.lang.Throwable -> Lec
            if (r0 == 0) goto L25
            goto Lb2
        L25:
            aavax.xml.namespace.QName r0 = r6.getName()     // Catch: java.lang.Throwable -> Lec
            boolean r3 = r0.equals(r7)     // Catch: java.lang.Throwable -> Lec
            if (r3 != 0) goto Lb0
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r3.<init>()     // Catch: java.lang.Throwable -> Lec
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = org.apache.xmlbeans.impl.common.QNameHelper.pretty(r7)     // Catch: java.lang.Throwable -> Lec
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = r7.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            java.lang.String r4 = r0.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r4 = " got "
            java.lang.String r5 = "expected "
            if (r1 == 0) goto L62
            java.lang.String r1 = ": document element namespace mismatch "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            r3.append(r5)     // Catch: java.lang.Throwable -> Lec
            addNamespace(r3, r7)     // Catch: java.lang.Throwable -> Lec
            r3.append(r4)     // Catch: java.lang.Throwable -> Lec
            addNamespace(r3, r0)     // Catch: java.lang.Throwable -> Lec
            goto Lcf
        L62:
            boolean r1 = namespacesSame(r7, r0)     // Catch: java.lang.Throwable -> Lec
            if (r1 == 0) goto L9e
            java.lang.String r1 = ": document element local name mismatch "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r1.<init>()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r1 = r1.append(r5)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = r7.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = r1.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r7.<init>()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = r7.append(r4)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r0 = r0.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = r7.append(r0)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            goto Lcf
        L9e:
            java.lang.String r7 = ": document element mismatch "
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = "got "
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = org.apache.xmlbeans.impl.common.QNameHelper.pretty(r0)     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            goto Lcf
        Lb0:
            r3 = r2
            goto Lcf
        Lb2:
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r3.<init>()     // Catch: java.lang.Throwable -> Lec
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = org.apache.xmlbeans.impl.common.QNameHelper.pretty(r7)     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            boolean r7 = r6.isRoot()     // Catch: java.lang.Throwable -> Lec
            if (r7 == 0) goto Lca
            java.lang.String r7 = ": no document element"
            goto Lcc
        Lca:
            java.lang.String r7 = ": multiple document elements"
        Lcc:
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
        Lcf:
            if (r3 != 0) goto Ld5
            r6.pop()
            return
        Ld5:
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> Lec
            org.apache.xmlbeans.impl.store.Cursor r0 = new org.apache.xmlbeans.impl.store.Cursor     // Catch: java.lang.Throwable -> Lec
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Lec
            org.apache.xmlbeans.XmlError r7 = org.apache.xmlbeans.XmlError.forCursor(r7, r0)     // Catch: java.lang.Throwable -> Lec
            org.apache.xmlbeans.XmlException r0 = new org.apache.xmlbeans.XmlException     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Throwable -> Lec
            r0.<init>(r1, r2, r7)     // Catch: java.lang.Throwable -> Lec
            throw r0     // Catch: java.lang.Throwable -> Lec
        Lec:
            r7 = move-exception
            r6.pop()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.verifyDocumentType(org.apache.xmlbeans.impl.store.Cur, aavax.xml.namespace.QName):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5 A[Catch: all -> 0x00ec, TRY_ENTER, TryCatch #0 {all -> 0x00ec, blocks: (B:10:0x0014, B:13:0x001d, B:16:0x0025, B:18:0x002f, B:21:0x0050, B:25:0x00d5, B:26:0x00eb, B:28:0x0062, B:30:0x0068, B:31:0x009e, B:33:0x00b2, B:36:0x00cc), top: B:9:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void verifyAttributeType(org.apache.xmlbeans.impl.store.Cur r6, aavax.xml.namespace.QName r7) throws org.apache.xmlbeans.XmlException {
        /*
            boolean r0 = org.apache.xmlbeans.impl.store.Locale.$assertionsDisabled
            if (r0 != 0) goto L11
            boolean r0 = r6.isRoot()
            if (r0 == 0) goto Lb
            goto L11
        Lb:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        L11:
            r6.push()
            boolean r0 = toFirstNormalAttr(r6)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = "The document is not a "
            r2 = 0
            if (r0 == 0) goto Lb2
            boolean r0 = toNextNormalAttr(r6)     // Catch: java.lang.Throwable -> Lec
            if (r0 == 0) goto L25
            goto Lb2
        L25:
            aavax.xml.namespace.QName r0 = r6.getName()     // Catch: java.lang.Throwable -> Lec
            boolean r3 = r0.equals(r7)     // Catch: java.lang.Throwable -> Lec
            if (r3 != 0) goto Lb0
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r3.<init>()     // Catch: java.lang.Throwable -> Lec
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = org.apache.xmlbeans.impl.common.QNameHelper.pretty(r7)     // Catch: java.lang.Throwable -> Lec
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = r7.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            java.lang.String r4 = r0.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r4 = " got "
            java.lang.String r5 = "expected "
            if (r1 == 0) goto L62
            java.lang.String r1 = ": attribute namespace mismatch "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            r3.append(r5)     // Catch: java.lang.Throwable -> Lec
            addNamespace(r3, r7)     // Catch: java.lang.Throwable -> Lec
            r3.append(r4)     // Catch: java.lang.Throwable -> Lec
            addNamespace(r3, r0)     // Catch: java.lang.Throwable -> Lec
            goto Lcf
        L62:
            boolean r1 = namespacesSame(r7, r0)     // Catch: java.lang.Throwable -> Lec
            if (r1 == 0) goto L9e
            java.lang.String r1 = ": attribute local name mismatch "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r1.<init>()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r1 = r1.append(r5)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = r7.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = r1.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r7.<init>()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = r7.append(r4)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r0 = r0.getLocalPart()     // Catch: java.lang.Throwable -> Lec
            java.lang.StringBuffer r7 = r7.append(r0)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            goto Lcf
        L9e:
            java.lang.String r7 = ": attribute element mismatch "
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = "got "
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = org.apache.xmlbeans.impl.common.QNameHelper.pretty(r0)     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            goto Lcf
        Lb0:
            r3 = r2
            goto Lcf
        Lb2:
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lec
            r3.<init>()     // Catch: java.lang.Throwable -> Lec
            r3.append(r1)     // Catch: java.lang.Throwable -> Lec
            java.lang.String r7 = org.apache.xmlbeans.impl.common.QNameHelper.pretty(r7)     // Catch: java.lang.Throwable -> Lec
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
            boolean r7 = r6.isRoot()     // Catch: java.lang.Throwable -> Lec
            if (r7 == 0) goto Lca
            java.lang.String r7 = ": no attributes"
            goto Lcc
        Lca:
            java.lang.String r7 = ": multiple attributes"
        Lcc:
            r3.append(r7)     // Catch: java.lang.Throwable -> Lec
        Lcf:
            if (r3 != 0) goto Ld5
            r6.pop()
            return
        Ld5:
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> Lec
            org.apache.xmlbeans.impl.store.Cursor r0 = new org.apache.xmlbeans.impl.store.Cursor     // Catch: java.lang.Throwable -> Lec
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Lec
            org.apache.xmlbeans.XmlError r7 = org.apache.xmlbeans.XmlError.forCursor(r7, r0)     // Catch: java.lang.Throwable -> Lec
            org.apache.xmlbeans.XmlException r0 = new org.apache.xmlbeans.XmlException     // Catch: java.lang.Throwable -> Lec
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Throwable -> Lec
            r0.<init>(r1, r2, r7)     // Catch: java.lang.Throwable -> Lec
            throw r0     // Catch: java.lang.Throwable -> Lec
        Lec:
            r7 = move-exception
            r6.pop()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.verifyAttributeType(org.apache.xmlbeans.impl.store.Cur, aavax.xml.namespace.QName):void");
    }

    static boolean isFragmentQName(QName qName) {
        return qName.equals(_openuriFragment) || qName.equals(_xmlFragment);
    }

    static boolean isFragment(Cur cur, Cur cur2) {
        boolean z;
        int kind;
        if (!$assertionsDisabled && cur2.isAttr()) {
            throw new AssertionError();
        }
        cur.push();
        cur2.push();
        int i = 0;
        while (!cur.isSamePos(cur2) && (kind = cur.kind()) != 3) {
            if ((kind == 0 && !isWhiteSpace(cur.getCharsAsString(-1))) || (kind == 2 && (i = i + 1) > 1)) {
                z = true;
                break;
            }
            if (!$assertionsDisabled && kind == 3) {
                throw new AssertionError();
            }
            if (kind != 0) {
                cur.toEnd();
            }
            cur.next();
        }
        z = false;
        cur.pop();
        cur2.pop();
        return z || i != 1;
    }

    public static XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject newInstance;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.newInstance(schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                newInstance = locale.newInstance(schemaType, xmlOptions);
            } finally {
            }
        }
        return newInstance;
    }

    private XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        Cur tempCur = tempCur();
        SchemaType schemaType2 = (SchemaType) maskNull.get(XmlOptions.DOCUMENT_TYPE);
        if (schemaType2 == null) {
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            schemaType2 = schemaType;
        }
        if (schemaType2.isDocumentType()) {
            tempCur.createDomDocumentRoot();
        } else {
            tempCur.createRoot();
        }
        tempCur.setType(schemaType2);
        XmlObject xmlObject = (XmlObject) tempCur.getUser();
        tempCur.release();
        return xmlObject;
    }

    public static DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return getLocale(schemaTypeLoader, xmlOptions);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlObject parseToXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(str, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                parseToXmlObject = locale.parseToXmlObject(str, schemaType, xmlOptions);
            } finally {
            }
        }
        return parseToXmlObject;
    }

    private XmlObject parseToXmlObject(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        Cur parse = parse(str, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) parse.getUser();
        parse.release();
        return xmlObject;
    }

    Cur parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        StringReader stringReader = new StringReader(str);
        try {
            try {
                Cur load = getSaxLoader(xmlOptions).load(this, new InputSource(stringReader), xmlOptions);
                autoTypeDocument(load, schemaType, xmlOptions);
                return load;
            } catch (IOException e) {
                if ($assertionsDisabled) {
                    throw new XmlException(e.getMessage(), e);
                }
                throw new AssertionError("StringReader should not throw IOException");
            }
        } finally {
            try {
                stringReader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
        XmlObject parseToXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(xMLInputStream, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                parseToXmlObject = locale.parseToXmlObject(xMLInputStream, schemaType, xmlOptions);
            } finally {
            }
        }
        return parseToXmlObject;
    }

    public XmlObject parseToXmlObject(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
        try {
            Cur loadXMLInputStream = loadXMLInputStream(xMLInputStream, xmlOptions);
            autoTypeDocument(loadXMLInputStream, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) loadXMLInputStream.getUser();
            loadXMLInputStream.release();
            return xmlObject;
        } catch (XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlObject parseToXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(xMLStreamReader, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                parseToXmlObject = locale.parseToXmlObject(xMLStreamReader, schemaType, xmlOptions);
            } finally {
            }
        }
        return parseToXmlObject;
    }

    public XmlObject parseToXmlObject(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        try {
            Cur loadXMLStreamReader = loadXMLStreamReader(xMLStreamReader, xmlOptions);
            autoTypeDocument(loadXMLStreamReader, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) loadXMLStreamReader.getUser();
            loadXMLStreamReader.release();
            return xmlObject;
        } catch (aavax.xml.stream.XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    private static void lineNumber(XMLEvent xMLEvent, LoadContext loadContext) {
        Location location = xMLEvent.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), -1);
        }
    }

    private static void lineNumber(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        aavax.xml.stream.Location location = xMLStreamReader.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
    }

    private void doAttributes(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int attributeCount = xMLStreamReader.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            loadContext.attr(xMLStreamReader.getAttributeLocalName(i), xMLStreamReader.getAttributeNamespace(i), xMLStreamReader.getAttributePrefix(i), xMLStreamReader.getAttributeValue(i));
        }
    }

    private void doNamespaces(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        for (int i = 0; i < namespaceCount; i++) {
            String namespacePrefix = xMLStreamReader.getNamespacePrefix(i);
            if (namespacePrefix == null || namespacePrefix.length() == 0) {
                loadContext.attr("xmlns", "http://www.w3.org/2000/xmlns/", null, xMLStreamReader.getNamespaceURI(i));
            } else {
                loadContext.attr(namespacePrefix, "http://www.w3.org/2000/xmlns/", "xmlns", xMLStreamReader.getNamespaceURI(i));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0155 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.xmlbeans.impl.store.Cur loadXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream r14, org.apache.xmlbeans.XmlOptions r15) throws org.apache.xmlbeans.xml.stream.XMLStreamException {
        /*
            Method dump skipped, instructions count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.loadXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream, org.apache.xmlbeans.XmlOptions):org.apache.xmlbeans.impl.store.Cur");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.xmlbeans.impl.store.Cur loadXMLStreamReader(aavax.xml.stream.XMLStreamReader r10, org.apache.xmlbeans.XmlOptions r11) throws aavax.xml.stream.XMLStreamException {
        /*
            r9 = this;
            org.apache.xmlbeans.XmlOptions r11 = org.apache.xmlbeans.XmlOptions.maskNull(r11)
            java.lang.String r0 = "LOAD_LINE_NUMBERS"
            boolean r0 = r11.hasOption(r0)
            org.apache.xmlbeans.impl.store.Cur$CurLoadContext r1 = new org.apache.xmlbeans.impl.store.Cur$CurLoadContext
            r1.<init>(r9, r11)
            int r2 = r10.getEventType()
            r3 = 0
            r4 = 0
            r5 = r4
            r6 = r5
            r4 = r3
        L18:
            switch(r2) {
                case 1: goto La3;
                case 2: goto L98;
                case 3: goto L87;
                case 4: goto L72;
                case 5: goto L65;
                case 6: goto Lb7;
                case 7: goto L4e;
                case 8: goto L47;
                case 9: goto L3e;
                case 10: goto L39;
                case 11: goto Lb7;
                case 12: goto L72;
                case 13: goto L34;
                default: goto L1b;
            }
        L1b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r0 = "Unhandled xml event type: "
            java.lang.StringBuffer r11 = r11.append(r0)
            java.lang.StringBuffer r11 = r11.append(r2)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L34:
            r9.doNamespaces(r10, r1)
            goto Lb7
        L39:
            r9.doAttributes(r10, r1)
            goto Lb7
        L3e:
            java.lang.String r2 = r10.getText()
            r1.text(r2)
            goto Lb7
        L47:
            if (r0 == 0) goto Lc6
            lineNumber(r10, r1)
            goto Lc6
        L4e:
            int r3 = r3 + 1
            java.lang.String r2 = r10.getCharacterEncodingScheme()
            java.lang.String r4 = r10.getVersion()
            boolean r5 = r10.isStandalone()
            if (r0 == 0) goto L61
            lineNumber(r10, r1)
        L61:
            r6 = r4
            r4 = r5
            r5 = r2
            goto Lb7
        L65:
            java.lang.String r2 = r10.getText()
            r1.comment(r2)
            if (r0 == 0) goto Lb7
            lineNumber(r10, r1)
            goto Lb7
        L72:
            char[] r2 = r10.getTextCharacters()
            int r7 = r10.getTextStart()
            int r8 = r10.getTextLength()
            r1.text(r2, r7, r8)
            if (r0 == 0) goto Lb7
            lineNumber(r10, r1)
            goto Lb7
        L87:
            java.lang.String r2 = r10.getPITarget()
            java.lang.String r7 = r10.getPIData()
            r1.procInst(r2, r7)
            if (r0 == 0) goto Lb7
            lineNumber(r10, r1)
            goto Lb7
        L98:
            int r3 = r3 + (-1)
            r1.endElement()
            if (r0 == 0) goto Lb7
            lineNumber(r10, r1)
            goto Lb7
        La3:
            int r3 = r3 + 1
            aavax.xml.namespace.QName r2 = r10.getName()
            r1.startElement(r2)
            if (r0 == 0) goto Lb1
            lineNumber(r10, r1)
        Lb1:
            r9.doAttributes(r10, r1)
            r9.doNamespaces(r10, r1)
        Lb7:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Lc6
            if (r3 > 0) goto Lc0
            goto Lc6
        Lc0:
            int r2 = r10.next()
            goto L18
        Lc6:
            org.apache.xmlbeans.impl.store.Cur r10 = r1.finish()
            associateSourceName(r10, r11)
            r11 = 1
            org.apache.xmlbeans.XmlDocumentProperties r11 = getDocProps(r10, r11)
            r11.setEncoding(r5)
            r11.setVersion(r6)
            r11.setStandalone(r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.loadXMLStreamReader(aavax.xml.stream.XMLStreamReader, org.apache.xmlbeans.XmlOptions):org.apache.xmlbeans.impl.store.Cur");
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlObject parseToXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(inputStream, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                parseToXmlObject = locale.parseToXmlObject(inputStream, schemaType, xmlOptions);
            } finally {
            }
        }
        return parseToXmlObject;
    }

    private XmlObject parseToXmlObject(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        Cur load = getSaxLoader(xmlOptions).load(this, new InputSource(inputStream), xmlOptions);
        autoTypeDocument(load, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) load.getUser();
        load.release();
        return xmlObject;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlObject parseToXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(reader, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                parseToXmlObject = locale.parseToXmlObject(reader, schemaType, xmlOptions);
            } finally {
            }
        }
        return parseToXmlObject;
    }

    private XmlObject parseToXmlObject(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        Cur load = getSaxLoader(xmlOptions).load(this, new InputSource(reader), xmlOptions);
        autoTypeDocument(load, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) load.getUser();
        load.release();
        return xmlObject;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlObject parseToXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(node, schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                parseToXmlObject = locale.parseToXmlObject(node, schemaType, xmlOptions);
            } finally {
            }
        }
        return parseToXmlObject;
    }

    public XmlObject parseToXmlObject(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptions);
        loadNode(node, curLoadContext);
        Cur finish = curLoadContext.finish();
        associateSourceName(finish, xmlOptions);
        autoTypeDocument(finish, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) finish.getUser();
        finish.release();
        return xmlObject;
    }

    private void loadNodeChildren(Node node, LoadContext loadContext) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            loadNode(firstChild, loadContext);
        }
    }

    void loadNode(Node node, LoadContext loadContext) {
        switch (node.getNodeType()) {
            case 1:
                loadContext.startElement(makeQualifiedQName(node.getNamespaceURI(), node.getNodeName()));
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node item = attributes.item(i);
                    String nodeName = item.getNodeName();
                    String nodeValue = item.getNodeValue();
                    if (nodeName.toLowerCase().startsWith("xmlns")) {
                        if (nodeName.length() == 5) {
                            loadContext.xmlns(null, nodeValue);
                        } else {
                            loadContext.xmlns(nodeName.substring(6), nodeValue);
                        }
                    } else {
                        loadContext.attr(makeQualifiedQName(item.getNamespaceURI(), nodeName), nodeValue);
                    }
                }
                loadNodeChildren(node, loadContext);
                loadContext.endElement();
                return;
            case 2:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Unexpected node");
            case 3:
            case 4:
                loadContext.text(node.getNodeValue());
                return;
            case 5:
            case 9:
            case 11:
                loadNodeChildren(node, loadContext);
                return;
            case 7:
                loadContext.procInst(node.getNodeName(), node.getNodeValue());
                return;
            case 8:
                loadContext.comment(node.getNodeValue());
                return;
            default:
                return;
        }
    }

    private class XmlSaxHandlerImpl extends SaxHandler implements XmlSaxHandler {
        private XmlOptions _options;
        private SchemaType _type;

        XmlSaxHandlerImpl(Locale locale, SchemaType schemaType, XmlOptions xmlOptions) {
            super(null);
            this._options = xmlOptions;
            this._type = schemaType;
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put("LOAD_USE_LOCALE_CHAR_UTIL");
            initSaxHandler(locale, xmlOptions2);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public ContentHandler getContentHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public LexicalHandler getLexicalHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastNonAttr(xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastAttr(qName, xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public XmlObject getObject() throws XmlException {
            if (this._context == null) {
                return null;
            }
            this._locale.enter();
            try {
                Cur finish = this._context.finish();
                Locale.autoTypeDocument(finish, this._type, this._options);
                XmlObject xmlObject = (XmlObject) finish.getUser();
                finish.release();
                this._context = null;
                return xmlObject;
            } finally {
                this._locale.exit();
            }
        }
    }

    public static XmlSaxHandler newSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlSaxHandler newSaxHandler;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.newSaxHandler(schemaType, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                newSaxHandler = locale.newSaxHandler(schemaType, xmlOptions);
            } finally {
            }
        }
        return newSaxHandler;
    }

    public XmlSaxHandler newSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        return new XmlSaxHandlerImpl(this, schemaType, xmlOptions);
    }

    QName makeQName(String str, String str2) {
        if ($assertionsDisabled || (str2 != null && str2.length() > 0)) {
            return this._qnameFactory.getQName(str, str2);
        }
        throw new AssertionError();
    }

    QName makeQNameNoCheck(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    QName makeQName(String str, String str2, String str3) {
        QNameFactory qNameFactory = this._qnameFactory;
        if (str3 == null) {
            str3 = "";
        }
        return qNameFactory.getQName(str, str2, str3);
    }

    QName makeQualifiedQName(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int indexOf = str2.indexOf(58);
        return indexOf < 0 ? this._qnameFactory.getQName(str, str2) : this._qnameFactory.getQName(str, str2.substring(indexOf + 1), str2.substring(0, indexOf));
    }

    private static class DocProps extends XmlDocumentProperties {
        private HashMap _map;

        private DocProps() {
            this._map = new HashMap();
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object put(Object obj, Object obj2) {
            return this._map.put(obj, obj2);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object get(Object obj) {
            return this._map.get(obj);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object remove(Object obj) {
            return this._map.remove(obj);
        }
    }

    static XmlDocumentProperties getDocProps(Cur cur, boolean z) {
        cur.push();
        while (cur.toParent()) {
        }
        Class cls = class$org$apache$xmlbeans$impl$store$Locale$DocProps;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.store.Locale$DocProps");
            class$org$apache$xmlbeans$impl$store$Locale$DocProps = cls;
        }
        DocProps docProps = (DocProps) cur.getBookmark(cls);
        if (docProps == null && z) {
            Class cls2 = class$org$apache$xmlbeans$impl$store$Locale$DocProps;
            if (cls2 == null) {
                cls2 = class$("org.apache.xmlbeans.impl.store.Locale$DocProps");
                class$org$apache$xmlbeans$impl$store$Locale$DocProps = cls2;
            }
            docProps = new DocProps();
            cur.setBookmark(cls2, docProps);
        }
        cur.pop();
        return docProps;
    }

    void registerForChange(ChangeListener changeListener) {
        if (changeListener.getNextChangeListener() == null) {
            ChangeListener changeListener2 = this._changeListeners;
            if (changeListener2 == null) {
                changeListener.setNextChangeListener(changeListener);
            } else {
                changeListener.setNextChangeListener(changeListener2);
            }
            this._changeListeners = changeListener;
        }
    }

    void notifyChange() {
        while (true) {
            ChangeListener changeListener = this._changeListeners;
            if (changeListener != null) {
                changeListener.notifyChange();
                ChangeListener nextChangeListener = this._changeListeners.getNextChangeListener();
                ChangeListener changeListener2 = this._changeListeners;
                if (nextChangeListener == changeListener2) {
                    changeListener2.setNextChangeListener(null);
                }
                ChangeListener nextChangeListener2 = this._changeListeners.getNextChangeListener();
                this._changeListeners.setNextChangeListener(null);
                this._changeListeners = nextChangeListener2;
            } else {
                this._locations.notifyChange();
                return;
            }
        }
    }

    static String getTextValue(Cur cur) {
        if (!$assertionsDisabled && !cur.isNode()) {
            throw new AssertionError();
        }
        if (!cur.hasChildren()) {
            return cur.getValueAsString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        cur.push();
        while (true) {
            cur.next();
            if (!cur.isAtEndOfLastPush()) {
                if (cur.isText() && ((!cur._xobj.isComment() && !cur._xobj.isProcinst()) || cur._pos >= cur._xobj._cchValue)) {
                    CharUtil.getString(stringBuffer, cur.getChars(-1), cur._offSrc, cur._cchSrc);
                }
            } else {
                cur.pop();
                return stringBuffer.toString();
            }
        }
    }

    static int getTextValue(Cur cur, int i, char[] cArr, int i2, int i3) {
        if (!$assertionsDisabled && !cur.isNode()) {
            throw new AssertionError();
        }
        String valueAsString = cur._xobj.getValueAsString(i);
        int length = valueAsString.length();
        if (length <= i3) {
            i3 = length;
        }
        if (i3 <= 0) {
            return 0;
        }
        valueAsString.getChars(0, i3, cArr, i2);
        return i3;
    }

    static String applyWhiteSpaceRule(String str, int i) {
        int i2 = 0;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return str;
        }
        int i3 = 1;
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt == '\n' || charAt == '\r' || charAt == '\t') {
                    return processWhiteSpaceRule(str, i);
                }
                i2++;
            }
            return str;
        }
        if (i != 3) {
            return str;
        }
        if (CharUtil.isWhiteSpace(str.charAt(0)) || CharUtil.isWhiteSpace(str.charAt(length - 1))) {
            return processWhiteSpaceRule(str, i);
        }
        while (i3 < length) {
            boolean isWhiteSpace = CharUtil.isWhiteSpace(str.charAt(i3));
            if (isWhiteSpace && i2 != 0) {
                return processWhiteSpaceRule(str, i);
            }
            i3++;
            i2 = isWhiteSpace ? 1 : 0;
        }
        return str;
    }

    static String processWhiteSpaceRule(String str, int i) {
        ScrubBuffer scrubBuffer = getScrubBuffer(i);
        scrubBuffer.scrub(str, 0, str.length());
        return scrubBuffer.getResultAsString();
    }

    static final class ScrubBuffer {
        private static final int NOSPACE_STATE = 2;
        private static final int SPACE_SEEN_STATE = 1;
        private static final int START_STATE = 0;
        private int _state;
        private int _wsr;
        private char[] _srcBuf = new char[1024];
        private StringBuffer _sb = new StringBuffer();

        ScrubBuffer() {
        }

        void init(int i) {
            StringBuffer stringBuffer = this._sb;
            stringBuffer.delete(0, stringBuffer.length());
            this._wsr = i;
            this._state = 0;
        }

        void scrub(Object obj, int i, int i2) {
            char[] cArr;
            if (i2 == 0) {
                return;
            }
            if (this._wsr == 1) {
                CharUtil.getString(this._sb, obj, i, i2);
                return;
            }
            if (obj instanceof char[]) {
                cArr = (char[]) obj;
            } else {
                char[] cArr2 = this._srcBuf;
                if (i2 > cArr2.length) {
                    if (i2 <= 16384) {
                        cArr2 = new char[16384];
                        this._srcBuf = cArr2;
                    } else {
                        cArr2 = new char[i2];
                    }
                }
                CharUtil.getChars(cArr2, 0, obj, i, i2);
                cArr = cArr2;
                i = 0;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                char c = cArr[i + i4];
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    this._sb.append(cArr, i + i3, i4 - i3);
                    i3 = i4 + 1;
                    if (this._wsr == 2) {
                        this._sb.append(' ');
                    } else if (this._state == 2) {
                        this._state = 1;
                    }
                } else {
                    if (this._state == 1) {
                        this._sb.append(' ');
                    }
                    this._state = 2;
                }
            }
            this._sb.append(cArr, i + i3, i2 - i3);
        }

        String getResultAsString() {
            return this._sb.toString();
        }
    }

    static ScrubBuffer getScrubBuffer(int i) {
        ScrubBuffer scrubBuffer = (ScrubBuffer) ((SoftReference) tl_scrubBuffer.get()).get();
        if (scrubBuffer == null) {
            scrubBuffer = new ScrubBuffer();
            tl_scrubBuffer.set(new SoftReference(scrubBuffer));
        }
        scrubBuffer.init(i);
        return scrubBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0022, code lost:
    
        r3.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0026, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean pushToContainer(org.apache.xmlbeans.impl.store.Cur r3) {
        /*
            r3.push()
        L3:
            int r0 = r3.kind()
            r1 = -2
            if (r0 == r1) goto L22
            r1 = -1
            if (r0 == r1) goto L22
            r1 = 1
            if (r0 == r1) goto L21
            r2 = 2
            if (r0 == r2) goto L21
            r1 = 4
            if (r0 == r1) goto L1d
            r1 = 5
            if (r0 == r1) goto L1d
            r3.nextWithAttrs()
            goto L3
        L1d:
            r3.skip()
            goto L3
        L21:
            return r1
        L22:
            r3.pop()
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.pushToContainer(org.apache.xmlbeans.impl.store.Cur):boolean");
    }

    static boolean toFirstNormalAttr(Cur cur) {
        cur.push();
        if (cur.toFirstAttr()) {
            while (cur.isXmlns()) {
                if (!cur.toNextAttr()) {
                }
            }
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    static boolean toPrevNormalAttr(Cur cur) {
        if (!cur.isAttr()) {
            return false;
        }
        cur.push();
        do {
            if (!$assertionsDisabled && !cur.isAttr()) {
                throw new AssertionError();
            }
            if (cur.prev()) {
                cur.prev();
                if (!cur.isAttr()) {
                    cur.prev();
                }
            } else {
                cur.pop();
                return false;
            }
        } while (!cur.isNormalAttr());
        cur.popButStay();
        return true;
    }

    static boolean toNextNormalAttr(Cur cur) {
        cur.push();
        while (cur.toNextAttr()) {
            if (!cur.isXmlns()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return false;
    }

    Xobj findNthChildElem(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
        boolean z = $assertionsDisabled;
        if (!z && qName != null && qNameSet != null) {
            throw new AssertionError();
        }
        if (!z && i < 0) {
            throw new AssertionError();
        }
        if (xobj == null) {
            return null;
        }
        int distance = this._nthCache_A.distance(xobj, qName, qNameSet, i);
        int distance2 = this._nthCache_B.distance(xobj, qName, qNameSet, i);
        Xobj fetch = (distance <= distance2 ? this._nthCache_A : this._nthCache_B).fetch(xobj, qName, qNameSet, i);
        if (distance == distance2) {
            nthCache nthcache = this._nthCache_A;
            this._nthCache_A = this._nthCache_B;
            this._nthCache_B = nthcache;
        }
        return fetch;
    }

    int count(Xobj xobj, QName qName, QNameSet qNameSet) {
        int i = 0;
        for (Xobj findNthChildElem = findNthChildElem(xobj, qName, qNameSet, 0); findNthChildElem != null; findNthChildElem = findNthChildElem._nextSibling) {
            if (findNthChildElem.isElem()) {
                if (qNameSet == null) {
                    if (!findNthChildElem._name.equals(qName)) {
                    }
                    i++;
                } else {
                    if (!qNameSet.contains(findNthChildElem._name)) {
                    }
                    i++;
                }
            }
        }
        return i;
    }

    static boolean toChild(Cur cur, QName qName, int i) {
        if (i < 0 || !pushToContainer(cur)) {
            return false;
        }
        Xobj findNthChildElem = cur._locale.findNthChildElem(cur._xobj, qName, null, i);
        cur.pop();
        if (findNthChildElem == null) {
            return false;
        }
        cur.moveTo(findNthChildElem);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x003b, code lost:
    
        r6.moveTo(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x003e, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean toFirstChildElement(org.apache.xmlbeans.impl.store.Cur r6) {
        /*
            org.apache.xmlbeans.impl.store.Xobj r0 = r6._xobj
            int r1 = r6._pos
        L4:
            int r2 = r6.kind()
            r3 = -2
            r4 = 0
            if (r2 == r3) goto L3b
            r3 = -1
            if (r2 == r3) goto L3b
            r3 = 1
            if (r2 == r3) goto L23
            r5 = 2
            if (r2 == r5) goto L23
            r3 = 4
            if (r2 == r3) goto L1f
            r3 = 5
            if (r2 == r3) goto L1f
            r6.nextWithAttrs()
            goto L4
        L1f:
            r6.skip()
            goto L4
        L23:
            boolean r2 = r6.toFirstChild()
            if (r2 == 0) goto L37
            boolean r2 = r6.isElem()
            if (r2 != 0) goto L36
            boolean r2 = toNextSiblingElement(r6)
            if (r2 != 0) goto L36
            goto L37
        L36:
            return r3
        L37:
            r6.moveTo(r0, r1)
            return r4
        L3b:
            r6.moveTo(r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.toFirstChildElement(org.apache.xmlbeans.impl.store.Cur):boolean");
    }

    static boolean toLastChildElement(Cur cur) {
        if (!pushToContainer(cur)) {
            return false;
        }
        if (!cur.toLastChild() || (!cur.isElem() && !toPrevSiblingElement(cur))) {
            cur.pop();
            return false;
        }
        cur.popButStay();
        return true;
    }

    static boolean toPrevSiblingElement(Cur cur) {
        int kind;
        boolean z = false;
        if (!cur.hasParent()) {
            return false;
        }
        Cur tempCur = cur.tempCur();
        if (tempCur.kind() != 3) {
            while (true) {
                if (!tempCur.prev() || (kind = tempCur.kind()) == 1 || kind == 2) {
                    break;
                }
                if (tempCur.kind() == -2) {
                    tempCur.toParent();
                    cur.moveToCur(tempCur);
                    z = true;
                    break;
                }
            }
        }
        tempCur.release();
        return z;
    }

    static boolean toNextSiblingElement(Cur cur) {
        if (!cur.hasParent()) {
            return false;
        }
        cur.push();
        int kind = cur.kind();
        if (kind == 3) {
            cur.toParent();
            cur.next();
        } else if (kind == 2) {
            cur.skip();
        }
        while (true) {
            int kind2 = cur.kind();
            if (kind2 < 0) {
                cur.pop();
                return false;
            }
            if (kind2 == 2) {
                cur.popButStay();
                return true;
            }
            if (kind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    static boolean toNextSiblingElement(Cur cur, Xobj xobj) {
        Xobj xobj2 = cur._xobj;
        int i = cur._pos;
        int kind = cur.kind();
        if (kind == 3) {
            cur.moveTo(xobj);
            cur.next();
        } else if (kind == 2) {
            cur.skip();
        }
        while (true) {
            int kind2 = cur.kind();
            if (kind2 < 0) {
                cur.moveTo(xobj2, i);
                return false;
            }
            if (kind2 == 2) {
                return true;
            }
            if (kind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    static void applyNamespaces(Cur cur, Map map) {
        if (!$assertionsDisabled && !cur.isContainer()) {
            throw new AssertionError();
        }
        for (String str : map.keySet()) {
            if (!str.toLowerCase().startsWith("xml") && cur.namespaceForPrefix(str, false) == null) {
                cur.push();
                cur.next();
                cur.createAttr(cur._locale.createXmlns(str));
                cur.next();
                cur.insertString((String) map.get(str));
                cur.pop();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        r5 = new java.util.HashMap();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.Map getAllNamespaces(org.apache.xmlbeans.impl.store.Cur r4, java.util.Map r5) {
        /*
            boolean r0 = org.apache.xmlbeans.impl.store.Locale.$assertionsDisabled
            if (r0 != 0) goto L11
            boolean r1 = r4.isNode()
            if (r1 == 0) goto Lb
            goto L11
        Lb:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L11:
            r4.push()
            boolean r1 = r4.isContainer()
            if (r1 != 0) goto L1d
            r4.toParent()
        L1d:
            if (r0 != 0) goto L2c
            boolean r0 = r4.isContainer()
            if (r0 == 0) goto L26
            goto L2c
        L26:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L2c:
            aavax.xml.namespace.QName r0 = r4.getName()
        L30:
            boolean r1 = r4.toNextAttr()
            if (r1 == 0) goto L6e
            boolean r1 = r4.isXmlns()
            if (r1 == 0) goto L30
            java.lang.String r1 = r4.getXmlnsPrefix()
            java.lang.String r2 = r4.getXmlnsUri()
            int r3 = r1.length()
            if (r3 != 0) goto L5d
            int r3 = r2.length()
            if (r3 <= 0) goto L5d
            if (r0 == 0) goto L5d
            java.lang.String r3 = r0.getNamespaceURI()
            int r3 = r3.length()
            if (r3 <= 0) goto L5d
            goto L30
        L5d:
            if (r5 != 0) goto L64
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
        L64:
            boolean r3 = r5.containsKey(r1)
            if (r3 != 0) goto L30
            r5.put(r1, r2)
            goto L30
        L6e:
            boolean r0 = r4.isContainer()
            if (r0 != 0) goto L77
            r4.toParentRaw()
        L77:
            boolean r0 = r4.toParentRaw()
            if (r0 != 0) goto L2c
            r4.pop()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.getAllNamespaces(org.apache.xmlbeans.impl.store.Cur, java.util.Map):java.util.Map");
    }

    class nthCache {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Xobj _child;
        private int _n;
        private QName _name;
        private Xobj _parent;
        private QNameSet _set;
        private long _version;

        private boolean setsSame(QNameSet qNameSet, QNameSet qNameSet2) {
            return qNameSet != null && qNameSet == qNameSet2;
        }

        static {
            if (Locale.class$org$apache$xmlbeans$impl$store$Locale == null) {
                Locale.class$org$apache$xmlbeans$impl$store$Locale = Locale.class$("org.apache.xmlbeans.impl.store.Locale");
            } else {
                Class cls = Locale.class$org$apache$xmlbeans$impl$store$Locale;
            }
            $assertionsDisabled = true;
        }

        nthCache() {
        }

        private boolean namesSame(QName qName, QName qName2) {
            return qName == null || qName.equals(qName2);
        }

        private boolean nameHit(QName qName, QNameSet qNameSet, QName qName2) {
            return qNameSet == null ? namesSame(qName, qName2) : qNameSet.contains(qName2);
        }

        private boolean cacheSame(QName qName, QNameSet qNameSet) {
            return qNameSet == null ? namesSame(qName, this._name) : setsSame(qNameSet, this._set);
        }

        int distance(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (xobj != this._parent || !cacheSame(qName, qNameSet)) {
                return Integer.MAX_VALUE;
            }
            int i2 = this._n;
            return i > i2 ? i - i2 : i2 - i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
        
            r4._child = r5;
            r4._n++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
        
            r4._child = r5;
            r4._n--;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        org.apache.xmlbeans.impl.store.Xobj fetch(org.apache.xmlbeans.impl.store.Xobj r5, aavax.xml.namespace.QName r6, org.apache.xmlbeans.QNameSet r7, int r8) {
            /*
                r4 = this;
                boolean r0 = org.apache.xmlbeans.impl.store.Locale.nthCache.$assertionsDisabled
                if (r0 != 0) goto Ld
                if (r8 < 0) goto L7
                goto Ld
            L7:
                java.lang.AssertionError r5 = new java.lang.AssertionError
                r5.<init>()
                throw r5
            Ld:
                long r0 = r4._version
                org.apache.xmlbeans.impl.store.Locale r2 = org.apache.xmlbeans.impl.store.Locale.this
                long r2 = r2.version()
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                r1 = 0
                if (r0 != 0) goto L26
                org.apache.xmlbeans.impl.store.Xobj r0 = r4._parent
                if (r0 != r5) goto L26
                boolean r0 = r4.cacheSame(r6, r7)
                if (r0 == 0) goto L26
                if (r8 != 0) goto L52
            L26:
                org.apache.xmlbeans.impl.store.Locale r0 = org.apache.xmlbeans.impl.store.Locale.this
                long r2 = r0.version()
                r4._version = r2
                r4._parent = r5
                r4._name = r6
                r4._child = r1
                r0 = -1
                r4._n = r0
                org.apache.xmlbeans.impl.store.Xobj r5 = r5._firstChild
            L39:
                if (r5 == 0) goto L52
                boolean r0 = r5.isElem()
                if (r0 == 0) goto L4f
                aavax.xml.namespace.QName r0 = r5._name
                boolean r0 = r4.nameHit(r6, r7, r0)
                if (r0 == 0) goto L4f
                r4._child = r5
                r5 = 0
                r4._n = r5
                goto L52
            L4f:
                org.apache.xmlbeans.impl.store.Xobj r5 = r5._nextSibling
                goto L39
            L52:
                int r5 = r4._n
                if (r5 >= 0) goto L57
                return r1
            L57:
                if (r8 <= r5) goto L7b
            L59:
                int r5 = r4._n
                if (r8 <= r5) goto L9f
                org.apache.xmlbeans.impl.store.Xobj r5 = r4._child
            L5f:
                org.apache.xmlbeans.impl.store.Xobj r5 = r5._nextSibling
                if (r5 != 0) goto L64
                return r1
            L64:
                boolean r0 = r5.isElem()
                if (r0 == 0) goto L5f
                aavax.xml.namespace.QName r0 = r5._name
                boolean r0 = r4.nameHit(r6, r7, r0)
                if (r0 == 0) goto L5f
                r4._child = r5
                int r5 = r4._n
                int r5 = r5 + 1
                r4._n = r5
                goto L59
            L7b:
                if (r8 >= r5) goto L9f
            L7d:
                int r5 = r4._n
                if (r8 >= r5) goto L9f
                org.apache.xmlbeans.impl.store.Xobj r5 = r4._child
            L83:
                org.apache.xmlbeans.impl.store.Xobj r5 = r5._prevSibling
                if (r5 != 0) goto L88
                return r1
            L88:
                boolean r0 = r5.isElem()
                if (r0 == 0) goto L83
                aavax.xml.namespace.QName r0 = r5._name
                boolean r0 = r4.nameHit(r6, r7, r0)
                if (r0 == 0) goto L83
                r4._child = r5
                int r5 = r4._n
                int r5 = r5 + (-1)
                r4._n = r5
                goto L7d
            L9f:
                org.apache.xmlbeans.impl.store.Xobj r5 = r4._child
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Locale.nthCache.fetch(org.apache.xmlbeans.impl.store.Xobj, aavax.xml.namespace.QName, org.apache.xmlbeans.QNameSet, int):org.apache.xmlbeans.impl.store.Xobj");
        }
    }

    DomImpl.Dom findDomNthChild(DomImpl.Dom dom, int i) {
        DomImpl.Dom fetch;
        if (!$assertionsDisabled && i < 0) {
            throw new AssertionError();
        }
        if (dom == null) {
            return null;
        }
        int distance = this._domNthCache_A.distance(dom, i);
        int distance2 = this._domNthCache_B.distance(dom, i);
        boolean z = distance2 - (this._domNthCache_B._len / 2) > 0 && (distance2 - (this._domNthCache_B._len / 2)) + (-40) > 0;
        boolean z2 = distance - (this._domNthCache_A._len / 2) > 0 && (distance - (this._domNthCache_A._len / 2)) + (-40) > 0;
        if (distance <= distance2) {
            if (!z2) {
                fetch = this._domNthCache_A.fetch(dom, i);
            } else {
                this._domNthCache_B._version = -1L;
                fetch = this._domNthCache_B.fetch(dom, i);
            }
        } else if (!z) {
            fetch = this._domNthCache_B.fetch(dom, i);
        } else {
            this._domNthCache_A._version = -1L;
            fetch = this._domNthCache_A.fetch(dom, i);
        }
        if (distance == distance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return fetch;
    }

    int domLength(DomImpl.Dom dom) {
        if (dom == null) {
            return 0;
        }
        int distance = this._domNthCache_A.distance(dom, 0);
        int distance2 = this._domNthCache_B.distance(dom, 0);
        int length = (distance <= distance2 ? this._domNthCache_A : this._domNthCache_B).length(dom);
        if (distance == distance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return length;
    }

    void invalidateDomCaches(DomImpl.Dom dom) {
        if (this._domNthCache_A._parent == dom) {
            this._domNthCache_A._version = -1L;
        }
        if (this._domNthCache_B._parent == dom) {
            this._domNthCache_B._version = -1L;
        }
    }

    boolean isDomCached(DomImpl.Dom dom) {
        return this._domNthCache_A._parent == dom || this._domNthCache_B._parent == dom;
    }

    class domNthCache {
        static final /* synthetic */ boolean $assertionsDisabled;
        public static final int BLITZ_BOUNDARY = 40;
        private DomImpl.Dom _child;
        private int _len;
        private int _n;
        private DomImpl.Dom _parent;
        private long _version;

        static {
            if (Locale.class$org$apache$xmlbeans$impl$store$Locale == null) {
                Locale.class$org$apache$xmlbeans$impl$store$Locale = Locale.class$("org.apache.xmlbeans.impl.store.Locale");
            } else {
                Class cls = Locale.class$org$apache$xmlbeans$impl$store$Locale;
            }
            $assertionsDisabled = true;
        }

        domNthCache() {
        }

        int distance(DomImpl.Dom dom, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (dom != this._parent) {
                return Integer.MAX_VALUE;
            }
            int i2 = this._n;
            return i > i2 ? i - i2 : i2 - i;
        }

        int length(DomImpl.Dom dom) {
            int i;
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
            }
            if (this._len == -1) {
                DomImpl.Dom dom2 = this._child;
                if (dom2 != null && (i = this._n) != -1) {
                    this._len = i;
                } else {
                    dom2 = DomImpl.firstChild(this._parent);
                    this._len = 0;
                    this._child = dom2;
                    this._n = 0;
                }
                while (dom2 != null) {
                    this._len++;
                    dom2 = DomImpl.nextSibling(dom2);
                }
            }
            return this._len;
        }

        DomImpl.Dom fetch(DomImpl.Dom dom, int i) {
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
                DomImpl.Dom firstChild = DomImpl.firstChild(this._parent);
                while (true) {
                    if (firstChild == null) {
                        break;
                    }
                    int i2 = this._n + 1;
                    this._n = i2;
                    if (this._child != null || i != i2) {
                        firstChild = DomImpl.nextSibling(firstChild);
                    } else {
                        this._child = firstChild;
                        break;
                    }
                }
                return this._child;
            }
            int i3 = this._n;
            if (i3 < 0) {
                return null;
            }
            if (i > i3) {
                while (i > this._n) {
                    DomImpl.Dom nextSibling = DomImpl.nextSibling(this._child);
                    if (nextSibling == null) {
                        return null;
                    }
                    this._child = nextSibling;
                    this._n++;
                }
            } else if (i < i3) {
                while (i < this._n) {
                    DomImpl.Dom prevSibling = DomImpl.prevSibling(this._child);
                    if (prevSibling == null) {
                        return null;
                    }
                    this._child = prevSibling;
                    this._n--;
                }
            }
            return this._child;
        }
    }

    CharUtil getCharUtil() {
        if (this._charUtil == null) {
            this._charUtil = new CharUtil(1024);
        }
        return this._charUtil;
    }

    long version() {
        return this._versionAll;
    }

    Cur weakCur(Object obj) {
        boolean z = $assertionsDisabled;
        if (!z && (obj == null || (obj instanceof Ref))) {
            throw new AssertionError();
        }
        Cur cur = getCur();
        if (!z && cur._tempFrame != -1) {
            throw new AssertionError();
        }
        if (!z && cur._ref != null) {
            throw new AssertionError();
        }
        cur._ref = new Ref(cur, obj);
        return cur;
    }

    final ReferenceQueue refQueue() {
        if (this._refQueue == null) {
            this._refQueue = new ReferenceQueue();
        }
        return this._refQueue;
    }

    static final class Ref extends PhantomReference {
        Cur _cur;

        Ref(Cur cur, Object obj) {
            super(obj, cur._locale.refQueue());
            this._cur = cur;
        }
    }

    Cur tempCur() {
        return tempCur(null);
    }

    Cur tempCur(String str) {
        Cur cur = getCur();
        boolean z = $assertionsDisabled;
        if (!z && cur._tempFrame != -1) {
            throw new AssertionError();
        }
        if (!z && this._numTempFramesLeft >= this._tempFrames.length) {
            throw new AssertionError("Temp frame not pushed");
        }
        Cur[] curArr = this._tempFrames;
        int length = (curArr.length - this._numTempFramesLeft) - 1;
        if (!z && (length < 0 || length >= curArr.length)) {
            throw new AssertionError();
        }
        Cur cur2 = curArr[length];
        cur._nextTemp = cur2;
        if (!z && cur._prevTemp != null) {
            throw new AssertionError();
        }
        if (cur2 != null) {
            if (!z && cur2._prevTemp != null) {
                throw new AssertionError();
            }
            cur2._prevTemp = cur;
        }
        this._tempFrames[length] = cur;
        cur._tempFrame = length;
        cur._id = str;
        return cur;
    }

    Cur getCur() {
        boolean z = $assertionsDisabled;
        if (!z && this._curPool != null && this._curPoolCount <= 0) {
            throw new AssertionError();
        }
        Cur cur = this._curPool;
        if (cur == null) {
            cur = new Cur(this);
        } else {
            this._curPool = cur.listRemove(cur);
            this._curPoolCount--;
        }
        if (!z && cur._state != 0) {
            throw new AssertionError();
        }
        if (!z && (cur._prev != null || cur._next != null)) {
            throw new AssertionError();
        }
        if (!z && (cur._xobj != null || cur._pos != -2)) {
            throw new AssertionError();
        }
        if (!z && cur._ref != null) {
            throw new AssertionError();
        }
        this._registered = cur.listInsert(this._registered);
        cur._state = 1;
        return cur;
    }

    void embedCurs() {
        while (true) {
            Cur cur = this._registered;
            if (cur == null) {
                return;
            }
            if (!$assertionsDisabled && cur._xobj == null) {
                throw new AssertionError();
            }
            this._registered = cur.listRemove(this._registered);
            cur._xobj._embedded = cur.listInsert(cur._xobj._embedded);
            cur._state = 2;
        }
    }

    DomImpl.TextNode createTextNode() {
        return this._saaj == null ? new DomImpl.TextNode(this) : new DomImpl.SaajTextNode(this);
    }

    DomImpl.CdataNode createCdataNode() {
        return this._saaj == null ? new DomImpl.CdataNode(this) : new DomImpl.SaajCdataNode(this);
    }

    boolean entered() {
        return this._tempFrames.length - this._numTempFramesLeft > 0;
    }

    public void enter(Locale locale) {
        enter();
        if (locale != this) {
            locale.enter();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void enter() {
        if (!$assertionsDisabled && this._numTempFramesLeft < 0) {
            throw new AssertionError();
        }
        int i = this._numTempFramesLeft - 1;
        this._numTempFramesLeft = i;
        if (i <= 0) {
            Cur[] curArr = this._tempFrames;
            int length = curArr.length;
            this._numTempFramesLeft = length;
            Cur[] curArr2 = new Cur[length * 2];
            System.arraycopy(curArr, 0, curArr2, 0, curArr.length);
            this._tempFrames = curArr2;
        }
        int i2 = this._entryCount + 1;
        this._entryCount = i2;
        if (i2 > 1000) {
            pollQueue();
            this._entryCount = 0;
        }
    }

    private void pollQueue() {
        if (this._refQueue == null) {
            return;
        }
        while (true) {
            Ref ref = (Ref) this._refQueue.poll();
            if (ref == null) {
                return;
            }
            if (ref._cur != null) {
                ref._cur.release();
            }
        }
    }

    public void exit(Locale locale) {
        exit();
        if (locale != this) {
            locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void exit() {
        int i;
        if (!$assertionsDisabled && ((i = this._numTempFramesLeft) < 0 || i > this._tempFrames.length - 1)) {
            throw new AssertionError(new StringBuffer().append(" Temp frames mismanaged. Impossible stack frame. Unsynchronized: ").append(noSync()).toString());
        }
        int length = this._tempFrames.length;
        int i2 = this._numTempFramesLeft + 1;
        this._numTempFramesLeft = i2;
        int i3 = length - i2;
        while (true) {
            Cur[] curArr = this._tempFrames;
            if (curArr[i3] == null) {
                return;
            } else {
                curArr[i3].release();
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean noSync() {
        return this._noSync;
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean sync() {
        return !this._noSync;
    }

    static final boolean isWhiteSpace(String str) {
        int length = str.length();
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(str.charAt(i))) {
                return false;
            }
            length = i;
        }
    }

    static final boolean isWhiteSpace(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(stringBuffer.charAt(i))) {
                return false;
            }
            length = i;
        }
    }

    static boolean beginsWithXml(String str) {
        char charAt;
        char charAt2;
        if (str.length() < 3) {
            return false;
        }
        char charAt3 = str.charAt(0);
        return (charAt3 == 'x' || charAt3 == 'X') && ((charAt = str.charAt(1)) == 'm' || charAt == 'M') && ((charAt2 = str.charAt(2)) == 'l' || charAt2 == 'L');
    }

    static boolean isXmlns(QName qName) {
        String prefix = qName.getPrefix();
        if (prefix.equals("xmlns")) {
            return true;
        }
        return prefix.length() == 0 && qName.getLocalPart().equals("xmlns");
    }

    QName createXmlns(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() == 0 ? makeQName("http://www.w3.org/2000/xmlns/", "xmlns", "") : makeQName("http://www.w3.org/2000/xmlns/", str, "xmlns");
    }

    static String xmlnsPrefix(QName qName) {
        return qName.getPrefix().equals("xmlns") ? qName.getLocalPart() : "";
    }

    static abstract class LoadContext {
        private Hashtable _idAttrs;

        protected abstract void abort();

        protected abstract void attr(QName qName, String str);

        protected abstract void attr(String str, String str2, String str3, String str4);

        protected abstract void bookmark(XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void comment(String str);

        protected abstract void comment(char[] cArr, int i, int i2);

        protected abstract void endDTD();

        protected abstract void endElement();

        protected abstract Cur finish();

        protected abstract void lineNumber(int i, int i2, int i3);

        protected abstract void procInst(String str, String str2);

        protected abstract void startDTD(String str, String str2, String str3);

        protected abstract void startElement(QName qName);

        protected abstract void text(String str);

        protected abstract void text(char[] cArr, int i, int i2);

        protected abstract void xmlns(String str, String str2);

        LoadContext() {
        }

        protected void addIdAttr(String str, String str2) {
            if (this._idAttrs == null) {
                this._idAttrs = new Hashtable();
            }
            this._idAttrs.put(str2, str);
        }

        protected boolean isAttrOfTypeId(QName qName, QName qName2) {
            if (this._idAttrs == null) {
                return false;
            }
            String prefix = qName.getPrefix();
            String localPart = qName.getLocalPart();
            if (!"".equals(prefix)) {
                localPart = new StringBuffer().append(prefix).append(":").append(localPart).toString();
            }
            String str = (String) this._idAttrs.get(localPart);
            if (str == null) {
                return false;
            }
            String prefix2 = qName2.getPrefix();
            qName2.getLocalPart();
            String localPart2 = qName2.getLocalPart();
            if (!"".equals(prefix2)) {
                localPart2 = new StringBuffer().append(prefix2).append(":").append(localPart2).toString();
            }
            return str.equals(localPart2);
        }
    }

    private static class DefaultEntityResolver implements EntityResolver {
        private DefaultEntityResolver() {
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            return new InputSource(new StringReader(""));
        }
    }

    private static SaxLoader getPiccoloSaxLoader() {
        SaxLoader saxLoader = (SaxLoader) SystemCache.get().getSaxLoader();
        if (saxLoader != null) {
            return saxLoader;
        }
        PiccoloSaxLoader newInstance = PiccoloSaxLoader.newInstance();
        SystemCache.get().setSaxLoader(newInstance);
        return newInstance;
    }

    private static SaxLoader getSaxLoader(XmlOptions xmlOptions) {
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        EntityResolver entityResolver = null;
        byte b = 0;
        if (!maskNull.hasOption(XmlOptions.LOAD_USE_DEFAULT_RESOLVER)) {
            EntityResolver entityResolver2 = (EntityResolver) maskNull.get(XmlOptions.ENTITY_RESOLVER);
            if (entityResolver2 == null) {
                entityResolver2 = ResolverUtil.getGlobalEntityResolver();
            }
            if (entityResolver2 == null) {
                entityResolver2 = new DefaultEntityResolver();
            }
            entityResolver = entityResolver2;
        }
        if (maskNull.hasOption(XmlOptions.LOAD_USE_XMLREADER)) {
            XMLReader xMLReader = (XMLReader) maskNull.get(XmlOptions.LOAD_USE_XMLREADER);
            if (xMLReader == null) {
                throw new IllegalArgumentException("XMLReader is null");
            }
            XmlReaderSaxLoader xmlReaderSaxLoader = new XmlReaderSaxLoader(xMLReader);
            if (entityResolver == null) {
                return xmlReaderSaxLoader;
            }
            xMLReader.setEntityResolver(entityResolver);
            return xmlReaderSaxLoader;
        }
        SaxLoader piccoloSaxLoader = getPiccoloSaxLoader();
        piccoloSaxLoader.setEntityResolver(entityResolver);
        return piccoloSaxLoader;
    }

    private static class XmlReaderSaxLoader extends SaxLoader {
        XmlReaderSaxLoader(XMLReader xMLReader) {
            super(xMLReader, null);
        }
    }

    private static class PiccoloSaxLoader extends SaxLoader {
        private Piccolo _piccolo;

        private PiccoloSaxLoader(Piccolo piccolo) {
            super(piccolo, piccolo.getStartLocator());
            this._piccolo = piccolo;
        }

        static PiccoloSaxLoader newInstance() {
            return new PiccoloSaxLoader(new Piccolo());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.SaxLoader
        void postLoad(Cur cur) {
            XmlDocumentProperties docProps = Locale.getDocProps(cur, true);
            docProps.setEncoding(this._piccolo.getEncoding());
            docProps.setVersion(this._piccolo.getVersion());
            super.postLoad(cur);
        }
    }

    private static abstract class SaxHandler implements ContentHandler, LexicalHandler, DeclHandler, DTDHandler {
        static final /* synthetic */ boolean $assertionsDisabled;
        protected LoadContext _context;
        private int _entityBytes;
        private int _entityBytesLimit;
        private boolean _insideCDATA;
        private int _insideEntity;
        protected Locale _locale;
        private Locator _startLocator;
        private boolean _wantCdataBookmarks;
        private boolean _wantLineNumbers;
        private boolean _wantLineNumbersAtEndElt;

        @Override // org.xml.sax.ext.DeclHandler
        public void elementDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) throws SAXException {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void externalEntityDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void internalEntityDecl(String str, String str2) {
        }

        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }

        static {
            if (Locale.class$org$apache$xmlbeans$impl$store$Locale == null) {
                Locale.class$org$apache$xmlbeans$impl$store$Locale = Locale.class$("org.apache.xmlbeans.impl.store.Locale");
            } else {
                Class cls = Locale.class$org$apache$xmlbeans$impl$store$Locale;
            }
            $assertionsDisabled = true;
        }

        SaxHandler(Locator locator) {
            this._insideCDATA = false;
            this._entityBytesLimit = 10240;
            this._entityBytes = 0;
            this._insideEntity = 0;
            this._startLocator = locator;
        }

        SaxHandler() {
            this(null);
        }

        void initSaxHandler(Locale locale, XmlOptions xmlOptions) {
            this._locale = locale;
            XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
            this._context = new Cur.CurLoadContext(this._locale, maskNull);
            this._wantLineNumbers = this._startLocator != null && maskNull.hasOption(XmlOptions.LOAD_LINE_NUMBERS);
            this._wantLineNumbersAtEndElt = this._startLocator != null && maskNull.hasOption(XmlOptions.LOAD_LINE_NUMBERS_END_ELEMENT);
            this._wantCdataBookmarks = this._startLocator != null && maskNull.hasOption(XmlOptions.LOAD_SAVE_CDATA_BOOKMARKS);
            if (maskNull.hasOption(XmlOptions.LOAD_ENTITY_BYTES_LIMIT)) {
                this._entityBytesLimit = ((Integer) maskNull.get(XmlOptions.LOAD_ENTITY_BYTES_LIMIT)).intValue();
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            str2.length();
            if (str3.indexOf(58) >= 0 && str.length() == 0) {
                XmlError forMessage = XmlError.forMessage(new StringBuffer().append("Use of undefined namespace prefix: ").append(str3.substring(0, str3.indexOf(58))).toString());
                throw new XmlRuntimeException(forMessage.toString(), (Throwable) null, forMessage);
            }
            this._context.startElement(this._locale.makeQualifiedQName(str, str3));
            if (this._wantLineNumbers) {
                this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                String qName = attributes.getQName(i);
                if (qName.equals("xmlns")) {
                    this._context.xmlns("", attributes.getValue(i));
                } else if (qName.startsWith(Sax2Dom.XMLNS_STRING)) {
                    String substring = qName.substring(6);
                    if (substring.length() == 0) {
                        XmlError forMessage2 = XmlError.forMessage("Prefix not specified", 0);
                        throw new XmlRuntimeException(forMessage2.toString(), (Throwable) null, forMessage2);
                    }
                    String value = attributes.getValue(i);
                    if (value.length() == 0) {
                        XmlError forMessage3 = XmlError.forMessage(new StringBuffer().append("Prefix can't be mapped to no namespace: ").append(substring).toString(), 0);
                        throw new XmlRuntimeException(forMessage3.toString(), (Throwable) null, forMessage3);
                    }
                    this._context.xmlns(substring, value);
                } else {
                    int indexOf = qName.indexOf(58);
                    if (indexOf < 0) {
                        this._context.attr(qName, attributes.getURI(i), null, attributes.getValue(i));
                    } else {
                        this._context.attr(qName.substring(indexOf + 1), attributes.getURI(i), qName.substring(0, indexOf), attributes.getValue(i));
                    }
                }
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            this._context.endElement();
            if (this._wantLineNumbersAtEndElt) {
                this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            this._context.text(cArr, i, i2);
            if (this._wantCdataBookmarks && this._insideCDATA) {
                this._context.bookmarkLastNonAttr(CDataBookmark.CDATA_BOOKMARK);
            }
            if (this._insideEntity != 0) {
                int i3 = this._entityBytes + i2;
                this._entityBytes = i3;
                if (i3 > this._entityBytesLimit) {
                    throw new SAXException(XmlError.forMessage(XmlErrorCodes.EXCEPTION_EXCEEDED_ENTITY_BYTES, new Integer[]{new Integer(this._entityBytesLimit)}).getMessage());
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] cArr, int i, int i2) throws SAXException {
            this._context.comment(cArr, i, i2);
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            this._context.procInst(str, str2);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String str, String str2, String str3) throws SAXException {
            this._context.startDTD(str, str2, str3);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() throws SAXException {
            this._context.endDTD();
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws SAXException {
            if (Locale.beginsWithXml(str)) {
                if ("xml".equals(str) && "http://www.w3.org/XML/1998/namespace".equals(str2)) {
                    return;
                }
                XmlError forMessage = XmlError.forMessage(new StringBuffer().append("Prefix can't begin with XML: ").append(str).toString(), 0);
                throw new XmlRuntimeException(forMessage.toString(), (Throwable) null, forMessage);
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() throws SAXException {
            this._insideCDATA = true;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() throws SAXException {
            this._insideCDATA = false;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String str) throws SAXException {
            this._insideEntity++;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String str) throws SAXException {
            int i = this._insideEntity - 1;
            this._insideEntity = i;
            if (!$assertionsDisabled && i < 0) {
                throw new AssertionError();
            }
            if (i == 0) {
                this._entityBytes = 0;
            }
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void attributeDecl(String str, String str2, String str3, String str4, String str5) {
            if (str3.equals("ID")) {
                this._context.addIdAttr(str, str2);
            }
        }
    }

    private static abstract class SaxLoader extends SaxHandler implements ErrorHandler {
        private XMLReader _xr;

        SaxLoader(XMLReader xMLReader, Locator locator) {
            super(locator);
            this._xr = xMLReader;
            try {
                xMLReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
                this._xr.setFeature("http://xml.org/sax/features/namespaces", true);
                this._xr.setFeature("http://xml.org/sax/features/validation", false);
                this._xr.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                this._xr.setContentHandler(this);
                this._xr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
                this._xr.setDTDHandler(this);
                this._xr.setErrorHandler(this);
            } catch (Throwable th) {
                throw new RuntimeException(th.getMessage(), th);
            }
        }

        void setEntityResolver(EntityResolver entityResolver) {
            this._xr.setEntityResolver(entityResolver);
        }

        void postLoad(Cur cur) {
            this._locale = null;
            this._context = null;
        }

        public Cur load(Locale locale, InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
            inputSource.setSystemId("file://");
            initSaxHandler(locale, xmlOptions);
            try {
                this._xr.parse(inputSource);
                Cur finish = this._context.finish();
                Locale.associateSourceName(finish, xmlOptions);
                postLoad(finish);
                return finish;
            } catch (XmlRuntimeException e) {
                this._context.abort();
                throw new XmlException(e);
            } catch (RuntimeException e2) {
                this._context.abort();
                throw e2;
            } catch (FileFormatException e3) {
                this._context.abort();
                throw new XmlException(e3.getMessage(), e3);
            } catch (SAXParseException e4) {
                this._context.abort();
                XmlError forLocation = XmlError.forLocation(e4.getMessage(), (String) XmlOptions.safeGet(xmlOptions, XmlOptions.DOCUMENT_SOURCE_NAME), e4.getLineNumber(), e4.getColumnNumber(), -1);
                throw new XmlException(forLocation.toString(), e4, forLocation);
            } catch (SAXException e5) {
                this._context.abort();
                XmlError forMessage = XmlError.forMessage(e5.getMessage());
                throw new XmlException(forMessage.toString(), e5, forMessage);
            }
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }
    }

    private DomImpl.Dom load(InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
        return getSaxLoader(xmlOptions).load(this, inputSource, xmlOptions).getDom();
    }

    public DomImpl.Dom load(Reader reader) throws XmlException, IOException {
        return load(reader, (XmlOptions) null);
    }

    public DomImpl.Dom load(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
        return load(new InputSource(reader), xmlOptions);
    }

    public DomImpl.Dom load(InputStream inputStream) throws XmlException, IOException {
        return load(inputStream, (XmlOptions) null);
    }

    public DomImpl.Dom load(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
        return load(new InputSource(inputStream), xmlOptions);
    }

    public DomImpl.Dom load(String str) throws XmlException {
        return load(str, (XmlOptions) null);
    }

    public DomImpl.Dom load(String str, XmlOptions xmlOptions) throws XmlException {
        StringReader stringReader = new StringReader(str);
        try {
            try {
                return load(stringReader, xmlOptions);
            } catch (IOException e) {
                if ($assertionsDisabled) {
                    throw new XmlException(e.getMessage(), e);
                }
                throw new AssertionError("StringReader should not throw IOException");
            }
        } finally {
            try {
                stringReader.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String str, String str2, DocumentType documentType) {
        return DomImpl._domImplementation_createDocument(this, str, str2, documentType);
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String str, String str2, String str3) {
        throw new RuntimeException("Not implemented");
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String str, String str2) {
        return DomImpl._domImplementation_hasFeature(this, str, str2);
    }

    public Object getFeature(String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    private static DomImpl.Dom checkNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        if (!(node instanceof DomImpl.Dom)) {
            throw new IllegalArgumentException("Node is not an XmlBeans node");
        }
        return (DomImpl.Dom) node;
    }

    public static XmlCursor nodeToCursor(Node node) {
        return DomImpl._getXmlCursor(checkNode(node));
    }

    public static XmlObject nodeToXmlObject(Node node) {
        return DomImpl._getXmlObject(checkNode(node));
    }

    public static XMLStreamReader nodeToXmlStream(Node node) {
        return DomImpl._getXmlStreamReader(checkNode(node));
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public void setSaajData(Node node, Object obj) {
        if (!$assertionsDisabled && !(node instanceof DomImpl.Dom)) {
            throw new AssertionError();
        }
        DomImpl.saajCallback_setSaajData((DomImpl.Dom) node, obj);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Object getSaajData(Node node) {
        if ($assertionsDisabled || (node instanceof DomImpl.Dom)) {
            return DomImpl.saajCallback_getSaajData((DomImpl.Dom) node);
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element createSoapElement(QName qName, QName qName2) {
        if ($assertionsDisabled || this._ownerDoc != null) {
            return DomImpl.saajCallback_createSoapElement(this._ownerDoc, qName, qName2);
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element importSoapElement(Document document, Element element, boolean z, QName qName) {
        if ($assertionsDisabled || (document instanceof DomImpl.Dom)) {
            return DomImpl.saajCallback_importSoapElement((DomImpl.Dom) document, element, z, qName);
        }
        throw new AssertionError();
    }

    private static final class DefaultQNameFactory implements QNameFactory {
        private QNameCache _cache;

        private DefaultQNameFactory() {
            this._cache = XmlBeans.getQNameCache();
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), new String(cArr3, i5, i6));
        }
    }

    private static final class LocalDocumentQNameFactory implements QNameFactory {
        private QNameCache _cache = new QNameCache(32);

        private LocalDocumentQNameFactory() {
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), new String(cArr3, i5, i6));
        }
    }
}
