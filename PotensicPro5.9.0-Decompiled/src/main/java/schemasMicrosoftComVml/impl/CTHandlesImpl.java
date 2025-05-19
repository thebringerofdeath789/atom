package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComVml.CTH;
import schemasMicrosoftComVml.CTHandles;

/* loaded from: classes6.dex */
public class CTHandlesImpl extends XmlComplexContentImpl implements CTHandles {
    private static final QName H$0 = new QName("urn:schemas-microsoft-com:vml", "h");

    public CTHandlesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public CTH addNewH() {
        CTH cth;
        synchronized (monitor()) {
            check_orphaned();
            cth = (CTH) get_store().add_element_user(H$0);
        }
        return cth;
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public CTH getHArray(int i) {
        CTH cth;
        synchronized (monitor()) {
            check_orphaned();
            cth = (CTH) get_store().find_element_user(H$0, i);
            if (cth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cth;
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public CTH[] getHArray() {
        CTH[] cthArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(H$0, arrayList);
            cthArr = new CTH[arrayList.size()];
            arrayList.toArray(cthArr);
        }
        return cthArr;
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public List<CTH> getHList() {
        1HList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public CTH insertNewH(int i) {
        CTH cth;
        synchronized (monitor()) {
            check_orphaned();
            cth = (CTH) get_store().insert_element_user(H$0, i);
        }
        return cth;
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public void removeH(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(H$0, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public void setHArray(int i, CTH cth) {
        synchronized (monitor()) {
            check_orphaned();
            CTH cth2 = (CTH) get_store().find_element_user(H$0, i);
            if (cth2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cth2.set(cth);
        }
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public void setHArray(CTH[] cthArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cthArr, H$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTHandles
    public int sizeOfHArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(H$0);
        }
        return count_elements;
    }
}
