package org.apache.xmlbeans.impl.validator;

import aavax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.impl.common.IdentityConstraint;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.JavaBooleanHolderEx;
import org.apache.xmlbeans.impl.values.JavaDecimalHolderEx;
import org.apache.xmlbeans.impl.values.JavaDoubleHolderEx;
import org.apache.xmlbeans.impl.values.JavaFloatHolderEx;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx;
import org.apache.xmlbeans.impl.values.JavaNotationHolderEx;
import org.apache.xmlbeans.impl.values.JavaQNameHolderEx;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.JavaUriHolderEx;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* loaded from: classes5.dex */
public final class Validator implements ValidatorListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$validator$Validator;
    private boolean _booleanValue;
    private byte[] _byteArrayValue;
    private IdentityConstraint _constraintEngine;
    private BigDecimal _decimalValue;
    private double _doubleValue;
    private int _eatContent;
    private Collection _errorListener;
    private int _errorState;
    private float _floatValue;
    private GDate _gdateValue;
    private GDuration _gdurationValue;
    private SchemaTypeLoader _globalTypes;
    private boolean _invalid;
    private List _listTypes;
    private List _listValue;
    private SchemaLocalAttribute _localAttribute;
    private SchemaLocalElement _localElement;
    private QName _qnameValue;
    private SchemaField _rootField;
    private SchemaType _rootType;
    private State _stateStack;
    private boolean _strict;
    private String _stringValue;
    private int _suspendErrors;
    private boolean _treatLaxAsSkip;
    private SchemaType _unionType;
    private ValidatorVC _vc;
    private LinkedList _visitorPool = new LinkedList();
    private SchemaAttributeModel _wildcardAttribute;
    private SchemaParticle _wildcardElement;

    static {
        if (class$org$apache$xmlbeans$impl$validator$Validator == null) {
            class$org$apache$xmlbeans$impl$validator$Validator = class$("org.apache.xmlbeans.impl.validator.Validator");
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

    public Validator(SchemaType schemaType, SchemaField schemaField, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection collection) {
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        this._errorListener = (Collection) maskNull.get(XmlOptions.ERROR_LISTENER);
        this._treatLaxAsSkip = maskNull.hasOption(XmlOptions.VALIDATE_TREAT_LAX_AS_SKIP);
        this._strict = maskNull.hasOption(XmlOptions.VALIDATE_STRICT);
        if (this._errorListener == null) {
            this._errorListener = collection;
        }
        this._constraintEngine = new IdentityConstraint(this._errorListener, schemaType.isDocumentType());
        this._globalTypes = schemaTypeLoader;
        this._rootType = schemaType;
        this._rootField = schemaField;
        this._vc = new ValidatorVC();
    }

    private class ValidatorVC implements ValidationContext {
        ValidatorListener.Event _event;

        private ValidatorVC() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            Validator.this.emitError(this._event, str, null, null, null, 1001, null);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            Validator.this.emitError(this._event, str, objArr, null, null, null, 1001, null);
        }
    }

    public boolean isValid() {
        return !this._invalid && this._constraintEngine.isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, QName qName, SchemaType schemaType, List list, int i, SchemaType schemaType2) {
        emitError(event, str, null, null, 0, null, qName, schemaType, list, i, schemaType2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, List list, int i, SchemaType schemaType2) {
        emitError(event, null, str, objArr, 0, null, qName, schemaType, list, i, schemaType2);
    }

    private void emitError(ValidatorListener.Event event, String str, String str2, Object[] objArr, int i, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        XmlValidationError forLocationWithDetails;
        this._errorState++;
        if (this._suspendErrors == 0) {
            if (i == 0) {
                this._invalid = true;
            }
            if (this._errorListener != null) {
                if (!$assertionsDisabled && event == null) {
                    throw new AssertionError();
                }
                XmlCursor locationAsCursor = event.getLocationAsCursor();
                if (locationAsCursor != null) {
                    forLocationWithDetails = XmlValidationError.forCursorWithDetails(str, str2, objArr, i, locationAsCursor, qName, qName2, schemaType, list, i2, schemaType2);
                } else {
                    forLocationWithDetails = XmlValidationError.forLocationWithDetails(str, str2, objArr, i, event.getLocation(), qName, qName2, schemaType, list, i2, schemaType2);
                }
                this._errorListener.add(forLocationWithDetails);
            }
        }
    }

    private void emitFieldError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, List list, int i, SchemaType schemaType2) {
        emitFieldError(event, null, str, objArr, 0, qName, schemaType, list, i, schemaType2);
    }

    private void emitFieldError(ValidatorListener.Event event, String str, String str2, Object[] objArr, int i, QName qName, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        State state = this._stateStack;
        emitError(event, str, str2, objArr, i, (state == null || state._field == null) ? null : this._stateStack._field.getName(), qName, schemaType, list, i2, schemaType2);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener
    public void nextEvent(int i, ValidatorListener.Event event) {
        resetValues();
        int i2 = this._eatContent;
        if (i2 > 0) {
            if (i == 1) {
                this._eatContent = i2 + 1;
                return;
            } else {
                if (i != 2) {
                    return;
                }
                this._eatContent = i2 - 1;
                return;
            }
        }
        if (!$assertionsDisabled && i != 1 && i != 4 && i != 2 && i != 3 && i != 5) {
            throw new AssertionError();
        }
        if (i == 1) {
            beginEvent(event);
            return;
        }
        if (i == 2) {
            endEvent(event);
            return;
        }
        if (i == 3) {
            textEvent(event);
        } else if (i == 4) {
            attrEvent(event);
        } else {
            if (i != 5) {
                return;
            }
            endAttrsEvent(event);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void beginEvent(org.apache.xmlbeans.impl.common.ValidatorListener.Event r21) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.validator.Validator.beginEvent(org.apache.xmlbeans.impl.common.ValidatorListener$Event):void");
    }

    private void attrEvent(ValidatorListener.Event event) {
        QName name = event.getName();
        State state = topState();
        if (state._attrs == null) {
            state._attrs = new HashSet();
        }
        if (state._attrs.contains(name)) {
            emitFieldError(event, XmlErrorCodes.XML_DUPLICATE_ATTRIBUTE, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        state._attrs.add(name);
        if (!state._canHaveAttrs) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NO_WILDCARD, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        SchemaLocalAttribute attribute = state._attrModel == null ? null : state._attrModel.getAttribute(name);
        if (attribute != null) {
            this._localAttribute = attribute;
            if (attribute.getUse() == 1) {
                emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$PROHIBITED_ATTRIBUTE, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
                return;
            } else {
                this._constraintEngine.attr(event, name, attribute.getType(), validateSimpleType(attribute.getType(), attribute, event, false, false));
                return;
            }
        }
        int wildcardProcess = state._attrModel.getWildcardProcess();
        this._wildcardAttribute = state._attrModel;
        if (wildcardProcess == 0) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NO_WILDCARD, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        if (!state._attrModel.getWildcardSet().contains(name)) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NOT_WILDCARD_VALID, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        if (wildcardProcess != 3) {
            if (wildcardProcess == 2 && this._treatLaxAsSkip) {
                return;
            }
            SchemaGlobalAttribute findAttribute = this._globalTypes.findAttribute(name);
            this._localAttribute = findAttribute;
            if (findAttribute != null) {
                this._constraintEngine.attr(event, name, findAttribute.getType(), validateSimpleType(findAttribute.getType(), findAttribute, event, false, false));
            } else {
                if (wildcardProcess == 2) {
                    return;
                }
                if (!$assertionsDisabled && wildcardProcess != 1) {
                    throw new AssertionError();
                }
                emitFieldError(event, XmlErrorCodes.ASSESS_ATTR_SCHEMA_VALID$NOT_RESOLVED, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            }
        }
    }

    private void endAttrsEvent(ValidatorListener.Event event) {
        State state = topState();
        if (state._attrModel != null) {
            for (SchemaLocalAttribute schemaLocalAttribute : state._attrModel.getAttributes()) {
                if (state._attrs == null || !state._attrs.contains(schemaLocalAttribute.getName())) {
                    if (schemaLocalAttribute.getUse() == 3) {
                        emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_REQUIRED_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName())}, schemaLocalAttribute.getName(), null, null, 1000, state._type);
                    } else if (schemaLocalAttribute.isDefault() || schemaLocalAttribute.isFixed()) {
                        this._constraintEngine.attr(event, schemaLocalAttribute.getName(), schemaLocalAttribute.getType(), schemaLocalAttribute.getDefaultText());
                    }
                }
            }
        }
    }

    private void endEvent(ValidatorListener.Event event) {
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        if (!state._isNil) {
            if (!state.end()) {
                findDetailedErrorEnd(event, state);
            }
            if (state._isEmpty) {
                handleText(event, true, state._field);
            }
        }
        popState(event);
        this._constraintEngine.endElement(event);
    }

    private void textEvent(ValidatorListener.Event event) {
        State state = topState();
        if (state._isNil) {
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_CONTENT, null, state._field.getName(), state._type, null, 4, state._type);
        } else {
            handleText(event, false, state._field);
        }
        state._isEmpty = false;
    }

    private void handleText(ValidatorListener.Event event, boolean z, SchemaField schemaField) {
        State state = topState();
        if (!state._sawText) {
            if (state._hasSimpleContent) {
                this._constraintEngine.text(event, state._type, validateSimpleType(state._type, schemaField, event, z, true), false);
            } else if (state._canHaveMixedContent) {
                this._constraintEngine.text(event, XmlString.type, validateSimpleType(XmlString.type, schemaField, event, z, true), false);
            } else if (z) {
                this._constraintEngine.text(event, state._type, null, true);
            } else {
                this._constraintEngine.text(event, state._type, "", false);
            }
        }
        if (!z && !state._canHaveMixedContent && !event.textIsWhitespace() && !state._hasSimpleContent) {
            if (schemaField instanceof SchemaLocalElement) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField;
                if (!$assertionsDisabled && state._type.getContentType() != 1 && state._type.getContentType() != 3) {
                    throw new AssertionError();
                }
                emitError(event, state._type.getContentType() == 1 ? XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EMPTY_WITH_CONTENT : XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$ELEMENT_ONLY_WITH_TEXT, new Object[]{QNameHelper.pretty(schemaLocalElement.getName())}, schemaLocalElement.getName(), schemaField.getType(), null, 3, null);
            } else {
                emitError(event, "Can't have mixed content", event.getName(), state._type, null, 3, null);
            }
        }
        if (z) {
            return;
        }
        state._sawText = true;
    }

    private void findDetailedErrorBegin(ValidatorListener.Event event, State state, QName qName) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : state._type.getElementProperties()) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        ArrayList arrayList3 = arrayList.size() > 0 ? arrayList : arrayList2;
        if (arrayList3.size() <= 0) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$ELEMENT_NOT_ALLOWED, new Object[]{QNameHelper.pretty(qName)}, qName, null, null, 1, state._type);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            stringBuffer.append(QNameHelper.pretty((QName) it.next()));
            if (it.hasNext()) {
                stringBuffer.append(StringUtils.SPACE);
            }
        }
        emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EXPECTED_DIFFERENT_ELEMENT, new Object[]{new Integer(arrayList3.size()), stringBuffer.toString(), QNameHelper.pretty(qName)}, qName, null, arrayList3, 1, state._type);
    }

    private void findDetailedErrorEnd(ValidatorListener.Event event, State state) {
        SchemaProperty[] elementProperties = state._type.getElementProperties();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : elementProperties) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        ArrayList arrayList3 = arrayList.size() > 0 ? arrayList : arrayList2;
        if (arrayList3.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                stringBuffer.append(QNameHelper.pretty((QName) it.next()));
                if (it.hasNext()) {
                    stringBuffer.append(StringUtils.SPACE);
                }
            }
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_ELEMENT, new Object[]{new Integer(arrayList3.size()), stringBuffer.toString()}, null, null, arrayList3, 1, state._type);
            return;
        }
        emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EXPECTED_ELEMENT, null, null, null, null, 2, state._type);
    }

    private final class State {
        static final /* synthetic */ boolean $assertionsDisabled;
        SchemaAttributeModel _attrModel;
        HashSet _attrs;
        boolean _canHaveAttrs;
        boolean _canHaveElements;
        boolean _canHaveMixedContent;
        SchemaField _field;
        boolean _hasSimpleContent;
        boolean _isEmpty;
        boolean _isNil;
        State _next;
        boolean _sawText;
        SchemaType _type;
        SchemaTypeVisitorImpl _visitor;

        static {
            if (Validator.class$org$apache$xmlbeans$impl$validator$Validator == null) {
                Validator.class$org$apache$xmlbeans$impl$validator$Validator = Validator.class$("org.apache.xmlbeans.impl.validator.Validator");
            } else {
                Class cls = Validator.class$org$apache$xmlbeans$impl$validator$Validator;
            }
            $assertionsDisabled = true;
        }

        private State() {
        }

        boolean visit(QName qName) {
            return this._canHaveElements && this._visitor.visit(qName);
        }

        boolean test(QName qName) {
            return this._canHaveElements && this._visitor.testValid(qName);
        }

        boolean end() {
            return !this._canHaveElements || this._visitor.visit(null);
        }

        SchemaParticle currentParticle() {
            if ($assertionsDisabled || this._visitor != null) {
                return this._visitor.currentParticle();
            }
            throw new AssertionError();
        }
    }

    private boolean derivedFromInteger(SchemaType schemaType) {
        int builtinTypeCode = schemaType.getBuiltinTypeCode();
        while (builtinTypeCode == 0) {
            schemaType = schemaType.getBaseType();
            builtinTypeCode = schemaType.getBuiltinTypeCode();
        }
        return builtinTypeCode >= 22 && builtinTypeCode <= 34;
    }

    private void newState(SchemaType schemaType, SchemaField schemaField, boolean z) {
        State state = new State();
        state._type = schemaType;
        state._field = schemaField;
        state._isEmpty = true;
        state._isNil = z;
        if (schemaType.isSimpleType()) {
            state._hasSimpleContent = true;
        } else {
            state._canHaveAttrs = true;
            state._attrModel = schemaType.getAttributeModel();
            int contentType = schemaType.getContentType();
            if (contentType != 1) {
                if (contentType == 2) {
                    state._hasSimpleContent = true;
                } else {
                    if (contentType != 3) {
                        if (contentType == 4) {
                            state._canHaveMixedContent = true;
                        } else {
                            throw new RuntimeException("Unexpected content type");
                        }
                    }
                    SchemaParticle contentModel = schemaType.getContentModel();
                    state._canHaveElements = contentModel != null;
                    if (state._canHaveElements) {
                        state._visitor = initVisitor(contentModel);
                    }
                }
            }
        }
        pushState(state);
    }

    private void popState(ValidatorListener.Event event) {
        if (this._stateStack._visitor != null) {
            poolVisitor(this._stateStack._visitor);
            this._stateStack._visitor = null;
        }
        this._stateStack = this._stateStack._next;
    }

    private void pushState(State state) {
        state._next = this._stateStack;
        this._stateStack = state;
    }

    private void poolVisitor(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
        this._visitorPool.add(schemaTypeVisitorImpl);
    }

    private SchemaTypeVisitorImpl initVisitor(SchemaParticle schemaParticle) {
        if (this._visitorPool.isEmpty()) {
            return new SchemaTypeVisitorImpl(schemaParticle);
        }
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = (SchemaTypeVisitorImpl) this._visitorPool.removeLast();
        schemaTypeVisitorImpl.init(schemaParticle);
        return schemaTypeVisitorImpl;
    }

    private State topState() {
        return this._stateStack;
    }

    private String validateSimpleType(SchemaType schemaType, SchemaField schemaField, ValidatorListener.Event event, boolean z, boolean z2) {
        String str;
        String str2;
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
        if (schemaType.isNoType()) {
            emitError(event, schemaField.isAttribute() ? XmlErrorCodes.ATTR_LOCALLY_VALID$NO_TYPE : XmlErrorCodes.ELEM_LOCALLY_VALID$NO_TYPE, null, schemaField.getName(), schemaType, null, 3, null);
            return null;
        }
        if (z) {
            str = "";
        } else {
            int whiteSpaceRule = schemaType.getWhiteSpaceRule();
            str = whiteSpaceRule == 1 ? event.getText() : event.getText(whiteSpaceRule);
        }
        if (str.length() == 0 && z2 && schemaField != null && (schemaField.isDefault() || schemaField.isFixed())) {
            if (XmlQName.type.isAssignableFrom(schemaType)) {
                emitError(event, new StringBuffer().append("Default QName values are unsupported for ").append(QNameHelper.readable(schemaType)).append(" - ignoring.").toString(), null, null, 2, schemaField.getName(), null, schemaType, null, 3, null);
                return null;
            }
            String collapse = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
            if (validateSimpleType(schemaType, collapse, event)) {
                return collapse;
            }
            return null;
        }
        if (!validateSimpleType(schemaType, str, event)) {
            return null;
        }
        if (schemaField != null && schemaField.isFixed()) {
            String collapse2 = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
            if (!validateSimpleType(schemaType, collapse2, event)) {
                return null;
            }
            if (!schemaType.newValue(str).valueEquals(schemaType.newValue(collapse2))) {
                if (schemaField.isAttribute()) {
                    emitError(event, XmlErrorCodes.ATTR_LOCALLY_VALID$FIXED, new Object[]{str, collapse2, QNameHelper.pretty(event.getName())}, null, schemaField.getType(), null, 3, null);
                } else {
                    if (schemaField.getType().getContentType() == 4) {
                        str2 = XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_VALID_MIXED_CONTENT;
                    } else if (schemaType.isSimpleType()) {
                        str2 = XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_VALID_SIMPLE_TYPE;
                    } else {
                        if (!$assertionsDisabled) {
                            throw new AssertionError("Element with fixed may not be EMPTY or ELEMENT_ONLY");
                        }
                        str2 = null;
                    }
                    emitError(event, str2, new Object[]{str, collapse2}, schemaField.getName(), schemaField.getType(), null, 3, null);
                }
                return null;
            }
        }
        return str;
    }

    private boolean validateSimpleType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            if ($assertionsDisabled) {
                throw new RuntimeException("Not a simple type");
            }
            throw new AssertionError();
        }
        int i = this._errorState;
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 1) {
            validateAtomicType(schemaType, str, event);
        } else if (simpleVariety == 2) {
            validateUnionType(schemaType, str, event);
        } else if (simpleVariety == 3) {
            validateListType(schemaType, str, event);
        } else {
            throw new RuntimeException("Unexpected simple variety");
        }
        return i == this._errorState;
    }

    private void validateAtomicType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!$assertionsDisabled && schemaType.getSimpleVariety() != 1) {
            throw new AssertionError();
        }
        int i = this._errorState;
        this._vc._event = event;
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                this._stringValue = str;
                return;
            case 3:
                this._booleanValue = JavaBooleanHolderEx.validateLexical(str, schemaType, this._vc);
                return;
            case 4:
                byte[] validateLexical = JavaBase64HolderEx.validateLexical(str, schemaType, this._vc);
                if (validateLexical != null) {
                    JavaBase64HolderEx.validateValue(validateLexical, schemaType, this._vc);
                }
                this._byteArrayValue = validateLexical;
                return;
            case 5:
                byte[] validateLexical2 = JavaHexBinaryHolderEx.validateLexical(str, schemaType, this._vc);
                if (validateLexical2 != null) {
                    JavaHexBinaryHolderEx.validateValue(validateLexical2, schemaType, this._vc);
                }
                this._byteArrayValue = validateLexical2;
                return;
            case 6:
                JavaUriHolderEx.validateLexical(str, schemaType, this._vc);
                if (this._strict) {
                    try {
                        XsTypeConverter.lexAnyURI(str);
                    } catch (InvalidLexicalValueException unused) {
                        this._vc.invalid(XmlErrorCodes.ANYURI, new Object[]{str});
                    }
                }
                this._stringValue = str;
                return;
            case 7:
                QName validateLexical3 = JavaQNameHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i == this._errorState) {
                    JavaQNameHolderEx.validateValue(validateLexical3, schemaType, this._vc);
                }
                this._qnameValue = validateLexical3;
                return;
            case 8:
                QName validateLexical4 = JavaNotationHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i == this._errorState) {
                    JavaNotationHolderEx.validateValue(validateLexical4, schemaType, this._vc);
                }
                this._qnameValue = validateLexical4;
                return;
            case 9:
                float validateLexical5 = JavaFloatHolderEx.validateLexical(str, schemaType, this._vc);
                if (i == this._errorState) {
                    JavaFloatHolderEx.validateValue(validateLexical5, schemaType, this._vc);
                }
                this._floatValue = validateLexical5;
                return;
            case 10:
                double validateLexical6 = JavaDoubleHolderEx.validateLexical(str, schemaType, this._vc);
                if (i == this._errorState) {
                    JavaDoubleHolderEx.validateValue(validateLexical6, schemaType, this._vc);
                }
                this._doubleValue = validateLexical6;
                return;
            case 11:
                JavaDecimalHolderEx.validateLexical(str, schemaType, this._vc);
                if (derivedFromInteger(schemaType) && str.lastIndexOf(46) >= 0) {
                    this._vc.invalid(XmlErrorCodes.INTEGER, new Object[]{str});
                }
                if (i == this._errorState) {
                    BigDecimal bigDecimal = new BigDecimal(str);
                    this._decimalValue = bigDecimal;
                    JavaDecimalHolderEx.validateValue(bigDecimal, schemaType, this._vc);
                    return;
                }
                return;
            case 12:
                JavaStringEnumerationHolderEx.validateLexical(str, schemaType, this._vc);
                this._stringValue = str;
                return;
            case 13:
                GDuration validateLexical7 = XmlDurationImpl.validateLexical(str, schemaType, this._vc);
                if (validateLexical7 != null) {
                    XmlDurationImpl.validateValue(validateLexical7, schemaType, this._vc);
                }
                this._gdurationValue = validateLexical7;
                return;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                break;
            case 21:
                if (this._strict && str.length() == 6 && str.charAt(4) == '-' && str.charAt(5) == '-') {
                    this._vc.invalid("date", new Object[]{str});
                    break;
                }
                break;
            default:
                throw new RuntimeException("Unexpected primitive type code");
        }
        GDate validateLexical8 = XmlDateImpl.validateLexical(str, schemaType, this._vc);
        if (validateLexical8 != null) {
            XmlDateImpl.validateValue(validateLexical8, schemaType, this._vc);
        }
        this._gdateValue = validateLexical8;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0139 A[LOOP:0: B:20:0x0136->B:22:0x0139, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void validateListType(org.apache.xmlbeans.SchemaType r22, java.lang.String r23, org.apache.xmlbeans.impl.common.ValidatorListener.Event r24) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.validator.Validator.validateListType(org.apache.xmlbeans.SchemaType, java.lang.String, org.apache.xmlbeans.impl.common.ValidatorListener$Event):void");
    }

    private void validateUnionType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.matchPatternFacet(str)) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
        }
        SchemaType[] unionMemberTypes = schemaType.getUnionMemberTypes();
        int i = this._errorState;
        String str2 = str;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            if (i2 >= unionMemberTypes.length) {
                break;
            }
            int whiteSpaceRule = unionMemberTypes[i2].getWhiteSpaceRule();
            if (whiteSpaceRule == 0) {
                whiteSpaceRule = 1;
            }
            if (whiteSpaceRule != i3) {
                str2 = XmlWhitespace.collapse(str, whiteSpaceRule);
                i3 = whiteSpaceRule;
            }
            int i4 = this._errorState;
            this._suspendErrors++;
            try {
                validateSimpleType(unionMemberTypes[i2], str2, event);
                this._suspendErrors--;
                if (i4 == this._errorState) {
                    this._unionType = unionMemberTypes[i2];
                    break;
                }
                i2++;
            } catch (Throwable th) {
                this._suspendErrors--;
                throw th;
            }
        }
        this._errorState = i;
        if (i2 >= unionMemberTypes.length) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
            return;
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            NamespaceContext.push(new NamespaceContext(event));
            try {
                try {
                    XmlAnySimpleType newValue = schemaType.newValue(str);
                    int i5 = 0;
                    while (i5 < enumerationValues.length && !newValue.valueEquals(enumerationValues[i5])) {
                        i5++;
                    }
                    if (i5 >= enumerationValues.length) {
                        emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
                    }
                } catch (XmlValueOutOfRangeException unused) {
                    emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
                }
            } finally {
                NamespaceContext.pop();
            }
        }
    }

    private void addToList(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() == 1 || schemaType.getSimpleVariety() == 2) {
            if (schemaType.getUnionMemberTypes().length > 0 && getUnionType() != null) {
                schemaType = getUnionType();
                this._unionType = null;
            }
            this._listTypes.add(schemaType);
            if (schemaType.getPrimitiveType() == null) {
                this._listValue.add(null);
                return;
            }
            switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                case 2:
                    this._listValue.add(this._stringValue);
                    return;
                case 3:
                    this._listValue.add(this._booleanValue ? Boolean.TRUE : Boolean.FALSE);
                    this._booleanValue = false;
                    return;
                case 4:
                    this._listValue.add(this._byteArrayValue);
                    this._byteArrayValue = null;
                    return;
                case 5:
                    this._listValue.add(this._byteArrayValue);
                    this._byteArrayValue = null;
                    return;
                case 6:
                    this._listTypes.add(this._stringValue);
                    return;
                case 7:
                    this._listValue.add(this._qnameValue);
                    this._qnameValue = null;
                    return;
                case 8:
                    this._listValue.add(this._qnameValue);
                    this._qnameValue = null;
                    return;
                case 9:
                    this._listValue.add(new Float(this._floatValue));
                    this._floatValue = 0.0f;
                    return;
                case 10:
                    this._listValue.add(new Double(this._doubleValue));
                    this._doubleValue = 0.0d;
                    return;
                case 11:
                    this._listValue.add(this._decimalValue);
                    this._decimalValue = null;
                    return;
                case 12:
                    this._listValue.add(this._stringValue);
                    this._stringValue = null;
                    return;
                case 13:
                    this._listValue.add(this._gdurationValue);
                    this._gdurationValue = null;
                    return;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    this._listValue.add(this._gdateValue);
                    this._gdateValue = null;
                    return;
                default:
                    throw new RuntimeException("Unexpected primitive type code");
            }
        }
    }

    private void resetValues() {
        this._localAttribute = null;
        this._wildcardAttribute = null;
        this._stringValue = null;
        this._decimalValue = null;
        this._booleanValue = false;
        this._floatValue = 0.0f;
        this._doubleValue = 0.0d;
        this._qnameValue = null;
        this._gdateValue = null;
        this._gdurationValue = null;
        this._byteArrayValue = null;
        this._listValue = null;
        this._listTypes = null;
        this._unionType = null;
        this._localAttribute = null;
    }

    public SchemaType getCurrentElementSchemaType() {
        State state = topState();
        if (state != null) {
            return state._type;
        }
        return null;
    }

    public SchemaLocalElement getCurrentElement() {
        State state;
        SchemaLocalElement schemaLocalElement = this._localElement;
        if (schemaLocalElement != null) {
            return schemaLocalElement;
        }
        if (this._eatContent <= 0 && (state = this._stateStack) != null && (state._field instanceof SchemaLocalElement)) {
            return (SchemaLocalElement) this._stateStack._field;
        }
        return null;
    }

    public SchemaParticle getCurrentWildcardElement() {
        return this._wildcardElement;
    }

    public SchemaLocalAttribute getCurrentAttribute() {
        return this._localAttribute;
    }

    public SchemaAttributeModel getCurrentWildcardAttribute() {
        return this._wildcardAttribute;
    }

    public String getStringValue() {
        return this._stringValue;
    }

    public BigDecimal getDecimalValue() {
        return this._decimalValue;
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public float getFloatValue() {
        return this._floatValue;
    }

    public double getDoubleValue() {
        return this._doubleValue;
    }

    public QName getQNameValue() {
        return this._qnameValue;
    }

    public GDate getGDateValue() {
        return this._gdateValue;
    }

    public GDuration getGDurationValue() {
        return this._gdurationValue;
    }

    public byte[] getByteArrayValue() {
        return this._byteArrayValue;
    }

    public List getListValue() {
        return this._listValue;
    }

    public List getListTypes() {
        return this._listTypes;
    }

    public SchemaType getUnionType() {
        return this._unionType;
    }
}
