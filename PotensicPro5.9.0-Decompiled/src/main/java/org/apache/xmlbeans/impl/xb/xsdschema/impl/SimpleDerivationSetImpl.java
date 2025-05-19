package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet;

/* loaded from: classes5.dex */
public class SimpleDerivationSetImpl extends XmlUnionImpl implements SimpleDerivationSet, SimpleDerivationSet.Member, SimpleDerivationSet.Member2 {
    public SimpleDerivationSetImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected SimpleDerivationSetImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements SimpleDerivationSet.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MemberImpl2 extends XmlListImpl implements SimpleDerivationSet.Member2 {
        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }

        public static class ItemImpl extends JavaStringEnumerationHolderEx implements SimpleDerivationSet.Member2.Item {
            public ItemImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected ItemImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
