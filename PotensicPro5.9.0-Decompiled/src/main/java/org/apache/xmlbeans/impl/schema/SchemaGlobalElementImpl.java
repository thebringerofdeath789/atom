package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public class SchemaGlobalElementImpl extends SchemaLocalElementImpl implements SchemaGlobalElement {
    private static final QName[] _namearray = new QName[0];
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalRest;
    private String _parseTNS;
    private SchemaGlobalElement.Ref _sg;
    private Set _sgMembers = new LinkedHashSet();
    private SchemaGlobalElement.Ref _selfref = new SchemaGlobalElement.Ref(this);

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 1;
    }

    public SchemaGlobalElementImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        return this._filename;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    void setFinal(boolean z, boolean z2) {
        mutate();
        this._finalExt = z;
        this._finalRest = z2;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public SchemaGlobalElement substitutionGroup() {
        SchemaGlobalElement.Ref ref = this._sg;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setSubstitutionGroup(SchemaGlobalElement.Ref ref) {
        this._sg = ref;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public QName[] substitutionGroupMembers() {
        return (QName[]) this._sgMembers.toArray(_namearray);
    }

    public void addSubstitutionGroupMember(QName qName) {
        mutate();
        this._sgMembers.add(qName);
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public boolean finalExtension() {
        return this._finalExt;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public boolean finalRestriction() {
        return this._finalRest;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
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

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public SchemaGlobalElement.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }
}
