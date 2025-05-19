package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public class SchemaModelGroupImpl implements SchemaModelGroup {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaModelGroupImpl;
    private SchemaAnnotation _annotation;
    private String _attFormDefault;
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _elemFormDefault;
    private String _filename;
    private QName _name;
    private XmlObject _parseObject;
    private String _parseTNS;
    private boolean _redefinition;
    private SchemaModelGroup.Ref _selfref = new SchemaModelGroup.Ref(this);
    private Object _userData;

    @Override // org.apache.xmlbeans.SchemaModelGroup, org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 6;
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaModelGroupImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaModelGroupImpl = class$("org.apache.xmlbeans.impl.schema.SchemaModelGroupImpl");
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

    public SchemaModelGroupImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public SchemaModelGroupImpl(SchemaContainer schemaContainer, QName qName) {
        this._container = schemaContainer;
        this._name = qName;
    }

    public void init(QName qName, String str, boolean z, String str2, String str3, boolean z2, XmlObject xmlObject, SchemaAnnotation schemaAnnotation, Object obj) {
        QName qName2;
        if (!$assertionsDisabled && (qName2 = this._name) != null && !qName.equals(qName2)) {
            throw new AssertionError();
        }
        this._name = qName;
        this._parseTNS = str;
        this._chameleon = z;
        this._elemFormDefault = str2;
        this._attFormDefault = str3;
        this._redefinition = z2;
        this._parseObject = xmlObject;
        this._annotation = schemaAnnotation;
        this._userData = obj;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        return this._filename;
    }

    @Override // org.apache.xmlbeans.SchemaModelGroup, org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
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

    public String getElemFormDefault() {
        return this._elemFormDefault;
    }

    public String getAttFormDefault() {
        return this._attFormDefault;
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public SchemaModelGroup.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    @Override // org.apache.xmlbeans.SchemaModelGroup
    public Object getUserData() {
        return this._userData;
    }
}
