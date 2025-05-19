package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;

/* loaded from: classes6.dex */
public class SettingsDocumentImpl extends XmlComplexContentImpl implements SettingsDocument {
    private static final QName SETTINGS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "settings");

    public SettingsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument
    public CTSettings addNewSettings() {
        CTSettings cTSettings;
        synchronized (monitor()) {
            check_orphaned();
            cTSettings = (CTSettings) get_store().add_element_user(SETTINGS$0);
        }
        return cTSettings;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument
    public CTSettings getSettings() {
        synchronized (monitor()) {
            check_orphaned();
            CTSettings cTSettings = (CTSettings) get_store().find_element_user(SETTINGS$0, 0);
            if (cTSettings == null) {
                return null;
            }
            return cTSettings;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument
    public void setSettings(CTSettings cTSettings) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SETTINGS$0;
            CTSettings cTSettings2 = (CTSettings) typeStore.find_element_user(qName, 0);
            if (cTSettings2 == null) {
                cTSettings2 = (CTSettings) get_store().add_element_user(qName);
            }
            cTSettings2.set(cTSettings);
        }
    }
}
