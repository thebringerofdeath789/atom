package org.apache.xmlbeans.impl.values;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import com.ipotensic.baselib.mediadataretriever.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.apache.xmlbeans.DelegateXmlObject;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.validator.Validator;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes5.dex */
public abstract class XmlObjectBase implements TypeStoreUser, Serializable, XmlObject, SimpleValue {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final XmlObject[] EMPTY_RESULT;
    private static final int FLAGS_DATED = 672;
    private static final int FLAGS_ELEMENT = 7;
    private static final int FLAG_ATTRIBUTE = 8;
    private static final int FLAG_COMPLEXCONTENT = 16384;
    private static final int FLAG_COMPLEXTYPE = 8192;
    private static final int FLAG_ELEMENT_DATED = 512;
    private static final int FLAG_FIXED = 4;
    private static final int FLAG_HASDEFAULT = 2;
    private static final int FLAG_IMMUTABLE = 4096;
    private static final int FLAG_ISDEFAULT = 256;
    private static final int FLAG_NIL = 64;
    private static final int FLAG_NILLABLE = 1;
    private static final int FLAG_NIL_DATED = 128;
    private static final int FLAG_NOT_VARIABLE = 32768;
    private static final int FLAG_ORPHANED = 2048;
    private static final int FLAG_SETTINGDEFAULT = 1024;
    private static final int FLAG_STORE = 16;
    private static final int FLAG_VALIDATE_ON_SET = 65536;
    private static final int FLAG_VALUE_DATED = 32;
    public static final short KIND_SETTERHELPER_ARRAYITEM = 2;
    public static final short KIND_SETTERHELPER_SINGLETON = 1;
    public static final short MAJOR_VERSION_NUMBER = 1;
    public static final short MINOR_VERSION_NUMBER = 1;
    private static final BigInteger _max;
    private static final BigInteger _min;
    private static final XmlOptions _toStringOptions;
    public static final ValidationContext _voorVc;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$XmlObjectBase;
    private int _flags = 65;
    private Object _textsource;

    protected abstract String compute_text(NamespaceManager namespaceManager);

    protected abstract boolean equal_to(XmlObject xmlObject);

    protected int get_wscanon_rule() {
        return 3;
    }

    protected boolean is_defaultable_ws(String str) {
        return true;
    }

    public abstract SchemaType schemaType();

    protected abstract void set_nil();

    protected abstract void set_text(String str);

    protected void validate_simpleval(String str, ValidationContext validationContext) {
    }

    protected abstract int value_hash_code();

