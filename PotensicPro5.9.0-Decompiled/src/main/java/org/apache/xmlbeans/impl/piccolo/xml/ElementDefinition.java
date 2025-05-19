package org.apache.xmlbeans.impl.piccolo.xml;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
import org.apache.xmlbeans.impl.piccolo.util.IndexedObject;
import org.apache.xmlbeans.impl.piccolo.util.IndexedObjectImpl;

/* loaded from: classes5.dex */
public final class ElementDefinition {
    Map attributeMap;
    AttributeDefinition[] attributes;
    String name;
    int size;

    public ElementDefinition() {
        this(null);
    }

    public ElementDefinition(String str) {
        this.size = 0;
        this.name = str;
        this.attributes = new AttributeDefinition[4];
        this.attributeMap = new HashMap();
        this.size = 0;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final AttributeDefinition[] getAttributes() {
        return this.attributes;
    }

    public final int getAttributeCount() {
        return this.size;
    }

    public final IndexedObject getIndexedAttribute(String str) {
        return (IndexedObject) this.attributeMap.get(str);
    }

    public final AttributeDefinition getAttribute(int i) {
        return this.attributes[i];
    }

    public final void addAttribute(AttributeDefinition attributeDefinition) throws DuplicateKeyException {
        Object put = this.attributeMap.put(attributeDefinition.getQName(), new IndexedObjectImpl(this.size, attributeDefinition));
        if (put != null) {
            this.attributeMap.put(attributeDefinition.getQName(), put);
            throw new DuplicateKeyException(new StringBuffer().append("attribute '").append(attributeDefinition.getQName()).append("' is already defined for element '").append(this.name).append("'.").toString());
        }
        int i = this.size;
        AttributeDefinition[] attributeDefinitionArr = this.attributes;
        if (i >= attributeDefinitionArr.length) {
            AttributeDefinition[] attributeDefinitionArr2 = new AttributeDefinition[i * 2];
            System.arraycopy(attributeDefinitionArr, 0, attributeDefinitionArr2, 0, i);
            this.attributes = attributeDefinitionArr2;
        }
        AttributeDefinition[] attributeDefinitionArr3 = this.attributes;
        int i2 = this.size;
        this.size = i2 + 1;
        attributeDefinitionArr3[i2] = attributeDefinition;
    }
}
