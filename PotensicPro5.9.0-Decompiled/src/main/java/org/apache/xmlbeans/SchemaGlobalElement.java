package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;

/* loaded from: classes5.dex */
public interface SchemaGlobalElement extends SchemaLocalElement, SchemaComponent {
    boolean finalExtension();

    boolean finalRestriction();

    Ref getRef();

    SchemaGlobalElement substitutionGroup();

    QName[] substitutionGroupMembers();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 1;
        }

        public Ref(SchemaGlobalElement schemaGlobalElement) {
            super(schemaGlobalElement);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaGlobalElement get() {
            return (SchemaGlobalElement) getComponent();
        }
    }
}
