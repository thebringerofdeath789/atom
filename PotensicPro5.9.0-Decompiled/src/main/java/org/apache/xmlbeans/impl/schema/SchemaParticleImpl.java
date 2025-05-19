package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.NamespaceContext;

/* loaded from: classes5.dex */
public class SchemaParticleImpl implements SchemaParticle {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final BigInteger _maxint;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaParticleImpl;
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private QNameSet _excludeNextSet;
    private int _intMaxOccurs;
    private int _intMinOccurs;
    private boolean _isDefault;
    private boolean _isDeterministic;
    private boolean _isFixed;
    private boolean _isImmutable;
    private boolean _isNillable;
    private boolean _isSkippable;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    protected XmlObject _parseObject;
    private SchemaParticle[] _particleChildren;
    private int _particleType;
    private QName _qName;
    private QNameSet _startSet;
    private SchemaType.Ref _typeref;
    private Object _userData;
    private int _wildcardProcess;
    private QNameSet _wildcardSet;

    public boolean isAttribute() {
        return false;
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaParticleImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaParticleImpl = class$("org.apache.xmlbeans.impl.schema.SchemaParticleImpl");
        }
        $assertionsDisabled = true;
        _maxint = BigInteger.valueOf(2147483647L);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected void mutate() {
        if (this._isImmutable) {
            throw new IllegalStateException();
        }
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public boolean hasTransitionRules() {
        return this._startSet != null;
    }

    public boolean hasTransitionNotes() {
        return this._excludeNextSet != null;
    }

    public void setTransitionRules(QNameSet qNameSet, boolean z) {
        this._startSet = qNameSet;
        this._isSkippable = z;
    }

    public void setTransitionNotes(QNameSet qNameSet, boolean z) {
        this._excludeNextSet = qNameSet;
        this._isDeterministic = z;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean canStartWithElement(QName qName) {
        return qName != null && this._startSet.contains(qName);
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QNameSet acceptedStartNames() {
        return this._startSet;
    }

    public QNameSet getExcludeNextSet() {
        return this._excludeNextSet;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isSkippable() {
        return this._isSkippable;
    }

    public boolean isDeterministic() {
        return this._isDeterministic;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getParticleType() {
        return this._particleType;
    }

    public void setParticleType(int i) {
        mutate();
        this._particleType = i;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isSingleton() {
        BigInteger bigInteger = this._maxOccurs;
        return bigInteger != null && bigInteger.compareTo(BigInteger.ONE) == 0 && this._minOccurs.compareTo(BigInteger.ONE) == 0;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    public void setMinOccurs(BigInteger bigInteger) {
        mutate();
        this._minOccurs = bigInteger;
        this._intMinOccurs = pegBigInteger(bigInteger);
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getIntMinOccurs() {
        return this._intMinOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getIntMaxOccurs() {
        return this._intMaxOccurs;
    }

    public void setMaxOccurs(BigInteger bigInteger) {
        mutate();
        this._maxOccurs = bigInteger;
        this._intMaxOccurs = pegBigInteger(bigInteger);
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaParticle[] getParticleChildren() {
        SchemaParticle[] schemaParticleArr = this._particleChildren;
        if (schemaParticleArr == null) {
            if ($assertionsDisabled) {
                return null;
            }
            int i = this._particleType;
            if (i == 1 || i == 3 || i == 2) {
                throw new AssertionError();
            }
            return null;
        }
        SchemaParticle[] schemaParticleArr2 = new SchemaParticle[schemaParticleArr.length];
        System.arraycopy(schemaParticleArr, 0, schemaParticleArr2, 0, schemaParticleArr.length);
        return schemaParticleArr2;
    }

    public void setParticleChildren(SchemaParticle[] schemaParticleArr) {
        mutate();
        this._particleChildren = schemaParticleArr;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaParticle getParticleChild(int i) {
        return this._particleChildren[i];
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int countOfParticleChild() {
        SchemaParticle[] schemaParticleArr = this._particleChildren;
        if (schemaParticleArr == null) {
            return 0;
        }
        return schemaParticleArr.length;
    }

    public void setWildcardSet(QNameSet qNameSet) {
        mutate();
        this._wildcardSet = qNameSet;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QNameSet getWildcardSet() {
        return this._wildcardSet;
    }

    public void setWildcardProcess(int i) {
        mutate();
        this._wildcardProcess = i;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getWildcardProcess() {
        return this._wildcardProcess;
    }

    private static final int pegBigInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            return Integer.MAX_VALUE;
        }
        if (bigInteger.signum() <= 0) {
            return 0;
        }
        if (bigInteger.compareTo(_maxint) >= 0) {
            return Integer.MAX_VALUE;
        }
        return bigInteger.intValue();
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QName getName() {
        return this._qName;
    }

    public void setNameAndTypeRef(QName qName, SchemaType.Ref ref) {
        mutate();
        this._qName = qName;
        this._typeref = ref;
    }

    public boolean isTypeResolved() {
        return this._typeref != null;
    }

    public void resolveTypeRef(SchemaType.Ref ref) {
        if (this._typeref != null) {
            throw new IllegalStateException();
        }
        this._typeref = ref;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaType getType() {
        SchemaType.Ref ref = this._typeref;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public String getDefaultText() {
        return this._defaultText;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isDefault() {
        return this._isDefault;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isFixed() {
        return this._isFixed;
    }

    public void setDefault(String str, boolean z, XmlObject xmlObject) {
        mutate();
        this._defaultText = str;
        this._isDefault = str != null;
        this._isFixed = z;
        this._parseObject = xmlObject;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isNillable() {
        return this._isNillable;
    }

    public void setNillable(boolean z) {
        mutate();
        this._isNillable = z;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        if (this._defaultText == null || !XmlAnySimpleType.type.isAssignableFrom(getType())) {
            return null;
        }
        if (this._parseObject != null && XmlQName.type.isAssignableFrom(getType())) {
            try {
                NamespaceContext.push(new NamespaceContext(this._parseObject));
                return getType().newValue(this._defaultText);
            } finally {
                NamespaceContext.pop();
            }
        }
        return getType().newValue(this._defaultText);
    }

    public void setDefaultValue(XmlValueRef xmlValueRef) {
        mutate();
        this._defaultValue = xmlValueRef;
    }

    public Object getUserData() {
        return this._userData;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }
}
