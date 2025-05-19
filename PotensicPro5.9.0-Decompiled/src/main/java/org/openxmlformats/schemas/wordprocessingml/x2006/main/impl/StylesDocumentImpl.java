package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* loaded from: classes6.dex */
public class StylesDocumentImpl extends XmlComplexContentImpl implements StylesDocument {
    private static final QName STYLES$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styles");

    public StylesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public CTStyles addNewStyles() {
        CTStyles cTStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTStyles = (CTStyles) get_store().add_element_user(STYLES$0);
        }
        return cTStyles;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public CTStyles getStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTStyles cTStyles = (CTStyles) get_store().find_element_user(STYLES$0, 0);
            if (cTStyles == null) {
                return null;
            }
            return cTStyles;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public void setStyles(CTStyles cTStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLES$0;
            CTStyles cTStyles2 = (CTStyles) typeStore.find_element_user(qName, 0);
            if (cTStyles2 == null) {
                cTStyles2 = (CTStyles) get_store().add_element_user(qName);
            }
            cTStyles2.set(cTStyles);
        }
    }
}
