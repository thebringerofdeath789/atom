package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeElementSequencer;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.StringEnumValue;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeRestriction;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriRestriction;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryImpl;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlBooleanImpl;
import org.apache.xmlbeans.impl.values.XmlBooleanRestriction;
import org.apache.xmlbeans.impl.values.XmlByteImpl;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalRestriction;
import org.apache.xmlbeans.impl.values.XmlDoubleImpl;
import org.apache.xmlbeans.impl.values.XmlDoubleRestriction;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlEntitiesImpl;
import org.apache.xmlbeans.impl.values.XmlEntityImpl;
import org.apache.xmlbeans.impl.values.XmlFloatImpl;
import org.apache.xmlbeans.impl.values.XmlFloatRestriction;
import org.apache.xmlbeans.impl.values.XmlGDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthImpl;
import org.apache.xmlbeans.impl.values.XmlGYearImpl;
import org.apache.xmlbeans.impl.values.XmlGYearMonthImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlIdImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefsImpl;
import org.apache.xmlbeans.impl.values.XmlIntImpl;
import org.apache.xmlbeans.impl.values.XmlIntRestriction;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlIntegerRestriction;
import org.apache.xmlbeans.impl.values.XmlLanguageImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlLongImpl;
import org.apache.xmlbeans.impl.values.XmlLongRestriction;
import org.apache.xmlbeans.impl.values.XmlNCNameImpl;
import org.apache.xmlbeans.impl.values.XmlNameImpl;
import org.apache.xmlbeans.impl.values.XmlNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokenImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokensImpl;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNonPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNormalizedStringImpl;
import org.apache.xmlbeans.impl.values.XmlNotationImpl;
import org.apache.xmlbeans.impl.values.XmlNotationRestriction;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;
import org.apache.xmlbeans.impl.values.XmlQNameRestriction;
import org.apache.xmlbeans.impl.values.XmlShortImpl;
import org.apache.xmlbeans.impl.values.XmlStringEnumeration;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlStringRestriction;
import org.apache.xmlbeans.impl.values.XmlTimeImpl;
import org.apache.xmlbeans.impl.values.XmlTokenImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedByteImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedIntImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedLongImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedShortImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* loaded from: classes5.dex */
public final class SchemaTypeImpl implements SchemaType, TypeStoreUserFactory {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int JAVAIZED = 6;
    private static final int JAVAIZING = 5;
    private static final SchemaProperty[] NO_PROPERTIES;
    private static final int RESOLVED = 4;
    private static final int RESOLVED_SGS = 2;
    private static final int RESOLVING = 3;
    private static final int RESOLVING_SGS = 1;
    private static final int UNRESOLVED = 0;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaType;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeImpl;
    private boolean _abs;
    private SchemaAnnotation _annotation;
    private SchemaType.Ref[] _anonymousTyperefs;
    private int _anonymousUnionMemberOrdinal;
    private String _attFormDefault;
    private volatile Map _attrToIndexMap;
    private SchemaAttributeModel _attributeModel;
    private int _baseDepth;
    private SchemaType.Ref _baseEnumTyperef;
    private SchemaType.Ref _baseTyperef;
    private boolean _blockExt;
    private boolean _blockRest;
    private int _builtinTypeCode;
    private boolean _chameleon;
    private int _complexTypeVariety;
    private SchemaContainer _container;
    private volatile SchemaField _containerField;
    private volatile int _containerFieldCode;
    private volatile int _containerFieldIndex;
    private volatile SchemaComponent.Ref _containerFieldRef;
    private SchemaType.Ref _contentBasedOnTyperef;
    private SchemaParticle _contentModel;
    private int _decimalSize;
    private int _derivationType;
    private String _elemFormDefault;
    private volatile Map _eltToIndexMap;
    private XmlValueRef[] _enumerationValues;
    private XmlValueRef[] _facetArray;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalList;
    private boolean _finalRest;
    private boolean _finalUnion;
    private boolean[] _fixedFacetArray;
    private String _fullJavaImplName;
    private String _fullJavaName;
    private volatile QName[] _groupReferenceContext;
    private boolean _hasAllContent;
    private boolean _hasPatterns;
    private boolean _hasWildcardAttributes;
    private boolean _hasWildcardElements;
    private volatile boolean _implNotAvailable;
    private InterfaceExtension[] _interfaces;
    private boolean _isAttributeType;
    private boolean _isBounded;
    private boolean _isCompiled;
    private boolean _isDocumentType;
    private boolean _isFinite;
    private boolean _isNumeric;
    private boolean _isSimpleType;
    private boolean _isUnionOfLists;
    private volatile Class _javaClass;
    private volatile Class _javaEnumClass;
    private volatile Class _javaImplClass;
    private volatile Constructor _javaImplConstructor;
    private volatile Constructor _javaImplConstructor2;
    private SchemaType.Ref _listItemTyperef;
    private volatile List _listOfStringEnum;
    private volatile SchemaLocalElement[] _localElts;
    private volatile Map _lookupStringEnum;
    private volatile Map _lookupStringEnumEntry;
    private QName _name;
    private boolean _orderSensitive;
    private int _ordered;
    private SchemaType.Ref _outerSchemaTypeRef;
    private XmlObject _parseObject;
    private String _parseTNS;
    private RegularExpression[] _patterns;
    private PrePostExtension _prepost;
    private SchemaType.Ref _primitiveTypeRef;
    private Map _propertyModelByAttributeName;
    private Map _propertyModelByElementName;
    private boolean _redefinition;
    private int _resolvePhase;
    private QName _sg;
    private String _shortJavaImplName;
    private String _shortJavaName;
    private int _simpleTypeVariety;
    private boolean _stringEnumEnsured;
    private SchemaStringEnumEntry[] _stringEnumEntries;
    private QNameSet _typedWildcardAttributes;
    private QNameSet _typedWildcardElements;
    private volatile SchemaType _unionCommonBaseType;
    private volatile SchemaType[] _unionConstituentTypes;
    private SchemaType.Ref[] _unionMemberTyperefs;
    private volatile SchemaType[] _unionSubTypes;
    private volatile boolean _unloaded;
    private volatile Object _userData;
    private volatile Class _userTypeClass;
    private String _userTypeHandler;
    private volatile Class _userTypeHandlerClass;
    private String _userTypeName;
    private int _whiteSpaceRule;
    private final Object[] _ctrArgs = {this};
    private Set _validSubstitutions = Collections.EMPTY_SET;
    private List _sgMembers = new ArrayList();
    private SchemaType.Ref _selfref = new SchemaType.Ref(this);

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 0;
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeImpl = class$("org.apache.xmlbeans.impl.schema.SchemaTypeImpl");
        }
        $assertionsDisabled = true;
        NO_PROPERTIES = new SchemaProperty[0];
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public boolean isUnloaded() {
        return this._unloaded;
    }

    public void finishLoading() {
        this._unloaded = false;
    }

    SchemaTypeImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    SchemaTypeImpl(SchemaContainer schemaContainer, boolean z) {
        this._container = schemaContainer;
        this._unloaded = z;
        if (z) {
            finishQuick();
        }
    }

    public boolean isSGResolved() {
        return this._resolvePhase >= 2;
    }

    public boolean isSGResolving() {
        return this._resolvePhase >= 1;
    }

    public boolean isResolved() {
        return this._resolvePhase >= 4;
    }

    public boolean isResolving() {
        return this._resolvePhase == 3;
    }

    public boolean isUnjavaized() {
        return this._resolvePhase < 6;
    }

    public boolean isJavaized() {
        return this._resolvePhase == 6;
    }

    public void startResolvingSGs() {
        if (this._resolvePhase != 0) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 1;
    }

    public void finishResolvingSGs() {
        if (this._resolvePhase != 1) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 2;
    }

    public void startResolving() {
        boolean z = this._isDocumentType;
        if ((z && this._resolvePhase != 2) || (!z && this._resolvePhase != 0)) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 3;
    }

    public void finishResolving() {
        if (this._resolvePhase != 3) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 4;
    }

    public void startJavaizing() {
        if (this._resolvePhase != 4) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 5;
    }

    public void finishJavaizing() {
        if (this._resolvePhase != 5) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 6;
    }

    private void finishQuick() {
        this._resolvePhase = 6;
    }

    private void assertUnresolved() {
        if (this._resolvePhase != 0 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertSGResolving() {
        if (this._resolvePhase != 1 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertSGResolved() {
        if (this._resolvePhase != 2 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertResolving() {
        if (this._resolvePhase != 3 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertResolved() {
        if (this._resolvePhase != 4 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertJavaizing() {
        if (this._resolvePhase != 5 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    @Override // org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        assertUnresolved();
        this._name = qName;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        String str = this._filename;
        if (str != null) {
            return str;
        }
        if (getOuterType() != null) {
            return getOuterType().getSourceName();
        }
        SchemaField containerField = getContainerField();
        if (containerField == null) {
            return null;
        }
        if (containerField instanceof SchemaGlobalElement) {
            return ((SchemaGlobalElement) containerField).getSourceName();
        }
        if (containerField instanceof SchemaGlobalAttribute) {
            return ((SchemaGlobalAttribute) containerField).getSourceName();
        }
        return null;
    }

    public void setFilename(String str) {
        assertUnresolved();
        this._filename = str;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAnonymousType() {
        return this._name == null;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isDocumentType() {
        return this._isDocumentType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAttributeType() {
        return this._isAttributeType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QName getDocumentElementName() {
        SchemaParticle contentModel;
        if (!this._isDocumentType || (contentModel = getContentModel()) == null) {
            return null;
        }
        return contentModel.getName();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QName getAttributeTypeAttributeName() {
        SchemaAttributeModel attributeModel;
        SchemaLocalAttribute[] attributes;
        if (!this._isAttributeType || (attributeModel = getAttributeModel()) == null || (attributes = attributeModel.getAttributes()) == null || attributes.length <= 0) {
            return null;
        }
        return attributes[0].getName();
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        assertUnresolved();
        this._annotation = schemaAnnotation;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public void setDocumentType(boolean z) {
        assertUnresolved();
        this._isDocumentType = z;
    }

    public void setAttributeType(boolean z) {
        assertUnresolved();
        this._isAttributeType = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getContentType() {
        return this._complexTypeVariety;
    }

    public void setComplexTypeVariety(int i) {
        assertResolving();
        this._complexTypeVariety = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaTypeElementSequencer getElementSequencer() {
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = null;
        byte b = 0;
        byte b2 = 0;
        if (this._complexTypeVariety == 0) {
            return new SequencerImpl(schemaTypeVisitorImpl);
        }
        return new SequencerImpl(new SchemaTypeVisitorImpl(this._contentModel));
    }

    void setAbstractFinal(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        assertResolving();
        this._abs = z;
        this._finalExt = z2;
        this._finalRest = z3;
        this._finalList = z4;
        this._finalUnion = z5;
    }

    void setSimpleFinal(boolean z, boolean z2, boolean z3) {
        assertResolving();
        this._finalRest = z;
        this._finalList = z2;
        this._finalUnion = z3;
    }

    void setBlock(boolean z, boolean z2) {
        assertResolving();
        this._blockExt = z;
        this._blockRest = z2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean blockRestriction() {
        return this._blockRest;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean blockExtension() {
        return this._blockExt;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAbstract() {
        return this._abs;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalExtension() {
        return this._finalExt;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalRestriction() {
        return this._finalRest;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalList() {
        return this._finalList;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalUnion() {
        return this._finalUnion;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaField getContainerField() {
        if (this._containerFieldCode != -1) {
            SchemaType outerType = getOuterType();
            if (this._containerFieldCode == 0) {
                this._containerField = this._containerFieldRef == null ? null : (SchemaField) this._containerFieldRef.getComponent();
            } else if (this._containerFieldCode == 1) {
                this._containerField = outerType.getAttributeModel().getAttributes()[this._containerFieldIndex];
            } else {
                this._containerField = ((SchemaTypeImpl) outerType).getLocalElementByIndex(this._containerFieldIndex);
            }
            this._containerFieldCode = -1;
        }
        return this._containerField;
    }

    public void setContainerField(SchemaField schemaField) {
        assertUnresolved();
        this._containerField = schemaField;
        this._containerFieldCode = -1;
    }

    public void setContainerFieldRef(SchemaComponent.Ref ref) {
        assertUnresolved();
        this._containerFieldRef = ref;
        this._containerFieldCode = 0;
    }

    public void setContainerFieldIndex(short s, int i) {
        assertUnresolved();
        this._containerFieldCode = s;
        this._containerFieldIndex = i;
    }

    void setGroupReferenceContext(QName[] qNameArr) {
        assertUnresolved();
        this._groupReferenceContext = qNameArr;
    }

    QName[] getGroupReferenceContext() {
        return this._groupReferenceContext;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getOuterType() {
        SchemaType.Ref ref = this._outerSchemaTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setOuterSchemaTypeRef(SchemaType.Ref ref) {
        assertUnresolved();
        this._outerSchemaTypeRef = ref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isCompiled() {
        return this._isCompiled;
    }

    public void setCompiled(boolean z) {
        assertJavaizing();
        this._isCompiled = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isSkippedAnonymousType() {
        SchemaType outerType = getOuterType();
        if (outerType == null) {
            return false;
        }
        return outerType.getBaseType() == this || outerType.getContentBasedOnType() == this;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getShortJavaName() {
        return this._shortJavaName;
    }

    public void setShortJavaName(String str) {
        assertResolved();
        this._shortJavaName = str;
        SchemaType schemaType = this._outerSchemaTypeRef.get();
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getOuterType();
        }
        this._fullJavaName = new StringBuffer().append(schemaType.getFullJavaName()).append("$").append(this._shortJavaName).toString();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getFullJavaName() {
        return this._fullJavaName;
    }

    public void setFullJavaName(String str) {
        assertResolved();
        this._fullJavaName = str;
        this._shortJavaName = this._fullJavaName.substring(Math.max(str.lastIndexOf(36), this._fullJavaName.lastIndexOf(46)) + 1);
    }

    public void setShortJavaImplName(String str) {
        assertResolved();
        this._shortJavaImplName = str;
        SchemaType schemaType = this._outerSchemaTypeRef.get();
        while (schemaType.getFullJavaImplName() == null) {
            schemaType = schemaType.getOuterType();
        }
        this._fullJavaImplName = new StringBuffer().append(schemaType.getFullJavaImplName()).append("$").append(this._shortJavaImplName).toString();
    }

    public void setFullJavaImplName(String str) {
        assertResolved();
        this._fullJavaImplName = str;
        this._shortJavaImplName = this._fullJavaImplName.substring(Math.max(str.lastIndexOf(36), this._fullJavaImplName.lastIndexOf(46)) + 1);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getFullJavaImplName() {
        return this._fullJavaImplName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getShortJavaImplName() {
        return this._shortJavaImplName;
    }

    public String getUserTypeName() {
        return this._userTypeName;
    }

    public void setUserTypeName(String str) {
        this._userTypeName = str;
    }

    public String getUserTypeHandlerName() {
        return this._userTypeHandler;
    }

    public void setUserTypeHandlerName(String str) {
        this._userTypeHandler = str;
    }

    public void setInterfaceExtensions(InterfaceExtension[] interfaceExtensionArr) {
        assertResolved();
        this._interfaces = interfaceExtensionArr;
    }

    public InterfaceExtension[] getInterfaceExtensions() {
        return this._interfaces;
    }

    public void setPrePostExtension(PrePostExtension prePostExtension) {
        assertResolved();
        this._prepost = prePostExtension;
    }

    public PrePostExtension getPrePostExtension() {
        return this._prepost;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Object getUserData() {
        return this._userData;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    void setContainer(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    @Override // org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaParticle getContentModel() {
        return this._contentModel;
    }

    private static void buildEltList(List list, SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType != 4) {
                return;
            }
            list.add(schemaParticle);
        } else {
            for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
                buildEltList(list, schemaParticle.getParticleChild(i));
            }
        }
    }

    private void buildLocalElts() {
        ArrayList arrayList = new ArrayList();
        buildEltList(arrayList, this._contentModel);
        this._localElts = (SchemaLocalElement[]) arrayList.toArray(new SchemaLocalElement[arrayList.size()]);
    }

    public SchemaLocalElement getLocalElementByIndex(int i) {
        SchemaLocalElement[] schemaLocalElementArr = this._localElts;
        if (schemaLocalElementArr == null) {
            buildLocalElts();
            schemaLocalElementArr = this._localElts;
        }
        return schemaLocalElementArr[i];
    }

    public int getIndexForLocalElement(SchemaLocalElement schemaLocalElement) {
        Map map = this._eltToIndexMap;
        if (map == null) {
            if (this._localElts == null) {
                buildLocalElts();
            }
            map = new HashMap();
            for (int i = 0; i < this._localElts.length; i++) {
                map.put(this._localElts[i], new Integer(i));
            }
            this._eltToIndexMap = map;
        }
        return ((Integer) map.get(schemaLocalElement)).intValue();
    }

    public int getIndexForLocalAttribute(SchemaLocalAttribute schemaLocalAttribute) {
        Map map = this._attrToIndexMap;
        if (map == null) {
            map = new HashMap();
            SchemaLocalAttribute[] attributes = this._attributeModel.getAttributes();
            for (int i = 0; i < attributes.length; i++) {
                map.put(attributes[i], new Integer(i));
            }
            this._attrToIndexMap = map;
        }
        return ((Integer) map.get(schemaLocalAttribute)).intValue();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaAttributeModel getAttributeModel() {
        return this._attributeModel;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getProperties() {
        if (this._propertyModelByElementName == null) {
            return getAttributeProperties();
        }
        if (this._propertyModelByAttributeName == null) {
            return getElementProperties();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._propertyModelByElementName.values());
        arrayList.addAll(this._propertyModelByAttributeName.values());
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[arrayList.size()]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getDerivedProperties() {
        SchemaType baseType = getBaseType();
        if (baseType == null) {
            return getProperties();
        }
        ArrayList arrayList = new ArrayList();
        Map map = this._propertyModelByElementName;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        Map map2 = this._propertyModelByAttributeName;
        if (map2 != null) {
            arrayList.addAll(map2.values());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SchemaProperty schemaProperty = (SchemaProperty) it.next();
            SchemaProperty attributeProperty = schemaProperty.isAttribute() ? baseType.getAttributeProperty(schemaProperty.getName()) : baseType.getElementProperty(schemaProperty.getName());
            if (attributeProperty != null && eq(schemaProperty.getMinOccurs(), attributeProperty.getMinOccurs()) && eq(schemaProperty.getMaxOccurs(), attributeProperty.getMaxOccurs()) && schemaProperty.hasNillable() == attributeProperty.hasNillable() && eq(schemaProperty.getDefaultText(), attributeProperty.getDefaultText())) {
                it.remove();
            }
        }
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[arrayList.size()]);
    }

    private static boolean eq(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger == null && bigInteger2 == null) {
            return true;
        }
        if (bigInteger == null || bigInteger2 == null) {
            return false;
        }
        return bigInteger.equals(bigInteger2);
    }

    private static boolean eq(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getElementProperties() {
        Map map = this._propertyModelByElementName;
        if (map == null) {
            return NO_PROPERTIES;
        }
        return (SchemaProperty[]) map.values().toArray(new SchemaProperty[this._propertyModelByElementName.size()]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getAttributeProperties() {
        Map map = this._propertyModelByAttributeName;
        if (map == null) {
            return NO_PROPERTIES;
        }
        return (SchemaProperty[]) map.values().toArray(new SchemaProperty[this._propertyModelByAttributeName.size()]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty getElementProperty(QName qName) {
        Map map = this._propertyModelByElementName;
        if (map == null) {
            return null;
        }
        return (SchemaProperty) map.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty getAttributeProperty(QName qName) {
        Map map = this._propertyModelByAttributeName;
        if (map == null) {
            return null;
        }
        return (SchemaProperty) map.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasAllContent() {
        return this._hasAllContent;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isOrderSensitive() {
        return this._orderSensitive;
    }

    public void setOrderSensitive(boolean z) {
        assertJavaizing();
        this._orderSensitive = z;
    }

    public void setContentModel(SchemaParticle schemaParticle, SchemaAttributeModel schemaAttributeModel, Map map, Map map2, boolean z) {
        assertResolving();
        this._contentModel = schemaParticle;
        this._attributeModel = schemaAttributeModel;
        this._propertyModelByElementName = map;
        this._propertyModelByAttributeName = map2;
        this._hasAllContent = z;
        if (map != null) {
            this._validSubstitutions = new LinkedHashSet();
            Iterator it = this._propertyModelByElementName.values().iterator();
            while (it.hasNext()) {
                QName[] acceptedNames = ((SchemaProperty) it.next()).acceptedNames();
                for (int i = 0; i < acceptedNames.length; i++) {
                    if (!this._propertyModelByElementName.containsKey(acceptedNames[i])) {
                        this._validSubstitutions.add(acceptedNames[i]);
                    }
                }
            }
        }
    }

    private boolean containsElements() {
        return getContentType() == 3 || getContentType() == 4;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasAttributeWildcards() {
        return this._hasWildcardAttributes;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasElementWildcards() {
        return this._hasWildcardElements;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isValidSubstitution(QName qName) {
        return this._validSubstitutions.contains(qName);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader) {
        SchemaType type;
        SchemaType findType;
        if (isSimpleType() || !containsElements() || isNoType()) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        SchemaProperty schemaProperty = (SchemaProperty) this._propertyModelByElementName.get(qName);
        if (schemaProperty != null) {
            type = schemaProperty.getType();
        } else {
            if (schemaTypeLoader == null) {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            if (this._typedWildcardElements.contains(qName) || this._validSubstitutions.contains(qName)) {
                SchemaGlobalElement findElement = schemaTypeLoader.findElement(qName);
                if (findElement == null) {
                    return BuiltinSchemaTypeSystem.ST_NO_TYPE;
                }
                type = findElement.getType();
            } else {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
        }
        return (qName2 == null || schemaTypeLoader == null || (findType = schemaTypeLoader.findType(qName2)) == null || !type.isAssignableFrom(findType)) ? type : findType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getAttributeType(QName qName, SchemaTypeLoader schemaTypeLoader) {
        if (isSimpleType() || isNoType()) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        if (isURType()) {
            return BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        SchemaProperty schemaProperty = (SchemaProperty) this._propertyModelByAttributeName.get(qName);
        if (schemaProperty != null) {
            return schemaProperty.getType();
        }
        if (!this._typedWildcardAttributes.contains(qName) || schemaTypeLoader == null) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        SchemaGlobalAttribute findAttribute = schemaTypeLoader.findAttribute(qName);
        if (findAttribute == null) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        return findAttribute.getType();
    }

    public XmlObject createElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader) {
        SchemaType schemaType;
        SchemaProperty schemaProperty;
        SchemaType findType;
        if (isSimpleType() || !containsElements() || isNoType()) {
            schemaType = BuiltinSchemaTypeSystem.ST_NO_TYPE;
            schemaProperty = null;
        } else {
            schemaProperty = (SchemaProperty) this._propertyModelByElementName.get(qName);
            if (schemaProperty != null) {
                schemaType = schemaProperty.getType();
            } else if (this._typedWildcardElements.contains(qName) || this._validSubstitutions.contains(qName)) {
                SchemaGlobalElement findElement = schemaTypeLoader.findElement(qName);
                if (findElement != null) {
                    SchemaType type = findElement.getType();
                    SchemaType findDocumentType = schemaTypeLoader.findDocumentType(qName);
                    if (findDocumentType != null) {
                        schemaProperty = findDocumentType.getElementProperty(qName);
                    }
                    schemaType = type;
                } else {
                    schemaType = BuiltinSchemaTypeSystem.ST_NO_TYPE;
                }
            } else {
                schemaType = BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            if (qName2 != null && (findType = schemaTypeLoader.findType(qName2)) != null && schemaType.isAssignableFrom(findType)) {
                schemaType = findType;
            }
        }
        if (schemaType != null) {
            return ((SchemaTypeImpl) schemaType).createUnattachedNode(schemaProperty);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.xmlbeans.XmlObject createAttributeType(aavax.xml.namespace.QName r4, org.apache.xmlbeans.SchemaTypeLoader r5) {
        /*
            r3 = this;
            boolean r0 = r3.isSimpleType()
            r1 = 0
            if (r0 != 0) goto L43
            boolean r0 = r3.isNoType()
            if (r0 == 0) goto Le
            goto L43
        Le:
            boolean r0 = r3.isURType()
            if (r0 == 0) goto L17
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r4 = org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem.ST_ANY_SIMPLE
            goto L45
        L17:
            java.util.Map r0 = r3._propertyModelByAttributeName
            java.lang.Object r0 = r0.get(r4)
            org.apache.xmlbeans.SchemaProperty r0 = (org.apache.xmlbeans.SchemaProperty) r0
            if (r0 == 0) goto L28
            org.apache.xmlbeans.SchemaType r4 = r0.getType()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r4 = (org.apache.xmlbeans.impl.schema.SchemaTypeImpl) r4
            goto L46
        L28:
            org.apache.xmlbeans.QNameSet r2 = r3._typedWildcardAttributes
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L33
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r4 = org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem.ST_NO_TYPE
            goto L46
        L33:
            org.apache.xmlbeans.SchemaGlobalAttribute r4 = r5.findAttribute(r4)
            if (r4 == 0) goto L40
            org.apache.xmlbeans.SchemaType r4 = r4.getType()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r4 = (org.apache.xmlbeans.impl.schema.SchemaTypeImpl) r4
            goto L46
        L40:
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r4 = org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem.ST_NO_TYPE
            goto L46
        L43:
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r4 = org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem.ST_NO_TYPE
        L45:
            r0 = r1
        L46:
            if (r4 == 0) goto L4d
            org.apache.xmlbeans.XmlObject r4 = r4.createUnattachedNode(r0)
            return r4
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeImpl.createAttributeType(aavax.xml.namespace.QName, org.apache.xmlbeans.SchemaTypeLoader):org.apache.xmlbeans.XmlObject");
    }

    public void setWildcardSummary(QNameSet qNameSet, boolean z, QNameSet qNameSet2, boolean z2) {
        assertResolving();
        this._typedWildcardElements = qNameSet;
        this._hasWildcardElements = z;
        this._typedWildcardAttributes = qNameSet2;
        this._hasWildcardAttributes = z2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType[] getAnonymousTypes() {
        int length = this._anonymousTyperefs.length;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        for (int i = 0; i < length; i++) {
            schemaTypeArr[i] = this._anonymousTyperefs[i].get();
        }
        return schemaTypeArr;
    }

    public void setAnonymousTypeRefs(SchemaType.Ref[] refArr) {
        this._anonymousTyperefs = refArr;
    }

    private static SchemaType[] staCopy(SchemaType[] schemaTypeArr) {
        if (schemaTypeArr == null) {
            return null;
        }
        SchemaType[] schemaTypeArr2 = new SchemaType[schemaTypeArr.length];
        System.arraycopy(schemaTypeArr, 0, schemaTypeArr2, 0, schemaTypeArr.length);
        return schemaTypeArr2;
    }

    private static boolean[] boaCopy(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
        return zArr2;
    }

    public void setSimpleTypeVariety(int i) {
        assertResolving();
        this._simpleTypeVariety = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getSimpleVariety() {
        return this._simpleTypeVariety;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isURType() {
        int i = this._builtinTypeCode;
        return i == 1 || i == 2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isNoType() {
        return this == BuiltinSchemaTypeSystem.ST_NO_TYPE;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isSimpleType() {
        return this._isSimpleType;
    }

    public void setSimpleType(boolean z) {
        assertUnresolved();
        this._isSimpleType = z;
    }

    public boolean isUnionOfLists() {
        return this._isUnionOfLists;
    }

    public void setUnionOfLists(boolean z) {
        assertResolving();
        this._isUnionOfLists = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getPrimitiveType() {
        SchemaType.Ref ref = this._primitiveTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setPrimitiveTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._primitiveTypeRef = ref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getDecimalSize() {
        return this._decimalSize;
    }

    public void setDecimalSize(int i) {
        assertResolving();
        this._decimalSize = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getBaseType() {
        SchemaType.Ref ref = this._baseTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setBaseTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._baseTyperef = ref;
    }

    public int getBaseDepth() {
        return this._baseDepth;
    }

    public void setBaseDepth(int i) {
        assertResolving();
        this._baseDepth = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getContentBasedOnType() {
        SchemaType.Ref ref = this._contentBasedOnTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setContentBasedOnTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._contentBasedOnTyperef = ref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getDerivationType() {
        return this._derivationType;
    }

    public void setDerivationType(int i) {
        assertResolving();
        this._derivationType = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getListItemType() {
        SchemaType.Ref ref = this._listItemTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setListItemTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._listItemTyperef = ref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType[] getUnionMemberTypes() {
        SchemaType.Ref[] refArr = this._unionMemberTyperefs;
        int length = refArr == null ? 0 : refArr.length;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        for (int i = 0; i < length; i++) {
            schemaTypeArr[i] = this._unionMemberTyperefs[i].get();
        }
        return schemaTypeArr;
    }

    public void setUnionMemberTypeRefs(SchemaType.Ref[] refArr) {
        assertResolving();
        this._unionMemberTyperefs = refArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getAnonymousUnionMemberOrdinal() {
        return this._anonymousUnionMemberOrdinal;
    }

    public void setAnonymousUnionMemberOrdinal(int i) {
        assertUnresolved();
        this._anonymousUnionMemberOrdinal = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType[] getUnionConstituentTypes() {
        if (this._unionCommonBaseType == null) {
            computeFlatUnionModel();
        }
        return staCopy(this._unionConstituentTypes);
    }

    private void setUnionConstituentTypes(SchemaType[] schemaTypeArr) {
        this._unionConstituentTypes = schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType[] getUnionSubTypes() {
        if (this._unionCommonBaseType == null) {
            computeFlatUnionModel();
        }
        return staCopy(this._unionSubTypes);
    }

    private void setUnionSubTypes(SchemaType[] schemaTypeArr) {
        this._unionSubTypes = schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType getUnionCommonBaseType() {
        if (this._unionCommonBaseType == null) {
            computeFlatUnionModel();
        }
        return this._unionCommonBaseType;
    }

    private void setUnionCommonBaseType(SchemaType schemaType) {
        this._unionCommonBaseType = schemaType;
    }

    private void computeFlatUnionModel() {
        if (getSimpleVariety() != 2) {
            throw new IllegalStateException("Operation is only supported on union types");
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        SchemaType schemaType = null;
        linkedHashSet2.add(this);
        int i = 0;
        while (true) {
            SchemaType.Ref[] refArr = this._unionMemberTyperefs;
            if (i < refArr.length) {
                SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) refArr[i].get();
                int simpleVariety = schemaTypeImpl.getSimpleVariety();
                if (simpleVariety == 1) {
                    linkedHashSet.add(schemaTypeImpl);
                    linkedHashSet2.add(schemaTypeImpl);
                    schemaType = schemaTypeImpl.getCommonBaseType(schemaType);
                } else if (simpleVariety == 2) {
                    linkedHashSet.addAll(Arrays.asList(schemaTypeImpl.getUnionConstituentTypes()));
                    linkedHashSet2.addAll(Arrays.asList(schemaTypeImpl.getUnionSubTypes()));
                    SchemaType unionCommonBaseType = schemaTypeImpl.getUnionCommonBaseType();
                    if (unionCommonBaseType != null) {
                        schemaType = unionCommonBaseType.getCommonBaseType(schemaType);
                    }
                } else if (simpleVariety == 3) {
                    linkedHashSet.add(schemaTypeImpl);
                    linkedHashSet2.add(schemaTypeImpl);
                    schemaType = schemaTypeImpl.getCommonBaseType(schemaType);
                } else if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
                i++;
            } else {
                setUnionConstituentTypes((SchemaType[]) linkedHashSet.toArray(StscState.EMPTY_ST_ARRAY));
                setUnionSubTypes((SchemaType[]) linkedHashSet2.toArray(StscState.EMPTY_ST_ARRAY));
                setUnionCommonBaseType(schemaType);
                return;
            }
        }
    }

    public QName getSubstitutionGroup() {
        return this._sg;
    }

    public void setSubstitutionGroup(QName qName) {
        assertSGResolving();
        this._sg = qName;
    }

    public void addSubstitutionGroupMember(QName qName) {
        assertSGResolved();
        this._sgMembers.add(qName);
    }

    public QName[] getSubstitutionGroupMembers() {
        return (QName[]) this._sgMembers.toArray(new QName[this._sgMembers.size()]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getWhiteSpaceRule() {
        return this._whiteSpaceRule;
    }

    public void setWhiteSpaceRule(int i) {
        assertResolving();
        this._whiteSpaceRule = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType getFacet(int i) {
        XmlValueRef xmlValueRef;
        XmlValueRef[] xmlValueRefArr = this._facetArray;
        if (xmlValueRefArr == null || (xmlValueRef = xmlValueRefArr[i]) == null) {
            return null;
        }
        return xmlValueRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isFacetFixed(int i) {
        return this._fixedFacetArray[i];
    }

    public XmlAnySimpleType[] getBasicFacets() {
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[12];
        for (int i = 0; i <= 11; i++) {
            xmlAnySimpleTypeArr[i] = getFacet(i);
        }
        return xmlAnySimpleTypeArr;
    }

    public boolean[] getFixedFacets() {
        return boaCopy(this._fixedFacetArray);
    }

    public void setBasicFacets(XmlValueRef[] xmlValueRefArr, boolean[] zArr) {
        assertResolving();
        this._facetArray = xmlValueRefArr;
        this._fixedFacetArray = zArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int ordered() {
        return this._ordered;
    }

    public void setOrdered(int i) {
        assertResolving();
        this._ordered = i;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isBounded() {
        return this._isBounded;
    }

    public void setBounded(boolean z) {
        assertResolving();
        this._isBounded = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isFinite() {
        return this._isFinite;
    }

    public void setFinite(boolean z) {
        assertResolving();
        this._isFinite = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isNumeric() {
        return this._isNumeric;
    }

    public void setNumeric(boolean z) {
        assertResolving();
        this._isNumeric = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasPatternFacet() {
        return this._hasPatterns;
    }

    public void setPatternFacet(boolean z) {
        assertResolving();
        this._hasPatterns = z;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean matchPatternFacet(String str) {
        if (!this._hasPatterns) {
            return true;
        }
        RegularExpression[] regularExpressionArr = this._patterns;
        if (regularExpressionArr != null && regularExpressionArr.length > 0) {
            int i = 0;
            while (true) {
                RegularExpression[] regularExpressionArr2 = this._patterns;
                if (i >= regularExpressionArr2.length || regularExpressionArr2[i].matches(str)) {
                    break;
                }
                i++;
            }
            if (i >= this._patterns.length) {
                return false;
            }
        }
        return getBaseType().matchPatternFacet(str);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String[] getPatterns() {
        RegularExpression[] regularExpressionArr = this._patterns;
        int i = 0;
        if (regularExpressionArr == null) {
            return new String[0];
        }
        String[] strArr = new String[regularExpressionArr.length];
        while (true) {
            RegularExpression[] regularExpressionArr2 = this._patterns;
            if (i >= regularExpressionArr2.length) {
                return strArr;
            }
            strArr[i] = regularExpressionArr2[i].getPattern();
            i++;
        }
    }

    public RegularExpression[] getPatternExpressions() {
        RegularExpression[] regularExpressionArr = this._patterns;
        if (regularExpressionArr == null) {
            return new RegularExpression[0];
        }
        RegularExpression[] regularExpressionArr2 = new RegularExpression[regularExpressionArr.length];
        System.arraycopy(regularExpressionArr, 0, regularExpressionArr2, 0, regularExpressionArr.length);
        return regularExpressionArr2;
    }

    public void setPatterns(RegularExpression[] regularExpressionArr) {
        assertResolving();
        this._patterns = regularExpressionArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType[] getEnumerationValues() {
        XmlValueRef[] xmlValueRefArr = this._enumerationValues;
        if (xmlValueRefArr == null) {
            return null;
        }
        int length = xmlValueRefArr.length;
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[length];
        for (int i = 0; i < length; i++) {
            XmlValueRef xmlValueRef = this._enumerationValues[i];
            xmlAnySimpleTypeArr[i] = xmlValueRef == null ? null : xmlValueRef.get();
        }
        return xmlAnySimpleTypeArr;
    }

    public void setEnumerationValues(XmlValueRef[] xmlValueRefArr) {
        assertResolving();
        this._enumerationValues = xmlValueRefArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public StringEnumAbstractBase enumForString(String str) {
        ensureStringEnumInfo();
        if (this._lookupStringEnum == null) {
            return null;
        }
        return (StringEnumAbstractBase) this._lookupStringEnum.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public StringEnumAbstractBase enumForInt(int i) {
        ensureStringEnumInfo();
        if (this._listOfStringEnum == null || i < 0 || i >= this._listOfStringEnum.size()) {
            return null;
        }
        return (StringEnumAbstractBase) this._listOfStringEnum.get(i);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaStringEnumEntry enumEntryForString(String str) {
        ensureStringEnumInfo();
        if (this._lookupStringEnumEntry == null) {
            return null;
        }
        return (SchemaStringEnumEntry) this._lookupStringEnumEntry.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getBaseEnumType() {
        SchemaType.Ref ref = this._baseEnumTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setBaseEnumTypeRef(SchemaType.Ref ref) {
        this._baseEnumTyperef = ref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaStringEnumEntry[] getStringEnumEntries() {
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = this._stringEnumEntries;
        if (schemaStringEnumEntryArr == null) {
            return null;
        }
        int length = schemaStringEnumEntryArr.length;
        SchemaStringEnumEntry[] schemaStringEnumEntryArr2 = new SchemaStringEnumEntry[length];
        System.arraycopy(schemaStringEnumEntryArr, 0, schemaStringEnumEntryArr2, 0, length);
        return schemaStringEnumEntryArr2;
    }

    public void setStringEnumEntries(SchemaStringEnumEntry[] schemaStringEnumEntryArr) {
        assertJavaizing();
        this._stringEnumEntries = schemaStringEnumEntryArr;
    }

    private void ensureStringEnumInfo() {
        if (this._stringEnumEnsured) {
            return;
        }
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = this._stringEnumEntries;
        if (schemaStringEnumEntryArr == null) {
            this._stringEnumEnsured = true;
            return;
        }
        HashMap hashMap = new HashMap(schemaStringEnumEntryArr.length);
        ArrayList arrayList = new ArrayList(schemaStringEnumEntryArr.length + 1);
        HashMap hashMap2 = new HashMap(schemaStringEnumEntryArr.length);
        for (int i = 0; i < schemaStringEnumEntryArr.length; i++) {
            hashMap2.put(schemaStringEnumEntryArr[i].getString(), schemaStringEnumEntryArr[i]);
        }
        Class enumJavaClass = this._baseEnumTyperef.get().getEnumJavaClass();
        if (enumJavaClass != null) {
            try {
                StringEnumAbstractBase.Table table = (StringEnumAbstractBase.Table) enumJavaClass.getField("table").get(null);
                for (int i2 = 0; i2 < schemaStringEnumEntryArr.length; i2++) {
                    int intValue = schemaStringEnumEntryArr[i2].getIntValue();
                    StringEnumAbstractBase forInt = table.forInt(intValue);
                    hashMap.put(schemaStringEnumEntryArr[i2].getString(), forInt);
                    while (arrayList.size() <= intValue) {
                        arrayList.add(null);
                    }
                    arrayList.set(intValue, forInt);
                }
            } catch (Exception unused) {
                System.err.println(new StringBuffer().append("Something wrong: could not locate enum table for ").append(enumJavaClass).toString());
                hashMap.clear();
                arrayList.clear();
                enumJavaClass = null;
            }
        }
        if (enumJavaClass == null) {
            for (int i3 = 0; i3 < schemaStringEnumEntryArr.length; i3++) {
                int intValue2 = schemaStringEnumEntryArr[i3].getIntValue();
                String string = schemaStringEnumEntryArr[i3].getString();
                StringEnumValue stringEnumValue = new StringEnumValue(string, intValue2);
                hashMap.put(string, stringEnumValue);
                while (arrayList.size() <= intValue2) {
                    arrayList.add(null);
                }
                arrayList.set(intValue2, stringEnumValue);
            }
        }
        synchronized (this) {
            if (!this._stringEnumEnsured) {
                this._lookupStringEnum = hashMap;
                this._listOfStringEnum = arrayList;
                this._lookupStringEnumEntry = hashMap2;
            }
        }
        synchronized (this) {
            this._stringEnumEnsured = true;
        }
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasStringEnumValues() {
        return this._stringEnumEntries != null;
    }

    public void copyEnumerationValues(SchemaTypeImpl schemaTypeImpl) {
        assertResolving();
        this._enumerationValues = schemaTypeImpl._enumerationValues;
        this._baseEnumTyperef = schemaTypeImpl._baseEnumTyperef;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getBuiltinTypeCode() {
        return this._builtinTypeCode;
    }

    public void setBuiltinTypeCode(int i) {
        assertResolving();
        this._builtinTypeCode = i;
    }

    synchronized void assignJavaElementSetterModel() {
        SchemaProperty[] elementProperties = getElementProperties();
        SchemaParticle contentModel = getContentModel();
        HashMap hashMap = new HashMap();
        QNameSet computeAllContainedElements = computeAllContainedElements(contentModel, hashMap);
        for (SchemaProperty schemaProperty : elementProperties) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            QNameSet computeNondelimitingElements = computeNondelimitingElements(schemaPropertyImpl.getName(), contentModel, hashMap);
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(computeAllContainedElements);
            qNameSetBuilder.removeAll(computeNondelimitingElements);
            schemaPropertyImpl.setJavaSetterDelimiter(qNameSetBuilder.toQNameSet());
        }
    }

    private static QNameSet computeNondelimitingElements(QName qName, SchemaParticle schemaParticle, Map map) {
        QNameSet computeAllContainedElements = computeAllContainedElements(schemaParticle, map);
        if (!computeAllContainedElements.contains(qName)) {
            return QNameSet.EMPTY;
        }
        if (schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
            return computeAllContainedElements;
        }
        int particleType = schemaParticle.getParticleType();
        int i = 0;
        if (particleType == 2) {
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            while (i < schemaParticle.countOfParticleChild()) {
                if (computeAllContainedElements(schemaParticle.getParticleChild(i), map).contains(qName)) {
                    qNameSetBuilder.addAll(computeNondelimitingElements(qName, schemaParticle.getParticleChild(i), map));
                }
                i++;
            }
            return qNameSetBuilder.toQNameSet();
        }
        if (particleType != 3) {
            return particleType != 5 ? computeAllContainedElements : QNameSet.singleton(qName);
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        int countOfParticleChild = schemaParticle.countOfParticleChild();
        while (countOfParticleChild > 0) {
            countOfParticleChild--;
            QNameSet computeAllContainedElements2 = computeAllContainedElements(schemaParticle.getParticleChild(countOfParticleChild), map);
            if (i != 0) {
                qNameSetBuilder2.addAll(computeAllContainedElements2);
            } else if (computeAllContainedElements2.contains(qName)) {
                qNameSetBuilder2.addAll(computeNondelimitingElements(qName, schemaParticle.getParticleChild(countOfParticleChild), map));
                i = 1;
            }
        }
        return qNameSetBuilder2.toQNameSet();
    }

    private static QNameSet computeAllContainedElements(SchemaParticle schemaParticle, Map map) {
        QNameSet acceptedStartNames;
        QNameSet qNameSet = (QNameSet) map.get(schemaParticle);
        if (qNameSet != null) {
            return qNameSet;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 4) {
            acceptedStartNames = ((SchemaLocalElementImpl) schemaParticle).acceptedStartNames();
        } else if (particleType != 5) {
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
                qNameSetBuilder.addAll(computeAllContainedElements(schemaParticle.getParticleChild(i), map));
            }
            acceptedStartNames = qNameSetBuilder.toQNameSet();
        } else {
            acceptedStartNames = schemaParticle.getWildcardSet();
        }
        map.put(schemaParticle, acceptedStartNames);
        return acceptedStartNames;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Class getJavaClass() {
        if (this._javaClass == null && getFullJavaName() != null) {
            try {
                this._javaClass = Class.forName(getFullJavaName(), false, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._javaClass = null;
            }
        }
        return this._javaClass;
    }

    public Class getJavaImplClass() {
        if (this._implNotAvailable) {
            return null;
        }
        if (this._javaImplClass == null) {
            try {
                if (getFullJavaImplName() != null) {
                    this._javaImplClass = Class.forName(getFullJavaImplName(), false, getTypeSystem().getClassLoader());
                } else {
                    this._implNotAvailable = true;
                }
            } catch (ClassNotFoundException unused) {
                this._implNotAvailable = true;
            }
        }
        return this._javaImplClass;
    }

    public Class getUserTypeClass() {
        if (this._userTypeClass == null && getUserTypeName() != null) {
            try {
                this._userTypeClass = Class.forName(this._userTypeName, false, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._userTypeClass = null;
            }
        }
        return this._userTypeClass;
    }

    public Class getUserTypeHandlerClass() {
        if (this._userTypeHandlerClass == null && getUserTypeHandlerName() != null) {
            try {
                this._userTypeHandlerClass = Class.forName(this._userTypeHandler, false, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._userTypeHandlerClass = null;
            }
        }
        return this._userTypeHandlerClass;
    }

    public Constructor getJavaImplConstructor() {
        if (this._javaImplConstructor == null && !this._implNotAvailable) {
            Class javaImplClass = getJavaImplClass();
            if (javaImplClass == null) {
                return null;
            }
            try {
                Class<?>[] clsArr = new Class[1];
                Class<?> cls = class$org$apache$xmlbeans$SchemaType;
                if (cls == null) {
                    cls = class$("org.apache.xmlbeans.SchemaType");
                    class$org$apache$xmlbeans$SchemaType = cls;
                }
                clsArr[0] = cls;
                this._javaImplConstructor = javaImplClass.getConstructor(clsArr);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this._javaImplConstructor;
    }

    public Constructor getJavaImplConstructor2() {
        if (this._javaImplConstructor2 == null && !this._implNotAvailable) {
            Class javaImplClass = getJavaImplClass();
            if (javaImplClass == null) {
                return null;
            }
            try {
                Class<?>[] clsArr = new Class[2];
                Class<?> cls = class$org$apache$xmlbeans$SchemaType;
                if (cls == null) {
                    cls = class$("org.apache.xmlbeans.SchemaType");
                    class$org$apache$xmlbeans$SchemaType = cls;
                }
                clsArr[0] = cls;
                clsArr[1] = Boolean.TYPE;
                this._javaImplConstructor2 = javaImplClass.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this._javaImplConstructor2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Class getEnumJavaClass() {
        if (this._javaEnumClass == null && getBaseEnumType() != null) {
            try {
                this._javaEnumClass = Class.forName(new StringBuffer().append(getBaseEnumType().getFullJavaName()).append("$Enum").toString(), false, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._javaEnumClass = null;
            }
        }
        return this._javaEnumClass;
    }

    public void setJavaClass(Class cls) {
        assertResolved();
        this._javaClass = cls;
        setFullJavaName(cls.getName());
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isPrimitiveType() {
        return getBuiltinTypeCode() >= 2 && getBuiltinTypeCode() <= 21;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isBuiltinType() {
        return getBuiltinTypeCode() != 0;
    }

    public XmlObject createUnwrappedNode() {
        return createUnattachedNode(null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUserFactory
    public TypeStoreUser createTypeStoreUser() {
        return (TypeStoreUser) createUnattachedNode(null);
    }

    public XmlAnySimpleType newValidatingValue(Object obj) {
        return newValue(obj, true);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType newValue(Object obj) {
        return newValue(obj, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XmlAnySimpleType newValue(Object obj, boolean z) {
        if (!isSimpleType() && getContentType() != 2) {
            throw new XmlValueOutOfRangeException();
        }
        XmlObjectBase xmlObjectBase = (XmlObjectBase) createUnattachedNode(null);
        if (z) {
            xmlObjectBase.setValidateOnSet();
        }
        if (obj instanceof XmlObject) {
            xmlObjectBase.set_newValue((XmlObject) obj);
        } else {
            xmlObjectBase.objectSet(obj);
        }
        xmlObjectBase.check_dated();
        xmlObjectBase.setImmutable();
        return (XmlAnySimpleType) xmlObjectBase;
    }

    private XmlObject createUnattachedNode(SchemaProperty schemaProperty) {
        XmlObject createBuiltinInstance;
        if (!isBuiltinType() && !isNoType()) {
            Constructor javaImplConstructor = getJavaImplConstructor();
            if (javaImplConstructor != null) {
                try {
                    return (XmlObject) javaImplConstructor.newInstance(this._ctrArgs);
                } catch (Exception e) {
                    System.out.println("Exception trying to instantiate impl class.");
                    e.printStackTrace();
                }
            }
            createBuiltinInstance = null;
        } else {
            createBuiltinInstance = createBuiltinInstance();
        }
        SchemaType schemaType = this;
        while (createBuiltinInstance == null) {
            createBuiltinInstance = ((SchemaTypeImpl) schemaType).createUnattachedSubclass(this);
            schemaType = schemaType.getBaseType();
        }
        ((XmlObjectBase) createBuiltinInstance).init_flags(schemaProperty);
        return createBuiltinInstance;
    }

    private XmlObject createUnattachedSubclass(SchemaType schemaType) {
        if (!isBuiltinType() && !isNoType()) {
            Constructor javaImplConstructor2 = getJavaImplConstructor2();
            if (javaImplConstructor2 == null) {
                return null;
            }
            boolean isAccessible = javaImplConstructor2.isAccessible();
            try {
                javaImplConstructor2.setAccessible(true);
                try {
                    try {
                        Object[] objArr = new Object[2];
                        objArr[0] = schemaType;
                        objArr[1] = schemaType.isSimpleType() ? Boolean.FALSE : Boolean.TRUE;
                        return (XmlObject) javaImplConstructor2.newInstance(objArr);
                    } finally {
                        try {
                            javaImplConstructor2.setAccessible(isAccessible);
                        } catch (SecurityException unused) {
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Exception trying to instantiate impl class.");
                    e.printStackTrace();
                    try {
                        javaImplConstructor2.setAccessible(isAccessible);
                        return null;
                    } catch (SecurityException unused2) {
                        return null;
                    }
                }
            } catch (Exception e2) {
                System.out.println("Exception trying to instantiate impl class.");
                e2.printStackTrace();
                return null;
            }
        }
        return createBuiltinSubclass(schemaType);
    }

    private XmlObject createBuiltinInstance() {
        switch (getBuiltinTypeCode()) {
            case 0:
                return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
            case 1:
                return new XmlAnyTypeImpl();
            case 2:
                return new XmlAnySimpleTypeImpl();
            case 3:
                return new XmlBooleanImpl();
            case 4:
                return new XmlBase64BinaryImpl();
            case 5:
                return new XmlHexBinaryImpl();
            case 6:
                return new XmlAnyUriImpl();
            case 7:
                return new XmlQNameImpl();
            case 8:
                return new XmlNotationImpl();
            case 9:
                return new XmlFloatImpl();
            case 10:
                return new XmlDoubleImpl();
            case 11:
                return new XmlDecimalImpl();
            case 12:
                return new XmlStringImpl();
            case 13:
                return new XmlDurationImpl();
            case 14:
                return new XmlDateTimeImpl();
            case 15:
                return new XmlTimeImpl();
            case 16:
                return new XmlDateImpl();
            case 17:
                return new XmlGYearMonthImpl();
            case 18:
                return new XmlGYearImpl();
            case 19:
                return new XmlGMonthDayImpl();
            case 20:
                return new XmlGDayImpl();
            case 21:
                return new XmlGMonthImpl();
            case 22:
                return new XmlIntegerImpl();
            case 23:
                return new XmlLongImpl();
            case 24:
                return new XmlIntImpl();
            case 25:
                return new XmlShortImpl();
            case 26:
                return new XmlByteImpl();
            case 27:
                return new XmlNonPositiveIntegerImpl();
            case 28:
                return new XmlNegativeIntegerImpl();
            case 29:
                return new XmlNonNegativeIntegerImpl();
            case 30:
                return new XmlPositiveIntegerImpl();
            case 31:
                return new XmlUnsignedLongImpl();
            case 32:
                return new XmlUnsignedIntImpl();
            case 33:
                return new XmlUnsignedShortImpl();
            case 34:
                return new XmlUnsignedByteImpl();
            case 35:
                return new XmlNormalizedStringImpl();
            case 36:
                return new XmlTokenImpl();
            case 37:
                return new XmlNameImpl();
            case 38:
                return new XmlNCNameImpl();
            case 39:
                return new XmlLanguageImpl();
            case 40:
                return new XmlIdImpl();
            case 41:
                return new XmlIdRefImpl();
            case 42:
                return new XmlIdRefsImpl();
            case 43:
                return new XmlEntityImpl();
            case 44:
                return new XmlEntitiesImpl();
            case 45:
                return new XmlNmTokenImpl();
            case 46:
                return new XmlNmTokensImpl();
            default:
                throw new IllegalStateException(new StringBuffer().append("Unrecognized builtin type: ").append(getBuiltinTypeCode()).toString());
        }
    }

    private XmlObject createBuiltinSubclass(SchemaType schemaType) {
        boolean z = !schemaType.isSimpleType();
        switch (getBuiltinTypeCode()) {
            case 0:
                return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
            case 1:
            case 2:
                int simpleVariety = schemaType.getSimpleVariety();
                if (simpleVariety == 0) {
                    return new XmlComplexContentImpl(schemaType);
                }
                if (simpleVariety == 1) {
                    return new XmlAnySimpleTypeRestriction(schemaType, z);
                }
                if (simpleVariety == 2) {
                    return new XmlUnionImpl(schemaType, z);
                }
                if (simpleVariety == 3) {
                    return new XmlListImpl(schemaType, z);
                }
                throw new IllegalStateException();
            case 3:
                return new XmlBooleanRestriction(schemaType, z);
            case 4:
                return new XmlBase64BinaryRestriction(schemaType, z);
            case 5:
                return new XmlHexBinaryRestriction(schemaType, z);
            case 6:
                return new XmlAnyUriRestriction(schemaType, z);
            case 7:
                return new XmlQNameRestriction(schemaType, z);
            case 8:
                return new XmlNotationRestriction(schemaType, z);
            case 9:
                return new XmlFloatRestriction(schemaType, z);
            case 10:
                return new XmlDoubleRestriction(schemaType, z);
            case 11:
                return new XmlDecimalRestriction(schemaType, z);
            case 12:
                if (schemaType.hasStringEnumValues()) {
                    return new XmlStringEnumeration(schemaType, z);
                }
                return new XmlStringRestriction(schemaType, z);
            case 13:
                return new XmlDurationImpl(schemaType, z);
            case 14:
                return new XmlDateTimeImpl(schemaType, z);
            case 15:
                return new XmlTimeImpl(schemaType, z);
            case 16:
                return new XmlDateImpl(schemaType, z);
            case 17:
                return new XmlGYearMonthImpl(schemaType, z);
            case 18:
                return new XmlGYearImpl(schemaType, z);
            case 19:
                return new XmlGMonthDayImpl(schemaType, z);
            case 20:
                return new XmlGDayImpl(schemaType, z);
            case 21:
                return new XmlGMonthImpl(schemaType, z);
            case 22:
                return new XmlIntegerRestriction(schemaType, z);
            case 23:
                return new XmlLongRestriction(schemaType, z);
            case 24:
                return new XmlIntRestriction(schemaType, z);
            case 25:
                return new XmlShortImpl(schemaType, z);
            case 26:
                return new XmlByteImpl(schemaType, z);
            case 27:
                return new XmlNonPositiveIntegerImpl(schemaType, z);
            case 28:
                return new XmlNegativeIntegerImpl(schemaType, z);
            case 29:
                return new XmlNonNegativeIntegerImpl(schemaType, z);
            case 30:
                return new XmlPositiveIntegerImpl(schemaType, z);
            case 31:
                return new XmlUnsignedLongImpl(schemaType, z);
            case 32:
                return new XmlUnsignedIntImpl(schemaType, z);
            case 33:
                return new XmlUnsignedShortImpl(schemaType, z);
            case 34:
                return new XmlUnsignedByteImpl(schemaType, z);
            case 35:
                return new XmlNormalizedStringImpl(schemaType, z);
            case 36:
                return new XmlTokenImpl(schemaType, z);
            case 37:
                return new XmlNameImpl(schemaType, z);
            case 38:
                return new XmlNCNameImpl(schemaType, z);
            case 39:
                return new XmlLanguageImpl(schemaType, z);
            case 40:
                return new XmlIdImpl(schemaType, z);
            case 41:
                return new XmlIdRefImpl(schemaType, z);
            case 42:
                return new XmlIdRefsImpl(schemaType, z);
            case 43:
                return new XmlEntityImpl(schemaType, z);
            case 44:
                return new XmlEntitiesImpl(schemaType, z);
            case 45:
                return new XmlNmTokenImpl(schemaType, z);
            case 46:
                return new XmlNmTokensImpl(schemaType, z);
            default:
                throw new IllegalStateException(new StringBuffer().append("Unrecognized builtin type: ").append(getBuiltinTypeCode()).toString());
        }
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getCommonBaseType(SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl;
        if (this == BuiltinSchemaTypeSystem.ST_ANY_TYPE || schemaType == null || schemaType.isNoType()) {
            return this;
        }
        if (schemaType == BuiltinSchemaTypeSystem.ST_ANY_TYPE || isNoType()) {
            return schemaType;
        }
        while (true) {
            schemaTypeImpl = (SchemaTypeImpl) schemaType;
            if (schemaTypeImpl.getBaseDepth() <= getBaseDepth()) {
                break;
            }
            schemaType = schemaTypeImpl.getBaseType();
        }
        SchemaTypeImpl schemaTypeImpl2 = this;
        while (schemaTypeImpl2.getBaseDepth() > schemaTypeImpl.getBaseDepth()) {
            schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl2.getBaseType();
        }
        while (!schemaTypeImpl.equals(schemaTypeImpl2)) {
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
            schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl2.getBaseType();
            if (!$assertionsDisabled && (schemaTypeImpl == null || schemaTypeImpl2 == null)) {
                throw new AssertionError();
            }
        }
        return schemaTypeImpl;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAssignableFrom(SchemaType schemaType) {
        if (schemaType == null || schemaType.isNoType()) {
            return true;
        }
        if (isNoType()) {
            return false;
        }
        if (getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : getUnionMemberTypes()) {
                if (schemaType2.isAssignableFrom(schemaType)) {
                    return true;
                }
            }
        }
        int baseDepth = ((SchemaTypeImpl) schemaType).getBaseDepth() - getBaseDepth();
        if (baseDepth < 0) {
            return false;
        }
        while (baseDepth > 0) {
            schemaType = schemaType.getBaseType();
            baseDepth--;
        }
        return schemaType.equals(this);
    }

    public String toString() {
        String stringBuffer;
        if (getName() != null) {
            return new StringBuffer().append("T=").append(QNameHelper.pretty(getName())).toString();
        }
        if (isDocumentType()) {
            return new StringBuffer().append("D=").append(QNameHelper.pretty(getDocumentElementName())).toString();
        }
        if (isAttributeType()) {
            return new StringBuffer().append("R=").append(QNameHelper.pretty(getAttributeTypeAttributeName())).toString();
        }
        if (getContainerField() != null) {
            stringBuffer = new StringBuffer().append(getContainerField().getName().getNamespaceURI().length() > 0 ? getContainerField().isAttribute() ? "Q=" : "E=" : getContainerField().isAttribute() ? "A=" : "U=").append(getContainerField().getName().getLocalPart()).toString();
            if (getOuterType() == null) {
                return new StringBuffer().append(stringBuffer).append("@").append(getContainerField().getName().getNamespaceURI()).toString();
            }
        } else {
            if (isNoType()) {
                return "N=";
            }
            if (getOuterType() == null) {
                return "noouter";
            }
            if (getOuterType().getBaseType() == this) {
                stringBuffer = "B=";
            } else if (getOuterType().getContentBasedOnType() == this) {
                stringBuffer = "S=";
            } else if (getOuterType().getSimpleVariety() == 3) {
                stringBuffer = "I=";
            } else {
                stringBuffer = getOuterType().getSimpleVariety() == 2 ? new StringBuffer().append("M=").append(getAnonymousUnionMemberOrdinal()).toString() : "strange=";
            }
        }
        return new StringBuffer().append(stringBuffer).append("|").append(getOuterType().toString()).toString();
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z, String str2, String str3, boolean z2) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
        this._elemFormDefault = str2;
        this._attFormDefault = str3;
        this._redefinition = z2;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    public boolean isChameleon() {
        return this._chameleon;
    }

    public String getElemFormDefault() {
        return this._elemFormDefault;
    }

    public String getAttFormDefault() {
        return this._attFormDefault;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    private static class SequencerImpl implements SchemaTypeElementSequencer {
        private SchemaTypeVisitorImpl _visitor;

        private SequencerImpl(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
            this._visitor = schemaTypeVisitorImpl;
        }

        @Override // org.apache.xmlbeans.SchemaTypeElementSequencer
        public boolean next(QName qName) {
            SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitor;
            if (schemaTypeVisitorImpl == null) {
                return false;
            }
            return schemaTypeVisitorImpl.visit(qName);
        }

        @Override // org.apache.xmlbeans.SchemaTypeElementSequencer
        public boolean peek(QName qName) {
            SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitor;
            if (schemaTypeVisitorImpl == null) {
                return false;
            }
            return schemaTypeVisitorImpl.testValid(qName);
        }
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QNameSet qnameSetForWildcardElements() {
        SchemaParticle contentModel = getContentModel();
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        computeWildcardSet(contentModel, qNameSetBuilder);
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetBuilder);
        for (SchemaProperty schemaProperty : getElementProperties()) {
            qNameSetBuilder2.remove(schemaProperty.getName());
        }
        return qNameSetBuilder2.toQNameSet();
    }

    private static void computeWildcardSet(SchemaParticle schemaParticle, QNameSetBuilder qNameSetBuilder) {
        if (schemaParticle.getParticleType() == 5) {
            qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
            return;
        }
        for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
            computeWildcardSet(schemaParticle.getParticleChild(i), qNameSetBuilder);
        }
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QNameSet qnameSetForWildcardAttributes() {
        QNameSet wildcardSet = getAttributeModel().getWildcardSet();
        if (wildcardSet == null) {
            return QNameSet.EMPTY;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(wildcardSet);
        for (SchemaProperty schemaProperty : getAttributeProperties()) {
            qNameSetBuilder.remove(schemaProperty.getName());
        }
        return qNameSetBuilder.toQNameSet();
    }
}
