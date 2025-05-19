package org.apache.xmlbeans.impl.xb.xmlschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;

/* loaded from: classes5.dex */
public class SpaceAttributeImpl extends XmlComplexContentImpl implements SpaceAttribute {
    private static final QName SPACE$0 = new QName("http://www.w3.org/XML/1998/namespace", "space");

    public SpaceAttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public SpaceAttribute.Space.Enum getSpace() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (SpaceAttribute.Space.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public SpaceAttribute.Space xgetSpace() {
        SpaceAttribute.Space space;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$0;
            space = (SpaceAttribute.Space) typeStore.find_attribute_user(qName);
            if (space == null) {
                space = (SpaceAttribute.Space) get_default_attribute_value(qName);
            }
        }
        return space;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public boolean isSetSpace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPACE$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public void setSpace(SpaceAttribute.Space.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public void xsetSpace(SpaceAttribute.Space space) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACE$0;
            SpaceAttribute.Space space2 = (SpaceAttribute.Space) typeStore.find_attribute_user(qName);
            if (space2 == null) {
                space2 = (SpaceAttribute.Space) get_store().add_attribute_user(qName);
            }
            space2.set(space);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public void unsetSpace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPACE$0);
        }
    }

    public static class SpaceImpl extends JavaStringEnumerationHolderEx implements SpaceAttribute.Space {
        public SpaceImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected SpaceImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
