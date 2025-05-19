package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;

/* loaded from: classes5.dex */
public class XmlAnySimpleTypeRestriction extends XmlAnySimpleTypeImpl {
    private SchemaType _schemaType;

    public XmlAnySimpleTypeRestriction(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }
}
