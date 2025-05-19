package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public class SchemaGlobalAttributeImpl extends SchemaLocalAttributeImpl implements SchemaGlobalAttribute {
    private boolean _chameleon;
    SchemaContainer _container;
    String _filename;
    private String _parseTNS;
    private SchemaGlobalAttribute.Ref _selfref = new SchemaGlobalAttribute.Ref(this);

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 3;
    }

    public SchemaGlobalAttributeImpl(SchemaContainer schemaContainer) {
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

    @Override // org.apache.xmlbeans.SchemaGlobalAttribute
    public SchemaGlobalAttribute.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }
}
