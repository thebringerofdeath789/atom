package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;

/* loaded from: classes5.dex */
public interface SchemaAttributeGroup extends SchemaComponent, SchemaAnnotated {
    @Override // org.apache.xmlbeans.SchemaComponent
    int getComponentType();

    @Override // org.apache.xmlbeans.SchemaComponent
    QName getName();

    Object getUserData();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 4;
        }

        public Ref(SchemaAttributeGroup schemaAttributeGroup) {
            super(schemaAttributeGroup);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaAttributeGroup get() {
            return (SchemaAttributeGroup) getComponent();
        }
    }
}
