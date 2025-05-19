package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.AnyType;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;
import org.etsi.uri.x01903.v13.GenericTimeStampType;
import org.etsi.uri.x01903.v13.IncludeType;
import org.etsi.uri.x01903.v13.ReferenceInfoType;
import org.w3.x2000.x09.xmldsig.CanonicalizationMethodType;

/* loaded from: classes5.dex */
public class GenericTimeStampTypeImpl extends XmlComplexContentImpl implements GenericTimeStampType {
    private static final QName INCLUDE$0 = new QName(SignatureFacet.XADES_132_NS, "Include");
    private static final QName REFERENCEINFO$2 = new QName(SignatureFacet.XADES_132_NS, "ReferenceInfo");
    private static final QName CANONICALIZATIONMETHOD$4 = new QName(SignatureFacet.XML_DIGSIG_NS, "CanonicalizationMethod");
    private static final QName ENCAPSULATEDTIMESTAMP$6 = new QName(SignatureFacet.XADES_132_NS, "EncapsulatedTimeStamp");
    private static final QName XMLTIMESTAMP$8 = new QName(SignatureFacet.XADES_132_NS, "XMLTimeStamp");
    private static final QName ID$10 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);

    public GenericTimeStampTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public CanonicalizationMethodType addNewCanonicalizationMethod() {
        CanonicalizationMethodType canonicalizationMethodType;
        synchronized (monitor()) {
            check_orphaned();
            canonicalizationMethodType = (CanonicalizationMethodType) get_store().add_element_user(CANONICALIZATIONMETHOD$4);
        }
        return canonicalizationMethodType;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public EncapsulatedPKIDataType addNewEncapsulatedTimeStamp() {
        EncapsulatedPKIDataType encapsulatedPKIDataType;
        synchronized (monitor()) {
            check_orphaned();
            encapsulatedPKIDataType = (EncapsulatedPKIDataType) get_store().add_element_user(ENCAPSULATEDTIMESTAMP$6);
        }
        return encapsulatedPKIDataType;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public IncludeType addNewInclude() {
        IncludeType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(INCLUDE$0);
        }
        return add_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public ReferenceInfoType addNewReferenceInfo() {
        ReferenceInfoType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(REFERENCEINFO$2);
        }
        return add_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public AnyType addNewXMLTimeStamp() {
        AnyType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(XMLTIMESTAMP$8);
        }
        return add_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public CanonicalizationMethodType getCanonicalizationMethod() {
        synchronized (monitor()) {
            check_orphaned();
            CanonicalizationMethodType canonicalizationMethodType = (CanonicalizationMethodType) get_store().find_element_user(CANONICALIZATIONMETHOD$4, 0);
            if (canonicalizationMethodType == null) {
                return null;
            }
            return canonicalizationMethodType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public EncapsulatedPKIDataType getEncapsulatedTimeStampArray(int i) {
        EncapsulatedPKIDataType encapsulatedPKIDataType;
        synchronized (monitor()) {
            check_orphaned();
            encapsulatedPKIDataType = (EncapsulatedPKIDataType) get_store().find_element_user(ENCAPSULATEDTIMESTAMP$6, i);
            if (encapsulatedPKIDataType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return encapsulatedPKIDataType;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public EncapsulatedPKIDataType[] getEncapsulatedTimeStampArray() {
        EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENCAPSULATEDTIMESTAMP$6, arrayList);
            encapsulatedPKIDataTypeArr = new EncapsulatedPKIDataType[arrayList.size()];
            arrayList.toArray(encapsulatedPKIDataTypeArr);
        }
        return encapsulatedPKIDataTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public List<EncapsulatedPKIDataType> getEncapsulatedTimeStampList() {
        1EncapsulatedTimeStampList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EncapsulatedTimeStampList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public IncludeType getIncludeArray(int i) {
        IncludeType find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(INCLUDE$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public IncludeType[] getIncludeArray() {
        IncludeType[] includeTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INCLUDE$0, arrayList);
            includeTypeArr = new IncludeType[arrayList.size()];
            arrayList.toArray(includeTypeArr);
        }
        return includeTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public List<IncludeType> getIncludeList() {
        1IncludeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IncludeList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public ReferenceInfoType getReferenceInfoArray(int i) {
        ReferenceInfoType find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(REFERENCEINFO$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public ReferenceInfoType[] getReferenceInfoArray() {
        ReferenceInfoType[] referenceInfoTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REFERENCEINFO$2, arrayList);
            referenceInfoTypeArr = new ReferenceInfoType[arrayList.size()];
            arrayList.toArray(referenceInfoTypeArr);
        }
        return referenceInfoTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public List<ReferenceInfoType> getReferenceInfoList() {
        1ReferenceInfoList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ReferenceInfoList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public AnyType getXMLTimeStampArray(int i) {
        AnyType find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(XMLTIMESTAMP$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public AnyType[] getXMLTimeStampArray() {
        AnyType[] anyTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XMLTIMESTAMP$8, arrayList);
            anyTypeArr = new AnyType[arrayList.size()];
            arrayList.toArray(anyTypeArr);
        }
        return anyTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public List<AnyType> getXMLTimeStampList() {
        1XMLTimeStampList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1XMLTimeStampList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public EncapsulatedPKIDataType insertNewEncapsulatedTimeStamp(int i) {
        EncapsulatedPKIDataType encapsulatedPKIDataType;
        synchronized (monitor()) {
            check_orphaned();
            encapsulatedPKIDataType = (EncapsulatedPKIDataType) get_store().insert_element_user(ENCAPSULATEDTIMESTAMP$6, i);
        }
        return encapsulatedPKIDataType;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public IncludeType insertNewInclude(int i) {
        IncludeType insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(INCLUDE$0, i);
        }
        return insert_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public ReferenceInfoType insertNewReferenceInfo(int i) {
        ReferenceInfoType insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(REFERENCEINFO$2, i);
        }
        return insert_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public AnyType insertNewXMLTimeStamp(int i) {
        AnyType insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(XMLTIMESTAMP$8, i);
        }
        return insert_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public boolean isSetCanonicalizationMethod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CANONICALIZATIONMETHOD$4) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$10) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void removeEncapsulatedTimeStamp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENCAPSULATEDTIMESTAMP$6, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void removeInclude(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INCLUDE$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void removeReferenceInfo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REFERENCEINFO$2, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void removeXMLTimeStamp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XMLTIMESTAMP$8, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CANONICALIZATIONMETHOD$4;
            CanonicalizationMethodType canonicalizationMethodType2 = (CanonicalizationMethodType) typeStore.find_element_user(qName, 0);
            if (canonicalizationMethodType2 == null) {
                canonicalizationMethodType2 = (CanonicalizationMethodType) get_store().add_element_user(qName);
            }
            canonicalizationMethodType2.set(canonicalizationMethodType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setEncapsulatedTimeStampArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType) {
        synchronized (monitor()) {
            check_orphaned();
            EncapsulatedPKIDataType encapsulatedPKIDataType2 = (EncapsulatedPKIDataType) get_store().find_element_user(ENCAPSULATEDTIMESTAMP$6, i);
            if (encapsulatedPKIDataType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            encapsulatedPKIDataType2.set(encapsulatedPKIDataType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setEncapsulatedTimeStampArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(encapsulatedPKIDataTypeArr, ENCAPSULATEDTIMESTAMP$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setIncludeArray(int i, IncludeType includeType) {
        synchronized (monitor()) {
            check_orphaned();
            IncludeType find_element_user = get_store().find_element_user(INCLUDE$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(includeType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setIncludeArray(IncludeType[] includeTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) includeTypeArr, INCLUDE$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setReferenceInfoArray(int i, ReferenceInfoType referenceInfoType) {
        synchronized (monitor()) {
            check_orphaned();
            ReferenceInfoType find_element_user = get_store().find_element_user(REFERENCEINFO$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(referenceInfoType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setReferenceInfoArray(ReferenceInfoType[] referenceInfoTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) referenceInfoTypeArr, REFERENCEINFO$2);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setXMLTimeStampArray(int i, AnyType anyType) {
        synchronized (monitor()) {
            check_orphaned();
            AnyType find_element_user = get_store().find_element_user(XMLTIMESTAMP$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(anyType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void setXMLTimeStampArray(AnyType[] anyTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) anyTypeArr, XMLTIMESTAMP$8);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public int sizeOfEncapsulatedTimeStampArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ENCAPSULATEDTIMESTAMP$6);
        }
        return count_elements;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public int sizeOfIncludeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INCLUDE$0);
        }
        return count_elements;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public int sizeOfReferenceInfoArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(REFERENCEINFO$2);
        }
        return count_elements;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public int sizeOfXMLTimeStampArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(XMLTIMESTAMP$8);
        }
        return count_elements;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void unsetCanonicalizationMethod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CANONICALIZATIONMETHOD$4, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$10);
        }
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$10);
        }
        return xmlID;
    }

    @Override // org.etsi.uri.x01903.v13.GenericTimeStampType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$10;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }
}
