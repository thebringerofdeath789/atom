package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;

/* loaded from: classes5.dex */
public class NamespaceListImpl extends XmlUnionImpl implements NamespaceList, NamespaceList.Member, NamespaceList.Member2 {
    public NamespaceListImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected NamespaceListImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements NamespaceList.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MemberImpl2 extends XmlListImpl implements NamespaceList.Member2 {
        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }

        public static class ItemImpl extends XmlUnionImpl implements NamespaceList.Member2.Item, XmlAnyURI, NamespaceList.Member2.Item.Member {
            public ItemImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected ItemImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }

            public static class MemberImpl extends JavaStringEnumerationHolderEx implements NamespaceList.Member2.Item.Member {
                public MemberImpl(SchemaType schemaType) {
                    super(schemaType, false);
                }

                protected MemberImpl(SchemaType schemaType, boolean z) {
                    super(schemaType, z);
                }
            }
        }
    }
}
