package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument;

/* loaded from: classes6.dex */
public class DocumentDocumentImpl extends XmlComplexContentImpl implements DocumentDocument {
    private static final QName DOCUMENT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "document");

    public DocumentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument
    public CTDocument1 addNewDocument() {
        CTDocument1 cTDocument1;
        synchronized (monitor()) {
            check_orphaned();
            cTDocument1 = (CTDocument1) get_store().add_element_user(DOCUMENT$0);
        }
        return cTDocument1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument
    public CTDocument1 getDocument() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocument1 cTDocument1 = (CTDocument1) get_store().find_element_user(DOCUMENT$0, 0);
            if (cTDocument1 == null) {
                return null;
            }
            return cTDocument1;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument
    public void setDocument(CTDocument1 cTDocument1) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCUMENT$0;
            CTDocument1 cTDocument12 = (CTDocument1) typeStore.find_element_user(qName, 0);
            if (cTDocument12 == null) {
                cTDocument12 = (CTDocument1) get_store().add_element_user(qName);
            }
            cTDocument12.set(cTDocument1);
        }
    }
}
