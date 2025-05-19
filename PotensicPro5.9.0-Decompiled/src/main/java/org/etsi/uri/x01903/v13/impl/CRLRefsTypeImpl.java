package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLRefType;
import org.etsi.uri.x01903.v13.CRLRefsType;

/* loaded from: classes5.dex */
public class CRLRefsTypeImpl extends XmlComplexContentImpl implements CRLRefsType {
    private static final QName CRLREF$0 = new QName(SignatureFacet.XADES_132_NS, "CRLRef");

    public CRLRefsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType addNewCRLRef() {
        CRLRefType cRLRefType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefType = (CRLRefType) get_store().add_element_user(CRLREF$0);
        }
        return cRLRefType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType getCRLRefArray(int i) {
        CRLRefType cRLRefType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefType = (CRLRefType) get_store().find_element_user(CRLREF$0, i);
            if (cRLRefType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cRLRefType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType[] getCRLRefArray() {
        CRLRefType[] cRLRefTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CRLREF$0, arrayList);
            cRLRefTypeArr = new CRLRefType[arrayList.size()];
            arrayList.toArray(cRLRefTypeArr);
        }
        return cRLRefTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public List<CRLRefType> getCRLRefList() {
        1CRLRefList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CRLRefList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType insertNewCRLRef(int i) {
        CRLRefType cRLRefType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefType = (CRLRefType) get_store().insert_element_user(CRLREF$0, i);
        }
        return cRLRefType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public void removeCRLRef(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CRLREF$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public void setCRLRefArray(int i, CRLRefType cRLRefType) {
        synchronized (monitor()) {
            check_orphaned();
            CRLRefType cRLRefType2 = (CRLRefType) get_store().find_element_user(CRLREF$0, i);
            if (cRLRefType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cRLRefType2.set(cRLRefType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public void setCRLRefArray(CRLRefType[] cRLRefTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cRLRefTypeArr, CRLREF$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public int sizeOfCRLRefArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CRLREF$0);
        }
        return count_elements;
    }
}
