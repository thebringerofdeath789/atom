package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;

/* loaded from: classes5.dex */
public interface SchemaModelGroup extends SchemaComponent, SchemaAnnotated {
    @Override // org.apache.xmlbeans.SchemaComponent
    int getComponentType();

    @Override // org.apache.xmlbeans.SchemaComponent
    QName getName();

    Object getUserData();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 6;
        }

        public Ref(SchemaModelGroup schemaModelGroup) {
            super(schemaModelGroup);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaModelGroup get() {
            return (SchemaModelGroup) getComponent();
        }
    }
}
