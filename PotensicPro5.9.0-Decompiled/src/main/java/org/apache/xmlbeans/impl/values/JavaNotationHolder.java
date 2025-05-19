package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* loaded from: classes5.dex */
public abstract class JavaNotationHolder extends XmlQNameImpl {
    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_NOTATION;
    }
}
