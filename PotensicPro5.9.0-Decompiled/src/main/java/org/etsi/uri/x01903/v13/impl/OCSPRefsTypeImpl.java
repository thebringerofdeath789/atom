package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.OCSPRefType;
import org.etsi.uri.x01903.v13.OCSPRefsType;

/* loaded from: classes5.dex */
public class OCSPRefsTypeImpl extends XmlComplexContentImpl implements OCSPRefsType {
    private static final QName OCSPREF$0 = new QName(SignatureFacet.XADES_132_NS, "OCSPRef");

    public OCSPRefsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public OCSPRefType addNewOCSPRef() {
        OCSPRefType oCSPRefType;
        synchronized (monitor()) {
            check_orphaned();
            oCSPRefType = (OCSPRefType) get_store().add_element_user(OCSPREF$0);
        }
        return oCSPRefType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public OCSPRefType getOCSPRefArray(int i) {
        OCSPRefType oCSPRefType;
        synchronized (monitor()) {
            check_orphaned();
            oCSPRefType = (OCSPRefType) get_store().find_element_user(OCSPREF$0, i);
            if (oCSPRefType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return oCSPRefType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public OCSPRefType[] getOCSPRefArray() {
        OCSPRefType[] oCSPRefTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OCSPREF$0, arrayList);
            oCSPRefTypeArr = new OCSPRefType[arrayList.size()];
            arrayList.toArray(oCSPRefTypeArr);
        }
        return oCSPRefTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public List<OCSPRefType> getOCSPRefList() {
        1OCSPRefList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OCSPRefList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public OCSPRefType insertNewOCSPRef(int i) {
        OCSPRefType oCSPRefType;
        synchronized (monitor()) {
            check_orphaned();
            oCSPRefType = (OCSPRefType) get_store().insert_element_user(OCSPREF$0, i);
        }
        return oCSPRefType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public void removeOCSPRef(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OCSPREF$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public void setOCSPRefArray(int i, OCSPRefType oCSPRefType) {
        synchronized (monitor()) {
            check_orphaned();
            OCSPRefType oCSPRefType2 = (OCSPRefType) get_store().find_element_user(OCSPREF$0, i);
            if (oCSPRefType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            oCSPRefType2.set(oCSPRefType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public void setOCSPRefArray(OCSPRefType[] oCSPRefTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(oCSPRefTypeArr, OCSPREF$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefsType
    public int sizeOfOCSPRefArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OCSPREF$0);
        }
        return count_elements;
    }
}
