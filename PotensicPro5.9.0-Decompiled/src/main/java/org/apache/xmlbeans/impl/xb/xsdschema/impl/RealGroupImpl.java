package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RealGroup;

/* loaded from: classes5.dex */
public class RealGroupImpl extends GroupImpl implements RealGroup {
    private static final QName ALL$0 = new QName("http://www.w3.org/2001/XMLSchema", TtmlNode.COMBINE_ALL);
    private static final QName CHOICE$2 = new QName("http://www.w3.org/2001/XMLSchema", "choice");
    private static final QName SEQUENCE$4 = new QName("http://www.w3.org/2001/XMLSchema", "sequence");

    public RealGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All[] getAllArray() {
        All[] allArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALL$0, arrayList);
            allArr = new All[arrayList.size()];
            arrayList.toArray(allArr);
        }
        return allArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All getAllArray(int i) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(ALL$0, i);
            if (all == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAllArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALL$0);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(All[] allArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(allArr, ALL$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(int i, All all) {
        synchronized (monitor()) {
            check_orphaned();
            All all2 = (All) get_store().find_element_user(ALL$0, i);
            if (all2 == null) {
                throw new IndexOutOfBoundsException();
            }
            all2.set(all);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All insertNewAll(int i) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().insert_element_user(ALL$0, i);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$0);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAll(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$0, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getChoiceArray() {
        ExplicitGroup[] explicitGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHOICE$2, arrayList);
            explicitGroupArr = new ExplicitGroup[arrayList.size()];
            arrayList.toArray(explicitGroupArr);
        }
        return explicitGroupArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getChoiceArray(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$2, i);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfChoiceArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CHOICE$2);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(ExplicitGroup[] explicitGroupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(explicitGroupArr, CHOICE$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(int i, ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup2 = (ExplicitGroup) get_store().find_element_user(CHOICE$2, i);
            if (explicitGroup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewChoice(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(CHOICE$2, i);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$2);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeChoice(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$2, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getSequenceArray() {
        ExplicitGroup[] explicitGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEQUENCE$4, arrayList);
            explicitGroupArr = new ExplicitGroup[arrayList.size()];
            arrayList.toArray(explicitGroupArr);
        }
        return explicitGroupArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getSequenceArray(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$4, i);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfSequenceArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SEQUENCE$4);
        }
        return count_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(ExplicitGroup[] explicitGroupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(explicitGroupArr, SEQUENCE$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(int i, ExplicitGroup explicitGroup) {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup2 = (ExplicitGroup) get_store().find_element_user(SEQUENCE$4, i);
            if (explicitGroup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            explicitGroup2.set(explicitGroup);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewSequence(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(SEQUENCE$4, i);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$4);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeSequence(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$4, i);
        }
    }
}
