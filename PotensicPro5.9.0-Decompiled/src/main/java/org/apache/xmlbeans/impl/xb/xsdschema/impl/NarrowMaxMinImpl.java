package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin;

/* loaded from: classes5.dex */
public class NarrowMaxMinImpl extends LocalElementImpl implements NarrowMaxMin {
    public NarrowMaxMinImpl(SchemaType schemaType) {
        super(schemaType);
    }

    public static class MinOccursImpl extends JavaIntegerHolderEx implements NarrowMaxMin.MinOccurs {
        public MinOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MinOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MaxOccursImpl extends XmlUnionImpl implements NarrowMaxMin.MaxOccurs, XmlNonNegativeInteger, AllNNI.Member {
        public MaxOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MaxOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
