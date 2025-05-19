package schemasMicrosoftComOfficeOffice.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComOfficeOffice.CTIdMap;
import schemasMicrosoftComOfficeOffice.CTRegroupTable;
import schemasMicrosoftComOfficeOffice.CTRules;
import schemasMicrosoftComOfficeOffice.CTShapeLayout;
import schemasMicrosoftComVml.STExt;

/* loaded from: classes6.dex */
public class CTShapeLayoutImpl extends XmlComplexContentImpl implements CTShapeLayout {
    private static final QName IDMAP$0 = new QName("urn:schemas-microsoft-com:office:office", "idmap");
    private static final QName REGROUPTABLE$2 = new QName("urn:schemas-microsoft-com:office:office", "regrouptable");
    private static final QName RULES$4 = new QName("urn:schemas-microsoft-com:office:office", "rules");
    private static final QName EXT$6 = new QName("urn:schemas-microsoft-com:vml", "ext");

    public CTShapeLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public CTIdMap addNewIdmap() {
        CTIdMap cTIdMap;
        synchronized (monitor()) {
            check_orphaned();
            cTIdMap = (CTIdMap) get_store().add_element_user(IDMAP$0);
        }
        return cTIdMap;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public CTRegroupTable addNewRegrouptable() {
        CTRegroupTable add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(REGROUPTABLE$2);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public CTRules addNewRules() {
        CTRules add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RULES$4);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public STExt.Enum getExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EXT$6);
            if (simpleValue == null) {
                return null;
            }
            return (STExt.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public CTIdMap getIdmap() {
        synchronized (monitor()) {
            check_orphaned();
            CTIdMap cTIdMap = (CTIdMap) get_store().find_element_user(IDMAP$0, 0);
            if (cTIdMap == null) {
                return null;
            }
            return cTIdMap;
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public CTRegroupTable getRegrouptable() {
        synchronized (monitor()) {
            check_orphaned();
            CTRegroupTable find_element_user = get_store().find_element_user(REGROUPTABLE$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public CTRules getRules() {
        synchronized (monitor()) {
            check_orphaned();
            CTRules find_element_user = get_store().find_element_user(RULES$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXT$6) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public boolean isSetIdmap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IDMAP$0) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public boolean isSetRegrouptable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(REGROUPTABLE$2) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public boolean isSetRules() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RULES$4) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void setExt(STExt.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void setIdmap(CTIdMap cTIdMap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDMAP$0;
            CTIdMap cTIdMap2 = (CTIdMap) typeStore.find_element_user(qName, 0);
            if (cTIdMap2 == null) {
                cTIdMap2 = (CTIdMap) get_store().add_element_user(qName);
            }
            cTIdMap2.set(cTIdMap);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void setRegrouptable(CTRegroupTable cTRegroupTable) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPTABLE$2;
            CTRegroupTable find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTRegroupTable) get_store().add_element_user(qName);
            }
            find_element_user.set(cTRegroupTable);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void setRules(CTRules cTRules) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RULES$4;
            CTRules find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTRules) get_store().add_element_user(qName);
            }
            find_element_user.set(cTRules);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXT$6);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void unsetIdmap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IDMAP$0, 0);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void unsetRegrouptable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REGROUPTABLE$2, 0);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void unsetRules() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RULES$4, 0);
        }
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public STExt xgetExt() {
        STExt sTExt;
        synchronized (monitor()) {
            check_orphaned();
            sTExt = (STExt) get_store().find_attribute_user(EXT$6);
        }
        return sTExt;
    }

    @Override // schemasMicrosoftComOfficeOffice.CTShapeLayout
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$6;
            STExt sTExt2 = (STExt) typeStore.find_attribute_user(qName);
            if (sTExt2 == null) {
                sTExt2 = (STExt) get_store().add_attribute_user(qName);
            }
            sTExt2.set(sTExt);
        }
    }
}