    static {
        if (class$org$apache$xmlbeans$impl$values$XmlObjectBase == null) {
            class$org$apache$xmlbeans$impl$values$XmlObjectBase = class$("org.apache.xmlbeans.impl.values.XmlObjectBase");
        }
        $assertionsDisabled = true;
        _voorVc = new ValueOutOfRangeValidationContext();
        _max = BigInteger.valueOf(Long.MAX_VALUE);
        _min = BigInteger.valueOf(Long.MIN_VALUE);
        _toStringOptions = buildInnerPrettyOptions();
        EMPTY_RESULT = new XmlObject[0];
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public final Object monitor() {
        return has_store() ? get_store().get_locale() : this;
    }

    private static XmlObjectBase underlying(XmlObject xmlObject) {
        if (xmlObject == null) {
            return null;
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        while (xmlObject instanceof DelegateXmlObject) {
            xmlObject = ((DelegateXmlObject) xmlObject).underlyingXmlObject();
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        throw new IllegalStateException("Non-native implementations of XmlObject should extend FilterXmlObject or implement DelegateXmlObject");
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy() {
        XmlObject _copy;
        if (preCheck()) {
            return _copy();
        }
        synchronized (monitor()) {
            _copy = _copy();
        }
        return _copy;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy(XmlOptions xmlOptions) {
        XmlObject _copy;
        if (preCheck()) {
            return _copy(xmlOptions);
        }
        synchronized (monitor()) {
            _copy = _copy(xmlOptions);
        }
        return _copy;
    }

    private boolean preCheck() {
        if (has_store()) {
            return get_store().get_locale().noSync();
        }
        return false;
    }

    public final XmlObject _copy() {
        return _copy(null);
    }

    public final XmlObject _copy(XmlOptions xmlOptions) {
        if (isImmutable()) {
            return this;
        }
        check_orphaned();
        return (XmlObject) get_store().copy(get_store().get_schematypeloader(), schemaType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.documentProperties();
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream() {
        return newXMLInputStream(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream(XmlOptions xmlOptions) {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.newXMLInputStream(makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return newXMLStreamReader(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.newXMLStreamReader(makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return newInputStream(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.newInputStream(makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return newReader(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.newReader(makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.getDomNode();
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return newDomNode(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.newDomNode(makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        XmlCursor newCursorForce = newCursorForce();
        try {
            newCursorForce.save(contentHandler, lexicalHandler, makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) throws IOException {
        XmlCursor newCursorForce = newCursorForce();
        try {
            newCursorForce.save(file, makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        XmlCursor newCursorForce = newCursorForce();
        try {
            newCursorForce.save(outputStream, makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) throws IOException {
        XmlCursor newCursorForce = newCursorForce();
        try {
            newCursorForce.save(writer, makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        save(contentHandler, lexicalHandler, null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) throws IOException {
        save(file, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) throws IOException {
        save(outputStream, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) throws IOException {
        save(writer, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        XmlCursor newCursorForce = newCursorForce();
        try {
            newCursorForce.dump();
        } finally {
            newCursorForce.dispose();
        }
    }

    public XmlCursor newCursorForce() {
        XmlCursor newCursor;
        synchronized (monitor()) {
            newCursor = ensureStore().newCursor();
        }
        return newCursor;
    }

    private XmlObject ensureStore() {
        String compute_text;
        if ((this._flags & 16) != 0) {
            return this;
        }
        check_dated();
        if ((this._flags & 64) != 0) {
            compute_text = "";
        } else {
            compute_text = compute_text(has_store() ? get_store() : null);
        }
        XmlObject newInstance = XmlObject.Factory.newInstance(new XmlOptions().setDocumentType(schemaType()));
        XmlCursor newCursor = newInstance.newCursor();
        newCursor.toNextToken();
        newCursor.insertChars(compute_text);
        return newInstance;
    }

    private static XmlOptions makeInnerOptions(XmlOptions xmlOptions) {
        XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
        xmlOptions2.put(XmlOptions.SAVE_INNER);
        return xmlOptions2;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        XmlCursor new_cursor;
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot create cursors");
        }
        check_orphaned();
        XmlLocale xmlLocale = getXmlLocale();
        if (xmlLocale.noSync()) {
            xmlLocale.enter();
            try {
                return get_store().new_cursor();
            } finally {
            }
        }
        synchronized (xmlLocale) {
            xmlLocale.enter();
            try {
                new_cursor = get_store().new_cursor();
            } finally {
            }
        }
        return new_cursor;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        SchemaType schemaType;
        synchronized (monitor()) {
            schemaType = isNil() ? null : schemaType();
        }
        return schemaType;
    }

    private SchemaField schemaField() {
        SchemaField containerField = schemaType().getContainerField();
        return containerField == null ? get_store().get_schema_field() : containerField;
    }

    private static final class ValueOutOfRangeValidationContext implements ValidationContext {
        private ValueOutOfRangeValidationContext() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            throw new XmlValueOutOfRangeException(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            throw new XmlValueOutOfRangeException(str, objArr);
        }
    }

    private static final class ImmutableValueValidationContext implements ValidationContext {
        private Collection _coll;
        private XmlObject _loc;

        ImmutableValueValidationContext(Collection collection, XmlObject xmlObject) {
            this._coll = collection;
            this._loc = xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            this._coll.add(XmlError.forObject(str, this._loc));
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            this._coll.add(XmlError.forObject(str, objArr, this._loc));
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate() {
        return validate(null);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate(XmlOptions xmlOptions) {
        boolean isValid;
        int i = this._flags;
        if ((i & 16) == 0) {
            if ((i & 4096) != 0) {
                return validate_immutable(xmlOptions);
            }
            throw new IllegalStateException("XML objects with no underlying store cannot be validated");
        }
        synchronized (monitor()) {
            if ((this._flags & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            SchemaField schemaField = schemaField();
            SchemaType schemaType = schemaType();
            TypeStore typeStore = get_store();
            Validator validator = new Validator(schemaType, schemaField, typeStore.get_schematypeloader(), xmlOptions, null);
            typeStore.validate(validator);
            isValid = validator.isValid();
        }
        return isValid;
    }

    private boolean validate_immutable(XmlOptions xmlOptions) {
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(xmlOptions == null ? null : (Collection) xmlOptions.get(XmlOptions.ERROR_LISTENER));
        if (!schemaType().isSimpleType() && (xmlOptions == null || !xmlOptions.hasOption(XmlOptions.VALIDATE_TEXT_ONLY))) {
            SchemaProperty[] properties = schemaType().getProperties();
            for (int i = 0; i < properties.length; i++) {
                if (properties[i].getMinOccurs().signum() > 0) {
                    if (properties[i].isAttribute()) {
                        xmlErrorWatcher.add(XmlError.forObject(XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_REQUIRED_ATTRIBUTE, new Object[]{QNameHelper.pretty(properties[i].getName())}, this));
                    } else {
                        xmlErrorWatcher.add(XmlError.forObject(XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_ELEMENT, new Object[]{properties[i].getMinOccurs(), QNameHelper.pretty(properties[i].getName())}, this));
                    }
                }
            }
            if (schemaType().getContentType() != 2) {
                return !xmlErrorWatcher.hasError();
            }
        }
        String str = (String) this._textsource;
        if (str == null) {
            str = "";
        }
        validate_simpleval(str, new ImmutableValueValidationContext(xmlErrorWatcher, this));
        return !xmlErrorWatcher.hasError();
    }

    private static XmlObject[] _typedArray(XmlObject[] xmlObjectArr) {
        if (xmlObjectArr.length == 0) {
            return xmlObjectArr;
        }
        SchemaType schemaType = xmlObjectArr[0].schemaType();
        if (schemaType.equals(XmlObject.type) || schemaType.isNoType()) {
            return xmlObjectArr;
        }
        for (int i = 1; i < xmlObjectArr.length; i++) {
            if (xmlObjectArr[i].schemaType().isNoType()) {
                return xmlObjectArr;
            }
            schemaType = schemaType.getCommonBaseType(xmlObjectArr[i].schemaType());
            if (schemaType.equals(XmlObject.type)) {
                return xmlObjectArr;
            }
        }
        Class javaClass = schemaType.getJavaClass();
        while (javaClass == null) {
            schemaType = schemaType.getBaseType();
            if (XmlObject.type.equals(schemaType)) {
                return xmlObjectArr;
            }
            javaClass = schemaType.getJavaClass();
        }
        XmlObject[] xmlObjectArr2 = (XmlObject[]) Array.newInstance((Class<?>) javaClass, xmlObjectArr.length);
        System.arraycopy(xmlObjectArr, 0, xmlObjectArr2, 0, xmlObjectArr.length);
        return xmlObjectArr2;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str) {
        return selectPath(str, null);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr;
        XmlCursor newCursor = newCursor();
        if (newCursor == null) {
            throw new XmlValueDisconnectedException();
        }
        try {
            newCursor.selectPath(str, xmlOptions);
            if (!newCursor.hasNextSelection()) {
                xmlObjectArr = EMPTY_RESULT;
            } else {
                xmlObjectArr = new XmlObject[newCursor.getSelectionCount()];
                int i = 0;
                while (newCursor.toNextSelection()) {
                    XmlObject object = newCursor.getObject();
                    xmlObjectArr[i] = object;
                    if (object == null) {
                        if (newCursor.toParent()) {
                            XmlObject object2 = newCursor.getObject();
                            xmlObjectArr[i] = object2;
                            if (object2 != null) {
                            }
                        }
                        throw new XmlRuntimeException("Path must select only elements and attributes");
                    }
                    i++;
                }
            }
            newCursor.dispose();
            return _typedArray(xmlObjectArr);
        } catch (Throwable th) {
            newCursor.dispose();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str) {
        return execQuery(str, null);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str, XmlOptions xmlOptions) {
        XmlObject[] _typedArray;
        synchronized (monitor()) {
            TypeStore typeStore = get_store();
            if (typeStore == null) {
                throw new XmlRuntimeException("Cannot do XQuery on XML Value Objects");
            }
            try {
                _typedArray = _typedArray(typeStore.exec_query(str, xmlOptions));
            } catch (XmlException e) {
                throw new XmlRuntimeException(e);
            }
        }
        return _typedArray;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject changeType(SchemaType schemaType) {
        XmlObject xmlObject;
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot have thier type changed");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObject = (XmlObject) get_store().change_type(schemaType);
        }
        return xmlObject;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject substitute(QName qName, SchemaType schemaType) {
        XmlObject xmlObject;
        if (qName == null) {
            throw new IllegalArgumentException("Invalid name (null)");
        }
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot be used with substitution");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObject = (XmlObject) get_store().substitute(qName, schemaType);
        }
        return xmlObject;
    }

    protected XmlObjectBase() {
    }

    public void init_flags(SchemaProperty schemaProperty) {
        if (schemaProperty == null) {
            return;
        }
        if (schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1 || schemaProperty.hasNillable() == 1) {
            return;
        }
        int i = this._flags & (-8);
        this._flags = i;
        this._flags = (schemaProperty.hasDefault() == 0 ? 0 : 2) | (schemaProperty.hasFixed() == 0 ? 0 : 4) | (schemaProperty.hasNillable() == 0 ? 0 : 1) | 32768 | i;
    }

    protected void initComplexType(boolean z, boolean z2) {
        this._flags = (z ? 8192 : 0) | (z2 ? 16384 : 0) | this._flags;
    }

    protected boolean _isComplexType() {
        return (this._flags & 8192) != 0;
    }

    protected boolean _isComplexContent() {
        return (this._flags & 16384) != 0;
    }

    public void setValidateOnSet() {
        this._flags |= 65536;
    }

    protected boolean _validateOnSet() {
        return (this._flags & 65536) != 0;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean isNil() {
        boolean z;
        synchronized (monitor()) {
            check_dated();
            z = (this._flags & 64) != 0;
        }
        return z;
    }

    public final boolean isFixed() {
        check_element_dated();
        return (this._flags & 4) != 0;
    }

    public final boolean isNillable() {
        check_element_dated();
        return (this._flags & 1) != 0;
    }

    public final boolean isDefaultable() {
        check_element_dated();
        return (this._flags & 2) != 0;
    }

    public final boolean isDefault() {
        check_dated();
        return (this._flags & 256) != 0;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final void setNil() {
        synchronized (monitor()) {
            set_prepare();
            int i = this._flags;
            if ((i & 1) == 0 && (i & 65536) != 0) {
                throw new XmlValueNotNillableException();
            }
            set_nil();
            int i2 = this._flags | 64;
            this._flags = i2;
            if ((i2 & 16) != 0) {
                get_store().invalidate_text();
                this._flags &= -673;
                get_store().invalidate_nil();
            } else {
                this._textsource = null;
            }
        }
    }

    protected int elementFlags() {
        check_element_dated();
        return this._flags & 7;
    }

    public void setImmutable() {
        int i = this._flags;
        if ((i & 4112) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i | 4096;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isImmutable() {
        return (this._flags & 4096) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void attach_store(TypeStore typeStore) {
        this._textsource = typeStore;
        int i = this._flags;
        if ((i & 4096) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i | 688;
        if (typeStore.is_attribute()) {
            this._flags |= 8;
        }
        if (typeStore.validate_on_set()) {
            this._flags |= 65536;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_value() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= 32;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final boolean uses_invalidate_value() {
        SchemaType schemaType = schemaType();
        return schemaType.isSimpleType() || schemaType.getContentType() == 2;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_nilvalue() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= 160;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_element_order() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= FLAGS_DATED;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final TypeStore get_store() {
        if ($assertionsDisabled || (this._flags & 16) != 0) {
            return (TypeStore) this._textsource;
        }
        throw new AssertionError();
    }

    public final XmlLocale getXmlLocale() {
        return get_store().get_locale();
    }

    protected final boolean has_store() {
        return (this._flags & 16) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final String build_text(NamespaceManager namespaceManager) {
        boolean z = $assertionsDisabled;
        if (!z && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        if (!z && (this._flags & 32) != 0) {
            throw new AssertionError();
        }
        if ((this._flags & Utils.TARGET_SIZE_MINI_THUMBNAIL) != 0) {
            return "";
        }
        if (namespaceManager == null) {
            namespaceManager = has_store() ? get_store() : null;
        }
        return compute_text(namespaceManager);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean build_nil() {
        boolean z = $assertionsDisabled;
        if (!z && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        if (z || (this._flags & 32) == 0) {
            return (this._flags & 64) != 0;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void validate_now() {
        check_dated();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void disconnect_store() {
        if (!$assertionsDisabled && (this._flags & 16) == 0) {
            throw new AssertionError();
        }
        this._flags |= 2720;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_element_user(QName qName, QName qName2) {
        return (TypeStoreUser) ((SchemaTypeImpl) schemaType()).createElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_attribute_user(QName qName) {
        return (TypeStoreUser) ((SchemaTypeImpl) schemaType()).createAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_schema_type() {
        return schemaType();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_element_type(QName qName, QName qName2) {
        return schemaType().getElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_attribute_type(QName qName) {
        return schemaType().getAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        if (!$assertionsDisabled && !_isComplexContent()) {
            throw new AssertionError();
        }
        if (!_isComplexContent()) {
            throw new IllegalStateException();
        }
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        if (!$assertionsDisabled && !_isComplexType()) {
            throw new AssertionError();
        }
        if (!_isComplexType()) {
            throw new IllegalStateException();
        }
        SchemaProperty attributeProperty = schemaType().getAttributeProperty(qName);
        return attributeProperty == null ? "" : attributeProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty;
        if (!_isComplexContent() || (elementProperty = schemaType().getElementProperty(qName)) == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_attributeflags(QName qName) {
        SchemaProperty attributeProperty;
        if (_isComplexType() && (attributeProperty = schemaType().getAttributeProperty(qName)) != null) {
            return (attributeProperty.hasDefault() == 0 ? 0 : 2) | (attributeProperty.hasFixed() != 0 ? 4 : 0);
        }
        return 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        if (_isComplexType()) {
            return schemaType().isOrderSensitive();
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final QNameSet get_element_ending_delimiters(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return null;
        }
        return elementProperty.getJavaSetterDelimiter();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        if (_isComplexContent()) {
            return new SchemaTypeVisitorImpl(schemaType().getContentModel());
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaField get_attribute_field(QName qName) {
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null) {
            return null;
        }
        return attributeModel.getAttribute(qName);
    }

    protected void set_String(String str) {
        int i = this._flags;
        if ((i & 4096) != 0) {
            throw new IllegalStateException();
        }
        boolean z = (i & 64) != 0;
        update_from_wscanon_text(apply_wscanon(str));
        int i2 = this._flags;
        if ((i2 & 16) != 0) {
            int i3 = i2 & (-33);
            this._flags = i3;
            if ((i3 & 1024) == 0) {
                get_store().store_text(str);
            }
            if (z) {
                get_store().invalidate_nil();
                return;
            }
            return;
        }
        this._textsource = str;
    }

    protected void update_from_complex_content() {
        throw new XmlValueNotSupportedException("Complex content");
    }

    private final void update_from_wscanon_text(String str) {
        int i = this._flags;
        if ((i & 2) != 0 && (i & 1024) == 0 && (i & 8) == 0 && str.equals("")) {
            String compute_default_text = get_store().compute_default_text();
            if (compute_default_text == null) {
                throw new XmlValueOutOfRangeException();
            }
            this._flags |= 1024;
            try {
                setStringValue(compute_default_text);
                int i2 = this._flags & (-1025);
                this._flags = i2;
                int i3 = i2 & (-65);
                this._flags = i3;
                this._flags = i3 | 256;
                return;
            } catch (Throwable th) {
                this._flags &= -1025;
                throw th;
            }
        }
        set_text(str);
        this._flags &= -321;
    }

    private final String apply_wscanon(String str) {
        return XmlWhitespace.collapse(str, get_wscanon_rule());
    }

    private final void check_element_dated() {
        int i = this._flags;
        if ((i & 512) != 0 && (i & 32768) == 0) {
            if ((i & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            int compute_flags = get_store().compute_flags();
            int i2 = this._flags & (-520);
            this._flags = i2;
            this._flags = compute_flags | i2;
        }
        int i3 = this._flags;
        if ((i3 & 32768) != 0) {
            this._flags = i3 & (-513);
        }
    }

    protected final boolean is_orphaned() {
        return (this._flags & 2048) != 0;
    }

    protected final void check_orphaned() {
        if (is_orphaned()) {
            throw new XmlValueDisconnectedException();
        }
    }

    public final void check_dated() {
        String str;
        int i = this._flags;
        if ((i & FLAGS_DATED) != 0) {
            if ((i & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            if (!$assertionsDisabled && (i & 16) == 0) {
                throw new AssertionError();
            }
            check_element_dated();
            if ((this._flags & 512) != 0) {
                int compute_flags = get_store().compute_flags();
                int i2 = this._flags & (-520);
                this._flags = i2;
                this._flags = compute_flags | i2;
            }
            boolean z = false;
            if ((this._flags & 128) != 0) {
                if (get_store().find_nil()) {
                    int i3 = this._flags;
                    if ((i3 & 1) == 0 && (i3 & 65536) != 0) {
                        throw new XmlValueOutOfRangeException();
                    }
                    set_nil();
                    this._flags |= 64;
                    z = true;
                } else {
                    this._flags &= -65;
                }
                this._flags &= -129;
            }
            if (!z) {
                if ((this._flags & 16384) != 0 || (str = get_wscanon_text()) == null) {
                    update_from_complex_content();
                } else {
                    NamespaceContext.push(new NamespaceContext(get_store()));
                    try {
                        update_from_wscanon_text(str);
                    } finally {
                        NamespaceContext.pop();
                    }
                }
            }
            this._flags &= -33;
        }
    }

    private final void set_prepare() {
        check_element_dated();
        if ((this._flags & 4096) != 0) {
            throw new IllegalStateException();
        }
    }

    private final void set_commit() {
        int i = this._flags;
        boolean z = (i & 64) != 0;
        int i2 = i & (-321);
        this._flags = i2;
        if ((i2 & 16) != 0) {
            this._flags = i2 & (-673);
            get_store().invalidate_text();
            if (z) {
                get_store().invalidate_nil();
                return;
            }
            return;
        }
        this._textsource = null;
    }

    public final String get_wscanon_text() {
        if ((this._flags & 16) == 0) {
            return apply_wscanon((String) this._textsource);
        }
        return get_store().fetch_text(get_wscanon_rule());
    }

    public float getFloatValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0f;
        }
        return bigDecimalValue.floatValue();
    }

    public double getDoubleValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0d;
        }
        return bigDecimalValue.doubleValue();
    }

    public BigDecimal getBigDecimalValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "numeric"});
    }

    public BigInteger getBigIntegerValue() {
        BigDecimal bigDecimalValue = bigDecimalValue();
        if (bigDecimalValue == null) {
            return null;
        }
        return bigDecimalValue.toBigInteger();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        long intValue = getIntValue();
        if (intValue > 127) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -128) {
            return (byte) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        long intValue = getIntValue();
        if (intValue > 32767) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -32768) {
            return (short) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public int getIntValue() {
        long longValue = getLongValue();
        if (longValue > 2147483647L) {
            throw new XmlValueOutOfRangeException();
        }
        if (longValue >= -2147483648L) {
            return (int) longValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public long getLongValue() {
        BigInteger bigIntegerValue = getBigIntegerValue();
        if (bigIntegerValue == null) {
            return 0L;
        }
        if (bigIntegerValue.compareTo(_max) >= 0) {
            throw new XmlValueOutOfRangeException();
        }
        if (bigIntegerValue.compareTo(_min) <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        return bigIntegerValue.longValue();
    }

    static final XmlOptions buildInnerPrettyOptions() {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.put(XmlOptions.SAVE_INNER);
        xmlOptions.put(XmlOptions.SAVE_PRETTY_PRINT);
        xmlOptions.put(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
        xmlOptions.put(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        return xmlOptions;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final String toString() {
        String xmlText;
        synchronized (monitor()) {
            xmlText = ensureStore().xmlText(_toStringOptions);
        }
        return xmlText;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return xmlText(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        XmlCursor newCursorForce = newCursorForce();
        try {
            return newCursorForce.xmlText(makeInnerOptions(xmlOptions));
        } finally {
            newCursorForce.dispose();
        }
    }

    public StringEnumAbstractBase getEnumValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "enum"});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        if (isImmutable()) {
            if ((this._flags & 64) != 0) {
                return null;
            }
            return compute_text(null);
        }
        synchronized (monitor()) {
            if (_isComplexContent()) {
                return get_store().fetch_text(1);
            }
            check_dated();
            if ((this._flags & 64) != 0) {
                return null;
            }
            return compute_text(has_store() ? get_store() : null);
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String stringValue() {
        return getStringValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public boolean booleanValue() {
        return getBooleanValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte byteValue() {
        return getByteValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short shortValue() {
        return getShortValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public int intValue() {
        return getIntValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public long longValue() {
        return getLongValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigInteger bigIntegerValue() {
        return getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigDecimal bigDecimalValue() {
        return getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public float floatValue() {
        return getFloatValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public double doubleValue() {
        return getDoubleValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte[] byteArrayValue() {
        return getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase enumValue() {
        return getEnumValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Calendar calendarValue() {
        return getCalendarValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Date dateValue() {
        return getDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDate gDateValue() {
        return getGDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDuration gDurationValue() {
        return getGDurationValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public QName qNameValue() {
        return getQNameValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List xlistValue() {
        return xgetListValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List listValue() {
        return getListValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object objectValue() {
        return getObjectValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(String str) {
        setStringValue(str);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(boolean z) {
        setBooleanValue(z);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(byte b) {
        setByteValue(b);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(short s) {
        setShortValue(s);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(int i) {
        setIntValue(i);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(long j) {
        setLongValue(j);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(BigInteger bigInteger) {
        setBigIntegerValue(bigInteger);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(BigDecimal bigDecimal) {
        setBigDecimalValue(bigDecimal);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(float f) {
        setFloatValue(f);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(double d) {
        setDoubleValue(d);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(byte[] bArr) {
        setByteArrayValue(bArr);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(StringEnumAbstractBase stringEnumAbstractBase) {
        setEnumValue(stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(Calendar calendar) {
        setCalendarValue(calendar);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(Date date) {
        setDateValue(date);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(GDateSpecification gDateSpecification) {
        setGDateValue(gDateSpecification);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(GDurationSpecification gDurationSpecification) {
        setGDurationValue(gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(QName qName) {
        setQNameValue(qName);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(List list) {
        setListValue(list);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void objectSet(Object obj) {
        setObjectValue(obj);
    }

    public byte[] getByteArrayValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "byte[]"});
    }

    public boolean getBooleanValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), XmlErrorCodes.BOOLEAN});
    }

    public GDate getGDateValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Date"});
    }

    public Date getDateValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Date"});
    }

    public Calendar getCalendarValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Calendar"});
    }

    public GDuration getGDurationValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Duration"});
    }

    public QName getQNameValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), XmlErrorCodes.QNAME});
    }

    public List getListValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "List"});
    }

    public List xgetListValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "List"});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object getObjectValue() {
        return java_value(this);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBooleanValue(boolean z) {
        synchronized (monitor()) {
            set_prepare();
            set_boolean(z);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteValue(byte b) {
        synchronized (monitor()) {
            set_prepare();
            set_byte(b);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setShortValue(short s) {
        synchronized (monitor()) {
            set_prepare();
            set_short(s);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setIntValue(int i) {
        synchronized (monitor()) {
            set_prepare();
            set_int(i);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setLongValue(long j) {
        synchronized (monitor()) {
            set_prepare();
            set_long(j);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setFloatValue(float f) {
        synchronized (monitor()) {
            set_prepare();
            set_float(f);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDoubleValue(double d) {
        synchronized (monitor()) {
            set_prepare();
            set_double(d);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteArrayValue(byte[] bArr) {
        if (bArr == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_ByteArray(bArr);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase) {
        if (stringEnumAbstractBase == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_enum(stringEnumAbstractBase);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigIntegerValue(BigInteger bigInteger) {
        if (bigInteger == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigInteger(bigInteger);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigDecimalValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigDecimal(bigDecimal);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setCalendarValue(Calendar calendar) {
        if (calendar == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Calendar(calendar);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDateValue(Date date) {
        if (date == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Date(date);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setGDateValue(GDate gDate) {
        if (gDate == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDate);
            set_commit();
        }
    }

    public final void setGDateValue(GDateSpecification gDateSpecification) {
        if (gDateSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDateSpecification);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setGDurationValue(GDuration gDuration) {
        if (gDuration == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDuration);
            set_commit();
        }
    }

    public final void setGDurationValue(GDurationSpecification gDurationSpecification) {
        if (gDurationSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDurationSpecification);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setQNameValue(QName qName) {
        if (qName == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_QName(qName);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setListValue(List list) {
        if (list == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_list(list);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setStringValue(String str) {
        if (str == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_String(str);
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setObjectValue(Object obj) {
        if (obj == null) {
            setNil();
            return;
        }
        if (obj instanceof XmlObject) {
            set((XmlObject) obj);
            return;
        }
        if (obj instanceof String) {
            setStringValue((String) obj);
            return;
        }
        if (obj instanceof StringEnumAbstractBase) {
            setEnumValue((StringEnumAbstractBase) obj);
            return;
        }
        if (obj instanceof BigInteger) {
            setBigIntegerValue((BigInteger) obj);
            return;
        }
        if (obj instanceof BigDecimal) {
            setBigDecimalValue((BigDecimal) obj);
            return;
        }
        if (obj instanceof Byte) {
            setByteValue(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Short) {
            setShortValue(((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Integer) {
            setIntValue(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            setLongValue(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            setBooleanValue(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Float) {
            setFloatValue(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            setDoubleValue(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Calendar) {
            setCalendarValue((Calendar) obj);
            return;
        }
        if (obj instanceof Date) {
            setDateValue((Date) obj);
            return;
        }
        if (obj instanceof GDateSpecification) {
            setGDateValue((GDateSpecification) obj);
            return;
        }
        if (obj instanceof GDurationSpecification) {
            setGDurationValue((GDurationSpecification) obj);
            return;
        }
        if (obj instanceof QName) {
            setQNameValue((QName) obj);
        } else if (obj instanceof List) {
            setListValue((List) obj);
        } else {
            if (obj instanceof byte[]) {
                setByteArrayValue((byte[]) obj);
                return;
            }
            throw new XmlValueNotSupportedException(new StringBuffer().append("Can't set union object of class : ").append(obj.getClass().getName()).toString());
        }
    }

    public final void set_newValue(XmlObject xmlObject) {
        if (xmlObject == null || xmlObject.isNil()) {
            setNil();
            return;
        }
        if (xmlObject instanceof XmlAnySimpleType) {
            XmlAnySimpleType xmlAnySimpleType = (XmlAnySimpleType) xmlObject;
            SchemaType instanceType = ((SimpleValue) xmlAnySimpleType).instanceType();
            boolean z = $assertionsDisabled;
            if (!z && instanceType == null) {
                throw new AssertionError("Nil case should have been handled already");
            }
            if (instanceType.getSimpleVariety() == 3) {
                synchronized (monitor()) {
                    set_prepare();
                    set_list(((SimpleValue) xmlAnySimpleType).xgetListValue());
                    set_commit();
                }
                return;
            }
            synchronized (monitor()) {
                boolean z2 = true;
                if (!z) {
                    if (instanceType.getSimpleVariety() != 1) {
                        throw new AssertionError();
                    }
                }
                switch (instanceType.getPrimitiveType().getBuiltinTypeCode()) {
                    case 2:
                        if (xmlAnySimpleType.isImmutable()) {
                            z2 = false;
                        } else {
                            NamespaceContext.push(new NamespaceContext(xmlAnySimpleType));
                        }
                        try {
                            set_prepare();
                            set_xmlanysimple(xmlAnySimpleType);
                            set_commit();
                            return;
                        } finally {
                            if (z2) {
                                NamespaceContext.pop();
                            }
                        }
                    case 3:
                        boolean booleanValue = ((SimpleValue) xmlAnySimpleType).getBooleanValue();
                        set_prepare();
                        set_boolean(booleanValue);
                        set_commit();
                        return;
                    case 4:
                        byte[] byteArrayValue = ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
                        set_prepare();
                        set_b64(byteArrayValue);
                        set_commit();
                        return;
                    case 5:
                        byte[] byteArrayValue2 = ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
                        set_prepare();
                        set_hex(byteArrayValue2);
                        set_commit();
                        return;
                    case 6:
                        String stringValue = xmlAnySimpleType.getStringValue();
                        set_prepare();
                        set_text(stringValue);
                        set_commit();
                        return;
                    case 7:
                        QName qNameValue = ((SimpleValue) xmlAnySimpleType).getQNameValue();
                        set_prepare();
                        set_QName(qNameValue);
                        set_commit();
                        return;
                    case 8:
                        String stringValue2 = xmlAnySimpleType.getStringValue();
                        set_prepare();
                        set_notation(stringValue2);
                        set_commit();
                        return;
                    case 9:
                        float floatValue = ((SimpleValue) xmlAnySimpleType).getFloatValue();
                        set_prepare();
                        set_float(floatValue);
                        set_commit();
                        return;
                    case 10:
                        double doubleValue = ((SimpleValue) xmlAnySimpleType).getDoubleValue();
                        set_prepare();
                        set_double(doubleValue);
                        set_commit();
                        return;
                    case 11:
                        int decimalSize = instanceType.getDecimalSize();
                        if (decimalSize == 8) {
                            byte byteValue = ((SimpleValue) xmlAnySimpleType).getByteValue();
                            set_prepare();
                            set_byte(byteValue);
                        } else if (decimalSize == 16) {
                            short shortValue = ((SimpleValue) xmlAnySimpleType).getShortValue();
                            set_prepare();
                            set_short(shortValue);
                        } else if (decimalSize == 32) {
                            int intValue = ((SimpleValue) xmlAnySimpleType).getIntValue();
                            set_prepare();
                            set_int(intValue);
                        } else if (decimalSize == 64) {
                            long longValue = ((SimpleValue) xmlAnySimpleType).getLongValue();
                            set_prepare();
                            set_long(longValue);
                        } else {
                            switch (decimalSize) {
                                case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                                    BigInteger bigIntegerValue = ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
                                    set_prepare();
                                    set_BigInteger(bigIntegerValue);
                                    break;
                                default:
                                    if (!z) {
                                        throw new AssertionError("invalid numeric bit count");
                                    }
                                case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                                    BigDecimal bigDecimalValue = ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
                                    set_prepare();
                                    set_BigDecimal(bigDecimalValue);
                                    break;
                            }
                        }
                        set_commit();
                        return;
                    case 12:
                        String stringValue3 = xmlAnySimpleType.getStringValue();
                        set_prepare();
                        set_String(stringValue3);
                        set_commit();
                        return;
                    case 13:
                        GDuration gDurationValue = ((SimpleValue) xmlAnySimpleType).getGDurationValue();
                        set_prepare();
                        set_GDuration(gDurationValue);
                        set_commit();
                        return;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        GDate gDateValue = ((SimpleValue) xmlAnySimpleType).getGDateValue();
                        set_prepare();
                        set_GDate(gDateValue);
                        set_commit();
                        return;
                    default:
                        if (!z) {
                            throw new AssertionError("encountered nonprimitive type.");
                        }
                        break;
                }
            }
        }
        throw new IllegalStateException("Complex type unexpected");
    }

    private TypeStoreUser setterHelper(XmlObjectBase xmlObjectBase) {
        check_orphaned();
        xmlObjectBase.check_orphaned();
        return get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject set(XmlObject xmlObject) {
        TypeStoreUser typeStoreUser;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase underlying = underlying(xmlObject);
        if (underlying == null) {
            setNil();
            return this;
        }
        if (underlying.isImmutable()) {
            setStringValue(underlying.getStringValue());
            typeStoreUser = this;
        } else {
            boolean preCheck = preCheck();
            boolean preCheck2 = underlying.preCheck();
            if (monitor() == underlying.monitor()) {
                if (preCheck) {
                    typeStoreUser = setterHelper(underlying);
                } else {
                    synchronized (monitor()) {
                        typeStoreUser = setterHelper(underlying);
                    }
                }
            } else if (preCheck) {
                if (preCheck2) {
                    typeStoreUser = setterHelper(underlying);
                } else {
                    synchronized (underlying.monitor()) {
                        typeStoreUser = setterHelper(underlying);
                    }
                }
            } else if (preCheck2) {
                synchronized (monitor()) {
                    typeStoreUser = setterHelper(underlying);
                }
            } else {
                boolean z = false;
                try {
                    try {
                        GlobalLock.acquire();
                        try {
                            try {
                                synchronized (monitor()) {
                                    try {
                                        try {
                                            synchronized (underlying.monitor()) {
                                                try {
                                                    GlobalLock.release();
                                                    typeStoreUser = setterHelper(underlying);
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
                                        z = true;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            z = true;
                            throw new XmlRuntimeException(e);
                        } catch (Throwable th5) {
                            th = th5;
                            z = true;
                            if (z) {
                                GlobalLock.release();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                }
            }
        }
        return (XmlObject) typeStoreUser;
    }

    public final XmlObject generatedSetterHelperImpl(XmlObject xmlObject, QName qName, int i, short s) {
        XmlObject xmlObject2;
        XmlObject xmlObject3;
        XmlObject xmlObject4;
        XmlObjectBase targetForSetter;
        XmlObjectBase targetForSetter2;
        XmlObjectBase underlying = underlying(xmlObject);
        if (underlying == null) {
            synchronized (monitor()) {
                targetForSetter2 = getTargetForSetter(qName, i, s);
                targetForSetter2.setNil();
            }
            return targetForSetter2;
        }
        if (underlying.isImmutable()) {
            synchronized (monitor()) {
                targetForSetter = getTargetForSetter(qName, i, s);
                targetForSetter.setStringValue(underlying.getStringValue());
            }
            return targetForSetter;
        }
        boolean preCheck = preCheck();
        boolean preCheck2 = underlying.preCheck();
        if (monitor() == underlying.monitor()) {
            if (preCheck) {
                return (XmlObject) objSetterHelper(underlying, qName, i, s);
            }
            synchronized (monitor()) {
                xmlObject4 = (XmlObject) objSetterHelper(underlying, qName, i, s);
            }
            return xmlObject4;
        }
        if (preCheck) {
            if (preCheck2) {
                return (XmlObject) objSetterHelper(underlying, qName, i, s);
            }
            synchronized (underlying.monitor()) {
                xmlObject3 = (XmlObject) objSetterHelper(underlying, qName, i, s);
            }
            return xmlObject3;
        }
        if (preCheck2) {
            synchronized (monitor()) {
                xmlObject2 = (XmlObject) objSetterHelper(underlying, qName, i, s);
            }
            return xmlObject2;
        }
        boolean z = false;
        try {
            try {
                GlobalLock.acquire();
                try {
                    try {
                        synchronized (monitor()) {
                            try {
                                try {
                                    synchronized (underlying.monitor()) {
                                        try {
                                            GlobalLock.release();
                                            return (XmlObject) objSetterHelper(underlying, qName, i, s);
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
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    throw new XmlRuntimeException(e);
                } catch (Throwable th5) {
                    th = th5;
                    z = true;
                    if (z) {
                        GlobalLock.release();
                    }
                    throw th;
                }
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private TypeStoreUser objSetterHelper(XmlObjectBase xmlObjectBase, QName qName, int i, short s) {
        XmlObjectBase targetForSetter = getTargetForSetter(qName, i, s);
        targetForSetter.check_orphaned();
        xmlObjectBase.check_orphaned();
        return targetForSetter.get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    private XmlObjectBase getTargetForSetter(QName qName, int i, short s) {
        if (s == 1) {
            check_orphaned();
            XmlObjectBase xmlObjectBase = (XmlObjectBase) get_store().find_element_user(qName, i);
            if (xmlObjectBase == null) {
                xmlObjectBase = (XmlObjectBase) get_store().add_element_user(qName);
            }
            if (xmlObjectBase.isImmutable()) {
                throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
            }
            return xmlObjectBase;
        }
        if (s == 2) {
            check_orphaned();
            XmlObjectBase xmlObjectBase2 = (XmlObjectBase) get_store().find_element_user(qName, i);
            if (xmlObjectBase2 == null) {
                throw new IndexOutOfBoundsException();
            }
            if (xmlObjectBase2.isImmutable()) {
                throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
            }
            return xmlObjectBase2;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown kindSetterHelper: ").append((int) s).toString());
    }

    public final XmlObject _set(XmlObject xmlObject) {
        TypeStoreUser change_type;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase underlying = underlying(xmlObject);
        if (underlying == null) {
            setNil();
            return this;
        }
        if (underlying.isImmutable()) {
            set(underlying.stringValue());
            change_type = this;
        } else {
            check_orphaned();
            underlying.check_orphaned();
            change_type = get_store().copy_contents_from(underlying.get_store()).get_store().change_type(underlying.schemaType());
        }
        return (XmlObject) change_type;
    }

    protected void set_list(List list) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"List", getPrimitiveTypeName()});
    }

    protected void set_boolean(boolean z) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{XmlErrorCodes.BOOLEAN, getPrimitiveTypeName()});
    }

    protected void set_byte(byte b) {
        set_int(b);
    }

    protected void set_short(short s) {
        set_int(s);
    }

    protected void set_int(int i) {
        set_long(i);
    }

    protected void set_long(long j) {
        set_BigInteger(BigInteger.valueOf(j));
    }

    protected void set_char(char c) {
        set_String(Character.toString(c));
    }

    protected void set_float(float f) {
        set_BigDecimal(new BigDecimal(f));
    }

    protected void set_double(double d) {
        set_BigDecimal(new BigDecimal(d));
    }

    protected void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"enum", getPrimitiveTypeName()});
    }

    protected void set_ByteArray(byte[] bArr) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"byte[]", getPrimitiveTypeName()});
    }

    protected void set_b64(byte[] bArr) {
        set_ByteArray(bArr);
    }

    protected void set_hex(byte[] bArr) {
        set_ByteArray(bArr);
    }

    protected void set_BigInteger(BigInteger bigInteger) {
        set_BigDecimal(new BigDecimal(bigInteger));
    }

    protected void set_BigDecimal(BigDecimal bigDecimal) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"numeric", getPrimitiveTypeName()});
    }

    protected void set_Date(Date date) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Date", getPrimitiveTypeName()});
    }

    protected void set_Calendar(Calendar calendar) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Calendar", getPrimitiveTypeName()});
    }

    protected void set_GDate(GDateSpecification gDateSpecification) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Date", getPrimitiveTypeName()});
    }

    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Duration", getPrimitiveTypeName()});
    }

    protected void set_ComplexXml(XmlObject xmlObject) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"complex content", getPrimitiveTypeName()});
    }

    protected void set_QName(QName qName) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{XmlErrorCodes.QNAME, getPrimitiveTypeName()});
    }

    protected void set_notation(String str) {
        throw new XmlValueNotSupportedException();
    }

    protected void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        set_String(xmlAnySimpleType.getStringValue());
    }

    private final String getPrimitiveTypeName() {
        SchemaType schemaType = schemaType();
        if (schemaType.isNoType()) {
            return "unknown";
        }
        SchemaType primitiveType = schemaType.getPrimitiveType();
        return primitiveType == null ? "complex" : primitiveType.getName().getLocalPart();
    }

    private final boolean comparable_value_spaces(SchemaType schemaType, SchemaType schemaType2) {
        if (!$assertionsDisabled && (schemaType.getSimpleVariety() == 2 || schemaType2.getSimpleVariety() == 2)) {
            throw new AssertionError();
        }
        if (!schemaType.isSimpleType() && !schemaType2.isSimpleType()) {
            return schemaType.getContentType() == schemaType2.getContentType();
        }
        if (schemaType.isSimpleType() && schemaType2.isSimpleType()) {
            if (schemaType.getSimpleVariety() == 3 && schemaType2.getSimpleVariety() == 3) {
                return true;
            }
            if (schemaType.getSimpleVariety() != 3 && schemaType2.getSimpleVariety() != 3) {
                return schemaType.getPrimitiveType().equals(schemaType2.getPrimitiveType());
            }
        }
        return false;
    }

    private final boolean valueEqualsImpl(XmlObject xmlObject) {
        check_dated();
        SchemaType instanceType = instanceType();
        SchemaType instanceType2 = ((SimpleValue) xmlObject).instanceType();
        if (instanceType == null && instanceType2 == null) {
            return true;
        }
        if (instanceType == null || instanceType2 == null || !comparable_value_spaces(instanceType, instanceType2)) {
            return false;
        }
        if (xmlObject.schemaType().getSimpleVariety() == 2) {
            return underlying(xmlObject).equal_to(this);
        }
        return equal_to(xmlObject);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean valueEquals(XmlObject xmlObject) {
        boolean valueEqualsImpl;
        boolean valueEqualsImpl2;
        boolean z = false;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return valueEqualsImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        valueEqualsImpl2 = valueEqualsImpl(xmlObject);
                    }
                    return valueEqualsImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return valueEqualsImpl(xmlObject);
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
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    valueEqualsImpl = valueEqualsImpl(xmlObject);
                }
                return valueEqualsImpl;
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareTo(Object obj) {
        int compareValue = compareValue((XmlObject) obj);
        if (compareValue != 2) {
            return compareValue;
        }
        throw new ClassCastException();
    }

    private final int compareValueImpl(XmlObject xmlObject) {
        SchemaType instanceType;
        SchemaType instanceType2;
        try {
            instanceType = instanceType();
            instanceType2 = ((SimpleValue) xmlObject).instanceType();
        } catch (XmlValueOutOfRangeException unused) {
        }
        if (instanceType == null && instanceType2 == null) {
            return 0;
        }
        if (instanceType != null && instanceType2 != null && instanceType.isSimpleType() && !instanceType.isURType() && instanceType2.isSimpleType() && !instanceType2.isURType()) {
            if (instanceType.getPrimitiveType().getBuiltinTypeCode() != instanceType2.getPrimitiveType().getBuiltinTypeCode()) {
                return 2;
            }
            return compare_to(xmlObject);
        }
        return 2;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareValue(XmlObject xmlObject) {
        int compareValueImpl;
        int compareValueImpl2;
        if (xmlObject == null) {
            return 2;
        }
        boolean z = false;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return compareValueImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        compareValueImpl2 = compareValueImpl(xmlObject);
                    }
                    return compareValueImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return compareValueImpl(xmlObject);
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
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    compareValueImpl = compareValueImpl(xmlObject);
                }
                return compareValueImpl;
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    protected int compare_to(XmlObject xmlObject) {
        return equal_to(xmlObject) ? 0 : 2;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int valueHashCode() {
        int value_hash_code;
        synchronized (monitor()) {
            value_hash_code = value_hash_code();
        }
        return value_hash_code;
    }

    public boolean isInstanceOf(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() != 2) {
            for (SchemaType instanceType = instanceType(); instanceType != null; instanceType = instanceType.getBaseType()) {
                if (schemaType == instanceType) {
                    return true;
                }
            }
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes()));
        for (SchemaType instanceType2 = instanceType(); instanceType2 != null; instanceType2 = instanceType2.getBaseType()) {
            if (hashSet.contains(instanceType2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!isImmutable()) {
            return super.equals(obj);
        }
        if (!(obj instanceof XmlObject)) {
            return false;
        }
        XmlObject xmlObject = (XmlObject) obj;
        if (xmlObject.isImmutable()) {
            return valueEquals(xmlObject);
        }
        return false;
    }

    public final int hashCode() {
        if (!isImmutable()) {
            return super.hashCode();
        }
        synchronized (monitor()) {
            if (isNil()) {
                return 0;
            }
            return value_hash_code();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QName qName) {
        XmlCursor newCursor = newCursor();
        try {
            if (!newCursor.isContainer()) {
                return EMPTY_RESULT;
            }
            ArrayList arrayList = new ArrayList();
            if (newCursor.toChild(qName)) {
                do {
                    arrayList.add(newCursor.getObject());
                } while (newCursor.toNextSibling(qName));
            }
            if (arrayList.size() == 0) {
                return EMPTY_RESULT;
            }
            return (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
        } finally {
            newCursor.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(String str, String str2) {
        return selectChildren(new QName(str, str2));
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QNameSet qNameSet) {
        if (qNameSet == null) {
            throw new IllegalArgumentException();
        }
        XmlCursor newCursor = newCursor();
        try {
            if (!newCursor.isContainer()) {
                return EMPTY_RESULT;
            }
            ArrayList arrayList = new ArrayList();
            if (newCursor.toFirstChild()) {
                do {
                    if (!$assertionsDisabled && !newCursor.isContainer()) {
                        throw new AssertionError();
                    }
                    if (qNameSet.contains(newCursor.getName())) {
                        arrayList.add(newCursor.getObject());
                    }
                } while (newCursor.toNextSibling());
            }
            if (arrayList.size() == 0) {
                return EMPTY_RESULT;
            }
            return (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
        } finally {
            newCursor.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(QName qName) {
        XmlCursor newCursor = newCursor();
        try {
            if (!newCursor.isContainer()) {
                return null;
            }
            if (newCursor.toFirstAttribute()) {
                while (!newCursor.getName().equals(qName)) {
                    if (!newCursor.toNextAttribute()) {
                    }
                }
                return newCursor.getObject();
            }
            return null;
        } finally {
            newCursor.dispose();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(String str, String str2) {
        return selectAttribute(new QName(str, str2));
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectAttributes(QNameSet qNameSet) {
        if (qNameSet == null) {
            throw new IllegalArgumentException();
        }
        XmlCursor newCursor = newCursor();
        try {
            if (!newCursor.isContainer()) {
                return EMPTY_RESULT;
            }
            ArrayList arrayList = new ArrayList();
            if (newCursor.toFirstAttribute()) {
                do {
                    if (qNameSet.contains(newCursor.getName())) {
                        arrayList.add(newCursor.getObject());
                    }
                } while (newCursor.toNextAttribute());
            }
            if (arrayList.size() == 0) {
                return EMPTY_RESULT;
            }
            return (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
        } finally {
            newCursor.dispose();
        }
    }

    public Object writeReplace() {
        synchronized (monitor()) {
            if (isRootXmlObject()) {
                return new SerializedRootObject(this);
            }
            return new SerializedInteriorObject(this, getRootXmlObject());
        }
    }

    private boolean isRootXmlObject() {
        XmlCursor newCursor = newCursor();
        if (newCursor == null) {
            return false;
        }
        boolean z = !newCursor.toParent();
        newCursor.dispose();
        return z;
    }

    private XmlObject getRootXmlObject() {
        XmlCursor newCursor = newCursor();
        if (newCursor == null) {
            return this;
        }
        newCursor.toStartDoc();
        XmlObject object = newCursor.getObject();
        newCursor.dispose();
        return object;
    }

    private static class SerializedRootObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient Class _xbeanClass;

        private SerializedRootObject() {
        }

        private SerializedRootObject(XmlObject xmlObject) {
            this._xbeanClass = xmlObject.schemaType().getJavaClass();
            this._impl = xmlObject;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._xbeanClass);
            objectOutputStream.writeShort(0);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeObject(this._impl.xmlText());
            objectOutputStream.writeBoolean(false);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            int i;
            String readObjectV0;
            try {
                this._xbeanClass = (Class) objectInputStream.readObject();
                int readUnsignedShort = objectInputStream.readUnsignedShort();
                int i2 = 0;
                if (readUnsignedShort == 0) {
                    i2 = objectInputStream.readUnsignedShort();
                    i = objectInputStream.readUnsignedShort();
                } else {
                    i = 0;
                }
                if (i2 == 0) {
                    readObjectV0 = readObjectV0(objectInputStream, readUnsignedShort);
                    objectInputStream.readBoolean();
                } else {
                    if (i2 != 1) {
                        throw new IOException(new StringBuffer().append("Deserialization error: version number ").append(i2).append(".").append(i).append(" not supported.").toString());
                    }
                    if (i == 1) {
                        readObjectV0 = (String) objectInputStream.readObject();
                        objectInputStream.readBoolean();
                    } else {
                        throw new IOException(new StringBuffer().append("Deserialization error: version number ").append(i2).append(".").append(i).append(" not supported.").toString());
                    }
                }
                this._impl = XmlBeans.getContextTypeLoader().parse(readObjectV0, (SchemaType) null, new XmlOptions().setDocumentType(XmlBeans.typeForClass(this._xbeanClass)));
            } catch (Exception e) {
                throw ((IOException) new IOException(e.getMessage()).initCause(e));
            }
        }

        private String readObjectV0(ObjectInputStream objectInputStream, int i) throws IOException {
            DataInputStream dataInputStream;
            Throwable th;
            byte[] bArr = new byte[i + 2];
            int i2 = 0;
            bArr[0] = (byte) ((i >> 8) & 255);
            bArr[1] = (byte) (i & 255);
            while (i2 < i) {
                int read = objectInputStream.read(bArr, i2 + 2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 != i) {
                throw new IOException(new StringBuffer().append("Error reading backwards compatible XmlObject: number of bytes read (").append(i2).append(") != number expected (").append(i).append(")").toString());
            }
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            } catch (Throwable th2) {
                dataInputStream = null;
                th = th2;
            }
            try {
                String readUTF = dataInputStream.readUTF();
                dataInputStream.close();
                return readUTF;
            } catch (Throwable th3) {
                th = th3;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        }

        private Object readResolve() throws ObjectStreamException {
            return this._impl;
        }
    }

    private static class SerializedInteriorObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient XmlObject _root;

        private SerializedInteriorObject() {
        }

        private SerializedInteriorObject(XmlObject xmlObject, XmlObject xmlObject2) {
            this._impl = xmlObject;
            this._root = xmlObject2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._root);
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeInt(distanceToRoot());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this._root = (XmlObject) objectInputStream.readObject();
            objectInputStream.readBoolean();
            this._impl = objectAtDistance(objectInputStream.readInt());
        }

        private Object readResolve() throws ObjectStreamException {
            return this._impl;
        }

        private int distanceToRoot() {
            XmlCursor newCursor = this._impl.newCursor();
            int i = 0;
            while (!newCursor.toPrevToken().isNone()) {
                if (!newCursor.currentTokenType().isNamespace()) {
                    i++;
                }
            }
            newCursor.dispose();
            return i;
        }

        private XmlObject objectAtDistance(int i) {
            XmlCursor newCursor = this._root.newCursor();
            while (i > 0) {
                newCursor.toNextToken();
                if (!newCursor.currentTokenType().isNamespace()) {
                    i--;
                }
            }
            XmlObject object = newCursor.getObject();
            newCursor.dispose();
            return object;
        }
    }

    protected static Object java_value(XmlObject xmlObject) {
        if (xmlObject.isNil()) {
            return null;
        }
        if (!(xmlObject instanceof XmlAnySimpleType)) {
            return xmlObject;
        }
        SimpleValue simpleValue = (SimpleValue) xmlObject;
        SchemaType instanceType = simpleValue.instanceType();
        boolean z = $assertionsDisabled;
        if (!z && instanceType == null) {
            throw new AssertionError("Nil case should have been handled above");
        }
        if (instanceType.getSimpleVariety() == 3) {
            return simpleValue.getListValue();
        }
        switch (instanceType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
            case 8:
            case 12:
                break;
            case 3:
                return simpleValue.getBooleanValue() ? Boolean.TRUE : Boolean.FALSE;
            case 4:
            case 5:
                return simpleValue.getByteArrayValue();
            case 6:
                return simpleValue.getStringValue();
            case 7:
                return simpleValue.getQNameValue();
            case 9:
                return new Float(simpleValue.getFloatValue());
            case 10:
                return new Double(simpleValue.getDoubleValue());
            case 11:
                int decimalSize = instanceType.getDecimalSize();
                if (decimalSize == 8) {
                    return new Byte(simpleValue.getByteValue());
                }
                if (decimalSize == 16) {
                    return new Short(simpleValue.getShortValue());
                }
                if (decimalSize == 32) {
                    return new Integer(simpleValue.getIntValue());
                }
                if (decimalSize == 64) {
                    return new Long(simpleValue.getLongValue());
                }
                switch (decimalSize) {
                    case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                        return simpleValue.getBigIntegerValue();
                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                        break;
                    default:
                        if (!z) {
                            throw new AssertionError("invalid numeric bit count");
                        }
                        break;
                }
                return simpleValue.getBigDecimalValue();
            case 13:
                return simpleValue.getGDurationValue();
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return simpleValue.getCalendarValue();
            default:
                if (!z) {
                    throw new AssertionError("encountered nonprimitive type.");
                }
                break;
        }
        return simpleValue.getStringValue();
    }

    protected XmlAnySimpleType get_default_attribute_value(QName qName) {
        SchemaLocalAttribute attribute;
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null || (attribute = attributeModel.getAttribute(qName)) == null) {
            return null;
        }
        return attribute.getDefaultValue();
    }
}
