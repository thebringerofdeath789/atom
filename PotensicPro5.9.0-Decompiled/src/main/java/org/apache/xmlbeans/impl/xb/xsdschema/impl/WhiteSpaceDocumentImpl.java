package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;

/* loaded from: classes5.dex */
public class WhiteSpaceDocumentImpl extends XmlComplexContentImpl implements WhiteSpaceDocument {
    private static final QName WHITESPACE$0 = new QName("http://www.w3.org/2001/XMLSchema", "whiteSpace");

    public WhiteSpaceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument
    public WhiteSpaceDocument.WhiteSpace getWhiteSpace() {
        synchronized (monitor()) {
            check_orphaned();
            WhiteSpaceDocument.WhiteSpace whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(WHITESPACE$0, 0);
            if (whiteSpace == null) {
                return null;
            }
            return whiteSpace;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument
    public void setWhiteSpace(WhiteSpaceDocument.WhiteSpace whiteSpace) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WHITESPACE$0;
            WhiteSpaceDocument.WhiteSpace whiteSpace2 = (WhiteSpaceDocument.WhiteSpace) typeStore.find_element_user(qName, 0);
            if (whiteSpace2 == null) {
                whiteSpace2 = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(qName);
            }
            whiteSpace2.set(whiteSpace);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument
    public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(WHITESPACE$0);
        }
        return whiteSpace;
    }

    public static class WhiteSpaceImpl extends FacetImpl implements WhiteSpaceDocument.WhiteSpace {
        public WhiteSpaceImpl(SchemaType schemaType) {
            super(schemaType);
        }

        public static class ValueImpl extends JavaStringEnumerationHolderEx implements WhiteSpaceDocument.WhiteSpace.Value {
            public ValueImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected ValueImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
