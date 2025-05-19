package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.util.Collections;
import java.util.Map;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.XPath;

/* loaded from: classes5.dex */
public class SchemaIdentityConstraintImpl implements SchemaIdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaIdentityConstraintImpl;
    private SchemaAnnotation _annotation;
    private boolean _chameleon;
    private SchemaContainer _container;
    private volatile XPath[] _fieldPaths;
    private String[] _fields;
    private String _filename;
    private SchemaIdentityConstraint.Ref _key;
    private QName _name;
    private XmlObject _parse;
    private String _parseTNS;
    private String _selector;
    private volatile XPath _selectorPath;
    private int _type;
    private Object _userData;
    private Map _nsMap = Collections.EMPTY_MAP;
    private SchemaIdentityConstraint.Ref _selfref = new SchemaIdentityConstraint.Ref(this);

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 5;
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaIdentityConstraintImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaIdentityConstraintImpl = class$("org.apache.xmlbeans.impl.schema.SchemaIdentityConstraintImpl");
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

    public SchemaIdentityConstraintImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        return this._filename;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public String getSelector() {
        return this._selector;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getSelectorPath() {
        XPath xPath = this._selectorPath;
        if (xPath != null) {
            return xPath;
        }
        try {
            buildPaths();
            return this._selectorPath;
        } catch (XPath.XPathCompileException e) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError(new StringBuffer().append("Failed to compile xpath. Should be caught by compiler ").append(e).toString());
        }
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        this._annotation = schemaAnnotation;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public void setNSMap(Map map) {
        this._nsMap = map;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Map getNSMap() {
        return Collections.unmodifiableMap(this._nsMap);
    }

    public void setSelector(String str) {
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError();
        }
        this._selector = str;
    }

    public void setFields(String[] strArr) {
        if (!$assertionsDisabled && (strArr == null || strArr.length <= 0)) {
            throw new AssertionError();
        }
        this._fields = strArr;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public String[] getFields() {
        String[] strArr = this._fields;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getFieldPath(int i) {
        XPath[] xPathArr = this._fieldPaths;
        if (xPathArr == null) {
            try {
                buildPaths();
                xPathArr = this._fieldPaths;
            } catch (XPath.XPathCompileException e) {
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError(new StringBuffer().append("Failed to compile xpath. Should be caught by compiler ").append(e).toString());
            }
        }
        return xPathArr[i];
    }

    public void buildPaths() throws XPath.XPathCompileException {
        this._selectorPath = XPath.compileXPath(this._selector, this._nsMap);
        this._fieldPaths = new XPath[this._fields.length];
        for (int i = 0; i < this._fieldPaths.length; i++) {
            this._fieldPaths[i] = XPath.compileXPath(this._fields[i], this._nsMap);
        }
    }

    public void setReferencedKey(SchemaIdentityConstraint.Ref ref) {
        this._key = ref;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public SchemaIdentityConstraint getReferencedKey() {
        return this._key.get();
    }

    public void setConstraintCategory(int i) {
        if (!$assertionsDisabled && (i < 1 || i > 3)) {
            throw new AssertionError();
        }
        this._type = i;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public int getConstraintCategory() {
        return this._type;
    }

    public void setName(QName qName) {
        if (!$assertionsDisabled && qName == null) {
            throw new AssertionError();
        }
        this._name = qName;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z) {
        this._parse = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
    }

    public XmlObject getParseObject() {
        return this._parse;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    public boolean isResolved() {
        return (getConstraintCategory() == 2 && this._key == null) ? false : true;
    }

    public SchemaIdentityConstraint.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getUserData() {
        return this._userData;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }
}
