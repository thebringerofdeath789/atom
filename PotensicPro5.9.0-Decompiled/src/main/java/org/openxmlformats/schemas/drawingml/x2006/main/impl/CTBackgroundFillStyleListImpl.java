package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;

/* loaded from: classes5.dex */
public class CTBackgroundFillStyleListImpl extends XmlComplexContentImpl implements CTBackgroundFillStyleList {
    private static final QName NOFILL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
    private static final QName SOLIDFILL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
    private static final QName GRADFILL$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
    private static final QName BLIPFILL$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
    private static final QName PATTFILL$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
    private static final QName GRPFILL$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");

    public CTBackgroundFillStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$6);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(GRADFILL$4);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(GRPFILL$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$0);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PATTFILL$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$2);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties getBlipFillArray(int i) {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$6, i);
            if (cTBlipFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties[] getBlipFillArray() {
        CTBlipFillProperties[] cTBlipFillPropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BLIPFILL$6, arrayList);
            cTBlipFillPropertiesArr = new CTBlipFillProperties[arrayList.size()];
            arrayList.toArray(cTBlipFillPropertiesArr);
        }
        return cTBlipFillPropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTBlipFillProperties> getBlipFillList() {
        1BlipFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BlipFillList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties getGradFillArray(int i) {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(GRADFILL$4, i);
            if (cTGradientFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties[] getGradFillArray() {
        CTGradientFillProperties[] cTGradientFillPropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRADFILL$4, arrayList);
            cTGradientFillPropertiesArr = new CTGradientFillProperties[arrayList.size()];
            arrayList.toArray(cTGradientFillPropertiesArr);
        }
        return cTGradientFillPropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTGradientFillProperties> getGradFillList() {
        1GradFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GradFillList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties getGrpFillArray(int i) {
        CTGroupFillProperties find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(GRPFILL$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties[] getGrpFillArray() {
        CTGroupFillProperties[] cTGroupFillPropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRPFILL$10, arrayList);
            cTGroupFillPropertiesArr = new CTGroupFillProperties[arrayList.size()];
            arrayList.toArray(cTGroupFillPropertiesArr);
        }
        return cTGroupFillPropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTGroupFillProperties> getGrpFillList() {
        1GrpFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GrpFillList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties getNoFillArray(int i) {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$0, i);
            if (cTNoFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties[] getNoFillArray() {
        CTNoFillProperties[] cTNoFillPropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NOFILL$0, arrayList);
            cTNoFillPropertiesArr = new CTNoFillProperties[arrayList.size()];
            arrayList.toArray(cTNoFillPropertiesArr);
        }
        return cTNoFillPropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTNoFillProperties> getNoFillList() {
        1NoFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NoFillList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties getPattFillArray(int i) {
        CTPatternFillProperties find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PATTFILL$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties[] getPattFillArray() {
        CTPatternFillProperties[] cTPatternFillPropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PATTFILL$8, arrayList);
            cTPatternFillPropertiesArr = new CTPatternFillProperties[arrayList.size()];
            arrayList.toArray(cTPatternFillPropertiesArr);
        }
        return cTPatternFillPropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTPatternFillProperties> getPattFillList() {
        1PattFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PattFillList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties getSolidFillArray(int i) {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$2, i);
            if (cTSolidColorFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties[] getSolidFillArray() {
        CTSolidColorFillProperties[] cTSolidColorFillPropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SOLIDFILL$2, arrayList);
            cTSolidColorFillPropertiesArr = new CTSolidColorFillProperties[arrayList.size()];
            arrayList.toArray(cTSolidColorFillPropertiesArr);
        }
        return cTSolidColorFillPropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTSolidColorFillProperties> getSolidFillList() {
        1SolidFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SolidFillList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties insertNewBlipFill(int i) {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().insert_element_user(BLIPFILL$6, i);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties insertNewGradFill(int i) {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().insert_element_user(GRADFILL$4, i);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties insertNewGrpFill(int i) {
        CTGroupFillProperties insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(GRPFILL$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties insertNewNoFill(int i) {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().insert_element_user(NOFILL$0, i);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties insertNewPattFill(int i) {
        CTPatternFillProperties insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PATTFILL$8, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties insertNewSolidFill(int i) {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().insert_element_user(SOLIDFILL$2, i);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeBlipFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeGradFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeGrpFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeNoFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removePattFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeSolidFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setBlipFillArray(int i, CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$6, i);
            if (cTBlipFillProperties2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBlipFillProperties2.set(cTBlipFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setBlipFillArray(CTBlipFillProperties[] cTBlipFillPropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBlipFillPropertiesArr, BLIPFILL$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGradFillArray(int i, CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientFillProperties cTGradientFillProperties2 = (CTGradientFillProperties) get_store().find_element_user(GRADFILL$4, i);
            if (cTGradientFillProperties2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGradientFillProperties2.set(cTGradientFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGradFillArray(CTGradientFillProperties[] cTGradientFillPropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGradientFillPropertiesArr, GRADFILL$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGrpFillArray(int i, CTGroupFillProperties cTGroupFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupFillProperties find_element_user = get_store().find_element_user(GRPFILL$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTGroupFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGrpFillArray(CTGroupFillProperties[] cTGroupFillPropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGroupFillPropertiesArr, GRPFILL$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setNoFillArray(int i, CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTNoFillProperties cTNoFillProperties2 = (CTNoFillProperties) get_store().find_element_user(NOFILL$0, i);
            if (cTNoFillProperties2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNoFillProperties2.set(cTNoFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setNoFillArray(CTNoFillProperties[] cTNoFillPropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNoFillPropertiesArr, NOFILL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setPattFillArray(int i, CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTPatternFillProperties find_element_user = get_store().find_element_user(PATTFILL$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPatternFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setPattFillArray(CTPatternFillProperties[] cTPatternFillPropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPatternFillPropertiesArr, PATTFILL$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setSolidFillArray(int i, CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTSolidColorFillProperties cTSolidColorFillProperties2 = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$2, i);
            if (cTSolidColorFillProperties2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSolidColorFillProperties2.set(cTSolidColorFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setSolidFillArray(CTSolidColorFillProperties[] cTSolidColorFillPropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSolidColorFillPropertiesArr, SOLIDFILL$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfBlipFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BLIPFILL$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfGradFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GRADFILL$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfGrpFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GRPFILL$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfNoFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NOFILL$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfPattFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PATTFILL$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfSolidFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SOLIDFILL$2);
        }
        return count_elements;
    }
}
