package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComVml.CTF;
import schemasMicrosoftComVml.CTFormulas;

/* loaded from: classes6.dex */
public class CTFormulasImpl extends XmlComplexContentImpl implements CTFormulas {
    private static final QName F$0 = new QName("urn:schemas-microsoft-com:vml", "f");

    public CTFormulasImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public CTF addNewF() {
        CTF ctf;
        synchronized (monitor()) {
            check_orphaned();
            ctf = (CTF) get_store().add_element_user(F$0);
        }
        return ctf;
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public CTF getFArray(int i) {
        CTF ctf;
        synchronized (monitor()) {
            check_orphaned();
            ctf = (CTF) get_store().find_element_user(F$0, i);
            if (ctf == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctf;
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public CTF[] getFArray() {
        CTF[] ctfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(F$0, arrayList);
            ctfArr = new CTF[arrayList.size()];
            arrayList.toArray(ctfArr);
        }
        return ctfArr;
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public List<CTF> getFList() {
        1FList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public CTF insertNewF(int i) {
        CTF ctf;
        synchronized (monitor()) {
            check_orphaned();
            ctf = (CTF) get_store().insert_element_user(F$0, i);
        }
        return ctf;
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public void removeF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(F$0, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public void setFArray(int i, CTF ctf) {
        synchronized (monitor()) {
            check_orphaned();
            CTF ctf2 = (CTF) get_store().find_element_user(F$0, i);
            if (ctf2 == null) {
                throw new IndexOutOfBoundsException();
            }
            ctf2.set(ctf);
        }
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public void setFArray(CTF[] ctfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctfArr, F$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTFormulas
    public int sizeOfFArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(F$0);
        }
        return count_elements;
    }
}
