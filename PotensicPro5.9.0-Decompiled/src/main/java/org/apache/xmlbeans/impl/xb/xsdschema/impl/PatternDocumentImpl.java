package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;

/* loaded from: classes5.dex */
public class PatternDocumentImpl extends XmlComplexContentImpl implements PatternDocument {
    private static final QName PATTERN$0 = new QName("http://www.w3.org/2001/XMLSchema", "pattern");

    public PatternDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument
    public PatternDocument.Pattern getPattern() {
        synchronized (monitor()) {
            check_orphaned();
            PatternDocument.Pattern pattern = (PatternDocument.Pattern) get_store().find_element_user(PATTERN$0, 0);
            if (pattern == null) {
                return null;
            }
            return pattern;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument
    public void setPattern(PatternDocument.Pattern pattern) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTERN$0;
            PatternDocument.Pattern pattern2 = (PatternDocument.Pattern) typeStore.find_element_user(qName, 0);
            if (pattern2 == null) {
                pattern2 = (PatternDocument.Pattern) get_store().add_element_user(qName);
            }
            pattern2.set(pattern);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument
    public PatternDocument.Pattern addNewPattern() {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().add_element_user(PATTERN$0);
        }
        return pattern;
    }

    public static class PatternImpl extends NoFixedFacetImpl implements PatternDocument.Pattern {
        public PatternImpl(SchemaType schemaType) {
            super(schemaType);
        }
    }
}
