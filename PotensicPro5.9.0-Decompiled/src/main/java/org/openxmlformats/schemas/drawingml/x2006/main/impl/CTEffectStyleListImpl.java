package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList;

/* loaded from: classes5.dex */
public class CTEffectStyleListImpl extends XmlComplexContentImpl implements CTEffectStyleList {
    private static final QName EFFECTSTYLE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectStyle");

    public CTEffectStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem addNewEffectStyle() {
        CTEffectStyleItem cTEffectStyleItem;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleItem = (CTEffectStyleItem) get_store().add_element_user(EFFECTSTYLE$0);
        }
        return cTEffectStyleItem;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem getEffectStyleArray(int i) {
        CTEffectStyleItem cTEffectStyleItem;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleItem = (CTEffectStyleItem) get_store().find_element_user(EFFECTSTYLE$0, i);
            if (cTEffectStyleItem == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEffectStyleItem;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem[] getEffectStyleArray() {
        CTEffectStyleItem[] cTEffectStyleItemArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EFFECTSTYLE$0, arrayList);
            cTEffectStyleItemArr = new CTEffectStyleItem[arrayList.size()];
            arrayList.toArray(cTEffectStyleItemArr);
        }
        return cTEffectStyleItemArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public List<CTEffectStyleItem> getEffectStyleList() {
        1EffectStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EffectStyleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem insertNewEffectStyle(int i) {
        CTEffectStyleItem cTEffectStyleItem;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleItem = (CTEffectStyleItem) get_store().insert_element_user(EFFECTSTYLE$0, i);
        }
        return cTEffectStyleItem;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public void removeEffectStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTSTYLE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public void setEffectStyleArray(int i, CTEffectStyleItem cTEffectStyleItem) {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectStyleItem cTEffectStyleItem2 = (CTEffectStyleItem) get_store().find_element_user(EFFECTSTYLE$0, i);
            if (cTEffectStyleItem2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTEffectStyleItem2.set(cTEffectStyleItem);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public void setEffectStyleArray(CTEffectStyleItem[] cTEffectStyleItemArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEffectStyleItemArr, EFFECTSTYLE$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public int sizeOfEffectStyleArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EFFECTSTYLE$0);
        }
        return count_elements;
    }
}
