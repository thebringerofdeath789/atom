package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* loaded from: classes6.dex */
public class CTREltImpl extends XmlComplexContentImpl implements CTRElt {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rPr");
    private static final QName T$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "t");

    public CTREltImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public CTRPrElt addNewRPr() {
        CTRPrElt cTRPrElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrElt = (CTRPrElt) get_store().add_element_user(RPR$0);
        }
        return cTRPrElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public CTRPrElt getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPrElt cTRPrElt = (CTRPrElt) get_store().find_element_user(RPR$0, 0);
            if (cTRPrElt == null) {
                return null;
            }
            return cTRPrElt;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public String getT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(T$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public void setRPr(CTRPrElt cTRPrElt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$0;
            CTRPrElt cTRPrElt2 = (CTRPrElt) typeStore.find_element_user(qName, 0);
            if (cTRPrElt2 == null) {
                cTRPrElt2 = (CTRPrElt) get_store().add_element_user(qName);
            }
            cTRPrElt2.set(cTRPrElt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public void setT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public STXstring xgetT() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(T$2, 0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt
    public void xsetT(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$2;
            STXstring sTXstring2 = (STXstring) typeStore.find_element_user(qName, 0);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_element_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }
}
