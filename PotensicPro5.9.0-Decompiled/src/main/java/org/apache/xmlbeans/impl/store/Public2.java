package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Saver;
import org.apache.xmlbeans.impl.values.NamespaceManager;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public final class Public2 {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Public2;

    static {
        if (class$org$apache$xmlbeans$impl$store$Public2 == null) {
            class$org$apache$xmlbeans$impl$store$Public2 = class$("org.apache.xmlbeans.impl.store.Public2");
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

    private static Locale newLocale(Saaj saaj) {
        XmlOptions xmlOptions;
        if (saaj != null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put(Saaj.SAAJ_IMPL, saaj);
        } else {
            xmlOptions = null;
        }
        return Locale.getLocale(null, xmlOptions);
    }

    private static Locale newLocale() {
        return Locale.getLocale(null, null);
    }

    public static void setSync(Document document, boolean z) {
        if (!$assertionsDisabled && !(document instanceof DomImpl.Dom)) {
            throw new AssertionError();
        }
        ((DomImpl.Dom) document).locale()._noSync = !z;
    }

    public static String compilePath(String str, XmlOptions xmlOptions) {
        return Path.compilePath(str, xmlOptions);
    }

    public static DOMImplementation getDomImplementation() {
        return newLocale();
    }

    public static DOMImplementation getDomImplementation(Saaj saaj) {
        return newLocale(saaj);
    }

    public static Document parse(String str) throws XmlException {
        DomImpl.Dom load;
        Locale newLocale = newLocale();
        if (newLocale.noSync()) {
            newLocale.enter();
            try {
                load = newLocale.load(str);
            } finally {
            }
        } else {
            synchronized (newLocale) {
                newLocale.enter();
                try {
                    load = newLocale.load(str);
                    newLocale.exit();
                } finally {
                }
            }
        }
        return (Document) load;
    }

    public static Document parse(String str, XmlOptions xmlOptions) throws XmlException {
        DomImpl.Dom load;
        Locale newLocale = newLocale();
        if (newLocale.noSync()) {
            newLocale.enter();
            try {
                load = newLocale.load(str, xmlOptions);
            } finally {
            }
        } else {
            synchronized (newLocale) {
                newLocale.enter();
                try {
                    load = newLocale.load(str, xmlOptions);
                    newLocale.exit();
                } finally {
                }
            }
        }
        return (Document) load;
    }

    public static Document parse(String str, Saaj saaj) throws XmlException {
        DomImpl.Dom load;
        Locale newLocale = newLocale(saaj);
        if (newLocale.noSync()) {
            newLocale.enter();
            try {
                load = newLocale.load(str);
            } finally {
            }
        } else {
            synchronized (newLocale) {
                newLocale.enter();
                try {
                    load = newLocale.load(str);
                    newLocale.exit();
                } finally {
                }
            }
        }
        return (Document) load;
    }

    public static Document parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
        DomImpl.Dom load;
        Locale newLocale = newLocale();
        if (newLocale.noSync()) {
            newLocale.enter();
            try {
                load = newLocale.load(inputStream, xmlOptions);
            } finally {
            }
        } else {
            synchronized (newLocale) {
                newLocale.enter();
                try {
                    load = newLocale.load(inputStream, xmlOptions);
                    newLocale.exit();
                } finally {
                }
            }
        }
        return (Document) load;
    }

    public static Document parse(InputStream inputStream, Saaj saaj) throws XmlException, IOException {
        DomImpl.Dom load;
        Locale newLocale = newLocale(saaj);
        if (newLocale.noSync()) {
            newLocale.enter();
            try {
                load = newLocale.load(inputStream);
            } finally {
            }
        } else {
            synchronized (newLocale) {
                newLocale.enter();
                try {
                    load = newLocale.load(inputStream);
                    newLocale.exit();
                } finally {
                }
            }
        }
        return (Document) load;
    }

    public static Node getNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    public static XMLStreamReader getStream(Node node) {
        XMLStreamReader xmlStreamReader;
        if (!$assertionsDisabled && !(node instanceof DomImpl.Dom)) {
            throw new AssertionError();
        }
        DomImpl.Dom dom = (DomImpl.Dom) node;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return DomImpl.getXmlStreamReader(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlStreamReader = DomImpl.getXmlStreamReader(dom);
            } finally {
            }
        }
        return xmlStreamReader;
    }

    public static String save(Node node) {
        return save(node, (XmlOptions) null);
    }

    public static void save(Node node, OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        XmlCursor cursor = getCursor(node);
        cursor.save(outputStream, xmlOptions);
        cursor.dispose();
    }

    public static String save(Node node, XmlOptions xmlOptions) {
        String saveImpl;
        if (!$assertionsDisabled && !(node instanceof DomImpl.Dom)) {
            throw new AssertionError();
        }
        DomImpl.Dom dom = (DomImpl.Dom) node;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return saveImpl(dom, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                saveImpl = saveImpl(dom, xmlOptions);
            } finally {
            }
        }
        return saveImpl;
    }

    private static String saveImpl(DomImpl.Dom dom, XmlOptions xmlOptions) {
        Cur tempCur = dom.tempCur();
        String saveToString = new Saver.TextSaver(tempCur, xmlOptions, null).saveToString();
        tempCur.release();
        return saveToString;
    }

    public static String save(XmlCursor xmlCursor) {
        return save(xmlCursor, (XmlOptions) null);
    }

    public static String save(XmlCursor xmlCursor, XmlOptions xmlOptions) {
        String saveImpl;
        Cursor cursor = (Cursor) xmlCursor;
        Locale locale = cursor.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return saveImpl(cursor, xmlOptions);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                saveImpl = saveImpl(cursor, xmlOptions);
            } finally {
            }
        }
        return saveImpl;
    }

    private static String saveImpl(Cursor cursor, XmlOptions xmlOptions) {
        Cur tempCur = cursor.tempCur();
        String saveToString = new Saver.TextSaver(tempCur, xmlOptions, null).saveToString();
        tempCur.release();
        return saveToString;
    }

    public static XmlCursor newStore() {
        return newStore(null);
    }

    public static XmlCursor newStore(Saaj saaj) {
        XmlCursor _newStore;
        Locale newLocale = newLocale(saaj);
        if (newLocale.noSync()) {
            newLocale.enter();
            try {
                return _newStore(newLocale);
            } finally {
            }
        }
        synchronized (newLocale) {
            newLocale.enter();
            try {
                _newStore = _newStore(newLocale);
            } finally {
            }
        }
        return _newStore;
    }

    public static XmlCursor _newStore(Locale locale) {
        Cur tempCur = locale.tempCur();
        tempCur.createRoot();
        Cursor cursor = new Cursor(tempCur);
        tempCur.release();
        return cursor;
    }

    public static XmlCursor getCursor(Node node) {
        XmlCursor xmlCursor;
        if (!$assertionsDisabled && !(node instanceof DomImpl.Dom)) {
            throw new AssertionError();
        }
        DomImpl.Dom dom = (DomImpl.Dom) node;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return DomImpl.getXmlCursor(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlCursor = DomImpl.getXmlCursor(dom);
            } finally {
            }
        }
        return xmlCursor;
    }

    public static void dump(PrintStream printStream, DomImpl.Dom dom) {
        dom.dump(printStream);
    }

    public static void dump(PrintStream printStream, Node node) {
        dump(printStream, (DomImpl.Dom) node);
    }

    public static void dump(PrintStream printStream, XmlCursor xmlCursor) {
        ((Cursor) xmlCursor).dump(printStream);
    }

    public static void dump(PrintStream printStream, XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        DomImpl.Dom dom = (DomImpl.Dom) newCursor.getDomNode();
        newCursor.dispose();
        dump(printStream, dom);
    }

    public static void dump(DomImpl.Dom dom) {
        dump(System.out, dom);
    }

    public static void dump(Node node) {
        dump(System.out, node);
    }

    public static void dump(XmlCursor xmlCursor) {
        dump(System.out, xmlCursor);
    }

    public static void dump(XmlObject xmlObject) {
        dump(System.out, xmlObject);
    }

    private static class TestTypeStoreUser implements TypeStoreUser {
        private String _value;

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void attach_store(TypeStore typeStore) {
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void invalidate_value() {
        }

        TestTypeStoreUser(String str) {
            this._value = str;
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaType get_schema_type() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStore get_store() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public boolean uses_invalidate_value() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public String build_text(NamespaceManager namespaceManager) {
            return this._value;
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public boolean build_nil() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void invalidate_nilvalue() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void invalidate_element_order() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void validate_now() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void disconnect_store() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStoreUser create_element_user(QName qName, QName qName2) {
            return new TestTypeStoreUser("ELEM");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStoreUser create_attribute_user(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public String get_default_element_text(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public String get_default_attribute_text(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaType get_element_type(QName qName, QName qName2) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaType get_attribute_type(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public int get_elementflags(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public int get_attributeflags(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaField get_attribute_field(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public boolean is_child_element_order_sensitive() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public QNameSet get_element_ending_delimiters(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStoreVisitor new_visitor() {
            throw new RuntimeException("Not impl");
        }
    }

    public static void test() throws Exception {
        Xobj xobj = (Xobj) parse("<a>XY</a>");
        xobj._locale.enter();
        try {
            Cur tempCur = xobj.tempCur();
            tempCur.next();
            Cur tempCur2 = tempCur.tempCur();
            tempCur2.next();
            Cur tempCur3 = tempCur2.tempCur();
            tempCur3.nextChars(1);
            tempCur3.tempCur().nextChars(1);
            tempCur.dump();
            tempCur.moveNodeContents(tempCur, true);
            tempCur.dump();
        } finally {
            try {
            } finally {
            }
        }
    }
}
